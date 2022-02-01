package com.tencent.mobileqq.studymode;

import com.tencent.mobileqq.config.QConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/studymode/StudyModeSwitchDialogConfigProcessor$Companion;", "", "()V", "CONFIG_ID", "", "shouldShowStudyModeSwitchDialog", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class StudyModeSwitchDialogConfigProcessor$Companion
{
  public final boolean a()
  {
    Object localObject = QConfigManager.a().a(619);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QConfigManager.getSingle…n().loadConObj(CONFIG_ID)");
    return ((StudyModeSwitchDialogConfigProcessor.Config)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeSwitchDialogConfigProcessor.Companion
 * JD-Core Version:    0.7.0.1
 */