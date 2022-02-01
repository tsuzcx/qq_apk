package com.tencent.mobileqq.emoticonview;

import com.tencent.image.URLDrawableHandler.Adapter;
import com.tencent.qphone.base.util.QLog;

class AIOPopOutEmoticonConfig$1$1
  extends URLDrawableHandler.Adapter
{
  AIOPopOutEmoticonConfig$1$1(AIOPopOutEmoticonConfig.1 param1) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFileDownloadFailed, errorCode:");
    localStringBuilder.append(paramInt);
    QLog.i("AIOPopOutEmoticonConfig", 1, localStringBuilder.toString());
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.this$1.this$0.apngSoLoaded = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFileDownloadSucceed, fileSize:");
    localStringBuilder.append(paramLong);
    QLog.i("AIOPopOutEmoticonConfig", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AIOPopOutEmoticonConfig.1.1
 * JD-Core Version:    0.7.0.1
 */