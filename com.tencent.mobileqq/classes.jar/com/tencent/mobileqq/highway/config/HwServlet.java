package com.tencent.mobileqq.highway.config;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
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
  private static final int HIGHWAY_SERVICE_TYPE = 10;
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
  
  public static boolean isNetworkTypeMobile(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return false;
    }
    return true;
  }
  
  public static void reportTraffic(AppRuntime paramAppRuntime, String paramString1, int paramInt, String paramString2, boolean paramBoolean, long paramLong)
  {
    int j = 1;
    if ((paramAppRuntime == null) || (paramLong <= 0L)) {
      return;
    }
    for (;;)
    {
      try
      {
        i = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo().getType();
        if (i != 1) {
          continue;
        }
        i = 2;
      }
      catch (Exception localException1)
      {
        try
        {
          NewIntent localNewIntent;
          if (isNetworkTypeMobile(i) == true)
          {
            i = 1;
            continue;
          }
          int k = NetConnInfoCenterImpl.getSystemNetworkType();
          i = k;
        }
        catch (Exception localException2)
        {
          int i;
          break label185;
        }
        localException1 = localException1;
        i = 0;
      }
      localNewIntent = new NewIntent(paramAppRuntime.getApplication(), HwServlet.class);
      localNewIntent.putExtra("param_req_type", 182);
      localNewIntent.putExtra("ip", paramString1);
      localNewIntent.putExtra("port", paramInt);
      localNewIntent.putExtra("mType", paramString2);
      paramInt = j;
      if (paramBoolean) {
        paramInt = 0;
      }
      localNewIntent.putExtra("flag", paramInt);
      localNewIntent.putExtra("buffersize", paramLong);
      localNewIntent.putExtra("networktype", i);
      paramAppRuntime.startServlet(localNewIntent);
      return;
      if (i == 0) {
        i = 1;
      } else {
        label185:
        localException1.printStackTrace();
      }
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
  
  private void respGetIPList(Intent paramIntent, FromServiceMsg paramFromServiceMsg, AppRuntime paramAppRuntime, String paramString)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    Object localObject1 = new StringBuilder().append("HwServlet.respGetIPList()  is ");
    if (bool) {}
    for (paramIntent = "";; paramIntent = "not")
    {
      BdhLogUtil.LogEvent("C", paramIntent + " success");
      if (paramFromServiceMsg.isSuccess()) {
        break;
      }
      return;
    }
    localObject1 = ConfigManager.getInstance(null, null);
    paramIntent = new subcmd0x501.RspBody();
    for (;;)
    {
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        Object localObject2 = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get((byte[])localObject2);
        paramIntent.mergeFrom((byte[])localObject2);
        paramFromServiceMsg = (subcmd0x501.SubCmd0x501Rspbody)paramIntent.msg_subcmd_0x501_rsp_body.get();
        SessionInfo.updateSessionInfo(paramFromServiceMsg.bytes_httpconn_sig_session.get().toByteArray(), paramFromServiceMsg.bytes_session_key.get().toByteArray(), paramString);
        paramFromServiceMsg = paramFromServiceMsg.rpt_msg_httpconn_addrs.get();
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() == 0)) {
          break label994;
        }
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        if (!paramFromServiceMsg.hasNext()) {
          break label985;
        }
        localObject2 = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)paramFromServiceMsg.next();
        if (((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject2).uint32_service_type.get() != 10) {
          continue;
        }
        paramFromServiceMsg = new HwConfig();
        paramFromServiceMsg.ipList = new ArrayList();
        paramFromServiceMsg.netSegConfList = new ArrayList();
        paramFromServiceMsg.shortVideoSegConfList = new ArrayList();
        Object localObject3 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject2).rpt_msg_addrs.get();
        int i;
        Object localObject4;
        ArrayList localArrayList;
        String str;
        int j;
        if ((localObject3 != null) && (((List)localObject3).size() != 0))
        {
          i = 0;
          if (i < ((List)localObject3).size())
          {
            localObject4 = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)((List)localObject3).get(i);
            localArrayList = paramFromServiceMsg.ipList;
            str = spliceCircleUrl(((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject4).uint32_ip.get());
            j = ((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject4).uint32_port.get();
            if (((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject4).uint32_same_isp.get() != 1) {
              break label1003;
            }
            bool = true;
            localArrayList.add(new EndPoint(str, j, bool));
            i += 1;
            continue;
          }
        }
        paramFromServiceMsg.ipv6List = new ArrayList();
        localObject3 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject2).rpt_msg_addrs_v6.get();
        if ((localObject3 != null) && (((List)localObject3).size() != 0))
        {
          i = 0;
          if (i < ((List)localObject3).size())
          {
            localObject4 = (subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)((List)localObject3).get(i);
            localArrayList = paramFromServiceMsg.ipv6List;
            str = spliceIpv6Url(((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject4).bytes_ip6.get().toByteArray());
            j = ((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject4).uint32_port.get();
            if (((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject4).uint32_same_isp.get() != 1) {
              break label1009;
            }
            bool = true;
            localArrayList.add(new EndPoint(str, j, bool));
            i += 1;
            continue;
          }
        }
        localObject2 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject2).rpt_msg_netsegconf.get();
        if ((localObject2 != null) && (((List)localObject2).size() != 0))
        {
          i = 0;
          if (i < ((List)localObject2).size())
          {
            localObject3 = (subcmd0x501.SubCmd0x501Rspbody.NetSegConf)((List)localObject2).get(i);
            paramFromServiceMsg.netSegConfList.add(new HwNetSegConf(((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject3).uint32_net_type.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject3).uint32_segsize.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject3).uint32_segnum.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject3).uint32_curconnnum.get()));
            i += 1;
            continue;
          }
        }
        if (localObject1 != null)
        {
          ((ConfigManager)localObject1).onSrvAddrSsoGet(paramFromServiceMsg, paramAppRuntime, paramString);
          if (paramIntent.msg_subcmd_0x501_rsp_body.msg_ip_learn_conf.has())
          {
            paramAppRuntime = (subcmd0x501.SubCmd0x501Rspbody.IpLearnConf)paramIntent.msg_subcmd_0x501_rsp_body.msg_ip_learn_conf.get();
            if ((paramAppRuntime.uint32_refresh_cached_ip.has()) && (paramAppRuntime.uint32_refresh_cached_ip.get() == 1) && (localObject1 != null)) {
              IpContainer.refreshIpLearning();
            }
            if ((paramAppRuntime.uint32_enable_ip_learn.has()) && (paramAppRuntime.uint32_enable_ip_learn.get() == 1)) {
              com.tencent.mobileqq.highway.iplearning.IpLearningImpl.sEnableIpLearning = 1;
            }
          }
          else
          {
            if (paramIntent.msg_subcmd_0x501_rsp_body.msg_dyn_timeout_conf.has()) {
              BdhSegTimeoutUtil.updateFromSrv((subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf)paramIntent.msg_subcmd_0x501_rsp_body.msg_dyn_timeout_conf.get());
            }
            if (paramIntent.msg_subcmd_0x501_rsp_body.msg_open_up_conf.has()) {
              OpenUpConfig.updateFromSrv((subcmd0x501.SubCmd0x501Rspbody.OpenUpConf)paramIntent.msg_subcmd_0x501_rsp_body.msg_open_up_conf.get());
            }
            if (!paramIntent.msg_subcmd_0x501_rsp_body.msg_short_video_conf.has()) {
              break label955;
            }
            paramAppRuntime = ((subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf)paramIntent.msg_subcmd_0x501_rsp_body.msg_short_video_conf.get()).rpt_msg_netsegconf.get();
            if ((paramAppRuntime == null) || (paramAppRuntime.size() == 0)) {
              break label945;
            }
            i = 0;
            if (i >= paramAppRuntime.size()) {
              break label945;
            }
            paramString = (subcmd0x501.SubCmd0x501Rspbody.NetSegConf)paramAppRuntime.get(i);
            paramFromServiceMsg.shortVideoSegConfList.add(new HwNetSegConf(paramString.uint32_net_type.get(), paramString.uint32_segsize.get(), paramString.uint32_segnum.get(), paramString.uint32_curconnnum.get()));
            i += 1;
            continue;
          }
        }
        else
        {
          BdhLogUtil.LogEvent("C", "HwServlet.respGetIPList() cfg == null");
          continue;
        }
        com.tencent.mobileqq.highway.iplearning.IpLearningImpl.sEnableIpLearning = 0;
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        BdhLogUtil.LogException("C", "respGetIPList", paramIntent);
        return;
      }
      continue;
      label945:
      VideoUpConfigInfo.updateFromSrc(paramIntent.msg_subcmd_0x501_rsp_body.msg_short_video_conf);
      label955:
      if (!paramIntent.msg_subcmd_0x501_rsp_body.msg_ptv_conf.has()) {
        break;
      }
      PTVUpConfigInfo.updateFromSrc((subcmd0x501.SubCmd0x501Rspbody.PTVConf)paramIntent.msg_subcmd_0x501_rsp_body.msg_ptv_conf.get());
      return;
      label985:
      BdhLogUtil.LogEvent("C", "HwServlet.respGetIPList() cannot find HwServlet.HIGHWAY_SERVICE_TYPE");
      return;
      label994:
      BdhLogUtil.LogEvent("C", "HwServlet.respGetIPList() srvAddrList == null || srvAddrList.size() == 0");
      return;
      label1003:
      bool = false;
      continue;
      label1009:
      bool = false;
    }
  }
  
  public static String spliceCircleUrl(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF).append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF).append(".");
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
    mHasStart.set(false);
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
      if (mGetConfigListener != null)
      {
        paramIntent = (HwServlet.OnGetConfigListener)mGetConfigListener.get();
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
    switch (localBundle.getInt("param_req_type", 0))
    {
    default: 
      return;
    case 181: 
      reqGetIPList(paramIntent, paramPacket);
      return;
    }
    sendToMSF(paramIntent, MsfServiceSdk.get().getReportTrafficeMsg4Highway(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.HwServlet
 * JD-Core Version:    0.7.0.1
 */