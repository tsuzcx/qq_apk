package com.tencent.mobileqq.vas;

import akpw;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.IndividPub.IndividPub.Platform_Comm_Req;
import com.tencent.IndividPub.IndividPub.expTips_Pull_Req;
import com.tencent.IndividPub.IndividPub.expTips_Pull_Rsp;
import com.tencent.IndividPub.IndividPub.expTips_Req;
import com.tencent.IndividPub.IndividPub.expTips_Rsp;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.pendant.PendantTipsInfo;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.ApolloGameRankData;
import com.tencent.mobileqq.data.ApolloGameScoreData;
import com.tencent.mobileqq.data.ApolloObtainedActionData;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
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
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.praise.praise_sso.TPraiseSsoReq;
import com.tencent.mobileqq.praise.praise_sso.TPraiseSsoRsp;
import com.tencent.mobileqq.praise.praise_sso.TSsoCmd0x1Req;
import com.tencent.mobileqq.praise.praise_sso.TSsoCmd0x1Rsp;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.like.PraiseManager.OnPraiseSetCallback;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig.EffectInfo;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.pb.apollo.GetTinyID.STTinyID2UserAccInfoRsp;
import com.tencent.pb.apollo.GetTinyID.STUserAccInfo;
import com.tencent.pb.apollo.STCommon.STBatchRsp;
import com.tencent.pb.apollo.STCommon.STRspItem;
import com.tencent.pb.apollo.STGameResUpdate.STGameUpdateInfoRsp;
import com.tencent.pb.apollousertrace.ApolloUserTrace.STUserTrackReq;
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
import com.tencent.qqavopensdk.PBuffer.SSOTunnelEvent;
import com.tencent.util.Pair;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.apollo_game_status.STGameStateMsgList;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
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
  public static String b;
  public static String c = "IndividPub.ExpTips";
  public static String d = "SyncVCRReq";
  public static String e = "SyncVCRRsp";
  public static String f = "GetUrlReq";
  public static String g = "GetUrlRsp";
  long jdField_a_of_type_Long = 0L;
  public Bundle a;
  public PraiseManager.OnPraiseSetCallback a;
  private Vector jdField_a_of_type_JavaUtilVector = new Vector();
  
  static
  {
    jdField_a_of_type_JavaLangString = "VasExtensionHandler";
    jdField_b_of_type_JavaLangString = "Addon.Set";
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
          break label515;
        }
        i = ((Integer)localHashMap.get(Integer.valueOf(16))).intValue();
        paramIntent = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        paramFromServiceMsg = paramIntent.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if ((paramFromServiceMsg == null) || ((paramFromServiceMsg.apolloAISwitch & 0x10) == i << 4)) {
          break label515;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSetUserFlagResponse] before update, apolloAISwitch=", Integer.toBinaryString(paramFromServiceMsg.apolloAISwitch) });
        }
        paramFromServiceMsg.apolloAISwitch = (paramFromServiceMsg.apolloAISwitch & 0xFFFFFFEF | paramFromServiceMsg.apolloAISwitch ^ 0x10);
        paramIntent.a(paramFromServiceMsg);
        if (!QLog.isColorLevel()) {
          break label515;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSetUserFlagResponse] after update, apolloAISwitch=", Integer.toBinaryString(paramFromServiceMsg.apolloAISwitch) });
      }
      catch (Exception paramIntent)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "[handleSetUserFlagResponse] exception=", paramIntent);
        a(22, false, localHashMap);
        return;
      }
      a(22, bool, localHashMap);
      return;
      boolean bool = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSetUserFlagResponse] failed, result code=", Integer.valueOf(paramFromServiceMsg.getResultCode()) });
      }
      a(22, false, null);
      return;
      label515:
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
          a(23, true, localBundle);
          return;
        }
        localBundle.putLong("result", l);
        localBundle.putString("msg", paramIntent);
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handlePokeAuthResp failed " + paramIntent);
      }
      catch (Exception paramIntent)
      {
        localBundle.putInt("result", -254);
        localBundle.putString("msg", "系统繁忙，请稍候重试");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handlePokeAuthResp failed ", paramIntent);
        continue;
      }
      a(23, false, localBundle);
      return;
      localBundle.putInt("result", -255);
      localBundle.putString("msg", "系统繁忙，请稍候重试");
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
      a(25, false, null);
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
        a(25, true, paramFromServiceMsg);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameOnlineCountRsp] exception=", paramIntent);
      return;
    }
    a(25, false, null);
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
          paramIntent = (TroopEnterEffectManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(230);
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
      paramArrayOfByte = new TroopEnterEffectConfig.EffectInfo();
      paramArrayOfByte.a(paramFromServiceMsg);
      paramIntent.a(paramArrayOfByte);
      paramIntent.a(paramFromServiceMsg);
      SharedPreUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
      a(26, true, null);
      return;
    }
    QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD getMyEffect rsp is null");
    return;
    label357:
    QLog.e("TroopEnterEffect", 1, "handleTroopEnterEffectCMD error cmd = " + l + " ret = " + paramFromServiceMsg.ret.get());
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2, JSONObject paramJSONObject)
  {
    if ((paramContext == null) || (paramAppInterface == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_icemsg_trans.send_ai_event");
        if (!TextUtils.isEmpty(paramString1)) {
          break label287;
        }
        paramString1 = "android";
        ((JSONObject)localObject).put("from", paramString1);
        paramString1 = new JSONObject();
        paramString1.put("eventType", paramInt);
        paramString1.put("eventName", paramString2);
        paramString1.put("args", paramJSONObject);
        ((JSONObject)localObject).put("eventData", paramString1);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramContext = new NewIntent(paramContext, VasExtensionServlet.class);
        paramContext.putExtra("cmd", "apollo_icemsg_trans.send_ai_event");
        paramContext.putExtra("data", localUniSsoServerReq.toByteArray());
        paramAppInterface.startServlet(paramContext);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "reportEventToMS eventType: " + paramInt + " eventName=" + paramString2 + " args:" + paramJSONObject);
        return;
      }
      catch (Exception paramContext) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "reportEventToMS failed ", paramContext);
      return;
      label287:
      paramString1 = "android." + paramString1;
    }
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit();
        paramObject.putInt("renewal_tail_tip_exit", i);
        paramObject.putInt("renewal_tail_action", j);
        paramObject.putString("renewal_tail_tip", paramIntent);
        paramObject.putString("renewal_tail_click_text", paramFromServiceMsg);
        paramObject.putString("renewal_tail_activity_url", paramFromServiceMsg);
        paramObject.putInt("renewal_tail_item_id", k);
        paramObject.commit();
        VasWebviewUtil.reportCommercialDrainage("", "aio_pay", "aio_preshow", "", 1, 0, 0, "", String.valueOf(i), "");
        paramIntent = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
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
  
  private void a(Long[] paramArrayOfLong, String paramString)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = "android";; paramString = "android." + paramString)
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("from", paramString);
        paramString = new JSONArray();
        int j = paramArrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          paramString.put(paramArrayOfLong[i].longValue());
          i += 1;
        }
      }
      ((JSONObject)localObject).put("uins", paramString);
      ((JSONObject)localObject).put("detail", 1);
      ((JSONObject)localObject).put("cmd", "apollo_core.get_avatar");
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
      paramString.putExtra("cmd", "apollo_core.get_avatar");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString.putExtra("uinArr", paramArrayOfLong);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString);
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
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          PraiseManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, j);
          if ((this.jdField_a_of_type_AndroidOsBundle == null) || (this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager$OnPraiseSetCallback == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager$OnPraiseSetCallback.a(i, j, paramIntent, this.jdField_a_of_type_AndroidOsBundle);
          this.jdField_a_of_type_AndroidOsBundle = null;
          this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager$OnPraiseSetCallback = null;
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
  
  private void x(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "; isSuccess: " + paramFromServiceMsg.isSuccess() + ", ret: " + paramFromServiceMsg.getResultCode());
    }
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
        if (0L == paramFromServiceMsg.ret.get())
        {
          paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get());
          if (paramFromServiceMsg == null) {
            continue;
          }
          ApolloManager localApolloManager = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
          ArrayList localArrayList = new ArrayList();
          JSONArray localJSONArray = paramFromServiceMsg.getJSONArray("data");
          i = 0;
          if (i < localJSONArray.length())
          {
            paramFromServiceMsg = (JSONObject)localJSONArray.opt(i);
            l1 = paramFromServiceMsg.optLong("uin");
            ApolloBaseInfo localApolloBaseInfo = localApolloManager.b(l1 + "");
            long l2 = paramFromServiceMsg.optLong("ts");
            paramArrayOfByte = paramFromServiceMsg.toString();
            paramFromServiceMsg = localApolloBaseInfo.getApolloDress();
            localApolloBaseInfo.setApolloDress(l2, paramArrayOfByte);
            paramArrayOfByte = localApolloBaseInfo.getApolloDress();
            if (paramFromServiceMsg == null)
            {
              paramFromServiceMsg = "";
              break label686;
              if ((!TextUtils.isEmpty(paramArrayOfByte)) && (!TextUtils.equals(paramFromServiceMsg, paramArrayOfByte)))
              {
                localApolloBaseInfo.apolloHistoryDress = paramFromServiceMsg;
                localApolloBaseInfo.appearAction = null;
                SpriteRscBuilder.a(String.valueOf(l1));
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "save history uin:" + l1 + ", dress: " + paramFromServiceMsg + ", new dres: " + paramArrayOfByte);
                }
              }
              localArrayList.add(localApolloBaseInfo);
              i += 1;
              continue;
            }
            paramFromServiceMsg = paramFromServiceMsg.a();
            break label686;
            paramArrayOfByte = paramArrayOfByte.a();
            continue;
          }
          if (localArrayList.size() > 0)
          {
            localApolloManager.b(localArrayList);
            ((ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(localArrayList);
          }
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        int i;
        long l1;
        int j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "", paramFromServiceMsg);
        continue;
      }
      paramIntent = (Long[])paramIntent.getExtras().get("uinArr");
      if (paramIntent != null)
      {
        j = paramIntent.length;
        i = 0;
        if (i < j)
        {
          l1 = paramIntent[i].longValue();
          this.jdField_a_of_type_JavaUtilVector.remove(Long.valueOf(l1));
          i += 1;
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
          paramFromServiceMsg = (Long[])paramIntent.getExtras().get("uinArr");
          j = paramFromServiceMsg.length;
          i = 0;
          if (i < j)
          {
            l1 = paramFromServiceMsg[i].longValue();
            QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress no dress info uin:" + l1);
            i += 1;
            continue;
          }
          continue;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress fail ret: " + paramFromServiceMsg.getResultCode());
          continue;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloDress done  mSendingQueue size: " + this.jdField_a_of_type_JavaUtilVector.size());
      }
      return;
      label686:
      if (paramArrayOfByte == null) {
        paramArrayOfByte = "";
      }
    }
  }
  
  private void y(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("handleGetApolloBaseInfo ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label626;
      }
    }
    label626:
    for (int i = paramArrayOfByte.length;; i = -1)
    {
      QLog.d((String)localObject1, 2, i);
      if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {}
      do
      {
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
            localObject1 = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
            i = 0;
            while (i < paramIntent.rpt_msg_uin_data.size())
            {
              localObject2 = (oidb_0x5eb.UdcUinData)paramIntent.rpt_msg_uin_data.get(i);
              ApolloBaseInfo localApolloBaseInfo = ((ApolloManager)localObject1).b(((oidb_0x5eb.UdcUinData)localObject2).uint64_uin.get() + "");
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
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetApolloBaseInfo uin: " + localApolloBaseInfo.uin + ",apollo vipFlag: " + localApolloBaseInfo.apolloVipFlag + ", apollo status: " + localApolloBaseInfo.apolloStatus + ", apollo level: " + localApolloBaseInfo.apolloVipLevel + ", svr TS: " + localApolloBaseInfo.apolloServerTS);
              }
              if (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS) {
                paramFromServiceMsg.add(Long.valueOf(((oidb_0x5eb.UdcUinData)localObject2).uint64_uin.get()));
              }
              localApolloBaseInfo.apolloUpdateTime = NetConnInfoCenter.getServerTime();
              paramArrayOfByte.add(localApolloBaseInfo);
              i += 1;
            }
            ((ApolloManager)localObject1).b(paramArrayOfByte);
            a(paramFromServiceMsg, "AIO");
          }
          return;
        }
        catch (Throwable paramIntent)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d(jdField_a_of_type_JavaLangString, 2, "", paramIntent);
          return;
        }
        paramIntent = paramIntent.getStringArrayExtra("uins");
      } while (paramIntent == null);
      paramFromServiceMsg = new ArrayList(paramIntent.length);
      int j = paramIntent.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfByte = paramIntent[i];
        localObject1 = ((ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(paramArrayOfByte);
        if ((localObject1 != null) && (((ApolloBaseInfo)localObject1).apolloLocalTS != ((ApolloBaseInfo)localObject1).apolloServerTS)) {
          paramFromServiceMsg.add(Long.valueOf(Long.parseLong(paramArrayOfByte)));
        }
        i += 1;
      }
      a(paramFromServiceMsg, "AIOPanel");
      return;
    }
  }
  
  private void z(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
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
            paramFromServiceMsg.jdField_a_of_type_Long = l;
            paramFromServiceMsg.jdField_c_of_type_Long = paramIntent.rsp0x01.seq.get();
            paramFromServiceMsg.jdField_a_of_type_Int = paramIntent.rsp0x01.continue_flag.get();
            paramFromServiceMsg.jdField_b_of_type_Int = paramIntent.comm.polltime.get();
            paramFromServiceMsg.jdField_c_of_type_Int = paramIntent.rsp0x01.sync_switch.get();
            i = 0;
            while (i < paramIntent.rsp0x01.vcr_list.size())
            {
              paramArrayOfByte = (SCUpdatePB.VCR)paramIntent.rsp0x01.vcr_list.get(i);
              localObject = new VasQuickUpdateManager.VCR();
              ((VasQuickUpdateManager.VCR)localObject).a(paramArrayOfByte);
              paramFromServiceMsg.jdField_a_of_type_JavaUtilList.add(localObject);
              i += 1;
            }
            paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$SCPreloadOrReport.jdField_a_of_type_Long = paramIntent.rsp0x01.preload.plver.get();
            paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$SCPreloadOrReport.a(paramIntent.rsp0x01.preload.item_list);
            paramFromServiceMsg.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$SCPreloadOrReport.jdField_a_of_type_Long = paramIntent.rsp0x01.report.rpver.get();
            paramFromServiceMsg.jdField_b_of_type_ComTencentMobileqqVasVasQuickUpdateManager$SCPreloadOrReport.a(paramIntent.rsp0x01.report.item_list);
            a(16, true, paramFromServiceMsg);
            return;
          }
          if (paramIntent.cmd.get() != 2) {
            return;
          }
          paramFromServiceMsg = new VasQuickUpdateManager.GetUrlRsp();
          paramFromServiceMsg.jdField_a_of_type_Long = l;
          int i = 0;
          while (i < paramIntent.rsp0x02.update_list.size())
          {
            paramArrayOfByte = (SCUpdatePB.UpdateInfo)paramIntent.rsp0x02.update_list.get(i);
            localObject = new VasQuickUpdateManager.UpdateInfo();
            ((VasQuickUpdateManager.UpdateInfo)localObject).a(paramArrayOfByte, i);
            paramFromServiceMsg.jdField_a_of_type_JavaUtilList.add(localObject);
            i += 1;
          }
          a(17, true, paramFromServiceMsg);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        long l;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleQuickUpdate error: ", paramFromServiceMsg);
        paramFromServiceMsg = new akpw();
        paramFromServiceMsg.b = -1L;
        paramFromServiceMsg.jdField_a_of_type_Long = 0L;
        if (paramIntent.cmd.get() == 1)
        {
          a(16, false, paramFromServiceMsg);
          return;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handleQuickUpdate result = " + paramIntent.ret.get() + "msg = " + paramIntent.msg.get());
          paramFromServiceMsg = new akpw();
          paramFromServiceMsg.b = paramIntent.ret.get();
          paramFromServiceMsg.jdField_a_of_type_Long = l;
          if (paramIntent.cmd.get() == 1)
          {
            a(16, false, paramFromServiceMsg);
            return;
          }
          if (paramIntent.cmd.get() == 2) {
            a(17, false, paramFromServiceMsg);
          }
        }
        else if (paramIntent.cmd.get() == 2)
        {
          a(17, false, paramFromServiceMsg);
        }
      }
    }
  }
  
  protected Class a()
  {
    return VasExtensionObserver.class;
  }
  
  public JSONObject a(String paramString, List paramList)
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
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestExpireInfo, from=" + paramInt);
    }
    IndividPub.expTips_Req localexpTips_Req = new IndividPub.expTips_Req();
    Object localObject = new IndividPub.Platform_Comm_Req();
    ((IndividPub.Platform_Comm_Req)localObject).platForm.set(109L);
    ((IndividPub.Platform_Comm_Req)localObject).osver.set(Build.VERSION.RELEASE);
    ((IndividPub.Platform_Comm_Req)localObject).mqqver.set("7.6.8.3615");
    localexpTips_Req.comm.set((MessageMicro)localObject);
    localexpTips_Req.cmd.set(1);
    localexpTips_Req.setHasFlag(true);
    localObject = new IndividPub.expTips_Pull_Req();
    ((IndividPub.expTips_Pull_Req)localObject).from.set(paramInt);
    localexpTips_Req.reqcmd_0x01.set((MessageMicro)localObject);
    localObject = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
    ((NewIntent)localObject).putExtra("cmd", c);
    ((NewIntent)localObject).putExtra("data", localexpTips_Req.toByteArray());
    ((NewIntent)localObject).putExtra("from", paramInt);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    int j = 0;
    try
    {
      i = NetworkUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
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
    ((qqshop_act.SQQSHPUsrInfo)localObject).carriertype.set(EcShopAssistantManager.b());
    ((qqshop_act.SQQSHPUsrInfo)localObject).net_type.set(i);
    ((qqshop_act.SQQSHPUsrInfo)localObject).src.set(EcShopAssistantManager.a(paramInt2));
    ((qqshop_act.SQQSHPUsrInfo)localObject).src_idx.set(j);
    paramString.act_id.set(paramInt1);
    paramString.usr_info.set((MessageMicro)localObject);
    localObject = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "SQQShopAct.ReqAct");
    ((NewIntent)localObject).putExtra("data", paramString.toByteArray());
    ((NewIntent)localObject).putExtra("timeout", 3000L);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("EcshopJd", 2, "jd red packet sent.");
    }
  }
  
  public void a(int paramInt, Bundle paramBundle, PraiseManager.OnPraiseSetCallback paramOnPraiseSetCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "requestPraiseAuth, praiseId=" + paramInt);
    }
    Object localObject = new praise_sso.TSsoCmd0x1Req();
    ((praise_sso.TSsoCmd0x1Req)localObject).i32_itemId.set(paramInt);
    praise_sso.TPraiseSsoReq localTPraiseSsoReq = new praise_sso.TPraiseSsoReq();
    localTPraiseSsoReq.i32_cmd.set(1);
    localTPraiseSsoReq.i32_implat.set(109);
    localTPraiseSsoReq.str_qq_ver.set("7.6.8.3615");
    localTPraiseSsoReq.st_cmd0x1_req.set((MessageMicro)localObject);
    localObject = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "Praise.sso");
    ((NewIntent)localObject).putExtra("data", localTPraiseSsoReq.toByteArray());
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqProfileLikePraiseManager$OnPraiseSetCallback = paramOnPraiseSetCallback;
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void a(int paramInt, String paramString)
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
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_core.set_status");
        if (!TextUtils.isEmpty(paramString)) {
          break label211;
        }
        paramString = "android";
        ((JSONObject)localObject).put("from", paramString);
        ((JSONObject)localObject).put("status", paramInt);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
        paramString.putExtra("cmd", "apollo_core.set_status");
        paramString.putExtra("data", localUniSsoServerReq.toByteArray());
        paramString.putExtra("apollo_status", paramInt);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString);
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "changeApolloStatus failed ", paramString);
      return;
      label211:
      paramString = "android." + paramString;
    }
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("id", paramInt1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "vaspoke.check");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("timeout", 20000);
      ((NewIntent)localObject).putExtra("id", paramInt1);
      ((NewIntent)localObject).putExtra("name", paramString1);
      ((NewIntent)localObject).putExtra("minVersion", paramString2);
      ((NewIntent)localObject).putExtra("feeType", paramInt2);
      ((NewIntent)localObject).putExtra("fromType", paramInt3);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handlePokeAuth failed ", paramString1);
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_icemsg_trans.set_content");
      if (TextUtils.isEmpty(paramString2)) {}
      for (paramString2 = "android";; paramString2 = "android." + paramString2)
      {
        ((JSONObject)localObject).put("from", paramString2);
        ((JSONObject)localObject).put("msg_type", paramInt);
        ((JSONObject)localObject).put("str_content", paramString1);
        ((JSONObject)localObject).put("seq", 0);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString2 = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
        paramString2.putExtra("cmd", "apollo_icemsg_trans.set_content");
        paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "sendMsgToAI type: " + paramInt + " content" + paramString1);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "sendMsgToAI failed ", paramString1);
      }
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, float paramFloat, int paramInt3, String paramString3)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
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
        localObject = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
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
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("cmd", "apollo_aio_game.get_playing_usernum");
      ((JSONObject)localObject).put("from", paramString1);
      ((JSONObject)localObject).put("gameId", paramInt1);
      ((JSONObject)localObject).put("opType", paramInt2);
      ((JSONObject)localObject).put("theme", paramString2);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramString1 = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
      paramString1.putExtra("cmd", "apollo_aio_game.get_playing_usernum");
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString1.putExtra("tipsBarAnimation", paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getGameOnlineUserCount] exception=", paramString1);
    }
  }
  
  public void a(int paramInt, HashMap paramHashMap)
  {
    Object localObject1;
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq;
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[getApolloLoginData] app is null");
        return;
      }
      localObject1 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject1).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject1).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject1).mqqver.set("7.6.8");
      localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject1);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("cmd", "apollo_game_login.req");
      ((JSONObject)localObject1).put("from", "android");
      ((JSONObject)localObject1).put("mask", paramInt);
      if (paramHashMap != null)
      {
        Iterator localIterator = paramHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject2 = paramHashMap.get(str);
          if (localObject2 != null) {
            ((JSONObject)localObject1).put(str, localObject2);
          }
        }
      }
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject1).toString());
    }
    catch (Exception paramHashMap)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getGameOnlineUserCount] exception=", paramHashMap);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[getApolloLoginData] " + ((JSONObject)localObject1).toString());
    }
    paramHashMap = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
    paramHashMap.putExtra("cmd", "apollo_game_login.req");
    paramHashMap.putExtra("mask", paramInt);
    paramHashMap.putExtra("data", localUniSsoServerReq.toByteArray());
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramHashMap);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
    localNewIntent.putExtra("cmd", jdField_b_of_type_JavaLangString);
    localNewIntent.putExtra("pendantId", paramLong);
    localNewIntent.putExtra("seriesId", paramInt1);
    localNewIntent.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    PendantMarket.SetAddonReq localSetAddonReq = new PendantMarket.SetAddonReq();
    localSetAddonReq.cmd.set(2);
    localSetAddonReq.int_platform.set(2);
    localSetAddonReq.long_addon_id.set(paramLong);
    localSetAddonReq.str_qq_version.set("7.6.8");
    if (paramInt2 != -1) {
      localSetAddonReq.int_from_type.set(paramInt2);
    }
    localNewIntent.putExtra("data", localSetAddonReq.toByteArray());
    localNewIntent.putExtra("timeout", 30000);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    group_effect_commu.ReqBody localReqBody = new group_effect_commu.ReqBody();
    localReqBody.u64_cmd.set(paramLong1);
    localReqBody.u64_uin.set(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localReqBody.i32_implat.set(109);
    localReqBody.str_version.set(DeviceInfoUtil.d());
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
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), VasExtensionServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "Groupeffect.commop");
      ((NewIntent)localObject).putExtra("data", localReqBody.toByteArray());
      ((NewIntent)localObject).putExtra("usrdata", paramLong1);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
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
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("cmd");
    boolean bool = paramIntent.getBooleanExtra("isCMShowJSRequest", false);
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      if (bool)
      {
        o(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if (str.equals(jdField_b_of_type_JavaLangString))
      {
        a(paramIntent, paramArrayOfByte);
        return;
      }
      if ("apollo_core.get_avatar".equals(str))
      {
        x(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_core.set_status".equals(str))
      {
        b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_core.get_user_info".equals(str))
      {
        c(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_core.check_act".equals(str))
      {
        d(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("OidbSvc.0x5eb_15".equals(str))
      {
        y(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_extend.zan".equals(str))
      {
        e(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_extend.set_user_flag".equals(str))
      {
        A(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if (c.equals(str))
      {
        a(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("scupdate.handle".equals(str))
      {
        z(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_motto.get_user_motto".equals(str))
      {
        f(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_motto.get_user_weather".equals(str))
      {
        g(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("SQQShopAct.ReqAct".equals(str))
      {
        h(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("SQQShopActRead.GetActStatus".equals(str))
      {
        i(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("SQQShopAuthCodeSvc.AuthCode".equals(str))
      {
        j(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_icemsg_trans.set_content".equals(str))
      {
        k(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_icemsg_trans.set_ai_status".equals(str))
      {
        l(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_aio_game.check_game_v2".equals(str))
      {
        p(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_aio_game.get_game_room_state".equals(str))
      {
        m(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("OidbSvc.0x5eb_99".equals(str))
      {
        q(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("Praise.sso".equals(str))
      {
        b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("vaspoke.check".equals(str))
      {
        B(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_terminal_info.get_user_appear_info".equals(str))
      {
        r(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_cmd_batch.cmd_001".equals(str))
      {
        t(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_aio_game.get_playing_usernum".equals(str))
      {
        C(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_game_av.join_av_room".equals(str))
      {
        a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_game_av.get_av_ctrl_param".equals(str))
      {
        a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_game_av.get_usraccinfo".equals(str))
      {
        a(str, paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_currency.buy_item_by_curre".equals(str))
      {
        u(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_red_dot.get_reddot_info".equals(str))
      {
        n(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_router_game.game_relation_linkcmd_get_rank_chg".equals(str))
      {
        s(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_aio_game.save_user_gamepanel_gamelist".equals(str))
      {
        v(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("Groupeffect.commop".equals(str))
      {
        D(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("apollo_game_login.req".equals(str))
      {
        w(paramIntent, paramFromServiceMsg, paramArrayOfByte);
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
        break label571;
      }
      if (!paramArrayOfByte.tips_info.has()) {
        break label368;
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
            paramIntent = "温馨提示";
          }
          ((PendantTipsInfo)localObject3).titleWording = paramIntent;
          ((PendantTipsInfo)localObject3).wording = ((PendantMarket.TipsInfo)localObject2).wording.get();
          localObject1 = ((PendantMarket.TipsInfo)localObject2).right_btn_wording.get();
          paramIntent = (Intent)localObject1;
          if (((String)localObject1).equals("")) {
            paramIntent = "立即开通";
          }
          ((PendantTipsInfo)localObject3).rightBtnWording = paramIntent;
          localObject1 = ((PendantMarket.TipsInfo)localObject2).left_btn_wording.get();
          paramIntent = (Intent)localObject1;
          if (((String)localObject1).equals("")) {
            paramIntent = "取消";
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
          label368:
          QLog.e(jdField_a_of_type_JavaLangString, 1, "handlePendantAuthRsp tipsInfo.mergeFrom e=" + paramIntent);
        }
        if (!paramArrayOfByte.str_msg.has()) {
          break label557;
        }
      }
      if (!QLog.isColorLevel()) {
        break label400;
      }
      QLog.e("VasExtensionHandler", 2, "response from server error: " + i);
      label400:
      localBundle.putInt("result", i);
      switch (i)
      {
      case 1002: 
      case 1004: 
      case 2001: 
      case 2002: 
      default: 
        a(1, false, localBundle);
        return;
      }
      paramIntent = paramArrayOfByte.str_msg.get();
      label518:
      if (!paramArrayOfByte.str_url.has()) {
        break label564;
      }
      label557:
      label564:
      for (paramArrayOfByte = paramArrayOfByte.str_url.get();; paramArrayOfByte = "")
      {
        localBundle.putString("tips", paramIntent);
        localBundle.putString("url", paramArrayOfByte);
        break;
        paramIntent = "";
        break label518;
      }
      label571:
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label671;
      }
      localObject2 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      Object localObject3 = paramIntent.getStringExtra("uin");
      localObject1 = ((FriendsManager)localObject2).a((String)localObject3);
      paramArrayOfByte = (byte[])localObject1;
      if (localObject1 != null) {
        break label632;
      }
      paramArrayOfByte = new ExtensionInfo();
      paramArrayOfByte.uin = ((String)localObject3);
      label632:
      paramArrayOfByte.pendantId = paramIntent.getLongExtra("pendantId", -1L);
      paramArrayOfByte.pendantDiyId = paramIntent.getIntExtra("pendantDiyId", 0);
      paramArrayOfByte.timestamp = System.currentTimeMillis();
      ((FriendsManager)localObject2).a(paramArrayOfByte);
      label671:
      a(1, true, localBundle);
    }
    if (paramArrayOfByte == null) {
      return;
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
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
      paramArrayOfInt = new NewIntent(paramQQAppInterface.getApp(), VasExtensionServlet.class);
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
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
      a(localArrayList, paramString);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramString = "special_care_tip_show_" + (String)localObject + "_" + paramString;
    localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
    ((SharedPreferences.Editor)localObject).putInt(paramString, paramInt);
    ((SharedPreferences.Editor)localObject).commit();
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
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
      localObject = ((TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      StringBuilder localStringBuilder = new StringBuilder().append("skey=");
      paramString = (String)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramString = "";
      }
      localJSONObject.put("Cookie", paramString);
      localUniSsoServerReq.reqdata.set(localJSONObject.toString());
      paramString = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
      paramString.putExtra("cmd", "apollo_currency.buy_item_by_curre");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      paramString.putExtra("id", paramInt1);
      paramString.putExtra("packageId", paramInt2);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleBuyActionByGold] exception=", paramString);
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
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
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
        localObject = ((TicketManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        StringBuilder localStringBuilder = new StringBuilder().append("skey=");
        paramString2 = (String)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramString2 = "";
        }
        localJSONObject.put("Cookie", paramString2);
        localUniSsoServerReq.reqdata.set(localJSONObject.toString());
        paramString2 = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
        paramString2.putExtra("cmd", "apollo_core.get_user_info");
        paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
        paramString2.putExtra("touin", paramString1);
        paramString2.putExtra("mask", i);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString2);
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
    Object localObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Card localCard = ((FriendsManager)localObject).a(paramString);
    localObject = ((FriendsManager)localObject).c(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(paramString)))
    {
      SharedPreferences.Editor localEditor = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_plate_of_king", 0).edit();
      String str = "plate_of_king_display_switch_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c();
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
        break label326;
      }
    }
    label326:
    for (boolean bool1 = true;; bool1 = false)
    {
      localCard.namePlateOfKingDanDisplatSwitch = bool1;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, localCard);
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
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, paramString);
      }
      return;
      bool1 = false;
      break;
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
        SSOTunnelEvent.a().a(l, false, null);
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
        SSOTunnelEvent.a().a(l, true, paramString);
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
          SSOTunnelEvent.a().a(l, false, null);
          return;
        }
        paramString = new WebSSOAgent.UniSsoServerRsp();
        paramIntent = new qqavopensdkSsoTunnel.STAVCtrlParamRsp();
        try
        {
          paramString.mergeFrom(paramArrayOfByte);
          paramIntent.mergeFrom(paramString.pbRsqData.get().toByteArray());
          paramString = ((qqavopensdkSsoTunnel.STAVCtrlParamRsp)paramIntent.get()).ctrlParam.get().toByteArray();
          SSOTunnelEvent.a().a(l, true, paramString);
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
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
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
        paramString1 = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
        paramString1.putExtra("cmd", "apollo_extend.zan");
        paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
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
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[doCMGameReq], cmd:" + paramString1 + ",reqData:" + paramString2 + ",luaR:" + paramLong + ", app: " + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8.3615");
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
        localObject = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
        ((NewIntent)localObject).putExtra("usrdata", paramLong);
        ((NewIntent)localObject).putExtra("cmd", paramString1);
        ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
        ((NewIntent)localObject).putExtra("callFrom", paramInt);
        ((NewIntent)localObject).putExtra("isCMShowJSRequest", true);
        if (("apollo_aio_game.add_games_to_user_gamepanel".equals(paramString1)) || ("apollo_aio_game.del_games_from_user_gamepanel".equals(paramString1)) || ("apollo_aio_game.get_user_uin_or_openid".equals(paramString1)) || ("apollo_terminal_info.get_user_slaves_v2".equals(paramString1))) {
          ((NewIntent)localObject).putExtra("reqData", paramString2);
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
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
      localUniSsoServerReqComm.mqqver.set("7.6.8.3615");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set(localUniSsoServerReqComm);
      localUniSsoServerReq.reqdata.set(paramString2);
      paramString2 = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
      paramString2.putExtra("usrdata", paramString3);
      paramString2.putExtra("cmd", paramString1);
      paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "getGameStatusReq failed ", paramString1);
    }
  }
  
  public void a(String paramString1, List paramList1, String paramString2, List paramList2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "getApolloStandAction.");
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (paramList1 == null)) {
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
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
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
        paramString1 = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
        paramString1.putExtra("cmd", "apollo_router_game.game_relation_linkcmd_get_rank_chg");
        paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
        VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "get_rank_compare", 1, 0, new String[0]);
        return;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.e(jdField_a_of_type_JavaLangString, 2, "getApolloStandAction failed ", paramString1);
  }
  
  public void a(ArrayList paramArrayList, String paramString)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    paramArrayList.removeAll(this.jdField_a_of_type_JavaUtilVector);
    this.jdField_a_of_type_JavaUtilVector.addAll(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getGetUserApolloDress uinList size: " + paramArrayList.size() + ", queue size: " + this.jdField_a_of_type_JavaUtilVector.size() + ",from: " + paramString);
    }
    int i = 0;
    label94:
    if (i < paramArrayList.size()) {
      if (i + 16 >= paramArrayList.size()) {
        break label156;
      }
    }
    label156:
    for (int j = i + 16;; j = paramArrayList.size())
    {
      a((Long[])new ArrayList(paramArrayList.subList(i, j)).toArray(new Long[0]), paramString);
      i += 16;
      break label94;
      break;
    }
  }
  
  /* Error */
  public void a(java.util.Map paramMap)
  {
    // Byte code:
    //   0: new 444	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReqComm
    //   3: dup
    //   4: invokespecial 445	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReqComm:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: getfield 448	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReqComm:platform	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   14: ldc2_w 449
    //   17: invokevirtual 454	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   20: aload 5
    //   22: getfield 457	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReqComm:osver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   25: getstatic 462	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   28: invokevirtual 464	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   31: aload 5
    //   33: getfield 467	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReqComm:mqqver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   36: ldc_w 469
    //   39: invokevirtual 464	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   42: new 87	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReq
    //   45: dup
    //   46: invokespecial 88	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReq:<init>	()V
    //   49: astore 4
    //   51: aload 4
    //   53: getfield 473	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReq:comm	Lcom/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReqComm;
    //   56: aload 5
    //   58: invokevirtual 476	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReqComm:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   61: new 1940	com/tencent/pb/apollo/STCommon$STBatchReq
    //   64: dup
    //   65: invokespecial 1941	com/tencent/pb/apollo/STCommon$STBatchReq:<init>	()V
    //   68: astore 5
    //   70: new 1943	com/tencent/pb/apollo/STCommon$STReqItem
    //   73: dup
    //   74: invokespecial 1944	com/tencent/pb/apollo/STCommon$STReqItem:<init>	()V
    //   77: astore 6
    //   79: aload 6
    //   81: getfield 1947	com/tencent/pb/apollo/STCommon$STReqItem:strCmd	Lcom/tencent/mobileqq/pb/PBStringField;
    //   84: ldc_w 1949
    //   87: invokevirtual 464	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   90: aload 6
    //   92: getfield 1952	com/tencent/pb/apollo/STCommon$STReqItem:protoType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   95: iconst_1
    //   96: invokevirtual 1144	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   99: new 1954	com/tencent/pb/apollo/STGameResUpdate$STGameUpdateInfoReq
    //   102: dup
    //   103: invokespecial 1955	com/tencent/pb/apollo/STGameResUpdate$STGameUpdateInfoReq:<init>	()V
    //   106: astore 7
    //   108: new 752	java/util/ArrayList
    //   111: dup
    //   112: invokespecial 753	java/util/ArrayList:<init>	()V
    //   115: astore 8
    //   117: aload_1
    //   118: ifnull +136 -> 254
    //   121: aload_1
    //   122: invokeinterface 1960 1 0
    //   127: invokeinterface 1332 1 0
    //   132: astore_1
    //   133: aload_1
    //   134: invokeinterface 1098 1 0
    //   139: ifeq +115 -> 254
    //   142: aload_1
    //   143: invokeinterface 1102 1 0
    //   148: checkcast 1962	java/util/Map$Entry
    //   151: astore 10
    //   153: new 1964	com/tencent/pb/apollo/STGameResUpdate$STGameVerInfoIn
    //   156: dup
    //   157: invokespecial 1965	com/tencent/pb/apollo/STGameResUpdate$STGameVerInfoIn:<init>	()V
    //   160: astore 9
    //   162: aload 9
    //   164: getfield 1967	com/tencent/pb/apollo/STGameResUpdate$STGameVerInfoIn:gameId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   167: aload 10
    //   169: invokeinterface 1970 1 0
    //   174: checkcast 135	java/lang/Integer
    //   177: invokevirtual 192	java/lang/Integer:intValue	()I
    //   180: invokevirtual 1144	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   183: aload 10
    //   185: invokeinterface 1973 1 0
    //   190: checkcast 645	java/lang/String
    //   193: invokestatic 1979	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   196: fstore_2
    //   197: fload_2
    //   198: f2i
    //   199: istore_3
    //   200: aload 9
    //   202: getfield 1982	com/tencent/pb/apollo/STGameResUpdate$STGameVerInfoIn:localResVer	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   205: iload_3
    //   206: invokevirtual 1144	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   209: aload 8
    //   211: aload 9
    //   213: invokeinterface 1011 2 0
    //   218: pop
    //   219: goto -86 -> 133
    //   222: astore_1
    //   223: getstatic 22	com/tencent/mobileqq/vas/VasExtensionHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   226: iconst_1
    //   227: ldc_w 1984
    //   230: aload_1
    //   231: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   234: return
    //   235: astore 10
    //   237: getstatic 22	com/tencent/mobileqq/vas/VasExtensionHandler:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   240: iconst_1
    //   241: ldc_w 1986
    //   244: aload 10
    //   246: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   249: iconst_0
    //   250: istore_3
    //   251: goto -51 -> 200
    //   254: aload 7
    //   256: getfield 1988	com/tencent/pb/apollo/STGameResUpdate$STGameUpdateInfoReq:from	Lcom/tencent/mobileqq/pb/PBStringField;
    //   259: ldc_w 492
    //   262: invokevirtual 464	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   265: aload 7
    //   267: getfield 1991	com/tencent/pb/apollo/STGameResUpdate$STGameUpdateInfoReq:gvInfoList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   270: aload 8
    //   272: invokevirtual 1993	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   275: aload 6
    //   277: getfield 1996	com/tencent/pb/apollo/STCommon$STReqItem:reqPbData	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   280: aload 7
    //   282: invokevirtual 1997	com/tencent/pb/apollo/STGameResUpdate$STGameUpdateInfoReq:toByteArray	()[B
    //   285: invokestatic 1859	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   288: invokevirtual 1862	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   291: aload 5
    //   293: getfield 2000	com/tencent/pb/apollo/STCommon$STBatchReq:reqItems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   296: iconst_1
    //   297: anewarray 1943	com/tencent/pb/apollo/STCommon$STReqItem
    //   300: dup
    //   301: iconst_0
    //   302: aload 6
    //   304: aastore
    //   305: invokestatic 2006	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   308: invokevirtual 1993	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   311: aload 4
    //   313: getfield 1855	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReq:pbReqData	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   316: aload 5
    //   318: invokevirtual 2007	com/tencent/pb/apollo/STCommon$STBatchReq:toByteArray	()[B
    //   321: invokestatic 1859	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   324: invokevirtual 1862	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   327: new 508	mqq/app/NewIntent
    //   330: dup
    //   331: aload_0
    //   332: getfield 195	com/tencent/mobileqq/vas/VasExtensionHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   335: invokevirtual 602	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   338: ldc_w 510
    //   341: invokespecial 513	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   344: astore_1
    //   345: aload_1
    //   346: ldc_w 479
    //   349: ldc_w 1495
    //   352: invokevirtual 517	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   355: pop
    //   356: aload_1
    //   357: ldc 79
    //   359: aload 4
    //   361: invokevirtual 521	com/tencent/pb/webssoagent/WebSSOAgent$UniSsoServerReq:toByteArray	()[B
    //   364: invokevirtual 524	mqq/app/NewIntent:putExtra	(Ljava/lang/String;[B)Landroid/content/Intent;
    //   367: pop
    //   368: aload_0
    //   369: getfield 195	com/tencent/mobileqq/vas/VasExtensionHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   372: aload_1
    //   373: invokevirtual 693	com/tencent/mobileqq/app/QQAppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   376: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	VasExtensionHandler
    //   0	377	1	paramMap	java.util.Map
    //   196	2	2	f1	float
    //   199	52	3	i	int
    //   49	311	4	localUniSsoServerReq	WebSSOAgent.UniSsoServerReq
    //   7	310	5	localObject	Object
    //   77	226	6	localSTReqItem	com.tencent.pb.apollo.STCommon.STReqItem
    //   106	175	7	localSTGameUpdateInfoReq	com.tencent.pb.apollo.STGameResUpdate.STGameUpdateInfoReq
    //   115	156	8	localArrayList	ArrayList
    //   160	52	9	localSTGameVerInfoIn	com.tencent.pb.apollo.STGameResUpdate.STGameVerInfoIn
    //   151	33	10	localEntry	java.util.Map.Entry
    //   235	10	10	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	117	222	java/lang/Exception
    //   121	133	222	java/lang/Exception
    //   133	183	222	java/lang/Exception
    //   200	219	222	java/lang/Exception
    //   237	249	222	java/lang/Exception
    //   254	376	222	java/lang/Exception
    //   183	197	235	java/lang/Exception
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
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
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
        paramVarArgs = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
        paramVarArgs.putExtra("cmd", "apollo_terminal_info.get_user_appear_info");
        paramVarArgs.putExtra("data", localUniSsoServerReq.toByteArray());
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramVarArgs);
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
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1515);
    localOIDBSSOPkg.uint32_service_type.set(15);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x5eb_15");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).putExtra("uins", paramArrayOfString);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public void a(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int k = 0;
    Object localObject1 = new oidb_0x5eb.ReqBody();
    Object localObject2 = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (!((List)localObject2).contains(str)) {
        ((List)localObject2).add(str);
      }
      i += 1;
    }
    paramArrayOfString = (String[])((List)localObject2).toArray(new String[1]);
    int m = paramArrayOfString.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i < m)
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
    if (j < paramArrayOfInt.length)
    {
      switch (paramArrayOfInt[j])
      {
      }
      for (;;)
      {
        j += 1;
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
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "batchGetStrangerVasInfo, uins: " + Arrays.toString(paramArrayOfString) + " fields: " + Arrays.toString(paramArrayOfInt));
    paramArrayOfInt = new oidb_sso.OIDBSSOPkg();
    paramArrayOfInt.uint32_command.set(1515);
    paramArrayOfInt.uint32_service_type.set(99);
    paramArrayOfInt.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject1).toByteArray()));
    localObject1 = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
    ((NewIntent)localObject1).putExtra("cmd", "OidbSvc.0x5eb_99");
    ((NewIntent)localObject1).putExtra("data", paramArrayOfInt.toByteArray());
    ((NewIntent)localObject1).putExtra("uins", paramArrayOfString);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject1);
  }
  
  public boolean a(int paramInt)
  {
    Object localObject = EcShopAssistantManager.a();
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
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
    localNewIntent.putExtra("cmd", "SQQShopActRead.GetActStatus");
    localNewIntent.putExtra("data", ((qqshop_act.SQQSHPActReadReq)localObject).toByteArray());
    localNewIntent.putExtra("timeout", 3000L);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
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
      localSCUpdateReq.comm.qver.set(ByteStringMicro.copyFrom("7.6.8.3615".getBytes()));
      localSCUpdateReq.comm.osrelease.set(ByteStringMicro.copyFrom(String.valueOf(Build.VERSION.SDK_INT).getBytes()));
      localSCUpdateReq.comm.network.set(NetworkUtil.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()));
      localSCUpdateReq.comm.setHasFlag(true);
      paramString2 = new JSONObject(paramString2);
      if (paramString2.has("cookie")) {
        localSCUpdateReq.comm.cookie.set(paramString2.optLong("cookie"));
      }
      long l1;
      int i;
      long l2;
      long l3;
      Object localObject;
      int j;
      SCUpdatePB.ItemVersion localItemVersion;
      if (d.equals(paramString1))
      {
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
        if (paramString1 != null)
        {
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
        }
        localSCUpdateReq.req0x01.setHasFlag(true);
      }
      for (;;)
      {
        localSCUpdateReq.setHasFlag(true);
        paramString1 = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
        paramString1.putExtra("cmd", "scupdate.handle");
        paramString1.putExtra("data", localSCUpdateReq.toByteArray());
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString1);
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
      return false;
    }
    catch (Exception paramString1)
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
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
      a(1, new VasExtensionHandler.1(this));
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("cmd", "apollo_icemsg_trans.set_ai_status");
        if (!TextUtils.isEmpty(paramString)) {
          break label229;
        }
        paramString = "android";
        ((JSONObject)localObject).put("from", paramString);
        ((JSONObject)localObject).put("status", paramInt);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
        paramString = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
        paramString.putExtra("cmd", "apollo_icemsg_trans.set_ai_status");
        paramString.putExtra("data", localUniSsoServerReq.toByteArray());
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "changeAISwith status: " + paramInt);
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "changeAISwith failed ", paramString);
      return;
      label229:
      paramString = "android." + paramString;
    }
  }
  
  public void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        int i = paramIntent.getIntExtra("apollo_status", 0);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus ret: " + paramFromServiceMsg.ret.get() + ", apollo status:" + i);
        }
        paramIntent = new Pair(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(), Integer.valueOf(i));
        if (0L != paramFromServiceMsg.ret.get()) {
          break label198;
        }
        if (i != 0)
        {
          paramFromServiceMsg = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
          paramArrayOfByte = paramFromServiceMsg.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c());
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte.apolloStatus = i;
            paramFromServiceMsg.a(paramArrayOfByte);
          }
          a(3, true, paramIntent);
          return;
        }
        a(3, false, paramIntent);
        return;
      }
      catch (Exception paramIntent)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus failed ", paramIntent);
      return;
      label198:
      a(3, false, paramIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  public void b(String paramString)
  {
    a(new String[] { paramString });
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
        ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("7.6.8");
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
        paramString2 = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
        paramString2.putExtra("cmd", "apollo_motto.get_user_motto");
        paramString2.putExtra("data", localUniSsoServerReq.toByteArray());
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString2);
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
  
  public void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Object localObject1 = paramIntent.getStringExtra("touin");
    int i = paramIntent.getIntExtra("mask", 0);
    int j;
    int k;
    Object localObject4;
    int m;
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((QLog.isColorLevel()) && (paramIntent.rspdata.has())) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo ret: " + paramIntent.ret.get() + ", msg: " + paramIntent.rspdata.get() + ", touin:" + (String)localObject1 + ", mask: " + i);
        }
        if (0L != paramIntent.ret.get()) {
          break label1382;
        }
        paramIntent = new JSONObject(paramIntent.rspdata.get()).getJSONObject("data");
        if ((paramIntent == null) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label1382;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo apollo data: " + paramIntent.toString());
        }
        paramFromServiceMsg = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        if (paramFromServiceMsg == null) {
          break label1382;
        }
        paramArrayOfByte = paramFromServiceMsg.b((String)localObject1);
        j = 0;
        i = j;
        if (paramIntent.has("vip"))
        {
          k = paramIntent.getInt("vip");
          i = j;
          if (k != paramArrayOfByte.apolloVipFlag)
          {
            paramArrayOfByte.apolloVipFlag = k;
            i = 1;
          }
        }
        j = i;
        if (paramIntent.has("viplevel"))
        {
          k = paramIntent.getInt("viplevel");
          j = i;
          if (k != paramArrayOfByte.apolloVipLevel)
          {
            paramArrayOfByte.apolloVipLevel = k;
            j = 1;
          }
        }
        if (!paramIntent.has("userstatus")) {
          break label1362;
        }
        i = paramIntent.getInt("userstatus");
        if (i == paramArrayOfByte.apolloStatus) {
          break label1362;
        }
        paramArrayOfByte.apolloStatus = i;
        j = 1;
        if (!paramIntent.has("actlist")) {
          break label1099;
        }
        localObject2 = paramIntent.getJSONArray("actlist");
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGetUserApolloInfo] user action list=", localObject2 });
        }
        localObject1 = new HashMap(((JSONArray)localObject2).length());
        localObject4 = new JSONArray();
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = new Bundle();
          localObject5 = ((JSONArray)localObject2).getJSONObject(i);
          k = ((JSONObject)localObject5).optInt("id");
          ((Bundle)localObject3).putLong("beginTs", ((JSONObject)localObject5).optLong("beginTs"));
          ((Bundle)localObject3).putLong("endts", ((JSONObject)localObject5).optLong("endts"));
          m = ((JSONObject)localObject5).optInt("way");
          ((Bundle)localObject3).putInt("way", m);
          ((Bundle)localObject3).putInt("slaveActId", ((JSONObject)localObject5).optInt("slaveActId"));
          if (k == 0) {
            break label1365;
          }
          ((HashMap)localObject1).put(Integer.valueOf(k), localObject3);
          break label1365;
          label572:
          ((JSONObject)localObject5).put("type", k);
          ((JSONArray)localObject4).put(localObject5);
          i += 1;
        }
        if (((HashMap)localObject1).size() <= 0) {
          break label1107;
        }
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
          return;
        }
        localObject3 = (ApolloManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(152);
        if (localObject3 != null) {
          ((ApolloManager)localObject3).a = ((HashMap)localObject1);
        }
        localObject2 = (ApolloDaoManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(154);
        if (localObject2 == null) {
          break label1382;
        }
        ((ApolloDaoManager)localObject2).a((JSONArray)localObject4);
        Object localObject5 = ((ApolloDaoManager)localObject2).a(1);
        localObject4 = ((ApolloDaoManager)localObject2).b();
        k = 0;
        i = 0;
        if (localObject5 == null) {
          break label1392;
        }
        k = 0;
        label698:
        if (k < ((List)localObject5).size())
        {
          ApolloActionData localApolloActionData = (ApolloActionData)((List)localObject5).get(k);
          if (!((HashMap)localObject1).containsKey(Integer.valueOf(localApolloActionData.actionId))) {
            break label1383;
          }
          Bundle localBundle = (Bundle)((HashMap)localObject1).get(Integer.valueOf(localApolloActionData.actionId));
          if (localObject3 != null) {
            ((ApolloManager)localObject3).a(localApolloActionData, localBundle);
          }
          m = 1;
          i = m;
          if (!QLog.isColorLevel()) {
            break label1383;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo update actlist id: " + localApolloActionData.actionId);
          i = m;
          break label1383;
        }
        k = i;
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
          break label1392;
        }
        k = i;
        if (localObject2 == null) {
          break label1392;
        }
        k = i;
        if (i == 0) {
          break label1392;
        }
        ((ApolloDaoManager)localObject2).b((List)localObject5);
        k = i;
      }
      catch (Exception paramIntent)
      {
        Object localObject2;
        Object localObject3;
        label866:
        int n;
        if (!QLog.isColorLevel()) {
          break label1382;
        }
      }
      if (m < ((List)localObject4).size())
      {
        localObject3 = (ApolloActionData)((List)localObject4).get(m);
        if (!((HashMap)localObject1).containsKey(Integer.valueOf(((ApolloActionData)localObject3).actionId))) {
          break label1406;
        }
        ((ApolloActionData)localObject3).isShow = 1;
        n = 1;
        i = n;
        if (!QLog.isColorLevel()) {
          break label1406;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGetUserApolloInfo] set user action ", Integer.valueOf(((ApolloActionData)localObject3).actionId), " visible" });
        i = n;
        break label1406;
      }
      m = i;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
        break label1415;
      }
      m = i;
      if (localObject2 == null) {
        break label1415;
      }
      m = i;
      if (i == 0) {
        break label1415;
      }
      ((ApolloDaoManager)localObject2).b((List)localObject4);
      m = i;
      break label1415;
    }
    label1099:
    label1362:
    for (;;)
    {
      label1011:
      a(9, true, null);
      label1019:
      localObject1 = ((HashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((ApolloDaoManager)localObject2).a(((Integer)((Iterator)localObject1).next()).intValue()) == null)
        {
          paramFromServiceMsg.c();
          continue;
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo failed", paramIntent);
          return;
        }
      }
      label1107:
      label1365:
      label1382:
      label1383:
      label1392:
      label1406:
      do
      {
        a(9, false, null);
        break label1019;
        a(9, false, null);
        if (paramIntent.has("CurrencyInfo"))
        {
          i = paramIntent.getJSONObject("CurrencyInfo").optInt("balance");
          localObject1 = paramFromServiceMsg.a();
          if (localObject1 != null)
          {
            ((ApolloPanelManager)localObject1).jdField_a_of_type_Int = i;
            if (((ApolloPanelManager)localObject1).jdField_a_of_type_Boolean) {
              ((ApolloPanelManager)localObject1).b();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "balance:", Integer.valueOf(i) });
          }
        }
        if (paramIntent.has("zancount")) {
          a(6, true, Integer.valueOf(paramIntent.optInt("zancount")));
        }
        if (paramIntent.has("gameCoinInfo"))
        {
          i = paramIntent.getJSONObject("gameCoinInfo").optInt("balance", 0);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleGetUserApolloInfo] game coin count=", Integer.valueOf(i) });
          }
          ApolloGameUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i);
        }
        if (j != 0)
        {
          paramFromServiceMsg.a(paramArrayOfByte);
          return;
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetUserApolloInfo fail ret: " + paramFromServiceMsg.getResultCode());
          }
          if (1 == (i & 0x100))
          {
            a(6, false, Integer.valueOf(0));
            return;
          }
        }
        do
        {
          m = 0;
          break label1415;
          break;
          k = 0;
          if (m != 6) {
            break label572;
          }
          k = 6;
          break label572;
          return;
          k += 1;
          break label698;
        } while (localObject4 == null);
        m = 0;
        i = 0;
        break label866;
        m += 1;
        break label866;
        if (m != 0) {
          break label1011;
        }
      } while (k == 0);
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
    paramString = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), VasExtensionServlet.class);
    paramString.putExtra("cmd", "SQQShopAuthCodeSvc.AuthCode");
    paramString.putExtra("data", localSReq.toByteArray());
    paramString.putExtra("timeout", 3000L);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString);
  }
  
  public void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
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
          a(5, true, paramIntent);
          return;
        }
        paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get()).getJSONObject("data").getJSONObject("acresult");
        paramIntent.put("type", paramFromServiceMsg.optInt("type") + "");
        paramIntent.put("id", paramFromServiceMsg.optInt("id") + "");
        paramIntent.put("content", paramFromServiceMsg.optString("msg"));
        paramIntent.put("url", paramFromServiceMsg.optString("url"));
        a(5, false, paramIntent);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus failed ", paramFromServiceMsg);
        }
        paramIntent.put("ret", "-1");
        a(5, false, paramIntent);
        return;
      }
    }
    paramIntent.put("ret", paramFromServiceMsg.getResultCode() + "");
    a(5, false, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  public void d(String paramString)
  {
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(paramString))) {}
    Object localObject2;
    int i;
    do
    {
      return;
      localObject1 = "special_care_tip_show_" + (String)localObject1 + "_" + paramString;
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
      i = ((SharedPreferences)localObject2).getInt((String)localObject1, 0);
    } while (i == 0);
    ((SharedPreferences)localObject2).edit().remove((String)localObject1).commit();
    switch (i)
    {
    default: 
      QLog.e(jdField_a_of_type_JavaLangString, 1, "showIfHadSpecialCareTip have error type " + i);
      return;
    case 1: 
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131438664);
    }
    for (;;)
    {
      paramString = new UniteGrayTipParam(paramString, paramString, (String)localObject1, 0, -5020, 2097156, MessageCache.a());
      localObject2 = new Bundle();
      if (!TextUtils.isEmpty("特别关心"))
      {
        ((Bundle)localObject2).putInt("key_action", 21);
        ((Bundle)localObject2).putString("key_action_DATA", Integer.toString(i));
        int j = ((String)localObject1).lastIndexOf("特别关心");
        if (j >= 0) {
          paramString.a(j, "特别关心".length() + j, (Bundle)localObject2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("reactive", 2, "showIfHadSpecialCareTip grayStr=" + (String)localObject1 + "spanPos=" + j + "iconName=" + "特别关心");
        }
        VasWebviewUtil.reportCommercialDrainage(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "Care", "CareTipShow", "", 1, 0, 0, null, Integer.toString(i), null);
      }
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).hasRead = 0;
      ((MessageForUniteGrayTip)localObject1).subType = 0;
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      UniteGrayTipUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject1);
      return;
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131438665);
      continue;
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131438666);
      continue;
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131438667);
      continue;
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131438669);
      continue;
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131438668);
    }
  }
  
  public void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
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
          a(7, true, Integer.valueOf(new JSONObject(paramIntent.rspdata.get()).getJSONObject("data").optInt("zancount")));
          return;
        }
        a(7, false, Long.valueOf(paramIntent.ret.get()));
        return;
      }
      catch (Exception paramIntent)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus failed ", paramIntent);
        }
        a(7, false, Integer.valueOf(-1));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeApolloStatus fail ret: " + paramFromServiceMsg.getResultCode());
    }
    a(7, false, Integer.valueOf(paramFromServiceMsg.getResultCode()));
  }
  
  public void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
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
          paramArrayOfByte = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
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
  
  public void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (0L == paramIntent.ret.get())
        {
          paramIntent = new JSONObject(paramIntent.rspdata.get()).optJSONObject("data").getJSONArray("weaList");
          if ((paramIntent == null) || (paramIntent.length() < 1)) {
            return;
          }
          a(15, true, paramIntent.getJSONObject(0).toString());
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetWeather sucess");
          return;
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetWeather err  ret: " + paramIntent.ret.get());
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleGetWeather error", paramIntent);
        return;
      }
    } else if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleGetWeather fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  void h(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramIntent = new qqshop_act.SQQSHPActRsp();
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        if (paramIntent != null) {
          a(13, true, paramIntent);
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
        a(13, false, null);
      }
      catch (Exception paramIntent)
      {
        a(13, false, null);
        return;
      }
    }
    else
    {
      QLog.e("EcshopJd", 1, "rsp failed:" + paramFromServiceMsg.getBusinessFailCode());
    }
  }
  
  void i(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramIntent = EcShopAssistantManager.a();
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramFromServiceMsg = new qqshop_act.SQQSHPActReadRsp();
      try
      {
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.code.get() == 0)) {
          a(14, true, null);
        }
        while (QLog.isColorLevel())
        {
          QLog.i("EcshopJd", 2, "jd check response:" + paramFromServiceMsg.code.get());
          return;
          a(14, false, null);
          paramIntent.edit().putLong("last_jd_req", System.currentTimeMillis()).commit();
        }
        paramIntent.edit().putLong("last_jd_req", System.currentTimeMillis() - 5400000L).commit();
      }
      catch (Exception paramFromServiceMsg)
      {
        paramIntent.edit().putLong("last_jd_req", System.currentTimeMillis()).commit();
        a(14, false, null);
        return;
      }
    }
    else
    {
      a(14, false, null);
      QLog.e("EcshopJd", 1, "rsp failed:" + paramFromServiceMsg.getBusinessFailCode());
    }
  }
  
  public void j(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      int j = 0;
      paramIntent = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Leba.class);
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
  
  public void k(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (0L == paramIntent.ret.get())
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleSendMsgToAI err  ret: " + paramIntent.ret.get());
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleSendMsgToAI err  ret: " + paramIntent.ret.get());
        }
        a(19, false, null);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleSendMsgToAI error", paramIntent);
        return;
      }
    } else if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleSendMsgToAI fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  public void l(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        if (0L == paramIntent.ret.get())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handleChangeAISwitch err  ret: " + paramIntent.ret.get());
          }
          a(20, true, null);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleChangeAISwitch err  ret: " + paramIntent.ret.get());
        }
        a(20, false, null);
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleChangeAISwitch error", paramIntent);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleChangeAISwitch fail ret: " + paramFromServiceMsg.getResultCode());
    }
  }
  
  public void m(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
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
        ((ApolloGameManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210)).a((int)paramFromServiceMsg.ret.get(), paramArrayOfByte.rpt_msg_list.get(), paramIntent);
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
  
  public void n(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
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
  
  public void o(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleCMGameResp],data:" + paramArrayOfByte);
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {
      for (;;)
      {
        WebSSOAgent.UniSsoServerRsp localUniSsoServerRsp;
        long l;
        int i;
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
          l = paramIntent.getLongExtra("usrdata", 0L);
          paramArrayOfByte = paramIntent.getStringExtra("cmd");
          i = paramIntent.getIntExtra("callFrom", 0);
          localObject = (ApolloGameManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210);
          if ("apollo_aio_game.get_user_gamepanel_gamelist_v2".equals(paramArrayOfByte))
          {
            ((ApolloGameManager)localObject).a(localUniSsoServerRsp.ret.get(), paramFromServiceMsg);
            if (!QLog.isColorLevel()) {
              return;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "ret:" + localUniSsoServerRsp.ret.get() + ",data:" + paramFromServiceMsg + ",cmd:" + paramArrayOfByte);
            return;
          }
          if ((!"apollo_aio_game.add_games_to_user_gamepanel".equals(paramArrayOfByte)) && (!"apollo_aio_game.del_games_from_user_gamepanel".equals(paramArrayOfByte))) {
            break label307;
          }
          ((ApolloGameManager)localObject).a(localUniSsoServerRsp.ret.get(), paramArrayOfByte, paramFromServiceMsg, paramIntent.getStringExtra("reqData"));
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
        label307:
        if (i == 4)
        {
          ApolloCmdChannel.getChannel(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).callbackFromRequest(l, (int)localUniSsoServerRsp.ret.get(), paramArrayOfByte, paramFromServiceMsg);
        }
        else if ("apollo_terminal_info.get_user_slaves_v2".equals(paramArrayOfByte))
        {
          localObject = ((ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a();
          if (localObject != null) {
            ((ApolloPanelManager)localObject).a(localUniSsoServerRsp.ret.get(), paramFromServiceMsg, paramIntent.getStringExtra("reqData"));
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "resp data is err.");
    }
    if ("apollo_aio_game.check_game_v2".equals("")) {
      a(21, false, null);
    }
  }
  
  public void p(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleApolloGameKey],data:" + paramArrayOfByte);
    }
    try
    {
      Object localObject;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(ChatActivity.class);
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
        a(21, true, paramIntent);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "ret:" + paramFromServiceMsg.ret.get());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "resp data is err.");
        }
        a(21, false, null);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->" + paramIntent.getMessage());
      }
      a(21, false, null);
    }
  }
  
  public void q(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      paramIntent = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder().append("handleGetStrangerVasInfo ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label1740;
      }
    }
    label1699:
    label1702:
    label1709:
    label1712:
    label1715:
    label1718:
    label1721:
    label1727:
    label1740:
    for (int i = paramArrayOfByte.length;; i = -1)
    {
      QLog.d(paramIntent, 2, i);
      if ((paramArrayOfByte != null) && (paramFromServiceMsg.isSuccess())) {}
      for (;;)
      {
        int i1;
        try
        {
          paramIntent = new oidb_sso.OIDBSSOPkg();
          paramIntent.mergeFrom(paramArrayOfByte);
          if ((paramIntent.uint32_result.has()) && (paramIntent.uint32_result.get() == 0))
          {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
            paramFromServiceMsg.mergeFrom(paramIntent.bytes_bodybuffer.get().toByteArray());
            int i2 = paramFromServiceMsg.rpt_msg_uin_data.size();
            paramArrayOfByte = new HashSet(i2);
            localObject = new ArrayList(i2);
            FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
            VasFaceManager localVasFaceManager = ((VasExtensionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a;
            i = 0;
            j = 0;
            i1 = 0;
            if (i1 < i2)
            {
              oidb_0x5eb.UdcUinData localUdcUinData = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(i1);
              m = 0;
              String str = String.valueOf(localUdcUinData.uint64_uin.get());
              paramIntent = localFriendsManager.a(str);
              if (paramIntent != null) {
                break label1718;
              }
              paramIntent = new ExtensionInfo();
              paramIntent.uin = str;
              m = 1;
              if (!localUdcUinData.uint32_vas_font_id.has()) {
                break label1715;
              }
              long l = localUdcUinData.uint32_vas_font_id.get();
              if (!str.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                break label1712;
              }
              i = (int)FontManager.a(l);
              if ((FontManager.a(l) == paramIntent.uVipFont) && (FontManager.b(l) == paramIntent.vipFontType)) {
                break label1709;
              }
              paramIntent.uVipFont = FontManager.a(l);
              paramIntent.vipFontType = FontManager.b(l);
              paramIntent.lastUpdateTime = NetConnInfoCenter.getServerTime();
              m = 1;
              if ((!localUdcUinData.uint32_vas_diy_font_timestamp.has()) || (!str.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                break label1702;
              }
              k = localUdcUinData.uint32_vas_diy_font_timestamp.get();
              j = m;
              if (localUdcUinData.uint32_vas_magicfont_flag.has())
              {
                n = localUdcUinData.uint32_vas_magicfont_flag.get();
                j = m;
                if (n != paramIntent.magicFont)
                {
                  paramIntent.magicFont = n;
                  paramIntent.lastUpdateTime = NetConnInfoCenter.getServerTime();
                  j = 1;
                }
              }
              int n = j;
              if (localUdcUinData.uint32_req_font_effect_id.has())
              {
                m = localUdcUinData.uint32_req_font_effect_id.get();
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetStrangerVasInfo uin = " + str + " fontEffect = " + m + " extInfo.fontEffect = " + paramIntent.fontEffect);
                }
                if (m != paramIntent.fontEffect)
                {
                  paramIntent.fontEffect = m;
                  paramIntent.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
                  j = 1;
                }
                n = j;
                if (QLog.isColorLevel())
                {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetStrangerVasInfo uin = " + str + " extInfo.fontEffect = " + paramIntent.fontEffect + " extInfo.fontEffectLastUpdateTime = " + paramIntent.fontEffectLastUpdateTime);
                  n = j;
                }
              }
              m = n;
              if (localUdcUinData.uint64_face_addon_id.has())
              {
                l = localUdcUinData.uint64_face_addon_id.get();
                m = n;
                if (paramIntent.pendantId != l)
                {
                  paramIntent.pendantId = l;
                  paramIntent.lastUpdateTime = NetConnInfoCenter.getServerTime();
                  m = 1;
                }
              }
              if (localUdcUinData.uint32_bubble_id.has())
              {
                j = localUdcUinData.uint32_bubble_id.get();
                if ((j >= 0) && (String.valueOf(str).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                  ((SVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(j);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetStrangerVasInfo uin= " + str + "bubble id = " + j);
                }
              }
              j = m;
              if (localUdcUinData.uint32_vas_colorring_id.has())
              {
                n = localUdcUinData.uint32_vas_colorring_id.get();
                j = m;
                if (paramIntent.colorRingId != n)
                {
                  paramIntent.colorRingId = n;
                  j = 1;
                }
              }
              if (localUdcUinData.uint32_vas_praise_id.has())
              {
                m = localUdcUinData.uint32_vas_praise_id.get();
                if ((m > 0) && (String.valueOf(str).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                  PraiseManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, m);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetStrangerVasInfo uin= " + str + "praise id = " + m);
                }
              }
              if ((localUdcUinData.uint64_game_appid.has()) && (localUdcUinData.uint64_game_last_login_time.has()) && (localUdcUinData.uint32_plate_of_king_dan.has()) && (localUdcUinData.uint32_plate_of_king_dan_display_switch.has())) {
                a(str, localUdcUinData.uint64_game_appid.get(), localUdcUinData.uint64_game_last_login_time.get(), localUdcUinData.uint32_plate_of_king_dan.get(), localUdcUinData.uint32_plate_of_king_dan_display_switch.get());
              }
              if (localUdcUinData.uint32_vas_voicebubble_id.has())
              {
                m = localUdcUinData.uint32_vas_voicebubble_id.get();
                if ((m > 0) && (String.valueOf(str).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
                {
                  ((SVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).b(m);
                  if (QLog.isColorLevel()) {
                    QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetStrangerVasInfo uin= " + str + "voice print bubble id = " + m);
                  }
                }
              }
              if (localUdcUinData.uint32_suspend_effect_id.has())
              {
                m = localUdcUinData.uint32_suspend_effect_id.get();
                if ((m >= 0) && (String.valueOf(str).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                  ((SVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(str, m);
                }
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "uint32_suspend_effect_id = " + m);
                }
              }
              if (!localUdcUinData.uint32_vas_face_id.has()) {
                break label1699;
              }
              n = paramIntent.faceId;
              paramIntent.faceId = localUdcUinData.uint32_vas_face_id.get();
              paramIntent.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
              m = 1;
              j = m;
              if (QLog.isColorLevel())
              {
                QLog.d(jdField_a_of_type_JavaLangString, 1, "uint32_vas_face_id uin: " + str + " oldId: " + n + " newId: " + paramIntent.faceId);
                j = m;
              }
              m = j;
              if (localUdcUinData.uint32_vas_pendant_diy_id.has())
              {
                n = localUdcUinData.uint32_vas_pendant_diy_id.get();
                m = j;
                if (paramIntent.pendantDiyId != n)
                {
                  paramIntent.pendantDiyId = n;
                  paramIntent.lastUpdateTime = NetConnInfoCenter.getServerTime();
                  if (str.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                    ((SVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).b(n, false);
                  }
                  if (!QLog.isColorLevel()) {
                    break label1721;
                  }
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "handleGetStrangerVasInfo, uin=" + str + ", pendant=" + paramIntent.pendantId + ",font=" + paramIntent.uVipFont + ", fontType = " + paramIntent.vipFontType + ", magicFont = " + paramIntent.magicFont + ", colorRing = " + paramIntent.colorRingId + ", pendantDiyId = " + paramIntent.pendantDiyId);
                  break label1721;
                }
              }
              if (m == 0) {
                break label1727;
              }
              paramIntent.timestamp = System.currentTimeMillis();
              paramArrayOfByte.add(str);
              ((List)localObject).add(paramIntent);
              break label1727;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VasFont", 2, "0x5eb self has diy timestamp fontid = " + i + " timestamp = " + j);
            }
            paramIntent = localFriendsManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            FontManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramIntent, i, j);
            localFriendsManager.b((List)localObject);
            localVasFaceManager.a((Collection)localObject);
            a(66, true, paramArrayOfByte);
            return;
          }
          a(66, false, null);
          return;
        }
        catch (Throwable paramIntent)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "", paramIntent);
        return;
        a(66, false, null);
        return;
        continue;
        int k = j;
        continue;
        continue;
        continue;
        continue;
        continue;
        int m = 1;
        continue;
        i1 += 1;
        int j = k;
      }
    }
  }
  
  void r(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    for (;;)
    {
      ArrayList localArrayList1;
      ApolloManager localApolloManager;
      ArrayList localArrayList2;
      int j;
      JSONArray localJSONArray;
      JSONObject localJSONObject;
      int k;
      int i;
      int m;
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
        paramIntent = ApolloManager.a();
        paramFromServiceMsg = paramIntent.edit();
        paramArrayOfByte = new JSONObject(paramArrayOfByte).getJSONArray("data");
        int i1 = paramArrayOfByte.length();
        localArrayList1 = new ArrayList();
        localApolloManager = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        localArrayList2 = new ArrayList();
        j = 0;
        if (j >= i1) {
          break label829;
        }
        localObject2 = paramArrayOfByte.getJSONObject(j);
        localJSONArray = new JSONArray();
        localObject1 = ((JSONObject)localObject2).getString("uin");
        localJSONObject = new JSONObject(paramIntent.getString((String)localObject1, "{}"));
        localObject2 = ((JSONObject)localObject2).getJSONArray("action");
        localObject3 = localJSONObject.optJSONArray("action");
        int i2 = ((JSONArray)localObject2).length();
        localArrayList1.clear();
        k = 0;
        if (k >= i2) {
          break label650;
        }
        int n = 0;
        int i3 = ((JSONArray)localObject2).getJSONObject(k).getInt("id");
        long l1 = ((JSONArray)localObject2).getJSONObject(k).getLong("updateTs");
        i = n;
        if (localObject3 != null)
        {
          int i4 = ((JSONArray)localObject3).length();
          m = 0;
          i = n;
          if (m < i4)
          {
            i = ((JSONArray)localObject3).getJSONObject(m).getInt("id");
            long l2 = ((JSONArray)localObject3).getJSONObject(m).getLong("updateTs");
            if (i != i3) {
              break label850;
            }
            i = n;
            if (l1 != l2)
            {
              QLog.i(jdField_a_of_type_JavaLangString, 1, "handleApolloStandAction version update res.");
              i = 1;
            }
          }
        }
        if (!ApolloUtil.a(i3, 0))
        {
          if (!QLog.isColorLevel()) {
            break label844;
          }
          QLog.i(jdField_a_of_type_JavaLangString, 2, "handleApolloStandAction download res first time.");
          break label844;
        }
        if (i != 0)
        {
          Object localObject4 = new ApolloActionData();
          ((ApolloActionData)localObject4).actionId = i3;
          String str = ApolloUtil.a((ApolloActionData)localObject4, 5);
          localObject4 = ApolloUtil.a((ApolloActionData)localObject4, 4);
          Object localObject5 = new File((String)localObject4).getParentFile();
          if (((File)localObject5).exists())
          {
            localObject5 = ((File)localObject5).listFiles();
            if ((localObject5 != null) && (localObject5.length > 0))
            {
              m = localObject5.length;
              i = 0;
              if (i < m)
              {
                localObject5[i].delete();
                i += 1;
                continue;
              }
            }
          }
          ApolloResDownloader.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4, str);
        }
        if (!((JSONArray)localObject2).getJSONObject(k).has("actPlace")) {
          break label619;
        }
        i = ((JSONArray)localObject2).getJSONObject(k).getInt("actPlace");
        if (i == 1) {
          localArrayList1.add(((JSONArray)localObject2).getJSONObject(k));
        } else if (i == 2) {
          localJSONArray.put(((JSONArray)localObject2).getJSONObject(k));
        }
      }
      catch (Exception paramIntent) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "handleApolloStandAction ", paramIntent);
      return;
      label619:
      localArrayList1.add(((JSONArray)localObject2).getJSONObject(k));
      localJSONArray.put(((JSONArray)localObject2).getJSONObject(k));
      break label859;
      label650:
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
      Object localObject1 = localApolloManager.b((String)localObject1);
      if (localObject1 != null)
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("action", localJSONArray);
        ((ApolloBaseInfo)localObject1).appearAction = localJSONObject.toString();
        localArrayList2.add(localObject1);
        break label868;
        label829:
        paramFromServiceMsg.commit();
        localApolloManager.b(localArrayList2);
        return;
        label844:
        i = 1;
        continue;
        label850:
        m += 1;
        continue;
        label859:
        k += 1;
        continue;
      }
      label868:
      j += 1;
    }
  }
  
  public void s(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      return;
      int i;
      Object localObject1;
      Object localObject2;
      int j;
      Object localObject4;
      Object localObject3;
      Object localObject5;
      for (;;)
      {
        try
        {
          paramIntent = new WebSSOAgent.UniSsoServerRsp();
          paramIntent.mergeFrom(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "updateRankInfo handleGameRank response code:" + paramIntent.ret.get());
          }
          if ((paramIntent.ret.get() != 0L) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
            break;
          }
          paramIntent = paramIntent.rspdata.get();
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, " updateRankInfo handleGameRank response:" + paramIntent);
          }
          paramArrayOfByte = new JSONObject(paramIntent).optJSONObject("data");
          i = paramArrayOfByte.optInt("gameNum");
          paramIntent = ApolloGameUtil.a();
          if ((paramIntent != null) && (i >= 0))
          {
            paramIntent.edit().putInt("sp.score.num", i).apply();
            ApolloGameUtil.jdField_a_of_type_Int = i;
          }
          localObject1 = paramArrayOfByte.optJSONArray("chgList");
          paramIntent = (ApolloDaoManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
          paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          if ((paramIntent == null) || (paramFromServiceMsg == null)) {
            break label715;
          }
          if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
            break label542;
          }
          localObject2 = new ArrayList();
          j = ((JSONArray)localObject1).length();
          i = 0;
          if (i >= j) {
            break label535;
          }
          localObject4 = ((JSONArray)localObject1).getJSONObject(i);
          if (localObject4 != null)
          {
            localObject3 = new ApolloGameRankData();
            ((ApolloGameRankData)localObject3).mGameId = ((JSONObject)localObject4).optInt("gameId");
            ((ApolloGameRankData)localObject3).mRank = ((JSONObject)localObject4).optInt("chgFlag");
            ((ApolloGameRankData)localObject3).mFriendUin = paramArrayOfByte.optString("sessionId");
            ((ApolloGameRankData)localObject3).mValidTime = (System.currentTimeMillis() + 604800000L);
            ((ArrayList)localObject2).add(localObject3);
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "updateRankInfo handleGameRank data " + localObject3);
            }
            localObject4 = paramIntent.g(2147483647);
            if ((localObject4 != null) && (((List)localObject4).size() > 0))
            {
              localObject4 = ((List)localObject4).iterator();
              if (((Iterator)localObject4).hasNext())
              {
                localObject5 = (ApolloGameRankData)((Iterator)localObject4).next();
                if ((localObject5 == null) || (!((ApolloGameRankData)localObject5).mFriendUin.equals(((ApolloGameRankData)localObject3).mFriendUin)) || (((ApolloGameRankData)localObject5).mRank != 2) || (((ApolloGameRankData)localObject3).mRank != 1)) {
                  continue;
                }
                VipUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "cmshow", "Apollo", "beyond_notice_disappear", 3, 0, new String[] { String.valueOf(((ApolloGameRankData)localObject5).mGameId) });
                continue;
              }
            }
          }
          i += 1;
        }
        catch (Throwable paramIntent)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameRank]", paramIntent);
          return;
        }
      }
      label535:
      paramIntent.b(paramFromServiceMsg, (List)localObject2);
      label542:
      paramArrayOfByte = paramArrayOfByte.optJSONArray("gScoreList");
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length() > 0))
      {
        int k = paramArrayOfByte.length();
        i = 0;
        while (i < k)
        {
          localObject1 = paramArrayOfByte.getJSONObject(i);
          if (localObject1 != null)
          {
            localObject2 = ((JSONObject)localObject1).optJSONArray("gameList");
            if (localObject2 != null)
            {
              int m = ((JSONArray)localObject2).length();
              localObject3 = new ArrayList();
              j = 0;
              while (j < m)
              {
                localObject4 = new ApolloGameScoreData();
                ((ApolloGameScoreData)localObject4).mUin = ((JSONObject)localObject1).optString("uin");
                localObject5 = ((JSONArray)localObject2).getJSONObject(j);
                ((ApolloGameScoreData)localObject4).mGameId = ((JSONObject)localObject5).optInt("gameId");
                ((ApolloGameScoreData)localObject4).mScore = ((JSONObject)localObject5).optInt("score");
                ((ArrayList)localObject3).add(localObject4);
                j += 1;
              }
              paramIntent.a(paramFromServiceMsg, (List)localObject3);
              break label726;
              label715:
              QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameRank] context is null");
              return;
            }
          }
          label726:
          i += 1;
        }
      }
    }
  }
  
  void t(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      return;
      paramIntent = new WebSSOAgent.UniSsoServerRsp();
      paramFromServiceMsg = new STCommon.STBatchRsp();
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        paramFromServiceMsg.mergeFrom(paramIntent.pbRsqData.get().toByteArray());
        paramFromServiceMsg = (STCommon.STRspItem)paramFromServiceMsg.rspItems.get().get(0);
        paramIntent = paramFromServiceMsg.strCmd.get();
        long l = paramFromServiceMsg.ret.get();
        paramFromServiceMsg = paramFromServiceMsg.rspPbData.get().toByteArray();
        if (("apollo_res_update.get_game_update_info".equals(paramIntent)) && (l == 0L))
        {
          paramIntent = new STGameResUpdate.STGameUpdateInfoRsp();
          paramIntent.mergeFrom(paramFromServiceMsg);
          paramIntent = paramIntent.gvInfoList.get();
          if ((paramIntent != null) && (paramIntent.size() > 0))
          {
            a(24, true, paramIntent);
            return;
          }
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleApolloGameResUpdate error:", paramIntent);
        return;
      }
    }
    a(24, false, null);
  }
  
  public void u(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
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
          break label392;
        }
        paramIntent = new JSONObject(paramIntent.rspdata.get()).getJSONObject("data");
        if ((paramIntent == null) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
          break label392;
        }
        int k = paramIntent.optInt("isSuccBuy");
        int m = paramIntent.optInt("balance");
        paramIntent = ((ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a();
        if (paramIntent != null) {
          paramIntent.jdField_a_of_type_Int = m;
        }
        if (k != 1) {
          break label392;
        }
        paramIntent = (ApolloDaoManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
        paramFromServiceMsg = new ApolloObtainedActionData();
        paramFromServiceMsg.id = i;
        paramFromServiceMsg.beginTs = NetConnInfoCenter.getServerTime();
        paramFromServiceMsg.type = 0;
        paramFromServiceMsg.way = 4;
        paramIntent.a(paramFromServiceMsg);
        paramIntent = new Bundle();
        paramIntent.putInt("jumpPkdId", j);
        paramIntent.putInt("jumpActionId", i);
        a(9, true, paramIntent);
        paramIntent = new HashMap();
        paramIntent.put("APOLLO_POP_TYPE", "toast");
        paramIntent.put("tips", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131438206));
        paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (paramFromServiceMsg == null) {
          break label398;
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
        ApolloItemBuilder.a("购买失败，请重试~", 1, BaseApplicationImpl.getContext());
      }
      return;
      label392:
      i = 0;
      continue;
      label398:
      i = 1;
    }
  }
  
  public void v(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleSaveGameListResult]");
    }
    if ((paramArrayOfByte == null) || (!paramFromServiceMsg.isSuccess()))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleSaveGameListResult] data null or rsp failed");
      a(25, false, null);
    }
    for (;;)
    {
      return;
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSaveGameListResult] ret=", Long.valueOf(paramFromServiceMsg.ret.get()) });
        }
        if (paramFromServiceMsg.ret.get() == 0L)
        {
          paramFromServiceMsg = paramFromServiceMsg.rspdata.get();
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleSaveGameListResult] respData=", paramFromServiceMsg });
          }
          paramFromServiceMsg = new JSONObject(paramFromServiceMsg).optJSONObject("data");
          if (paramIntent == null) {
            continue;
          }
          long l = paramFromServiceMsg.optLong("timeStamp");
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleSaveGameListResult] last timeStamp : " + l);
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleGameOnlineCountRsp] exception=", paramIntent);
        return;
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleSaveGameListResult] ret : " + paramFromServiceMsg.ret.get());
  }
  
  public void w(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[handleApolloLoginReq]");
    }
    if ((paramIntent != null) && (paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      try
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleApolloLoginReq] ret=", Long.valueOf(paramFromServiceMsg.ret.get()) });
        }
        if (paramFromServiceMsg.ret.get() != 0L) {
          return;
        }
        int i = paramIntent.getIntExtra("mask", 0);
        paramIntent = paramFromServiceMsg.rspdata.get();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[handleApolloLoginReq] respData=", paramIntent });
        }
        paramIntent = new JSONObject(paramIntent).optJSONObject("data");
        if (paramIntent == null) {
          return;
        }
        switch (i)
        {
        case 1: 
          if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            ((ApolloGameManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210)).a(paramFromServiceMsg.ret.get(), paramIntent.toString());
            return;
          }
          break;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleApolloLoginReq] exception=", paramIntent);
        return;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[handleApolloLoginReq] app is null");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasExtensionHandler
 * JD-Core Version:    0.7.0.1
 */