package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"DATE_FORMAT", "", "LOAD_STATUS_FALSE", "", "LOAD_STATUS_NONE", "LOAD_STATUS_TRUE", "MODE_TYPE_DEFAULT", "MODE_TYPE_INVALID", "MODE_TYPE_SIMPLE", "MODE_TYPE_STUDY", "getCurMode", "isSimple", "", "isStudy", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class ModeConstantsKt
{
  public static final int a()
  {
    if (SimpleUIUtil.a()) {
      return 1;
    }
    if (StudyModeManager.a()) {
      return 2;
    }
    return 0;
  }
  
  public static final int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      return 1;
    }
    if (paramBoolean2) {
      return 2;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.ModeConstantsKt
 * JD-Core Version:    0.7.0.1
 */