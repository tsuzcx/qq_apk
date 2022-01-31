package com.tencent.qqmini.sdk.core.plugins;

import android.content.Intent;
import bgjd;
import bgje;
import bgkd;
import com.tencent.qqmini.sdk.log.QMLog;

class SettingsJsPlugin$1
  implements bgje
{
  SettingsJsPlugin$1(SettingsJsPlugin paramSettingsJsPlugin, bgkd parambgkd) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QMLog.d("SettingsJsPlugin", "doOnActivityResult requestCode=" + paramInt1 + ",resultCode=" + paramInt2 + ",data=" + paramIntent);
    if (paramInt1 == 5)
    {
      SettingsJsPlugin.access$000(this.this$0, this.val$req);
      bgjd.a().b(this);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SettingsJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */