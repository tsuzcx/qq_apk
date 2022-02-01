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
        int i = Build.VERSION.SDK_INT;
        Object localObject1;
        Object localObject2;
        if (i >= 26)
        {
          localObject1 = (ShortcutManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("shortcut");
          if (ShortcutUtils.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId, (ShortcutManager)localObject1))
          {
            QLog.i("Shortcut", 1, "Shortcut has created before!");
            localObject1 = ToastUtil.a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
            ((StringBuilder)localObject2).append("\"快捷方式已存在");
            ((ToastUtil)localObject1).a(((StringBuilder)localObject2).toString());
            if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback == null) {
              break label641;
            }
            this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(0, HardCodeUtil.a(2131713894));
            return;
          }
          if (!((ShortcutManager)localObject1).isRequestPinShortcutSupported()) {
            break label642;
          }
          localObject2 = ShortcutUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
          Object localObject3 = ShortcutUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
          PersistableBundle localPersistableBundle = new PersistableBundle();
          localObject2 = new ShortcutInfo.Builder(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId).setIcon(Icon.createWithBitmap((Bitmap)localObject3)).setShortLabel(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name).setIntent((Intent)localObject2).setExtras(localPersistableBundle).build();
          localObject3 = new Intent("com.tencent.mini.CreateShortcutSucceedReceiver");
          ((Intent)localObject3).putExtra("CONFIG_APPNAME", this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
          bool = ((ShortcutManager)localObject1).requestPinShortcut((ShortcutInfo)localObject2, PendingIntent.getBroadcast(this.jdField_a_of_type_AndroidAppActivity, 0, (Intent)localObject3, 134217728).getIntentSender());
          if (!bool)
          {
            ShortcutUtils.c(this.jdField_a_of_type_AndroidAppActivity);
            if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback != null) {
              this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(1, HardCodeUtil.a(2131713890));
            }
          }
          else
          {
            Thread.sleep(1000L);
            if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback != null) {
              this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(0, HardCodeUtil.a(2131713885));
            }
          }
        }
        else
        {
          if (com.tencent.mobileqq.utils.ShortcutUtils.a(AppLoaderFactory.getMiniAppInterface().getApplication(), new String[] { this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name }))
          {
            QLog.i("Shortcut", 1, "Shortcut has created before!");
            localObject1 = ToastUtil.a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
            ((StringBuilder)localObject2).append("\"快捷方式已存在");
            ((ToastUtil)localObject1).a(((StringBuilder)localObject2).toString());
            if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(0, HardCodeUtil.a(2131713882));
            return;
          }
          localObject1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
          ((Intent)localObject1).putExtra("android.intent.extra.shortcut.NAME", this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
          ((Intent)localObject1).putExtra("duplicate", false);
          ((Intent)localObject1).putExtra("android.intent.extra.shortcut.ICON", ShortcutUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
          ((Intent)localObject1).putExtra("android.intent.extra.shortcut.INTENT", ShortcutUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo));
          this.jdField_a_of_type_AndroidAppActivity.sendBroadcast((Intent)localObject1);
          Thread.sleep(1000L);
          if (com.tencent.mobileqq.utils.ShortcutUtils.a(AppLoaderFactory.getMiniAppInterface().getApplication(), new String[] { this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name }))
          {
            localObject1 = ToastUtil.a();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("已创建\"");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.name);
            ((StringBuilder)localObject2).append("\"快捷方式到桌面");
            ((ToastUtil)localObject1).a(((StringBuilder)localObject2).toString());
            if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback != null) {
              this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(0, HardCodeUtil.a(2131713884));
            }
          }
          else
          {
            ShortcutUtils.c(this.jdField_a_of_type_AndroidAppActivity);
            if (this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback != null)
            {
              this.jdField_a_of_type_ComTencentQqminiProxyimplShortcutUtils$AddShortcutCallback.a(1, HardCodeUtil.a(2131713893));
              return;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Shortcut", 1, "doAddShortcut exception!", localThrowable);
      }
      return;
      label641:
      return;
      label642:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.3
 * JD-Core Version:    0.7.0.1
 */