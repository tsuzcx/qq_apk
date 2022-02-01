package com.tencent.mobileqq.transfile;

import acnh;
import aooh;
import axio;
import azjj;
import azjk;
import azkb;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiMsgDownloadProcessor
  extends BaseDownloadProcessor
{
  private int mChannelType;
  private byte[] mContent;
  private byte[] mMsgKey;
  private byte[] mMsgResId = this.mUiRequest.resIdStr.getBytes();
  private String mOutFilePath;
  private int mUinType = this.mUiRequest.mUinType;
  
  public MultiMsgDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
  }
  
  /* Error */
  private boolean parseDownloadMsg(String paramString)
  {
    // Byte code:
    //   0: new 48	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 55	java/io/File:exists	()Z
    //   11: ifne +30 -> 41
    //   14: aload_0
    //   15: ldc 56
    //   17: new 58	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   24: ldc 63
    //   26: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: iconst_0
    //   40: ireturn
    //   41: new 77	java/io/RandomAccessFile
    //   44: dup
    //   45: aload_1
    //   46: ldc 79
    //   48: invokespecial 81	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: astore 6
    //   53: aload 6
    //   55: astore 5
    //   57: aload 6
    //   59: invokevirtual 85	java/io/RandomAccessFile:length	()J
    //   62: l2i
    //   63: newarray byte
    //   65: astore 7
    //   67: aload 6
    //   69: astore 5
    //   71: aload 6
    //   73: aload 7
    //   75: invokevirtual 89	java/io/RandomAccessFile:read	([B)I
    //   78: istore_2
    //   79: aload 6
    //   81: ifnull +8 -> 89
    //   84: aload 6
    //   86: invokevirtual 92	java/io/RandomAccessFile:close	()V
    //   89: aload 7
    //   91: ifnull +13 -> 104
    //   94: aload 7
    //   96: arraylength
    //   97: ifle +7 -> 104
    //   100: iload_2
    //   101: ifgt +154 -> 255
    //   104: aload_0
    //   105: ldc 56
    //   107: ldc 94
    //   109: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 97	java/io/IOException:printStackTrace	()V
    //   119: goto -30 -> 89
    //   122: astore 7
    //   124: aconst_null
    //   125: astore 6
    //   127: aload 6
    //   129: astore 5
    //   131: aload 7
    //   133: invokevirtual 98	java/io/FileNotFoundException:printStackTrace	()V
    //   136: aload 6
    //   138: astore 5
    //   140: aload_0
    //   141: ldc 56
    //   143: new 58	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   150: ldc 63
    //   152: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload 6
    //   167: ifnull +8 -> 175
    //   170: aload 6
    //   172: invokevirtual 92	java/io/RandomAccessFile:close	()V
    //   175: iconst_0
    //   176: ireturn
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 97	java/io/IOException:printStackTrace	()V
    //   182: goto -7 -> 175
    //   185: astore_1
    //   186: aconst_null
    //   187: astore 6
    //   189: aload 6
    //   191: astore 5
    //   193: aload_0
    //   194: ldc 56
    //   196: ldc 100
    //   198: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 6
    //   203: astore 5
    //   205: aload_1
    //   206: invokevirtual 97	java/io/IOException:printStackTrace	()V
    //   209: aload 6
    //   211: ifnull +8 -> 219
    //   214: aload 6
    //   216: invokevirtual 92	java/io/RandomAccessFile:close	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 97	java/io/IOException:printStackTrace	()V
    //   226: goto -7 -> 219
    //   229: astore_1
    //   230: aconst_null
    //   231: astore 5
    //   233: aload 5
    //   235: ifnull +8 -> 243
    //   238: aload 5
    //   240: invokevirtual 92	java/io/RandomAccessFile:close	()V
    //   243: aload_1
    //   244: athrow
    //   245: astore 5
    //   247: aload 5
    //   249: invokevirtual 97	java/io/IOException:printStackTrace	()V
    //   252: goto -9 -> 243
    //   255: aload 7
    //   257: arraylength
    //   258: istore_2
    //   259: aload 7
    //   261: iconst_0
    //   262: baload
    //   263: bipush 40
    //   265: if_icmpne +14 -> 279
    //   268: aload 7
    //   270: iload_2
    //   271: iconst_1
    //   272: isub
    //   273: baload
    //   274: bipush 41
    //   276: if_icmpeq +87 -> 363
    //   279: new 58	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   286: ldc 102
    //   288: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: iload_2
    //   292: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: ldc 107
    //   297: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: astore_1
    //   304: aload 7
    //   306: invokevirtual 110	java/lang/Object:toString	()Ljava/lang/String;
    //   309: astore 5
    //   311: new 58	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   318: aload_1
    //   319: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: astore 6
    //   324: aload 5
    //   326: astore_1
    //   327: aload 5
    //   329: invokevirtual 113	java/lang/String:length	()I
    //   332: bipush 20
    //   334: if_icmple +12 -> 346
    //   337: aload 5
    //   339: iconst_0
    //   340: bipush 20
    //   342: invokevirtual 117	java/lang/String:substring	(II)Ljava/lang/String;
    //   345: astore_1
    //   346: aload_0
    //   347: ldc 56
    //   349: aload 6
    //   351: aload_1
    //   352: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: iconst_0
    //   362: ireturn
    //   363: new 119	java/io/DataInputStream
    //   366: dup
    //   367: new 121	java/io/ByteArrayInputStream
    //   370: dup
    //   371: aload 7
    //   373: invokespecial 124	java/io/ByteArrayInputStream:<init>	([B)V
    //   376: invokespecial 127	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   379: astore 5
    //   381: aload 5
    //   383: invokevirtual 131	java/io/DataInputStream:readByte	()B
    //   386: pop
    //   387: aload 5
    //   389: invokevirtual 134	java/io/DataInputStream:readInt	()I
    //   392: istore 4
    //   394: aload 5
    //   396: invokevirtual 134	java/io/DataInputStream:readInt	()I
    //   399: istore_3
    //   400: iload 4
    //   402: iload_2
    //   403: if_icmpgt +8 -> 411
    //   406: iload_3
    //   407: iload_2
    //   408: if_icmple +40 -> 448
    //   411: aload_0
    //   412: ldc 56
    //   414: new 58	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   421: ldc 136
    //   423: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: iload 4
    //   428: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: ldc 138
    //   433: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: iload_3
    //   437: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   440: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: iconst_0
    //   447: ireturn
    //   448: iload 4
    //   450: ifle +450 -> 900
    //   453: iload 4
    //   455: newarray byte
    //   457: astore_1
    //   458: aload 5
    //   460: aload_1
    //   461: invokevirtual 139	java/io/DataInputStream:read	([B)I
    //   464: pop
    //   465: new 141	tencent/im/msg/im_msg_head$Head
    //   468: dup
    //   469: invokespecial 142	tencent/im/msg/im_msg_head$Head:<init>	()V
    //   472: astore 6
    //   474: aload 6
    //   476: aload_1
    //   477: invokevirtual 146	tencent/im/msg/im_msg_head$Head:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   480: pop
    //   481: aload 6
    //   483: getfield 150	tencent/im/msg/im_msg_head$Head:msg_httpconn_head	Ltencent/im/msg/im_msg_head$HttpConnHead;
    //   486: invokevirtual 156	tencent/im/msg/im_msg_head$HttpConnHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   489: checkcast 152	tencent/im/msg/im_msg_head$HttpConnHead
    //   492: getfield 160	tencent/im/msg/im_msg_head$HttpConnHead:uint32_error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   495: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   498: istore_2
    //   499: goto +403 -> 902
    //   502: aload_0
    //   503: ldc 56
    //   505: new 58	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   512: ldc 166
    //   514: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: iload_3
    //   518: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   521: ldc 168
    //   523: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: iload_2
    //   527: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   530: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: iconst_0
    //   537: ireturn
    //   538: iload_3
    //   539: newarray byte
    //   541: astore_1
    //   542: aload 5
    //   544: aload_1
    //   545: invokevirtual 139	java/io/DataInputStream:read	([B)I
    //   548: pop
    //   549: new 170	com/tencent/qphone/base/util/Cryptor
    //   552: dup
    //   553: invokespecial 171	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   556: aload_1
    //   557: aload_0
    //   558: getfield 173	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mMsgKey	[B
    //   561: invokevirtual 177	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   564: astore 5
    //   566: aload 5
    //   568: ifnull +9 -> 577
    //   571: aload 5
    //   573: arraylength
    //   574: ifgt +13 -> 587
    //   577: aload_0
    //   578: ldc 56
    //   580: ldc 179
    //   582: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: iconst_0
    //   586: ireturn
    //   587: new 181	tencent/im/longconn/longmsg/LongMsg$RspBody
    //   590: dup
    //   591: invokespecial 182	tencent/im/longconn/longmsg/LongMsg$RspBody:<init>	()V
    //   594: astore 6
    //   596: aload 6
    //   598: aload 5
    //   600: invokevirtual 183	tencent/im/longconn/longmsg/LongMsg$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   603: pop
    //   604: aload 6
    //   606: getfield 187	tencent/im/longconn/longmsg/LongMsg$RspBody:rpt_msg_down_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   609: iconst_0
    //   610: invokevirtual 192	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   613: checkcast 194	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp
    //   616: astore 5
    //   618: aload 5
    //   620: ifnonnull +13 -> 633
    //   623: aload_0
    //   624: ldc 56
    //   626: ldc 196
    //   628: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   631: iconst_0
    //   632: ireturn
    //   633: aload 5
    //   635: getfield 199	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   638: invokevirtual 202	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   641: ifne +13 -> 654
    //   644: aload_0
    //   645: ldc 56
    //   647: ldc 204
    //   649: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   652: iconst_0
    //   653: ireturn
    //   654: aload 5
    //   656: getfield 199	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   659: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   662: ifeq +13 -> 675
    //   665: aload_0
    //   666: ldc 56
    //   668: ldc 206
    //   670: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: iconst_0
    //   674: ireturn
    //   675: aload 5
    //   677: getfield 210	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:bytes_msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   680: invokevirtual 213	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   683: ifne +13 -> 696
    //   686: aload_0
    //   687: ldc 56
    //   689: ldc 215
    //   691: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: iconst_0
    //   695: ireturn
    //   696: aload_0
    //   697: aload 5
    //   699: getfield 210	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:bytes_msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   702: invokevirtual 218	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   705: invokevirtual 223	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   708: putfield 225	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mContent	[B
    //   711: aload_0
    //   712: getfield 225	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mContent	[B
    //   715: ifnull +11 -> 726
    //   718: aload_0
    //   719: getfield 225	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mContent	[B
    //   722: arraylength
    //   723: ifgt +13 -> 736
    //   726: aload_0
    //   727: ldc 56
    //   729: ldc 227
    //   731: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   734: iconst_0
    //   735: ireturn
    //   736: aload_0
    //   737: ldc 56
    //   739: new 58	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   746: ldc 229
    //   748: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: aload_1
    //   752: invokestatic 235	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   755: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   764: aload_0
    //   765: ldc 56
    //   767: new 58	java/lang/StringBuilder
    //   770: dup
    //   771: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   774: ldc 237
    //   776: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload_1
    //   780: arraylength
    //   781: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   784: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   787: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   790: aload_0
    //   791: ldc 56
    //   793: new 58	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   800: ldc 239
    //   802: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: aload_0
    //   806: getfield 225	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mContent	[B
    //   809: invokestatic 235	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   812: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   818: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   821: aload_0
    //   822: ldc 56
    //   824: new 58	java/lang/StringBuilder
    //   827: dup
    //   828: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   831: ldc 241
    //   833: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload_0
    //   837: getfield 225	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mContent	[B
    //   840: arraylength
    //   841: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   850: iconst_1
    //   851: ireturn
    //   852: astore_1
    //   853: aload_1
    //   854: invokevirtual 242	java/lang/Exception:printStackTrace	()V
    //   857: aload_0
    //   858: ldc 56
    //   860: new 58	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   867: ldc 244
    //   869: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: aload_1
    //   873: invokevirtual 247	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   876: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: invokevirtual 75	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   885: iconst_0
    //   886: ireturn
    //   887: astore_1
    //   888: goto -655 -> 233
    //   891: astore_1
    //   892: goto -703 -> 189
    //   895: astore 7
    //   897: goto -770 -> 127
    //   900: iconst_0
    //   901: istore_2
    //   902: iload_3
    //   903: ifle -401 -> 502
    //   906: iload_2
    //   907: ifeq -369 -> 538
    //   910: goto -408 -> 502
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	913	0	this	MultiMsgDownloadProcessor
    //   0	913	1	paramString	String
    //   78	829	2	i	int
    //   399	504	3	j	int
    //   392	62	4	k	int
    //   55	184	5	localObject1	Object
    //   245	3	5	localIOException	java.io.IOException
    //   309	389	5	localObject2	Object
    //   51	554	6	localObject3	Object
    //   65	30	7	arrayOfByte	byte[]
    //   122	250	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   895	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   84	89	114	java/io/IOException
    //   41	53	122	java/io/FileNotFoundException
    //   170	175	177	java/io/IOException
    //   41	53	185	java/io/IOException
    //   214	219	221	java/io/IOException
    //   41	53	229	finally
    //   238	243	245	java/io/IOException
    //   363	400	852	java/lang/Exception
    //   411	446	852	java/lang/Exception
    //   453	499	852	java/lang/Exception
    //   502	536	852	java/lang/Exception
    //   538	566	852	java/lang/Exception
    //   571	577	852	java/lang/Exception
    //   577	585	852	java/lang/Exception
    //   587	618	852	java/lang/Exception
    //   623	631	852	java/lang/Exception
    //   633	652	852	java/lang/Exception
    //   654	673	852	java/lang/Exception
    //   675	694	852	java/lang/Exception
    //   696	726	852	java/lang/Exception
    //   726	734	852	java/lang/Exception
    //   736	850	852	java/lang/Exception
    //   57	67	887	finally
    //   71	79	887	finally
    //   131	136	887	finally
    //   140	165	887	finally
    //   193	201	887	finally
    //   205	209	887	finally
    //   57	67	891	java/io/IOException
    //   71	79	891	java/io/IOException
    //   57	67	895	java/io/FileNotFoundException
    //   71	79	895	java/io/FileNotFoundException
  }
  
  private void recieveFile()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    Object localObject2 = null;
    Object localObject1;
    label72:
    Object localObject3;
    if (this.mIpList.size() > 0)
    {
      localObject1 = (ServerAddr)this.mIpList.get(0);
      if (this.mChannelType != 2) {
        break label498;
      }
      localHttpNetReq.mIsHttps = true;
      if (localObject1 == null) {
        break label487;
      }
      localHttpNetReq.mIsHostIP = true;
      if (!((ServerAddr)localObject1).isIpv6) {
        break label476;
      }
      localHttpNetReq.mHostForHttpsVerify = "sslv6.htdata.qq.com";
      localObject3 = new ServerAddr();
      ((ServerAddr)localObject3).mIp = localHttpNetReq.mHostForHttpsVerify;
      ((ServerAddr)localObject3).port = 443;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localObject3;
      }
      this.mIpList.add(localObject3);
      localObject1 = localObject2;
      localObject2 = "https://";
    }
    for (;;)
    {
      label119:
      if (QLog.isColorLevel()) {
        QLog.i("MultiMsg_TAG", 2, "Multimsg download recieveFile  url =" + (String)localObject2);
      }
      if ((((ServerAddr)localObject1).isIpv6) && (!((ServerAddr)localObject1).mIp.startsWith("["))) {}
      for (localObject2 = (String)localObject2 + "[" + ((ServerAddr)localObject1).mIp + "]";; localObject2 = (String)localObject2 + ((ServerAddr)localObject1).mIp)
      {
        localObject3 = localObject2;
        if (((ServerAddr)localObject1).port != 80) {
          localObject3 = (String)localObject2 + ":" + ((ServerAddr)localObject1).port;
        }
        localObject1 = (String)localObject3 + this.mUrlPath;
        logRichMediaEvent("MultimsgDownload.recieveFile", " url:" + (String)localObject1);
        this.mOutFilePath = AbsDownloader.getFilePath((String)localObject1);
        localHttpNetReq.mCallback = this;
        localHttpNetReq.mReqUrl = ((String)localObject1);
        localHttpNetReq.mHttpMethod = 0;
        localHttpNetReq.mServerList = this.mIpList;
        localHttpNetReq.mOutPath = this.mOutFilePath;
        localHttpNetReq.mMsgId = String.valueOf(this.mUiRequest.mUniseq);
        localHttpNetReq.mBusiProtoType = this.mUiRequest.mUinType;
        localHttpNetReq.mFileType = this.mUiRequest.mFileType;
        localHttpNetReq.mStartDownOffset = 0L;
        localHttpNetReq.mIsNetChgAsError = true;
        localHttpNetReq.mReqProperties.put("Accept-Encoding", "identity");
        logRichMediaEvent("httpDown", "url:" + (String)localObject1 + ",downOffset:" + localHttpNetReq.mStartDownOffset);
        if (canDoNextStep()) {
          break label565;
        }
        return;
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MultiMsg_TAG", 2, "Multimsg download recieveFile  ipListSize = 0 ");
        localObject1 = localObject2;
        break;
        label476:
        localHttpNetReq.mHostForHttpsVerify = "ssl.htdata.qq.com";
        break label72;
        label487:
        localHttpNetReq.mHostForHttpsVerify = "sslv6.htdata.qq.com";
        break label72;
        label498:
        if (localObject1 != null) {
          break label587;
        }
        localObject1 = new ServerAddr();
        ((ServerAddr)localObject1).mIp = "sslv6.htdata.qq.com";
        ((ServerAddr)localObject1).port = 8080;
        this.mIpList.add(localObject1);
        localObject2 = "http://";
        break label119;
      }
      label565:
      this.mNetReq = localHttpNetReq;
      setMtype();
      this.mNetEngine.sendReq(localHttpNetReq);
      return;
      label587:
      localObject2 = "http://";
    }
  }
  
  private void sendReqest()
  {
    this.mStepUrl.logStartTime();
    RichProto.RichProtoReq.MultiMsgDownReq localMultiMsgDownReq = new RichProto.RichProtoReq.MultiMsgDownReq();
    localMultiMsgDownReq.selfUin = this.mUiRequest.mSelfUin;
    localMultiMsgDownReq.peerUin = this.mUiRequest.mPeerUin;
    localMultiMsgDownReq.secondUin = this.mUiRequest.mSecondId;
    localMultiMsgDownReq.uinType = this.mUiRequest.mUinType;
    localMultiMsgDownReq.msgResId = this.mMsgResId;
    localMultiMsgDownReq.multiMsgType = this.mUiRequest.multiMsgType;
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "multi_msg_dw";
    localRichProtoReq.reqs.add(localMultiMsgDownReq);
    localRichProtoReq.protoReqMgr = this.app.getProtoReqManager();
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("requestStart", localRichProtoReq.toString());
      }
    } while (!canDoNextStep());
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  public int checkParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    return 0;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) {}
    while ((this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return;
    }
    int j = this.mReportedFlag;
    int i;
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      String str = this.mStepUrl.getReportInfo(1) + ";" + this.mStepTrans.getReportInfo(2) + ";" + this.mStepMsg.getReportInfo(3);
      this.mReportInfo.put("param_step", str);
      this.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      this.mReportInfo.put("param_uuid", this.mUiRequest.mServerPath);
      if (!paramBoolean) {
        break label235;
      }
      reportForIpv6(true, l);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l, this.mTotolLen, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      return;
      i = 1;
      break;
      label235:
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      reportForIpv6(false, l);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l, 0L, this.mReportInfo, "");
    }
  }
  
  protected String getReportTAG()
  {
    return "actMultiMsgDownload";
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp == null) {
      onError();
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.MultiMsgDownResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result != 0) {
          break label127;
        }
        this.mIpList = selectIpList(paramRichProtoReq.mIpv6List, paramRichProtoReq.ipList);
        this.mUrlPath = paramRichProtoReq.urlParam;
        this.mMsgKey = paramRichProtoReq.msgkey;
        this.mChannelType = paramRichProtoReq.mChannelType;
        recieveFile();
        i += 1;
      }
    }
    label127:
    onError();
  }
  
  void onError()
  {
    super.onError();
    if (this.mUiRequest.mDownCallBack != null)
    {
      azjk localazjk = new azjk();
      localazjk.b = -1;
      localazjk.jdField_a_of_type_Azkb = new azkb();
      localazjk.jdField_a_of_type_Azkb.b = "[MultiMsgDownloadProcessor] download failed";
      localazjk.jdField_a_of_type_ArrayOfByte = null;
      this.mUiRequest.mDownCallBack.a(localazjk);
    }
    this.mContent = null;
    sendMessageToUpdate(2005);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool2 = true;
    Object localObject = this.mStepTrans;
    if (paramNetResp.mResult == 0)
    {
      bool1 = true;
      copyStatisInfoFromNetResp((BaseTransProcessor.StepInfo)localObject, paramNetResp, bool1);
      localObject = new StringBuilder().append(" result:");
      if (paramNetResp.mResult != 0) {
        break label154;
      }
    }
    label154:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      logRichMediaEvent("onHttpResp", bool1);
      this.mTotolLen = paramNetResp.mTotalFileLen;
      this.mNetReq = null;
      if (this.mTotolLen <= 0L) {
        this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
      }
      this.file.stepTrans.respHeader = ((String)paramNetResp.mRespProperties.get("param_rspHeader"));
      if ((paramNetResp.mResult != 0) || (!parseDownloadMsg(this.mOutFilePath))) {
        break label159;
      }
      onSuccess();
      return;
      bool1 = false;
      break;
    }
    label159:
    if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
    {
      logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
      this.mNetworkChgRetryCount += 1;
      clearReprotInfo();
      sendReqest();
      return;
    }
    onError();
  }
  
  void onSuccess()
  {
    super.onSuccess();
    Object localObject1;
    if (this.mUiRequest.mDownCallBack != null)
    {
      localObject1 = new azjk();
      ((azjk)localObject1).b = 0;
      ((azjk)localObject1).jdField_a_of_type_ArrayOfByte = this.mContent;
      ((azjk)localObject1).jdField_c_of_type_JavaLangString = this.mUiRequest.mMd5;
      ((azjk)localObject1).jdField_c_of_type_Int = this.mUiRequest.mFileType;
      ((azjk)localObject1).jdField_d_of_type_Int = this.mUiRequest.mDownMode;
      ((azjk)localObject1).jdField_d_of_type_JavaLangString = this.mUiRequest.mRichTag;
      ((azjk)localObject1).jdField_a_of_type_Long = this.mUiRequest.mUniseq;
      ((azjk)localObject1).e = this.mUiRequest.resIdStr;
      this.mUiRequest.mDownCallBack.a((azjk)localObject1);
    }
    for (;;)
    {
      this.mContent = null;
      sendMessageToUpdate(2003);
      return;
      localObject1 = new HashMap();
      Object localObject2 = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      localObject2 = this.app.getProxyManager().a().a(this.mContent, (HashMap)localObject1, (MessageRecord)localObject2, null);
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        axio.a().a((HashMap)localObject1, this.mUiRequest.mUniseq, this.app);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "BaseTransProcessoronSuccess.onDownload,MultiMsg ");
        }
      }
    }
  }
  
  protected void setMtype()
  {
    String str;
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq)))
    {
      if (!acnh.d(this.mUinType)) {
        break label56;
      }
      str = "multimsgCd";
    }
    for (;;)
    {
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.mNetReq).mReqUrl);
      return;
      label56:
      if (this.mUinType == 1) {
        str = "multimsgGd";
      } else {
        str = "multimsgDd";
      }
    }
  }
  
  public void start()
  {
    sendMessageToUpdate(1000);
    sendMessageToUpdate(2001);
    sendReqest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.MultiMsgDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */