package com.tencent.mobileqq.education.answersearch;

import com.tencent.mobileqq.education.request.callback.IStudyUploadCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/education/answersearch/AnswerSearchResultViewModel$searchAnswer$1$1", "Lcom/tencent/mobileqq/education/request/callback/IStudyUploadCallback;", "onUploadFinish", "", "isSuc", "", "errorCode", "", "errorMsg", "", "url", "qq_education_impl_release"}, k=1, mv={1, 1, 16})
public final class AnswerSearchResultViewModel$searchAnswer$1$1
  implements IStudyUploadCallback
{
  AnswerSearchResultViewModel$searchAnswer$1$1(Ref.ObjectRef paramObjectRef, CountDownLatch paramCountDownLatch) {}
  
  public void a(boolean paramBoolean, int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "errorMsg");
    Intrinsics.checkParameterIsNotNull(paramString2, "url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("searchAnswer: uploadSearchPicture finish. url[");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(']');
    QLog.i("ProblemSearchResultViewModel", 1, localStringBuilder.toString());
    this.b.element = AnswerSearchResultViewModel.a(this.a.this$0, paramBoolean, paramInt, paramString1, paramString2);
    this.c.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.answersearch.AnswerSearchResultViewModel.searchAnswer.1.1
 * JD-Core Version:    0.7.0.1
 */