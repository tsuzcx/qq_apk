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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class ShortcutUtils$3
  implements Runnable
{
  ShortcutUtils$3(Activity paramActivity, MiniAppInfo paramMiniAppInfo, ShortcutUtils.AddShortcutCallback paramAddShortcutCallback) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 26) {
          break label308;
        }
        ShortcutManager localShortcutManager = (ShortcutManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("shortcut");
        if (ShortcutUtils.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, localShortcutManager))
        {
          QLog.i("Shortcut", 1, "Shortcut has created before!");
          ToastUtil.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name + "\"快捷方式已存在");
          if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(0, HardCodeUtil.a(2131713963));
          return;
        }
        if (!localShortcutManager.isRequestPinShortcutSupported()) {
          break label593;
        }
        Object localObject1 = ShortcutUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        Object localObject2 = ShortcutUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        PersistableBundle localPersistableBundle = new PersistableBundle();
        localObject1 = new ShortcutInfo.Builder(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId).setIcon(Icon.createWithBitmap((Bitmap)localObject2)).setShortLabel(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name).setIntent((Intent)localObject1).setExtras(localPersistableBundle).build();
        localObject2 = new Intent("com.tencent.mini.CreateShortcutSucceedReceiver");
        ((Intent)localObject2).putExtra("CONFIG_APPNAME", this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
        bool = localShortcutManager.requestPinShortcut((ShortcutInfo)localObject1, PendingIntent.getBroadcast(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject2, 134217728).getIntentSender());
        if (!bool)
        {
          ShortcutUtils.b(this.jdField_a_of_type_AndroidAppActivity);
          if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(1, HardCodeUtil.a(2131713959));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Shortcut", 1, "doAddShortcut exception!", localThrowable);
        return;
      }
      Thread.sleep(1000L);
      if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(0, HardCodeUtil.a(2131713954));
      return;
      label308:
      if (com.tencent.mobileqq.utils.ShortcutUtils.a(AppLoaderFactory.getMiniAppInterface().getApplication(), new String[] { this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name }))
      {
        QLog.i("Shortcut", 1, "Shortcut has created before!");
        ToastUtil.a().a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name + "\"快捷方式已存在");
        if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(0, HardCodeUtil.a(2131713951));
        return;
      }
      Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent.putExtra("android.intent.extra.shortcut.NAME", this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
      localIntent.putExtra("duplicate", false);
      localIntent.putExtra("android.intent.extra.shortcut.ICON", ShortcutUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
      localIntent.putExtra("android.intent.extra.shortcut.INTENT", ShortcutUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
      this.jdField_a_of_type_AndroidAppActivity.sendBroadcast(localIntent);
      Thread.sleep(1000L);
      if (com.tencent.mobileqq.utils.ShortcutUtils.a(AppLoaderFactory.getMiniAppInterface().getApplication(), new String[] { this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name }))
      {
        ToastUtil.a().a("已创建\"" + this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name + "\"快捷方式到桌面");
        if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(0, HardCodeUtil.a(2131713953));
        return;
      }
      ShortcutUtils.b(this.jdField_a_of_type_AndroidAppActivity);
      if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(1, HardCodeUtil.a(2131713962));
      return;
      label593:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.3
 * JD-Core Version:    0.7.0.1
 */