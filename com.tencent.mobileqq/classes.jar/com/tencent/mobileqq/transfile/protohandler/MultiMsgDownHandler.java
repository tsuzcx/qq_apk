package com.tencent.mobileqq.transfile.protohandler;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoResp;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.longconn.multimsg.MultiMsg.ExternMsg;
import tencent.im.longconn.multimsg.MultiMsg.MultiMsgApplyDownRsp;
import tencent.im.longconn.multimsg.MultiMsg.ReqBody;
import tencent.im.longconn.multimsg.MultiMsg.RspBody;

public class MultiMsgDownHandler
  extends BaseHandler
{
  int mReqNetType;
  
  private void addOne(int paramInt, RichProto.RichProtoReq.ReqCommon paramReqCommon, MultiMsg.ReqBody paramReqBody)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private byte[] constructReqBody(List<RichProto.RichProtoReq.ReqCommon> paramList)
  {
    int j = NetworkCenter.getInstance().getNetType();
    this.mReqNetType = j;
    int i = 3;
    if (j != 1) {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4) {
            i = 255;
          } else {
            i = 8;
          }
        }
        else {
          i = 7;
        }
      }
      else {
        i = 6;
      }
    }
    Object localObject = NetworkCenter.getInstance().getApnType();
    j = i;
    if (localObject != null)
    {
      j = i;
      if (((String)localObject).contains("wap")) {
        j = 5;
      }
    }
    localObject = new MultiMsg.ReqBody();
    ((MultiMsg.ReqBody)localObject).setHasFlag(true);
    ((MultiMsg.ReqBody)localObject).uint32_subcmd.set(2);
    ((MultiMsg.ReqBody)localObject).uint32_term_type.set(5);
    ((MultiMsg.ReqBody)localObject).uint32_platform_type.set(9);
    ((MultiMsg.ReqBody)localObject).uint32_net_type.set(j);
    ((MultiMsg.ReqBody)localObject).bytes_build_ver.set(ByteStringMicro.copyFromUtf8(TransFileUtil.getVersionCode()));
    ((MultiMsg.ReqBody)localObject).uint32_req_channel_type.set(2);
    i = 0;
    while (i < paramList.size())
    {
      addOne(i, (RichProto.RichProtoReq.ReqCommon)paramList.get(i), (MultiMsg.ReqBody)localObject);
      i += 1;
    }
    return ((MultiMsg.ReqBody)localObject).toByteArray();
  }
  
  public static List<ExcitingTransferHostInfo> getBDHServerIp(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (BaseApplicationImpl.sProcessId == 1)
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = ConfigManager.getInstance(BaseApplication.getContext(), ((QQAppInterface)localObject1).getHwEngine());
      if (localObject2 != null)
      {
        localObject2 = ((ConfigManager)localObject2).getOtherTypeIp(((QQAppInterface)localObject1).getApp().getBaseContext(), 21, paramBoolean);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          localObject1 = ((List)localObject2).iterator();
        }
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (EndPoint)((Iterator)localObject1).next();
          if ((localObject2 != null) && (!TextUtils.isEmpty(((EndPoint)localObject2).host)))
          {
            localArrayList.add(new ExcitingTransferHostInfo(((EndPoint)localObject2).host, ((EndPoint)localObject2).port, true));
            continue;
            HwServlet.getConfig((AppRuntime)localObject1, ((QQAppInterface)localObject1).getCurrentUin());
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static byte[] getHttpConnKey()
  {
    return SessionInfo.getInstance(BaseApplicationImpl.getApplication().getRuntime().getAccount()).getSessionKey();
  }
  
  public static byte[] getHttpConnSig()
  {
    return SessionInfo.getInstance(BaseApplicationImpl.getApplication().getRuntime().getAccount()).getHttpconn_sig_session();
  }
  
  void handleSSORespError(FromServiceMsg paramFromServiceMsg, RichProto.RichProtoResp paramRichProtoResp, StatictisInfo paramStatictisInfo, int paramInt)
  {
    if ((paramInt != 1002) && (paramInt != 1013))
    {
      setResult(-1, 9044, BaseMessageHandler.a(paramFromServiceMsg), "", paramStatictisInfo, paramRichProtoResp.resps);
      return;
    }
    setResult(-1, 9311, BaseMessageHandler.a(paramFromServiceMsg), "", paramStatictisInfo, paramRichProtoResp.resps);
  }
  
  void initResps(RichProto.RichProtoReq paramRichProtoReq)
  {
    RichProto.RichProtoResp localRichProtoResp = paramRichProtoReq.resp;
    localRichProtoResp.resps.clear();
    int i = 0;
    while (i < paramRichProtoReq.reqs.size())
    {
      RichProto.RichProtoResp.MultiMsgDownResp localMultiMsgDownResp = new RichProto.RichProtoResp.MultiMsgDownResp();
      localRichProtoResp.resps.add(i, localMultiMsgDownResp);
      i += 1;
    }
  }
  
  public void onProtoResp(ProtoReqManagerImpl.ProtoResp paramProtoResp, ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    Object localObject1 = paramProtoResp.resp;
    byte[] arrayOfByte = paramProtoResp.resp.getWupBuffer();
    RichProto.RichProtoReq localRichProtoReq = (RichProto.RichProtoReq)paramProtoReq.busiData;
    RichProto.RichProtoResp localRichProtoResp = localRichProtoReq.resp;
    StatictisInfo localStatictisInfo = paramProtoResp.statisInfo;
    if (((FromServiceMsg)localObject1).getResultCode() != 1000) {
      handleSSORespError((FromServiceMsg)localObject1, localRichProtoResp, localStatictisInfo, ((FromServiceMsg)localObject1).getResultCode());
    }
    for (;;)
    {
      try
      {
        localObject1 = ((MultiMsg.RspBody)new MultiMsg.RspBody().mergeFrom(arrayOfByte)).rpt_multimsg_applydown_rsp.get();
        int i = 0;
        if (i < ((List)localObject1).size())
        {
          Object localObject2 = (MultiMsg.MultiMsgApplyDownRsp)((List)localObject1).get(i);
          RichProto.RichProtoResp.MultiMsgDownResp localMultiMsgDownResp = (RichProto.RichProtoResp.MultiMsgDownResp)localRichProtoResp.resps.get(i);
          j = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).uint32_result.get();
          if (j == 0)
          {
            paramProtoResp = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_thumb_down_para.get();
            if (paramProtoResp == null) {
              paramProtoResp = null;
            } else {
              paramProtoResp = paramProtoResp.toStringUtf8();
            }
            Object localObject3 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_resid.get().toByteArray();
            Object localObject4 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).bytes_msg_key.get().toByteArray();
            if (!((MultiMsg.MultiMsgApplyDownRsp)localObject2).msg_extern_info.has()) {
              break label701;
            }
            j = ((MultiMsg.ExternMsg)((MultiMsg.MultiMsgApplyDownRsp)localObject2).msg_extern_info.get()).uint32_channel_type.get();
            localMultiMsgDownResp.mChannelType = j;
            localMultiMsgDownResp.urlParam = paramProtoResp;
            localMultiMsgDownResp.resId = ((byte[])localObject3);
            localMultiMsgDownResp.msgkey = ((byte[])localObject4);
            localObject3 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_ip.get();
            paramProtoResp = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_port.get();
            j = i;
            if (localObject3 != null)
            {
              int k = 0;
              j = i;
              if (k < ((List)localObject3).size())
              {
                long l1 = ((Integer)((List)localObject3).get(k)).intValue();
                long l2 = ((Integer)paramProtoResp.get(k)).intValue();
                localObject4 = new ServerAddr();
                ((ServerAddr)localObject4).mIp = PkgTools.int2IPNet(l1 & 0xFFFFFFFF);
                ((ServerAddr)localObject4).port = ((int)l2);
                localMultiMsgDownResp.ipList.add(k, localObject4);
                k += 1;
                continue;
              }
            }
            paramProtoResp = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_bytes_down_ip_v6.get();
            localObject2 = ((MultiMsg.MultiMsgApplyDownRsp)localObject2).rpt_uint32_down_v6_port.get();
            if (paramProtoResp != null)
            {
              i = 0;
              if (i < paramProtoResp.size())
              {
                localObject3 = new ServerAddr();
                ((ServerAddr)localObject3).mIp = Inet6Address.getByAddress(((ByteStringMicro)paramProtoResp.get(i)).toByteArray()).getHostAddress();
                ((ServerAddr)localObject3).port = ((int)((Integer)((List)localObject2).get(i)).intValue());
                ((ServerAddr)localObject3).isIpv6 = true;
                localMultiMsgDownResp.mIpv6List.add(i, localObject3);
                i += 1;
                continue;
              }
            }
            setResult(0, 0, "", "", localStatictisInfo, localMultiMsgDownResp);
            i = j;
          }
          else
          {
            if (j == 196) {
              ReportController.b(null, "CliOper", "", "", "0X8006627", "0X8006627", 0, 1, 0, "", "", "", "");
            }
            if (shouldRetryByRetCodeForGroup(j))
            {
              this.mReqUrlCount += 1;
              if (this.mReqUrlCount < 2)
              {
                localRichProtoReq.protoReqMgr.sendProtoReq(paramProtoReq);
                return;
              }
            }
            setResult(-1, -9527, ProcessorReport.getUrlReason(j), "", localStatictisInfo, localMultiMsgDownResp);
          }
          i += 1;
          continue;
        }
        RichProtoProc.onBusiProtoResp(localRichProtoReq, localRichProtoResp);
      }
      catch (Exception paramProtoResp)
      {
        paramProtoReq = ProcessorReport.getServerReason("P", -9529L);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramProtoResp.getMessage());
        ((StringBuilder)localObject1).append(" hex:");
        ((StringBuilder)localObject1).append(HexUtil.bytes2HexStr(arrayOfByte));
        setResult(-1, -9527, paramProtoReq, ((StringBuilder)localObject1).toString(), localStatictisInfo, localRichProtoResp.resps);
      }
      return;
      label701:
      int j = 0;
    }
  }
  
  public void sendRichProtoReq(RichProto.RichProtoReq paramRichProtoReq)
  {
    if ((paramRichProtoReq != null) && (paramRichProtoReq.reqs != null) && (paramRichProtoReq.protoReqMgr != null))
    {
      ProtoReqManagerImpl.ProtoReq localProtoReq = new ProtoReqManagerImpl.ProtoReq();
      localProtoReq.ssoCmd = "MultiMsg.ApplyDown";
      localProtoReq.reqBody = constructReqBody(paramRichProtoReq.reqs);
      localProtoReq.busiData = paramRichProtoReq;
      localProtoReq.callback = this;
      inner_sendToProtoReq(paramRichProtoReq, localProtoReq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.MultiMsgDownHandler
 * JD-Core Version:    0.7.0.1
 */