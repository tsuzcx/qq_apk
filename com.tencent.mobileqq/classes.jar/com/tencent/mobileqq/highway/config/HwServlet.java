package com.tencent.mobileqq.highway.config;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.tencent.mobileqq.highway.ipv6.Ipv6Config;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.ReqBody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.RspBody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501ReqBody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.Ip6Addr;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpAddr;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.NetSegConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.OpenUpConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.PTVConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhSegTimeoutUtil;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.highway.utils.PTVUpConfigInfo;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenterImpl;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;

public class HwServlet
  extends MSFServlet
{
  private static final String CMD_GET_IP_LIST = "HttpConn.0x6ff_501";
  private static final int CMD_ID_GET_CONFIG = 181;
  private static final int CMD_ID_REPORT_TRAFFIC = 182;
  private static final String CMD_PIC_UP = "LongConn.OffPicUp";
  public static final int HIGHWAY_SERVICE_HTTPS = 21;
  public static final int HIGHWAY_SERVICE_TYPE = 10;
  private static final String PARAM_FLAG = "flag";
  private static final String PARAM_IP = "ip";
  private static final String PARAM_NETWORKTYPE = "networktype";
  private static final String PARAM_PORT = "port";
  private static final String PARAM_REQUEST_TYPE = "param_req_type";
  private static final String PARAM_SIZE = "buffersize";
  private static final String PARAM_TYPE = "mType";
  private static final String PARAM_UIN = "param_uin";
  private static final String TAG = "HWConfigManager";
  private static AppRuntime mApp;
  public static WeakReference<HwServlet.OnGetConfigListener> mGetConfigListener;
  private static AtomicBoolean mHasStart = new AtomicBoolean(false);
  private static String mUin;
  
  private HwConfig generateConfig(subcmd0x501.SubCmd0x501Rspbody.SrvAddrs paramSrvAddrs)
  {
    HwConfig localHwConfig = new HwConfig();
    localHwConfig.ipList = new ArrayList();
    localHwConfig.netSegConfList = new ArrayList();
    localHwConfig.shortVideoSegConfList = new ArrayList();
    Object localObject1 = paramSrvAddrs.rpt_msg_addrs.get();
    int i;
    Object localObject2;
    Object localObject3;
    int j;
    boolean bool;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      i = 0;
      while (i < ((List)localObject1).size())
      {
        localObject2 = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)((List)localObject1).get(i);
        localObject3 = localHwConfig.ipList;
        String str = spliceCircleUrl(((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_ip.get());
        j = ((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_port.get();
        if (((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_same_isp.get() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((ArrayList)localObject3).add(new EndPoint(str, j, bool));
        i += 1;
      }
    }
    localHwConfig.ipv6List = new ArrayList();
    paramSrvAddrs = paramSrvAddrs.rpt_msg_addrs_v6.get();
    if ((paramSrvAddrs != null) && (paramSrvAddrs.size() != 0))
    {
      i = 0;
      while (i < paramSrvAddrs.size())
      {
        localObject1 = (subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)paramSrvAddrs.get(i);
        localObject2 = localHwConfig.ipv6List;
        localObject3 = spliceIpv6Url(((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject1).bytes_ip6.get().toByteArray());
        j = ((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject1).uint32_port.get();
        if (((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject1).uint32_same_isp.get() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((ArrayList)localObject2).add(new EndPoint((String)localObject3, j, bool));
        i += 1;
      }
    }
    return localHwConfig;
  }
  
  public static void getConfig(AppRuntime paramAppRuntime, String paramString)
  {
    getConfig(paramAppRuntime, paramString, null);
  }
  
  public static void getConfig(AppRuntime paramAppRuntime, String paramString, HwServlet.OnGetConfigListener paramOnGetConfigListener)
  {
    if (paramOnGetConfigListener != null) {
      mGetConfigListener = new WeakReference(paramOnGetConfigListener);
    }
    if (mHasStart.get()) {
      return;
    }
    mHasStart.set(true);
    BdhLogUtil.LogEvent("C", "HwServlet.getConfig()");
    mApp = paramAppRuntime;
    mUin = paramString;
    paramOnGetConfigListener = new NewIntent(paramAppRuntime.getApplication(), HwServlet.class);
    paramOnGetConfigListener.putExtra("param_req_type", 181);
    paramOnGetConfigListener.putExtra("param_uin", Long.parseLong(paramString));
    paramAppRuntime.startServlet(paramOnGetConfigListener);
  }
  
  private void handleIpv6Cfg(subcmd0x501.RspBody paramRspBody)
  {
    boolean bool = paramRspBody.msg_subcmd_0x501_rsp_body.uint32_fmt_policy.has();
    int m = 0;
    int j;
    int i;
    if (bool)
    {
      j = paramRspBody.msg_subcmd_0x501_rsp_body.uint32_fmt_policy.get();
      i = 1;
    }
    else
    {
      i = 0;
      j = 0;
    }
    int k;
    if (paramRspBody.msg_subcmd_0x501_rsp_body.uint32_bigdata_policy.has())
    {
      k = paramRspBody.msg_subcmd_0x501_rsp_body.uint32_bigdata_policy.get();
      i = 1;
    }
    else
    {
      k = 0;
    }
    if (paramRspBody.msg_subcmd_0x501_rsp_body.uint32_conn_attempt_delay.has())
    {
      m = paramRspBody.msg_subcmd_0x501_rsp_body.uint32_conn_attempt_delay.get();
      i = 1;
    }
    if (i != 0) {
      Ipv6Config.updateCfgFromSrv(BaseApplication.getContext(), j, k, m);
    }
  }
  
  public static boolean isNetworkTypeMobile(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 2) || (paramInt == 3) || (paramInt == 4) || (paramInt == 5);
  }
  
  public static void reportTraffic(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2, boolean paramBoolean, long paramLong)
  {
    int i;
    int j;
    if (paramAppRuntime != null)
    {
      if (paramLong <= 0L) {
        return;
      }
      i = 0;
      try
      {
        j = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo().getType();
        if (j != 1) {
          break label178;
        }
        i = 2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i = j;
      if (isNetworkTypeMobile(j) == true) {
        break label183;
      }
      i = j;
      j = NetConnInfoCenterImpl.getSystemNetworkType();
      i = j;
    }
    for (;;)
    {
      NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), HwServlet.class);
      localNewIntent.putExtra("param_req_type", 182);
      localNewIntent.putExtra("ip", paramString1);
      localNewIntent.putExtra("port", paramInt);
      localNewIntent.putExtra("mType", paramString2);
      localNewIntent.putExtra("flag", paramBoolean ^ true);
      localNewIntent.putExtra("buffersize", paramLong);
      localNewIntent.putExtra("networktype", i);
      paramAppRuntime.startServlet(localNewIntent);
      return;
      label178:
      if (j != 0) {
        break;
      }
      label183:
      i = 1;
    }
  }
  
  public static void reportTraffic4PicUp(AppRuntime paramAppRuntime, String paramString, int paramInt, boolean paramBoolean, long paramLong)
  {
    reportTraffic(paramAppRuntime, paramString, paramInt, "LongConn.OffPicUp", paramBoolean, paramLong);
  }
  
  private boolean reqGetIPList(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("param_uin", 0L);
    if (l == 0L) {
      BdhLogUtil.LogEvent("C", "HwServlet.reqGetIPList() fail due to uin=0");
    }
    BdhLogUtil.LogEvent("C", "HwServlet.reqGetIPList() req get ip list..");
    paramIntent = new subcmd0x501.SubCmd0x501ReqBody();
    paramIntent.uint64_uin.set(l);
    paramIntent.uint32_idc_id.set(0);
    paramIntent.uint32_appid.set(16);
    paramIntent.uint32_login_sig_type.set(1);
    paramIntent.uint32_request_flag.set(3);
    Object localObject = new ArrayList();
    ((List)localObject).add(Integer.valueOf(10));
    ((List)localObject).add(Integer.valueOf(21));
    paramIntent.rpt_uint32_service_types.set((List)localObject);
    paramIntent.uint32_plat.set(9);
    localObject = new subcmd0x501.ReqBody();
    ((subcmd0x501.ReqBody)localObject).msg_subcmd_0x501_req_body.set(paramIntent);
    paramPacket.setSSOCommand("HttpConn.0x6ff_501");
    paramIntent = ((subcmd0x501.ReqBody)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramIntent.length + 4);
    ((ByteBuffer)localObject).putInt(paramIntent.length + 4);
    ((ByteBuffer)localObject).put(paramIntent);
    paramPacket.putSendData(((ByteBuffer)localObject).array());
    return true;
  }
  
  public static void resetStartMask()
  {
    mHasStart.set(false);
  }
  
  private void respGetIPList(Intent paramIntent, FromServiceMsg paramFromServiceMsg, AppRuntime paramAppRuntime, String paramString)
  {
    Object localObject1 = this;
    Object localObject4 = paramAppRuntime;
    boolean bool = paramFromServiceMsg.isSuccess();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("HwServlet.respGetIPList()  is ");
    if (bool) {
      paramIntent = "";
    } else {
      paramIntent = "not";
    }
    ((StringBuilder)localObject2).append(paramIntent);
    ((StringBuilder)localObject2).append(" success");
    localObject2 = ((StringBuilder)localObject2).toString();
    paramIntent = "C";
    BdhLogUtil.LogEvent("C", (String)localObject2);
    if (!paramFromServiceMsg.isSuccess()) {
      return;
    }
    Object localObject6 = ConfigManager.getInstance(null, null);
    localObject2 = new subcmd0x501.RspBody();
    Object localObject5 = localObject1;
    localObject5 = paramIntent;
    Object localObject3;
    Object localObject7;
    Object localObject10;
    label1159:
    label1175:
    label1192:
    label1195:
    label1201:
    label1220:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        localObject5 = localObject1;
        localObject5 = paramIntent;
        localObject3 = new byte[paramFromServiceMsg.getInt() - 4];
        localObject5 = localObject1;
        localObject5 = paramIntent;
        paramFromServiceMsg.get((byte[])localObject3);
        localObject5 = localObject1;
        localObject5 = paramIntent;
        ((subcmd0x501.RspBody)localObject2).mergeFrom((byte[])localObject3);
        localObject5 = localObject1;
        localObject5 = paramIntent;
        paramFromServiceMsg = (subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject2).msg_subcmd_0x501_rsp_body.get();
        localObject5 = localObject1;
        localObject5 = paramIntent;
        SessionInfo.updateSessionInfo(paramFromServiceMsg.bytes_httpconn_sig_session.get().toByteArray(), paramFromServiceMsg.bytes_session_key.get().toByteArray(), paramString);
        localObject5 = localObject1;
        localObject5 = paramIntent;
        paramFromServiceMsg = paramFromServiceMsg.rpt_msg_httpconn_addrs.get();
        if (paramFromServiceMsg != null)
        {
          localObject5 = localObject1;
          localObject5 = paramIntent;
          if (paramFromServiceMsg.size() != 0)
          {
            localObject5 = localObject1;
            localObject5 = paramIntent;
            localObject3 = paramFromServiceMsg.iterator();
            paramFromServiceMsg = (FromServiceMsg)localObject6;
            localObject5 = localObject1;
            localObject5 = paramIntent;
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = localObject1;
              localObject5 = paramIntent;
              localSrvAddrs = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)((Iterator)localObject3).next();
              localObject5 = localObject1;
              localObject5 = paramIntent;
              i = localSrvAddrs.uint32_service_type.get();
              if (i == 10)
              {
                localObject5 = localObject1;
                localObject5 = paramIntent;
                localObject8 = ((HwServlet)localObject1).generateConfig(localSrvAddrs);
                localObject5 = localObject1;
                localObject5 = paramIntent;
                localObject7 = localSrvAddrs.rpt_msg_netsegconf.get();
                localObject4 = paramIntent;
                localObject5 = localObject2;
                localObject6 = localObject3;
                if (localObject7 != null)
                {
                  localObject4 = paramIntent;
                  localObject5 = localObject2;
                  localObject6 = localObject3;
                  localObject1 = paramIntent;
                }
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        subcmd0x501.SubCmd0x501Rspbody.SrvAddrs localSrvAddrs;
        int i;
        Object localObject8;
        long l1;
        long l2;
        long l3;
        paramFromServiceMsg = (FromServiceMsg)localObject5;
      }
      try
      {
        if (((List)localObject7).size() != 0)
        {
          i = 0;
          localObject4 = paramIntent;
          localObject5 = localObject2;
          localObject6 = localObject3;
          localObject1 = paramIntent;
          if (i < ((List)localObject7).size())
          {
            localObject1 = paramIntent;
            localObject4 = (subcmd0x501.SubCmd0x501Rspbody.NetSegConf)((List)localObject7).get(i);
            localObject1 = paramIntent;
            localObject5 = ((HwConfig)localObject8).netSegConfList;
            localObject1 = paramIntent;
            l1 = ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject4).uint32_net_type.get();
            localObject1 = paramIntent;
            l2 = ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject4).uint32_segsize.get();
            localObject1 = paramIntent;
            int j = ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject4).uint32_segnum.get();
            localObject1 = paramIntent;
            l3 = j;
            paramIntent = (Intent)localObject1;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        for (;;)
        {
          paramFromServiceMsg = (FromServiceMsg)localObject1;
        }
        paramIntent = (Intent)localObject4;
        localObject3 = paramAppRuntime;
        continue;
      }
      try
      {
        ((ArrayList)localObject5).add(new HwNetSegConf(l1, l2, l3, ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject4).uint32_curconnnum.get()));
        i += 1;
        paramIntent = (Intent)localObject1;
      }
      catch (InvalidProtocolBufferMicroException paramAppRuntime)
      {
        paramFromServiceMsg = paramIntent;
        paramIntent = paramAppRuntime;
        break label1159;
        continue;
        localObject4 = paramFromServiceMsg;
        continue;
        localObject5 = localObject10;
        localObject4 = localObject3;
        localObject3 = localObject7;
        paramIntent = (Intent)localObject1;
        localObject1 = localObject4;
        localObject4 = paramFromServiceMsg;
        paramFromServiceMsg = (FromServiceMsg)localObject5;
      }
      paramIntent = (Intent)localObject4;
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg.onSrvAddrSsoGet((HwConfig)localObject8, paramAppRuntime, paramString);
      }
      else
      {
        localObject1 = paramIntent;
        BdhLogUtil.LogEvent(paramIntent, "HwServlet.respGetIPList() cfg == null");
        break label1175;
        localObject1 = paramIntent;
        if (!((subcmd0x501.RspBody)localObject5).msg_subcmd_0x501_rsp_body.msg_ip_learn_conf.has()) {
          break label1192;
        }
        localObject1 = paramIntent;
        localObject2 = (subcmd0x501.SubCmd0x501Rspbody.IpLearnConf)((subcmd0x501.RspBody)localObject5).msg_subcmd_0x501_rsp_body.msg_ip_learn_conf.get();
        localObject1 = paramIntent;
        if (((subcmd0x501.SubCmd0x501Rspbody.IpLearnConf)localObject2).uint32_refresh_cached_ip.has())
        {
          localObject1 = paramIntent;
          if ((((subcmd0x501.SubCmd0x501Rspbody.IpLearnConf)localObject2).uint32_refresh_cached_ip.get() == 1) && (paramFromServiceMsg != null))
          {
            localObject1 = paramIntent;
            IpContainer.refreshIpLearning();
          }
        }
        localObject1 = paramIntent;
        if (((subcmd0x501.SubCmd0x501Rspbody.IpLearnConf)localObject2).uint32_enable_ip_learn.has())
        {
          localObject1 = paramIntent;
          if (((subcmd0x501.SubCmd0x501Rspbody.IpLearnConf)localObject2).uint32_enable_ip_learn.get() == 1)
          {
            localObject1 = paramIntent;
            com.tencent.mobileqq.highway.iplearning.IpLearningImpl.sEnableIpLearning = 1;
            break label1192;
          }
        }
        localObject1 = paramIntent;
        com.tencent.mobileqq.highway.iplearning.IpLearningImpl.sEnableIpLearning = 0;
        i = 0;
        localObject1 = paramIntent;
        if (((subcmd0x501.RspBody)localObject5).msg_subcmd_0x501_rsp_body.msg_dyn_timeout_conf.has())
        {
          localObject1 = paramIntent;
          BdhSegTimeoutUtil.updateFromSrv((subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf)((subcmd0x501.RspBody)localObject5).msg_subcmd_0x501_rsp_body.msg_dyn_timeout_conf.get());
        }
        localObject1 = paramIntent;
        if (((subcmd0x501.RspBody)localObject5).msg_subcmd_0x501_rsp_body.msg_open_up_conf.has())
        {
          localObject1 = paramIntent;
          OpenUpConfig.updateFromSrv((subcmd0x501.SubCmd0x501Rspbody.OpenUpConf)((subcmd0x501.RspBody)localObject5).msg_subcmd_0x501_rsp_body.msg_open_up_conf.get());
        }
        localObject1 = paramIntent;
        if (!((subcmd0x501.RspBody)localObject5).msg_subcmd_0x501_rsp_body.msg_short_video_conf.has()) {
          break label1195;
        }
        localObject1 = paramIntent;
        localObject7 = ((subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf)((subcmd0x501.RspBody)localObject5).msg_subcmd_0x501_rsp_body.msg_short_video_conf.get()).rpt_msg_netsegconf.get();
        localObject2 = paramFromServiceMsg;
        if (localObject7 != null)
        {
          localObject2 = paramFromServiceMsg;
          localObject1 = paramIntent;
          if (((List)localObject7).size() != 0)
          {
            localObject4 = localObject8;
            localObject2 = paramFromServiceMsg;
            localObject1 = paramIntent;
            if (i < ((List)localObject7).size())
            {
              localObject1 = paramIntent;
              localObject2 = (subcmd0x501.SubCmd0x501Rspbody.NetSegConf)((List)localObject7).get(i);
              localObject1 = paramIntent;
              ((HwConfig)localObject4).shortVideoSegConfList.add(new HwNetSegConf(((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject2).uint32_net_type.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject2).uint32_segsize.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject2).uint32_segnum.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject2).uint32_curconnnum.get()));
              i += 1;
              continue;
            }
          }
        }
        localObject1 = paramIntent;
        VideoUpConfigInfo.updateFromSrc(((subcmd0x501.RspBody)localObject5).msg_subcmd_0x501_rsp_body.msg_short_video_conf);
        localObject4 = localObject2;
        localObject1 = paramIntent;
        if (((subcmd0x501.RspBody)localObject5).msg_subcmd_0x501_rsp_body.msg_ptv_conf.has())
        {
          localObject1 = paramIntent;
          PTVUpConfigInfo.updateFromSrc((subcmd0x501.SubCmd0x501Rspbody.PTVConf)((subcmd0x501.RspBody)localObject5).msg_subcmd_0x501_rsp_body.msg_ptv_conf.get());
        }
        localObject1 = this;
        paramFromServiceMsg = paramIntent;
        try
        {
          ((HwServlet)localObject1).handleIpv6Cfg((subcmd0x501.RspBody)localObject5);
          paramFromServiceMsg = (FromServiceMsg)localObject3;
          localObject2 = localObject5;
          localObject3 = localObject1;
          localObject1 = paramIntent;
          localObject7 = localObject6;
          localObject10 = localObject4;
        }
        catch (InvalidProtocolBufferMicroException paramIntent)
        {
          Object localObject9;
          break label1159;
        }
        localObject5 = localObject1;
        localObject8 = paramFromServiceMsg;
        localObject6 = localObject2;
        localObject9 = localObject3;
        paramFromServiceMsg = (FromServiceMsg)localObject4;
        localObject2 = localObject6;
        localObject3 = localObject5;
        localObject1 = paramIntent;
        localObject7 = localObject9;
        localObject10 = localObject8;
        if (i != 21) {
          break label1201;
        }
        paramFromServiceMsg = paramIntent;
        ((ConfigManager)localObject8).onOtherTypeSrvAddrGet(((HwServlet)localObject5).generateConfig(localSrvAddrs), (AppRuntime)localObject4, i);
        localObject3 = localObject9;
        localObject2 = localObject6;
        localObject1 = localObject5;
        paramFromServiceMsg = (FromServiceMsg)localObject4;
        localObject5 = localObject8;
        break label1220;
        paramFromServiceMsg = paramIntent;
        BdhLogUtil.LogEvent(paramIntent, "HwServlet.respGetIPList() cannot find HwServlet.HIGHWAY_SERVICE_TYPE");
        return;
        paramFromServiceMsg = paramIntent;
        BdhLogUtil.LogEvent("C", "HwServlet.respGetIPList() srvAddrList == null || srvAddrList.size() == 0");
        return;
        BdhLogUtil.LogException(paramFromServiceMsg, "respGetIPList", paramIntent);
        return;
      }
    }
  }
  
  public static String spliceCircleUrl(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  public static String spliceIpv6Url(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = Inet6Address.getByAddress(paramArrayOfByte).getHostAddress();
      return paramArrayOfByte;
    }
    catch (UnknownHostException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    resetStartMask();
    paramFromServiceMsg.getResultCode();
    String str = paramFromServiceMsg.getServiceCmd();
    if (str == null)
    {
      BdhLogUtil.LogEvent("C", "cmd == null");
      return;
    }
    if (str.equals("HttpConn.0x6ff_501"))
    {
      respGetIPList(paramIntent, paramFromServiceMsg, mApp, mUin);
      paramIntent = mGetConfigListener;
      if (paramIntent != null)
      {
        paramIntent = (HwServlet.OnGetConfigListener)paramIntent.get();
        if (paramIntent != null)
        {
          paramIntent.onGetConfig();
          mGetConfigListener = null;
        }
      }
    }
    mApp = null;
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {
      return;
    }
    int i = localBundle.getInt("param_req_type", 0);
    if (i != 181)
    {
      if (i != 182) {
        return;
      }
      sendToMSF(paramIntent, MsfServiceSdk.get().getReportTrafficeMsg4Highway(paramIntent));
      return;
    }
    reqGetIPList(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.HwServlet
 * JD-Core Version:    0.7.0.1
 */