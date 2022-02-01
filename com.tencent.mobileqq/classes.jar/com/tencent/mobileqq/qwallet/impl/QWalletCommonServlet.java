package com.tencent.mobileqq.qwallet.impl;

import Wallet.AuthCodeReq;
import Wallet.AuthCodeRsp;
import Wallet.DownloadChooseReq;
import Wallet.DownloadChooseRsp;
import Wallet.DownloadReportReq;
import Wallet.FocusMpIdReq;
import Wallet.FocusMpIdRsp;
import Wallet.GetBroadCastHbIdiomReq;
import Wallet.GetBroadCastHbIdiomRsp;
import Wallet.GetGroupRedPackListReq;
import Wallet.GetGroupRedPackListRsp;
import Wallet.GetMiniAppReq;
import Wallet.GetMiniAppRsp;
import Wallet.GetRandomHbIdiomReq;
import Wallet.GetRandomHbIdiomRsp;
import Wallet.GetSkinListReq;
import Wallet.GetSkinListRsp;
import Wallet.IdiomRedPackMatchReq;
import Wallet.IdiomRedPackMatchRsp;
import Wallet.IsUinFocusMpIdReq;
import Wallet.IsUinFocusMpIdRsp;
import Wallet.JudgeDownloadReq;
import Wallet.JudgeDownloadRsp;
import Wallet.RedInfoSyncReq;
import Wallet.RedInfoSyncRsp;
import Wallet.ReportHBGameReq;
import Wallet.ReportHBGameRsp;
import Wallet.ReqWalletConfig;
import Wallet.ResInfo;
import Wallet.RspWalletConfig;
import Wallet.SetSelectedSkinReq;
import Wallet.SetSelectedSkinRsp;
import Wallet.SongRedPackMatchReq;
import Wallet.SongRedPackMatchRsp;
import Wallet.VoiceRedPackMatchReq;
import Wallet.VoiceRedPackMatchRsp;
import Wallet.WalletSkinReq;
import Wallet.WalletSkinRsp;
import android.content.Intent;
import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqgamepub.data.GetArkTailReq;
import com.tencent.mobileqq.qqgamepub.data.GetArkTailRsp;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoReq;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.ReportTypeReq;
import com.tencent.mobileqq.qqgamepub.data.ReportTypeRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

