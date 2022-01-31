package com.tencent.weiyun.transmission.upload.uploader;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.uploader.IUploader;
import com.tencent.weiyun.uploader.IUploader.IUploadListener;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.uploader.UploadResponse;
import com.tencent.weiyun.uploader.UploadResponse.Builder;
import com.tencent.weiyun.uploader.Uploader;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import com.tencent.weiyun.uploader.xplatform.UploadNative.CanceledFlag;
import java.util.HashMap;
import java.util.Map;

public class UploaderAgent
  implements Handler.Callback
{
  private static final long LARGE_MIN_SPLIT_SIZE = 655360L;
  private static final long MAX_SPLIT_NUM = 100L;
  private static final int MSG_MISSING_UPLOAD = 2;
  private static final int MSG_SECOND_UPLOAD = 1;
  private static final long SMALL_FILE_THRESHOLD = 1048576L;
  private static final long SMALL_MIN_SPLIT_SIZE = 65536L;
  private static final String TAG = "UploaderAgent";
  private final Context mContext;
  private final Handler mHandler;
  private IUploader mUploaderInner;
  
  public UploaderAgent(Context paramContext)
  {
    Uploader.init(new UploaderConfig(), new UploaderLog());
    this.mContext = paramContext;
    initDefaultUploader();
    paramContext = new HandlerThread("upload-fake-transport");
    paramContext.start();
    this.mHandler = new Handler(paramContext.getLooper(), this);
  }
  
  private void initDefaultUploader()
  {
    if (UploadNative.getInstance().isLoaded()) {
      this.mUploaderInner = new Uploader(this.mContext, "common_uploader", null);
    }
  }
  
  public String[] calSliceSha1(String paramString, UploadNative.CanceledFlag paramCanceledFlag)
  {
    if (this.mUploaderInner == null) {
      return null;
    }
    return this.mUploaderInner.calSliceSha1(paramString, paramCanceledFlag);
  }
  
  public boolean cancel(UploadRequest paramUploadRequest)
  {
    if (this.mUploaderInner == null) {
      return false;
    }
    this.mUploaderInner.cancel(paramUploadRequest);
    return true;
  }
  
  public void cancelAll()
  {
    if (this.mUploaderInner == null) {
      return;
    }
    this.mUploaderInner.cancelAll();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l4;
    long l2;
    long l1;
    label80:
    long l3;
    label103:
    long l6;
    label155:
    float f;
    if (paramMessage.what == 1)
    {
      paramMessage = (UploadRequest)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      ((HashMap)paramMessage.businessData()).put("second_upload", Boolean.toString(true));
      l4 = paramMessage.size();
      if (paramMessage.listener() != null)
      {
        l2 = l4;
        if (l4 >= 1048576L) {
          break label221;
        }
        l1 = 65536L;
        if (l1 <= l2 / 100L) {
          break label228;
        }
        long l5 = SystemClock.elapsedRealtime();
        for (;;)
        {
          if (l2 > 0L)
          {
            if (l2 >= l1) {
              break label238;
            }
            l3 = l2;
            l3 = l2 - l3;
            l6 = l4 - l3;
            l2 = SystemClock.elapsedRealtime() - l5;
            if ((l6 <= 0L) || (l2 <= 0L)) {
              break label244;
            }
            l2 = ((float)l6 / 1024.0F / ((float)l2 / 1000.0F));
            IUploader.IUploadListener localIUploadListener = paramMessage.listener();
            if (l4 != 0L) {
              break label250;
            }
            f = 1.0F;
            label170:
            localIUploadListener.onUploadProgress(paramMessage, l4, f, l2, 0L, 0L);
            try
            {
              Thread.sleep(50L);
              l2 = l3;
            }
            catch (InterruptedException localInterruptedException)
            {
              TsLog.e("UploaderAgent", localInterruptedException);
            }
          }
        }
        paramMessage.listener().onUploadFinished(paramMessage, true, null);
      }
    }
    for (;;)
    {
      return true;
      label221:
      l1 = 655360L;
      break;
      label228:
      l1 = l2 / 100L;
      break label80;
      label238:
      l3 = l1;
      break label103;
      label244:
      l2 = 0L;
      break label155;
      label250:
      f = (float)l6 / (float)l4;
      break label170;
      if (paramMessage.what == 2)
      {
        paramMessage = (UploadRequest)paramMessage.obj;
        if (paramMessage == null) {
          return true;
        }
        if (paramMessage.listener() != null)
        {
          UploadResponse localUploadResponse = new UploadResponse.Builder().code(1810024).errMsg("Uploader missing..").request(paramMessage).build();
          paramMessage.listener().onUploadFinished(paramMessage, false, localUploadResponse);
        }
      }
    }
  }
  
  public void loadLibFromPath(String paramString)
  {
    if ((!UploadNative.getInstance().isLoaded()) && (!TextUtils.isEmpty(paramString)) && (UploadNative.getInstance().loadLibFromPath(paramString))) {
      initDefaultUploader();
    }
  }
  
  public void saveDirectIpFromWns(Map<String, Map<String, Object>> paramMap)
  {
    if (this.mUploaderInner == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramMap == null);
        localObject = (Map)paramMap.get("PhotoSvrList");
      } while (localObject == null);
      paramMap = (String)((Map)localObject).get("OptimumIP_WY_HTTP_Upload");
      localObject = (String)((Map)localObject).get("BackupIP_WY_HTTP_Upload");
    } while ((TextUtils.isEmpty(paramMap)) || (TextUtils.isEmpty((CharSequence)localObject)));
    this.mUploaderInner.setIpConfig(paramMap, (String)localObject);
  }
  
  public void secondUpload(UploadRequest paramUploadRequest)
  {
    if (paramUploadRequest == null) {
      return;
    }
    Message.obtain(this.mHandler, 1, paramUploadRequest).sendToTarget();
  }
  
  public void setHttpProxy(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (this.mUploaderInner == null) {
      return;
    }
    this.mUploaderInner.setHttpProxy(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void setNetType(int paramInt)
  {
    if (this.mUploaderInner == null) {
      return;
    }
    this.mUploaderInner.setNetType(paramInt);
  }
  
  public void setSpareUploader(IUploader paramIUploader)
  {
    if ((this.mUploaderInner == null) && (paramIUploader != null)) {
      this.mUploaderInner = paramIUploader;
    }
  }
  
  public void speedDown()
  {
    if (this.mUploaderInner == null) {
      return;
    }
    this.mUploaderInner.speedDown();
  }
  
  public void trialSpeedUp(int paramInt)
  {
    if (this.mUploaderInner == null) {
      return;
    }
    this.mUploaderInner.trialSpeedUp(paramInt);
  }
  
  public boolean upload(UploadRequest paramUploadRequest)
  {
    if (this.mUploaderInner == null)
    {
      if (paramUploadRequest != null) {
        Message.obtain(this.mHandler, 2, paramUploadRequest).sendToTarget();
      }
      return false;
    }
    return this.mUploaderInner.upload(paramUploadRequest);
  }
  
  public void vipSpeedUp()
  {
    if (this.mUploaderInner == null) {
      return;
    }
    this.mUploaderInner.vipSpeedUp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.uploader.UploaderAgent
 * JD-Core Version:    0.7.0.1
 */