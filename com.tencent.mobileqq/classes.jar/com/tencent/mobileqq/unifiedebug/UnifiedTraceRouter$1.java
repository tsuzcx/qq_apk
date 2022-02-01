package com.tencent.mobileqq.unifiedebug;

import java.util.Map;

class UnifiedTraceRouter$1
  implements Runnable
{
  UnifiedTraceRouter$1(UnifiedTraceRouter paramUnifiedTraceRouter, String paramString, long paramLong, Map paramMap) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   4: aload_0
    //   5: getfield 18	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokevirtual 36	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:a	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_3
    //   12: new 38	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   25: astore 5
    //   27: aload 5
    //   29: aload 4
    //   31: aload 5
    //   33: getfield 42	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   36: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_3
    //   40: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 48
    //   45: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: putfield 42	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: aload_0
    //   55: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   58: getfield 55	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_Float	F
    //   61: fstore_2
    //   62: aload_3
    //   63: ldc 57
    //   65: invokevirtual 63	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   68: ifeq +14 -> 82
    //   71: fload_2
    //   72: fstore_1
    //   73: aload_3
    //   74: ldc 65
    //   76: invokevirtual 63	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   79: ifeq +43 -> 122
    //   82: fload_2
    //   83: fstore_1
    //   84: aload_0
    //   85: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   88: getfield 68	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   91: bipush 32
    //   93: if_icmpne +29 -> 122
    //   96: aload_0
    //   97: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   100: aload_3
    //   101: invokevirtual 71	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:d	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 4
    //   106: fload_2
    //   107: fstore_1
    //   108: aload 4
    //   110: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne +9 -> 122
    //   116: aload 4
    //   118: invokestatic 82	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   121: fstore_1
    //   122: new 84	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo
    //   125: dup
    //   126: aload_0
    //   127: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   130: aload_0
    //   131: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   134: aload_3
    //   135: invokevirtual 86	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:b	(Ljava/lang/String;)Ljava/lang/String;
    //   138: fload_1
    //   139: invokespecial 89	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:<init>	(Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;Ljava/lang/String;F)V
    //   142: astore 4
    //   144: aload 4
    //   146: aload_0
    //   147: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   150: getfield 68	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   153: putfield 91	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_a_of_type_Int	I
    //   156: aload 4
    //   158: aload 4
    //   160: getfield 92	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   163: invokestatic 98	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   166: invokevirtual 101	java/net/InetAddress:getHostName	()Ljava/lang/String;
    //   169: putfield 102	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   172: aload_0
    //   173: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   176: getfield 105	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   179: aload 4
    //   181: invokeinterface 111 2 0
    //   186: pop
    //   187: aload_3
    //   188: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   191: ifne +100 -> 291
    //   194: aload_0
    //   195: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   198: getfield 105	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   201: aload_0
    //   202: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   205: getfield 105	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   208: invokeinterface 115 1 0
    //   213: iconst_1
    //   214: isub
    //   215: invokeinterface 119 2 0
    //   220: checkcast 84	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo
    //   223: astore_3
    //   224: aload_3
    //   225: getfield 92	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   228: aload_0
    //   229: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   232: getfield 120	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   235: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifeq +340 -> 578
    //   241: aload_0
    //   242: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   245: getfield 68	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   248: bipush 32
    //   250: if_icmpge +133 -> 383
    //   253: aload_0
    //   254: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   257: bipush 32
    //   259: putfield 68	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   262: aload_0
    //   263: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   266: getfield 105	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   269: aload_3
    //   270: invokeinterface 126 2 0
    //   275: pop
    //   276: aload_0
    //   277: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   280: getfield 129	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   283: aload_0
    //   284: ldc2_w 130
    //   287: invokevirtual 137	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   290: pop
    //   291: return
    //   292: astore_3
    //   293: ldc 139
    //   295: iconst_1
    //   296: new 38	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   303: ldc 141
    //   305: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_3
    //   309: invokevirtual 144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   312: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload_0
    //   322: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   325: getfield 153	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   328: getstatic 158	com/tencent/mobileqq/app/QQManagerFactory:SEC_SPY_FILEMANAGER	I
    //   331: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   334: checkcast 166	com/tencent/mobileqq/secspy/SecSpyFileManager
    //   337: aload_0
    //   338: getfield 20	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:jdField_a_of_type_Long	J
    //   341: aload_3
    //   342: invokevirtual 144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   345: invokevirtual 169	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JLjava/lang/String;)V
    //   348: return
    //   349: astore 5
    //   351: ldc 139
    //   353: iconst_1
    //   354: new 38	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   361: ldc 171
    //   363: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 5
    //   368: invokevirtual 172	java/net/UnknownHostException:getMessage	()Ljava/lang/String;
    //   371: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: goto -208 -> 172
    //   383: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +112 -> 498
    //   389: aload_0
    //   390: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   393: getfield 105	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   396: invokeinterface 180 1 0
    //   401: astore_3
    //   402: aload_3
    //   403: invokeinterface 185 1 0
    //   408: ifeq +90 -> 498
    //   411: aload_3
    //   412: invokeinterface 189 1 0
    //   417: checkcast 84	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo
    //   420: astore 4
    //   422: ldc 139
    //   424: iconst_2
    //   425: new 38	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   432: ldc 191
    //   434: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload 4
    //   439: getfield 91	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_a_of_type_Int	I
    //   442: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc 196
    //   447: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 4
    //   452: getfield 102	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   455: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc 196
    //   460: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload 4
    //   465: getfield 92	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   468: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc 196
    //   473: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 4
    //   478: getfield 197	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$TraceRouteInfo:jdField_a_of_type_Float	F
    //   481: invokevirtual 200	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   484: ldc 202
    //   486: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: goto -93 -> 402
    //   498: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +16 -> 517
    //   504: ldc 139
    //   506: iconst_2
    //   507: aload_0
    //   508: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   511: getfield 42	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   514: invokestatic 204	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: aload_0
    //   518: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   521: getfield 153	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   524: getstatic 158	com/tencent/mobileqq/app/QQManagerFactory:SEC_SPY_FILEMANAGER	I
    //   527: invokevirtual 164	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   530: checkcast 166	com/tencent/mobileqq/secspy/SecSpyFileManager
    //   533: aload_0
    //   534: getfield 20	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:jdField_a_of_type_Long	J
    //   537: aload_0
    //   538: getfield 18	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   541: aload_0
    //   542: getfield 22	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   545: aload_0
    //   546: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   549: getfield 105	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   552: invokevirtual 207	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JLjava/lang/String;Ljava/util/Map;Ljava/util/List;)V
    //   555: aload_0
    //   556: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   559: iconst_1
    //   560: putfield 68	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   563: aload_0
    //   564: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   567: new 209	java/util/ArrayList
    //   570: dup
    //   571: invokespecial 210	java/util/ArrayList:<init>	()V
    //   574: putfield 105	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   577: return
    //   578: aload_0
    //   579: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   582: getfield 68	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   585: bipush 32
    //   587: if_icmpge -296 -> 291
    //   590: aload_0
    //   591: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   594: astore_3
    //   595: aload_3
    //   596: aload_3
    //   597: getfield 68	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   600: iconst_1
    //   601: iadd
    //   602: putfield 68	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_b_of_type_Int	I
    //   605: aload_0
    //   606: getfield 16	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter$1:this$0	Lcom/tencent/mobileqq/unifiedebug/UnifiedTraceRouter;
    //   609: getfield 129	com/tencent/mobileqq/unifiedebug/UnifiedTraceRouter:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   612: aload_0
    //   613: ldc2_w 130
    //   616: invokevirtual 137	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   619: pop
    //   620: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	this	1
    //   72	67	1	f1	float
    //   61	46	2	f2	float
    //   11	259	3	localObject1	Object
    //   292	50	3	localException	java.lang.Exception
    //   401	196	3	localObject2	Object
    //   19	458	4	localObject3	Object
    //   25	7	5	localUnifiedTraceRouter	UnifiedTraceRouter
    //   349	18	5	localUnknownHostException	java.net.UnknownHostException
    // Exception table:
    //   from	to	target	type
    //   0	54	292	java/lang/Exception
    //   156	172	349	java/net/UnknownHostException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.UnifiedTraceRouter.1
 * JD-Core Version:    0.7.0.1
 */