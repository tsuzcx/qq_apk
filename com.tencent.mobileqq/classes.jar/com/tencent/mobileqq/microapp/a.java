package com.tencent.mobileqq.microapp;

import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

final class a
  implements Runnable
{
  a(MiniAppInterface paramMiniAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppInterface", 2, "Kill process " + MiniAppInterface.access$000(this.a).getPackageName());
    }
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.a
 * JD-Core Version:    0.7.0.1
 */