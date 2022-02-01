package com.tencent.mobileqq.transfile.protohandler;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.GeneralConfigUtils;
import com.tencent.mobileqq.statistics.RichMediaBugReport;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlRsp;
import tencent.im.cs.cmd0x352.cmd0x352.IPv6Info;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.RspBody;

public class C2CPicDownHandler
  extends PicDownHandler
{
  private void handleResponse(RichProto.RichProtoReq.C2CPicDownReq paramC2CPicDownReq, cmd0x352.GetImgUrlRsp paramGetImgUrlRsp, RichProto.RichProtoResp.PicDownResp paramPicDownResp)
  {
    int j = 0;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (GeneralConfigUtils.a())
    {
      localObject1 = paramGetImgUrlRsp.bytes_big_thumb_down_para.get();
      localObject2 = paramGetImgUrlRsp.bytes_original_down_para.get();
      localObject3 = paramGetImgUrlRsp.bytes_big_down_para.get();
      if (localObject1 != null) {
        break label234;
      }
      localObject1 = null;
      label44:
      if (localObject2 != null) {
        break label244;
      }
      localObject2 = null;
      label52:
      if (localObject3 != null) {
        break label254;
      }
      localObject3 = null;
      label60:
      if (paramC2CPicDownReq.fileType != 65537) {
        break label264;
      }
    }
    for (;;)
    {
      label69:
      paramPicDownResp.urlPath = ((String)localObject1);
      int i;
      if ((paramGetImgUrlRsp.rpt_uint32_down_ip.has()) && (paramGetImgUrlRsp.rpt_uint32_down_ip.size() > 0) && (paramGetImgUrlRsp.rpt_uint32_down_port.has()) && (paramGetImgUrlRsp.rpt_uint32_down_port.size() > 0))
      {
        paramC2CPicDownReq = paramGetImgUrlRsp.rpt_uint32_down_ip.get();
        localObject1 = paramGetImgUrlRsp.rpt_uint32_down_port.get();
        i = 0;
        for (;;)
        {
          if (i < paramC2CPicDownReq.size())
          {
            localObject2 = new ServerAddr();
            ((ServerAddr)localObject2).mIp = PkgTools.int2IPNet(((Integer)paramC2CPicDownReq.get(i)).intValue() & 0xFFFFFFFF);
            ((ServerAddr)localObject2).port = ((Integer)((List)localObject1).get(i)).intValue();
            paramPicDownResp.mIpList.add(i, localObject2);
            i += 1;
            continue;
            localObject1 = paramGetImgUrlRsp.bytes_thumb_down_para.get();
            break;
            label234:
            localObject1 = ((ByteStringMicro)localObject1).toStringUtf8();
            break label44;
            label244:
            localObject2 = ((ByteStringMicro)localObject2).toStringUtf8();
            break label52;
            label254:
            localObject3 = ((ByteStringMicro)localObject3).toStringUtf8();
            break label60;
            label264:
            localObject1 = localObject3;
            if (paramC2CPicDownReq.fileType == 1) {
              break label69;
            }
            if (paramC2CPicDownReq.fileType != 131075) {
              break label500;
            }
            localObject1 = localObject2;
            break label69;
          }
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
      return;
      label500:
      localObject1 = null;
    }
  }
  
  /* Error */
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x352.ReqBody paramReqBody)
  {
    // Byte code:
    //   0: bipush 16
    //   2: istore 4
    //   4: aload_2
    //   5: checkcast 37	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq
    //   8: astore 8
    //   10: new 184	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq
    //   13: dup
    //   14: invokespecial 185	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:<init>	()V
    //   17: astore 9
    //   19: aload 9
    //   21: iconst_1
    //   22: invokevirtual 189	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:setHasFlag	(Z)V
    //   25: aload 9
    //   27: getfield 193	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_src_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   30: aload 8
    //   32: getfield 196	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:peerUin	Ljava/lang/String;
    //   35: invokestatic 202	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   38: invokevirtual 206	java/lang/Long:longValue	()J
    //   41: invokevirtual 212	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   44: aload 9
    //   46: getfield 215	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_pic_up_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   49: aload 8
    //   51: getfield 218	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:msgTime	I
    //   54: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   57: aload 8
    //   59: getfield 224	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:selfUin	Ljava/lang/String;
    //   62: astore 7
    //   64: aload 7
    //   66: astore_2
    //   67: aload 7
    //   69: ldc 226
    //   71: invokevirtual 232	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: ifeq +10 -> 84
    //   77: aload 7
    //   79: iconst_1
    //   80: invokevirtual 236	java/lang/String:substring	(I)Ljava/lang/String;
    //   83: astore_2
    //   84: aload_2
    //   85: invokestatic 202	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   88: invokevirtual 206	java/lang/Long:longValue	()J
    //   91: lstore 5
    //   93: aload 9
    //   95: getfield 239	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint64_dst_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   98: lload 5
    //   100: invokevirtual 212	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   103: aload 8
    //   105: getfield 242	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:uuid	Ljava/lang/String;
    //   108: ldc 244
    //   110: invokevirtual 248	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   113: astore_2
    //   114: aload 9
    //   116: getfield 251	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_file_resid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   119: aload_2
    //   120: invokestatic 255	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   123: invokevirtual 258	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   126: aload 9
    //   128: getfield 262	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   131: aload 8
    //   133: getfield 265	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:isContact	Z
    //   136: invokevirtual 269	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   139: ldc_w 271
    //   142: aload 8
    //   144: getfield 274	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:storageSource	Ljava/lang/String;
    //   147: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: ifeq +151 -> 301
    //   153: aload 9
    //   155: getfield 280	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   158: iconst_2
    //   159: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   162: aload 9
    //   164: getfield 283	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_term	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   167: iconst_5
    //   168: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   171: aload 9
    //   173: getfield 262	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bool_address_book	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   176: aload 8
    //   178: getfield 265	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:isContact	Z
    //   181: invokevirtual 269	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   184: aload 9
    //   186: getfield 286	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_platform_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   189: bipush 9
    //   191: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   194: aload 9
    //   196: getfield 289	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_bu_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   199: iconst_1
    //   200: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   203: aload 8
    //   205: getfield 41	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:fileType	I
    //   208: istore_1
    //   209: iload_1
    //   210: ldc 42
    //   212: if_icmpne +137 -> 349
    //   215: invokestatic 17	com/tencent/mobileqq/statistics/GeneralConfigUtils:a	()Z
    //   218: ifeq +123 -> 341
    //   221: bipush 16
    //   223: istore_1
    //   224: iconst_4
    //   225: istore 4
    //   227: aload 9
    //   229: getfield 292	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: iload 4
    //   234: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   237: aload 9
    //   239: getfield 295	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_url_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   242: iload_1
    //   243: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   246: aload 9
    //   248: getfield 298	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:bytes_build_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   251: invokestatic 303	com/tencent/mobileqq/transfile/TransFileUtil:getVersionCode	()Ljava/lang/String;
    //   254: invokestatic 307	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 258	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   260: aload 9
    //   262: getfield 310	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_req_transfer_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   265: aload 8
    //   267: getfield 311	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:protocolType	I
    //   270: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   273: aload_3
    //   274: getfield 316	tencent/im/cs/cmd0x352/cmd0x352$ReqBody:rpt_msg_getimg_url_req	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   277: aload 9
    //   279: invokevirtual 319	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   282: return
    //   283: astore_2
    //   284: aload_2
    //   285: invokevirtual 322	java/lang/Exception:printStackTrace	()V
    //   288: goto -185 -> 103
    //   291: astore_2
    //   292: aload_2
    //   293: invokevirtual 323	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   296: aconst_null
    //   297: astore_2
    //   298: goto -184 -> 114
    //   301: ldc_w 325
    //   304: aload 8
    //   306: getfield 274	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$C2CPicDownReq:storageSource	Ljava/lang/String;
    //   309: invokevirtual 277	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   312: ifeq +15 -> 327
    //   315: aload 9
    //   317: getfield 280	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   320: iconst_1
    //   321: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   324: goto -162 -> 162
    //   327: aload 9
    //   329: getfield 280	tencent/im/cs/cmd0x352/cmd0x352$GetImgUrlReq:uint32_src_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   332: sipush 255
    //   335: invokevirtual 221	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   338: goto -176 -> 162
    //   341: iconst_1
    //   342: istore_1
    //   343: iconst_4
    //   344: istore 4
    //   346: goto -119 -> 227
    //   349: iload_1
    //   350: iconst_1
    //   351: if_icmpne +13 -> 364
    //   354: bipush 6
    //   356: istore 4
    //   358: bipush 8
    //   360: istore_1
    //   361: goto -134 -> 227
    //   364: iload_1
    //   365: ldc 115
    //   367: if_icmpne +8 -> 375
    //   370: iconst_2
    //   371: istore_1
    //   372: goto -145 -> 227
    //   375: iconst_0
    //   376: istore_1
    //   377: iconst_0
    //   378: istore 4
    //   380: goto -153 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	C2CPicDownHandler
    //   0	383	1	paramInt	int
    //   0	383	2	paramReqCommon	RichProto.RichProtoReq.ReqCommon
    //   0	383	3	paramReqBody	cmd0x352.ReqBody
    //   2	377	4	i	int
    //   91	8	5	l	long
    //   62	16	7	str	String
    //   8	297	8	localC2CPicDownReq	RichProto.RichProtoReq.C2CPicDownReq
    //   17	311	9	localGetImgUrlReq	tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlReq
    // Exception table:
    //   from	to	target	type
    //   57	64	283	java/lang/Exception
    //   67	84	283	java/lang/Exception
    //   84	103	283	java/lang/Exception
    //   103	114	291	java/io/UnsupportedEncodingException
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
    switch (NetworkCenter.getInstance().getNetType())
    {
    default: 
      i = 6;
    }
    for (;;)
    {
      paramList = NetworkCenter.getInstance().getApnType();
      int j = i;
      if (paramList != null)
      {
        j = i;
        if (paramList.contains("wap")) {
          j = 5;
        }
      }
      localReqBody.uint32_net_type.set(j);
      return localReqBody.toByteArray();
      i = 3;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
    }
  }
  
  protected boolean handleSucResponse(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp, StatictisInfo paramStatictisInfo)
  {
    try
    {
      paramProtoResp = ((cmd0x352.RspBody)new cmd0x352.RspBody().mergeFrom(paramArrayOfByte)).rpt_msg_getimg_url_rsp.get();
      if ((paramProtoResp != null) && (paramProtoResp.size() != 0)) {
        break label104;
      }
      throw new Exception("resps null");
    }
    catch (Exception paramProtoResp)
    {
      setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramStatictisInfo, paramRichProtoResp.resps);
    }
    return true;
    label104:
    Iterator localIterator = paramProtoResp.iterator();
    label112:
    while (localIterator.hasNext())
    {
      paramProtoResp = (cmd0x352.GetImgUrlRsp)localIterator.next();
      try
      {
        localPicDownResp = (RichProto.RichProtoResp.PicDownResp)paramRichProtoResp.resps.get(0);
        try
        {
          localC2CPicDownReq = (RichProto.RichProtoReq.C2CPicDownReq)paramRichProtoReq.reqs.get(0);
          if (localPicDownResp == null) {
            continue;
          }
          if (paramFromServiceMsg.getAttributes().containsKey("_attr_send_by_quickHttp")) {
            localPicDownResp.isSendByQuickHttp = ((Boolean)paramFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
          }
          i = paramProtoResp.uint32_result.get();
          if (i != 0) {
            break label308;
          }
          handleResponse(localC2CPicDownReq, paramProtoResp, localPicDownResp);
          setResult(0, 0, "", "", paramStatictisInfo, localPicDownResp);
        }
        catch (Exception paramProtoResp) {}
      }
      catch (Exception paramProtoResp)
      {
        for (;;)
        {
          RichProto.RichProtoReq.C2CPicDownReq localC2CPicDownReq;
          int i;
          RichProto.RichProtoResp.PicDownResp localPicDownResp = null;
        }
      }
      if (localPicDownResp != null)
      {
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(paramArrayOfByte), paramStatictisInfo, localPicDownResp);
        continue;
        if (C2CPicUpHandler.shouldRetryByRetCode(i))
        {
          this.mReqUrlCount += 1;
          if (this.mReqUrlCount < 2)
          {
            paramRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
            return false;
          }
        }
        if ((i == 201) && (QLog.isColorLevel())) {
          break label388;
        }
      }
    }
    for (;;)
    {
      label308:
      setResult(-1, -9527, BaseTransProcessor.getUrlReason(i), BaseTransProcessor.getUrlReason(i), paramStatictisInfo, localPicDownResp);
      break label112;
      break;
      label388:
      RichMediaBugReport.a("Download_C2C_Pic_Request_Error_Param_Check", localC2CPicDownReq.uuid);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.C2CPicDownHandler
 * JD-Core Version:    0.7.0.1
 */