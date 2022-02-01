package com.tencent.weiyun.transmission.upload.processor;

import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatisticsTimes;
import com.tencent.weiyun.transmission.upload.UploadType;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class UrlFetcher
  implements Handler.Callback
{
  private static final int MSG_FETCH = 21;
  private static final String TAG = "UploadUrlFetcher";
  private final UrlFetcher.UrlFetcherCallback mCallback;
  private final ReleaseLooperHandler mHandler;
  
  public UrlFetcher(UrlFetcher.UrlFetcherCallback paramUrlFetcherCallback, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.mCallback = paramUrlFetcherCallback;
    this.mHandler = paramReleaseLooperHandler;
    this.mHandler.addCallback(this);
  }
  
  private void performFetchUrl(UploadJobContext paramUploadJobContext, int paramInt)
  {
    if (paramUploadJobContext == null) {}
    long l;
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
      localHostInterface.fetchUploadServerInfo(localUploadFile, paramUploadJobContext, new UrlFetcher.1(this, l));
      return;
    }
  }
  
  public void cancelAll()
  {
    this.mHandler.removeMessages(21);
  }
  
  public void fetchUrl(UploadJobContext paramUploadJobContext, int paramInt)
  {
    if (paramUploadJobContext == null) {
      return;
    }
    this.mHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, paramUploadJobContext));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      performFetchUrl((UploadJobContext)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.processor.UrlFetcher
 * JD-Core Version:    0.7.0.1
 */