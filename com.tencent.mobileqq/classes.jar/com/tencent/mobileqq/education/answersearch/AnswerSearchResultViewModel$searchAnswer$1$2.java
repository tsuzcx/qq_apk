package com.tencent.mobileqq.education.answersearch;

import com.tencent.mobileqq.education.request.StudyReqInfo;
import com.tencent.mobileqq.education.request.callback.IStudyCmdCallback;
import com.tencent.mobileqq.education.request.respone.IStudyResponse;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/education/answersearch/AnswerSearchResultViewModel$searchAnswer$1$2", "Lcom/tencent/mobileqq/education/request/callback/IStudyCmdCallback;", "onCmdResponse", "", "request", "Lcom/tencent/mobileqq/education/request/StudyReqInfo;", "response", "Lcom/tencent/mobileqq/education/request/respone/IStudyResponse;", "qq_education_impl_release"}, k=1, mv={1, 1, 16})
public final class AnswerSearchResultViewModel$searchAnswer$1$2
  implements IStudyCmdCallback
{
  public void a(@NotNull StudyReqInfo paramStudyReqInfo, @NotNull IStudyResponse paramIStudyResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramStudyReqInfo, "request");
    Intrinsics.checkParameterIsNotNull(paramIStudyResponse, "response");
    QLog.i("ProblemSearchResultViewModel", 1, "searchAnswer: requestSearchResult finish.");
    AnswerSearchResultViewModel.a(this.a.this$0, paramIStudyResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.answersearch.AnswerSearchResultViewModel.searchAnswer.1.2
 * JD-Core Version:    0.7.0.1
 */