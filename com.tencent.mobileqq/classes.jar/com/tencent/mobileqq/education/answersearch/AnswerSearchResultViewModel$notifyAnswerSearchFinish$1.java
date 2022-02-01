package com.tencent.mobileqq.education.answersearch;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnswerSearchResultViewModel$notifyAnswerSearchFinish$1
  implements Runnable
{
  AnswerSearchResultViewModel$notifyAnswerSearchFinish$1(AnswerSearchResultViewModel paramAnswerSearchResultViewModel, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AnswerSearchResultViewModel.a(this.this$0, this.a);
    AnswerSearchResultViewModel.a(this.this$0, this.b);
    AnswerSearchResultViewModel.b(this.this$0, this.c);
    AnswerSearchResultViewModel.c(this.this$0, this.d);
    this.this$0.a().setValue(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.answersearch.AnswerSearchResultViewModel.notifyAnswerSearchFinish.1
 * JD-Core Version:    0.7.0.1
 */