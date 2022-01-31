package com.tencent.mobileqq.servlet;

import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import ConfigPush.PushReq;
import KQQ.CheckUpdateResp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavSrvAddrProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.Constants.Key;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.os.MqqHandler;

public class PushServlet
  extends MSFServlet
{
  public static boolean a;
  
  private static void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList)
  {
    new QfavSrvAddrProvider().a(paramFileStoragePushFSSvcList);
  }
  
  public static void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList, QQAppInterface paramQQAppInterface)
  {
    paramFileStoragePushFSSvcList.pttlist = FMTSrvAddrProvider.a().a(paramFileStoragePushFSSvcList.pttlist);
    FMTSrvAddrProvider.a().a(paramFileStoragePushFSSvcList);
    b(paramFileStoragePushFSSvcList, paramQQAppInterface);
    a(paramFileStoragePushFSSvcList);
    a(paramQQAppInterface);
    PicIPManager.a(paramFileStoragePushFSSvcList, paramQQAppInterface);
    if ((paramFileStoragePushFSSvcList.vGPicDownLoadList == null) && (QLog.isColorLevel())) {
      QLog.d("FMT_ADDR", 2, "RECEIVED PUSH: vGPicDownLoadList ==null");
    }
    PTTPreDownloader.a(paramQQAppInterface).a(true, false);
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.getApp();
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = paramQQAppInterface.getCurrentAccountUin();
    HwConfig localHwConfig = FMTSrvAddrProvider.a().a();
    if (localHwConfig != null) {
      ConfigManager.getInstance(localBaseApplication, paramQQAppInterface, paramQQAppInterface.getAppid(), str).onSrvAddrPush(localBaseApplication, paramQQAppInterface, str, localHwConfig);
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
    synchronized (FMTSrvAddrProvider.a().a)
    {
      if (!localQQAppInterface.a.d())
      {
        FMTSrvAddrProvider.a().b(paramArrayOfByte);
        return;
      }
      a(paramArrayOfByte, localQQAppInterface);
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
        if (QLog.isColorLevel()) {
          QLog.d("PushServlet", 2, "info.sip" + localFileStorageServerListInfo.sIP + ",info.port" + localFileStorageServerListInfo.iPort);
        }
      }
      SosoSrvAddrProvider.a().a(paramFileStoragePushFSSvcList.vUrlEncodeServiceList);
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "cmd_connOpened", "RegPrxySvc.PullGroupMsgSeq", "RegPrxySvc.PullDisMsgSeq", "RegPrxySvc.infoNew", "RegPrxySvc.PullDisMsgProxy", "RegPrxySvc.PullGroupMsgProxy", "RegPrxySvc.GetMsgV2", "RegPrxySvc.PbGetMsg", "RegPrxySvc.PbSyncMsg", "RegPrxySvc.PbGetGroupMsg", "RegPrxySvc.PbGetDiscussMsg", "RegPrxySvc.PullDisGroupSeq", "RegPrxySvc.NoticeEnd", "cmd_connClosed", "ConfigPushSvc.PushReq", "StatSvc.register", "cmd_connAllFailed", "cmd_recvFirstResp", "cmd_connWeakNet", "cmd_connWeakNet_New", "MultiVideo.s2c", "MultiVideo.c2sack", "ProfileService.CheckUpdateReq", "cmd_netNeedSignon", "qqwifi.notifyAvail", "RegPrxySvc.QueryIpwdStat", "ConfigPushSvc.PushDomain" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    String str = paramFromServiceMsg.getServiceCmd();
    if ("cmd_connOpened".equals(str))
    {
      paramIntent = (String)paramFromServiceMsg.getAttribute("resp_connopen_serverAdd");
      if (QLog.isColorLevel()) {
        QLog.d("PushServlet", 2, "onReceive: cmd=" + str + "," + "resp_connopen_serverAdd" + "=" + paramIntent);
      }
      if (!TextUtils.isEmpty(paramIntent)) {
        a = paramIntent.contains("183.61.46.145");
      }
      localQQAppInterface.c();
    }
    label672:
    label857:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if ("cmd_connClosed".equals(str))
          {
            localQQAppInterface.f();
            return;
          }
          if ("cmd_connWeakNet".equals(str))
          {
            localQQAppInterface.e();
            return;
          }
          if ("cmd_connWeakNet_New".equals(str))
          {
            localQQAppInterface.b(paramFromServiceMsg.getBusinessFailMsg());
            return;
          }
          if ("cmd_netNeedSignon".equals(str))
          {
            localQQAppInterface.c((String)paramFromServiceMsg.getAttribute("signonurl"));
            return;
          }
          boolean bool1;
          if ("qqwifi.notifyAvail".equals(str))
          {
            bool1 = ((Boolean)paramFromServiceMsg.getAttribute("has_avail_qqwifi", Boolean.valueOf(false))).booleanValue();
            if (QLog.isColorLevel()) {
              QLog.i("PushServlet", 2, "QQWiFi : recv broadcast -" + str + "hasAvailWiFi = " + bool1);
            }
            paramIntent = localQQAppInterface.getHandler(Conversation.class);
            if (paramIntent != null)
            {
              if (bool1) {}
              for (int i = 1032;; i = 1033)
              {
                paramIntent.sendEmptyMessage(i);
                if (!bool1) {
                  break;
                }
                ReportController.b(localQQAppInterface, "CliOper", "", "", "QQWIFI", "show_buleNotify", 0, 0, "", "", "", "");
                return;
              }
            }
          }
          else
          {
            if ("cmd_recvFirstResp".equals(str))
            {
              localQQAppInterface.g();
              return;
            }
            if ("cmd_connAllFailed".equals(str))
            {
              localQQAppInterface.h();
              return;
            }
            if ("ConfigPushSvc.PushReq".equals(str))
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
              if ("ConfigPushSvc.PushDomain".equals(str))
              {
                InnerDns.a().a(paramFromServiceMsg);
                return;
              }
              if ("StatSvc.register".equals(paramFromServiceMsg.getServiceCmd()))
              {
                paramIntent = (SvcRespRegister)decodePacket(paramFromServiceMsg.getWupBuffer(), "SvcRespRegister", new SvcRespRegister());
                if ((paramIntent != null) && (paramIntent.cReplyCode == 0))
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.contacts.", 2, "PushServlet.onReceive " + paramIntent.timeStamp + ", " + paramIntent.bUpdateFlag);
                  }
                  long l = paramIntent.timeStamp;
                  if (paramIntent.timeStamp == 0L) {
                    l = localQQAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
                  }
                  if ((l == 0L) || (paramIntent.bUpdateFlag == 1) || (paramIntent.bLargeSeqUpdate == 1))
                  {
                    paramFromServiceMsg = localQQAppInterface.a;
                    if ((l == 0L) || (paramIntent.bUpdateFlag == 1))
                    {
                      bool1 = true;
                      l = paramIntent.timeStamp;
                      if (paramIntent.bLargeSeqUpdate != 1) {
                        break label672;
                      }
                    }
                    for (boolean bool2 = true;; bool2 = false)
                    {
                      paramFromServiceMsg.a(bool1, l, bool2);
                      return;
                      bool1 = false;
                      break;
                    }
                  }
                }
              }
              else
              {
                if ((!"RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.GetMsgV2".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PullDisMsgSeq".equals(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.NoticeEnd".equals(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PullDisGroupSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PullGroupMsgSeq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.infoLogin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.getOffMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.infoSync".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.PbSyncMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
                  break label1224;
                }
                if (paramIntent == null) {
                  break label1088;
                }
                paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
                paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
                if ((!"RegPrxySvc.infoLogin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) && (!"RegPrxySvc.getOffMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
                  try
                  {
                    if (localQQAppInterface.a().a != 0L)
                    {
                      if (paramFromServiceMsg.getAttributes().containsKey("_attr_regprxy_random_code")) {
                        break label1110;
                      }
                      if (!QLog.isColorLevel()) {
                        continue;
                      }
                      QLog.d("Q.msg.register_proxy", 2, "[ReSendProxy]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " No Random!");
                    }
                  }
                  catch (Exception localException)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.w("Q.msg.register_proxy", 2, "[ReSendProxy] PushServletException", localException);
                    }
                  }
                }
              }
            }
          }
        }
        if (("RegPrxySvc.PbGetMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PbGetDiscussMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PbGetGroupMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("RegPrxySvc.PbSyncMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))) {
          paramIntent.extraData.putBoolean("req_pb_protocol_flag", true);
        }
        if ("RegPrxySvc.PbSyncMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
          paramIntent.extraData.putBoolean("used_new_register_proxy", true);
        }
        for (;;)
        {
          localQQAppInterface.a.e();
          ((QQAppInterface)getAppRuntime()).a(paramIntent, paramFromServiceMsg);
          return;
          paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
          break label857;
          if (((Long)paramFromServiceMsg.getAttributes().get("_attr_regprxy_random_code")).longValue() == localQQAppInterface.a().a) {
            break label985;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.register_proxy", 2, "[ReSendProxy]cmd=" + paramFromServiceMsg.getServiceCmd() + " app seq:" + paramFromServiceMsg.getAppSeq() + " Diff Random=" + (Long)paramFromServiceMsg.getAttributes().get("_attr_regprxy_random_code"));
          return;
          paramIntent.extraData.putBoolean("used_register_proxy", true);
        }
        if (("MultiVideo.s2c".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) || ("MultiVideo.c2sack".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
        {
          if (QLog.isColorLevel()) {
            QLog.d("dimontang", 2, String.format("RECEIVED PUSH: MULTI VIDEO S2C, SsoSeq[%s], AppSeq[%s]", new Object[] { Integer.valueOf(paramFromServiceMsg.getRequestSsoSeq()), Integer.valueOf(paramFromServiceMsg.getAppSeq()) }));
          }
          if (paramIntent != null)
          {
            paramIntent = (ToServiceMsg)paramIntent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            paramFromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), paramIntent);
          }
          for (;;)
          {
            ((QQAppInterface)getAppRuntime()).a(paramIntent, paramFromServiceMsg);
            return;
            paramIntent = new ToServiceMsg("", paramFromServiceMsg.getUin(), paramFromServiceMsg.getServiceCmd());
          }
        }
      } while (!"ProfileService.CheckUpdateReq".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
      if (QLog.isColorLevel()) {
        QLog.d("MSFServlet", 2, "push command:" + paramFromServiceMsg.getServiceCmd() + " ssoseq:" + paramFromServiceMsg.getRequestSsoSeq());
      }
    } while (paramFromServiceMsg.getRequestSsoSeq() > 0);
    label985:
    paramIntent = new UniPacket(true);
    try
    {
      label1088:
      label1110:
      paramIntent.setEncodeName("utf-8");
      label1224:
      paramIntent.decode(paramFromServiceMsg.getWupBuffer());
      label1450:
      paramIntent = (CheckUpdateResp)paramIntent.getByClass("CheckUpdateResp", new CheckUpdateResp());
      ((FriendListHandler)localQQAppInterface.a(1)).a(paramIntent);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      break label1450;
    }
    catch (RuntimeException paramFromServiceMsg)
    {
      break label1450;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.PushServlet
 * JD-Core Version:    0.7.0.1
 */