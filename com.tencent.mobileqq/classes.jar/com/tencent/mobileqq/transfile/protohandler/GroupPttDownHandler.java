package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetPttUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;

public class GroupPttDownHandler
  extends BaseHandler
{
  public static final String TAG = "Q.richmedia.GroupPttDownHandler";
  
  private void handleError(FromServiceMsg paramFromServiceMsg, RichProto.RichProtoResp paramRichProtoResp, StatictisInfo paramStatictisInfo)
  {
    int i = paramFromServiceMsg.getResultCode();
    if ((i != 1002) && (i != 1013))
    {
      str = BaseMessageHandler.a(paramFromServiceMsg);
      paramFromServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
      if (paramFromServiceMsg == null) {
        paramFromServiceMsg = "";
      }
      setResult(-1, 9044, str, paramFromServiceMsg, paramStatictisInfo, paramRichProtoResp.resps);
      return;
    }
    String str = BaseMessageHandler.a(paramFromServiceMsg);
    paramFromServiceMsg = paramFromServiceMsg.getBusinessFailMsg();
    if (paramFromServiceMsg == null) {
      paramFromServiceMsg = "";
    }
    setResult(-1, 9311, str, paramFromServiceMsg, paramStatictisInfo, paramRichProtoResp.resps);
  }
  
  /* Error */
  private boolean handleSuccess(ProtoReqManagerImpl.ProtoReq paramProtoReq, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, StatictisInfo paramStatictisInfo)
  {
    // Byte code:
    //   0: new 49	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   3: dup
    //   4: invokespecial 50	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   7: astore 10
    //   9: aload 10
    //   11: aload_3
    //   12: invokevirtual 54	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15: checkcast 49	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   18: getfield 58	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_getptt_url_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   21: invokevirtual 64	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   24: astore 10
    //   26: aload 10
    //   28: ifnull +723 -> 751
    //   31: aload 10
    //   33: invokeinterface 69 1 0
    //   38: ifeq +713 -> 751
    //   41: aload 10
    //   43: invokeinterface 73 1 0
    //   48: astore 12
    //   50: aload 12
    //   52: invokeinterface 79 1 0
    //   57: ifeq +779 -> 836
    //   60: aload 12
    //   62: invokeinterface 83 1 0
    //   67: checkcast 85	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp
    //   70: astore 13
    //   72: aload 5
    //   74: getfield 39	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   77: aload 13
    //   79: getfield 89	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:uint64_file_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   82: invokevirtual 94	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   85: l2i
    //   86: invokeinterface 97 2 0
    //   91: checkcast 99	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp
    //   94: astore 11
    //   96: aload 11
    //   98: ifnull +568 -> 666
    //   101: aload 11
    //   103: aload_2
    //   104: ldc 101
    //   106: iconst_0
    //   107: invokestatic 107	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   110: invokevirtual 111	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   113: checkcast 103	java/lang/Boolean
    //   116: invokevirtual 114	java/lang/Boolean:booleanValue	()Z
    //   119: putfield 118	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:isSendByQuickHttp	Z
    //   122: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: istore 9
    //   127: iload 9
    //   129: ifeq +45 -> 174
    //   132: new 125	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   139: astore 10
    //   141: aload 10
    //   143: ldc 128
    //   145: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload 10
    //   151: aload 11
    //   153: getfield 118	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:isSendByQuickHttp	Z
    //   156: invokevirtual 135	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: ldc 137
    //   162: iconst_2
    //   163: aload 10
    //   165: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: goto +3 -> 174
    //   174: aload 11
    //   176: ifnull +28 -> 204
    //   179: aload 13
    //   181: getfield 148	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:uint32_transfer_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   184: invokevirtual 152	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   187: iconst_1
    //   188: if_icmpne +655 -> 843
    //   191: iconst_1
    //   192: istore 9
    //   194: goto +3 -> 197
    //   197: aload 11
    //   199: iload 9
    //   201: putfield 155	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:mIsHttps	Z
    //   204: aload 13
    //   206: getfield 158	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   209: invokevirtual 152	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   212: istore 7
    //   214: iload 7
    //   216: ifne +323 -> 539
    //   219: aload 11
    //   221: aload 13
    //   223: getfield 162	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:bytes_down_para	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   226: invokevirtual 167	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   229: invokevirtual 172	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   232: putfield 175	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:urlPath	Ljava/lang/String;
    //   235: aload 13
    //   237: getfield 179	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_ip	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   240: invokevirtual 182	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   243: astore 10
    //   245: aload 13
    //   247: getfield 185	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_uint32_down_port	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   250: invokevirtual 182	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   253: astore 14
    //   255: iconst_0
    //   256: istore 7
    //   258: aload 10
    //   260: invokeinterface 69 1 0
    //   265: istore 8
    //   267: iload 7
    //   269: iload 8
    //   271: if_icmpge +81 -> 352
    //   274: new 187	com/tencent/mobileqq/transfile/ServerAddr
    //   277: dup
    //   278: invokespecial 188	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   281: astore 15
    //   283: aload 15
    //   285: aload 10
    //   287: iload 7
    //   289: invokeinterface 97 2 0
    //   294: checkcast 190	java/lang/Integer
    //   297: invokevirtual 193	java/lang/Integer:intValue	()I
    //   300: i2l
    //   301: ldc2_w 194
    //   304: land
    //   305: invokestatic 201	com/tencent/mobileqq/utils/httputils/PkgTools:int2IPNet	(J)Ljava/lang/String;
    //   308: putfield 204	com/tencent/mobileqq/transfile/ServerAddr:mIp	Ljava/lang/String;
    //   311: aload 15
    //   313: aload 14
    //   315: iload 7
    //   317: invokeinterface 97 2 0
    //   322: checkcast 190	java/lang/Integer
    //   325: invokevirtual 193	java/lang/Integer:intValue	()I
    //   328: putfield 208	com/tencent/mobileqq/transfile/ServerAddr:port	I
    //   331: aload 11
    //   333: getfield 212	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:mIpList	Ljava/util/ArrayList;
    //   336: iload 7
    //   338: aload 15
    //   340: invokevirtual 218	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   343: iload 7
    //   345: iconst_1
    //   346: iadd
    //   347: istore 7
    //   349: goto -91 -> 258
    //   352: aload 13
    //   354: getfield 221	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_msg_down_ip6	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   357: invokevirtual 224	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   360: istore 9
    //   362: iload 9
    //   364: ifeq +130 -> 494
    //   367: aload 13
    //   369: getfield 221	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_msg_down_ip6	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   372: invokevirtual 225	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   375: ifle +119 -> 494
    //   378: aload 13
    //   380: getfield 221	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_msg_down_ip6	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   383: invokevirtual 64	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   386: astore 10
    //   388: iconst_0
    //   389: istore 7
    //   391: iload 7
    //   393: aload 10
    //   395: invokeinterface 69 1 0
    //   400: if_icmpge +94 -> 494
    //   403: new 187	com/tencent/mobileqq/transfile/ServerAddr
    //   406: dup
    //   407: invokespecial 188	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   410: astore 14
    //   412: aload 14
    //   414: aload 10
    //   416: iload 7
    //   418: invokeinterface 97 2 0
    //   423: checkcast 227	tencent/im/cs/cmd0x388/cmd0x388$IPv6Info
    //   426: getfield 230	tencent/im/cs/cmd0x388/cmd0x388$IPv6Info:bytes_ip6	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   429: invokevirtual 167	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   432: invokevirtual 234	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   435: invokestatic 240	java/net/Inet6Address:getByAddress	([B)Ljava/net/InetAddress;
    //   438: invokevirtual 245	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   441: putfield 204	com/tencent/mobileqq/transfile/ServerAddr:mIp	Ljava/lang/String;
    //   444: aload 14
    //   446: aload 10
    //   448: iload 7
    //   450: invokeinterface 97 2 0
    //   455: checkcast 227	tencent/im/cs/cmd0x388/cmd0x388$IPv6Info
    //   458: getfield 248	tencent/im/cs/cmd0x388/cmd0x388$IPv6Info:uint32_port	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: invokevirtual 152	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   464: putfield 208	com/tencent/mobileqq/transfile/ServerAddr:port	I
    //   467: aload 14
    //   469: iconst_1
    //   470: putfield 251	com/tencent/mobileqq/transfile/ServerAddr:isIpv6	Z
    //   473: aload 11
    //   475: getfield 254	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:mIpv6List	Ljava/util/ArrayList;
    //   478: iload 7
    //   480: aload 14
    //   482: invokevirtual 218	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   485: iload 7
    //   487: iconst_1
    //   488: iadd
    //   489: istore 7
    //   491: goto -100 -> 391
    //   494: aload 13
    //   496: getfield 258	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_str_domain	Lcom/tencent/mobileqq/pb/PBStringField;
    //   499: invokevirtual 261	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   502: istore 9
    //   504: iload 9
    //   506: ifeq +16 -> 522
    //   509: aload 11
    //   511: aload 13
    //   513: getfield 258	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:rpt_str_domain	Lcom/tencent/mobileqq/pb/PBStringField;
    //   516: invokevirtual 263	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   519: putfield 266	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:domainV4V6	Ljava/lang/String;
    //   522: aload_0
    //   523: iconst_0
    //   524: iconst_0
    //   525: ldc 33
    //   527: ldc 33
    //   529: aload 6
    //   531: aload 11
    //   533: invokevirtual 269	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   536: goto +130 -> 666
    //   539: aload 11
    //   541: astore 10
    //   543: aload 13
    //   545: getfield 272	tencent/im/cs/cmd0x388/cmd0x388$GetPttUrlRsp:uint32_allow_retry	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   548: invokevirtual 152	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   551: iconst_1
    //   552: if_icmpne +24 -> 576
    //   555: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +12 -> 570
    //   561: ldc 8
    //   563: iconst_2
    //   564: ldc_w 274
    //   567: invokestatic 277	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 10
    //   572: iconst_0
    //   573: putfield 280	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttDownResp:isAllowRetry	Z
    //   576: aload_0
    //   577: iload 7
    //   579: invokevirtual 284	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:shouldRetryByRetCodeForGroup	(I)Z
    //   582: istore 9
    //   584: iload 9
    //   586: ifeq +42 -> 628
    //   589: aload_0
    //   590: aload_0
    //   591: getfield 287	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:mReqUrlCount	I
    //   594: iconst_1
    //   595: iadd
    //   596: putfield 287	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:mReqUrlCount	I
    //   599: aload_0
    //   600: getfield 287	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:mReqUrlCount	I
    //   603: istore 8
    //   605: iload 8
    //   607: iconst_2
    //   608: if_icmpge +20 -> 628
    //   611: aload 4
    //   613: getfield 293	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:protoReqMgr	Lcom/tencent/mobileqq/transfile/api/IProtoReqManager;
    //   616: astore 10
    //   618: aload 10
    //   620: aload_1
    //   621: invokeinterface 299 2 0
    //   626: iconst_1
    //   627: ireturn
    //   628: aload_0
    //   629: iconst_m1
    //   630: sipush -9527
    //   633: iload 7
    //   635: i2l
    //   636: invokestatic 304	com/tencent/mobileqq/transfile/report/ProcessorReport:getUrlReason	(J)Ljava/lang/String;
    //   639: ldc 33
    //   641: aload 6
    //   643: aload 10
    //   645: invokevirtual 269	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   648: goto -598 -> 50
    //   651: astore 10
    //   653: goto +5 -> 658
    //   656: astore 10
    //   658: goto +16 -> 674
    //   661: astore 10
    //   663: goto +11 -> 674
    //   666: goto -616 -> 50
    //   669: astore 10
    //   671: aconst_null
    //   672: astore 11
    //   674: aload 11
    //   676: ifnull -626 -> 50
    //   679: ldc_w 306
    //   682: ldc2_w 307
    //   685: invokestatic 312	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   688: astore 13
    //   690: new 125	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   697: astore 14
    //   699: aload 14
    //   701: aload 10
    //   703: invokevirtual 315	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   706: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 14
    //   712: ldc_w 317
    //   715: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload 14
    //   721: aload_3
    //   722: invokestatic 323	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   725: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload_0
    //   730: iconst_m1
    //   731: sipush -9527
    //   734: aload 13
    //   736: aload 14
    //   738: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: aload 6
    //   743: aload 11
    //   745: invokevirtual 269	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   748: goto -698 -> 50
    //   751: new 47	java/lang/Exception
    //   754: dup
    //   755: ldc_w 325
    //   758: invokespecial 328	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   761: athrow
    //   762: astore_1
    //   763: goto +4 -> 767
    //   766: astore_1
    //   767: ldc_w 306
    //   770: ldc2_w 307
    //   773: invokestatic 312	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   776: astore_2
    //   777: new 125	java/lang/StringBuilder
    //   780: dup
    //   781: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   784: astore 4
    //   786: aload 4
    //   788: aload_1
    //   789: invokevirtual 315	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   792: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload 4
    //   798: ldc_w 317
    //   801: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload 4
    //   807: aload_3
    //   808: invokestatic 323	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   811: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload_0
    //   816: iconst_m1
    //   817: sipush -9527
    //   820: aload_2
    //   821: aload 4
    //   823: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: aload 6
    //   828: aload 5
    //   830: getfield 39	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   833: invokevirtual 43	com/tencent/mobileqq/transfile/protohandler/GroupPttDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   836: iconst_0
    //   837: ireturn
    //   838: astore 10
    //   840: goto -166 -> 674
    //   843: iconst_0
    //   844: istore 9
    //   846: goto -649 -> 197
    //   849: astore 10
    //   851: goto -11 -> 840
    //   854: astore 10
    //   856: goto -198 -> 658
    //   859: astore 10
    //   861: goto -203 -> 658
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	864	0	this	GroupPttDownHandler
    //   0	864	1	paramProtoReq	ProtoReqManagerImpl.ProtoReq
    //   0	864	2	paramFromServiceMsg	FromServiceMsg
    //   0	864	3	paramArrayOfByte	byte[]
    //   0	864	4	paramRichProtoReq	RichProto.RichProtoReq
    //   0	864	5	paramRichProtoResp	RichProto.RichProtoResp
    //   0	864	6	paramStatictisInfo	StatictisInfo
    //   212	422	7	i	int
    //   265	344	8	j	int
    //   125	720	9	bool	boolean
    //   7	637	10	localObject1	Object
    //   651	1	10	localException1	java.lang.Exception
    //   656	1	10	localException2	java.lang.Exception
    //   661	1	10	localException3	java.lang.Exception
    //   669	33	10	localException4	java.lang.Exception
    //   838	1	10	localException5	java.lang.Exception
    //   849	1	10	localException6	java.lang.Exception
    //   854	1	10	localException7	java.lang.Exception
    //   859	1	10	localException8	java.lang.Exception
    //   94	650	11	localGroupPttDownResp	RichProto.RichProtoResp.GroupPttDownResp
    //   48	13	12	localIterator	java.util.Iterator
    //   70	665	13	localObject2	Object
    //   253	484	14	localObject3	Object
    //   281	58	15	localServerAddr	com.tencent.mobileqq.transfile.ServerAddr
    // Exception table:
    //   from	to	target	type
    //   618	626	651	java/lang/Exception
    //   628	648	651	java/lang/Exception
    //   522	536	656	java/lang/Exception
    //   543	570	656	java/lang/Exception
    //   570	576	656	java/lang/Exception
    //   576	584	656	java/lang/Exception
    //   101	127	661	java/lang/Exception
    //   204	214	661	java/lang/Exception
    //   72	96	669	java/lang/Exception
    //   9	26	762	java/lang/Exception
    //   31	50	762	java/lang/Exception
    //   50	72	762	java/lang/Exception
    //   679	748	762	java/lang/Exception
    //   751	762	762	java/lang/Exception
    //   0	9	766	java/lang/Exception
    //   132	171	838	java/lang/Exception
    //   179	191	838	java/lang/Exception
    //   197	204	838	java/lang/Exception
    //   274	343	838	java/lang/Exception
    //   367	388	838	java/lang/Exception
    //   391	485	838	java/lang/Exception
    //   509	522	838	java/lang/Exception
    //   219	255	849	java/lang/Exception
    //   258	267	849	java/lang/Exception
    //   352	362	849	java/lang/Exception
    //   494	504	849	java/lang/Exception
    //   611	618	854	java/lang/Exception
    //   589	605	859	java/lang/Exception
  }
  
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.GroupPttDownReq)paramReqCommon;
    cmd0x388.GetPttUrlReq localGetPttUrlReq = new cmd0x388.GetPttUrlReq();
    localGetPttUrlReq.setHasFlag(true);
    localGetPttUrlReq.uint64_file_id.set(paramInt);
    localGetPttUrlReq.uint64_dst_uin.set(Long.valueOf(paramReqCommon.selfUin).longValue());
    localGetPttUrlReq.uint64_group_code.set(Long.parseLong(paramReqCommon.peerUin));
    localGetPttUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.md5));
    if (paramReqCommon.groupFileID != 0L) {
      localGetPttUrlReq.uint64_fileid.set(paramReqCommon.groupFileID);
    }
    localGetPttUrlReq.uint32_req_platform_type.set(9);
    localGetPttUrlReq.uint32_req_term.set(5);
    localGetPttUrlReq.uint32_inner_ip.set(0);
    Object localObject = localGetPttUrlReq.uint32_bu_type;
    if (paramReqCommon.uinType == 1) {
      paramInt = 3;
    } else {
      paramInt = 4;
    }
    ((PBUInt32Field)localObject).set(paramInt);
    localGetPttUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    localGetPttUrlReq.uint32_codec.set(paramReqCommon.voiceType);
    if (paramReqCommon.groupFileKey != null) {}
    try
    {
      localObject = paramReqCommon.groupFileKey.getBytes("utf-8");
      localGetPttUrlReq.bytes_file_key.set(ByteStringMicro.copyFrom((byte[])localObject));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label216:
      break label216;
    }
    localGetPttUrlReq.uint32_is_auto.set(paramReqCommon.downType);
    localGetPttUrlReq.uint32_req_transfer_type.set(2);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("constructReqBody GroupPttDownReq = ");
      ((StringBuilder)localObject).append(paramReqCommon.toString());
      QLog.d("Q.richmedia.GroupPttDownHandler", 2, ((StringBuilder)localObject).toString());
    }
    paramReqBody.rpt_msg_getptt_url_req.add(localGetPttUrlReq);
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(4);
    int i = 0;
    while (i < paramList.size())
    {
      addOne(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), localReqBody);
      i += 1;
    }
    int j = NetworkCenter.getInstance().getNetType();
    i = 3;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j == 3) {
          break label101;
        }
        if (j == 4) {}
      }
      else
      {
        i = 6;
        break label104;
      }
      i = 8;
      break label104;
      label101:
      i = 7;
    }
    label104:
    paramList = NetworkCenter.getInstance().getApnType();
    j = i;
    if (paramList != null)
    {
      j = i;
      if (paramList.contains("wap")) {
        j = 5;
      }
    }
    localReqBody.uint32_net_type.set(j);
    return localReqBody.toByteArray();
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.GroupPttDownResp localGroupPttDownResp = new RichProto.RichProtoResp.GroupPttDownResp();
      localRichProtoResp.resps.add(i, localGroupPttDownResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.resp;
    if (localFromServiceMsg == null) {
      return;
    }
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    paramProtoResp = paramProtoResp.statisInfo;
    if (localFromServiceMsg.getResultCode() != 1000) {
      handleError(localFromServiceMsg, localRichProtoResp, paramProtoResp);
    } else if (handleSuccess(paramProtoReq, localFromServiceMsg, arrayOfByte, localRichProtoReq, localRichProtoResp, paramProtoResp)) {
      return;
    }
    RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "PttStore.GroupPttDown";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPttDownHandler
 * JD-Core Version:    0.7.0.1
 */