public class QWalletCommonServlet
  extends MSFServlet
{
  public static void a(JceStruct paramJceStruct, int paramInt, BusinessObserver paramBusinessObserver)
  {
    a(paramJceStruct, paramBusinessObserver, paramInt, 0, null);
  }
  
  private static void a(JceStruct paramJceStruct, int paramInt1, BusinessObserver paramBusinessObserver, int paramInt2, AppRuntime paramAppRuntime)
  {
    AppRuntime localAppRuntime = paramAppRuntime;
    if (paramAppRuntime == null) {
      localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    }
    paramAppRuntime = new NewIntent(localAppRuntime.getApplication(), QWalletCommonServlet.class);
    paramAppRuntime.putExtra("req", paramJceStruct);
    paramAppRuntime.putExtra("cmd_type", paramInt1);
    paramAppRuntime.putExtra("callback_thread_type", paramInt2);
    paramAppRuntime.setObserver(paramBusinessObserver);
    localAppRuntime.startServlet(paramAppRuntime);
  }
  
  public static void a(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver)
  {
    a(paramJceStruct, paramBusinessObserver, 0, 0, null);
  }
  
  public static void a(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver, int paramInt)
  {
    a(paramJceStruct, paramBusinessObserver, 0, paramInt, null);
  }
  
  public static void a(JceStruct paramJceStruct, BusinessObserver paramBusinessObserver, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    for (;;)
    {
      try
      {
        boolean bool = paramJceStruct instanceof DownloadReportReq;
        Object localObject2 = null;
        Object localObject3 = null;
        Object localObject1 = null;
        if (bool)
        {
          a(paramJceStruct, 2, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramAppRuntime = (DownloadReportReq)paramJceStruct;
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send DownloadReportReq|");
            paramBusinessObserver.append(paramAppRuntime.iType);
            paramBusinessObserver.append("|");
            paramBusinessObserver.append(paramAppRuntime.sSpeed);
            paramBusinessObserver.append("|");
            paramJceStruct = localObject1;
            if (paramAppRuntime.vecResInfo != null)
            {
              paramJceStruct = localObject1;
              if (paramAppRuntime.vecResInfo.size() > 0) {
                paramJceStruct = ((ResInfo)paramAppRuntime.vecResInfo.get(0)).sResId;
              }
            }
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else if ((paramJceStruct instanceof JudgeDownloadReq))
        {
          a(paramJceStruct, 1, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramAppRuntime = (JudgeDownloadReq)paramJceStruct;
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send JudgeDownloadReq|");
            paramBusinessObserver.append(paramAppRuntime.iType);
            paramBusinessObserver.append("|");
            paramJceStruct = localObject2;
            if (paramAppRuntime.vecResInfo != null)
            {
              paramJceStruct = localObject2;
              if (paramAppRuntime.vecResInfo.size() > 0) {
                paramJceStruct = ((ResInfo)paramAppRuntime.vecResInfo.get(0)).sResId;
              }
            }
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else if ((paramJceStruct instanceof DownloadChooseReq))
        {
          a(paramJceStruct, 3, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramAppRuntime = (DownloadChooseReq)paramJceStruct;
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send DownloadChooseReq|");
            paramJceStruct = localObject3;
            if (paramAppRuntime.vecResInfo != null)
            {
              paramJceStruct = localObject3;
              if (paramAppRuntime.vecResInfo.size() > 0) {
                paramJceStruct = ((ResInfo)paramAppRuntime.vecResInfo.get(0)).sResId;
              }
            }
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else if ((paramJceStruct instanceof WalletSkinReq))
        {
          a(paramJceStruct, 6, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (WalletSkinReq)paramJceStruct;
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send WalletSkinReq|");
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else if ((paramJceStruct instanceof ReqWalletConfig))
        {
          if (paramInt1 != 1) {
            break label1558;
          }
          paramInt1 = 17;
          a(paramJceStruct, paramInt1, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (ReqWalletConfig)paramJceStruct;
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send ReqWalletConfig|");
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else if ((paramJceStruct instanceof VoiceRedPackMatchReq))
        {
          a(paramJceStruct, 13, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send VoiceRedPackMatchReq|");
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else if ((paramJceStruct instanceof GetSkinListReq))
        {
          a(paramJceStruct, 14, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (GetSkinListReq)paramJceStruct;
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send GetSkinListReq|");
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else if ((paramJceStruct instanceof SetSelectedSkinReq))
        {
          a(paramJceStruct, 15, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (SetSelectedSkinReq)paramJceStruct;
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send SetSelectedSkinReq|");
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else if ((paramJceStruct instanceof GetGroupRedPackListReq))
        {
          a(paramJceStruct, 18, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (GetGroupRedPackListReq)paramJceStruct;
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send GetGroupRedPackListReq|");
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else if ((paramJceStruct instanceof RedInfoSyncReq))
        {
          a(paramJceStruct, 19, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (RedInfoSyncReq)paramJceStruct;
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send RedInfoSyncReq|");
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else if ((paramJceStruct instanceof ReportHBGameReq))
        {
          a(paramJceStruct, 20, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (ReportHBGameReq)paramJceStruct;
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send ReportHBGameReq|");
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else if ((paramJceStruct instanceof SongRedPackMatchReq))
        {
          a(paramJceStruct, 21, paramBusinessObserver, paramInt2, paramAppRuntime);
          if (QLog.isColorLevel())
          {
            paramJceStruct = (SongRedPackMatchReq)paramJceStruct;
            paramBusinessObserver = new StringBuilder();
            paramBusinessObserver.append("send SongRedPackMatchReq|");
            paramBusinessObserver.append(paramJceStruct);
            QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
          }
        }
        else
        {
          bool = paramJceStruct instanceof AuthCodeReq;
          if (bool)
          {
            a(paramJceStruct, 22, paramBusinessObserver, paramInt2, paramAppRuntime);
            if (QLog.isColorLevel())
            {
              paramJceStruct = (AuthCodeReq)paramJceStruct;
              paramBusinessObserver = new StringBuilder();
              paramBusinessObserver.append("send AuthCodeReq|");
              paramBusinessObserver.append(paramJceStruct);
              QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
            }
          }
          else if ((paramJceStruct instanceof GetMiniAppReq))
          {
            a(paramJceStruct, 23, paramBusinessObserver, paramInt2, paramAppRuntime);
            if (QLog.isColorLevel())
            {
              paramJceStruct = (GetMiniAppReq)paramJceStruct;
              paramBusinessObserver = new StringBuilder();
              paramBusinessObserver.append("send AuthCodeReq|");
              paramBusinessObserver.append(paramJceStruct);
              QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
            }
          }
          else if ((paramJceStruct instanceof IsUinFocusMpIdReq))
          {
            a(paramJceStruct, 24, paramBusinessObserver, paramInt2, paramAppRuntime);
            if (QLog.isColorLevel())
            {
              paramJceStruct = (IsUinFocusMpIdReq)paramJceStruct;
              paramBusinessObserver = new StringBuilder();
              paramBusinessObserver.append("send UinFocusMp|");
              paramBusinessObserver.append(paramJceStruct);
              QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
            }
          }
          else if ((paramJceStruct instanceof FocusMpIdReq))
          {
            a(paramJceStruct, 25, paramBusinessObserver, paramInt2, paramAppRuntime);
            if (QLog.isColorLevel())
            {
              paramJceStruct = (FocusMpIdReq)paramJceStruct;
              paramBusinessObserver = new StringBuilder();
              paramBusinessObserver.append("send AuthCodeReq|");
              paramBusinessObserver.append(paramJceStruct);
              QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
            }
          }
          else if ((paramJceStruct instanceof IdiomRedPackMatchReq))
          {
            a(paramJceStruct, 26, paramBusinessObserver, paramInt2, paramAppRuntime);
            if (QLog.isColorLevel())
            {
              paramJceStruct = (IdiomRedPackMatchReq)paramJceStruct;
              paramBusinessObserver = new StringBuilder();
              paramBusinessObserver.append("send AuthCodeReq|");
              paramBusinessObserver.append(paramJceStruct);
              QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
            }
          }
          else if ((paramJceStruct instanceof GetRandomHbIdiomReq))
          {
            a(paramJceStruct, 27, paramBusinessObserver, paramInt2, paramAppRuntime);
            if (QLog.isColorLevel())
            {
              paramJceStruct = (GetRandomHbIdiomReq)paramJceStruct;
              paramBusinessObserver = new StringBuilder();
              paramBusinessObserver.append("send AuthCodeReq|");
              paramBusinessObserver.append(paramJceStruct);
              QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
            }
          }
          else if ((paramJceStruct instanceof GetBroadCastHbIdiomReq))
          {
            a(paramJceStruct, 28, paramBusinessObserver, paramInt2, paramAppRuntime);
            if (QLog.isColorLevel())
            {
              paramJceStruct = (GetBroadCastHbIdiomReq)paramJceStruct;
              paramBusinessObserver = new StringBuilder();
              paramBusinessObserver.append("send AuthCodeReq|");
              paramBusinessObserver.append(paramJceStruct);
              QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
            }
          }
          else if ((paramJceStruct instanceof GetArkTailReq))
          {
            a(paramJceStruct, 29, paramBusinessObserver, paramInt2, paramAppRuntime);
            if (QLog.isColorLevel())
            {
              paramJceStruct = (GetArkTailReq)paramJceStruct;
              paramBusinessObserver = new StringBuilder();
              paramBusinessObserver.append("send GetArkTailReq|");
              paramBusinessObserver.append(paramJceStruct);
              QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
            }
          }
          else if ((paramJceStruct instanceof ReportTypeReq))
          {
            a(paramJceStruct, 30, paramBusinessObserver, paramInt2, paramAppRuntime);
            if (QLog.isColorLevel())
            {
              paramJceStruct = (ReportTypeReq)paramJceStruct;
              paramBusinessObserver = new StringBuilder();
              paramBusinessObserver.append("send ReportTypeReq|");
              paramBusinessObserver.append(paramJceStruct);
              QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
            }
          }
          else if ((paramJceStruct instanceof GmpEnterInfoReq))
          {
            a(paramJceStruct, 31, paramBusinessObserver, paramInt2, paramAppRuntime);
            if (QLog.isColorLevel())
            {
              paramJceStruct = (GmpEnterInfoReq)paramJceStruct;
              paramBusinessObserver = new StringBuilder();
              paramBusinessObserver.append("send GET_GAME_ENTRY|");
              paramBusinessObserver.append(paramJceStruct);
              QLog.d("QWalletCommonServlet", 2, paramBusinessObserver.toString());
              return;
            }
          }
        }
      }
      catch (Throwable paramJceStruct)
      {
        if (QLog.isColorLevel())
        {
          paramBusinessObserver = new StringBuilder();
          paramBusinessObserver.append("sendRequest|");
          paramBusinessObserver.append(paramJceStruct.toString());
          QLog.e("QWalletCommonServlet", 2, paramBusinessObserver.toString());
        }
      }
      return;
      label1558:
      paramInt1 = 10;
    }
  }
  
  public void notifyObserver(Intent paramIntent, int paramInt, boolean paramBoolean, Bundle paramBundle, Class<? extends BusinessObserver> paramClass)
  {
    if (paramIntent.getIntExtra("callback_thread_type", 0) == 0)
    {
      super.notifyObserver(paramIntent, paramInt, paramBoolean, paramBundle, paramClass);
      return;
    }
    if ((paramIntent instanceof NewIntent))
    {
      paramIntent = ((NewIntent)paramIntent).getObserver();
      if (paramIntent != null) {
        ThreadManager.post(new QWalletCommonServlet.1(this, paramIntent, paramInt, paramBoolean, paramBundle), 5, null, true);
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramIntent != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      boolean bool = "QQPayFrequencySvc.judgeDownload".equals(str);
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject8 = null;
      Object localObject1 = null;
      Object localObject2 = null;
      StringBuilder localStringBuilder = null;
      Object localObject9 = null;
      Object localObject10 = null;
      Object localObject11 = null;
      Object localObject12 = null;
      Object localObject13 = null;
      Object localObject14 = null;
      Object localObject15 = null;
      Object localObject16 = null;
      Object localObject17 = null;
      Object localObject18 = null;
      Object localObject19 = null;
      Object localObject20 = null;
      Object localObject3 = null;
      if (bool)
      {
        localObject1 = localObject3;
        if (paramFromServiceMsg.isSuccess()) {
          localObject1 = (JudgeDownloadRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new JudgeDownloadRsp());
        }
        localObject2 = new Bundle();
        if (localObject1 != null) {
          ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
        }
        ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
        notifyObserver(paramIntent, 1, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        return;
      }
      if ("QQPayFrequencySvc.downloadChoose".equals(str))
      {
        localObject1 = localObject4;
        if (paramFromServiceMsg.isSuccess()) {
          localObject1 = (DownloadChooseRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new DownloadChooseRsp());
        }
        localObject2 = new Bundle();
        if (localObject1 != null) {
          ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
        }
        ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
        notifyObserver(paramIntent, 3, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        return;
      }
      if ("QQWalletPayReportSvc.getWalletSkin".equals(str))
      {
        localObject1 = localObject5;
        if (paramFromServiceMsg.isSuccess()) {
          localObject1 = (WalletSkinRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new WalletSkinRsp());
        }
        localObject2 = new Bundle();
        if (localObject1 != null) {
          ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
        }
        ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
        notifyObserver(paramIntent, 6, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        return;
      }
      if ("WalletConfigSvr.getConfig".equals(str))
      {
        localObject1 = localObject6;
        if (paramFromServiceMsg.isSuccess()) {
          localObject1 = (RspWalletConfig)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new RspWalletConfig());
        }
        localObject2 = new Bundle();
        if (localObject1 != null) {
          ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
        }
        ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
        notifyObserver(paramIntent, 10, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        return;
      }
      if ("WalletConfigSvr.setUserSession".equals(str))
      {
        localObject1 = localObject7;
        if (paramFromServiceMsg.isSuccess()) {
          localObject1 = (RspWalletConfig)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new RspWalletConfig());
        }
        localObject2 = new Bundle();
        if (localObject1 != null) {
          ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
        }
        ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
        notifyObserver(paramIntent, 17, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        return;
      }
      if ((str != null) && (str.startsWith("QQwalletVoicePack.macthVoice")))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QWalletCommonServlet", 2, "voice redpacket msg grap back...");
        }
        localObject1 = localObject8;
        if (paramFromServiceMsg.isSuccess()) {
          localObject1 = (VoiceRedPackMatchRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new VoiceRedPackMatchRsp());
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("CMD_VOICE_RED_PACKET isSuccess:");
          ((StringBuilder)localObject2).append(paramFromServiceMsg.isSuccess());
          QLog.d("QWalletCommonServlet", 2, ((StringBuilder)localObject2).toString());
        }
        if ((localObject1 != null) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("rsp.status = ");
          ((StringBuilder)localObject2).append(((VoiceRedPackMatchRsp)localObject1).status);
          QLog.d("QWalletCommonServlet", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new Bundle();
        if (localObject1 != null) {
          ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
        }
        ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
        ((Bundle)localObject2).putInt("msfRetCode", paramFromServiceMsg.getResultCode());
        notifyObserver(paramIntent, 13, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        return;
      }
      if ("VAC_RedEnvelopeSkinSvc.GetSkinList".equals(str))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("GetSkinListRsp isSuccess:");
          ((StringBuilder)localObject2).append(paramFromServiceMsg.isSuccess());
          QLog.d("QWalletCommonServlet", 2, ((StringBuilder)localObject2).toString());
        }
        if (paramFromServiceMsg.isSuccess()) {
          localObject1 = (GetSkinListRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetSkinListRsp());
        }
        localObject2 = new Bundle();
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("GetSkinListRsp = ");
            localStringBuilder.append(localObject1);
            QLog.d("QWalletCommonServlet", 2, localStringBuilder.toString());
          }
          ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
        }
        ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
        notifyObserver(paramIntent, 14, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        return;
      }
      if ("VAC_RedEnvelopeSkinSvc.SetSelectedSkin".equals(str))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("SetSelectedSkinRsp isSuccess:");
          ((StringBuilder)localObject1).append(paramFromServiceMsg.isSuccess());
          QLog.d("QWalletCommonServlet", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = localObject2;
        if (paramFromServiceMsg.isSuccess()) {
          localObject1 = (SetSelectedSkinRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new SetSelectedSkinRsp());
        }
        localObject2 = new Bundle();
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("SetSelectedSkinRsp = ");
            localStringBuilder.append(localObject1);
            QLog.d("QWalletCommonServlet", 2, localStringBuilder.toString());
          }
          ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
        }
        ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
        notifyObserver(paramIntent, 15, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        return;
      }
      if ("GroupRedPackListSvc.getGroupRedPackList".equals(str))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("GetGroupRedPackListRsp isSuccess:");
          ((StringBuilder)localObject1).append(paramFromServiceMsg.isSuccess());
          QLog.d("QWalletCommonServlet", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = localStringBuilder;
        if (paramFromServiceMsg.isSuccess()) {
          localObject1 = (GetGroupRedPackListRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetGroupRedPackListRsp());
        }
        localObject2 = new Bundle();
        if (localObject1 != null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("GetGroupRedPackListRsp = ");
            localStringBuilder.append(localObject1);
            QLog.d("QWalletCommonServlet", 2, localStringBuilder.toString());
          }
          ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
        }
        ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
        notifyObserver(paramIntent, 18, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        return;
      }
      if ("WalletConfigSvr.syncRedInfo".equals(str))
      {
        localObject1 = localObject9;
        if (paramFromServiceMsg.isSuccess()) {
          localObject1 = (RedInfoSyncRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new RedInfoSyncRsp());
        }
        localObject2 = new Bundle();
        if (localObject1 != null) {
          ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
        }
        ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
        notifyObserver(paramIntent, 19, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        return;
      }
      if ("GroupRedPackListSvc.reportHBGame".equals(str))
      {
        if (paramFromServiceMsg.isSuccess())
        {
          paramIntent = (ReportHBGameRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new ReportHBGameRsp());
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("ReportHBGameRsp result = ");
            paramFromServiceMsg.append(paramIntent.result);
            QLog.d("QWalletCommonServlet", 2, paramFromServiceMsg.toString());
          }
        }
      }
      else
      {
        if ((str != null) && (str.startsWith("QQwalletVoicePack.macthSong")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QWalletCommonServlet", 2, "song redpacket msg grap back...");
          }
          localObject1 = localObject10;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (SongRedPackMatchRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new SongRedPackMatchRsp());
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("CMD_SONG_RED_PACKET isSuccess:");
            ((StringBuilder)localObject2).append(paramFromServiceMsg.isSuccess());
            QLog.d("QWalletCommonServlet", 2, ((StringBuilder)localObject2).toString());
          }
          if ((localObject1 != null) && (QLog.isColorLevel()))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("rsp.status = ");
            ((StringBuilder)localObject2).append(((SongRedPackMatchRsp)localObject1).status);
            QLog.d("QWalletCommonServlet", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 21, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
          return;
        }
        if ("VacThirdCodeSvc.fetchCodes".equals(str))
        {
          localObject1 = localObject11;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (AuthCodeRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AuthCodeRsp());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 22, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
          return;
        }
        if ("MiniAppSvc.get_mini_app".equals(str))
        {
          localObject1 = localObject12;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (GetMiniAppRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetMiniAppRsp());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 23, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
          return;
        }
        if ("MiniAppSvc.is_uin_focus_mpid".equals(str))
        {
          localObject1 = localObject13;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (IsUinFocusMpIdRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new IsUinFocusMpIdRsp());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 24, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
          return;
        }
        if ("MiniAppSvc.focus_mpid".equals(str))
        {
          localObject1 = localObject14;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (FocusMpIdRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new FocusMpIdRsp());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 25, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
          return;
        }
        if ("QQwalletVoicePack.macthIdiom".equals(str))
        {
          localObject1 = localObject15;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (IdiomRedPackMatchRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new IdiomRedPackMatchRsp());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 26, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
          return;
        }
        if ("QQwalletVoicePack.GetRandomHbIdiom".equals(str))
        {
          localObject1 = localObject16;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (GetRandomHbIdiomRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetRandomHbIdiomRsp());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 27, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
          return;
        }
        if ("QQwalletVoicePack.GetBroadCastHbIdiom".equals(str))
        {
          localObject1 = localObject17;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (GetBroadCastHbIdiomRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetBroadCastHbIdiomRsp());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 28, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
          return;
        }
        if ("GameCenterWebSvc.13571".equals(str))
        {
          localObject1 = localObject18;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (GetArkTailRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GetArkTailRsp());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 29, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
          return;
        }
        if ("GameCenterWebSvc.13572".equals(str))
        {
          localObject1 = localObject19;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (ReportTypeRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new ReportTypeRsp());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 30, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
          return;
        }
        if ("GameMpSvc.EnterInfo".equals(str))
        {
          localObject1 = localObject20;
          if (paramFromServiceMsg.isSuccess()) {
            localObject1 = (GmpEnterInfoRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new GmpEnterInfoRsp());
          }
          localObject2 = new Bundle();
          if (localObject1 != null) {
            ((Bundle)localObject2).putSerializable("rsp", (Serializable)localObject1);
          }
          ((Bundle)localObject2).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 31, paramFromServiceMsg.isSuccess(), (Bundle)localObject2, null);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QWalletCommonServlet", 2, "onReceive request or response is null");
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getExtras().getInt("cmd_type");
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 6) {
            if (i != 10) {
              switch (i)
              {
              default: 
                switch (i)
                {
                default: 
                  return;
                }
                break;
              }
            }
          }
        }
      }
    }
    try
    {
      paramPacket.addRequestPacket("req", (GmpEnterInfoReq)paramIntent.getSerializableExtra("req"));
      paramPacket.setSSOCommand("GameMpSvc.EnterInfo");
      paramPacket.setFuncName("EnterInfo");
      paramPacket.setServantName("GameCenter.GameMpoperServer.GameMpoperObj");
      return;
    }
    catch (OutOfMemoryError|Throwable paramIntent) {}
    paramPacket.addRequestPacket("req", (ReportTypeReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("GameCenterWebSvc.13572");
    paramPacket.setFuncName("ReportType");
    paramPacket.setServantName("GameCenter.GameContentAdaptServer.GameContentAdaptObj");
    return;
    paramPacket.addRequestPacket("req", (GetArkTailReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("GameCenterWebSvc.13571");
    paramPacket.setFuncName("GetArkTail");
    paramPacket.setServantName("GameCenter.GameContentAdaptServer.GameContentAdaptObj");
    return;
    paramPacket.addRequestPacket("req", (GetBroadCastHbIdiomReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("QQwalletVoicePack.GetBroadCastHbIdiom");
    paramPacket.setFuncName("GetBroadCastHbIdiom");
    paramPacket.setServantName("Wallet.VoiceMatchServer.VoiceMatchObj");
    return;
    paramPacket.addRequestPacket("req", (GetRandomHbIdiomReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("QQwalletVoicePack.GetRandomHbIdiom");
    paramPacket.setFuncName("GetRandomHbIdiom");
    paramPacket.setServantName("Wallet.VoiceMatchServer.VoiceMatchObj");
    return;
    paramPacket.addRequestPacket("req", (IdiomRedPackMatchReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("QQwalletVoicePack.macthIdiom");
    paramPacket.setFuncName("macthIdiom");
    paramPacket.setServantName("Wallet.VoiceMatchServer.VoiceMatchObj");
    return;
    paramPacket.addRequestPacket("req", (FocusMpIdReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("MiniAppSvc.focus_mpid");
    paramPacket.setFuncName("focus_mpid");
    paramPacket.setServantName("Wallet.MiniAppServer.MiniAppObj");
    return;
    paramPacket.addRequestPacket("req", (IsUinFocusMpIdReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("MiniAppSvc.is_uin_focus_mpid");
    paramPacket.setFuncName("is_uin_focus_mpid");
    paramPacket.setServantName("Wallet.MiniAppServer.MiniAppObj");
    return;
    paramPacket.addRequestPacket("req", (GetMiniAppReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("MiniAppSvc.get_mini_app");
    paramPacket.setFuncName("get_mini_app");
    paramPacket.setServantName("Wallet.MiniAppServer.MiniAppObj");
    return;
    paramPacket.addRequestPacket("req", (AuthCodeReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("VacThirdCodeSvc.fetchCodes");
    paramPacket.setFuncName("fetchCodes");
    paramPacket.setServantName("VAC.AuthCodeCoroServer.AuthCodeCoroObj");
    return;
    paramPacket.addRequestPacket("req", (SongRedPackMatchReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("QQwalletVoicePack.macthSong");
    paramPacket.setFuncName("macthSong");
    paramPacket.setServantName("Wallet.VoiceMatchServer.VoiceMatchObj");
    return;
    paramPacket.addRequestPacket("req", (ReportHBGameReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("GroupRedPackListSvc.reportHBGame");
    paramPacket.setFuncName("reportHBGame");
    paramPacket.setServantName("Wallet.WalletHBGameServer.WalletHBGameObj");
    return;
    paramPacket.addRequestPacket("req", (RedInfoSyncReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("WalletConfigSvr.syncRedInfo");
    paramPacket.setFuncName("syncRedInfo");
    paramPacket.setServantName("Wallet.MobileWalletConfigServer.MobileWalletConfigObj");
    return;
    paramPacket.addRequestPacket("req", (GetGroupRedPackListReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("GroupRedPackListSvc.getGroupRedPackList");
    paramPacket.setFuncName("getGroupRedPackList");
    paramPacket.setServantName("Wallet.GroupRedPackListServer.GroupRedPackListObj");
    paramPacket.setTimeout(5000L);
    return;
    paramPacket.addRequestPacket("req", (ReqWalletConfig)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("WalletConfigSvr.setUserSession");
    paramPacket.setFuncName("setUserSession");
    paramPacket.setServantName("Wallet.MobileWalletConfigServer.MobileWalletConfigObj");
    return;
    paramPacket.addRequestPacket("req", (SetSelectedSkinReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("VAC_RedEnvelopeSkinSvc.SetSelectedSkin");
    paramPacket.setFuncName("SetSelectedSkin");
    paramPacket.setServantName("Wallet.RedEnvelopeSkinServer.RedEnvelopeSkinObj");
    paramPacket.setTimeout(15000L);
    return;
    paramPacket.addRequestPacket("req", (GetSkinListReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("VAC_RedEnvelopeSkinSvc.GetSkinList");
    paramPacket.setFuncName("GetSkinList");
    paramPacket.setServantName("Wallet.RedEnvelopeSkinServer.RedEnvelopeSkinObj");
    paramPacket.setTimeout(15000L);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("QWalletCommonServlet", 2, "build voice redpacket sso package...");
    }
    paramPacket.addRequestPacket("req", (VoiceRedPackMatchReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("QQwalletVoicePack.macthVoice");
    paramPacket.setFuncName("macthVoice");
    paramPacket.setServantName("Wallet.VoiceMatchServer.VoiceMatchObj");
    return;
    paramPacket.addRequestPacket("req", (ReqWalletConfig)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("WalletConfigSvr.getConfig");
    paramPacket.setFuncName("getConfig");
    paramPacket.setServantName("Wallet.MobileWalletConfigServer.MobileWalletConfigObj");
    return;
    paramPacket.addRequestPacket("req", (WalletSkinReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("QQWalletPayReportSvc.getWalletSkin");
    paramPacket.setFuncName("getWalletSkin");
    paramPacket.setServantName("Wallet.WalletSkinServer.WalletSkinObj");
    paramPacket.setTimeout(15000L);
    return;
    paramPacket.addRequestPacket("req", (DownloadChooseReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("QQPayFrequencySvc.downloadChoose");
    paramPacket.setFuncName("downloadChoose");
    paramPacket.setServantName("Wallet.FrequencyControlServer.FrequencyControlObj");
    return;
    paramPacket.addRequestPacket("req", (DownloadReportReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("QQPayFrequencySvc.downloadReport");
    paramPacket.setFuncName("downloadReport");
    paramPacket.setServantName("Wallet.FrequencyControlServer.FrequencyControlObj");
    return;
    paramPacket.addRequestPacket("req", (JudgeDownloadReq)paramIntent.getSerializableExtra("req"));
    paramPacket.setSSOCommand("QQPayFrequencySvc.judgeDownload");
    paramPacket.setFuncName("judgeDownload");
    paramPacket.setServantName("Wallet.FrequencyControlServer.FrequencyControlObj");
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.impl.QWalletCommonServlet
 * JD-Core Version:    0.7.0.1
 */