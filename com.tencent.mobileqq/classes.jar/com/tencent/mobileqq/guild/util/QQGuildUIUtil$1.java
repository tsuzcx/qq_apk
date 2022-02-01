package com.tencent.mobileqq.guild.util;

import android.app.Activity;

final class QQGuildUIUtil$1
  implements Runnable
{
  QQGuildUIUtil$1(Activity paramActivity) {}
  
  public void run()
  {
    Activity localActivity = this.a;
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildUIUtil.1
 * JD-Core Version:    0.7.0.1
 */