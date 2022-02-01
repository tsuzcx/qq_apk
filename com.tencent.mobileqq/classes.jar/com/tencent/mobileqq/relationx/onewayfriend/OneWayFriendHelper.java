package com.tencent.mobileqq.relationx.onewayfriend;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class OneWayFriendHelper
{
  private int jdField_a_of_type_Int;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OneWayFriendHelper.OneWayFriendListener jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper$OneWayFriendListener;
  private OneWayFriendObserver jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendObserver = new OneWayFriendHelper.1(this);
  private String jdField_a_of_type_JavaLangString;
  
  public OneWayFriendHelper(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHelper", 0, String.format("OneWayFriendHelper app=%s curType=%s friendUin=%s", new Object[] { paramQQAppInterface, Integer.valueOf(paramInt), paramString }));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendObserver);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OneWayFriendHelper", 0, String.format("notifyOneWayFriend friendUin=%s oneWayFriend=%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper$OneWayFriendListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper$OneWayFriendListener.a(paramString, paramBoolean);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    return (paramInt == 0) && (!paramQQAppInterface.b(paramString));
  }
  
  public void a()
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString))
    {
      OneWayFriendHandler localOneWayFriendHandler = (OneWayFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ONE_WAY_FRIEND_HANDLER);
      if (localOneWayFriendHandler != null) {
        localOneWayFriendHandler.a(Long.parseLong(this.jdField_a_of_type_JavaLangString));
      }
      return;
    }
    a(this.jdField_a_of_type_JavaLangString, false);
  }
  
  public void a(OneWayFriendHelper.OneWayFriendListener paramOneWayFriendListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper$OneWayFriendListener = paramOneWayFriendListener;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendHelper$OneWayFriendListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqRelationxOnewayfriendOneWayFriendObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper
 * JD-Core Version:    0.7.0.1
 */