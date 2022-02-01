package com.tencent.mobileqq.secspy;

import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c.MsgBody;

class SecSpyFileManager$2
  implements Runnable
{
  SecSpyFileManager$2(SecSpyFileManager paramSecSpyFileManager, submsgtype0x7c.MsgBody paramMsgBody, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x7cSubmsgtype0x7c$MsgBody	Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;
    //   4: getfield 42	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:int32_cmd	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   7: invokevirtual 48	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   10: istore_1
    //   11: aload_0
    //   12: getfield 17	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x7cSubmsgtype0x7c$MsgBody	Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;
    //   15: getfield 52	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:uint64_seq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   18: invokevirtual 57	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   21: lstore 5
    //   23: aload_0
    //   24: getfield 17	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x7cSubmsgtype0x7c$MsgBody	Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;
    //   27: getfield 61	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:rpt_string_cmd_ext	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   30: iconst_0
    //   31: invokevirtual 66	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   34: checkcast 68	java/lang/String
    //   37: astore 14
    //   39: aload_0
    //   40: getfield 17	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x7cSubmsgtype0x7c$MsgBody	Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;
    //   43: getfield 71	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:rpt_string_seq_ext	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   46: invokevirtual 75	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   49: ifeq +22 -> 71
    //   52: aload_0
    //   53: getfield 17	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x7cSubmsgtype0x7c$MsgBody	Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;
    //   56: getfield 71	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:rpt_string_seq_ext	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   59: iconst_0
    //   60: invokevirtual 66	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   63: checkcast 68	java/lang/String
    //   66: astore 13
    //   68: goto +7 -> 75
    //   71: ldc 77
    //   73: astore 13
    //   75: new 79	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   82: astore 15
    //   84: aload 15
    //   86: ldc 82
    //   88: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 15
    //   94: iload_1
    //   95: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 15
    //   101: ldc 91
    //   103: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 15
    //   109: lload 5
    //   111: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 15
    //   117: ldc 96
    //   119: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 15
    //   125: aload 14
    //   127: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 15
    //   133: ldc 98
    //   135: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 15
    //   141: aload 13
    //   143: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 100
    //   149: iconst_1
    //   150: aload 15
    //   152: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload_0
    //   159: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   162: lload 5
    //   164: iconst_1
    //   165: iconst_0
    //   166: anewarray 4	java/lang/Object
    //   169: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   172: iload_1
    //   173: iconst_1
    //   174: if_icmpeq +3861 -> 4035
    //   177: iload_1
    //   178: iconst_2
    //   179: if_icmpeq +3745 -> 3924
    //   182: iload_1
    //   183: iconst_3
    //   184: if_icmpeq +3571 -> 3755
    //   187: iload_1
    //   188: iconst_4
    //   189: if_icmpeq +3377 -> 3566
    //   192: iload_1
    //   193: sipush 275
    //   196: if_icmpeq +3320 -> 3516
    //   199: iload_1
    //   200: sipush 276
    //   203: if_icmpeq +3205 -> 3408
    //   206: iload_1
    //   207: sipush 280
    //   210: if_icmpeq +3081 -> 3291
    //   213: iload_1
    //   214: sipush 291
    //   217: if_icmpeq +3046 -> 3263
    //   220: iload_1
    //   221: tableswitch	default:+79 -> 300, 257:+2954->3175, 258:+2646->2867, 259:+2436->2657, 260:+2224->2445, 261:+1988->2209, 262:+1898->2119, 263:+1774->1995, 264:+1666->1887, 265:+1576->1797, 266:+1315->1536, 267:+1148->1369, 268:+1058->1279, 269:+877->1098, 270:+711->932, 271:+506->727, 272:+82->303
    //   301: dconst_0
    //   302: fload_0
    //   303: aload_0
    //   304: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   307: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   310: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   313: invokestatic 130	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   316: istore_2
    //   317: iload_2
    //   318: ifgt +52 -> 370
    //   321: aload_0
    //   322: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   325: lload 5
    //   327: iconst_m1
    //   328: iconst_1
    //   329: anewarray 4	java/lang/Object
    //   332: dup
    //   333: iconst_0
    //   334: ldc 132
    //   336: aastore
    //   337: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   340: goto -40 -> 300
    //   343: astore 14
    //   345: ldc 134
    //   347: astore 13
    //   349: goto +3931 -> 4280
    //   352: astore 14
    //   354: ldc 134
    //   356: astore 13
    //   358: goto +3942 -> 4300
    //   361: astore 14
    //   363: ldc 134
    //   365: astore 13
    //   367: goto +3953 -> 4320
    //   370: new 136	org/json/JSONObject
    //   373: dup
    //   374: aload 14
    //   376: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   379: astore 14
    //   381: aload 14
    //   383: ldc 141
    //   385: invokevirtual 145	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   388: astore 15
    //   390: aload 15
    //   392: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   395: ifne +310 -> 705
    //   398: aload 14
    //   400: ldc 153
    //   402: invokevirtual 157	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   405: istore_2
    //   406: aload_0
    //   407: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   410: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   413: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   416: invokestatic 162	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;)Z
    //   419: istore 9
    //   421: iload 9
    //   423: ifne +28 -> 451
    //   426: aload_0
    //   427: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   430: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   433: astore 16
    //   435: aload_0
    //   436: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   439: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   442: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   445: aload 15
    //   447: iload_2
    //   448: invokestatic 168	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/app/Application;Ljava/lang/String;I)V
    //   451: aload_0
    //   452: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   455: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   458: invokevirtual 171	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	()Landroid/os/Handler;
    //   461: aload_0
    //   462: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   465: invokestatic 174	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager;)Ljava/lang/Runnable;
    //   468: invokevirtual 180	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   471: aload 14
    //   473: ldc 182
    //   475: invokevirtual 186	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   478: lstore_3
    //   479: aload_0
    //   480: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   483: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   486: invokevirtual 171	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	()Landroid/os/Handler;
    //   489: aload_0
    //   490: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   493: invokestatic 174	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager;)Ljava/lang/Runnable;
    //   496: lload_3
    //   497: ldc2_w 187
    //   500: lmul
    //   501: invokevirtual 192	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   504: pop
    //   505: aload 14
    //   507: ldc 194
    //   509: invokevirtual 197	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   512: ifeq +176 -> 688
    //   515: aload 14
    //   517: ldc 194
    //   519: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   522: astore 15
    //   524: aload 15
    //   526: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   529: ifne +137 -> 666
    //   532: aload 15
    //   534: invokestatic 206	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   537: astore 16
    //   539: ldc 208
    //   541: aload 16
    //   543: invokevirtual 211	android/net/Uri:getScheme	()Ljava/lang/String;
    //   546: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   549: istore 9
    //   551: iload 9
    //   553: ifne +41 -> 594
    //   556: ldc 217
    //   558: aload 16
    //   560: invokevirtual 211	android/net/Uri:getScheme	()Ljava/lang/String;
    //   563: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   566: ifeq +6 -> 572
    //   569: goto +25 -> 594
    //   572: aload_0
    //   573: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   576: lload 5
    //   578: iconst_m1
    //   579: iconst_1
    //   580: anewarray 4	java/lang/Object
    //   583: dup
    //   584: iconst_0
    //   585: ldc 219
    //   587: aastore
    //   588: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   591: goto -291 -> 300
    //   594: aload 14
    //   596: ldc 221
    //   598: ldc2_w 222
    //   601: invokevirtual 227	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   604: lstore_3
    //   605: lload_3
    //   606: lconst_0
    //   607: lcmp
    //   608: ifgt +4076 -> 4684
    //   611: ldc2_w 228
    //   614: lstore_3
    //   615: goto +3 -> 618
    //   618: aload 14
    //   620: ldc 231
    //   622: iconst_5
    //   623: invokevirtual 235	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   626: istore_2
    //   627: aload_0
    //   628: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   631: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   634: astore 14
    //   636: aload_0
    //   637: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   640: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   643: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   646: astore 16
    //   648: aload 14
    //   650: aload 16
    //   652: aload 15
    //   654: iload_2
    //   655: lload_3
    //   656: lload 5
    //   658: aload 13
    //   660: invokevirtual 239	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:c	(Landroid/content/Context;Ljava/lang/String;IJJLjava/lang/String;)V
    //   663: goto +3255 -> 3918
    //   666: aload_0
    //   667: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   670: lload 5
    //   672: iconst_m1
    //   673: iconst_1
    //   674: anewarray 4	java/lang/Object
    //   677: dup
    //   678: iconst_0
    //   679: ldc 241
    //   681: aastore
    //   682: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   685: goto +3233 -> 3918
    //   688: aload_0
    //   689: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   692: lload 5
    //   694: iconst_0
    //   695: iconst_0
    //   696: anewarray 4	java/lang/Object
    //   699: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   702: goto +3216 -> 3918
    //   705: aload_0
    //   706: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   709: lload 5
    //   711: iconst_m1
    //   712: iconst_1
    //   713: anewarray 4	java/lang/Object
    //   716: dup
    //   717: iconst_0
    //   718: ldc 243
    //   720: aastore
    //   721: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   724: goto +3194 -> 3918
    //   727: new 136	org/json/JSONObject
    //   730: dup
    //   731: aload 14
    //   733: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   736: astore 15
    //   738: aload 15
    //   740: ldc 245
    //   742: ldc2_w 222
    //   745: invokevirtual 227	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   748: lstore_3
    //   749: aload 15
    //   751: ldc 231
    //   753: iconst_5
    //   754: invokevirtual 235	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   757: istore_2
    //   758: lload_3
    //   759: lconst_0
    //   760: lcmp
    //   761: ifle +32 -> 793
    //   764: aload_0
    //   765: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   768: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   771: aload_0
    //   772: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   775: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   778: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   781: lload_3
    //   782: lload 5
    //   784: aload 13
    //   786: iload_2
    //   787: invokevirtual 248	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;JJLjava/lang/String;I)V
    //   790: goto +3128 -> 3918
    //   793: aload 15
    //   795: ldc 194
    //   797: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   800: astore 14
    //   802: aload 15
    //   804: ldc 250
    //   806: ldc2_w 222
    //   809: invokevirtual 227	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   812: lstore_3
    //   813: aload 14
    //   815: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   818: ifne +92 -> 910
    //   821: aload 14
    //   823: invokestatic 206	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   826: astore 15
    //   828: ldc 208
    //   830: aload 15
    //   832: invokevirtual 211	android/net/Uri:getScheme	()Ljava/lang/String;
    //   835: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   838: ifne +3870 -> 4708
    //   841: ldc 217
    //   843: aload 15
    //   845: invokevirtual 211	android/net/Uri:getScheme	()Ljava/lang/String;
    //   848: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   851: ifeq +6 -> 857
    //   854: goto +3854 -> 4708
    //   857: aload_0
    //   858: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   861: lload 5
    //   863: iconst_m1
    //   864: iconst_1
    //   865: anewarray 4	java/lang/Object
    //   868: dup
    //   869: iconst_0
    //   870: ldc 219
    //   872: aastore
    //   873: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   876: goto +3042 -> 3918
    //   879: aload_0
    //   880: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   883: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   886: aload_0
    //   887: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   890: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   893: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   896: aload 14
    //   898: iload_2
    //   899: lload_3
    //   900: lload 5
    //   902: aload 13
    //   904: invokevirtual 252	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;Ljava/lang/String;IJJLjava/lang/String;)V
    //   907: goto +3011 -> 3918
    //   910: aload_0
    //   911: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   914: lload 5
    //   916: iconst_m1
    //   917: iconst_1
    //   918: anewarray 4	java/lang/Object
    //   921: dup
    //   922: iconst_0
    //   923: ldc 241
    //   925: aastore
    //   926: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   929: goto +2989 -> 3918
    //   932: new 136	org/json/JSONObject
    //   935: dup
    //   936: aload 14
    //   938: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   941: astore 14
    //   943: aload 14
    //   945: ldc 141
    //   947: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   950: astore 13
    //   952: aload 14
    //   954: ldc 254
    //   956: invokevirtual 258	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   959: astore 14
    //   961: aload 13
    //   963: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   966: ifne +110 -> 1076
    //   969: aload 14
    //   971: ifnull +82 -> 1053
    //   974: aload_0
    //   975: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   978: aload 14
    //   980: invokevirtual 261	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   983: astore 14
    //   985: aload_0
    //   986: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   989: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   992: aload_0
    //   993: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   996: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   999: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1002: aload 13
    //   1004: aload 14
    //   1006: invokevirtual 265	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:b	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V
    //   1009: aload_0
    //   1010: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1013: lload 5
    //   1015: iconst_0
    //   1016: iconst_0
    //   1017: anewarray 4	java/lang/Object
    //   1020: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1023: goto +2895 -> 3918
    //   1026: astore 13
    //   1028: aload_0
    //   1029: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1032: lload 5
    //   1034: iconst_m1
    //   1035: iconst_1
    //   1036: anewarray 4	java/lang/Object
    //   1039: dup
    //   1040: iconst_0
    //   1041: aload 13
    //   1043: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1046: aastore
    //   1047: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1050: goto +2868 -> 3918
    //   1053: aload_0
    //   1054: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1057: lload 5
    //   1059: iconst_m1
    //   1060: iconst_1
    //   1061: anewarray 4	java/lang/Object
    //   1064: dup
    //   1065: iconst_0
    //   1066: ldc_w 270
    //   1069: aastore
    //   1070: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1073: goto +2845 -> 3918
    //   1076: aload_0
    //   1077: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1080: lload 5
    //   1082: iconst_m1
    //   1083: iconst_1
    //   1084: anewarray 4	java/lang/Object
    //   1087: dup
    //   1088: iconst_0
    //   1089: ldc 243
    //   1091: aastore
    //   1092: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1095: goto +2823 -> 3918
    //   1098: new 136	org/json/JSONObject
    //   1101: dup
    //   1102: aload 14
    //   1104: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1107: ldc 141
    //   1109: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1112: astore 14
    //   1114: aload 14
    //   1116: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1119: istore 9
    //   1121: iload 9
    //   1123: ifne +134 -> 1257
    //   1126: aload_0
    //   1127: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1130: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   1133: aload_0
    //   1134: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1137: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1140: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1143: aload 14
    //   1145: invokevirtual 273	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   1148: astore 15
    //   1150: aload 15
    //   1152: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1155: ifne +20 -> 1175
    //   1158: aload_0
    //   1159: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1162: aload 15
    //   1164: lload 5
    //   1166: aload 13
    //   1168: iconst_1
    //   1169: invokevirtual 276	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;JLjava/lang/String;Z)V
    //   1172: goto +2746 -> 3918
    //   1175: aload_0
    //   1176: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1179: astore 13
    //   1181: new 79	java/lang/StringBuilder
    //   1184: dup
    //   1185: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1188: astore 15
    //   1190: aload 15
    //   1192: ldc_w 278
    //   1195: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: pop
    //   1199: aload 15
    //   1201: aload 14
    //   1203: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: pop
    //   1207: aload 13
    //   1209: lload 5
    //   1211: iconst_m1
    //   1212: iconst_1
    //   1213: anewarray 4	java/lang/Object
    //   1216: dup
    //   1217: iconst_0
    //   1218: aload 15
    //   1220: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1223: aastore
    //   1224: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1227: goto +2691 -> 3918
    //   1230: astore 13
    //   1232: aload_0
    //   1233: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1236: lload 5
    //   1238: iconst_m1
    //   1239: iconst_1
    //   1240: anewarray 4	java/lang/Object
    //   1243: dup
    //   1244: iconst_0
    //   1245: aload 13
    //   1247: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1250: aastore
    //   1251: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1254: goto +2664 -> 3918
    //   1257: aload_0
    //   1258: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1261: lload 5
    //   1263: iconst_m1
    //   1264: iconst_1
    //   1265: anewarray 4	java/lang/Object
    //   1268: dup
    //   1269: iconst_0
    //   1270: ldc 243
    //   1272: aastore
    //   1273: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1276: goto +2642 -> 3918
    //   1279: aload_0
    //   1280: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1283: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   1286: aload_0
    //   1287: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1290: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1293: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1296: invokevirtual 281	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:b	(Landroid/content/Context;)Ljava/util/Set;
    //   1299: astore 13
    //   1301: new 136	org/json/JSONObject
    //   1304: dup
    //   1305: invokespecial 282	org/json/JSONObject:<init>	()V
    //   1308: astore 14
    //   1310: aload 14
    //   1312: ldc_w 284
    //   1315: aload_0
    //   1316: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1319: aload 13
    //   1321: invokevirtual 287	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/util/Collection;)Lorg/json/JSONArray;
    //   1324: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1327: pop
    //   1328: aload_0
    //   1329: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1332: lload 5
    //   1334: aload 14
    //   1336: invokevirtual 294	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JLorg/json/JSONObject;)V
    //   1339: goto +2579 -> 3918
    //   1342: astore 13
    //   1344: aload_0
    //   1345: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1348: lload 5
    //   1350: iconst_m1
    //   1351: iconst_1
    //   1352: anewarray 4	java/lang/Object
    //   1355: dup
    //   1356: iconst_0
    //   1357: aload 13
    //   1359: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1362: aastore
    //   1363: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1366: goto +2552 -> 3918
    //   1369: new 136	org/json/JSONObject
    //   1372: dup
    //   1373: aload 14
    //   1375: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1378: astore 14
    //   1380: aload 14
    //   1382: ldc 141
    //   1384: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1387: astore 13
    //   1389: aload 14
    //   1391: ldc_w 296
    //   1394: invokevirtual 258	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1397: astore 14
    //   1399: aload 13
    //   1401: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1404: ifne +110 -> 1514
    //   1407: aload 14
    //   1409: ifnull +82 -> 1491
    //   1412: aload_0
    //   1413: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1416: aload 14
    //   1418: invokevirtual 261	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   1421: astore 14
    //   1423: aload_0
    //   1424: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1427: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   1430: aload_0
    //   1431: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1434: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1437: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1440: aload 13
    //   1442: aload 14
    //   1444: invokevirtual 298	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)V
    //   1447: aload_0
    //   1448: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1451: lload 5
    //   1453: iconst_0
    //   1454: iconst_0
    //   1455: anewarray 4	java/lang/Object
    //   1458: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1461: goto +2457 -> 3918
    //   1464: astore 13
    //   1466: aload_0
    //   1467: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1470: lload 5
    //   1472: iconst_m1
    //   1473: iconst_1
    //   1474: anewarray 4	java/lang/Object
    //   1477: dup
    //   1478: iconst_0
    //   1479: aload 13
    //   1481: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1484: aastore
    //   1485: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1488: goto +2430 -> 3918
    //   1491: aload_0
    //   1492: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1495: lload 5
    //   1497: iconst_m1
    //   1498: iconst_1
    //   1499: anewarray 4	java/lang/Object
    //   1502: dup
    //   1503: iconst_0
    //   1504: ldc_w 300
    //   1507: aastore
    //   1508: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1511: goto +2407 -> 3918
    //   1514: aload_0
    //   1515: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1518: lload 5
    //   1520: iconst_m1
    //   1521: iconst_1
    //   1522: anewarray 4	java/lang/Object
    //   1525: dup
    //   1526: iconst_0
    //   1527: ldc 243
    //   1529: aastore
    //   1530: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1533: goto +2385 -> 3918
    //   1536: new 136	org/json/JSONObject
    //   1539: dup
    //   1540: aload 14
    //   1542: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1545: ldc 141
    //   1547: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1550: astore 14
    //   1552: aload 14
    //   1554: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1557: istore 9
    //   1559: iload 9
    //   1561: ifne +214 -> 1775
    //   1564: aload_0
    //   1565: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1568: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   1571: aload_0
    //   1572: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1575: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1578: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1581: aload 14
    //   1583: invokevirtual 303	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/util/List;
    //   1586: astore 15
    //   1588: new 136	org/json/JSONObject
    //   1591: dup
    //   1592: invokespecial 282	org/json/JSONObject:<init>	()V
    //   1595: astore 13
    //   1597: aload 13
    //   1599: ldc 141
    //   1601: aload 14
    //   1603: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1606: pop
    //   1607: new 305	org/json/JSONArray
    //   1610: dup
    //   1611: invokespecial 306	org/json/JSONArray:<init>	()V
    //   1614: astore 14
    //   1616: aload 15
    //   1618: invokeinterface 312 1 0
    //   1623: astore 15
    //   1625: aload 15
    //   1627: invokeinterface 317 1 0
    //   1632: ifeq +91 -> 1723
    //   1635: aload 15
    //   1637: invokeinterface 321 1 0
    //   1642: checkcast 323	java/util/Map
    //   1645: astore 16
    //   1647: new 136	org/json/JSONObject
    //   1650: dup
    //   1651: invokespecial 282	org/json/JSONObject:<init>	()V
    //   1654: astore 17
    //   1656: aload 16
    //   1658: invokeinterface 327 1 0
    //   1663: invokeinterface 330 1 0
    //   1668: astore 18
    //   1670: aload 18
    //   1672: invokeinterface 317 1 0
    //   1677: ifeq +35 -> 1712
    //   1680: aload 18
    //   1682: invokeinterface 321 1 0
    //   1687: checkcast 68	java/lang/String
    //   1690: astore 19
    //   1692: aload 17
    //   1694: aload 19
    //   1696: aload 16
    //   1698: aload 19
    //   1700: invokeinterface 333 2 0
    //   1705: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1708: pop
    //   1709: goto -39 -> 1670
    //   1712: aload 14
    //   1714: aload 17
    //   1716: invokevirtual 336	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1719: pop
    //   1720: goto -95 -> 1625
    //   1723: aload 13
    //   1725: ldc_w 296
    //   1728: aload 14
    //   1730: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1733: pop
    //   1734: aload_0
    //   1735: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1738: lload 5
    //   1740: aload 13
    //   1742: invokevirtual 294	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JLorg/json/JSONObject;)V
    //   1745: goto +2173 -> 3918
    //   1748: astore 13
    //   1750: aload_0
    //   1751: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1754: lload 5
    //   1756: iconst_m1
    //   1757: iconst_1
    //   1758: anewarray 4	java/lang/Object
    //   1761: dup
    //   1762: iconst_0
    //   1763: aload 13
    //   1765: invokevirtual 337	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   1768: aastore
    //   1769: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1772: goto +2146 -> 3918
    //   1775: aload_0
    //   1776: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1779: lload 5
    //   1781: iconst_m1
    //   1782: iconst_1
    //   1783: anewarray 4	java/lang/Object
    //   1786: dup
    //   1787: iconst_0
    //   1788: ldc 243
    //   1790: aastore
    //   1791: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1794: goto +2124 -> 3918
    //   1797: aload_0
    //   1798: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1801: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   1804: aload_0
    //   1805: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1808: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1811: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1814: invokevirtual 339	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;)Ljava/util/Set;
    //   1817: astore 13
    //   1819: new 136	org/json/JSONObject
    //   1822: dup
    //   1823: invokespecial 282	org/json/JSONObject:<init>	()V
    //   1826: astore 14
    //   1828: aload 14
    //   1830: ldc_w 284
    //   1833: aload_0
    //   1834: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1837: aload 13
    //   1839: invokevirtual 287	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/util/Collection;)Lorg/json/JSONArray;
    //   1842: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1845: pop
    //   1846: aload_0
    //   1847: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1850: lload 5
    //   1852: aload 14
    //   1854: invokevirtual 294	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JLorg/json/JSONObject;)V
    //   1857: goto +2061 -> 3918
    //   1860: astore 13
    //   1862: aload_0
    //   1863: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1866: lload 5
    //   1868: iconst_m1
    //   1869: iconst_1
    //   1870: anewarray 4	java/lang/Object
    //   1873: dup
    //   1874: iconst_0
    //   1875: aload 13
    //   1877: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1880: aastore
    //   1881: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1884: goto +2034 -> 3918
    //   1887: new 136	org/json/JSONObject
    //   1890: dup
    //   1891: aload 14
    //   1893: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1896: ldc_w 341
    //   1899: invokevirtual 258	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1902: astore 13
    //   1904: aload 13
    //   1906: ifnull +66 -> 1972
    //   1909: aload_0
    //   1910: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1913: aload 13
    //   1915: invokevirtual 261	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   1918: astore 13
    //   1920: aload_0
    //   1921: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1924: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   1927: aload_0
    //   1928: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1931: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1934: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   1937: aload 13
    //   1939: invokevirtual 344	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;Ljava/util/List;)V
    //   1942: goto +1976 -> 3918
    //   1945: astore 13
    //   1947: aload_0
    //   1948: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1951: lload 5
    //   1953: iconst_m1
    //   1954: iconst_1
    //   1955: anewarray 4	java/lang/Object
    //   1958: dup
    //   1959: iconst_0
    //   1960: aload 13
    //   1962: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1965: aastore
    //   1966: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1969: goto +1949 -> 3918
    //   1972: aload_0
    //   1973: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   1976: lload 5
    //   1978: iconst_m1
    //   1979: iconst_1
    //   1980: anewarray 4	java/lang/Object
    //   1983: dup
    //   1984: iconst_0
    //   1985: ldc_w 346
    //   1988: aastore
    //   1989: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   1992: goto +1926 -> 3918
    //   1995: new 136	org/json/JSONObject
    //   1998: dup
    //   1999: aload 14
    //   2001: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2004: ldc_w 341
    //   2007: invokevirtual 258	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2010: astore 14
    //   2012: aload 14
    //   2014: ifnull +82 -> 2096
    //   2017: aload_0
    //   2018: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2021: aload 14
    //   2023: invokevirtual 261	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   2026: astore 14
    //   2028: aload_0
    //   2029: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2032: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   2035: aload_0
    //   2036: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2039: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2042: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   2045: aload 14
    //   2047: invokevirtual 349	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;Ljava/util/List;)Ljava/lang/String;
    //   2050: astore 14
    //   2052: aload_0
    //   2053: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2056: aload 14
    //   2058: lload 5
    //   2060: aload 13
    //   2062: iconst_1
    //   2063: invokevirtual 276	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;JLjava/lang/String;Z)V
    //   2066: goto +1852 -> 3918
    //   2069: astore 13
    //   2071: aload_0
    //   2072: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2075: lload 5
    //   2077: iconst_m1
    //   2078: iconst_1
    //   2079: anewarray 4	java/lang/Object
    //   2082: dup
    //   2083: iconst_0
    //   2084: aload 13
    //   2086: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2089: aastore
    //   2090: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2093: goto +1825 -> 3918
    //   2096: aload_0
    //   2097: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2100: lload 5
    //   2102: iconst_m1
    //   2103: iconst_1
    //   2104: anewarray 4	java/lang/Object
    //   2107: dup
    //   2108: iconst_0
    //   2109: ldc_w 346
    //   2112: aastore
    //   2113: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2116: goto +1802 -> 3918
    //   2119: aload_0
    //   2120: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2123: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   2126: aload_0
    //   2127: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2130: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2133: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   2136: invokevirtual 352	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;)Ljava/util/List;
    //   2139: astore 13
    //   2141: new 136	org/json/JSONObject
    //   2144: dup
    //   2145: invokespecial 282	org/json/JSONObject:<init>	()V
    //   2148: astore 14
    //   2150: aload 14
    //   2152: ldc_w 341
    //   2155: aload_0
    //   2156: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2159: aload 13
    //   2161: invokevirtual 287	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/util/Collection;)Lorg/json/JSONArray;
    //   2164: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2167: pop
    //   2168: aload_0
    //   2169: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2172: lload 5
    //   2174: aload 14
    //   2176: invokevirtual 294	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JLorg/json/JSONObject;)V
    //   2179: goto +1739 -> 3918
    //   2182: astore 13
    //   2184: aload_0
    //   2185: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2188: lload 5
    //   2190: iconst_m1
    //   2191: iconst_1
    //   2192: anewarray 4	java/lang/Object
    //   2195: dup
    //   2196: iconst_0
    //   2197: aload 13
    //   2199: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2202: aastore
    //   2203: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2206: goto +1712 -> 3918
    //   2209: new 136	org/json/JSONObject
    //   2212: dup
    //   2213: aload 14
    //   2215: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2218: astore 14
    //   2220: aload 14
    //   2222: ldc_w 354
    //   2225: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2228: astore 13
    //   2230: aload 14
    //   2232: ldc_w 356
    //   2235: invokevirtual 258	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2238: astore 14
    //   2240: aload 14
    //   2242: ifnull +180 -> 2422
    //   2245: aload 14
    //   2247: invokevirtual 359	org/json/JSONArray:length	()I
    //   2250: ifle +172 -> 2422
    //   2253: aload_0
    //   2254: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2257: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   2260: aload 13
    //   2262: invokevirtual 361	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2265: astore 13
    //   2267: aload_0
    //   2268: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2271: aload 13
    //   2273: invokevirtual 364	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   2276: astore 15
    //   2278: aload 15
    //   2280: ifnull +87 -> 2367
    //   2283: aload 15
    //   2285: invokevirtual 369	java/io/File:exists	()Z
    //   2288: ifeq +79 -> 2367
    //   2291: aload 15
    //   2293: invokevirtual 372	java/io/File:isDirectory	()Z
    //   2296: ifeq +71 -> 2367
    //   2299: aload_0
    //   2300: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2303: aload 14
    //   2305: invokevirtual 261	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   2308: astore 13
    //   2310: aload_0
    //   2311: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2314: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   2317: aload 15
    //   2319: aload 13
    //   2321: invokevirtual 375	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Ljava/io/File;Ljava/util/List;)Z
    //   2324: ifeq +20 -> 2344
    //   2327: aload_0
    //   2328: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2331: lload 5
    //   2333: iconst_0
    //   2334: iconst_0
    //   2335: anewarray 4	java/lang/Object
    //   2338: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2341: goto +1577 -> 3918
    //   2344: aload_0
    //   2345: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2348: lload 5
    //   2350: iconst_m1
    //   2351: iconst_1
    //   2352: anewarray 4	java/lang/Object
    //   2355: dup
    //   2356: iconst_0
    //   2357: ldc_w 377
    //   2360: aastore
    //   2361: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2364: goto +1554 -> 3918
    //   2367: aload_0
    //   2368: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2371: astore 14
    //   2373: new 79	java/lang/StringBuilder
    //   2376: dup
    //   2377: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   2380: astore 15
    //   2382: aload 15
    //   2384: ldc_w 379
    //   2387: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2390: pop
    //   2391: aload 15
    //   2393: aload 13
    //   2395: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2398: pop
    //   2399: aload 14
    //   2401: lload 5
    //   2403: iconst_m1
    //   2404: iconst_1
    //   2405: anewarray 4	java/lang/Object
    //   2408: dup
    //   2409: iconst_0
    //   2410: aload 15
    //   2412: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2415: aastore
    //   2416: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2419: goto +1499 -> 3918
    //   2422: aload_0
    //   2423: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2426: lload 5
    //   2428: iconst_m1
    //   2429: iconst_1
    //   2430: anewarray 4	java/lang/Object
    //   2433: dup
    //   2434: iconst_0
    //   2435: ldc_w 381
    //   2438: aastore
    //   2439: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2442: goto +1476 -> 3918
    //   2445: new 136	org/json/JSONObject
    //   2448: dup
    //   2449: aload 14
    //   2451: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2454: astore 15
    //   2456: aload 15
    //   2458: ldc_w 354
    //   2461: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2464: astore 14
    //   2466: aload 15
    //   2468: ldc_w 356
    //   2471: invokevirtual 258	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2474: astore 15
    //   2476: aload 15
    //   2478: ifnull +156 -> 2634
    //   2481: aload 15
    //   2483: invokevirtual 359	org/json/JSONArray:length	()I
    //   2486: ifle +148 -> 2634
    //   2489: aload_0
    //   2490: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2493: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   2496: aload 14
    //   2498: invokevirtual 361	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2501: astore 14
    //   2503: aload_0
    //   2504: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2507: aload 14
    //   2509: invokevirtual 364	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   2512: astore 16
    //   2514: aload 16
    //   2516: ifnull +63 -> 2579
    //   2519: aload 16
    //   2521: invokevirtual 369	java/io/File:exists	()Z
    //   2524: ifeq +55 -> 2579
    //   2527: aload 16
    //   2529: invokevirtual 372	java/io/File:isDirectory	()Z
    //   2532: ifeq +47 -> 2579
    //   2535: aload_0
    //   2536: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2539: aload 15
    //   2541: invokevirtual 261	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Lorg/json/JSONArray;)Ljava/util/List;
    //   2544: astore 14
    //   2546: aload_0
    //   2547: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2550: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   2553: aload 16
    //   2555: aload 14
    //   2557: invokevirtual 384	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Ljava/io/File;Ljava/util/List;)Ljava/lang/String;
    //   2560: astore 14
    //   2562: aload_0
    //   2563: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2566: aload 14
    //   2568: lload 5
    //   2570: aload 13
    //   2572: iconst_1
    //   2573: invokevirtual 276	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;JLjava/lang/String;Z)V
    //   2576: goto +1342 -> 3918
    //   2579: aload_0
    //   2580: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2583: astore 13
    //   2585: new 79	java/lang/StringBuilder
    //   2588: dup
    //   2589: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   2592: astore 15
    //   2594: aload 15
    //   2596: ldc_w 379
    //   2599: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2602: pop
    //   2603: aload 15
    //   2605: aload 14
    //   2607: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2610: pop
    //   2611: aload 13
    //   2613: lload 5
    //   2615: iconst_m1
    //   2616: iconst_1
    //   2617: anewarray 4	java/lang/Object
    //   2620: dup
    //   2621: iconst_0
    //   2622: aload 15
    //   2624: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2627: aastore
    //   2628: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2631: goto +1287 -> 3918
    //   2634: aload_0
    //   2635: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2638: lload 5
    //   2640: iconst_m1
    //   2641: iconst_1
    //   2642: anewarray 4	java/lang/Object
    //   2645: dup
    //   2646: iconst_0
    //   2647: ldc_w 381
    //   2650: aastore
    //   2651: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2654: goto +1264 -> 3918
    //   2657: new 136	org/json/JSONObject
    //   2660: dup
    //   2661: aload 14
    //   2663: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2666: ldc_w 354
    //   2669: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2672: astore 13
    //   2674: aload 13
    //   2676: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2679: ifne +165 -> 2844
    //   2682: aload_0
    //   2683: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2686: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   2689: aload 13
    //   2691: invokevirtual 361	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2694: astore 13
    //   2696: aload_0
    //   2697: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2700: aload 13
    //   2702: invokevirtual 364	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   2705: astore 14
    //   2707: aload 14
    //   2709: ifnull +80 -> 2789
    //   2712: aload 14
    //   2714: invokevirtual 369	java/io/File:exists	()Z
    //   2717: ifeq +72 -> 2789
    //   2720: aload 14
    //   2722: invokevirtual 372	java/io/File:isDirectory	()Z
    //   2725: istore 9
    //   2727: iload 9
    //   2729: ifeq +60 -> 2789
    //   2732: aload_0
    //   2733: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2736: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   2739: aload 14
    //   2741: aload 13
    //   2743: invokevirtual 387	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Ljava/io/File;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2746: astore 13
    //   2748: aload_0
    //   2749: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2752: lload 5
    //   2754: aload 13
    //   2756: invokevirtual 294	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JLorg/json/JSONObject;)V
    //   2759: goto +1159 -> 3918
    //   2762: astore 13
    //   2764: aload_0
    //   2765: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2768: lload 5
    //   2770: iconst_m1
    //   2771: iconst_1
    //   2772: anewarray 4	java/lang/Object
    //   2775: dup
    //   2776: iconst_0
    //   2777: aload 13
    //   2779: invokevirtual 388	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2782: aastore
    //   2783: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2786: goto +1132 -> 3918
    //   2789: aload_0
    //   2790: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2793: astore 14
    //   2795: new 79	java/lang/StringBuilder
    //   2798: dup
    //   2799: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   2802: astore 15
    //   2804: aload 15
    //   2806: ldc_w 379
    //   2809: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2812: pop
    //   2813: aload 15
    //   2815: aload 13
    //   2817: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2820: pop
    //   2821: aload 14
    //   2823: lload 5
    //   2825: iconst_m1
    //   2826: iconst_1
    //   2827: anewarray 4	java/lang/Object
    //   2830: dup
    //   2831: iconst_0
    //   2832: aload 15
    //   2834: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2837: aastore
    //   2838: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2841: goto +1077 -> 3918
    //   2844: aload_0
    //   2845: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2848: lload 5
    //   2850: iconst_m1
    //   2851: iconst_1
    //   2852: anewarray 4	java/lang/Object
    //   2855: dup
    //   2856: iconst_0
    //   2857: ldc_w 390
    //   2860: aastore
    //   2861: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   2864: goto +1054 -> 3918
    //   2867: new 136	org/json/JSONObject
    //   2870: dup
    //   2871: aload 14
    //   2873: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2876: astore 14
    //   2878: aload 14
    //   2880: ldc_w 392
    //   2883: iconst_0
    //   2884: invokevirtual 396	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2887: ifeq +202 -> 3089
    //   2890: new 398	java/util/Date
    //   2893: dup
    //   2894: aload 14
    //   2896: ldc_w 400
    //   2899: invokevirtual 186	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   2902: ldc2_w 187
    //   2905: lmul
    //   2906: invokespecial 403	java/util/Date:<init>	(J)V
    //   2909: astore 14
    //   2911: new 405	java/text/SimpleDateFormat
    //   2914: dup
    //   2915: ldc_w 407
    //   2918: invokespecial 408	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   2921: aload 14
    //   2923: invokevirtual 412	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   2926: astore 14
    //   2928: new 414	android/content/Intent
    //   2931: dup
    //   2932: ldc_w 416
    //   2935: invokespecial 417	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   2938: astore 15
    //   2940: ldc_w 419
    //   2943: invokestatic 425	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   2946: checkcast 419	com/tencent/mobileqq/webview/api/IWebProcessPreload
    //   2949: invokeinterface 428 1 0
    //   2954: ifeq +109 -> 3063
    //   2957: aload_0
    //   2958: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2961: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2964: invokevirtual 432	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2967: invokestatic 130	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   2970: ldc_w 433
    //   2973: if_icmplt +90 -> 3063
    //   2976: aload 15
    //   2978: ldc_w 435
    //   2981: aload 14
    //   2983: invokevirtual 439	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   2986: pop
    //   2987: aload 15
    //   2989: ldc_w 441
    //   2992: aload_0
    //   2993: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   2996: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2999: invokevirtual 444	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3002: invokevirtual 439	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   3005: pop
    //   3006: aload 15
    //   3008: ldc_w 446
    //   3011: new 448	com/tencent/mobileqq/secspy/SecSpyFileManager$2$1
    //   3014: dup
    //   3015: aload_0
    //   3016: aload_0
    //   3017: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3020: getfield 451	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   3023: aload 14
    //   3025: aload 13
    //   3027: invokespecial 454	com/tencent/mobileqq/secspy/SecSpyFileManager$2$1:<init>	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager$2;Landroid/os/Handler;Ljava/lang/String;Ljava/lang/String;)V
    //   3030: invokevirtual 457	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   3033: pop
    //   3034: aload 15
    //   3036: ldc_w 459
    //   3039: lload 5
    //   3041: invokevirtual 462	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   3044: pop
    //   3045: aload_0
    //   3046: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3049: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3052: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3055: aload 15
    //   3057: invokevirtual 468	mqq/app/MobileQQ:sendBroadcast	(Landroid/content/Intent;)V
    //   3060: goto +858 -> 3918
    //   3063: aload_0
    //   3064: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3067: aload 14
    //   3069: aload_0
    //   3070: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3073: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3076: invokevirtual 444	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3079: lload 5
    //   3081: aload 13
    //   3083: invokestatic 471	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V
    //   3086: goto +832 -> 3918
    //   3089: aload 14
    //   3091: ldc_w 400
    //   3094: invokevirtual 186	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   3097: lstore_3
    //   3098: aload 14
    //   3100: ldc_w 473
    //   3103: invokevirtual 186	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   3106: lstore 7
    //   3108: aload_0
    //   3109: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3112: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   3115: lload_3
    //   3116: ldc2_w 187
    //   3119: lmul
    //   3120: lload 7
    //   3122: ldc2_w 187
    //   3125: lmul
    //   3126: invokevirtual 476	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(JJ)Ljava/lang/String;
    //   3129: astore 14
    //   3131: aload_0
    //   3132: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3135: aload 14
    //   3137: lload 5
    //   3139: aload 13
    //   3141: iconst_1
    //   3142: invokevirtual 276	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;JLjava/lang/String;Z)V
    //   3145: goto +773 -> 3918
    //   3148: astore 13
    //   3150: aload_0
    //   3151: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3154: lload 5
    //   3156: iconst_m1
    //   3157: iconst_1
    //   3158: anewarray 4	java/lang/Object
    //   3161: dup
    //   3162: iconst_0
    //   3163: aload 13
    //   3165: invokevirtual 388	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   3168: aastore
    //   3169: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   3172: goto +746 -> 3918
    //   3175: aload_0
    //   3176: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3179: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   3182: aload_0
    //   3183: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3186: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3189: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3192: invokevirtual 479	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager$TerminalInfo;
    //   3195: astore 13
    //   3197: aload_0
    //   3198: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3201: lload 5
    //   3203: aload 13
    //   3205: invokevirtual 484	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager$TerminalInfo:a	()Lorg/json/JSONObject;
    //   3208: invokevirtual 294	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JLorg/json/JSONObject;)V
    //   3211: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3214: ifeq +704 -> 3918
    //   3217: new 79	java/lang/StringBuilder
    //   3220: dup
    //   3221: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3224: astore 14
    //   3226: aload 14
    //   3228: ldc_w 489
    //   3231: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3234: pop
    //   3235: aload 14
    //   3237: aload 13
    //   3239: invokevirtual 484	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager$TerminalInfo:a	()Lorg/json/JSONObject;
    //   3242: invokevirtual 490	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3245: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3248: pop
    //   3249: ldc 100
    //   3251: iconst_2
    //   3252: aload 14
    //   3254: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3257: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3260: goto +658 -> 3918
    //   3263: aconst_null
    //   3264: aload_0
    //   3265: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3268: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3271: invokestatic 495	com/tencent/mobileqq/activity/QQSettingMsgHistoryActivity:a	(Landroid/app/Activity;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   3274: aload_0
    //   3275: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3278: lload 5
    //   3280: iconst_0
    //   3281: iconst_0
    //   3282: anewarray 4	java/lang/Object
    //   3285: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   3288: goto +630 -> 3918
    //   3291: new 136	org/json/JSONObject
    //   3294: dup
    //   3295: aload 14
    //   3297: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3300: ldc 194
    //   3302: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3305: astore 14
    //   3307: aload 14
    //   3309: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3312: istore 9
    //   3314: iload 9
    //   3316: ifne +70 -> 3386
    //   3319: aload_0
    //   3320: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3323: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   3326: aload_0
    //   3327: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3330: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3333: lload 5
    //   3335: aload 14
    //   3337: invokevirtual 498	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;)Ljava/lang/String;
    //   3340: astore 14
    //   3342: aload_0
    //   3343: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3346: aload 14
    //   3348: lload 5
    //   3350: aload 13
    //   3352: iconst_1
    //   3353: invokevirtual 276	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;JLjava/lang/String;Z)V
    //   3356: goto +562 -> 3918
    //   3359: astore 13
    //   3361: aload_0
    //   3362: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3365: lload 5
    //   3367: iconst_m1
    //   3368: iconst_1
    //   3369: anewarray 4	java/lang/Object
    //   3372: dup
    //   3373: iconst_0
    //   3374: aload 13
    //   3376: invokevirtual 268	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3379: aastore
    //   3380: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   3383: goto +535 -> 3918
    //   3386: aload_0
    //   3387: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3390: lload 5
    //   3392: iconst_m1
    //   3393: iconst_1
    //   3394: anewarray 4	java/lang/Object
    //   3397: dup
    //   3398: iconst_0
    //   3399: ldc 243
    //   3401: aastore
    //   3402: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   3405: goto +513 -> 3918
    //   3408: new 136	org/json/JSONObject
    //   3411: dup
    //   3412: aload 14
    //   3414: invokespecial 139	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3417: ldc 194
    //   3419: invokevirtual 145	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3422: astore 13
    //   3424: aload 13
    //   3426: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3429: istore 9
    //   3431: iload 9
    //   3433: ifne +61 -> 3494
    //   3436: aload_0
    //   3437: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3440: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   3443: aload_0
    //   3444: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3447: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3450: lload 5
    //   3452: aload 13
    //   3454: aload_0
    //   3455: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3458: getfield 451	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   3461: invokevirtual 501	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;Landroid/os/Handler;)V
    //   3464: goto +454 -> 3918
    //   3467: astore 13
    //   3469: aload_0
    //   3470: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3473: lload 5
    //   3475: iconst_m1
    //   3476: iconst_1
    //   3477: anewarray 4	java/lang/Object
    //   3480: dup
    //   3481: iconst_0
    //   3482: aload 13
    //   3484: invokevirtual 502	java/io/IOException:getMessage	()Ljava/lang/String;
    //   3487: aastore
    //   3488: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   3491: goto +427 -> 3918
    //   3494: aload_0
    //   3495: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3498: lload 5
    //   3500: iconst_m1
    //   3501: iconst_1
    //   3502: anewarray 4	java/lang/Object
    //   3505: dup
    //   3506: iconst_0
    //   3507: ldc 243
    //   3509: aastore
    //   3510: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   3513: goto +405 -> 3918
    //   3516: aload_0
    //   3517: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3520: getfield 118	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3523: invokevirtual 124	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3526: invokestatic 505	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	(Landroid/app/Application;)V
    //   3529: aload_0
    //   3530: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3533: getfield 165	com/tencent/mobileqq/secspy/SecSpyFileManager:jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager	Lcom/tencent/mobileqq/unifiedebug/UnifiedDebugManager;
    //   3536: invokevirtual 171	com/tencent/mobileqq/unifiedebug/UnifiedDebugManager:a	()Landroid/os/Handler;
    //   3539: aload_0
    //   3540: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3543: invokestatic 174	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Lcom/tencent/mobileqq/secspy/SecSpyFileManager;)Ljava/lang/Runnable;
    //   3546: invokevirtual 180	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3549: aload_0
    //   3550: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3553: lload 5
    //   3555: iconst_0
    //   3556: iconst_0
    //   3557: anewarray 4	java/lang/Object
    //   3560: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   3563: goto +355 -> 3918
    //   3566: aload_0
    //   3567: getfield 17	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x7cSubmsgtype0x7c$MsgBody	Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;
    //   3570: getfield 61	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:rpt_string_cmd_ext	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3573: invokevirtual 508	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   3576: iconst_2
    //   3577: if_icmplt +341 -> 3918
    //   3580: aload_0
    //   3581: getfield 17	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x7cSubmsgtype0x7c$MsgBody	Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;
    //   3584: getfield 61	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:rpt_string_cmd_ext	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   3587: iconst_1
    //   3588: invokevirtual 66	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   3591: checkcast 68	java/lang/String
    //   3594: astore 13
    //   3596: aload 14
    //   3598: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3601: ifne +317 -> 3918
    //   3604: aload 13
    //   3606: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3609: ifne +309 -> 3918
    //   3612: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3615: ifeq +57 -> 3672
    //   3618: new 79	java/lang/StringBuilder
    //   3621: dup
    //   3622: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3625: astore 15
    //   3627: aload 15
    //   3629: ldc_w 510
    //   3632: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3635: pop
    //   3636: aload 15
    //   3638: aload 14
    //   3640: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3643: pop
    //   3644: aload 15
    //   3646: ldc_w 512
    //   3649: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3652: pop
    //   3653: aload 15
    //   3655: aload 13
    //   3657: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3660: pop
    //   3661: ldc 100
    //   3663: iconst_2
    //   3664: aload 15
    //   3666: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3669: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3672: aload_0
    //   3673: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3676: aload 14
    //   3678: invokevirtual 364	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   3681: astore 14
    //   3683: aload_0
    //   3684: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3687: aload 13
    //   3689: invokevirtual 364	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   3692: astore 13
    //   3694: aload 14
    //   3696: ifnull +222 -> 3918
    //   3699: aload 13
    //   3701: ifnull +217 -> 3918
    //   3704: aload 14
    //   3706: invokevirtual 369	java/io/File:exists	()Z
    //   3709: ifeq +209 -> 3918
    //   3712: aload 14
    //   3714: aload 13
    //   3716: invokevirtual 516	java/io/File:renameTo	(Ljava/io/File;)Z
    //   3719: pop
    //   3720: aload_0
    //   3721: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3724: lload 5
    //   3726: iconst_0
    //   3727: iconst_0
    //   3728: anewarray 4	java/lang/Object
    //   3731: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   3734: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3737: ifeq +12 -> 3749
    //   3740: ldc 100
    //   3742: iconst_2
    //   3743: ldc_w 518
    //   3746: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3749: iconst_1
    //   3750: istore 9
    //   3752: goto +406 -> 4158
    //   3755: aload 14
    //   3757: invokestatic 151	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3760: ifne +158 -> 3918
    //   3763: aload_0
    //   3764: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3767: aload 14
    //   3769: invokevirtual 364	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;)Ljava/io/File;
    //   3772: astore 13
    //   3774: aload 13
    //   3776: ifnull +142 -> 3918
    //   3779: aload 13
    //   3781: invokevirtual 369	java/io/File:exists	()Z
    //   3784: ifeq +134 -> 3918
    //   3787: aload 13
    //   3789: invokevirtual 521	java/io/File:isFile	()Z
    //   3792: ifeq +126 -> 3918
    //   3795: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3798: ifeq +40 -> 3838
    //   3801: new 79	java/lang/StringBuilder
    //   3804: dup
    //   3805: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   3808: astore 15
    //   3810: aload 15
    //   3812: ldc_w 523
    //   3815: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3818: pop
    //   3819: aload 15
    //   3821: aload 14
    //   3823: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3826: pop
    //   3827: ldc 100
    //   3829: iconst_2
    //   3830: aload 15
    //   3832: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3835: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3838: aload 13
    //   3840: invokevirtual 526	java/io/File:delete	()Z
    //   3843: pop
    //   3844: aload 13
    //   3846: invokevirtual 529	java/io/File:createNewFile	()Z
    //   3849: pop
    //   3850: aload_0
    //   3851: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3854: lload 5
    //   3856: iconst_0
    //   3857: iconst_0
    //   3858: anewarray 4	java/lang/Object
    //   3861: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   3864: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3867: ifeq -118 -> 3749
    //   3870: ldc 100
    //   3872: iconst_2
    //   3873: ldc_w 531
    //   3876: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3879: goto -130 -> 3749
    //   3882: astore 14
    //   3884: ldc 134
    //   3886: astore 13
    //   3888: iconst_1
    //   3889: istore 9
    //   3891: goto +687 -> 4578
    //   3894: astore 14
    //   3896: ldc 134
    //   3898: astore 13
    //   3900: iconst_1
    //   3901: istore 9
    //   3903: goto +423 -> 4326
    //   3906: astore 14
    //   3908: ldc 134
    //   3910: astore 13
    //   3912: iconst_1
    //   3913: istore 9
    //   3915: goto +522 -> 4437
    //   3918: iconst_0
    //   3919: istore 9
    //   3921: goto +237 -> 4158
    //   3924: aload_0
    //   3925: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3928: lload 5
    //   3930: iconst_2
    //   3931: iconst_0
    //   3932: anewarray 4	java/lang/Object
    //   3935: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   3938: aload_0
    //   3939: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3942: aload 14
    //   3944: lload 5
    //   3946: aload 13
    //   3948: iconst_1
    //   3949: invokevirtual 534	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;JLjava/lang/String;Z)Z
    //   3952: istore 9
    //   3954: iload 9
    //   3956: istore 10
    //   3958: iload 9
    //   3960: ifeq +194 -> 4154
    //   3963: iload 9
    //   3965: istore 10
    //   3967: iload 9
    //   3969: istore 11
    //   3971: iload 9
    //   3973: istore 12
    //   3975: aload_0
    //   3976: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   3979: lload 5
    //   3981: iconst_0
    //   3982: iconst_0
    //   3983: anewarray 4	java/lang/Object
    //   3986: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   3989: iload 9
    //   3991: istore 10
    //   3993: goto +161 -> 4154
    //   3996: astore 13
    //   3998: aload 13
    //   4000: astore 14
    //   4002: ldc 134
    //   4004: astore 13
    //   4006: goto +274 -> 4280
    //   4009: astore 13
    //   4011: aload 13
    //   4013: astore 14
    //   4015: ldc 134
    //   4017: astore 13
    //   4019: goto +281 -> 4300
    //   4022: astore 13
    //   4024: aload 13
    //   4026: astore 14
    //   4028: ldc 134
    //   4030: astore 13
    //   4032: goto +288 -> 4320
    //   4035: ldc 134
    //   4037: astore 15
    //   4039: aload_0
    //   4040: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   4043: astore 15
    //   4045: aload 15
    //   4047: lload 5
    //   4049: iconst_2
    //   4050: iconst_0
    //   4051: anewarray 4	java/lang/Object
    //   4054: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   4057: aload_0
    //   4058: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   4061: aload 14
    //   4063: lload 5
    //   4065: aload 13
    //   4067: iconst_0
    //   4068: invokevirtual 534	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ljava/lang/String;JLjava/lang/String;Z)Z
    //   4071: istore 9
    //   4073: iload 9
    //   4075: istore 10
    //   4077: iload 9
    //   4079: ifeq +75 -> 4154
    //   4082: iload 9
    //   4084: istore 10
    //   4086: iload 9
    //   4088: istore 11
    //   4090: iload 9
    //   4092: istore 12
    //   4094: aload_0
    //   4095: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   4098: lload 5
    //   4100: iconst_0
    //   4101: iconst_0
    //   4102: anewarray 4	java/lang/Object
    //   4105: invokevirtual 115	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(JI[Ljava/lang/Object;)V
    //   4108: iload 9
    //   4110: istore 10
    //   4112: goto +42 -> 4154
    //   4115: astore 14
    //   4117: iload 10
    //   4119: istore 9
    //   4121: ldc 134
    //   4123: astore 13
    //   4125: goto +453 -> 4578
    //   4128: astore 14
    //   4130: iload 11
    //   4132: istore 9
    //   4134: ldc 134
    //   4136: astore 13
    //   4138: goto +188 -> 4326
    //   4141: astore 14
    //   4143: iload 12
    //   4145: istore 9
    //   4147: ldc 134
    //   4149: astore 13
    //   4151: goto +286 -> 4437
    //   4154: iload 10
    //   4156: istore 9
    //   4158: iload_1
    //   4159: bipush 10
    //   4161: if_icmpge +406 -> 4567
    //   4164: iload 9
    //   4166: ifne +401 -> 4567
    //   4169: aload_0
    //   4170: getfield 19	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_Int	I
    //   4173: ifle +394 -> 4567
    //   4176: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4179: ifeq +43 -> 4222
    //   4182: new 79	java/lang/StringBuilder
    //   4185: dup
    //   4186: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4189: astore 13
    //   4191: aload 13
    //   4193: ldc 134
    //   4195: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4198: pop
    //   4199: aload 13
    //   4201: aload_0
    //   4202: getfield 19	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_Int	I
    //   4205: iconst_1
    //   4206: isub
    //   4207: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4210: pop
    //   4211: ldc 100
    //   4213: iconst_2
    //   4214: aload 13
    //   4216: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4219: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4222: ldc2_w 187
    //   4225: invokestatic 539	java/lang/Thread:sleep	(J)V
    //   4228: goto +322 -> 4550
    //   4231: astore 13
    //   4233: goto +312 -> 4545
    //   4236: astore 13
    //   4238: goto +30 -> 4268
    //   4241: astore 13
    //   4243: goto +45 -> 4288
    //   4246: astore 13
    //   4248: goto +60 -> 4308
    //   4251: astore 13
    //   4253: goto +15 -> 4268
    //   4256: astore 13
    //   4258: goto +30 -> 4288
    //   4261: astore 13
    //   4263: goto +45 -> 4308
    //   4266: astore 13
    //   4268: ldc 134
    //   4270: astore 15
    //   4272: aload 13
    //   4274: astore 14
    //   4276: aload 15
    //   4278: astore 13
    //   4280: iconst_0
    //   4281: istore 9
    //   4283: goto +295 -> 4578
    //   4286: astore 13
    //   4288: ldc 134
    //   4290: astore 15
    //   4292: aload 13
    //   4294: astore 14
    //   4296: aload 15
    //   4298: astore 13
    //   4300: iconst_0
    //   4301: istore 9
    //   4303: goto +23 -> 4326
    //   4306: astore 13
    //   4308: ldc 134
    //   4310: astore 15
    //   4312: aload 13
    //   4314: astore 14
    //   4316: aload 15
    //   4318: astore 13
    //   4320: iconst_0
    //   4321: istore 9
    //   4323: goto +114 -> 4437
    //   4326: aload 13
    //   4328: astore 15
    //   4330: iload 9
    //   4332: istore 10
    //   4334: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4337: ifeq +22 -> 4359
    //   4340: aload 13
    //   4342: astore 15
    //   4344: iload 9
    //   4346: istore 10
    //   4348: ldc 100
    //   4350: iconst_2
    //   4351: ldc_w 541
    //   4354: aload 14
    //   4356: invokestatic 545	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4359: iload_1
    //   4360: bipush 10
    //   4362: if_icmpge +205 -> 4567
    //   4365: iload 9
    //   4367: ifne +200 -> 4567
    //   4370: aload_0
    //   4371: getfield 19	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_Int	I
    //   4374: ifle +193 -> 4567
    //   4377: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4380: ifeq +43 -> 4423
    //   4383: new 79	java/lang/StringBuilder
    //   4386: dup
    //   4387: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4390: astore 14
    //   4392: aload 14
    //   4394: aload 13
    //   4396: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4399: pop
    //   4400: aload 14
    //   4402: aload_0
    //   4403: getfield 19	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_Int	I
    //   4406: iconst_1
    //   4407: isub
    //   4408: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4411: pop
    //   4412: ldc 100
    //   4414: iconst_2
    //   4415: aload 14
    //   4417: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4420: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4423: ldc2_w 187
    //   4426: invokestatic 539	java/lang/Thread:sleep	(J)V
    //   4429: goto +121 -> 4550
    //   4432: astore 13
    //   4434: goto +111 -> 4545
    //   4437: aload 13
    //   4439: astore 15
    //   4441: iload 9
    //   4443: istore 10
    //   4445: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4448: ifeq +22 -> 4470
    //   4451: aload 13
    //   4453: astore 15
    //   4455: iload 9
    //   4457: istore 10
    //   4459: ldc 100
    //   4461: iconst_2
    //   4462: ldc_w 547
    //   4465: aload 14
    //   4467: invokestatic 545	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4470: iload_1
    //   4471: bipush 10
    //   4473: if_icmpge +94 -> 4567
    //   4476: iload 9
    //   4478: ifne +89 -> 4567
    //   4481: aload_0
    //   4482: getfield 19	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_Int	I
    //   4485: ifle +82 -> 4567
    //   4488: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4491: ifeq +43 -> 4534
    //   4494: new 79	java/lang/StringBuilder
    //   4497: dup
    //   4498: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4501: astore 14
    //   4503: aload 14
    //   4505: aload 13
    //   4507: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4510: pop
    //   4511: aload 14
    //   4513: aload_0
    //   4514: getfield 19	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_Int	I
    //   4517: iconst_1
    //   4518: isub
    //   4519: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4522: pop
    //   4523: ldc 100
    //   4525: iconst_2
    //   4526: aload 14
    //   4528: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4531: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4534: ldc2_w 187
    //   4537: invokestatic 539	java/lang/Thread:sleep	(J)V
    //   4540: goto +10 -> 4550
    //   4543: astore 13
    //   4545: aload 13
    //   4547: invokevirtual 550	java/lang/InterruptedException:printStackTrace	()V
    //   4550: aload_0
    //   4551: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   4554: aload_0
    //   4555: getfield 17	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x7cSubmsgtype0x7c$MsgBody	Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;
    //   4558: aload_0
    //   4559: getfield 19	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_Int	I
    //   4562: iconst_1
    //   4563: isub
    //   4564: invokevirtual 553	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;I)V
    //   4567: return
    //   4568: astore 14
    //   4570: iload 10
    //   4572: istore 9
    //   4574: aload 15
    //   4576: astore 13
    //   4578: iload_1
    //   4579: bipush 10
    //   4581: if_icmpge +94 -> 4675
    //   4584: iload 9
    //   4586: ifne +89 -> 4675
    //   4589: aload_0
    //   4590: getfield 19	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_Int	I
    //   4593: ifle +82 -> 4675
    //   4596: invokestatic 487	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4599: ifeq +43 -> 4642
    //   4602: new 79	java/lang/StringBuilder
    //   4605: dup
    //   4606: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   4609: astore 15
    //   4611: aload 15
    //   4613: aload 13
    //   4615: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4618: pop
    //   4619: aload 15
    //   4621: aload_0
    //   4622: getfield 19	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_Int	I
    //   4625: iconst_1
    //   4626: isub
    //   4627: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4630: pop
    //   4631: ldc 100
    //   4633: iconst_2
    //   4634: aload 15
    //   4636: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4639: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4642: ldc2_w 187
    //   4645: invokestatic 539	java/lang/Thread:sleep	(J)V
    //   4648: goto +10 -> 4658
    //   4651: astore 13
    //   4653: aload 13
    //   4655: invokevirtual 550	java/lang/InterruptedException:printStackTrace	()V
    //   4658: aload_0
    //   4659: getfield 15	com/tencent/mobileqq/secspy/SecSpyFileManager$2:this$0	Lcom/tencent/mobileqq/secspy/SecSpyFileManager;
    //   4662: aload_0
    //   4663: getfield 17	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x7cSubmsgtype0x7c$MsgBody	Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;
    //   4666: aload_0
    //   4667: getfield 19	com/tencent/mobileqq/secspy/SecSpyFileManager$2:jdField_a_of_type_Int	I
    //   4670: iconst_1
    //   4671: isub
    //   4672: invokevirtual 553	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;I)V
    //   4675: goto +6 -> 4681
    //   4678: aload 14
    //   4680: athrow
    //   4681: goto -3 -> 4678
    //   4684: lload_3
    //   4685: ldc2_w 187
    //   4688: lmul
    //   4689: lstore_3
    //   4690: goto -4072 -> 618
    //   4693: astore 13
    //   4695: goto -697 -> 3998
    //   4698: astore 13
    //   4700: goto -689 -> 4011
    //   4703: astore 13
    //   4705: goto -681 -> 4024
    //   4708: lload_3
    //   4709: lconst_0
    //   4710: lcmp
    //   4711: ifgt +10 -> 4721
    //   4714: ldc2_w 228
    //   4717: lstore_3
    //   4718: goto -3839 -> 879
    //   4721: lload_3
    //   4722: ldc2_w 187
    //   4725: lmul
    //   4726: lstore_3
    //   4727: goto -3848 -> 879
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4730	0	this	2
    //   10	4152	1	i	int
    //   316	583	2	j	int
    //   478	2638	3	l1	long
    //   21	4078	5	l2	long
    //   3106	15	7	l3	long
    //   419	3746	9	bool1	boolean
    //   3956	199	10	bool2	boolean
    //   3969	162	11	bool3	boolean
    //   3973	171	12	bool4	boolean
    //   66	937	13	str1	java.lang.String
    //   1026	141	13	localException1	java.lang.Exception
    //   1179	29	13	localSecSpyFileManager	SecSpyFileManager
    //   1230	16	13	localException2	java.lang.Exception
    //   1299	21	13	localSet1	java.util.Set
    //   1342	16	13	localException3	java.lang.Exception
    //   1387	54	13	str2	java.lang.String
    //   1464	16	13	localException4	java.lang.Exception
    //   1595	146	13	localJSONObject1	org.json.JSONObject
    //   1748	16	13	localSQLiteException	android.database.sqlite.SQLiteException
    //   1817	21	13	localSet2	java.util.Set
    //   1860	16	13	localException5	java.lang.Exception
    //   1902	36	13	localObject1	Object
    //   1945	116	13	localException6	java.lang.Exception
    //   2069	16	13	localException7	java.lang.Exception
    //   2139	21	13	localList	java.util.List
    //   2182	16	13	localException8	java.lang.Exception
    //   2228	527	13	localObject2	Object
    //   2762	378	13	localJSONException1	org.json.JSONException
    //   3148	16	13	localJSONException2	org.json.JSONException
    //   3195	156	13	localTerminalInfo	com.tencent.mobileqq.unifiedebug.UnifiedDebugManager.TerminalInfo
    //   3359	16	13	localException9	java.lang.Exception
    //   3422	31	13	str3	java.lang.String
    //   3467	16	13	localIOException	java.io.IOException
    //   3594	353	13	localObject3	Object
    //   3996	3	13	localObject4	Object
    //   4004	1	13	str4	java.lang.String
    //   4009	3	13	localException10	java.lang.Exception
    //   4017	1	13	str5	java.lang.String
    //   4022	3	13	localInvalidProtocolBufferMicroException1	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   4030	185	13	localObject5	Object
    //   4231	1	13	localInterruptedException	java.lang.InterruptedException
    //   37	89	14	str6	java.lang.String
    //   343	1	14	localObject6	Object
    //   352	1	14	localException11	java.lang.Exception
    //   361	14	14	localInvalidProtocolBufferMicroException2	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   379	3443	14	localObject7	Object
    //   3882	1	14	localObject8	Object
    //   3894	1	14	localException12	java.lang.Exception
    //   3906	37	14	localInvalidProtocolBufferMicroException3	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   4000	62	14	localObject9	Object
    //   4115	1	14	localObject10	Object
    //   4128	1	14	localException13	java.lang.Exception
    //   4141	1	14	localInvalidProtocolBufferMicroException4	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   82	3964	15	localObject11	Object
    //   433	2121	16	localObject12	Object
    //   1654	61	17	localJSONObject2	org.json.JSONObject
    //   1668	13	18	localIterator	java.util.Iterator
    //   1690	9	19	str7	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   321	340	343	finally
    //   426	451	343	finally
    //   556	569	343	finally
    //   572	591	343	finally
    //   321	340	352	java/lang/Exception
    //   426	451	352	java/lang/Exception
    //   556	569	352	java/lang/Exception
    //   572	591	352	java/lang/Exception
    //   321	340	361	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   426	451	361	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   556	569	361	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   572	591	361	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   985	1023	1026	java/lang/Exception
    //   1126	1172	1230	java/lang/Exception
    //   1175	1227	1230	java/lang/Exception
    //   1279	1339	1342	java/lang/Exception
    //   1423	1461	1464	java/lang/Exception
    //   1564	1625	1748	android/database/sqlite/SQLiteException
    //   1625	1670	1748	android/database/sqlite/SQLiteException
    //   1670	1709	1748	android/database/sqlite/SQLiteException
    //   1712	1720	1748	android/database/sqlite/SQLiteException
    //   1723	1745	1748	android/database/sqlite/SQLiteException
    //   1797	1857	1860	java/lang/Exception
    //   1920	1942	1945	java/lang/Exception
    //   2028	2066	2069	java/lang/Exception
    //   2119	2179	2182	java/lang/Exception
    //   2732	2759	2762	org/json/JSONException
    //   3089	3145	3148	org/json/JSONException
    //   3319	3356	3359	java/lang/Exception
    //   3436	3464	3467	java/io/IOException
    //   3720	3749	3882	finally
    //   3850	3879	3882	finally
    //   3720	3749	3894	java/lang/Exception
    //   3850	3879	3894	java/lang/Exception
    //   3720	3749	3906	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3850	3879	3906	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   648	663	3996	finally
    //   666	685	3996	finally
    //   688	702	3996	finally
    //   705	724	3996	finally
    //   727	758	3996	finally
    //   764	790	3996	finally
    //   793	854	3996	finally
    //   857	876	3996	finally
    //   879	907	3996	finally
    //   910	929	3996	finally
    //   932	969	3996	finally
    //   974	985	3996	finally
    //   985	1023	3996	finally
    //   1028	1050	3996	finally
    //   1053	1073	3996	finally
    //   1076	1095	3996	finally
    //   1098	1121	3996	finally
    //   1126	1172	3996	finally
    //   1175	1227	3996	finally
    //   1232	1254	3996	finally
    //   1257	1276	3996	finally
    //   1279	1339	3996	finally
    //   1344	1366	3996	finally
    //   1369	1407	3996	finally
    //   1412	1423	3996	finally
    //   1423	1461	3996	finally
    //   1466	1488	3996	finally
    //   1491	1511	3996	finally
    //   1514	1533	3996	finally
    //   1536	1559	3996	finally
    //   1564	1625	3996	finally
    //   1625	1670	3996	finally
    //   1670	1709	3996	finally
    //   1712	1720	3996	finally
    //   1723	1745	3996	finally
    //   1750	1772	3996	finally
    //   1775	1794	3996	finally
    //   1797	1857	3996	finally
    //   1862	1884	3996	finally
    //   1887	1904	3996	finally
    //   1909	1920	3996	finally
    //   1920	1942	3996	finally
    //   1947	1969	3996	finally
    //   1972	1992	3996	finally
    //   1995	2012	3996	finally
    //   2017	2028	3996	finally
    //   2028	2066	3996	finally
    //   2071	2093	3996	finally
    //   2096	2116	3996	finally
    //   2119	2179	3996	finally
    //   2184	2206	3996	finally
    //   2209	2240	3996	finally
    //   2245	2278	3996	finally
    //   2283	2341	3996	finally
    //   2344	2364	3996	finally
    //   2367	2419	3996	finally
    //   2422	2442	3996	finally
    //   2445	2476	3996	finally
    //   2481	2514	3996	finally
    //   2519	2576	3996	finally
    //   2579	2631	3996	finally
    //   2634	2654	3996	finally
    //   2657	2707	3996	finally
    //   2712	2727	3996	finally
    //   2732	2759	3996	finally
    //   2764	2786	3996	finally
    //   2789	2841	3996	finally
    //   2844	2864	3996	finally
    //   2867	3060	3996	finally
    //   3063	3086	3996	finally
    //   3089	3145	3996	finally
    //   3150	3172	3996	finally
    //   3175	3260	3996	finally
    //   3263	3288	3996	finally
    //   3291	3314	3996	finally
    //   3319	3356	3996	finally
    //   3361	3383	3996	finally
    //   3386	3405	3996	finally
    //   3408	3431	3996	finally
    //   3436	3464	3996	finally
    //   3469	3491	3996	finally
    //   3494	3513	3996	finally
    //   3516	3563	3996	finally
    //   3566	3672	3996	finally
    //   3672	3694	3996	finally
    //   3704	3720	3996	finally
    //   3755	3774	3996	finally
    //   3779	3838	3996	finally
    //   3838	3850	3996	finally
    //   3924	3954	3996	finally
    //   648	663	4009	java/lang/Exception
    //   666	685	4009	java/lang/Exception
    //   688	702	4009	java/lang/Exception
    //   705	724	4009	java/lang/Exception
    //   727	758	4009	java/lang/Exception
    //   764	790	4009	java/lang/Exception
    //   793	854	4009	java/lang/Exception
    //   857	876	4009	java/lang/Exception
    //   879	907	4009	java/lang/Exception
    //   910	929	4009	java/lang/Exception
    //   932	969	4009	java/lang/Exception
    //   974	985	4009	java/lang/Exception
    //   1028	1050	4009	java/lang/Exception
    //   1053	1073	4009	java/lang/Exception
    //   1076	1095	4009	java/lang/Exception
    //   1098	1121	4009	java/lang/Exception
    //   1232	1254	4009	java/lang/Exception
    //   1257	1276	4009	java/lang/Exception
    //   1344	1366	4009	java/lang/Exception
    //   1369	1407	4009	java/lang/Exception
    //   1412	1423	4009	java/lang/Exception
    //   1466	1488	4009	java/lang/Exception
    //   1491	1511	4009	java/lang/Exception
    //   1514	1533	4009	java/lang/Exception
    //   1536	1559	4009	java/lang/Exception
    //   1564	1625	4009	java/lang/Exception
    //   1625	1670	4009	java/lang/Exception
    //   1670	1709	4009	java/lang/Exception
    //   1712	1720	4009	java/lang/Exception
    //   1723	1745	4009	java/lang/Exception
    //   1750	1772	4009	java/lang/Exception
    //   1775	1794	4009	java/lang/Exception
    //   1862	1884	4009	java/lang/Exception
    //   1887	1904	4009	java/lang/Exception
    //   1909	1920	4009	java/lang/Exception
    //   1947	1969	4009	java/lang/Exception
    //   1972	1992	4009	java/lang/Exception
    //   1995	2012	4009	java/lang/Exception
    //   2017	2028	4009	java/lang/Exception
    //   2071	2093	4009	java/lang/Exception
    //   2096	2116	4009	java/lang/Exception
    //   2184	2206	4009	java/lang/Exception
    //   2209	2240	4009	java/lang/Exception
    //   2245	2278	4009	java/lang/Exception
    //   2283	2341	4009	java/lang/Exception
    //   2344	2364	4009	java/lang/Exception
    //   2367	2419	4009	java/lang/Exception
    //   2422	2442	4009	java/lang/Exception
    //   2445	2476	4009	java/lang/Exception
    //   2481	2514	4009	java/lang/Exception
    //   2519	2576	4009	java/lang/Exception
    //   2579	2631	4009	java/lang/Exception
    //   2634	2654	4009	java/lang/Exception
    //   2657	2707	4009	java/lang/Exception
    //   2712	2727	4009	java/lang/Exception
    //   2732	2759	4009	java/lang/Exception
    //   2764	2786	4009	java/lang/Exception
    //   2789	2841	4009	java/lang/Exception
    //   2844	2864	4009	java/lang/Exception
    //   2867	3060	4009	java/lang/Exception
    //   3063	3086	4009	java/lang/Exception
    //   3089	3145	4009	java/lang/Exception
    //   3150	3172	4009	java/lang/Exception
    //   3175	3260	4009	java/lang/Exception
    //   3263	3288	4009	java/lang/Exception
    //   3291	3314	4009	java/lang/Exception
    //   3361	3383	4009	java/lang/Exception
    //   3386	3405	4009	java/lang/Exception
    //   3408	3431	4009	java/lang/Exception
    //   3436	3464	4009	java/lang/Exception
    //   3469	3491	4009	java/lang/Exception
    //   3494	3513	4009	java/lang/Exception
    //   3516	3563	4009	java/lang/Exception
    //   3566	3672	4009	java/lang/Exception
    //   3672	3694	4009	java/lang/Exception
    //   3704	3720	4009	java/lang/Exception
    //   3755	3774	4009	java/lang/Exception
    //   3779	3838	4009	java/lang/Exception
    //   3838	3850	4009	java/lang/Exception
    //   3924	3954	4009	java/lang/Exception
    //   648	663	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   666	685	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   688	702	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   705	724	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   727	758	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   764	790	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   793	854	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   857	876	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   879	907	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   910	929	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   932	969	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   974	985	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   985	1023	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1028	1050	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1053	1073	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1076	1095	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1098	1121	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1126	1172	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1175	1227	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1232	1254	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1257	1276	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1279	1339	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1344	1366	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1369	1407	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1412	1423	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1423	1461	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1466	1488	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1491	1511	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1514	1533	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1536	1559	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1564	1625	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1625	1670	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1670	1709	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1712	1720	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1723	1745	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1750	1772	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1775	1794	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1797	1857	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1862	1884	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1887	1904	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1909	1920	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1920	1942	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1947	1969	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1972	1992	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1995	2012	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2017	2028	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2028	2066	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2071	2093	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2096	2116	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2119	2179	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2184	2206	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2209	2240	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2245	2278	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2283	2341	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2344	2364	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2367	2419	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2422	2442	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2445	2476	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2481	2514	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2519	2576	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2579	2631	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2634	2654	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2657	2707	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2712	2727	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2732	2759	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2764	2786	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2789	2841	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2844	2864	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2867	3060	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3063	3086	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3089	3145	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3150	3172	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3175	3260	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3263	3288	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3291	3314	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3319	3356	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3361	3383	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3386	3405	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3408	3431	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3436	3464	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3469	3491	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3494	3513	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3516	3563	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3566	3672	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3672	3694	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3704	3720	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3755	3774	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3779	3838	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3838	3850	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3924	3954	4022	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3975	3989	4115	finally
    //   4094	4108	4115	finally
    //   3975	3989	4128	java/lang/Exception
    //   4094	4108	4128	java/lang/Exception
    //   3975	3989	4141	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4094	4108	4141	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4222	4228	4231	java/lang/InterruptedException
    //   4039	4045	4251	finally
    //   4045	4073	4251	finally
    //   4039	4045	4256	java/lang/Exception
    //   4045	4073	4256	java/lang/Exception
    //   4039	4045	4261	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4045	4073	4261	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   75	172	4266	finally
    //   75	172	4286	java/lang/Exception
    //   75	172	4306	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4423	4429	4432	java/lang/InterruptedException
    //   4534	4540	4543	java/lang/InterruptedException
    //   4334	4340	4568	finally
    //   4348	4359	4568	finally
    //   4445	4451	4568	finally
    //   4459	4470	4568	finally
    //   4642	4648	4651	java/lang/InterruptedException
    //   303	317	4693	finally
    //   370	421	4693	finally
    //   451	551	4693	finally
    //   594	605	4693	finally
    //   618	648	4693	finally
    //   303	317	4698	java/lang/Exception
    //   370	421	4698	java/lang/Exception
    //   451	551	4698	java/lang/Exception
    //   594	605	4698	java/lang/Exception
    //   618	648	4698	java/lang/Exception
    //   303	317	4703	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   370	421	4703	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   451	551	4703	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   594	605	4703	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   618	648	4703	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.secspy.SecSpyFileManager.2
 * JD-Core Version:    0.7.0.1
 */