package com.tencent.mobileqq.extendfriend.network;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class ExtendFriendHandler$1
  implements BusinessObserver
{
  ExtendFriendHandler$1(ExtendFriendHandler paramExtendFriendHandler, String paramString, int paramInt1, int paramInt2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (FriendsManager)ExtendFriendHandler.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendHandler).getManager(QQManagerFactory.FRIENDS_MANAGER);
      Card localCard = paramObject.b(this.jdField_a_of_type_JavaLangString);
      localCard.clothesId = this.jdField_a_of_type_Int;
      localCard.fontId = this.b;
      localCard.updateTime = NetConnInfoCenter.getServerTimeMillis();
      paramObject.a(localCard);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendHandler.notifyUI(1, paramBoolean, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler.1
 * JD-Core Version:    0.7.0.1
 */