package com.tencent.tkd.topicsdk.mvp;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mvp/ListPresenter;", "BEAN", "VIEW", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListPresenter;", "model", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListModel;", "(Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListModel;)V", "mIsUsedCacheData", "", "mView", "getModel", "()Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListModel;", "setModel", "total", "", "getTotal", "()I", "attachView", "", "view", "(Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;)V", "detachView", "handleLoadFirstPageError", "isCacheData", "list", "", "errorCode", "errorMsg", "", "handleLoadFirstPageSuccess", "handleLoadFirstPageSuccessNotCacheData", "handleLoadFirstPageSuccessWithCacheData", "loadFirstPage", "needCache", "(Ljava/lang/Boolean;)V", "loadNextPage", "refreshPage", "updateModel", "updateView", "Companion", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public class ListPresenter<BEAN, VIEW extends ListContract.IListView<BEAN>>
  implements ListContract.IListPresenter<BEAN, VIEW>
{
  public static final ListPresenter.Companion a;
  @NotNull
  private ListContract.IListModel<BEAN> jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListModel;
  private ListContract.IListView<BEAN> jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkMvpListPresenter$Companion = new ListPresenter.Companion(null);
  }
  
  public ListPresenter(@NotNull ListContract.IListModel<BEAN> paramIListModel)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListModel = paramIListModel;
  }
  
  private final void a(List<? extends BEAN> paramList)
  {
    if (!((Collection)paramList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView;
        if (localIListView != null)
        {
          localIListView.setCenterHide();
          localIListView.setListData(paramList, false);
          localIListView.setFooterNoMore();
          localIListView.setHeaderLoading();
        }
        this.jdField_a_of_type_Boolean = true;
      }
      return;
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
      ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView;
      if (localIListView != null) {
        localIListView.setHeaderError(paramInt, paramString);
      }
    }
    int i;
    if (!((Collection)paramList).isEmpty())
    {
      i = 1;
      if ((i == 0) || (!paramBoolean)) {
        break label93;
      }
      paramString = this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView;
      if (paramString != null)
      {
        paramString.setCenterHide();
        paramString.setListData(paramList, false);
        paramString.setFooterNoMore();
      }
    }
    label93:
    do
    {
      do
      {
        return;
        i = 0;
        break;
      } while (this.jdField_a_of_type_Boolean);
      paramList = this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView;
      if (paramList != null) {
        paramList.setCenterError(paramInt, paramString);
      }
      paramList = this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView;
    } while (paramList == null);
    paramList.setTotal(0);
  }
  
  private final void b(int paramInt, List<? extends BEAN> paramList)
  {
    ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView;
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
    return this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListModel;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView = ((ListContract.IListView)null);
  }
  
  public void a(int paramInt, @NotNull List<? extends BEAN> paramList)
  {
    int i = 0;
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView;
    if (localIListView != null)
    {
      localIListView.setTotal(paramInt);
      localIListView.setListData(paramList, false);
      paramInt = i;
      if (!((Collection)paramList).isEmpty()) {
        paramInt = 1;
      }
      if (paramInt == 0) {
        break label93;
      }
      localIListView.setCenterHide();
      if (!this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListModel.a()) {
        break label83;
      }
      localIListView.setFooterHasMore();
    }
    for (;;)
    {
      return;
      label83:
      localIListView.setFooterNoMore();
      continue;
      label93:
      localIListView.setCenterEmpty();
      localIListView.setFooterHide();
    }
  }
  
  public void a(@NotNull VIEW paramVIEW)
  {
    Intrinsics.checkParameterIsNotNull(paramVIEW, "view");
    this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView = paramVIEW;
  }
  
  public void a(@Nullable Boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView;
    if (localObject != null) {
      ((ListContract.IListView)localObject).setCenterLoading();
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListModel;
    if (paramBoolean != null) {}
    for (boolean bool = paramBoolean.booleanValue();; bool = false)
    {
      ((ListContract.IListModel)localObject).a(bool, (Function6)new ListPresenter.loadFirstPage.1(this));
      return;
    }
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListModel.a())
    {
      localIListView = this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView;
      if (localIListView != null) {
        localIListView.setFooterNoMore();
      }
      return;
    }
    ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListView;
    if (localIListView != null) {
      localIListView.setFooterLoading();
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkMvpListContract$IListModel.a((Function4)new ListPresenter.loadNextPage.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.ListPresenter
 * JD-Core Version:    0.7.0.1
 */