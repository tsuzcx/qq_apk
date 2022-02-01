package com.tencent.mobileqq.transfile;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.MultiMsgDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.MultiMsgDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MultiMsgDownloadProcessor
  extends BaseDownloadProcessor
{
  QQAppInterface app = (QQAppInterface)this.app;
  private int mChannelType;
  private byte[] mContent;
  private byte[] mMsgKey;
  private byte[] mMsgResId = this.mUiRequest.resIdStr.getBytes();
  private String mOutFilePath;
  private int mUinType = this.mUiRequest.mUinType;
  
  public MultiMsgDownloadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
  }
  
  /* Error */
  private boolean parseDownloadMsg(String paramString)
  {
    // Byte code:
    //   0: new 58	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 65	java/io/File:exists	()Z
    //   11: ifne +40 -> 51
    //   14: new 67	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   21: astore 5
    //   23: aload 5
    //   25: ldc 72
    //   27: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 5
    //   33: aload_1
    //   34: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_0
    //   39: ldc 77
    //   41: aload 5
    //   43: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: iconst_0
    //   50: ireturn
    //   51: aconst_null
    //   52: astore 7
    //   54: aconst_null
    //   55: astore 6
    //   57: new 87	java/io/RandomAccessFile
    //   60: dup
    //   61: aload_1
    //   62: ldc 89
    //   64: invokespecial 91	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: astore 5
    //   69: aload 5
    //   71: astore 6
    //   73: aload 5
    //   75: invokevirtual 95	java/io/RandomAccessFile:length	()J
    //   78: l2i
    //   79: newarray byte
    //   81: astore 7
    //   83: aload 5
    //   85: astore 6
    //   87: aload 5
    //   89: aload 7
    //   91: invokevirtual 99	java/io/RandomAccessFile:read	([B)I
    //   94: istore_2
    //   95: aload 5
    //   97: invokevirtual 102	java/io/RandomAccessFile:close	()V
    //   100: goto +8 -> 108
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   108: aload 7
    //   110: arraylength
    //   111: ifle +730 -> 841
    //   114: iload_2
    //   115: ifgt +6 -> 121
    //   118: goto +723 -> 841
    //   121: aload 7
    //   123: arraylength
    //   124: istore_2
    //   125: aload 7
    //   127: iconst_0
    //   128: baload
    //   129: bipush 40
    //   131: if_icmpne +612 -> 743
    //   134: aload 7
    //   136: iload_2
    //   137: iconst_1
    //   138: isub
    //   139: baload
    //   140: bipush 41
    //   142: if_icmpeq +6 -> 148
    //   145: goto +598 -> 743
    //   148: new 107	java/io/DataInputStream
    //   151: dup
    //   152: new 109	java/io/ByteArrayInputStream
    //   155: dup
    //   156: aload 7
    //   158: invokespecial 112	java/io/ByteArrayInputStream:<init>	([B)V
    //   161: invokespecial 115	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   164: astore 5
    //   166: aload 5
    //   168: invokevirtual 119	java/io/DataInputStream:readByte	()B
    //   171: pop
    //   172: aload 5
    //   174: invokevirtual 123	java/io/DataInputStream:readInt	()I
    //   177: istore 4
    //   179: aload 5
    //   181: invokevirtual 123	java/io/DataInputStream:readInt	()I
    //   184: istore_3
    //   185: iload 4
    //   187: iload_2
    //   188: if_icmpgt +463 -> 651
    //   191: iload_3
    //   192: iload_2
    //   193: if_icmple +6 -> 199
    //   196: goto +455 -> 651
    //   199: iload 4
    //   201: ifle +820 -> 1021
    //   204: iload 4
    //   206: newarray byte
    //   208: astore_1
    //   209: aload 5
    //   211: aload_1
    //   212: invokevirtual 124	java/io/DataInputStream:read	([B)I
    //   215: pop
    //   216: new 126	tencent/im/msg/im_msg_head$Head
    //   219: dup
    //   220: invokespecial 127	tencent/im/msg/im_msg_head$Head:<init>	()V
    //   223: astore 6
    //   225: aload 6
    //   227: aload_1
    //   228: invokevirtual 131	tencent/im/msg/im_msg_head$Head:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   231: pop
    //   232: aload 6
    //   234: getfield 135	tencent/im/msg/im_msg_head$Head:msg_httpconn_head	Ltencent/im/msg/im_msg_head$HttpConnHead;
    //   237: invokevirtual 141	tencent/im/msg/im_msg_head$HttpConnHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   240: checkcast 137	tencent/im/msg/im_msg_head$HttpConnHead
    //   243: getfield 145	tencent/im/msg/im_msg_head$HttpConnHead:uint32_error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   246: invokevirtual 149	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   249: istore_2
    //   250: goto +773 -> 1023
    //   253: iload_3
    //   254: newarray byte
    //   256: astore_1
    //   257: aload 5
    //   259: aload_1
    //   260: invokevirtual 124	java/io/DataInputStream:read	([B)I
    //   263: pop
    //   264: new 151	com/tencent/qphone/base/util/Cryptor
    //   267: dup
    //   268: invokespecial 152	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   271: aload_1
    //   272: aload_0
    //   273: getfield 154	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mMsgKey	[B
    //   276: invokevirtual 158	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   279: astore 5
    //   281: aload 5
    //   283: ifnull +312 -> 595
    //   286: aload 5
    //   288: arraylength
    //   289: ifgt +6 -> 295
    //   292: goto +303 -> 595
    //   295: new 160	tencent/im/longconn/longmsg/LongMsg$RspBody
    //   298: dup
    //   299: invokespecial 161	tencent/im/longconn/longmsg/LongMsg$RspBody:<init>	()V
    //   302: astore 6
    //   304: aload 6
    //   306: aload 5
    //   308: invokevirtual 162	tencent/im/longconn/longmsg/LongMsg$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   311: pop
    //   312: aload 6
    //   314: getfield 166	tencent/im/longconn/longmsg/LongMsg$RspBody:rpt_msg_down_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   317: iconst_0
    //   318: invokevirtual 171	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   321: checkcast 173	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp
    //   324: astore 5
    //   326: aload 5
    //   328: ifnonnull +13 -> 341
    //   331: aload_0
    //   332: ldc 77
    //   334: ldc 175
    //   336: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: iconst_0
    //   340: ireturn
    //   341: aload 5
    //   343: getfield 178	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   346: invokevirtual 181	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   349: ifne +13 -> 362
    //   352: aload_0
    //   353: ldc 77
    //   355: ldc 183
    //   357: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: iconst_0
    //   361: ireturn
    //   362: aload 5
    //   364: getfield 178	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   367: invokevirtual 149	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   370: ifeq +13 -> 383
    //   373: aload_0
    //   374: ldc 77
    //   376: ldc 185
    //   378: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   381: iconst_0
    //   382: ireturn
    //   383: aload 5
    //   385: getfield 189	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:bytes_msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   388: invokevirtual 192	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   391: ifne +13 -> 404
    //   394: aload_0
    //   395: ldc 77
    //   397: ldc 194
    //   399: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: iconst_0
    //   403: ireturn
    //   404: aload_0
    //   405: aload 5
    //   407: getfield 189	tencent/im/longconn/longmsg/LongMsg$MsgDownRsp:bytes_msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   410: invokevirtual 197	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   413: invokevirtual 202	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   416: putfield 204	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mContent	[B
    //   419: aload_0
    //   420: getfield 204	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mContent	[B
    //   423: ifnull +162 -> 585
    //   426: aload_0
    //   427: getfield 204	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mContent	[B
    //   430: arraylength
    //   431: ifgt +6 -> 437
    //   434: goto +151 -> 585
    //   437: new 67	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   444: astore 5
    //   446: aload 5
    //   448: ldc 206
    //   450: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload 5
    //   456: aload_1
    //   457: invokestatic 212	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   460: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload_0
    //   465: ldc 77
    //   467: aload 5
    //   469: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   475: new 67	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   482: astore 5
    //   484: aload 5
    //   486: ldc 214
    //   488: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 5
    //   494: aload_1
    //   495: arraylength
    //   496: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload_0
    //   501: ldc 77
    //   503: aload 5
    //   505: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: new 67	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   518: astore_1
    //   519: aload_1
    //   520: ldc 219
    //   522: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: aload_1
    //   527: aload_0
    //   528: getfield 204	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mContent	[B
    //   531: invokestatic 212	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   534: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload_0
    //   539: ldc 77
    //   541: aload_1
    //   542: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: new 67	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   555: astore_1
    //   556: aload_1
    //   557: ldc 221
    //   559: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload_1
    //   564: aload_0
    //   565: getfield 204	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:mContent	[B
    //   568: arraylength
    //   569: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload_0
    //   574: ldc 77
    //   576: aload_1
    //   577: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   583: iconst_1
    //   584: ireturn
    //   585: aload_0
    //   586: ldc 77
    //   588: ldc 223
    //   590: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   593: iconst_0
    //   594: ireturn
    //   595: aload_0
    //   596: ldc 77
    //   598: ldc 225
    //   600: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: iconst_0
    //   604: ireturn
    //   605: new 67	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   612: astore_1
    //   613: aload_1
    //   614: ldc 227
    //   616: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload_1
    //   621: iload_3
    //   622: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload_1
    //   627: ldc 229
    //   629: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload_1
    //   634: iload_2
    //   635: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: aload_0
    //   640: ldc 77
    //   642: aload_1
    //   643: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   649: iconst_0
    //   650: ireturn
    //   651: new 67	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   658: astore_1
    //   659: aload_1
    //   660: ldc 231
    //   662: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload_1
    //   667: iload 4
    //   669: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   672: pop
    //   673: aload_1
    //   674: ldc 233
    //   676: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: pop
    //   680: aload_1
    //   681: iload_3
    //   682: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload_0
    //   687: ldc 77
    //   689: aload_1
    //   690: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: iconst_0
    //   697: ireturn
    //   698: astore_1
    //   699: aload_1
    //   700: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   703: new 67	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   710: astore 5
    //   712: aload 5
    //   714: ldc 236
    //   716: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload 5
    //   722: aload_1
    //   723: invokevirtual 239	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   726: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload_0
    //   731: ldc 77
    //   733: aload 5
    //   735: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: iconst_0
    //   742: ireturn
    //   743: new 67	java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   750: astore_1
    //   751: aload_1
    //   752: ldc 241
    //   754: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: pop
    //   758: aload_1
    //   759: iload_2
    //   760: invokevirtual 217	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   763: pop
    //   764: aload_1
    //   765: ldc 243
    //   767: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload_1
    //   772: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: astore_1
    //   776: aload 7
    //   778: invokevirtual 246	java/lang/Object:toString	()Ljava/lang/String;
    //   781: astore 5
    //   783: new 67	java/lang/StringBuilder
    //   786: dup
    //   787: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   790: astore 6
    //   792: aload 6
    //   794: aload_1
    //   795: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload 5
    //   801: astore_1
    //   802: aload 5
    //   804: invokevirtual 248	java/lang/String:length	()I
    //   807: bipush 20
    //   809: if_icmple +12 -> 821
    //   812: aload 5
    //   814: iconst_0
    //   815: bipush 20
    //   817: invokevirtual 252	java/lang/String:substring	(II)Ljava/lang/String;
    //   820: astore_1
    //   821: aload 6
    //   823: aload_1
    //   824: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: pop
    //   828: aload_0
    //   829: ldc 77
    //   831: aload 6
    //   833: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   839: iconst_0
    //   840: ireturn
    //   841: aload_0
    //   842: ldc 77
    //   844: ldc 254
    //   846: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   849: iconst_0
    //   850: ireturn
    //   851: astore 6
    //   853: aload 5
    //   855: astore_1
    //   856: aload 6
    //   858: astore 5
    //   860: goto +17 -> 877
    //   863: astore 7
    //   865: goto +54 -> 919
    //   868: astore_1
    //   869: goto +130 -> 999
    //   872: astore 5
    //   874: aload 7
    //   876: astore_1
    //   877: aload_1
    //   878: astore 6
    //   880: aload_0
    //   881: ldc 77
    //   883: ldc_w 256
    //   886: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   889: aload_1
    //   890: astore 6
    //   892: aload 5
    //   894: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   897: aload_1
    //   898: ifnull +14 -> 912
    //   901: aload_1
    //   902: invokevirtual 102	java/io/RandomAccessFile:close	()V
    //   905: iconst_0
    //   906: ireturn
    //   907: astore_1
    //   908: aload_1
    //   909: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   912: iconst_0
    //   913: ireturn
    //   914: astore 7
    //   916: aconst_null
    //   917: astore 5
    //   919: aload 5
    //   921: astore 6
    //   923: aload 7
    //   925: invokevirtual 257	java/io/FileNotFoundException:printStackTrace	()V
    //   928: aload 5
    //   930: astore 6
    //   932: new 67	java/lang/StringBuilder
    //   935: dup
    //   936: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   939: astore 7
    //   941: aload 5
    //   943: astore 6
    //   945: aload 7
    //   947: ldc 72
    //   949: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: pop
    //   953: aload 5
    //   955: astore 6
    //   957: aload 7
    //   959: aload_1
    //   960: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: aload 5
    //   966: astore 6
    //   968: aload_0
    //   969: ldc 77
    //   971: aload 7
    //   973: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokevirtual 85	com/tencent/mobileqq/transfile/MultiMsgDownloadProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   979: aload 5
    //   981: ifnull +15 -> 996
    //   984: aload 5
    //   986: invokevirtual 102	java/io/RandomAccessFile:close	()V
    //   989: iconst_0
    //   990: ireturn
    //   991: astore_1
    //   992: aload_1
    //   993: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   996: iconst_0
    //   997: ireturn
    //   998: astore_1
    //   999: aload 6
    //   1001: ifnull +18 -> 1019
    //   1004: aload 6
    //   1006: invokevirtual 102	java/io/RandomAccessFile:close	()V
    //   1009: goto +10 -> 1019
    //   1012: astore 5
    //   1014: aload 5
    //   1016: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   1019: aload_1
    //   1020: athrow
    //   1021: iconst_0
    //   1022: istore_2
    //   1023: iload_3
    //   1024: ifle -419 -> 605
    //   1027: iload_2
    //   1028: ifeq -775 -> 253
    //   1031: goto -426 -> 605
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1034	0	this	MultiMsgDownloadProcessor
    //   0	1034	1	paramString	String
    //   94	934	2	i	int
    //   184	840	3	j	int
    //   177	491	4	k	int
    //   21	838	5	localObject1	Object
    //   872	21	5	localIOException1	java.io.IOException
    //   917	68	5	localObject2	Object
    //   1012	3	5	localIOException2	java.io.IOException
    //   55	777	6	localObject3	Object
    //   851	6	6	localIOException3	java.io.IOException
    //   878	127	6	localObject4	Object
    //   52	725	7	arrayOfByte	byte[]
    //   863	12	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   914	10	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   939	33	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   95	100	103	java/io/IOException
    //   148	185	698	java/lang/Exception
    //   204	250	698	java/lang/Exception
    //   253	281	698	java/lang/Exception
    //   286	292	698	java/lang/Exception
    //   295	326	698	java/lang/Exception
    //   331	339	698	java/lang/Exception
    //   341	360	698	java/lang/Exception
    //   362	381	698	java/lang/Exception
    //   383	402	698	java/lang/Exception
    //   404	434	698	java/lang/Exception
    //   437	583	698	java/lang/Exception
    //   585	593	698	java/lang/Exception
    //   595	603	698	java/lang/Exception
    //   605	649	698	java/lang/Exception
    //   651	696	698	java/lang/Exception
    //   73	83	851	java/io/IOException
    //   87	95	851	java/io/IOException
    //   73	83	863	java/io/FileNotFoundException
    //   87	95	863	java/io/FileNotFoundException
    //   57	69	868	finally
    //   880	889	868	finally
    //   892	897	868	finally
    //   57	69	872	java/io/IOException
    //   901	905	907	java/io/IOException
    //   57	69	914	java/io/FileNotFoundException
    //   984	989	991	java/io/IOException
    //   73	83	998	finally
    //   87	95	998	finally
    //   923	928	998	finally
    //   932	941	998	finally
    //   945	953	998	finally
    //   957	964	998	finally
    //   968	979	998	finally
    //   1004	1009	1012	java/io/IOException
  }
  
  private void recieveFile()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    if (this.mIpList.size() > 0)
    {
      localObject1 = (ServerAddr)this.mIpList.get(0);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("MultiMsg_TAG", 2, "Multimsg download recieveFile  ipListSize = 0 ");
      }
      localObject1 = null;
    }
    int i = this.mChannelType;
    String str = "http://";
    if (i == 2)
    {
      localHttpNetReq.mIsHttps = true;
      if (localObject1 != null)
      {
        localHttpNetReq.mIsHostIP = true;
        if (((ServerAddr)localObject1).isIpv6) {
          localHttpNetReq.mHostForHttpsVerify = "sslv6.htdata.qq.com";
        } else {
          localHttpNetReq.mHostForHttpsVerify = "ssl.htdata.qq.com";
        }
      }
      else
      {
        localHttpNetReq.mHostForHttpsVerify = "sslv6.htdata.qq.com";
      }
      localObject3 = new ServerAddr();
      ((ServerAddr)localObject3).mIp = localHttpNetReq.mHostForHttpsVerify;
      ((ServerAddr)localObject3).port = 443;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = localObject3;
      }
      this.mIpList.add(localObject3);
      localObject3 = "https://";
    }
    else
    {
      localObject2 = localObject1;
      localObject3 = str;
      if (localObject1 == null)
      {
        localObject2 = new ServerAddr();
        ((ServerAddr)localObject2).mIp = "sslv6.htdata.qq.com";
        ((ServerAddr)localObject2).port = 8080;
        this.mIpList.add(localObject2);
        localObject3 = str;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Multimsg download recieveFile  url =");
      ((StringBuilder)localObject1).append((String)localObject3);
      QLog.i("MultiMsg_TAG", 2, ((StringBuilder)localObject1).toString());
    }
    if ((((ServerAddr)localObject2).isIpv6) && (!((ServerAddr)localObject2).mIp.startsWith("[")))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(((ServerAddr)localObject2).mIp);
      ((StringBuilder)localObject1).append("]");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append(((ServerAddr)localObject2).mIp);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject3 = localObject1;
    if (((ServerAddr)localObject2).port != 80)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append(((ServerAddr)localObject2).port);
      localObject3 = ((StringBuilder)localObject3).toString();
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject3);
    ((StringBuilder)localObject1).append(this.mUrlPath);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" url:");
    ((StringBuilder)localObject2).append((String)localObject1);
    logRichMediaEvent("MultimsgDownload.recieveFile", ((StringBuilder)localObject2).toString());
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
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("url:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(",downOffset:");
    ((StringBuilder)localObject2).append(localHttpNetReq.mStartDownOffset);
    logRichMediaEvent("httpDown", ((StringBuilder)localObject2).toString());
    if (!canDoNextStep()) {
      return;
    }
    this.mNetReq = localHttpNetReq;
    setMtype();
    this.mNetEngine.sendReq(localHttpNetReq);
  }
  
  private void sendReqest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
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
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    if (QLog.isColorLevel()) {
      logRichMediaEvent("requestStart", localRichProtoReq.toString());
    }
    if (!canDoNextStep()) {
      return;
    }
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
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return;
    }
    if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0)))
    {
      if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
        return;
      }
      Object localObject = this.mProcessorReport;
      int j = this.mProcessorReport.mReportedFlag;
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      ((ProcessorReport)localObject).mReportedFlag = (j | i);
      long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mProcessorReport.mStepUrl.getReportInfo(1));
      ((StringBuilder)localObject).append(";");
      ((StringBuilder)localObject).append(this.mProcessorReport.mStepTrans.getReportInfo(2));
      ((StringBuilder)localObject).append(";");
      ((StringBuilder)localObject).append(this.mProcessorReport.mStepMsg.getReportInfo(3));
      localObject = ((StringBuilder)localObject).toString();
      this.mProcessorReport.mReportInfo.put("param_step", localObject);
      this.mProcessorReport.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      this.mProcessorReport.mReportInfo.put("param_uuid", this.mUiRequest.mServerPath);
      if (paramBoolean)
      {
        reportForIpv6(true, l);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l, this.mTotolLen, this.mProcessorReport.mReportInfo, "");
      }
      else
      {
        if (this.mProcessorReport.errCode != -9527) {
          this.mProcessorReport.mReportInfo.remove("param_rspHeader");
        }
        this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
        reportForIpv6(false, l);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l, 0L, this.mProcessorReport.mReportInfo, "");
      }
      setReportFlag();
    }
  }
  
  protected String getReportTAG()
  {
    return "actMultiMsgDownload";
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp == null)
    {
      onError();
      return;
    }
    int i = 0;
    while (i < paramRichProtoResp.resps.size())
    {
      paramRichProtoReq = (RichProto.RichProtoResp.MultiMsgDownResp)paramRichProtoResp.resps.get(i);
      if (QLog.isColorLevel()) {
        logRichMediaEvent("procUrl", paramRichProtoReq.toString());
      }
      this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
      if (paramRichProtoReq.result == 0)
      {
        this.mIpList = selectIpList(paramRichProtoReq.mIpv6List, paramRichProtoReq.ipList);
        this.mUrlPath = paramRichProtoReq.urlParam;
        this.mMsgKey = paramRichProtoReq.msgkey;
        this.mChannelType = paramRichProtoReq.mChannelType;
        recieveFile();
        i += 1;
      }
      else
      {
        onError();
      }
    }
  }
  
  void onError()
  {
    super.onError();
    if (this.mUiRequest.mDownCallBack != null)
    {
      DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
      localDownResult.b = -1;
      localDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = new PicInfoInterface.ErrInfo();
      localDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b = "[MultiMsgDownloadProcessor] download failed";
      localDownResult.jdField_a_of_type_ArrayOfByte = null;
      this.mUiRequest.mDownCallBack.a(localDownResult);
    }
    this.mContent = null;
    sendMessageToUpdate(2005);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = this.mProcessorReport;
    StepInfo localStepInfo = this.mProcessorReport.mStepTrans;
    int i = paramNetResp.mResult;
    boolean bool2 = false;
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((ProcessorReport)localObject).copyStaticsInfoFromNetResp(localStepInfo, paramNetResp, bool1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" result:");
    boolean bool1 = bool2;
    if (paramNetResp.mResult == 0) {
      bool1 = true;
    }
    ((StringBuilder)localObject).append(bool1);
    logRichMediaEvent("onHttpResp", ((StringBuilder)localObject).toString());
    this.mTotolLen = paramNetResp.mTotalFileLen;
    this.mNetReq = null;
    if (this.mTotolLen <= 0L) {
      this.mTotolLen = (paramNetResp.mTotalBlockLen + paramNetResp.mReq.mStartDownOffset);
    }
    this.file.stepTrans.respHeader = ((String)paramNetResp.mRespProperties.get("param_rspHeader"));
    if ((paramNetResp.mResult == 0) && (parseDownloadMsg(this.mOutFilePath)))
    {
      onSuccess();
      return;
    }
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
      localObject1 = new DownCallBack.DownResult();
      ((DownCallBack.DownResult)localObject1).b = 0;
      ((DownCallBack.DownResult)localObject1).jdField_a_of_type_ArrayOfByte = this.mContent;
      ((DownCallBack.DownResult)localObject1).jdField_c_of_type_JavaLangString = this.mUiRequest.mMd5;
      ((DownCallBack.DownResult)localObject1).jdField_c_of_type_Int = this.mUiRequest.mFileType;
      ((DownCallBack.DownResult)localObject1).jdField_d_of_type_Int = this.mUiRequest.mDownMode;
      ((DownCallBack.DownResult)localObject1).jdField_d_of_type_JavaLangString = this.mUiRequest.mRichTag;
      ((DownCallBack.DownResult)localObject1).jdField_a_of_type_Long = this.mUiRequest.mUniseq;
      ((DownCallBack.DownResult)localObject1).e = this.mUiRequest.resIdStr;
      this.mUiRequest.mDownCallBack.a((DownCallBack.DownResult)localObject1);
    }
    else
    {
      localObject1 = new HashMap();
      Object localObject2 = this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      localObject2 = this.app.getProxyManager().a().a(this.mContent, (HashMap)localObject1, (MessageRecord)localObject2, null);
      if ((localObject2 != null) && (((HashMap)localObject2).size() > 0))
      {
        MultiMsgManager.a().a((HashMap)localObject1, this.mUiRequest.mUniseq, this.app);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "BaseTransProcessoronSuccess.onDownload,MultiMsg ");
        }
      }
    }
    this.mContent = null;
    sendMessageToUpdate(2003);
  }
  
  protected void setMtype()
  {
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq)))
    {
      String str;
      if (UinTypeUtil.b(this.mUinType)) {
        str = "multimsgCd";
      } else if (this.mUinType == 1) {
        str = "multimsgGd";
      } else {
        str = "multimsgDd";
      }
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype(str, ((HttpNetReq)this.mNetReq).mReqUrl);
    }
  }
  
  public void start()
  {
    sendMessageToUpdate(1000);
    sendMessageToUpdate(2001);
    sendReqest();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.MultiMsgDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */