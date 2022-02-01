package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import android.os.Parcelable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

final class ShortcutUtils$1
  implements Runnable
{
  public void run()
  {
    Object localObject1 = this.a;
    boolean bool = ShortcutUtils.a((Context)localObject1, new String[] { ((Context)localObject1).getString(2131886912) });
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = ShortcutUtils.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("createShortcut ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(ShortcutUtils.b());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (bool)
    {
      if (ShortcutUtils.c() < 3) {
        ThreadManager.getSubThreadHandler().postDelayed(this, 1000L);
      }
    }
    else
    {
      localObject1 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject1).setClassName(this.a, this.b);
      ((Intent)localObject1).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).addFlags(2097152);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject1);
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", this.a.getResources().getString(2131886912));
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this.a.getApplicationContext(), 2130841158));
      ((Intent)localObject2).putExtra("duplicate", false);
      ((Intent)localObject2).setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      this.a.sendOrderedBroadcast((Intent)localObject2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShortcutUtils.1
 * JD-Core Version:    0.7.0.1
 */