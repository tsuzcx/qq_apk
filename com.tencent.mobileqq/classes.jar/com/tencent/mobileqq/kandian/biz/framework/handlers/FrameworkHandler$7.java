package com.tencent.mobileqq.kandian.biz.framework.handlers;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class FrameworkHandler$7
  implements StudyModeChangeListener
{
  FrameworkHandler$7(FrameworkHandler paramFrameworkHandler) {}
  
  public void onChange(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onChange], isStudyMode = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("FrameworkHandler", 1, localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new FrameworkHandler.7.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler.7
 * JD-Core Version:    0.7.0.1
 */