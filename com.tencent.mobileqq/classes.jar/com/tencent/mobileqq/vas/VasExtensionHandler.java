package com.tencent.mobileqq.vas;

import amma;
import amme;
import amna;
import amts;
import amtt;
import amwn;
import anba;
import anbb;
import anbc;
import anbd;
import anbe;
import ancd;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import anex;
import ankc;
import anvk;
import anvx;
import aocy;
import aqlr;
import avce;
import avhz;
import avia;
import avkh;
import axlp;
import aztk;
import bcrg;
import bcvc;
import bfkh;
import bfkw;
import bhhr;
import bhnd;
import bhoa;
import bhot;
import bhou;
import bhow;
import bhox;
import bhql;
import bimv;
import bkjq;
import com.hiboom.protocol.DiyEmotionPb.Filter_Req;
import com.hiboom.protocol.DiyEmotionPb.Filter_Req_Comm;
import com.hiboom.protocol.DiyEmotionPb.Filter_Rsp;
import com.hiboom.protocol.DiyEmotionPb.Filter_Text_Req;
import com.hiboom.protocol.DiyEmotionPb.Filter_Text_Rsp;
import com.tencent.IndividPub.IndividPub.Platform_Comm_Req;
import com.tencent.IndividPub.IndividPub.expTips_Pull_Req;
import com.tencent.IndividPub.IndividPub.expTips_Pull_Rsp;
import com.tencent.IndividPub.IndividPub.expTips_Req;
import com.tencent.IndividPub.IndividPub.expTips_Rsp;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.common.util.ReportInfoManager.ReportChannlInfo;
import com.tencent.mobileqq.WebSsoBody.STServiceMonitItem;
import com.tencent.mobileqq.WebSsoBody.STServiceMonitReq;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.pendant.PendantTipsInfo;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.ApolloGameScoreData;
import com.tencent.mobileqq.data.ApolloObtainedActionData;
import com.tencent.mobileqq.data.ApolloRecommendAction;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.FriendInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.GameInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.Gift;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.LabelInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.RedInfo;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.TopCardInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.praise.praise_sso.TPraiseSsoReq;
import com.tencent.mobileqq.praise.praise_sso.TPraiseSsoRsp;
import com.tencent.mobileqq.praise.praise_sso.TSsoCmd0x1Req;
import com.tencent.mobileqq.praise.praise_sso.TSsoCmd0x1Rsp;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.apollo.CmGameMsgTunnel.AddrDistribueReq;
import com.tencent.pb.apollo.CmGameMsgTunnel.AddrDistribueRsp;
import com.tencent.pb.apollo.GetTinyID.STTinyID2UserAccInfoRsp;
import com.tencent.pb.apollo.GetTinyID.STUserAccInfo;
import com.tencent.pb.apollo.STExploreInfo.STEntryIdInfo;
import com.tencent.pb.apollo.STExploreInfo.STEntryIdMsg;
import com.tencent.pb.apollo.STExploreInfo.STGetMsgReq;
import com.tencent.pb.apollo.STExploreInfo.STGetMsgRsp;
import com.tencent.pb.apollo.STExploreInfo.STMsgInfo;
import com.tencent.pb.apollo.STGameLogin.STGameLoginReq;
import com.tencent.pb.apollo.STGameLogin.STGetGameConfReq;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserTrackReq;
import com.tencent.pb.gamecenter.MonitReport.MonitReportReq;
import com.tencent.pb.gamecenter.MonitReport.PublicAccountReq;
import com.tencent.pb.pendantMarket.PendantMarket.SetAddonReq;
import com.tencent.pb.pendantMarket.PendantMarket.SetAddonRsp;
import com.tencent.pb.pendantMarket.PendantMarket.TipsInfo;
import com.tencent.pb.scupdate.SCUpdatePB.GetUrlReq;
import com.tencent.pb.scupdate.SCUpdatePB.GetUrlRsp;
import com.tencent.pb.scupdate.SCUpdatePB.ItemVersion;
import com.tencent.pb.scupdate.SCUpdatePB.SCPreload;
import com.tencent.pb.scupdate.SCUpdatePB.SCReport;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateReq;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateReqComm;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateRsp;
import com.tencent.pb.scupdate.SCUpdatePB.SCUpdateRspComm;
import com.tencent.pb.scupdate.SCUpdatePB.SyncVCRReq;
import com.tencent.pb.scupdate.SCUpdatePB.SyncVCRRsp;
import com.tencent.pb.scupdate.SCUpdatePB.UpdateInfo;
import com.tencent.pb.scupdate.SCUpdatePB.VCR;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.RspBody;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAVCtrlParamRsp;
import com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel.STAudioVideoRsp;
import gb;
import gm;
import gxh_message.Dialogue;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import onq;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.apollo_game_status.STGameStateMsgList;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ClientInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.CommCardNameBuf;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.MemberInfo;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.ReqBody;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RichCardNameElem;
import tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActReadReq;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActReadRsp;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActReq;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActRsp;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPUsrInfo;
import tencent.im.oidb.qqshop.qqshop_code.SReq;
import tencent.im.oidb.qqshop.qqshop_code.SRsp;
import tencent.qun.group_effect.group_effect_commu.ReqBody;
import tencent.qun.group_effect.group_effect_commu.RspBody;
import tencent.qun.group_effect.group_effect_commu.TEffectDetail;
import tencent.qun.group_effect.group_effect_commu.TEntryNotifyReq0x2000;
import tencent.qun.group_effect.group_effect_commu.TEntryNotifyRsp0x2000;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectReq0x2;
import tencent.qun.group_effect.group_effect_commu.TGetMyEffectRsp0x2;

