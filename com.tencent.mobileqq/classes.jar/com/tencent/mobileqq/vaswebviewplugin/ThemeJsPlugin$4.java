package com.tencent.mobileqq.vaswebviewplugin;

import com.tencent.mobileqq.vip.CUKingCardHelper.CUKingDialogListener;

class ThemeJsPlugin$4
  implements CUKingCardHelper.CUKingDialogListener
{
  ThemeJsPlugin$4(ThemeJsPlugin paramThemeJsPlugin, String paramString1, String paramString2, boolean paramBoolean, String paramString3) {}
  
  public void callback(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if ((paramInt != 3) && (paramInt != 4)) {
        return;
      }
      this.this$0.gotoDownload(-2, this.val$id, this.val$version, this.val$isVoiceTheme, this.val$callbackId);
      return;
    }
    this.this$0.gotoDownload(2, this.val$id, this.val$version, this.val$isVoiceTheme, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */