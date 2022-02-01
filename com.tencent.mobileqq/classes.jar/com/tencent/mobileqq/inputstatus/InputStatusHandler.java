package com.tencent.mobileqq.inputstatus;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.InputNotifyReq;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.InputNotifyRsp;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.ReqBody;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class InputStatusHandler
  extends BusinessHandler
{
  private static final String jdField_a_of_type_JavaLangString = "InputStatusHandler";
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public InputStatusHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    cmd0xcd4.RspBody localRspBody = new cmd0xcd4.RspBody();
    parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (cmd0xcd4.InputNotifyRsp)localRspBody.input_notify.get();
    boolean bool;
    if (paramFromServiceMsg.sint32_result.get() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    notifyUI(1, bool, paramFromServiceMsg);
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 60	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 4
    //   6: iconst_0
    //   7: istore 10
    //   9: iconst_0
    //   10: istore 9
    //   12: iconst_0
    //   13: istore 8
    //   15: iload 4
    //   17: ifeq +13 -> 30
    //   20: aload_3
    //   21: ifnull +9 -> 30
    //   24: iconst_1
    //   25: istore 4
    //   27: goto +6 -> 33
    //   30: iconst_0
    //   31: istore 4
    //   33: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +42 -> 78
    //   39: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: astore_2
    //   43: new 69	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   50: astore 13
    //   52: aload 13
    //   54: ldc 72
    //   56: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 13
    //   62: iload 4
    //   64: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_2
    //   69: iconst_2
    //   70: aload 13
    //   72: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iload 4
    //   80: istore 7
    //   82: iload 4
    //   84: ifeq +625 -> 709
    //   87: iload 4
    //   89: istore 5
    //   91: iload 4
    //   93: istore 6
    //   95: new 89	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   98: dup
    //   99: invokespecial 90	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   102: aload_3
    //   103: checkcast 92	[B
    //   106: checkcast 92	[B
    //   109: invokevirtual 96	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   112: checkcast 89	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   115: astore_2
    //   116: iload 4
    //   118: istore 5
    //   120: iload 4
    //   122: istore 6
    //   124: aload_2
    //   125: getfield 100	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   128: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   131: ifne +627 -> 758
    //   134: iconst_1
    //   135: istore 4
    //   137: goto +3 -> 140
    //   140: iload 4
    //   142: istore 5
    //   144: iload 4
    //   146: istore 6
    //   148: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +82 -> 233
    //   154: iload 4
    //   156: istore 5
    //   158: iload 4
    //   160: istore 6
    //   162: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   165: astore_3
    //   166: iload 4
    //   168: istore 5
    //   170: iload 4
    //   172: istore 6
    //   174: new 69	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   181: astore 13
    //   183: iload 4
    //   185: istore 5
    //   187: iload 4
    //   189: istore 6
    //   191: aload 13
    //   193: ldc 105
    //   195: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: iload 4
    //   201: istore 5
    //   203: iload 4
    //   205: istore 6
    //   207: aload 13
    //   209: iload 4
    //   211: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: iload 4
    //   217: istore 5
    //   219: iload 4
    //   221: istore 6
    //   223: aload_3
    //   224: iconst_2
    //   225: aload 13
    //   227: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: iload 4
    //   235: istore 7
    //   237: iload 4
    //   239: ifeq +470 -> 709
    //   242: iload 4
    //   244: istore 5
    //   246: iload 4
    //   248: istore 6
    //   250: iload 4
    //   252: istore 7
    //   254: aload_2
    //   255: getfield 109	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   258: invokevirtual 114	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   261: ifeq +448 -> 709
    //   264: iload 4
    //   266: istore 5
    //   268: iload 4
    //   270: istore 6
    //   272: iload 4
    //   274: istore 7
    //   276: aload_2
    //   277: getfield 109	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   280: invokevirtual 117	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   283: ifnull +426 -> 709
    //   286: iload 4
    //   288: istore 5
    //   290: iload 4
    //   292: istore 6
    //   294: aload_2
    //   295: getfield 109	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   298: invokevirtual 117	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   301: invokevirtual 123	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   304: invokestatic 129	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   307: invokevirtual 132	java/nio/ByteBuffer:getInt	()I
    //   310: invokestatic 137	com/tencent/mobileqq/util/Utils:a	(I)J
    //   313: lstore 11
    //   315: iload 4
    //   317: istore 5
    //   319: iload 4
    //   321: istore 6
    //   323: aload_0
    //   324: getfield 19	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   327: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   330: lload 11
    //   332: invokestatic 148	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   335: invokevirtual 152	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq +52 -> 390
    //   341: iload 4
    //   343: istore 5
    //   345: iload 4
    //   347: istore 6
    //   349: aload_1
    //   350: getfield 158	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   353: ldc 160
    //   355: invokevirtual 166	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   358: istore 4
    //   360: aload_0
    //   361: getfield 19	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   364: iload 4
    //   366: iconst_0
    //   367: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:setVisibilityForInputStatus	(ZZ)V
    //   370: iconst_1
    //   371: istore 5
    //   373: goto +343 -> 716
    //   376: astore_2
    //   377: iconst_1
    //   378: istore 5
    //   380: goto +259 -> 639
    //   383: astore_2
    //   384: iconst_1
    //   385: istore 5
    //   387: goto +150 -> 537
    //   390: iload 4
    //   392: istore 5
    //   394: iload 4
    //   396: istore 6
    //   398: iload 10
    //   400: istore 7
    //   402: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq +304 -> 709
    //   408: iload 4
    //   410: istore 5
    //   412: iload 4
    //   414: istore 6
    //   416: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   419: astore_2
    //   420: iload 4
    //   422: istore 5
    //   424: iload 4
    //   426: istore 6
    //   428: new 69	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   435: astore_3
    //   436: iload 4
    //   438: istore 5
    //   440: iload 4
    //   442: istore 6
    //   444: aload_3
    //   445: ldc 172
    //   447: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: iload 4
    //   453: istore 5
    //   455: iload 4
    //   457: istore 6
    //   459: aload_3
    //   460: aload_0
    //   461: getfield 19	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   464: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   467: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: iload 4
    //   473: istore 5
    //   475: iload 4
    //   477: istore 6
    //   479: aload_3
    //   480: ldc 174
    //   482: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: iload 4
    //   488: istore 5
    //   490: iload 4
    //   492: istore 6
    //   494: aload_3
    //   495: lload 11
    //   497: invokevirtual 177	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: iload 4
    //   503: istore 5
    //   505: iload 4
    //   507: istore 6
    //   509: aload_2
    //   510: iconst_2
    //   511: aload_3
    //   512: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: iload 10
    //   520: istore 7
    //   522: goto +187 -> 709
    //   525: astore_2
    //   526: goto +113 -> 639
    //   529: astore_2
    //   530: iload 6
    //   532: istore 5
    //   534: iconst_0
    //   535: istore 4
    //   537: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   540: ifeq +13 -> 553
    //   543: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   546: iconst_1
    //   547: ldc 179
    //   549: aload_2
    //   550: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   553: iload 9
    //   555: istore 6
    //   557: iload 4
    //   559: istore 7
    //   561: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq +181 -> 745
    //   567: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   570: astore_3
    //   571: new 69	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   578: astore_2
    //   579: iload 8
    //   581: istore 5
    //   583: aload_2
    //   584: ldc 105
    //   586: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload_2
    //   591: iload 5
    //   593: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload_2
    //   598: ldc 184
    //   600: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload_2
    //   605: aload_1
    //   606: getfield 158	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   609: ldc 160
    //   611: invokevirtual 166	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   614: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload_3
    //   619: iconst_2
    //   620: aload_2
    //   621: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: iload 5
    //   629: istore 6
    //   631: iload 4
    //   633: istore 7
    //   635: goto +110 -> 745
    //   638: astore_2
    //   639: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   642: ifeq +65 -> 707
    //   645: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   648: astore_3
    //   649: new 69	java/lang/StringBuilder
    //   652: dup
    //   653: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   656: astore 13
    //   658: aload 13
    //   660: ldc 105
    //   662: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload 13
    //   668: iload 5
    //   670: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload 13
    //   676: ldc 184
    //   678: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: aload 13
    //   684: aload_1
    //   685: getfield 158	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   688: ldc 160
    //   690: invokevirtual 166	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   693: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload_3
    //   698: iconst_2
    //   699: aload 13
    //   701: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: aload_2
    //   708: athrow
    //   709: iconst_0
    //   710: istore 4
    //   712: iload 7
    //   714: istore 5
    //   716: iload 5
    //   718: istore 6
    //   720: iload 4
    //   722: istore 7
    //   724: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   727: ifeq +18 -> 745
    //   730: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   733: astore_3
    //   734: new 69	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   741: astore_2
    //   742: goto -159 -> 583
    //   745: aload_0
    //   746: iconst_3
    //   747: iload 6
    //   749: iload 7
    //   751: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   754: invokevirtual 51	com/tencent/mobileqq/inputstatus/InputStatusHandler:notifyUI	(IZLjava/lang/Object;)V
    //   757: return
    //   758: iconst_0
    //   759: istore 4
    //   761: goto -621 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	764	0	this	InputStatusHandler
    //   0	764	1	paramToServiceMsg	ToServiceMsg
    //   0	764	2	paramFromServiceMsg	FromServiceMsg
    //   0	764	3	paramObject	Object
    //   4	756	4	bool1	boolean
    //   89	628	5	bool2	boolean
    //   93	655	6	bool3	boolean
    //   80	670	7	bool4	boolean
    //   13	567	8	bool5	boolean
    //   10	544	9	bool6	boolean
    //   7	512	10	bool7	boolean
    //   313	183	11	l	long
    //   50	650	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   360	370	376	finally
    //   360	370	383	java/lang/Exception
    //   95	116	525	finally
    //   124	134	525	finally
    //   148	154	525	finally
    //   162	166	525	finally
    //   174	183	525	finally
    //   191	199	525	finally
    //   207	215	525	finally
    //   223	233	525	finally
    //   254	264	525	finally
    //   276	286	525	finally
    //   294	315	525	finally
    //   323	341	525	finally
    //   349	360	525	finally
    //   402	408	525	finally
    //   416	420	525	finally
    //   428	436	525	finally
    //   444	451	525	finally
    //   459	471	525	finally
    //   479	486	525	finally
    //   494	501	525	finally
    //   509	518	525	finally
    //   95	116	529	java/lang/Exception
    //   124	134	529	java/lang/Exception
    //   148	154	529	java/lang/Exception
    //   162	166	529	java/lang/Exception
    //   174	183	529	java/lang/Exception
    //   191	199	529	java/lang/Exception
    //   207	215	529	java/lang/Exception
    //   223	233	529	java/lang/Exception
    //   254	264	529	java/lang/Exception
    //   276	286	529	java/lang/Exception
    //   294	315	529	java/lang/Exception
    //   323	341	529	java/lang/Exception
    //   349	360	529	java/lang/Exception
    //   402	408	529	java/lang/Exception
    //   416	420	529	java/lang/Exception
    //   428	436	529	java/lang/Exception
    //   444	451	529	java/lang/Exception
    //   459	471	529	java/lang/Exception
    //   479	486	529	java/lang/Exception
    //   494	501	529	java/lang/Exception
    //   509	518	529	java/lang/Exception
    //   537	553	638	finally
  }
  
  /* Error */
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 60	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 4
    //   6: iconst_1
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 11
    //   12: iconst_0
    //   13: istore 10
    //   15: iload 4
    //   17: ifeq +13 -> 30
    //   20: aload_2
    //   21: ifnull +9 -> 30
    //   24: iconst_1
    //   25: istore 5
    //   27: goto +6 -> 33
    //   30: iconst_0
    //   31: istore 5
    //   33: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +42 -> 78
    //   39: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: astore_1
    //   43: new 69	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   50: astore 12
    //   52: aload 12
    //   54: ldc 192
    //   56: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 12
    //   62: iload 5
    //   64: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_1
    //   69: iconst_2
    //   70: aload 12
    //   72: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iload 11
    //   80: istore 6
    //   82: iload 5
    //   84: istore 4
    //   86: iload 5
    //   88: ifeq +515 -> 603
    //   91: iload 5
    //   93: istore 7
    //   95: iload 5
    //   97: istore 8
    //   99: new 89	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   102: dup
    //   103: invokespecial 90	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   106: aload_2
    //   107: checkcast 92	[B
    //   110: checkcast 92	[B
    //   113: invokevirtual 96	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   116: checkcast 89	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   119: astore_1
    //   120: iload 5
    //   122: istore 7
    //   124: iload 5
    //   126: istore 8
    //   128: aload_1
    //   129: getfield 100	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   135: ifne +514 -> 649
    //   138: iconst_1
    //   139: istore 5
    //   141: goto +3 -> 144
    //   144: iload 5
    //   146: istore 7
    //   148: iload 5
    //   150: istore 8
    //   152: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +82 -> 237
    //   158: iload 5
    //   160: istore 7
    //   162: iload 5
    //   164: istore 8
    //   166: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   169: astore_2
    //   170: iload 5
    //   172: istore 7
    //   174: iload 5
    //   176: istore 8
    //   178: new 69	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   185: astore 12
    //   187: iload 5
    //   189: istore 7
    //   191: iload 5
    //   193: istore 8
    //   195: aload 12
    //   197: ldc 194
    //   199: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: iload 5
    //   205: istore 7
    //   207: iload 5
    //   209: istore 8
    //   211: aload 12
    //   213: iload 5
    //   215: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: iload 5
    //   221: istore 7
    //   223: iload 5
    //   225: istore 8
    //   227: aload_2
    //   228: iconst_2
    //   229: aload 12
    //   231: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: iload 11
    //   239: istore 6
    //   241: iload 5
    //   243: istore 4
    //   245: iload 5
    //   247: ifeq +356 -> 603
    //   250: iload 5
    //   252: istore 7
    //   254: iload 5
    //   256: istore 8
    //   258: iload 11
    //   260: istore 6
    //   262: iload 5
    //   264: istore 4
    //   266: aload_1
    //   267: getfield 109	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   270: invokevirtual 114	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   273: ifeq +330 -> 603
    //   276: iload 5
    //   278: istore 7
    //   280: iload 5
    //   282: istore 8
    //   284: iload 11
    //   286: istore 6
    //   288: iload 5
    //   290: istore 4
    //   292: aload_1
    //   293: getfield 109	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   296: invokevirtual 117	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   299: ifnull +304 -> 603
    //   302: iload 5
    //   304: istore 7
    //   306: iload 5
    //   308: istore 8
    //   310: new 196	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   313: dup
    //   314: invokespecial 197	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   317: astore_2
    //   318: iload 5
    //   320: istore 7
    //   322: iload 5
    //   324: istore 8
    //   326: aload_2
    //   327: aload_1
    //   328: getfield 109	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   331: invokevirtual 117	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   334: invokevirtual 123	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   337: invokevirtual 198	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   340: pop
    //   341: iload 5
    //   343: istore 7
    //   345: iload 5
    //   347: istore 8
    //   349: aload_2
    //   350: getfield 202	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   353: invokevirtual 207	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   356: ifle +61 -> 417
    //   359: iload 5
    //   361: istore 7
    //   363: iload 5
    //   365: istore 8
    //   367: aload_2
    //   368: getfield 202	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   371: iconst_0
    //   372: invokevirtual 210	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   375: checkcast 212	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   378: getfield 215	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_input_status_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   381: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   384: istore_3
    //   385: iload_3
    //   386: iconst_1
    //   387: if_icmpeq +20 -> 407
    //   390: iload_3
    //   391: ifne +6 -> 397
    //   394: goto +13 -> 407
    //   397: iconst_0
    //   398: istore 5
    //   400: iload 9
    //   402: istore 4
    //   404: goto +19 -> 423
    //   407: iconst_1
    //   408: istore 5
    //   410: iload 9
    //   412: istore 4
    //   414: goto +9 -> 423
    //   417: iconst_0
    //   418: istore 5
    //   420: iconst_0
    //   421: istore 4
    //   423: aload_0
    //   424: getfield 19	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   427: ifnull +13 -> 440
    //   430: aload_0
    //   431: getfield 19	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   434: iload 5
    //   436: iconst_0
    //   437: invokevirtual 170	com/tencent/mobileqq/app/QQAppInterface:setVisibilityForInputStatus	(ZZ)V
    //   440: iload 5
    //   442: istore 6
    //   444: goto +159 -> 603
    //   447: astore_1
    //   448: goto +108 -> 556
    //   451: astore_1
    //   452: goto +20 -> 472
    //   455: astore_1
    //   456: iload 7
    //   458: istore 4
    //   460: goto +96 -> 556
    //   463: astore_1
    //   464: iload 8
    //   466: istore 4
    //   468: iload 10
    //   470: istore 5
    //   472: iload 4
    //   474: istore 7
    //   476: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +17 -> 496
    //   482: iload 4
    //   484: istore 7
    //   486: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   489: iconst_2
    //   490: ldc 217
    //   492: aload_1
    //   493: invokestatic 182	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   496: iload 5
    //   498: istore 7
    //   500: iload 4
    //   502: istore 8
    //   504: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   507: ifeq +129 -> 636
    //   510: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   513: astore_2
    //   514: new 69	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   521: astore_1
    //   522: aload_1
    //   523: ldc 194
    //   525: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload_1
    //   530: iload 4
    //   532: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload_2
    //   537: iconst_2
    //   538: aload_1
    //   539: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   545: iload 5
    //   547: istore 7
    //   549: iload 4
    //   551: istore 8
    //   553: goto +83 -> 636
    //   556: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   559: ifeq +42 -> 601
    //   562: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   565: astore_2
    //   566: new 69	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   573: astore 12
    //   575: aload 12
    //   577: ldc 194
    //   579: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload 12
    //   585: iload 4
    //   587: invokevirtual 79	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload_2
    //   592: iconst_2
    //   593: aload 12
    //   595: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 87	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: aload_1
    //   602: athrow
    //   603: iload 6
    //   605: istore 7
    //   607: iload 4
    //   609: istore 8
    //   611: invokestatic 65	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   614: ifeq +22 -> 636
    //   617: getstatic 67	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   620: astore_2
    //   621: new 69	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   628: astore_1
    //   629: iload 6
    //   631: istore 5
    //   633: goto -111 -> 522
    //   636: aload_0
    //   637: iconst_2
    //   638: iload 8
    //   640: iload 7
    //   642: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   645: invokevirtual 51	com/tencent/mobileqq/inputstatus/InputStatusHandler:notifyUI	(IZLjava/lang/Object;)V
    //   648: return
    //   649: iconst_0
    //   650: istore 5
    //   652: goto -508 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	655	0	this	InputStatusHandler
    //   0	655	1	paramFromServiceMsg	FromServiceMsg
    //   0	655	2	paramObject	Object
    //   384	7	3	i	int
    //   4	604	4	bool1	boolean
    //   25	626	5	bool2	boolean
    //   80	550	6	bool3	boolean
    //   93	548	7	bool4	boolean
    //   97	542	8	bool5	boolean
    //   7	404	9	bool6	boolean
    //   13	456	10	bool7	boolean
    //   10	275	11	bool8	boolean
    //   50	544	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   423	440	447	finally
    //   423	440	451	java/lang/Exception
    //   99	120	455	finally
    //   128	138	455	finally
    //   152	158	455	finally
    //   166	170	455	finally
    //   178	187	455	finally
    //   195	203	455	finally
    //   211	219	455	finally
    //   227	237	455	finally
    //   266	276	455	finally
    //   292	302	455	finally
    //   310	318	455	finally
    //   326	341	455	finally
    //   349	359	455	finally
    //   367	385	455	finally
    //   476	482	455	finally
    //   486	496	455	finally
    //   99	120	463	java/lang/Exception
    //   128	138	463	java/lang/Exception
    //   152	158	463	java/lang/Exception
    //   166	170	463	java/lang/Exception
    //   178	187	463	java/lang/Exception
    //   195	203	463	java/lang/Exception
    //   211	219	463	java/lang/Exception
    //   227	237	463	java/lang/Exception
    //   266	276	463	java/lang/Exception
    //   292	302	463	java/lang/Exception
    //   310	318	463	java/lang/Exception
    //   326	341	463	java/lang/Exception
    //   349	359	463	java/lang/Exception
    //   367	385	463	java/lang/Exception
  }
  
  public void a()
  {
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localReqBody.rpt_uint64_uins.add(Long.valueOf(l));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localReqBody.uint32_input_status_flag.set(1);
    sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42261", 1515, 22, localReqBody.toByteArray()));
  }
  
  void a(int paramInt, long paramLong)
  {
    cmd0xcd4.InputNotifyReq localInputNotifyReq = new cmd0xcd4.InputNotifyReq();
    localInputNotifyReq.uint32_event_type.set(paramInt);
    localInputNotifyReq.uint32_ime.set(0);
    localInputNotifyReq.uint64_to_uin.set(paramLong);
    cmd0xcd4.ReqBody localReqBody = new cmd0xcd4.ReqBody();
    localReqBody.input_notify.set(localInputNotifyReq);
    sendPbReq(makeOIDBPkg("OidbSvc.0xcd4", 3284, 1, localReqBody.toByteArray()));
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setVisibilityForInputStatus OPEN=");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          s = 1;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23275).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_42261");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("uint32_input_status_flag", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromInputStatusHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "setMedalSwitch ex", localException);
        }
        return;
      }
      short s = 2;
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return InputStatusObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (TextUtils.equals("OidbSvc.0xcd4", paramFromServiceMsg.getServiceCmd()))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      if (TextUtils.equals("OidbSvc.0x5eb_42261", paramFromServiceMsg.getServiceCmd()))
      {
        b(paramFromServiceMsg, paramObject);
        return;
      }
      if (TextUtils.equals("OidbSvc.0x4ff_42261", paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.inputstatus.InputStatusHandler
 * JD-Core Version:    0.7.0.1
 */