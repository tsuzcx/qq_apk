package com.tencent.qqmini.proxyimpl;

import com.tencent.plato.mqq.network.ProgressListener;
import com.tencent.qqmini.sdk.core.proxy.UploaderProxy.UploadListener;

final class HttpUtil$1
  implements ProgressListener
{
  HttpUtil$1(UploaderProxy.UploadListener paramUploadListener) {}
  
  public void onProgress(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.val$listener.onUploadProgress((int)(100.0D * paramLong1 / paramLong2), (int)paramLong1, (int)paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.HttpUtil.1
 * JD-Core Version:    0.7.0.1
 */