package com.tencent.tkd.weibo.framework.mvp;

import android.util.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "VIEW", "Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListView;", "isSuccess", "", "list", "", "total", "", "isCacheData", "errorCode", "errorMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class ListPresenter$loadFirstPage$1
  extends Lambda
  implements Function6<Boolean, List<? extends BEAN>, Integer, Boolean, Integer, String, Unit>
{
  ListPresenter$loadFirstPage$1(ListPresenter paramListPresenter)
  {
    super(6);
  }
  
  public final void invoke(boolean paramBoolean1, @NotNull List<? extends BEAN> paramList, int paramInt1, boolean paramBoolean2, int paramInt2, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    ListPresenter.a(this.this$0, false);
    if (paramBoolean1)
    {
      ListPresenter.a(this.this$0, paramBoolean2, paramInt1, paramList);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadFirstPage error, errorCode=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", errorMsg= ");
    localStringBuilder.append(paramString);
    Log.i("ListPresenter", localStringBuilder.toString());
    ListPresenter.a(this.this$0, paramBoolean2, paramList, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.mvp.ListPresenter.loadFirstPage.1
 * JD-Core Version:    0.7.0.1
 */