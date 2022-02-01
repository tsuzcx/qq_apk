package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.config.GameCenterMsgBean;
import com.tencent.mobileqq.gamecenter.config.GameMsgTabConfig;
import com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper;
import com.tencent.mobileqq.gamecenter.data.GameQQPlayerUtils;
import com.tencent.mobileqq.gamecenter.data.IDataVisitor;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDelSessionRecord;
import com.tencent.mobileqq.gamecenter.msgInfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.msgInfo.GameUserInfo;
import com.tencent.mobileqq.gamecenter.msgInfo.TinyConvProxy;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;
import com.tencent.mobileqq.gamecenter.utils.GameMsgUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

@Service(process={"all"})
public class GameMsgManagerServiceImpl
  implements IGameMsgManagerService, Observer
{
  public static final int GAME_SWITCH_PULL_INTERVAL = 300000;
  public static final int GAME_USER_INFO_PULL_INTERVAL = 120000;
  public static final String SP_KEY_ENTER_PUB = "sp_enter_pub";
  public static final String SP_KEY_PUBACC_MSG_REDPOINT = "sp_pubacc_msg_redpoint";
  public static final String SP_KEY_REQ_MSG_READ_TIME = "sp_key_req_msg_read_time";
  public static final String SP_KEY_REQ_MSG_R_VALUE = "sp_key_req_msg_unread_num";
  private static final String TAG;
  private AppInterface mApp;
  private EntityManager mEntityMgr;
  private Map<String, GameCenterSessionInfo> mFolderMap = new ConcurrentHashMap();
  private Map<String, GameBasicInfo> mGameBasicConfigCache = Collections.synchronizedMap(new HashMap());
  private Map<String, GameSwitchConfig> mGameSwitchConfigCache = Collections.synchronizedMap(new HashMap());
  private long mGameSwitchLastUpdateTime = 0L;
  private Map<String, GameUserInfo> mGameUserInfoMapCache = Collections.synchronizedMap(new HashMap());
  private Runnable mInitTask = new GameMsgManagerServiceImpl.2(this);
  private boolean mInited = false;
  public boolean mIsHasUnreadMsg = false;
  private long mLastPullTS = 0L;
  private GameCenterMsgBean mMsgConfig = new GameCenterMsgBean();
  private boolean mMsgShowedOnList = false;
  public boolean mNeedPopMsgView = false;
  private Map<String, GameCenterSessionInfo> mNormalMap = new ConcurrentHashMap();
  private int mPubMsgRedPointSwitch = 0;
  public GameQQPlayerUtils mQQPlayerUtil = new GameQQPlayerUtils();
  private Map<String, String> mRoleIdRedDotMap = Collections.synchronizedMap(new HashMap());
  private GameDelSessionDataHelper mSessionDelDataHelper;
  private GameCenterUnissoObserver mSessionInfoObserver = new GameMsgManagerServiceImpl.1(this);
  private Map<String, GameCenterSessionInfo> mSessionMap = new ConcurrentHashMap();
  public boolean mShowReqMsgUnread = false;
  private GameMsgTabConfig mTabConfig = new GameMsgTabConfig();
  private int mUnshowedUnreadCnt = 0;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(GameCenterUnissoHandler.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("GameMsgManager");
    TAG = localStringBuilder.toString();
  }
  
  private ArrayList<String> checkUsrInfoUpdateList(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      long l1 = System.currentTimeMillis();
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = findGameUserInfo(str);
        StringBuilder localStringBuilder;
        if (localObject == null)
        {
          localArrayList.add(str);
          localObject = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("case 1: can't find in local, roldId:");
          localStringBuilder.append(str);
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
        else
        {
          long l2 = l1 - ((GameUserInfo)localObject).mSaveTs;
          if (QLog.isColorLevel())
          {
            localObject = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("delta:");
            localStringBuilder.append(l2);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
          if (l2 >= 120000L)
          {
            localArrayList.add(str);
            localObject = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("case 2: it's time to update, roldId:");
            localStringBuilder.append(str);
            QLog.i((String)localObject, 2, localStringBuilder.toString());
          }
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private void deleteAllSession(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[deleteAllSession] gameId:");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = this.mSessionMap.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if (paramString.equals(localGameCenterSessionInfo.e()))
      {
        ((Iterator)localObject2).remove();
        ((IMessageFacade)localObject1).clearHistory(localGameCenterSessionInfo.d(), 10007);
      }
    }
    localObject1 = this.mNormalMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (paramString.equals(((GameCenterSessionInfo)((Map.Entry)((Iterator)localObject1).next()).getValue()).e())) {
        ((Iterator)localObject1).remove();
      }
    }
    localObject1 = this.mFolderMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (paramString.equals((String)((Map.Entry)((Iterator)localObject1).next()).getKey())) {
        ((Iterator)localObject1).remove();
      }
    }
  }
  
  private GameCenterSessionInfo getFolderSession(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.mFolderMap.size() == 0) {
      getSessionInfoList();
    }
    return (GameCenterSessionInfo)this.mFolderMap.get(paramString);
  }
  
  private String getFriendShowName(String paramString)
  {
    Object localObject = GameMsgUtil.a();
    String str = "";
    if (localObject == null) {
      return "";
    }
    localObject = ((IFriendDataService)((AppInterface)localObject).getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
    paramString = str;
    if (localObject != null)
    {
      if ((((Friends)localObject).remark != null) && (((Friends)localObject).remark.length() > 0)) {
        return ((Friends)localObject).remark;
      }
      paramString = str;
      if (((Friends)localObject).name != null)
      {
        paramString = str;
        if (((Friends)localObject).name.length() > 0) {
          paramString = ((Friends)localObject).name;
        }
      }
    }
    return paramString;
  }
  
  private HashMap<String, GameDetailInfo> getGameDetailInfo(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      HashMap localHashMap = new HashMap();
      boolean bool = false;
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject1 = findGameUserInfo(str);
        Object localObject2;
        if (localObject1 == null)
        {
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("usrInfo is null, roleId:");
          ((StringBuilder)localObject2).append(str);
          QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        }
        for (;;)
        {
          bool = true;
          break;
          localObject2 = findGameConfig(((GameUserInfo)localObject1).mAppId);
          if (localObject2 != null) {
            break label176;
          }
          str = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("basicinfp is null, appid:");
          ((StringBuilder)localObject2).append(((GameUserInfo)localObject1).mAppId);
          QLog.w(str, 1, ((StringBuilder)localObject2).toString());
        }
        label176:
        localHashMap.put(str, GameDetailInfo.a((GameBasicInfo)localObject2, (GameUserInfo)localObject1));
      }
      pullGameUsrInfoFromServer(bool, paramArrayList);
      return localHashMap;
    }
    return null;
  }
  
  private GameCenterSessionInfo getLastestSession(List<GameCenterSessionInfo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (GameCenterSessionInfo)localIterator.next();
      GameDelSessionRecord localGameDelSessionRecord = new GameDelSessionRecord();
      localGameDelSessionRecord.mUin = paramList.d();
      if (paramList != null) {
        if (!this.mSessionDelDataHelper.d(localGameDelSessionRecord)) {
          return paramList;
        }
      }
    }
    paramList = null;
    return paramList;
  }
  
  private List<ConversationInfo> getTinyConvInfoList()
  {
    return TinyConvProxy.a().a(this.mApp);
  }
  
  private void initGameBasicConfig()
  {
    try
    {
      Object localObject1 = (ArrayList)this.mEntityMgr.query(GameBasicInfo.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameBasicInfo)localObject2;
            if (!TextUtils.isEmpty(((GameBasicInfo)localObject2).mAppId)) {
              this.mGameBasicConfigCache.put(((GameBasicInfo)localObject2).mAppId, localObject2);
            }
          }
        }
        localObject1 = TAG;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("gameConfig.size:");
        ((StringBuilder)localObject2).append(this.mGameBasicConfigCache.size());
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, localThrowable.getMessage());
    }
  }
  
  private void initGameSwitchConfig()
  {
    try
    {
      Object localObject1 = (ArrayList)this.mEntityMgr.query(GameSwitchConfig.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameSwitchConfig)localObject2;
            if (!TextUtils.isEmpty(((GameSwitchConfig)localObject2).mAppId)) {
              this.mGameSwitchConfigCache.put(((GameSwitchConfig)localObject2).mAppId, localObject2);
            }
          }
        }
        localObject1 = TAG;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("gameSwitchConfig.size:");
        ((StringBuilder)localObject2).append(this.mGameSwitchConfigCache.size());
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, localThrowable.getMessage());
    }
  }
  
  private void initGameUserInfo()
  {
    try
    {
      Object localObject1 = (ArrayList)this.mEntityMgr.query(GameUserInfo.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameUserInfo)localObject2;
            if (!TextUtils.isEmpty(((GameUserInfo)localObject2).mRoleId)) {
              this.mGameUserInfoMapCache.put(((GameUserInfo)localObject2).mRoleId, localObject2);
            }
          }
        }
        localObject1 = TAG;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ursInfo.size:");
        ((StringBuilder)localObject2).append(this.mGameUserInfoMapCache.size());
        QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, localThrowable.getMessage());
    }
  }
  
  private void initTabCongif()
  {
    SharedPreferences localSharedPreferences = this.mApp.getApplication().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getCurrentAccountUin());
    localStringBuilder.append("sp_key_tab_config");
    this.mTabConfig = GameMsgTabConfig.a(localSharedPreferences.getString(localStringBuilder.toString(), ""));
  }
  
  private void notifyMessageChange(String paramString, GameCenterSessionInfo paramGameCenterSessionInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new Intent(paramString);
    ((Intent)localObject).setPackage(this.mApp.getApplication().getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_game_msg", paramGameCenterSessionInfo);
    localBundle.putInt("key_msg_change_type", paramInt1);
    localBundle.putInt("key_msg_unread_cnt", paramInt2);
    ((Intent)localObject).putExtras(localBundle);
    this.mApp.getApplication().sendBroadcast((Intent)localObject);
    paramGameCenterSessionInfo = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[notifyMessageChange] action:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",type:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",cnt:");
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i(paramGameCenterSessionInfo, 1, ((StringBuilder)localObject).toString());
  }
  
  private void setAllReaded(String paramString)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[setAllReaded] gameId:");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = this.mSessionMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (GameCenterSessionInfo)this.mSessionMap.get(localObject2);
      if (paramString.equals(((GameCenterSessionInfo)localObject2).e())) {
        setReaded((GameCenterSessionInfo)localObject2);
      }
    }
  }
  
  private void tryGetGameSwitchFromSvr()
  {
    if (!isGrayOpen())
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[tryGetGameSwitchFromSvr], not in gray whitelist, return.");
      }
      return;
    }
    if (System.currentTimeMillis() - this.mGameSwitchLastUpdateTime > 300000L)
    {
      QLog.i(TAG, 1, "[tryGetGameSwitchFromSvr]");
      GameCenterUnissoHandler.a().a();
      this.mGameSwitchLastUpdateTime = System.currentTimeMillis();
    }
  }
  
  private void updateGameConfigItem(GameBasicInfo paramGameBasicInfo)
  {
    if (paramGameBasicInfo != null)
    {
      if (TextUtils.isEmpty(paramGameBasicInfo.mAppId)) {
        return;
      }
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateGameConfigItem], appId:");
      localStringBuilder.append(paramGameBasicInfo.mAppId);
      QLog.i(str, 1, localStringBuilder.toString());
      this.mGameBasicConfigCache.put(paramGameBasicInfo.mAppId, paramGameBasicInfo);
      updateEntity(paramGameBasicInfo);
    }
  }
  
  private void updateGameUsrInfoItem(GameUserInfo paramGameUserInfo)
  {
    if (paramGameUserInfo != null)
    {
      if (TextUtils.isEmpty(paramGameUserInfo.mRoleId)) {
        return;
      }
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateGameUsrInfoItem], roleId:");
      localStringBuilder.append(paramGameUserInfo.mRoleId);
      QLog.i(str, 1, localStringBuilder.toString());
      this.mGameUserInfoMapCache.put(paramGameUserInfo.mRoleId, paramGameUserInfo);
      updateEntity(paramGameUserInfo);
    }
  }
  
  private void updateSessionInfo(GameCenterSessionInfo paramGameCenterSessionInfo, GameDetailInfo paramGameDetailInfo)
  {
    paramGameCenterSessionInfo.k(paramGameDetailInfo.jdField_b_of_type_JavaLangString);
    paramGameCenterSessionInfo.j(getFriendShowName(paramGameDetailInfo.jdField_b_of_type_JavaLangString));
    paramGameCenterSessionInfo.i(paramGameDetailInfo.e);
    paramGameCenterSessionInfo.f(paramGameDetailInfo.jdField_c_of_type_JavaLangString);
    paramGameCenterSessionInfo.e(paramGameDetailInfo.jdField_b_of_type_Int);
    paramGameCenterSessionInfo.h(paramGameDetailInfo.jdField_d_of_type_JavaLangString);
    paramGameCenterSessionInfo.g(paramGameDetailInfo.i);
    paramGameCenterSessionInfo.c(paramGameDetailInfo.k);
    paramGameCenterSessionInfo.a(paramGameDetailInfo.j);
  }
  
  public void cleanSessionUnread(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cleanSessionUnread] id:");
      localStringBuilder.append(paramString);
      QLog.d(str, 1, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.mApp != null)
    {
      paramString = getSessionInfoByUin(paramString);
      if (paramString == null) {
        return;
      }
      paramString.d(0);
      setUnshowedUnreadCnt(getUnreadCnt());
    }
  }
  
  public GameBasicInfo findGameConfig(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = (GameBasicInfo)this.mGameBasicConfigCache.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    QLog.i(TAG, 1, "try to read from db");
    localObject = this.mEntityMgr.find(GameBasicInfo.class, paramString);
    if (localObject != null)
    {
      localObject = (GameBasicInfo)localObject;
      this.mGameBasicConfigCache.put(paramString, localObject);
      return localObject;
    }
    QLog.i(TAG, 1, "fail to find gameCfg from db.");
    return null;
  }
  
  public GameSwitchConfig findGameSwitchConfig(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[findGameSwitchConfig], appId:");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = (GameSwitchConfig)this.mGameSwitchConfigCache.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    QLog.i(TAG, 1, "try to read from db");
    localObject = this.mEntityMgr.find(GameSwitchConfig.class, paramString);
    if (localObject != null)
    {
      localObject = (GameSwitchConfig)localObject;
      this.mGameSwitchConfigCache.put(paramString, localObject);
      return localObject;
    }
    QLog.i(TAG, 1, "fail to find gameCfg from db.");
    return null;
  }
  
  public GameUserInfo findGameUserInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = (GameUserInfo)this.mGameUserInfoMapCache.get(paramString);
    if (localObject != null) {
      return localObject;
    }
    QLog.i(TAG, 1, "try to read from db");
    localObject = this.mEntityMgr.find(GameUserInfo.class, paramString);
    if (localObject != null)
    {
      localObject = (GameUserInfo)localObject;
      this.mGameUserInfoMapCache.put(paramString, localObject);
      return localObject;
    }
    QLog.i(TAG, 1, "fail to find usrinfo from db.");
    return null;
  }
  
  public int getAIORedDotStyle()
  {
    Object localObject = this.mTabConfig;
    int i;
    if ((localObject != null) && (((GameMsgTabConfig)localObject).a() != null)) {
      i = Integer.valueOf((String)this.mTabConfig.a().get("style")).intValue();
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getAIOredDotStyle] ret = ");
      localStringBuilder.append(i);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public String getAIORedDotStyleId()
  {
    Object localObject = this.mTabConfig;
    if ((localObject != null) && (((GameMsgTabConfig)localObject).a() != null) && (this.mTabConfig.a().get("grayPolicyId") != null)) {
      localObject = (String)this.mTabConfig.a().get("grayPolicyId");
    } else {
      localObject = "";
    }
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getAIORedDotStyleId] ret = ");
      localStringBuilder.append((String)localObject);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public String getAioHippyBundleName()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if (localGameCenterMsgBean == null) {
      return null;
    }
    return localGameCenterMsgBean.f;
  }
  
  public String getAioHippyParameters()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if (localGameCenterMsgBean == null) {
      return null;
    }
    return localGameCenterMsgBean.g;
  }
  
  public ArrayList<String> getAioQuickReply(String paramString)
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if ((localGameCenterMsgBean != null) && (localGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      return (ArrayList)this.mMsgConfig.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public String getBoxMsgSwitchId()
  {
    Object localObject = this.mTabConfig;
    if ((localObject != null) && (((GameMsgTabConfig)localObject).b() != null) && (this.mTabConfig.b().get("grayPolicyId") != null)) {
      localObject = (String)this.mTabConfig.b().get("grayPolicyId");
    } else {
      localObject = "";
    }
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getBoxMsgSwitchId] ret = ");
      localStringBuilder.append((String)localObject);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public String getFriVerifyMsg(String paramString)
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if ((localGameCenterMsgBean != null) && (localGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      return (String)this.mMsgConfig.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public String getGameBuddyAppName()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if ((localGameCenterMsgBean != null) && (!TextUtils.isEmpty(localGameCenterMsgBean.e))) {
      return this.mMsgConfig.e;
    }
    return "\"玩伴\"小程序";
  }
  
  public String getGameMsgListUrl()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if ((localGameCenterMsgBean != null) && (!TextUtils.isEmpty(localGameCenterMsgBean.jdField_a_of_type_JavaLangString))) {
      return this.mMsgConfig.jdField_a_of_type_JavaLangString;
    }
    return "https://fastest.gamecenter.qq.com/_fst_/speed_gamecenter_qq_com/_fst_/pushgame/v1/home/msg?_wv=18950115&_wwv=393&_fst_id=194";
  }
  
  public String getGameMsgSettingUrl()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if ((localGameCenterMsgBean != null) && (!TextUtils.isEmpty(localGameCenterMsgBean.jdField_b_of_type_JavaLangString))) {
      return this.mMsgConfig.jdField_b_of_type_JavaLangString;
    }
    return "https://speed.gamecenter.qq.com/pushgame/v1/gamemsg-setting?_wv=2&_wwv=134";
  }
  
  public String getGamePrefix()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if ((localGameCenterMsgBean != null) && (!TextUtils.isEmpty(localGameCenterMsgBean.jdField_c_of_type_JavaLangString))) {
      return this.mMsgConfig.jdField_c_of_type_JavaLangString;
    }
    return "[游戏好友]";
  }
  
  public boolean getHasUnreadMsg()
  {
    return this.mIsHasUnreadMsg;
  }
  
  public GameCenterSessionInfo getLastSessionInfo()
  {
    if (this.mSessionMap.size() == 0) {
      getSessionInfoList();
    }
    Object localObject2 = new ArrayList(this.mFolderMap.values());
    Object localObject1 = new ArrayList(this.mNormalMap.values());
    Collections.sort((List)localObject2);
    Collections.sort((List)localObject1);
    if ((((List)localObject2).size() > 0) && (((List)localObject1).size() > 0))
    {
      localObject2 = (GameCenterSessionInfo)((List)localObject2).get(0);
      localObject1 = (GameCenterSessionInfo)((List)localObject1).get(0);
      if (((GameCenterSessionInfo)localObject2).a() > ((GameCenterSessionInfo)localObject1).a()) {
        return localObject2;
      }
      return localObject1;
    }
    if (((List)localObject2).size() > 0) {
      return (GameCenterSessionInfo)((List)localObject2).get(0);
    }
    if (((List)localObject1).size() > 0) {
      return (GameCenterSessionInfo)((List)localObject1).get(0);
    }
    return null;
  }
  
  public GameCenterSessionInfo getLastSessionInfoExceptDelSession()
  {
    if (this.mSessionMap.size() == 0) {
      getSessionInfoList();
    }
    Object localObject2 = new ArrayList(this.mFolderMap.values());
    Object localObject1 = new ArrayList(this.mNormalMap.values());
    Collections.sort((List)localObject2);
    Collections.sort((List)localObject1);
    localObject2 = getLastestSession((List)localObject2);
    localObject1 = getLastestSession((List)localObject1);
    if ((localObject2 != null) && (localObject1 != null))
    {
      if (((GameCenterSessionInfo)localObject2).a() > ((GameCenterSessionInfo)localObject1).a()) {
        return localObject2;
      }
      return localObject1;
    }
    if (localObject2 == null) {
      return localObject1;
    }
    return localObject2;
  }
  
  public boolean getMsgShowOnList()
  {
    return this.mMsgShowedOnList;
  }
  
  public boolean getNeedPopMsgView()
  {
    return this.mNeedPopMsgView;
  }
  
  public String getPlayerInfoUrl()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if (localGameCenterMsgBean != null) {
      return localGameCenterMsgBean.jdField_d_of_type_JavaLangString;
    }
    return "";
  }
  
  public String getRedDotConfig(String paramString)
  {
    String str = (String)this.mRoleIdRedDotMap.get(paramString);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public long getReqMsgCnt()
  {
    long l1 = GameMsgUtil.a(this.mApp.getCurrentAccountUin(), "sp_key_req_msg_unread_num");
    long l2 = GameMsgUtil.a(this.mApp.getCurrentAccountUin(), "sp_key_req_msg_read_time");
    if ((GameMsgUtil.a(l1)) && (!GameMsgUtil.a(l2)) && (this.mFolderMap.size() > 0)) {
      return 1L;
    }
    return 0L;
  }
  
  public IDataVisitor getSessionDelDataHelper()
  {
    return this.mSessionDelDataHelper;
  }
  
  public GameCenterSessionInfo getSessionInfoByRoleId(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getSessionInfoByRoleId] roleId:");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    boolean bool = TextUtils.isEmpty(paramString);
    StringBuilder localStringBuilder = null;
    if (bool) {
      return null;
    }
    if (this.mSessionMap.size() == 0) {
      getSessionInfoList();
    }
    Iterator localIterator = this.mSessionMap.keySet().iterator();
    do
    {
      localObject = localStringBuilder;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      localObject = (GameCenterSessionInfo)this.mSessionMap.get(localObject);
    } while (!paramString.equals(((GameCenterSessionInfo)localObject).c()));
    return localObject;
  }
  
  public GameCenterSessionInfo getSessionInfoByUin(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getSessionInfoByUin] sessionId:");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.mSessionMap.size() == 0) {
      getSessionInfoList();
    }
    return (GameCenterSessionInfo)this.mSessionMap.get(paramString);
  }
  
  public List<GameCenterSessionInfo> getSessionInfoList()
  {
    return getSessionInfoList(0, "");
  }
  
  public List<GameCenterSessionInfo> getSessionInfoList(int paramInt, String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[getSessionInfoList] type:");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(",gameId:");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("curSize:");
        ((StringBuilder)localObject2).append(this.mSessionMap.size());
        QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      if (!isGrayOpen())
      {
        paramString = new ArrayList();
        return paramString;
      }
      Object localObject2 = new ArrayList();
      Object localObject4;
      Object localObject5;
      if (this.mSessionMap.size() == 0)
      {
        localObject3 = getTinyConvInfoList();
        if ((localObject3 != null) && (((List)localObject3).size() != 0))
        {
          localObject1 = new HashSet();
          localObject4 = ((List)localObject3).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (ConversationInfo)((Iterator)localObject4).next();
            if ((((ConversationInfo)localObject5).tinyInfo != null) && (!TextUtils.isEmpty(((ConversationInfo)localObject5).tinyInfo.fromRoleId)))
            {
              ((Set)localObject1).add(((ConversationInfo)localObject5).tinyInfo.fromRoleId);
              ((Set)localObject1).add(((ConversationInfo)localObject5).tinyInfo.toRoleId);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject4 = TAG;
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("[getSessionInfoList] tinycon size:");
            ((StringBuilder)localObject5).append(((List)localObject3).size());
            ((StringBuilder)localObject5).append(" id size:");
            ((StringBuilder)localObject5).append(((Set)localObject1).size());
            QLog.d((String)localObject4, 2, ((StringBuilder)localObject5).toString());
          }
          localObject1 = getGameDetailInfo(new ArrayList((Collection)localObject1));
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (ConversationInfo)((Iterator)localObject3).next();
            if (localObject4 == null)
            {
              QLog.e(TAG, 1, "[getSessionInfoList] info is null, continue.");
            }
            else
            {
              if (QLog.isColorLevel())
              {
                localObject5 = TAG;
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append("[getSessionInfoList] info:");
                ((StringBuilder)localObject6).append(((ConversationInfo)localObject4).toString());
                QLog.d((String)localObject5, 1, ((StringBuilder)localObject6).toString());
              }
              localObject5 = new GameCenterSessionInfo();
              Object localObject6 = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
              if (localObject6 == null) {
                return null;
              }
              Object localObject7 = ((IMessageFacade)localObject6).getLastMessage(((ConversationInfo)localObject4).uin, ((ConversationInfo)localObject4).type);
              Object localObject8;
              if ((localObject7 != null) && ((localObject7 instanceof Message)))
              {
                localObject8 = ((Message)localObject7).emoRecentMsg;
                if (!TextUtils.isEmpty((CharSequence)localObject8)) {
                  ((GameCenterSessionInfo)localObject5).m(((CharSequence)localObject8).toString());
                }
                ((GameCenterSessionInfo)localObject5).a(((MessageRecord)localObject7).isSend());
                ((GameCenterSessionInfo)localObject5).b(((MessageRecord)localObject7).time);
              }
              localObject6 = ((IMessageFacade)localObject6).getFirstUnreadMessage(((ConversationInfo)localObject4).uin, ((ConversationInfo)localObject4).type);
              if (localObject6 != null)
              {
                localObject7 = ((Message)localObject6).emoRecentMsg;
                if (!TextUtils.isEmpty((CharSequence)localObject7)) {
                  ((GameCenterSessionInfo)localObject5).l(((CharSequence)localObject7).toString());
                }
                ((GameCenterSessionInfo)localObject5).a(((Message)localObject6).time);
              }
              ((GameCenterSessionInfo)localObject5).e(((ConversationInfo)localObject4).uin);
              ((GameCenterSessionInfo)localObject5).b(((ConversationInfo)localObject4).type);
              ((GameCenterSessionInfo)localObject5).d(((ConversationInfo)localObject4).unreadCount);
              ((GameCenterSessionInfo)localObject5).a(this.mApp);
              if (QLog.isColorLevel())
              {
                localObject6 = TAG;
                localObject7 = new StringBuilder();
                ((StringBuilder)localObject7).append("[getSessionInfoList] sessionId");
                ((StringBuilder)localObject7).append(((ConversationInfo)localObject4).uin);
                ((StringBuilder)localObject7).append(" tinyInfo:");
                ((StringBuilder)localObject7).append(((ConversationInfo)localObject4).tinyInfo);
                QLog.d((String)localObject6, 1, ((StringBuilder)localObject7).toString());
              }
              if ((((ConversationInfo)localObject4).tinyInfo != null) && (!TextUtils.isEmpty(((ConversationInfo)localObject4).tinyInfo.fromRoleId)))
              {
                localObject6 = new StringBuilder();
                ((StringBuilder)localObject6).append(((ConversationInfo)localObject4).tinyInfo.gameAppId);
                ((StringBuilder)localObject6).append("");
                if (isGameMsgBlocked(((StringBuilder)localObject6).toString()))
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  localObject4 = TAG;
                  localObject6 = new StringBuilder();
                  ((StringBuilder)localObject6).append("[getSessionInfoList] msg blocked: ");
                  ((StringBuilder)localObject6).append(((GameCenterSessionInfo)localObject5).d());
                  QLog.d((String)localObject4, 1, ((StringBuilder)localObject6).toString());
                  continue;
                }
                ((GameCenterSessionInfo)localObject5).d(((ConversationInfo)localObject4).tinyInfo.fromRoleId);
                ((GameCenterSessionInfo)localObject5).b(((ConversationInfo)localObject4).tinyInfo.toRoleId);
                ((GameCenterSessionInfo)localObject5).c(((ConversationInfo)localObject4).tinyInfo.fromTinyId);
                ((GameCenterSessionInfo)localObject5).d(((ConversationInfo)localObject4).tinyInfo.toTinyId);
                if (localObject1 != null)
                {
                  localObject6 = (GameDetailInfo)((HashMap)localObject1).get(((ConversationInfo)localObject4).tinyInfo.fromRoleId);
                  if (QLog.isColorLevel())
                  {
                    localObject7 = TAG;
                    localObject8 = new StringBuilder();
                    ((StringBuilder)localObject8).append("[getSessionInfoList] sessionId:");
                    ((StringBuilder)localObject8).append(((ConversationInfo)localObject4).uin);
                    ((StringBuilder)localObject8).append(",gameDetailInfo:");
                    ((StringBuilder)localObject8).append(localObject6);
                    QLog.d((String)localObject7, 2, ((StringBuilder)localObject8).toString());
                  }
                  if (localObject6 != null) {
                    updateSessionInfo((GameCenterSessionInfo)localObject5, (GameDetailInfo)localObject6);
                  }
                }
              }
              this.mSessionMap.put(((GameCenterSessionInfo)localObject5).d(), localObject5);
            }
          }
          if (QLog.isColorLevel())
          {
            localObject1 = TAG;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("[getSessionInfoList] sessionMap:");
            ((StringBuilder)localObject3).append(this.mSessionMap.toString());
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          }
        }
        else
        {
          QLog.i(TAG, 1, "[getSessionInfoList] tinyconversion is null.return");
          return null;
        }
      }
      this.mNormalMap.clear();
      this.mFolderMap.clear();
      Object localObject1 = this.mSessionMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        localObject3 = (GameCenterSessionInfo)this.mSessionMap.get(localObject3);
        ((GameCenterSessionInfo)localObject3).c(0);
        if (isGameMsgSync(((GameCenterSessionInfo)localObject3).e()))
        {
          ((GameCenterSessionInfo)localObject3).a(1);
          this.mNormalMap.put(((GameCenterSessionInfo)localObject3).d(), localObject3);
        }
        else
        {
          ((GameCenterSessionInfo)localObject3).a(0);
          if (((GameCenterSessionInfo)localObject3).c() > 0)
          {
            if (!this.mFolderMap.containsKey(((GameCenterSessionInfo)localObject3).e()))
            {
              ((GameCenterSessionInfo)localObject3).a();
              this.mFolderMap.put(((GameCenterSessionInfo)localObject3).e(), localObject3);
            }
            else
            {
              localObject4 = (GameCenterSessionInfo)this.mFolderMap.get(((GameCenterSessionInfo)localObject3).e());
              if (((GameCenterSessionInfo)localObject3).a() > ((GameCenterSessionInfo)localObject4).a())
              {
                ((GameCenterSessionInfo)localObject3).c(((GameCenterSessionInfo)localObject4).b() + 1);
                this.mFolderMap.put(((GameCenterSessionInfo)localObject3).e(), localObject3);
              }
            }
          }
          else
          {
            localObject4 = TAG;
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("[getSessionInfoList] folder session:");
            ((StringBuilder)localObject5).append(localObject3);
            QLog.i((String)localObject4, 1, ((StringBuilder)localObject5).toString());
          }
        }
      }
      localObject1 = TAG;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[getSessionInfoList] size:");
      ((StringBuilder)localObject3).append(this.mSessionMap.size());
      ((StringBuilder)localObject3).append(",fsize:");
      ((StringBuilder)localObject3).append(this.mFolderMap.size());
      ((StringBuilder)localObject3).append("，nsize:");
      ((StringBuilder)localObject3).append(this.mNormalMap.size());
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject3).toString());
      if (paramInt == 0)
      {
        ((List)localObject2).addAll(this.mNormalMap.values());
        ((List)localObject2).addAll(this.mFolderMap.values());
        localObject1 = localObject2;
      }
      else if (paramInt == 1)
      {
        localObject1 = new ArrayList(this.mFolderMap.values());
      }
      else if (paramInt == 2)
      {
        localObject1 = new ArrayList(this.mNormalMap.values());
      }
      else
      {
        localObject1 = localObject2;
        if (paramInt == 3)
        {
          localObject3 = this.mSessionMap.keySet().iterator();
          for (;;)
          {
            localObject1 = localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = (String)((Iterator)localObject3).next();
            if (TextUtils.equals(paramString, ((GameCenterSessionInfo)this.mSessionMap.get(localObject1)).e())) {
              ((List)localObject2).add(this.mSessionMap.get(localObject1));
            }
          }
        }
      }
      Collections.sort((List)localObject1);
      if (QLog.isColorLevel())
      {
        paramString = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[getSessionInfoList] ret:");
        ((StringBuilder)localObject2).append(localObject1.toString());
        QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean getShowReqMsgUnread()
  {
    return this.mShowReqMsgUnread;
  }
  
  public GameDetailInfo getSingleGameDetail(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getSingleGameDetail], roleId:");
      ((StringBuilder)localObject2).append(paramString);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1 = findGameUserInfo(paramString);
    Object localObject2 = new ArrayList();
    if (localObject1 == null)
    {
      QLog.w(TAG, 1, "usrInfo is null");
      ((ArrayList)localObject2).add(paramString);
      pullGameUsrInfoFromServer(true, (ArrayList)localObject2);
      return null;
    }
    GameBasicInfo localGameBasicInfo = findGameConfig(((GameUserInfo)localObject1).mAppId);
    if (localGameBasicInfo == null)
    {
      QLog.w(TAG, 1, "basicinfp is null");
      ((ArrayList)localObject2).add(paramString);
      pullGameUsrInfoFromServer(true, (ArrayList)localObject2);
      return null;
    }
    ((ArrayList)localObject2).add(paramString);
    pullGameUsrInfoFromServer(false, (ArrayList)localObject2);
    return GameDetailInfo.a(localGameBasicInfo, (GameUserInfo)localObject1);
  }
  
  public int getUnreadCnt()
  {
    return getUnreadCnt(true);
  }
  
  public int getUnreadCnt(boolean paramBoolean)
  {
    if (this.mNormalMap.size() == 0) {
      getSessionInfoList();
    }
    Object localObject1 = this.mNormalMap.keySet().iterator();
    int i = 0;
    int j = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (GameCenterSessionInfo)this.mNormalMap.get(localObject2);
      if (localObject2 != null) {
        j += ((GameCenterSessionInfo)localObject2).c();
      }
    }
    if (this.mPubMsgRedPointSwitch == 1) {
      i = 0 + j;
    }
    long l = getReqMsgCnt();
    int k = i;
    if (paramBoolean) {
      k = (int)(i + l);
    }
    if (j + l > 0L) {
      this.mIsHasUnreadMsg = true;
    }
    localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[getUnreadCnt] cnt:");
    ((StringBuilder)localObject2).append(k);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    return k;
  }
  
  public int getUnreadCnt4MsgTab()
  {
    if (this.mNormalMap.size() == 0) {
      getSessionInfoList();
    }
    Object localObject1 = this.mNormalMap.keySet().iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (GameCenterSessionInfo)this.mNormalMap.get(localObject2);
      if (localObject2 != null) {
        i += ((GameCenterSessionInfo)localObject2).c();
      }
    }
    long l = getReqMsgCnt();
    int j = (int)(0 + i + l);
    if (i + l > 0L) {
      this.mIsHasUnreadMsg = true;
    }
    localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[getUnreadCnt4MsgTab] cnt:");
    ((StringBuilder)localObject2).append(j);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    return j;
  }
  
  public List<String> getUnreadFriIcon()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mSessionMap.size() == 0) {
      getSessionInfoList();
    }
    Object localObject1;
    Object localObject2;
    if (this.mSessionMap.size() > 0)
    {
      localObject1 = this.mSessionMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (GameCenterSessionInfo)this.mSessionMap.get(localObject2);
        if ((localObject2 != null) && (((GameCenterSessionInfo)localObject2).c() > 0)) {
          localArrayList.add(((GameCenterSessionInfo)localObject2).g());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getUnreadFriIcon] friend icon size:");
      ((StringBuilder)localObject2).append(localArrayList.size());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return localArrayList;
  }
  
  public int getUnshowedUnreadCnt()
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getUnshowedUnreadCnt] cnt:");
      localStringBuilder.append(this.mUnshowedUnreadCnt);
      localStringBuilder.append(", mPubMsgRedPointSwitch:");
      localStringBuilder.append(this.mPubMsgRedPointSwitch);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (!GameMsgUtil.a(this.mApp)) {
      return 0;
    }
    if (!isGrayOpen()) {
      return 0;
    }
    if (((IVasDepTemp)QRoute.api(IVasDepTemp.class)).isBelongServiceAccountFolderInner("2747277822")) {
      return 0;
    }
    return this.mUnshowedUnreadCnt;
  }
  
  public int getViewType()
  {
    return 1;
  }
  
  public boolean isGameBuddySwitchOpen()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    return (localGameCenterMsgBean != null) && (localGameCenterMsgBean.jdField_c_of_type_Int == 1);
  }
  
  protected boolean isGameMsgBlocked(String paramString)
  {
    Object localObject = findGameSwitchConfig(paramString);
    if (localObject == null)
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isGameMsgBlocked] gameId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", config is null,return false");
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      return false;
    }
    return ((GameSwitchConfig)localObject).mBlockSwitch != 0;
  }
  
  public boolean isGameMsgBoxOpen(String paramString)
  {
    Object localObject = findGameSwitchConfig(paramString);
    StringBuilder localStringBuilder;
    if (localObject == null)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isGameMsgBoxOpen] gameId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", config is null,return true");
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      return true;
    }
    boolean bool;
    if (((GameSwitchConfig)localObject).mBoxSwitch == 0) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isGameMsgBoxOpen] gameId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", ret:");
      localStringBuilder.append(bool);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean isGameMsgShowInBoxFormTabConfig()
  {
    GameMsgTabConfig localGameMsgTabConfig = this.mTabConfig;
    return (localGameMsgTabConfig != null) && (localGameMsgTabConfig.b() != null) && ("1".equals(this.mTabConfig.b().get("style")));
  }
  
  public boolean isGameMsgShowInMsgBox(String paramString)
  {
    Object localObject = getSessionInfoByUin(paramString);
    boolean bool = true;
    if (localObject == null)
    {
      QLog.e(TAG, 1, "[isGameMsgShowInMsgBox] info = null");
      paramString = ((IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "")).getLastMessage(paramString, 10007);
      if (paramString != null)
      {
        localObject = paramString.getExtInfoFromExtStr("ext_key_game_msg_info");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramString = String.valueOf(new TinyInfo((String)localObject, paramString.isSend()).gameAppId);
          break label99;
        }
      }
      paramString = null;
    }
    else
    {
      paramString = ((GameCenterSessionInfo)localObject).e();
    }
    label99:
    if ((TextUtils.isEmpty(paramString)) || (!isGameMsgBoxOpen(paramString)) || (isGameMsgBlocked(paramString))) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramString = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[isGameMsgShowInMsgBox] ret = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean isGameMsgSync(String paramString)
  {
    Object localObject = findGameSwitchConfig(paramString);
    StringBuilder localStringBuilder;
    if (localObject == null)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isGameMsgSync] gameId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", config is null,return true");
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      return true;
    }
    if (isShowInMsgBox()) {
      return true;
    }
    boolean bool;
    if (((GameSwitchConfig)localObject).mSyncSwitch == 0) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isGameMsgSync] gameId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", ret:");
      localStringBuilder.append(bool);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean isGrayOpen()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    return (localGameCenterMsgBean != null) && (localGameCenterMsgBean.jdField_a_of_type_Int == 1);
  }
  
  public boolean isInited()
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isInited]");
      localStringBuilder.append(this.mInited);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return this.mInited;
  }
  
  public boolean isShowInMsgBox()
  {
    Object localObject = this.mApp;
    if (localObject == null) {
      return false;
    }
    localObject = (ITempMsgBoxManager)((AppInterface)localObject).getRuntimeService(ITempMsgBoxManager.class, "");
    if (localObject == null) {
      return false;
    }
    if ((((ITempMsgBoxManager)localObject).configContains(10007)) && (isGameMsgShowInBoxFormTabConfig()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[isShowInMsgBox], true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[isShowInMsgBox], false");
    }
    return false;
  }
  
  public void notifySessionChangedBySwitch()
  {
    notifyMessageChange("action_qgame_messgae_change", null, 3, getUnreadCnt());
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    QLog.i(TAG, 1, "[GameMsgManager] onCreate");
    if ((paramAppRuntime instanceof AppInterface))
    {
      this.mApp = ((AppInterface)paramAppRuntime);
      this.mEntityMgr = this.mApp.getEntityManagerFactory().createEntityManager();
      this.mSessionDelDataHelper = new GameDelSessionDataHelper(this.mEntityMgr);
      ThreadManager.getSubThreadHandler().post(this.mInitTask);
      QLog.i(TAG, 1, "[GameMsgManager] end");
      return;
    }
    QLog.e(TAG, 1, "appRuntime not instanceof AppInterface");
  }
  
  public void onDestroy()
  {
    QLog.i(TAG, 1, "[onDestroy]");
    Object localObject = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
    if (localObject != null) {
      ((IMessageFacade)localObject).deleteObserver(this);
    }
    localObject = this.mApp;
    if (localObject != null) {
      ((AppInterface)localObject).removeObserver(this.mSessionInfoObserver);
    }
  }
  
  public void onGameMsgRRecv(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "update r value:", Integer.valueOf(paramInt) });
    }
    setPubAccRedSwitch(paramInt);
    if (paramInt == 1)
    {
      GameMsgUtil.a(this.mApp.getCurrentAccountUin(), "sp_key_req_msg_unread_num", System.currentTimeMillis());
      GameMsgUtil.a(this.mApp.getCurrentAccountUin(), "sp_key_req_msg_read_time", 0L);
    }
  }
  
  public void onGameSwitchChange(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[onGameSwitchChange] gameId:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(",switchType:");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(",value:");
    ((StringBuilder)localObject2).append(paramInt2);
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool = true;
    QLog.i((String)localObject1, 1, (String)localObject2);
    ArrayList localArrayList = new ArrayList();
    localObject2 = findGameSwitchConfig(paramString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new GameSwitchConfig();
      ((GameSwitchConfig)localObject1).mAppId = paramString;
    }
    if (paramInt1 == 0)
    {
      if ((paramInt2 != 0) && (paramInt2 != 1)) {
        ((GameSwitchConfig)localObject1).mBlockSwitch = 0;
      } else {
        ((GameSwitchConfig)localObject1).mBlockSwitch = paramInt2;
      }
      localArrayList.add(localObject1);
      saveOrUpdateGameSwitchConfigs(localArrayList);
      if (((GameSwitchConfig)localObject1).mBlockSwitch == 1) {
        deleteAllSession(paramString);
      }
    }
    else if (paramInt1 == 1)
    {
      if ((paramInt2 != 0) && (paramInt2 != 1)) {
        ((GameSwitchConfig)localObject1).mSyncSwitch = 1;
      } else {
        ((GameSwitchConfig)localObject1).mSyncSwitch = paramInt2;
      }
      localArrayList.add(localObject1);
      saveOrUpdateGameSwitchConfigs(localArrayList);
      if (((GameSwitchConfig)localObject1).mSyncSwitch == 0) {
        setAllReaded(paramString);
      }
    }
    else if (paramInt1 == 2)
    {
      if ((paramInt2 != 0) && (paramInt2 != 1)) {
        ((GameSwitchConfig)localObject1).mBoxSwitch = 0;
      } else {
        ((GameSwitchConfig)localObject1).mBoxSwitch = paramInt2;
      }
      localArrayList.add(localObject1);
      saveOrUpdateGameSwitchConfigs(localArrayList);
    }
    int i;
    int j;
    if ((paramInt1 == 0) && (paramInt2 == 1))
    {
      i = 1;
      j = 3;
    }
    else if (paramInt1 == 2)
    {
      if (paramInt2 == 0) {
        i = 2;
      } else {
        i = 1;
      }
      j = i;
      i = 1;
    }
    else
    {
      i = 0;
      j = 0;
    }
    if ((i == 0) || (!isShowInMsgBox())) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[onGameSwitchChange] gameId:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(",switchType:");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", value: ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(", notifyMsgBox:");
      ((StringBuilder)localObject2).append(bool);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (bool)
    {
      localObject1 = new Intent("action_qgame_toggle_change");
      ((Intent)localObject1).setPackage(this.mApp.getApplication().getPackageName());
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("key_msg_change_game_id", paramString);
      ((Bundle)localObject2).putInt("key_msg_change_type_id", j);
      paramString = findGameConfig(paramString);
      if (paramString != null) {
        ((Bundle)localObject2).putString("key_msg_change_game_name", paramString.mName);
      }
      ((Intent)localObject1).putExtras((Bundle)localObject2);
      this.mApp.getApplication().sendBroadcast((Intent)localObject1);
    }
  }
  
  protected void pullGameUsrInfoFromServer(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[pullGameUsrInfoFromServer], isForcePull:");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.mLastPullTS;
      if (l1 - l2 < 1000L) {
        return;
      }
      this.mLastPullTS = System.currentTimeMillis();
      if (!isGrayOpen())
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "not in gray whitelist, return.");
        }
        return;
      }
      ThreadManager.getSubThreadHandler().post(new GameMsgManagerServiceImpl.5(this, paramBoolean, paramArrayList));
      return;
    }
    finally {}
  }
  
  public void saveOrUpdateGameBasicConfigs(ArrayList<GameBasicInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      Object localObject1;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[saveOrUpdateGameBasicConfigs], size:");
        ((StringBuilder)localObject2).append(paramArrayList.size());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (GameBasicInfo)paramArrayList.next();
        if (localObject1 != null)
        {
          localObject2 = (GameBasicInfo)this.mGameBasicConfigCache.get(((GameBasicInfo)localObject1).mAppId);
          if (localObject2 == null)
          {
            ((GameBasicInfo)localObject1).setStatus(1000);
            updateGameConfigItem((GameBasicInfo)localObject1);
          }
          else if (((GameBasicInfo)localObject2).mUpdateTs != ((GameBasicInfo)localObject1).mUpdateTs)
          {
            updateGameConfigItem((GameBasicInfo)localObject1);
            String str = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("game basic config has changed,origTS:");
            localStringBuilder.append(((GameBasicInfo)localObject2).mUpdateTs);
            localStringBuilder.append(",newTS:");
            localStringBuilder.append(((GameBasicInfo)localObject1).mUpdateTs);
            QLog.i(str, 1, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  public void saveOrUpdateGameSwitchConfigs(ArrayList<GameSwitchConfig> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameSwitchConfig localGameSwitchConfig = (GameSwitchConfig)paramArrayList.next();
        if (localGameSwitchConfig != null)
        {
          if (QLog.isColorLevel())
          {
            String str = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("[saveOrUpdateGameSwitchConfigs] config:");
            localStringBuilder.append(localGameSwitchConfig.toString());
            QLog.d(str, 2, localStringBuilder.toString());
          }
          this.mGameSwitchConfigCache.put(localGameSwitchConfig.mAppId, localGameSwitchConfig);
          updateEntity(localGameSwitchConfig);
        }
      }
    }
  }
  
  public void saveOrUpdateGameUsrInfoArrays(ArrayList<GameUserInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      Object localObject1;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[saveOrUpdateGameUsrInfoArrays], size:");
        ((StringBuilder)localObject2).append(paramArrayList.size());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject1 = (GameUserInfo)paramArrayList.next();
        if (localObject1 != null)
        {
          localObject2 = (GameUserInfo)this.mGameUserInfoMapCache.get(((GameUserInfo)localObject1).mRoleId);
          if (localObject2 == null)
          {
            ((GameUserInfo)localObject1).setStatus(1000);
            updateGameUsrInfoItem((GameUserInfo)localObject1);
          }
          else if (((GameUserInfo)localObject1).mUpdateTs != ((GameUserInfo)localObject2).mUpdateTs)
          {
            updateGameUsrInfoItem((GameUserInfo)localObject1);
            String str = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("game user info has changed,origTS:");
            localStringBuilder.append(((GameUserInfo)localObject2).mUpdateTs);
            localStringBuilder.append(",newTS:");
            localStringBuilder.append(((GameUserInfo)localObject1).mUpdateTs);
            QLog.i(str, 1, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  public void saveOrUpdateTabConfigs(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[saveOrUpdateTabConfigs] config:");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new GameMsgManagerServiceImpl.3(this, paramString));
  }
  
  public void setMsgShowOnList(boolean paramBoolean)
  {
    this.mMsgShowedOnList = paramBoolean;
  }
  
  public void setNeedPopMsgView(boolean paramBoolean)
  {
    this.mNeedPopMsgView = paramBoolean;
  }
  
  public void setPubAccRedSwitch(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setPubAccRedSwitch], v:");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramInt != this.mPubMsgRedPointSwitch)
    {
      this.mApp.getApplication().getSharedPreferences("game_center_sp", 0).edit().putInt("sp_pubacc_msg_redpoint", paramInt).commit();
      this.mPubMsgRedPointSwitch = paramInt;
    }
  }
  
  public void setReaded(GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    IMessageFacade localIMessageFacade = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
    if (localIMessageFacade == null) {
      return;
    }
    String str = paramGameCenterSessionInfo.d();
    localIMessageFacade.setReaded(str, 10007);
    paramGameCenterSessionInfo.d(0);
    if (this.mNormalMap.get(str) != null) {
      ((GameCenterSessionInfo)this.mNormalMap.get(str)).d(0);
    }
  }
  
  protected void setReqMsgRead()
  {
    GameMsgUtil.a(this.mApp.getCurrentAccountUin(), "sp_key_req_msg_unread_num", 0L);
    GameMsgUtil.a(this.mApp.getCurrentAccountUin(), "sp_key_req_msg_read_time", System.currentTimeMillis());
  }
  
  public void setShowReqMsgUnread(boolean paramBoolean)
  {
    this.mShowReqMsgUnread = paramBoolean;
  }
  
  public void setUnshowedUnreadCnt(int paramInt)
  {
    setUnshowedUnreadCntV2(paramInt, true);
  }
  
  public void setUnshowedUnreadCntV2(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = this.mApp;
    if (localObject1 == null) {
      return;
    }
    if ((((IRecentUserProxyService)((AppInterface)localObject1).getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().b("2747277822", 1008) == null) && (paramInt != 0)) {
      return;
    }
    this.mUnshowedUnreadCnt = paramInt;
    localObject1 = this.mApp.getApplication().getSharedPreferences("game_center_sp", 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sp_enter_pub");
    ((StringBuilder)localObject2).append(this.mApp.getCurrentAccountUin());
    localObject2 = ((StringBuilder)localObject2).toString();
    ((SharedPreferences)localObject1).edit().putInt((String)localObject2, this.mUnshowedUnreadCnt).apply();
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[setUnshowedUnreadCnt] cnt:");
      ((StringBuilder)localObject2).append(this.mUnshowedUnreadCnt);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      setReqMsgRead();
      this.mIsHasUnreadMsg = false;
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!isGrayOpen()) {
      return;
    }
    if ((paramObject instanceof MessageRecord))
    {
      Object localObject1 = (MessageRecord)paramObject;
      if (((MessageRecord)localObject1).istroop == 10007)
      {
        tryGetGameSwitchFromSvr();
        ConversationInfo localConversationInfo = TinyConvProxy.a().a(this.mApp, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
        if (QLog.isColorLevel())
        {
          paramObservable = TAG;
          paramObject = new StringBuilder();
          paramObject.append("[update] ##-- new msg:");
          paramObject.append(((MessageRecord)localObject1).frienduin);
          paramObject.append(", conInfo:");
          paramObject.append(localConversationInfo);
          QLog.d(paramObservable, 1, paramObject.toString());
        }
        if (localConversationInfo != null)
        {
          if (QLog.isColorLevel())
          {
            paramObservable = TAG;
            paramObject = new StringBuilder();
            paramObject.append("tinyConvInfo.unreadCount:");
            paramObject.append(localConversationInfo.unreadCount);
            QLog.d(paramObservable, 2, paramObject.toString());
          }
          if ((this.mSessionDelDataHelper != null) && (localConversationInfo.unreadCount > 0)) {
            GameDelSessionDataHelper.a(((MessageRecord)localObject1).frienduin, this.mSessionDelDataHelper);
          }
          paramObject = getSessionInfoByUin(((MessageRecord)localObject1).frienduin);
          Object localObject2;
          int i;
          if (paramObject == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "[update] create new sessionInfo.");
            }
            paramObject = new GameCenterSessionInfo();
            paramObject.e(((MessageRecord)localObject1).frienduin);
            paramObservable = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
            if (paramObservable == null) {
              return;
            }
            localObject2 = paramObservable.getFirstUnreadMessage(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
            if (localObject2 != null)
            {
              if (TextUtils.isEmpty(((Message)localObject2).emoRecentMsg)) {
                paramObservable = "";
              } else {
                paramObservable = ((Message)localObject2).emoRecentMsg.toString();
              }
              paramObject.l(paramObservable);
              paramObject.a(((Message)localObject2).time);
            }
            paramObservable = localConversationInfo.tinyInfo;
            if (paramObservable != null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramObservable.gameAppId);
              ((StringBuilder)localObject2).append("");
              if (isGameMsgBlocked(((StringBuilder)localObject2).toString()))
              {
                if (QLog.isColorLevel())
                {
                  paramObservable = TAG;
                  paramObject = new StringBuilder();
                  paramObject.append("[update] ##-- new msg:");
                  paramObject.append(((MessageRecord)localObject1).frienduin);
                  paramObject.append(", blocked.");
                  QLog.d(paramObservable, 1, paramObject.toString());
                }
                return;
              }
              paramObject.d(paramObservable.fromRoleId);
              paramObject.b(paramObservable.toRoleId);
              paramObject.c(paramObservable.fromTinyId);
              paramObject.d(paramObservable.toTinyId);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramObservable.gameAppId);
              ((StringBuilder)localObject2).append("");
              paramObject.f(((StringBuilder)localObject2).toString());
              localObject2 = getSingleGameDetail(paramObject.c());
              if (localObject2 != null) {
                updateSessionInfo(paramObject, (GameDetailInfo)localObject2);
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramObservable.gameAppId);
              ((StringBuilder)localObject2).append("");
              if (isGameMsgSync(((StringBuilder)localObject2).toString()))
              {
                paramObject.a(1);
                this.mNormalMap.put(paramObject.d(), paramObject);
              }
              else
              {
                paramObject.a(0);
                paramObject.a();
                this.mFolderMap.put(paramObject.e(), paramObject);
              }
              this.mSessionMap.put(paramObject.d(), paramObject);
            }
            i = 0;
            paramObservable = paramObject;
          }
          else
          {
            j = paramObject.c();
            paramObservable = paramObject;
            i = j;
            if (paramObject.a() == 0)
            {
              paramObservable = getFolderSession(paramObject.e());
              if (QLog.isColorLevel())
              {
                localObject2 = TAG;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("[update] folder session:");
                localStringBuilder.append(paramObservable);
                QLog.d((String)localObject2, 2, localStringBuilder.toString());
              }
              if (paramObservable != null)
              {
                paramObject.c(paramObservable.b() + 1);
                this.mFolderMap.put(paramObject.e(), paramObject);
                paramObservable = paramObject;
                i = j;
              }
              else
              {
                paramObject.a();
                this.mFolderMap.put(paramObject.e(), paramObject);
                i = j;
                paramObservable = paramObject;
              }
            }
          }
          paramObservable.d(localConversationInfo.unreadCount);
          paramObservable.m(((MessageRecord)localObject1).msg);
          paramObservable.b(((MessageRecord)localObject1).time);
          paramObservable.a(((MessageRecord)localObject1).isSend());
          paramObservable.a(this.mApp);
          int j = getUnreadCnt();
          int k = paramObservable.c();
          if (QLog.isColorLevel())
          {
            paramObject = TAG;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[update] update info:");
            ((StringBuilder)localObject1).append(paramObservable.toString());
            QLog.d(paramObject, 2, ((StringBuilder)localObject1).toString());
          }
          int m = getUnreadCnt4MsgTab();
          if (paramObservable.a() == 0)
          {
            paramObservable = getFolderSession(paramObservable.e());
            if (QLog.isColorLevel())
            {
              paramObject = TAG;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[update] notify folder session:");
              ((StringBuilder)localObject1).append(paramObservable);
              QLog.d(paramObject, 2, ((StringBuilder)localObject1).toString());
            }
            notifyMessageChange("action_qgame_messgae_change", paramObservable, 1, m);
          }
          else
          {
            notifyMessageChange("action_qgame_messgae_change", paramObservable, 1, m);
            notifyMessageChange("action_qgame_unread_change", paramObservable, 1, m);
          }
          if (QLog.isColorLevel())
          {
            paramObservable = TAG;
            paramObject = new StringBuilder();
            paramObject.append("[update] oldUnread:");
            paramObject.append(i);
            paramObject.append(",newUnread:");
            paramObject.append(k);
            QLog.d(paramObservable, 2, paramObject.toString());
          }
          if ((GameMsgUtil.a(this.mApp)) && (i != k))
          {
            ((ITempApi)QRoute.api(ITempApi.class)).refreshAppBadge(this.mApp);
            setUnshowedUnreadCntV2(j, false);
          }
        }
      }
    }
  }
  
  protected boolean updateEntity(Entity paramEntity)
  {
    boolean bool2 = this.mEntityMgr.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        this.mEntityMgr.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.mEntityMgr.update(paramEntity);
      }
    }
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateEntity em closed e=");
      localStringBuilder.append(paramEntity.getTableName());
      QLog.e(str, 2, localStringBuilder.toString());
    }
    return false;
  }
  
  public void updateMgrConfig(GameCenterMsgBean paramGameCenterMsgBean)
  {
    QLog.i(TAG, 2, "[updateGraySwich]");
    if (paramGameCenterMsgBean == null) {
      return;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("graySwitch:");
    localStringBuilder.append(paramGameCenterMsgBean.jdField_a_of_type_Int);
    localStringBuilder.append(",msgListUrl:");
    localStringBuilder.append(paramGameCenterMsgBean.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",settingUrl:");
    localStringBuilder.append(paramGameCenterMsgBean.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(",prefix:");
    localStringBuilder.append(paramGameCenterMsgBean.jdField_c_of_type_JavaLangString);
    QLog.i(str, 1, localStringBuilder.toString());
    if (this.mMsgConfig == null) {
      this.mMsgConfig = new GameCenterMsgBean();
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_a_of_type_JavaLangString)) {
      this.mMsgConfig.jdField_a_of_type_JavaLangString = paramGameCenterMsgBean.jdField_a_of_type_JavaLangString;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_b_of_type_JavaLangString)) {
      this.mMsgConfig.jdField_b_of_type_JavaLangString = paramGameCenterMsgBean.jdField_b_of_type_JavaLangString;
    }
    this.mMsgConfig.jdField_a_of_type_Int = paramGameCenterMsgBean.jdField_a_of_type_Int;
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_c_of_type_JavaLangString)) {
      this.mMsgConfig.jdField_c_of_type_JavaLangString = paramGameCenterMsgBean.jdField_c_of_type_JavaLangString;
    }
    this.mMsgConfig.jdField_c_of_type_Int = paramGameCenterMsgBean.jdField_c_of_type_Int;
    this.mMsgConfig.e = paramGameCenterMsgBean.e;
    this.mMsgConfig.jdField_a_of_type_JavaUtilHashMap = paramGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap;
    this.mMsgConfig.jdField_d_of_type_Int = paramGameCenterMsgBean.jdField_d_of_type_Int;
    this.mMsgConfig.f = paramGameCenterMsgBean.f;
    this.mMsgConfig.g = paramGameCenterMsgBean.g;
    this.mMsgConfig.jdField_b_of_type_JavaUtilHashMap = paramGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap;
  }
  
  public void updateRedDotConfig(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateRedDotConfig], roleId:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",value:");
      localStringBuilder.append(paramString2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.mRoleIdRedDotMap.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */