package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.hippy.qq.api.IUpdateListener;

class HippyJsPlugin$1
  implements IUpdateListener
{
  HippyJsPlugin$1(HippyJsPlugin paramHippyJsPlugin, String paramString) {}
  
  public void onUpdateFailed(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramInt2 == 101)
    {
      this.this$0.onJsUpdateCompleted(paramString2, 1, null, this.val$callbackId);
      return;
    }
    if (paramInt2 == 1)
    {
      this.this$0.onJsUpdateCompleted(paramString2, 0, null, this.val$callbackId);
      return;
    }
    this.this$0.onJsUpdateCompleted(paramString2, -1, paramString1, this.val$callbackId);
  }
  
  public void onUpdateSuccess(int paramInt, String paramString)
  {
    this.this$0.onJsUpdateCompleted(paramString, 1, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.HippyJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */