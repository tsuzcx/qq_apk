package com.tencent.qqmini.proxyimpl;

import alpo;
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
import bdix;
import bfhq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
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
          break label302;
        }
        ShortcutManager localShortcutManager = (ShortcutManager)this.val$activity.getSystemService("shortcut");
        if (ShortcutUtils.isShortcutCreated_O(this.val$miniAppInfo.appId, localShortcutManager))
        {
          QLog.i("Shortcut", 1, "Shortcut has created before!");
          bfhq.a().a(this.val$miniAppInfo.name + "\"快捷方式已存在");
          if (this.val$callback == null) {
            break;
          }
          this.val$callback.onAddResult(0, alpo.a(2131714397));
          return;
        }
        if (!localShortcutManager.isRequestPinShortcutSupported()) {
          break label587;
        }
        Object localObject1 = ShortcutUtils.access$000(this.val$activity, this.val$miniAppInfo);
        Object localObject2 = ShortcutUtils.access$100(this.val$activity, this.val$miniAppInfo);
        PersistableBundle localPersistableBundle = new PersistableBundle();
        localObject1 = new ShortcutInfo.Builder(this.val$activity, this.val$miniAppInfo.appId).setIcon(Icon.createWithBitmap((Bitmap)localObject2)).setShortLabel(this.val$miniAppInfo.name).setIntent((Intent)localObject1).setExtras(localPersistableBundle).build();
        localObject2 = new Intent("com.tencent.mini.CreateShortcutSucceedReceiver");
        ((Intent)localObject2).putExtra("CONFIG_APPNAME", this.val$miniAppInfo.name);
        bool = localShortcutManager.requestPinShortcut((ShortcutInfo)localObject1, PendingIntent.getBroadcast(this.val$activity, 0, (Intent)localObject2, 134217728).getIntentSender());
        if (!bool)
        {
          ShortcutUtils.access$200(this.val$activity);
          if (this.val$callback == null) {
            break;
          }
          this.val$callback.onAddResult(1, alpo.a(2131714393));
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
      this.val$callback.onAddResult(0, alpo.a(2131714388));
      return;
      label302:
      if (bdix.a(MiniAppEnv.g().getContext(), new String[] { this.val$miniAppInfo.name }))
      {
        QLog.i("Shortcut", 1, "Shortcut has created before!");
        bfhq.a().a(this.val$miniAppInfo.name + "\"快捷方式已存在");
        if (this.val$callback == null) {
          break;
        }
        this.val$callback.onAddResult(0, alpo.a(2131714385));
        return;
      }
      Intent localIntent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent.putExtra("android.intent.extra.shortcut.NAME", this.val$miniAppInfo.name);
      localIntent.putExtra("duplicate", false);
      localIntent.putExtra("android.intent.extra.shortcut.ICON", ShortcutUtils.access$100(this.val$activity, this.val$miniAppInfo));
      localIntent.putExtra("android.intent.extra.shortcut.INTENT", ShortcutUtils.access$000(this.val$activity, this.val$miniAppInfo));
      this.val$activity.sendBroadcast(localIntent);
      Thread.sleep(1000L);
      if (bdix.a(MiniAppEnv.g().getContext(), new String[] { this.val$miniAppInfo.name }))
      {
        bfhq.a().a("已创建\"" + this.val$miniAppInfo.name + "\"快捷方式到桌面");
        if (this.val$callback == null) {
          break;
        }
        this.val$callback.onAddResult(0, alpo.a(2131714387));
        return;
      }
      ShortcutUtils.access$200(this.val$activity);
      if (this.val$callback == null) {
        break;
      }
      this.val$callback.onAddResult(1, alpo.a(2131714396));
      return;
      label587:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShortcutUtils.3
 * JD-Core Version:    0.7.0.1
 */