package com.tencent.mobileqq.tofumsg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class AIOTofuMsgHelper
  implements ILifeCycleHelper
{
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TofuManager jdField_a_of_type_ComTencentMobileqqTofumsgTofuManager;
  private String jdField_a_of_type_JavaLangString;
  
  public AIOTofuMsgHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public String getTag()
  {
    return "Tofu_AIOTofuMsgHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 14, 8 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      ThreadManager.executeOnSubThread(new AIOTofuMsgHelper.1(this));
      return;
      QLog.i("Tofu_AIOTofuMsgHelper", 1, "onMoveToState show_first.");
      if (this.jdField_a_of_type_ComTencentMobileqqTofumsgTofuManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqTofumsgTofuManager = ((TofuManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TOFUMSG_MANAGER));
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    } while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!((FriendsManager)localObject).b(this.jdField_a_of_type_JavaLangString)));
    boolean bool = ((NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a(this.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTofumsgTofuManager;
    String str = this.jdField_a_of_type_JavaLangString;
    if (bool) {}
    for (paramInt = 1;; paramInt = 0)
    {
      ((TofuManager)localObject).a(str, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tofumsg.AIOTofuMsgHelper
 * JD-Core Version:    0.7.0.1
 */