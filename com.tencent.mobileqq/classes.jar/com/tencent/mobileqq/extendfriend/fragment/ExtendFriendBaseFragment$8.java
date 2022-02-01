package com.tencent.mobileqq.extendfriend.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendBaseFragment$8
  extends ExtendFriendObserver
{
  ExtendFriendBaseFragment$8(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  public void onGetStrangerInfo(boolean paramBoolean, StrangerInfo paramStrangerInfo, int paramInt)
  {
    if (paramInt != ExtendFriendBaseFragment.a(this.a)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramStrangerInfo == null));
      localObject = ((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    } while (localObject == null);
    ExtendFriendBaseFragment localExtendFriendBaseFragment = this.a;
    if (!TextUtils.isEmpty(paramStrangerInfo.mDeclaration)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localExtendFriendBaseFragment.jdField_a_of_type_Boolean = paramBoolean;
      this.a.b = ((Card)localObject).isShowCard;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, String.format("addMyFeed mProfileComplete=%s mShowCard=%s", new Object[] { Boolean.valueOf(this.a.jdField_a_of_type_Boolean), Boolean.valueOf(this.a.b) }));
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter == null) {
        break;
      }
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(0);
      paramStrangerInfo.mIsMyFeed = true;
      if ((localObject != null) && (TextUtils.equals(((StrangerInfo)localObject).mUin, paramStrangerInfo.mUin))) {
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.b(0);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(0, paramStrangerInfo);
      if (!TextUtils.isEmpty(paramStrangerInfo.mDeclaration)) {
        paramStrangerInfo.mDeclaration = paramStrangerInfo.mDeclaration.replace('\n', ' ').trim();
      }
      if ((!this.a.b) || (!this.a.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.b(0);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment.8
 * JD-Core Version:    0.7.0.1
 */