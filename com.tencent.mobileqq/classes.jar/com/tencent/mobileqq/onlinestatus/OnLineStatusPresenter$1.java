package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;

class OnLineStatusPresenter$1
  implements Runnable
{
  OnLineStatusPresenter$1(OnLineStatusPresenter paramOnLineStatusPresenter, FriendsManager paramFriendsManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    this.this$0.a("FriendsEntityNotLoad", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusPresenter.1
 * JD-Core Version:    0.7.0.1
 */