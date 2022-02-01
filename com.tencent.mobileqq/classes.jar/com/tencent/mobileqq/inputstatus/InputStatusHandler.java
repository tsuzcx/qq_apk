package com.tencent.mobileqq.inputstatus;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.InputNotifyReq;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.InputNotifyRsp;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.ReqBody;
import tencent.im.oidb.cmd0xcd4.cmd0xcd4.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class InputStatusHandler
  extends BusinessHandler
{
  private static final String jdField_a_of_type_JavaLangString = InputStatusHandler.class.getSimpleName();
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
    if (paramFromServiceMsg.sint32_result.get() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      notifyUI(1, bool, paramFromServiceMsg);
      return;
    }
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: iconst_1
    //   4: istore 11
    //   6: iconst_1
    //   7: istore 8
    //   9: iconst_0
    //   10: istore 10
    //   12: aload_2
    //   13: invokevirtual 66	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +379 -> 395
    //   19: aload_3
    //   20: ifnull +375 -> 395
    //   23: iconst_1
    //   24: istore 4
    //   26: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +30 -> 59
    //   32: getstatic 17	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   35: iconst_2
    //   36: new 73	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   43: ldc 76
    //   45: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 4
    //   50: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iload 4
    //   61: istore 7
    //   63: iload 4
    //   65: ifeq +586 -> 651
    //   68: iload 4
    //   70: istore 5
    //   72: iload 4
    //   74: istore 6
    //   76: new 92	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   79: dup
    //   80: invokespecial 93	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   83: aload_3
    //   84: checkcast 95	[B
    //   87: checkcast 95	[B
    //   90: invokevirtual 99	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   93: checkcast 92	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: astore_2
    //   97: iload 4
    //   99: istore 5
    //   101: iload 4
    //   103: istore 6
    //   105: aload_2
    //   106: getfield 103	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 106	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: ifne +289 -> 401
    //   115: iconst_1
    //   116: istore 4
    //   118: iload 4
    //   120: istore 5
    //   122: iload 4
    //   124: istore 6
    //   126: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +38 -> 167
    //   132: iload 4
    //   134: istore 5
    //   136: iload 4
    //   138: istore 6
    //   140: getstatic 17	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: iconst_2
    //   144: new 73	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   151: ldc 108
    //   153: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: iload 4
    //   158: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: iload 4
    //   169: istore 7
    //   171: iload 4
    //   173: ifeq +478 -> 651
    //   176: iload 4
    //   178: istore 5
    //   180: iload 4
    //   182: istore 6
    //   184: iload 4
    //   186: istore 7
    //   188: aload_2
    //   189: getfield 112	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   192: invokevirtual 117	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   195: ifeq +456 -> 651
    //   198: iload 4
    //   200: istore 5
    //   202: iload 4
    //   204: istore 6
    //   206: iload 4
    //   208: istore 7
    //   210: aload_2
    //   211: getfield 112	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   214: invokevirtual 120	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   217: ifnull +434 -> 651
    //   220: iload 4
    //   222: istore 5
    //   224: iload 4
    //   226: istore 6
    //   228: aload_2
    //   229: getfield 112	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   232: invokevirtual 120	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   235: invokevirtual 126	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   238: invokestatic 132	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   241: invokevirtual 135	java/nio/ByteBuffer:getInt	()I
    //   244: invokestatic 140	com/tencent/mobileqq/util/Utils:a	(I)J
    //   247: lstore 12
    //   249: iload 4
    //   251: istore 5
    //   253: iload 4
    //   255: istore 6
    //   257: aload_0
    //   258: getfield 25	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   261: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   264: lload 12
    //   266: invokestatic 151	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   269: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   272: ifeq +135 -> 407
    //   275: iload 4
    //   277: istore 5
    //   279: iload 4
    //   281: istore 6
    //   283: aload_1
    //   284: getfield 161	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   287: ldc 163
    //   289: invokevirtual 169	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   292: istore 4
    //   294: iload 11
    //   296: istore 5
    //   298: aload_0
    //   299: getfield 25	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: iload 4
    //   304: iconst_0
    //   305: invokevirtual 173	com/tencent/mobileqq/app/QQAppInterface:setVisibilityForInputStatus	(ZZ)V
    //   308: iload 4
    //   310: istore 6
    //   312: iload 8
    //   314: istore 4
    //   316: iload 4
    //   318: istore 5
    //   320: iload 6
    //   322: istore 7
    //   324: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   327: ifeq +55 -> 382
    //   330: getstatic 17	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   333: iconst_2
    //   334: new 73	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   341: ldc 108
    //   343: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload 4
    //   348: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   351: ldc 175
    //   353: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_1
    //   357: getfield 161	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   360: ldc 163
    //   362: invokevirtual 169	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   365: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   368: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: iload 6
    //   376: istore 7
    //   378: iload 4
    //   380: istore 5
    //   382: aload_0
    //   383: iconst_3
    //   384: iload 5
    //   386: iload 7
    //   388: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   391: invokevirtual 57	com/tencent/mobileqq/inputstatus/InputStatusHandler:notifyUI	(IZLjava/lang/Object;)V
    //   394: return
    //   395: iconst_0
    //   396: istore 4
    //   398: goto -372 -> 26
    //   401: iconst_0
    //   402: istore 4
    //   404: goto -286 -> 118
    //   407: iload 4
    //   409: istore 5
    //   411: iload 4
    //   413: istore 6
    //   415: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   418: ifeq +53 -> 471
    //   421: iload 4
    //   423: istore 5
    //   425: iload 4
    //   427: istore 6
    //   429: getstatic 17	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   432: iconst_2
    //   433: new 73	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   440: ldc 182
    //   442: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_0
    //   446: getfield 25	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   449: invokevirtual 145	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   452: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: ldc 184
    //   457: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: lload 12
    //   462: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   465: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: iconst_0
    //   472: istore 4
    //   474: iload 10
    //   476: istore 6
    //   478: goto -162 -> 316
    //   481: astore_2
    //   482: iconst_0
    //   483: istore 4
    //   485: iload 5
    //   487: istore 6
    //   489: iload 6
    //   491: istore 5
    //   493: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq +17 -> 513
    //   499: iload 6
    //   501: istore 5
    //   503: getstatic 17	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   506: iconst_1
    //   507: ldc 189
    //   509: aload_2
    //   510: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   513: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   516: ifeq +125 -> 641
    //   519: getstatic 17	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   522: iconst_2
    //   523: new 73	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   530: ldc 108
    //   532: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: iconst_0
    //   536: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   539: ldc 175
    //   541: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload_1
    //   545: getfield 161	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   548: ldc 163
    //   550: invokevirtual 169	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   553: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   556: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: iconst_0
    //   563: istore 5
    //   565: iload 4
    //   567: istore 7
    //   569: goto -187 -> 382
    //   572: astore_2
    //   573: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq +47 -> 623
    //   579: getstatic 17	com/tencent/mobileqq/inputstatus/InputStatusHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   582: iconst_2
    //   583: new 73	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   590: ldc 108
    //   592: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: iload 6
    //   597: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   600: ldc 175
    //   602: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload_1
    //   606: getfield 161	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   609: ldc 163
    //   611: invokevirtual 169	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   614: invokevirtual 83	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   617: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   623: aload_2
    //   624: athrow
    //   625: astore_2
    //   626: iload 5
    //   628: istore 6
    //   630: goto -57 -> 573
    //   633: astore_2
    //   634: iload 9
    //   636: istore 6
    //   638: goto -149 -> 489
    //   641: iconst_0
    //   642: istore 5
    //   644: iload 4
    //   646: istore 7
    //   648: goto -266 -> 382
    //   651: iload 7
    //   653: istore 4
    //   655: iload 10
    //   657: istore 6
    //   659: goto -343 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	InputStatusHandler
    //   0	662	1	paramToServiceMsg	ToServiceMsg
    //   0	662	2	paramFromServiceMsg	FromServiceMsg
    //   0	662	3	paramObject	Object
    //   24	630	4	bool1	boolean
    //   70	573	5	bool2	boolean
    //   74	584	6	bool3	boolean
    //   61	591	7	bool4	boolean
    //   7	306	8	bool5	boolean
    //   1	634	9	bool6	boolean
    //   10	646	10	bool7	boolean
    //   4	291	11	bool8	boolean
    //   247	214	12	l	long
    // Exception table:
    //   from	to	target	type
    //   76	97	481	java/lang/Exception
    //   105	115	481	java/lang/Exception
    //   126	132	481	java/lang/Exception
    //   140	167	481	java/lang/Exception
    //   188	198	481	java/lang/Exception
    //   210	220	481	java/lang/Exception
    //   228	249	481	java/lang/Exception
    //   257	275	481	java/lang/Exception
    //   283	294	481	java/lang/Exception
    //   415	421	481	java/lang/Exception
    //   429	471	481	java/lang/Exception
    //   76	97	572	finally
    //   105	115	572	finally
    //   126	132	572	finally
    //   140	167	572	finally
    //   188	198	572	finally
    //   210	220	572	finally
    //   228	249	572	finally
    //   257	275	572	finally
    //   283	294	572	finally
    //   415	421	572	finally
    //   429	471	572	finally
    //   298	308	625	finally
    //   493	499	625	finally
    //   503	513	625	finally
    //   298	308	633	java/lang/Exception
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool8 = false;
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool5 = false;
    boolean bool2;
    boolean bool3;
    boolean bool6;
    boolean bool1;
    boolean bool7;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetShowInputStatusToFriendResp success=" + bool2);
      }
      bool3 = bool2;
      bool6 = bool8;
      if (bool2)
      {
        bool1 = bool2;
        bool7 = bool9;
        bool4 = bool2;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool1 = bool2;
        bool7 = bool9;
        bool4 = bool2;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool2 = true;
        bool1 = bool2;
        bool7 = bool9;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          bool1 = bool2;
          bool7 = bool9;
          bool4 = bool2;
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetShowInputStatusToFriendResp result=" + bool2);
        }
        bool3 = bool2;
        bool6 = bool8;
        if (bool2)
        {
          bool3 = bool2;
          bool6 = bool8;
          bool1 = bool2;
          bool7 = bool9;
          bool4 = bool2;
          if (paramFromServiceMsg.bytes_bodybuffer.has())
          {
            bool3 = bool2;
            bool6 = bool8;
            bool1 = bool2;
            bool7 = bool9;
            bool4 = bool2;
            if (paramFromServiceMsg.bytes_bodybuffer.get() != null)
            {
              bool1 = bool2;
              bool7 = bool9;
              bool4 = bool2;
              paramObject = new oidb_0x5eb.RspBody();
              bool1 = bool2;
              bool7 = bool9;
              bool4 = bool2;
              paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
              bool1 = bool2;
              bool7 = bool9;
              bool4 = bool2;
              if (paramObject.rpt_msg_uin_data.size() <= 0) {
                continue;
              }
              bool1 = bool2;
              bool7 = bool9;
              bool4 = bool2;
              int i = ((oidb_0x5eb.UdcUinData)paramObject.rpt_msg_uin_data.get(0)).uint32_input_status_flag.get();
              if (i == 1) {
                break label625;
              }
              bool5 = bool10;
              if (i != 0) {
                break label628;
              }
              break label625;
              bool3 = bool2;
              bool6 = bool5;
              bool1 = bool2;
              bool7 = bool5;
              bool4 = bool2;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
              {
                bool1 = bool2;
                bool7 = bool5;
                bool4 = bool2;
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setVisibilityForInputStatus(bool5, false);
                bool6 = bool5;
                bool3 = bool2;
              }
            }
          }
        }
        bool2 = bool3;
        bool4 = bool6;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetShowInputStatusToFriendResp result=" + bool3);
          bool4 = bool6;
          bool2 = bool3;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool4 = bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool4 = bool1;
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetShowInputStatusToFriendResp ex", paramFromServiceMsg);
        bool2 = bool1;
        bool4 = bool7;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetShowInputStatusToFriendResp result=" + bool1);
        bool2 = bool1;
        bool4 = bool7;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetShowInputStatusToFriendResp result=" + bool4);
      }
      notifyUI(2, bool2, Boolean.valueOf(bool4));
      return;
      bool2 = false;
      break;
      bool2 = false;
      continue;
      bool2 = false;
      continue;
      label625:
      bool5 = true;
      label628:
      bool2 = true;
    }
  }
  
  public void a()
  {
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localReqBody.rpt_uint64_uins.add(Long.valueOf(l));
      localReqBody.uint32_input_status_flag.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42261", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
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
    short s = 2;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setVisibilityForInputStatus OPEN=" + paramBoolean);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      Object localObject = ByteBuffer.allocate(13);
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (paramBoolean) {
        s = 1;
      }
      ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23275).putShort((short)2).putShort(s);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x4ff_42261");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putBoolean("uint32_input_status_flag", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromInputStatusHandler", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setMedalSwitch ex", localException);
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return InputStatusObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (!TextUtils.equals("OidbSvc.0xcd4", paramFromServiceMsg.getServiceCmd())) {
        break label27;
      }
      a(paramFromServiceMsg, paramObject);
    }
    label27:
    do
    {
      return;
      if (TextUtils.equals("OidbSvc.0x5eb_42261", paramFromServiceMsg.getServiceCmd()))
      {
        b(paramFromServiceMsg, paramObject);
        return;
      }
    } while (!TextUtils.equals("OidbSvc.0x4ff_42261", paramFromServiceMsg.getServiceCmd()));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.inputstatus.InputStatusHandler
 * JD-Core Version:    0.7.0.1
 */