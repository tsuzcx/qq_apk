package com.tencent.weiyun.transmission.upload.processor;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.UploadServerInfoCallback;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatisticsTimes;
import com.tencent.weiyun.transmission.upload.UploadType;

public class UrlFetcher
  implements Handler.Callback
{
  private static final int MSG_FETCH = 1;
  private static final String TAG = "UploadUrlFetcher";
  private final UrlFetcherCallback mCallback;
  private final Handler mHandler;
  
  public UrlFetcher(UrlFetcherCallback paramUrlFetcherCallback)
  {
    this.mCallback = paramUrlFetcherCallback;
    paramUrlFetcherCallback = new HandlerThread("upload-url-fetcher");
    paramUrlFetcherCallback.start();
    this.mHandler = new Handler(paramUrlFetcherCallback.getLooper(), this);
  }
  
  private void performFetchUrl(UploadJobContext paramUploadJobContext, int paramInt)
  {
    if (paramUploadJobContext == null) {}
    final long l;
    do
    {
      return;
      l = paramUploadJobContext.dbId();
    } while (paramUploadJobContext.isCanceled());
    paramUploadJobContext.statisticsTimes().onFetchUrlStart();
    WeiyunTransmissionGlobal.HostInterface localHostInterface = WeiyunTransmissionGlobal.getInstance().getHostInterface();
    UploadFile localUploadFile = paramUploadJobContext.file().clone();
    if (!TextUtils.isEmpty(paramUploadJobContext.file().compressedPath)) {}
    for (paramUploadJobContext = UploadType.EXIST_COVER;; paramUploadJobContext = UploadType.values()[paramInt])
    {
      localHostInterface.fetchUploadServerInfo(localUploadFile, paramUploadJobContext, new WeiyunTransmissionGlobal.UploadServerInfoCallback()
      {
        public void onResult(UploadFile paramAnonymousUploadFile, boolean paramAnonymousBoolean, int paramAnonymousInt, String paramAnonymousString)
        {
          if (paramAnonymousUploadFile == null) {
            return;
          }
          if (paramAnonymousBoolean)
          {
            if (paramAnonymousUploadFile.serverInfo == null)
            {
              UrlFetcher.this.mCallback.onFetchError(l, 1810024, "");
              return;
            }
            UrlFetcher.this.mCallback.onFetchSuccess(l, paramAnonymousUploadFile);
            return;
          }
          UrlFetcher.this.mCallback.onFetchError(l, paramAnonymousInt, paramAnonymousString);
        }
      });
      return;
    }
  }
  
  public void cancelAll()
  {
    this.mHandler.removeMessages(1);
  }
  
  public void fetchUrl(UploadJobContext paramUploadJobContext, int paramInt)
  {
    if (paramUploadJobContext == null) {
      return;
    }
    Message.obtain(this.mHandler, 1, paramInt, 0, paramUploadJobContext).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      performFetchUrl((UploadJobContext)paramMessage.obj, paramMessage.arg1);
    }
    return true;
  }
  
  public static abstract interface UrlFetcherCallback
  {
    public abstract void onFetchError(long paramLong, int paramInt, String paramString);
    
    public abstract void onFetchSuccess(long paramLong, UploadFile paramUploadFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.processor.UrlFetcher
 * JD-Core Version:    0.7.0.1
 */