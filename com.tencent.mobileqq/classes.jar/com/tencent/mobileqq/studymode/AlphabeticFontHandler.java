package com.tencent.mobileqq.studymode;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class AlphabeticFontHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  public AlphabeticFontHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  /* Error */
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 23	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 4
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 10
    //   12: iconst_0
    //   13: istore 11
    //   15: iload 4
    //   17: ifeq +13 -> 30
    //   20: aload_2
    //   21: ifnull +9 -> 30
    //   24: iconst_1
    //   25: istore 5
    //   27: goto +6 -> 33
    //   30: iconst_0
    //   31: istore 5
    //   33: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +35 -> 71
    //   39: new 30	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   46: astore_1
    //   47: aload_1
    //   48: ldc 35
    //   50: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_1
    //   55: iload 5
    //   57: invokevirtual 42	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc 44
    //   63: iconst_2
    //   64: aload_1
    //   65: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iload 10
    //   73: istore 6
    //   75: iload 5
    //   77: istore 4
    //   79: iload 5
    //   81: ifeq +478 -> 559
    //   84: iload 5
    //   86: istore 7
    //   88: iload 5
    //   90: istore 8
    //   92: new 54	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: dup
    //   96: invokespecial 55	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   99: aload_2
    //   100: checkcast 57	[B
    //   103: checkcast 57	[B
    //   106: invokevirtual 61	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   109: checkcast 54	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   112: astore_1
    //   113: iload 5
    //   115: istore 7
    //   117: iload 5
    //   119: istore 8
    //   121: aload_1
    //   122: getfield 65	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: ifne +549 -> 677
    //   131: iconst_1
    //   132: istore 5
    //   134: goto +3 -> 137
    //   137: iload 5
    //   139: istore 7
    //   141: iload 5
    //   143: istore 8
    //   145: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +67 -> 215
    //   151: iload 5
    //   153: istore 7
    //   155: iload 5
    //   157: istore 8
    //   159: new 30	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   166: astore_2
    //   167: iload 5
    //   169: istore 7
    //   171: iload 5
    //   173: istore 8
    //   175: aload_2
    //   176: ldc 73
    //   178: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: iload 5
    //   184: istore 7
    //   186: iload 5
    //   188: istore 8
    //   190: aload_2
    //   191: iload 5
    //   193: invokevirtual 42	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: iload 5
    //   199: istore 7
    //   201: iload 5
    //   203: istore 8
    //   205: ldc 44
    //   207: iconst_2
    //   208: aload_2
    //   209: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: iload 10
    //   217: istore 6
    //   219: iload 5
    //   221: istore 4
    //   223: iload 5
    //   225: ifeq +334 -> 559
    //   228: iload 5
    //   230: istore 7
    //   232: iload 5
    //   234: istore 8
    //   236: iload 10
    //   238: istore 6
    //   240: iload 5
    //   242: istore 4
    //   244: aload_1
    //   245: getfield 77	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   248: invokevirtual 82	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   251: ifeq +308 -> 559
    //   254: iload 5
    //   256: istore 7
    //   258: iload 5
    //   260: istore 8
    //   262: iload 10
    //   264: istore 6
    //   266: iload 5
    //   268: istore 4
    //   270: aload_1
    //   271: getfield 77	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   274: invokevirtual 85	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   277: ifnull +282 -> 559
    //   280: iload 5
    //   282: istore 7
    //   284: iload 5
    //   286: istore 8
    //   288: new 87	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   291: dup
    //   292: invokespecial 88	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   295: astore_2
    //   296: iload 5
    //   298: istore 7
    //   300: iload 5
    //   302: istore 8
    //   304: aload_2
    //   305: aload_1
    //   306: getfield 77	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   309: invokevirtual 85	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   312: invokevirtual 94	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   315: invokevirtual 95	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   318: pop
    //   319: iload 5
    //   321: istore 7
    //   323: iload 5
    //   325: istore 8
    //   327: aload_2
    //   328: getfield 99	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   331: invokevirtual 104	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   334: ifle +82 -> 416
    //   337: iload 5
    //   339: istore 7
    //   341: iload 5
    //   343: istore 8
    //   345: aload_2
    //   346: getfield 99	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   349: iconst_0
    //   350: invokevirtual 107	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   353: checkcast 109	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   356: getfield 112	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_alphabetic_font_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   359: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   362: istore_3
    //   363: iload 11
    //   365: istore 5
    //   367: iload_3
    //   368: ifeq +6 -> 374
    //   371: iconst_1
    //   372: istore 5
    //   374: getstatic 118	com/tencent/common/app/BaseApplicationImpl:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   377: aload_0
    //   378: invokevirtual 121	com/tencent/mobileqq/studymode/AlphabeticFontHandler:getCurrentAccountUin	()Ljava/lang/String;
    //   381: iconst_1
    //   382: ldc 123
    //   384: iload 5
    //   386: invokestatic 129	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   389: invokestatic 134	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Object;)V
    //   392: iconst_1
    //   393: istore 4
    //   395: iload 5
    //   397: istore 6
    //   399: goto +160 -> 559
    //   402: astore_1
    //   403: iconst_1
    //   404: istore 7
    //   406: goto +113 -> 519
    //   409: astore_1
    //   410: iconst_1
    //   411: istore 4
    //   413: goto +26 -> 439
    //   416: iconst_0
    //   417: istore 4
    //   419: iload 10
    //   421: istore 6
    //   423: goto +136 -> 559
    //   426: astore_1
    //   427: goto +92 -> 519
    //   430: astore_1
    //   431: iload 8
    //   433: istore 4
    //   435: iload 9
    //   437: istore 5
    //   439: iload 4
    //   441: istore 7
    //   443: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +16 -> 462
    //   449: iload 4
    //   451: istore 7
    //   453: ldc 44
    //   455: iconst_2
    //   456: ldc 136
    //   458: aload_1
    //   459: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   462: iload 5
    //   464: istore 7
    //   466: iload 4
    //   468: istore 8
    //   470: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq +115 -> 588
    //   476: new 30	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   483: astore_1
    //   484: aload_1
    //   485: ldc 73
    //   487: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload_1
    //   492: iload 4
    //   494: invokevirtual 42	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: ldc 44
    //   500: iconst_2
    //   501: aload_1
    //   502: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: iload 5
    //   510: istore 7
    //   512: iload 4
    //   514: istore 8
    //   516: goto +72 -> 588
    //   519: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +35 -> 557
    //   525: new 30	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   532: astore_2
    //   533: aload_2
    //   534: ldc 73
    //   536: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: pop
    //   540: aload_2
    //   541: iload 7
    //   543: invokevirtual 42	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   546: pop
    //   547: ldc 44
    //   549: iconst_2
    //   550: aload_2
    //   551: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: aload_1
    //   558: athrow
    //   559: iload 6
    //   561: istore 7
    //   563: iload 4
    //   565: istore 8
    //   567: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +18 -> 588
    //   573: new 30	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   580: astore_1
    //   581: iload 6
    //   583: istore 5
    //   585: goto -101 -> 484
    //   588: aload_0
    //   589: invokespecial 142	com/tencent/mobileqq/studymode/AlphabeticFontHandler:b	()Z
    //   592: ifne +72 -> 664
    //   595: iload 7
    //   597: ifeq +30 -> 627
    //   600: aload_0
    //   601: getfield 13	com/tencent/mobileqq/studymode/AlphabeticFontHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   604: ldc 144
    //   606: ldc 146
    //   608: ldc 146
    //   610: ldc 148
    //   612: ldc 148
    //   614: iconst_0
    //   615: iconst_0
    //   616: ldc 146
    //   618: ldc 146
    //   620: ldc 146
    //   622: ldc 146
    //   624: invokestatic 153	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   627: new 155	java/text/SimpleDateFormat
    //   630: dup
    //   631: ldc 157
    //   633: getstatic 163	java/util/Locale:CHINESE	Ljava/util/Locale;
    //   636: invokespecial 166	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   639: astore_1
    //   640: getstatic 118	com/tencent/common/app/BaseApplicationImpl:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   643: aload_0
    //   644: invokevirtual 121	com/tencent/mobileqq/studymode/AlphabeticFontHandler:getCurrentAccountUin	()Ljava/lang/String;
    //   647: iconst_1
    //   648: ldc 168
    //   650: aload_1
    //   651: new 170	java/util/Date
    //   654: dup
    //   655: invokespecial 171	java/util/Date:<init>	()V
    //   658: invokevirtual 175	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   661: invokestatic 134	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Object;)V
    //   664: aload_0
    //   665: iconst_1
    //   666: iload 8
    //   668: iload 7
    //   670: invokestatic 129	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   673: invokevirtual 179	com/tencent/mobileqq/studymode/AlphabeticFontHandler:notifyUI	(IZLjava/lang/Object;)V
    //   676: return
    //   677: iconst_0
    //   678: istore 5
    //   680: goto -543 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	683	0	this	AlphabeticFontHandler
    //   0	683	1	paramFromServiceMsg	FromServiceMsg
    //   0	683	2	paramObject	Object
    //   362	6	3	i	int
    //   4	560	4	bool1	boolean
    //   25	654	5	bool2	boolean
    //   73	509	6	bool3	boolean
    //   86	583	7	bool4	boolean
    //   90	577	8	bool5	boolean
    //   7	429	9	bool6	boolean
    //   10	410	10	bool7	boolean
    //   13	351	11	bool8	boolean
    // Exception table:
    //   from	to	target	type
    //   374	392	402	finally
    //   374	392	409	java/lang/Exception
    //   92	113	426	finally
    //   121	131	426	finally
    //   145	151	426	finally
    //   159	167	426	finally
    //   175	182	426	finally
    //   190	197	426	finally
    //   205	215	426	finally
    //   244	254	426	finally
    //   270	280	426	finally
    //   288	296	426	finally
    //   304	319	426	finally
    //   327	337	426	finally
    //   345	363	426	finally
    //   443	449	426	finally
    //   453	462	426	finally
    //   92	113	430	java/lang/Exception
    //   121	131	430	java/lang/Exception
    //   145	151	430	java/lang/Exception
    //   159	167	430	java/lang/Exception
    //   175	182	430	java/lang/Exception
    //   190	197	430	java/lang/Exception
    //   205	215	430	java/lang/Exception
    //   244	254	430	java/lang/Exception
    //   270	280	430	java/lang/Exception
    //   288	296	430	java/lang/Exception
    //   304	319	430	java/lang/Exception
    //   327	337	430	java/lang/Exception
    //   345	363	430	java/lang/Exception
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 23	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 10
    //   9: iconst_0
    //   10: istore 8
    //   12: iconst_0
    //   13: istore 9
    //   15: iload 5
    //   17: ifeq +13 -> 30
    //   20: aload_3
    //   21: ifnull +9 -> 30
    //   24: iconst_1
    //   25: istore 5
    //   27: goto +6 -> 33
    //   30: iconst_0
    //   31: istore 5
    //   33: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +35 -> 71
    //   39: new 30	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   46: astore_2
    //   47: aload_2
    //   48: ldc 182
    //   50: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: iload 5
    //   57: invokevirtual 42	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc 44
    //   63: iconst_2
    //   64: aload_2
    //   65: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: iload 5
    //   73: ifeq +566 -> 639
    //   76: new 54	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   79: dup
    //   80: invokespecial 55	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   83: aload_3
    //   84: checkcast 57	[B
    //   87: checkcast 57	[B
    //   90: invokevirtual 61	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   93: checkcast 54	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: astore_2
    //   97: aload_2
    //   98: getfield 65	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   101: invokevirtual 71	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   104: istore 4
    //   106: iload 4
    //   108: ifne +9 -> 117
    //   111: iconst_1
    //   112: istore 5
    //   114: goto +6 -> 120
    //   117: iconst_0
    //   118: istore 5
    //   120: iload 5
    //   122: istore 7
    //   124: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +73 -> 200
    //   130: iload 5
    //   132: istore 7
    //   134: new 30	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   141: astore_3
    //   142: iload 5
    //   144: istore 7
    //   146: aload_3
    //   147: ldc 184
    //   149: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: iload 5
    //   155: istore 7
    //   157: aload_3
    //   158: iload 5
    //   160: invokevirtual 42	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: iload 5
    //   166: istore 7
    //   168: aload_3
    //   169: ldc 186
    //   171: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: iload 5
    //   177: istore 7
    //   179: aload_3
    //   180: iload 4
    //   182: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: iload 5
    //   188: istore 7
    //   190: ldc 44
    //   192: iconst_2
    //   193: aload_3
    //   194: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: iload 5
    //   202: ifeq +239 -> 441
    //   205: iload 5
    //   207: istore 7
    //   209: aload_2
    //   210: getfield 77	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   213: invokevirtual 82	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   216: ifeq +225 -> 441
    //   219: iload 5
    //   221: istore 7
    //   223: aload_2
    //   224: getfield 77	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   227: invokevirtual 85	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   230: ifnull +211 -> 441
    //   233: iload 5
    //   235: istore 7
    //   237: aload_2
    //   238: getfield 77	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   241: invokevirtual 85	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   244: invokevirtual 94	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   247: invokestatic 195	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   250: invokevirtual 198	java/nio/ByteBuffer:getInt	()I
    //   253: invokestatic 203	com/tencent/mobileqq/util/Utils:a	(I)J
    //   256: lstore 11
    //   258: iload 5
    //   260: istore 7
    //   262: aload_0
    //   263: getfield 13	com/tencent/mobileqq/studymode/AlphabeticFontHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   266: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   269: lload 11
    //   271: invokestatic 211	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   274: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   277: ifeq +68 -> 345
    //   280: iload 5
    //   282: istore 7
    //   284: aload_1
    //   285: getfield 221	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   288: ldc 223
    //   290: invokevirtual 229	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   293: istore 6
    //   295: getstatic 118	com/tencent/common/app/BaseApplicationImpl:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   298: aload_0
    //   299: invokevirtual 121	com/tencent/mobileqq/studymode/AlphabeticFontHandler:getCurrentAccountUin	()Ljava/lang/String;
    //   302: iconst_1
    //   303: ldc 123
    //   305: iload 6
    //   307: invokestatic 129	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   310: invokestatic 134	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Object;)V
    //   313: iload 6
    //   315: istore 5
    //   317: iconst_1
    //   318: istore 6
    //   320: goto +326 -> 646
    //   323: astore_2
    //   324: iconst_1
    //   325: istore 7
    //   327: goto +251 -> 578
    //   330: astore_2
    //   331: iconst_1
    //   332: istore 7
    //   334: iload 6
    //   336: istore 5
    //   338: iload 7
    //   340: istore 6
    //   342: goto +130 -> 472
    //   345: iload 5
    //   347: istore 7
    //   349: iload 10
    //   351: istore 6
    //   353: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +287 -> 643
    //   359: iload 5
    //   361: istore 7
    //   363: new 30	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   370: astore_2
    //   371: iload 5
    //   373: istore 7
    //   375: aload_2
    //   376: ldc 231
    //   378: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: iload 5
    //   384: istore 7
    //   386: aload_2
    //   387: aload_0
    //   388: getfield 13	com/tencent/mobileqq/studymode/AlphabeticFontHandler:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   391: invokevirtual 206	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   394: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: iload 5
    //   400: istore 7
    //   402: aload_2
    //   403: ldc 233
    //   405: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: iload 5
    //   411: istore 7
    //   413: aload_2
    //   414: lload 11
    //   416: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: iload 5
    //   422: istore 7
    //   424: ldc 44
    //   426: iconst_2
    //   427: aload_2
    //   428: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: iload 10
    //   436: istore 6
    //   438: goto +205 -> 643
    //   441: iload 5
    //   443: istore 6
    //   445: goto +198 -> 643
    //   448: astore_2
    //   449: iload 5
    //   451: istore 6
    //   453: goto +16 -> 469
    //   456: astore_2
    //   457: iload 5
    //   459: istore 7
    //   461: goto +117 -> 578
    //   464: astore_2
    //   465: iload 5
    //   467: istore 6
    //   469: iconst_0
    //   470: istore 5
    //   472: iload 6
    //   474: istore 7
    //   476: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +16 -> 495
    //   482: iload 6
    //   484: istore 7
    //   486: ldc 44
    //   488: iconst_1
    //   489: ldc 238
    //   491: aload_2
    //   492: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   495: iload 8
    //   497: istore 7
    //   499: iload 5
    //   501: istore 8
    //   503: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +165 -> 671
    //   509: new 30	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   516: astore_2
    //   517: iload 9
    //   519: istore 6
    //   521: aload_2
    //   522: ldc 184
    //   524: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload_2
    //   529: iload 6
    //   531: invokevirtual 42	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   534: pop
    //   535: aload_2
    //   536: ldc 240
    //   538: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_2
    //   543: aload_1
    //   544: getfield 221	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   547: ldc 223
    //   549: invokevirtual 229	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   552: invokevirtual 42	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: ldc 44
    //   558: iconst_2
    //   559: aload_2
    //   560: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   566: iload 6
    //   568: istore 7
    //   570: iload 5
    //   572: istore 8
    //   574: goto +97 -> 671
    //   577: astore_2
    //   578: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   581: ifeq +56 -> 637
    //   584: new 30	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   591: astore_3
    //   592: aload_3
    //   593: ldc 184
    //   595: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload_3
    //   600: iload 7
    //   602: invokevirtual 42	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload_3
    //   607: ldc 240
    //   609: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload_3
    //   614: aload_1
    //   615: getfield 221	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   618: ldc 223
    //   620: invokevirtual 229	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   623: invokevirtual 42	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   626: pop
    //   627: ldc 44
    //   629: iconst_2
    //   630: aload_3
    //   631: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   637: aload_2
    //   638: athrow
    //   639: iload 5
    //   641: istore 6
    //   643: iconst_0
    //   644: istore 5
    //   646: iload 6
    //   648: istore 7
    //   650: iload 5
    //   652: istore 8
    //   654: invokestatic 28	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   657: ifeq +14 -> 671
    //   660: new 30	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   667: astore_2
    //   668: goto -147 -> 521
    //   671: aload_0
    //   672: iconst_2
    //   673: iload 7
    //   675: iload 8
    //   677: invokestatic 129	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   680: invokevirtual 179	com/tencent/mobileqq/studymode/AlphabeticFontHandler:notifyUI	(IZLjava/lang/Object;)V
    //   683: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	this	AlphabeticFontHandler
    //   0	684	1	paramToServiceMsg	ToServiceMsg
    //   0	684	2	paramFromServiceMsg	FromServiceMsg
    //   0	684	3	paramObject	Object
    //   104	77	4	i	int
    //   4	647	5	bool1	boolean
    //   293	354	6	bool2	boolean
    //   122	552	7	bool3	boolean
    //   10	666	8	bool4	boolean
    //   13	505	9	bool5	boolean
    //   7	428	10	bool6	boolean
    //   256	159	11	l	long
    // Exception table:
    //   from	to	target	type
    //   295	313	323	finally
    //   295	313	330	java/lang/Exception
    //   124	130	448	java/lang/Exception
    //   134	142	448	java/lang/Exception
    //   146	153	448	java/lang/Exception
    //   157	164	448	java/lang/Exception
    //   168	175	448	java/lang/Exception
    //   179	186	448	java/lang/Exception
    //   190	200	448	java/lang/Exception
    //   209	219	448	java/lang/Exception
    //   223	233	448	java/lang/Exception
    //   237	258	448	java/lang/Exception
    //   262	280	448	java/lang/Exception
    //   284	295	448	java/lang/Exception
    //   353	359	448	java/lang/Exception
    //   363	371	448	java/lang/Exception
    //   375	382	448	java/lang/Exception
    //   386	398	448	java/lang/Exception
    //   402	409	448	java/lang/Exception
    //   413	420	448	java/lang/Exception
    //   424	434	448	java/lang/Exception
    //   76	106	456	finally
    //   76	106	464	java/lang/Exception
    //   124	130	577	finally
    //   134	142	577	finally
    //   146	153	577	finally
    //   157	164	577	finally
    //   168	175	577	finally
    //   179	186	577	finally
    //   190	200	577	finally
    //   209	219	577	finally
    //   223	233	577	finally
    //   237	258	577	finally
    //   262	280	577	finally
    //   284	295	577	finally
    //   353	359	577	finally
    //   363	371	577	finally
    //   375	382	577	finally
    //   386	398	577	finally
    //   402	409	577	finally
    //   413	420	577	finally
    //   424	434	577	finally
    //   476	482	577	finally
    //   486	495	577	finally
  }
  
  private boolean b()
  {
    Object localObject1 = (String)SharedPreUtils.b(BaseApplicationImpl.context, getCurrentAccountUin(), "teens_mode_last_report_alphabetic_time", "");
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject1);
    boolean bool2 = false;
    if (!bool1) {
      try
      {
        Object localObject2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE).parse((String)localObject1);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTime((Date)localObject2);
        localObject2 = Calendar.getInstance();
        ((Calendar)localObject2).setTime(new Date());
        bool1 = bool2;
        if (((Calendar)localObject1).get(0) == ((Calendar)localObject2).get(0))
        {
          bool1 = bool2;
          if (((Calendar)localObject1).get(1) == ((Calendar)localObject2).get(1))
          {
            int i = ((Calendar)localObject1).get(6);
            int j = ((Calendar)localObject2).get(6);
            bool1 = bool2;
            if (i == j) {
              bool1 = true;
            }
          }
        }
        return bool1;
      }
      catch (ParseException localParseException)
      {
        localParseException.printStackTrace();
      }
    }
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setVisibilityForAlphabeticFontStatus OPEN=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("AlphabeticFontHandler", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.a.getCurrentAccountUin());
        if (paramBoolean)
        {
          s = 1;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23053).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_42483");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("uint32_input_status_flag", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromAlphabeticFontHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AlphabeticFontHandler", 1, "setMedalSwitch ex", localException);
        }
        return;
      }
      short s = 2;
    }
  }
  
  public boolean a()
  {
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    try
    {
      long l = Long.parseLong(this.a.getCurrentAccountUin());
      localReqBody.rpt_uint64_uins.add(Long.valueOf(l));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    localReqBody.uint32_alphabetic_font_flag.set(1);
    sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42483", 1515, 22, localReqBody.toByteArray()));
    return ((Boolean)SharedPreUtils.b(BaseApplicationImpl.context, getCurrentAccountUin(), "key_alphabetic_font_switch_status_", Boolean.valueOf(false))).booleanValue();
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return AlphabeticFontSwitchObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      if (TextUtils.equals("OidbSvc.0x5eb_42483", paramFromServiceMsg.getServiceCmd()))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      if (TextUtils.equals("OidbSvc.0x4ff_42483", paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.studymode.AlphabeticFontHandler
 * JD-Core Version:    0.7.0.1
 */