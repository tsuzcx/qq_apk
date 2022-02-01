package com.tencent.mobileqq.education.request;

import com.tencent.mobileqq.education.request.callback.IStudyCmdCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/StudyCmdHandler$RequestObject;", "", "request", "Lcom/tencent/mobileqq/education/request/StudyReqInfo;", "callback", "Lcom/tencent/mobileqq/education/request/callback/IStudyCmdCallback;", "(Lcom/tencent/mobileqq/education/request/StudyReqInfo;Lcom/tencent/mobileqq/education/request/callback/IStudyCmdCallback;)V", "getCallback", "()Lcom/tencent/mobileqq/education/request/callback/IStudyCmdCallback;", "getRequest", "()Lcom/tencent/mobileqq/education/request/StudyReqInfo;", "qq_education_impl_release"}, k=1, mv={1, 1, 16})
public final class StudyCmdHandler$RequestObject
{
  @NotNull
  private final StudyReqInfo a;
  @Nullable
  private final IStudyCmdCallback b;
  
  public StudyCmdHandler$RequestObject(@NotNull StudyReqInfo paramStudyReqInfo, @Nullable IStudyCmdCallback paramIStudyCmdCallback)
  {
    this.a = paramStudyReqInfo;
    this.b = paramIStudyCmdCallback;
  }
  
  @NotNull
  public final StudyReqInfo a()
  {
    return this.a;
  }
  
  @Nullable
  public final IStudyCmdCallback b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.StudyCmdHandler.RequestObject
 * JD-Core Version:    0.7.0.1
 */