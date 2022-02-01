package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.qphone.base.util.QLog;

class KidModeAdvanceSettingFragment$5
  extends ResourcePluginListener
{
  KidModeAdvanceSettingFragment$5(KidModeAdvanceSettingFragment paramKidModeAdvanceSettingFragment) {}
  
  public void a(byte paramByte)
  {
    QLog.d("ResourcePluginListener", 1, "notifyLebaState ");
    ThreadManager.excute(new KidModeAdvanceSettingFragment.5.1(this), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment.5
 * JD-Core Version:    0.7.0.1
 */