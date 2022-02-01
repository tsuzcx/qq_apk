package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendEditFragment$9
  extends ExtendFriendObserver
{
  ExtendFriendEditFragment$9(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  public void onEditExtendFriendInfo(boolean paramBoolean)
  {
    super.onEditExtendFriendInfo(paramBoolean);
    if (paramBoolean)
    {
      ExtendFriendEditFragment.a(this.a).dismiss();
      ExtendFriendEditFragment.a(this.a).setResult(8193);
      if (ExtendFriendEditFragment.a(this.a) != null) {
        ExtendFriendEditFragment.a(this.a).finish();
      }
      return;
    }
    ExtendFriendEditFragment.a(this.a).dismiss();
  }
  
  public void onGetExtendFriendInfo(boolean paramBoolean, Card paramCard)
  {
    super.onGetExtendFriendInfo(paramBoolean, paramCard);
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo = new ExtendFriendProfileEditFragment.ExtendFriendInfo(paramCard);
      if ((TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_a_of_type_JavaLangString)) && (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.b)))
      {
        ExtendFriendEditFragment.a(this.a, true);
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo);
      }
    }
    for (;;)
    {
      ExtendFriendEditFragment.a(this.a).dismiss();
      return;
      ExtendFriendEditFragment.a(this.a, false);
      break;
      QQToast.a(ExtendFriendEditFragment.a(this.a), "获取扩列信息失败", 0).a();
    }
  }
  
  public void onGetStrangerInfo(boolean paramBoolean, StrangerInfo paramStrangerInfo, int paramInt)
  {
    if ((paramBoolean) && (paramStrangerInfo != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.a(ExtendFriendEditFragment.a(this.a).app, paramStrangerInfo);
    }
  }
  
  public void onUpdateCampusCertificateStatus(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendProfileEdit", 2, String.format("ExtendFriendEditFragment onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 2) && (this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null))
    {
      ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)this.a.getActivity().app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_a_of_type_Long = localExtendFriendManager.f();
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.b(this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo);
    }
  }
  
  public void onUpdateExtendFriendCampusSchoolInfo(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Bundle)))
    {
      paramObject = (Bundle)paramObject;
      String str1 = paramObject.getString("name");
      String str2 = paramObject.getString("schoolid");
      int i = paramObject.getInt("category");
      int j = paramObject.getInt("idx");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment != null))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.d = str1;
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.c = str2;
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.h = i;
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.jdField_a_of_type_Long = -1L;
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.g = j;
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.b(this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment.9
 * JD-Core Version:    0.7.0.1
 */