package com.tencent.mobileqq.filemanager.core;

import com.tencent.qphone.base.util.QLog;

class MMApkFileSafeChecker$CheckTask$3$1
  implements Runnable
{
  MMApkFileSafeChecker$CheckTask$3$1(MMApkFileSafeChecker.CheckTask.3 param3) {}
  
  public void run()
  {
    if (this.a.a.j) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MMApkCheck] <");
    localStringBuilder.append(this.a.a.k);
    localStringBuilder.append("> check timeout!");
    QLog.i("MMApkFileSafeChecker<FileAssistant>", 1, localStringBuilder.toString());
    this.a.a.a(1, 0, "", "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.CheckTask.3.1
 * JD-Core Version:    0.7.0.1
 */