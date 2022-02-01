package com.tencent.mobileqq.troop.redpoint.troopsettingredpoint;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.redpoint.RedPointInfo;
import com.tencent.mobileqq.troop.redpoint.RedPointInfoManager;
import com.tencent.mobileqq.troop.redpoint.RedPointItem;
import com.tencent.mobileqq.troop.redpoint.RedPointUtils;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;

public class TroopMgrAppProcessor
  extends AbsBaseProcessor
{
  public TroopMgrAppProcessor(QQAppInterface paramQQAppInterface, String paramString)
  {
    super(paramQQAppInterface, paramString);
  }
  
  public String a()
  {
    return "TroopMgrAppProcessor";
  }
  
  public void a()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
    if ((localTroopInfo == null) || (!localTroopInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
      RedPointUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "troop", 5, 0);
    }
  }
  
  public void b()
  {
    Object localObject = ((RedPointInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.RED_POINT_INFO_MANAGER)).a(this.jdField_a_of_type_JavaLangString, "troop");
    if (localObject != null)
    {
      localObject = ((RedPointInfo)localObject).a(5);
      if ((localObject != null) && (((RedPointItem)localObject).unReadNum != 0))
      {
        RedPointUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, "troop", 5, 0);
        TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, 101913298);
      }
    }
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.TroopMgrAppProcessor
 * JD-Core Version:    0.7.0.1
 */