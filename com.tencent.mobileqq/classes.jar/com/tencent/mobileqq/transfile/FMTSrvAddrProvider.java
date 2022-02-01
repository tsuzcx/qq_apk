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
import com.tencent.mobileqq.ptt.PttIpSaver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import tencent.im.cs.ptt_apply.ptt_apply.Addr;
import tencent.im.cs.ptt_apply.ptt_apply.QQApplyAuthkeyRsp;

@Deprecated
public final class FMTSrvAddrProvider
{
  private static final String FMT_PICDOWN_IPLIST = AppConstants.SDCARD_DATABASE + "ipDownAddr.ini";
  private static final String FMT_PICDOWN_IPLIST_TMP = AppConstants.SDCARD_DATABASE + "ipDownAddr.tmp";
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
  private PttIpSaver mPttIpSaver = new PttIpSaver();
  private int mState = 0;
  private FileStoragePushFSSvcList mSvcList = readFromFile();
  private FileStoragePushFSSvcList mSvcListCache;
  public Object saveSvcListLock = new Object();
  
  static
  {
    FMT_SVC_INI_TMP = AppConstants.SDCARD_DATABASE + "fmtSrvAddr.ini";
    FMT_SVC_INI = AppConstants.SDCARD_DATABASE + "srvAddr.ini";
  }
  
  private FMTSrvAddrProvider()
  {
    parseGroupPttDownloadIPList();
    init();
  }
  
