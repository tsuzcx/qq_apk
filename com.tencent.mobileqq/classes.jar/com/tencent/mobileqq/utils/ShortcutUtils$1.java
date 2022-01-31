package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.res.Resources;
import bdix;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class ShortcutUtils$1
  implements Runnable
{
  public void run()
  {
    boolean bool = bdix.a(this.jdField_a_of_type_AndroidContentContext, new String[] { this.jdField_a_of_type_AndroidContentContext.getString(2131690192) });
    if (QLog.isColorLevel()) {
      QLog.d(bdix.a(), 2, "createShortcut " + bool + ", " + bdix.a());
    }
    if (bool)
    {
      if (bdix.b() < 3) {
        ThreadManager.getSubThreadHandler().postDelayed(this, 1000L);
      }
      return;
    }
    Intent localIntent1 = new Intent("android.intent.action.MAIN");
    localIntent1.setClassName(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    localIntent1.addCategory("android.intent.category.LAUNCHER");
    localIntent1.addFlags(268435456);
    localIntent1.addFlags(2097152);
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
    localIntent2.putExtra("android.intent.extra.shortcut.NAME", this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690192));
    localIntent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2130840157));
    localIntent2.putExtra("duplicate", false);
    localIntent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    this.jdField_a_of_type_AndroidContentContext.sendOrderedBroadcast(localIntent2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShortcutUtils.1
 * JD-Core Version:    0.7.0.1
 */