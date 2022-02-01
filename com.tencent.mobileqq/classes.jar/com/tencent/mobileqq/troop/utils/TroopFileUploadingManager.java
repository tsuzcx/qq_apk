package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopFileUploadingManager
{
  public static TroopFileUploadingManager a;
  public BizTroopObserver a;
  public QQAppInterface a;
  
  public TroopFileUploadingManager()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopFileUploadingManager.1(this);
  }
  
  /* Error */
  public static TroopFileUploadingManager a(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 23	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager	Lcom/tencent/mobileqq/troop/utils/TroopFileUploadingManager;
    //   6: ifnonnull +16 -> 22
    //   9: aload_0
    //   10: invokestatic 27	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   13: getstatic 23	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager	Lcom/tencent/mobileqq/troop/utils/TroopFileUploadingManager;
    //   16: astore_0
    //   17: ldc 2
    //   19: monitorexit
    //   20: aload_0
    //   21: areturn
    //   22: getstatic 23	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager	Lcom/tencent/mobileqq/troop/utils/TroopFileUploadingManager;
    //   25: getfield 29	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   28: aload_0
    //   29: if_acmpeq -16 -> 13
    //   32: getstatic 23	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager	Lcom/tencent/mobileqq/troop/utils/TroopFileUploadingManager;
    //   35: getfield 29	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   38: ifnull +25 -> 63
    //   41: getstatic 23	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager	Lcom/tencent/mobileqq/troop/utils/TroopFileUploadingManager;
    //   44: getfield 29	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   47: getstatic 23	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager	Lcom/tencent/mobileqq/troop/utils/TroopFileUploadingManager;
    //   50: getfield 19	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver	Lcom/tencent/mobileqq/app/BizTroopObserver;
    //   53: invokevirtual 35	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   56: getstatic 23	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager	Lcom/tencent/mobileqq/troop/utils/TroopFileUploadingManager;
    //   59: aconst_null
    //   60: putfield 29	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: aconst_null
    //   64: putstatic 23	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager	Lcom/tencent/mobileqq/troop/utils/TroopFileUploadingManager;
    //   67: aload_0
    //   68: invokestatic 27	com/tencent/mobileqq/troop/utils/TroopFileUploadingManager:b	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   71: goto -58 -> 13
    //   74: astore_0
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_0
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   3	13	74	finally
    //   13	17	74	finally
    //   22	63	74	finally
    //   63	71	74	finally
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager != null)
    {
      paramQQAppInterface.removeObserver(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = new TroopFileUploadingManager();
    jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileUploadingManager
 * JD-Core Version:    0.7.0.1
 */