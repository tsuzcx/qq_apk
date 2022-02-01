package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl;
import com.tencent.mobileqq.gamecenter.data.GameMsgRemoteUserItem;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.mobileqq.gamecenter.sso.GameCenterSsoRspData;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryAIOGreetInfoReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryAIOGreetInfoRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GetMobileDialogReq;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GetMobileDialogRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.MobileDialog;
import com.tencent.mobileqq.gamecenter.utils.CommUtils;
import com.tencent.mobileqq.gamecenter.utils.GameMsgUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryRsp;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameCenterUnissoHandler
  extends BusinessHandler
{
  public static final String a = "com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler";
  public static String b = "GameCenterMsg.";
  private static String c;
  private long d = 0L;
  private long e = 1200L;
  private AppInterface f;
  private WadlTrpcListener g = new GameCenterUnissoHandler.1(this);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append("GameCenterUnissoHandler");
    c = localStringBuilder.toString();
  }
  
  public GameCenterUnissoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.f = paramAppInterface;
  }
  
  private GameDetailInfo a(GameUserInfo paramGameUserInfo)
  {
    if (paramGameUserInfo == null) {
      return null;
    }
    GameMsgManagerServiceImpl localGameMsgManagerServiceImpl = (GameMsgManagerServiceImpl)this.f.getRuntimeService(IGameMsgManagerService.class, "");
    if (GameUserInfo.isUsrInfoUpdate(localGameMsgManagerServiceImpl.findGameUserInfo(paramGameUserInfo.mRoleId), paramGameUserInfo))
    {
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[notifyGameUsrInfoChanged], roleId:");
      localStringBuilder.append(paramGameUserInfo.mRoleId);
      QLog.i(str, 1, localStringBuilder.toString());
      return GameDetailInfo.a(localGameMsgManagerServiceImpl.findGameConfig(paramGameUserInfo.mAppId), paramGameUserInfo);
    }
    return null;
  }
  
  public static GameCenterUnissoHandler a()
  {
    return (GameCenterUnissoHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(a);
  }
  
  private GameCenterSsoRspData a(Intent paramIntent, Object paramObject)
  {
    GameCenterSsoRspData localGameCenterSsoRspData = new GameCenterSsoRspData();
    localGameCenterSsoRspData.b = paramObject;
    if (paramIntent != null) {
      localGameCenterSsoRspData.a = paramIntent.getIntExtra("req_intent_param_hashcode", -1);
    }
    return localGameCenterSsoRspData;
  }
  
  private CommonReq a(long paramLong1, long paramLong2)
  {
    CommonReq localCommonReq = new CommonReq();
    try
    {
      localCommonReq.cpuCoreCount.set(DeviceInfoUtil.h());
      localCommonReq.manufacturer.set(Build.BRAND);
      localCommonReq.model.set(Build.MODEL);
      localCommonReq.osVersionCode.set(Build.VERSION.SDK_INT);
      localCommonReq.qqVersion.set(DeviceInfoUtil.a(MobileQQ.getContext()));
      localCommonReq.totalMemory.set((int)(DeviceInfoUtil.a() / 1048576L));
      localCommonReq.lastPreDownloadTime.set(paramLong1);
      localCommonReq.lastUpdateTime.set(paramLong2);
      return localCommonReq;
    }
    catch (Throwable localThrowable)
    {
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createCommonHippyReq e:");
      localStringBuilder.append(localThrowable);
      QLog.e(str, 1, localStringBuilder.toString());
    }
    return localCommonReq;
  }
  
  private void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      str = c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[saveTabConfigInterval] interval : ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    String str = this.f.getCurrentAccountUin();
    Object localObject = this.f.getApplication().getSharedPreferences("game_center_sp", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("sp_key_get_tab_config_interval");
    ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong);
    this.e = paramLong;
  }
  
  private void b(long paramLong)
  {
    String str = this.f.getCurrentAccountUin();
    SharedPreferences.Editor localEditor = this.f.getApplication().getSharedPreferences("game_center_sp", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("sp_key_last_get_tab_config_timestamp");
    localEditor.putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "[handleGameStartPriority]");
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {}
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        paramFromServiceMsg.ret.get();
        paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get());
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[handleGameStartPriority] root: ");
          localStringBuilder.append(paramFromServiceMsg.toString());
          QLog.d(paramArrayOfByte, 2, localStringBuilder.toString());
        }
        paramFromServiceMsg = paramFromServiceMsg.optJSONObject("GameInfo.GetGameStartPriority");
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg = paramFromServiceMsg.optJSONObject("rsp");
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.optInt("ret_code") == 0))
          {
            notifyUI(8227, true, a(paramIntent, paramFromServiceMsg));
            return;
          }
        }
      }
      notifyUI(8227, false, a(paramIntent, null));
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e(c, 1, "", paramIntent);
    }
  }
  
  private void c(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    paramIntent = c;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handleRemoteUserList], retCode:");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i(paramIntent, 1, ((StringBuilder)localObject).toString());
    try
    {
      paramIntent = (IGameMsgManagerService)this.f.getRuntimeService(IGameMsgManagerService.class, "");
      if ((paramLong == 0L) && (paramTrpcInovkeRsp != null) && (paramTrpcInovkeRsp.data.has()))
      {
        localObject = new GetMobileDialogRsp();
        ((GetMobileDialogRsp)localObject).mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        localObject = ((GetMobileDialogRsp)localObject).dialogList.get();
        paramTrpcInovkeRsp = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MobileDialog localMobileDialog = (MobileDialog)((Iterator)localObject).next();
          GameMsgRemoteUserItem localGameMsgRemoteUserItem = new GameMsgRemoteUserItem();
          localGameMsgRemoteUserItem.f = localMobileDialog.fromOpenID.get();
          localGameMsgRemoteUserItem.b = localMobileDialog.fromRoleID.get();
          localGameMsgRemoteUserItem.d = localMobileDialog.fromTinyID.get();
          localGameMsgRemoteUserItem.g = localMobileDialog.toOpenID.get();
          localGameMsgRemoteUserItem.c = localMobileDialog.toRoleID.get();
          localGameMsgRemoteUserItem.e = localMobileDialog.toTinyID.get();
          localGameMsgRemoteUserItem.a = localMobileDialog.appid.get();
          localGameMsgRemoteUserItem.h = localMobileDialog.sig.get();
          localGameMsgRemoteUserItem.i = localMobileDialog.time.get();
          paramTrpcInovkeRsp.add(localGameMsgRemoteUserItem);
        }
        paramIntent.notifyRemoteUserReady(0, paramTrpcInovkeRsp);
        paramIntent = c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(",dialog size:");
        ((StringBuilder)localObject).append(paramTrpcInovkeRsp.size());
        QLog.i(paramIntent, 1, ((StringBuilder)localObject).toString());
        return;
      }
      QLog.w(c, 1, "rsp errors!");
      paramIntent.notifyRemoteUserReady((int)paramLong, null);
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e(c, 1, paramIntent, new Object[0]);
      ((IGameMsgManagerService)this.f.getRuntimeService(IGameMsgManagerService.class, "")).notifyRemoteUserReady(-2001, null);
    }
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "[handleAioPopInfo]");
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          paramFromServiceMsg.ret.get();
          paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get()).optJSONObject("Aio.GetAioPop");
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg = paramFromServiceMsg.optJSONObject("rsp");
            if (paramFromServiceMsg != null)
            {
              int i = paramFromServiceMsg.optInt("ret_code");
              Object localObject1 = paramFromServiceMsg.optString("err_msg");
              paramArrayOfByte = paramFromServiceMsg.optJSONObject("popinfo");
              if (i != 0)
              {
                paramIntent = c;
                paramFromServiceMsg = new StringBuilder();
                paramFromServiceMsg.append("errMsg:");
                paramFromServiceMsg.append((String)localObject1);
                QLog.w(paramIntent, 1, paramFromServiceMsg.toString());
                return;
              }
              if (QLog.isColorLevel())
              {
                localObject1 = c;
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("[handleAioPopInfo] popInfo: ");
                ((StringBuilder)localObject2).append(paramArrayOfByte.toString());
                QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
              }
              localObject1 = paramFromServiceMsg.optJSONObject("friend_info");
              Object localObject2 = paramFromServiceMsg.optJSONArray("gray_tips_list");
              if (localObject1 != null) {
                notifyUI(8226, true, a(paramIntent, localObject1));
              }
              if (paramArrayOfByte != null) {
                notifyUI(8225, true, a(paramIntent, paramArrayOfByte));
              }
              if (localObject2 != null) {
                notifyUI(8228, true, a(paramIntent, localObject2));
              }
              notifyUI(8273, true, a(paramIntent, paramFromServiceMsg.optString("desc")));
              paramArrayOfByte = paramFromServiceMsg.optJSONObject("stranger_recomd");
              if (paramArrayOfByte != null) {
                notifyUI(8262, true, a(paramIntent, paramArrayOfByte));
              }
              notifyUI(8261, true, a(paramIntent, paramFromServiceMsg.optString("top_gray_tips")));
              notifyUI(8264, true, a(paramIntent, paramFromServiceMsg.optJSONArray("head_icon_list")));
              notifyUI(8274, true, a(paramIntent, paramFromServiceMsg));
              if (paramFromServiceMsg.has("sgamebattle"))
              {
                notifyUI(8275, true, a(paramIntent, paramFromServiceMsg));
                return;
              }
            }
          }
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e(c, 1, paramIntent.getMessage());
      }
    }
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "[handleSetSwitch]");
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          long l = paramFromServiceMsg.ret.get();
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("ret:");
            localStringBuilder.append(l);
            QLog.d(paramArrayOfByte, 2, localStringBuilder.toString());
          }
          if (new JSONObject(paramFromServiceMsg.rspdata.get()).getJSONObject("UserInfo.SetSwitch").getJSONObject("rsp").optInt("ret_code") == 0)
          {
            notifyUI(8265, true, a(paramIntent, ""));
            return;
          }
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e(c, 1, paramIntent.getMessage());
      }
    }
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "[handleAddOrShieldFriend]");
    }
    try
    {
      CommUtils.a();
      if ((paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
      {
        paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        paramFromServiceMsg.ret.get();
        paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get()).getJSONObject("Aio.DealGameFriend").getJSONObject("rsp");
        int i = paramFromServiceMsg.optInt("ret_code");
        int j = paramFromServiceMsg.optInt("op_type");
        paramArrayOfByte = paramFromServiceMsg.optString("err_msg");
        String str = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleAddOrShieldFriend], retCode:");
        localStringBuilder.append(i);
        localStringBuilder.append(",errMsg:");
        localStringBuilder.append(paramArrayOfByte);
        localStringBuilder.append(",type:");
        localStringBuilder.append(j);
        QLog.i(str, 1, localStringBuilder.toString());
        notifyUI(8263, true, a(paramIntent, paramFromServiceMsg));
        return;
      }
    }
    catch (Throwable paramFromServiceMsg)
    {
      notifyUI(8263, false, a(paramIntent, null));
      QLog.e(c, 1, paramFromServiceMsg.getMessage());
    }
  }
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "[handleGetGameSwitch]");
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          paramFromServiceMsg.ret.get();
          paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get()).getJSONObject("UserInfo.GetSwitch").getJSONObject("rsp");
          int i = paramFromServiceMsg.optInt("ret_code");
          paramArrayOfByte = paramFromServiceMsg.optString("err_msg");
          paramFromServiceMsg = paramFromServiceMsg.optJSONObject("result_map").optJSONObject(this.f.getCurrentAccountUin());
          if (i != 0)
          {
            paramIntent = c;
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("errMsg:");
            paramFromServiceMsg.append(paramArrayOfByte);
            QLog.w(paramIntent, 1, paramFromServiceMsg.toString());
            return;
          }
          Object localObject;
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = c;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[handleGetGameSwitch] result: ");
            ((StringBuilder)localObject).append(paramFromServiceMsg.toString());
            QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject).toString());
          }
          paramArrayOfByte = new ArrayList();
          if (paramFromServiceMsg != null)
          {
            localObject = paramFromServiceMsg.keys();
            while (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              if (!TextUtils.isEmpty(str))
              {
                GameSwitchConfig localGameSwitchConfig = new GameSwitchConfig();
                JSONObject localJSONObject = paramFromServiceMsg.getJSONObject(str);
                localGameSwitchConfig.mAppId = str;
                localGameSwitchConfig.mSyncSwitch = localJSONObject.optInt("switch");
                localGameSwitchConfig.mBlockSwitch = localJSONObject.optInt("qq_block_switch");
                localGameSwitchConfig.mBoxSwitch = localJSONObject.optInt("box_switch");
                localGameSwitchConfig.print();
                paramArrayOfByte.add(localGameSwitchConfig);
              }
            }
            ((GameMsgManagerServiceImpl)this.f.getRuntimeService(IGameMsgManagerService.class, "")).saveOrUpdateGameSwitchConfigs(paramArrayOfByte);
          }
          notifyUI(8272, true, a(paramIntent, ""));
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e(c, 1, paramIntent.getMessage());
      }
    }
  }
  
  private void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str1 = "game_profile";
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "[handleGetUserInfoRsp]");
    }
    for (;;)
    {
      try
      {
        l1 = System.currentTimeMillis();
        localObject2 = (GameMsgManagerServiceImpl)this.f.getRuntimeService(IGameMsgManagerService.class, "");
        if ((paramArrayOfByte != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
        {
          paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
          paramFromServiceMsg.mergeFrom(paramArrayOfByte);
          paramFromServiceMsg.ret.get();
          paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get());
          if (QLog.isColorLevel()) {
            QLog.d(c, 2, paramFromServiceMsg.toString());
          }
          paramFromServiceMsg = paramFromServiceMsg.getJSONObject("UserInfo.GetUserInfo").getJSONObject("rsp");
          int i = paramFromServiceMsg.optInt("ret_code");
          paramArrayOfByte = paramFromServiceMsg.optString("err_msg");
          if (i != 0)
          {
            paramIntent = c;
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("errMsg:");
            paramFromServiceMsg.append(paramArrayOfByte);
            QLog.w(paramIntent, 1, paramFromServiceMsg.toString());
            return;
          }
          paramArrayOfByte = paramFromServiceMsg.optJSONObject("game_config");
          localArrayList = new ArrayList();
          localObject1 = "data_update_ts";
          if (paramArrayOfByte != null)
          {
            localObject3 = paramArrayOfByte.keys();
            if (((Iterator)localObject3).hasNext())
            {
              localObject5 = (String)((Iterator)localObject3).next();
              if (TextUtils.isEmpty((CharSequence)localObject5)) {
                continue;
              }
              localObject4 = new GameBasicInfo();
              ((GameBasicInfo)localObject4).mAppId = ((String)localObject5);
              localObject5 = paramArrayOfByte.getJSONObject((String)localObject5);
              ((GameBasicInfo)localObject4).mName = ((JSONObject)localObject5).optString("name");
              ((GameBasicInfo)localObject4).mIconUrl = ((JSONObject)localObject5).optString("icon");
              ((GameBasicInfo)localObject4).mMsgMaxLen = ((JSONObject)localObject5).optInt("msg_max_len");
              ((GameBasicInfo)localObject4).mUpdateTs = ((JSONObject)localObject5).optLong("data_update_ts");
              ((GameBasicInfo)localObject4).mStartGameUrl = ((JSONObject)localObject5).optString("zone_url");
              ((GameBasicInfo)localObject4).print();
              localArrayList.add(localObject4);
              continue;
            }
            ((GameMsgManagerServiceImpl)localObject2).saveOrUpdateGameBasicConfigs(localArrayList);
          }
          localObject3 = paramFromServiceMsg.optJSONArray("result_list");
          paramFromServiceMsg = new ArrayList();
          if (localObject3 == null) {
            break label815;
          }
          i = ((JSONArray)localObject3).length();
          localArrayList = new ArrayList();
          j = 0;
          paramArrayOfByte = (byte[])localObject2;
          localObject2 = localObject3;
          localObject3 = this;
          if (j < i)
          {
            localObject3 = new GameUserInfo();
            localObject6 = ((JSONArray)localObject2).getJSONObject(j);
            localObject4 = ((JSONObject)localObject6).optString("uin");
            k = ((JSONObject)localObject6).optInt("online_type");
            m = ((JSONObject)localObject6).optInt("sex");
            l2 = ((JSONObject)localObject6).optLong((String)localObject1);
            n = ((JSONObject)localObject6).optInt("msgsync_switch");
            localObject5 = ((JSONObject)localObject6).optString("appid");
            str2 = ((JSONObject)localObject6).optString("nick");
            str3 = ((JSONObject)localObject6).optString("face_url");
            str4 = ((JSONObject)localObject6).optString("role_id");
          }
        }
      }
      catch (Throwable paramIntent)
      {
        long l1;
        Object localObject2;
        ArrayList localArrayList;
        Object localObject1;
        Object localObject3;
        Object localObject5;
        Object localObject4;
        int j;
        Object localObject6;
        int k;
        int m;
        long l2;
        int n;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        QLog.e(c, 1, paramIntent.getMessage());
      }
      try
      {
        str5 = ((JSONObject)localObject6).optString("partition_name");
        str6 = ((JSONObject)localObject6).optJSONObject(str1).optString("level_pic");
        str7 = ((JSONObject)localObject6).optJSONObject(str1).getString("level_text");
        str8 = ((JSONObject)localObject6).optString("online_desc");
        localObject6 = ((JSONObject)localObject6).optString("viprank_url");
        ((GameUserInfo)localObject3).mUin = ((String)localObject4);
        ((GameUserInfo)localObject3).mRoleId = str4;
        ((GameUserInfo)localObject3).mAppId = ((String)localObject5);
        ((GameUserInfo)localObject3).mUpdateTs = l2;
        ((GameUserInfo)localObject3).mFaceUrl = str3;
        ((GameUserInfo)localObject3).mSex = m;
        ((GameUserInfo)localObject3).mNickInGame = str2;
        ((GameUserInfo)localObject3).mOnlineType = k;
        ((GameUserInfo)localObject3).mPartitioName = str5;
        ((GameUserInfo)localObject3).mLevelPic = str6;
        ((GameUserInfo)localObject3).mLevelText = str7;
        ((GameUserInfo)localObject3).mSaveTs = l1;
        ((GameUserInfo)localObject3).mSwitchInGame = n;
        ((GameUserInfo)localObject3).mOnLineDesc = str8;
        ((GameUserInfo)localObject3).mVipRankUrl = ((String)localObject6);
        ((GameUserInfo)localObject3).print();
        try
        {
          localObject4 = a((GameUserInfo)localObject3);
          if (localObject4 == null) {
            break label808;
          }
          localArrayList.add(localObject4);
          paramFromServiceMsg.add(localObject3);
          j += 1;
        }
        catch (Throwable paramIntent)
        {
          continue;
        }
        localObject1 = paramArrayOfByte;
        paramArrayOfByte = paramFromServiceMsg;
        localObject2 = localObject1;
        if (localArrayList.size() > 0)
        {
          ((GameCenterUnissoHandler)localObject3).notifyUI(8224, true, ((GameCenterUnissoHandler)localObject3).a(paramIntent, localArrayList));
          paramArrayOfByte = paramFromServiceMsg;
          localObject2 = localObject1;
        }
        if (localObject2 == null) {
          break label807;
        }
        ((GameMsgManagerServiceImpl)localObject2).saveOrUpdateGameUsrInfoArrays(paramArrayOfByte);
        return;
      }
      catch (Throwable paramIntent)
      {
        continue;
      }
      return;
      label807:
      return;
      label808:
      continue;
      label815:
      paramArrayOfByte = paramFromServiceMsg;
    }
  }
  
  private boolean h()
  {
    this.e = d();
    this.d = e();
    boolean bool;
    if (NetConnInfoCenter.getServerTime() - this.d / 1000L < this.e) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkTabConfigInterval] ret=");
      localStringBuilder.append(bool);
      localStringBuilder.append(",lasttime = ");
      localStringBuilder.append(this.d / 1000L);
      localStringBuilder.append(", interval = ");
      localStringBuilder.append(this.e);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "[getGameSwitch]");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("req", new JSONObject());
      ((JSONObject)localObject).put("UserInfo.GetSwitch", localJSONObject);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, ((JSONObject)localObject).toString());
      }
      localObject = new NewIntent(this.f.getApp(), GameCenterUnissoServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "GameCenterMsg.GetSwitch");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      ((NewIntent)localObject).putExtra("req_intent_param_hashcode", paramInt);
      this.f.startServlet((NewIntent)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(c, 1, localThrowable.getMessage());
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[addOrShieldFriend], type:");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(",friRoleId:");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(",myRoleId:");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(",message:");
      ((StringBuilder)localObject2).append(paramString3);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.8.17");
      localObject1 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
      localObject2 = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("op_type", paramInt2);
      localJSONObject.put("to_roleid", paramString1);
      localJSONObject.put("roleid", paramString2);
      localJSONObject.put("text", paramString3);
      paramString1 = new JSONObject();
      paramString1.put("req", localJSONObject);
      ((JSONObject)localObject2).put("Aio.DealGameFriend", paramString1);
      ((WebSSOAgent.UniSsoServerReq)localObject1).reqdata.set(((JSONObject)localObject2).toString());
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, ((JSONObject)localObject2).toString());
      }
      paramString1 = new NewIntent(this.f.getApp(), GameCenterUnissoServlet.class);
      paramString1.putExtra("cmd", "GameCenterMsg.DealGameFriend");
      paramString1.putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
      paramString1.putExtra("req_intent_param_hashcode", paramInt1);
      this.f.startServlet(paramString1);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e(c, 1, paramString1.getMessage());
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getGameStartPriority] appid: ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.8.17");
      localObject1 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
      localObject2 = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", paramString);
      paramString = new JSONObject();
      paramString.put("req", localJSONObject);
      ((JSONObject)localObject2).put("GameInfo.GetGameStartPriority", paramString);
      ((WebSSOAgent.UniSsoServerReq)localObject1).reqdata.set(((JSONObject)localObject2).toString());
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, ((JSONObject)localObject2).toString());
      }
      paramString = new NewIntent(this.f.getApp(), GameCenterUnissoServlet.class);
      paramString.putExtra("cmd", "GameCenterMsg.GetGameStartPriority");
      paramString.putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
      paramString.putExtra("req_intent_param_hashcode", paramInt);
      this.f.startServlet(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(c, 1, paramString.getMessage());
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[setGameSwitch] synSwitch: ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(",blockSwitch:");
      ((StringBuilder)localObject2).append(paramInt3);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.8.17");
      localObject1 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
      localObject2 = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", paramString);
      localJSONObject.put("switch_type", paramInt2);
      localJSONObject.put("qq_block_switch_type", paramInt3);
      paramString = new JSONObject();
      paramString.put("req", localJSONObject);
      ((JSONObject)localObject2).put("UserInfo.SetSwitch", paramString);
      ((WebSSOAgent.UniSsoServerReq)localObject1).reqdata.set(((JSONObject)localObject2).toString());
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, ((JSONObject)localObject2).toString());
      }
      paramString = new NewIntent(this.f.getApp(), GameCenterUnissoServlet.class);
      paramString.putExtra("cmd", "GameCenterMsg.SetSwitch");
      paramString.putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
      paramString.putExtra("req_intent_param_hashcode", paramInt1);
      this.f.startServlet(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(c, 1, paramString.getMessage());
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getAioPopInfo] from svr mid: ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(",fid:");
      ((StringBuilder)localObject2).append(paramString2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      try
      {
        localObject2 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.8.17");
        localObject1 = new WebSSOAgent.UniSsoServerReq();
        ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
        localObject2 = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("me_roleid", paramString1);
        localJSONObject.put("friend_roleid", paramString2);
        paramString1 = (TicketManager)this.f.getManager(2);
        if (paramString1 != null) {
          localJSONObject.put("skey", paramString1.getSkey(this.f.getAccount()));
        }
        paramString1 = new JSONObject();
        paramString1.put("req", localJSONObject);
        ((JSONObject)localObject2).put("Aio.GetAioPop", paramString1);
        ((WebSSOAgent.UniSsoServerReq)localObject1).reqdata.set(((JSONObject)localObject2).toString());
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, ((JSONObject)localObject2).toString());
        }
        paramString1 = new NewIntent(this.f.getApp(), GameCenterUnissoServlet.class);
        paramString1.putExtra("cmd", "GameCenterMsg.GetAioPop");
        paramString1.putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
        paramString1.putExtra("req_intent_param_hashcode", paramInt);
        this.f.startServlet(paramString1);
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e(c, 1, paramString1.getMessage());
      }
    }
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "[getGameUserInfo] from svr");
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      try
      {
        Object localObject1 = new WebSSOAgent.UniSsoServerReqComm();
        ((WebSSOAgent.UniSsoServerReqComm)localObject1).platform.set(109L);
        ((WebSSOAgent.UniSsoServerReqComm)localObject1).osver.set(Build.VERSION.RELEASE);
        ((WebSSOAgent.UniSsoServerReqComm)localObject1).mqqver.set("8.8.17");
        WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
        localUniSsoServerReq.comm.set((MessageMicro)localObject1);
        localObject1 = new JSONObject();
        Object localObject2 = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("role_id", str);
          ((JSONArray)localObject2).put(localJSONObject);
        }
        paramArrayList = new JSONObject();
        paramArrayList.put("is_need_game_config", true);
        paramArrayList.put("query_list", localObject2);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("req", paramArrayList);
        ((JSONObject)localObject1).put("UserInfo.GetUserInfo", localObject2);
        localUniSsoServerReq.reqdata.set(((JSONObject)localObject1).toString());
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, ((JSONObject)localObject1).toString());
        }
        paramArrayList = new NewIntent(this.f.getApp(), GameCenterUnissoServlet.class);
        paramArrayList.putExtra("cmd", "GameCenterMsg.GetUserInfo");
        paramArrayList.putExtra("data", localUniSsoServerReq.toByteArray());
        paramArrayList.putExtra("req_intent_param_hashcode", paramInt);
        this.f.startServlet(paramArrayList);
        return;
      }
      catch (Throwable paramArrayList)
      {
        QLog.e(c, 1, paramArrayList.getMessage());
      }
    }
  }
  
  public void a(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    paramIntent = c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleGameMsgTabConfig retCode:");
    localStringBuilder.append(paramLong);
    QLog.i(paramIntent, 1, localStringBuilder.toString());
    if ((paramLong == 0L) && (paramTrpcInovkeRsp != null)) {
      if (!paramTrpcInovkeRsp.data.has()) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramIntent = new CommonMobileConfQueryRsp();
        paramIntent.mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        if (!paramIntent.updatePreDownloadGap.has()) {
          break label250;
        }
        paramLong = paramIntent.updatePreDownloadGap.get();
        a(paramLong);
        if (!paramIntent.confList.has())
        {
          QLog.e(c, 1, "handleGameMsgTabConfig configRsp is empty.");
          return;
        }
        paramIntent = paramIntent.confList.get().iterator();
        if (paramIntent.hasNext())
        {
          paramTrpcInovkeRsp = (MobileConfRsp)paramIntent.next();
          if (paramTrpcInovkeRsp.configType.get() != 8) {
            continue;
          }
          paramIntent = paramTrpcInovkeRsp.conf.get();
          ((GameMsgManagerServiceImpl)this.f.getRuntimeService(IGameMsgManagerService.class, "")).saveOrUpdateTabConfigs(paramIntent);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        paramTrpcInovkeRsp = c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleGameMsgTabConfig error:");
        localStringBuilder.append(paramIntent);
        QLog.i(paramTrpcInovkeRsp, 1, localStringBuilder.toString());
      }
      return;
      label250:
      paramLong = 1200L;
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str1 = paramIntent.getStringExtra("cmd");
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      String str2 = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceive], cmd:");
      localStringBuilder.append(str1);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    if ("GameCenterMsg.GetUserInfo".equals(str1))
    {
      g(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return;
    }
    if ("GameCenterMsg.GetSwitch".equals(str1))
    {
      f(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return;
    }
    if ("GameCenterMsg.GetAioPop".equals(str1))
    {
      c(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return;
    }
    if ("GameCenterMsg.GetGameStartPriority".equals(str1))
    {
      b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return;
    }
    if ("GameCenterMsg.DealGameFriend".equals(str1))
    {
      e(paramIntent, paramFromServiceMsg, paramArrayOfByte);
      return;
    }
    if ("GameCenterMsg.SetSwitch".equals(str1)) {
      d(paramIntent, paramFromServiceMsg, paramArrayOfByte);
    }
  }
  
  public void b()
  {
    QLog.i(c, 1, "[getRemoteUserList]");
    try
    {
      Object localObject = new GetMobileDialogReq();
      ((GetMobileDialogReq)localObject).offset.set(0);
      ((GetMobileDialogReq)localObject).pageSize.set(-1);
      ((GetMobileDialogReq)localObject).uin.set(Long.parseLong(GameMsgUtil.a().getCurrentAccountUin()));
      localObject = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/216", false, ((GetMobileDialogReq)localObject).toByteArray());
      TrpcProxy.TrpcListReq localTrpcListReq = new TrpcProxy.TrpcListReq();
      localTrpcListReq.list.add((MessageMicro)localObject);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.g);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc(localTrpcListReq, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(c, 1, localThrowable, new Object[0]);
    }
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    QLog.i(c, 1, "[reqGameMsgSayHiInfo]");
    IGameMsgManagerService localIGameMsgManagerService = (IGameMsgManagerService)this.f.getRuntimeService(IGameMsgManagerService.class, "");
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      try
      {
        GameMsgGreeting.QueryAIOGreetInfoReq localQueryAIOGreetInfoReq = new GameMsgGreeting.QueryAIOGreetInfoReq();
        localQueryAIOGreetInfoReq.fromRoleID.set(paramString1);
        localQueryAIOGreetInfoReq.toRoleID.set(paramString2);
        paramString2 = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/221", false, localQueryAIOGreetInfoReq.toByteArray());
        paramString1 = new TrpcProxy.TrpcListReq();
        paramString1.list.add(paramString2);
        ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.g);
        paramString2 = new Bundle();
        paramString2.putInt("requestId", paramInt);
        ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc(paramString1, paramString2);
        return;
      }
      catch (Throwable paramString1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("request error.");
        paramString2.append(paramString1);
        localIGameMsgManagerService.notifyGameMsgSayHiInfo(paramInt, -1L, paramString2.toString(), null);
        QLog.e(c, 1, paramString1, new Object[0]);
        return;
      }
    }
    localIGameMsgManagerService.notifyGameMsgSayHiInfo(paramInt, -1L, "roleId is empty.", null);
    QLog.i(c, 1, "[reqGameMsgSayHiInfo] roleId is empty.");
  }
  
  protected void b(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    Object localObject = c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleGameMsgSayHiInfo retCode:");
    localStringBuilder.append(paramLong);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (paramIntent == null)
    {
      QLog.i(c, 1, "handleGameMsgSayHiInfo request is null.");
      return;
    }
    localObject = (IGameMsgManagerService)this.f.getRuntimeService(IGameMsgManagerService.class, "");
    int i = paramIntent.getIntExtra("requestId", 0);
    if ((paramLong == 0L) && (paramTrpcInovkeRsp != null) && (paramTrpcInovkeRsp.data.has())) {
      try
      {
        paramIntent = new GameMsgGreeting.QueryAIOGreetInfoRsp();
        paramIntent.mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        ((IGameMsgManagerService)localObject).notifyGameMsgSayHiInfo(i, 0L, "", paramIntent);
        return;
      }
      catch (Throwable paramIntent)
      {
        paramTrpcInovkeRsp = new StringBuilder();
        paramTrpcInovkeRsp.append("parse rsp error:");
        paramTrpcInovkeRsp.append(paramIntent);
        ((IGameMsgManagerService)localObject).notifyGameMsgSayHiInfo(i, -1L, paramTrpcInovkeRsp.toString(), null);
        paramTrpcInovkeRsp = c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGameMsgSayHiInfo error:");
        ((StringBuilder)localObject).append(paramIntent);
        QLog.i(paramTrpcInovkeRsp, 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    ((IGameMsgManagerService)localObject).notifyGameMsgSayHiInfo(i, paramLong, "error.", null);
  }
  
  public void c()
  {
    if (!h()) {
      return;
    }
    this.d = NetConnInfoCenter.getServerTimeMillis();
    b(this.d);
    QLog.i(c, 1, "getGameMsgTabConfig start");
    try
    {
      Object localObject1 = new CommonMobileConfQueryReq();
      Object localObject2 = a(0L, 0L);
      ((CommonMobileConfQueryReq)localObject1).commonReq.set((MessageMicro)localObject2);
      localObject2 = new MobileConfReq();
      ((MobileConfReq)localObject2).configType.set(8);
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("name", "qgame_msgassistant_aio_redpoint");
      localJSONArray.put(localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("name", "qgame_msgassistant_box");
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("testList", localJSONArray);
      ((MobileConfReq)localObject2).busiReq.set(localJSONObject1.toString());
      ((CommonMobileConfQueryReq)localObject1).reqConfList.add((MessageMicro)localObject2);
      localObject1 = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/33", false, ((CommonMobileConfQueryReq)localObject1).toByteArray());
      localObject2 = new TrpcProxy.TrpcListReq();
      ((TrpcProxy.TrpcListReq)localObject2).list.add((MessageMicro)localObject1);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.g);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject2, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(c, 1, "getGameMsgTabConfig err: ", localException);
    }
  }
  
  public long d()
  {
    String str = this.f.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = this.f.getApplication().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("sp_key_get_tab_config_interval");
    return localSharedPreferences.getLong(localStringBuilder.toString(), 1200L);
  }
  
  public long e()
  {
    String str = this.f.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = this.f.getApplication().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("sp_key_last_get_tab_config_timestamp");
    this.d = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    return this.d;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "sendProfileGuideShowed");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.8.17");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localUniSsoServerReq.reqdata.set("");
      localObject = new NewIntent(this.f.getApp(), GameCenterUnissoServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "GameCenterMsg.SetQQCardPopSwitch");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.f.startServlet((NewIntent)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(c, 1, localThrowable.getMessage());
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GameCenterUnissoObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).removeListener(this.g);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler
 * JD-Core Version:    0.7.0.1
 */