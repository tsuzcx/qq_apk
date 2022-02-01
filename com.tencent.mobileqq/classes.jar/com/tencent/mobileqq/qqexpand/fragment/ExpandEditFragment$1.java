package com.tencent.mobileqq.qqexpand.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qqexpand.bean.profile.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ExpandEditFragment$1
  extends ExpandObserver
{
  ExpandEditFragment$1(ExpandEditFragment paramExpandEditFragment) {}
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendProfileEdit", 2, String.format("ExtendFriendEditFragment onUpdateCampusCertificateStatus isSuccess=%s scene=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt == 2) && (this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment != null))
    {
      IExpandManager localIExpandManager = (IExpandManager)ExpandEditFragment.a(this.a).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_a_of_type_Long = localIExpandManager.f();
      this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.b(this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo);
    }
  }
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    super.a(paramBoolean, paramCard);
    boolean bool = false;
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo = new ExtendFriendInfo(paramCard);
      paramCard = this.a;
      paramBoolean = bool;
      if (TextUtils.isEmpty(paramCard.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_a_of_type_JavaLangString))
      {
        paramBoolean = bool;
        if (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.b)) {
          paramBoolean = true;
        }
      }
      ExpandEditFragment.a(paramCard, paramBoolean);
      this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo);
    }
    else
    {
      QQToast.a(ExpandEditFragment.a(this.a), "获取扩列信息失败", 0).a();
    }
    ExpandEditFragment.a(this.a).dismiss();
  }
  
  protected void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    if (paramBoolean)
    {
      ExpandEditFragment.a(this.a).dismiss();
      ExpandEditFragment.a(this.a).setResult(8193);
      if (ExpandEditFragment.a(this.a) != null) {
        ExpandEditFragment.a(this.a).finish();
      }
    }
    else
    {
      ExpandEditFragment.a(this.a).dismiss();
    }
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Bundle)))
    {
      paramObject = (Bundle)paramObject;
      String str1 = paramObject.getString("name");
      String str2 = paramObject.getString("schoolid");
      int i = paramObject.getInt("category");
      int j = paramObject.getInt("idx");
      if ((this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment != null))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.d = str1;
        this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.c = str2;
        this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.h = i;
        this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.jdField_a_of_type_Long = -1L;
        this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo.g = j;
        this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandProfileEditFragment.b(this.a.jdField_a_of_type_ComTencentMobileqqQqexpandBeanProfileExtendFriendInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandEditFragment.1
 * JD-Core Version:    0.7.0.1
 */