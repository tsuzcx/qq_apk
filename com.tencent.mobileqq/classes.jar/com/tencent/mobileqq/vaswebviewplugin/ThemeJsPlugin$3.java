package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;

class ThemeJsPlugin$3
  implements CUKingCardHelper.CUKingDialogListener
{
  ThemeJsPlugin$3(ThemeJsPlugin paramThemeJsPlugin, String paramString1, String paramString2, Bundle paramBundle, String paramString3) {}
  
  public void callback(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      this.this$0.gotoDownload(2, this.val$id, this.val$version, this.val$reqData, this.val$callbackId);
      return;
    }
    this.this$0.gotoDownload(-2, this.val$id, this.val$version, this.val$reqData, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */