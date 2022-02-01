package com.tencent.mobileqq.education.answersearch;

import android.text.TextUtils;
import com.tencent.mobileqq.education.request.callback.IStudyCmdCallback;
import com.tencent.mobileqq.education.request.callback.IStudyUploadCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnswerSearchResultViewModel$searchAnswer$1
  implements Runnable
{
  AnswerSearchResultViewModel$searchAnswer$1(AnswerSearchResultViewModel paramAnswerSearchResultViewModel) {}
  
  public final void run()
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = "";
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    QLog.i("ProblemSearchResultViewModel", 1, "searchAnswer: uploadSearchPicture start.");
    this.this$0.a((IStudyUploadCallback)new AnswerSearchResultViewModel.searchAnswer.1.1(this, localObjectRef, localCountDownLatch));
    try
    {
      localCountDownLatch.await(10000L, TimeUnit.MILLISECONDS);
      if (TextUtils.isEmpty((CharSequence)localObjectRef.element))
      {
        AnswerSearchResultViewModel.a(this.this$0, -2, "data upload error.", null, null, 12, null);
        return;
      }
      QLog.i("ProblemSearchResultViewModel", 1, "searchAnswer: requestSearchResult start.");
      this.this$0.a((String)localObjectRef.element, (IStudyCmdCallback)new AnswerSearchResultViewModel.searchAnswer.1.2(this));
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      label129:
      break label129;
    }
    QLog.i("ProblemSearchResultViewModel", 1, "searchAnswer: error. process finish.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.answersearch.AnswerSearchResultViewModel.searchAnswer.1
 * JD-Core Version:    0.7.0.1
 */