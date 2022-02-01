package com.tencent.mobileqq.kandian.base.mvp;

import android.support.annotation.Nullable;
import java.util.List;

public class ListPresenter<BEAN, VIEW extends ListContract.IListView<BEAN>>
  implements ListContract.IListPresenter<BEAN, VIEW>
{
  private ListContract.IListModel<BEAN> jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListModel;
  private ListContract.IListView<BEAN> jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView = null;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ListPresenter(ListContract.IListModel<BEAN> paramIListModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListModel = paramIListModel;
  }
  
  private void a(List<BEAN> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView;
      if (localIListView != null)
      {
        localIListView.setCenterHide();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setListData(paramList, false);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setFooterNoMore();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setHeaderLoading();
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt, List<BEAN> paramList)
  {
    if (paramBoolean)
    {
      a(paramList);
      return;
    }
    b(paramInt, paramList);
  }
  
  private void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, @Nullable String paramString)
  {
    ListContract.IListView localIListView;
    if (this.jdField_a_of_type_Boolean)
    {
      localIListView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView;
      if (localIListView != null) {
        localIListView.setHeaderError(paramInt, paramString);
      }
    }
    if ((paramList != null) && (!paramList.isEmpty()) && (paramBoolean))
    {
      localIListView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView;
      if (localIListView != null)
      {
        localIListView.setCenterHide();
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setListData(paramList, false);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setFooterNoMore();
        return;
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      paramList = this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView;
      if (paramList != null)
      {
        paramList.setCenterError(paramInt, paramString);
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setTotal(0);
      }
    }
  }
  
  private void b(int paramInt, List<BEAN> paramList)
  {
    ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView;
    if (localIListView != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        localIListView.setHeaderSuccess();
      }
      a(paramInt, paramList);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView = null;
  }
  
  public void a(int paramInt, List<BEAN> paramList)
  {
    ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView;
    if (localIListView != null)
    {
      localIListView.setTotal(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setListData(paramList, false);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setCenterHide();
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListModel.a())
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setFooterHasMore();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setFooterNoMore();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setCenterEmpty();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView.setFooterHide();
    }
  }
  
  public void a(VIEW paramVIEW)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView = paramVIEW;
  }
  
  public void b()
  {
    ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView;
    if (localIListView != null) {
      localIListView.setCenterLoading();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListModel.a(true, new ListPresenter.2(this));
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListModel.a())
    {
      localIListView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView;
      if (localIListView != null) {
        localIListView.setFooterNoMore();
      }
      return;
    }
    ListContract.IListView localIListView = this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListView;
    if (localIListView != null) {
      localIListView.setFooterLoading();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$IListModel.a(new ListPresenter.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.mvp.ListPresenter
 * JD-Core Version:    0.7.0.1
 */