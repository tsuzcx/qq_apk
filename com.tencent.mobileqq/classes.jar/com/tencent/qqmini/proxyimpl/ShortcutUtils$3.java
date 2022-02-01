package com.tencent.qqmini.proxyimpl;

import amtj;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import bfzb;
import bhzt;
import bjfx;
import bjgc;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public final class ShortcutUtils$3
  implements Runnable
{
  public ShortcutUtils$3(Activity paramActivity, MiniAppInfo paramMiniAppInfo, bjgc parambjgc) {}
  
  public void run()
  {
    boolean bool = false;
    try
    {
      if (Build.VERSION.SDK_INT < 26) {
        break label347;
      }
      ShortcutManager localShortcutManager = (ShortcutManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("shortcut");
      if (bjfx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, localShortcutManager))
      {
        QLog.i("Shortcut", 1, "Shortcut has created before!");
        bhzt.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name + "\"快捷方式已存在");
        if (this.jdField_a_of_type_Bjgc == null) {
          return;
        }
        this.jdField_a_of_type_Bjgc.a(0, amtj.a(2131713120));
        return;
      }
      if (localShortcutManager.isRequestPinShortcutSupported())
      {
        Object localObject1 = bjfx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        Object localObject2 = bjfx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        PersistableBundle localPersistableBundle = new PersistableBundle();
        localObject1 = new ShortcutInfo.Builder(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId).setIcon(Icon.createWithBitmap((Bitmap)localObject2)).setShortLabel(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name).setIntent((Intent)localObject1).setExtras(localPersistableBundle).build();
        localObject2 = new Intent("com.tencent.mini.CreateShortcutSucceedReceiver");
        ((Intent)localObject2).putExtra("CONFIG_APPNAME", this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
        bool = localShortcutManager.requestPinShortcut((ShortcutInfo)localObject1, PendingIntent.getBroadcast(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject2, 134217728).getIntentSender());
      }
      if (!bool)
      {
        bjfx.b(this.jdField_a_of_type_AndroidAppActivity);
        if (this.jdField_a_of_type_Bjgc == null) {
          return;
        }
        this.jdField_a_of_type_Bjgc.a(1, amtj.a(2131713116));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Shortcut", 1, "doAddShortcut exception!", localThrowable);
      return;
    }
    Thread.sleep(1000L);
    if (bjfx.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, localThrowable))
    {
      if (this.jdField_a_of_type_Bjgc != null) {
        this.jdField_a_of_type_Bjgc.a(0, amtj.a(2131713111));
      }
    }
    else if (this.jdField_a_of_type_Bjgc != null)
    {
      this.jdField_a_of_type_Bjgc.a(1, amtj.a(2131713116));
      return;
      label347:
      if (bfzb.a(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApplication(), new String[] { this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name }))
      {
        QLog.i("Shortcut", 1, "Shortcut has created before!");
        bhzt.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name + "\"快捷方式已存在");
        if (this.jdField_a_of_type_Bjgc != null) {
          this.jdField_a_of_type_Bjgc.a(0, amtj.a(2131713108));
        }
      }
      else
      {
        Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        localIntent.putExtra("android.intent.extra.shortcut.NAME", this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
        localIntent.putExtra("duplicate", false);
        localIntent.putExtra("android.intent.extra.shortcut.ICON", bjfx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
        localIntent.putExtra("android.intent.extra.shortcut.INTENT", bjfx.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
        this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
        Thread.sleep(1000L);
        if (bfzb.a(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApplication(), new String[] { this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name }))
        {
          bhzt.a().a("已创建\"" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name + "\"快捷方式到桌面");
          if (this.jdField_a_of_type_Bjgc != null) {
            this.jdField_a_of_type_Bjgc.a(0, amtj.a(2131713110));
          }
        }
        else
        {
          bjfx.b(this.jdField_a_of_type_AndroidAppActivity);
          if (this.jdField_a_of_type_Bjgc != null) {
            this.jdField_a_of_type_Bjgc.a(1, amtj.a(2131713119));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.3
 * JD-Core Version:    0.7.0.1
 */