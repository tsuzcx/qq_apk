package com.tencent.tkd.weibo.framework.mvp;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/framework/mvp/ListPresenter;", "BEAN", "VIEW", "Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListView;", "Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListPresenter;", "model", "Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListModel;", "(Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListModel;)V", "isLoading", "", "mIsUsedCacheData", "mView", "getModel", "()Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListModel;", "setModel", "total", "", "getTotal", "()I", "attachView", "", "view", "(Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListView;)V", "detachView", "handleLoadFirstPageError", "isCacheData", "list", "", "errorCode", "errorMsg", "", "handleLoadFirstPageSuccess", "handleLoadFirstPageSuccessNotCacheData", "handleLoadFirstPageSuccessWithCacheData", "loadFirstPage", "needCache", "(Ljava/lang/Boolean;)V", "loadNextPage", "refreshPage", "updateModel", "updateView", "Companion", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public class ListPresenter<BEAN, VIEW extends ListContract.IListView<BEAN>>
  implements ListContract.IListPresenter<BEAN, VIEW>
{
  public static final ListPresenter.Companion a;
  @NotNull
  private ListContract.IListModel<BEAN> jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListModel;
  private ListContract.IListView<BEAN> jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListPresenter$Companion = new ListPresenter.Companion(null);
  }
  
  public ListPresenter(@NotNull ListContract.IListModel<BEAN> paramIListModel)
  {
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListModel = paramIListModel;
  }
  
  private final void a(List<? extends BEAN> paramList)
  {
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView;
      if (localIListView != null)
      {
        localIListView.setCenterHide();
        localIListView.setListData(paramList, false);
        localIListView.setFooterNoMore();
        localIListView.setHeaderLoading();
      }
      this.jdField_a_of_type_Boolean = true;
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
    if (this.jdField_a_of_type_Boolean)
    {
      ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView;
      if (localIListView != null) {
        localIListView.setHeaderError(paramInt, paramString);
      }
    }
    if (((((Collection)paramList).isEmpty() ^ true)) && (paramBoolean))
    {
      paramString = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView;
      if (paramString != null)
      {
        paramString.setCenterHide();
        paramString.setListData(paramList, false);
        paramString.setFooterNoMore();
      }
    }
    else if (!this.jdField_a_of_type_Boolean)
    {
      paramList = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView;
      if (paramList != null) {
        paramList.setCenterError(paramInt, paramString);
      }
      paramList = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView;
      if (paramList != null) {
        paramList.setTotal(0);
      }
    }
  }
  
  private final void b(int paramInt, List<? extends BEAN> paramList)
  {
    ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView;
    if (localIListView != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        localIListView.setHeaderSuccess();
      }
      a(paramInt, paramList);
    }
  }
  
  @NotNull
  public final ListContract.IListModel<BEAN> a()
  {
    return this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListModel;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView = ((ListContract.IListView)null);
  }
  
  public void a(int paramInt, @NotNull List<? extends BEAN> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView;
    if (localIListView != null)
    {
      localIListView.setTotal(paramInt);
      localIListView.setListData(paramList, false);
      if ((((Collection)paramList).isEmpty() ^ true))
      {
        localIListView.setCenterHide();
        if (this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListModel.a())
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
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView = paramVIEW;
  }
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (this.b) {
      return;
    }
    this.b = true;
    Object localObject = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView;
    if (localObject != null) {
      ((ListContract.IListView)localObject).setCenterLoading();
    }
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListModel;
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
    if (!this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListModel.a())
    {
      localIListView = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView;
      if (localIListView != null) {
        localIListView.setFooterNoMore();
      }
      return;
    }
    if (this.b) {
      return;
    }
    this.b = true;
    ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListView;
    if (localIListView != null) {
      localIListView.setFooterLoading();
    }
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkMvpListContract$IListModel.a((Function4)new ListPresenter.loadNextPage.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.mvp.ListPresenter
 * JD-Core Version:    0.7.0.1
 */