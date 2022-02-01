package com.tencent.mobileqq.transfile.protohandler;

import com.tencent.mobileqq.pb.ByteStringMicro;
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
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.GetImgUrlReq;
import tencent.im.cs.cmd0x388.cmd0x388.GetImgUrlRsp;
import tencent.im.cs.cmd0x388.cmd0x388.IPv6Info;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;

public class GuildPicDownHandler
  extends PicDownHandler
{
  private static final String TAG = "GuildPicDownHandler.<gld>";
  
  private String fileType2LogStr(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 65537)
      {
        if (paramInt != 131075)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("UNKNOWN");
          localStringBuilder.append(paramInt);
          return localStringBuilder.toString();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("IMG_RAW");
        localStringBuilder.append(paramInt);
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("THUMB");
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BIG_COMPRESS");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void handleResponse(RichProto.RichProtoReq.GuildPicDownReq paramGuildPicDownReq, cmd0x388.GetImgUrlRsp paramGetImgUrlRsp, RichProto.RichProtoResp.PicDownResp paramPicDownResp)
  {
    Object localObject1;
    if (paramGuildPicDownReq.fileType == 65537) {
      localObject1 = paramGetImgUrlRsp.bytes_thumb_down_para.get().toStringUtf8();
    } else if (paramGuildPicDownReq.fileType == 1) {
      localObject1 = paramGetImgUrlRsp.bytes_big_down_para.get().toStringUtf8();
    } else if (paramGuildPicDownReq.fileType == 131075) {
      localObject1 = paramGetImgUrlRsp.bytes_original_down_para.get().toStringUtf8();
    } else {
      localObject1 = null;
    }
    paramPicDownResp.urlPath = ((String)localObject1);
    boolean bool = paramGetImgUrlRsp.rpt_uint32_down_ip.has();
    int j = 0;
    Object localObject2;
    int i;
    if ((bool) && (paramGetImgUrlRsp.rpt_uint32_down_ip.size() > 0) && (paramGetImgUrlRsp.rpt_uint32_down_port.has()) && (paramGetImgUrlRsp.rpt_uint32_down_port.size() > 0))
    {
      localObject1 = paramGetImgUrlRsp.rpt_uint32_down_ip.get();
      localObject2 = paramGetImgUrlRsp.rpt_uint32_down_port.get();
      i = 0;
      while (i < ((List)localObject1).size())
      {
        ServerAddr localServerAddr = new ServerAddr();
        localServerAddr.mIp = PkgTools.int2IPNet(((Integer)((List)localObject1).get(i)).intValue() & 0xFFFFFFFF);
        localServerAddr.port = ((Integer)((List)localObject2).get(i)).intValue();
        paramPicDownResp.mIpList.add(i, localServerAddr);
        i += 1;
      }
    }
    if ((paramGetImgUrlRsp.rpt_msg_down_ip6.has()) && (paramGetImgUrlRsp.rpt_msg_down_ip6.size() > 0))
    {
      localObject1 = paramGetImgUrlRsp.rpt_msg_down_ip6.get();
      i = j;
      while (i < ((List)localObject1).size())
      {
        localObject2 = new ServerAddr();
        ((ServerAddr)localObject2).mIp = Inet6Address.getByAddress(((cmd0x388.IPv6Info)((List)localObject1).get(i)).bytes_ip6.get().toByteArray()).getHostAddress();
        ((ServerAddr)localObject2).port = ((cmd0x388.IPv6Info)((List)localObject1).get(i)).uint32_port.get();
        ((ServerAddr)localObject2).isIpv6 = true;
        paramPicDownResp.mIpv6List.add(i, localObject2);
        i += 1;
      }
    }
    if (paramGetImgUrlRsp.bytes_down_domain.has())
    {
      localObject1 = new ServerAddr();
      ((ServerAddr)localObject1).mIp = paramGetImgUrlRsp.bytes_down_domain.get().toStringUtf8();
      ((ServerAddr)localObject1).port = 80;
      paramPicDownResp.mIpList.add(localObject1);
      paramPicDownResp.domain = ((ServerAddr)localObject1).mIp;
    }
    if (paramGetImgUrlRsp.uint32_https_url_flag.has()) {
      paramPicDownResp.protocolType = paramGetImgUrlRsp.uint32_https_url_flag.get();
    }
    paramGetImgUrlRsp = new StringBuilder();
    paramGetImgUrlRsp.append("step:handleSucResponse urlPath:");
    paramGetImgUrlRsp.append(paramPicDownResp.urlPath);
    paramGetImgUrlRsp.append(" type:");
    paramGetImgUrlRsp.append(fileType2LogStr(paramGuildPicDownReq.fileType));
    QLog.i("GuildPicDownHandler.<gld>", 1, paramGetImgUrlRsp.toString());
  }
  
  void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, cmd0x388.ReqBody paramReqBody)
  {
    paramReqCommon = (RichProto.RichProtoReq.GuildPicDownReq)paramReqCommon;
    cmd0x388.GetImgUrlReq localGetImgUrlReq = new cmd0x388.GetImgUrlReq();
    localGetImgUrlReq.setHasFlag(true);
    localGetImgUrlReq.uint64_file_id.set(paramInt);
    paramInt = 2;
    try
    {
      localGetImgUrlReq.uint64_dst_uin.set(Long.parseLong(paramReqCommon.selfUin));
      localGetImgUrlReq.uint64_qqmeet_channel_id.set(Long.parseLong(paramReqCommon.peerUin));
      localGetImgUrlReq.uint64_qqmeet_guild_id.set(Long.parseLong(paramReqCommon.secondUin));
      localGetImgUrlReq.bytes_download_index.set(ByteStringMicro.copyFrom(paramReqCommon.index));
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addOne: Exception = ");
      localStringBuilder.append(localException);
      QLog.d("GuildPicDownHandler.<gld>", 2, localStringBuilder.toString());
    }
    localGetImgUrlReq.uint64_group_code.set(Long.parseLong(paramReqCommon.peerUin));
    localGetImgUrlReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramReqCommon.md5));
    localGetImgUrlReq.uint32_pic_up_timestamp.set(paramReqCommon.msgTime);
    if (paramReqCommon.groupFileID != 0L) {
      localGetImgUrlReq.uint64_fileid.set(paramReqCommon.groupFileID);
    }
    if (paramReqCommon.fileType == 65537)
    {
      localGetImgUrlReq.uint32_url_flag.set(4);
    }
    else if (paramReqCommon.fileType == 1)
    {
      localGetImgUrlReq.uint32_url_flag.set(8);
      localGetImgUrlReq.uint32_url_type.set(3);
    }
    else if (paramReqCommon.fileType == 131075)
    {
      localGetImgUrlReq.uint32_url_flag.set(2);
      localGetImgUrlReq.uint32_url_type.set(4);
    }
    localGetImgUrlReq.uint32_req_platform_type.set(9);
    localGetImgUrlReq.uint32_req_term.set(5);
    localGetImgUrlReq.uint32_inner_ip.set(0);
    PBUInt32Field localPBUInt32Field = localGetImgUrlReq.uint32_bu_type;
    if (paramReqCommon.uinType == 10014) {
      paramInt = 211;
    }
    localPBUInt32Field.set(paramInt);
    localGetImgUrlReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    localGetImgUrlReq.uint32_req_transfer_type.set(paramReqCommon.protocolType);
    paramReqBody.rpt_msg_getimg_url_req.add(localGetImgUrlReq);
    paramReqBody = new StringBuilder();
    paramReqBody.append("step:GetImgUrlReq index:");
    paramReqBody.append(localGetImgUrlReq.bytes_download_index.get().toStringUtf8());
    paramReqBody.append(" fileType:");
    paramReqBody.append(fileType2LogStr(paramReqCommon.fileType));
    QLog.i("GuildPicDownHandler.<gld>", 1, paramReqBody.toString());
  }
  
  byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    cmd0x388.ReqBody localReqBody = new cmd0x388.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.uint32_subcmd.set(2);
    localReqBody.uint32_command_id.set(83);
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
          break label111;
        }
        if (j == 4) {}
      }
      else
      {
        i = 6;
        break label114;
      }
      i = 8;
      break label114;
      label111:
      i = 7;
    }
    label114:
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
    //   0: ldc2_w 390
    //   3: lstore 11
    //   5: lload 11
    //   7: lstore 9
    //   9: new 393	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   12: dup
    //   13: invokespecial 394	tencent/im/cs/cmd0x388/cmd0x388$RspBody:<init>	()V
    //   16: aload 4
    //   18: invokevirtual 398	tencent/im/cs/cmd0x388/cmd0x388$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   21: checkcast 393	tencent/im/cs/cmd0x388/cmd0x388$RspBody
    //   24: getfield 401	tencent/im/cs/cmd0x388/cmd0x388$RspBody:rpt_msg_getimg_url_rsp	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   27: invokevirtual 142	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +359 -> 391
    //   35: lload 11
    //   37: lstore 9
    //   39: aload_1
    //   40: invokeinterface 98 1 0
    //   45: ifeq +346 -> 391
    //   48: lload 11
    //   50: lstore 9
    //   52: aload_1
    //   53: invokeinterface 405 1 0
    //   58: astore 15
    //   60: lload 11
    //   62: lstore 9
    //   64: aload 15
    //   66: invokeinterface 410 1 0
    //   71: ifeq +405 -> 476
    //   74: lload 11
    //   76: lstore 9
    //   78: aload 15
    //   80: invokeinterface 414 1 0
    //   85: checkcast 49	tencent/im/cs/cmd0x388/cmd0x388$GetImgUrlRsp
    //   88: astore_1
    //   89: aload 6
    //   91: getfield 420	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   94: aload_1
    //   95: getfield 421	tencent/im/cs/cmd0x388/cmd0x388$GetImgUrlRsp:uint64_file_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   98: invokevirtual 424	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   101: l2i
    //   102: invokeinterface 104 2 0
    //   107: checkcast 72	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$PicDownResp
    //   110: astore 14
    //   112: aload 5
    //   114: getfield 429	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:reqs	Ljava/util/List;
    //   117: iconst_0
    //   118: invokeinterface 104 2 0
    //   123: checkcast 43	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$GuildPicDownReq
    //   126: astore 16
    //   128: aload 14
    //   130: ifnull +176 -> 306
    //   133: aload_3
    //   134: invokevirtual 435	com/tencent/qphone/base/remote/FromServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   137: ldc_w 437
    //   140: invokevirtual 442	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   143: istore 13
    //   145: iload 13
    //   147: ifeq +37 -> 184
    //   150: aload 14
    //   152: aload_3
    //   153: ldc_w 437
    //   156: iconst_0
    //   157: invokestatic 448	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   160: invokevirtual 452	com/tencent/qphone/base/remote/FromServiceMsg:getAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   163: checkcast 444	java/lang/Boolean
    //   166: invokevirtual 455	java/lang/Boolean:booleanValue	()Z
    //   169: putfield 458	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$PicDownResp:isSendByQuickHttp	Z
    //   172: goto +12 -> 184
    //   175: astore_1
    //   176: goto +5 -> 181
    //   179: astore 16
    //   181: goto +136 -> 317
    //   184: aload_1
    //   185: getfield 461	tencent/im/cs/cmd0x388/cmd0x388$GetImgUrlRsp:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   188: invokevirtual 170	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   191: istore 8
    //   193: iload 8
    //   195: ifne +31 -> 226
    //   198: aload_0
    //   199: aload 16
    //   201: aload_1
    //   202: aload 14
    //   204: invokespecial 463	com/tencent/mobileqq/transfile/protohandler/GuildPicDownHandler:handleResponse	(Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq$GuildPicDownReq;Ltencent/im/cs/cmd0x388/cmd0x388$GetImgUrlRsp;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$PicDownResp;)V
    //   207: aload_0
    //   208: iconst_0
    //   209: iconst_0
    //   210: ldc_w 465
    //   213: ldc_w 465
    //   216: aload 7
    //   218: aload 14
    //   220: invokevirtual 469	com/tencent/mobileqq/transfile/protohandler/GuildPicDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   223: goto +83 -> 306
    //   226: aload_0
    //   227: iload 8
    //   229: invokevirtual 473	com/tencent/mobileqq/transfile/protohandler/GuildPicDownHandler:shouldRetryByRetCodeForGroup	(I)Z
    //   232: istore 13
    //   234: iload 13
    //   236: ifeq +36 -> 272
    //   239: aload_0
    //   240: aload_0
    //   241: getfield 476	com/tencent/mobileqq/transfile/protohandler/GuildPicDownHandler:mReqUrlCount	I
    //   244: iconst_1
    //   245: iadd
    //   246: putfield 476	com/tencent/mobileqq/transfile/protohandler/GuildPicDownHandler:mReqUrlCount	I
    //   249: aload_0
    //   250: getfield 476	com/tencent/mobileqq/transfile/protohandler/GuildPicDownHandler:mReqUrlCount	I
    //   253: iconst_2
    //   254: if_icmpge +18 -> 272
    //   257: aload 5
    //   259: getfield 480	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoReq:protoReqMgr	Lcom/tencent/mobileqq/transfile/api/IProtoReqManager;
    //   262: astore_1
    //   263: aload_1
    //   264: aload_2
    //   265: invokeinterface 486 2 0
    //   270: iconst_0
    //   271: ireturn
    //   272: iload 8
    //   274: i2l
    //   275: lstore 9
    //   277: aload_0
    //   278: iconst_m1
    //   279: sipush -9527
    //   282: lload 9
    //   284: invokestatic 491	com/tencent/mobileqq/transfile/report/ProcessorReport:getUrlReason	(J)Ljava/lang/String;
    //   287: lload 9
    //   289: invokestatic 491	com/tencent/mobileqq/transfile/report/ProcessorReport:getUrlReason	(J)Ljava/lang/String;
    //   292: aload 7
    //   294: aload 14
    //   296: invokevirtual 469	com/tencent/mobileqq/transfile/protohandler/GuildPicDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   299: goto +7 -> 306
    //   302: astore_1
    //   303: goto +7 -> 310
    //   306: goto +176 -> 482
    //   309: astore_1
    //   310: goto +7 -> 317
    //   313: astore_1
    //   314: aconst_null
    //   315: astore 14
    //   317: ldc_w 493
    //   320: ldc2_w 390
    //   323: invokestatic 497	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   326: astore 16
    //   328: new 19	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   335: astore 17
    //   337: aload 17
    //   339: aload_1
    //   340: invokevirtual 500	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   343: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 17
    //   349: ldc_w 502
    //   352: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 17
    //   358: aload 4
    //   360: invokestatic 508	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   363: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 17
    //   369: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: astore_1
    //   373: aload_0
    //   374: iconst_m1
    //   375: sipush -9527
    //   378: aload 16
    //   380: aload_1
    //   381: aload 7
    //   383: aload 14
    //   385: invokevirtual 469	com/tencent/mobileqq/transfile/protohandler/GuildPicDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Lcom/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp$RespCommon;)V
    //   388: goto +94 -> 482
    //   391: new 210	java/lang/Exception
    //   394: dup
    //   395: ldc_w 510
    //   398: invokespecial 513	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   401: athrow
    //   402: ldc2_w 390
    //   405: lstore 9
    //   407: astore_1
    //   408: goto +4 -> 412
    //   411: astore_1
    //   412: ldc_w 493
    //   415: lload 9
    //   417: invokestatic 497	com/tencent/mobileqq/transfile/report/ProcessorReport:getServerReason	(Ljava/lang/String;J)Ljava/lang/String;
    //   420: astore_2
    //   421: new 19	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   428: astore_3
    //   429: aload_3
    //   430: aload_1
    //   431: invokevirtual 500	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   434: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_3
    //   439: ldc_w 502
    //   442: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload_3
    //   447: aload 4
    //   449: invokestatic 508	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   452: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload_0
    //   457: iconst_m1
    //   458: sipush -9527
    //   461: aload_2
    //   462: aload_3
    //   463: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: aload 7
    //   468: aload 6
    //   470: getfield 420	com/tencent/mobileqq/transfile/protohandler/RichProto$RichProtoResp:resps	Ljava/util/List;
    //   473: invokevirtual 516	com/tencent/mobileqq/transfile/protohandler/GuildPicDownHandler:setResult	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/StatictisInfo;Ljava/util/List;)V
    //   476: iconst_1
    //   477: ireturn
    //   478: astore_1
    //   479: goto -169 -> 310
    //   482: ldc2_w 390
    //   485: lstore 11
    //   487: goto -427 -> 60
    //   490: astore_1
    //   491: ldc2_w 390
    //   494: lstore 9
    //   496: goto -84 -> 412
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	this	GuildPicDownHandler
    //   0	499	1	paramProtoResp	com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp
    //   0	499	2	paramProtoReq	ProtoReqManagerImpl.ProtoReq
    //   0	499	3	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	499	4	paramArrayOfByte	byte[]
    //   0	499	5	paramRichProtoReq	RichProto.RichProtoReq
    //   0	499	6	paramRichProtoResp	RichProto.RichProtoResp
    //   0	499	7	paramStatictisInfo	com.tencent.mobileqq.app.StatictisInfo
    //   7	70	9	l1	long
    //   3	72	11	l2	long
    //   143	3	13	bool	boolean
    //   110	41	14	localPicDownResp	RichProto.RichProtoResp.PicDownResp
    //   58	21	15	localIterator	java.util.Iterator
    //   126	1	16	localGuildPicDownReq	RichProto.RichProtoReq.GuildPicDownReq
    // Exception table:
    //   from	to	target	type
    //   150	172	175	java/lang/Exception
    //   207	223	302	java/lang/Exception
    //   226	234	302	java/lang/Exception
    //   263	270	302	java/lang/Exception
    //   277	299	302	java/lang/Exception
    //   112	128	309	java/lang/Exception
    //   133	145	309	java/lang/Exception
    //   184	193	309	java/lang/Exception
    //   198	207	309	java/lang/Exception
    //   89	112	313	java/lang/Exception
    //   373	388	402	java/lang/Exception
    //   391	402	402	java/lang/Exception
    //   9	31	411	java/lang/Exception
    //   39	48	411	java/lang/Exception
    //   52	60	411	java/lang/Exception
    //   64	74	411	java/lang/Exception
    //   78	89	411	java/lang/Exception
    //   239	263	478	java/lang/Exception
    //   317	373	490	java/lang/Exception
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
      localProtoReq.ssoCmd = "ImgStore.QQMeetPicDown";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GuildPicDownHandler
 * JD-Core Version:    0.7.0.1
 */