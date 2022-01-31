package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import bbgu;

class ThemeJsPlugin$5
  extends bbgu
{
  ThemeJsPlugin$5(ThemeJsPlugin paramThemeJsPlugin, Context paramContext, int paramInt, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    super(paramContext, paramInt);
  }
  
  public void onBackPressed()
  {
    this.this$0.gotoDownload(-1, this.val$id, this.val$version, this.val$isVoiceTheme, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */