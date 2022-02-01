package com.tencent.mobileqq.kandian.base.mvp;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

class ListModel$3
  implements ListModel.LoadDataFromNetworkCallback<BEAN, COOKIE>
{
  ListModel$3(ListModel paramListModel, ListContract.NextPageCallback paramNextPageCallback) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListModel.a.addAll(paramArrayList);
    if (paramBoolean1)
    {
      ListModel.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListModel, paramCOOKIE);
      ListModel.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListModel, paramBoolean2 ^ true);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListContract$NextPageCallback.a(paramBoolean1, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListModel.a, paramInt2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.mvp.ListModel.3
 * JD-Core Version:    0.7.0.1
 */