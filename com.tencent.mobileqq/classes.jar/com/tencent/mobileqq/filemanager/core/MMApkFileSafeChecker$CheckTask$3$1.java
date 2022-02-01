package com.tencent.mobileqq.filemanager.core;

import asim;
import com.tencent.qphone.base.util.QLog;

class MMApkFileSafeChecker$CheckTask$3$1
  implements Runnable
{
  MMApkFileSafeChecker$CheckTask$3$1(MMApkFileSafeChecker.CheckTask.3 param3) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, "[MMApkCheck] <" + this.a.a.jdField_a_of_type_Int + "> check timeout!");
    this.a.a.a(1, 0, "", "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.3.1
 * JD-Core Version:    0.7.0.1
 */