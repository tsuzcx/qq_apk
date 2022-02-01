package com.tencent.tkd.weibo.framework.mvp;

import android.util.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "VIEW", "Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListView;", "isSuccess", "", "allList", "", "errorCode", "", "errorMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class ListPresenter$loadNextPage$1
  extends Lambda
  implements Function4<Boolean, List<? extends BEAN>, Integer, String, Unit>
{
  ListPresenter$loadNextPage$1(ListPresenter paramListPresenter)
  {
    super(4);
  }
  
  public final void invoke(boolean paramBoolean, @NotNull List<? extends BEAN> paramList, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "allList");
    ListPresenter.a(this.this$0, false);
    ListContract.IListView localIListView = ListPresenter.a(this.this$0);
    if (localIListView != null)
    {
      if (!paramBoolean) {
        break label74;
      }
      localIListView.setListData(paramList, true);
      if (!this.this$0.a().a()) {
        break label64;
      }
      localIListView.setFooterHasMore();
    }
    for (;;)
    {
      return;
      label64:
      localIListView.setFooterNoMore();
      continue;
      label74:
      Log.i("ListPresenter", "loadNextPage error, errorCode=" + paramInt + ", errorMsg= " + paramString);
      localIListView.setFooterError(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.mvp.ListPresenter.loadNextPage.1
 * JD-Core Version:    0.7.0.1
 */