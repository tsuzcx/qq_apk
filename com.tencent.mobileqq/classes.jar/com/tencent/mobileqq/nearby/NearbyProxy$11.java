package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class NearbyProxy$11
  extends MessageObserver
{
  NearbyProxy$11(NearbyProxy paramNearbyProxy) {}
  
  public void onInsertIntoBlackList(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (((Integer)paramArrayOfObject[0]).intValue() != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProxy", 2, "onInsertIntoBlackList from nearby");
    }
    if ((paramBoolean) && (paramArrayOfObject.length == 4))
    {
      ((Long)paramArrayOfObject[1]).longValue();
      String str = (String)paramArrayOfObject[2];
      int i = ((Integer)paramArrayOfObject[3]).intValue();
      NearbySPUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "blacklist_sequence", Integer.valueOf(i));
      paramArrayOfObject = new ArrayList();
      paramArrayOfObject.add(Long.valueOf(str));
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
      ((ShieldMsgManger)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).a(1001, paramArrayOfObject, 1);
      return;
    }
    NearbyProxy.a(this.a, 4115, new Object[] { Boolean.valueOf(false) });
  }
  
  public void onRemoveFromBlackList(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NearbyProxy", 2, "onRemoveFromBlackList from nearby");
    }
    if (paramBoolean)
    {
      ShieldMsgManger localShieldMsgManger = (ShieldMsgManger)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramString));
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppShieldListObserver);
      localShieldMsgManger.b(1001, localArrayList, 1);
      return;
    }
    NearbyProxy.a(this.a, 4116, new Object[] { Boolean.valueOf(false) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.11
 * JD-Core Version:    0.7.0.1
 */