package com.tencent.weiyun.transmission.upload.uploader;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
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
  private static final int MSG_MISSING_UPLOAD = 32;
  private static final int MSG_SECOND_UPLOAD = 31;
  private static final long SMALL_FILE_THRESHOLD = 1048576L;
  private static final long SMALL_MIN_SPLIT_SIZE = 65536L;
  private static final String TAG = "UploaderAgent";
  private final Context mContext;
  private final ReleaseLooperHandler mHandler;
  private IUploader mUploaderInner;
  
  public UploaderAgent(Context paramContext, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    Uploader.init(new UploaderConfig(), new UploaderLog());
    this.mContext = paramContext;
    initDefaultUploader();
    this.mHandler = paramReleaseLooperHandler;
    this.mHandler.addCallback(this);
  }
  
  private void initDefaultUploader()
  {
    if (UploadNative.getInstance().isLoaded()) {
      this.mUploaderInner = new Uploader(this.mContext, "common_uploader", null);
    }
  }
  
  public String[] calSliceSha1(String paramString, UploadNative.CanceledFlag paramCanceledFlag)
  {
    IUploader localIUploader = this.mUploaderInner;
    if (localIUploader == null) {
      return null;
    }
    return localIUploader.calSliceSha1(paramString, paramCanceledFlag);
  }
  
  public boolean cancel(UploadRequest paramUploadRequest)
  {
    IUploader localIUploader = this.mUploaderInner;
    if (localIUploader == null) {
      return false;
    }
    localIUploader.cancel(paramUploadRequest);
    return true;
  }
  
  public void cancelAll()
  {
    IUploader localIUploader = this.mUploaderInner;
    if (localIUploader == null) {
      return;
    }
    localIUploader.cancelAll();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 31)
    {
      paramMessage = (UploadRequest)paramMessage.obj;
      if (paramMessage == null) {
        return true;
      }
      ((HashMap)paramMessage.businessData()).put("second_upload", Boolean.toString(true));
      long l4 = paramMessage.size();
      if (paramMessage.listener() != null)
      {
        long l1;
        if (l4 < 1048576L) {
          l1 = 65536L;
        } else {
          l1 = 655360L;
        }
        long l2 = l4 / 100L;
        if (l1 <= l2) {
          l1 = l2;
        }
        long l5 = SystemClock.elapsedRealtime();
        l2 = l4;
        for (;;)
        {
          if (l2 > 0L)
          {
            if (l2 < l1) {
              l3 = l2;
            } else {
              l3 = l1;
            }
            long l3 = l2 - l3;
            long l6 = l4 - l3;
            l2 = SystemClock.elapsedRealtime() - l5;
            if ((l6 > 0L) && (l2 > 0L)) {
              l2 = ((float)l6 / 1024.0F / ((float)l2 / 1000.0F));
            } else {
              l2 = 0L;
            }
            IUploader.IUploadListener localIUploadListener = paramMessage.listener();
            float f;
            if (l4 == 0L) {
              f = 1.0F;
            } else {
              f = (float)l6 / (float)l4;
            }
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
      return true;
    }
    if (paramMessage.what == 32)
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
      return true;
    }
    return false;
  }
  
  public void loadLibFromPath(String paramString)
  {
    if ((!UploadNative.getInstance().isLoaded()) && (!TextUtils.isEmpty(paramString)) && (UploadNative.getInstance().loadLibFromPath(paramString))) {
      initDefaultUploader();
    }
  }
  
  public void saveDirectIpFromWns(Map<String, Map<String, Object>> paramMap)
  {
    if (this.mUploaderInner == null) {
      return;
    }
    if (paramMap != null)
    {
      Object localObject = (Map)paramMap.get("PhotoSvrList");
      if (localObject != null)
      {
        paramMap = (String)((Map)localObject).get("OptimumIP_WY_HTTP_Upload");
        localObject = (String)((Map)localObject).get("BackupIP_WY_HTTP_Upload");
        if ((!TextUtils.isEmpty(paramMap)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          this.mUploaderInner.setIpConfig(paramMap, (String)localObject);
        }
      }
    }
  }
  
  public void secondUpload(UploadRequest paramUploadRequest)
  {
    if (paramUploadRequest == null) {
      return;
    }
    this.mHandler.sendMessage(Message.obtain(null, 31, paramUploadRequest));
  }
  
  public void setHttpProxy(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    IUploader localIUploader = this.mUploaderInner;
    if (localIUploader == null) {
      return;
    }
    localIUploader.setHttpProxy(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void setNetType(int paramInt)
  {
    IUploader localIUploader = this.mUploaderInner;
    if (localIUploader == null) {
      return;
    }
    localIUploader.setNetType(paramInt);
  }
  
  public void setSpareUploader(IUploader paramIUploader)
  {
    if ((this.mUploaderInner == null) && (paramIUploader != null)) {
      this.mUploaderInner = paramIUploader;
    }
  }
  
  public void speedDown()
  {
    IUploader localIUploader = this.mUploaderInner;
    if (localIUploader == null) {
      return;
    }
    localIUploader.speedDown();
  }
  
  public void trialSpeedUp(int paramInt)
  {
    IUploader localIUploader = this.mUploaderInner;
    if (localIUploader == null) {
      return;
    }
    localIUploader.trialSpeedUp(paramInt);
  }
  
  public boolean upload(UploadRequest paramUploadRequest)
  {
    IUploader localIUploader = this.mUploaderInner;
    if (localIUploader == null)
    {
      if (paramUploadRequest != null) {
        this.mHandler.sendMessage(Message.obtain(null, 32, paramUploadRequest));
      }
      return false;
    }
    return localIUploader.upload(paramUploadRequest);
  }
  
  public void vipSpeedUp()
  {
    IUploader localIUploader = this.mUploaderInner;
    if (localIUploader == null) {
      return;
    }
    localIUploader.vipSpeedUp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.uploader.UploaderAgent
 * JD-Core Version:    0.7.0.1
 */