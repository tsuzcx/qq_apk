package com.tencent.mobileqq.transfile.protohandler;

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
import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlReq;
import tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlRsp;
import tencent.im.cs.cmd0x352.cmd0x352.IPv6Info;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;

public class C2CPicDownHandler
  extends PicDownHandler
{
  private void handleResponse(RichProto.RichProtoReq.C2CPicDownReq paramC2CPicDownReq, cmd0x352.GetImgUrlRsp paramGetImgUrlRsp, RichProto.RichProtoResp.PicDownResp paramPicDownResp)
  {
    Object localObject1 = paramGetImgUrlRsp.bytes_thumb_down_para.get();
    Object localObject2 = paramGetImgUrlRsp.bytes_original_down_para.get();
    Object localObject3 = paramGetImgUrlRsp.bytes_big_down_para.get();
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((ByteStringMicro)localObject1).toStringUtf8();
    }
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = ((ByteStringMicro)localObject2).toStringUtf8();
    }
    if (localObject3 == null) {
      localObject3 = null;
    } else {
      localObject3 = ((ByteStringMicro)localObject3).toStringUtf8();
    }
    if (paramC2CPicDownReq.fileType == 65537) {
      paramC2CPicDownReq = (RichProto.RichProtoReq.C2CPicDownReq)localObject1;
    } else if (paramC2CPicDownReq.fileType == 1) {
      paramC2CPicDownReq = (RichProto.RichProtoReq.C2CPicDownReq)localObject3;
    } else if (paramC2CPicDownReq.fileType == 131075) {
      paramC2CPicDownReq = (RichProto.RichProtoReq.C2CPicDownReq)localObject2;
    } else {
      paramC2CPicDownReq = null;
    }
    paramPicDownResp.urlPath = paramC2CPicDownReq;
    boolean bool = paramGetImgUrlRsp.rpt_uint32_down_ip.has();
    int j = 0;
    int i;
    if ((bool) && (paramGetImgUrlRsp.rpt_uint32_down_ip.size() > 0) && (paramGetImgUrlRsp.rpt_uint32_down_port.has()) && (paramGetImgUrlRsp.rpt_uint32_down_port.size() > 0))
    {
      paramC2CPicDownReq = paramGetImgUrlRsp.rpt_uint32_down_ip.get();
      localObject1 = paramGetImgUrlRsp.rpt_uint32_down_port.get();
      i = 0;
      while (i < paramC2CPicDownReq.size())
      {
        localObject2 = new ServerAddr();
        ((ServerAddr)localObject2).mIp = PkgTools.int2IPNet(((Integer)paramC2CPicDownReq.get(i)).intValue() & 0xFFFFFFFF);
        ((ServerAddr)localObject2).port = ((Integer)((List)localObject1).get(i)).intValue();
        paramPicDownResp.mIpList.add(i, localObject2);
        i += 1;
      }
    }
    if ((paramGetImgUrlRsp.rpt_msg_down_ip6.has()) && (paramGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
    {
      paramC2CPicDownReq = paramGetImgUrlRsp.rpt_msg_down_ip6.get();
      i = j;
      while (i < paramC2CPicDownReq.size())
      {
        localObject1 = new ServerAddr();
        ((ServerAddr)localObject1).mIp = Inet6Address.getByAddress(((cmd0x352.IPv6Info)paramC2CPicDownReq.get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
        ((ServerAddr)localObject1).port = ((cmd0x352.IPv6Info)paramC2CPicDownReq.get(i)).uint32_port.get();
        ((ServerAddr)localObject1).isIpv6 = true;
        paramPicDownResp.mIpv6List.add(i, localObject1);
        i += 1;
      }
    }
    if (paramGetImgUrlRsp.bytes_down_domain.has())
    {
      paramC2CPicDownReq = new ServerAddr();
      paramC2CPicDownReq.mIp = paramGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
      paramC2CPicDownReq.port = 80;
      paramPicDownResp.mIpList.add(paramC2CPicDownReq);
      paramPicDownResp.domain = paramC2CPicDownReq.mIp;
    }
    if (paramGetImgUrlRsp.uint32_https_url_flag.has()) {
      paramPicDownResp.protocolType = paramGetImgUrlRsp.uint32_https_url_flag.get();
    }
  }
  
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x352.ReqBody paramReqBody)
  {
    RichProto.RichProtoReq.C2CPicDownReq localC2CPicDownReq = (RichProto.RichProtoReq.C2CPicDownReq)paramReqCommon;
    cmd0x352.GetImgUrlReq localGetImgUrlReq = new cmd0x352.GetImgUrlReq();
    paramInt = 1;
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_src_uin.set(Long.valueOf(localC2CPicDownReq.peerUin).longValue());
    localGetImgUrlReq.uint32_pic_up_timestamp.set(localC2CPicDownReq.msgTime);
    try
    {
      String str = localC2CPicDownReq.selfUin;
      paramReqCommon = str;
      if (str.startsWith("+")) {
        paramReqCommon = str.substring(1);
      }
      long l = Long.valueOf(paramReqCommon).longValue();
      localGetImgUrlReq.uint64_dst_uin.set(l);
    }
    catch (Exception paramReqCommon)
    {
      paramReqCommon.printStackTrace();
    }
    try
    {
      paramReqCommon = localC2CPicDownReq.uuid.getBytes("utf-8");
    }
    catch (UnsupportedEncodingException paramReqCommon)
    {
      paramReqCommon.printStackTrace();
      paramReqCommon = null;
    }
    localGetImgUrlReq.bytes_file_resid.set(ByteStringMicro.copyFrom(paramReqCommon));
    localGetImgUrlReq.bool_address_book.set(localC2CPicDownReq.isContact);
    if ("ftn".equals(localC2CPicDownReq.storageSource)) {
      localGetImgUrlReq.uint32_src_file_type.set(2);
    } else if ("picplatform".equals(localC2CPicDownReq.storageSource)) {
      localGetImgUrlReq.uint32_src_file_type.set(1);
    } else {
      localGetImgUrlReq.uint32_src_file_type.set(255);
    }
    localGetImgUrlReq.uint32_req_term.set(5);
    localGetImgUrlReq.bool_address_book.set(localC2CPicDownReq.isContact);
    localGetImgUrlReq.uint32_req_platform_type.set(9);
    localGetImgUrlReq.uint32_bu_type.set(1);
    int j = localC2CPicDownReq.fileType;
    int i = 0;
    if (j == 65537)
    {
      i = 4;
    }
    else if (j == 1)
    {
      i = 6;
      paramInt = 8;
    }
    else if (j == 131075)
    {
      i = 16;
      paramInt = 2;
    }
    else
    {
      paramInt = 0;
    }
    localGetImgUrlReq.uint32_url_type.set(i);
    localGetImgUrlReq.uint32_url_flag.set(paramInt);
    localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    localGetImgUrlReq.uint32_req_transfer_type.set(localC2CPicDownReq.protocolType);
    paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    cmd0x352.ReqBody localReqBody = new cmd0x352.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
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
  
  /* Error */
  protected boolean handleSucResponse(com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, com.tencent.mobileqq.app.StatictisInfo paramStatictisInfo)
  {
    // Byte code:
    //   0: ldc2_w 355
    //   3: lstore 11
    //   5: lload 11
    //   7: lstore 9
    //   9: new 358	tencent/im/cs/cmd0x352/cmd0x352$RspBody
    //   12: dup
    //   13: invokespecial 359	tencent/im/cs/cmd0x352/cmd0x352$RspBody:<init>	()V
    //   16: aload 4
    //   18: invokevirtual 363	tencent/im/cs/cmd0x352/cmd0x352$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   21: checkcast 358	tencent/im/cs/cmd0x352/cmd0x352$RspBody
    //   24: getfield 366	tencent/im/cs/cmd0x352/cmd0x352$RspBody:rpt_msg_getimg_url_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   27: invokevirtual 116	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +381 -> 413
    //   35: lload 11
    //   37: lstore 9
    //   39: aload_1
    //   40: invokeinterface 72 1 0
    //   45: ifeq +368 -> 413
    //   48: lload 11
    //   50: lstore 9
    //   52: aload_1
    //   53: invokeinterface 370 1 0
    //   58: astore 15
    //   60: lload 11
    //   62: lstore 9
    //   64: aload 15
    //   66: invokeinterface 375 1 0
    //   71: ifeq +427 -> 498
    //   74: lload 11
    //   76: lstore 9
    //   78: aload 15
    //   80: invokeinterface 379 1 0
    //   85: checkcast 13	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlRsp
    //   88: astore_1
    //   89: aload 6
    //   91: getfield 385	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   94: iconst_0
    //   95: invokeinterface 78 2 0
    //   100: checkcast 45	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$PicDownResp
    //   103: astore 14
    //   105: aload 5
    //   107: getfield 390	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:reqs	Ljava/util/List;
    //   110: iconst_0
    //   111: invokeinterface 78 2 0
    //   116: checkcast 37	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq
    //   119: astore 16
    //   121: aload 14
    //   123: ifnull +390 -> 513
    //   126: aload_3
    //   127: invokevirtual 396	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   130: ldc_w 398
    //   133: invokevirtual 403	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   136: istore 13
    //   138: iload 13
    //   140: ifeq +37 -> 177
    //   143: aload 14
    //   145: aload_3
    //   146: ldc_w 398
    //   149: iconst_0
    //   150: invokestatic 408	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   153: invokevirtual 412	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   156: checkcast 405	java/lang/Boolean
    //   159: invokevirtual 415	java/lang/Boolean:booleanValue	()Z
    //   162: putfield 418	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$PicDownResp:isSendByQuickHttp	Z
    //   165: goto +12 -> 177
    //   168: astore_1
    //   169: goto +5 -> 174
    //   172: astore 16
    //   174: goto +160 -> 334
    //   177: aload_1
    //   178: getfield 421	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   181: invokevirtual 144	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   184: istore 8
    //   186: iload 8
    //   188: ifne +31 -> 219
    //   191: aload_0
    //   192: aload 16
    //   194: aload_1
    //   195: aload 14
    //   197: invokespecial 423	com/tencent/mobileqq/transfile/protohandler/C2CPicDownHandler:handleResponse	(Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq;Ltencent/im/cs/cmd0x352/cmd0x352$GetImgUrlRsp;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$PicDownResp;)V
    //   200: aload_0
    //   201: iconst_0
    //   202: iconst_0
    //   203: ldc_w 425
    //   206: ldc_w 425
    //   209: aload 7
    //   211: aload 14
    //   213: invokevirtual 429	com/tencent/mobileqq/transfile/protohandler/C2CPicDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   216: goto +297 -> 513
    //   219: iload 8
    //   221: invokestatic 435	com/tencent/mobileqq/transfile/protohandler/C2CPicUpHandler:shouldRetryByRetCode	(I)Z
    //   224: istore 13
    //   226: iload 13
    //   228: ifeq +36 -> 264
    //   231: aload_0
    //   232: aload_0
    //   233: getfield 438	com/tencent/mobileqq/transfile/protohandler/C2CPicDownHandler:mReqUrlCount	I
    //   236: iconst_1
    //   237: iadd
    //   238: putfield 438	com/tencent/mobileqq/transfile/protohandler/C2CPicDownHandler:mReqUrlCount	I
    //   241: aload_0
    //   242: getfield 438	com/tencent/mobileqq/transfile/protohandler/C2CPicDownHandler:mReqUrlCount	I
    //   245: iconst_2
    //   246: if_icmpge +18 -> 264
    //   249: aload 5
    //   251: getfield 442	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:protoReqMgr	Lcom/tencent/mobileqq/transfile/api/IProtoReqManager;
    //   254: astore_1
    //   255: aload_1
    //   256: aload_2
    //   257: invokeinterface 448 2 0
    //   262: iconst_0
    //   263: ireturn
    //   264: iload 8
    //   266: sipush 201
    //   269: if_icmpne +23 -> 292
    //   272: invokestatic 453	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifne +6 -> 281
    //   278: goto +14 -> 292
    //   281: ldc_w 455
    //   284: aload 16
    //   286: getfield 237	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:uuid	Ljava/lang/String;
    //   289: invokestatic 461	com/tencent/mobileqq/statistics/RichMediaBugReport:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: iload 8
    //   294: i2l
    //   295: lstore 9
    //   297: aload_0
    //   298: iconst_m1
    //   299: sipush -9527
    //   302: lload 9
    //   304: invokestatic 466	com/tencent/mobileqq/transfile/report/ProcessorReport:getUrlReason	(J)Ljava/lang/String;
    //   307: lload 9
    //   309: invokestatic 466	com/tencent/mobileqq/transfile/report/ProcessorReport:getUrlReason	(J)Ljava/lang/String;
    //   312: aload 7
    //   314: aload 14
    //   316: invokevirtual 429	com/tencent/mobileqq/transfile/protohandler/C2CPicDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   319: goto +194 -> 513
    //   322: astore_1
    //   323: goto +4 -> 327
    //   326: astore_1
    //   327: goto +7 -> 334
    //   330: astore_1
    //   331: aconst_null
    //   332: astore 14
    //   334: aload 14
    //   336: ifnull +177 -> 513
    //   339: ldc_w 468
    //   342: ldc2_w 355
    //   345: invokestatic 472	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   348: astore 16
    //   350: new 474	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 475	java/lang/StringBuilder:<init>	()V
    //   357: astore 17
    //   359: aload 17
    //   361: aload_1
    //   362: invokevirtual 478	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   365: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 17
    //   371: ldc_w 484
    //   374: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: pop
    //   378: aload 17
    //   380: aload 4
    //   382: invokestatic 490	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   385: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 17
    //   391: invokevirtual 493	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: astore_1
    //   395: aload_0
    //   396: iconst_m1
    //   397: sipush -9527
    //   400: aload 16
    //   402: aload_1
    //   403: aload 7
    //   405: aload 14
    //   407: invokevirtual 429	com/tencent/mobileqq/transfile/protohandler/C2CPicDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   410: goto +103 -> 513
    //   413: new 172	java/lang/Exception
    //   416: dup
    //   417: ldc_w 495
    //   420: invokespecial 498	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   423: athrow
    //   424: ldc2_w 355
    //   427: lstore 9
    //   429: astore_1
    //   430: goto +4 -> 434
    //   433: astore_1
    //   434: ldc_w 468
    //   437: lload 9
    //   439: invokestatic 472	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   442: astore_2
    //   443: new 474	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 475	java/lang/StringBuilder:<init>	()V
    //   450: astore_3
    //   451: aload_3
    //   452: aload_1
    //   453: invokevirtual 478	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   456: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload_3
    //   461: ldc_w 484
    //   464: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload_3
    //   469: aload 4
    //   471: invokestatic 490	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   474: invokevirtual 482	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: aload_0
    //   479: iconst_m1
    //   480: sipush -9527
    //   483: aload_2
    //   484: aload_3
    //   485: invokevirtual 493	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: aload 7
    //   490: aload 6
    //   492: getfield 385	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   495: invokevirtual 501	com/tencent/mobileqq/transfile/protohandler/C2CPicDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   498: iconst_1
    //   499: ireturn
    //   500: astore_1
    //   501: goto -174 -> 327
    //   504: astore_1
    //   505: ldc2_w 355
    //   508: lstore 9
    //   510: goto -76 -> 434
    //   513: ldc2_w 355
    //   516: lstore 11
    //   518: goto -458 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	C2CPicDownHandler
    //   0	521	1	paramProtoResp	com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp
    //   0	521	2	paramProtoReq	ProtoReqManagerImpl.ProtoReq
    //   0	521	3	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	521	4	paramArrayOfByte	byte[]
    //   0	521	5	paramRichProtoReq	RichProto.RichProtoReq
    //   0	521	6	paramRichProtoResp	RichProto.RichProtoResp
    //   0	521	7	paramStatictisInfo	com.tencent.mobileqq.app.StatictisInfo
    //   7	70	9	l1	long
    //   3	72	11	l2	long
    //   136	3	13	bool	boolean
    //   103	41	14	localPicDownResp	RichProto.RichProtoResp.PicDownResp
    //   58	21	15	localIterator	java.util.Iterator
    //   119	1	16	localC2CPicDownReq	RichProto.RichProtoReq.C2CPicDownReq
    // Exception table:
    //   from	to	target	type
    //   143	165	168	java/lang/Exception
    //   200	216	322	java/lang/Exception
    //   219	226	322	java/lang/Exception
    //   255	262	322	java/lang/Exception
    //   272	278	322	java/lang/Exception
    //   281	292	322	java/lang/Exception
    //   297	319	322	java/lang/Exception
    //   105	121	326	java/lang/Exception
    //   126	138	326	java/lang/Exception
    //   177	186	326	java/lang/Exception
    //   191	200	326	java/lang/Exception
    //   89	105	330	java/lang/Exception
    //   395	410	424	java/lang/Exception
    //   413	424	424	java/lang/Exception
    //   9	31	433	java/lang/Exception
    //   39	48	433	java/lang/Exception
    //   52	60	433	java/lang/Exception
    //   64	74	433	java/lang/Exception
    //   78	89	433	java/lang/Exception
    //   231	255	500	java/lang/Exception
    //   339	395	504	java/lang/Exception
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.PicDownResp localPicDownResp = new RichProto.RichProtoResp.PicDownResp();
      localRichProtoResp.resps.add(i, localPicDownResp);
      i += 1;
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "LongConn.OffPicDown";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPicDownHandler
 * JD-Core Version:    0.7.0.1
 */