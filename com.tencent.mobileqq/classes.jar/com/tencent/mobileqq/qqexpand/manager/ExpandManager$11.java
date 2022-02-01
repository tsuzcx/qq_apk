package com.tencent.mobileqq.qqexpand.manager;

import com.tencent.mobileqq.qqexpand.utils.ExtendFriendGetLocationListener;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class ExpandManager$11
  extends LbsManagerServiceOnLocationChangeListener
{
  ExpandManager$11(ExpandManager paramExpandManager, String paramString, boolean paramBoolean, ExtendFriendGetLocationListener paramExtendFriendGetLocationListener)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getExtendFriendLocationInfoAsync onLocationFinish ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ExtendFriendManager", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsExtendFriendGetLocationListener != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExpandManager;
      boolean bool;
      if (paramInt == 0) {
        bool = true;
      } else {
        bool = false;
      }
      ExpandManager.a((ExpandManager)localObject, bool, paramSosoLbsInfo, this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsExtendFriendGetLocationListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.ExpandManager.11
 * JD-Core Version:    0.7.0.1
 */