public class VasExtensionHandler
  extends BusinessHandler
{
  public static String a;
  public static final Map<String, bhnd> a;
  private static long b;
  public static String b;
  private static long c;
  public static String c;
  public static String d = "SyncVCRReq";
  public static String e = "SyncVCRRsp";
  public static String f = "GetUrlReq";
  public static String g = "GetUrlRsp";
  public int a;
  long jdField_a_of_type_Long = 0L;
  public Bundle a;
  public aztk a;
  private HashMap<String, BusinessObserver> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<bhot> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Vector<Long> jdField_a_of_type_JavaUtilVector = new Vector();
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VasExtensionHandler";
    jdField_b_of_type_JavaLangString = "Addon.Set";
    jdField_c_of_type_JavaLangString = "IndividPub.ExpTips";
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put("qqvalue.GetQQValue", new bhoa());
  }
  
  public VasExtensionHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void A(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleSetUserFlagResponse]");
    }
    HashMap localHashMap = new HashMap();
    int i;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getByteArrayExtra("data");
      if (paramIntent != null)
      {
        Object localObject = new WebSSOAgent.UniSsoServerReq();
        try
        {
          ((WebSSOAgent.UniSsoServerReq)localObject).mergeFrom(paramIntent);
          paramIntent = new JSONObject(((WebSSOAgent.UniSsoServerReq)localObject).reqdata.get());
          if (paramIntent.has("flagInfo"))
          {
            paramIntent = paramIntent.getJSONArray("flagInfo");
            if (paramIntent != null)
            {
              i = 0;
              int j = paramIntent.length();
              while (i < j)
              {
                localObject = paramIntent.getJSONObject(i);
                if (localObject != null) {
                  localHashMap.put(Integer.valueOf(((JSONObject)localObject).optInt("type")), Integer.valueOf(((JSONObject)localObject).optInt("value")));
                }
                i += 1;
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break label193;
          }
        }
        catch (Exception paramIntent)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleSetUserFlagResponse] get request data exception=", paramIntent);
        }
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSetUserFlagResponse] flagSettingMap=", localHashMap });
    label193:
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      long l;
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        l = paramIntent.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSetUserFlagResponse] ret=", Long.valueOf(l) });
        }
        if ((l != 0L) || (!localHashMap.containsKey(Integer.valueOf(16)))) {
          break label518;
        }
        i = ((Integer)localHashMap.get(Integer.valueOf(16))).intValue();
        paramIntent = (amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER);
        paramFromServiceMsg = paramIntent.b(this.app.getCurrentAccountUin());
        if ((paramFromServiceMsg == null) || ((paramFromServiceMsg.apolloAISwitch & 0x10) == i << 4)) {
          break label518;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSetUserFlagResponse] before update, apolloAISwitch=", Integer.toBinaryString(paramFromServiceMsg.apolloAISwitch) });
        }
        paramFromServiceMsg.apolloAISwitch = (paramFromServiceMsg.apolloAISwitch & 0xFFFFFFEF | paramFromServiceMsg.apolloAISwitch ^ 0x10);
        paramIntent.a(paramFromServiceMsg);
        if (!QLog.isColorLevel()) {
          break label518;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSetUserFlagResponse] after update, apolloAISwitch=", Integer.toBinaryString(paramFromServiceMsg.apolloAISwitch) });
      }
      catch (Exception paramIntent)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "[handleSetUserFlagResponse] exception=", paramIntent);
        notifyUI(22, false, localHashMap);
        return;
      }
      notifyUI(22, bool, localHashMap);
      return;
      boolean bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSetUserFlagResponse] failed, result code=", Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      }
      notifyUI(22, false, null);
      return;
      label518:
      if (0L == l) {
        bool = true;
      }
    }
  }
  
  private void B(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("id", paramIntent.getIntExtra("id", -1));
    localBundle.putString("name", paramIntent.getStringExtra("name"));
    localBundle.putString("minVersion", paramIntent.getStringExtra("minVersion"));
    localBundle.putInt("feeType", paramIntent.getIntExtra("feeType", 0));
    localBundle.putInt("fromType", paramIntent.getIntExtra("fromType", 0));
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        long l = paramIntent.ret.get();
        paramIntent = paramIntent.errmsg.get();
        if (l == 0L)
        {
          notifyUI(23, true, localBundle);
          return;
        }
        localBundle.putLong("result", l);
        localBundle.putString("msg", paramIntent);
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handlePokeAuthResp failed " + paramIntent);
      }
      catch (Exception paramIntent)
      {
        localBundle.putInt("result", -254);
        localBundle.putString("msg", anvx.a(2131715404));
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handlePokeAuthResp failed ", paramIntent);
        continue;
      }
      notifyUI(23, false, localBundle);
      return;
      localBundle.putInt("result", -255);
      localBundle.putString("msg", anvx.a(2131715405));
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handlePokeAuthResp fail ret: " + paramFromServiceMsg.getResultCode());
      }
    }
  }
  
  private void C(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleGameOnlineCountRsp]");
    }
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameOnlineCountRsp] data null or rsp failed");
      notifyUI(25, false, null);
      return;
    }
    try
    {
      paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
      paramFromServiceMsg.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGameOnlineCountRsp] ret=", Long.valueOf(paramFromServiceMsg.ret.get()) });
      }
      if (paramFromServiceMsg.ret.get() == 0L)
      {
        paramFromServiceMsg = paramFromServiceMsg.rspdata.get();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGameOnlineCountRsp] respData=", paramFromServiceMsg });
        }
        paramFromServiceMsg = new JSONObject(paramFromServiceMsg).optJSONObject("data");
        if (paramIntent != null) {
          paramFromServiceMsg.put("tipsBarAnimation", paramIntent.getBooleanExtra("tipsBarAnimation", false));
        }
        notifyUI(25, true, paramFromServiceMsg);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameOnlineCountRsp] exception=", paramIntent);
      return;
    }
    notifyUI(25, false, null);
  }
  
  private void D(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {
      QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD fail data = " + paramArrayOfByte + " errorcode = " + paramFromServiceMsg.getResultCode() + " ssoSeq = " + paramFromServiceMsg.getRequestSsoSeq());
    }
    long l;
    do
    {
      for (;;)
      {
        return;
        paramFromServiceMsg = new group_effect_commu.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          l = paramIntent.getLongExtra("usrdata", 0L);
          if (paramFromServiceMsg.ret.get() != 0) {
            break label357;
          }
          paramIntent = (bfkw)this.app.getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
          if (l == 8192L)
          {
            paramFromServiceMsg = (group_effect_commu.TEntryNotifyRsp0x2000)paramFromServiceMsg.st_entry_notify.get();
            if (paramFromServiceMsg != null)
            {
              paramArrayOfByte = (group_effect_commu.TEffectDetail)paramFromServiceMsg.st_userconfig.get();
              paramIntent.jdField_a_of_type_Long = (paramFromServiceMsg.notify_interval.get() * 1000);
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopEnterEffect", 2, "handleTroopEnterEffectCMD ENTER_GROUP success notifyInteval = " + paramIntent.jdField_a_of_type_Long);
          }
        }
        catch (Exception paramIntent)
        {
          QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD error: " + paramIntent.getMessage());
          return;
        }
      }
    } while (l != 2L);
    paramFromServiceMsg = (group_effect_commu.TGetMyEffectRsp0x2)paramFromServiceMsg.st_get_effect.get();
    if (paramFromServiceMsg != null)
    {
      if (paramFromServiceMsg.ret.get() != 0)
      {
        QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD getMyEffect fail");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "handleTroopEnterEffectCMD getMyEffect success");
      }
      paramArrayOfByte = new bfkh();
      paramArrayOfByte.a(paramFromServiceMsg);
      paramIntent.a(paramArrayOfByte);
      paramIntent.a(paramFromServiceMsg);
      bhhr.f(this.app.getApplication(), this.app.getCurrentAccountUin(), System.currentTimeMillis());
      notifyUI(26, true, null);
      return;
    }
    QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD getMyEffect rsp is null");
    return;
    label357:
    QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD error cmd = " + l + " ret = " + paramFromServiceMsg.ret.get());
  }
  
  private void E(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleApolloGameLoginReq] ret=", Long.valueOf(paramIntent.ret.get()) });
        }
        if (paramIntent.ret.get() == 0L)
        {
          if (this.app != null)
          {
            ((amma)this.app.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a(paramIntent.ret.get(), paramIntent.pbRsqData.get().toByteArray());
            return;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleApolloGameLoginReq] app is null");
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleApolloGameLoginReq] exception=", paramIntent);
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, new Object[] { "[handleApolloGameLoginReq] failed ret:", Long.valueOf(paramIntent.ret.get()) });
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleApolloGameLoginReq] failed");
  }
  
  private void F(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGameConfigListReq] ret=", Long.valueOf(paramFromServiceMsg.ret.get()) });
        }
        if (paramFromServiceMsg.ret.get() == 0L)
        {
          if (this.app != null)
          {
            ((amma)this.app.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a(paramFromServiceMsg.ret.get(), paramFromServiceMsg.pbRsqData.get().toByteArray(), paramIntent.getBundleExtra("extras"));
            return;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameConfigListReq] app is null");
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameConfigListReq] exception=", paramIntent);
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, new Object[] { "[handleGameConfigListReq] failed ret:", Long.valueOf(paramFromServiceMsg.ret.get()) });
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameConfigListReq] failed");
  }
  
  private void G(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleApolloGameDevList]");
    }
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      int i;
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleApolloGameDevList] ret=", Long.valueOf(paramIntent.ret.get()) });
        }
        if (paramIntent.ret.get() == 0L)
        {
          paramIntent = paramIntent.rspdata.get();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleApolloGameDevList] respData=", paramIntent });
          }
          if ((this.mApp != null) && (!TextUtils.isEmpty(paramIntent)))
          {
            paramFromServiceMsg = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
            paramIntent = new JSONObject(paramIntent).optJSONObject("data");
            i = paramIntent.optInt("innerUin");
            paramArrayOfByte = paramIntent.optJSONArray("gameIdList");
            paramIntent = "";
            if (paramArrayOfByte == null) {
              break label309;
            }
            paramIntent = paramArrayOfByte.toString();
            break label309;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleApolloGameDevList] innerUin:", Integer.valueOf(i), ",gameIdList:", paramArrayOfByte });
            }
            paramFromServiceMsg.edit().putString(this.mApp.getCurrentAccountUin() + "_" + "cmgame_sp_dev_game_list", paramIntent).commit();
          }
        }
        return;
      }
      catch (Throwable paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleApolloGameDevList] exception=", paramIntent);
        return;
      }
      label309:
      if (i == 1) {
        paramIntent = "1";
      }
    }
  }
  
  private void H(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    label255:
    for (;;)
    {
      try
      {
        paramIntent = (DiyEmotionPb.Filter_Rsp)new DiyEmotionPb.Filter_Rsp().mergeFrom(paramArrayOfByte);
        int i;
        if (paramIntent.ret.get() == 0L)
        {
          i = 1;
          if (i == 0) {
            break label255;
          }
          bool1 = ((Boolean)paramIntent.rspcmd_0x01.is_valid.get(0)).booleanValue();
          paramIntent = new Bundle();
          if (paramFromServiceMsg.getResultCode() == 1002)
          {
            bool2 = true;
            paramIntent.putBoolean("timeout", bool2);
            paramIntent.putBoolean("legalSuccess", bool1);
            long l = SystemClock.uptimeMillis() - jdField_c_of_type_Long;
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "RichTextIllegalWordTime", bool1, l, 0L, null, "");
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "costTime:" + l + " isTimeOut:" + bool2 + " legalSuccess:" + bool1);
            }
            ((avkh)this.app.getManager(QQManagerFactory.HIBOOM_MANAGER)).b(bool1);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        boolean bool2 = false;
        continue;
        boolean bool1 = false;
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "diy handler onRecive fail err:" + paramIntent.getMessage());
        return;
      }
    }
  }
  
  private void I(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "handleCmGameConnInfoRsp, code=" + paramFromServiceMsg.getResultCode());
    Object localObject = null;
    paramIntent = localObject;
    if (paramArrayOfByte != null)
    {
      paramIntent = localObject;
      if (!paramFromServiceMsg.isSuccess()) {}
    }
    for (;;)
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        long l = paramIntent.ret.get();
        QLog.e(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleCmGameConnInfoRsp] unissoRet=", Long.valueOf(l) });
        if (l != 0L) {
          break label225;
        }
        paramFromServiceMsg = new CmGameMsgTunnel.AddrDistribueRsp();
        paramFromServiceMsg.mergeFrom(paramIntent.pbRsqData.get().toByteArray());
        int i = paramFromServiceMsg.port.get();
        paramIntent = new amtt(paramFromServiceMsg.ip_list.get(), i, paramFromServiceMsg.aes_key.get(), paramFromServiceMsg.distribute_ts.get(), paramFromServiceMsg.sign.get());
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "[handleCmGameConnInfoRsp] failed ", paramIntent);
        paramIntent = localObject;
        continue;
        paramFromServiceMsg.b();
        return;
      }
      paramFromServiceMsg = ((amme)this.mApp.getManager(QQManagerFactory.APOLLO_MANAGER)).a();
      if (paramIntent != null)
      {
        paramFromServiceMsg.a(paramIntent);
        return;
      }
      label225:
      paramIntent = null;
    }
  }
  
  private void J(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString + "_apollo_store_stability_", 2, new Object[] { "[handleReportApolloStoreStabilityResp] ret=", Long.valueOf(paramIntent.ret.get()) });
        }
        if (paramIntent.ret.get() != 0L) {
          QLog.e(jdField_a_of_type_JavaLangString + "_apollo_store_stability_", 1, new Object[] { "[handleReportApolloStoreStabilityResp] failed ret:", Long.valueOf(paramIntent.ret.get()) });
        }
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString + "_apollo_store_stability_", 1, "[handleReportApolloStoreStabilityResp] exception=", paramIntent);
        return;
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString + "_apollo_store_stability_", 1, "[handleReportApolloStoreStabilityResp] failed");
  }
  
  private void K(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGetArkAds] ret=", Long.valueOf(paramIntent.ret.get()) });
      }
      if (paramIntent.ret.get() == 0L)
      {
        paramIntent = new JSONObject(paramIntent.rspdata.get());
        if (paramIntent != null)
        {
          paramFromServiceMsg = paramIntent.optJSONObject("12818");
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.optInt("ret", 1) == 0))
          {
            paramIntent = (bcvc)this.app.getManager(QQManagerFactory.GAMECENTER_MANAGER);
            paramFromServiceMsg = paramFromServiceMsg.optJSONObject("data");
            if (paramFromServiceMsg != null)
            {
              paramFromServiceMsg = paramFromServiceMsg.optJSONObject("rsp");
              if (paramFromServiceMsg != null) {
                paramIntent.a().a(paramFromServiceMsg);
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGetArkAds] err:" + paramIntent.getMessage());
    }
  }
  
  private void L(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleReportPadFaceShown] ret=", Long.valueOf(paramIntent.ret.get()) });
      }
      if (paramIntent.ret.get() == 0L)
      {
        paramIntent = new JSONObject(paramIntent.rspdata.get());
        if (paramIntent != null)
        {
          paramIntent = paramIntent.optJSONObject("12827");
          if (paramIntent != null)
          {
            int i = paramIntent.optInt("ret", 1);
            if (i != 0) {
              QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleReportPadFaceShown] ret:" + i);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleReportPadFaceShown] err:" + paramIntent.getMessage());
    }
  }
  
  private void a(Intent paramIntent, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    oidb_0x5eb.RspBody localRspBody = new oidb_0x5eb.RspBody();
    localRspBody.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
    int n = localRspBody.rpt_msg_uin_data.size();
    HashSet localHashSet = new HashSet(n);
    ArrayList localArrayList1 = new ArrayList(n);
    ArrayList localArrayList2 = new ArrayList();
    anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    VasFaceManager localVasFaceManager = ((bhou)this.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
    int i = 0;
    int j = 0;
    int m = 0;
    oidb_0x5eb.UdcUinData localUdcUinData;
    boolean bool;
    String str;
    int k;
    if (m < n)
    {
      localUdcUinData = (oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get(m);
      bool = false;
      str = String.valueOf(localUdcUinData.uint64_uin.get());
      ExtensionInfo localExtensionInfo = localanvk.a(str);
      paramOIDBSSOPkg = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        paramOIDBSSOPkg = new ExtensionInfo();
        paramOIDBSSOPkg.uin = str;
        bool = true;
      }
      k = i;
      if (!localUdcUinData.uint32_vas_font_id.has()) {
        break label793;
      }
      long l = localUdcUinData.uint32_vas_font_id.get();
      if (str.equals(this.app.getCurrentAccountUin()))
      {
        k = (int)gb.a(l);
        gm.c = k;
        i = k;
        if (QLog.isColorLevel())
        {
          QLog.d("VasShieldFont", 2, "handleGetStrangerVasInfo: " + gm.c);
          i = k;
        }
      }
      if (gb.a(l) == paramOIDBSSOPkg.uVipFont)
      {
        k = i;
        if (gb.b(l) == paramOIDBSSOPkg.vipFontType) {
          break label793;
        }
      }
      paramOIDBSSOPkg.uVipFont = gb.a(l);
      paramOIDBSSOPkg.vipFontType = gb.b(l);
      paramOIDBSSOPkg.lastUpdateTime = NetConnInfoCenter.getServerTime();
      bool = true;
    }
    for (;;)
    {
      try
      {
        if (localUdcUinData.uint32_bubble_id.has())
        {
          k = localUdcUinData.uint32_bubble_id.get();
          ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(k);
        }
        if ((!localUdcUinData.uint32_vas_diy_font_timestamp.has()) || (!str.equals(this.app.getCurrentAccountUin()))) {
          break label790;
        }
        j = localUdcUinData.uint32_vas_diy_font_timestamp.get();
        bool = a(localUdcUinData, a(localUdcUinData, a(localArrayList2, localUdcUinData, bool, str, paramOIDBSSOPkg), str, paramOIDBSSOPkg), paramOIDBSSOPkg);
        a(localUdcUinData);
        c(localUdcUinData, str);
        b(localUdcUinData, str);
        c(localUdcUinData);
        a(localUdcUinData, str);
        b(localUdcUinData);
        if ((localUdcUinData.uint64_game_appid.has()) && (localUdcUinData.uint64_game_last_login_time.has()) && (localUdcUinData.uint32_plate_of_king_dan.has()) && (localUdcUinData.uint32_plate_of_king_dan_display_switch.has())) {
          a(str, localUdcUinData.uint64_game_appid.get(), localUdcUinData.uint64_game_last_login_time.get(), localUdcUinData.uint32_plate_of_king_dan.get(), localUdcUinData.uint32_plate_of_king_dan_display_switch.get());
        }
        if (paramIntent.getBooleanExtra("req_roam_type", false)) {
          a(str, localUdcUinData);
        }
        if (paramIntent.getBooleanExtra("req_music_type", false)) {
          notifyUI(36, true, Integer.valueOf(localUdcUinData.uint32_rsp_listen_together_player_id.get()));
        }
        if (bool)
        {
          paramOIDBSSOPkg.timestamp = System.currentTimeMillis();
          localHashSet.add(str);
          localArrayList1.add(paramOIDBSSOPkg);
        }
        m += 1;
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "" + localException.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasFont", 2, "0x5eb self has diy timestamp fontid = " + i + " timestamp = " + j);
      }
      paramIntent = localanvk.a(this.app.getCurrentAccountUin());
      gb.a(this.app, this.app.getCurrentAccountUin(), paramIntent, i, j);
      localanvk.b(localArrayList1);
      localVasFaceManager.b(localArrayList2);
      localVasFaceManager.a(localArrayList1);
      notifyUI(66, true, localHashSet);
      return;
      label790:
      continue;
      label793:
      i = k;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, BusinessObserver paramBusinessObserver, Object paramObject)
  {
    ThreadManager.getSubThreadHandler().post(new VasExtensionHandler.UpdateRunnable(paramBusinessObserver, paramFromServiceMsg.isSuccess(), paramObject));
  }
  
  private void a(String paramString, JSONArray paramJSONArray, List<FeedsItemData> paramList)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int k = paramJSONArray.length();
      int i = 0;
      if (i < k)
      {
        FeedsItemData localFeedsItemData = new FeedsItemData();
        JSONObject localJSONObject1 = paramJSONArray.getJSONObject(i);
        JSONObject localJSONObject2 = localJSONObject1.optJSONObject("feed_info");
        localFeedsItemData.msgId = paramString;
        localFeedsItemData.authorName = localJSONObject2.optString("anchor_name");
        localFeedsItemData.authorIcon = localJSONObject2.optString("anchor_icon");
        localFeedsItemData.type = localJSONObject2.optInt("feed_type");
        localFeedsItemData.feedId = localJSONObject2.optString("feed_id");
        localFeedsItemData.coverImgUrl = localJSONObject2.optString("cover_url");
        localFeedsItemData.commentNum = localJSONObject2.optInt("comment_num");
        localFeedsItemData.title = localJSONObject2.optString("title");
        localFeedsItemData.jumpUrl = localJSONObject2.optString("jump_url");
        localFeedsItemData.algorithmId = localJSONObject2.optString("algorithm_id");
        localFeedsItemData.label = localJSONObject2.optString("label");
        localFeedsItemData.rcmdReason = localJSONObject2.optString("rcmd_reason");
        localFeedsItemData.subTitle = localJSONObject2.optString("sub_title");
        localFeedsItemData.operateText = localJSONObject2.optString("operate_text");
        localFeedsItemData.groupId = localJSONObject2.optString("group_id");
        if (localFeedsItemData.type == 1)
        {
          localFeedsItemData.videoUrl = localJSONObject2.optString("live_stream_url");
          localFeedsItemData.videoViewers = localJSONObject2.optInt("live_online_num");
          localFeedsItemData.videoSrcName = localJSONObject2.optString("video_source");
          localFeedsItemData.videoSrcImg = localJSONObject2.optString("video_source_icon");
        }
        for (;;)
        {
          localFeedsItemData.viewersNum = localJSONObject2.optInt("vv");
          localJSONObject1 = localJSONObject1.optJSONObject("game_info");
          localFeedsItemData.gameInfo = new FeedsItemData.GameInfo();
          localFeedsItemData.gameInfo.gameName = localJSONObject1.optString("name");
          localFeedsItemData.gameInfo.gameIcon = localJSONObject1.optString("icon");
          localFeedsItemData.gameInfo.gamePkgName = localJSONObject1.optString("pkg_name");
          localFeedsItemData.gameInfo.gamePkgSize = localJSONObject1.optInt("pkg_size");
          localFeedsItemData.gameInfo.gameStatus = localJSONObject1.optInt("status");
          localFeedsItemData.gameInfo.gameApkUrl = localJSONObject1.optString("apk_url");
          localFeedsItemData.gameInfo.gameAppId = localJSONObject1.optString("appid");
          localFeedsItemData.gameInfo.gameVersionCode = localJSONObject1.optString("version_code");
          localFeedsItemData.gameInfo.gameTicket = localJSONObject1.optString("tickets");
          paramList.add(localFeedsItemData);
          i += 1;
          break;
          if (localFeedsItemData.type == 2)
          {
            localFeedsItemData.videoUrl = localJSONObject2.optString("video_url");
            localFeedsItemData.videoDuration = localJSONObject2.optInt("video_duration");
            localFeedsItemData.videoSrcType = localJSONObject2.optInt("video_source_type");
            localFeedsItemData.videoVid = localJSONObject2.optString("video_vid");
          }
          else if (localFeedsItemData.type == 7)
          {
            JSONArray localJSONArray = localJSONObject2.optJSONArray("gift_list");
            localFeedsItemData.giftList = new ArrayList();
            if (localJSONArray != null)
            {
              int j = 0;
              while (j < localJSONArray.length())
              {
                FeedsItemData.Gift localGift = new FeedsItemData.Gift();
                localGift.picture = localJSONArray.getJSONObject(j).optString("picture");
                localGift.text = localJSONArray.getJSONObject(j).optString("text");
                localFeedsItemData.giftList.add(localGift);
                j += 1;
              }
            }
          }
        }
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress rootData: " + paramJSONObject);
    }
    amme localamme = (amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    ArrayList localArrayList = new ArrayList();
    JSONArray localJSONArray = paramJSONObject.getJSONArray("data");
    HashMap localHashMap = new HashMap();
    int i;
    long l1;
    Object localObject2;
    if (localJSONArray != null)
    {
      i = 0;
      if (i < localJSONArray.length())
      {
        localObject1 = (JSONObject)localJSONArray.opt(i);
        l1 = ((JSONObject)localObject1).optLong("uin");
        ApolloBaseInfo localApolloBaseInfo = localamme.b(l1 + "");
        long l2 = ((JSONObject)localObject1).optLong("ts");
        localObject2 = ((JSONObject)localObject1).toString();
        localObject1 = localApolloBaseInfo.getApolloDress();
        localApolloBaseInfo.setApolloDress(l2, (String)localObject2);
        localObject2 = localApolloBaseInfo.getApolloDress();
        if (localObject1 == null)
        {
          localObject1 = "";
          label189:
          if (localObject2 != null) {
            break label332;
          }
        }
        label332:
        for (localObject2 = "";; localObject2 = ((ApolloDress)localObject2).a())
        {
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.equals((CharSequence)localObject1, (CharSequence)localObject2)))
          {
            localApolloBaseInfo.apolloHistoryDress = ((String)localObject1);
            localApolloBaseInfo.appearAction = null;
            ancd.a(String.valueOf(l1));
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "save history uin:" + l1 + ", dress: " + (String)localObject1 + ", new dres: " + (String)localObject2);
            }
          }
          localHashMap.put(localApolloBaseInfo.uin, localApolloBaseInfo);
          localArrayList.add(localApolloBaseInfo);
          i += 1;
          break;
          localObject1 = ((ApolloDress)localObject1).a();
          break label189;
        }
      }
    }
    Object localObject1 = paramJSONObject.optJSONObject("device");
    if (localObject1 != null)
    {
      ApolloUtil.a(((JSONObject)localObject1).optInt("level"));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress MSAA_level deviceJson : " + localObject1);
      }
    }
    localObject1 = paramJSONObject.optJSONArray("data2");
    if (localObject1 != null)
    {
      i = 0;
      if (i < ((JSONArray)localObject1).length())
      {
        localObject2 = (JSONObject)((JSONArray)localObject1).opt(i);
        l1 = ((JSONObject)localObject2).optLong("uin");
        paramJSONObject = (ApolloBaseInfo)localHashMap.get(String.valueOf(l1));
        if (paramJSONObject != null) {
          break label726;
        }
        paramJSONObject = localamme.b(l1 + "");
      }
    }
    label726:
    for (int j = 1;; j = 0)
    {
      paramJSONObject.setApolloDress3D(this.app, (JSONObject)localObject2);
      if (j != 0) {
        localArrayList.add(paramJSONObject);
      }
      paramJSONObject = paramJSONObject.getApolloDress3D();
      if ((paramJSONObject != null) && (!TextUtils.isEmpty(paramJSONObject.jdField_a_of_type_JavaLangString))) {
        anex.a(this.app, paramJSONObject.jdField_a_of_type_JavaLangString, null);
      }
      i += 1;
      break;
      if (localArrayList.size() > 0)
      {
        paramJSONObject = localArrayList.iterator();
        while (paramJSONObject.hasNext())
        {
          localObject1 = (ApolloBaseInfo)paramJSONObject.next();
          if (localObject1 != null) {
            if (((ApolloBaseInfo)localObject1).apolloServerTS != 0L)
            {
              if (((ApolloBaseInfo)localObject1).apolloLocalTS != ((ApolloBaseInfo)localObject1).apolloServerTS) {
                ((ApolloBaseInfo)localObject1).apolloLocalTS = ((ApolloBaseInfo)localObject1).apolloServerTS;
              }
            }
            else {
              ((ApolloBaseInfo)localObject1).apolloServerTS = ((ApolloBaseInfo)localObject1).apolloLocalTS;
            }
          }
        }
        localamme.b(localArrayList);
        ((amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a(localArrayList);
      }
      for (;;)
      {
        return;
        paramJSONObject = localHashMap.entrySet().iterator();
        while (paramJSONObject.hasNext())
        {
          localObject1 = (Map.Entry)paramJSONObject.next();
          a((String)((Map.Entry)localObject1).getKey(), (ApolloBaseInfo)((Map.Entry)localObject1).getValue());
        }
      }
    }
  }
  
  private void a(JSONObject paramJSONObject, amme paramamme, ApolloBaseInfo paramApolloBaseInfo, boolean paramBoolean)
  {
    int i;
    if (paramJSONObject.has("CurrencyInfo"))
    {
      i = paramJSONObject.getJSONObject("CurrencyInfo").optInt("balance");
      amna localamna = paramamme.a();
      if (localamna != null)
      {
        localamna.jdField_a_of_type_Int = i;
        if (localamna.jdField_a_of_type_Boolean) {
          localamna.b();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "balance:", Integer.valueOf(i) });
      }
    }
    if (paramJSONObject.has("zancount")) {
      notifyUI(6, true, Integer.valueOf(paramJSONObject.optInt("zancount")));
    }
    if (paramJSONObject.has("gameCoinInfo"))
    {
      i = paramJSONObject.getJSONObject("gameCoinInfo").optInt("balance", 0);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGetUserApolloInfo] game coin count=", Integer.valueOf(i) });
      }
      ApolloGameUtil.a(this.app, i);
    }
    if (paramBoolean) {
      paramamme.a(paramApolloBaseInfo);
    }
  }
  
  private void a(JSONObject paramJSONObject, ankc paramankc, EntityManager paramEntityManager)
  {
    paramJSONObject = paramJSONObject.optJSONArray("gScoreList");
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      int k = paramJSONObject.length();
      int i = 0;
      while (i < k)
      {
        JSONObject localJSONObject1 = paramJSONObject.getJSONObject(i);
        if (localJSONObject1 != null)
        {
          JSONArray localJSONArray = localJSONObject1.optJSONArray("gameList");
          if (localJSONArray != null)
          {
            int m = localJSONArray.length();
            ArrayList localArrayList = new ArrayList();
            int j = 0;
            while (j < m)
            {
              ApolloGameScoreData localApolloGameScoreData = new ApolloGameScoreData();
              localApolloGameScoreData.mUin = localJSONObject1.optString("uin");
              JSONObject localJSONObject2 = localJSONArray.getJSONObject(j);
              localApolloGameScoreData.mGameId = localJSONObject2.optInt("gameId");
              localApolloGameScoreData.mScore = localJSONObject2.optInt("score");
              localArrayList.add(localApolloGameScoreData);
              j += 1;
            }
            paramankc.a(paramEntityManager, localArrayList);
          }
        }
        i += 1;
      }
    }
  }
  
  private void a(JSONObject paramJSONObject, JSONArray paramJSONArray, ankc paramankc, EntityManager paramEntityManager)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        Object localObject = paramJSONArray.getJSONObject(i);
        if (localObject != null)
        {
          ApolloGameRankData localApolloGameRankData1 = new ApolloGameRankData();
          localApolloGameRankData1.mGameId = ((JSONObject)localObject).optInt("gameId");
          localApolloGameRankData1.mRank = ((JSONObject)localObject).optInt("chgFlag");
          localApolloGameRankData1.mFriendUin = paramJSONObject.optString("sessionId");
          localApolloGameRankData1.mValidTime = (System.currentTimeMillis() + 604800000L);
          localArrayList.add(localApolloGameRankData1);
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "updateRankInfo handleGameRank data " + localApolloGameRankData1);
          }
          localObject = paramankc.h(2147483647);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              ApolloGameRankData localApolloGameRankData2 = (ApolloGameRankData)((Iterator)localObject).next();
              if ((localApolloGameRankData2 != null) && (localApolloGameRankData2.mFriendUin.equals(localApolloGameRankData1.mFriendUin)) && (localApolloGameRankData2.mRank == 2) && (localApolloGameRankData1.mRank == 1)) {
                VipUtils.a(this.mApp, "cmshow", "Apollo", "beyond_notice_disappear", 3, 0, new String[] { String.valueOf(localApolloGameRankData2.mGameId) });
              }
            }
          }
        }
        i += 1;
      }
      paramankc.b(paramEntityManager, localArrayList);
    }
  }
  
  private void a(oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    boolean bool = true;
    if (paramUdcUinData.uint32_c2c_aio_shortcut_switch.has()) {
      if (paramUdcUinData.uint32_c2c_aio_shortcut_switch.get() != 1) {
        break label32;
      }
    }
    for (;;)
    {
      aqlr.a(this.app, bool);
      return;
      label32:
      bool = false;
    }
  }
  
  private void a(oidb_0x5eb.UdcUinData paramUdcUinData, String paramString)
  {
    if (paramUdcUinData.uint32_rsp_qq_level_icon_type.has())
    {
      int i = paramUdcUinData.uint32_rsp_qq_level_icon_type.get();
      paramUdcUinData = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramString = paramUdcUinData.b(paramString + "");
      if ((paramString != null) && (paramString.mQQLevelType != i))
      {
        paramString.mQQLevelType = i;
        paramUdcUinData.a(paramString);
        this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramString);
      }
    }
  }
  
  private void a(Long[] paramArrayOfLong, String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      if (TextUtils.isEmpty(paramString)) {}
      JSONArray localJSONArray;
      for (paramString = "android";; paramString = "android." + paramString)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("from", paramString);
        paramString = new JSONArray();
        localJSONArray = new JSONArray();
        int j = paramArrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          long l = paramArrayOfLong[i].longValue();
          paramString.put(l);
          localJSONArray.put(l);
          i += 1;
        }
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("producer", Build.PRODUCT);
      localJSONObject.put("model", Build.MODEL);
      localJSONObject.put("cpuCount", DeviceInfoUtil.getCpuNumber());
      localJSONObject.put("cpuFrequency", DeviceInfoUtil.getCpuFrequency());
      localJSONObject.put("systemTotalMemory", DeviceInfoUtil.getSystemTotalMemory());
      ((JSONObject)localObject).put("deviceInfo", localJSONObject);
      ((JSONObject)localObject).put("uins", paramString);
      ((JSONObject)localObject).put("3dUins", localJSONArray);
      ((JSONObject)localObject).put("detail", 1);
      ((JSONObject)localObject).put("cmd", "apollo_core.get_avatar");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString = new NewIntent(this.app.getApp(), bhox.class);
      paramString.putExtra("cmd", "apollo_core.get_avatar");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString.putExtra("uinArr", paramArrayOfLong);
      this.app.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        this.jdField_a_of_type_JavaUtilVector.remove(paramArrayOfLong);
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, paramString.getMessage());
    }
  }
  
  private boolean a(amme paramamme1, HashMap<Integer, Bundle> paramHashMap, JSONArray paramJSONArray, amme paramamme2, ankc paramankc)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramankc == null) {
      return bool2;
    }
    paramankc.a(paramJSONArray);
    List localList = paramankc.a(1);
    paramJSONArray = paramankc.b();
    int i;
    if (localList != null)
    {
      j = 0;
      i = 0;
      while (j < localList.size())
      {
        ApolloActionData localApolloActionData = (ApolloActionData)localList.get(j);
        if (paramHashMap.containsKey(Integer.valueOf(localApolloActionData.actionId)))
        {
          Bundle localBundle = (Bundle)paramHashMap.get(Integer.valueOf(localApolloActionData.actionId));
          if (paramamme2 != null) {
            paramamme2.a(localApolloActionData, localBundle);
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo update actlist id: " + localApolloActionData.actionId);
          }
          i = 1;
        }
        j += 1;
      }
      if ((this.mApp != null) && (paramankc != null) && (i != 0)) {
        paramankc.b(localList);
      }
    }
    for (int j = i;; j = 0)
    {
      if (paramJSONArray != null)
      {
        k = 0;
        i = 0;
        while (k < paramJSONArray.size())
        {
          paramamme2 = (ApolloActionData)paramJSONArray.get(k);
          if (paramHashMap.containsKey(Integer.valueOf(paramamme2.actionId)))
          {
            paramamme2.isShow = 1;
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGetUserApolloInfo] set user action ", Integer.valueOf(paramamme2.actionId), " visible" });
            }
            i = 1;
          }
          k += 1;
        }
        k = i;
        if (this.mApp != null)
        {
          k = i;
          if (paramankc != null)
          {
            k = i;
            if (i != 0) {
              paramankc.b(paramJSONArray);
            }
          }
        }
      }
      for (int k = i;; k = 0)
      {
        if ((k != 0) || (j != 0)) {
          bool1 = true;
        }
        for (;;)
        {
          paramHashMap = paramHashMap.keySet().iterator();
          for (;;)
          {
            bool2 = bool1;
            if (!paramHashMap.hasNext()) {
              break;
            }
            if (paramankc.a(((Integer)paramHashMap.next()).intValue()) == null) {
              paramamme1.d();
            }
          }
          notifyUI(9, false, null);
        }
      }
    }
  }
  
  private boolean a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("__cmd_seq__");
    if ((TextUtils.isEmpty(str)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))) {
      return false;
    }
    BusinessObserver localBusinessObserver = (BusinessObserver)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    if (localBusinessObserver == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilHashMap.remove(str);
    paramIntent = (Class)paramIntent.getSerializableExtra("__rspClass__");
    if (paramIntent == null)
    {
      a(paramFromServiceMsg, localBusinessObserver, paramArrayOfByte);
      return true;
    }
    try
    {
      paramIntent = (MessageMicro)paramIntent.newInstance();
      paramIntent.mergeFrom(paramArrayOfByte);
      a(paramFromServiceMsg, localBusinessObserver, paramIntent);
      return true;
    }
    catch (Exception paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "response is error", paramIntent);
    }
    return false;
  }
  
  private boolean a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, String paramString)
  {
    paramString = anbc.a.a(paramString);
    if (paramString != null)
    {
      anbe localanbe = new anbe();
      localanbe.jdField_a_of_type_AndroidContentIntent = paramIntent;
      localanbe.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
      localanbe.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      localanbe.jdField_a_of_type_ComTencentMobileqqVasVasExtensionHandler = this;
      localanbe.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.app;
      paramString.a(localanbe);
      return true;
    }
    return false;
  }
  
  private boolean a(PBUInt32Field paramPBUInt32Field)
  {
    return (paramPBUInt32Field.has()) && (paramPBUInt32Field.get() == 1);
  }
  
  private boolean a(String paramString, WebSSOAgent.UniSsoServerRsp paramUniSsoServerRsp, int paramInt)
  {
    paramUniSsoServerRsp = new JSONObject(paramUniSsoServerRsp.rspdata.get()).getJSONObject("data");
    amme localamme;
    boolean bool2;
    int i;
    if ((paramUniSsoServerRsp != null) && (this.app != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo apollo data: " + paramUniSsoServerRsp.toString());
      }
      localamme = (amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER);
      if (localamme != null)
      {
        paramString = localamme.b(paramString);
        bool2 = false;
        bool1 = bool2;
        if (paramUniSsoServerRsp.has("vip"))
        {
          i = paramUniSsoServerRsp.getInt("vip");
          bool1 = bool2;
          if (i != paramString.apolloVipFlag)
          {
            paramString.apolloVipFlag = i;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (paramUniSsoServerRsp.has("viplevel"))
        {
          i = paramUniSsoServerRsp.getInt("viplevel");
          bool2 = bool1;
          if (i != paramString.apolloVipLevel)
          {
            paramString.apolloVipLevel = i;
            bool2 = true;
          }
        }
        if (!paramUniSsoServerRsp.has("userstatus")) {
          break label613;
        }
        i = paramUniSsoServerRsp.getInt("userstatus");
        if (i == paramString.apolloStatus) {
          break label613;
        }
        paramString.apolloStatus = i;
      }
    }
    label607:
    label613:
    for (boolean bool1 = true;; bool1 = bool2)
    {
      if (paramUniSsoServerRsp.has("actlist"))
      {
        Object localObject1 = paramUniSsoServerRsp.getJSONArray("actlist");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGetUserApolloInfo] user action list=", localObject1 });
        }
        HashMap localHashMap = new HashMap(((JSONArray)localObject1).length());
        JSONArray localJSONArray = new JSONArray();
        i = 0;
        Object localObject2;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = new Bundle();
          JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
          int j = localJSONObject.optInt("id");
          ((Bundle)localObject2).putLong("beginTs", localJSONObject.optLong("beginTs"));
          ((Bundle)localObject2).putLong("endts", localJSONObject.optLong("endts"));
          int k = localJSONObject.optInt("way");
          ((Bundle)localObject2).putInt("way", k);
          ((Bundle)localObject2).putInt("slaveActId", localJSONObject.optInt("slaveActId"));
          if (j != 0) {
            localHashMap.put(Integer.valueOf(j), localObject2);
          }
          j = 0;
          if (k == 6) {
            j = 6;
          }
          localJSONObject.put("type", j);
          localJSONArray.put(localJSONObject);
          i += 1;
        }
        if (localHashMap.size() > 0)
        {
          if (this.mApp == null) {
            return true;
          }
          localObject1 = (amme)this.mApp.getManager(QQManagerFactory.APOLLO_MANAGER);
          if (localObject1 != null) {
            ((amme)localObject1).jdField_a_of_type_JavaUtilHashMap = localHashMap;
          }
          localObject2 = (ankc)this.mApp.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
          if (localObject2 == null) {
            return true;
          }
          a(localamme, localHashMap, localJSONArray, (amme)localObject1, (ankc)localObject2);
        }
        if (1073741824 != (0x40000000 & paramInt)) {
          break label607;
        }
      }
      for (bool2 = a(paramUniSsoServerRsp);; bool2 = false)
      {
        if (bool2)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "[handleGetUserApolloInfo] send NOTIFY_TYPE_REFRESH_ACTION");
          notifyUI(9, true, null);
        }
        a(paramUniSsoServerRsp, localamme, paramString, bool1);
        return false;
        notifyUI(9, false, null);
        break;
      }
    }
  }
  
  private boolean a(ArrayList<String> paramArrayList, oidb_0x5eb.UdcUinData paramUdcUinData, boolean paramBoolean, String paramString, ExtensionInfo paramExtensionInfo)
  {
    boolean bool = paramBoolean;
    int i;
    if (paramUdcUinData.uint32_vas_magicfont_flag.has())
    {
      i = paramUdcUinData.uint32_vas_magicfont_flag.get();
      bool = paramBoolean;
      if (i != paramExtensionInfo.magicFont)
      {
        paramExtensionInfo.magicFont = i;
        paramExtensionInfo.lastUpdateTime = NetConnInfoCenter.getServerTime();
        bool = true;
      }
    }
    paramBoolean = bool;
    if (paramUdcUinData.uint32_vas_colorring_id.has())
    {
      i = paramUdcUinData.uint32_vas_colorring_id.get();
      paramBoolean = bool;
      if (paramExtensionInfo.colorRingId != i)
      {
        paramExtensionInfo.colorRingId = i;
        paramBoolean = true;
      }
    }
    if (paramUdcUinData.uint32_vas_praise_id.has())
    {
      i = paramUdcUinData.uint32_vas_praise_id.get();
      if ((i > 0) && (String.valueOf(paramString).equals(this.app.getCurrentAccountUin()))) {
        PraiseManager.a(this.app, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetStrangerVasInfo uin= " + paramString + "praise id = " + i);
      }
    }
    if (paramUdcUinData.uint32_vas_voicebubble_id.has())
    {
      i = paramUdcUinData.uint32_vas_voicebubble_id.get();
      if ((i > 0) && (String.valueOf(paramString).equals(this.app.getCurrentAccountUin())))
      {
        ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b(i);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetStrangerVasInfo uin= " + paramString + "voice print bubble id = " + i);
        }
      }
    }
    bool = paramBoolean;
    if (paramUdcUinData.uint32_vas_face_id.has())
    {
      i = paramExtensionInfo.faceId;
      int j = paramUdcUinData.uint32_vas_face_id.get();
      if ((paramExtensionInfo.faceIdUpdateTime == 0L) || (i != j))
      {
        paramExtensionInfo.faceId = j;
        paramExtensionInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
        paramBoolean = true;
      }
      if (i != j) {
        paramArrayList.add(paramString);
      }
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "uint32_vas_face_id uin: " + paramString + " oldId: " + i + " newId: " + j);
        bool = paramBoolean;
      }
    }
    if (paramUdcUinData.uint32_vas_pendant_diy_id.has())
    {
      i = paramUdcUinData.uint32_vas_pendant_diy_id.get();
      if (paramExtensionInfo.pendantDiyId != i)
      {
        paramExtensionInfo.pendantDiyId = i;
        paramExtensionInfo.lastUpdateTime = NetConnInfoCenter.getServerTime();
        if (paramString.equals(this.app.getCurrentAccountUin())) {
          ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b(i, false);
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetStrangerVasInfo, uin=" + paramString + ", pendant=" + paramExtensionInfo.pendantId + ",font=" + paramExtensionInfo.uVipFont + ", fontType = " + paramExtensionInfo.vipFontType + ", magicFont = " + paramExtensionInfo.magicFont + ", colorRing = " + paramExtensionInfo.colorRingId + ", pendantDiyId = " + paramExtensionInfo.pendantDiyId);
        }
        return true;
      }
    }
    return bool;
  }
  
  private boolean a(JSONArray paramJSONArray, boolean paramBoolean, int paramInt, long paramLong)
  {
    boolean bool = paramBoolean;
    int j;
    int i;
    if (paramJSONArray != null)
    {
      j = paramJSONArray.length();
      i = 0;
    }
    for (;;)
    {
      bool = paramBoolean;
      if (i < j)
      {
        int k = paramJSONArray.getJSONObject(i).getInt("id");
        long l = paramJSONArray.getJSONObject(i).getLong("updateTs");
        if (k != paramInt) {
          break label87;
        }
        bool = paramBoolean;
        if (paramLong != l)
        {
          QLog.i(jdField_a_of_type_JavaLangString, 1, "handleApolloStandAction version update res.");
          bool = true;
        }
      }
      return bool;
      label87:
      i += 1;
    }
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "[handleGetUserApolloInfo] rsp for recommend action");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject2;
    int i;
    int k;
    ApolloRecommendAction localApolloRecommendAction;
    if (paramJSONObject.has("hotAct"))
    {
      localObject2 = paramJSONObject.getJSONArray("hotAct");
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "[handleGetUserApolloInfo] hotAct=", localObject2 });
      j = ((JSONArray)localObject2).length();
      i = 0;
      while (i < j)
      {
        k = ((JSONArray)localObject2).optInt(i);
        localApolloRecommendAction = new ApolloRecommendAction();
        localApolloRecommendAction.id = k;
        localApolloRecommendAction.type = 1;
        localArrayList.add(localApolloRecommendAction);
        ((List)localObject1).add(localApolloRecommendAction);
        i += 1;
      }
    }
    int m;
    if (paramJSONObject.has("ascendAct"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("ascendAct");
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "[handleGetUserApolloInfo] ascendAct=", paramJSONObject });
      k = paramJSONObject.length();
      i = 0;
      if (i < k)
      {
        m = paramJSONObject.optInt(i);
        localObject2 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (((ApolloRecommendAction)((Iterator)localObject2).next()).id != m);
      }
    }
    for (int j = 1;; j = 0)
    {
      if (j == 0)
      {
        localObject2 = new ApolloRecommendAction();
        ((ApolloRecommendAction)localObject2).id = m;
        ((ApolloRecommendAction)localObject2).type = 2;
        localArrayList.add(localObject2);
      }
      i += 1;
      break;
      if (this.mApp != null)
      {
        paramJSONObject = (ankc)this.mApp.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
        if (paramJSONObject != null)
        {
          localObject1 = paramJSONObject.g();
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "[handleGetUserApolloInfo] recommendActionList=", localArrayList, ", local=", localObject1 });
          j = ((List)localObject1).size();
          if (j != localArrayList.size()) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "[handleGetUserApolloInfo] update recommendActionList=", localArrayList });
          paramJSONObject.e();
          paramJSONObject.g(localArrayList);
          return true;
          i = 0;
          for (;;)
          {
            if (i >= j) {
              break label477;
            }
            localObject2 = (ApolloRecommendAction)((List)localObject1).get(i);
            localApolloRecommendAction = (ApolloRecommendAction)localArrayList.get(i);
            if ((((ApolloRecommendAction)localObject2).id != localApolloRecommendAction.id) || (((ApolloRecommendAction)localObject2).type != localApolloRecommendAction.type))
            {
              i = 1;
              break;
            }
            i += 1;
          }
        }
        return false;
        label477:
        i = 0;
      }
    }
  }
  
  private boolean a(oidb_0x5eb.UdcUinData paramUdcUinData, boolean paramBoolean, ExtensionInfo paramExtensionInfo)
  {
    boolean bool = paramBoolean;
    if (paramUdcUinData.uint64_face_addon_id.has())
    {
      long l = paramUdcUinData.uint64_face_addon_id.get();
      bool = paramBoolean;
      if (paramExtensionInfo.pendantId != l)
      {
        paramExtensionInfo.pendantId = l;
        paramExtensionInfo.lastUpdateTime = NetConnInfoCenter.getServerTime();
        bool = true;
      }
    }
    return bool;
  }
  
  private boolean a(oidb_0x5eb.UdcUinData paramUdcUinData, boolean paramBoolean, String paramString, ExtensionInfo paramExtensionInfo)
  {
    boolean bool = paramBoolean;
    if (paramUdcUinData.uint32_req_font_effect_id.has())
    {
      int i = paramUdcUinData.uint32_req_font_effect_id.get();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetStrangerVasInfo uin = " + paramString + " fontEffect = " + i + " extInfo.fontEffect = " + paramExtensionInfo.fontEffect);
      }
      if (i != paramExtensionInfo.fontEffect)
      {
        paramExtensionInfo.fontEffect = i;
        paramExtensionInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
        paramBoolean = true;
      }
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetStrangerVasInfo uin = " + paramString + " extInfo.fontEffect = " + paramExtensionInfo.fontEffect + " extInfo.fontEffectLastUpdateTime = " + paramExtensionInfo.fontEffectLastUpdateTime);
        bool = paramBoolean;
      }
    }
    return bool;
  }
  
  private boolean a(Object[] paramArrayOfObject, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("feed_list");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("layer_condition");
    ArrayList localArrayList = new ArrayList();
    FeedsItemData.TopCardInfo localTopCardInfo = new FeedsItemData.TopCardInfo();
    paramJSONObject = paramJSONObject.optJSONObject("top_card");
    if (paramJSONObject != null)
    {
      FeedsItemData.LabelInfo localLabelInfo;
      if (paramJSONObject.optInt("top_card_display_flag", 1) == 0)
      {
        bool = false;
        localTopCardInfo.showTopCard = bool;
        localTopCardInfo.msgId = paramString1;
        localObject1 = paramJSONObject.optJSONObject("game_info");
        localTopCardInfo.gameInfo = new FeedsItemData.GameInfo();
        if (localObject1 != null)
        {
          localTopCardInfo.gameInfo.gameName = ((JSONObject)localObject1).optString("name");
          localTopCardInfo.gameInfo.gameIcon = ((JSONObject)localObject1).optString("icon");
          localTopCardInfo.gameInfo.gamePkgName = ((JSONObject)localObject1).optString("pkg_name");
          localTopCardInfo.gameInfo.gamePkgSize = ((JSONObject)localObject1).optInt("pkg_size");
          localTopCardInfo.gameInfo.gameStatus = ((JSONObject)localObject1).optInt("status");
          localTopCardInfo.gameInfo.gameApkUrl = ((JSONObject)localObject1).optString("apk_url");
          localTopCardInfo.gameInfo.gameAppId = ((JSONObject)localObject1).optString("appid");
          localTopCardInfo.gameInfo.gameVersionCode = ((JSONObject)localObject1).optString("version_code");
          localTopCardInfo.gameInfo.gameTicket = ((JSONObject)localObject1).optString("tickets");
        }
        localTopCardInfo.actionDesc = paramJSONObject.optString("game_info_text");
        localTopCardInfo.prioritiesIconFlag = paramJSONObject.optInt("priorities_icon_flag");
        localObject1 = paramJSONObject.optJSONArray("entry_list");
        localLabelInfo = new FeedsItemData.LabelInfo();
        localTopCardInfo.labelInfos = new ArrayList();
        if (paramJSONObject.optInt("friend_display_flag", 1) != 0) {
          break label510;
        }
      }
      Object localObject3;
      int i;
      int j;
      label510:
      for (boolean bool = false;; bool = true)
      {
        localLabelInfo.showFriend = bool;
        if (!localLabelInfo.showFriend) {
          break label536;
        }
        localLabelInfo.isFriend = true;
        localLabelInfo.friendType = paramJSONObject.optInt("friend_type");
        localLabelInfo.friendNum = paramJSONObject.optInt("game_friend_total_num");
        localLabelInfo.reportId = "10001";
        localObject2 = paramJSONObject.optJSONArray("friend_list");
        localObject3 = new ArrayList();
        if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
          break label523;
        }
        i = 0;
        j = ((JSONArray)localObject2).length();
        while (i < j)
        {
          JSONObject localJSONObject2 = ((JSONArray)localObject2).getJSONObject(i);
          FeedsItemData.FriendInfo localFriendInfo = new FeedsItemData.FriendInfo();
          localFriendInfo.icon = localJSONObject2.optString("icon");
          localFriendInfo.name = localJSONObject2.optString("name");
          localFriendInfo.uin = localJSONObject2.optString("uin");
          ((List)localObject3).add(localFriendInfo);
          i += 1;
        }
        bool = true;
        break;
      }
      localLabelInfo.friendList = ((List)localObject3);
      label523:
      localTopCardInfo.labelInfos.add(localLabelInfo);
      label536:
      Object localObject2 = paramJSONObject.optJSONObject("friend_red_point");
      localLabelInfo.redInfo = new FeedsItemData.RedInfo();
      if (localObject2 != null)
      {
        localLabelInfo.redInfo.redPointId = ((JSONObject)localObject2).optString("red_point_id");
        localLabelInfo.redInfo.redPointStartTime = ((JSONObject)localObject2).optLong("begin_time");
        localLabelInfo.redInfo.redPointEndTime = ((JSONObject)localObject2).optLong("end_time");
      }
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          localLabelInfo = new FeedsItemData.LabelInfo();
          localLabelInfo.iconUrl = ((JSONObject)localObject2).optString("entry_icon");
          localLabelInfo.name = ((JSONObject)localObject2).optString("entry_name");
          localLabelInfo.jumpUrl = ((JSONObject)localObject2).optString("entry_url");
          localLabelInfo.desc = ((JSONObject)localObject2).optString("entry_text");
          localLabelInfo.reportId = ((JSONObject)localObject2).optString("report_id");
          localLabelInfo.msgId = paramString1;
          localLabelInfo.appId = paramString2;
          localObject3 = ((JSONObject)localObject2).optJSONObject("red_point");
          localLabelInfo.redInfo = new FeedsItemData.RedInfo();
          if (localObject3 != null)
          {
            localLabelInfo.redInfo.redPointId = ((JSONObject)localObject3).optString("red_point_id");
            localLabelInfo.redInfo.redPointStartTime = ((JSONObject)localObject3).optLong("begin_time");
            localLabelInfo.redInfo.redPointEndTime = ((JSONObject)localObject3).optLong("end_time");
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray("entry_icon_list");
          localLabelInfo.icons = new ArrayList();
          if (localObject2 != null)
          {
            j = 0;
            while (j < ((JSONArray)localObject2).length())
            {
              localLabelInfo.icons.add(((JSONArray)localObject2).getJSONObject(j).optString("entry_icon"));
              j += 1;
            }
          }
          localTopCardInfo.labelInfos.add(localLabelInfo);
          i += 1;
        }
      }
      Object localObject1 = paramJSONObject.optJSONObject("banner");
      if (localObject1 != null)
      {
        localTopCardInfo.bannerIconZip = ((JSONObject)localObject1).optString("banner_icon_zip");
        localTopCardInfo.bannerGap = ((JSONObject)localObject1).optInt("banner_gap", 60);
        localTopCardInfo.bannerUrl = ((JSONObject)localObject1).optString("banner_url");
        localTopCardInfo.bannerBeginTime = ((JSONObject)localObject1).optLong("begin_time", 0L);
        localTopCardInfo.bannerEndTime = ((JSONObject)localObject1).optLong("end_time", 0L);
      }
      paramJSONObject = paramJSONObject.optJSONArray("priorities");
      if (paramJSONObject != null)
      {
        localTopCardInfo.priorities = new ArrayList();
        i = 0;
        while (i < paramJSONObject.length())
        {
          localObject1 = paramJSONObject.optString(i, "");
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            localTopCardInfo.priorities.add(localObject1);
          }
          i += 1;
        }
      }
    }
    a(paramString1, localJSONArray, localArrayList);
    paramArrayOfObject[2] = localArrayList;
    paramArrayOfObject[3] = localJSONObject1;
    paramArrayOfObject[4] = localTopCardInfo;
    paramArrayOfObject[5] = paramString1;
    paramArrayOfObject[6] = paramString2;
    notifyUI(29, true, paramArrayOfObject);
    return true;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleExpireInfoResponse");
    }
    long l2;
    try
    {
      if (!paramFromServiceMsg.isSuccess())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleExpireInfoResponse, isSuccess false, error code=" + paramFromServiceMsg.getResultCode());
        return;
      }
      paramFromServiceMsg = new IndividPub.expTips_Rsp();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      long l1 = paramFromServiceMsg.ret.get();
      if (l1 != 0L) {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleExpireInfoResponse, ret=" + l1 + ", error msg=" + paramFromServiceMsg.errmsg.get());
      }
      l2 = paramIntent.getIntExtra("from", 1);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleExpireInfoResponse, from=" + l2);
      }
      if (l2 == 1L)
      {
        if (l1 != 0L) {
          return;
        }
        paramObject = (IndividPub.expTips_Pull_Rsp)paramFromServiceMsg.rspcmd_0x01.get();
        int i = paramObject.expFlag.get();
        paramIntent = paramObject.content.get();
        paramFromServiceMsg = paramObject.clickText.get();
        int j = paramObject.action.get();
        int k = paramObject.itemId.get();
        paramObject = paramObject.url.get();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleExpireInfoResponse, from aio, expireFlag=" + i + ", expireTipContent=" + paramIntent + ", clickText=" + paramFromServiceMsg + ", action=" + j + ", url=" + paramObject);
        }
        if (i == 0) {
          return;
        }
        SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
        localEditor.putInt("renewal_tail_tip_exit", i);
        localEditor.putInt("renewal_tail_action", j);
        localEditor.putString("renewal_tail_tip", paramIntent);
        localEditor.putString("renewal_tail_click_text", paramFromServiceMsg);
        localEditor.putString("renewal_tail_activity_url", paramObject);
        localEditor.putInt("renewal_tail_item_id", k);
        localEditor.commit();
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_preshow", "", 1, 0, 0, "", String.valueOf(i), "");
        paramIntent = this.app.getHandler(ChatActivity.class);
        if (paramIntent == null) {
          return;
        }
        paramIntent.sendMessage(paramIntent.obtainMessage(26));
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleExpireInfoResponse exception", paramIntent);
      return;
    }
    if ((l2 != 2L) && (l2 == 3L)) {}
  }
  
  private void b(oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (paramUdcUinData.uint32_rsp_theme_font_id.has()) {
      bhql.b(paramUdcUinData.uint32_rsp_theme_font_id.get());
    }
  }
  
  private void b(oidb_0x5eb.UdcUinData paramUdcUinData, String paramString)
  {
    if (paramUdcUinData.uint32_suspend_effect_id.has())
    {
      int i = paramUdcUinData.uint32_suspend_effect_id.get();
      if ((i >= 0) && (String.valueOf(paramString).equals(this.app.getCurrentAccountUin()))) {
        ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramString, i);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "uint32_suspend_effect_id = " + i);
      }
    }
  }
  
  private boolean b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, String paramString)
  {
    if ("ltgame_addr_distribute.get_iplist".equals(paramString))
    {
      I(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_router_game.apl_plus_d_linkcmd_get".equals(paramString))
    {
      u(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if (("apollo_game_login.get_user_game_list_info".equals(paramString)) || ("apollo_aio_game.get_user_game_list_info".equals(paramString)))
    {
      E(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if (("apollo_game_login.get_game_conf_info".equals(paramString)) || ("apollo_aio_game.get_game_conf_info".equals(paramString)))
    {
      F(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_aio_game.get_user_dev_gamelist".equals(paramString))
    {
      G(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if (("cmshowar_message_plat.get_msg".equals(paramString)) || ("apollo_interact.get_msg".equals(paramString)))
    {
      x(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("QQVacCommSvc.get_feeds".equals(paramString))
    {
      b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("QQVacCommSvc.get_padface_add".equals(paramString))
    {
      K(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("QQVacCommSvc.report_padface_shown".equals(paramString))
    {
      L(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("QQVacCommSvc.get_friends".equals(paramString))
    {
      c(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("cmshowar_activity_template.report_user_source".equals(paramString))
    {
      w(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    return false;
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramIntent = new Oidb_0x8fc.RspBody();
      for (;;)
      {
        try
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
          {
            notifyUI(27, true, null);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ColorNick", 2, "handleModifyColorNick sso fail result = " + paramFromServiceMsg.uint32_result.get());
          }
          if (paramFromServiceMsg.uint32_result.has())
          {
            i = paramFromServiceMsg.uint32_result.get();
            if (!paramIntent.strErrInfo.has()) {
              break label213;
            }
            paramIntent = paramIntent.strErrInfo.get();
            notifyUI(27, false, new Object[] { Integer.valueOf(i), paramIntent });
            return;
          }
        }
        catch (Exception paramIntent)
        {
          QLog.e("ColorNick", 1, "handleModifyColorNick error: ", paramIntent);
          notifyUI(27, false, Integer.valueOf(-1));
          return;
        }
        int i = -1;
        continue;
        label213:
        paramIntent = "";
      }
    }
  }
  
  private void c(oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    int i;
    if (paramUdcUinData.uint32_bubble_unread_switch.has())
    {
      i = paramUdcUinData.uint32_bubble_unread_switch.get();
      paramUdcUinData = (BubbleManager)this.app.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
      if (paramUdcUinData != null) {
        if (i != 0) {
          break label81;
        }
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      paramUdcUinData.a(bool);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "uint32_bubble_unread_switch : " + i);
      }
      return;
    }
  }
  
  private void c(oidb_0x5eb.UdcUinData paramUdcUinData, String paramString)
  {
    Dialogue localDialogue;
    if (paramUdcUinData.bytes_req_vip_ext_id.has())
    {
      localDialogue = new Dialogue();
      localDialogue.mergeFrom(paramUdcUinData.bytes_req_vip_ext_id.get().toByteArray());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "vip_card_extension id by refresh=" + localDialogue.short_nameplate_itemid);
      }
      paramUdcUinData = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramString = paramUdcUinData.e(paramString);
      if (paramString != null) {
        if (!localDialogue.short_nameplate_itemid.has()) {
          break label127;
        }
      }
    }
    label127:
    for (int i = localDialogue.short_nameplate_itemid.get();; i = 0)
    {
      paramString.bigClubExtTemplateId = i;
      paramUdcUinData.a(paramString);
      return;
    }
  }
  
  private boolean c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, String paramString)
  {
    if ("apollo_aio_game.check_game_v2".equals(paramString))
    {
      o(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_aio_game.get_game_room_state".equals(paramString))
    {
      l(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("OidbSvc.0x5eb_99".equals(paramString))
    {
      p(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("Praise.sso".equals(paramString))
    {
      a(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("vaspoke.check".equals(paramString))
    {
      B(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_terminal_info.get_user_appear_info".equals(paramString))
    {
      q(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_aio_game.get_playing_usernum".equals(paramString))
    {
      C(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_game_av.join_av_room".equals(paramString))
    {
      a(paramString, paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_game_av.get_av_ctrl_param".equals(paramString))
    {
      a(paramString, paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_game_av.get_usraccinfo".equals(paramString))
    {
      a(paramString, paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_currency.buy_item_by_curre".equals(paramString))
    {
      s(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_red_dot.get_reddot_info".equals(paramString))
    {
      m(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_router_game.game_relation_linkcmd_get_rank_chg".equals(paramString))
    {
      r(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_aio_game.save_user_gamepanel_gamelist".equals(paramString))
    {
      t(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("Groupeffect.commop".equals(paramString))
    {
      D(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("gxzbpublic.filter".equals(paramString))
    {
      H(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_dc_report.service_monit".equals(paramString))
    {
      J(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_router_game.apl_sq_wl_linkcmd_get_all".equals(paramString))
    {
      v(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("OidbSvc.0x8fc_3".equals(paramString))
    {
      c(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    return false;
  }
  
  private boolean d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, String paramString)
  {
    if (paramString.equals(jdField_b_of_type_JavaLangString))
    {
      a(paramIntent, paramArrayOfByte);
      return true;
    }
    if ("apollo_core.get_avatar".equals(paramString))
    {
      y(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_core.get_user_info".equals(paramString))
    {
      d(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_core.check_act".equals(paramString))
    {
      e(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("OidbSvc.0x5eb_15".equals(paramString))
    {
      z(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_extend.zan".equals(paramString))
    {
      f(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_extend.set_user_flag".equals(paramString))
    {
      A(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if (jdField_c_of_type_JavaLangString.equals(paramString))
    {
      b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("scupdate.handle".equals(paramString))
    {
      g(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("apollo_motto.get_user_motto".equals(paramString))
    {
      h(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("SQQShopAct.ReqAct".equals(paramString))
    {
      i(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("SQQShopActRead.GetActStatus".equals(paramString))
    {
      j(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    if ("SQQShopAuthCodeSvc.AuthCode".equals(paramString))
    {
      k(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return true;
    }
    return false;
  }
  
  private void x(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str1 = paramIntent.getStringExtra("cmd");
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleExploreInfo] cmd: " + str1 + "data null or rsp failed");
      notifyUI(28, false, null);
    }
    int j;
    int k;
    do
    {
      return;
      while (!paramFromServiceMsg.hasNext())
      {
        for (;;)
        {
          try
          {
            paramIntent = new WebSSOAgent.UniSsoServerRsp();
            paramIntent.mergeFrom(paramArrayOfByte);
            l = paramIntent.ret.get();
            if (0L == l) {
              break;
            }
            paramFromServiceMsg = jdField_a_of_type_JavaLangString;
            paramArrayOfByte = new StringBuilder().append("[handleExploreInfo] cmd: ").append(str1).append(", retCode: ").append(l).append(", errMsg: ");
            if (paramIntent.errmsg.has())
            {
              paramIntent = paramIntent.errmsg.get();
              QLog.e(paramFromServiceMsg, 1, paramIntent);
              notifyUI(28, false, null);
              return;
            }
          }
          catch (Exception paramIntent)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleExploreInfo] cmd: " + str1 + ", exceptonMsg: " + paramIntent.getMessage());
            notifyUI(28, false, null);
            return;
          }
          paramIntent = "unknown";
        }
        paramFromServiceMsg = new STExploreInfo.STGetMsgRsp();
        paramFromServiceMsg.mergeFrom(paramIntent.pbRsqData.get().toByteArray());
        if (!paramFromServiceMsg.eid_list.has()) {
          break;
        }
        paramFromServiceMsg = paramFromServiceMsg.eid_list.get().iterator();
      }
      paramArrayOfByte = (STExploreInfo.STEntryIdMsg)paramFromServiceMsg.next();
      j = paramArrayOfByte.entry_id.get();
      k = paramArrayOfByte.next_req_ts.get();
      localObject = this.app.getApp().getSharedPreferences("apollo_sp" + this.app.getCurrentUin(), 0);
      if (j != 1) {
        break;
      }
      paramIntent = "next_req_st_drawer";
      this.jdField_a_of_type_Int = k;
      ((SharedPreferences)localObject).edit().putInt(paramIntent, k).commit();
      paramIntent = paramArrayOfByte.msg_info.get().iterator();
    } while (!paramIntent.hasNext());
    STExploreInfo.STMsgInfo localSTMsgInfo = (STExploreInfo.STMsgInfo)paramIntent.next();
    long l = localSTMsgInfo.seq.get();
    paramArrayOfByte = localSTMsgInfo.wording.get().toStringUtf8();
    Object localObject = localSTMsgInfo.jump_url.get().toStringUtf8();
    int m = localSTMsgInfo.is_red.get();
    String str2 = localSTMsgInfo.icon_url.get().toStringUtf8();
    int n = localSTMsgInfo.action_id.get();
    int i1 = localSTMsgInfo.bubble_id.get();
    paramFromServiceMsg = localSTMsgInfo.scheme.get();
    int i2 = amme.a(this.app, this.app.getCurrentUin());
    paramIntent = paramFromServiceMsg;
    if (2 == i2) {
      paramIntent = "3d_" + paramFromServiceMsg;
    }
    if (localSTMsgInfo.msg_id.has()) {}
    for (int i = localSTMsgInfo.msg_id.get();; i = 0)
    {
      paramFromServiceMsg = new JSONObject();
      paramFromServiceMsg.put("entry_id", j);
      paramFromServiceMsg.put("seq", l);
      paramFromServiceMsg.put("wording", paramArrayOfByte);
      paramFromServiceMsg.put("jump_url", localObject);
      paramFromServiceMsg.put("is_red", m);
      paramFromServiceMsg.put("icon_url", str2);
      paramFromServiceMsg.put("action_id", n);
      paramFromServiceMsg.put("bubble_id", i1);
      paramFromServiceMsg.put("scheme", paramIntent);
      paramFromServiceMsg.put("next_st", k);
      paramFromServiceMsg.put("show_sum", 1);
      paramFromServiceMsg.put("msg_id", i);
      paramFromServiceMsg.put("cmshow_module", i2);
      QLog.d(jdField_a_of_type_JavaLangString, 1, "[handleExploreInfo] reqCmd: " + str1 + ", id:" + j + ",info:" + paramFromServiceMsg.toString());
      notifyUI(28, true, paramFromServiceMsg.toString());
      return;
      paramIntent = "next_req_st_drawer_friend_card";
      this.jdField_b_of_type_Int = k;
      break;
      throw new Exception("eid_list is null");
    }
  }
  
  private void y(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    int j = 0;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "; isSuccess: " + paramFromServiceMsg.isSuccess() + ", ret: " + paramFromServiceMsg.getResultCode());
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress ret: " + paramFromServiceMsg.ret.get());
        }
        if (0L != paramFromServiceMsg.ret.get()) {
          continue;
        }
        paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get());
        if (paramFromServiceMsg == null) {
          continue;
        }
        a(paramFromServiceMsg);
      }
      catch (Throwable paramFromServiceMsg)
      {
        long l;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "", paramFromServiceMsg);
        continue;
      }
      paramIntent = (Long[])paramIntent.getExtras().get("uinArr");
      if (paramIntent == null) {
        break;
      }
      int k = paramIntent.length;
      int i = j;
      if (i >= k) {
        break;
      }
      l = paramIntent[i].longValue();
      this.jdField_a_of_type_JavaUtilVector.remove(Long.valueOf(l));
      i += 1;
      continue;
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = (Long[])paramIntent.getExtras().get("uinArr");
        k = paramFromServiceMsg.length;
        i = 0;
        if (i < k)
        {
          l = paramFromServiceMsg[i].longValue();
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress no dress info uin:" + l);
          a(String.valueOf(l), null);
          i += 1;
        }
        else
        {
          continue;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handleGetUserApolloDress request failed " + paramFromServiceMsg.ret.get());
          paramFromServiceMsg = (Long[])paramIntent.getExtras().get("uinArr");
          if (paramFromServiceMsg != null)
          {
            k = paramFromServiceMsg.length;
            i = 0;
            if (i < k)
            {
              a(String.valueOf(paramFromServiceMsg[i].longValue()), null);
              i += 1;
            }
            else
            {
              continue;
              QLog.e(jdField_a_of_type_JavaLangString, 1, "handleGetUserApolloDress fail ret: " + paramFromServiceMsg.getResultCode());
              paramFromServiceMsg = (Long[])paramIntent.getExtras().get("uinArr");
              if (paramFromServiceMsg != null)
              {
                k = paramFromServiceMsg.length;
                i = 0;
                while (i < k)
                {
                  a(String.valueOf(paramFromServiceMsg[i].longValue()), null);
                  i += 1;
                }
              }
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress done  mSendingQueue size: " + this.jdField_a_of_type_JavaUtilVector.size());
    }
  }
  
  private void z(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder().append("handleGetApolloBaseInfo ").append(paramFromServiceMsg.isSuccess()).append(", ");
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length;; i = -1)
    {
      QLog.d((String)localObject1, 1, i);
      if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
        try
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
          {
            paramIntent = new oidb_0x5eb.RspBody();
            paramIntent.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
            paramFromServiceMsg = new ArrayList(paramIntent.rpt_msg_uin_data.size());
            paramArrayOfByte = new ArrayList(paramIntent.rpt_msg_uin_data.size());
            localObject1 = (amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER);
            i = 0;
            if (i < paramIntent.rpt_msg_uin_data.size())
            {
              localObject2 = (oidb_0x5eb.UdcUinData)paramIntent.rpt_msg_uin_data.get(i);
              String str = ((oidb_0x5eb.UdcUinData)localObject2).uint64_uin.get() + "";
              ApolloBaseInfo localApolloBaseInfo = ((amme)localObject1).b(str);
              if (((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_vip_flag.has()) {
                localApolloBaseInfo.apolloVipFlag = ((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_vip_flag.get();
              }
              if (((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_vip_level.has()) {
                localApolloBaseInfo.apolloVipLevel = ((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_vip_level.get();
              }
              if (((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_status.has()) {
                localApolloBaseInfo.apolloStatus = ((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_status.get();
              }
              if (((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_timestamp.has()) {
                localApolloBaseInfo.apolloServerTS = ((oidb_0x5eb.UdcUinData)localObject2).uint32_apollo_timestamp.get();
              }
              if (((oidb_0x5eb.UdcUinData)localObject2).uint32_cmshow_3d_flag.has()) {
                localApolloBaseInfo.cmshow3dFlag = ((oidb_0x5eb.UdcUinData)localObject2).uint32_cmshow_3d_flag.get();
              }
              if (((oidb_0x5eb.UdcUinData)localObject2).uint32_flag_super_yellow_diamond.has()) {
                localApolloBaseInfo.superYellowDiamondFlag = ((oidb_0x5eb.UdcUinData)localObject2).uint32_flag_super_yellow_diamond.get();
              }
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "handleGetApolloBaseInfo uin: ", localApolloBaseInfo.uin, ",apollo vipFlag: ", Integer.valueOf(localApolloBaseInfo.apolloVipFlag), ", apollo status: ", Integer.valueOf(localApolloBaseInfo.apolloStatus), ", apollo level: ", Integer.valueOf(localApolloBaseInfo.apolloVipLevel), ", svr TS: ", Long.valueOf(localApolloBaseInfo.apolloServerTS), ", cmshow3dFlag=", Integer.valueOf(localApolloBaseInfo.cmshow3dFlag) });
              }
              if (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS) {
                paramFromServiceMsg.add(Long.valueOf(((oidb_0x5eb.UdcUinData)localObject2).uint64_uin.get()));
              }
              for (;;)
              {
                localApolloBaseInfo.apolloUpdateTime = NetConnInfoCenter.getServerTime();
                paramArrayOfByte.add(localApolloBaseInfo);
                i += 1;
                break;
                b(str, localApolloBaseInfo);
              }
            }
          }
          else
          {
            return;
          }
        }
        catch (Throwable paramIntent)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "", paramIntent);
        }
      }
      do
      {
        ((amme)localObject1).b(paramArrayOfByte);
        a(paramFromServiceMsg, "AIO");
        return;
        paramIntent = paramIntent.getStringArrayExtra("uins");
      } while (paramIntent == null);
      paramFromServiceMsg = new ArrayList(paramIntent.length);
      int j = paramIntent.length;
      i = 0;
      if (i < j)
      {
        paramArrayOfByte = paramIntent[i];
        localObject1 = ((amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER)).b(paramArrayOfByte);
        if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloLocalTS != ((ApolloBaseInfo)localObject1).apolloServerTS)) {
          paramFromServiceMsg.add(Long.valueOf(Long.parseLong(paramArrayOfByte)));
        }
        for (;;)
        {
          i += 1;
          break;
          b(paramArrayOfByte, (ApolloBaseInfo)localObject1);
        }
      }
      a(paramFromServiceMsg, "AIOPanel");
      return;
    }
  }
  
  public JSONObject a(String paramString, List<ApolloGameScoreData> paramList)
  {
    JSONObject localJSONObject1;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONObject1.put("uin", Long.parseLong(paramString));
      paramString = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ApolloGameScoreData localApolloGameScoreData = (ApolloGameScoreData)paramList.next();
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("gameId", localApolloGameScoreData.mGameId);
        localJSONObject2.put("score", localApolloGameScoreData.mScore);
        paramString.put(localJSONObject2);
      }
      localJSONObject1.put("gameList", paramString);
    }
    catch (Throwable paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getScoreParam]", paramString);
      return null;
    }
    return localJSONObject1;
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        if (this.app == null)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[getApolloLoginData] app is null");
          return;
        }
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new STGameLogin.STGameLoginReq();
        long l = ApolloGameUtil.a(this.app);
        ((STGameLogin.STGameLoginReq)localObject).local_ts.set((int)l);
        ((STGameLogin.STGameLoginReq)localObject).from.set("android");
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((STGameLogin.STGameLoginReq)localObject).toByteArray()));
        boolean bool = ((amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER)).c(this.app.getCurrentUin());
        if (bool)
        {
          localObject = "apollo_aio_game.get_user_game_list_info";
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "getApolloGameLoginReq isGameWhiteUser:", Boolean.valueOf(bool), " ts:", Long.valueOf(l) });
          }
          NewIntent localNewIntent = new NewIntent(this.app.getApp(), bhox.class);
          localNewIntent.putExtra("cmd", (String)localObject);
          localNewIntent.putExtra("data", localUniSsoServerReq.toByteArray());
          this.app.startServlet(localNewIntent);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[getApolloGameLoginReq] exception=", localException);
        return;
      }
      String str = "apollo_game_login.get_user_game_list_info";
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestExpireInfo, from=" + paramInt);
    }
    IndividPub.expTips_Req localexpTips_Req = new IndividPub.expTips_Req();
    Object localObject = new IndividPub.Platform_Comm_Req();
    ((IndividPub.Platform_Comm_Req)localObject).platForm.set(109L);
    ((IndividPub.Platform_Comm_Req)localObject).osver.set(Build.VERSION.RELEASE);
    ((IndividPub.Platform_Comm_Req)localObject).mqqver.set("8.4.10.4875");
    localexpTips_Req.comm.set((MessageMicro)localObject);
    localexpTips_Req.cmd.set(1);
    localexpTips_Req.setHasFlag(true);
    localObject = new IndividPub.expTips_Pull_Req();
    ((IndividPub.expTips_Pull_Req)localObject).from.set(paramInt);
    localexpTips_Req.reqcmd_0x01.set((MessageMicro)localObject);
    localObject = new NewIntent(this.app.getApp(), bhox.class);
    ((NewIntent)localObject).putExtra("cmd", jdField_c_of_type_JavaLangString);
    ((NewIntent)localObject).putExtra("data", localexpTips_Req.toByteArray());
    ((NewIntent)localObject).putExtra("from", paramInt);
    this.app.startServlet((NewIntent)localObject);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "getPadFaceAd");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10.4875");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("uin", Long.parseLong(this.app.getCurrentAccountUin()));
      localJSONObject2.put("id", paramInt2);
      localJSONObject2.put("redpoint", paramInt1);
      localJSONObject2.put("last_time", paramLong);
      localJSONObject2.put("qq_plat", 1);
      localJSONObject2.put("qq_version", "8.4.10.4875");
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12818", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.app.getApp(), bhox.class);
      ((NewIntent)localObject).putExtra("cmd", "QQVacCommSvc.get_padface_add");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getPadFaceAd] exception=", localException);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    int j = 0;
    try
    {
      i = NetworkUtil.getSystemNetwork(this.app.getApp().getApplicationContext());
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int k;
        label28:
        Object localObject;
        int i = 0;
      }
    }
    try
    {
      k = Integer.parseInt(paramString);
      j = k;
    }
    catch (Exception paramString)
    {
      break label28;
    }
    paramString = new qqshop_act.SQQSHPActReq();
    localObject = new qqshop_act.SQQSHPUsrInfo();
    ((qqshop_act.SQQSHPUsrInfo)localObject).carriertype.set(onq.b());
    ((qqshop_act.SQQSHPUsrInfo)localObject).net_type.set(i);
    ((qqshop_act.SQQSHPUsrInfo)localObject).src.set(onq.a(paramInt2));
    ((qqshop_act.SQQSHPUsrInfo)localObject).src_idx.set(j);
    paramString.act_id.set(paramInt1);
    paramString.usr_info.set((MessageMicro)localObject);
    localObject = new NewIntent(this.app.getApp(), bhox.class);
    ((NewIntent)localObject).putExtra("cmd", "SQQShopAct.ReqAct");
    ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 3000L);
    this.app.startServlet((NewIntent)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("EcshopJd", 2, "jd red packet sent.");
    }
  }
  
  public void a(int paramInt, Bundle paramBundle, aztk paramaztk)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestPraiseAuth, praiseId=" + paramInt);
    }
    Object localObject = new praise_sso.TSsoCmd0x1Req();
    ((praise_sso.TSsoCmd0x1Req)localObject).i32_itemId.set(paramInt);
    praise_sso.TPraiseSsoReq localTPraiseSsoReq = new praise_sso.TPraiseSsoReq();
    localTPraiseSsoReq.i32_cmd.set(1);
    localTPraiseSsoReq.i32_implat.set(109);
    localTPraiseSsoReq.str_qq_ver.set("8.4.10.4875");
    localTPraiseSsoReq.st_cmd0x1_req.set((MessageMicro)localObject);
    localObject = new NewIntent(this.app.getApp(), bhox.class);
    ((NewIntent)localObject).putExtra("cmd", "Praise.sso");
    ((NewIntent)localObject).putExtra("data", localTPraiseSsoReq.toByteArray());
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Aztk = paramaztk;
    this.app.startServlet((NewIntent)localObject);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("id", paramInt1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.app.getApp(), bhox.class);
      ((NewIntent)localObject).putExtra("cmd", "vaspoke.check");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("timeout", 20000);
      ((NewIntent)localObject).putExtra("id", paramInt1);
      ((NewIntent)localObject).putExtra("name", paramString1);
      ((NewIntent)localObject).putExtra("minVersion", paramString2);
      ((NewIntent)localObject).putExtra("feeType", paramInt2);
      ((NewIntent)localObject).putExtra("fromType", paramInt3);
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handlePokeAuth failed ", paramString1);
    }
  }
  
  public void a(int paramInt, String paramString, anbb paramanbb)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_core.set_status");
        if (!TextUtils.isEmpty(paramString)) {
          break label223;
        }
        paramString = "android";
        ((JSONObject)localObject).put("from", paramString);
        ((JSONObject)localObject).put("status", paramInt);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString = new NewIntent(this.app.getApp(), bhox.class);
        paramString.putExtra("cmd", "apollo_core.set_status");
        paramString.putExtra("data", localUniSsoServerReq.toByteArray());
        paramString.putExtra("apollo_status", paramInt);
        anba.a.a(paramanbb, paramString);
        this.app.startServlet(paramString);
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "changeApolloStatus failed ", paramString);
      return;
      label223:
      paramString = "android." + paramString;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[reportGamePubAccountMsgList] status:" + paramInt + ",msg:" + paramString1 + ",url:" + paramString2);
    }
    Object localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
    localUniSsoServerReq.comm.set((MessageMicro)localObject);
    localObject = new MonitReport.MonitReportReq();
    ((MonitReport.MonitReportReq)localObject).type.set(1);
    MonitReport.PublicAccountReq localPublicAccountReq = new MonitReport.PublicAccountReq();
    localPublicAccountReq.action.set(paramInt);
    if (TextUtils.isEmpty(paramString1)) {}
    for (paramString1 = Long.valueOf(0L);; paramString1 = Long.valueOf(Long.parseLong(paramString1)))
    {
      localPublicAccountReq.msgid.set(paramString1.longValue());
      localPublicAccountReq.url.set(paramString2);
      localPublicAccountReq.ts.set(NetConnInfoCenter.getServerTimeMillis());
      ((MonitReport.MonitReportReq)localObject).public_acct_req.add(localPublicAccountReq);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((MonitReport.MonitReportReq)localObject).toByteArray()));
      paramString1 = new NewIntent(this.app.getApp(), bhox.class);
      paramString1.putExtra("cmd", "gc_monitor_report.report_public_acct_info");
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet(paramString1);
      return;
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, float paramFloat, int paramInt3, String paramString3)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "apollo_core.check_act");
      if (TextUtils.isEmpty(paramString3)) {}
      for (localObject = "android";; localObject = "android." + paramString3)
      {
        localJSONObject.put("from", localObject);
        localJSONObject.put("actid", paramInt1);
        localUniSsoServerReq.reqdata.set(localJSONObject.toString());
        localObject = new NewIntent(this.app.getApp(), bhox.class);
        ((NewIntent)localObject).putExtra("cmd", "apollo_core.check_act");
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("actionId", paramInt1);
        if (!TextUtils.isEmpty(paramString1)) {
          ((NewIntent)localObject).putExtra("actionText", paramString1);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          ((NewIntent)localObject).putExtra("textType", paramString2);
        }
        if (!TextUtils.isEmpty(paramString3)) {
          ((NewIntent)localObject).putExtra("optFrom", paramString3);
        }
        ((NewIntent)localObject).putExtra("audioId", paramInt2);
        ((NewIntent)localObject).putExtra("audioTime", paramFloat);
        ((NewIntent)localObject).putExtra("isPlayDefultAudio", paramInt3);
        this.app.startServlet((NewIntent)localObject);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "checkActionAuth failed id: " + paramInt1, paramString1);
      }
    }
  }
  
  public void a(int paramInt1, String paramString1, boolean paramBoolean, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[getGameOnlineUserCount] gameId=", Integer.valueOf(paramInt1), ", from=", paramString1 });
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_aio_game.get_playing_usernum");
      ((JSONObject)localObject).put("from", paramString1);
      ((JSONObject)localObject).put("gameId", paramInt1);
      ((JSONObject)localObject).put("opType", paramInt2);
      ((JSONObject)localObject).put("theme", paramString2);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString1 = new NewIntent(this.app.getApp(), bhox.class);
      paramString1.putExtra("cmd", "apollo_aio_game.get_playing_usernum");
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString1.putExtra("tipsBarAnimation", paramBoolean);
      this.app.startServlet(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getGameOnlineUserCount] exception=", paramString1);
    }
  }
  
  public void a(int paramInt, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[reportGamePubAccountMsgList] status:" + paramInt + " size:" + paramList.size());
    }
    Object localObject = new WebSSOAgent.UniSsoServerReqComm();
    ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
    ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
    localUniSsoServerReq.comm.set((MessageMicro)localObject);
    localObject = new MonitReport.MonitReportReq();
    ((MonitReport.MonitReportReq)localObject).type.set(1);
    Iterator localIterator = paramList.iterator();
    MonitReport.PublicAccountReq localPublicAccountReq;
    if (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      localPublicAccountReq = new MonitReport.PublicAccountReq();
      localPublicAccountReq.action.set(paramInt);
      paramList = localMessageRecord.getExtInfoFromExtStr("pa_msgId");
      if (!TextUtils.isEmpty(localMessageRecord.getExtInfoFromExtStr("pa_msgId"))) {
        break label300;
      }
      paramList = "0";
    }
    label300:
    for (;;)
    {
      localPublicAccountReq.msgid.set(Long.parseLong(paramList));
      localPublicAccountReq.ts.set(NetConnInfoCenter.getServerTimeMillis());
      ((MonitReport.MonitReportReq)localObject).public_acct_req.add(localPublicAccountReq);
      break;
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((MonitReport.MonitReportReq)localObject).toByteArray()));
      paramList = new NewIntent(this.app.getApp(), bhox.class);
      paramList.putExtra("cmd", "gc_monitor_report.report_public_acct_info");
      paramList.putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet(paramList);
      return;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApp(), bhox.class);
    localNewIntent.putExtra("cmd", jdField_b_of_type_JavaLangString);
    localNewIntent.putExtra("pendantId", paramLong);
    localNewIntent.putExtra("seriesId", paramInt1);
    localNewIntent.putExtra("uin", this.app.getCurrentAccountUin());
    PendantMarket.SetAddonReq localSetAddonReq = new PendantMarket.SetAddonReq();
    localSetAddonReq.cmd.set(2);
    localSetAddonReq.int_platform.set(2);
    localSetAddonReq.long_addon_id.set(paramLong);
    localSetAddonReq.str_qq_version.set("8.4.10");
    if (paramInt2 != -1) {
      localSetAddonReq.int_from_type.set(paramInt2);
    }
    localNewIntent.putExtra("data", localSetAddonReq.toByteArray());
    localNewIntent.putExtra("timeout", 30000);
    this.app.startServlet(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    group_effect_commu.ReqBody localReqBody = new group_effect_commu.ReqBody();
    localReqBody.u64_cmd.set(paramLong1);
    localReqBody.u64_uin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localReqBody.i32_implat.set(109);
    localReqBody.str_version.set(DeviceInfoUtil.getQQVersion());
    Object localObject;
    if (paramLong1 == 8192L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect", 2, "sendTroopEnterEffectCMD ENTER_GROUP troopId = " + paramLong2);
      }
      localObject = new group_effect_commu.TEntryNotifyReq0x2000();
      ((group_effect_commu.TEntryNotifyReq0x2000)localObject).group_id.set(paramLong2);
      localReqBody.st_entry_notify.set((MessageMicro)localObject);
    }
    for (;;)
    {
      localObject = new NewIntent(this.mApp.getApp(), bhox.class);
      ((NewIntent)localObject).putExtra("cmd", "Groupeffect.commop");
      ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
      ((NewIntent)localObject).putExtra("usrdata", paramLong1);
      this.app.startServlet((NewIntent)localObject);
      return;
      if (paramLong1 == 2L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopEnterEffect", 2, "sendTroopEnterEffectCMD GET_MY_EFFECT troopId = " + paramLong2);
        }
        localObject = new group_effect_commu.TGetMyEffectReq0x2();
        localReqBody.st_get_effect.set((MessageMicro)localObject);
      }
    }
  }
  
  protected void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handlePraiseAuthResponse");
    }
    for (;;)
    {
      int i;
      try
      {
        if (!paramFromServiceMsg.isSuccess())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handlePraiseAuthResponse, isSuccess false, error code=" + paramFromServiceMsg.getResultCode());
          return;
        }
        paramIntent = new praise_sso.TPraiseSsoRsp();
        paramIntent.mergeFrom((byte[])paramObject);
        i = paramIntent.i32_ret.get();
        paramIntent = (praise_sso.TSsoCmd0x1Rsp)paramIntent.st_cmd0x1_rsp.get();
        int j = paramIntent.i32_itemId.get();
        paramIntent = paramIntent.str_url.get();
        if (i == 0)
        {
          PraiseManager.a(this.app, j);
          if ((this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_Aztk == null)) {
            break;
          }
          this.jdField_a_of_type_Aztk.a(i, j, paramIntent, this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_AndroidOsBundle = null;
          this.jdField_a_of_type_Aztk = null;
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handlePraiseAuthResponse exception", paramIntent);
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handlePraiseAuthResponse, ret=" + i);
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("cmd");
    boolean bool = paramIntent.getBooleanExtra("isCMShowJSRequest", false);
    if (TextUtils.isEmpty(str)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (a(paramIntent, paramFromServiceMsg, paramArrayOfByte));
        if (bool)
        {
          n(paramIntent, paramFromServiceMsg, paramArrayOfByte);
          return;
        }
      } while ((a(paramIntent, paramFromServiceMsg, paramArrayOfByte, str)) || (d(paramIntent, paramFromServiceMsg, paramArrayOfByte, str)) || (c(paramIntent, paramFromServiceMsg, paramArrayOfByte, str)) || (b(paramIntent, paramFromServiceMsg, paramArrayOfByte, str)));
      bhnd localbhnd = (bhnd)jdField_a_of_type_JavaUtilMap.get(str);
      if (localbhnd != null)
      {
        localbhnd.a(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "unknow cmd :" + str);
  }
  
  public void a(Intent paramIntent, byte[] paramArrayOfByte)
  {
    Object localObject1 = new PendantMarket.SetAddonRsp();
    try
    {
      ((PendantMarket.SetAddonRsp)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject1;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handlePendantAuthRsp rsp.mergeFrom e=" + paramArrayOfByte);
        paramArrayOfByte = null;
      }
      Bundle localBundle = new Bundle();
      int i = paramArrayOfByte.int_result.get();
      localBundle.putLong("pendantId", paramIntent.getLongExtra("pendantId", -1L));
      localBundle.getInt("seriesId", paramIntent.getIntExtra("seriesId", -1));
      localBundle.putString("uin", paramIntent.getStringExtra("uin"));
      if (i == 0) {
        break label579;
      }
      if (!paramArrayOfByte.tips_info.has()) {
        break label377;
      }
      Object localObject2 = new PendantMarket.TipsInfo();
      try
      {
        ((PendantMarket.TipsInfo)localObject2).mergeFrom(paramArrayOfByte.tips_info.toByteArray());
        localObject3 = new PendantTipsInfo();
        boolean bool = ((PendantMarket.TipsInfo)localObject2).valid.get();
        ((PendantTipsInfo)localObject3).valid = bool;
        if (bool)
        {
          ((PendantTipsInfo)localObject3).type = ((PendantMarket.TipsInfo)localObject2).type.get();
          localObject1 = ((PendantMarket.TipsInfo)localObject2).title_wording.get();
          paramIntent = (Intent)localObject1;
          if (((String)localObject1).equals("")) {
            paramIntent = anvx.a(2131715402);
          }
          ((PendantTipsInfo)localObject3).titleWording = paramIntent;
          ((PendantTipsInfo)localObject3).wording = ((PendantMarket.TipsInfo)localObject2).wording.get();
          localObject1 = ((PendantMarket.TipsInfo)localObject2).right_btn_wording.get();
          paramIntent = (Intent)localObject1;
          if (((String)localObject1).equals("")) {
            paramIntent = anvx.a(2131715403);
          }
          ((PendantTipsInfo)localObject3).rightBtnWording = paramIntent;
          localObject1 = ((PendantMarket.TipsInfo)localObject2).left_btn_wording.get();
          paramIntent = (Intent)localObject1;
          if (((String)localObject1).equals("")) {
            paramIntent = anvx.a(2131715401);
          }
          ((PendantTipsInfo)localObject3).leftBtnWording = paramIntent;
          ((PendantTipsInfo)localObject3).vipType = ((PendantMarket.TipsInfo)localObject2).vip_type.get();
          ((PendantTipsInfo)localObject3).vipMonth = ((PendantMarket.TipsInfo)localObject2).vip_month.get();
          ((PendantTipsInfo)localObject3).url = ((PendantMarket.TipsInfo)localObject2).url.get();
        }
        localBundle.putSerializable("tipsInfo", (Serializable)localObject3);
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        for (;;)
        {
          label377:
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handlePendantAuthRsp tipsInfo.mergeFrom e=" + paramIntent);
        }
        if (!paramArrayOfByte.str_msg.has()) {
          break label565;
        }
      }
      if (!QLog.isColorLevel()) {
        break label409;
      }
      QLog.e("VasExtensionHandler", 2, "response from server error: " + i);
      label409:
      localBundle.putInt("result", i);
      switch (i)
      {
      case 1002: 
      case 1004: 
      case 2001: 
      case 2002: 
      default: 
        notifyUI(1, false, localBundle);
        return;
      }
      paramIntent = paramArrayOfByte.str_msg.get();
      label526:
      if (!paramArrayOfByte.str_url.has()) {
        break label572;
      }
      label565:
      label572:
      for (paramArrayOfByte = paramArrayOfByte.str_url.get();; paramArrayOfByte = "")
      {
        localBundle.putString("tips", paramIntent);
        localBundle.putString("url", paramArrayOfByte);
        break;
        paramIntent = "";
        break label526;
      }
      label579:
      if (this.app == null) {
        break label680;
      }
      localObject2 = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject3 = paramIntent.getStringExtra("uin");
      localObject1 = ((anvk)localObject2).a((String)localObject3);
      paramArrayOfByte = (byte[])localObject1;
      if (localObject1 != null) {
        break label641;
      }
      paramArrayOfByte = new ExtensionInfo();
      paramArrayOfByte.uin = ((String)localObject3);
      label641:
      paramArrayOfByte.pendantId = paramIntent.getLongExtra("pendantId", -1L);
      paramArrayOfByte.pendantDiyId = paramIntent.getIntExtra("pendantDiyId", 0);
      paramArrayOfByte.timestamp = System.currentTimeMillis();
      ((anvk)localObject2).a(paramArrayOfByte);
      label680:
      notifyUI(1, true, localBundle);
    }
    if (paramArrayOfByte == null) {
      return;
    }
  }
  
  public void a(bhot parambhot)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(parambhot);
      return;
    }
  }
  
  public void a(ReportInfoManager.ReportChannlInfo paramReportChannlInfo)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "reportGameCenterChannel");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10.4875");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("qq_version", "8.4.10.4875");
      Field[] arrayOfField = paramReportChannlInfo.getClass().getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        localJSONObject2.put(localField.getName(), localField.get(paramReportChannlInfo));
        i += 1;
      }
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12886", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramReportChannlInfo = new NewIntent(this.app.getApp(), bhox.class);
      paramReportChannlInfo.putExtra("cmd", "QQVacCommSvc.report_channel");
      paramReportChannlInfo.putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet(paramReportChannlInfo);
      return;
    }
    catch (Exception paramReportChannlInfo)
    {
      paramReportChannlInfo.printStackTrace();
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[doSaveGameList] empty list");
      return;
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_aio_game.save_user_gamepanel_gamelist");
      ((JSONObject)localObject).put("from", "android");
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        localJSONArray.put(paramArrayOfInt[i]);
        i += 1;
      }
      ((JSONObject)localObject).put("gameIdList", localJSONArray);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[doSaveGameList] " + ((JSONObject)localObject).toString());
      }
      paramArrayOfInt = new NewIntent(paramQQAppInterface.getApp(), bhox.class);
      paramArrayOfInt.putExtra("cmd", "apollo_aio_game.save_user_gamepanel_gamelist");
      paramArrayOfInt.putExtra("data", localUniSsoServerReq.toByteArray());
      paramQQAppInterface.startServlet(paramArrayOfInt);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getGameOnlineUserCount] exception=", paramQQAppInterface);
    }
  }
  
  public void a(String paramString)
  {
    if (this.app != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.app.getLongAccountUin()));
      a(localArrayList, paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "getGameFriendList");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10.4875");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appid", paramString);
      localJSONObject2.put("friend_type", paramInt);
      localJSONObject2.put("skey", ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin()));
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12825", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString = new NewIntent(this.app.getApp(), bhox.class);
      paramString.putExtra("cmd", "QQVacCommSvc.get_friends");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getGameFriendList] exception=", paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[buyActionByGold]");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cmd", "apollo_currency.buy_item_by_curre");
      localJSONObject.put("from", "Android");
      localJSONObject.put("toUin", Long.parseLong(paramString));
      localJSONObject.put("isSave", 0);
      localJSONObject.put("isGift", 0);
      paramString = new JSONArray();
      localObject = new JSONObject();
      ((JSONObject)localObject).put("type", 3);
      ((JSONObject)localObject).put("id", paramInt1);
      paramString.put(localObject);
      localJSONObject.put("buyList", paramString);
      localObject = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
      StringBuilder localStringBuilder = new StringBuilder().append("skey=");
      paramString = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = "";
      }
      localJSONObject.put("Cookie", paramString);
      localUniSsoServerReq.reqdata.set(localJSONObject.toString());
      paramString = new NewIntent(this.app.getApp(), bhox.class);
      paramString.putExtra("cmd", "apollo_currency.buy_item_by_curre");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString.putExtra("id", paramInt1);
      paramString.putExtra("packageId", paramInt2);
      this.app.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleBuyActionByGold] exception=", paramString);
    }
  }
  
  public void a(String paramString, int paramInt, anbb paramanbb)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = "android";; paramString = "android." + paramString)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_core.set_model");
        ((JSONObject)localObject).put("from", paramString);
        ((JSONObject)localObject).put("model", paramInt);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString = new NewIntent(this.app.getApp(), bhox.class);
        paramString.putExtra("cmd", "apollo_core.set_model");
        paramString.putExtra("data", localUniSsoServerReq.toByteArray());
        paramString.putExtra("model", paramInt);
        anba.a.a(paramanbb, paramString);
        this.app.startServlet(paramString);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, paramString.getMessage());
      }
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "");
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("cmd", "apollo_core.get_user_info");
        if (!TextUtils.isEmpty(paramString2)) {
          break label335;
        }
        paramString2 = "android";
        localJSONObject.put("from", paramString2);
        localJSONObject.put("touin", Long.valueOf(paramString1));
        localJSONObject.put("mask", i);
        localObject = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
        StringBuilder localStringBuilder = new StringBuilder().append("skey=");
        paramString2 = (String)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramString2 = "";
        }
        localJSONObject.put("Cookie", paramString2);
        localUniSsoServerReq.reqdata.set(localJSONObject.toString());
        paramString2 = new NewIntent(this.app.getApp(), bhox.class);
        paramString2.putExtra("cmd", "apollo_core.get_user_info");
        paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
        paramString2.putExtra("touin", paramString1);
        paramString2.putExtra("mask", i);
        this.app.startServlet(paramString2);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getUserApolloInfo failed ", paramString1);
      return;
      label335:
      paramString2 = "android." + paramString2;
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleNamePlateOfKingInfo : uin = " + paramString + ", gameId = " + paramLong1 + ", gameLoginTime = " + paramLong2 + ", dan = " + paramInt1 + ", dansSwitch = " + paramInt2);
    }
    Object localObject = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = ((anvk)localObject).b(paramString);
    localObject = ((anvk)localObject).e(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (this.app.getCurrentUin().equals(paramString)))
    {
      SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences("sp_plate_of_king", 0).edit();
      String str = "plate_of_king_display_switch_" + this.app.getCurrentUin();
      if (paramInt2 == 1)
      {
        bool1 = true;
        localEditor.putBoolean(str, bool1).apply();
      }
    }
    else if (localCard != null)
    {
      localCard.namePlateOfKingGameId = paramLong1;
      localCard.namePlateOfKingLoginTime = paramLong2;
      localCard.namePlateOfKingDan = paramInt1;
      if (paramInt2 != 1) {
        break label331;
      }
    }
    label331:
    for (boolean bool1 = true;; bool1 = false)
    {
      localCard.namePlateOfKingDanDisplatSwitch = bool1;
      this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, localCard);
      if (localObject != null)
      {
        ((Friends)localObject).namePlateOfKingGameId = paramLong1;
        ((Friends)localObject).namePlateOfKingLoginTime = paramLong2;
        ((Friends)localObject).namePlateOfKingDan = paramInt1;
        bool1 = bool2;
        if (paramInt2 == 1) {
          bool1 = true;
        }
        ((Friends)localObject).namePlateOfKingDanDisplatSwitch = bool1;
        this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramString);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, List<String> paramList, boolean paramBoolean, String paramString2, String paramString3)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "getGamePubAccountFeeds");
    Object localObject;
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq;
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    try
    {
      localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10.4875");
      localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("msg_id", paramLong1);
      localJSONObject2.put("msg_time", paramLong2);
      localJSONObject2.put("title", "");
      localJSONObject2.put("tt", 1);
      localJSONObject2.put("uin", "");
      localJSONObject2.put("appid", paramString2);
      localJSONObject2.put("ext_json", paramString3);
      paramString3 = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramString3.put((String)paramList.next());
      }
      localJSONObject2.put("view_feed_id_list", paramString3);
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getCmGameConnInfo] exception=", paramString1);
      return;
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localJSONObject2.put("get_top_card", i);
      localJSONObject2.put("qq_version", "8.4.10");
      localJSONObject2.put("skey", ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin()));
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12787", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramList = new NewIntent(this.app.getApp(), bhox.class);
      paramList.putExtra("cmd", "QQVacCommSvc.get_feeds");
      paramList.putExtra("data", localUniSsoServerReq.toByteArray());
      paramList.putExtra("msgId", paramString1);
      paramList.putExtra("msgSeq", paramLong1);
      paramList.putExtra("appId", paramString2);
      paramList.putExtra("fromBottom", paramBoolean);
      this.app.startServlet(paramList);
      return;
    }
  }
  
  void a(String paramString, Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    int i = 0;
    long l;
    if ("apollo_game_av.join_av_room".equals(paramString))
    {
      l = paramIntent.getLongExtra("usrdata", 0L);
      if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {
        bkjq.a().a(l, false, null);
      }
    }
    for (;;)
    {
      return;
      paramString = new WebSSOAgent.UniSsoServerRsp();
      paramIntent = new qqavopensdkSsoTunnel.STAudioVideoRsp();
      try
      {
        paramString.mergeFrom(paramArrayOfByte);
        paramIntent.mergeFrom(paramString.pbRsqData.get().toByteArray());
        paramString = ((qqavopensdkSsoTunnel.RspBody)((qqavopensdkSsoTunnel.STAudioVideoRsp)paramIntent.get()).rspbody.get()).bytes_rspbody.get().toByteArray();
        bkjq.a().a(l, true, paramString);
        return;
      }
      catch (Exception paramString)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleRoomSSOInfoCallback error:", paramString);
        return;
      }
      if ("apollo_game_av.get_av_ctrl_param".equals(paramString))
      {
        l = paramIntent.getLongExtra("usrdata", 0L);
        if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
        {
          bkjq.a().a(l, false, null);
          return;
        }
        paramString = new WebSSOAgent.UniSsoServerRsp();
        paramIntent = new qqavopensdkSsoTunnel.STAVCtrlParamRsp();
        try
        {
          paramString.mergeFrom(paramArrayOfByte);
          paramIntent.mergeFrom(paramString.pbRsqData.get().toByteArray());
          paramString = ((qqavopensdkSsoTunnel.STAVCtrlParamRsp)paramIntent.get()).ctrlParam.get().toByteArray();
          bkjq.a().a(l, true, paramString);
          return;
        }
        catch (Exception paramString)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handleRoomSSOInfoCallback error:", paramString);
          return;
        }
      }
      if ((!"apollo_game_av.get_usraccinfo".equals(paramString)) || (paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {
        continue;
      }
      paramString = new GetTinyID.STTinyID2UserAccInfoRsp();
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        paramString.mergeFrom(paramIntent.pbRsqData.get().toByteArray());
        paramString = ((GetTinyID.STTinyID2UserAccInfoRsp)paramString.get()).user_acc_info.get();
        if ((paramString == null) || (paramString.size() <= 0)) {
          continue;
        }
        paramIntent = new ArrayList(paramString.size());
        paramFromServiceMsg = new ArrayList(paramString.size());
        while (i < paramString.size())
        {
          paramIntent.add(Long.valueOf(((GetTinyID.STUserAccInfo)paramString.get(i)).tinyid.get()));
          paramFromServiceMsg.add(((GetTinyID.STUserAccInfo)paramString.get(i)).identifier.get());
          i += 1;
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleRoomSSOInfoCallback error:", paramString);
      }
    }
  }
  
  public void a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArrayList localArrayList;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bhot localbhot = (bhot)localIterator.next();
        if (localbhot.b(paramString, paramApolloBaseInfo)) {
          localArrayList.add(localbhot);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.removeAll(localArrayList);
  }
  
  public void a(String paramString, MessageMicro paramMessageMicro, Class paramClass, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), bhox.class);
    Object localObject = new StringBuilder().append(paramString).append("_");
    long l = jdField_b_of_type_Long + 1L;
    jdField_b_of_type_Long = l;
    localObject = l;
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramMessageMicro.toByteArray());
    localNewIntent.putExtra("timeout", 30000);
    localNewIntent.putExtra("__cmd_seq__", (String)localObject);
    localNewIntent.putExtra("__rspClass__", paramClass);
    this.jdField_a_of_type_JavaUtilHashMap.put(localObject, paramBusinessObserver);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_extend.zan");
        if (!TextUtils.isEmpty(paramString2)) {
          break label202;
        }
        paramString2 = "android";
        ((JSONObject)localObject).put("from", paramString2);
        ((JSONObject)localObject).put("touin", Long.parseLong(paramString1));
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString1 = new NewIntent(this.app.getApp(), bhox.class);
        paramString1.putExtra("cmd", "apollo_extend.zan");
        paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
        this.app.startServlet(paramString1);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "changeApolloStatus failed ", paramString1);
      return;
      label202:
      paramString2 = "android." + paramString2;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "[reportGameAchievement]");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10.4875");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appid", paramString1);
      localJSONObject2.put("tt", 1);
      localJSONObject2.put("type", paramInt);
      localJSONObject2.put("uin", paramString2);
      localJSONObject2.put("skey", ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin()));
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("13077", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString2 = new NewIntent(this.app.getApp(), bhox.class);
      paramString2.putExtra("cmd", "GameCenterWebSvc.13077");
      paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString2.putExtra("appid", paramString1);
      this.app.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[reportGameAchievement] exception=", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.4.10");
      Object localObject1 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
      if ((paramString1 == null) && (paramString2 == null))
      {
        QLog.e(jdField_a_of_type_JavaLangString + "_apollo_store_stability_", 1, "reportApolloStoreStabilityData. cmd == null || url == null");
        return;
      }
      localObject2 = new WebSsoBody.STServiceMonitReq();
      WebSsoBody.STServiceMonitItem localSTServiceMonitItem = new WebSsoBody.STServiceMonitItem();
      localSTServiceMonitItem.errcode.set(paramInt1);
      if (!TextUtils.isEmpty(paramString1)) {
        localSTServiceMonitItem.cmd.set(paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localSTServiceMonitItem.url.set(paramString2);
      }
      localSTServiceMonitItem.cost.set(paramInt2);
      localSTServiceMonitItem.src.set(1);
      ((WebSsoBody.STServiceMonitReq)localObject2).list.add(localSTServiceMonitItem);
      ((WebSSOAgent.UniSsoServerReq)localObject1).pbReqData.set(ByteStringMicro.copyFrom(((WebSsoBody.STServiceMonitReq)localObject2).toByteArray()));
      localObject2 = new NewIntent(this.app.getApp(), bhox.class);
      ((NewIntent)localObject2).putExtra("cmd", "apollo_dc_report.service_monit");
      ((NewIntent)localObject2).putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
      this.app.startServlet((NewIntent)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportApolloStoreStabilityData cmd: ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" url:");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(" errcode:");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" cost:");
        ((StringBuilder)localObject1).append(paramInt2);
        QLog.d(jdField_a_of_type_JavaLangString + "_apollo_store_stability_", 2, ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString + "_apollo_store_stability_", 1, "reportApolloStoreStabilityData failed ", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[doCMGameReq], cmd:" + paramString1 + ",reqData:" + paramString2 + ",luaR:" + paramLong + ", app: " + this.app);
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10.4875");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      if ("apollo_aio_game.report_user_track".equals(paramString1))
      {
        localObject = ApolloUtil.a(paramString2).toByteArray();
        byte[] arrayOfByte = paramString2.getBytes();
        if ((localObject != null) && (localObject.length > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "set pb data, orgByte:" + arrayOfByte.length + ",pbByte:" + localObject.length);
          }
          localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom((byte[])localObject));
        }
      }
      for (;;)
      {
        localObject = new NewIntent(this.app.getApp(), bhox.class);
        ((NewIntent)localObject).putExtra("usrdata", paramLong);
        ((NewIntent)localObject).putExtra("cmd", paramString1);
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("callFrom", paramInt);
        ((NewIntent)localObject).putExtra("isCMShowJSRequest", true);
        if (("apollo_aio_game.add_games_to_user_gamepanel".equals(paramString1)) || ("apollo_aio_game.del_games_from_user_gamepanel".equals(paramString1)) || ("apollo_aio_game.get_user_uin_or_openid".equals(paramString1)) || ("apollo_terminal_info.get_user_slaves_v2".equals(paramString1))) {
          ((NewIntent)localObject).putExtra("reqData", paramString2);
        }
        this.app.startServlet((NewIntent)localObject);
        return;
        localUniSsoServerReq.reqdata.set(paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "doCMGameReq failed ", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    try
    {
      a(paramString1, paramString2.getBytes("ISO8859_1"), paramBusinessObserver);
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[getGameStatusReq], cmd:" + paramString1 + ",reqData:" + paramString2 + ",extraInfo:" + paramString3);
    }
    try
    {
      WebSSOAgent.UniSsoServerReqComm localUniSsoServerReqComm = new WebSSOAgent.UniSsoServerReqComm();
      localUniSsoServerReqComm.platform.set(109L);
      localUniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
      localUniSsoServerReqComm.mqqver.set("8.4.10.4875");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
      localUniSsoServerReq.reqdata.set(paramString2);
      paramString2 = new NewIntent(this.app.getApp(), bhox.class);
      paramString2.putExtra("usrdata", paramString3);
      paramString2.putExtra("cmd", paramString1);
      paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getGameStatusReq failed ", paramString1);
    }
  }
  
  public void a(String paramString, ArrayList<bimv> paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("ColorNick", 1, "modifyTroopMemberCardInfoWithColorNick paragraphs is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColorNick", 2, "modifyTroopMemberCardInfoWithColorNick troopUin = " + paramString);
    }
    Oidb_0x8fc.ReqBody localReqBody = new Oidb_0x8fc.ReqBody();
    localReqBody.uint64_group_code.set(Long.parseLong(paramString));
    ArrayList localArrayList1 = new ArrayList();
    Oidb_0x8fc.MemberInfo localMemberInfo = new Oidb_0x8fc.MemberInfo();
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    localMemberInfo.uint64_uin.set(l);
    ArrayList localArrayList2 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      bimv localbimv = (bimv)localIterator.next();
      Oidb_0x8fc.RichCardNameElem localRichCardNameElem = new Oidb_0x8fc.RichCardNameElem();
      switch (localbimv.c)
      {
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNick", 2, "modifyTroopMemberCardInfoWithColorNick type = " + localbimv.c + " text = " + localbimv.jdField_a_of_type_JavaLangString);
        }
        localArrayList2.add(localRichCardNameElem);
        break;
        localRichCardNameElem.bytes_text.set(ByteStringMicro.copyFrom(localbimv.jdField_a_of_type_JavaLangString.getBytes()));
        localStringBuilder.append(localbimv.jdField_a_of_type_JavaLangString);
        continue;
        paramArrayList = localbimv.jdField_a_of_type_JavaLangString;
        paramString = paramArrayList;
        if (paramArrayList.substring(0, 1).equals("<")) {
          paramString = paramArrayList.substring(1);
        }
        paramArrayList = paramString;
        if (paramString.substring(paramString.length() - 1).equals(">")) {
          paramArrayList = paramString.substring(0, paramString.length() - 1);
        }
        localRichCardNameElem.bytes_ctrl.set(ByteStringMicro.copyFrom(paramArrayList.getBytes()));
      }
    }
    paramString = new Oidb_0x8fc.CommCardNameBuf();
    paramString.rpt_rich_card_name.set(localArrayList2);
    paramString.uint32_cool_id.set(paramInt);
    localMemberInfo.bytes_comm_rich_card_name.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
    localMemberInfo.member_card_name.set(ByteStringMicro.copyFrom(localStringBuilder.toString().getBytes()));
    localArrayList1.add(localMemberInfo);
    localReqBody.rpt_mem_level_info.set(localArrayList1);
    paramString = new Oidb_0x8fc.ClientInfo();
    paramString.uint32_implat.set(109);
    paramString.string_clientver.set(DeviceInfoUtil.getQQVersion());
    localReqBody.msg_client_info.set(paramString);
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2300);
    paramString.uint32_service_type.set(3);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramArrayList = new NewIntent(this.app.getApp(), bhox.class);
    paramArrayList.putExtra("cmd", "OidbSvc.0x8fc_3");
    paramArrayList.putExtra("data", paramString.toByteArray());
    this.app.startServlet(paramArrayList);
  }
  
  public void a(String paramString1, List<ApolloGameScoreData> paramList1, String paramString2, List<ApolloGameScoreData> paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "getApolloStandAction.");
    }
    if ((this.app == null) || (TextUtils.isEmpty(paramString1)) || (paramList1 == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[requestGameRank] uin is empty");
    }
    do
    {
      return;
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_router_game.game_relation_linkcmd_get_rank_chg");
        ((JSONObject)localObject).put("from", "android");
        ((JSONObject)localObject).put("aioType", 1);
        ((JSONObject)localObject).put("sessionId", Long.parseLong(paramString2));
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(a(paramString1, paramList1));
        localJSONArray.put(a(paramString2, paramList2));
        ((JSONObject)localObject).put("gScoreList", localJSONArray);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "requestGameRank request:" + localObject);
        }
        paramString1 = new NewIntent(this.app.getApp(), bhox.class);
        paramString1.putExtra("cmd", "apollo_router_game.game_relation_linkcmd_get_rank_chg");
        paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
        this.app.startServlet(paramString1);
        VipUtils.a(this.app, "cmshow", "Apollo", "get_rank_compare", 1, 0, new String[0]);
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "getApolloStandAction failed ", paramString1);
  }
  
  protected void a(String paramString, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    int i;
    if (a(paramUdcUinData.roam_flag_svip_5year)) {
      i = 5;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "onGetRoamType: " + i);
      }
      this.app.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0).edit().putInt("message_roam_flag" + paramString, i).commit();
      this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(114, true, new Object[] { paramString, Integer.valueOf(i) });
      return;
      if ((a(paramUdcUinData.roam_flag_svip_2year)) || (a(paramUdcUinData.roam_flag_svip_forever))) {
        i = 4;
      } else if (a(paramUdcUinData.roam_flag_vip_30day)) {
        i = 3;
      } else if (a(paramUdcUinData.roam_flag_qq_7day)) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, BusinessObserver paramBusinessObserver)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), bhox.class);
    Object localObject = new StringBuilder().append(paramString).append("_");
    long l = jdField_b_of_type_Long + 1L;
    jdField_b_of_type_Long = l;
    localObject = l;
    localNewIntent.putExtra("cmd", paramString);
    localNewIntent.putExtra("data", paramArrayOfByte);
    localNewIntent.putExtra("timeout", 30000L);
    localNewIntent.putExtra("__cmd_seq__", (String)localObject);
    this.jdField_a_of_type_JavaUtilHashMap.put(localObject, paramBusinessObserver);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(ArrayList<Long> paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramArrayList.removeAll(this.jdField_a_of_type_JavaUtilVector);
    Object localObject = paramArrayList;
    if (paramArrayList.size() > 1)
    {
      paramArrayList = new HashSet(paramArrayList);
      localObject = new ArrayList();
      ((ArrayList)localObject).addAll(paramArrayList);
    }
    this.jdField_a_of_type_JavaUtilVector.addAll((Collection)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getGetUserApolloDress uinList size: " + ((ArrayList)localObject).size() + ", queue size: " + this.jdField_a_of_type_JavaUtilVector.size() + ",from: " + paramString);
    }
    int i = 0;
    label132:
    if (i < ((ArrayList)localObject).size()) {
      if (i + 16 >= ((ArrayList)localObject).size()) {
        break label197;
      }
    }
    label197:
    for (int j = i + 16;; j = ((ArrayList)localObject).size())
    {
      a((Long[])new ArrayList(((ArrayList)localObject).subList(i, j)).toArray(new Long[0]), paramString);
      i += 16;
      break label132;
      break;
    }
  }
  
  public void a(List<String> paramList)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "[reportDislikeItem]");
    Object localObject;
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq;
    JSONObject localJSONObject1;
    JSONObject localJSONObject2;
    try
    {
      localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10.4875");
      localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      localJSONObject1 = new JSONObject();
      localJSONObject2 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localJSONArray.put((String)paramList.next());
      }
      localJSONObject2.put("op_item_id_list", localJSONArray);
    }
    catch (Exception paramList)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[reportDislikeItem] exception=", paramList);
      return;
    }
    localJSONObject1.put("req", localJSONObject2);
    ((JSONObject)localObject).put("12815", localJSONObject1);
    localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
    paramList = new NewIntent(this.app.getApp(), bhox.class);
    paramList.putExtra("cmd", "QQVacCommSvc.dislike");
    paramList.putExtra("data", localUniSsoServerReq.toByteArray());
    this.app.startServlet(paramList);
  }
  
  public void a(List<Integer> paramList, Bundle paramBundle)
  {
    for (;;)
    {
      try
      {
        if ((this.app == null) || (paramList == null) || (paramList.size() == 0))
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[getGameConfigListReq] app is null");
          return;
        }
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new STGameLogin.STGetGameConfReq();
        ((STGameLogin.STGetGameConfReq)localObject).game_id_list.set(paramList);
        ((STGameLogin.STGetGameConfReq)localObject).from.set("android");
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((STGameLogin.STGetGameConfReq)localObject).toByteArray()));
        boolean bool = ((amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER)).c(this.app.getCurrentUin());
        if (bool)
        {
          paramList = "apollo_aio_game.get_game_conf_info";
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "getGameConfigListReq isGameWhiteUser:", Boolean.valueOf(bool) });
          }
          localObject = new NewIntent(this.app.getApp(), bhox.class);
          ((NewIntent)localObject).putExtra("extras", paramBundle);
          ((NewIntent)localObject).putExtra("cmd", paramList);
          ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
          this.app.startServlet((NewIntent)localObject);
          return;
        }
      }
      catch (Exception paramList)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[getGameConfigListReq] exception=", paramList);
        return;
      }
      paramList = "apollo_game_login.get_game_conf_info";
    }
  }
  
  public void a(long... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "getApolloStandAction.");
    }
    if (paramVarArgs.length == 0) {}
    do
    {
      return;
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_terminal_info.get_user_appear_info");
        ((JSONObject)localObject).put("from", "android");
        JSONArray localJSONArray = new JSONArray();
        int i = 0;
        while (i < paramVarArgs.length)
        {
          localJSONArray.put(paramVarArgs[i]);
          i += 1;
        }
        ((JSONObject)localObject).put("touins", localJSONArray);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramVarArgs = new NewIntent(this.app.getApp(), bhox.class);
        paramVarArgs.putExtra("cmd", "apollo_terminal_info.get_user_appear_info");
        paramVarArgs.putExtra("data", localUniSsoServerReq.toByteArray());
        this.app.startServlet(paramVarArgs);
        return;
      }
      catch (Exception paramVarArgs) {}
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "getApolloStandAction failed ", paramVarArgs);
  }
  
  public void a(String[] paramArrayOfString)
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfString[i];
        try
        {
          long l = Long.parseLong(str);
          ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_vip_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_vip_level.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_status.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_apollo_timestamp.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_cmshow_3d_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_flag_super_yellow_diamond.set(1);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1515);
    localOIDBSSOPkg.uint32_service_type.set(15);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.app.getApp(), bhox.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x5eb_15");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("uins", paramArrayOfString);
    this.app.startServlet((NewIntent)localObject);
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    a(paramArrayOfString, paramArrayOfInt, 99);
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt)
  {
    int j = 0;
    Object localObject1 = new oidb_0x5eb.ReqBody();
    Object localObject2 = new ArrayList();
    int k = paramArrayOfString.length;
    int i = 0;
    while (i < k)
    {
      String str = paramArrayOfString[i];
      if (!((List)localObject2).contains(str)) {
        ((List)localObject2).add(str);
      }
      i += 1;
    }
    paramArrayOfString = (String[])((List)localObject2).toArray(new String[1]);
    k = paramArrayOfString.length;
    i = 0;
    for (;;)
    {
      if (i < k)
      {
        localObject2 = paramArrayOfString[i];
        try
        {
          long l = Long.parseLong((String)localObject2);
          ((oidb_0x5eb.ReqBody)localObject1).rpt_uint64_uins.add(Long.valueOf(l));
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
    }
    boolean bool2 = false;
    boolean bool1 = false;
    i = j;
    if (i < paramArrayOfInt.length)
    {
      switch (paramArrayOfInt[i])
      {
      }
      for (;;)
      {
        i += 1;
        break;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_font_id_flag.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_magicfont_flag.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_face_addon_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_bubble_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_colorring_flag.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_praise_flag.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_game_appid.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_game_last_login_time.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_voicebubble_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_plate_of_king_dan.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_plate_of_king_dan_display_switch.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_pendant_diy_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_suspend_effect_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_face_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vas_diy_font_timestamp_flag.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_font_effect_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_qq_7day.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_vip_30day.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_2year.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_5year.set(1);
        ((oidb_0x5eb.ReqBody)localObject1).roam_flag_svip_forever.set(1);
        bool1 = true;
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_qq_level_icon_type_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_theme_font_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_bubble_unread_switch.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_vip_ext_id.set(1);
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_req_listen_together_player_id.set(1);
        bool2 = true;
        continue;
        ((oidb_0x5eb.ReqBody)localObject1).uint32_c2c_aio_shortcut_switch.set(1);
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "batchGetStrangerVasInfo, uins: " + Arrays.toString(paramArrayOfString) + " fields: " + Arrays.toString(paramArrayOfInt));
    paramArrayOfInt = new oidb_sso.OIDBSSOPkg();
    paramArrayOfInt.uint32_command.set(1515);
    paramArrayOfInt.uint32_service_type.set(paramInt);
    paramArrayOfInt.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject1).toByteArray()));
    localObject1 = new NewIntent(this.app.getApp(), bhox.class);
    ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x5eb_99");
    ((NewIntent)localObject1).putExtra("data", paramArrayOfInt.toByteArray());
    ((NewIntent)localObject1).putExtra("req_roam_type", bool1);
    ((NewIntent)localObject1).putExtra("req_music_type", bool2);
    ((NewIntent)localObject1).putExtra("uins", paramArrayOfString);
    this.app.startServlet((NewIntent)localObject1);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = onq.a();
    if (localObject != null) {
      this.jdField_a_of_type_Long = ((SharedPreferences)localObject).getLong("last_jd_req", 0L);
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 7200000L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EcshopJd", 2, "failed redInterval return.");
      }
      return false;
    }
    localObject = new qqshop_act.SQQSHPActReadReq();
    ((qqshop_act.SQQSHPActReadReq)localObject).act_id.set(paramInt);
    NewIntent localNewIntent = new NewIntent(this.app.getApp(), bhox.class);
    localNewIntent.putExtra("cmd", "SQQShopActRead.GetActStatus");
    localNewIntent.putExtra("data", ((qqshop_act.SQQSHPActReadReq)localObject).toByteArray());
    localNewIntent.putExtra("timeout", 3000L);
    this.app.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.i("EcshopJd", 2, "jd check sent:" + paramInt);
    }
    return true;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      SCUpdatePB.SCUpdateReq localSCUpdateReq = new SCUpdatePB.SCUpdateReq();
      localSCUpdateReq.comm.plat.set(109);
      localSCUpdateReq.comm.qver.set(ByteStringMicro.copyFrom("8.4.10.4875".getBytes()));
      localSCUpdateReq.comm.osrelease.set(ByteStringMicro.copyFrom(String.valueOf(Build.VERSION.SDK_INT).getBytes()));
      localSCUpdateReq.comm.network.set(NetworkUtil.getNetworkType(this.app.getApplication()));
      localSCUpdateReq.comm.setHasFlag(true);
      paramString2 = new JSONObject(paramString2);
      if (paramString2.has("cookie")) {
        localSCUpdateReq.comm.cookie.set(paramString2.optLong("cookie"));
      }
      if (paramString2.has("force")) {
        localSCUpdateReq.comm.force.set(paramString2.optInt("force"));
      }
      long l1;
      int i;
      long l2;
      long l3;
      Object localObject;
      int j;
      SCUpdatePB.ItemVersion localItemVersion;
      for (;;)
      {
        if (!d.equals(paramString1)) {
          break label502;
        }
        localSCUpdateReq.cmd.set(1);
        l1 = paramString2.optLong("seq");
        i = paramString2.optInt("sync_mode");
        l2 = paramString2.optLong("plver");
        l3 = paramString2.optLong("rpver");
        localSCUpdateReq.req0x01.seq.set(l1);
        localSCUpdateReq.req0x01.sync_mode.set(i);
        localSCUpdateReq.req0x01.plver.set(l2);
        localSCUpdateReq.req0x01.rpver.set(l3);
        paramString1 = paramString2.optJSONArray("item_list");
        if (paramString1 == null) {
          break;
        }
        i = 0;
        while (i < paramString1.length())
        {
          localObject = paramString1.getJSONObject(i);
          j = ((JSONObject)localObject).optInt("bid");
          paramString2 = ((JSONObject)localObject).optString("scid");
          localObject = ((JSONObject)localObject).optString("version");
          localItemVersion = new SCUpdatePB.ItemVersion();
          localItemVersion.bid.set(j);
          localItemVersion.scid.set(paramString2);
          localItemVersion.version.set((String)localObject);
          localSCUpdateReq.req0x01.item_list.add(localItemVersion);
          i += 1;
        }
        localSCUpdateReq.comm.force.set(2);
      }
      label502:
      return false;
    }
    catch (Throwable paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = paramString1.getStackTrace();
        i = 0;
        while (i < paramString1.length)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, paramString1[i].toString());
          i += 1;
        }
        localSCUpdateReq.req0x01.setHasFlag(true);
        for (;;)
        {
          localSCUpdateReq.setHasFlag(true);
          paramString1 = new NewIntent(this.app.getApp(), bhox.class);
          paramString1.putExtra("cmd", "scupdate.handle");
          paramString1.putExtra("data", localSCUpdateReq.toByteArray());
          this.app.startServlet(paramString1);
          return true;
          if (f.equals(paramString1))
          {
            localSCUpdateReq.cmd.set(2);
            l1 = paramString2.optLong("delta_mode");
            l2 = paramString2.optLong("storage_mode");
            l3 = paramString2.optLong("compress_mode");
            paramString1 = paramString2.optString("from");
            localSCUpdateReq.comm.from.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
            localSCUpdateReq.req0x02.delta_mode.set((int)l1);
            localSCUpdateReq.req0x02.storage_mode.set((int)l2);
            localSCUpdateReq.req0x02.compress_mode.set((int)l3);
            paramString1 = paramString2.optJSONArray("item_list");
            if (paramString1 != null)
            {
              i = 0;
              while (i < paramString1.length())
              {
                localObject = paramString1.getJSONObject(i);
                j = ((JSONObject)localObject).optInt("bid");
                paramString2 = ((JSONObject)localObject).optString("scid");
                localObject = ((JSONObject)localObject).optString("srcMd5");
                localItemVersion = new SCUpdatePB.ItemVersion();
                localItemVersion.bid.set(j);
                localItemVersion.scid.set(paramString2);
                localItemVersion.version.set((String)localObject);
                localSCUpdateReq.req0x02.item_list.add(localItemVersion);
                i += 1;
              }
            }
            localSCUpdateReq.req0x02.setHasFlag(true);
          }
        }
      }
    }
  }
  
  public void b()
  {
    try
    {
      if (this.app == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[getApolloGameDevList] app is null");
        return;
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_aio_game.get_user_dev_gamelist");
      ((JSONObject)localObject).put("from", "android");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[getApolloGameDevList] " + ((JSONObject)localObject).toString());
      }
      localObject = new NewIntent(this.app.getApp(), bhox.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_aio_game.get_user_dev_gamelist");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getApolloGameDevList] exception=", localException);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.app == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getExploreInfo] app is null");
    }
    String str;
    long l;
    do
    {
      return;
      str = "cmshowar_message_plat.get_msg";
      if (amme.a(this.app, this.app.getCurrentUin()) != 2) {
        str = "apollo_interact.get_msg";
      }
      l = NetConnInfoCenter.getServerTime();
      if (paramInt != 1) {
        break;
      }
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_Int = this.app.getApp().getSharedPreferences("apollo_sp" + this.app.getCurrentUin(), 0).getInt("next_req_st_drawer", (int)l);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[getExploreInfo] exploreDrawerSt:" + this.jdField_a_of_type_Int + ",currentTime:" + l + "|" + paramInt);
      }
    } while (this.jdField_a_of_type_Int > l);
    do
    {
      try
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[getExploreInfo] cmd: " + str);
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new STExploreInfo.STGetMsgReq();
        ((STExploreInfo.STGetMsgReq)localObject).app_type.set(1);
        STExploreInfo.STEntryIdInfo localSTEntryIdInfo = new STExploreInfo.STEntryIdInfo();
        localSTEntryIdInfo.num.set(1);
        localSTEntryIdInfo.entry_id.set(paramInt);
        ((STExploreInfo.STGetMsgReq)localObject).eid_list.add(localSTEntryIdInfo);
        localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(((STExploreInfo.STGetMsgReq)localObject).toByteArray()));
        localObject = new NewIntent(this.app.getApp(), bhox.class);
        ((NewIntent)localObject).putExtra("cmd", str);
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        this.app.startServlet((NewIntent)localObject);
        return;
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, new Object[] { "[getExploreInfo] exception: ", localException.getMessage() });
        return;
      }
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_Int = this.app.getApp().getSharedPreferences("apollo_sp" + this.app.getCurrentUin(), 0).getInt("next_req_st_drawer_friend_card", (int)l);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[getExploreInfo] exploreFriendCardSt:" + this.jdField_b_of_type_Int + ",currentTime:" + l + "|" + paramInt);
      }
    } while (this.jdField_b_of_type_Int <= l);
  }
  
  public void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Long.valueOf(paramIntent.getLongExtra("msgSeq", 0L));
    arrayOfObject[1] = Boolean.valueOf(paramIntent.getBooleanExtra("fromBottom", true));
    String str = paramIntent.getStringExtra("msgId");
    paramIntent = paramIntent.getStringExtra("appId");
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGamePubAccountFeeds] ret=", paramFromServiceMsg.ret.get() + ",data:" + paramFromServiceMsg.rspdata.get() });
        }
        if (paramFromServiceMsg.ret.get() == 0L)
        {
          paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get());
          boolean bool2 = false;
          boolean bool1 = bool2;
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg = paramFromServiceMsg.optJSONObject("12787");
            bool1 = bool2;
            if (paramFromServiceMsg != null)
            {
              paramFromServiceMsg = paramFromServiceMsg.optJSONObject("data");
              bool1 = bool2;
              if (paramFromServiceMsg != null)
              {
                paramFromServiceMsg = paramFromServiceMsg.optJSONObject("rsp");
                bool1 = bool2;
                if (paramFromServiceMsg != null) {
                  bool1 = a(arrayOfObject, str, paramIntent, paramFromServiceMsg);
                }
              }
            }
          }
          if (!bool1) {
            notifyUI(29, false, arrayOfObject);
          }
        }
        return;
      }
      catch (Exception paramIntent)
      {
        notifyUI(29, false, arrayOfObject);
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGamePubAccountFeeds] err:" + paramIntent.getMessage());
        return;
      }
    }
    notifyUI(29, false, arrayOfObject);
  }
  
  public void b(bhot parambhot)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(parambhot);
      return;
    }
  }
  
  public void b(String paramString)
  {
    a(new String[] { paramString });
  }
  
  public void b(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArrayList localArrayList;
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bhot localbhot = (bhot)localIterator.next();
        if (localbhot.a(paramString, paramApolloBaseInfo)) {
          localArrayList.add(localbhot);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.removeAll(localArrayList);
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_motto.get_user_motto");
        if (!TextUtils.isEmpty(paramString2)) {
          break label249;
        }
        paramString2 = "android";
        ((JSONObject)localObject).put("from", paramString2);
        paramString2 = new JSONArray();
        paramString2.put(Long.parseLong(paramString1));
        ((JSONObject)localObject).put("uins", paramString2);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString2 = new NewIntent(this.app.getApp(), bhox.class);
        paramString2.putExtra("cmd", "apollo_motto.get_user_motto");
        paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
        this.app.startServlet(paramString2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getUserSignStr uin: " + paramString1);
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getUserSignStr failed ", paramString1);
      return;
      label249:
      paramString2 = "android." + paramString2;
    }
  }
  
  public void c()
  {
    try
    {
      if (this.app == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[getUsedAppList]");
        return;
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[getUsedAppList] " + ((JSONObject)localObject).toString());
      }
      localObject = new NewIntent(this.app.getApp(), bhox.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_game.apl_plus_d_linkcmd_get");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getUsedAppList] exception=", localException);
    }
  }
  
  public void c(int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "reportPadFaceShown");
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10.4875");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("uin", Long.parseLong(this.app.getCurrentAccountUin()));
      localJSONObject2.put("id", paramInt);
      localJSONObject2.put("qq_plat", 1);
      localJSONObject2.put("qq_version", "8.4.10.4875");
      localJSONObject1.put("req", localJSONObject2);
      ((JSONObject)localObject).put("12827", localJSONObject1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.app.getApp(), bhox.class);
      ((NewIntent)localObject).putExtra("cmd", "QQVacCommSvc.report_padface_shown");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[reportPadFaceShown] exception=", localException);
    }
  }
  
  public void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGetGameFriend] ret=", paramIntent.ret.get() + ",data:" + paramIntent.rspdata.get() });
        }
        if (paramIntent.ret.get() == 0L)
        {
          paramIntent = new JSONObject(paramIntent.rspdata.get());
          if (paramIntent == null) {
            break label414;
          }
          paramFromServiceMsg = paramIntent.optJSONObject("12825");
          paramIntent.optInt("ecode");
          if (paramFromServiceMsg == null) {
            break label414;
          }
          paramIntent = paramFromServiceMsg.optJSONObject("data");
          if (paramIntent == null) {
            break label414;
          }
          paramIntent = paramIntent.optJSONObject("rsp");
          if (paramIntent == null) {
            break label414;
          }
          paramIntent.optString("appid");
          paramIntent = paramIntent.optJSONArray("friend_list");
          paramFromServiceMsg = new ArrayList();
          i = 0;
          if (i < paramIntent.length())
          {
            paramArrayOfByte = new FeedsItemData.FriendInfo();
            paramArrayOfByte.icon = paramIntent.getJSONObject(i).optString("icon");
            paramArrayOfByte.name = paramIntent.getJSONObject(i).optString("name");
            paramArrayOfByte.uin = paramIntent.getJSONObject(i).optString("uin");
            paramArrayOfByte.loginTime = paramIntent.getJSONObject(i).optLong("login_time");
            paramArrayOfByte.partition = paramIntent.getJSONObject(i).optString("partition");
            paramArrayOfByte.roleName = paramIntent.getJSONObject(i).optString("role_name");
            paramArrayOfByte.jumpUrl = paramIntent.getJSONObject(i).optString("jump_url");
            paramFromServiceMsg.add(paramArrayOfByte);
            i += 1;
            continue;
          }
          notifyUI(31, true, paramFromServiceMsg);
          i = 1;
          if (i == 0) {
            notifyUI(31, false, null);
          }
        }
        return;
      }
      catch (Exception paramIntent)
      {
        notifyUI(31, false, null);
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGetGameFriend] err:" + paramIntent.getMessage());
        return;
      }
      notifyUI(31, false, null);
      return;
      label414:
      int i = 0;
    }
  }
  
  public void c(String paramString)
  {
    qqshop_code.SReq localSReq = new qqshop_code.SReq();
    localSReq.appid.set(100273020);
    localSReq.version.set(1);
    PBStringField localPBStringField = localSReq.redirect_uri;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    localPBStringField.set(str);
    paramString = new NewIntent(this.app.getApp(), bhox.class);
    paramString.putExtra("cmd", "SQQShopAuthCodeSvc.AuthCode");
    paramString.putExtra("data", localSReq.toByteArray());
    paramString.putExtra("timeout", 3000L);
    this.app.startServlet(paramString);
  }
  
  public void d()
  {
    try
    {
      if (this.app == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[requestApolloWhiteList] app is null");
        return;
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_router_game.apl_sq_wl_linkcmd_get_all");
      ((JSONObject)localObject).put("from", "android");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[requestApolloWhiteList] " + ((JSONObject)localObject).toString());
      }
      localObject = new NewIntent(this.app.getApp(), bhox.class);
      ((NewIntent)localObject).putExtra("cmd", "apollo_router_game.apl_sq_wl_linkcmd_get_all");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[requestApolloWhiteList] exception=", localException);
    }
  }
  
  public void d(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "sendKapuReportDownload sourceId:", Integer.valueOf(paramInt) });
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10.4875");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("actId", 1);
      ((JSONObject)localObject).put("sourceId", paramInt);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.app.getApp(), bhox.class);
      ((NewIntent)localObject).putExtra("cmd", "cmshowar_activity_template.report_user_source");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[sendKapuReportDownload] exception=", localException);
    }
  }
  
  public void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("touin");
    int i = paramIntent.getIntExtra("mask", 0);
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()) && (!TextUtils.isEmpty(str))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((QLog.isColorLevel()) && (paramIntent.rspdata.has())) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo ret: " + paramIntent.ret.get() + ", msg: " + paramIntent.rspdata.get() + ", touin:" + str + ", mask: " + i);
        }
        if (0L == paramIntent.ret.get())
        {
          boolean bool = a(str, paramIntent, i);
          if (!bool) {}
        }
        return;
      }
      catch (Exception paramIntent)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo failed", paramIntent);
        return;
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo fail ret: " + paramFromServiceMsg.getResultCode());
  }
  
  public void d(String paramString)
  {
    Object localObject1 = this.app.getCurrentAccountUin();
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramString))) {}
    Object localObject2;
    int i;
    do
    {
      return;
      localObject1 = "special_care_tip_show_" + (String)localObject1 + "_" + paramString;
      localObject2 = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      i = ((SharedPreferences)localObject2).getInt((String)localObject1, 0);
    } while (i == 0);
    ((SharedPreferences)localObject2).edit().remove((String)localObject1).commit();
    switch (i)
    {
    default: 
      QLog.e(jdField_a_of_type_JavaLangString, 1, "showIfHadSpecialCareTip have error type " + i);
      return;
    case 1: 
      localObject1 = this.app.getApp().getString(2131692946);
    }
    for (;;)
    {
      paramString = new avhz(paramString, paramString, (String)localObject1, 0, -5020, 2097156, bcrg.a());
      localObject2 = new Bundle();
      String str = anvx.a(2131715406);
      if (!TextUtils.isEmpty(str))
      {
        ((Bundle)localObject2).putInt("key_action", 21);
        ((Bundle)localObject2).putString("key_action_DATA", Integer.toString(i));
        int j = ((String)localObject1).lastIndexOf(str);
        if (j >= 0) {
          paramString.a(j, str.length() + j, (Bundle)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("reactive", 2, "showIfHadSpecialCareTip grayStr=" + (String)localObject1 + "spanPos=" + j + "iconName=" + str);
        }
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "Care", "CareTipShow", "", 1, 0, 0, null, Integer.toString(i), null);
      }
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).hasRead = 0;
      ((MessageForUniteGrayTip)localObject1).subType = 0;
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.app, paramString);
      avia.a(this.app, (MessageForUniteGrayTip)localObject1);
      return;
      localObject1 = this.app.getApp().getString(2131692949);
      continue;
      localObject1 = this.app.getApp().getString(2131692948);
      continue;
      localObject1 = this.app.getApp().getString(2131692945);
      continue;
      localObject1 = this.app.getApp().getString(2131692947);
      continue;
      localObject1 = this.app.getApp().getString(2131692944);
    }
  }
  
  public void e()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "getCmGameConnInfo");
    try
    {
      if (this.app == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[getCmGameConnInfo] app null");
        return;
      }
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.4.10");
      CmGameMsgTunnel.AddrDistribueReq localAddrDistribueReq = new CmGameMsgTunnel.AddrDistribueReq();
      localAddrDistribueReq.appid.set(2);
      localAddrDistribueReq.net_type.set(amwn.d());
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localUniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(localAddrDistribueReq.toByteArray()));
      localObject = new NewIntent(this.app.getApp(), bhox.class);
      ((NewIntent)localObject).putExtra("cmd", "ltgame_addr_distribute.get_iplist");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("timeout", 15000L);
      this.app.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getCmGameConnInfo] exception=", localException);
    }
  }
  
  public void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    int i = paramIntent.getIntExtra("actionId", 0);
    String str1 = paramIntent.getStringExtra("actionText");
    String str2 = paramIntent.getStringExtra("textType");
    String str3 = paramIntent.getStringExtra("optFrom");
    int j = paramIntent.getIntExtra("audioId", 0);
    float f1 = paramIntent.getFloatExtra("audioTime", 0.0F);
    int k = paramIntent.getIntExtra("isPlayDefultAudio", 0);
    paramIntent = new HashMap();
    paramIntent.put("id", i + "");
    paramIntent.put("actionText", str1);
    paramIntent.put("textType", str2);
    paramIntent.put("optFrom", str3);
    paramIntent.put("audioId", "" + j);
    paramIntent.put("audioTime", "" + f1);
    paramIntent.put("isPlayDefultAudio", "" + k);
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((QLog.isColorLevel()) && (paramFromServiceMsg.rspdata.has())) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleCheckActionAuth ret: " + paramFromServiceMsg.ret.get() + ", msg: " + paramFromServiceMsg.rspdata.get());
        }
        paramIntent.put("ret", paramFromServiceMsg.ret.get() + "");
        if (0L == paramFromServiceMsg.ret.get())
        {
          notifyUI(5, true, paramIntent);
          return;
        }
        paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get()).getJSONObject("data").getJSONObject("acresult");
        paramIntent.put("type", paramFromServiceMsg.optInt("type") + "");
        paramIntent.put("id", paramFromServiceMsg.optInt("id") + "");
        paramIntent.put("content", paramFromServiceMsg.optString("msg"));
        paramIntent.put("url", paramFromServiceMsg.optString("url"));
        notifyUI(5, false, paramIntent);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus failed ", paramFromServiceMsg);
        }
        paramIntent.put("ret", "-1");
        notifyUI(5, false, paramIntent);
        return;
      }
    }
    paramIntent.put("ret", paramFromServiceMsg.getResultCode() + "");
    notifyUI(5, false, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  public void e(String paramString)
  {
    String str1 = this.app.getCurrentAccountUin();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(paramString))) {}
    String str2;
    Object localObject2;
    int i;
    do
    {
      return;
      localObject1 = "hot_friend_new_boat_graytip_sp" + str1 + "_" + paramString;
      str2 = "hot_friend_new_boat_graytip_sp" + str1 + "_" + paramString + "_tips";
      localObject2 = this.app.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      i = ((SharedPreferences)localObject2).getInt((String)localObject1, 0);
      str1 = ((SharedPreferences)localObject2).getString(str2, "");
    } while (i == 0);
    ((SharedPreferences)localObject2).edit().remove((String)localObject1).remove(str2).commit();
    switch (i)
    {
    default: 
      QLog.e(jdField_a_of_type_JavaLangString, 1, "showIfHadNewBoatTips have error type " + i);
      return;
    }
    if (TextUtils.isEmpty(str1))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "showIfHadNewBoatTips grayStr null ");
      return;
    }
    if (str1.contains("gray_small_ship")) {}
    for (Object localObject1 = str1.replace("gray_small_ship", " ");; localObject1 = str1)
    {
      if (((String)localObject1).contains("gray_big_ship")) {
        localObject1 = ((String)localObject1).replace("gray_big_ship", " ");
      }
      for (;;)
      {
        paramString = new avhz(paramString, paramString, (String)localObject1, 0, -5020, 2097156, bcrg.a());
        if (!TextUtils.isEmpty(str1))
        {
          str1 = axlp.a(this.app, 12L, 1L);
          str2 = axlp.a(this.app, 12L, 2L);
          i = ((String)localObject1).lastIndexOf(str1);
          int j = ((String)localObject1).lastIndexOf(str2);
          localObject1 = new Bundle();
          localObject2 = new Bundle();
          if (i >= 0)
          {
            ((Bundle)localObject1).putString("image_resource", "gray_small_ship");
            paramString.a(i - 1, i, (Bundle)localObject1);
            ((Bundle)localObject2).putInt("key_action", 11);
            ((Bundle)localObject2).putString("key_action_DATA", str1);
            paramString.a(i, str1.length() + i, (Bundle)localObject2);
          }
          if (j >= 0)
          {
            ((Bundle)localObject1).putString("image_resource", "gray_big_ship");
            paramString.a(j - 1, j, (Bundle)localObject1);
            ((Bundle)localObject2).putInt("key_action", 11);
            ((Bundle)localObject2).putString("key_action_DATA", str2);
            paramString.a(j, str2.length() + j, (Bundle)localObject2);
          }
        }
        localObject1 = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject1).hasRead = 0;
        ((MessageForUniteGrayTip)localObject1).subType = 0;
        ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.app, paramString);
        avia.a(this.app, (MessageForUniteGrayTip)localObject1);
        return;
      }
    }
  }
  
  public void f()
  {
    a(new String[] { this.app.getCurrentAccountUin() }, new int[] { 45033 });
  }
  
  public void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleSetZanCount ret: " + paramIntent.ret.get());
        }
        if (0L == paramIntent.ret.get())
        {
          notifyUI(7, true, Integer.valueOf(new JSONObject(paramIntent.rspdata.get()).getJSONObject("data").optInt("zancount")));
          return;
        }
        notifyUI(7, false, Long.valueOf(paramIntent.ret.get()));
        return;
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus failed ", paramIntent);
        }
        notifyUI(7, false, Integer.valueOf(-1));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus fail ret: " + paramFromServiceMsg.getResultCode());
    }
    notifyUI(7, false, Integer.valueOf(paramFromServiceMsg.getResultCode()));
  }
  
  public void f(String paramString)
  {
    Object localObject = paramString;
    if (paramString == null)
    {
      paramString = "";
      localObject = paramString;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "content == null");
        localObject = paramString;
      }
    }
    paramString = new DiyEmotionPb.Filter_Req();
    paramString.cmd.set(1);
    DiyEmotionPb.Filter_Req_Comm localFilter_Req_Comm = new DiyEmotionPb.Filter_Req_Comm();
    localFilter_Req_Comm.platform.set(1L);
    localFilter_Req_Comm.mqqver.set("8.4.10");
    localFilter_Req_Comm.osver.set(Build.VERSION.RELEASE);
    DiyEmotionPb.Filter_Text_Req localFilter_Text_Req = new DiyEmotionPb.Filter_Text_Req();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    localFilter_Text_Req.text.set(localArrayList);
    paramString.comm.set(localFilter_Req_Comm);
    paramString.reqcmd_0x01.set(localFilter_Text_Req);
    if (this.app != null)
    {
      localObject = new NewIntent(this.app.getApp(), bhox.class);
      ((NewIntent)localObject).putExtra("cmd", "gxzbpublic.filter");
      ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
      ((NewIntent)localObject).putExtra("timeout", 30000L);
      jdField_c_of_type_Long = SystemClock.uptimeMillis();
      this.app.startServlet((NewIntent)localObject);
    }
  }
  
  protected void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramIntent = new SCUpdatePB.SCUpdateRsp();
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleQuickUpdate ret: " + paramIntent.ret.get());
        }
        l = 0L;
        if (paramIntent.comm.cookie.has()) {
          l = paramIntent.comm.cookie.get();
        }
        if (paramIntent.ret.get() == 0L)
        {
          Object localObject;
          if (paramIntent.cmd.get() == 1)
          {
            paramFromServiceMsg = new VasQuickUpdateManager.SyncVCRRsp();
            paramFromServiceMsg.cookie = l;
            paramFromServiceMsg.seq = paramIntent.rsp0x01.seq.get();
            paramFromServiceMsg.continueFlag = paramIntent.rsp0x01.continue_flag.get();
            paramFromServiceMsg.polltime = paramIntent.comm.polltime.get();
            paramFromServiceMsg.syncSwitch = paramIntent.rsp0x01.sync_switch.get();
            paramFromServiceMsg.environment = paramIntent.rsp0x01.environment.get();
            i = 0;
            while (i < paramIntent.rsp0x01.vcr_list.size())
            {
              paramArrayOfByte = (SCUpdatePB.VCR)paramIntent.rsp0x01.vcr_list.get(i);
              localObject = new VasQuickUpdateManager.VCR();
              ((VasQuickUpdateManager.VCR)localObject).set(paramArrayOfByte);
              paramFromServiceMsg.vcrList.add(localObject);
              i += 1;
            }
            paramFromServiceMsg.preload.ver = paramIntent.rsp0x01.preload.plver.get();
            paramFromServiceMsg.preload.setList(paramIntent.rsp0x01.preload.item_list);
            paramFromServiceMsg.report.ver = paramIntent.rsp0x01.report.rpver.get();
            paramFromServiceMsg.report.setList(paramIntent.rsp0x01.report.item_list);
            notifyUI(16, true, paramFromServiceMsg);
            return;
          }
          if (paramIntent.cmd.get() != 2) {
            return;
          }
          paramFromServiceMsg = new VasQuickUpdateManager.GetUrlRsp();
          paramFromServiceMsg.cookie = l;
          int i = 0;
          while (i < paramIntent.rsp0x02.update_list.size())
          {
            paramArrayOfByte = (SCUpdatePB.UpdateInfo)paramIntent.rsp0x02.update_list.get(i);
            localObject = new VasQuickUpdateManager.UpdateInfo();
            ((VasQuickUpdateManager.UpdateInfo)localObject).set(paramArrayOfByte, i);
            paramFromServiceMsg.updateList.add(localObject);
            i += 1;
          }
          notifyUI(17, true, paramFromServiceMsg);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        long l;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleQuickUpdate error: ", paramFromServiceMsg);
        paramFromServiceMsg = new VasQuickUpdateManager.QuickUpdateRsp();
        paramFromServiceMsg.ret = -1L;
        paramFromServiceMsg.cookie = 0L;
        if (paramIntent.cmd.get() == 1)
        {
          notifyUI(16, false, paramFromServiceMsg);
          return;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handleQuickUpdate result = " + paramIntent.ret.get() + "msg = " + paramIntent.msg.get());
          paramFromServiceMsg = new VasQuickUpdateManager.QuickUpdateRsp();
          paramFromServiceMsg.ret = paramIntent.ret.get();
          paramFromServiceMsg.cookie = l;
          if (paramIntent.cmd.get() == 1)
          {
            notifyUI(16, false, paramFromServiceMsg);
            return;
          }
          if (paramIntent.cmd.get() == 2) {
            notifyUI(17, false, paramFromServiceMsg);
          }
        }
        else if (paramIntent.cmd.get() == 2)
        {
          notifyUI(17, false, paramFromServiceMsg);
        }
      }
    }
  }
  
  public void h(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (0L == paramIntent.ret.get())
        {
          paramFromServiceMsg = new JSONObject(paramIntent.rspdata.get()).optJSONArray("data").optJSONObject(0);
          paramIntent = paramFromServiceMsg.optString("motto_content");
          paramFromServiceMsg = paramFromServiceMsg.optLong("uin") + "";
          paramArrayOfByte = (amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER);
          if (paramArrayOfByte != null)
          {
            ApolloBaseInfo localApolloBaseInfo = paramArrayOfByte.b(paramFromServiceMsg);
            if (localApolloBaseInfo != null)
            {
              localApolloBaseInfo.apolloSignStr = paramIntent;
              localApolloBaseInfo.apolloLocalSignTs = localApolloBaseInfo.apolloSignValidTS;
              paramArrayOfByte.a(localApolloBaseInfo);
            }
          }
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetSignStr uin: " + paramFromServiceMsg + ", sign: " + paramIntent);
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetSignStr err  ret: " + paramIntent.ret.get());
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleGetSignStr error", paramIntent);
        return;
      }
    } else if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetSignStr fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  void i(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramIntent = new qqshop_act.SQQSHPActRsp();
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        if (paramIntent != null) {
          notifyUI(13, true, paramIntent);
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        if ("jd red packet response:" + paramIntent == null) {}
        for (paramIntent = "-1";; paramIntent = "" + paramIntent.code.get())
        {
          QLog.i("EcshopJd", 2, paramIntent);
          return;
        }
        notifyUI(13, false, null);
      }
      catch (Exception paramIntent)
      {
        notifyUI(13, false, null);
        return;
      }
    }
    else
    {
      QLog.e("EcshopJd", 1, "rsp failed:" + paramFromServiceMsg.getBusinessFailCode());
    }
  }
  
  void j(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramIntent = onq.a();
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = new qqshop_act.SQQSHPActReadRsp();
      try
      {
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.code.get() == 0)) {
          notifyUI(14, true, null);
        }
        while (QLog.isColorLevel())
        {
          QLog.i("EcshopJd", 2, "jd check response:" + paramFromServiceMsg.code.get());
          return;
          notifyUI(14, false, null);
          paramIntent.edit().putLong("last_jd_req", System.currentTimeMillis()).commit();
        }
        paramIntent.edit().putLong("last_jd_req", System.currentTimeMillis() - 5400000L).commit();
      }
      catch (Exception paramFromServiceMsg)
      {
        paramIntent.edit().putLong("last_jd_req", System.currentTimeMillis()).commit();
        notifyUI(14, false, null);
        return;
      }
    }
    else
    {
      notifyUI(14, false, null);
      QLog.e("EcshopJd", 1, "rsp failed:" + paramFromServiceMsg.getBusinessFailCode());
    }
  }
  
  public void k(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (this.app == null) {}
    do
    {
      return;
      int j = 0;
      paramIntent = this.app.getHandler(Leba.class);
      qqshop_code.SRsp localSRsp = new qqshop_code.SRsp();
      int i = j;
      if (paramArrayOfByte != null)
      {
        i = j;
        if (!paramFromServiceMsg.isSuccess()) {}
      }
      try
      {
        localSRsp.mergeFrom(paramArrayOfByte);
        i = j;
        if (localSRsp != null)
        {
          i = j;
          if (localSRsp.ret_code.get() == 0)
          {
            if (paramIntent != null) {
              paramIntent.obtainMessage(1134008, localSRsp).sendToTarget();
            }
            i = 1;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          i = j;
        }
      }
    } while (i != 0);
    paramIntent.obtainMessage(1134007, localSRsp).sendToTarget();
  }
  
  public void l(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleGameStatusResp],data:" + paramArrayOfByte);
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {}
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new apollo_game_status.STGameStateMsgList();
        paramArrayOfByte.mergeFrom(paramFromServiceMsg.pbRsqData.get().toByteArray());
        paramIntent = paramIntent.getStringExtra("usrdata");
        ((amma)this.app.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a((int)paramFromServiceMsg.ret.get(), paramArrayOfByte.rpt_msg_list.get(), paramIntent);
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "handleGameStatusResp resp data is err.");
      return;
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->" + paramIntent.getMessage());
      }
    }
  }
  
  public void m(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleCMGameResp],data:" + paramArrayOfByte);
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {}
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        paramFromServiceMsg = new JSONObject(paramIntent.rspdata.get()).toString();
        paramIntent = paramFromServiceMsg;
        if (TextUtils.isEmpty(paramFromServiceMsg)) {
          paramIntent = "{}";
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleGetRedDotInfo] " + paramIntent);
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGetRedDotInfo] ");
    }
  }
  
  public void n(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleCMGameResp],data:" + paramArrayOfByte);
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {
      for (;;)
      {
        WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp;
        Object localObject;
        try
        {
          if (!paramFromServiceMsg.isSuccess()) {
            break;
          }
          localUniSsoServerRsp = new WebSSOAgent.UniSsoServerRsp();
          localUniSsoServerRsp.mergeFrom(paramArrayOfByte);
          paramArrayOfByte = new JSONObject(localUniSsoServerRsp.rspdata.get()).toString();
          paramFromServiceMsg = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte)) {
            paramFromServiceMsg = "{}";
          }
          long l = paramIntent.getLongExtra("usrdata", 0L);
          paramArrayOfByte = paramIntent.getStringExtra("cmd");
          int i = paramIntent.getIntExtra("callFrom", 0);
          localObject = (amma)this.app.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
          if (("apollo_aio_game.add_games_to_user_gamepanel".equals(paramArrayOfByte)) || ("apollo_aio_game.del_games_from_user_gamepanel".equals(paramArrayOfByte)))
          {
            ((amma)localObject).a(localUniSsoServerRsp.ret.get(), paramArrayOfByte, paramFromServiceMsg, paramIntent.getStringExtra("reqData"));
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "ret:" + localUniSsoServerRsp.ret.get() + ",data:" + paramFromServiceMsg + ",cmd:" + paramArrayOfByte);
            return;
          }
          if (i != 4) {
            break label312;
          }
          ApolloCmdChannel.getChannel(this.app).callbackFromRequest(l, (int)localUniSsoServerRsp.ret.get(), paramArrayOfByte, paramFromServiceMsg);
          continue;
          QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->" + paramIntent.getMessage());
        }
        catch (Exception paramIntent)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        return;
        label312:
        if ("apollo_terminal_info.get_user_slaves_v2".equals(paramArrayOfByte))
        {
          localObject = ((amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a();
          if (localObject != null) {
            ((amna)localObject).a(localUniSsoServerRsp.ret.get(), paramFromServiceMsg, paramIntent.getStringExtra("reqData"));
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "resp data is err.");
    }
    if ("apollo_aio_game.check_game_v2".equals("")) {
      notifyUI(21, false, null);
    }
  }
  
  public void o(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleApolloGameKey],data:" + paramArrayOfByte);
    }
    try
    {
      Object localObject;
      if (this.mApp != null)
      {
        localObject = this.mApp.getHandler(ChatActivity.class);
        if (localObject != null) {
          ((MqqHandler)localObject).obtainMessage(73).sendToTarget();
        }
      }
      if ((paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        int i = paramIntent.getIntExtra("gameId", 0);
        boolean bool = paramIntent.getBooleanExtra("isCreator", false);
        long l = paramIntent.getLongExtra("roomId", 0L);
        paramArrayOfByte = paramIntent.getStringExtra("from");
        localObject = paramIntent.getStringExtra("version");
        int j = paramIntent.getIntExtra("enter", 0);
        int k = paramIntent.getIntExtra("gameMode", 0);
        String str = paramIntent.getStringExtra("extendJson");
        int m = paramIntent.getIntExtra("src", 0);
        paramIntent = new Bundle();
        paramIntent.putInt("gameId", i);
        paramIntent.putBoolean("isCreator", bool);
        paramIntent.putLong("roomId", l);
        paramIntent.putString("from", paramArrayOfByte);
        paramIntent.putString("oldVersion", (String)localObject);
        paramIntent.putInt("gameMode", k);
        paramIntent.putInt("enter", j);
        paramIntent.putLong("retCode", paramFromServiceMsg.ret.get());
        paramIntent.putString("extendJson", str);
        paramIntent.putInt("src", m);
        paramIntent.putByteArray("data", paramFromServiceMsg.pbRsqData.get().toByteArray());
        notifyUI(21, true, paramIntent);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "ret:" + paramFromServiceMsg.ret.get());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "resp data is err.");
        }
        notifyUI(21, false, null);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->" + paramIntent.getMessage());
      }
      notifyUI(21, false, null);
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return bhow.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void p(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("handleGetStrangerVasInfo ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label152;
      }
    }
    label151:
    label152:
    for (int i = paramArrayOfByte.length;; i = -1)
    {
      QLog.d(str, 2, i);
      if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
      {
        try
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          if ((paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0))
          {
            a(paramIntent, paramFromServiceMsg);
            return;
          }
          notifyUI(66, false, null);
          return;
        }
        catch (Throwable paramIntent)
        {
          if (!QLog.isColorLevel()) {
            break label151;
          }
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "", paramIntent);
      }
      else
      {
        notifyUI(66, false, null);
      }
      return;
    }
  }
  
  void q(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()) || (this.app == null)) {
      return;
    }
    for (;;)
    {
      ArrayList localArrayList1;
      amme localamme;
      ArrayList localArrayList2;
      int i;
      JSONArray localJSONArray;
      JSONObject localJSONObject;
      int j;
      boolean bool;
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (paramIntent.ret.get() != 0L) {
          break;
        }
        paramArrayOfByte = paramIntent.rspdata.get();
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "handleApolloStandAction response:" + paramArrayOfByte);
        }
        paramIntent = amme.a();
        paramFromServiceMsg = paramIntent.edit();
        paramArrayOfByte = new JSONObject(paramArrayOfByte).getJSONArray("data");
        int m = paramArrayOfByte.length();
        localArrayList1 = new ArrayList();
        localamme = (amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER);
        localArrayList2 = new ArrayList();
        i = 0;
        if (i >= m) {
          break label745;
        }
        localObject2 = paramArrayOfByte.getJSONObject(i);
        localJSONArray = new JSONArray();
        localObject1 = ((JSONObject)localObject2).getString("uin");
        localJSONObject = new JSONObject(paramIntent.getString((String)localObject1, "{}"));
        localObject2 = ((JSONObject)localObject2).getJSONArray("action");
        localObject3 = localJSONObject.optJSONArray("action");
        int n = ((JSONArray)localObject2).length();
        localArrayList1.clear();
        j = 0;
        if (j >= n) {
          break label566;
        }
        int k = ((JSONArray)localObject2).getJSONObject(j).getInt("id");
        bool = a((JSONArray)localObject3, false, k, ((JSONArray)localObject2).getJSONObject(j).getLong("updateTs"));
        if (!ApolloUtil.a(k, 0))
        {
          if (!QLog.isColorLevel()) {
            break label760;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 2, "handleApolloStandAction download res first time.");
          break label760;
        }
        if (bool)
        {
          Object localObject4 = new ApolloActionData();
          ((ApolloActionData)localObject4).actionId = k;
          String str = ApolloUtil.a((ApolloActionData)localObject4, 5);
          localObject4 = ApolloUtil.a((ApolloActionData)localObject4, 4);
          Object localObject5 = new File((String)localObject4).getParentFile();
          if (((File)localObject5).exists())
          {
            localObject5 = ((File)localObject5).listFiles();
            if ((localObject5 != null) && (localObject5.length > 0))
            {
              int i1 = localObject5.length;
              k = 0;
              if (k < i1)
              {
                localObject5[k].delete();
                k += 1;
                continue;
              }
            }
          }
          anex.a(this.app, (String)localObject4, str);
        }
        if (!((JSONArray)localObject2).getJSONObject(j).has("actPlace")) {
          break label535;
        }
        k = ((JSONArray)localObject2).getJSONObject(j).getInt("actPlace");
        if (k == 1) {
          localArrayList1.add(((JSONArray)localObject2).getJSONObject(j));
        } else if (k == 2) {
          localJSONArray.put(((JSONArray)localObject2).getJSONObject(j));
        }
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleApolloStandAction ", paramIntent);
      return;
      label535:
      localArrayList1.add(((JSONArray)localObject2).getJSONObject(j));
      localJSONArray.put(((JSONArray)localObject2).getJSONObject(j));
      break label766;
      label566:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "uin:", localObject1, ",sort result:" + localArrayList1 });
      }
      Object localObject2 = new JSONArray();
      Object localObject3 = localArrayList1.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((JSONArray)localObject2).put((JSONObject)((Iterator)localObject3).next());
      }
      localJSONObject.put("action", localObject2);
      paramFromServiceMsg.putString((String)localObject1, localJSONObject.toString());
      Object localObject1 = localamme.b((String)localObject1);
      if (localObject1 != null)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("action", localJSONArray);
        ((ApolloBaseInfo)localObject1).appearAction = localJSONObject.toString();
        localArrayList2.add(localObject1);
        break label775;
        label745:
        paramFromServiceMsg.commit();
        localamme.b(localArrayList2);
        return;
        label760:
        bool = true;
        continue;
        label766:
        j += 1;
        continue;
      }
      label775:
      i += 1;
    }
  }
  
  public void r(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      return;
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "updateRankInfo handleGameRank response code:" + paramIntent.ret.get());
        }
        if ((paramIntent.ret.get() == 0L) && (this.app != null))
        {
          paramIntent = paramIntent.rspdata.get();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, " updateRankInfo handleGameRank response:" + paramIntent);
          }
          paramIntent = new JSONObject(paramIntent).optJSONObject("data");
          int i = paramIntent.optInt("gameNum");
          paramFromServiceMsg = ApolloGameUtil.a();
          if ((paramFromServiceMsg != null) && (i >= 0))
          {
            paramFromServiceMsg.edit().putInt("sp.score.num", i).apply();
            ApolloGameUtil.jdField_a_of_type_Int = i;
          }
          paramFromServiceMsg = paramIntent.optJSONArray("chgList");
          paramArrayOfByte = (ankc)this.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
          EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
          if ((paramArrayOfByte != null) && (localEntityManager != null))
          {
            a(paramIntent, paramFromServiceMsg, paramArrayOfByte, localEntityManager);
            a(paramIntent, paramArrayOfByte, localEntityManager);
            return;
          }
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameRank]", paramIntent);
        return;
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameRank] context is null");
  }
  
  public void s(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    int i = paramIntent.getIntExtra("id", 0);
    int j = paramIntent.getIntExtra("packageId", 0);
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()) && (i > 0)) {}
    for (;;)
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((QLog.isColorLevel()) && (paramIntent.rspdata.has())) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "handleBuyActionByGold ret: ", Long.valueOf(paramIntent.ret.get()), ", msg: ", paramIntent.rspdata.get() });
        }
        if (paramIntent.ret.get() != 0L) {
          break label396;
        }
        paramIntent = new JSONObject(paramIntent.rspdata.get()).getJSONObject("data");
        if ((paramIntent == null) || (this.app == null)) {
          break label396;
        }
        int k = paramIntent.optInt("isSuccBuy");
        int m = paramIntent.optInt("balance");
        paramIntent = ((amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a();
        if (paramIntent != null) {
          paramIntent.jdField_a_of_type_Int = m;
        }
        if (k != 1) {
          break label396;
        }
        paramIntent = (ankc)this.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
        paramFromServiceMsg = new ApolloObtainedActionData();
        paramFromServiceMsg.id = i;
        paramFromServiceMsg.beginTs = NetConnInfoCenter.getServerTime();
        paramFromServiceMsg.type = 0;
        paramFromServiceMsg.way = 4;
        paramIntent.a(paramFromServiceMsg);
        paramIntent = new Bundle();
        paramIntent.putInt("jumpPkdId", j);
        paramIntent.putInt("jumpActionId", i);
        notifyUI(9, true, paramIntent);
        paramIntent = new HashMap();
        paramIntent.put("APOLLO_POP_TYPE", "toast");
        paramIntent.put("tips", this.app.getApp().getString(2131690067));
        paramFromServiceMsg = this.app.getHandler(ChatActivity.class);
        if (paramFromServiceMsg == null) {
          break label402;
        }
        paramFromServiceMsg = paramFromServiceMsg.obtainMessage(45);
        paramFromServiceMsg.obj = paramIntent;
        paramFromServiceMsg.sendToTarget();
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleBuyActionByGold failed", paramIntent);
        return;
      }
      if (i == 0) {
        ApolloItemBuilder.a(anvx.a(2131715407), 1, BaseApplicationImpl.getContext());
      }
      return;
      label396:
      i = 0;
      continue;
      label402:
      i = 1;
    }
  }
  
  public void t(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleSaveGameListResult]");
    }
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleSaveGameListResult] data null or rsp failed");
      notifyUI(25, false, null);
    }
    for (;;)
    {
      return;
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSaveGameListResult] ret=", Long.valueOf(paramIntent.ret.get()) });
        }
        if (paramIntent.ret.get() == 0L)
        {
          paramIntent = paramIntent.rspdata.get();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSaveGameListResult] respData=", paramIntent });
          }
          paramIntent = new JSONObject(paramIntent).optJSONObject("data");
          if (paramIntent == null) {
            continue;
          }
          long l = paramIntent.optLong("timeStamp");
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleSaveGameListResult] last timeStamp : " + l);
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameOnlineCountRsp] exception=", paramIntent);
        return;
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleSaveGameListResult] ret : " + paramIntent.ret.get());
  }
  
  public void u(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handlePlusUsedAppListRsp]");
    }
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handlePlusUsedAppListRsp] ret=", Long.valueOf(paramIntent.ret.get()) });
      }
      if (paramIntent.ret.get() == 0L)
      {
        paramIntent = paramIntent.rspdata.get();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handlePlusUsedAppListRsp] respData=", paramIntent });
        }
        if (this.mApp != null)
        {
          paramFromServiceMsg = (UsedAppListManager)this.mApp.getManager(QQManagerFactory.USED_APP_LIST_MANAGER);
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.syncRoamUsedListFromSrv(paramIntent);
          }
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handlePlusUsedAppListRsp] exception=", paramIntent);
    }
  }
  
  public void v(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleApolloLoginReq]");
    }
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleApolloWhiteList] ret=", Long.valueOf(paramIntent.ret.get()) });
      }
      if (paramIntent.ret.get() == 0L)
      {
        paramIntent = paramIntent.rspdata.get();
        paramFromServiceMsg = new JSONObject(paramIntent).optJSONObject("data");
        if (paramFromServiceMsg != null)
        {
          int i = paramIntent.indexOf("bitmap\":");
          if (i >= 0)
          {
            int j = paramIntent.indexOf(",", i);
            if (j >= 0) {
              ThreadManagerV2.executeOnSubThread(new VasExtensionHandler.1(this, paramIntent.substring(i + 8, j), paramFromServiceMsg.optJSONArray("val_list")));
            }
          }
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramIntent, new Object[] { " handle err" });
    }
  }
  
  public void w(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    try
    {
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramIntent.mergeFrom(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleKapuReportDownload] ret=", Long.valueOf(paramIntent.ret.get()) });
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleKapuReportDownload] err:" + paramIntent.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasExtensionHandler
 * JD-Core Version:    0.7.0.1
 */