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

public class GroupPicUpHandler
  extends PicUpHandler
{
  int mReqNetType;
  
  private void handleSucResult(StatictisInfo paramStatictisInfo, cmd0x388.TryUpImgRsp paramTryUpImgRsp, RichProto.RichProtoResp.GroupPicUpResp paramGroupPicUpResp)
  {
    paramGroupPicUpResp.groupFileID = paramTryUpImgRsp.uint64_fileid.get();
    boolean bool2 = paramTryUpImgRsp.bool_file_exit.has();
    boolean bool1 = false;
    int i = 0;
    Object localObject1;
    if ((bool2) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      paramGroupPicUpResp.isExist = true;
      localObject1 = paramTryUpImgRsp.rpt_uint32_up_ip.get();
      paramTryUpImgRsp = paramTryUpImgRsp.rpt_uint32_up_port.get();
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {}
    }
    else
    {
      while (i < ((List)localObject1).size())
      {
        long l1 = ((Integer)((List)localObject1).get(i)).intValue();
        long l2 = ((Integer)paramTryUpImgRsp.get(i)).intValue();
        Object localObject2 = new ServerAddr();
        ((ServerAddr)localObject2).mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
        ((ServerAddr)localObject2).port = ((int)l2);
        paramGroupPicUpResp.mIpList.add(i, localObject2);
        i += 1;
        continue;
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
            paramGroupPicUpResp.mIpList.add(i, localServerAddr);
            i += 1;
          }
        }
        localObject2 = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
        if ((localObject2 == null) || (((String)localObject2).equals("")) || (localObject1 == null) || (((List)localObject1).size() == 0)) {
          break label505;
        }
        paramGroupPicUpResp.mUkey = ((String)localObject2);
        paramGroupPicUpResp.blockSize = ((int)paramTryUpImgRsp.uint64_block_size.get());
        paramGroupPicUpResp.transferedSize = ((int)paramTryUpImgRsp.uint64_up_offset.get());
        if (NetworkCenter.getInstance().getNetType() != this.mReqNetType) {
          bool1 = true;
        }
        paramGroupPicUpResp.networkChange = bool1;
        paramGroupPicUpResp.startOffset = paramTryUpImgRsp.uint64_up_offset.get();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(" Channel:");
          ((StringBuilder)localObject1).append(paramTryUpImgRsp.bool_new_big_chan.get());
          QLog.d("BDH_LOG", 2, ((StringBuilder)localObject1).toString());
        }
        if ((paramTryUpImgRsp.bool_new_big_chan.has()) && (paramTryUpImgRsp.bool_new_big_chan.get() == true)) {
          paramGroupPicUpResp.isUseBdh = true;
        }
      }
    }
    setResult(0, 0, "", "", paramStatictisInfo, paramGroupPicUpResp);
    return;
    label505:
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
    localTryUpImgReq.uint32_app_pic_type.set(paramReqCommon.busiType);
    PBUInt32Field localPBUInt32Field = localTryUpImgReq.uint32_bu_type;
    if (paramReqCommon.uinType == 1) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    localPBUInt32Field.set(paramInt);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    localTryUpImgReq.uint32_srv_upload.set(paramReqCommon.typeHotPic);
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
          break label106;
        }
        if (j == 4) {}
      }
      else
      {
        i = 6;
        break label109;
      }
      i = 8;
      break label109;
      label106:
      i = 7;
    }
    label109:
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
    //   0: new 389	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   3: dup
    //   4: invokespecial 390	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_2
    //   12: invokevirtual 394	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15: checkcast 389	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   18: getfield 397	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_tryup_img_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   21: invokevirtual 398	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +331 -> 359
    //   31: aload 6
    //   33: invokeinterface 65 1 0
    //   38: ifeq +321 -> 359
    //   41: aload 6
    //   43: invokeinterface 402 1 0
    //   48: astore 14
    //   50: aload 14
    //   52: invokeinterface 407 1 0
    //   57: ifeq +387 -> 444
    //   60: aload 14
    //   62: invokeinterface 411 1 0
    //   67: checkcast 15	tencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp
    //   70: astore 6
    //   72: aload 4
    //   74: getfield 417	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   77: aload 6
    //   79: getfield 418	tencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp:uint64_file_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   82: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   85: l2i
    //   86: invokeinterface 68 2 0
    //   91: checkcast 27	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPicUpResp
    //   94: astore 13
    //   96: aload 13
    //   98: ifnull -48 -> 50
    //   101: aload_1
    //   102: invokevirtual 424	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   105: ldc_w 426
    //   108: invokevirtual 431	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   111: istore 10
    //   113: iload 10
    //   115: ifeq +37 -> 152
    //   118: aload 13
    //   120: aload_1
    //   121: ldc_w 426
    //   124: iconst_0
    //   125: invokestatic 436	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   128: invokevirtual 440	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: checkcast 433	java/lang/Boolean
    //   134: invokevirtual 443	java/lang/Boolean:booleanValue	()Z
    //   137: putfield 446	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPicUpResp:isSendByQuickHttp	Z
    //   140: goto +12 -> 152
    //   143: astore 6
    //   145: goto +142 -> 287
    //   148: astore_1
    //   149: goto +138 -> 287
    //   152: aload 6
    //   154: getfield 449	tencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 451	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: istore 8
    //   162: iload 8
    //   164: ifne +16 -> 180
    //   167: aload_0
    //   168: aload 5
    //   170: aload 6
    //   172: aload 13
    //   174: invokespecial 453	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:handleSucResult	(Lcom/tencent/mobileqq/app/StatictisInfo;Ltencent/im/cs/cmd0x388/cmd0x388$TryUpImgRsp;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$GroupPicUpResp;)V
    //   177: goto -127 -> 50
    //   180: aload_0
    //   181: iload 8
    //   183: invokevirtual 457	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:shouldRetryByRetCodeForGroup	(I)Z
    //   186: istore 10
    //   188: iload 10
    //   190: ifeq +51 -> 241
    //   193: aload_0
    //   194: aload_0
    //   195: getfield 460	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:mReqUrlCount	I
    //   198: iconst_1
    //   199: iadd
    //   200: putfield 460	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:mReqUrlCount	I
    //   203: aload_0
    //   204: getfield 460	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:mReqUrlCount	I
    //   207: istore 9
    //   209: iload 9
    //   211: iconst_2
    //   212: if_icmpge +29 -> 241
    //   215: aload_3
    //   216: getfield 466	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:protoReqMgr	Lcom/tencent/mobileqq/transfile/api/IProtoReqManager;
    //   219: astore 6
    //   221: aload 6
    //   223: aload 7
    //   225: invokeinterface 472 2 0
    //   230: return
    //   231: astore 6
    //   233: goto +5 -> 238
    //   236: astore 6
    //   238: goto +49 -> 287
    //   241: iload 8
    //   243: i2l
    //   244: lstore 11
    //   246: lload 11
    //   248: invokestatic 477	com/tencent/mobileqq/transfile/report/ProcessorReport:getUrlReason	(J)Ljava/lang/String;
    //   251: astore 6
    //   253: aload_0
    //   254: iconst_m1
    //   255: sipush -9527
    //   258: aload 6
    //   260: ldc 124
    //   262: aload 5
    //   264: aload 13
    //   266: invokevirtual 199	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   269: goto -219 -> 50
    //   272: astore 6
    //   274: goto +13 -> 287
    //   277: astore 6
    //   279: goto +8 -> 287
    //   282: astore 6
    //   284: aconst_null
    //   285: astore 13
    //   287: ldc_w 479
    //   290: ldc2_w 480
    //   293: invokestatic 485	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   296: astore 15
    //   298: new 169	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   305: astore 16
    //   307: aload 16
    //   309: aload 6
    //   311: invokevirtual 488	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   314: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 16
    //   320: ldc_w 490
    //   323: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 16
    //   329: aload_2
    //   330: invokestatic 122	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   333: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_0
    //   338: iconst_m1
    //   339: sipush -9527
    //   342: aload 15
    //   344: aload 16
    //   346: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: aload 5
    //   351: aload 13
    //   353: invokevirtual 199	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   356: goto -306 -> 50
    //   359: new 201	java/lang/Exception
    //   362: dup
    //   363: ldc_w 492
    //   366: invokespecial 206	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   369: athrow
    //   370: astore_1
    //   371: goto +4 -> 375
    //   374: astore_1
    //   375: ldc_w 479
    //   378: ldc2_w 480
    //   381: invokestatic 485	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   384: astore_3
    //   385: new 169	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   392: astore 6
    //   394: aload 6
    //   396: aload_1
    //   397: invokevirtual 488	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   400: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: aload 6
    //   406: ldc_w 490
    //   409: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 6
    //   415: aload_2
    //   416: invokestatic 122	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   419: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload_0
    //   424: iconst_m1
    //   425: sipush -9527
    //   428: aload_3
    //   429: aload 6
    //   431: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: aload 5
    //   436: aload 4
    //   438: getfield 417	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   441: invokevirtual 495	com/tencent/mobileqq/transfile/protohandler/GroupPicUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   444: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	GroupPicUpHandler
    //   0	445	1	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	445	2	paramArrayOfByte	byte[]
    //   0	445	3	paramRichProtoReq	RichProto.RichProtoReq
    //   0	445	4	paramRichProtoResp	RichProto.RichProtoResp
    //   0	445	5	paramStatictisInfo	StatictisInfo
    //   0	445	6	paramProtoResp	com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp
    //   0	445	7	paramProtoReq	ProtoReqManagerImpl.ProtoReq
    //   111	3	10	bool	boolean
    //   94	25	13	localGroupPicUpResp	RichProto.RichProtoResp.GroupPicUpResp
    //   48	13	14	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   118	140	143	java/lang/Exception
    //   167	177	143	java/lang/Exception
    //   221	230	143	java/lang/Exception
    //   215	221	231	java/lang/Exception
    //   193	209	236	java/lang/Exception
    //   253	269	272	java/lang/Exception
    //   101	113	277	java/lang/Exception
    //   152	162	277	java/lang/Exception
    //   180	188	277	java/lang/Exception
    //   246	253	277	java/lang/Exception
    //   72	96	282	java/lang/Exception
    //   9	26	370	java/lang/Exception
    //   31	50	370	java/lang/Exception
    //   50	72	370	java/lang/Exception
    //   287	356	370	java/lang/Exception
    //   359	370	370	java/lang/Exception
    //   0	9	374	java/lang/Exception
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.GroupPicUpResp localGroupPicUpResp = new RichProto.RichProtoResp.GroupPicUpResp();
      localRichProtoResp.resps.add(i, localGroupPicUpResp);
      i += 1;
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "ImgStore.GroupPicUp";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPicUpHandler
 * JD-Core Version:    0.7.0.1
 */