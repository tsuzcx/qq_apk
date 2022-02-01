package com.tencent.mobileqq.extendfriend.fragment;

import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendCampusFragment$1
  extends ExtendFriendObserver
{
  ExtendFriendCampusFragment$1(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  public void onUpdateCampusCertificateStatus(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusFragment", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment.1
 * JD-Core Version:    0.7.0.1
 */