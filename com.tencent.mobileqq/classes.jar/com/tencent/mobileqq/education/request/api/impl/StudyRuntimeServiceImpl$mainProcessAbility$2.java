package com.tencent.mobileqq.education.request.api.impl;

import com.tencent.mobileqq.education.request.StudyMainProcessAbility;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mobileqq/education/request/StudyMainProcessAbility;", "invoke"}, k=3, mv={1, 1, 16})
final class StudyRuntimeServiceImpl$mainProcessAbility$2
  extends Lambda
  implements Function0<StudyMainProcessAbility>
{
  StudyRuntimeServiceImpl$mainProcessAbility$2(StudyRuntimeServiceImpl paramStudyRuntimeServiceImpl)
  {
    super(0);
  }
  
  @NotNull
  public final StudyMainProcessAbility invoke()
  {
    StudyRuntimeServiceImpl.access$setAbilityInit$p(this.this$0, true);
    return new StudyMainProcessAbility();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.api.impl.StudyRuntimeServiceImpl.mainProcessAbility.2
 * JD-Core Version:    0.7.0.1
 */