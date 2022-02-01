package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;

class ExpandCampusNewFragment$1
  extends ExpandObserver
{
  ExpandCampusNewFragment$1(ExpandCampusNewFragment paramExpandCampusNewFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusNewFragment", 2, String.format("onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandCampusNewFragment.1
 * JD-Core Version:    0.7.0.1
 */