package com.tencent.mobileqq.studymode.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;

@QAPI(process={"all"})
public abstract interface IStudyModeManager
  extends QRouteApi
{
  public static final int NORMAL_MODE = 0;
  public static final int STUDY_MODE = 1;
  
  public abstract boolean getStudyModeSwitch();
  
  public abstract void registerStudyModeChangeListener(StudyModeChangeListener paramStudyModeChangeListener);
  
  public abstract void unregisterStudyModeChangeListener(StudyModeChangeListener paramStudyModeChangeListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.api.IStudyModeManager
 * JD-Core Version:    0.7.0.1
 */