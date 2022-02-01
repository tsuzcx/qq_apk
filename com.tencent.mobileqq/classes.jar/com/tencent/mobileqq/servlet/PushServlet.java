package com.tencent.mobileqq.servlet;

import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import ConfigPush.PushReq;
import KQQ.CheckUpdateResp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.activity.recent.bannerprocessor.QQWifiBannerProcessor;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.config.business.MSFConfigProcessor;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.troop.soso.SosoSrvAddrProvider;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavSrvAddrProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.Key;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;
import mqq.observer.AccountObserver;

public class PushServlet
  extends MSFServlet
{
  public static boolean a = false;
  
  private static void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    new QfavSrvAddrProvider().a(paramFileStoragePushFSSvcList);
  }
  
  public static void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList, QQAppInterface paramQQAppInterface)
  {
    paramFileStoragePushFSSvcList.pttlist = FMTSrvAddrProvider.getInstance().replaceWithTLVForPtt(paramFileStoragePushFSSvcList.pttlist);
    FMTSrvAddrProvider.getInstance().setSvcList(paramFileStoragePushFSSvcList);
    b(paramFileStoragePushFSSvcList, paramQQAppInterface);
    a(paramFileStoragePushFSSvcList);
    a(paramQQAppInterface);
    if (PicIPManager.a(paramFileStoragePushFSSvcList)) {
      NearbyManagerHelper.a(paramQQAppInterface).b();
    }
    if ((paramFileStoragePushFSSvcList.vGPicDownLoadList == null) && (QLog.isColorLevel())) {
      QLog.d("FMT_ADDR", 2, "RECEIVED PUSH: vGPicDownLoadList ==null");
    }
    ((IPTTPreDownloader)paramQQAppInterface.getRuntimeService(IPTTPreDownloader.class)).onAddrProviderReady(true, false);
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApp();
    BaseApplication localBaseApplication = BaseApplication.getContext();
    Map localMap = FMTSrvAddrProvider.getInstance().getHighwayConfigMap();
    ConfigManager.getInstance(localBaseApplication, paramQQAppInterface.getHwEngine()).onSrvAddrPush(localBaseApplication, paramQQAppInterface, localMap);
  }
  
  private static void a(ArrayList<FileStorageServerListInfo> paramArrayList)
  {
    Object localObject = MobileQQ.sMobileQQ;
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((MobileQQ)localObject).getSharedPreferences("SosoSrvAddrList", i);
    if (paramArrayList != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)paramArrayList.next();
        localStringBuilder.append(localFileStorageServerListInfo.sIP);
        localStringBuilder.append(":");
        localStringBuilder.append(localFileStorageServerListInfo.iPort);
        localStringBuilder.append("|");
      }
      ((SharedPreferences)localObject).edit().putString("SosoSrvAddrList_key", localStringBuilder.toString()).commit();
      paramArrayList = new Intent("com.tencent.receiver.soso");
      paramArrayList.putExtra("com.tencent.receiver.soso.type", SosoSrvAddrProvider.a);
      MobileQQ.sMobileQQ.sendBroadcast(paramArrayList);
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMT_ADDR", 2, "RECEIVED PUSH: FMT SERVER ADDR LIST");
    }
    ??? = new JceInputStream(paramArrayOfByte);
    paramArrayOfByte = new FileStoragePushFSSvcList();
    paramArrayOfByte.readFrom((JceInputStream)???);
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    synchronized (FMTSrvAddrProvider.getInstance().saveSvcListLock)
    {
      if (!localQQAppInterface.mAutomator.d()) {
        FMTSrvAddrProvider.getInstance().setSvcListCache(paramArrayOfByte);
      } else {
        a(paramArrayOfByte, localQQAppInterface);
      }
      return;
    }
  }
  
  private static void b(FileStoragePushFSSvcList paramFileStoragePushFSSvcList, QQAppInterface paramQQAppInterface)
  {
    if ((paramFileStoragePushFSSvcList != null) && (paramFileStoragePushFSSvcList.vUrlEncodeServiceList != null))
    {
      paramQQAppInterface = paramFileStoragePushFSSvcList.vUrlEncodeServiceList.iterator();
      while (paramQQAppInterface.hasNext())
      {
        FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)paramQQAppInterface.next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("info.sip=");
          localStringBuilder.append(localFileStorageServerListInfo.sIP);
          localStringBuilder.append(",info.port=");
          localStringBuilder.append(localFileStorageServerListInfo.iPort);
          QLog.d("PushServlet", 2, localStringBuilder.toString());
        }
      }
      a(paramFileStoragePushFSSvcList.vUrlEncodeServiceList);
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "cmd_connOpened", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PbGetMsg", "RegPrxySvc.PbSyncMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullDisGroupSeq", "RegPrxySvc.NoticeEnd", "RegPrxySvc.GetBoxFilter", "cmd_connClosed", "ConfigPushSvc.PushReq", "StatSvc.register", "cmd_connAllFailed", "cmd_recvFirstResp", "cmd_connWeakNet", "cmd_connWeakNet_New", "MultiVideo.s2c", "MultiVideo.c2sack", "ProfileService.CheckUpdateReq", "cmd_netNeedSignon", "qqwifi.notifyAvail", "RegPrxySvc.QueryIpwdStat", "ConfigPushSvc.PushDomain", "cmd_wake_from_deep_sleep" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    Object localObject = paramFromServiceMsg.getServiceCmd();
    boolean bool1 = "cmd_connOpened".equals(localObject);
    int i = 2;
    if (bool1)
    {
      paramIntent = (String)paramFromServiceMsg.getAttribute("resp_connopen_serverAdd");
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("onReceive: cmd=");
        paramFromServiceMsg.append((String)localObject);
        paramFromServiceMsg.append(",");
        paramFromServiceMsg.append("resp_connopen_serverAdd");
        paramFromServiceMsg.append("=");
        paramFromServiceMsg.append(paramIntent);
        QLog.d("PushServlet", 2, paramFromServiceMsg.toString());
      }
      if (!TextUtils.isEmpty(paramIntent)) {
        a = paramIntent.contains("14.18.180.90");
      }
      localQQAppInterface.onMessageConnect();
      return;
    }
    if ("cmd_connClosed".equals(localObject))
    {
      localQQAppInterface.onConnClose();
      return;
    }
    if ("cmd_connWeakNet".equals(localObject))
    {
      localQQAppInterface.onWeakNet();
      return;
    }
    if ("cmd_connWeakNet_New".equals(localObject))
    {
      localQQAppInterface.onWeakNet(paramFromServiceMsg.getBusinessFailMsg());
      return;
    }
    if ("cmd_netNeedSignon".equals(localObject))
    {
      localQQAppInterface.onNetNeedSignon((String)paramFromServiceMsg.getAttribute("signonurl"));
      return;
    }
    bool1 = "qqwifi.notifyAvail".equals(localObject);
    boolean bool2 = false;
    long l1;
    if (bool1)
    {
      bool1 = ((Boolean)paramFromServiceMsg.getAttribute("has_avail_qqwifi", Boolean.valueOf(false))).booleanValue();
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("QQWiFi : recv broadcast -");
        paramIntent.append((String)localObject);
        paramIntent.append("hasAvailWiFi = ");
        paramIntent.append(bool1);
        QLog.i("PushServlet", 2, paramIntent.toString());
      }
      paramIntent = BannerManager.a();
      int j = QQWifiBannerProcessor.a;
      if (!bool1) {
        i = 0;
      }
      paramIntent.a(j, i, null);
      if (bool1) {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "QQWIFI", "show_buleNotify", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if ("cmd_recvFirstResp".equals(localObject))
      {
        localQQAppInterface.onRecvFistResp();
        return;
      }
      if ("cmd_connAllFailed".equals(localObject))
      {
        localQQAppInterface.onConnAllFailed();
        return;
      }
      if ("ConfigPushSvc.PushReq".equals(localObject))
      {
        paramIntent = new UniPacket(true);
        paramIntent.setEncodeName("utf-8");
        paramIntent.decode(paramFromServiceMsg.getWupBuffer());
        paramIntent = (PushReq)paramIntent.getByClass("PushReq", new PushReq());
        if ((paramIntent != null) && (paramIntent.type == 2)) {
          a(paramIntent.jcebuf);
        }
      }
      else
      {
        if ("ConfigPushSvc.PushDomain".equals(localObject))
        {
          InnerDns.getInstance().onReceivePush(paramFromServiceMsg);
          return;
        }
        if ("StatSvc.register".equals(paramFromServiceMsg.getServiceCmd()))
        {
          paramIntent = (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
          if ((paramIntent != null) && (paramIntent.cReplyCode == 0))
          {
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("PushServlet.onReceive ");
              paramFromServiceMsg.append(paramIntent.timeStamp);
              paramFromServiceMsg.append(", bUpdateFlag: ");
              paramFromServiceMsg.append(paramIntent.bUpdateFlag);
              paramFromServiceMsg.append(", bLargeSeqUpdate: ");
              paramFromServiceMsg.append(paramIntent.bLargeSeqUpdate);
              paramFromServiceMsg.append(", iStatus: ");
              paramFromServiceMsg.append(paramIntent.iStatus);
              QLog.d("Q.contacts.", 2, paramFromServiceMsg.toString());
            }
            l1 = paramIntent.timeStamp;
            if (paramIntent.timeStamp == 0L) {
              l1 = localQQAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
            }
            if ((l1 == 0L) || (paramIntent.bUpdateFlag == 1) || (paramIntent.bLargeSeqUpdate == 1))
            {
              paramFromServiceMsg = localQQAppInterface.mAutomator;
              if ((l1 != 0L) && (paramIntent.bUpdateFlag != 1)) {
                bool1 = false;
              } else {
                bool1 = true;
              }
              l1 = paramIntent.timeStamp;
              if (paramIntent.bLargeSeqUpdate == 1) {
                bool2 = true;
              }
              paramFromServiceMsg.a(bool1, l1, bool2);
            }
            paramFromServiceMsg = AppRuntime.Status.build(paramIntent.iStatus);
            l1 = paramIntent.uExtOnlineStatus;
            if (paramFromServiceMsg != null)
            {
              paramIntent = (IOnlineStatusService)localQQAppInterface.getRuntimeService(IOnlineStatusService.class);
              paramIntent.setOnlineStatus(paramFromServiceMsg);
              paramIntent.setExtOnlineStatus(l1);
              paramIntent = new Bundle();
              paramIntent.putSerializable("onlineStatus", paramFromServiceMsg);
              paramIntent.putLong("extOnlineStatus", l1);
              localQQAppInterface.notifyObservers(AccountObserver.class, 2211, true, paramIntent);
              return;
            }
            QLog.d("Q.contacts.", 1, "PushServlet.onReceive onlineStatus is null!");
          }
        }
        else if ((!"RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.GetMsgV2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PullDisMsgSeq".equals(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.NoticeEnd".equals(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.GetBoxFilter".equals(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PullGroupMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.infoLogin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.getOffMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.infoSync".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PbSyncMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
        {
          if ((!"MultiVideo.s2c".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"MultiVideo.c2sack".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
            if ("ProfileService.CheckUpdateReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
            {
              if (QLog.isColorLevel())
              {
                paramIntent = new StringBuilder();
                paramIntent.append("push command:");
                paramIntent.append(paramFromServiceMsg.getServiceCmd());
                paramIntent.append(" ssoseq:");
                paramIntent.append(paramFromServiceMsg.getRequestSsoSeq());
                QLog.d("PushServlet", 2, paramIntent.toString());
              }
              if (paramFromServiceMsg.getRequestSsoSeq() > 0) {
                return;
              }
              paramIntent = new UniPacket(true);
            }
          }
        }
      }
    }
    try
    {
      paramIntent.setEncodeName("utf-8");
      paramIntent.decode(paramFromServiceMsg.getWupBuffer());
      label1160:
      paramIntent = (CheckUpdateResp)paramIntent.getByClass("CheckUpdateResp", new CheckUpdateResp());
      ((FriendListHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).handleCheckUpdate(paramIntent);
      return;
      if (TextUtils.equals("cmd_wake_from_deep_sleep", (CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PushServlet", 2, new Object[] { "onReceive: cmd = ", localObject, ", manager = ", Boolean.valueOf(MSFConfigProcessor.a()) });
        }
        if ((Build.MANUFACTURER.equalsIgnoreCase("huawei")) && (MSFConfigProcessor.a()))
        {
          l1 = (int)(System.currentTimeMillis() / 1000L);
          long l2 = Math.abs(new Random().nextInt());
          localQQAppInterface.getMsgHandler().a(l1 << 32 | l2, false, true);
          QQBeaconReport.a("load_msg_from_deep_sleep");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("dimontang", 2, String.format("RECEIVED PUSH: MULTI VIDEO S2C, SsoSeq[%s], AppSeq[%s]", new Object[] { Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()), Integer.valueOf(paramFromServiceMsg.getAppSeq()) }));
          }
          if (paramIntent != null)
          {
            paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
          }
          else
          {
            paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
          }
          ((QQAppInterface)getAppRuntime()).receiveToService(paramIntent, paramFromServiceMsg);
          return;
          if (paramIntent != null)
          {
            paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
          }
          else
          {
            paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
          }
          if ((!"RegPrxySvc.infoLogin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.getOffMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
            try
            {
              if (localQQAppInterface.getMsgHandler().a.a != 0L)
              {
                if (!paramFromServiceMsg.getAttributes().containsKey("_attr_regprxy_random_code"))
                {
                  if (!QLog.isColorLevel()) {
                    return;
                  }
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("[ReSendProxy]cmd=");
                  ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
                  ((StringBuilder)localObject).append(" app seq:");
                  ((StringBuilder)localObject).append(paramFromServiceMsg.getAppSeq());
                  ((StringBuilder)localObject).append(" No Random!");
                  QLog.d("Q.msg.register_proxy", 2, ((StringBuilder)localObject).toString());
                  return;
                }
                if (((Long)paramFromServiceMsg.getAttributes().get("_attr_regprxy_random_code")).longValue() != localQQAppInterface.getMsgHandler().a.a)
                {
                  if (QLog.isColorLevel())
                  {
                    localObject = new StringBuilder();
                    ((StringBuilder)localObject).append("[ReSendProxy]cmd=");
                    ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
                    ((StringBuilder)localObject).append(" app seq:");
                    ((StringBuilder)localObject).append(paramFromServiceMsg.getAppSeq());
                    ((StringBuilder)localObject).append(" Diff Random=");
                    ((StringBuilder)localObject).append((Long)paramFromServiceMsg.getAttributes().get("_attr_regprxy_random_code"));
                    QLog.d("Q.msg.register_proxy", 2, ((StringBuilder)localObject).toString());
                  }
                  return;
                }
              }
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.w("Q.msg.register_proxy", 2, "[ReSendProxy] PushServletException", localException);
              }
            }
          }
          if ((!"RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.GetBoxFilter".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PbSyncMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
            break label1841;
          }
          paramIntent.extraData.putBoolean("req_pb_protocol_flag", true);
          label1841:
          if ("RegPrxySvc.PbSyncMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
            paramIntent.extraData.putBoolean("used_new_register_proxy", true);
          } else {
            paramIntent.extraData.putBoolean("used_register_proxy", true);
          }
          localQQAppInterface.mAutomator.d();
          ((QQAppInterface)getAppRuntime()).receiveToService(paramIntent, paramFromServiceMsg);
        }
      }
      return;
    }
    catch (RuntimeException|Exception paramFromServiceMsg)
    {
      break label1160;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.PushServlet
 * JD-Core Version:    0.7.0.1
 */