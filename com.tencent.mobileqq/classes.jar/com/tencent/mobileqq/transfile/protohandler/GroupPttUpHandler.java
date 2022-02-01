package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttReq;

public class GroupPttUpHandler
  extends BaseHandler
{
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.PttUpReq)paramReqCommon;
    cmd0x388.TryUpPttReq localTryUpPttReq = new cmd0x388.TryUpPttReq();
    localTryUpPttReq.setHasFlag(true);
    localTryUpPttReq.uint64_src_uin.set(Long.valueOf(paramReqCommon.selfUin).longValue());
    localTryUpPttReq.uint64_group_code.set(Long.valueOf(paramReqCommon.peerUin).longValue());
    localTryUpPttReq.uint64_file_id.set(paramInt);
    localTryUpPttReq.uint64_file_size.set(paramReqCommon.fileSize);
    localTryUpPttReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.md5));
    localTryUpPttReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramReqCommon.fileName));
    localTryUpPttReq.uint32_src_term.set(5);
    localTryUpPttReq.uint32_platform_type.set(9);
    Object localObject = localTryUpPttReq.uint32_bu_type;
    if (paramReqCommon.uinType == 1) {
      paramInt = 3;
    } else {
      paramInt = 4;
    }
    ((PBUInt32Field)localObject).set(paramInt);
    localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    localTryUpPttReq.uint32_voice_length.set(paramReqCommon.voiceLength);
    localTryUpPttReq.uint32_codec.set(paramReqCommon.voiceType);
    localTryUpPttReq.uint32_voice_type.set(paramReqCommon.audioPanelType);
    localTryUpPttReq.bool_new_up_chan.set(true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GroupPttUp: panel[");
      ((StringBuilder)localObject).append(paramReqCommon.audioPanelType);
      ((StringBuilder)localObject).append("] type[");
      ((StringBuilder)localObject).append(paramReqCommon.voiceType);
      ((StringBuilder)localObject).append("] length[");
      ((StringBuilder)localObject).append(paramReqCommon.voiceLength);
      ((StringBuilder)localObject).append("] size[");
      ((StringBuilder)localObject).append(paramReqCommon.fileSize);
      ((StringBuilder)localObject).append("]");
      QLog.d("RecordParams", 2, ((StringBuilder)localObject).toString());
    }
    paramReqBody.rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(3);
    int i = 0;
    while (i < paramList.size())
    {
      addOne(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), localReqBody);
      i += 1;
    }
    i = getHandlerNetType();
    localReqBody.uint32_net_type.set(i);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("GroupPttUp: net[");
      paramList.append(i);
      paramList.append("]");
      QLog.d("RecordParams", 2, paramList.toString());
    }
    return localReqBody.toByteArray();
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.GroupPttUpResp localGroupPttUpResp = new RichProto.RichProtoResp.GroupPttUpResp();
      localRichProtoResp.resps.add(i, localGroupPttUpResp);
      i += 1;
    }
  }
  
  /* Error */
  public void onProtoResp(com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    // Byte code:
    //   0: ldc_w 256
    //   3: astore 11
    //   5: ldc_w 258
    //   8: astore 18
    //   10: aload_1
    //   11: getfield 263	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:resp	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   14: astore 12
    //   16: aload_1
    //   17: getfield 263	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:resp	Lcom/tencent/qphone/base/remote/FromServiceMsg;
    //   20: invokevirtual 268	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   23: astore 10
    //   25: aload_2
    //   26: getfield 274	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoReq:busiData	Ljava/lang/Object;
    //   29: checkcast 228	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq
    //   32: astore 24
    //   34: aload 24
    //   36: getfield 232	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:resp	Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp;
    //   39: astore 25
    //   41: aload_1
    //   42: getfield 278	com/tencent/mobileqq/transfile/api/impl/ProtoReqManagerImpl$ProtoResp:statisInfo	Lcom/tencent/mobileqq/app/StatictisInfo;
    //   45: astore 13
    //   47: aload 12
    //   49: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   52: istore_3
    //   53: ldc_w 283
    //   56: astore 23
    //   58: iload_3
    //   59: sipush 1000
    //   62: if_icmpeq +112 -> 174
    //   65: aload 12
    //   67: invokevirtual 281	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   70: istore_3
    //   71: iload_3
    //   72: sipush 1002
    //   75: if_icmpeq +56 -> 131
    //   78: iload_3
    //   79: sipush 1013
    //   82: if_icmpne +6 -> 88
    //   85: goto +46 -> 131
    //   88: aload 12
    //   90: invokestatic 289	com/tencent/mobileqq/app/BaseMessageHandler:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/String;
    //   93: astore_2
    //   94: aload 12
    //   96: invokevirtual 292	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   99: astore_1
    //   100: aload_1
    //   101: ifnonnull +10 -> 111
    //   104: ldc_w 283
    //   107: astore_1
    //   108: goto +3 -> 111
    //   111: aload_0
    //   112: iconst_m1
    //   113: sipush 9044
    //   116: aload_2
    //   117: aload_1
    //   118: aload 13
    //   120: aload 25
    //   122: getfield 238	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   125: invokevirtual 296	com/tencent/mobileqq/transfile/protohandler/GroupPttUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   128: goto +1396 -> 1524
    //   131: aload 12
    //   133: invokestatic 289	com/tencent/mobileqq/app/BaseMessageHandler:a	(Lcom/tencent/qphone/base/remote/FromServiceMsg;)Ljava/lang/String;
    //   136: astore_2
    //   137: aload 12
    //   139: invokevirtual 292	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   142: astore_1
    //   143: aload_1
    //   144: ifnonnull +10 -> 154
    //   147: ldc_w 283
    //   150: astore_1
    //   151: goto +3 -> 154
    //   154: aload_0
    //   155: iconst_m1
    //   156: sipush 9311
    //   159: aload_2
    //   160: aload_1
    //   161: aload 13
    //   163: aload 25
    //   165: getfield 238	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   168: invokevirtual 296	com/tencent/mobileqq/transfile/protohandler/GroupPttUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   171: goto +1353 -> 1524
    //   174: aload 13
    //   176: astore 17
    //   178: aload 11
    //   180: astore 16
    //   182: aload 18
    //   184: astore 15
    //   186: aload 10
    //   188: astore 14
    //   190: new 298	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   193: dup
    //   194: invokespecial 299	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   197: aload 10
    //   199: invokevirtual 303	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   202: checkcast 298	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   205: getfield 306	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_tryup_ptt_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   208: invokevirtual 309	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   211: astore_1
    //   212: aload_1
    //   213: ifnull +1182 -> 1395
    //   216: aload 13
    //   218: astore 17
    //   220: aload 11
    //   222: astore 16
    //   224: aload 18
    //   226: astore 15
    //   228: aload 10
    //   230: astore 14
    //   232: aload_1
    //   233: invokeinterface 202 1 0
    //   238: ifeq +1157 -> 1395
    //   241: aload 13
    //   243: astore 17
    //   245: aload 11
    //   247: astore 16
    //   249: aload 18
    //   251: astore 15
    //   253: aload 10
    //   255: astore 14
    //   257: aload_1
    //   258: invokeinterface 313 1 0
    //   263: astore 26
    //   265: aload 10
    //   267: astore_1
    //   268: aload 18
    //   270: astore 10
    //   272: aload 13
    //   274: astore 17
    //   276: aload 11
    //   278: astore 16
    //   280: aload 10
    //   282: astore 15
    //   284: aload_1
    //   285: astore 14
    //   287: aload 26
    //   289: invokeinterface 318 1 0
    //   294: ifeq +1230 -> 1524
    //   297: aload 13
    //   299: astore 17
    //   301: aload 11
    //   303: astore 16
    //   305: aload 10
    //   307: astore 15
    //   309: aload_1
    //   310: astore 14
    //   312: aload 26
    //   314: invokeinterface 322 1 0
    //   319: checkcast 324	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp
    //   322: astore 27
    //   324: aload 25
    //   326: getfield 238	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   329: aload 27
    //   331: getfield 325	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:uint64_file_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   334: invokevirtual 327	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   337: l2i
    //   338: invokeinterface 206 2 0
    //   343: checkcast 246	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttUpResp
    //   346: astore 18
    //   348: aload 18
    //   350: aload 12
    //   352: ldc_w 329
    //   355: iconst_0
    //   356: invokestatic 334	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   359: invokevirtual 338	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   362: checkcast 331	java/lang/Boolean
    //   365: invokevirtual 341	java/lang/Boolean:booleanValue	()Z
    //   368: putfield 345	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttUpResp:isSendByQuickHttp	Z
    //   371: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: istore 5
    //   376: iload 5
    //   378: ifeq +76 -> 454
    //   381: new 150	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   388: astore 14
    //   390: aload 14
    //   392: ldc_w 347
    //   395: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: aload 14
    //   401: aload 18
    //   403: getfield 345	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttUpResp:isSendByQuickHttp	Z
    //   406: invokevirtual 350	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: ldc_w 352
    //   413: iconst_2
    //   414: aload 14
    //   416: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 355	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: goto +32 -> 454
    //   425: astore 15
    //   427: aload 11
    //   429: astore 16
    //   431: aload 10
    //   433: astore 17
    //   435: aload 12
    //   437: astore 11
    //   439: aload 18
    //   441: astore 14
    //   443: aload 16
    //   445: astore 10
    //   447: aload 17
    //   449: astore 12
    //   451: goto +841 -> 1292
    //   454: aload 27
    //   456: getfield 358	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   459: invokevirtual 360	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   462: istore_3
    //   463: iload_3
    //   464: ifne +586 -> 1050
    //   467: aload 18
    //   469: aload 27
    //   471: getfield 363	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:uint64_fileid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   474: invokevirtual 327	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   477: putfield 367	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttUpResp:groupFileID	J
    //   480: aload 27
    //   482: getfield 370	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:bytes_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   485: invokevirtual 373	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   488: istore 5
    //   490: iload 5
    //   492: ifeq +19 -> 511
    //   495: aload 18
    //   497: aload 27
    //   499: getfield 370	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:bytes_file_key	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   502: invokevirtual 376	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   505: invokevirtual 377	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   508: putfield 380	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttUpResp:groupFileKey	[B
    //   511: aload 27
    //   513: getfield 383	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:bool_file_exit	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   516: invokevirtual 384	com/tencent/mobileqq/pb/PBBoolField:has	()Z
    //   519: istore 5
    //   521: iload 5
    //   523: ifeq +38 -> 561
    //   526: aload 27
    //   528: getfield 383	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:bool_file_exit	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   531: invokevirtual 386	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   534: ifeq +27 -> 561
    //   537: aload 18
    //   539: iconst_1
    //   540: putfield 389	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttUpResp:isExist	Z
    //   543: aload_1
    //   544: astore 17
    //   546: aload 12
    //   548: astore 16
    //   550: aload 11
    //   552: astore 15
    //   554: aload 10
    //   556: astore 14
    //   558: goto +432 -> 990
    //   561: aload 27
    //   563: getfield 393	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:rpt_uint32_up_ip	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   566: invokevirtual 396	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   569: astore 28
    //   571: aload 27
    //   573: getfield 399	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:rpt_uint32_up_port	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   576: invokevirtual 396	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   579: astore 29
    //   581: aload 11
    //   583: astore 22
    //   585: aload 10
    //   587: astore 21
    //   589: aload 12
    //   591: astore 19
    //   593: aload_1
    //   594: astore 16
    //   596: aload 28
    //   598: ifnull +281 -> 879
    //   601: aload 11
    //   603: astore 20
    //   605: aload 10
    //   607: astore 17
    //   609: aload 12
    //   611: astore 15
    //   613: aload_1
    //   614: astore 14
    //   616: aload 11
    //   618: astore 22
    //   620: aload 10
    //   622: astore 21
    //   624: aload 12
    //   626: astore 19
    //   628: aload_1
    //   629: astore 16
    //   631: aload 28
    //   633: invokeinterface 202 1 0
    //   638: ifle +241 -> 879
    //   641: iconst_0
    //   642: istore_3
    //   643: aload 11
    //   645: astore 20
    //   647: aload 10
    //   649: astore 17
    //   651: aload 12
    //   653: astore 15
    //   655: aload_1
    //   656: astore 14
    //   658: aload 11
    //   660: astore 22
    //   662: aload 10
    //   664: astore 21
    //   666: aload 12
    //   668: astore 19
    //   670: aload_1
    //   671: astore 16
    //   673: iload_3
    //   674: aload 28
    //   676: invokeinterface 202 1 0
    //   681: if_icmpge +198 -> 879
    //   684: aload 11
    //   686: astore 20
    //   688: aload 10
    //   690: astore 17
    //   692: aload 12
    //   694: astore 15
    //   696: aload_1
    //   697: astore 14
    //   699: aload 28
    //   701: iload_3
    //   702: invokeinterface 206 2 0
    //   707: checkcast 401	java/lang/Integer
    //   710: invokevirtual 404	java/lang/Integer:intValue	()I
    //   713: istore 4
    //   715: aload_1
    //   716: astore 14
    //   718: iload 4
    //   720: i2l
    //   721: lstore 6
    //   723: aload 29
    //   725: iload_3
    //   726: invokeinterface 206 2 0
    //   731: checkcast 401	java/lang/Integer
    //   734: invokevirtual 404	java/lang/Integer:intValue	()I
    //   737: istore 4
    //   739: aload 10
    //   741: astore_1
    //   742: iload 4
    //   744: i2l
    //   745: lstore 8
    //   747: new 406	com/tencent/mobileqq/transfile/ServerAddr
    //   750: dup
    //   751: invokespecial 407	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   754: astore 10
    //   756: aload 10
    //   758: lload 6
    //   760: ldc2_w 408
    //   763: land
    //   764: invokestatic 415	com/tencent/mobileqq/utils/httputils/PkgTools:int2IPNet	(J)Ljava/lang/String;
    //   767: putfield 418	com/tencent/mobileqq/transfile/ServerAddr:mIp	Ljava/lang/String;
    //   770: aload 10
    //   772: lload 8
    //   774: l2i
    //   775: putfield 421	com/tencent/mobileqq/transfile/ServerAddr:port	I
    //   778: aload 18
    //   780: getfield 425	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttUpResp:ipList	Ljava/util/ArrayList;
    //   783: iload_3
    //   784: aload 10
    //   786: invokevirtual 428	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   789: iload_3
    //   790: iconst_1
    //   791: iadd
    //   792: istore_3
    //   793: aload_1
    //   794: astore 10
    //   796: aload 14
    //   798: astore_1
    //   799: goto -156 -> 643
    //   802: astore 15
    //   804: aload 14
    //   806: astore 17
    //   808: aload 12
    //   810: astore 16
    //   812: aload 11
    //   814: astore 10
    //   816: aload_1
    //   817: astore 12
    //   819: goto +46 -> 865
    //   822: astore 15
    //   824: aload 10
    //   826: astore_1
    //   827: aload 14
    //   829: astore 17
    //   831: aload 12
    //   833: astore 16
    //   835: aload 11
    //   837: astore 10
    //   839: aload_1
    //   840: astore 12
    //   842: goto +23 -> 865
    //   845: astore_1
    //   846: aload 20
    //   848: astore 10
    //   850: aload 17
    //   852: astore 12
    //   854: aload 15
    //   856: astore 16
    //   858: aload 14
    //   860: astore 17
    //   862: aload_1
    //   863: astore 15
    //   865: aload 18
    //   867: astore 14
    //   869: aload 17
    //   871: astore_1
    //   872: aload 16
    //   874: astore 11
    //   876: goto +416 -> 1292
    //   879: aload 22
    //   881: astore_1
    //   882: aload 21
    //   884: astore 10
    //   886: aload 19
    //   888: astore 12
    //   890: aload 16
    //   892: astore 11
    //   894: aload 27
    //   896: getfield 431	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:bytes_up_ukey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   899: invokevirtual 376	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   902: invokevirtual 377	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   905: invokestatic 437	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   908: astore 14
    //   910: aload 14
    //   912: ifnull +127 -> 1039
    //   915: aload 14
    //   917: aload 23
    //   919: invokevirtual 443	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   922: ifne +117 -> 1039
    //   925: aload 28
    //   927: ifnull +112 -> 1039
    //   930: aload 28
    //   932: invokeinterface 202 1 0
    //   937: ifeq +102 -> 1039
    //   940: aload 18
    //   942: aload 14
    //   944: putfield 446	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttUpResp:mUkey	Ljava/lang/String;
    //   947: aload 18
    //   949: aload 27
    //   951: getfield 449	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:uint64_block_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   954: invokevirtual 327	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   957: l2i
    //   958: putfield 452	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttUpResp:blockSize	I
    //   961: aload 18
    //   963: aload 27
    //   965: getfield 455	tencent/im/cs/cmd0x388/cmd0x388$TryUpPttRsp:uint64_up_offset	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   968: invokevirtual 327	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   971: l2i
    //   972: putfield 458	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPttUpResp:transferedSize	I
    //   975: aload 10
    //   977: astore 14
    //   979: aload_1
    //   980: astore 15
    //   982: aload 12
    //   984: astore 16
    //   986: aload 11
    //   988: astore 17
    //   990: aload 17
    //   992: astore 11
    //   994: aload 16
    //   996: astore 12
    //   998: aload 15
    //   1000: astore_1
    //   1001: aload 14
    //   1003: astore 10
    //   1005: aload_0
    //   1006: iconst_0
    //   1007: iconst_0
    //   1008: ldc_w 283
    //   1011: ldc_w 283
    //   1014: aload 13
    //   1016: aload 18
    //   1018: invokevirtual 461	com/tencent/mobileqq/transfile/protohandler/GroupPttUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   1021: aload 17
    //   1023: astore 10
    //   1025: aload 16
    //   1027: astore_1
    //   1028: aload 15
    //   1030: astore 11
    //   1032: aload 14
    //   1034: astore 17
    //   1036: goto +173 -> 1209
    //   1039: new 254	java/lang/Exception
    //   1042: dup
    //   1043: ldc_w 463
    //   1046: invokespecial 466	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1049: athrow
    //   1050: aload 11
    //   1052: astore 14
    //   1054: aload 10
    //   1056: astore 17
    //   1058: aload 12
    //   1060: astore 15
    //   1062: aload_1
    //   1063: astore 16
    //   1065: aload 16
    //   1067: astore 11
    //   1069: aload 15
    //   1071: astore 12
    //   1073: aload 14
    //   1075: astore_1
    //   1076: aload 17
    //   1078: astore 10
    //   1080: aload_0
    //   1081: iload_3
    //   1082: invokevirtual 470	com/tencent/mobileqq/transfile/protohandler/GroupPttUpHandler:shouldRetryByRetCodeForGroup	(I)Z
    //   1085: ifeq +78 -> 1163
    //   1088: aload 16
    //   1090: astore 11
    //   1092: aload 15
    //   1094: astore 12
    //   1096: aload 14
    //   1098: astore_1
    //   1099: aload 17
    //   1101: astore 10
    //   1103: aload_0
    //   1104: aload_0
    //   1105: getfield 473	com/tencent/mobileqq/transfile/protohandler/GroupPttUpHandler:mReqUrlCount	I
    //   1108: iconst_1
    //   1109: iadd
    //   1110: putfield 473	com/tencent/mobileqq/transfile/protohandler/GroupPttUpHandler:mReqUrlCount	I
    //   1113: aload 16
    //   1115: astore 11
    //   1117: aload 15
    //   1119: astore 12
    //   1121: aload 14
    //   1123: astore_1
    //   1124: aload 17
    //   1126: astore 10
    //   1128: aload_0
    //   1129: getfield 473	com/tencent/mobileqq/transfile/protohandler/GroupPttUpHandler:mReqUrlCount	I
    //   1132: iconst_2
    //   1133: if_icmpge +30 -> 1163
    //   1136: aload 16
    //   1138: astore 11
    //   1140: aload 15
    //   1142: astore 12
    //   1144: aload 14
    //   1146: astore_1
    //   1147: aload 17
    //   1149: astore 10
    //   1151: aload 24
    //   1153: getfield 477	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:protoReqMgr	Lcom/tencent/mobileqq/transfile/api/IProtoReqManager;
    //   1156: aload_2
    //   1157: invokeinterface 483 2 0
    //   1162: return
    //   1163: aload 16
    //   1165: astore 11
    //   1167: aload 15
    //   1169: astore 12
    //   1171: aload 14
    //   1173: astore_1
    //   1174: aload 17
    //   1176: astore 10
    //   1178: aload_0
    //   1179: iconst_m1
    //   1180: sipush -9527
    //   1183: iload_3
    //   1184: i2l
    //   1185: invokestatic 488	com/tencent/mobileqq/transfile/report/ProcessorReport:getUrlReason	(J)Ljava/lang/String;
    //   1188: ldc_w 283
    //   1191: aload 13
    //   1193: aload 18
    //   1195: invokevirtual 461	com/tencent/mobileqq/transfile/protohandler/GroupPttUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   1198: aload 14
    //   1200: astore 11
    //   1202: aload 15
    //   1204: astore_1
    //   1205: aload 16
    //   1207: astore 10
    //   1209: aload 17
    //   1211: astore 12
    //   1213: aload 11
    //   1215: astore 19
    //   1217: goto +327 -> 1544
    //   1220: astore 15
    //   1222: aload_1
    //   1223: astore 16
    //   1225: aload 10
    //   1227: astore 17
    //   1229: goto +16 -> 1245
    //   1232: astore 15
    //   1234: aload 10
    //   1236: astore 17
    //   1238: aload 11
    //   1240: astore 16
    //   1242: aload_1
    //   1243: astore 11
    //   1245: aload 18
    //   1247: astore 14
    //   1249: aload 11
    //   1251: astore_1
    //   1252: aload 12
    //   1254: astore 11
    //   1256: aload 16
    //   1258: astore 10
    //   1260: aload 17
    //   1262: astore 12
    //   1264: goto +28 -> 1292
    //   1267: astore 15
    //   1269: aload 12
    //   1271: astore 14
    //   1273: aconst_null
    //   1274: astore 16
    //   1276: aload 10
    //   1278: astore 12
    //   1280: aload 11
    //   1282: astore 10
    //   1284: aload 14
    //   1286: astore 11
    //   1288: aload 16
    //   1290: astore 14
    //   1292: aload 13
    //   1294: astore 16
    //   1296: aload 12
    //   1298: ldc2_w 489
    //   1301: invokestatic 494	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   1304: astore 20
    //   1306: new 150	java/lang/StringBuilder
    //   1309: dup
    //   1310: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   1313: astore 17
    //   1315: aload 17
    //   1317: aload 15
    //   1319: invokevirtual 497	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1322: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: aload 17
    //   1328: aload 10
    //   1330: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: pop
    //   1334: aload 17
    //   1336: aload_1
    //   1337: invokestatic 437	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1340: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: aload 17
    //   1346: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1349: astore 21
    //   1351: aload 10
    //   1353: astore 19
    //   1355: aload 12
    //   1357: astore 10
    //   1359: aload 16
    //   1361: astore 15
    //   1363: aload_1
    //   1364: astore 17
    //   1366: aload 19
    //   1368: astore 18
    //   1370: aload_0
    //   1371: iconst_m1
    //   1372: sipush -9527
    //   1375: aload 20
    //   1377: aload 21
    //   1379: aload 16
    //   1381: aload 14
    //   1383: invokevirtual 461	com/tencent/mobileqq/transfile/protohandler/GroupPttUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   1386: aload_1
    //   1387: astore 10
    //   1389: aload 11
    //   1391: astore_1
    //   1392: goto +152 -> 1544
    //   1395: ldc_w 256
    //   1398: astore 18
    //   1400: ldc_w 258
    //   1403: astore_1
    //   1404: aload 10
    //   1406: astore 17
    //   1408: aload_1
    //   1409: astore 10
    //   1411: aload 13
    //   1413: astore 15
    //   1415: new 254	java/lang/Exception
    //   1418: dup
    //   1419: ldc_w 499
    //   1422: invokespecial 466	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1425: athrow
    //   1426: astore_2
    //   1427: aload 18
    //   1429: astore_1
    //   1430: goto +25 -> 1455
    //   1433: astore 11
    //   1435: aload 17
    //   1437: astore_2
    //   1438: aload 16
    //   1440: astore_1
    //   1441: aload 15
    //   1443: astore 10
    //   1445: aload 14
    //   1447: astore 17
    //   1449: aload_2
    //   1450: astore 15
    //   1452: aload 11
    //   1454: astore_2
    //   1455: aload 10
    //   1457: ldc2_w 489
    //   1460: invokestatic 494	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   1463: astore 10
    //   1465: new 150	java/lang/StringBuilder
    //   1468: dup
    //   1469: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   1472: astore 11
    //   1474: aload 11
    //   1476: aload_2
    //   1477: invokevirtual 497	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1480: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: pop
    //   1484: aload 11
    //   1486: aload_1
    //   1487: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1490: pop
    //   1491: aload 11
    //   1493: aload 17
    //   1495: invokestatic 437	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   1498: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1501: pop
    //   1502: aload_0
    //   1503: iconst_m1
    //   1504: sipush -9527
    //   1507: aload 10
    //   1509: aload 11
    //   1511: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1514: aload 15
    //   1516: aload 25
    //   1518: getfield 238	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   1521: invokevirtual 296	com/tencent/mobileqq/transfile/protohandler/GroupPttUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   1524: aload 24
    //   1526: aload 25
    //   1528: invokestatic 505	com/tencent/mobileqq/transfile/protohandler/RichProtoProc:onBusiProtoResp	(Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp;)V
    //   1531: return
    //   1532: astore 15
    //   1534: aload_1
    //   1535: astore 16
    //   1537: aload 10
    //   1539: astore 17
    //   1541: goto -296 -> 1245
    //   1544: aload 10
    //   1546: astore 14
    //   1548: aload 19
    //   1550: astore 11
    //   1552: aload 12
    //   1554: astore 10
    //   1556: aload_1
    //   1557: astore 12
    //   1559: aload 14
    //   1561: astore_1
    //   1562: goto -1290 -> 272
    //   1565: astore_2
    //   1566: aload 10
    //   1568: astore 11
    //   1570: aload 12
    //   1572: astore 10
    //   1574: aload 16
    //   1576: astore 15
    //   1578: aload_1
    //   1579: astore 17
    //   1581: aload 11
    //   1583: astore_1
    //   1584: goto -129 -> 1455
    //   1587: astore_2
    //   1588: aload 10
    //   1590: astore 11
    //   1592: aload 12
    //   1594: astore 10
    //   1596: aload 16
    //   1598: astore 15
    //   1600: aload_1
    //   1601: astore 17
    //   1603: aload 11
    //   1605: astore_1
    //   1606: goto -151 -> 1455
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1609	0	this	GroupPttUpHandler
    //   0	1609	1	paramProtoResp	com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp
    //   0	1609	2	paramProtoReq	ProtoReqManagerImpl.ProtoReq
    //   52	1132	3	i	int
    //   713	30	4	j	int
    //   374	148	5	bool	boolean
    //   721	38	6	l1	long
    //   745	28	8	l2	long
    //   23	1572	10	localObject1	Object
    //   3	1387	11	localObject2	Object
    //   1433	20	11	localException1	java.lang.Exception
    //   1472	132	11	localObject3	Object
    //   14	1579	12	localObject4	Object
    //   45	1367	13	localStatictisInfo	com.tencent.mobileqq.app.StatictisInfo
    //   188	1372	14	localObject5	Object
    //   184	124	15	localObject6	Object
    //   425	1	15	localException2	java.lang.Exception
    //   552	143	15	localObject7	Object
    //   802	1	15	localException3	java.lang.Exception
    //   822	33	15	localException4	java.lang.Exception
    //   863	340	15	localObject8	Object
    //   1220	1	15	localException5	java.lang.Exception
    //   1232	1	15	localException6	java.lang.Exception
    //   1267	51	15	localException7	java.lang.Exception
    //   1361	154	15	localObject9	Object
    //   1532	1	15	localException8	java.lang.Exception
    //   1576	23	15	localObject10	Object
    //   180	1417	16	localObject11	Object
    //   176	1426	17	localObject12	Object
    //   8	1420	18	localObject13	Object
    //   591	958	19	localObject14	Object
    //   603	773	20	localObject15	Object
    //   587	791	21	localObject16	Object
    //   583	297	22	localObject17	Object
    //   56	862	23	str	java.lang.String
    //   32	1493	24	localRichProtoReq	RichProto.RichProtoReq
    //   39	1488	25	localRichProtoResp	RichProto.RichProtoResp
    //   263	50	26	localIterator	java.util.Iterator
    //   322	642	27	localTryUpPttRsp	tencent.im.cs.cmd0x388.cmd0x388.TryUpPttRsp
    //   569	362	28	localList1	List
    //   579	145	29	localList2	List
    // Exception table:
    //   from	to	target	type
    //   381	422	425	java/lang/Exception
    //   495	511	425	java/lang/Exception
    //   526	543	425	java/lang/Exception
    //   747	789	802	java/lang/Exception
    //   723	739	822	java/lang/Exception
    //   631	641	845	java/lang/Exception
    //   673	684	845	java/lang/Exception
    //   699	715	845	java/lang/Exception
    //   1005	1021	1220	java/lang/Exception
    //   1039	1050	1220	java/lang/Exception
    //   1080	1088	1220	java/lang/Exception
    //   1103	1113	1220	java/lang/Exception
    //   1128	1136	1220	java/lang/Exception
    //   1151	1162	1220	java/lang/Exception
    //   1178	1198	1220	java/lang/Exception
    //   348	376	1232	java/lang/Exception
    //   454	463	1232	java/lang/Exception
    //   467	490	1232	java/lang/Exception
    //   511	521	1232	java/lang/Exception
    //   561	581	1232	java/lang/Exception
    //   324	348	1267	java/lang/Exception
    //   1370	1386	1426	java/lang/Exception
    //   1415	1426	1426	java/lang/Exception
    //   190	212	1433	java/lang/Exception
    //   232	241	1433	java/lang/Exception
    //   257	265	1433	java/lang/Exception
    //   287	297	1433	java/lang/Exception
    //   312	324	1433	java/lang/Exception
    //   894	910	1532	java/lang/Exception
    //   915	925	1532	java/lang/Exception
    //   930	975	1532	java/lang/Exception
    //   1326	1351	1565	java/lang/Exception
    //   1296	1326	1587	java/lang/Exception
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "PttStore.GroupPttUp";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPttUpHandler
 * JD-Core Version:    0.7.0.1
 */