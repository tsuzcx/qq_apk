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
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    boolean bool = ShortcutUtils.a((Context)localObject1, new String[] { ((Context)localObject1).getString(2131690092) });
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = ShortcutUtils.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("createShortcut ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(ShortcutUtils.a());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (bool)
    {
      if (ShortcutUtils.b() < 3) {
        ThreadManager.getSubThreadHandler().postDelayed(this, 1000L);
      }
    }
    else
    {
      localObject1 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject1).setClassName(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject1).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject1).addFlags(268435456);
      ((Intent)localObject1).addFlags(2097152);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject1);
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.NAME", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690092));
      ((Intent)localObject2).putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2130840405));
      ((Intent)localObject2).putExtra("duplicate", false);
      ((Intent)localObject2).setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      this.jdField_a_of_type_AndroidContentContext.sendOrderedBroadcast((Intent)localObject2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShortcutUtils.1
 * JD-Core Version:    0.7.0.1
 */