package com.tencent.qqmini.miniapp.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.smtt.sdk.TbsDownloader;

final class EmbeddedHelper$4
  implements DialogInterface.OnClickListener
{
  EmbeddedHelper$4(String paramString1, String paramString2, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QMLog.e("EmbeddedHelper", "startDownload");
    SharedPreferences.Editor localEditor = EmbeddedHelper.access$400().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.val$version);
    localStringBuilder.append(this.val$uin);
    localEditor.putInt(localStringBuilder.toString(), 1).commit();
    TbsDownloader.startDownload(this.val$activity, true);
    paramDialogInterface.dismiss();
    EmbeddedHelper.setIsRunning(Boolean.valueOf(false));
    EmbeddedHelper.access$300(781, "download");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.EmbeddedHelper.4
 * JD-Core Version:    0.7.0.1
 */