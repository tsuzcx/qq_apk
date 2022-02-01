package com.tencent.tkd.topicsdk.mvp;

import com.tencent.tkd.topicsdk.framework.TLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "VIEW", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;", "isSuccess", "", "list", "", "total", "", "<anonymous parameter 3>", "errorCode", "errorMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class ListPresenter$refreshPage$1
  extends Lambda
  implements Function6<Boolean, List<? extends BEAN>, Integer, Boolean, Integer, String, Unit>
{
  ListPresenter$refreshPage$1(ListPresenter paramListPresenter)
  {
    super(6);
  }
  
  public final void invoke(boolean paramBoolean1, @NotNull List<? extends BEAN> paramList, int paramInt1, boolean paramBoolean2, int paramInt2, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    ListContract.IListView localIListView = ListPresenter.a(this.this$0);
    if (localIListView != null)
    {
      if (!paramBoolean1) {
        break label41;
      }
      localIListView.setHeaderSuccess();
      this.this$0.a(paramInt1, paramList);
    }
    for (;;)
    {
      return;
      label41:
      TLog.a("ListPresenter", "refreshPage error, errorCode=" + paramInt2 + ", errorMsg= " + paramString);
      localIListView.setHeaderError(paramInt2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.ListPresenter.refreshPage.1
 * JD-Core Version:    0.7.0.1
 */