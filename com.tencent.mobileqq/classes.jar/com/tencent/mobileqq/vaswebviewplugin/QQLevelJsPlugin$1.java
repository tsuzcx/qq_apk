package com.tencent.mobileqq.vaswebviewplugin;

import beht;

class QQLevelJsPlugin$1
  extends beht
{
  QQLevelJsPlugin$1(QQLevelJsPlugin paramQQLevelJsPlugin, String paramString) {}
  
  public void onComplete(String paramString, int paramInt)
  {
    this.this$0.callJs(this.val$callbackId, new String[] { "{'result':" + paramInt + "}" });
  }
  
  public void onProgress(String paramString, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQLevelJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */