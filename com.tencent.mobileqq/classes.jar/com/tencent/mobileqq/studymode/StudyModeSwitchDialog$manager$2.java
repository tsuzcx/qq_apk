package com.tencent.mobileqq.studymode;

import baau;
import babh;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/studymode/ModeSwitchManager;", "invoke"}, k=3, mv={1, 1, 16})
public final class StudyModeSwitchDialog$manager$2
  extends Lambda
  implements Function0<baau>
{
  public StudyModeSwitchDialog$manager$2(babh parambabh)
  {
    super(0);
  }
  
  @NotNull
  public final baau invoke()
  {
    Manager localManager = babh.a(this.this$0).app.getManager(361);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.studymode.ModeSwitchManager");
    }
    return (baau)localManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.StudyModeSwitchDialog.manager.2
 * JD-Core Version:    0.7.0.1
 */