package com.tencent.mobileqq.transfile.protohandler;

import anza;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ProtoReqManager;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoReq;
import com.tencent.mobileqq.transfile.ProtoReqManager.ProtoResp;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x388.cmd0x388.ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388.RspBody;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttReq;
import tencent.im.cs.cmd0x388.cmd0x388.TryUpPttRsp;

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
    PBUInt32Field localPBUInt32Field = localTryUpPttReq.uint32_bu_type;
    if (paramReqCommon.uinType == 1) {}
    for (paramInt = 3;; paramInt = 4)
    {
      localPBUInt32Field.set(paramInt);
      localTryUpPttReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(RichMediaUtil.getVersionCode()));
      localTryUpPttReq.uint32_voice_length.set(paramReqCommon.voiceLength);
      localTryUpPttReq.uint32_codec.set(paramReqCommon.voiceType);
      localTryUpPttReq.uint32_voice_type.set(paramReqCommon.audioPanelType);
      localTryUpPttReq.bool_new_up_chan.set(true);
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "GroupPttUp: panel[" + paramReqCommon.audioPanelType + "] type[" + paramReqCommon.voiceType + "] length[" + paramReqCommon.voiceLength + "] size[" + paramReqCommon.fileSize + "]");
      }
      paramReqBody.rpt_msg_tryup_ptt_req.add(localTryUpPttReq);
      return;
    }
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
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "GroupPttUp: net[" + i + "]");
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
  
  public void onProtoResp(ProtoReqManager.ProtoResp paramProtoResp, ProtoReqManager.ProtoReq paramProtoReq)
  {
    FromServiceMsg localFromServiceMsg = paramProtoResp.resp;
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    anza localanza = paramProtoResp.statisInfo;
    int i;
    if (localFromServiceMsg.getResultCode() != 1000)
    {
      i = localFromServiceMsg.getResultCode();
      if ((i == 1002) || (i == 1013))
      {
        localObject1 = MessageHandler.a(localFromServiceMsg);
        paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
        paramProtoResp = paramProtoReq;
        if (paramProtoReq == null) {
          paramProtoResp = "";
        }
        setResult(-1, 9311, (String)localObject1, paramProtoResp, localanza, localRichProtoResp.resps);
      }
    }
    for (;;)
    {
      RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      return;
      localObject1 = MessageHandler.a(localFromServiceMsg);
      paramProtoReq = localFromServiceMsg.getBusinessFailMsg();
      paramProtoResp = paramProtoReq;
      if (paramProtoReq == null) {
        paramProtoResp = "";
      }
      setResult(-1, 9044, (String)localObject1, paramProtoResp, localanza, localRichProtoResp.resps);
      continue;
      try
      {
        paramProtoResp = ((cmd0x388.RspBody)new cmd0x388.RspBody().mergeFrom(arrayOfByte)).rpt_msg_tryup_ptt_rsp.get();
        if ((paramProtoResp != null) && (paramProtoResp.size() != 0)) {
          break label266;
        }
        throw new Exception("resps null");
      }
      catch (Exception paramProtoResp)
      {
        setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localanza, localRichProtoResp.resps);
      }
      continue;
      label266:
      Iterator localIterator = paramProtoResp.iterator();
      while (localIterator.hasNext())
      {
        paramProtoResp = (cmd0x388.TryUpPttRsp)localIterator.next();
        for (;;)
        {
          try
          {
            for (;;)
            {
              localObject1 = (RichProto.RichProtoResp.GroupPttUpResp)localRichProtoResp.resps.get((int)paramProtoResp.uint64_file_id.get());
              try
              {
                ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).isSendByQuickHttp = ((Boolean)localFromServiceMsg.getAttribute("_attr_send_by_quickHttp", Boolean.valueOf(false))).booleanValue();
                if (QLog.isColorLevel()) {
                  QLog.e("http_sideway", 2, "GroupPttUpHandler.onProtoResp:isSendByQuickHttp=" + ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).isSendByQuickHttp);
                }
                i = paramProtoResp.uint32_result.get();
                if (i != 0) {
                  break label750;
                }
                ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).groupFileID = paramProtoResp.uint64_fileid.get();
                if (paramProtoResp.bytes_file_key.has()) {
                  ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).groupFileKey = paramProtoResp.bytes_file_key.get().toByteArray();
                }
                if ((!paramProtoResp.bool_file_exit.has()) || (!paramProtoResp.bool_file_exit.get())) {
                  break label528;
                }
                ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).isExist = true;
                setResult(0, 0, "", "", localanza, (RichProto.RichProtoResp.RespCommon)localObject1);
              }
              catch (Exception paramProtoResp) {}
            }
          }
          catch (Exception paramProtoResp)
          {
            label528:
            List localList;
            Object localObject2;
            long l1;
            long l2;
            ServerAddr localServerAddr;
            localObject1 = null;
            continue;
          }
          setResult(-1, -9527, BaseTransProcessor.getServerReason("P", -9529L), paramProtoResp.getMessage() + " hex:" + HexUtil.bytes2HexStr(arrayOfByte), localanza, (RichProto.RichProtoResp.RespCommon)localObject1);
          break;
          localList = paramProtoResp.rpt_uint32_up_ip.get();
          localObject2 = paramProtoResp.rpt_uint32_up_port.get();
          if ((localList != null) && (localList.size() > 0))
          {
            i = 0;
            if (i < localList.size())
            {
              l1 = ((Integer)localList.get(i)).intValue();
              l2 = ((Integer)((List)localObject2).get(i)).intValue();
              localServerAddr = new ServerAddr();
              localServerAddr.mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
              localServerAddr.port = ((int)l2);
              ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).ipList.add(i, localServerAddr);
              i += 1;
              continue;
            }
          }
          localObject2 = HexUtil.bytes2HexStr(paramProtoResp.bytes_up_ukey.get().toByteArray());
          if ((localObject2 == null) || (((String)localObject2).equals("")) || (localList == null) || (localList.size() == 0)) {
            throw new Exception("check ukey,iplist");
          }
          ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).mUkey = ((String)localObject2);
          ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).blockSize = ((int)paramProtoResp.uint64_block_size.get());
          ((RichProto.RichProtoResp.GroupPttUpResp)localObject1).transferedSize = ((int)paramProtoResp.uint64_up_offset.get());
        }
        label750:
        if (GroupPicUpHandler.shouldRetryByRetCode(i))
        {
          this.mReqUrlCount += 1;
          if (this.mReqUrlCount < 2)
          {
            localRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
            return;
          }
        }
        setResult(-1, -9527, BaseTransProcessor.getUrlReason(i), "", localanza, (RichProto.RichProtoResp.RespCommon)localObject1);
      }
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManager.ProtoReq localProtoReq = new ProtoReqManager.ProtoReq();
      localProtoReq.ssoCmd = "PttStore.GroupPttUp";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.GroupPttUpHandler
 * JD-Core Version:    0.7.0.1
 */