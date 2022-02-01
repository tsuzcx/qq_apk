package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errorCode", "", "errorMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class PublishArticlePresenter$publishArticle$1$1
  extends Lambda
  implements Function2<Integer, String, Unit>
{
  public static final 1 INSTANCE = new 1();
  
  PublishArticlePresenter$publishArticle$1$1()
  {
    super(2);
  }
  
  public final void invoke(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    TLog.a("PublishArticlePresenter", "errCode: " + paramInt + ", errorMsg: " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticlePresenter.publishArticle.1.1
 * JD-Core Version:    0.7.0.1
 */