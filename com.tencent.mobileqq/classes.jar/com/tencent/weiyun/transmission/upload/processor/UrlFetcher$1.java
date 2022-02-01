package com.tencent.weiyun.transmission.upload.processor;

import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.UploadServerInfoCallback;
import com.tencent.weiyun.transmission.upload.UploadFile;

class UrlFetcher$1
  implements WeiyunTransmissionGlobal.UploadServerInfoCallback
{
  UrlFetcher$1(UrlFetcher paramUrlFetcher, long paramLong) {}
  
  public void onResult(UploadFile paramUploadFile, boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramUploadFile == null) {
      return;
    }
    if (paramBoolean)
    {
      if (paramUploadFile.serverInfo == null)
      {
        UrlFetcher.access$000(this.this$0).onFetchError(this.val$dbId, 1810024, "");
        return;
      }
      UrlFetcher.access$000(this.this$0).onFetchSuccess(this.val$dbId, paramUploadFile);
      return;
    }
    UrlFetcher.access$000(this.this$0).onFetchError(this.val$dbId, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.processor.UrlFetcher.1
 * JD-Core Version:    0.7.0.1
 */