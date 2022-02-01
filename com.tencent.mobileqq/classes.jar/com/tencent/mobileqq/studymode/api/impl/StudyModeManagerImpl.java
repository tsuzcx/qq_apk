package com.tencent.mobileqq.studymode.api.impl;

import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;

public class StudyModeManagerImpl
  implements IStudyModeManager
{
  public boolean getStudyModeSwitch()
  {
    return StudyModeManager.h();
  }
  
  public void registerStudyModeChangeListener(StudyModeChangeListener paramStudyModeChangeListener)
  {
    StudyModeManager.a(paramStudyModeChangeListener);
  }
  
  public void unregisterStudyModeChangeListener(StudyModeChangeListener paramStudyModeChangeListener)
  {
    StudyModeManager.b(paramStudyModeChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.api.impl.StudyModeManagerImpl
 * JD-Core Version:    0.7.0.1
 */