package com.tencent.mobileqq.mini.appbrand.utils;

import ajya;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import bbkd;
import bdis;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.app.BaseAppLoaderManager;
import com.tencent.qphone.base.util.QLog;

final class ShortcutUtils$3
  implements Runnable
{
  ShortcutUtils$3(BaseActivity paramBaseActivity, ApkgInfo paramApkgInfo, ShortcutUtils.AddShortcutCallback paramAddShortcutCallback) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 26) {
          break label302;
        }
        ShortcutManager localShortcutManager = (ShortcutManager)this.val$activity.getSystemService("shortcut");
        if (ShortcutUtils.isShortcutCreated_O(this.val$apkgInfo.appId, localShortcutManager))
        {
          QLog.i("Shortcut", 1, "Shortcut has created before!");
          bdis.a().a(this.val$apkgInfo.apkgName + "\"快捷方式已存在");
          if (this.val$callback == null) {
            break;
          }
          this.val$callback.onAddResult(0, ajya.a(2131714025));
          return;
        }
        if (!localShortcutManager.isRequestPinShortcutSupported()) {
          break label597;
        }
        Object localObject1 = ShortcutUtils.access$000(this.val$activity, this.val$apkgInfo);
        Object localObject2 = ShortcutUtils.access$100(this.val$activity, this.val$apkgInfo);
        PersistableBundle localPersistableBundle = new PersistableBundle();
        localObject1 = new ShortcutInfo.Builder(this.val$activity, this.val$apkgInfo.appId).setIcon(Icon.createWithBitmap((Bitmap)localObject2)).setShortLabel(this.val$apkgInfo.apkgName).setIntent((Intent)localObject1).setExtras(localPersistableBundle).build();
        localObject2 = new Intent("com.tencent.mini.CreateShortcutSucceedReceiver");
        ((Intent)localObject2).putExtra("CONFIG_APPNAME", this.val$apkgInfo.apkgName);
        bool = localShortcutManager.requestPinShortcut((ShortcutInfo)localObject1, PendingIntent.getBroadcast(this.val$activity, 0, (Intent)localObject2, 134217728).getIntentSender());
        if (!bool)
        {
          ShortcutUtils.access$200(this.val$activity);
          if (this.val$callback == null) {
            break;
          }
          this.val$callback.onAddResult(1, ajya.a(2131714021));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Shortcut", 1, "doAddShortcut exception!", localThrowable);
        return;
      }
      if (this.val$callback == null) {
        break;
      }
      this.val$callback.onAddResult(0, ajya.a(2131714016));
      return;
      label302:
      if (bbkd.a(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApplication(), new String[] { this.val$apkgInfo.apkgName }))
      {
        QLog.i("Shortcut", 1, "Shortcut has created before!");
        bdis.a().a(this.val$apkgInfo.apkgName + "\"快捷方式已存在");
        if (this.val$callback == null) {
          break;
        }
        this.val$callback.onAddResult(0, ajya.a(2131714013));
        return;
      }
      Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent.putExtra("android.intent.extra.shortcut.NAME", this.val$apkgInfo.apkgName);
      localIntent.putExtra("duplicate", false);
      localIntent.putExtra("android.intent.extra.shortcut.ICON", ShortcutUtils.access$100(this.val$activity, this.val$apkgInfo));
      localIntent.putExtra("android.intent.extra.shortcut.INTENT", ShortcutUtils.access$000(this.val$activity, this.val$apkgInfo));
      this.val$activity.sendBroadcast(localIntent);
      Thread.sleep(1000L);
      if (bbkd.a(AppLoaderFactory.getAppLoaderManager().getMiniAppInterface().getApplication(), new String[] { this.val$apkgInfo.apkgName }))
      {
        bdis.a().a("已创建\"" + this.val$apkgInfo.apkgName + "\"快捷方式到桌面");
        if (this.val$callback == null) {
          break;
        }
        this.val$callback.onAddResult(0, ajya.a(2131714015));
        return;
      }
      ShortcutUtils.access$200(this.val$activity);
      if (this.val$callback == null) {
        break;
      }
      this.val$callback.onAddResult(1, ajya.a(2131714024));
      return;
      label597:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.ShortcutUtils.3
 * JD-Core Version:    0.7.0.1
 */