  private void decodeSrvAddrs(Map<Integer, HwConfig> paramMap, subcmd0x501.SubCmd0x501Rspbody paramSubCmd0x501Rspbody, List<subcmd0x501.SubCmd0x501Rspbody.SrvAddrs> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)paramList.next();
      int j = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject).uint32_service_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "GetHighwayConfig   find HwServlet.HIGHWAY_SERVICE_TYPE" + j);
      }
      if (j == 10)
      {
        HwConfig localHwConfig = generateConfig((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject);
        localHwConfig.netSegConfList = new ArrayList();
        localObject = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject).rpt_msg_netsegconf.get();
        if ((localObject != null) && (((List)localObject).size() != 0))
        {
          int i = 0;
          while (i < ((List)localObject).size())
          {
            subcmd0x501.SubCmd0x501Rspbody.NetSegConf localNetSegConf = (subcmd0x501.SubCmd0x501Rspbody.NetSegConf)((List)localObject).get(i);
            localHwConfig.netSegConfList.add(new HwNetSegConf(localNetSegConf.uint32_net_type.get(), localNetSegConf.uint32_segsize.get(), localNetSegConf.uint32_segnum.get(), localNetSegConf.uint32_curconnnum.get()));
            i += 1;
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
        if (paramSubCmd0x501Rspbody.msg_short_video_conf.has())
        {
          localHwConfig.videoConf = paramSubCmd0x501Rspbody.msg_short_video_conf;
          label305:
          if (!paramSubCmd0x501Rspbody.msg_ptv_conf.has()) {
            break label416;
          }
          localHwConfig.ptvCof = paramSubCmd0x501Rspbody.msg_ptv_conf;
          label324:
          if (!paramSubCmd0x501Rspbody.uint32_fmt_policy.has()) {
            break label434;
          }
          localHwConfig.fmtIpv6Policy = paramSubCmd0x501Rspbody.uint32_fmt_policy;
          label343:
          if (!paramSubCmd0x501Rspbody.uint32_bigdata_policy.has()) {
            break label452;
          }
          localHwConfig.bdhIpv6Policy = paramSubCmd0x501Rspbody.uint32_bigdata_policy;
          label362:
          if (!paramSubCmd0x501Rspbody.uint32_conn_attempt_delay.has()) {
            break label470;
          }
          localHwConfig.connAttemptDelay = paramSubCmd0x501Rspbody.uint32_conn_attempt_delay;
        }
        for (;;)
        {
          paramMap.put(Integer.valueOf(j), localHwConfig);
          break;
          if (!QLog.isColorLevel()) {
            break label305;
          }
          QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_short_video_conf.has() : false ! ");
          break label305;
          label416:
          if (!QLog.isColorLevel()) {
            break label324;
          }
          QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.msg_ptv_conf.has() : false ! ");
          break label324;
          label434:
          if (!QLog.isColorLevel()) {
            break label343;
          }
          QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_fmt_policy.has() : false ! ");
          break label343;
          label452:
          if (!QLog.isColorLevel()) {
            break label362;
          }
          QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_bigdata_policy.has() : false ! ");
          break label362;
          label470:
          if (QLog.isColorLevel()) {
            QLog.d("FMT_ADDR", 2, "<BDH_LOG> getHighwayConfig from push. rspBody.uint32_conn_attempt_delay.has() : false ! ");
          }
        }
      }
      if (j == 21) {
        paramMap.put(Integer.valueOf(j), generateConfig((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)localObject));
      }
    }
  }
  
  public static void destroy()
  {
    if (mSelf == null) {
      return;
    }
    mSelf.onDestroy();
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
      if (i < ((List)localObject1).size())
      {
        localObject2 = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)((List)localObject1).get(i);
        localObject3 = localHwConfig.ipList;
        String str = HwServlet.spliceCircleUrl(((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_ip.get());
        j = ((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_port.get();
        if (((subcmd0x501.SubCmd0x501Rspbody.IpAddr)localObject2).uint32_same_isp.get() == 1) {}
        for (bool = true;; bool = false)
        {
          ((ArrayList)localObject3).add(new EndPoint(str, j, bool));
          i += 1;
          break;
        }
      }
    }
    localHwConfig.ipv6List = new ArrayList();
    paramSrvAddrs = paramSrvAddrs.rpt_msg_addrs_v6.get();
    if ((paramSrvAddrs != null) && (paramSrvAddrs.size() != 0))
    {
      i = 0;
      if (i < paramSrvAddrs.size())
      {
        localObject1 = (subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)paramSrvAddrs.get(i);
        localObject2 = localHwConfig.ipv6List;
        localObject3 = HwServlet.spliceIpv6Url(((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject1).bytes_ip6.get().toByteArray());
        j = ((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject1).uint32_port.get();
        if (((subcmd0x501.SubCmd0x501Rspbody.Ip6Addr)localObject1).uint32_same_isp.get() == 1) {}
        for (bool = true;; bool = false)
        {
          ((ArrayList)localObject2).add(new EndPoint((String)localObject3, j, bool));
          i += 1;
          break;
        }
      }
    }
    return localHwConfig;
  }
  
  private int getBigDataServiceType(int paramInt)
  {
    if (paramInt == 6) {}
    do
    {
      return 1;
      if (paramInt == 7) {
        return 2;
      }
      if (paramInt == 8) {
        return 3;
      }
      if (paramInt == 9) {
        return 4;
      }
    } while (paramInt != 10);
    return 5;
  }
  
  private ArrayList<FileStorageServerListInfo> getBigDataSvcList(int paramInt)
  {
    int j = 0;
    if (this.mBigDataSvcList.containsKey(Integer.valueOf(paramInt))) {
      return (ArrayList)this.mBigDataSvcList.get(Integer.valueOf(paramInt));
    }
    if ((this.mSvcList != null) && (this.mSvcList.bigDataChannel != null) && (this.mSvcList.bigDataChannel.vBigdata_iplists != null))
    {
      int i = 0;
      while (i < this.mSvcList.bigDataChannel.vBigdata_iplists.size())
      {
        Object localObject = (BigDataIpList)this.mSvcList.bigDataChannel.vBigdata_iplists.get(i);
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
        paramInt2 = 0;
        while (paramInt2 < paramArrayOfByte3.length)
        {
          arrayOfByte1[paramInt1] = 3;
          paramInt1 += 1;
          paramArrayOfByte1 = PkgTools.shortToHL((short)paramArrayOfByte3[paramInt2].length);
          System.arraycopy(paramArrayOfByte1, 0, arrayOfByte1, paramInt1, paramArrayOfByte1.length);
          paramInt1 += paramArrayOfByte1.length;
          System.arraycopy(paramArrayOfByte3[paramInt2], 0, arrayOfByte1, paramInt1, paramArrayOfByte3[paramInt2].length);
          paramInt1 += paramArrayOfByte3[paramInt2].length;
          paramInt2 += 1;
        }
        paramInt2 = paramInt1;
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
    int j = 0;
    if (this.mDomainSvrList.containsKey(Integer.valueOf(paramInt))) {
      return (ArrayList)this.mDomainSvrList.get(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      int i;
      Object localObject2;
      try
      {
        if ((this.mSvcList != null) && (this.mSvcList.domainIpChannel != null) && (this.mSvcList.domainIpChannel.vDomain_iplists != null))
        {
          i = 0;
          if (i < this.mSvcList.domainIpChannel.vDomain_iplists.size())
          {
            Object localObject1 = (DomainIpList)this.mSvcList.domainIpChannel.vDomain_iplists.get(i);
            if (((DomainIpList)localObject1).uDomain_type != paramInt) {
              break label352;
            }
            localObject2 = ((DomainIpList)localObject1).vIplist;
            localObject1 = new ArrayList();
            i = j;
            if (i < ((ArrayList)localObject2).size())
            {
              localObject3 = new FileStorageServerListInfo();
              ((FileStorageServerListInfo)localObject3).sIP = NetworkUtil.a(((DomainIpInfo)((ArrayList)localObject2).get(i)).uIp);
              ((FileStorageServerListInfo)localObject3).iPort = ((DomainIpInfo)((ArrayList)localObject2).get(i)).uPort;
              ((ArrayList)localObject1).add(localObject3);
              i += 1;
              continue;
            }
            this.mDomainSvrList.put(Integer.valueOf(paramInt), localObject1);
            if (!QLog.isColorLevel()) {
              break label349;
            }
            localObject2 = new StringBuffer();
            Object localObject3 = ((ArrayList)localObject1).iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break label309;
            }
            FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)((Iterator)localObject3).next();
            ((StringBuffer)localObject2).append(localFileStorageServerListInfo.sIP).append(":").append(localFileStorageServerListInfo.iPort).append(",");
            continue;
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
      label309:
      QLog.d("FMT_ADDR", 2, "Domain type=" + paramInt + ",iplist=" + ((StringBuffer)localObject2).toString());
      label349:
      return localNoSuchFieldError;
      label352:
      i += 1;
    }
  }
  
  private int getDomainType(int paramInt)
  {
    switch (paramInt)
    {
    case 16: 
    default: 
      return -1;
    case 12: 
      return 1;
    case 13: 
      return 2;
    case 14: 
      return 3;
    case 15: 
      return 7;
    }
    return 16;
  }
  
  public static FMTSrvAddrProvider getInstance()
  {
    if (mSelf == null) {}
    synchronized (mlock)
    {
      if (mSelf == null) {
        mSelf = new FMTSrvAddrProvider();
      }
      return mSelf;
    }
  }
  
  private ArrayList<FileStorageServerListInfo> getSvcList(int paramInt)
  {
    if (this.mSvcList != null)
    {
      switch (paramInt)
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      default: 
        return getBigDataSvcList(getBigDataServiceType(paramInt));
      case 0: 
        return this.mSvcList.vUpLoadList;
      case 1: 
        return this.mSvcList.vPicDownLoadList;
      case 2: 
        return this.mSvcList.vGPicDownLoadList;
      case 3: 
        return this.mSvcList.vQzoneProxyServiceList;
      case 4: 
        return this.mSvcList.vUrlEncodeServiceList;
      case 5: 
        return this.mSvcList.vVipEmotionList;
      case 11: 
        return this.mSvcList.vC2CPicDownList;
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 17: 
        return getDomainSvrList(getDomainType(paramInt));
      }
      return this.mGroupPttIpList.getIpList(this.mPttIpSaver.b());
    }
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "getSvcList error,mSvcList=null");
    }
    return null;
  }
  
  private byte[] getTlvByteFromGroupPttIpList(FMTSrvAddrProvider.PttIpList paramPttIpList)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    label81:
    ByteArrayOutputStream localByteArrayOutputStream;
    DataOutputStream localDataOutputStream;
    if (paramPttIpList != null)
    {
      localObject1 = (byte[][])null;
      localObject2 = (byte[][])null;
      if ((paramPttIpList.groupPttDownloadWifiIPLIst == null) || (paramPttIpList.groupPttDownloadWifiIPLIst.size() <= 0)) {
        break label567;
      }
      localObject1 = new byte[paramPttIpList.groupPttDownloadWifiIPLIst.size()][];
      if ((paramPttIpList.groupPttDownloadXGIPLIst == null) || (paramPttIpList.groupPttDownloadXGIPLIst.size() <= 0)) {
        break label564;
      }
      localObject2 = new byte[paramPttIpList.groupPttDownloadXGIPLIst.size()][];
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    }
    for (;;)
    {
      try
      {
        if (paramPttIpList.wifiIdentifier == null) {
          break label553;
        }
        localDataOutputStream.writeUTF(paramPttIpList.wifiIdentifier);
        arrayOfByte1 = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.reset();
        m = 0 + (arrayOfByte1.length + 3);
        j = 1;
        if (paramPttIpList.xGIdentifier != null)
        {
          localDataOutputStream.writeUTF(paramPttIpList.xGIdentifier);
          arrayOfByte2 = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.reset();
          m += arrayOfByte2.length + 3;
          j += 1;
          i = j;
          k = m;
          FileStorageServerListInfo localFileStorageServerListInfo;
          if (paramPttIpList.groupPttDownloadWifiIPLIst != null)
          {
            i = j;
            k = m;
            if (paramPttIpList.groupPttDownloadWifiIPLIst.size() > 0)
            {
              k = 0;
              i = m;
              if (k >= paramPttIpList.groupPttDownloadWifiIPLIst.size()) {
                break label570;
              }
              localFileStorageServerListInfo = (FileStorageServerListInfo)paramPttIpList.groupPttDownloadWifiIPLIst.get(k);
              localDataOutputStream.writeInt(localFileStorageServerListInfo.iPort);
              localDataOutputStream.writeUTF(localFileStorageServerListInfo.sIP);
              localObject1[k] = localByteArrayOutputStream.toByteArray();
              localByteArrayOutputStream.reset();
              i += localObject1[k].length + 3;
              j += 1;
              k += 1;
              continue;
            }
          }
          j = i;
          m = k;
          if (paramPttIpList.groupPttDownloadXGIPLIst != null)
          {
            j = i;
            m = k;
            if (paramPttIpList.groupPttDownloadXGIPLIst.size() > 0)
            {
              int n = 0;
              j = k;
              m = i;
              k = n;
              i = j;
              j = m;
              if (k >= paramPttIpList.groupPttDownloadXGIPLIst.size()) {
                break label578;
              }
              localFileStorageServerListInfo = (FileStorageServerListInfo)paramPttIpList.groupPttDownloadXGIPLIst.get(k);
              localDataOutputStream.writeInt(localFileStorageServerListInfo.iPort);
              localDataOutputStream.writeUTF(localFileStorageServerListInfo.sIP);
              localObject2[k] = localByteArrayOutputStream.toByteArray();
              localByteArrayOutputStream.reset();
              i += localObject2[k].length + 3;
              j += 1;
              k += 1;
              continue;
            }
          }
          paramPttIpList = getBytes(arrayOfByte1, arrayOfByte2, (byte[][])localObject1, (byte[][])localObject2, m, (byte)j, 0);
          if (localByteArrayOutputStream == null) {}
        }
        byte[] arrayOfByte2 = null;
      }
      catch (Throwable paramPttIpList)
      {
        paramPttIpList = paramPttIpList;
        paramPttIpList.printStackTrace();
        if (localByteArrayOutputStream != null) {}
        try
        {
          localByteArrayOutputStream.close();
          localObject1 = localObject3;
          if (localDataOutputStream == null) {
            continue;
          }
          localDataOutputStream.close();
          return null;
        }
        catch (Throwable paramPttIpList)
        {
          return null;
        }
      }
      finally
      {
        if (localByteArrayOutputStream != null) {}
        try
        {
          localByteArrayOutputStream.close();
          if (localDataOutputStream != null) {
            localDataOutputStream.close();
          }
        }
        catch (Throwable localThrowable1)
        {
          continue;
        }
      }
      continue;
      label553:
      int j = 0;
      int m = 0;
      byte[] arrayOfByte1 = null;
      continue;
      label564:
      break label81;
      label567:
      break;
      label570:
      int k = i;
      int i = j;
      continue;
      label578:
      m = i;
    }
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
    if ((this.mSvcList != null) && (this.mSvcList.fmtIPInfo != null))
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
    return (paramInt >> 0 & 0xFF) + '.' + (paramInt >> 8 & 0xFF) + '.' + (paramInt >> 16 & 0xFF) + '.' + (paramInt >> 24 & 0xFF);
  }
  
  private void parseGroupPttDownloadIPList()
  {
    if ((this.mSvcList == null) || (this.mSvcList.pttlist == null) || (this.mSvcList.pttlist.length == 0))
    {
      doClearGroupPttDownloadIPList();
      return;
    }
    this.mGroupPttIpList = getPttIpListFromTlvByte(this.mSvcList.pttlist);
  }
  
  /* Error */
  private FileStoragePushFSSvcList readFromFile()
  {
    // Byte code:
    //   0: getstatic 83	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:FMT_SVC_INI	Ljava/lang/String;
    //   3: invokestatic 683	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 689	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +34 -> 47
    //   16: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +12 -> 31
    //   22: ldc 20
    //   24: iconst_2
    //   25: ldc_w 691
    //   28: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: iconst_0
    //   32: ifeq +11 -> 43
    //   35: new 693	java/lang/NullPointerException
    //   38: dup
    //   39: invokespecial 694	java/lang/NullPointerException:<init>	()V
    //   42: athrow
    //   43: aconst_null
    //   44: astore_3
    //   45: aload_3
    //   46: areturn
    //   47: new 696	java/io/FileInputStream
    //   50: dup
    //   51: aload_2
    //   52: invokespecial 699	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore 5
    //   57: aload 5
    //   59: astore_3
    //   60: sipush 1024
    //   63: newarray byte
    //   65: astore_2
    //   66: aload 5
    //   68: astore_3
    //   69: new 609	java/io/ByteArrayOutputStream
    //   72: dup
    //   73: invokespecial 610	java/io/ByteArrayOutputStream:<init>	()V
    //   76: astore 4
    //   78: aload 5
    //   80: astore_3
    //   81: aload 5
    //   83: aload_2
    //   84: invokevirtual 703	java/io/FileInputStream:read	([B)I
    //   87: istore_1
    //   88: iload_1
    //   89: iconst_m1
    //   90: if_icmpeq +60 -> 150
    //   93: aload 5
    //   95: astore_3
    //   96: aload 4
    //   98: aload_2
    //   99: iconst_0
    //   100: iload_1
    //   101: invokevirtual 707	java/io/ByteArrayOutputStream:write	([BII)V
    //   104: goto -26 -> 78
    //   107: astore 4
    //   109: aconst_null
    //   110: astore_2
    //   111: aload 5
    //   113: astore_3
    //   114: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +16 -> 133
    //   120: aload 5
    //   122: astore_3
    //   123: ldc 20
    //   125: iconst_2
    //   126: ldc 111
    //   128: aload 4
    //   130: invokestatic 710	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   133: aload_2
    //   134: astore_3
    //   135: aload 5
    //   137: ifnull -92 -> 45
    //   140: aload 5
    //   142: invokevirtual 711	java/io/FileInputStream:close	()V
    //   145: aload_2
    //   146: areturn
    //   147: astore_3
    //   148: aload_2
    //   149: areturn
    //   150: aload 5
    //   152: astore_3
    //   153: new 713	com/qq/taf/jce/JceInputStream
    //   156: dup
    //   157: aload 4
    //   159: invokevirtual 623	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   162: invokespecial 716	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   165: astore 4
    //   167: aload 5
    //   169: astore_3
    //   170: new 455	ConfigPush/FileStoragePushFSSvcList
    //   173: dup
    //   174: invokespecial 717	ConfigPush/FileStoragePushFSSvcList:<init>	()V
    //   177: astore_2
    //   178: aload 5
    //   180: astore_3
    //   181: aload_2
    //   182: aload 4
    //   184: invokevirtual 721	ConfigPush/FileStoragePushFSSvcList:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   187: aload_2
    //   188: astore_3
    //   189: aload 5
    //   191: ifnull -146 -> 45
    //   194: aload 5
    //   196: invokevirtual 711	java/io/FileInputStream:close	()V
    //   199: aload_2
    //   200: areturn
    //   201: astore_3
    //   202: aload_2
    //   203: areturn
    //   204: astore_2
    //   205: aconst_null
    //   206: astore_3
    //   207: aload_3
    //   208: ifnull +7 -> 215
    //   211: aload_3
    //   212: invokevirtual 711	java/io/FileInputStream:close	()V
    //   215: aload_2
    //   216: athrow
    //   217: astore_2
    //   218: goto -175 -> 43
    //   221: astore_3
    //   222: goto -7 -> 215
    //   225: astore_2
    //   226: goto -19 -> 207
    //   229: astore 4
    //   231: aconst_null
    //   232: astore 5
    //   234: aconst_null
    //   235: astore_2
    //   236: goto -125 -> 111
    //   239: astore 4
    //   241: goto -130 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	FMTSrvAddrProvider
    //   87	14	1	i	int
    //   6	197	2	localObject1	Object
    //   204	12	2	localObject2	Object
    //   217	1	2	localIOException1	java.io.IOException
    //   225	1	2	localObject3	Object
    //   235	1	2	localObject4	Object
    //   44	91	3	localObject5	Object
    //   147	1	3	localIOException2	java.io.IOException
    //   152	37	3	localObject6	Object
    //   201	1	3	localIOException3	java.io.IOException
    //   206	6	3	localObject7	Object
    //   221	1	3	localIOException4	java.io.IOException
    //   76	21	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   107	51	4	localException1	Exception
    //   165	18	4	localJceInputStream	com.qq.taf.jce.JceInputStream
    //   229	1	4	localException2	Exception
    //   239	1	4	localException3	Exception
    //   55	178	5	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   60	66	107	java/lang/Exception
    //   69	78	107	java/lang/Exception
    //   81	88	107	java/lang/Exception
    //   96	104	107	java/lang/Exception
    //   153	167	107	java/lang/Exception
    //   170	178	107	java/lang/Exception
    //   140	145	147	java/io/IOException
    //   194	199	201	java/io/IOException
    //   0	31	204	finally
    //   47	57	204	finally
    //   35	43	217	java/io/IOException
    //   211	215	221	java/io/IOException
    //   60	66	225	finally
    //   69	78	225	finally
    //   81	88	225	finally
    //   96	104	225	finally
    //   114	120	225	finally
    //   123	133	225	finally
    //   153	167	225	finally
    //   170	178	225	finally
    //   181	187	225	finally
    //   0	31	229	java/lang/Exception
    //   47	57	229	java/lang/Exception
    //   181	187	239	java/lang/Exception
  }
  
  /* Error */
  private void writeToFile(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_3
    //   6: astore_2
    //   7: getstatic 79	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:FMT_SVC_INI_TMP	Ljava/lang/String;
    //   10: invokestatic 683	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   13: astore 5
    //   15: aload_1
    //   16: ifnonnull +77 -> 93
    //   19: aload_3
    //   20: astore_2
    //   21: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +14 -> 38
    //   27: aload_3
    //   28: astore_2
    //   29: ldc 20
    //   31: iconst_2
    //   32: ldc_w 724
    //   35: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload 5
    //   40: ifnull +40 -> 80
    //   43: aload_3
    //   44: astore_2
    //   45: aload 5
    //   47: invokevirtual 727	java/io/File:exists	()Z
    //   50: ifeq +30 -> 80
    //   53: aload_3
    //   54: astore_2
    //   55: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +14 -> 72
    //   61: aload_3
    //   62: astore_2
    //   63: ldc 20
    //   65: iconst_2
    //   66: ldc_w 729
    //   69: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_3
    //   73: astore_2
    //   74: aload 5
    //   76: invokevirtual 732	java/io/File:delete	()Z
    //   79: pop
    //   80: iconst_0
    //   81: ifeq +11 -> 92
    //   84: new 693	java/lang/NullPointerException
    //   87: dup
    //   88: invokespecial 694	java/lang/NullPointerException:<init>	()V
    //   91: athrow
    //   92: return
    //   93: aload_3
    //   94: astore_2
    //   95: new 734	com/qq/taf/jce/JceOutputStream
    //   98: dup
    //   99: invokespecial 735	com/qq/taf/jce/JceOutputStream:<init>	()V
    //   102: astore 6
    //   104: aload_3
    //   105: astore_2
    //   106: aload_1
    //   107: aload 6
    //   109: invokevirtual 739	ConfigPush/FileStoragePushFSSvcList:writeTo	(Lcom/qq/taf/jce/JceOutputStream;)V
    //   112: aload_3
    //   113: astore_2
    //   114: aload 6
    //   116: invokevirtual 740	com/qq/taf/jce/JceOutputStream:toByteArray	()[B
    //   119: astore 6
    //   121: aload_3
    //   122: astore_2
    //   123: new 742	java/io/FileOutputStream
    //   126: dup
    //   127: aload 5
    //   129: iconst_0
    //   130: invokespecial 745	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   133: astore_3
    //   134: aload_3
    //   135: aload 6
    //   137: invokevirtual 747	java/io/FileOutputStream:write	([B)V
    //   140: new 685	java/io/File
    //   143: dup
    //   144: getstatic 83	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:FMT_SVC_INI	Ljava/lang/String;
    //   147: invokespecial 749	java/io/File:<init>	(Ljava/lang/String;)V
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 727	java/io/File:exists	()Z
    //   155: ifeq +8 -> 163
    //   158: aload_2
    //   159: invokevirtual 732	java/io/File:delete	()Z
    //   162: pop
    //   163: aload 5
    //   165: aload_2
    //   166: invokevirtual 753	java/io/File:renameTo	(Ljava/io/File;)Z
    //   169: pop
    //   170: aload_3
    //   171: ifnull +7 -> 178
    //   174: aload_3
    //   175: invokevirtual 754	java/io/FileOutputStream:close	()V
    //   178: aload_1
    //   179: ifnull -87 -> 92
    //   182: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq -93 -> 92
    //   188: ldc 20
    //   190: iconst_2
    //   191: ldc_w 756
    //   194: invokestatic 218	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: return
    //   198: astore_2
    //   199: aload 4
    //   201: astore_3
    //   202: aload_2
    //   203: astore 4
    //   205: aload_3
    //   206: astore_2
    //   207: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq +16 -> 226
    //   213: aload_3
    //   214: astore_2
    //   215: ldc 20
    //   217: iconst_2
    //   218: ldc_w 758
    //   221: aload 4
    //   223: invokestatic 710	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_3
    //   227: ifnull -49 -> 178
    //   230: aload_3
    //   231: invokevirtual 754	java/io/FileOutputStream:close	()V
    //   234: goto -56 -> 178
    //   237: astore_2
    //   238: goto -60 -> 178
    //   241: astore_1
    //   242: aload_2
    //   243: ifnull +7 -> 250
    //   246: aload_2
    //   247: invokevirtual 754	java/io/FileOutputStream:close	()V
    //   250: aload_1
    //   251: athrow
    //   252: astore_1
    //   253: return
    //   254: astore_2
    //   255: goto -77 -> 178
    //   258: astore_2
    //   259: goto -9 -> 250
    //   262: astore_1
    //   263: aload_3
    //   264: astore_2
    //   265: goto -23 -> 242
    //   268: astore 4
    //   270: goto -65 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	FMTSrvAddrProvider
    //   0	273	1	paramFileStoragePushFSSvcList	FileStoragePushFSSvcList
    //   6	160	2	localObject1	Object
    //   198	5	2	localException1	Exception
    //   206	9	2	localObject2	Object
    //   237	10	2	localIOException1	java.io.IOException
    //   254	1	2	localIOException2	java.io.IOException
    //   258	1	2	localIOException3	java.io.IOException
    //   264	1	2	localObject3	Object
    //   1	263	3	localObject4	Object
    //   3	219	4	localObject5	Object
    //   268	1	4	localException2	Exception
    //   13	151	5	localFile	java.io.File
    //   102	34	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   7	15	198	java/lang/Exception
    //   21	27	198	java/lang/Exception
    //   29	38	198	java/lang/Exception
    //   45	53	198	java/lang/Exception
    //   55	61	198	java/lang/Exception
    //   63	72	198	java/lang/Exception
    //   74	80	198	java/lang/Exception
    //   95	104	198	java/lang/Exception
    //   106	112	198	java/lang/Exception
    //   114	121	198	java/lang/Exception
    //   123	134	198	java/lang/Exception
    //   230	234	237	java/io/IOException
    //   7	15	241	finally
    //   21	27	241	finally
    //   29	38	241	finally
    //   45	53	241	finally
    //   55	61	241	finally
    //   63	72	241	finally
    //   74	80	241	finally
    //   95	104	241	finally
    //   106	112	241	finally
    //   114	121	241	finally
    //   123	134	241	finally
    //   207	213	241	finally
    //   215	226	241	finally
    //   84	92	252	java/io/IOException
    //   174	178	254	java/io/IOException
    //   246	250	258	java/io/IOException
    //   134	163	262	finally
    //   163	170	262	finally
    //   134	163	268	java/lang/Exception
    //   163	170	268	java/lang/Exception
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
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2;
    if (this.mSvcList != null)
    {
      localObject1 = localObject3;
      if (this.mSvcList.bigDataChannel != null)
      {
        localObject1 = localObject3;
        if (this.mSvcList.bigDataChannel.vBigdata_pb_buf != null)
        {
          localObject1 = localObject3;
          if (this.mSvcList.bigDataChannel.vBigdata_pb_buf.length > 0)
          {
            localObject1 = this.mSvcList.bigDataChannel.vBigdata_pb_buf;
            localObject2 = new subcmd0x501.RspBody();
          }
        }
      }
    }
    try
    {
      ((subcmd0x501.RspBody)localObject2).mergeFrom((byte[])localObject1);
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject2 = ((subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject2).msg_subcmd_0x501_rsp_body.get()).msg_download_encrypt_conf;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            QLog.d("FMT_ADDR", 2, "picEncryptSwitchInit: pic:" + ((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject2).bool_enable_encrypted_pic.get() + ",url:" + ((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject2).bool_enable_encrypt_request.get() + ",ctlFlg:" + ((subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf)localObject2).uint32_ctrl_flag.get());
            localObject1 = localObject2;
          }
        }
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localObject2 = null;
      }
    }
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
  
  /* Error */
  public byte[] getBigDataSrvKey(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 128	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:mSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 128	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:mSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 459	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 128	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:mSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 459	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 819	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 128	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:mSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 459	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 822	ConfigPush/BigDataChannel:sBigdata_key_session	[B
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: aconst_null
    //   50: astore_3
    //   51: goto -6 -> 45
    //   54: astore_3
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	FMTSrvAddrProvider
    //   0	59	1	paramLong	long
    //   44	7	3	arrayOfByte	byte[]
    //   54	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	54	finally
  }
  
  /* Error */
  public byte[] getBigDataSrvSign(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 128	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:mSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   6: ifnull +43 -> 49
    //   9: aload_0
    //   10: getfield 128	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:mSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   13: getfield 459	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   16: ifnull +33 -> 49
    //   19: aload_0
    //   20: getfield 128	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:mSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   23: getfield 459	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   26: getfield 819	ConfigPush/BigDataChannel:uSig_Uin	J
    //   29: lload_1
    //   30: lcmp
    //   31: ifne +18 -> 49
    //   34: aload_0
    //   35: getfield 128	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:mSvcList	LConfigPush/FileStoragePushFSSvcList;
    //   38: getfield 459	ConfigPush/FileStoragePushFSSvcList:bigDataChannel	LConfigPush/BigDataChannel;
    //   41: getfield 826	ConfigPush/BigDataChannel:sBigdata_sig_session	[B
    //   44: astore_3
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_3
    //   48: areturn
    //   49: aconst_null
    //   50: astore_3
    //   51: goto -6 -> 45
    //   54: astore_3
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	FMTSrvAddrProvider
    //   0	59	1	paramLong	long
    //   44	7	3	arrayOfByte	byte[]
    //   54	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	45	54	finally
  }
  
  /* Error */
  public ServerAddr getFirst(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial 172	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:getSvcList	(I)Ljava/util/ArrayList;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +52 -> 61
    //   12: aload_3
    //   13: invokevirtual 465	java/util/ArrayList:size	()I
    //   16: ifle +45 -> 61
    //   19: new 830	com/tencent/mobileqq/transfile/ServerAddr
    //   22: dup
    //   23: invokespecial 831	com/tencent/mobileqq/transfile/ServerAddr:<init>	()V
    //   26: astore_2
    //   27: aload_2
    //   28: aload_3
    //   29: iconst_0
    //   30: invokevirtual 466	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   33: checkcast 476	ConfigPush/FileStorageServerListInfo
    //   36: getfield 485	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   39: putfield 834	com/tencent/mobileqq/transfile/ServerAddr:mIp	Ljava/lang/String;
    //   42: aload_2
    //   43: aload_3
    //   44: iconst_0
    //   45: invokevirtual 466	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   48: checkcast 476	ConfigPush/FileStorageServerListInfo
    //   51: getfield 491	ConfigPush/FileStorageServerListInfo:iPort	I
    //   54: putfield 837	com/tencent/mobileqq/transfile/ServerAddr:port	I
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: areturn
    //   61: aconst_null
    //   62: astore_2
    //   63: goto -6 -> 57
    //   66: astore_2
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	FMTSrvAddrProvider
    //   0	71	1	paramInt	int
    //   26	37	2	localServerAddr	ServerAddr
    //   66	4	2	localObject	Object
    //   7	37	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	8	66	finally
    //   12	57	66	finally
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
    HwConfig localHwConfig = null;
    Map localMap = getHighwayConfigMap();
    if (localMap != null) {
      localHwConfig = (HwConfig)localMap.get(Integer.valueOf(10));
    }
    return localHwConfig;
  }
  
  public Map<Integer, HwConfig> getHighwayConfigMap()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1;
    boolean bool;
    if ((this.mSvcList != null) && (this.mSvcList.bigDataChannel != null))
    {
      localObject1 = new StringBuilder().append("GetHighwayConfig  Has PbBuffer : ");
      if (this.mSvcList.bigDataChannel.vBigdata_pb_buf == null) {
        break label232;
      }
      bool = true;
    }
    for (;;)
    {
      QLog.d("FMT_ADDR", 2, String.valueOf(bool) + " IpList : " + this.mSvcList.bigDataChannel.vBigdata_iplists.size());
      Object localObject2;
      if ((this.mSvcList.bigDataChannel.vBigdata_pb_buf != null) && (this.mSvcList.bigDataChannel.vBigdata_pb_buf.length > 0))
      {
        localObject2 = this.mSvcList.bigDataChannel.vBigdata_pb_buf;
        localObject1 = new subcmd0x501.RspBody();
      }
      try
      {
        ((subcmd0x501.RspBody)localObject1).mergeFrom((byte[])localObject2);
        if (localObject1 != null)
        {
          localObject1 = (subcmd0x501.SubCmd0x501Rspbody)((subcmd0x501.RspBody)localObject1).msg_subcmd_0x501_rsp_body.get();
          localObject2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          SessionInfo.updateSessionInfo(((subcmd0x501.SubCmd0x501Rspbody)localObject1).bytes_httpconn_sig_session.get().toByteArray(), ((subcmd0x501.SubCmd0x501Rspbody)localObject1).bytes_session_key.get().toByteArray(), (String)localObject2);
          localObject2 = ((subcmd0x501.SubCmd0x501Rspbody)localObject1).rpt_msg_httpconn_addrs.get();
          if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
            decodeSrvAddrs(localHashMap, (subcmd0x501.SubCmd0x501Rspbody)localObject1, (List)localObject2);
          }
        }
        else
        {
          return localHashMap;
          label232:
          bool = false;
        }
      }
      catch (Exception localException)
      {
        do
        {
          for (;;)
          {
            localObject1 = null;
            localException.printStackTrace();
          }
        } while (!QLog.isColorLevel());
        QLog.d("FMT_ADDR", 2, "GetHighwayConfig srvAddrList == null || srvAddrList.size() == 0");
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
    catch (Exception paramArrayOfByte) {}
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
    if (QLog.isColorLevel())
    {
      if (this.encryptConf == null) {
        break label106;
      }
      QLog.d("FMT_ADDR", 2, "getPicEncryptSwitch: pic:" + this.encryptConf.bool_enable_encrypted_pic.get() + ",url:" + this.encryptConf.bool_enable_encrypt_request.get() + ",ctlFlag:" + this.encryptConf.uint32_ctrl_flag.get());
    }
    for (;;)
    {
      return this.encryptConf;
      label106:
      QLog.d("FMT_ADDR", 2, "getPicEncryptSwitch: none!");
    }
  }
  
  /* Error */
  public FMTSrvAddrProvider.PttIpList getPttIpListFromTlvByte(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 17
    //   6: aconst_null
    //   7: astore 15
    //   9: aconst_null
    //   10: astore 19
    //   12: aconst_null
    //   13: astore 18
    //   15: aconst_null
    //   16: astore 16
    //   18: aconst_null
    //   19: astore 10
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 933	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:isTlvByte	([B)Z
    //   26: ifne +15 -> 41
    //   29: new 106	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList
    //   32: dup
    //   33: invokespecial 107	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:<init>	()V
    //   36: astore 9
    //   38: aload 9
    //   40: areturn
    //   41: aload 10
    //   43: astore 8
    //   45: aload 19
    //   47: astore 12
    //   49: aload 11
    //   51: astore 9
    //   53: aload_1
    //   54: ifnull +572 -> 626
    //   57: aload 16
    //   59: astore 13
    //   61: aload 15
    //   63: astore 14
    //   65: aload 10
    //   67: astore 8
    //   69: aload 19
    //   71: astore 12
    //   73: aload 11
    //   75: astore 9
    //   77: aload 18
    //   79: astore 10
    //   81: aload 17
    //   83: astore 11
    //   85: aload_1
    //   86: arraylength
    //   87: ifle +539 -> 626
    //   90: aload 16
    //   92: astore 13
    //   94: aload 15
    //   96: astore 14
    //   98: aload 18
    //   100: astore 10
    //   102: aload 17
    //   104: astore 11
    //   106: new 106	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList
    //   109: dup
    //   110: invokespecial 107	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:<init>	()V
    //   113: astore 15
    //   115: aload_1
    //   116: iconst_1
    //   117: baload
    //   118: istore 4
    //   120: iconst_0
    //   121: istore_2
    //   122: iconst_2
    //   123: istore_3
    //   124: aconst_null
    //   125: astore 10
    //   127: aconst_null
    //   128: astore 8
    //   130: iload_2
    //   131: iload 4
    //   133: if_icmpge +481 -> 614
    //   136: aload_1
    //   137: iload_3
    //   138: baload
    //   139: istore 5
    //   141: iload_3
    //   142: iconst_1
    //   143: iadd
    //   144: istore_3
    //   145: iconst_2
    //   146: newarray byte
    //   148: astore 9
    //   150: aload_1
    //   151: iload_3
    //   152: aload 9
    //   154: iconst_0
    //   155: iconst_2
    //   156: invokestatic 507	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   159: iload_3
    //   160: iconst_2
    //   161: iadd
    //   162: istore_3
    //   163: aload 9
    //   165: iconst_0
    //   166: invokestatic 938	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   169: istore 6
    //   171: aload_1
    //   172: iload_3
    //   173: iload 6
    //   175: newarray byte
    //   177: iconst_0
    //   178: iload 6
    //   180: invokestatic 507	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   183: iload 5
    //   185: iconst_1
    //   186: if_icmpne +117 -> 303
    //   189: new 940	java/io/ByteArrayInputStream
    //   192: dup
    //   193: aload_1
    //   194: iload_3
    //   195: iload 6
    //   197: invokespecial 942	java/io/ByteArrayInputStream:<init>	([BII)V
    //   200: astore 9
    //   202: new 944	java/io/DataInputStream
    //   205: dup
    //   206: aload 9
    //   208: invokespecial 947	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   211: astore 10
    //   213: aload 15
    //   215: aload 10
    //   217: invokevirtual 950	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   220: putfield 618	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:wifiIdentifier	Ljava/lang/String;
    //   223: aload 9
    //   225: astore 8
    //   227: aload 10
    //   229: astore 9
    //   231: aload 8
    //   233: ifnull +24 -> 257
    //   236: aload 9
    //   238: astore 13
    //   240: aload 8
    //   242: astore 14
    //   244: aload 9
    //   246: astore 10
    //   248: aload 8
    //   250: astore 11
    //   252: aload 8
    //   254: invokevirtual 951	java/io/ByteArrayInputStream:close	()V
    //   257: aload 9
    //   259: ifnull +24 -> 283
    //   262: aload 9
    //   264: astore 13
    //   266: aload 8
    //   268: astore 14
    //   270: aload 9
    //   272: astore 10
    //   274: aload 8
    //   276: astore 11
    //   278: aload 9
    //   280: invokevirtual 952	java/io/DataInputStream:close	()V
    //   283: iload_2
    //   284: iconst_1
    //   285: iadd
    //   286: istore_2
    //   287: iload_3
    //   288: iload 6
    //   290: iadd
    //   291: istore_3
    //   292: aload 8
    //   294: astore 10
    //   296: aload 9
    //   298: astore 8
    //   300: goto -170 -> 130
    //   303: iload 5
    //   305: iconst_2
    //   306: if_icmpne +190 -> 496
    //   309: new 940	java/io/ByteArrayInputStream
    //   312: dup
    //   313: aload_1
    //   314: iload_3
    //   315: iload 6
    //   317: invokespecial 942	java/io/ByteArrayInputStream:<init>	([BII)V
    //   320: astore 9
    //   322: new 944	java/io/DataInputStream
    //   325: dup
    //   326: aload 9
    //   328: invokespecial 947	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   331: astore 10
    //   333: aload 15
    //   335: aload 10
    //   337: invokevirtual 950	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   340: putfield 629	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:xGIdentifier	Ljava/lang/String;
    //   343: new 940	java/io/ByteArrayInputStream
    //   346: dup
    //   347: aload_1
    //   348: iload_3
    //   349: iload 6
    //   351: invokespecial 942	java/io/ByteArrayInputStream:<init>	([BII)V
    //   354: astore 12
    //   356: new 944	java/io/DataInputStream
    //   359: dup
    //   360: aload 12
    //   362: invokespecial 947	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   365: astore 9
    //   367: aload 9
    //   369: astore 13
    //   371: aload 12
    //   373: astore 14
    //   375: aload 9
    //   377: astore 10
    //   379: aload 12
    //   381: astore 11
    //   383: aload 15
    //   385: getfield 956	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:xGError	[I
    //   388: iconst_0
    //   389: aload 9
    //   391: invokevirtual 959	java/io/DataInputStream:readInt	()I
    //   394: iastore
    //   395: aload 9
    //   397: astore 13
    //   399: aload 12
    //   401: astore 14
    //   403: aload 9
    //   405: astore 10
    //   407: aload 12
    //   409: astore 11
    //   411: aload 15
    //   413: getfield 956	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:xGError	[I
    //   416: iconst_1
    //   417: aload 9
    //   419: invokevirtual 959	java/io/DataInputStream:readInt	()I
    //   422: iastore
    //   423: aload 12
    //   425: astore 8
    //   427: goto -196 -> 231
    //   430: astore 9
    //   432: aload 14
    //   434: astore 8
    //   436: aload 13
    //   438: astore_1
    //   439: aload_1
    //   440: astore 10
    //   442: aload 8
    //   444: astore 11
    //   446: aload 9
    //   448: invokevirtual 642	java/lang/Throwable:printStackTrace	()V
    //   451: aload_1
    //   452: astore 10
    //   454: aload 8
    //   456: astore 11
    //   458: new 106	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList
    //   461: dup
    //   462: invokespecial 107	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:<init>	()V
    //   465: astore 12
    //   467: aload 8
    //   469: ifnull +8 -> 477
    //   472: aload 8
    //   474: invokevirtual 951	java/io/ByteArrayInputStream:close	()V
    //   477: aload 12
    //   479: astore 9
    //   481: aload_1
    //   482: ifnull -444 -> 38
    //   485: aload_1
    //   486: invokevirtual 952	java/io/DataInputStream:close	()V
    //   489: aload 12
    //   491: areturn
    //   492: astore_1
    //   493: aload 12
    //   495: areturn
    //   496: iload 5
    //   498: iconst_3
    //   499: if_icmpeq +9 -> 508
    //   502: iload 5
    //   504: iconst_4
    //   505: if_icmpne +360 -> 865
    //   508: new 940	java/io/ByteArrayInputStream
    //   511: dup
    //   512: aload_1
    //   513: iload_3
    //   514: iload 6
    //   516: invokespecial 942	java/io/ByteArrayInputStream:<init>	([BII)V
    //   519: astore 9
    //   521: new 944	java/io/DataInputStream
    //   524: dup
    //   525: aload 9
    //   527: invokespecial 947	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   530: astore 10
    //   532: aload 10
    //   534: invokevirtual 959	java/io/DataInputStream:readInt	()I
    //   537: istore 7
    //   539: aload 10
    //   541: invokevirtual 950	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   544: astore 8
    //   546: iload 5
    //   548: iconst_3
    //   549: if_icmpne +34 -> 583
    //   552: aload 15
    //   554: getfield 603	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadWifiIPLIst	Ljava/util/ArrayList;
    //   557: new 476	ConfigPush/FileStorageServerListInfo
    //   560: dup
    //   561: aload 8
    //   563: iload 7
    //   565: invokespecial 917	ConfigPush/FileStorageServerListInfo:<init>	(Ljava/lang/String;I)V
    //   568: invokevirtual 269	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   571: pop
    //   572: aload 9
    //   574: astore 8
    //   576: aload 10
    //   578: astore 9
    //   580: goto -349 -> 231
    //   583: aload 15
    //   585: getfield 607	com/tencent/mobileqq/transfile/FMTSrvAddrProvider$PttIpList:groupPttDownloadXGIPLIst	Ljava/util/ArrayList;
    //   588: new 476	ConfigPush/FileStorageServerListInfo
    //   591: dup
    //   592: aload 8
    //   594: iload 7
    //   596: invokespecial 917	ConfigPush/FileStorageServerListInfo:<init>	(Ljava/lang/String;I)V
    //   599: invokevirtual 269	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   602: pop
    //   603: aload 9
    //   605: astore 8
    //   607: aload 10
    //   609: astore 9
    //   611: goto -380 -> 231
    //   614: aload 10
    //   616: astore 9
    //   618: aload 8
    //   620: astore 12
    //   622: aload 15
    //   624: astore 8
    //   626: aload 9
    //   628: ifnull +8 -> 636
    //   631: aload 9
    //   633: invokevirtual 951	java/io/ByteArrayInputStream:close	()V
    //   636: aload 8
    //   638: astore 9
    //   640: aload 12
    //   642: ifnull -604 -> 38
    //   645: aload 12
    //   647: invokevirtual 952	java/io/DataInputStream:close	()V
    //   650: aload 8
    //   652: areturn
    //   653: astore_1
    //   654: aload 8
    //   656: areturn
    //   657: astore_1
    //   658: aload 11
    //   660: astore 9
    //   662: aload 10
    //   664: astore 8
    //   666: aload 9
    //   668: ifnull +8 -> 676
    //   671: aload 9
    //   673: invokevirtual 951	java/io/ByteArrayInputStream:close	()V
    //   676: aload 8
    //   678: ifnull +8 -> 686
    //   681: aload 8
    //   683: invokevirtual 952	java/io/DataInputStream:close	()V
    //   686: aload_1
    //   687: athrow
    //   688: astore 8
    //   690: goto -4 -> 686
    //   693: astore_1
    //   694: aload 10
    //   696: astore 8
    //   698: goto -32 -> 666
    //   701: astore_1
    //   702: aload 10
    //   704: astore 8
    //   706: goto -40 -> 666
    //   709: astore_1
    //   710: aload 10
    //   712: astore 8
    //   714: aload 12
    //   716: astore 9
    //   718: goto -52 -> 666
    //   721: astore_1
    //   722: aload 10
    //   724: astore 8
    //   726: goto -60 -> 666
    //   729: astore_1
    //   730: aload 10
    //   732: astore 9
    //   734: goto -68 -> 666
    //   737: astore_1
    //   738: goto -72 -> 666
    //   741: astore_1
    //   742: goto -76 -> 666
    //   745: astore_1
    //   746: goto -80 -> 666
    //   749: astore_1
    //   750: aload 9
    //   752: astore 8
    //   754: aload_1
    //   755: astore 9
    //   757: aload 10
    //   759: astore_1
    //   760: goto -321 -> 439
    //   763: astore 11
    //   765: aload 10
    //   767: astore_1
    //   768: aload 9
    //   770: astore 8
    //   772: aload 11
    //   774: astore 9
    //   776: goto -337 -> 439
    //   779: astore 9
    //   781: aload 10
    //   783: astore_1
    //   784: aload 12
    //   786: astore 8
    //   788: goto -349 -> 439
    //   791: astore_1
    //   792: aload 9
    //   794: astore 8
    //   796: aload_1
    //   797: astore 9
    //   799: aload 10
    //   801: astore_1
    //   802: goto -363 -> 439
    //   805: astore 9
    //   807: aload 8
    //   809: astore_1
    //   810: aload 10
    //   812: astore 8
    //   814: goto -375 -> 439
    //   817: astore 10
    //   819: aload 8
    //   821: astore_1
    //   822: aload 9
    //   824: astore 8
    //   826: aload 10
    //   828: astore 9
    //   830: goto -391 -> 439
    //   833: astore 10
    //   835: aload 8
    //   837: astore_1
    //   838: aload 9
    //   840: astore 8
    //   842: aload 10
    //   844: astore 9
    //   846: goto -407 -> 439
    //   849: astore 10
    //   851: aload 8
    //   853: astore_1
    //   854: aload 9
    //   856: astore 8
    //   858: aload 10
    //   860: astore 9
    //   862: goto -423 -> 439
    //   865: aload 8
    //   867: astore 9
    //   869: aload 10
    //   871: astore 8
    //   873: goto -642 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	876	0	this	FMTSrvAddrProvider
    //   0	876	1	paramArrayOfByte	byte[]
    //   121	166	2	i	int
    //   123	391	3	j	int
    //   118	16	4	k	int
    //   139	411	5	m	int
    //   169	346	6	n	int
    //   537	58	7	i1	int
    //   43	639	8	localObject1	Object
    //   688	1	8	localThrowable1	Throwable
    //   696	176	8	localObject2	Object
    //   36	382	9	localObject3	Object
    //   430	17	9	localThrowable2	Throwable
    //   479	296	9	localObject4	Object
    //   779	14	9	localThrowable3	Throwable
    //   797	1	9	arrayOfByte	byte[]
    //   805	18	9	localThrowable4	Throwable
    //   828	40	9	localObject5	Object
    //   19	792	10	localObject6	Object
    //   817	10	10	localThrowable5	Throwable
    //   833	10	10	localThrowable6	Throwable
    //   849	21	10	localThrowable7	Throwable
    //   1	658	11	localObject7	Object
    //   763	10	11	localThrowable8	Throwable
    //   47	738	12	localObject8	Object
    //   59	378	13	localObject9	Object
    //   63	370	14	localObject10	Object
    //   7	616	15	localPttIpList	FMTSrvAddrProvider.PttIpList
    //   16	75	16	localObject11	Object
    //   4	99	17	localObject12	Object
    //   13	86	18	localObject13	Object
    //   10	60	19	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   85	90	430	java/lang/Throwable
    //   106	115	430	java/lang/Throwable
    //   252	257	430	java/lang/Throwable
    //   278	283	430	java/lang/Throwable
    //   383	395	430	java/lang/Throwable
    //   411	423	430	java/lang/Throwable
    //   472	477	492	java/lang/Throwable
    //   485	489	492	java/lang/Throwable
    //   631	636	653	java/lang/Throwable
    //   645	650	653	java/lang/Throwable
    //   85	90	657	finally
    //   106	115	657	finally
    //   252	257	657	finally
    //   278	283	657	finally
    //   383	395	657	finally
    //   411	423	657	finally
    //   446	451	657	finally
    //   458	467	657	finally
    //   671	676	688	java/lang/Throwable
    //   681	686	688	java/lang/Throwable
    //   213	223	693	finally
    //   333	356	701	finally
    //   356	367	709	finally
    //   532	546	721	finally
    //   552	572	721	finally
    //   583	603	721	finally
    //   145	159	729	finally
    //   163	183	729	finally
    //   189	202	729	finally
    //   309	322	729	finally
    //   508	521	729	finally
    //   202	213	737	finally
    //   322	333	741	finally
    //   521	532	745	finally
    //   213	223	749	java/lang/Throwable
    //   333	356	763	java/lang/Throwable
    //   356	367	779	java/lang/Throwable
    //   532	546	791	java/lang/Throwable
    //   552	572	791	java/lang/Throwable
    //   583	603	791	java/lang/Throwable
    //   145	159	805	java/lang/Throwable
    //   163	183	805	java/lang/Throwable
    //   189	202	805	java/lang/Throwable
    //   309	322	805	java/lang/Throwable
    //   508	521	805	java/lang/Throwable
    //   202	213	817	java/lang/Throwable
    //   322	333	833	java/lang/Throwable
    //   521	532	849	java/lang/Throwable
  }
  
  public PttIpSaver getPttIpSaver()
  {
    return this.mPttIpSaver;
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
        ((StringBuffer)localObject1).append("http://").append(localFileStorageServerListInfo.sIP);
        if (localFileStorageServerListInfo.iPort != 80) {
          ((StringBuffer)localObject1).append(":").append(localFileStorageServerListInfo.iPort);
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
        ((StringBuffer)localObject1).append("http://").append(localFileStorageServerListInfo.sIP);
        if (localFileStorageServerListInfo.iPort != 80) {
          ((StringBuffer)localObject1).append(":").append(localFileStorageServerListInfo.iPort);
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
    boolean bool = true;
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        if (paramArrayOfByte.length != 0) {
          break label82;
        }
        return false;
      }
      catch (Throwable paramArrayOfByte) {}
      if (i < k)
      {
        j += 1;
        byte[] arrayOfByte = new byte[2];
        System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, 2);
        j = j + 2 + Utils.a(arrayOfByte, 0);
        if (j <= paramArrayOfByte.length) {
          i += 1;
        }
      }
      else
      {
        i = paramArrayOfByte.length;
        if (j == i) {
          return bool;
        }
        bool = false;
        continue;
      }
      label82:
      while (paramArrayOfByte[0] != 0) {
        return false;
      }
      int k = paramArrayOfByte[1];
      int j = 2;
      int i = 0;
    }
  }
  
  public void onDestroy()
  {
    this.mPttIpSaver.b();
    this.mLongMsgIpSaver.destroy();
  }
  
  public void onFailed(int paramInt, String paramString)
  {
    if (paramInt == 16) {}
    for (;;)
    {
      try
      {
        this.mGroupPttIpList.onFailed(this.mPttIpSaver.b(), paramString);
        if (QLog.isDevelopLevel()) {
          QLog.d("SPD", 4, "onFailed for GroupPtt: " + paramString);
        }
        return;
      }
      finally {}
      this.mChooser.onFailed(paramInt, paramString);
    }
  }
  
  public byte[] replaceWithTLVForPtt(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = getIpListFromPb(paramArrayOfByte);
    String str = this.mPttIpSaver.b();
    boolean bool = this.mPttIpSaver.a();
    if (this.mGroupPttIpList != null)
    {
      if (!bool) {
        break label58;
      }
      this.mGroupPttIpList.groupPttDownloadWifiIPLIst = paramArrayOfByte;
      this.mGroupPttIpList.wifiIdentifier = str;
    }
    for (;;)
    {
      return getTlvByteFromGroupPttIpList(this.mGroupPttIpList);
      label58:
      this.mGroupPttIpList.groupPttDownloadXGIPLIst = paramArrayOfByte;
      this.mGroupPttIpList.xGIdentifier = str;
    }
  }
  
  public void setSvcList(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "set svclist" + paramFileStoragePushFSSvcList);
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
      if (QLog.isColorLevel()) {
        QLog.d("FMT_ADDR", 2, "setSvcListCache" + paramFileStoragePushFSSvcList);
      }
      this.mSvcListCache = paramFileStoragePushFSSvcList;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FMTSrvAddrProvider
 * JD-Core Version:    0.7.0.1
 */