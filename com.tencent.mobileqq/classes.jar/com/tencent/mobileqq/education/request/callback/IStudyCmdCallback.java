package com.tencent.mobileqq.education.request.callback;

import com.tencent.mobileqq.education.request.StudyReqInfo;
import com.tencent.mobileqq.education.request.respone.IStudyResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/request/callback/IStudyCmdCallback;", "", "onCmdResponse", "", "request", "Lcom/tencent/mobileqq/education/request/StudyReqInfo;", "response", "Lcom/tencent/mobileqq/education/request/respone/IStudyResponse;", "qq-education-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IStudyCmdCallback
{
  public abstract void a(@NotNull StudyReqInfo paramStudyReqInfo, @NotNull IStudyResponse paramIStudyResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.request.callback.IStudyCmdCallback
 * JD-Core Version:    0.7.0.1
 */