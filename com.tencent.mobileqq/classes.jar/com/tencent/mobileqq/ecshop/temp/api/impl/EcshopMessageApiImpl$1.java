package com.tencent.mobileqq.ecshop.temp.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;

class EcshopMessageApiImpl$1
  implements Runnable
{
  EcshopMessageApiImpl$1(EcshopMessageApiImpl paramEcshopMessageApiImpl, BaseQQAppInterface paramBaseQQAppInterface, String paramString) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnonnull +36 -> 42
    //   9: aload_0
    //   10: getfield 17	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +26 -> 41
    //   18: aload_2
    //   19: ldc 28
    //   21: invokevirtual 34	com/tencent/common/app/business/BaseQQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   24: checkcast 28	com/tencent/mobileqq/msg/api/IConversationFacade
    //   27: aload_0
    //   28: getfield 19	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: sipush 1008
    //   34: lconst_0
    //   35: iconst_0
    //   36: invokeinterface 38 6 0
    //   41: return
    //   42: aload_0
    //   43: getfield 17	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   46: ldc 28
    //   48: invokevirtual 34	com/tencent/common/app/business/BaseQQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   51: checkcast 28	com/tencent/mobileqq/msg/api/IConversationFacade
    //   54: aload_0
    //   55: getfield 19	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   58: sipush 1008
    //   61: invokeinterface 42 3 0
    //   66: istore_1
    //   67: iload_1
    //   68: ifne +36 -> 104
    //   71: aload_0
    //   72: getfield 17	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +26 -> 103
    //   80: aload_2
    //   81: ldc 28
    //   83: invokevirtual 34	com/tencent/common/app/business/BaseQQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   86: checkcast 28	com/tencent/mobileqq/msg/api/IConversationFacade
    //   89: aload_0
    //   90: getfield 19	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   93: sipush 1008
    //   96: lconst_0
    //   97: iconst_0
    //   98: invokeinterface 38 6 0
    //   103: return
    //   104: aload_0
    //   105: getfield 17	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   108: ldc 44
    //   110: invokevirtual 34	com/tencent/common/app/business/BaseQQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   113: checkcast 44	com/tencent/mobileqq/msg/api/IMessageFacade
    //   116: aload_0
    //   117: getfield 19	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   120: sipush 1008
    //   123: invokeinterface 48 3 0
    //   128: astore_2
    //   129: aload_2
    //   130: invokestatic 54	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl:access$000	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/structmsg/AbsStructMsgElement;
    //   133: astore_3
    //   134: aload_3
    //   135: ifnull +42 -> 177
    //   138: aload_3
    //   139: getfield 60	com/tencent/mobileqq/structmsg/AbsStructMsgElement:c	I
    //   142: bipush 100
    //   144: if_icmpeq +33 -> 177
    //   147: aload_0
    //   148: getfield 15	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:this$0	Lcom/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl;
    //   151: aload_2
    //   152: invokevirtual 64	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl:getAdInfoByChatMessage	(Lcom/tencent/mobileqq/data/MessageRecord;)Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;
    //   155: astore_2
    //   156: aload_2
    //   157: ifnull +83 -> 240
    //   160: invokestatic 69	com/tencent/gdtad/aditem/GdtPreLoader:a	()Lcom/tencent/gdtad/aditem/GdtPreLoader;
    //   163: new 71	com/tencent/gdtad/aditem/GdtAd
    //   166: dup
    //   167: aload_2
    //   168: invokespecial 74	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   171: invokevirtual 77	com/tencent/gdtad/aditem/GdtPreLoader:a	(Lcom/tencent/gdtad/aditem/GdtAd;)V
    //   174: goto +66 -> 240
    //   177: aload_2
    //   178: instanceof 79
    //   181: ifeq +59 -> 240
    //   184: aload_0
    //   185: getfield 15	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:this$0	Lcom/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl;
    //   188: aload_2
    //   189: invokevirtual 83	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl:getSourceAdFromArk	(Lcom/tencent/mobileqq/data/MessageRecord;)Lorg/json/JSONObject;
    //   192: astore_3
    //   193: aload_3
    //   194: ifnull +46 -> 240
    //   197: iconst_1
    //   198: invokestatic 89	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   201: aload_3
    //   202: ldc 91
    //   204: invokevirtual 97	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   207: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   210: ifeq +30 -> 240
    //   213: aload_0
    //   214: getfield 15	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:this$0	Lcom/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl;
    //   217: aload_2
    //   218: invokevirtual 64	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl:getAdInfoByChatMessage	(Lcom/tencent/mobileqq/data/MessageRecord;)Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;
    //   221: astore_2
    //   222: aload_2
    //   223: ifnull +17 -> 240
    //   226: invokestatic 69	com/tencent/gdtad/aditem/GdtPreLoader:a	()Lcom/tencent/gdtad/aditem/GdtPreLoader;
    //   229: new 71	com/tencent/gdtad/aditem/GdtAd
    //   232: dup
    //   233: aload_2
    //   234: invokespecial 74	com/tencent/gdtad/aditem/GdtAd:<init>	(Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;)V
    //   237: invokevirtual 77	com/tencent/gdtad/aditem/GdtPreLoader:a	(Lcom/tencent/gdtad/aditem/GdtAd;)V
    //   240: aload_0
    //   241: getfield 17	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   244: astore_2
    //   245: aload_2
    //   246: ifnull +53 -> 299
    //   249: goto +27 -> 276
    //   252: astore_2
    //   253: goto +47 -> 300
    //   256: astore_2
    //   257: ldc 103
    //   259: iconst_1
    //   260: aload_2
    //   261: invokestatic 109	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   264: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aload_0
    //   268: getfield 17	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   271: astore_2
    //   272: aload_2
    //   273: ifnull +26 -> 299
    //   276: aload_2
    //   277: ldc 28
    //   279: invokevirtual 34	com/tencent/common/app/business/BaseQQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   282: checkcast 28	com/tencent/mobileqq/msg/api/IConversationFacade
    //   285: aload_0
    //   286: getfield 19	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   289: sipush 1008
    //   292: lconst_0
    //   293: iconst_0
    //   294: invokeinterface 38 6 0
    //   299: return
    //   300: aload_0
    //   301: getfield 17	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   304: astore_3
    //   305: aload_3
    //   306: ifnull +26 -> 332
    //   309: aload_3
    //   310: ldc 28
    //   312: invokevirtual 34	com/tencent/common/app/business/BaseQQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   315: checkcast 28	com/tencent/mobileqq/msg/api/IConversationFacade
    //   318: aload_0
    //   319: getfield 19	com/tencent/mobileqq/ecshop/temp/api/impl/EcshopMessageApiImpl$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   322: sipush 1008
    //   325: lconst_0
    //   326: iconst_0
    //   327: invokeinterface 38 6 0
    //   332: aload_2
    //   333: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	1
    //   66	2	1	i	int
    //   4	242	2	localObject1	Object
    //   252	1	2	localObject2	Object
    //   256	5	2	localThrowable	java.lang.Throwable
    //   271	62	2	localBaseQQAppInterface	BaseQQAppInterface
    //   133	177	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	5	252	finally
    //   42	67	252	finally
    //   104	134	252	finally
    //   138	156	252	finally
    //   160	174	252	finally
    //   177	193	252	finally
    //   197	222	252	finally
    //   226	240	252	finally
    //   257	267	252	finally
    //   0	5	256	java/lang/Throwable
    //   42	67	256	java/lang/Throwable
    //   104	134	256	java/lang/Throwable
    //   138	156	256	java/lang/Throwable
    //   160	174	256	java/lang/Throwable
    //   177	193	256	java/lang/Throwable
    //   197	222	256	java/lang/Throwable
    //   226	240	256	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.temp.api.impl.EcshopMessageApiImpl.1
 * JD-Core Version:    0.7.0.1
 */