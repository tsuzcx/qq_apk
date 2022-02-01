package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.vas.aidl.IDownloadListener.Stub;

class QQLevelJsPlugin$1
  extends IDownloadListener.Stub
{
  QQLevelJsPlugin$1(QQLevelJsPlugin paramQQLevelJsPlugin, String paramString) {}
  
  public void onComplete(String paramString, int paramInt)
  {
    paramString = this.this$0;
    String str = this.val$callbackId;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{'result':");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("}");
    paramString.callJs(str, new String[] { localStringBuilder.toString() });
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQLevelJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */