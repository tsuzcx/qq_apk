package com.tencent.mobileqq.transfile.protohandler;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.StatictisInfo;
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
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpImgRsp;

public class GuildPicUpHandler
  extends PicUpHandler
{
  int mReqNetType;
  
  private void handleSucResult(StatictisInfo paramStatictisInfo, cmd0x388.TryUpImgRsp paramTryUpImgRsp, RichProto.RichProtoResp.GuildPicUpResp paramGuildPicUpResp)
  {
    paramGuildPicUpResp.groupFileID = paramTryUpImgRsp.uint64_fileid.get();
    if (paramTryUpImgRsp.bytes_download_index.has()) {
      paramGuildPicUpResp.mDownLoadIndex = paramTryUpImgRsp.bytes_download_index.get().toByteArray();
    } else {
      QLog.d("Q.richmedia.BaseHandler", 2, "handleSucResult: Guild_mDownLoadIndex is null");
    }
    boolean bool2 = paramTryUpImgRsp.bool_file_exit.has();
    boolean bool1 = false;
    int i = 0;
    Object localObject1;
    long l1;
    long l2;
    Object localObject2;
    if ((bool2) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      paramGuildPicUpResp.isExist = true;
      localObject1 = paramTryUpImgRsp.rpt_uint32_up_ip.get();
      paramTryUpImgRsp = paramTryUpImgRsp.rpt_uint32_up_port.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        while (i < ((List)localObject1).size())
        {
          l1 = ((Integer)((List)localObject1).get(i)).intValue();
          l2 = ((Integer)paramTryUpImgRsp.get(i)).intValue();
          localObject2 = new ServerAddr();
          ((ServerAddr)localObject2).mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
          ((ServerAddr)localObject2).port = ((int)l2);
          paramGuildPicUpResp.mIpList.add(i, localObject2);
          i += 1;
        }
      }
    }
    else
    {
      localObject1 = paramTryUpImgRsp.rpt_uint32_up_ip.get();
      localObject2 = paramTryUpImgRsp.rpt_uint32_up_port.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        i = 0;
        while (i < ((List)localObject1).size())
        {
          l1 = ((Integer)((List)localObject1).get(i)).intValue();
          l2 = ((Integer)((List)localObject2).get(i)).intValue();
          ServerAddr localServerAddr = new ServerAddr();
          localServerAddr.mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
          localServerAddr.port = ((int)l2);
          paramGuildPicUpResp.mIpList.add(i, localServerAddr);
          i += 1;
        }
      }
      localObject2 = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (localObject1 == null) || (((List)localObject1).size() == 0)) {
        break label542;
      }
      paramGuildPicUpResp.mUkey = ((String)localObject2);
      paramGuildPicUpResp.blockSize = ((int)paramTryUpImgRsp.uint64_block_size.get());
      paramGuildPicUpResp.transferedSize = ((int)paramTryUpImgRsp.uint64_up_offset.get());
      if (NetworkCenter.getInstance().getNetType() != this.mReqNetType) {
        bool1 = true;
      }
      paramGuildPicUpResp.networkChange = bool1;
      paramGuildPicUpResp.startOffset = paramTryUpImgRsp.uint64_up_offset.get();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" Channel:");
        ((StringBuilder)localObject1).append(paramTryUpImgRsp.bool_new_big_chan.get());
        QLog.d("BDH_LOG", 2, ((StringBuilder)localObject1).toString());
      }
      if ((paramTryUpImgRsp.bool_new_big_chan.has()) && (paramTryUpImgRsp.bool_new_big_chan.get())) {
        paramGuildPicUpResp.isUseBdh = true;
      }
    }
    setResult(0, 0, "", "", paramStatictisInfo, paramGuildPicUpResp);
    return;
    label542:
    paramStatictisInfo = new Exception("check ukey,iplist");
    for (;;)
    {
      throw paramStatictisInfo;
    }
  }
  
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.PicUpReq)paramReqCommon;
    cmd0x388.TryUpImgReq localTryUpImgReq = new cmd0x388.TryUpImgReq();
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.parseLong(paramReqCommon.selfUin));
    localTryUpImgReq.uint64_group_code.set(Long.parseLong(paramReqCommon.peerUin));
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.uint64_file_size.set(paramReqCommon.fileSize);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.md5));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramReqCommon.fileName));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_pic_width.set(paramReqCommon.width);
    localTryUpImgReq.uint32_pic_height.set(paramReqCommon.height);
    localTryUpImgReq.uint32_pic_type.set(paramReqCommon.picType);
    localTryUpImgReq.uint32_app_pic_type.set(paramReqCommon.busiType);
    localTryUpImgReq.uint32_bu_type.set(211);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    localTryUpImgReq.uint32_srv_upload.set(paramReqCommon.typeHotPic);
    localTryUpImgReq.uint64_qqmeet_channel_id.set(Long.parseLong(paramReqCommon.peerUin));
    localTryUpImgReq.uint64_qqmeet_guild_id.set(Long.parseLong(paramReqCommon.secondUin));
    if (paramReqCommon.isRaw) {
      localTryUpImgReq.uint32_original_pic.set(1);
    }
    if (!TextUtils.isEmpty(paramReqCommon.transferUrl)) {
      localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(paramReqCommon.transferUrl));
    }
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(1);
    localReqBody.uint32_command_id.set(83);
    int i = 0;
    while (i < paramList.size())
    {
      addOne(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), localReqBody);
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
          break label116;
        }
        if (j == 4) {}
      }
      else
      {
        i = 6;
        break label119;
      }
      i = 8;
      break label119;
      label116:
      i = 7;
    }
    label119:
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
  
  /* Error */
  protected void handleSucResp(com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, StatictisInfo paramStatictisInfo, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    // Byte code:
    //   0: new 406	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   3: dup
    //   4: invokespecial 407	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_2
    //   12: invokevirtual 411	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15: checkcast 406	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   18: getfield 414	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_tryup_img_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   21: invokevirtual 415	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +351 -> 379
    //   31: aload 6
    //   33: invokeinterface 95 1 0
    //   38: ifeq +341 -> 379
    //   41: aload 6
    //   43: invokeinterface 419 1 0
    //   48: astore 14
    //   50: aload 14
    //   52: invokeinterface 424 1 0
    //   57: ifeq +407 -> 464
    //   60: aload 14
    //   62: invokeinterface 428 1 0
    //   67: checkcast 15	tencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp
    //   70: astore 6
    //   72: aload 4
    //   74: getfield 434	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   77: aload 6
    //   79: getfield 435	tencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp:uint64_file_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   82: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   85: l2i
    //   86: invokeinterface 98 2 0
    //   91: checkcast 27	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GuildPicUpResp
    //   94: astore 13
    //   96: aload 13
    //   98: ifnull -48 -> 50
    //   101: aload_1
    //   102: invokevirtual 441	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   105: ldc_w 443
    //   108: invokevirtual 448	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   111: istore 10
    //   113: iload 10
    //   115: ifeq +37 -> 152
    //   118: aload 13
    //   120: aload_1
    //   121: ldc_w 443
    //   124: iconst_0
    //   125: invokestatic 454	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   128: invokevirtual 458	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: checkcast 450	java/lang/Boolean
    //   134: invokevirtual 461	java/lang/Boolean:booleanValue	()Z
    //   137: putfield 464	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GuildPicUpResp:isSendByQuickHttp	Z
    //   140: goto +12 -> 152
    //   143: astore 6
    //   145: goto +162 -> 307
    //   148: astore_1
    //   149: goto +158 -> 307
    //   152: aload 6
    //   154: getfield 467	tencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 469	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: istore 8
    //   162: iload 8
    //   164: ifne +36 -> 200
    //   167: aload 6
    //   169: getfield 35	tencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp:bytes_download_index	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   172: invokevirtual 41	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   175: istore 10
    //   177: iload 10
    //   179: ifeq +21 -> 200
    //   182: aload_0
    //   183: aload 5
    //   185: aload 6
    //   187: aload 13
    //   189: invokespecial 471	com/tencent/mobileqq/transfile/protohandler/GuildPicUpHandler:handleSucResult	(Lcom/tencent/mobileqq/app/StatictisInfo;Ltencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GuildPicUpResp;)V
    //   192: goto -142 -> 50
    //   195: astore 6
    //   197: goto +110 -> 307
    //   200: aload_0
    //   201: iload 8
    //   203: invokevirtual 475	com/tencent/mobileqq/transfile/protohandler/GuildPicUpHandler:shouldRetryByRetCodeForGroup	(I)Z
    //   206: istore 10
    //   208: iload 10
    //   210: ifeq +51 -> 261
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 478	com/tencent/mobileqq/transfile/protohandler/GuildPicUpHandler:mReqUrlCount	I
    //   218: iconst_1
    //   219: iadd
    //   220: putfield 478	com/tencent/mobileqq/transfile/protohandler/GuildPicUpHandler:mReqUrlCount	I
    //   223: aload_0
    //   224: getfield 478	com/tencent/mobileqq/transfile/protohandler/GuildPicUpHandler:mReqUrlCount	I
    //   227: istore 9
    //   229: iload 9
    //   231: iconst_2
    //   232: if_icmpge +29 -> 261
    //   235: aload_3
    //   236: getfield 484	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:protoReqMgr	Lcom/tencent/mobileqq/transfile/api/IProtoReqManager;
    //   239: astore 6
    //   241: aload 6
    //   243: aload 7
    //   245: invokeinterface 490 2 0
    //   250: return
    //   251: astore 6
    //   253: goto +5 -> 258
    //   256: astore 6
    //   258: goto +49 -> 307
    //   261: iload 8
    //   263: i2l
    //   264: lstore 11
    //   266: lload 11
    //   268: invokestatic 495	com/tencent/mobileqq/transfile/report/ProcessorReport:getUrlReason	(J)Ljava/lang/String;
    //   271: astore 6
    //   273: aload_0
    //   274: iconst_m1
    //   275: sipush -9527
    //   278: aload 6
    //   280: ldc 142
    //   282: aload 5
    //   284: aload 13
    //   286: invokevirtual 211	com/tencent/mobileqq/transfile/protohandler/GuildPicUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   289: goto -239 -> 50
    //   292: astore 6
    //   294: goto +13 -> 307
    //   297: astore 6
    //   299: goto +8 -> 307
    //   302: astore 6
    //   304: aconst_null
    //   305: astore 13
    //   307: ldc_w 497
    //   310: ldc2_w 498
    //   313: invokestatic 503	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   316: astore 15
    //   318: new 185	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   325: astore 16
    //   327: aload 16
    //   329: aload 6
    //   331: invokevirtual 506	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   334: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 16
    //   340: ldc_w 508
    //   343: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 16
    //   349: aload_2
    //   350: invokestatic 140	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   353: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload_0
    //   358: iconst_m1
    //   359: sipush -9527
    //   362: aload 15
    //   364: aload 16
    //   366: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: aload 5
    //   371: aload 13
    //   373: invokevirtual 211	com/tencent/mobileqq/transfile/protohandler/GuildPicUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   376: goto -326 -> 50
    //   379: new 213	java/lang/Exception
    //   382: dup
    //   383: ldc_w 510
    //   386: invokespecial 218	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   389: athrow
    //   390: astore_1
    //   391: goto +4 -> 395
    //   394: astore_1
    //   395: ldc_w 497
    //   398: ldc2_w 498
    //   401: invokestatic 503	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   404: astore_3
    //   405: new 185	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   412: astore 6
    //   414: aload 6
    //   416: aload_1
    //   417: invokevirtual 506	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   420: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 6
    //   426: ldc_w 508
    //   429: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 6
    //   435: aload_2
    //   436: invokestatic 140	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   439: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload_0
    //   444: iconst_m1
    //   445: sipush -9527
    //   448: aload_3
    //   449: aload 6
    //   451: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: aload 5
    //   456: aload 4
    //   458: getfield 434	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   461: invokevirtual 513	com/tencent/mobileqq/transfile/protohandler/GuildPicUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   464: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	465	0	this	GuildPicUpHandler
    //   0	465	1	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	465	2	paramArrayOfByte	byte[]
    //   0	465	3	paramRichProtoReq	RichProto.RichProtoReq
    //   0	465	4	paramRichProtoResp	RichProto.RichProtoResp
    //   0	465	5	paramStatictisInfo	StatictisInfo
    //   0	465	6	paramProtoResp	com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp
    //   0	465	7	paramProtoReq	ProtoReqManagerImpl.ProtoReq
    //   111	3	10	bool	boolean
    //   94	25	13	localGuildPicUpResp	RichProto.RichProtoResp.GuildPicUpResp
    //   48	13	14	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   118	140	143	java/lang/Exception
    //   182	192	143	java/lang/Exception
    //   241	250	143	java/lang/Exception
    //   167	177	195	java/lang/Exception
    //   235	241	251	java/lang/Exception
    //   213	229	256	java/lang/Exception
    //   273	289	292	java/lang/Exception
    //   101	113	297	java/lang/Exception
    //   152	162	297	java/lang/Exception
    //   200	208	297	java/lang/Exception
    //   266	273	297	java/lang/Exception
    //   72	96	302	java/lang/Exception
    //   9	26	390	java/lang/Exception
    //   31	50	390	java/lang/Exception
    //   50	72	390	java/lang/Exception
    //   307	376	390	java/lang/Exception
    //   379	390	390	java/lang/Exception
    //   0	9	394	java/lang/Exception
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.GuildPicUpResp localGuildPicUpResp = new RichProto.RichProtoResp.GuildPicUpResp();
      localRichProtoResp.resps.add(i, localGuildPicUpResp);
      i += 1;
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "ImgStore.QQMeetPicUp";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GuildPicUpHandler
 * JD-Core Version:    0.7.0.1
 */