package com.tencent.mobileqq.ocr.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.ocr.OCRObserver;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpAROcrInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpClientRequestBodyV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533.HttpDeviceV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533.ReqBody;
import tencent.im.msg.im_msg_head.Head;
import tencent.im.msg.im_msg_head.HttpConnHead;
import tencent.im.msg.im_msg_head.LoginSig;
import tencent.im.oidb.cmd0x990.oidb_0x990.BatchTranslateReq;
import tencent.im.oidb.cmd0x990.oidb_0x990.BatchTranslateRsp;
import tencent.im.oidb.cmd0x990.oidb_0x990.ReqBody;
import tencent.im.oidb.cmd0x990.oidb_0x990.RspBody;
import tencent.im.oidb.cmd0x990.oidb_0x990.TranslateRsp;

public class OCRHandler
  extends BusinessHandler
{
  private static int jdField_a_of_type_Int = 0;
  public static final String a = "com.tencent.mobileqq.ocr.api.impl.OCRHandler";
  public static boolean a = false;
  public static String b = "OidbSvc.0x990";
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public OCRHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private static int a()
  {
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    return i;
  }
  
  /* Error */
  private void a(int paramInt, Intent paramIntent, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 9
    //   3: aconst_null
    //   4: astore 14
    //   6: aconst_null
    //   7: astore 15
    //   9: aconst_null
    //   10: astore 12
    //   12: aload_2
    //   13: ifnull +23 -> 36
    //   16: aload_2
    //   17: ldc 32
    //   19: invokevirtual 38	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 13
    //   24: aload_2
    //   25: ldc 40
    //   27: lconst_0
    //   28: invokevirtual 44	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   31: lstore 9
    //   33: goto +6 -> 39
    //   36: aconst_null
    //   37: astore 13
    //   39: iconst_1
    //   40: istore 8
    //   42: iload_1
    //   43: ifne +416 -> 459
    //   46: new 46	tencent/im/cs/cmd0x6ff/subcmd0x533$RspBody
    //   49: dup
    //   50: invokespecial 48	tencent/im/cs/cmd0x6ff/subcmd0x533$RspBody:<init>	()V
    //   53: astore_2
    //   54: aload_2
    //   55: aload_3
    //   56: invokevirtual 52	tencent/im/cs/cmd0x6ff/subcmd0x533$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   59: pop
    //   60: aload_2
    //   61: getfield 56	tencent/im/cs/cmd0x6ff/subcmd0x533$RspBody:msg_ocr_result	Ltencent/im/cs/cmd0x6ff/subcmd0x533$HttpAROcrResult;
    //   64: invokevirtual 62	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpAROcrResult:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   67: checkcast 58	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpAROcrResult
    //   70: getfield 66	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpAROcrResult:msg_sougou_rsp	Ltencent/im/cs/cmd0x6ff/subcmd0x533$HttpServerResponseBodyV2;
    //   73: invokevirtual 69	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpServerResponseBodyV2:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   76: checkcast 68	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpServerResponseBodyV2
    //   79: astore_3
    //   80: aload_3
    //   81: invokevirtual 73	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpServerResponseBodyV2:has	()Z
    //   84: istore 11
    //   86: iconst_m1
    //   87: istore 5
    //   89: iload 11
    //   91: ifeq +15 -> 106
    //   94: aload_3
    //   95: getfield 77	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpServerResponseBodyV2:int32_tencent_errorcode	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   98: invokevirtual 81	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   101: istore 4
    //   103: goto +6 -> 109
    //   106: iconst_m1
    //   107: istore 4
    //   109: aload_3
    //   110: invokevirtual 73	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpServerResponseBodyV2:has	()Z
    //   113: ifeq +12 -> 125
    //   116: aload_3
    //   117: getfield 84	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpServerResponseBodyV2:int32_sougou_errorcode	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   120: invokevirtual 81	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   123: istore 5
    //   125: iload 4
    //   127: ifne +158 -> 285
    //   130: iload 5
    //   132: ifne +153 -> 285
    //   135: new 86	java/util/ArrayList
    //   138: dup
    //   139: invokespecial 87	java/util/ArrayList:<init>	()V
    //   142: astore_2
    //   143: aload_3
    //   144: getfield 91	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpServerResponseBodyV2:rpt_msg_cards	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   147: invokevirtual 96	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   150: invokeinterface 102 1 0
    //   155: astore_3
    //   156: aload_3
    //   157: invokeinterface 107 1 0
    //   162: ifeq +102 -> 264
    //   165: aload_3
    //   166: invokeinterface 111 1 0
    //   171: checkcast 113	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpCardV2
    //   174: getfield 116	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpCardV2:rpt_msg_card_properties	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   177: invokevirtual 96	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   180: invokestatic 121	com/tencent/mobileqq/ocr/OCRTextSearchInfo:a	(Ljava/util/List;)Lcom/tencent/mobileqq/ocr/OCRTextSearchInfo$SougouSearchInfo;
    //   183: astore 12
    //   185: aload 12
    //   187: getfield 126	com/tencent/mobileqq/ocr/OCRTextSearchInfo$SougouSearchInfo:title	Ljava/lang/String;
    //   190: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   193: ifeq +17 -> 210
    //   196: aload 12
    //   198: getfield 135	com/tencent/mobileqq/ocr/OCRTextSearchInfo$SougouSearchInfo:abstractStr	Ljava/lang/String;
    //   201: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   204: ifeq +6 -> 210
    //   207: goto -51 -> 156
    //   210: aload_2
    //   211: aload 12
    //   213: invokeinterface 139 2 0
    //   218: pop
    //   219: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq -66 -> 156
    //   225: new 146	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   232: astore 14
    //   234: aload 14
    //   236: ldc 149
    //   238: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 14
    //   244: aload 12
    //   246: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 158
    //   252: iconst_2
    //   253: aload 14
    //   255: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: goto -105 -> 156
    //   264: aload_2
    //   265: invokeinterface 169 1 0
    //   270: istore 6
    //   272: iconst_1
    //   273: istore 11
    //   275: goto +203 -> 478
    //   278: astore_3
    //   279: aload_2
    //   280: astore 12
    //   282: goto +133 -> 415
    //   285: aload 14
    //   287: astore_2
    //   288: iload 4
    //   290: istore 7
    //   292: iload 5
    //   294: istore 6
    //   296: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +153 -> 452
    //   302: new 146	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   309: astore_2
    //   310: aload_2
    //   311: ldc 171
    //   313: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_2
    //   318: iload 4
    //   320: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload_2
    //   325: ldc 176
    //   327: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_2
    //   332: iload 5
    //   334: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_2
    //   339: ldc 178
    //   341: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_2
    //   346: aload_3
    //   347: getfield 182	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpServerResponseBodyV2:string_tencent_errormsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   350: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   353: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload_2
    //   358: ldc 188
    //   360: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload_2
    //   365: aload_3
    //   366: getfield 191	tencent/im/cs/cmd0x6ff/subcmd0x533$HttpServerResponseBodyV2:string_sougou_errormsg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   369: invokevirtual 186	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   372: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: ldc 158
    //   378: iconst_2
    //   379: aload_2
    //   380: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload 14
    //   388: astore_2
    //   389: iload 4
    //   391: istore 7
    //   393: iload 5
    //   395: istore 6
    //   397: goto +55 -> 452
    //   400: astore_3
    //   401: goto +14 -> 415
    //   404: astore_3
    //   405: goto +7 -> 412
    //   408: astore_3
    //   409: iconst_0
    //   410: istore 4
    //   412: iconst_0
    //   413: istore 5
    //   415: aload 12
    //   417: astore_2
    //   418: iload 4
    //   420: istore 7
    //   422: iload 5
    //   424: istore 6
    //   426: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +23 -> 452
    //   432: ldc 158
    //   434: iconst_2
    //   435: ldc 193
    //   437: aload_3
    //   438: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   441: iload 5
    //   443: istore 6
    //   445: iload 4
    //   447: istore 7
    //   449: aload 12
    //   451: astore_2
    //   452: iload 6
    //   454: istore 5
    //   456: goto +12 -> 468
    //   459: iconst_0
    //   460: istore 7
    //   462: iconst_0
    //   463: istore 5
    //   465: aload 15
    //   467: astore_2
    //   468: iconst_0
    //   469: istore 11
    //   471: iconst_0
    //   472: istore 6
    //   474: iload 7
    //   476: istore 4
    //   478: aload_0
    //   479: iconst_1
    //   480: iload 11
    //   482: iconst_2
    //   483: anewarray 199	java/lang/Object
    //   486: dup
    //   487: iconst_0
    //   488: aload 13
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: aload_2
    //   494: aastore
    //   495: invokevirtual 203	com/tencent/mobileqq/ocr/api/impl/OCRHandler:notifyUI	(IZLjava/lang/Object;)V
    //   498: iload_1
    //   499: ifeq +13 -> 512
    //   502: iload_1
    //   503: istore 5
    //   505: iload 8
    //   507: istore 4
    //   509: goto +35 -> 544
    //   512: iload 4
    //   514: ifeq +13 -> 527
    //   517: iload 4
    //   519: istore 5
    //   521: iconst_2
    //   522: istore 4
    //   524: goto +20 -> 544
    //   527: iload 5
    //   529: ifeq +9 -> 538
    //   532: iconst_3
    //   533: istore 4
    //   535: goto +9 -> 544
    //   538: iconst_0
    //   539: istore 4
    //   541: iconst_0
    //   542: istore 5
    //   544: new 205	java/util/HashMap
    //   547: dup
    //   548: invokespecial 206	java/util/HashMap:<init>	()V
    //   551: astore_3
    //   552: invokestatic 212	android/os/SystemClock:elapsedRealtime	()J
    //   555: lload 9
    //   557: lsub
    //   558: lstore 9
    //   560: aload_3
    //   561: ldc 214
    //   563: lload 9
    //   565: invokestatic 220	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   568: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   571: pop
    //   572: iload 5
    //   574: ifne +12 -> 586
    //   577: iload 5
    //   579: invokestatic 229	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   582: astore_2
    //   583: goto +37 -> 620
    //   586: new 146	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   593: astore_2
    //   594: aload_2
    //   595: iload 4
    //   597: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload_2
    //   602: ldc 231
    //   604: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_2
    //   609: iload 5
    //   611: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload_2
    //   616: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: astore_2
    //   620: aload_3
    //   621: ldc 233
    //   623: aload_2
    //   624: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   627: pop
    //   628: aload_3
    //   629: ldc 235
    //   631: iload 5
    //   633: invokestatic 229	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   636: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   639: pop
    //   640: aload_3
    //   641: ldc 237
    //   643: iload 4
    //   645: invokestatic 229	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   648: invokevirtual 224	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   651: pop
    //   652: aload_0
    //   653: getfield 24	com/tencent/mobileqq/ocr/api/impl/OCRHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   656: invokevirtual 243	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   659: invokestatic 249	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   662: aload_0
    //   663: getfield 24	com/tencent/mobileqq/ocr/api/impl/OCRHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   666: invokevirtual 252	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   669: ldc 254
    //   671: iload 11
    //   673: lload 9
    //   675: lconst_0
    //   676: aload_3
    //   677: ldc_w 256
    //   680: invokevirtual 260	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   683: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   686: ifeq +79 -> 765
    //   689: new 146	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   696: astore_3
    //   697: aload_3
    //   698: ldc_w 262
    //   701: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload_3
    //   706: iload_1
    //   707: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload_3
    //   712: ldc_w 264
    //   715: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload_3
    //   720: iload 11
    //   722: invokevirtual 267	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_3
    //   727: ldc_w 269
    //   730: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload_3
    //   735: aload_2
    //   736: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload_3
    //   741: ldc_w 271
    //   744: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload_3
    //   749: iload 6
    //   751: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: ldc 158
    //   757: iconst_2
    //   758: aload_3
    //   759: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	766	0	this	OCRHandler
    //   0	766	1	paramInt	int
    //   0	766	2	paramIntent	Intent
    //   0	766	3	paramArrayOfByte	byte[]
    //   101	543	4	i	int
    //   87	545	5	j	int
    //   270	480	6	k	int
    //   290	185	7	m	int
    //   40	466	8	n	int
    //   1	673	9	l	long
    //   84	637	11	bool	boolean
    //   10	440	12	localObject1	Object
    //   22	467	13	str	String
    //   4	383	14	localStringBuilder	StringBuilder
    //   7	459	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   143	156	278	java/lang/Exception
    //   156	207	278	java/lang/Exception
    //   210	261	278	java/lang/Exception
    //   264	272	278	java/lang/Exception
    //   135	143	400	java/lang/Exception
    //   296	386	400	java/lang/Exception
    //   109	125	404	java/lang/Exception
    //   46	86	408	java/lang/Exception
    //   94	103	408	java/lang/Exception
  }
  
  private void a(int paramInt, Intent paramIntent, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    long l = paramIntent.getLongExtra("param_subtype", 0L);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleReqBigDataRsp, errorCode=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("Q.ocr.OCRHandlerImpl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i = paramInt;
    if (paramInt == 0) {}
    label1164:
    for (;;)
    {
      try
      {
        int k = paramArrayOfByte1.length;
        Object localObject3;
        if ((paramArrayOfByte1[0] == 40) && (paramArrayOfByte1[(k - 1)] == 41))
        {
          paramArrayOfByte1 = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte1));
          paramArrayOfByte1.readByte();
          i = paramArrayOfByte1.readInt();
          int j = paramArrayOfByte1.readInt();
          if ((i <= k) && (j <= k))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("handleReqBigDataRsp | headLen=");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append(" | bodyLen=");
              ((StringBuilder)localObject1).append(j);
              QLog.i("Q.ocr.OCRHandlerImpl", 2, ((StringBuilder)localObject1).toString());
            }
            if (i > 0)
            {
              localObject1 = new byte[i];
              paramArrayOfByte1.read((byte[])localObject1);
              localObject3 = new im_msg_head.Head();
              ((im_msg_head.Head)localObject3).mergeFrom((byte[])localObject1);
              localObject3 = (im_msg_head.HttpConnHead)((im_msg_head.Head)localObject3).msg_httpconn_head.get();
              paramInt = ((im_msg_head.HttpConnHead)localObject3).uint32_error_code.get();
              if (!QLog.isDevelopLevel()) {
                break label1164;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("uint64_uin=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint64_uin.get());
              ((StringBuilder)localObject1).append(", uint32_command=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_command.get());
              ((StringBuilder)localObject1).append(", uint32_sub_command=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_sub_command.get());
              ((StringBuilder)localObject1).append(", uint32_seq=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_seq.get());
              ((StringBuilder)localObject1).append(", uint32_version=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_version.get());
              ((StringBuilder)localObject1).append(", uint32_retry_times=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_retry_times.get());
              ((StringBuilder)localObject1).append(", uint32_client_type=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_client_type.get());
              ((StringBuilder)localObject1).append(", uint32_pub_no=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_pub_no.get());
              ((StringBuilder)localObject1).append(", uint32_local_id=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_local_id.get());
              ((StringBuilder)localObject1).append(", uint32_time_zone=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_time_zone.get());
              ((StringBuilder)localObject1).append(", uint32_client_ip=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_client_ip.get());
              ((StringBuilder)localObject1).append(", uint32_client_port=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_client_port.get());
              ((StringBuilder)localObject1).append(", uint32_qzhttp_ip=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_qzhttp_ip.get());
              ((StringBuilder)localObject1).append(", uint32_qzhttp_port=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_qzhttp_port.get());
              ((StringBuilder)localObject1).append(", uint32_spp_ip=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_spp_ip.get());
              ((StringBuilder)localObject1).append(", uint32_spp_port=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_spp_port.get());
              ((StringBuilder)localObject1).append(", uint32_flag=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_flag.get());
              ((StringBuilder)localObject1).append(", bytes_key=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).bytes_key.get());
              ((StringBuilder)localObject1).append(", uint32_compress_type=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_compress_type.get());
              ((StringBuilder)localObject1).append(", uint32_origin_size=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_origin_size.get());
              ((StringBuilder)localObject1).append(", uint32_error_code=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_error_code.get());
              ((StringBuilder)localObject1).append(", uint32_command_id=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_command_id.get());
              ((StringBuilder)localObject1).append(", uint32_service_cmdid=");
              ((StringBuilder)localObject1).append(((im_msg_head.HttpConnHead)localObject3).uint32_service_cmdid.get());
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("handleReqBigData,  RspHttpConnHead=");
              ((StringBuilder)localObject3).append(((StringBuilder)localObject1).toString());
              QLog.i("Q.ocr.OCRHandlerImpl", 4, ((StringBuilder)localObject3).toString());
              break label1164;
            }
            localObject1 = localObject2;
            i = paramInt;
            if (j > 0)
            {
              localObject1 = localObject2;
              i = paramInt;
              if (paramInt == 0)
              {
                localObject1 = new byte[j];
                paramArrayOfByte1.read((byte[])localObject1);
                localObject1 = new Cryptor().decrypt((byte[])localObject1, paramArrayOfByte2);
                i = paramInt;
              }
            }
          }
          else
          {
            a(-2, paramIntent, null, null);
            if (!QLog.isColorLevel()) {
              break;
            }
            paramArrayOfByte1 = new StringBuilder();
            paramArrayOfByte1.append("handleReqBigDataRsp error, unexpected length, headLen=");
            paramArrayOfByte1.append(i);
            paramArrayOfByte1.append(", bodyLen=");
            paramArrayOfByte1.append(j);
            QLog.e("Q.ocr.OCRHandlerImpl", 2, paramArrayOfByte1.toString());
          }
        }
        else
        {
          paramArrayOfByte2 = new StringBuilder();
          paramArrayOfByte2.append("unexpected body data, len=");
          paramArrayOfByte2.append(k);
          paramArrayOfByte2.append(", data=");
          localObject3 = paramArrayOfByte2.toString();
          paramArrayOfByte2 = paramArrayOfByte1.toString();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject3);
          paramArrayOfByte1 = paramArrayOfByte2;
          if (paramArrayOfByte2.length() > 20) {
            paramArrayOfByte1 = paramArrayOfByte2.substring(0, 20);
          }
          ((StringBuilder)localObject1).append(paramArrayOfByte1);
          paramArrayOfByte1 = ((StringBuilder)localObject1).toString();
          a(-2, paramIntent, null, null);
          if (QLog.isColorLevel())
          {
            paramArrayOfByte2 = new StringBuilder();
            paramArrayOfByte2.append("handleReqBigDataRsp error, errorMsg=");
            paramArrayOfByte2.append(paramArrayOfByte1);
            QLog.e("Q.ocr.OCRHandlerImpl", 2, paramArrayOfByte2.toString());
          }
          return;
        }
      }
      catch (Exception paramArrayOfByte1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.ocr.OCRHandlerImpl", 2, "handleReqBigDataRsp error", paramArrayOfByte1);
        }
        i = -10;
        localObject1 = localObject2;
      }
      if (l == 2L) {
        a(i, paramIntent, (byte[])localObject1);
      }
      return;
    }
  }
  
  private void a(Intent paramIntent)
  {
    long l1 = paramIntent.getLongExtra("param_uin", 0L);
    Object localObject6 = paramIntent.getByteArrayExtra("param_reqbody");
    long l2 = paramIntent.getLongExtra("param_subtype", 0L);
    if ((l1 != 0L) && (localObject6 != null))
    {
      Object localObject1 = ConfigManager.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine());
      boolean bool2 = false;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((ConfigManager)localObject1).getOtherTypeIp(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), 21, false);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = (EndPoint)((List)localObject1).get(0);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("https://");
          ((StringBuilder)localObject2).append(((EndPoint)localObject1).host);
          ((StringBuilder)localObject2).append(":");
          ((StringBuilder)localObject2).append(((EndPoint)localObject1).port);
          ((StringBuilder)localObject2).append("/");
          localObject1 = ((StringBuilder)localObject2).toString();
          break label193;
        }
      }
      localObject1 = "";
      label193:
      Object localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = "https://sslv6.htdata.qq.com/";
      }
      byte[] arrayOfByte = SessionInfo.getInstance(getCurrentAccountUin()).getSessionKey();
      Object localObject5 = SessionInfo.getInstance(getCurrentAccountUin()).getHttpconn_sig_session();
      if (arrayOfByte != null)
      {
        localObject2 = arrayOfByte;
        localObject1 = localObject5;
        if (localObject5 != null) {}
      }
      else
      {
        localObject1 = localObject5;
      }
      try
      {
        int i;
        if (SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin()).getHttpconn_sig_session() != null)
        {
          i = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin()).getHttpconn_sig_session().length;
          localObject1 = new byte[i];
          System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin()).getHttpconn_sig_session(), 0, localObject1, 0, i);
        }
        localObject2 = arrayOfByte;
        if (SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin()).getSessionKey() != null)
        {
          i = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin()).getSessionKey().length;
          localObject2 = new byte[i];
          System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin()).getSessionKey(), 0, localObject2, 0, i);
        }
        Object localObject4;
        if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (localObject1 != null))
        {
          arrayOfByte = new Cryptor().encrypt((byte[])localObject6, (byte[])localObject2);
          localObject5 = new im_msg_head.Head();
          ((im_msg_head.Head)localObject5).uint32_head_type.set(4);
          localObject6 = new im_msg_head.LoginSig();
          ((im_msg_head.LoginSig)localObject6).uint32_type.set(22);
          ((im_msg_head.LoginSig)localObject6).bytes_sig.set(ByteStringMicro.copyFrom((byte[])localObject1));
          ((im_msg_head.Head)localObject5).msg_login_sig.set((MessageMicro)localObject6);
          localObject1 = new im_msg_head.HttpConnHead();
          ((im_msg_head.HttpConnHead)localObject1).uint64_uin.set(l1);
          ((im_msg_head.HttpConnHead)localObject1).uint32_command.set(1791);
          ((im_msg_head.HttpConnHead)localObject1).uint32_sub_command.set(1331);
          ((im_msg_head.HttpConnHead)localObject1).uint32_seq.set(a());
          ((im_msg_head.HttpConnHead)localObject1).uint32_version.set(4643);
          ((im_msg_head.HttpConnHead)localObject1).uint32_flag.set(1);
          ((im_msg_head.HttpConnHead)localObject1).uint32_compress_type.set(0);
          ((im_msg_head.HttpConnHead)localObject1).uint32_error_code.set(0);
          ((im_msg_head.Head)localObject5).msg_httpconn_head.set((MessageMicro)localObject1);
          localObject5 = ((im_msg_head.Head)localObject5).toByteArray();
          localObject1 = new ByteArrayOutputStream();
          try
          {
            localObject6 = new DataOutputStream((OutputStream)localObject1);
            ((DataOutputStream)localObject6).write(40);
            ((DataOutputStream)localObject6).writeInt(localObject5.length);
            ((DataOutputStream)localObject6).writeInt(arrayOfByte.length);
            ((DataOutputStream)localObject6).write((byte[])localObject5);
            ((DataOutputStream)localObject6).write(arrayOfByte);
            ((DataOutputStream)localObject6).write(41);
            ((DataOutputStream)localObject6).flush();
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.ocr.OCRHandlerImpl", 2, "reqSouggouSearchBigData", localException);
            }
            a(-10, paramIntent, null, null);
          }
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append("cgi-bin/httpconn");
          localObject4 = ((StringBuilder)localObject4).toString();
          localObject5 = ((ByteArrayOutputStream)localObject1).toByteArray();
          localObject1 = new HttpNetReq();
          ((HttpNetReq)localObject1).mSendData = ((byte[])localObject5);
          ((HttpNetReq)localObject1).mCallback = new OCRHandler.BaseOCRReqBigDataListener(this, paramIntent, (byte[])localObject2, (String)localObject3);
          ((HttpNetReq)localObject1).mReqUrl = ((String)localObject4);
          ((HttpNetReq)localObject1).mHttpMethod = 1;
          ((HttpNetReq)localObject1).mFileType = 57;
          ((HttpNetReq)localObject1).mReqProperties.put("Accept-Encoding", "identity");
          ((HttpNetReq)localObject1).mContinuErrorLimit = 2;
          ((HttpNetReq)localObject1).mExcuteTimeLimit = 15000L;
          ((HttpNetReq)localObject1).mIsHttps = true;
          ((HttpNetReq)localObject1).mIsHostIP = true;
          ((HttpNetReq)localObject1).mHostForHttpsVerify = "sslv6.htdata.qq.com";
          paramIntent = MobileQQ.sMobileQQ.waitAppRuntime(null);
          if ((paramIntent instanceof AppInterface))
          {
            ((IHttpEngineService)((AppInterface)paramIntent).getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject1);
            if (QLog.isColorLevel()) {
              QLog.i("Q.ocr.OCRHandlerImpl", 2, "reqSouggouSearchBigData send");
            }
          }
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("reqSouggouSearchBigData start, uin=");
            paramIntent.append(l1);
            paramIntent.append(",subType=");
            paramIntent.append(l2);
            paramIntent.append(",url=");
            paramIntent.append((String)localObject4);
            paramIntent.append(",testserver=");
            paramIntent.append(jdField_a_of_type_Boolean);
            QLog.i("Q.ocr.OCRHandlerImpl", 2, paramIntent.toString());
          }
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("reqSouggouSearchBigData, host=");
          ((StringBuilder)localObject4).append((String)localObject3);
          ((StringBuilder)localObject4).append(",bkeyIsNull=");
          if (localObject2 == null) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          ((StringBuilder)localObject4).append(bool1);
          ((StringBuilder)localObject4).append(",bSignIsNull=");
          boolean bool1 = bool2;
          if (localObject1 == null) {
            bool1 = true;
          }
          ((StringBuilder)localObject4).append(bool1);
          QLog.i("Q.ocr.OCRHandlerImpl", 2, ((StringBuilder)localObject4).toString());
        }
        a(-1, paramIntent, null, null);
        return;
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.OCRHandlerImpl", 2, "reqSouggouSearchBigData, uin or reqBody is null");
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0x990.RspBody();
    int k = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramFromServiceMsg = "";
    int i;
    if ((k == 0) && (((oidb_0x990.RspBody)localObject).msg_translate_rsp.has()))
    {
      paramObject = (oidb_0x990.TranslateRsp)((oidb_0x990.RspBody)localObject).msg_translate_rsp.get();
      int j = paramObject.int32_ret_code.get();
      if (j == 0)
      {
        i = j;
        if (paramObject.bytes_trans_result.has())
        {
          paramFromServiceMsg = paramObject.bytes_trans_result.get().toStringUtf8();
          i = j;
        }
      }
      else
      {
        QLog.d("Q.ocr.OCRHandlerImpl", 1, String.format("handleTranslateResp, errCode: %s", new Object[] { Integer.valueOf(j) }));
        i = j;
      }
    }
    else
    {
      QLog.d("Q.ocr.OCRHandlerImpl", 1, String.format("handleBatchTranslateResp parse error, result: %s", new Object[] { Integer.valueOf(k) }));
      i = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.OCRHandlerImpl", 2, String.format("handleTranslateResp, result: %s, errCode: %s, translateResult: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramFromServiceMsg }));
    }
    paramObject = new Object[2];
    paramObject[0] = Integer.valueOf(0);
    if ((k == 0) && (i == 0))
    {
      localObject = new TranslateResult(0);
      ((TranslateResult)localObject).a(paramToServiceMsg.extraData.getString("param_translate_src_lang"), paramToServiceMsg.extraData.getString("param_translate_dst_lang"), paramToServiceMsg.extraData.getString("param_translate_src_text"), paramFromServiceMsg);
      paramObject[1] = localObject;
      notifyUI(2, true, paramObject);
      return;
    }
    notifyUI(2, false, paramObject);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject3 = new oidb_0x990.RspBody();
    int m = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject3);
    Object localObject2 = null;
    Object localObject1 = null;
    String str = "";
    if ((m == 0) && (((oidb_0x990.RspBody)localObject3).msg_batch_translate_rsp.has()))
    {
      localObject3 = (oidb_0x990.BatchTranslateRsp)((oidb_0x990.RspBody)localObject3).msg_batch_translate_rsp.get();
      if (localObject3 != null)
      {
        i = ((oidb_0x990.BatchTranslateRsp)localObject3).int32_error_code.get();
        if (i == 0)
        {
          if (((oidb_0x990.BatchTranslateRsp)localObject3).rpt_src_bytes_text_list.has())
          {
            paramFromServiceMsg = ((oidb_0x990.BatchTranslateRsp)localObject3).rpt_src_bytes_text_list.get();
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
            {
              paramObject = new ArrayList();
              localObject2 = paramFromServiceMsg.iterator();
              for (;;)
              {
                paramFromServiceMsg = paramObject;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramObject.add(((ByteStringMicro)((Iterator)localObject2).next()).toStringUtf8());
              }
            }
          }
          paramFromServiceMsg = null;
          paramObject = localObject1;
          if (((oidb_0x990.BatchTranslateRsp)localObject3).rpt_dst_bytes_text_list.has())
          {
            localObject2 = ((oidb_0x990.BatchTranslateRsp)localObject3).rpt_dst_bytes_text_list.get();
            paramObject = localObject1;
            if (localObject2 != null)
            {
              paramObject = localObject1;
              if (((List)localObject2).size() > 0)
              {
                localObject1 = new ArrayList();
                localObject2 = ((List)localObject2).iterator();
                for (;;)
                {
                  paramObject = localObject1;
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  ((List)localObject1).add(((ByteStringMicro)((Iterator)localObject2).next()).toStringUtf8());
                }
              }
            }
          }
          localObject1 = paramFromServiceMsg;
          paramFromServiceMsg = paramObject;
          paramObject = str;
          break label374;
        }
        paramObject = str;
        if (((oidb_0x990.BatchTranslateRsp)localObject3).bytes_error_msg.has()) {
          paramObject = ((oidb_0x990.BatchTranslateRsp)localObject3).bytes_error_msg.get().toStringUtf8();
        }
        QLog.d("Q.ocr.OCRHandlerImpl", 1, new Object[] { "handleBatchTranslateResp translate error, errCode: %s, errMsg: %s", Integer.valueOf(i), paramObject });
        paramFromServiceMsg = null;
        localObject1 = localObject2;
        break label374;
      }
    }
    else
    {
      QLog.d("Q.ocr.OCRHandlerImpl", 1, String.format("handleBatchTranslateResp parse error, result: %s", new Object[] { Integer.valueOf(m) }));
    }
    paramFromServiceMsg = null;
    int i = 0;
    paramObject = str;
    localObject1 = localObject2;
    label374:
    if (QLog.isColorLevel())
    {
      int j;
      if (localObject1 == null) {
        j = 0;
      } else {
        j = ((List)localObject1).size();
      }
      int k;
      if (paramFromServiceMsg == null) {
        k = 0;
      } else {
        k = paramFromServiceMsg.size();
      }
      QLog.d("Q.ocr.OCRHandlerImpl", 2, String.format("handleBatchTranslateResp, result: %s, errCode: %s, errMsg: %s, scrTextSize: %s, dstTextSize: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), paramObject, Integer.valueOf(j), Integer.valueOf(k) }));
    }
    paramObject = new Object[2];
    paramObject[0] = Integer.valueOf(1);
    if ((localObject1 != null) && (paramFromServiceMsg != null))
    {
      str = paramToServiceMsg.extraData.getString("param_translate_src_lang");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("param_translate_dst_lang");
      localObject2 = new TranslateResult(1);
      ((TranslateResult)localObject2).a(str, paramToServiceMsg, (List)localObject1, paramFromServiceMsg);
      paramObject[1] = localObject2;
      notifyUI(2, true, paramObject);
      return;
    }
    notifyUI(2, false, paramObject);
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doSougouSearch start, sessionId=");
      ((StringBuilder)localObject1).append(paramString1);
      QLog.d("Q.ocr.OCRHandlerImpl", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new subcmd0x533.HttpClientRequestBodyV2();
    Object localObject2 = new subcmd0x533.HttpDeviceV2();
    ((subcmd0x533.HttpDeviceV2)localObject2).platform.set(1);
    ((subcmd0x533.HttpClientRequestBodyV2)localObject1).msg_device.set((MessageMicro)localObject2);
    localObject2 = new ArrayList(1);
    ((List)localObject2).add(paramString2);
    ((subcmd0x533.HttpClientRequestBodyV2)localObject1).rpt_string_sentences.set((List)localObject2);
    ((subcmd0x533.HttpClientRequestBodyV2)localObject1).uint32_timeout_ms.set(3000);
    paramString2 = new subcmd0x533.HttpAROcrInfo();
    paramString2.uint64_ocr_recog_type.set(2L);
    paramString2.msg_sougou_req.set((MessageMicro)localObject1);
    localObject1 = new subcmd0x533.ReqBody();
    ((subcmd0x533.ReqBody)localObject1).string_session_id.set(paramString1);
    ((subcmd0x533.ReqBody)localObject1).uint64_req_recog_type.set(16L);
    ((subcmd0x533.ReqBody)localObject1).uint32_business_type.set(0);
    ((subcmd0x533.ReqBody)localObject1).string_clt_version.set(String.valueOf(AppSetting.a()));
    ((subcmd0x533.ReqBody)localObject1).msg_ocr_info.set(paramString2);
    paramString2 = new Intent();
    paramString2.putExtra("param_uin", Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
    paramString2.putExtra("param_reqbody", ((subcmd0x533.ReqBody)localObject1).toByteArray());
    paramString2.putExtra("param_subtype", 2L);
    paramString2.putExtra("param_sougou_sessionid", paramString1);
    paramString2.putExtra("param_starttime", paramLong);
    a(paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.d("Q.ocr.OCRHandlerImpl", 1, "batchTranslate, texts is empty!");
      return;
    }
    paramString1 = paramString1.split("\n");
    ArrayList localArrayList = new ArrayList();
    if ((paramString1 != null) && (paramString1.length > 0))
    {
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString1[i];
        if (!TextUtils.isEmpty(localObject.trim().replace("\n", ""))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    if (localArrayList.size() > 0)
    {
      a(localArrayList, paramString2, paramString3);
      return;
    }
    QLog.d("Q.ocr.OCRHandlerImpl", 1, "batchTranslate, srcTextList is empty!");
  }
  
  public void a(List<String> paramList, String paramString1, String paramString2)
  {
    oidb_0x990.ReqBody localReqBody = new oidb_0x990.ReqBody();
    oidb_0x990.BatchTranslateReq localBatchTranslateReq = new oidb_0x990.BatchTranslateReq();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        localBatchTranslateReq.rpt_src_bytes_text_list.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localBatchTranslateReq.str_src_language.set(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localBatchTranslateReq.str_dst_language.set(paramString2);
    }
    localReqBody.msg_batch_translate_req.set(localBatchTranslateReq);
    paramList = makeOIDBPkg(b, 2448, 2, localReqBody.toByteArray());
    paramList.extraData.putInt("param_translate_type", 2);
    paramList.extraData.putString("param_translate_src_lang", paramString1);
    paramList.extraData.putString("param_translate_dst_lang", paramString2);
    sendPbReq(paramList);
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.OCRHandlerImpl", 2, String.format("batchTranslate, srcLang: %s, dstLang: %s", new Object[] { paramString1, paramString2 }));
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add(b);
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return OCRObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str2 = paramToServiceMsg.extraData.getString("friendUin");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramFromServiceMsg.getUin();
    }
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    new Bundle().putString("uin", str1);
    if (b.equals(paramFromServiceMsg.getServiceCmd()))
    {
      int i = paramToServiceMsg.extraData.getInt("param_translate_type");
      if (i == 1)
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (i == 2)
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      QLog.e("Q.ocr.OCRHandlerImpl", 1, String.format("onReceive, cmd = OidbSvc.0x990, serviceType error: %s", new Object[] { Integer.valueOf(i) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.OCRHandler
 * JD-Core Version:    0.7.0.1
 */