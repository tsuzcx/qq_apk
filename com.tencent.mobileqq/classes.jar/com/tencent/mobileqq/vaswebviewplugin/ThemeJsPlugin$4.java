package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ThemeJsPlugin$4
  extends QQCustomDialog
{
  ThemeJsPlugin$4(ThemeJsPlugin paramThemeJsPlugin, Context paramContext, int paramInt, String paramString1, String paramString2, Bundle paramBundle, String paramString3)
  {
    super(paramContext, paramInt);
  }
  
  public void onBackPressed()
  {
    this.this$0.gotoDownload(-1, this.val$id, this.val$version, this.val$reqData, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */