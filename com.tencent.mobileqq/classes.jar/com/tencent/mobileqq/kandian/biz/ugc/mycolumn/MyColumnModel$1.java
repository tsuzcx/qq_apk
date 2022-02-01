package com.tencent.mobileqq.kandian.biz.ugc.mycolumn;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.kandian.base.mvp.ListModel.LoadDataFromNetworkCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MyColumnModel$1
  extends ProtoUtils.TroopProtocolObserver
{
  MyColumnModel$1(MyColumnModel paramMyColumnModel, ListModel.LoadDataFromNetworkCallback paramLoadDataFromNetworkCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    MyColumnModel.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcMycolumnMyColumnModel, false);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      MyColumnModel.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcMycolumnMyColumnModel, this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListModel$LoadDataFromNetworkCallback, paramArrayOfByte, paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RIJUGC.MyColumnModel", 2, "loadDataFromNetwork failed.");
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseMvpListModel$LoadDataFromNetworkCallback.a(false, true, 0, new ArrayList(), null, paramInt, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.mycolumn.MyColumnModel.1
 * JD-Core Version:    0.7.0.1
 */