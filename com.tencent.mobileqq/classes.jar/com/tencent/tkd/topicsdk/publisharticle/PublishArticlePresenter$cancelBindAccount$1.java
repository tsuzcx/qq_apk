package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePresenter$cancelBindAccount$1
  extends Lambda
  implements Function1<Boolean, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  PublishArticlePresenter$cancelBindAccount$1()
  {
    super(1);
  }
  
  public final void invoke(boolean paramBoolean)
  {
    TLog.a("PublishArticlePresenter", "cancelBindAccount, isSuccess = " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePresenter.cancelBindAccount.1
 * JD-Core Version:    0.7.0.1
 */