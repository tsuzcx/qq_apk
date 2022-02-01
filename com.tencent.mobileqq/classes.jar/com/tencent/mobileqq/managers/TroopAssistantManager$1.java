package com.tencent.mobileqq.managers;

import com.tencent.mobileqq.app.QQAppInterface;

class TroopAssistantManager$1
  implements Runnable
{
  TroopAssistantManager$1(TroopAssistantManager paramTroopAssistantManager, QQAppInterface paramQQAppInterface) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	com/tencent/mobileqq/managers/TroopAssistantManager$1:this$0	Lcom/tencent/mobileqq/managers/TroopAssistantManager;
    //   4: getfield 28	com/tencent/mobileqq/managers/TroopAssistantManager:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   7: astore_3
    //   8: aload_3
    //   9: monitorenter
    //   10: aconst_null
    //   11: astore_2
    //   12: aload_2
    //   13: astore_1
    //   14: aload_0
    //   15: getfield 14	com/tencent/mobileqq/managers/TroopAssistantManager$1:this$0	Lcom/tencent/mobileqq/managers/TroopAssistantManager;
    //   18: getfield 31	com/tencent/mobileqq/managers/TroopAssistantManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   21: ifnull +63 -> 84
    //   24: aload_2
    //   25: astore_1
    //   26: aload_0
    //   27: getfield 14	com/tencent/mobileqq/managers/TroopAssistantManager$1:this$0	Lcom/tencent/mobileqq/managers/TroopAssistantManager;
    //   30: getfield 31	com/tencent/mobileqq/managers/TroopAssistantManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   33: invokeinterface 37 1 0
    //   38: ifle +46 -> 84
    //   41: aload_0
    //   42: getfield 14	com/tencent/mobileqq/managers/TroopAssistantManager$1:this$0	Lcom/tencent/mobileqq/managers/TroopAssistantManager;
    //   45: getfield 31	com/tencent/mobileqq/managers/TroopAssistantManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   48: invokeinterface 41 1 0
    //   53: astore_1
    //   54: goto +30 -> 84
    //   57: astore_1
    //   58: goto +68 -> 126
    //   61: astore 4
    //   63: aload_2
    //   64: astore_1
    //   65: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +16 -> 84
    //   71: ldc 49
    //   73: iconst_2
    //   74: aload 4
    //   76: invokevirtual 53	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   79: invokestatic 57	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload_2
    //   83: astore_1
    //   84: aload_3
    //   85: monitorexit
    //   86: aload_1
    //   87: ifnull +38 -> 125
    //   90: aload_0
    //   91: getfield 16	com/tencent/mobileqq/managers/TroopAssistantManager$1:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   94: invokevirtual 63	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   97: aload_0
    //   98: getfield 16	com/tencent/mobileqq/managers/TroopAssistantManager$1:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   101: invokevirtual 66	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   104: iconst_0
    //   105: invokevirtual 72	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   108: invokeinterface 78 1 0
    //   113: ldc 80
    //   115: aload_1
    //   116: invokestatic 85	com/tencent/mobileqq/utils/SharedPreferencesHandler:a	(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;[Ljava/lang/Object;)Landroid/content/SharedPreferences$Editor;
    //   119: invokeinterface 90 1 0
    //   124: pop
    //   125: return
    //   126: aload_3
    //   127: monitorexit
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	1
    //   13	41	1	localObject1	Object
    //   57	1	1	localObject2	Object
    //   64	65	1	localObject3	Object
    //   11	72	2	localObject4	Object
    //   7	120	3	localObject5	Object
    //   61	14	4	localIllegalArgumentException	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   14	24	57	finally
    //   26	54	57	finally
    //   65	82	57	finally
    //   84	86	57	finally
    //   126	128	57	finally
    //   14	24	61	java/lang/IllegalArgumentException
    //   26	54	61	java/lang/IllegalArgumentException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.TroopAssistantManager.1
 * JD-Core Version:    0.7.0.1
 */