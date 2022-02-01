package com.tencent.tkd.topicsdk.mvp;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;", "BEAN", "VIEW", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListPresenter;", "model", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListModel;", "(Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListModel;)V", "isLoading", "", "mIsUsedCacheData", "mView", "getModel", "()Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListModel;", "setModel", "total", "", "getTotal", "()I", "attachView", "", "view", "(Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;)V", "detachView", "handleLoadFirstPageError", "isCacheData", "list", "", "errorCode", "errorMsg", "", "handleLoadFirstPageSuccess", "handleLoadFirstPageSuccessNotCacheData", "handleLoadFirstPageSuccessWithCacheData", "loadFirstPage", "needCache", "(Ljava/lang/Boolean;)V", "loadNextPage", "refreshPage", "updateModel", "updateView", "Companion", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public class ListPresenter<BEAN, VIEW extends ListContract.IListView<BEAN>>
  implements ListContract.IListPresenter<BEAN, VIEW>
{
  public static final ListPresenter.Companion a = new ListPresenter.Companion(null);
  private ListContract.IListView<BEAN> b;
  private boolean c;
  private boolean d;
  @NotNull
  private ListContract.IListModel<BEAN> e;
  
  public ListPresenter(@NotNull ListContract.IListModel<BEAN> paramIListModel)
  {
    this.e = paramIListModel;
  }
  
  private final void a(List<? extends BEAN> paramList)
  {
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      ListContract.IListView localIListView = this.b;
      if (localIListView != null)
      {
        localIListView.setCenterHide();
        localIListView.setListData(paramList, false);
        localIListView.setFooterNoMore();
        localIListView.setHeaderLoading();
      }
      this.c = true;
    }
  }
  
  private final void a(boolean paramBoolean, int paramInt, List<? extends BEAN> paramList)
  {
    if (paramBoolean)
    {
      a(paramList);
      return;
    }
    b(paramInt, paramList);
  }
  
  private final void a(boolean paramBoolean, List<? extends BEAN> paramList, int paramInt, String paramString)
  {
    if (this.c)
    {
      ListContract.IListView localIListView = this.b;
      if (localIListView != null) {
        localIListView.setHeaderError(paramInt, paramString);
      }
    }
    if (((((Collection)paramList).isEmpty() ^ true)) && (paramBoolean))
    {
      paramString = this.b;
      if (paramString != null)
      {
        paramString.setCenterHide();
        paramString.setListData(paramList, false);
        paramString.setFooterNoMore();
      }
    }
    else if (!this.c)
    {
      paramList = this.b;
      if (paramList != null) {
        paramList.setCenterError(paramInt, paramString);
      }
      paramList = this.b;
      if (paramList != null) {
        paramList.setTotal(0);
      }
    }
  }
  
  private final void b(int paramInt, List<? extends BEAN> paramList)
  {
    ListContract.IListView localIListView = this.b;
    if (localIListView != null)
    {
      if (this.c) {
        localIListView.setHeaderSuccess();
      }
      a(paramInt, paramList);
    }
  }
  
  public void a()
  {
    this.b = ((ListContract.IListView)null);
  }
  
  public void a(int paramInt, @NotNull List<? extends BEAN> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    ListContract.IListView localIListView = this.b;
    if (localIListView != null)
    {
      localIListView.setTotal(paramInt);
      localIListView.setListData(paramList, false);
      if ((((Collection)paramList).isEmpty() ^ true))
      {
        localIListView.setCenterHide();
        if (this.e.a())
        {
          localIListView.setFooterHasMore();
          return;
        }
        localIListView.setFooterNoMore();
        return;
      }
      localIListView.setCenterEmpty();
      localIListView.setFooterHide();
    }
  }
  
  public void a(@NotNull VIEW paramVIEW)
  {
    Intrinsics.checkParameterIsNotNull(paramVIEW, "view");
    this.b = paramVIEW;
  }
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    Object localObject = this.b;
    if (localObject != null) {
      ((ListContract.IListView)localObject).setCenterLoading();
    }
    localObject = this.e;
    boolean bool;
    if (paramBoolean != null) {
      bool = paramBoolean.booleanValue();
    } else {
      bool = false;
    }
    ((ListContract.IListModel)localObject).a(bool, (Function6)new ListPresenter.loadFirstPage.1(this));
  }
  
  public void b()
  {
    if (!this.e.a())
    {
      localIListView = this.b;
      if (localIListView != null) {
        localIListView.setFooterNoMore();
      }
      return;
    }
    if (this.d) {
      return;
    }
    this.d = true;
    ListContract.IListView localIListView = this.b;
    if (localIListView != null) {
      localIListView.setFooterLoading();
    }
    this.e.a((Function4)new ListPresenter.loadNextPage.1(this));
  }
  
  @NotNull
  public final ListContract.IListModel<BEAN> c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.ListPresenter
 * JD-Core Version:    0.7.0.1
 */