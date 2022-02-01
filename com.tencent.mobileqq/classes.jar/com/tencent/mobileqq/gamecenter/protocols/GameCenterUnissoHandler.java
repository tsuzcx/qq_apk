package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
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
import com.tencent.mobileqq.gamecenter.msgInfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.msgInfo.GameUserInfo;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;
import com.tencent.mobileqq.gamecenter.utils.CommUtils;
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
  private long jdField_a_of_type_Long = 0L;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private WadlTrpcListener jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener = new GameCenterUnissoHandler.1(this);
  private long b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("GameCenterUnissoHandler");
    c = localStringBuilder.toString();
  }
  
  public GameCenterUnissoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_b_of_type_Long = 1200L;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private GameDetailInfo a(GameUserInfo paramGameUserInfo)
  {
    if (paramGameUserInfo == null) {
      return null;
    }
    GameMsgManagerServiceImpl localGameMsgManagerServiceImpl = (GameMsgManagerServiceImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
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
    return (GameCenterUnissoHandler)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(jdField_a_of_type_JavaLangString);
  }
  
  private CommonReq a(long paramLong1, long paramLong2)
  {
    CommonReq localCommonReq = new CommonReq();
    try
    {
      localCommonReq.cpuCoreCount.set(DeviceInfoUtil.b());
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
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences("game_center_sp", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("sp_key_get_tab_config_interval");
    ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), paramLong);
    this.jdField_b_of_type_Long = paramLong;
  }
  
  private boolean a()
  {
    this.jdField_b_of_type_Long = a();
    this.jdField_a_of_type_Long = b();
    boolean bool;
    if (NetConnInfoCenter.getServerTime() - this.jdField_a_of_type_Long / 1000L < this.jdField_b_of_type_Long) {
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
      localStringBuilder.append(this.jdField_a_of_type_Long / 1000L);
      localStringBuilder.append(", interval = ");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void b(long paramLong)
  {
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences("game_center_sp", 0).edit();
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
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        paramIntent.ret.get();
        paramIntent = new JSONObject(paramIntent.rspdata.get());
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = c;
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("[handleGameStartPriority] root: ");
          paramArrayOfByte.append(paramIntent.toString());
          QLog.d(paramFromServiceMsg, 2, paramArrayOfByte.toString());
        }
        paramIntent = paramIntent.optJSONObject("GameInfo.GetGameStartPriority");
        if (paramIntent != null)
        {
          paramIntent = paramIntent.optJSONObject("rsp");
          if ((paramIntent != null) && (paramIntent.optInt("ret_code") == 0))
          {
            notifyUI(8227, true, paramIntent);
            return;
          }
        }
      }
      notifyUI(8227, false, null);
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.e(c, 1, "", paramIntent);
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
          paramIntent = new WebSSOAgent.UniSsoServerRsp();
          paramIntent.mergeFrom(paramArrayOfByte);
          paramIntent.ret.get();
          paramIntent = new JSONObject(paramIntent.rspdata.get()).optJSONObject("Aio.GetAioPop");
          if (paramIntent != null)
          {
            paramIntent = paramIntent.optJSONObject("rsp");
            if (paramIntent != null)
            {
              int i = paramIntent.optInt("ret_code");
              paramArrayOfByte = paramIntent.optString("err_msg");
              paramFromServiceMsg = paramIntent.optJSONObject("popinfo");
              if (i != 0)
              {
                paramIntent = c;
                paramFromServiceMsg = new StringBuilder();
                paramFromServiceMsg.append("errMsg:");
                paramFromServiceMsg.append(paramArrayOfByte);
                QLog.w(paramIntent, 1, paramFromServiceMsg.toString());
                return;
              }
              if (QLog.isColorLevel())
              {
                paramArrayOfByte = c;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("[handleAioPopInfo] popInfo: ");
                ((StringBuilder)localObject).append(paramFromServiceMsg.toString());
                QLog.d(paramArrayOfByte, 2, ((StringBuilder)localObject).toString());
              }
              paramArrayOfByte = paramIntent.optJSONObject("friend_info");
              Object localObject = paramIntent.optJSONArray("gray_tips_list");
              if (paramArrayOfByte != null) {
                notifyUI(8226, true, paramArrayOfByte);
              }
              if (paramFromServiceMsg != null) {
                notifyUI(8225, true, paramFromServiceMsg);
              }
              if (localObject != null) {
                notifyUI(8228, true, localObject);
              }
              notifyUI(8273, true, paramIntent.optString("desc"));
              paramFromServiceMsg = paramIntent.optJSONObject("stranger_recomd");
              if (paramFromServiceMsg != null) {
                notifyUI(8262, true, paramFromServiceMsg);
              }
              notifyUI(8261, true, paramIntent.optString("top_gray_tips"));
              notifyUI(8264, true, paramIntent.optJSONArray("head_icon_list"));
              return;
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
          paramIntent = new WebSSOAgent.UniSsoServerRsp();
          paramIntent.mergeFrom(paramArrayOfByte);
          long l = paramIntent.ret.get();
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = c;
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("ret:");
            paramArrayOfByte.append(l);
            QLog.d(paramFromServiceMsg, 2, paramArrayOfByte.toString());
          }
          if (new JSONObject(paramIntent.rspdata.get()).getJSONObject("UserInfo.SetSwitch").getJSONObject("rsp").optInt("ret_code") == 0)
          {
            notifyUI(8265, true, "");
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
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        paramIntent.ret.get();
        paramIntent = new JSONObject(paramIntent.rspdata.get()).getJSONObject("Aio.DealGameFriend").getJSONObject("rsp");
        int i = paramIntent.optInt("ret_code");
        int j = paramIntent.optInt("op_type");
        paramFromServiceMsg = paramIntent.optString("err_msg");
        paramArrayOfByte = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleAddOrShieldFriend], retCode:");
        localStringBuilder.append(i);
        localStringBuilder.append(",errMsg:");
        localStringBuilder.append(paramFromServiceMsg);
        localStringBuilder.append(",type:");
        localStringBuilder.append(j);
        QLog.i(paramArrayOfByte, 1, localStringBuilder.toString());
        notifyUI(8263, true, paramIntent);
        return;
      }
    }
    catch (Throwable paramIntent)
    {
      notifyUI(8263, false, null);
      QLog.e(c, 1, paramIntent.getMessage());
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
          paramIntent = new WebSSOAgent.UniSsoServerRsp();
          paramIntent.mergeFrom(paramArrayOfByte);
          paramIntent.ret.get();
          paramIntent = new JSONObject(paramIntent.rspdata.get()).getJSONObject("UserInfo.GetSwitch").getJSONObject("rsp");
          int i = paramIntent.optInt("ret_code");
          paramFromServiceMsg = paramIntent.optString("err_msg");
          paramIntent = paramIntent.optJSONObject("result_map").optJSONObject(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
          if (i != 0)
          {
            paramIntent = c;
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("errMsg:");
            paramArrayOfByte.append(paramFromServiceMsg);
            QLog.w(paramIntent, 1, paramArrayOfByte.toString());
            return;
          }
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = c;
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("[handleGetGameSwitch] result: ");
            paramArrayOfByte.append(paramIntent.toString());
            QLog.d(paramFromServiceMsg, 2, paramArrayOfByte.toString());
          }
          paramFromServiceMsg = new ArrayList();
          if (paramIntent != null)
          {
            paramArrayOfByte = paramIntent.keys();
            while (paramArrayOfByte.hasNext())
            {
              String str = (String)paramArrayOfByte.next();
              if (!TextUtils.isEmpty(str))
              {
                GameSwitchConfig localGameSwitchConfig = new GameSwitchConfig();
                JSONObject localJSONObject = paramIntent.getJSONObject(str);
                localGameSwitchConfig.mAppId = str;
                localGameSwitchConfig.mSyncSwitch = localJSONObject.optInt("switch");
                localGameSwitchConfig.mBlockSwitch = localJSONObject.optInt("qq_block_switch");
                localGameSwitchConfig.mBoxSwitch = localJSONObject.optInt("box_switch");
                localGameSwitchConfig.print();
                paramFromServiceMsg.add(localGameSwitchConfig);
              }
            }
            ((GameMsgManagerServiceImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).saveOrUpdateGameSwitchConfigs(paramFromServiceMsg);
          }
          notifyUI(8272, true, "");
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
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "[handleGetUserInfoRsp]");
    }
    for (;;)
    {
      try
      {
        l1 = System.currentTimeMillis();
        paramIntent = (GameMsgManagerServiceImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
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
          localObject2 = new ArrayList();
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
              ((ArrayList)localObject2).add(localObject4);
              continue;
            }
            paramIntent.saveOrUpdateGameBasicConfigs((ArrayList)localObject2);
          }
          localObject3 = paramFromServiceMsg.optJSONArray("result_list");
          localObject2 = new ArrayList();
          if (localObject3 == null) {
            break label780;
          }
          i = ((JSONArray)localObject3).length();
          paramArrayOfByte = new ArrayList();
          j = 0;
          paramFromServiceMsg = paramIntent;
          paramIntent = (Intent)localObject2;
          localObject2 = localObject3;
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
            str1 = ((JSONObject)localObject6).optString("nick");
            str2 = ((JSONObject)localObject6).optString("face_url");
            str3 = ((JSONObject)localObject6).optString("role_id");
          }
        }
      }
      catch (Throwable paramIntent)
      {
        long l1;
        Object localObject2;
        Object localObject3;
        Object localObject5;
        Object localObject4;
        int j;
        Object localObject6;
        int k;
        int m;
        long l2;
        int n;
        String str1;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        QLog.e(c, 1, paramIntent.getMessage());
      }
      try
      {
        str4 = ((JSONObject)localObject6).optString("partition_name");
        str5 = ((JSONObject)localObject6).optJSONObject("game_profile").optString("level_pic");
        str6 = ((JSONObject)localObject6).optJSONObject("game_profile").getString("level_text");
        localObject6 = ((JSONObject)localObject6).optString("online_desc");
        ((GameUserInfo)localObject3).mUin = ((String)localObject4);
        ((GameUserInfo)localObject3).mRoleId = str3;
        ((GameUserInfo)localObject3).mAppId = ((String)localObject5);
        ((GameUserInfo)localObject3).mUpdateTs = l2;
        ((GameUserInfo)localObject3).mFaceUrl = str2;
        ((GameUserInfo)localObject3).mSex = m;
        ((GameUserInfo)localObject3).mNickInGame = str1;
        ((GameUserInfo)localObject3).mOnlineType = k;
        ((GameUserInfo)localObject3).mPartitioName = str4;
        ((GameUserInfo)localObject3).mLevelPic = str5;
        ((GameUserInfo)localObject3).mLevelText = str6;
        ((GameUserInfo)localObject3).mSaveTs = l1;
        ((GameUserInfo)localObject3).mSwitchInGame = n;
        ((GameUserInfo)localObject3).mOnLineDesc = ((String)localObject6);
        ((GameUserInfo)localObject3).print();
        try
        {
          localObject4 = a((GameUserInfo)localObject3);
          if (localObject4 == null) {
            break label773;
          }
          paramArrayOfByte.add(localObject4);
          paramIntent.add(localObject3);
          j += 1;
        }
        catch (Throwable paramIntent)
        {
          continue;
        }
        localObject2 = paramIntent;
        localObject1 = paramFromServiceMsg;
        if (paramArrayOfByte.size() > 0)
        {
          notifyUI(8224, true, paramArrayOfByte);
          localObject2 = paramIntent;
          localObject1 = paramFromServiceMsg;
        }
        if (localObject1 == null) {
          break label772;
        }
        ((GameMsgManagerServiceImpl)localObject1).saveOrUpdateGameUsrInfoArrays((ArrayList)localObject2);
        return;
      }
      catch (Throwable paramIntent)
      {
        continue;
      }
      return;
      label772:
      return;
      label773:
      continue;
      label780:
      Object localObject1 = paramIntent;
    }
  }
  
  public long a()
  {
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("sp_key_get_tab_config_interval");
    return localSharedPreferences.getLong(localStringBuilder.toString(), 1200L);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "[getGameSwitch]");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.7.0");
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
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "GameCenterMsg.GetSwitch");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(c, 1, localThrowable.getMessage());
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[addOrShieldFriend], type:");
      ((StringBuilder)localObject2).append(paramInt);
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.7.0");
      localObject1 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
      localObject2 = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("op_type", paramInt);
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
      paramString1 = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
      paramString1.putExtra("cmd", "GameCenterMsg.DealGameFriend");
      paramString1.putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString1);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e(c, 1, paramString1.getMessage());
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
          ((GameMsgManagerServiceImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).saveOrUpdateTabConfigs(paramIntent);
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
  
  public void a(String paramString)
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
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.7.0");
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
      paramString = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
      paramString.putExtra("cmd", "GameCenterMsg.GetGameStartPriority");
      paramString.putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(c, 1, paramString.getMessage());
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[setGameSwitch] synSwitch: ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(",blockSwitch:");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    try
    {
      localObject2 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.7.0");
      localObject1 = new WebSSOAgent.UniSsoServerReq();
      ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
      localObject2 = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", paramString);
      localJSONObject.put("switch_type", paramInt1);
      localJSONObject.put("qq_block_switch_type", paramInt2);
      paramString = new JSONObject();
      paramString.put("req", localJSONObject);
      ((JSONObject)localObject2).put("UserInfo.SetSwitch", paramString);
      ((WebSSOAgent.UniSsoServerReq)localObject1).reqdata.set(((JSONObject)localObject2).toString());
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, ((JSONObject)localObject2).toString());
      }
      paramString = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
      paramString.putExtra("cmd", "GameCenterMsg.SetSwitch");
      paramString.putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(c, 1, paramString.getMessage());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getGameUserInfo] from svr mid: ");
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
        ((WebSSOAgent.UniSsoServerReqComm)localObject2).mqqver.set("8.7.0");
        localObject1 = new WebSSOAgent.UniSsoServerReq();
        ((WebSSOAgent.UniSsoServerReq)localObject1).comm.set((MessageMicro)localObject2);
        localObject2 = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("me_roleid", paramString1);
        localJSONObject.put("friend_roleid", paramString2);
        paramString1 = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
        if (paramString1 != null) {
          localJSONObject.put("skey", paramString1.getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
        }
        paramString1 = new JSONObject();
        paramString1.put("req", localJSONObject);
        ((JSONObject)localObject2).put("Aio.GetAioPop", paramString1);
        ((WebSSOAgent.UniSsoServerReq)localObject1).reqdata.set(((JSONObject)localObject2).toString());
        if (QLog.isColorLevel()) {
          QLog.d(c, 2, ((JSONObject)localObject2).toString());
        }
        paramString1 = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
        paramString1.putExtra("cmd", "GameCenterMsg.GetAioPop");
        paramString1.putExtra("data", ((WebSSOAgent.UniSsoServerReq)localObject1).toByteArray());
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString1);
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e(c, 1, paramString1.getMessage());
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
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
        ((WebSSOAgent.UniSsoServerReqComm)localObject1).mqqver.set("8.7.0");
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
        paramArrayList = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
        paramArrayList.putExtra("cmd", "GameCenterMsg.GetUserInfo");
        paramArrayList.putExtra("data", localUniSsoServerReq.toByteArray());
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramArrayList);
        return;
      }
      catch (Throwable paramArrayList)
      {
        QLog.e(c, 1, paramArrayList.getMessage());
      }
    }
  }
  
  public long b()
  {
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("sp_key_last_get_tab_config_timestamp");
    this.jdField_a_of_type_Long = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    return this.jdField_a_of_type_Long;
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    b(this.jdField_a_of_type_Long);
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
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject2, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e(c, 1, "getGameMsgTabConfig err: ", localException);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GameCenterUnissoObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler
 * JD-Core Version:    0.7.0.1
 */