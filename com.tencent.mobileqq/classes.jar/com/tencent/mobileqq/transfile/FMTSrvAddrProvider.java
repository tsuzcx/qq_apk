package com.tencent.mobileqq.transfile;

import ConfigPush.BigDataChannel;
import ConfigPush.BigDataIpInfo;
import ConfigPush.BigDataIpList;
import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import ConfigPush.FmtIPInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.RspBody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.Ip6Addr;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpAddr;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.IpLearnConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.NetSegConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.OpenUpConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.PTVConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.ShortVideoConf;
import com.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.IRichMediaIpSaver;
import com.tencent.mobileqq.richmedia.api.IRichMediaTransferUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.highway.protocol.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;>;
import java.util.Map;
import mqq.app.AppRuntime;
import tencent.im.cs.ptt_apply.ptt_apply.Addr;
import tencent.im.cs.ptt_apply.ptt_apply.QQApplyAuthkeyRsp;

@Deprecated
public final class FMTSrvAddrProvider
{
  private static final String FMT_PICDOWN_IPLIST;
  private static final String FMT_PICDOWN_IPLIST_TMP;
  private static final String FMT_SVC_INI;
  private static final String FMT_SVC_INI_TMP;
  public static final int STATE_CLEAR = 2;
  public static final int STATE_INIT = 0;
  public static final int STATE_READY = 1;
  public static final String TAG = "FMT_ADDR";
  public static final int TLV_WIFI_IDENTIFIER_INDEX = 1;
  public static final int TLV_WIFI_IP_LIST_INDEX = 3;
  public static final int TLV_XG_IDENTIFIER_INDEX = 2;
  public static final int TLV_XG_IP_LIST_INDEX = 4;
  private static FMTSrvAddrProvider mSelf;
  private static byte[] mlock = new byte[1];
  private subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf encryptConf;
  private Hashtable<Integer, ArrayList<FileStorageServerListInfo>> mBigDataSvcList = new Hashtable();
  private FMTSrvAddrProvider.SrvAddrChooser mChooser = new FMTSrvAddrProvider.SrvAddrChooser(this);
  private Hashtable<Integer, ArrayList<FileStorageServerListInfo>> mDomainSvrList = new Hashtable();
  private long mGateIpOper = -1L;
  private String mGatewayIp = "";
  private FMTSrvAddrProvider.PttIpList mGroupPttIpList = new FMTSrvAddrProvider.PttIpList();
  private StructLongMessageIpSaver mLongMsgIpSaver = new StructLongMessageIpSaver();
  private IRichMediaIpSaver mRichMediaIpSaver = ((IRichMediaTransferUtils)QRoute.api(IRichMediaTransferUtils.class)).createRichMediaIpSaver();
  private int mState = 0;
  private FileStoragePushFSSvcList mSvcList = readFromFile();
  private FileStoragePushFSSvcList mSvcListCache;
  public Object saveSvcListLock = new Object();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_DATABASE);
    localStringBuilder.append("fmtSrvAddr.ini");
    FMT_SVC_INI_TMP = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_DATABASE);
    localStringBuilder.append("srvAddr.ini");
    FMT_SVC_INI = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_DATABASE);
    localStringBuilder.append("ipDownAddr.ini");
    FMT_PICDOWN_IPLIST = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_DATABASE);
    localStringBuilder.append("ipDownAddr.tmp");
    FMT_PICDOWN_IPLIST_TMP = localStringBuilder.toString();
  }
  
  private FMTSrvAddrProvider()
  {
    parseGroupPttDownloadIPList();
    init();
  }
  
  private void decodeSrvAddrs(Map<Integer, HwConfig> paramMap, subcmd0x501.SubCmd0x501Rspbody paramSubCmd0x501Rspbody, List<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> paramList)
  {
    Object localObject1 = paramMap;
    Object localObject2;
    for (paramList = paramList.iterator(); paramList.hasNext(); paramList = (List<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs>)localObject2)
    {
      Object localObject4 = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)paramList.next();
      int j = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject4).uint32_service_type.get();
      boolean bool = QLog.isColorLevel();
      localObject2 = "FMT_ADDR";
      Object localObject3;
      if (bool)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("GetHighwayConfig   find HwServlet.HIGHWAY_SERVICE_TYPE");
        ((StringBuilder)localObject3).append(j);
        QLog.d("FMT_ADDR", 2, ((StringBuilder)localObject3).toString());
      }
      if (j == 10)
      {
        HwConfig localHwConfig = generateConfig((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject4);
        localHwConfig.netSegConfList = new ArrayList();
        localObject4 = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject4).rpt_msg_netsegconf.get();
        localObject3 = paramList;
        localObject1 = localObject2;
        if (localObject4 != null)
        {
          localObject3 = paramList;
          localObject1 = localObject2;
          if (((List)localObject4).size() != 0)
          {
            int i = 0;
            for (;;)
            {
              localObject3 = paramList;
              localObject1 = localObject2;
              if (i >= ((List)localObject4).size()) {
                break;
              }
              localObject1 = (subcmd0x501.SubCmd0x501Rspbody.NetSegConf)((List)localObject4).get(i);
              localHwConfig.netSegConfList.add(new HwNetSegConf(((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject1).uint32_net_type.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject1).uint32_segsize.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject1).uint32_segnum.get(), ((subcmd0x501.SubCmd0x501Rspbody.NetSegConf)localObject1).uint32_curconnnum.get()));
              i += 1;
            }
          }
        }
        if (paramSubCmd0x501Rspbody.msg_ip_learn_conf.has()) {
          localHwConfig.ipConf = ((subcmd0x501.SubCmd0x501Rspbody.IpLearnConf)paramSubCmd0x501Rspbody.msg_ip_learn_conf.get());
        }
        if (paramSubCmd0x501Rspbody.msg_dyn_timeout_conf.has()) {
          localHwConfig.dtConf = ((subcmd0x501.SubCmd0x501Rspbody.DynTimeOutConf)paramSubCmd0x501Rspbody.msg_dyn_timeout_conf.get());
        }
        if (paramSubCmd0x501Rspbody.msg_open_up_conf.has()) {
          localHwConfig.openUpConf = ((subcmd0x501.SubCmd0x501Rspbody.OpenUpConf)paramSubCmd0x501Rspbody.msg_open_up_conf.get());
        }
        if (paramSubCmd0x501Rspbody.msg_short_video_conf.has()) {
          localHwConfig.videoConf = paramSubCmd0x501Rspbody.msg_short_video_conf;
        } else if (QLog.isColorLevel()) {
          QLog.d((String)localObject1, 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_short_video_conf.has() : false ! ");
        }
        if (paramSubCmd0x501Rspbody.msg_ptv_conf.has()) {
          localHwConfig.ptvCof = paramSubCmd0x501Rspbody.msg_ptv_conf;
        } else if (QLog.isColorLevel()) {
          QLog.d((String)localObject1, 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_ptv_conf.has() : false ! ");
        }
        if (paramSubCmd0x501Rspbody.uint32_fmt_policy.has()) {
          localHwConfig.fmtIpv6Policy = paramSubCmd0x501Rspbody.uint32_fmt_policy;
        } else if (QLog.isColorLevel()) {
          QLog.d((String)localObject1, 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_fmt_policy.has() : false ! ");
        }
        if (paramSubCmd0x501Rspbody.uint32_bigdata_policy.has()) {
          localHwConfig.bdhIpv6Policy = paramSubCmd0x501Rspbody.uint32_bigdata_policy;
        } else if (QLog.isColorLevel()) {
          QLog.d((String)localObject1, 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_bigdata_policy.has() : false ! ");
        }
        if (paramSubCmd0x501Rspbody.uint32_conn_attempt_delay.has()) {
          localHwConfig.connAttemptDelay = paramSubCmd0x501Rspbody.uint32_conn_attempt_delay;
        } else if (QLog.isColorLevel()) {
          QLog.d((String)localObject1, 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_conn_attempt_delay.has() : false ! ");
        }
        paramList = paramMap;
        paramList.put(Integer.valueOf(j), localHwConfig);
      }
      else
      {
        localObject2 = paramList;
        paramList = (List<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs>)localObject1;
        localObject3 = localObject2;
        if (j == 21)
        {
          ((Map)localObject1).put(Integer.valueOf(j), generateConfig((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject4));
          paramList = (List<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs>)localObject1;
          break label581;
        }
      }
      localObject2 = localObject3;
      label581:
      localObject1 = paramList;
    }
  }
  
  public static void destroy()
  {
    FMTSrvAddrProvider localFMTSrvAddrProvider = mSelf;
    if (localFMTSrvAddrProvider == null) {
      return;
    }
    localFMTSrvAddrProvider.onDestroy();
  }
  
  private void doClearGroupPttDownloadIPList()
  {
    this.mGroupPttIpList = new FMTSrvAddrProvider.PttIpList();
    if (QLog.isDevelopLevel()) {
      QLog.d("SPD", 4, "Clear GroupPtt D-IpList");
    }
  }
  
  private HwConfig generateConfig(subcmd0x501.SubCmd0x501Rspbody.SrvAddrs paramSrvAddrs)
  {
    HwConfig localHwConfig = new HwConfig();
    localHwConfig.ipList = new ArrayList();
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
        String str = HwServlet.spliceCircleUrl(((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_ip.get());
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
        localObject3 = HwServlet.spliceIpv6Url(((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject1).bytes_ip6.get().toByteArray());
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
  
  private int getBigDataServiceType(int paramInt)
  {
    if (paramInt == 6) {
      return 1;
    }
    if (paramInt == 7) {
      return 2;
    }
    if (paramInt == 8) {
      return 3;
    }
    if (paramInt == 9) {
      return 4;
    }
    if (paramInt == 10) {
      return 5;
    }
    return 1;
  }
  
  private ArrayList<FileStorageServerListInfo> getBigDataSvcList(int paramInt)
  {
    if (this.mBigDataSvcList.containsKey(Integer.valueOf(paramInt))) {
      return (ArrayList)this.mBigDataSvcList.get(Integer.valueOf(paramInt));
    }
    Object localObject = this.mSvcList;
    if ((localObject != null) && (((FileStoragePushFSSvcList)localObject).bigDataChannel != null) && (this.mSvcList.bigDataChannel.vBigdata_iplists != null))
    {
      int j = 0;
      int i = 0;
      while (i < this.mSvcList.bigDataChannel.vBigdata_iplists.size())
      {
        localObject = (BigDataIpList)this.mSvcList.bigDataChannel.vBigdata_iplists.get(i);
        if (((BigDataIpList)localObject).uService_type == paramInt)
        {
          localObject = ((BigDataIpList)localObject).vIplist;
          ArrayList localArrayList = new ArrayList();
          i = j;
          while (i < ((ArrayList)localObject).size())
          {
            FileStorageServerListInfo localFileStorageServerListInfo = new FileStorageServerListInfo();
            localFileStorageServerListInfo.sIP = ((BigDataIpInfo)((ArrayList)localObject).get(i)).sIp;
            localFileStorageServerListInfo.iPort = ((int)((BigDataIpInfo)((ArrayList)localObject).get(i)).uPort);
            localArrayList.add(localFileStorageServerListInfo);
            i += 1;
          }
          this.mBigDataSvcList.put(Integer.valueOf(paramInt), localArrayList);
          return localArrayList;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private byte[] getBytes(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[][] paramArrayOfByte3, byte[][] paramArrayOfByte4, int paramInt1, byte paramByte, int paramInt2)
  {
    byte[] arrayOfByte1 = new byte[paramInt1 + 2];
    arrayOfByte1[0] = 0;
    paramInt1 = paramInt2 + 1;
    arrayOfByte1[paramInt1] = paramByte;
    paramInt1 += 1;
    paramInt2 = paramInt1;
    if (paramArrayOfByte1 != null)
    {
      arrayOfByte1[paramInt1] = 1;
      paramInt1 += 1;
      byte[] arrayOfByte2 = PkgTools.shortToHL((short)paramArrayOfByte1.length);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt1, arrayOfByte2.length);
      paramInt1 += arrayOfByte2.length;
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, paramInt1, paramArrayOfByte1.length);
      paramInt2 = paramInt1 + paramArrayOfByte1.length;
    }
    paramInt1 = paramInt2;
    if (paramArrayOfByte2 != null)
    {
      arrayOfByte1[paramInt2] = 2;
      paramInt1 = paramInt2 + 1;
      paramArrayOfByte1 = PkgTools.shortToHL((short)paramArrayOfByte2.length);
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, paramInt1, paramArrayOfByte1.length);
      paramInt1 += paramArrayOfByte1.length;
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte1, paramInt1, paramArrayOfByte2.length);
      paramInt1 += paramArrayOfByte2.length;
    }
    paramInt2 = paramInt1;
    if (paramArrayOfByte3 != null)
    {
      paramInt2 = paramInt1;
      if (paramArrayOfByte3.length > 0)
      {
        int i = 0;
        for (;;)
        {
          paramInt2 = paramInt1;
          if (i >= paramArrayOfByte3.length) {
            break;
          }
          arrayOfByte1[paramInt1] = 3;
          paramInt1 += 1;
          paramArrayOfByte1 = PkgTools.shortToHL((short)paramArrayOfByte3[i].length);
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, paramInt1, paramArrayOfByte1.length);
          paramInt1 += paramArrayOfByte1.length;
          System.arraycopy(paramArrayOfByte3[i], 0, arrayOfByte1, paramInt1, paramArrayOfByte3[i].length);
          paramInt1 += paramArrayOfByte3[i].length;
          i += 1;
        }
      }
    }
    if ((paramArrayOfByte4 != null) && (paramArrayOfByte4.length > 0))
    {
      paramInt1 = 0;
      while (paramInt1 < paramArrayOfByte4.length)
      {
        arrayOfByte1[paramInt2] = 4;
        paramInt2 += 1;
        paramArrayOfByte1 = PkgTools.shortToHL((short)paramArrayOfByte4[paramInt1].length);
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, paramInt2, paramArrayOfByte1.length);
        paramInt2 += paramArrayOfByte1.length;
        System.arraycopy(paramArrayOfByte4[paramInt1], 0, arrayOfByte1, paramInt2, paramArrayOfByte4[paramInt1].length);
        paramInt2 += paramArrayOfByte4[paramInt1].length;
        paramInt1 += 1;
      }
    }
    return arrayOfByte1;
  }
  
  private ArrayList<FileStorageServerListInfo> getDomainSvrList(int paramInt)
  {
    if (this.mDomainSvrList.containsKey(Integer.valueOf(paramInt))) {
      return (ArrayList)this.mDomainSvrList.get(Integer.valueOf(paramInt));
    }
    try
    {
      if ((this.mSvcList != null) && (this.mSvcList.domainIpChannel != null) && (this.mSvcList.domainIpChannel.vDomain_iplists != null))
      {
        int j = 0;
        int i = 0;
        while (i < this.mSvcList.domainIpChannel.vDomain_iplists.size())
        {
          Object localObject1 = (DomainIpList)this.mSvcList.domainIpChannel.vDomain_iplists.get(i);
          if (((DomainIpList)localObject1).uDomain_type == paramInt)
          {
            Object localObject2 = ((DomainIpList)localObject1).vIplist;
            localObject1 = new ArrayList();
            i = j;
            Object localObject3;
            while (i < ((ArrayList)localObject2).size())
            {
              localObject3 = new FileStorageServerListInfo();
              ((FileStorageServerListInfo)localObject3).sIP = NetworkUtil.intAddr2Ip(((DomainIpInfo)((ArrayList)localObject2).get(i)).uIp);
              ((FileStorageServerListInfo)localObject3).iPort = ((DomainIpInfo)((ArrayList)localObject2).get(i)).uPort;
              ((ArrayList)localObject1).add(localObject3);
              i += 1;
            }
            this.mDomainSvrList.put(Integer.valueOf(paramInt), localObject1);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuffer();
              localObject3 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)((Iterator)localObject3).next();
                ((StringBuffer)localObject2).append(localFileStorageServerListInfo.sIP);
                ((StringBuffer)localObject2).append(":");
                ((StringBuffer)localObject2).append(localFileStorageServerListInfo.iPort);
                ((StringBuffer)localObject2).append(",");
              }
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("Domain type=");
              ((StringBuilder)localObject3).append(paramInt);
              ((StringBuilder)localObject3).append(",iplist=");
              ((StringBuilder)localObject3).append(((StringBuffer)localObject2).toString());
              QLog.d("FMT_ADDR", 2, ((StringBuilder)localObject3).toString());
            }
            return localObject1;
          }
          i += 1;
        }
      }
      return null;
    }
    catch (NoSuchFieldError localNoSuchFieldError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMT_ADDR", 2, localNoSuchFieldError.getMessage());
      }
    }
  }
  
  private int getDomainType(int paramInt)
  {
    switch (paramInt)
    {
    case 16: 
    default: 
      return -1;
    case 17: 
      return 16;
    case 15: 
      return 7;
    case 14: 
      return 3;
    case 13: 
      return 2;
    }
    return 1;
  }
  
  public static FMTSrvAddrProvider getInstance()
  {
    if (mSelf == null) {
      synchronized (mlock)
      {
        if (mSelf == null) {
          mSelf = new FMTSrvAddrProvider();
        }
      }
    }
    return mSelf;
  }
  
  private ArrayList<FileStorageServerListInfo> getSvcList(int paramInt)
  {
    FileStoragePushFSSvcList localFileStoragePushFSSvcList = this.mSvcList;
    if (localFileStoragePushFSSvcList != null)
    {
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3)
            {
              if (paramInt != 4)
              {
                if (paramInt != 5)
                {
                  switch (paramInt)
                  {
                  default: 
                    return getBigDataSvcList(getBigDataServiceType(paramInt));
                  case 16: 
                    return this.mGroupPttIpList.getIpList(this.mRichMediaIpSaver.a());
                  case 12: 
                  case 13: 
                  case 14: 
                  case 15: 
                  case 17: 
                    return getDomainSvrList(getDomainType(paramInt));
                  }
                  return localFileStoragePushFSSvcList.vC2CPicDownList;
                }
                return localFileStoragePushFSSvcList.vVipEmotionList;
              }
              return localFileStoragePushFSSvcList.vUrlEncodeServiceList;
            }
            return localFileStoragePushFSSvcList.vQzoneProxyServiceList;
          }
          return localFileStoragePushFSSvcList.vGPicDownLoadList;
        }
        return localFileStoragePushFSSvcList.vPicDownLoadList;
      }
      return localFileStoragePushFSSvcList.vUpLoadList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getSvcList error,mSvcList=null");
    }
    return null;
  }
  
  /* Error */
  private byte[] getTlvByteFromGroupPttIpList(FMTSrvAddrProvider.PttIpList paramPttIpList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +504 -> 505
    //   4: aconst_null
    //   5: checkcast 617	[[B
    //   8: astore 10
    //   10: aload_1
    //   11: getfield 620	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadWifiIPLIst	Ljava/util/ArrayList;
    //   14: ifnull +28 -> 42
    //   17: aload_1
    //   18: getfield 620	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadWifiIPLIst	Ljava/util/ArrayList;
    //   21: invokevirtual 480	java/util/ArrayList:size	()I
    //   24: ifle +18 -> 42
    //   27: aload_1
    //   28: getfield 620	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadWifiIPLIst	Ljava/util/ArrayList;
    //   31: invokevirtual 480	java/util/ArrayList:size	()I
    //   34: anewarray 621	[B
    //   37: astore 8
    //   39: goto +7 -> 46
    //   42: aload 10
    //   44: astore 8
    //   46: aload 10
    //   48: astore 9
    //   50: aload_1
    //   51: getfield 624	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadXGIPLIst	Ljava/util/ArrayList;
    //   54: ifnull +29 -> 83
    //   57: aload 10
    //   59: astore 9
    //   61: aload_1
    //   62: getfield 624	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadXGIPLIst	Ljava/util/ArrayList;
    //   65: invokevirtual 480	java/util/ArrayList:size	()I
    //   68: ifle +15 -> 83
    //   71: aload_1
    //   72: getfield 624	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadXGIPLIst	Ljava/util/ArrayList;
    //   75: invokevirtual 480	java/util/ArrayList:size	()I
    //   78: anewarray 621	[B
    //   81: astore 9
    //   83: new 626	java/io/ByteArrayOutputStream
    //   86: dup
    //   87: invokespecial 627	java/io/ByteArrayOutputStream:<init>	()V
    //   90: astore 12
    //   92: new 629	java/io/DataOutputStream
    //   95: dup
    //   96: aload 12
    //   98: invokespecial 632	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   101: astore 13
    //   103: aload_1
    //   104: getfield 635	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:wifiIdentifier	Ljava/lang/String;
    //   107: astore 10
    //   109: iconst_0
    //   110: istore 7
    //   112: aload 10
    //   114: ifnull +405 -> 519
    //   117: aload 13
    //   119: aload_1
    //   120: getfield 635	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:wifiIdentifier	Ljava/lang/String;
    //   123: invokevirtual 639	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   126: aload 12
    //   128: invokevirtual 640	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   131: astore 10
    //   133: aload 12
    //   135: invokevirtual 643	java/io/ByteArrayOutputStream:reset	()V
    //   138: aload 10
    //   140: arraylength
    //   141: iconst_3
    //   142: iadd
    //   143: iconst_0
    //   144: iadd
    //   145: istore_2
    //   146: iconst_1
    //   147: istore 5
    //   149: goto +3 -> 152
    //   152: aload_1
    //   153: getfield 646	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:xGIdentifier	Ljava/lang/String;
    //   156: ifnull +374 -> 530
    //   159: aload 13
    //   161: aload_1
    //   162: getfield 646	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:xGIdentifier	Ljava/lang/String;
    //   165: invokevirtual 639	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   168: aload 12
    //   170: invokevirtual 640	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   173: astore 11
    //   175: aload 12
    //   177: invokevirtual 643	java/io/ByteArrayOutputStream:reset	()V
    //   180: aload 11
    //   182: arraylength
    //   183: istore_3
    //   184: iload 5
    //   186: iconst_1
    //   187: iadd
    //   188: istore 5
    //   190: iload_2
    //   191: iload_3
    //   192: iconst_3
    //   193: iadd
    //   194: iadd
    //   195: istore_3
    //   196: goto +3 -> 199
    //   199: iload_3
    //   200: istore_2
    //   201: iload 5
    //   203: istore 4
    //   205: aload_1
    //   206: getfield 620	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadWifiIPLIst	Ljava/util/ArrayList;
    //   209: ifnull +110 -> 319
    //   212: iload_3
    //   213: istore_2
    //   214: iload 5
    //   216: istore 4
    //   218: aload_1
    //   219: getfield 620	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadWifiIPLIst	Ljava/util/ArrayList;
    //   222: invokevirtual 480	java/util/ArrayList:size	()I
    //   225: ifle +94 -> 319
    //   228: iload 5
    //   230: istore_2
    //   231: iconst_0
    //   232: istore 4
    //   234: iload 4
    //   236: aload_1
    //   237: getfield 620	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadWifiIPLIst	Ljava/util/ArrayList;
    //   240: invokevirtual 480	java/util/ArrayList:size	()I
    //   243: if_icmpge +295 -> 538
    //   246: aload_1
    //   247: getfield 620	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadWifiIPLIst	Ljava/util/ArrayList;
    //   250: iload 4
    //   252: invokevirtual 481	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   255: checkcast 491	ConfigPush/FileStorageServerListInfo
    //   258: astore 14
    //   260: aload 13
    //   262: aload 14
    //   264: getfield 506	ConfigPush/FileStorageServerListInfo:iPort	I
    //   267: invokevirtual 650	java/io/DataOutputStream:writeInt	(I)V
    //   270: aload 13
    //   272: aload 14
    //   274: getfield 500	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   277: invokevirtual 639	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   280: aload 8
    //   282: iload 4
    //   284: aload 12
    //   286: invokevirtual 640	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   289: aastore
    //   290: aload 12
    //   292: invokevirtual 643	java/io/ByteArrayOutputStream:reset	()V
    //   295: iload_3
    //   296: aload 8
    //   298: iload 4
    //   300: aaload
    //   301: arraylength
    //   302: iconst_3
    //   303: iadd
    //   304: iadd
    //   305: istore_3
    //   306: iload_2
    //   307: iconst_1
    //   308: iadd
    //   309: istore_2
    //   310: iload 4
    //   312: iconst_1
    //   313: iadd
    //   314: istore 4
    //   316: goto -82 -> 234
    //   319: iload_2
    //   320: istore 5
    //   322: iload 4
    //   324: istore 6
    //   326: aload_1
    //   327: getfield 624	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadXGIPLIst	Ljava/util/ArrayList;
    //   330: ifnull +111 -> 441
    //   333: iload_2
    //   334: istore 5
    //   336: iload 4
    //   338: istore 6
    //   340: aload_1
    //   341: getfield 624	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadXGIPLIst	Ljava/util/ArrayList;
    //   344: invokevirtual 480	java/util/ArrayList:size	()I
    //   347: ifle +94 -> 441
    //   350: iload 7
    //   352: istore_3
    //   353: iload_2
    //   354: istore 5
    //   356: iload 4
    //   358: istore 6
    //   360: iload_3
    //   361: aload_1
    //   362: getfield 624	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadXGIPLIst	Ljava/util/ArrayList;
    //   365: invokevirtual 480	java/util/ArrayList:size	()I
    //   368: if_icmpge +73 -> 441
    //   371: aload_1
    //   372: getfield 624	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadXGIPLIst	Ljava/util/ArrayList;
    //   375: iload_3
    //   376: invokevirtual 481	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   379: checkcast 491	ConfigPush/FileStorageServerListInfo
    //   382: astore 14
    //   384: aload 13
    //   386: aload 14
    //   388: getfield 506	ConfigPush/FileStorageServerListInfo:iPort	I
    //   391: invokevirtual 650	java/io/DataOutputStream:writeInt	(I)V
    //   394: aload 13
    //   396: aload 14
    //   398: getfield 500	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   401: invokevirtual 639	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   404: aload 9
    //   406: iload_3
    //   407: aload 12
    //   409: invokevirtual 640	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   412: aastore
    //   413: aload 12
    //   415: invokevirtual 643	java/io/ByteArrayOutputStream:reset	()V
    //   418: iload_2
    //   419: aload 9
    //   421: iload_3
    //   422: aaload
    //   423: arraylength
    //   424: iconst_3
    //   425: iadd
    //   426: iadd
    //   427: istore_2
    //   428: iload 4
    //   430: iconst_1
    //   431: iadd
    //   432: istore 4
    //   434: iload_3
    //   435: iconst_1
    //   436: iadd
    //   437: istore_3
    //   438: goto -85 -> 353
    //   441: aload_0
    //   442: aload 10
    //   444: aload 11
    //   446: aload 8
    //   448: aload 9
    //   450: iload 5
    //   452: iload 6
    //   454: i2b
    //   455: iconst_0
    //   456: invokespecial 652	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:getBytes	([B[B[[B[[BIBI)[B
    //   459: astore_1
    //   460: aload 12
    //   462: invokevirtual 655	java/io/ByteArrayOutputStream:close	()V
    //   465: aload 13
    //   467: invokevirtual 656	java/io/DataOutputStream:close	()V
    //   470: aload_1
    //   471: areturn
    //   472: astore_1
    //   473: goto +20 -> 493
    //   476: astore_1
    //   477: aload_1
    //   478: invokevirtual 659	java/lang/Throwable:printStackTrace	()V
    //   481: aload 12
    //   483: invokevirtual 655	java/io/ByteArrayOutputStream:close	()V
    //   486: aload 13
    //   488: invokevirtual 656	java/io/DataOutputStream:close	()V
    //   491: aconst_null
    //   492: areturn
    //   493: aload 12
    //   495: invokevirtual 655	java/io/ByteArrayOutputStream:close	()V
    //   498: aload 13
    //   500: invokevirtual 656	java/io/DataOutputStream:close	()V
    //   503: aload_1
    //   504: athrow
    //   505: aconst_null
    //   506: areturn
    //   507: astore 8
    //   509: aload_1
    //   510: areturn
    //   511: astore_1
    //   512: aconst_null
    //   513: areturn
    //   514: astore 8
    //   516: goto -13 -> 503
    //   519: aconst_null
    //   520: astore 10
    //   522: iconst_0
    //   523: istore_2
    //   524: iconst_0
    //   525: istore 5
    //   527: goto -375 -> 152
    //   530: aconst_null
    //   531: astore 11
    //   533: iload_2
    //   534: istore_3
    //   535: goto -336 -> 199
    //   538: iload_2
    //   539: istore 4
    //   541: iload_3
    //   542: istore_2
    //   543: goto -224 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	546	0	this	FMTSrvAddrProvider
    //   0	546	1	paramPttIpList	FMTSrvAddrProvider.PttIpList
    //   145	398	2	i	int
    //   183	359	3	j	int
    //   203	337	4	k	int
    //   147	379	5	m	int
    //   324	129	6	n	int
    //   110	241	7	i1	int
    //   37	410	8	localObject1	Object
    //   507	1	8	localThrowable1	Throwable
    //   514	1	8	localThrowable2	Throwable
    //   48	401	9	localObject2	Object
    //   8	513	10	localObject3	Object
    //   173	359	11	arrayOfByte	byte[]
    //   90	404	12	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   101	398	13	localDataOutputStream	java.io.DataOutputStream
    //   258	139	14	localFileStorageServerListInfo	FileStorageServerListInfo
    // Exception table:
    //   from	to	target	type
    //   103	109	472	finally
    //   117	146	472	finally
    //   152	184	472	finally
    //   205	212	472	finally
    //   218	228	472	finally
    //   234	306	472	finally
    //   326	333	472	finally
    //   340	350	472	finally
    //   360	428	472	finally
    //   441	460	472	finally
    //   477	481	472	finally
    //   103	109	476	java/lang/Throwable
    //   117	146	476	java/lang/Throwable
    //   152	184	476	java/lang/Throwable
    //   205	212	476	java/lang/Throwable
    //   218	228	476	java/lang/Throwable
    //   234	306	476	java/lang/Throwable
    //   326	333	476	java/lang/Throwable
    //   340	350	476	java/lang/Throwable
    //   360	428	476	java/lang/Throwable
    //   441	460	476	java/lang/Throwable
    //   460	470	507	java/lang/Throwable
    //   481	491	511	java/lang/Throwable
    //   493	503	514	java/lang/Throwable
  }
  
  private void init()
  {
    int i = 1;
    while (i < 8)
    {
      getBigDataSvcList(i);
      i += 1;
    }
    this.mChooser.init(this.mSvcList);
    FileStoragePushFSSvcList localFileStoragePushFSSvcList = this.mSvcList;
    if ((localFileStoragePushFSSvcList != null) && (localFileStoragePushFSSvcList.fmtIPInfo != null))
    {
      this.mGatewayIp = this.mSvcList.fmtIPInfo.sGateIp;
      this.mGateIpOper = this.mSvcList.fmtIPInfo.iGateIpOper;
    }
    if (this.mSvcList == null)
    {
      this.mGateIpOper = -1L;
      this.mGatewayIp = "";
    }
    downloadEncryptConfInit();
  }
  
  public static String intToIp(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt >> 0 & 0xFF);
    localStringBuilder.append('.');
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append('.');
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append('.');
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  private void parseGroupPttDownloadIPList()
  {
    FileStoragePushFSSvcList localFileStoragePushFSSvcList = this.mSvcList;
    if ((localFileStoragePushFSSvcList != null) && (localFileStoragePushFSSvcList.pttlist != null) && (this.mSvcList.pttlist.length != 0))
    {
      this.mGroupPttIpList = getPttIpListFromTlvByte(this.mSvcList.pttlist);
      return;
    }
    doClearGroupPttDownloadIPList();
  }
  
  /* Error */
  private FileStoragePushFSSvcList readFromFile()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: getstatic 89	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:FMT_SVC_INI	Ljava/lang/String;
    //   10: invokestatic 701	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   13: astore 4
    //   15: aload_3
    //   16: astore_2
    //   17: aload 4
    //   19: invokevirtual 707	java/io/File:length	()J
    //   22: lconst_0
    //   23: lcmp
    //   24: ifne +24 -> 48
    //   27: aload_3
    //   28: astore_2
    //   29: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq +202 -> 234
    //   35: aload_3
    //   36: astore_2
    //   37: ldc 20
    //   39: iconst_2
    //   40: ldc_w 709
    //   43: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aconst_null
    //   47: areturn
    //   48: aload_3
    //   49: astore_2
    //   50: new 711	java/io/FileInputStream
    //   53: dup
    //   54: aload 4
    //   56: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: astore_3
    //   60: sipush 1024
    //   63: newarray byte
    //   65: astore_2
    //   66: new 626	java/io/ByteArrayOutputStream
    //   69: dup
    //   70: invokespecial 627	java/io/ByteArrayOutputStream:<init>	()V
    //   73: astore 4
    //   75: aload_3
    //   76: aload_2
    //   77: invokevirtual 718	java/io/FileInputStream:read	([B)I
    //   80: istore_1
    //   81: iload_1
    //   82: iconst_m1
    //   83: if_icmpeq +14 -> 97
    //   86: aload 4
    //   88: aload_2
    //   89: iconst_0
    //   90: iload_1
    //   91: invokevirtual 722	java/io/ByteArrayOutputStream:write	([BII)V
    //   94: goto -19 -> 75
    //   97: new 724	com/qq/taf/jce/JceInputStream
    //   100: dup
    //   101: aload 4
    //   103: invokevirtual 640	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   106: invokespecial 727	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   109: astore 4
    //   111: new 470	ConfigPush/FileStoragePushFSSvcList
    //   114: dup
    //   115: invokespecial 728	ConfigPush/FileStoragePushFSSvcList:<init>	()V
    //   118: astore_2
    //   119: aload_2
    //   120: aload 4
    //   122: invokevirtual 732	ConfigPush/FileStoragePushFSSvcList:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   125: aload_2
    //   126: astore 5
    //   128: aload_3
    //   129: invokevirtual 733	java/io/FileInputStream:close	()V
    //   132: aload_2
    //   133: areturn
    //   134: astore 4
    //   136: goto +17 -> 153
    //   139: astore 4
    //   141: aload_3
    //   142: astore_2
    //   143: aload 4
    //   145: astore_3
    //   146: goto +64 -> 210
    //   149: astore 4
    //   151: aconst_null
    //   152: astore_2
    //   153: aload 4
    //   155: astore 5
    //   157: aload_2
    //   158: astore 4
    //   160: goto +15 -> 175
    //   163: astore_3
    //   164: goto +46 -> 210
    //   167: astore 5
    //   169: aconst_null
    //   170: astore 4
    //   172: aload 6
    //   174: astore_3
    //   175: aload_3
    //   176: astore_2
    //   177: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +15 -> 195
    //   183: aload_3
    //   184: astore_2
    //   185: ldc 20
    //   187: iconst_2
    //   188: ldc 117
    //   190: aload 5
    //   192: invokestatic 736	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   195: aload_3
    //   196: ifnull +11 -> 207
    //   199: aload 4
    //   201: astore 5
    //   203: aload_3
    //   204: invokevirtual 733	java/io/FileInputStream:close	()V
    //   207: aload 4
    //   209: areturn
    //   210: aload_2
    //   211: ifnull +7 -> 218
    //   214: aload_2
    //   215: invokevirtual 733	java/io/FileInputStream:close	()V
    //   218: goto +5 -> 223
    //   221: aload_3
    //   222: athrow
    //   223: goto -2 -> 221
    //   226: astore_2
    //   227: aload 5
    //   229: areturn
    //   230: astore_2
    //   231: goto -13 -> 218
    //   234: aconst_null
    //   235: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	FMTSrvAddrProvider
    //   80	11	1	i	int
    //   6	209	2	localObject1	Object
    //   226	1	2	localIOException1	java.io.IOException
    //   230	1	2	localIOException2	java.io.IOException
    //   4	142	3	localObject2	Object
    //   163	1	3	localObject3	Object
    //   174	48	3	localObject4	Object
    //   13	108	4	localObject5	Object
    //   134	1	4	localException1	Exception
    //   139	5	4	localObject6	Object
    //   149	5	4	localException2	Exception
    //   158	50	4	localObject7	Object
    //   126	30	5	localObject8	Object
    //   167	24	5	localException3	Exception
    //   201	27	5	localObject9	Object
    //   1	172	6	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   119	125	134	java/lang/Exception
    //   60	75	139	finally
    //   75	81	139	finally
    //   86	94	139	finally
    //   97	119	139	finally
    //   119	125	139	finally
    //   60	75	149	java/lang/Exception
    //   75	81	149	java/lang/Exception
    //   86	94	149	java/lang/Exception
    //   97	119	149	java/lang/Exception
    //   7	15	163	finally
    //   17	27	163	finally
    //   29	35	163	finally
    //   37	46	163	finally
    //   50	60	163	finally
    //   177	183	163	finally
    //   185	195	163	finally
    //   7	15	167	java/lang/Exception
    //   17	27	167	java/lang/Exception
    //   29	35	167	java/lang/Exception
    //   37	46	167	java/lang/Exception
    //   50	60	167	java/lang/Exception
    //   128	132	226	java/io/IOException
    //   203	207	226	java/io/IOException
    //   214	218	230	java/io/IOException
  }
  
  /* Error */
  private void writeToFile(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: getstatic 85	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:FMT_SVC_INI_TMP	Ljava/lang/String;
    //   10: invokestatic 701	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   13: astore 4
    //   15: aload_1
    //   16: ifnonnull +65 -> 81
    //   19: aload_3
    //   20: astore_2
    //   21: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +14 -> 38
    //   27: aload_3
    //   28: astore_2
    //   29: ldc 20
    //   31: iconst_2
    //   32: ldc_w 739
    //   35: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload 4
    //   40: ifnull +215 -> 255
    //   43: aload_3
    //   44: astore_2
    //   45: aload 4
    //   47: invokevirtual 742	java/io/File:exists	()Z
    //   50: ifeq +205 -> 255
    //   53: aload_3
    //   54: astore_2
    //   55: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +14 -> 72
    //   61: aload_3
    //   62: astore_2
    //   63: ldc 20
    //   65: iconst_2
    //   66: ldc_w 744
    //   69: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_3
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 747	java/io/File:delete	()Z
    //   79: pop
    //   80: return
    //   81: aload_3
    //   82: astore_2
    //   83: new 749	com/qq/taf/jce/JceOutputStream
    //   86: dup
    //   87: invokespecial 750	com/qq/taf/jce/JceOutputStream:<init>	()V
    //   90: astore 6
    //   92: aload_3
    //   93: astore_2
    //   94: aload_1
    //   95: aload 6
    //   97: invokevirtual 754	ConfigPush/FileStoragePushFSSvcList:writeTo	(Lcom/qq/taf/jce/JceOutputStream;)V
    //   100: aload_3
    //   101: astore_2
    //   102: aload 6
    //   104: invokevirtual 755	com/qq/taf/jce/JceOutputStream:toByteArray	()[B
    //   107: astore 6
    //   109: aload_3
    //   110: astore_2
    //   111: new 757	java/io/FileOutputStream
    //   114: dup
    //   115: aload 4
    //   117: iconst_0
    //   118: invokespecial 760	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   121: astore_3
    //   122: aload_3
    //   123: aload 6
    //   125: invokevirtual 762	java/io/FileOutputStream:write	([B)V
    //   128: new 703	java/io/File
    //   131: dup
    //   132: getstatic 89	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:FMT_SVC_INI	Ljava/lang/String;
    //   135: invokespecial 764	java/io/File:<init>	(Ljava/lang/String;)V
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 742	java/io/File:exists	()Z
    //   143: ifeq +8 -> 151
    //   146: aload_2
    //   147: invokevirtual 747	java/io/File:delete	()Z
    //   150: pop
    //   151: aload 4
    //   153: aload_2
    //   154: invokevirtual 768	java/io/File:renameTo	(Ljava/io/File;)Z
    //   157: pop
    //   158: aload_3
    //   159: invokevirtual 769	java/io/FileOutputStream:close	()V
    //   162: goto +55 -> 217
    //   165: goto +52 -> 217
    //   168: astore_1
    //   169: aload_3
    //   170: astore_2
    //   171: goto +66 -> 237
    //   174: astore 4
    //   176: goto +12 -> 188
    //   179: astore_1
    //   180: goto +57 -> 237
    //   183: astore 4
    //   185: aload 5
    //   187: astore_3
    //   188: aload_3
    //   189: astore_2
    //   190: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +16 -> 209
    //   196: aload_3
    //   197: astore_2
    //   198: ldc 20
    //   200: iconst_2
    //   201: ldc_w 771
    //   204: aload 4
    //   206: invokestatic 736	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_3
    //   210: ifnull +7 -> 217
    //   213: aload_3
    //   214: invokevirtual 769	java/io/FileOutputStream:close	()V
    //   217: aload_1
    //   218: ifnull +18 -> 236
    //   221: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +12 -> 236
    //   227: ldc 20
    //   229: iconst_2
    //   230: ldc_w 773
    //   233: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: return
    //   237: aload_2
    //   238: ifnull +7 -> 245
    //   241: aload_2
    //   242: invokevirtual 769	java/io/FileOutputStream:close	()V
    //   245: aload_1
    //   246: athrow
    //   247: astore_2
    //   248: goto -83 -> 165
    //   251: astore_2
    //   252: goto -7 -> 245
    //   255: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	FMTSrvAddrProvider
    //   0	256	1	paramFileStoragePushFSSvcList	FileStoragePushFSSvcList
    //   6	236	2	localObject1	Object
    //   247	1	2	localIOException1	java.io.IOException
    //   251	1	2	localIOException2	java.io.IOException
    //   4	210	3	localObject2	Object
    //   13	139	4	localFile	java.io.File
    //   174	1	4	localException1	Exception
    //   183	22	4	localException2	Exception
    //   1	185	5	localObject3	Object
    //   90	34	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   122	151	168	finally
    //   151	158	168	finally
    //   122	151	174	java/lang/Exception
    //   151	158	174	java/lang/Exception
    //   7	15	179	finally
    //   21	27	179	finally
    //   29	38	179	finally
    //   45	53	179	finally
    //   55	61	179	finally
    //   63	72	179	finally
    //   74	80	179	finally
    //   83	92	179	finally
    //   94	100	179	finally
    //   102	109	179	finally
    //   111	122	179	finally
    //   190	196	179	finally
    //   198	209	179	finally
    //   7	15	183	java/lang/Exception
    //   21	27	183	java/lang/Exception
    //   29	38	183	java/lang/Exception
    //   45	53	183	java/lang/Exception
    //   55	61	183	java/lang/Exception
    //   63	72	183	java/lang/Exception
    //   74	80	183	java/lang/Exception
    //   83	92	183	java/lang/Exception
    //   94	100	183	java/lang/Exception
    //   102	109	183	java/lang/Exception
    //   111	122	183	java/lang/Exception
    //   158	162	247	java/io/IOException
    //   213	217	247	java/io/IOException
    //   241	245	251	java/io/IOException
  }
  
  public void clear()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "FMT SERVER LIST CLEARED!!!");
      }
      if (this.mSvcList == null)
      {
        this.mSvcList = new FileStoragePushFSSvcList();
        if (QLog.isColorLevel()) {
          QLog.d("FMT_ADDR", 2, "bug, not supposed to be null");
        }
      }
      ArrayList localArrayList1 = this.mSvcList.vC2CPicDownList;
      ArrayList localArrayList2 = this.mSvcList.vGPicDownLoadList;
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = new FileStoragePushFSSvcList();
      localFileStoragePushFSSvcList.vC2CPicDownList = localArrayList1;
      localFileStoragePushFSSvcList.vGPicDownLoadList = localArrayList2;
      localFileStoragePushFSSvcList.pttlist = this.mSvcList.pttlist;
      setSvcList(localFileStoragePushFSSvcList);
      this.mChooser.clear();
      this.mBigDataSvcList.clear();
      this.mDomainSvrList.clear();
      this.mSvcList = new FileStoragePushFSSvcList();
      this.mSvcList.vC2CPicDownList = localArrayList1;
      this.mSvcList.vGPicDownLoadList = localArrayList2;
      this.mState = 2;
      init();
      return;
    }
    finally {}
  }
  
  public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf downloadEncryptConfInit()
  {
    Object localObject3 = this.mSvcList;
    Object localObject4 = null;
    Object localObject1 = localObject4;
    Object localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject4;
      if (((FileStoragePushFSSvcList)localObject3).bigDataChannel != null)
      {
        localObject1 = localObject4;
        if (this.mSvcList.bigDataChannel.vBigdata_pb_buf != null)
        {
          localObject1 = localObject4;
          if (this.mSvcList.bigDataChannel.vBigdata_pb_buf.length > 0)
          {
            localObject1 = this.mSvcList.bigDataChannel.vBigdata_pb_buf;
            localObject3 = new subcmd0x501.RspBody();
            try
            {
              ((subcmd0x501.RspBody)localObject3).mergeFrom((byte[])localObject1);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              localObject3 = null;
            }
            localObject2 = localObject4;
            if (localObject3 != null)
            {
              localObject3 = ((subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject3).msg_subcmd_0x501_rsp_body.get()).msg_download_encrypt_conf;
              localObject2 = localObject3;
              if (QLog.isColorLevel())
              {
                localObject2 = localObject3;
                if (localObject3 != null)
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("picEncryptSwitchInit: pic:");
                  ((StringBuilder)localObject2).append(((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject3).bool_enable_encrypted_pic.get());
                  ((StringBuilder)localObject2).append(",url:");
                  ((StringBuilder)localObject2).append(((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject3).bool_enable_encrypt_request.get());
                  ((StringBuilder)localObject2).append(",ctlFlg:");
                  ((StringBuilder)localObject2).append(((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject3).uint32_ctrl_flag.get());
                  QLog.d("FMT_ADDR", 2, ((StringBuilder)localObject2).toString());
                  localObject2 = localObject3;
                }
              }
            }
          }
        }
      }
    }
    return localObject2;
  }
  
  public ArrayList<FileStorageServerListInfo> getAllIpList(int paramInt)
  {
    try
    {
      ArrayList localArrayList = getSvcList(paramInt);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public byte[] getBigDataSrvKey(long paramLong)
  {
    try
    {
      if ((this.mSvcList != null) && (this.mSvcList.bigDataChannel != null) && (this.mSvcList.bigDataChannel.uSig_Uin == paramLong))
      {
        byte[] arrayOfByte = this.mSvcList.bigDataChannel.sBigdata_key_session;
        return arrayOfByte;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public byte[] getBigDataSrvSign(long paramLong)
  {
    try
    {
      if ((this.mSvcList != null) && (this.mSvcList.bigDataChannel != null) && (this.mSvcList.bigDataChannel.uSig_Uin == paramLong))
      {
        byte[] arrayOfByte = this.mSvcList.bigDataChannel.sBigdata_sig_session;
        return arrayOfByte;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ServerAddr getFirst(int paramInt)
  {
    try
    {
      ArrayList localArrayList = getSvcList(paramInt);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        ServerAddr localServerAddr = new ServerAddr();
        localServerAddr.mIp = ((FileStorageServerListInfo)localArrayList.get(0)).sIP;
        localServerAddr.port = ((FileStorageServerListInfo)localArrayList.get(0)).iPort;
        return localServerAddr;
      }
      return null;
    }
    finally {}
  }
  
  public long getGateIpOper()
  {
    FileStoragePushFSSvcList localFileStoragePushFSSvcList = readFromFile();
    if ((localFileStoragePushFSSvcList != null) && (localFileStoragePushFSSvcList.fmtIPInfo != null)) {
      return localFileStoragePushFSSvcList.fmtIPInfo.iGateIpOper;
    }
    return -1L;
  }
  
  public long getGateIpOperFromMemeory()
  {
    return this.mGateIpOper;
  }
  
  public String getGateWayIp()
  {
    return this.mGatewayIp;
  }
  
  public HwConfig getHighwayConfig()
  {
    Map localMap = getHighwayConfigMap();
    if (localMap != null) {
      return (HwConfig)localMap.get(Integer.valueOf(10));
    }
    return null;
  }
  
  public Map<Integer, HwConfig> getHighwayConfigMap()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.mSvcList;
    if ((localObject1 != null) && (((FileStoragePushFSSvcList)localObject1).bigDataChannel != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("GetHighwayConfig  Has PbBuffer : ");
      boolean bool;
      if (this.mSvcList.bigDataChannel.vBigdata_pb_buf != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(String.valueOf(bool));
      ((StringBuilder)localObject1).append(" IpList : ");
      ((StringBuilder)localObject1).append(this.mSvcList.bigDataChannel.vBigdata_iplists.size());
      QLog.d("FMT_ADDR", 2, ((StringBuilder)localObject1).toString());
      if ((this.mSvcList.bigDataChannel.vBigdata_pb_buf != null) && (this.mSvcList.bigDataChannel.vBigdata_pb_buf.length > 0))
      {
        byte[] arrayOfByte = this.mSvcList.bigDataChannel.vBigdata_pb_buf;
        localObject1 = new subcmd0x501.RspBody();
        try
        {
          ((subcmd0x501.RspBody)localObject1).mergeFrom(arrayOfByte);
        }
        catch (Exception localException)
        {
          localObject1 = null;
          localException.printStackTrace();
        }
        if (localObject1 != null)
        {
          localObject1 = (subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject1).msg_subcmd_0x501_rsp_body.get();
          Object localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          SessionInfo.updateSessionInfo(((subcmd0x501.SubCmd0x501Rspbody)localObject1).bytes_httpconn_sig_session.get().toByteArray(), ((subcmd0x501.SubCmd0x501Rspbody)localObject1).bytes_session_key.get().toByteArray(), (String)localObject2);
          localObject2 = ((subcmd0x501.SubCmd0x501Rspbody)localObject1).rpt_msg_httpconn_addrs.get();
          if ((localObject2 != null) && (((List)localObject2).size() != 0))
          {
            decodeSrvAddrs(localHashMap, (subcmd0x501.SubCmd0x501Rspbody)localObject1, (List)localObject2);
            return localHashMap;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FMT_ADDR", 2, "GetHighwayConfig srvAddrList == null || srvAddrList.size() == 0");
          }
        }
      }
    }
    return localHashMap;
  }
  
  public ArrayList<FileStorageServerListInfo> getIpListFromPb(byte[] paramArrayOfByte)
  {
    Object localObject = new ptt_apply.QQApplyAuthkeyRsp();
    try
    {
      ((ptt_apply.QQApplyAuthkeyRsp)localObject).mergeFrom(paramArrayOfByte);
      if (((ptt_apply.QQApplyAuthkeyRsp)localObject).address.has())
      {
        paramArrayOfByte = ((ptt_apply.QQApplyAuthkeyRsp)localObject).address.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          localObject = new ArrayList();
          int i = 0;
          while (i < paramArrayOfByte.size())
          {
            ptt_apply.Addr localAddr = (ptt_apply.Addr)paramArrayOfByte.get(i);
            int j = localAddr.uint32_out_ip.get();
            if (j != 0)
            {
              int k = localAddr.uint32_out_port.get();
              ((ArrayList)localObject).add(new FileStorageServerListInfo(intToIp(j), k));
            }
            i += 1;
          }
          return localObject;
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      label134:
      break label134;
    }
    return null;
  }
  
  public StructLongMessageIpSaver getLongMsgIpSaver()
  {
    return this.mLongMsgIpSaver;
  }
  
  public subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf getPicDownEncryptConf()
  {
    if (this.encryptConf == null) {
      this.encryptConf = downloadEncryptConfInit();
    }
    if (QLog.isColorLevel()) {
      if (this.encryptConf != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getPicEncryptSwitch: pic:");
        localStringBuilder.append(this.encryptConf.bool_enable_encrypted_pic.get());
        localStringBuilder.append(",url:");
        localStringBuilder.append(this.encryptConf.bool_enable_encrypt_request.get());
        localStringBuilder.append(",ctlFlag:");
        localStringBuilder.append(this.encryptConf.uint32_ctrl_flag.get());
        QLog.d("FMT_ADDR", 2, localStringBuilder.toString());
      }
      else
      {
        QLog.d("FMT_ADDR", 2, "getPicEncryptSwitch: none!");
      }
    }
    return this.encryptConf;
  }
  
  /* Error */
  public FMTSrvAddrProvider.PttIpList getPttIpListFromTlvByte(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 948	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:isTlvByte	([B)Z
    //   5: ifne +11 -> 16
    //   8: new 112	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList
    //   11: dup
    //   12: invokespecial 113	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:<init>	()V
    //   15: areturn
    //   16: aconst_null
    //   17: astore 10
    //   19: aconst_null
    //   20: astore 8
    //   22: aload_1
    //   23: ifnull +824 -> 847
    //   26: aload_1
    //   27: arraylength
    //   28: ifle +819 -> 847
    //   31: new 112	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList
    //   34: dup
    //   35: invokespecial 113	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:<init>	()V
    //   38: astore 16
    //   40: aload_1
    //   41: iconst_1
    //   42: baload
    //   43: istore 4
    //   45: aconst_null
    //   46: astore 11
    //   48: aload 11
    //   50: astore 8
    //   52: iconst_0
    //   53: istore_2
    //   54: iconst_2
    //   55: istore_3
    //   56: iload_2
    //   57: iload 4
    //   59: if_icmpge +691 -> 750
    //   62: aload_1
    //   63: iload_3
    //   64: baload
    //   65: istore 5
    //   67: iload_3
    //   68: iconst_1
    //   69: iadd
    //   70: istore_3
    //   71: aload 11
    //   73: astore 14
    //   75: aload 8
    //   77: astore 13
    //   79: aload 11
    //   81: astore 15
    //   83: aload 8
    //   85: astore 12
    //   87: iconst_2
    //   88: newarray byte
    //   90: astore 9
    //   92: aload 11
    //   94: astore 14
    //   96: aload 8
    //   98: astore 13
    //   100: aload 11
    //   102: astore 15
    //   104: aload 8
    //   106: astore 12
    //   108: aload_1
    //   109: iload_3
    //   110: aload 9
    //   112: iconst_0
    //   113: iconst_2
    //   114: invokestatic 522	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   117: iload_3
    //   118: iconst_2
    //   119: iadd
    //   120: istore_3
    //   121: aload 11
    //   123: astore 14
    //   125: aload 8
    //   127: astore 13
    //   129: aload 11
    //   131: astore 15
    //   133: aload 8
    //   135: astore 12
    //   137: aload 9
    //   139: iconst_0
    //   140: invokestatic 954	com/tencent/mobileqq/util/Utils:b	([BI)S
    //   143: istore 6
    //   145: aload 11
    //   147: astore 14
    //   149: aload 8
    //   151: astore 13
    //   153: aload 11
    //   155: astore 15
    //   157: aload 8
    //   159: astore 12
    //   161: aload_1
    //   162: iload_3
    //   163: iload 6
    //   165: newarray byte
    //   167: iconst_0
    //   168: iload 6
    //   170: invokestatic 522	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   173: iload 5
    //   175: iconst_1
    //   176: if_icmpne +120 -> 296
    //   179: aload 11
    //   181: astore 14
    //   183: aload 8
    //   185: astore 13
    //   187: aload 11
    //   189: astore 15
    //   191: aload 8
    //   193: astore 12
    //   195: new 956	java/io/ByteArrayInputStream
    //   198: dup
    //   199: aload_1
    //   200: iload_3
    //   201: iload 6
    //   203: invokespecial 958	java/io/ByteArrayInputStream:<init>	([BII)V
    //   206: astore 9
    //   208: aload 9
    //   210: astore 11
    //   212: aload 9
    //   214: astore 12
    //   216: new 960	java/io/DataInputStream
    //   219: dup
    //   220: aload 9
    //   222: invokespecial 963	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   225: astore 10
    //   227: aload 10
    //   229: astore 13
    //   231: aload 9
    //   233: astore 11
    //   235: aload 10
    //   237: astore 14
    //   239: aload 9
    //   241: astore 12
    //   243: aload 16
    //   245: aload 10
    //   247: invokevirtual 966	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   250: putfield 635	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:wifiIdentifier	Ljava/lang/String;
    //   253: goto +349 -> 602
    //   256: astore_1
    //   257: aload 13
    //   259: astore 9
    //   261: goto +16 -> 277
    //   264: astore 9
    //   266: aload 14
    //   268: astore_1
    //   269: goto +20 -> 289
    //   272: astore_1
    //   273: aload 8
    //   275: astore 9
    //   277: aload 11
    //   279: astore 8
    //   281: goto +544 -> 825
    //   284: astore 9
    //   286: aload 8
    //   288: astore_1
    //   289: aload 12
    //   291: astore 8
    //   293: goto +482 -> 775
    //   296: iload 5
    //   298: iconst_2
    //   299: if_icmpne +180 -> 479
    //   302: aload 11
    //   304: astore 14
    //   306: aload 8
    //   308: astore 13
    //   310: aload 11
    //   312: astore 15
    //   314: aload 8
    //   316: astore 12
    //   318: new 956	java/io/ByteArrayInputStream
    //   321: dup
    //   322: aload_1
    //   323: iload_3
    //   324: iload 6
    //   326: invokespecial 958	java/io/ByteArrayInputStream:<init>	([BII)V
    //   329: astore 10
    //   331: aload 10
    //   333: astore 11
    //   335: aload 10
    //   337: astore 12
    //   339: new 960	java/io/DataInputStream
    //   342: dup
    //   343: aload 10
    //   345: invokespecial 963	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   348: astore 9
    //   350: aload 9
    //   352: astore 13
    //   354: aload 10
    //   356: astore 11
    //   358: aload 9
    //   360: astore 14
    //   362: aload 10
    //   364: astore 12
    //   366: aload 16
    //   368: aload 9
    //   370: invokevirtual 966	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   373: putfield 646	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:xGIdentifier	Ljava/lang/String;
    //   376: aload 9
    //   378: astore 13
    //   380: aload 10
    //   382: astore 11
    //   384: aload 9
    //   386: astore 14
    //   388: aload 10
    //   390: astore 12
    //   392: new 956	java/io/ByteArrayInputStream
    //   395: dup
    //   396: aload_1
    //   397: iload_3
    //   398: iload 6
    //   400: invokespecial 958	java/io/ByteArrayInputStream:<init>	([BII)V
    //   403: astore 8
    //   405: new 960	java/io/DataInputStream
    //   408: dup
    //   409: aload 8
    //   411: invokespecial 963	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   414: astore 10
    //   416: aload 16
    //   418: getfield 970	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:xGError	[I
    //   421: iconst_0
    //   422: aload 10
    //   424: invokevirtual 973	java/io/DataInputStream:readInt	()I
    //   427: iastore
    //   428: aload 16
    //   430: getfield 970	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:xGError	[I
    //   433: iconst_1
    //   434: aload 10
    //   436: invokevirtual 973	java/io/DataInputStream:readInt	()I
    //   439: iastore
    //   440: aload 8
    //   442: astore 9
    //   444: goto +158 -> 602
    //   447: astore_1
    //   448: aload 10
    //   450: astore 9
    //   452: goto +373 -> 825
    //   455: astore 9
    //   457: aload 10
    //   459: astore_1
    //   460: goto +315 -> 775
    //   463: astore_1
    //   464: goto +361 -> 825
    //   467: astore 10
    //   469: aload 9
    //   471: astore_1
    //   472: aload 10
    //   474: astore 9
    //   476: goto +299 -> 775
    //   479: iload 5
    //   481: iconst_3
    //   482: if_icmpeq +17 -> 499
    //   485: aload 11
    //   487: astore 9
    //   489: aload 8
    //   491: astore 10
    //   493: iload 5
    //   495: iconst_4
    //   496: if_icmpne +106 -> 602
    //   499: aload 11
    //   501: astore 14
    //   503: aload 8
    //   505: astore 13
    //   507: aload 11
    //   509: astore 15
    //   511: aload 8
    //   513: astore 12
    //   515: new 956	java/io/ByteArrayInputStream
    //   518: dup
    //   519: aload_1
    //   520: iload_3
    //   521: iload 6
    //   523: invokespecial 958	java/io/ByteArrayInputStream:<init>	([BII)V
    //   526: astore 9
    //   528: new 960	java/io/DataInputStream
    //   531: dup
    //   532: aload 9
    //   534: invokespecial 963	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   537: astore 10
    //   539: aload 10
    //   541: invokevirtual 973	java/io/DataInputStream:readInt	()I
    //   544: istore 7
    //   546: aload 10
    //   548: invokevirtual 966	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   551: astore 8
    //   553: iload 5
    //   555: iconst_3
    //   556: if_icmpne +26 -> 582
    //   559: aload 16
    //   561: getfield 620	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadWifiIPLIst	Ljava/util/ArrayList;
    //   564: new 491	ConfigPush/FileStorageServerListInfo
    //   567: dup
    //   568: aload 8
    //   570: iload 7
    //   572: invokespecial 932	ConfigPush/FileStorageServerListInfo:<init>	(Ljava/lang/String;I)V
    //   575: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   578: pop
    //   579: goto +23 -> 602
    //   582: aload 16
    //   584: getfield 624	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadXGIPLIst	Ljava/util/ArrayList;
    //   587: new 491	ConfigPush/FileStorageServerListInfo
    //   590: dup
    //   591: aload 8
    //   593: iload 7
    //   595: invokespecial 932	ConfigPush/FileStorageServerListInfo:<init>	(Ljava/lang/String;I)V
    //   598: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   601: pop
    //   602: aload 9
    //   604: ifnull +24 -> 628
    //   607: aload 9
    //   609: astore 14
    //   611: aload 10
    //   613: astore 13
    //   615: aload 9
    //   617: astore 15
    //   619: aload 10
    //   621: astore 12
    //   623: aload 9
    //   625: invokevirtual 974	java/io/ByteArrayInputStream:close	()V
    //   628: aload 10
    //   630: ifnull +24 -> 654
    //   633: aload 9
    //   635: astore 14
    //   637: aload 10
    //   639: astore 13
    //   641: aload 9
    //   643: astore 15
    //   645: aload 10
    //   647: astore 12
    //   649: aload 10
    //   651: invokevirtual 975	java/io/DataInputStream:close	()V
    //   654: iload_3
    //   655: iload 6
    //   657: iadd
    //   658: istore_3
    //   659: iload_2
    //   660: iconst_1
    //   661: iadd
    //   662: istore_2
    //   663: aload 9
    //   665: astore 11
    //   667: aload 10
    //   669: astore 8
    //   671: goto -615 -> 56
    //   674: astore_1
    //   675: goto +16 -> 691
    //   678: astore 8
    //   680: aload 10
    //   682: astore_1
    //   683: goto +28 -> 711
    //   686: astore_1
    //   687: aload 8
    //   689: astore 10
    //   691: aload 9
    //   693: astore 8
    //   695: aload 10
    //   697: astore 9
    //   699: goto +126 -> 825
    //   702: astore 10
    //   704: aload 8
    //   706: astore_1
    //   707: aload 10
    //   709: astore 8
    //   711: aload 9
    //   713: astore 10
    //   715: aload 8
    //   717: astore 9
    //   719: aload 10
    //   721: astore 8
    //   723: goto +52 -> 775
    //   726: astore_1
    //   727: aload 14
    //   729: astore 8
    //   731: aload 13
    //   733: astore 9
    //   735: goto +90 -> 825
    //   738: astore 9
    //   740: aload 15
    //   742: astore 8
    //   744: aload 12
    //   746: astore_1
    //   747: goto +28 -> 775
    //   750: aload 16
    //   752: astore_1
    //   753: aload 11
    //   755: astore 10
    //   757: goto +95 -> 852
    //   760: astore_1
    //   761: aconst_null
    //   762: astore 8
    //   764: aload 8
    //   766: astore 9
    //   768: goto +57 -> 825
    //   771: astore 9
    //   773: aconst_null
    //   774: astore_1
    //   775: aload 9
    //   777: invokevirtual 659	java/lang/Throwable:printStackTrace	()V
    //   780: new 112	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList
    //   783: dup
    //   784: invokespecial 113	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:<init>	()V
    //   787: astore 10
    //   789: aload 8
    //   791: ifnull +103 -> 894
    //   794: aload 10
    //   796: astore 9
    //   798: aload 8
    //   800: invokevirtual 974	java/io/ByteArrayInputStream:close	()V
    //   803: goto +91 -> 894
    //   806: aload 10
    //   808: astore 9
    //   810: aload_1
    //   811: invokevirtual 975	java/io/DataInputStream:close	()V
    //   814: aload 10
    //   816: areturn
    //   817: astore 10
    //   819: aload_1
    //   820: astore 9
    //   822: aload 10
    //   824: astore_1
    //   825: aload 8
    //   827: ifnull +8 -> 835
    //   830: aload 8
    //   832: invokevirtual 974	java/io/ByteArrayInputStream:close	()V
    //   835: aload 9
    //   837: ifnull +8 -> 845
    //   840: aload 9
    //   842: invokevirtual 975	java/io/DataInputStream:close	()V
    //   845: aload_1
    //   846: athrow
    //   847: aconst_null
    //   848: astore_1
    //   849: aload_1
    //   850: astore 8
    //   852: aload 10
    //   854: ifnull +11 -> 865
    //   857: aload_1
    //   858: astore 9
    //   860: aload 10
    //   862: invokevirtual 974	java/io/ByteArrayInputStream:close	()V
    //   865: aload_1
    //   866: astore 9
    //   868: aload 8
    //   870: ifnull +12 -> 882
    //   873: aload_1
    //   874: astore 10
    //   876: aload 8
    //   878: astore_1
    //   879: goto -73 -> 806
    //   882: aload 9
    //   884: areturn
    //   885: astore_1
    //   886: aload 9
    //   888: areturn
    //   889: astore 8
    //   891: goto -46 -> 845
    //   894: aload 10
    //   896: astore 9
    //   898: aload_1
    //   899: ifnull -17 -> 882
    //   902: goto -96 -> 806
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	905	0	this	FMTSrvAddrProvider
    //   0	905	1	paramArrayOfByte	byte[]
    //   53	610	2	i	int
    //   55	604	3	j	int
    //   43	17	4	k	int
    //   65	492	5	m	int
    //   143	515	6	n	int
    //   544	50	7	i1	int
    //   20	650	8	localObject1	Object
    //   678	10	8	localThrowable1	Throwable
    //   693	184	8	localObject2	Object
    //   889	1	8	localThrowable2	Throwable
    //   90	170	9	localObject3	Object
    //   264	1	9	localThrowable3	Throwable
    //   275	1	9	localObject4	Object
    //   284	1	9	localThrowable4	Throwable
    //   348	103	9	localObject5	Object
    //   455	15	9	localThrowable5	Throwable
    //   474	260	9	localObject6	Object
    //   738	1	9	localThrowable6	Throwable
    //   766	1	9	localObject7	Object
    //   771	5	9	localThrowable7	Throwable
    //   796	101	9	localObject8	Object
    //   17	441	10	localObject9	Object
    //   467	6	10	localThrowable8	Throwable
    //   491	205	10	localObject10	Object
    //   702	6	10	localThrowable9	Throwable
    //   713	102	10	localObject11	Object
    //   817	44	10	localObject12	Object
    //   874	21	10	arrayOfByte	byte[]
    //   46	708	11	localObject13	Object
    //   85	660	12	localObject14	Object
    //   77	655	13	localObject15	Object
    //   73	655	14	localObject16	Object
    //   81	660	15	localObject17	Object
    //   38	713	16	localPttIpList	FMTSrvAddrProvider.PttIpList
    // Exception table:
    //   from	to	target	type
    //   243	253	256	finally
    //   366	376	256	finally
    //   392	405	256	finally
    //   243	253	264	java/lang/Throwable
    //   366	376	264	java/lang/Throwable
    //   392	405	264	java/lang/Throwable
    //   216	227	272	finally
    //   339	350	272	finally
    //   216	227	284	java/lang/Throwable
    //   339	350	284	java/lang/Throwable
    //   416	440	447	finally
    //   416	440	455	java/lang/Throwable
    //   405	416	463	finally
    //   405	416	467	java/lang/Throwable
    //   539	553	674	finally
    //   559	579	674	finally
    //   582	602	674	finally
    //   539	553	678	java/lang/Throwable
    //   559	579	678	java/lang/Throwable
    //   582	602	678	java/lang/Throwable
    //   528	539	686	finally
    //   528	539	702	java/lang/Throwable
    //   87	92	726	finally
    //   108	117	726	finally
    //   137	145	726	finally
    //   161	173	726	finally
    //   195	208	726	finally
    //   318	331	726	finally
    //   515	528	726	finally
    //   623	628	726	finally
    //   649	654	726	finally
    //   87	92	738	java/lang/Throwable
    //   108	117	738	java/lang/Throwable
    //   137	145	738	java/lang/Throwable
    //   161	173	738	java/lang/Throwable
    //   195	208	738	java/lang/Throwable
    //   318	331	738	java/lang/Throwable
    //   515	528	738	java/lang/Throwable
    //   623	628	738	java/lang/Throwable
    //   649	654	738	java/lang/Throwable
    //   26	40	760	finally
    //   26	40	771	java/lang/Throwable
    //   775	789	817	finally
    //   798	803	885	java/lang/Throwable
    //   810	814	885	java/lang/Throwable
    //   860	865	885	java/lang/Throwable
    //   830	835	889	java/lang/Throwable
    //   840	845	889	java/lang/Throwable
  }
  
  public IRichMediaIpSaver getPttIpSaver()
  {
    return this.mRichMediaIpSaver;
  }
  
  public String getSrvAddr(int paramInt)
  {
    Object localObject1 = null;
    try
    {
      FileStorageServerListInfo localFileStorageServerListInfo = this.mChooser.getAddr(paramInt);
      if (localFileStorageServerListInfo != null)
      {
        localObject1 = new StringBuffer(200);
        ((StringBuffer)localObject1).append("http://");
        ((StringBuffer)localObject1).append(localFileStorageServerListInfo.sIP);
        if (localFileStorageServerListInfo.iPort != 80)
        {
          ((StringBuffer)localObject1).append(":");
          ((StringBuffer)localObject1).append(localFileStorageServerListInfo.iPort);
        }
        ((StringBuffer)localObject1).append("/");
        localObject1 = ((StringBuffer)localObject1).toString();
      }
      return localObject1;
    }
    finally {}
  }
  
  public String getSrvAddrForPttDownload()
  {
    Object localObject1 = null;
    try
    {
      FileStorageServerListInfo localFileStorageServerListInfo = this.mChooser.getAddrForPttDownload();
      if (localFileStorageServerListInfo != null)
      {
        localObject1 = new StringBuffer(200);
        ((StringBuffer)localObject1).append("http://");
        ((StringBuffer)localObject1).append(localFileStorageServerListInfo.sIP);
        if (localFileStorageServerListInfo.iPort != 80)
        {
          ((StringBuffer)localObject1).append(":");
          ((StringBuffer)localObject1).append(localFileStorageServerListInfo.iPort);
        }
        ((StringBuffer)localObject1).append("/");
        localObject1 = ((StringBuffer)localObject1).toString();
      }
      return localObject1;
    }
    finally {}
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public FileStoragePushFSSvcList getSvcListCache()
  {
    try
    {
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = this.mSvcListCache;
      return localFileStoragePushFSSvcList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isTlvByte(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      int i;
      int k;
      int j;
      try
      {
        if (paramArrayOfByte.length != 0) {
          break label82;
        }
        return false;
      }
      catch (Throwable paramArrayOfByte)
      {
        byte[] arrayOfByte;
        return false;
      }
      if (i < k)
      {
        j += 1;
        arrayOfByte = new byte[2];
        System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 2);
        j = j + 2 + Utils.b(arrayOfByte, 0);
        if (j > paramArrayOfByte.length) {
          return false;
        }
      }
      else
      {
        i = paramArrayOfByte.length;
        bool1 = bool2;
        if (j == i) {
          bool1 = true;
        }
        return bool1;
        label82:
        if (paramArrayOfByte[0] != 0) {
          return false;
        }
        k = paramArrayOfByte[1];
        i = 0;
        j = 2;
        continue;
      }
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    this.mRichMediaIpSaver.b();
    this.mLongMsgIpSaver.destroy();
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    if (paramInt == 16) {}
    try
    {
      this.mGroupPttIpList.onFailed(this.mRichMediaIpSaver.a(), paramString);
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onFailed for GroupPtt: ");
        localStringBuilder.append(paramString);
        QLog.d("SPD", 4, localStringBuilder.toString());
        break label76;
        this.mChooser.onFailed(paramInt, paramString);
      }
      label76:
      return;
    }
    finally {}
  }
  
  public byte[] replaceWithTLVForPtt(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = getIpListFromPb(paramArrayOfByte);
    String str = this.mRichMediaIpSaver.a();
    boolean bool = this.mRichMediaIpSaver.c();
    FMTSrvAddrProvider.PttIpList localPttIpList = this.mGroupPttIpList;
    if (localPttIpList != null) {
      if (bool)
      {
        localPttIpList.groupPttDownloadWifiIPLIst = paramArrayOfByte;
        localPttIpList.wifiIdentifier = str;
      }
      else
      {
        localPttIpList.groupPttDownloadXGIPLIst = paramArrayOfByte;
        localPttIpList.xGIdentifier = str;
      }
    }
    return getTlvByteFromGroupPttIpList(this.mGroupPttIpList);
  }
  
  public void setSvcList(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set svclist");
        localStringBuilder.append(paramFileStoragePushFSSvcList);
        QLog.d("FMT_ADDR", 2, localStringBuilder.toString());
      }
      this.mSvcList = paramFileStoragePushFSSvcList;
      this.mState = 1;
      init();
      writeToFile(paramFileStoragePushFSSvcList);
      return;
    }
    finally {}
  }
  
  public void setSvcListCache(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSvcListCache");
        localStringBuilder.append(paramFileStoragePushFSSvcList);
        QLog.d("FMT_ADDR", 2, localStringBuilder.toString());
      }
      this.mSvcListCache = paramFileStoragePushFSSvcList;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FMTSrvAddrProvider
 * JD-Core Version:    0.7.0.1
 */