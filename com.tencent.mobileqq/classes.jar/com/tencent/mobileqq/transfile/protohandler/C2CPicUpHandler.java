package com.tencent.mobileqq.transfile.protohandler;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgRsp;

public class C2CPicUpHandler
  extends PicUpHandler
{
  int mReqNetType;
  
  public static boolean shouldRetryByRetCode(int paramInt)
  {
    return (paramInt != 196) && (paramInt != 197) && (paramInt != 199) && (paramInt != 201) && (paramInt != 202) && (paramInt != 206) && (paramInt != 207) && (paramInt != 208);
  }
  
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x352.ReqBody paramReqBody)
  {
    RichProto.RichProtoReq.PicUpReq localPicUpReq = (RichProto.RichProtoReq.PicUpReq)paramReqCommon;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(localPicUpReq.selfUin).longValue());
    try
    {
      String str = localPicUpReq.peerUin;
      paramReqCommon = str;
      if (str.startsWith("+")) {
        paramReqCommon = str.substring(1);
      }
      long l = Long.valueOf(paramReqCommon).longValue();
      localTryUpImgReq.uint64_dst_uin.set(l);
    }
    catch (Exception paramReqCommon)
    {
      paramReqCommon.printStackTrace();
    }
    localTryUpImgReq.uint64_file_size.set(localPicUpReq.fileSize);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(localPicUpReq.md5));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(localPicUpReq.fileName));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(localPicUpReq.isContact);
    localTryUpImgReq.uint32_platform_type.set(9);
    setBuType(localTryUpImgReq);
    localTryUpImgReq.bool_pic_original.set(localPicUpReq.isRaw);
    localTryUpImgReq.uint32_pic_width.set(localPicUpReq.width);
    localTryUpImgReq.uint32_pic_height.set(localPicUpReq.height);
    localTryUpImgReq.uint32_pic_type.set(localPicUpReq.picType);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    localTryUpImgReq.bool_reject_tryfast.set(false);
    localTryUpImgReq.uint32_srv_upload.set(localPicUpReq.typeHotPic);
    if (!TextUtils.isEmpty(localPicUpReq.transferUrl)) {
      localTryUpImgReq.bytes_transfer_url.set(ByteStringMicro.copyFromUtf8(localPicUpReq.transferUrl));
    }
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
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
  protected void handleSucResp(com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, com.tencent.mobileqq.app.StatictisInfo paramStatictisInfo, com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    // Byte code:
    //   0: new 257	tencent/im/cs/cmd0x352/cmd0x352$RspBody
    //   3: dup
    //   4: invokespecial 258	tencent/im/cs/cmd0x352/cmd0x352$RspBody:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_2
    //   12: invokevirtual 262	tencent/im/cs/cmd0x352/cmd0x352$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15: checkcast 257	tencent/im/cs/cmd0x352/cmd0x352$RspBody
    //   18: getfield 265	tencent/im/cs/cmd0x352/cmd0x352$RspBody:rpt_msg_tryup_img_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   21: invokevirtual 268	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   24: astore 6
    //   26: aload 6
    //   28: ifnull +327 -> 355
    //   31: aload 6
    //   33: invokeinterface 217 1 0
    //   38: ifeq +317 -> 355
    //   41: aload 6
    //   43: invokeinterface 272 1 0
    //   48: astore 12
    //   50: aload 12
    //   52: invokeinterface 278 1 0
    //   57: ifeq +383 -> 440
    //   60: aload 12
    //   62: invokeinterface 282 1 0
    //   67: checkcast 284	tencent/im/cs/cmd0x352/cmd0x352$TryUpImgRsp
    //   70: astore 6
    //   72: aload 4
    //   74: getfield 290	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   77: aload 6
    //   79: getfield 291	tencent/im/cs/cmd0x352/cmd0x352$TryUpImgRsp:uint64_file_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   82: invokevirtual 293	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   85: l2i
    //   86: invokeinterface 221 2 0
    //   91: checkcast 295	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$C2CPicUpResp
    //   94: astore 11
    //   96: aload 11
    //   98: ifnull -48 -> 50
    //   101: aload_1
    //   102: invokevirtual 301	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   105: ldc_w 303
    //   108: invokevirtual 309	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   111: istore 10
    //   113: iload 10
    //   115: ifeq +37 -> 152
    //   118: aload 11
    //   120: aload_1
    //   121: ldc_w 303
    //   124: iconst_0
    //   125: invokestatic 314	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   128: invokevirtual 318	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   131: checkcast 311	java/lang/Boolean
    //   134: invokevirtual 321	java/lang/Boolean:booleanValue	()Z
    //   137: putfield 324	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$C2CPicUpResp:isSendByQuickHttp	Z
    //   140: goto +12 -> 152
    //   143: astore 6
    //   145: goto +138 -> 283
    //   148: astore_1
    //   149: goto +134 -> 283
    //   152: aload 6
    //   154: getfield 327	tencent/im/cs/cmd0x352/cmd0x352$TryUpImgRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 329	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: istore 8
    //   162: iload 8
    //   164: ifne +30 -> 194
    //   167: aload_0
    //   168: aload 6
    //   170: aload 11
    //   172: invokevirtual 333	com/tencent/mobileqq/transfile/protohandler/C2CPicUpHandler:parseResp	(Ltencent/im/cs/cmd0x352/cmd0x352$TryUpImgRsp;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$C2CPicUpResp;)V
    //   175: aload_0
    //   176: iconst_0
    //   177: iconst_0
    //   178: ldc_w 335
    //   181: ldc_w 335
    //   184: aload 5
    //   186: aload 11
    //   188: invokevirtual 339	com/tencent/mobileqq/transfile/protohandler/C2CPicUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   191: goto -141 -> 50
    //   194: iload 8
    //   196: invokestatic 341	com/tencent/mobileqq/transfile/protohandler/C2CPicUpHandler:shouldRetryByRetCode	(I)Z
    //   199: istore 10
    //   201: iload 10
    //   203: ifeq +41 -> 244
    //   206: aload_0
    //   207: aload_0
    //   208: getfield 344	com/tencent/mobileqq/transfile/protohandler/C2CPicUpHandler:mReqUrlCount	I
    //   211: iconst_1
    //   212: iadd
    //   213: putfield 344	com/tencent/mobileqq/transfile/protohandler/C2CPicUpHandler:mReqUrlCount	I
    //   216: aload_0
    //   217: getfield 344	com/tencent/mobileqq/transfile/protohandler/C2CPicUpHandler:mReqUrlCount	I
    //   220: istore 9
    //   222: iload 9
    //   224: iconst_2
    //   225: if_icmpge +19 -> 244
    //   228: aload_3
    //   229: getfield 350	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:protoReqMgr	Lcom/tencent/mobileqq/transfile/api/IProtoReqManager;
    //   232: astore 6
    //   234: aload 6
    //   236: aload 7
    //   238: invokeinterface 356 2 0
    //   243: return
    //   244: aload_0
    //   245: iconst_m1
    //   246: sipush -9527
    //   249: iload 8
    //   251: i2l
    //   252: invokestatic 362	com/tencent/mobileqq/transfile/report/ProcessorReport:getUrlReason	(J)Ljava/lang/String;
    //   255: ldc_w 335
    //   258: aload 5
    //   260: aload 11
    //   262: invokevirtual 339	com/tencent/mobileqq/transfile/protohandler/C2CPicUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   265: goto -215 -> 50
    //   268: astore 6
    //   270: goto +13 -> 283
    //   273: astore 6
    //   275: goto +8 -> 283
    //   278: astore 6
    //   280: aconst_null
    //   281: astore 11
    //   283: ldc_w 364
    //   286: ldc2_w 365
    //   289: invokestatic 370	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   292: astore 13
    //   294: new 372	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   301: astore 14
    //   303: aload 14
    //   305: aload 6
    //   307: invokevirtual 376	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   310: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 14
    //   316: ldc_w 382
    //   319: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 14
    //   325: aload_2
    //   326: invokestatic 388	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   329: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload_0
    //   334: iconst_m1
    //   335: sipush -9527
    //   338: aload 13
    //   340: aload 14
    //   342: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: aload 5
    //   347: aload 11
    //   349: invokevirtual 339	com/tencent/mobileqq/transfile/protohandler/C2CPicUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   352: goto -302 -> 50
    //   355: new 17	java/lang/Exception
    //   358: dup
    //   359: ldc_w 393
    //   362: invokespecial 396	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   365: athrow
    //   366: astore_1
    //   367: goto +4 -> 371
    //   370: astore_1
    //   371: ldc_w 364
    //   374: ldc2_w 365
    //   377: invokestatic 370	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   380: astore_3
    //   381: new 372	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   388: astore 6
    //   390: aload 6
    //   392: aload_1
    //   393: invokevirtual 376	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   396: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 6
    //   402: ldc_w 382
    //   405: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 6
    //   411: aload_2
    //   412: invokestatic 388	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   415: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_0
    //   420: iconst_m1
    //   421: sipush -9527
    //   424: aload_3
    //   425: aload 6
    //   427: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: aload 5
    //   432: aload 4
    //   434: getfield 290	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   437: invokevirtual 399	com/tencent/mobileqq/transfile/protohandler/C2CPicUpHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   440: return
    //   441: astore 6
    //   443: goto +5 -> 448
    //   446: astore 6
    //   448: goto -178 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	this	C2CPicUpHandler
    //   0	451	1	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	451	2	paramArrayOfByte	byte[]
    //   0	451	3	paramRichProtoReq	RichProto.RichProtoReq
    //   0	451	4	paramRichProtoResp	RichProto.RichProtoResp
    //   0	451	5	paramStatictisInfo	com.tencent.mobileqq.app.StatictisInfo
    //   0	451	6	paramProtoResp	com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp
    //   0	451	7	paramProtoReq	ProtoReqManagerImpl.ProtoReq
    //   111	3	10	bool	boolean
    //   94	25	11	localC2CPicUpResp	RichProto.RichProtoResp.C2CPicUpResp
    //   48	13	12	localIterator	java.util.Iterator
    // Exception table:
    //   from	to	target	type
    //   118	140	143	java/lang/Exception
    //   175	191	268	java/lang/Exception
    //   194	201	268	java/lang/Exception
    //   234	243	268	java/lang/Exception
    //   244	265	268	java/lang/Exception
    //   101	113	273	java/lang/Exception
    //   152	162	273	java/lang/Exception
    //   167	175	273	java/lang/Exception
    //   72	96	278	java/lang/Exception
    //   9	26	366	java/lang/Exception
    //   31	50	366	java/lang/Exception
    //   50	72	366	java/lang/Exception
    //   283	352	366	java/lang/Exception
    //   355	366	366	java/lang/Exception
    //   0	9	370	java/lang/Exception
    //   228	234	441	java/lang/Exception
    //   206	222	446	java/lang/Exception
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.C2CPicUpResp localC2CPicUpResp = new RichProto.RichProtoResp.C2CPicUpResp();
      localRichProtoResp.resps.add(i, localC2CPicUpResp);
      i += 1;
    }
  }
  
  void parseResp(cmd0x352.TryUpImgRsp paramTryUpImgRsp, RichProto.RichProtoResp.C2CPicUpResp paramC2CPicUpResp)
  {
    if (paramTryUpImgRsp.bytes_up_resid.has()) {
      paramC2CPicUpResp.mResid = paramTryUpImgRsp.bytes_up_resid.get().toStringUtf8();
    }
    if (paramTryUpImgRsp.bytes_up_uuid.has()) {
      paramC2CPicUpResp.mUuid = paramTryUpImgRsp.bytes_up_uuid.get().toStringUtf8();
    }
    paramC2CPicUpResp.startOffset = paramTryUpImgRsp.uint64_up_offset.get();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" TryUpLoad : Offset:");
      localStringBuilder.append(paramC2CPicUpResp.startOffset);
      localStringBuilder.append(" Value:");
      localStringBuilder.append(paramTryUpImgRsp.uint64_up_offset.get());
      QLog.d("BDH_LOG", 2, localStringBuilder.toString());
    }
    boolean bool2 = paramTryUpImgRsp.bool_file_exit.has();
    boolean bool1 = true;
    if ((bool2) && (paramTryUpImgRsp.bool_file_exit.get()))
    {
      paramC2CPicUpResp.isExist = true;
    }
    else
    {
      paramC2CPicUpResp.mUkey = HexUtil.bytes2HexStr(paramTryUpImgRsp.bytes_up_ukey.get().toByteArray());
      paramC2CPicUpResp.blockSize = ((int)paramTryUpImgRsp.uint64_block_size.get());
      if (NetworkCenter.getInstance().getNetType() == this.mReqNetType) {
        bool1 = false;
      }
      paramC2CPicUpResp.networkChange = bool1;
    }
    if (paramTryUpImgRsp.bytes_original_down_para.has()) {
      paramC2CPicUpResp.mOriginalDownPara = paramTryUpImgRsp.bytes_original_down_para.get().toStringUtf8();
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      setSsoCmd(localProtoReq);
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
  
  protected void setBuType(cmd0x352.TryUpImgReq paramTryUpImgReq)
  {
    paramTryUpImgReq.uint32_bu_type.set(1);
  }
  
  protected void setSsoCmd(ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    paramProtoReq.ssoCmd = "LongConn.OffPicUp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPicUpHandler
 * JD-Core Version:    0.7.0.1
 */