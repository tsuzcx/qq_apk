package com.tencent.mobileqq.extendfriend;

import com.tencent.mobileqq.extendfriend.utils.ExtendFriendGetLocationListener;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendManager$11
  extends LbsManagerServiceOnLocationChangeListener
{
  ExtendFriendManager$11(ExtendFriendManager paramExtendFriendManager, String paramString, boolean paramBoolean, ExtendFriendGetLocationListener paramExtendFriendGetLocationListener)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendManager", 2, "getExtendFriendLocationInfoAsync onLocationFinish " + paramInt);
    }
    ExtendFriendManager localExtendFriendManager;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendGetLocationListener != null)
    {
      localExtendFriendManager = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager;
      if (paramInt != 0) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      ExtendFriendManager.a(localExtendFriendManager, bool, paramSosoLbsInfo, this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendGetLocationListener);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendManager.11
 * JD-Core Version:    0.7.0.1
 */