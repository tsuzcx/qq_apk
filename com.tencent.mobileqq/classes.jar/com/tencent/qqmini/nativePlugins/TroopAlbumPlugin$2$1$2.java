package com.tencent.qqmini.nativePlugins;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import bglv;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.QzonePluginProxyActivity;
import mqq.app.AppRuntime;

class TroopAlbumPlugin$2$1$2
  implements DialogInterface.OnClickListener
{
  TroopAlbumPlugin$2$1$2(TroopAlbumPlugin.2.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    Intent localIntent = new Intent();
    String str = TroopAlbumPlugin.access$900(this.this$2.this$1.this$0).a().getResources().getString(2131718162);
    QzonePluginProxyActivity.a(localIntent, "com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity");
    localIntent.putExtra("aid", "jhan_plxz");
    localIntent.putExtra("success_tips", str);
    localIntent.putExtra("direct_go", true);
    QzonePluginProxyActivity.a(TroopAlbumPlugin.access$1000(this.this$2.this$1.this$0).a(), paramDialogInterface, localIntent, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.TroopAlbumPlugin.2.1.2
 * JD-Core Version:    0.7.0.1
 */