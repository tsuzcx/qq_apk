package com.tencent.mobileqq.gamecenter.protocol;

import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.hippy.qq.update.HippyQQUpdateManager;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.HippyUpdateManager.TabFile;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gamecenter.message.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.message.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.message.GameUserInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfReq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameCenterUnissoHandler
  extends BusinessHandler
{
  private static GameCenterUnissoHandler jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGameCenterUnissoHandler = null;
  public static String a;
  private static String b;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private WadlTrpcListener jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener = new GameCenterUnissoHandler.1(this);
  
  static
  {
    jdField_a_of_type_JavaLangString = "GameCenterMsg.";
    b = jdField_a_of_type_JavaLangString + "GameCenterUnissoHandler";
  }
  
  public GameCenterUnissoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private GameDetailInfo a(GameUserInfo paramGameUserInfo)
  {
    if (paramGameUserInfo == null) {
      return null;
    }
    GameMsgManager localGameMsgManager = (GameMsgManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    if (GameUserInfo.isUsrInfoUpdate(localGameMsgManager.a(paramGameUserInfo.mRoleId), paramGameUserInfo))
    {
      QLog.i(b, 1, "[notifyGameUsrInfoChanged], roleId:" + paramGameUserInfo.mRoleId);
      return GameDetailInfo.a(localGameMsgManager.a(paramGameUserInfo.mAppId), paramGameUserInfo);
    }
    return null;
  }
  
  public static GameCenterUnissoHandler a()
  {
    AppInterface localAppInterface = HippyReporter.getAppInterface();
    if ((localAppInterface instanceof QQAppInterface)) {
      return (GameCenterUnissoHandler)((QQAppInterface)localAppInterface).getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER);
    }
    if (localAppInterface != null)
    {
      if (jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGameCenterUnissoHandler == null) {}
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGameCenterUnissoHandler == null) {
          jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGameCenterUnissoHandler = new GameCenterUnissoHandler(localAppInterface);
        }
        return jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGameCenterUnissoHandler;
      }
      finally {}
    }
    return null;
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
      localCommonReq.qqVersion.set(DeviceInfoUtil.a(BaseApplicationImpl.getContext()));
      localCommonReq.totalMemory.set((int)(DeviceInfoUtil.a() / 1048576L));
      localCommonReq.lastPreDownloadTime.set(paramLong1);
      localCommonReq.lastUpdateTime.set(paramLong2);
      return localCommonReq;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("hippyUpdateAction-" + b, 1, "createCommonHippyReq e:" + localThrowable);
    }
    return localCommonReq;
  }
  
  private MobileConfReq a()
  {
    MobileConfReq localMobileConfReq = new MobileConfReq();
    try
    {
      localMobileConfReq.configType.set(1);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("qqGameCenterBundleVersion", UpdateSetting.getInstance().getModuleVersion("QQGameCenter"));
      localMobileConfReq.busiReq.set(localJSONObject.toString());
      if (QLog.isColorLevel()) {
        QLog.d("hippyUpdateAction-" + b, 0, "[createPreloadConfigReq] hippyConfig: " + localJSONObject);
      }
      return localMobileConfReq;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("hippyUpdateAction-" + b, 1, "createHippyConfigReq e:" + localThrowable);
    }
    return localMobileConfReq;
  }
  
  private MobileConfReq a(int paramInt1, Map<String, Integer> paramMap, int paramInt2)
  {
    MobileConfReq localMobileConfReq = new MobileConfReq();
    JSONObject localJSONObject1;
    do
    {
      try
      {
        localMobileConfReq.configType.set(2);
        localJSONObject1 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        if ((paramMap != null) && (paramMap.size() > 0))
        {
          Iterator localIterator = paramMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("bundleName", str);
            localJSONObject2.put("bundleVersion", paramMap.get(str));
            localJSONArray.put(localJSONObject2);
          }
        }
        localJSONObject1.put("bundleList", localJSONArray);
      }
      catch (Throwable paramMap)
      {
        QLog.e("hippyUpdateAction-" + b, 1, "createPreloadConfigReq e:" + paramMap);
        return localMobileConfReq;
      }
      localJSONObject1.put("sdkVersion", "3.0");
      localJSONObject1.put("channel", "10001");
      localJSONObject1.put("guid", HippyQQUpdateManager.getGuid());
      localJSONObject1.put("type", paramInt2);
      localJSONObject1.put("source", paramInt1);
      localMobileConfReq.busiReq.set(localJSONObject1.toString());
    } while (!QLog.isColorLevel());
    QLog.d("hippyUpdateAction-" + b, 0, "[createPreloadConfigReq] hippyBundleJson: " + localJSONObject1);
    return localMobileConfReq;
  }
  
  private MobileConfReq a(Map<String, String> paramMap)
  {
    MobileConfReq localMobileConfReq = new MobileConfReq();
    JSONObject localJSONObject1;
    try
    {
      localMobileConfReq.configType.set(3);
      localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      if ((paramMap != null) && (paramMap.size() > 0))
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, paramMap.get(str));
        }
      }
      localJSONObject1.put("tabFileMd5", localJSONObject2);
    }
    catch (Throwable paramMap)
    {
      QLog.e("hippyUpdateAction-" + b, 1, "createTabConfigReq e:" + paramMap);
      return localMobileConfReq;
    }
    localJSONObject1.put("source", 1);
    localMobileConfReq.busiReq.set(localJSONObject1.toString());
    return localMobileConfReq;
  }
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[handleGameStartPriority]");
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
        if (QLog.isColorLevel()) {
          QLog.d(b, 0, "[handleGameStartPriority] root: " + paramIntent.toString());
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
      QLog.e(b, 1, "", paramIntent);
    }
  }
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[handleAioPopInfo]");
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
                QLog.w(b, 1, "errMsg:" + paramArrayOfByte);
                return;
              }
              if (QLog.isColorLevel()) {
                QLog.d(b, 0, "[handleAioPopInfo] popInfo: " + paramFromServiceMsg.toString());
              }
              paramArrayOfByte = paramIntent.optJSONObject("friend_info");
              JSONArray localJSONArray = paramIntent.optJSONArray("gray_tips_list");
              if (paramArrayOfByte != null) {
                notifyUI(8226, true, paramArrayOfByte);
              }
              if (paramFromServiceMsg != null) {
                notifyUI(8225, true, paramFromServiceMsg);
              }
              if (localJSONArray != null) {
                notifyUI(8228, true, localJSONArray);
              }
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
        QLog.e(b, 1, paramIntent.getMessage());
      }
    }
  }
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GameMsgChatPie.f, 0, "[handleSetSwitch]");
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {}
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        long l = paramIntent.ret.get();
        if (QLog.isColorLevel()) {
          QLog.d(GameMsgChatPie.f, 0, "ret:" + l);
        }
        if (new JSONObject(paramIntent.rspdata.get()).getJSONObject("UserInfo.SetSwitch").getJSONObject("rsp").optInt("ret_code") == 0) {
          notifyUI(8265, true, "");
        }
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      QLog.e(GameMsgChatPie.f, 1, paramIntent.getMessage());
    }
  }
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GameMsgChatPie.g, 0, "[handleAddOrShieldFriend]");
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null)) {}
    try
    {
      if (paramFromServiceMsg.isSuccess())
      {
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        paramIntent.ret.get();
        paramIntent = new JSONObject(paramIntent.rspdata.get()).getJSONObject("Aio.DealGameFriend").getJSONObject("rsp");
        int i = paramIntent.optInt("ret_code");
        int j = paramIntent.optInt("op_type");
        paramFromServiceMsg = paramIntent.optString("err_msg");
        QLog.i(GameMsgChatPie.g, 1, "[handleAddOrShieldFriend], retCode:" + i + ",errMsg:" + paramFromServiceMsg + ",type:" + j);
        notifyUI(8263, true, paramIntent);
      }
      return;
    }
    catch (Throwable paramIntent)
    {
      notifyUI(8263, false, null);
      QLog.e(GameMsgChatPie.g, 1, paramIntent.getMessage());
    }
  }
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[handleGetGameSwitch]");
    }
    if ((paramArrayOfByte != null) && (paramFromServiceMsg != null))
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          return;
        }
        paramIntent = new WebSSOAgent.UniSsoServerRsp();
        paramIntent.mergeFrom(paramArrayOfByte);
        paramIntent.ret.get();
        paramIntent = new JSONObject(paramIntent.rspdata.get()).getJSONObject("UserInfo.GetSwitch").getJSONObject("rsp");
        int i = paramIntent.optInt("ret_code");
        paramFromServiceMsg = paramIntent.optString("err_msg");
        paramIntent = paramIntent.optJSONObject("result_map").optJSONObject(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        if (i != 0)
        {
          QLog.w(b, 1, "errMsg:" + paramFromServiceMsg);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d(b, 0, "[handleGetGameSwitch] result: " + paramIntent.toString());
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
              localGameSwitchConfig.print();
              paramFromServiceMsg.add(localGameSwitchConfig);
            }
          }
          ((GameMsgManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).c(paramFromServiceMsg);
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e(b, 1, paramIntent.getMessage());
        return;
      }
      notifyUI(8272, true, "");
    }
  }
  
  private void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[handleGetUserInfoRsp]");
    }
    long l1;
    int i;
    ArrayList localArrayList;
    Object localObject1;
    Object localObject3;
    Object localObject2;
    try
    {
      l1 = System.currentTimeMillis();
      paramIntent = (GameMsgManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
      if ((paramArrayOfByte == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
        return;
      }
      paramFromServiceMsg = new WebSSOAgent.UniSsoServerRsp();
      paramFromServiceMsg.mergeFrom(paramArrayOfByte);
      paramFromServiceMsg.ret.get();
      paramFromServiceMsg = new JSONObject(paramFromServiceMsg.rspdata.get());
      if (QLog.isColorLevel()) {
        QLog.d(b, 0, paramFromServiceMsg.toString());
      }
      paramFromServiceMsg = paramFromServiceMsg.getJSONObject("UserInfo.GetUserInfo").getJSONObject("rsp");
      i = paramFromServiceMsg.optInt("ret_code");
      paramArrayOfByte = paramFromServiceMsg.optString("err_msg");
      if (i != 0)
      {
        QLog.w(b, 1, "errMsg:" + paramArrayOfByte);
        return;
      }
      paramArrayOfByte = paramFromServiceMsg.optJSONObject("game_config");
      localArrayList = new ArrayList();
      if (paramArrayOfByte != null)
      {
        localObject1 = paramArrayOfByte.keys();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject2 = new GameBasicInfo();
            ((GameBasicInfo)localObject2).mAppId = ((String)localObject3);
            localObject3 = paramArrayOfByte.getJSONObject((String)localObject3);
            ((GameBasicInfo)localObject2).mName = ((JSONObject)localObject3).optString("name");
            ((GameBasicInfo)localObject2).mIconUrl = ((JSONObject)localObject3).optString("icon");
            ((GameBasicInfo)localObject2).mMsgMaxLen = ((JSONObject)localObject3).optInt("msg_max_len");
            ((GameBasicInfo)localObject2).mUpdateTs = ((JSONObject)localObject3).optLong("data_update_ts");
            ((GameBasicInfo)localObject2).mStartGameUrl = ((JSONObject)localObject3).optString("zone_url");
            ((GameBasicInfo)localObject2).print();
            localArrayList.add(localObject2);
          }
        }
        paramIntent.b(localArrayList);
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e(b, 1, paramIntent.getMessage());
      return;
    }
    paramFromServiceMsg = paramFromServiceMsg.optJSONArray("result_list");
    paramArrayOfByte = new ArrayList();
    if (paramFromServiceMsg != null)
    {
      int j = paramFromServiceMsg.length();
      localArrayList = new ArrayList();
      i = 0;
      while (i < j)
      {
        localObject1 = new GameUserInfo();
        Object localObject4 = paramFromServiceMsg.getJSONObject(i);
        localObject2 = ((JSONObject)localObject4).optString("uin");
        int k = ((JSONObject)localObject4).optInt("online_type");
        int m = ((JSONObject)localObject4).optInt("sex");
        long l2 = ((JSONObject)localObject4).optLong("data_update_ts");
        int n = ((JSONObject)localObject4).optInt("msgsync_switch");
        localObject3 = ((JSONObject)localObject4).optString("appid");
        String str1 = ((JSONObject)localObject4).optString("nick");
        String str2 = ((JSONObject)localObject4).optString("face_url");
        String str3 = ((JSONObject)localObject4).optString("role_id");
        String str4 = ((JSONObject)localObject4).optString("partition_name");
        String str5 = ((JSONObject)localObject4).optJSONObject("game_profile").optString("level_pic");
        String str6 = ((JSONObject)localObject4).optJSONObject("game_profile").getString("level_text");
        localObject4 = ((JSONObject)localObject4).optString("online_desc");
        ((GameUserInfo)localObject1).mUin = ((String)localObject2);
        ((GameUserInfo)localObject1).mRoleId = str3;
        ((GameUserInfo)localObject1).mAppId = ((String)localObject3);
        ((GameUserInfo)localObject1).mUpdateTs = l2;
        ((GameUserInfo)localObject1).mFaceUrl = str2;
        ((GameUserInfo)localObject1).mSex = m;
        ((GameUserInfo)localObject1).mNickInGame = str1;
        ((GameUserInfo)localObject1).mOnlineType = k;
        ((GameUserInfo)localObject1).mPartitioName = str4;
        ((GameUserInfo)localObject1).mLevelPic = str5;
        ((GameUserInfo)localObject1).mLevelText = str6;
        ((GameUserInfo)localObject1).mSaveTs = l1;
        ((GameUserInfo)localObject1).mSwitchInGame = n;
        ((GameUserInfo)localObject1).mOnLineDesc = ((String)localObject4);
        ((GameUserInfo)localObject1).print();
        localObject2 = a((GameUserInfo)localObject1);
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
        paramArrayOfByte.add(localObject1);
        i += 1;
      }
      if (localArrayList.size() > 0) {
        notifyUI(8224, true, localArrayList);
      }
    }
    if (paramIntent != null) {
      paramIntent.a(paramArrayOfByte);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[getGameSwitch]");
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("req", new JSONObject());
      ((JSONObject)localObject).put("UserInfo.GetSwitch", localJSONObject);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(b, 0, ((JSONObject)localObject).toString());
      }
      localObject = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
      ((NewIntent)localObject).putExtra("cmd", "GameCenterMsg.GetSwitch");
      ((NewIntent)localObject).putExtra("data", localUniSsoServerReq.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(b, 1, localThrowable.getMessage());
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hippyUpdateAction-" + b, 0, "[requestHippyConfig]");
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("hippyUpdateAction-" + b, 1, "[requestHippyConfig] moduleName is empty, return.");
      return;
    }
    Object localObject2 = "";
    try
    {
      Object localObject3 = HippyUpdateManager.getInstance().getTabFilesConfig();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Map)localObject3).containsKey(paramString)) {
          localObject1 = ((HippyUpdateManager.TabFile)((Map)localObject3).get(paramString)).tabFileMd5;
        }
      }
      localObject2 = new HashMap();
      ((Map)localObject2).put(paramString, localObject1);
      localObject1 = a((Map)localObject2);
      localObject2 = a();
      localObject3 = new HashMap();
      ((Map)localObject3).put(paramString, Integer.valueOf(paramInt2));
      paramString = a(paramInt1, (Map)localObject3, 2);
      localObject3 = new CommonMobileConfQueryReq();
      CommonReq localCommonReq = a(0L, paramLong);
      ((CommonMobileConfQueryReq)localObject3).commonReq.set(localCommonReq);
      ((CommonMobileConfQueryReq)localObject3).reqConfList.add(paramString);
      ((CommonMobileConfQueryReq)localObject3).reqConfList.add((MessageMicro)localObject2);
      ((CommonMobileConfQueryReq)localObject3).reqConfList.add((MessageMicro)localObject1);
      paramString = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/33", false, ((CommonMobileConfQueryReq)localObject3).toByteArray());
      localObject1 = new TrpcProxy.TrpcListReq();
      ((TrpcProxy.TrpcListReq)localObject1).list.add(paramString);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject1, paramBundle);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("hippyUpdateAction-" + b, 1, paramString.toString());
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(GameMsgChatPie.g, 0, "[addOrShieldFriend], type:" + paramInt + ",friRoleId:" + paramString1 + ",myRoleId:" + paramString2 + ",message:" + paramString3);
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("op_type", paramInt);
      localJSONObject.put("to_roleid", paramString1);
      localJSONObject.put("roleid", paramString2);
      localJSONObject.put("text", paramString3);
      paramString1 = new JSONObject();
      paramString1.put("req", localJSONObject);
      ((JSONObject)localObject).put("Aio.DealGameFriend", paramString1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(b, 0, ((JSONObject)localObject).toString());
      }
      paramString1 = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
      paramString1.putExtra("cmd", "GameCenterMsg.DealGameFriend");
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString1);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e(b, 1, paramString1.getMessage());
    }
  }
  
  public void a(int paramInt, Map<String, Integer> paramMap, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("hippyUpdateAction-" + b, 0, "[requestPreDownloadConfig]");
    }
    try
    {
      Object localObject = a(paramLong, 0L);
      MobileConfReq localMobileConfReq = a();
      paramMap = a(paramInt, paramMap, 1);
      CommonMobileConfQueryReq localCommonMobileConfQueryReq = new CommonMobileConfQueryReq();
      localCommonMobileConfQueryReq.commonReq.set((MessageMicro)localObject);
      localCommonMobileConfQueryReq.reqConfList.add(localMobileConfReq);
      localCommonMobileConfQueryReq.reqConfList.add(paramMap);
      paramMap = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/33", false, localCommonMobileConfQueryReq.toByteArray());
      localObject = new TrpcProxy.TrpcListReq();
      ((TrpcProxy.TrpcListReq)localObject).list.add(paramMap);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc((TrpcProxy.TrpcListReq)localObject, paramBundle);
      return;
    }
    catch (Throwable paramMap)
    {
      QLog.e("hippyUpdateAction-" + b, 1, paramMap.toString());
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    String str = paramIntent.getStringExtra("cmd");
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(b, 0, "[onReceive], cmd:" + str);
      }
      if ("GameCenterMsg.GetUserInfo".equals(str))
      {
        g(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("GameCenterMsg.GetSwitch".equals(str))
      {
        f(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("GameCenterMsg.GetAioPop".equals(str))
      {
        c(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("GameCenterMsg.GetGameStartPriority".equals(str))
      {
        b(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
      if ("GameCenterMsg.DealGameFriend".equals(str))
      {
        e(paramIntent, paramFromServiceMsg, paramArrayOfByte);
        return;
      }
    } while (!"GameCenterMsg.SetSwitch".equals(str));
    d(paramIntent, paramFromServiceMsg, paramArrayOfByte);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[getGameStartPriority] appid: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", paramString);
      paramString = new JSONObject();
      paramString.put("req", localJSONObject);
      ((JSONObject)localObject).put("GameInfo.GetGameStartPriority", paramString);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(b, 0, ((JSONObject)localObject).toString());
      }
      paramString = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
      paramString.putExtra("cmd", "GameCenterMsg.GetGameStartPriority");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(b, 1, paramString.getMessage());
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[setGameSwitch] synSwitch: " + paramInt1 + ",blockSwitch:" + paramInt2);
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", paramString);
      localJSONObject.put("switch_type", paramInt1);
      localJSONObject.put("qq_block_switch_type", paramInt2);
      paramString = new JSONObject();
      paramString.put("req", localJSONObject);
      ((JSONObject)localObject).put("UserInfo.SetSwitch", paramString);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(b, 0, ((JSONObject)localObject).toString());
      }
      paramString = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
      paramString.putExtra("cmd", "GameCenterMsg.SetSwitch");
      paramString.putExtra("data", localUniSsoServerReq.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e(b, 1, paramString.getMessage());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[getGameUserInfo] from svr mid: " + paramString1 + ",fid:" + paramString2);
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("me_roleid", paramString1);
      localJSONObject.put("friend_roleid", paramString2);
      paramString1 = (TicketManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(2);
      if (paramString1 != null) {
        localJSONObject.put("skey", paramString1.getSkey(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
      }
      paramString1 = new JSONObject();
      paramString1.put("req", localJSONObject);
      ((JSONObject)localObject).put("Aio.GetAioPop", paramString1);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      if (QLog.isColorLevel()) {
        QLog.d(b, 0, ((JSONObject)localObject).toString());
      }
      paramString1 = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
      paramString1.putExtra("cmd", "GameCenterMsg.GetAioPop");
      paramString1.putExtra("data", localUniSsoServerReq.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramString1);
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e(b, 1, paramString1.getMessage());
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, "[getGameUserInfo] from svr");
    }
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    Object localObject1;
    WebSSOAgent.UniSsoServerReq localUniSsoServerReq;
    try
    {
      localObject1 = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject1).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject1).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject1).mqqver.set("8.5.5");
      localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject1);
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("role_id", str);
        ((JSONArray)localObject2).put(localJSONObject);
      }
      paramArrayList = new JSONObject();
    }
    catch (Throwable paramArrayList)
    {
      QLog.e(b, 1, paramArrayList.getMessage());
      return;
    }
    paramArrayList.put("is_need_game_config", true);
    paramArrayList.put("query_list", localObject2);
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("req", paramArrayList);
    ((JSONObject)localObject1).put("UserInfo.GetUserInfo", localObject2);
    localUniSsoServerReq.reqdata.set(((JSONObject)localObject1).toString());
    if (QLog.isColorLevel()) {
      QLog.d(b, 0, ((JSONObject)localObject1).toString());
    }
    paramArrayList = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
    paramArrayList.putExtra("cmd", "GameCenterMsg.GetUserInfo");
    paramArrayList.putExtra("data", localUniSsoServerReq.toByteArray());
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramArrayList);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = new WebSSOAgent.UniSsoServerReqComm();
      ((WebSSOAgent.UniSsoServerReqComm)localObject).platform.set(109L);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).osver.set(Build.VERSION.RELEASE);
      ((WebSSOAgent.UniSsoServerReqComm)localObject).mqqver.set("8.5.5.5105");
      WebSSOAgent.UniSsoServerReq localUniSsoServerReq = new WebSSOAgent.UniSsoServerReq();
      localUniSsoServerReq.comm.set((MessageMicro)localObject);
      localObject = new JSONObject();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("req", paramJSONObject);
      ((JSONObject)localObject).put("GameCenterHippy.Report", localJSONObject);
      localUniSsoServerReq.reqdata.set(((JSONObject)localObject).toString());
      paramJSONObject = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), GameCenterUnissoServlet.class);
      paramJSONObject.putExtra("cmd", "GameCenterHippy.Report");
      paramJSONObject.putExtra("data", localUniSsoServerReq.toByteArray());
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramJSONObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return GameCenterUnissoObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).removeListener(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler
 * JD-Core Version:    0.7.0.1
 */