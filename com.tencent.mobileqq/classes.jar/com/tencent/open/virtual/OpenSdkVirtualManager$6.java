package com.tencent.open.virtual;

import android.app.Activity;
import com.tencent.open.agent.authority.AuthCallback;
import com.tencent.open.model.AccountInfo;
import java.util.List;
import mqq.observer.BusinessObserver;

class OpenSdkVirtualManager$6
  implements BusinessObserver
{
  OpenSdkVirtualManager$6(OpenSdkVirtualManager paramOpenSdkVirtualManager, long paramLong1, AccountInfo paramAccountInfo, String paramString1, boolean paramBoolean1, String paramString2, List paramList, long paramLong2, AuthCallback paramAuthCallback, String paramString3, Activity paramActivity, boolean paramBoolean2, String paramString4) {}
  
  /* Error */
  public void onReceive(int paramInt, boolean paramBoolean, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 60	java/lang/System:currentTimeMillis	()J
    //   3: aload_0
    //   4: getfield 24	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_Long	J
    //   7: lsub
    //   8: lstore 10
    //   10: aload_3
    //   11: ldc 62
    //   13: invokevirtual 68	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 16
    //   18: ldc 70
    //   20: iconst_1
    //   21: new 72	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   28: ldc 75
    //   30: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload 16
    //   35: invokestatic 83	com/tencent/open/agent/util/AuthorityUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   38: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 85
    //   43: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   50: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   53: invokestatic 83	com/tencent/open/agent/util/AuthorityUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 90
    //   61: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: lload 10
    //   66: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_3
    //   76: ldc 104
    //   78: invokevirtual 108	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   81: istore 7
    //   83: aload_0
    //   84: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   87: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   90: aload 16
    //   92: invokevirtual 114	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifne +154 -> 249
    //   98: aload_0
    //   99: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   102: invokestatic 119	com/tencent/open/virtual/OpenSdkVirtualManager:a	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   105: aload_0
    //   106: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   109: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: checkcast 127	java/lang/Integer
    //   115: astore_3
    //   116: aload_3
    //   117: ifnonnull +87 -> 204
    //   120: iconst_0
    //   121: istore_1
    //   122: iload 7
    //   124: sipush 1002
    //   127: if_icmpne +85 -> 212
    //   130: iload_1
    //   131: iconst_1
    //   132: if_icmpge +80 -> 212
    //   135: ldc 70
    //   137: iconst_1
    //   138: ldc 129
    //   140: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_0
    //   144: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   147: invokestatic 119	com/tencent/open/virtual/OpenSdkVirtualManager:a	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   150: aload_0
    //   151: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   154: iload_1
    //   155: iconst_1
    //   156: iadd
    //   157: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   160: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: pop
    //   164: aload_0
    //   165: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   168: aload_0
    //   169: getfield 30	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_Boolean	Z
    //   172: aload_0
    //   173: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   176: aload_0
    //   177: getfield 32	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   180: aload_0
    //   181: getfield 34	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   184: aload_0
    //   185: getfield 36	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_b_of_type_Long	J
    //   188: aload_0
    //   189: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   192: aload_0
    //   193: getfield 40	com/tencent/open/virtual/OpenSdkVirtualManager$6:c	Ljava/lang/String;
    //   196: aload_0
    //   197: getfield 42	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   200: invokevirtual 140	com/tencent/open/virtual/OpenSdkVirtualManager:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;JLcom/tencent/open/agent/authority/AuthCallback;Ljava/lang/String;Landroid/app/Activity;)V
    //   203: return
    //   204: aload_3
    //   205: invokevirtual 144	java/lang/Integer:intValue	()I
    //   208: istore_1
    //   209: goto -87 -> 122
    //   212: aload_0
    //   213: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   216: ifnull -13 -> 203
    //   219: aload_0
    //   220: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   223: invokestatic 119	com/tencent/open/virtual/OpenSdkVirtualManager:a	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   226: aload_0
    //   227: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   230: iconst_0
    //   231: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   234: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: aload_0
    //   239: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   242: iconst_0
    //   243: iconst_m1
    //   244: aconst_null
    //   245: invokevirtual 149	com/tencent/open/agent/authority/AuthCallback:a	(ZILcom/tencent/open/agent/authority/AuthResponse;)V
    //   248: return
    //   249: iload_2
    //   250: ifeq +779 -> 1029
    //   253: iconst_0
    //   254: istore 9
    //   256: iconst_0
    //   257: istore 8
    //   259: iconst_0
    //   260: istore_1
    //   261: aload_0
    //   262: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   265: invokestatic 119	com/tencent/open/virtual/OpenSdkVirtualManager:a	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   268: aload_0
    //   269: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   272: iconst_0
    //   273: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: pop
    //   280: new 151	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse
    //   283: dup
    //   284: invokespecial 152	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:<init>	()V
    //   287: astore 18
    //   289: iload 9
    //   291: istore 5
    //   293: iload 7
    //   295: istore 6
    //   297: aload 18
    //   299: astore 16
    //   301: aload_3
    //   302: ldc 154
    //   304: invokevirtual 158	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   307: astore 19
    //   309: iload 9
    //   311: istore 5
    //   313: iload 7
    //   315: istore 6
    //   317: aload 18
    //   319: astore 16
    //   321: aload_0
    //   322: getfield 44	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_b_of_type_Boolean	Z
    //   325: ifeq +1082 -> 1407
    //   328: iload 9
    //   330: istore 5
    //   332: iload 7
    //   334: istore 6
    //   336: aload 18
    //   338: astore 16
    //   340: aload 19
    //   342: aload_0
    //   343: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   346: invokestatic 163	com/tencent/open/virtual/OpenSdkVirtualUtil:b	([BLcom/tencent/open/model/AccountInfo;)[B
    //   349: astore 19
    //   351: iload 7
    //   353: istore 4
    //   355: aload 18
    //   357: astore 17
    //   359: aload 19
    //   361: ifnull +370 -> 731
    //   364: iload 9
    //   366: istore 5
    //   368: iload 7
    //   370: istore 6
    //   372: aload 18
    //   374: astore 16
    //   376: aload 19
    //   378: arraylength
    //   379: i2l
    //   380: lstore 12
    //   382: iload 9
    //   384: istore 5
    //   386: iload 7
    //   388: istore 6
    //   390: aload 18
    //   392: astore 16
    //   394: aload 18
    //   396: aload 19
    //   398: invokevirtual 167	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   401: checkcast 151	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse
    //   404: astore 17
    //   406: iload 9
    //   408: istore 5
    //   410: iload 7
    //   412: istore 6
    //   414: aload 17
    //   416: astore 16
    //   418: aload 17
    //   420: getfield 171	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   423: invokevirtual 175	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   426: istore 4
    //   428: iload 4
    //   430: ifne +972 -> 1402
    //   433: aload_0
    //   434: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   437: aload_0
    //   438: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   441: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   444: aload 17
    //   446: getfield 179	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:expires_in	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   449: invokevirtual 183	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   452: aload 19
    //   454: invokestatic 186	com/tencent/open/virtual/OpenSdkVirtualUtil:a	(Ljava/lang/String;Ljava/lang/String;J[B)V
    //   457: aload_0
    //   458: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   461: ifnull +18 -> 479
    //   464: aload_0
    //   465: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   468: iconst_1
    //   469: iload 4
    //   471: aload 17
    //   473: invokestatic 191	com/tencent/open/agent/authority/AuthResponse:a	(Lcom/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse;)Lcom/tencent/open/agent/authority/AuthResponse;
    //   476: invokevirtual 149	com/tencent/open/agent/authority/AuthCallback:a	(ZILcom/tencent/open/agent/authority/AuthResponse;)V
    //   479: iconst_1
    //   480: istore_1
    //   481: aload 17
    //   483: invokevirtual 195	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:toByteArray	()[B
    //   486: arraylength
    //   487: i2l
    //   488: lstore 14
    //   490: aload 17
    //   492: getfield 171	com/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse:ret	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   495: invokevirtual 175	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   498: istore 5
    //   500: new 64	android/os/Bundle
    //   503: dup
    //   504: invokespecial 196	android/os/Bundle:<init>	()V
    //   507: astore 16
    //   509: aload 16
    //   511: ldc 198
    //   513: ldc 200
    //   515: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: aload 16
    //   520: ldc 206
    //   522: ldc 208
    //   524: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: aload_3
    //   528: ldc 210
    //   530: iconst_0
    //   531: invokevirtual 214	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   534: ifeq +385 -> 919
    //   537: ldc 216
    //   539: astore_3
    //   540: aload 16
    //   542: ldc 218
    //   544: aload_3
    //   545: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: aload 16
    //   550: ldc 220
    //   552: aload_0
    //   553: getfield 46	com/tencent/open/virtual/OpenSdkVirtualManager$6:d	Ljava/lang/String;
    //   556: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload 16
    //   561: ldc 222
    //   563: new 72	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   570: ldc 224
    //   572: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: iload 5
    //   577: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: aload 16
    //   588: ldc 229
    //   590: new 72	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   597: ldc 224
    //   599: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: lload 10
    //   604: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   607: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokevirtual 204	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: invokestatic 234	com/tencent/open/agent/report/ReportCenter:a	()Lcom/tencent/open/agent/report/ReportCenter;
    //   616: aload 16
    //   618: aload_0
    //   619: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: aload_0
    //   623: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   626: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   629: iconst_0
    //   630: iconst_1
    //   631: invokevirtual 237	com/tencent/open/agent/report/ReportCenter:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;ZZ)V
    //   634: invokestatic 242	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   637: ldc 244
    //   639: aload_0
    //   640: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   643: invokestatic 246	com/tencent/open/virtual/OpenSdkVirtualManager:b	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   646: aload_0
    //   647: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   650: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   653: checkcast 248	java/lang/Long
    //   656: invokevirtual 251	java/lang/Long:longValue	()J
    //   659: lload 12
    //   661: lload 14
    //   663: iconst_0
    //   664: aload_0
    //   665: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   668: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   671: invokestatic 255	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   674: ldc_w 257
    //   677: new 72	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   684: ldc_w 259
    //   687: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: iload 5
    //   692: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   698: iconst_1
    //   699: invokevirtual 262	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;Z)V
    //   702: iconst_0
    //   703: ldc_w 264
    //   706: aload_0
    //   707: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   710: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   713: aload_0
    //   714: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   717: aconst_null
    //   718: invokestatic 269	android/os/SystemClock:elapsedRealtime	()J
    //   721: invokestatic 272	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   724: iload 5
    //   726: iconst_1
    //   727: aconst_null
    //   728: invokestatic 275	com/tencent/open/agent/util/AuthorityUtil:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   731: iload_1
    //   732: istore 5
    //   734: iload 4
    //   736: istore 6
    //   738: aload 17
    //   740: astore 16
    //   742: ldc 70
    //   744: iconst_1
    //   745: new 72	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   752: ldc_w 277
    //   755: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload_0
    //   759: getfield 46	com/tencent/open/virtual/OpenSdkVirtualManager$6:d	Ljava/lang/String;
    //   762: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: ldc_w 279
    //   768: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload_0
    //   772: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   775: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   778: invokestatic 83	com/tencent/open/agent/util/AuthorityUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   781: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: ldc_w 281
    //   787: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: iload 4
    //   792: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   795: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   801: aload 17
    //   803: astore 16
    //   805: iload_1
    //   806: ifne +25 -> 831
    //   809: aload_0
    //   810: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   813: ifnull +18 -> 831
    //   816: aload_0
    //   817: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   820: iconst_0
    //   821: iload 4
    //   823: aload 16
    //   825: invokestatic 191	com/tencent/open/agent/authority/AuthResponse:a	(Lcom/tencent/protofile/sdkauthorize/SdkAuthorize$AuthorizeResponse;)Lcom/tencent/open/agent/authority/AuthResponse;
    //   828: invokevirtual 149	com/tencent/open/agent/authority/AuthCallback:a	(ZILcom/tencent/open/agent/authority/AuthResponse;)V
    //   831: aload_0
    //   832: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   835: invokestatic 283	com/tencent/open/virtual/OpenSdkVirtualManager:c	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   838: aload_0
    //   839: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   842: invokestatic 269	android/os/SystemClock:elapsedRealtime	()J
    //   845: invokestatic 272	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   848: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   851: pop
    //   852: ldc 70
    //   854: iconst_1
    //   855: new 72	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   862: ldc_w 285
    //   865: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: aload_0
    //   869: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   872: invokestatic 283	com/tencent/open/virtual/OpenSdkVirtualManager:c	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   875: aload_0
    //   876: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   879: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   882: checkcast 248	java/lang/Long
    //   885: invokevirtual 251	java/lang/Long:longValue	()J
    //   888: aload_0
    //   889: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   892: invokestatic 246	com/tencent/open/virtual/OpenSdkVirtualManager:b	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   895: aload_0
    //   896: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   899: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   902: checkcast 248	java/lang/Long
    //   905: invokevirtual 251	java/lang/Long:longValue	()J
    //   908: lsub
    //   909: invokevirtual 93	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   912: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   918: return
    //   919: ldc_w 287
    //   922: astore_3
    //   923: goto -383 -> 540
    //   926: astore_3
    //   927: ldc 70
    //   929: iconst_1
    //   930: ldc_w 289
    //   933: aload_3
    //   934: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   937: goto -206 -> 731
    //   940: astore_3
    //   941: iload 6
    //   943: istore 4
    //   945: iload 5
    //   947: istore_1
    //   948: aload_0
    //   949: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   952: ifnull +14 -> 966
    //   955: aload_0
    //   956: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   959: iconst_0
    //   960: iload 4
    //   962: aconst_null
    //   963: invokevirtual 149	com/tencent/open/agent/authority/AuthCallback:a	(ZILcom/tencent/open/agent/authority/AuthResponse;)V
    //   966: ldc 70
    //   968: iconst_1
    //   969: new 72	java/lang/StringBuilder
    //   972: dup
    //   973: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   976: ldc_w 277
    //   979: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: aload_0
    //   983: getfield 46	com/tencent/open/virtual/OpenSdkVirtualManager$6:d	Ljava/lang/String;
    //   986: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: ldc_w 279
    //   992: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: aload_0
    //   996: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   999: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1002: invokestatic 83	com/tencent/open/agent/util/AuthorityUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1005: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: ldc_w 281
    //   1011: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: iload 4
    //   1016: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1019: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1022: aload_3
    //   1023: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1026: goto -221 -> 805
    //   1029: aload_0
    //   1030: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   1033: invokestatic 119	com/tencent/open/virtual/OpenSdkVirtualManager:a	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1036: aload_0
    //   1037: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1040: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1043: checkcast 127	java/lang/Integer
    //   1046: astore_3
    //   1047: aload_3
    //   1048: ifnonnull +87 -> 1135
    //   1051: iconst_0
    //   1052: istore_1
    //   1053: iload 7
    //   1055: sipush 1002
    //   1058: if_icmpne +85 -> 1143
    //   1061: iload_1
    //   1062: iconst_1
    //   1063: if_icmpge +80 -> 1143
    //   1066: ldc 70
    //   1068: iconst_1
    //   1069: ldc 129
    //   1071: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: aload_0
    //   1075: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   1078: invokestatic 119	com/tencent/open/virtual/OpenSdkVirtualManager:a	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1081: aload_0
    //   1082: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1085: iload_1
    //   1086: iconst_1
    //   1087: iadd
    //   1088: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1091: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1094: pop
    //   1095: aload_0
    //   1096: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   1099: aload_0
    //   1100: getfield 30	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_Boolean	Z
    //   1103: aload_0
    //   1104: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1107: aload_0
    //   1108: getfield 32	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1111: aload_0
    //   1112: getfield 34	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1115: aload_0
    //   1116: getfield 36	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_b_of_type_Long	J
    //   1119: aload_0
    //   1120: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   1123: aload_0
    //   1124: getfield 40	com/tencent/open/virtual/OpenSdkVirtualManager$6:c	Ljava/lang/String;
    //   1127: aload_0
    //   1128: getfield 42	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   1131: invokevirtual 140	com/tencent/open/virtual/OpenSdkVirtualManager:a	(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;JLcom/tencent/open/agent/authority/AuthCallback;Ljava/lang/String;Landroid/app/Activity;)V
    //   1134: return
    //   1135: aload_3
    //   1136: invokevirtual 144	java/lang/Integer:intValue	()I
    //   1139: istore_1
    //   1140: goto -87 -> 1053
    //   1143: aload_0
    //   1144: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   1147: invokestatic 119	com/tencent/open/virtual/OpenSdkVirtualManager:a	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1150: aload_0
    //   1151: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1154: iconst_0
    //   1155: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1158: invokevirtual 137	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1161: pop
    //   1162: aload_0
    //   1163: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   1166: ifnull +14 -> 1180
    //   1169: aload_0
    //   1170: getfield 38	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenAgentAuthorityAuthCallback	Lcom/tencent/open/agent/authority/AuthCallback;
    //   1173: iconst_0
    //   1174: iload 7
    //   1176: aconst_null
    //   1177: invokevirtual 149	com/tencent/open/agent/authority/AuthCallback:a	(ZILcom/tencent/open/agent/authority/AuthResponse;)V
    //   1180: invokestatic 242	com/tencent/open/business/cgireport/ReportManager:a	()Lcom/tencent/open/business/cgireport/ReportManager;
    //   1183: ldc 244
    //   1185: aload_0
    //   1186: getfield 22	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenVirtualOpenSdkVirtualManager	Lcom/tencent/open/virtual/OpenSdkVirtualManager;
    //   1189: invokestatic 246	com/tencent/open/virtual/OpenSdkVirtualManager:b	(Lcom/tencent/open/virtual/OpenSdkVirtualManager;)Ljava/util/concurrent/ConcurrentHashMap;
    //   1192: aload_0
    //   1193: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1196: invokevirtual 125	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1199: checkcast 248	java/lang/Long
    //   1202: invokevirtual 251	java/lang/Long:longValue	()J
    //   1205: lconst_0
    //   1206: lconst_0
    //   1207: iload 7
    //   1209: aload_0
    //   1210: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   1213: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1216: invokestatic 255	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1219: ldc_w 257
    //   1222: ldc 224
    //   1224: iconst_1
    //   1225: invokevirtual 262	com/tencent/open/business/cgireport/ReportManager:a	(Ljava/lang/String;JJJIJLjava/lang/String;Ljava/lang/String;Z)V
    //   1228: iconst_1
    //   1229: ldc_w 264
    //   1232: aload_0
    //   1233: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   1236: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1239: aload_0
    //   1240: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1243: aconst_null
    //   1244: invokestatic 269	android/os/SystemClock:elapsedRealtime	()J
    //   1247: invokestatic 272	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1250: sipush 3002
    //   1253: iconst_1
    //   1254: ldc 224
    //   1256: invokestatic 275	com/tencent/open/agent/util/AuthorityUtil:a	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   1259: invokestatic 234	com/tencent/open/agent/report/ReportCenter:a	()Lcom/tencent/open/agent/report/ReportCenter;
    //   1262: aload_0
    //   1263: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   1266: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1269: ldc 224
    //   1271: aload_0
    //   1272: getfield 28	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1275: ldc_w 287
    //   1278: ldc_w 294
    //   1281: new 72	java/lang/StringBuilder
    //   1284: dup
    //   1285: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   1288: ldc 224
    //   1290: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: sipush 3002
    //   1296: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1299: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1302: iconst_0
    //   1303: iconst_1
    //   1304: invokevirtual 297	com/tencent/open/agent/report/ReportCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
    //   1307: ldc 70
    //   1309: iconst_1
    //   1310: new 72	java/lang/StringBuilder
    //   1313: dup
    //   1314: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   1317: ldc_w 277
    //   1320: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: aload_0
    //   1324: getfield 46	com/tencent/open/virtual/OpenSdkVirtualManager$6:d	Ljava/lang/String;
    //   1327: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: ldc_w 279
    //   1333: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: aload_0
    //   1337: getfield 26	com/tencent/open/virtual/OpenSdkVirtualManager$6:jdField_a_of_type_ComTencentOpenModelAccountInfo	Lcom/tencent/open/model/AccountInfo;
    //   1340: getfield 88	com/tencent/open/model/AccountInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1343: invokestatic 83	com/tencent/open/agent/util/AuthorityUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1346: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1349: ldc_w 299
    //   1352: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: iload 7
    //   1357: invokevirtual 227	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1360: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1363: invokestatic 102	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1366: goto -535 -> 831
    //   1369: astore_3
    //   1370: ldc 70
    //   1372: iconst_1
    //   1373: ldc_w 301
    //   1376: aload_3
    //   1377: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1380: goto -73 -> 1307
    //   1383: astore_3
    //   1384: iload 8
    //   1386: istore_1
    //   1387: aload 17
    //   1389: astore 16
    //   1391: goto -443 -> 948
    //   1394: astore_3
    //   1395: aload 17
    //   1397: astore 16
    //   1399: goto -451 -> 948
    //   1402: iconst_0
    //   1403: istore_1
    //   1404: goto -923 -> 481
    //   1407: goto -1056 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1410	0	this	6
    //   0	1410	1	paramInt	int
    //   0	1410	2	paramBoolean	boolean
    //   0	1410	3	paramBundle	android.os.Bundle
    //   353	662	4	i	int
    //   291	655	5	j	int
    //   295	647	6	k	int
    //   81	1275	7	m	int
    //   257	1128	8	n	int
    //   254	153	9	i1	int
    //   8	595	10	l1	long
    //   380	280	12	l2	long
    //   488	174	14	l3	long
    //   16	1382	16	localObject	Object
    //   357	1039	17	localAuthorizeResponse1	com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse
    //   287	108	18	localAuthorizeResponse2	com.tencent.protofile.sdkauthorize.SdkAuthorize.AuthorizeResponse
    //   307	146	19	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   481	537	926	java/lang/Exception
    //   540	731	926	java/lang/Exception
    //   301	309	940	java/lang/Exception
    //   321	328	940	java/lang/Exception
    //   340	351	940	java/lang/Exception
    //   376	382	940	java/lang/Exception
    //   394	406	940	java/lang/Exception
    //   418	428	940	java/lang/Exception
    //   742	801	940	java/lang/Exception
    //   1180	1307	1369	java/lang/Exception
    //   433	479	1383	java/lang/Exception
    //   927	937	1394	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.virtual.OpenSdkVirtualManager.6
 * JD-Core Version:    0.7.0.1
 */