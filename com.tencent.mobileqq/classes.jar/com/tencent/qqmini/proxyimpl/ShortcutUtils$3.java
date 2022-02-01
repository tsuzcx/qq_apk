package com.tencent.qqmini.proxyimpl;

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
import anzj;
import bhsk;
import bjuh;
import blaa;
import blaf;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public final class ShortcutUtils$3
  implements Runnable
{
  public ShortcutUtils$3(Activity paramActivity, MiniAppInfo paramMiniAppInfo, blaf paramblaf) {}
  
  public void run()
  {
    boolean bool = false;
    try
    {
      if (Build.VERSION.SDK_INT < 26) {
        break label347;
      }
      ShortcutManager localShortcutManager = (ShortcutManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("shortcut");
      if (blaa.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, localShortcutManager))
      {
        QLog.i("Shortcut", 1, "Shortcut has created before!");
        bjuh.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name + "\"快捷方式已存在");
        if (this.jdField_a_of_type_Blaf == null) {
          return;
        }
        this.jdField_a_of_type_Blaf.a(0, anzj.a(2131712888));
        return;
      }
      if (localShortcutManager.isRequestPinShortcutSupported())
      {
        Object localObject1 = blaa.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        Object localObject2 = blaa.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        PersistableBundle localPersistableBundle = new PersistableBundle();
        localObject1 = new ShortcutInfo.Builder(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId).setIcon(Icon.createWithBitmap((Bitmap)localObject2)).setShortLabel(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name).setIntent((Intent)localObject1).setExtras(localPersistableBundle).build();
        localObject2 = new Intent("com.tencent.mini.CreateShortcutSucceedReceiver");
        ((Intent)localObject2).putExtra("CONFIG_APPNAME", this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
        bool = localShortcutManager.requestPinShortcut((ShortcutInfo)localObject1, PendingIntent.getBroadcast(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject2, 134217728).getIntentSender());
      }
      if (!bool)
      {
        blaa.b(this.jdField_a_of_type_AndroidAppActivity);
        if (this.jdField_a_of_type_Blaf == null) {
          return;
        }
        this.jdField_a_of_type_Blaf.a(1, anzj.a(2131712884));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Shortcut", 1, "doAddShortcut exception!", localThrowable);
      return;
    }
    Thread.sleep(1000L);
    if (blaa.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, localThrowable))
    {
      if (this.jdField_a_of_type_Blaf != null) {
        this.jdField_a_of_type_Blaf.a(0, anzj.a(2131712879));
      }
    }
    else if (this.jdField_a_of_type_Blaf != null)
    {
      this.jdField_a_of_type_Blaf.a(1, anzj.a(2131712884));
      return;
      label347:
      if (bhsk.a(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApplication(), new String[] { this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name }))
      {
        QLog.i("Shortcut", 1, "Shortcut has created before!");
        bjuh.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name + "\"快捷方式已存在");
        if (this.jdField_a_of_type_Blaf != null) {
          this.jdField_a_of_type_Blaf.a(0, anzj.a(2131712876));
        }
      }
      else
      {
        Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        localIntent.putExtra("android.intent.extra.shortcut.NAME", this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
        localIntent.putExtra("duplicate", false);
        localIntent.putExtra("android.intent.extra.shortcut.ICON", blaa.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
        localIntent.putExtra("android.intent.extra.shortcut.INTENT", blaa.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
        this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
        Thread.sleep(1000L);
        if (bhsk.a(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApplication(), new String[] { this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name }))
        {
          bjuh.a().a("已创建\"" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name + "\"快捷方式到桌面");
          if (this.jdField_a_of_type_Blaf != null) {
            this.jdField_a_of_type_Blaf.a(0, anzj.a(2131712878));
          }
        }
        else
        {
          blaa.b(this.jdField_a_of_type_AndroidAppActivity);
          if (this.jdField_a_of_type_Blaf != null) {
            this.jdField_a_of_type_Blaf.a(1, anzj.a(2131712887));
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