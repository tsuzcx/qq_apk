package com.tencent.mobileqq.vaswebviewplugin;

import bbwe;

class ThemeJsPlugin$4
  implements bbwe
{
  ThemeJsPlugin$4(ThemeJsPlugin paramThemeJsPlugin, String paramString1, String paramString2, boolean paramBoolean, String paramString3) {}
  
  public void callback(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      this.this$0.gotoDownload(2, this.val$id, this.val$version, this.val$isVoiceTheme, this.val$callbackId);
      return;
    }
    this.this$0.gotoDownload(-2, this.val$id, this.val$version, this.val$isVoiceTheme, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */