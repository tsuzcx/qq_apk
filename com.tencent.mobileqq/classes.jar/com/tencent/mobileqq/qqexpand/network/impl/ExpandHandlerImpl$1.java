package com.tencent.mobileqq.qqexpand.network.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

class ExpandHandlerImpl$1
  implements BusinessObserver
{
  ExpandHandlerImpl$1(ExpandHandlerImpl paramExpandHandlerImpl, String paramString, int paramInt1, int paramInt2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      paramObject = (FriendsManager)ExpandHandlerImpl.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkImplExpandHandlerImpl).getManager(QQManagerFactory.FRIENDS_MANAGER);
      Card localCard = paramObject.b(this.jdField_a_of_type_JavaLangString);
      localCard.clothesId = this.jdField_a_of_type_Int;
      localCard.fontId = this.b;
      localCard.updateTime = NetConnInfoCenter.getServerTimeMillis();
      paramObject.a(localCard);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkImplExpandHandlerImpl.notifyUI(1, paramBoolean, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl.1
 * JD-Core Version:    0.7.0.1
 */