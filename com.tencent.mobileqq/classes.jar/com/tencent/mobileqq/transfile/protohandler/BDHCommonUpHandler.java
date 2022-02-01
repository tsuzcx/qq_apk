package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgRsp;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpInfo4Busi;

public class BDHCommonUpHandler
  extends BaseHandler
{
  int mReqNetType;
  
  private void handleBusSuc(RichProto.RichProtoResp.BDHCommonUpResp paramBDHCommonUpResp, cmd0x388.TryUpImgRsp paramTryUpImgRsp)
  {
    if (paramTryUpImgRsp.msg_info4busi.has())
    {
      localObject1 = (cmd0x388.TryUpInfo4Busi)paramTryUpImgRsp.msg_info4busi.get();
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_down_domain.has()) {
        paramBDHCommonUpResp.downDomain = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_down_domain.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_big_down_url.has()) {
        paramBDHCommonUpResp.bigDownUrl = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_big_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_original_down_url.has()) {
        paramBDHCommonUpResp.orgiDownUrl = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_original_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_thumb_down_url.has()) {
        paramBDHCommonUpResp.thumbDownUrl = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_thumb_down_url.get().toStringUtf8();
      }
      if (((cmd0x388.TryUpInfo4Busi)localObject1).bytes_file_resid.has()) {
        paramBDHCommonUpResp.resid = ((cmd0x388.TryUpInfo4Busi)localObject1).bytes_file_resid.get().toStringUtf8();
      }
    }
    paramBDHCommonUpResp.groupFileID = paramTryUpImgRsp.uint64_fileid.get();
    Object localObject1 = paramTryUpImgRsp.rpt_uint32_up_ip.get();
    Object localObject2 = paramTryUpImgRsp.rpt_uint32_up_port.get();
    boolean bool = false;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        long l1 = ((Integer)((List)localObject1).get(i)).intValue();
        long l2 = ((Integer)((List)localObject2).get(i)).intValue();
        ServerAddr localServerAddr = new ServerAddr();
        localServerAddr.mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
        localServerAddr.port = ((int)l2);
        paramBDHCommonUpResp.mIpList.add(i, localServerAddr);
        i += 1;
      }
    }
    if ((paramTryUpImgRsp.bool_file_exit.has()) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      paramBDHCommonUpResp.isExist = true;
      return;
    }
    localObject2 = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
    if ((localObject2 != null) && (!((String)localObject2).equals("")) && (localObject1 != null) && (((List)localObject1).size() != 0))
    {
      paramBDHCommonUpResp.mUkey = ((String)localObject2);
      paramBDHCommonUpResp.blockSize = ((int)paramTryUpImgRsp.uint64_block_size.get());
      paramBDHCommonUpResp.transferedSize = ((int)paramTryUpImgRsp.uint64_up_offset.get());
      if (NetworkCenter.getInstance().getNetType() != this.mReqNetType) {
        bool = true;
      }
      paramBDHCommonUpResp.networkChange = bool;
      paramBDHCommonUpResp.startOffset = paramTryUpImgRsp.uint64_up_offset.get();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" Channel:");
        ((StringBuilder)localObject1).append(paramTryUpImgRsp.bool_new_big_chan.get());
        QLog.d("BDH_LOG", 2, ((StringBuilder)localObject1).toString());
      }
      if ((paramTryUpImgRsp.bool_new_big_chan.has()) && (paramTryUpImgRsp.bool_new_big_chan.get() == true)) {
        paramBDHCommonUpResp.isUseBdh = true;
      }
      return;
    }
    paramBDHCommonUpResp = new Exception("check ukey,iplist");
    for (;;)
    {
      throw paramBDHCommonUpResp;
    }
  }
  
  public static boolean shouldRetryByRetCode(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 194) && (paramInt != 197) && (paramInt != 199) && (paramInt != 200) && (paramInt != 201) && (paramInt != 203) && (paramInt != 202) && (paramInt != 120509) && (paramInt != 400010) && (paramInt != 400011);
  }
  
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.PicUpReq)paramReqCommon;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(paramReqCommon.selfUin).longValue());
    localTryUpImgReq.uint64_group_code.set(Long.valueOf(paramReqCommon.peerUin).longValue());
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(paramReqCommon.fileSize);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.md5));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramReqCommon.fileName));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(paramReqCommon.width);
    localTryUpImgReq.uint32_pic_height.set(paramReqCommon.height);
    localTryUpImgReq.uint32_pic_type.set(paramReqCommon.picType);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (paramReqCommon.uinType == 1) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    localPBUInt32Field.set(paramInt);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    if (paramReqCommon.isRaw) {
      localTryUpImgReq.uint32_original_pic.set(1);
    }
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  byte[] constructReqBody(RichProto.RichProtoReq paramRichProtoReq)
  {
    if (paramRichProtoReq == null) {
      return null;
    }
    List localList = paramRichProtoReq.reqs;
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    localReqBody.uint32_command_id.set(paramRichProtoReq.commandId);
    if (paramRichProtoReq.extention != null) {
      localReqBody.bytes_extension.set(ByteStringMicro.copyFrom(paramRichProtoReq.extention));
    }
    int i = 0;
    while (i < localList.size())
    {
      addOne(i, (RichProto.RichProtoReq.ReqCommon)localList.get(i), localReqBody);
      i += 1;
    }
    int j = NetworkCenter.getInstance().getNetType();
    this.mReqNetType = j;
    i = 3;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j == 3) {
          break label154;
        }
        if (j == 4) {}
      }
      else
      {
        i = 6;
        break label157;
      }
      i = 8;
      break label157;
      label154:
      i = 7;
    }
    label157:
    paramRichProtoReq = NetworkCenter.getInstance().getApnType();
    j = i;
    if (paramRichProtoReq != null)
    {
      j = i;
      if (paramRichProtoReq.contains("wap")) {
        j = 5;
      }
    }
    localReqBody.uint32_net_type.set(j);
    return localReqBody.toByteArray();
  }
  
  /* Error */
  protected void handleSucResp(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, com.tencent.mobileqq.app.StatictisInfo paramStatictisInfo, ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    // Byte code:
    //   0: new 427	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   3: dup
    //   4: invokespecial 428	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_2
    //   12: invokevirtual 432	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15: checkcast 427	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   18: getfield 435	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_tryup_img_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   21: invokevirtual 436	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +327 -> 355
    //   31: aload 6
    //   33: invokeinterface 106 1 0
    //   38: ifeq +317 -> 355
    //   41: aload 6
    //   43: invokeinterface 440 1 0
    //   48: astore 12
    //   50: aload 12
    //   52: invokeinterface 445 1 0
    //   57: ifeq +383 -> 440
    //   60: aload 12
    //   62: invokeinterface 449 1 0
    //   67: checkcast 15	tencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp
    //   70: astore 6
    //   72: aload 4
    //   74: getfield 454	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   77: aload 6
    //   79: getfield 455	tencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp:uint64_file_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   82: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   85: l2i
    //   86: invokeinterface 109 2 0
    //   91: checkcast 47	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$BDHCommonUpResp
    //   94: astore 11
    //   96: aload 11
    //   98: ifnonnull +6 -> 104
    //   101: goto -51 -> 50
    //   104: aload_1
    //   105: invokevirtual 461	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   108: ldc_w 463
    //   111: invokevirtual 468	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   114: istore 10
    //   116: iload 10
    //   118: ifeq +37 -> 155
    //   121: aload 11
    //   123: aload_1
    //   124: ldc_w 463
    //   127: iconst_0
    //   128: invokestatic 473	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   131: invokevirtual 477	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 470	java/lang/Boolean
    //   137: invokevirtual 480	java/lang/Boolean:booleanValue	()Z
    //   140: putfield 483	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$BDHCommonUpResp:isSendByQuickHttp	Z
    //   143: goto +12 -> 155
    //   146: astore 6
    //   148: goto +135 -> 283
    //   151: astore_1
    //   152: goto +131 -> 283
    //   155: aload 6
    //   157: getfield 486	tencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   160: invokevirtual 488	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   163: istore 8
    //   165: iload 8
    //   167: ifne +28 -> 195
    //   170: aload_0
    //   171: aload 11
    //   173: aload 6
    //   175: invokespecial 490	com/tencent/mobileqq/transfile/protohandler/BDHCommonUpHandler:handleBusSuc	(Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$BDHCommonUpResp;Ltencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp;)V
    //   178: aload_0
    //   179: iconst_0
    //   180: iconst_0
    //   181: ldc 169
    //   183: ldc 169
    //   185: aload 5
    //   187: aload 11
    //   189: invokevirtual 494	com/tencent/mobileqq/transfile/protohandler/BDHCommonUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   192: goto -142 -> 50
    //   195: iload 8
    //   197: invokestatic 496	com/tencent/mobileqq/transfile/protohandler/BDHCommonUpHandler:shouldRetryByRetCode	(I)Z
    //   200: istore 10
    //   202: iload 10
    //   204: ifeq +41 -> 245
    //   207: aload_0
    //   208: aload_0
    //   209: getfield 499	com/tencent/mobileqq/transfile/protohandler/BDHCommonUpHandler:mReqUrlCount	I
    //   212: iconst_1
    //   213: iadd
    //   214: putfield 499	com/tencent/mobileqq/transfile/protohandler/BDHCommonUpHandler:mReqUrlCount	I
    //   217: aload_0
    //   218: getfield 499	com/tencent/mobileqq/transfile/protohandler/BDHCommonUpHandler:mReqUrlCount	I
    //   221: istore 9
    //   223: iload 9
    //   225: iconst_2
    //   226: if_icmpge +19 -> 245
    //   229: aload_3
    //   230: getfield 503	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:protoReqMgr	Lcom/tencent/mobileqq/transfile/api/IProtoReqManager;
    //   233: astore 6
    //   235: aload 6
    //   237: aload 7
    //   239: invokeinterface 509 2 0
    //   244: return
    //   245: aload_0
    //   246: iconst_m1
    //   247: sipush -9527
    //   250: iload 8
    //   252: i2l
    //   253: invokestatic 514	com/tencent/mobileqq/transfile/report/ProcessorReport:getUrlReason	(J)Ljava/lang/String;
    //   256: ldc 169
    //   258: aload 5
    //   260: aload 11
    //   262: invokevirtual 494	com/tencent/mobileqq/transfile/protohandler/BDHCommonUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   265: goto -215 -> 50
    //   268: astore 6
    //   270: goto +13 -> 283
    //   273: astore 6
    //   275: goto +8 -> 283
    //   278: astore 6
    //   280: aconst_null
    //   281: astore 11
    //   283: ldc_w 516
    //   286: ldc2_w 517
    //   289: invokestatic 522	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   292: astore 13
    //   294: new 214	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   301: astore 14
    //   303: aload 14
    //   305: aload 6
    //   307: invokevirtual 525	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   310: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 14
    //   316: ldc_w 527
    //   319: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 14
    //   325: aload_2
    //   326: invokestatic 167	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   329: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_0
    //   334: iconst_m1
    //   335: sipush -9527
    //   338: aload 13
    //   340: aload 14
    //   342: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: aload 5
    //   347: aload 11
    //   349: invokevirtual 494	com/tencent/mobileqq/transfile/protohandler/BDHCommonUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   352: goto -302 -> 50
    //   355: new 241	java/lang/Exception
    //   358: dup
    //   359: ldc_w 529
    //   362: invokespecial 246	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   365: athrow
    //   366: astore_1
    //   367: goto +4 -> 371
    //   370: astore_1
    //   371: ldc_w 516
    //   374: ldc2_w 517
    //   377: invokestatic 522	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   380: astore_3
    //   381: new 214	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   388: astore 6
    //   390: aload 6
    //   392: aload_1
    //   393: invokevirtual 525	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   396: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 6
    //   402: ldc_w 527
    //   405: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 6
    //   411: aload_2
    //   412: invokestatic 167	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   415: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_0
    //   420: iconst_m1
    //   421: sipush -9527
    //   424: aload_3
    //   425: aload 6
    //   427: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: aload 5
    //   432: aload 4
    //   434: getfield 454	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   437: invokevirtual 532	com/tencent/mobileqq/transfile/protohandler/BDHCommonUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   440: return
    //   441: astore 6
    //   443: goto +5 -> 448
    //   446: astore 6
    //   448: goto -178 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	this	BDHCommonUpHandler
    //   0	451	1	paramFromServiceMsg	FromServiceMsg
    //   0	451	2	paramArrayOfByte	byte[]
    //   0	451	3	paramRichProtoReq	RichProto.RichProtoReq
    //   0	451	4	paramRichProtoResp	RichProto.RichProtoResp
    //   0	451	5	paramStatictisInfo	com.tencent.mobileqq.app.StatictisInfo
    //   0	451	6	paramProtoResp	ProtoReqManagerImpl.ProtoResp
    //   0	451	7	paramProtoReq	ProtoReqManagerImpl.ProtoReq
    //   114	3	10	bool	boolean
    //   94	28	11	localBDHCommonUpResp	RichProto.RichProtoResp.BDHCommonUpResp
    //   48	13	12	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   121	143	146	java/lang/Exception
    //   178	192	268	java/lang/Exception
    //   195	202	268	java/lang/Exception
    //   235	244	268	java/lang/Exception
    //   245	265	268	java/lang/Exception
    //   104	116	273	java/lang/Exception
    //   155	165	273	java/lang/Exception
    //   170	178	273	java/lang/Exception
    //   72	96	278	java/lang/Exception
    //   9	26	366	java/lang/Exception
    //   31	50	366	java/lang/Exception
    //   50	72	366	java/lang/Exception
    //   283	352	366	java/lang/Exception
    //   355	366	366	java/lang/Exception
    //   0	9	370	java/lang/Exception
    //   229	235	441	java/lang/Exception
    //   207	223	446	java/lang/Exception
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.BDHCommonUpResp localBDHCommonUpResp = new RichProto.RichProtoResp.BDHCommonUpResp();
      localRichProtoResp.resps.add(i, localBDHCommonUpResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProtoResp: ");
      localStringBuilder.append(paramProtoResp.resp.getResultCode());
      QLog.e("BDHCommonUpHandler", 1, localStringBuilder.toString());
    }
    super.onProtoResp(paramProtoResp, paramProtoReq);
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "ImgStore.BDHCommonUp";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.BDHCommonUpHandler
 * JD-Core Version:    0.7.0.1
 */