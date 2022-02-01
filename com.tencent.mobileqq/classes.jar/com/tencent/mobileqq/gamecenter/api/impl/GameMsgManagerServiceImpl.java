package com.tencent.mobileqq.gamecenter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgSayHiCallback;
import com.tencent.mobileqq.gamecenter.api.IRemoteUserListCallback;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.config.GameCenterMsgBean;
import com.tencent.mobileqq.gamecenter.config.GameMsgTabConfig;
import com.tencent.mobileqq.gamecenter.data.GameDelSessionDataHelper;
import com.tencent.mobileqq.gamecenter.data.GameMsgRemoteUserItem;
import com.tencent.mobileqq.gamecenter.data.GameQQPlayerUtils;
import com.tencent.mobileqq.gamecenter.data.IDataVisitor;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameDelSessionRecord;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.mobileqq.gamecenter.msginfo.TinyConvProxy;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.sso.GameCenterUnissoObserver;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryAIOGreetInfoRsp;
import com.tencent.mobileqq.gamecenter.ui.GameAioOnlineStatusPopUpWindow;
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
import java.util.List<Lcom.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONObject;

@Service(process={"all"})
public class GameMsgManagerServiceImpl
  implements IGameMsgManagerService, Observer
{
  public static final int GAME_CONVERSATION_MAX_NUM = 200;
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
  private IGameMsgSayHiCallback mGameMsgSayHiCallback;
  private Map<String, GameSwitchConfig> mGameSwitchConfigCache = Collections.synchronizedMap(new HashMap());
  private long mGameSwitchLastUpdateTime = 0L;
  private Map<String, GameUserInfo> mGameUserInfoMapCache = Collections.synchronizedMap(new HashMap());
  private int mHashcode = hashCode();
  private Runnable mInitTask = new GameMsgManagerServiceImpl.2(this);
  private boolean mInited = false;
  public boolean mIsHasUnreadMsg = false;
  private GameCenterMsgBean mMsgConfig = new GameCenterMsgBean();
  private boolean mMsgShowedOnList = false;
  public boolean mNeedPopMsgView = false;
  private Map<String, GameCenterSessionInfo> mNormalMap = new ConcurrentHashMap();
  private int mPubMsgRedPointSwitch = 0;
  public GameQQPlayerUtils mQQPlayerUtil = new GameQQPlayerUtils();
  private IRemoteUserListCallback mRemoteListCallback;
  private Map<String, String> mRoleIdRedDotMap = Collections.synchronizedMap(new HashMap());
  private GameDelSessionDataHelper mSessionDelDataHelper;
  private GameCenterUnissoObserver mSessionInfoObserver = new GameMsgManagerServiceImpl.1(this, this.mHashcode);
  private Map<String, GameCenterSessionInfo> mSessionMap = new ConcurrentHashMap();
  public boolean mShowReqMsgUnread = false;
  private GameMsgTabConfig mTabConfig = new GameMsgTabConfig();
  private int mUnshowedUnreadCnt = 0;
  private ArrayList<WeakReference<GameCenterUnissoObserver>> mUserInfoChangeObserverList = new ArrayList();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(GameCenterUnissoHandler.b);
    localStringBuilder.append("GameMsgManager");
    TAG = localStringBuilder.toString();
  }
  
  private void addUserInfo(List<GameCenterSessionInfo> paramList)
  {
    QLog.i(TAG, 1, "+++++++[addUserInfo]+++++++");
    Object localObject1 = new HashSet();
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (GameCenterSessionInfo)((Iterator)localObject2).next();
        ((Set)localObject1).add(((GameCenterSessionInfo)localObject3).e());
        ((Set)localObject1).add(((GameCenterSessionInfo)localObject3).b());
      }
      localObject2 = TAG;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("[addUserInfo], roleid size:");
      ((StringBuilder)localObject3).append(((Set)localObject1).size());
      QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
      localObject1 = getGameDetailInfo(new ArrayList((Collection)localObject1));
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (GameCenterSessionInfo)paramList.next();
        localObject3 = (GameDetailInfo)((HashMap)localObject1).get(((GameCenterSessionInfo)localObject2).e());
        if (localObject3 != null) {
          updateSessionInfo((GameCenterSessionInfo)localObject2, (GameDetailInfo)localObject3);
        }
      }
      paramList = this.mSessionMap.keySet().iterator();
      while (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        localObject2 = (GameCenterSessionInfo)this.mSessionMap.get(localObject2);
        localObject3 = (GameDetailInfo)((HashMap)localObject1).get(((GameCenterSessionInfo)localObject2).e());
        if (localObject3 != null) {
          updateSessionInfo((GameCenterSessionInfo)localObject2, (GameDetailInfo)localObject3);
        }
      }
    }
  }
  
  private MessageRecord checkUpdateParam(Object paramObject)
  {
    if (isGrayOpen())
    {
      if (!(paramObject instanceof MessageRecord)) {
        return null;
      }
      paramObject = (MessageRecord)paramObject;
      if (paramObject.istroop != 10007) {
        return null;
      }
      return paramObject;
    }
    return null;
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
  
  private GameCenterSessionInfo creatSessionInfo(MessageRecord paramMessageRecord, TinyInfo paramTinyInfo)
  {
    QLog.d(TAG, 2, "[crreatSessionInfo] create new sessionInfo.");
    GameCenterSessionInfo localGameCenterSessionInfo = new GameCenterSessionInfo();
    localGameCenterSessionInfo.e(paramMessageRecord.frienduin);
    Object localObject = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
    if (localObject == null) {
      return null;
    }
    Message localMessage = ((IMessageFacade)localObject).getFirstUnreadMessage(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if (localMessage != null)
    {
      if (TextUtils.isEmpty(localMessage.emoRecentMsg)) {
        localObject = "";
      } else {
        localObject = localMessage.emoRecentMsg.toString();
      }
      localGameCenterSessionInfo.l((String)localObject);
      localGameCenterSessionInfo.a(localMessage.time);
    }
    if (paramTinyInfo != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramTinyInfo.gameAppId);
      ((StringBuilder)localObject).append("");
      if (isGameMsgBlocked(((StringBuilder)localObject).toString()))
      {
        paramTinyInfo = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[update] ##-- new msg:");
        ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
        ((StringBuilder)localObject).append(", blocked.");
        QLog.i(paramTinyInfo, 1, ((StringBuilder)localObject).toString());
        return null;
      }
      localGameCenterSessionInfo.d(paramTinyInfo.fromRoleId);
      localGameCenterSessionInfo.b(paramTinyInfo.toRoleId);
      localGameCenterSessionInfo.c(paramTinyInfo.fromTinyId);
      localGameCenterSessionInfo.d(paramTinyInfo.toTinyId);
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append(paramTinyInfo.gameAppId);
      paramMessageRecord.append("");
      localGameCenterSessionInfo.f(paramMessageRecord.toString());
      paramMessageRecord = getSingleGameDetail(localGameCenterSessionInfo.e());
      if (paramMessageRecord != null) {
        updateSessionInfo(localGameCenterSessionInfo, paramMessageRecord);
      }
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append(paramTinyInfo.gameAppId);
      paramMessageRecord.append("");
      if (isGameMsgSync(paramMessageRecord.toString()))
      {
        localGameCenterSessionInfo.a(1);
        this.mNormalMap.put(localGameCenterSessionInfo.g(), localGameCenterSessionInfo);
      }
      else
      {
        localGameCenterSessionInfo.a(0);
        localGameCenterSessionInfo.c();
        this.mFolderMap.put(localGameCenterSessionInfo.h(), localGameCenterSessionInfo);
      }
      this.mSessionMap.put(localGameCenterSessionInfo.g(), localGameCenterSessionInfo);
    }
    return localGameCenterSessionInfo;
  }
  
  private GameCenterSessionInfo createSessionInfo(ConversationInfo paramConversationInfo)
  {
    if ((paramConversationInfo != null) && (paramConversationInfo.tinyInfo != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramConversationInfo.tinyInfo.gameAppId);
      ((StringBuilder)localObject1).append("");
      if (isGameMsgBlocked(((StringBuilder)localObject1).toString())) {
        return null;
      }
      localObject1 = TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[createSessionInfo] info:");
      ((StringBuilder)localObject2).append(paramConversationInfo.toString());
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      localObject1 = new GameCenterSessionInfo();
      localObject2 = (IMessageFacade)this.mApp.getRuntimeService(IMessageFacade.class, "");
      if (localObject2 == null) {
        return null;
      }
      Object localObject3 = ((IMessageFacade)localObject2).getLastMessage(paramConversationInfo.uin, paramConversationInfo.type);
      if ((localObject3 != null) && ((localObject3 instanceof Message)))
      {
        CharSequence localCharSequence = ((Message)localObject3).emoRecentMsg;
        if (!TextUtils.isEmpty(localCharSequence)) {
          ((GameCenterSessionInfo)localObject1).m(localCharSequence.toString());
        }
        ((GameCenterSessionInfo)localObject1).a(((MessageRecord)localObject3).isSend());
        ((GameCenterSessionInfo)localObject1).b(((MessageRecord)localObject3).time);
      }
      localObject2 = ((IMessageFacade)localObject2).getFirstUnreadMessage(paramConversationInfo.uin, paramConversationInfo.type);
      if (localObject2 != null)
      {
        localObject3 = ((Message)localObject2).emoRecentMsg;
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((GameCenterSessionInfo)localObject1).l(((CharSequence)localObject3).toString());
        }
        ((GameCenterSessionInfo)localObject1).a(((Message)localObject2).time);
      }
      ((GameCenterSessionInfo)localObject1).e(paramConversationInfo.uin);
      ((GameCenterSessionInfo)localObject1).b(paramConversationInfo.type);
      ((GameCenterSessionInfo)localObject1).d(paramConversationInfo.unreadCount);
      ((GameCenterSessionInfo)localObject1).a(this.mApp);
      ((GameCenterSessionInfo)localObject1).d(paramConversationInfo.tinyInfo.fromRoleId);
      ((GameCenterSessionInfo)localObject1).b(paramConversationInfo.tinyInfo.toRoleId);
      ((GameCenterSessionInfo)localObject1).c(paramConversationInfo.tinyInfo.fromTinyId);
      ((GameCenterSessionInfo)localObject1).d(paramConversationInfo.tinyInfo.toTinyId);
      return localObject1;
    }
    QLog.e(TAG, 1, "[createSessionInfo] param is error.");
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
      if (paramString.equals(localGameCenterSessionInfo.h()))
      {
        ((Iterator)localObject2).remove();
        ((IMessageFacade)localObject1).clearHistory(localGameCenterSessionInfo.g(), 10007);
      }
    }
    localObject1 = this.mNormalMap.entrySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (paramString.equals(((GameCenterSessionInfo)((Map.Entry)((Iterator)localObject1).next()).getValue()).h())) {
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
  
  private void fillFolderMap(GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramGameCenterSessionInfo == null) {
      return;
    }
    paramGameCenterSessionInfo.a(0);
    Object localObject;
    if (paramGameCenterSessionInfo.o() > 0)
    {
      if (!this.mFolderMap.containsKey(paramGameCenterSessionInfo.h()))
      {
        paramGameCenterSessionInfo.c();
        this.mFolderMap.put(paramGameCenterSessionInfo.h(), paramGameCenterSessionInfo);
        return;
      }
      localObject = (GameCenterSessionInfo)this.mFolderMap.get(paramGameCenterSessionInfo.h());
      if (paramGameCenterSessionInfo.n() > ((GameCenterSessionInfo)localObject).n())
      {
        paramGameCenterSessionInfo.c(((GameCenterSessionInfo)localObject).l() + 1);
        this.mFolderMap.put(paramGameCenterSessionInfo.h(), paramGameCenterSessionInfo);
      }
    }
    else
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getSessionInfoList] folder session:");
      localStringBuilder.append(paramGameCenterSessionInfo);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  private List<GameCenterSessionInfo> getFilteredList(List<GameCenterSessionInfo> paramList, String paramString)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Object localObject1 = TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getFilteredList], allList.size:");
      ((StringBuilder)localObject2).append(paramList.size());
      ((StringBuilder)localObject2).append(",gameId:");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      localObject2 = new ArrayList();
      localObject1 = paramList;
      if (!isSpecialGameId(paramString)) {
        if (TextUtils.isEmpty(paramString))
        {
          localObject1 = paramList;
        }
        else
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            localObject1 = (GameCenterSessionInfo)paramList.next();
            if (paramString.equals(((GameCenterSessionInfo)localObject1).h())) {
              ((List)localObject2).add(localObject1);
            }
          }
          localObject1 = localObject2;
        }
      }
      Collections.sort((List)localObject1);
      paramList = TAG;
      paramString = new StringBuilder();
      paramString.append("[getFilteredList], gameList.size:");
      paramString.append(((List)localObject1).size());
      QLog.i(paramList, 1, paramString.toString());
      paramList = (List<GameCenterSessionInfo>)localObject1;
      if (((List)localObject1).size() > 200) {
        paramList = ((List)localObject1).subList(0, 200);
      }
      return paramList;
    }
    return null;
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
  
  private GameCenterSessionInfo getLastestSession(List<GameCenterSessionInfo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (GameCenterSessionInfo)localIterator.next();
      GameDelSessionRecord localGameDelSessionRecord = new GameDelSessionRecord();
      localGameDelSessionRecord.mUin = paramList.g();
      if (paramList != null) {
        if (!this.mSessionDelDataHelper.d(localGameDelSessionRecord)) {
          return paramList;
        }
      }
    }
    paramList = null;
    return paramList;
  }
  
  private List<GameCenterSessionInfo> getRequiredSessionList(int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == 0)
    {
      localArrayList.addAll(this.mNormalMap.values());
      localArrayList.addAll(this.mFolderMap.values());
      localObject = localArrayList;
    }
    else if (paramInt == 1)
    {
      localObject = new ArrayList(this.mFolderMap.values());
    }
    else if (paramInt == 2)
    {
      localObject = new ArrayList(this.mNormalMap.values());
    }
    else
    {
      localObject = localArrayList;
      if (paramInt == 3)
      {
        Iterator localIterator = this.mSessionMap.keySet().iterator();
        for (;;)
        {
          localObject = localArrayList;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (String)localIterator.next();
          if (TextUtils.equals(paramString, ((GameCenterSessionInfo)this.mSessionMap.get(localObject)).h())) {
            localArrayList.add(this.mSessionMap.get(localObject));
          }
        }
      }
    }
    Object localObject = getFilteredList((List)localObject, paramString);
    if (!isSpecialGameId(paramString)) {
      addUserInfo((List)localObject);
    }
    return localObject;
  }
  
  private List<ConversationInfo> getTinyConvInfoList()
  {
    return TinyConvProxy.a().a(this.mApp);
  }
  
  private String getUnreadStr4EachGame()
  {
    Object localObject = "";
    try
    {
      JSONObject localJSONObject = new JSONObject();
      HashMap localHashMap = getUnreadForEachGame();
      if (localHashMap != null)
      {
        localObject = localHashMap.keySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          localJSONObject.put(str, localHashMap.get(str));
        }
        localObject = localJSONObject.toString();
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(TAG, 1, localThrowable, new Object[0]);
    }
    return "";
  }
  
  private void handleFolderSession(GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramGameCenterSessionInfo == null) {
      return;
    }
    if (paramGameCenterSessionInfo.f() == 0)
    {
      GameCenterSessionInfo localGameCenterSessionInfo = getFolderSession(paramGameCenterSessionInfo.h());
      if (QLog.isColorLevel())
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleFolderSession] folder session:");
        localStringBuilder.append(localGameCenterSessionInfo);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if (localGameCenterSessionInfo != null) {
        paramGameCenterSessionInfo.c(localGameCenterSessionInfo.l() + 1);
      } else {
        paramGameCenterSessionInfo.c();
      }
      this.mFolderMap.put(paramGameCenterSessionInfo.h(), paramGameCenterSessionInfo);
    }
  }
  
  private void handleMsgBoxCase(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool2 = false;
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
    boolean bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (isShowInMsgBox()) {
        bool1 = true;
      }
    }
    Object localObject1;
    Object localObject2;
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
      ((StringBuilder)localObject2).append(bool1);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (bool1)
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
  
  private void handleSwitchType0(GameSwitchConfig paramGameSwitchConfig, String paramString, int paramInt)
  {
    if (paramGameSwitchConfig == null) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 1)) {
      paramGameSwitchConfig.mBlockSwitch = 0;
    } else {
      paramGameSwitchConfig.mBlockSwitch = paramInt;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramGameSwitchConfig);
    saveOrUpdateGameSwitchConfigs(localArrayList);
    if (paramGameSwitchConfig.mBlockSwitch == 1) {
      deleteAllSession(paramString);
    }
  }
  
  private void handleSwitchType1(GameSwitchConfig paramGameSwitchConfig, String paramString, int paramInt)
  {
    if (paramGameSwitchConfig == null) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 1)) {
      paramGameSwitchConfig.mSyncSwitch = 1;
    } else {
      paramGameSwitchConfig.mSyncSwitch = paramInt;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramGameSwitchConfig);
    saveOrUpdateGameSwitchConfigs(localArrayList);
    if (paramGameSwitchConfig.mSyncSwitch == 0) {
      setAllReaded(paramString);
    }
  }
  
  private void handleSwitchType2(GameSwitchConfig paramGameSwitchConfig, String paramString, int paramInt)
  {
    if (paramGameSwitchConfig == null) {
      return;
    }
    if ((paramInt != 0) && (paramInt != 1)) {
      paramGameSwitchConfig.mBoxSwitch = 0;
    } else {
      paramGameSwitchConfig.mBoxSwitch = paramInt;
    }
    paramString = new ArrayList();
    paramString.add(paramGameSwitchConfig);
    saveOrUpdateGameSwitchConfigs(paramString);
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
  
  private boolean initSessionMap()
  {
    QLog.i(TAG, 1, "[initSessionMap] ++++SesseionMap is empty, Start Initialization.++");
    Object localObject1 = getTinyConvInfoList();
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = ((List)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = createSessionInfo((ConversationInfo)((Iterator)localObject1).next());
        if (localObject2 != null) {
          this.mSessionMap.put(((GameCenterSessionInfo)localObject2).g(), localObject2);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[initSessionMap] sessionMap:");
        ((StringBuilder)localObject2).append(this.mSessionMap.toString());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return true;
    }
    QLog.i(TAG, 1, "[initSessionMap] tinyconversion is null.return");
    return false;
  }
  
  private void initTabCongif()
  {
    SharedPreferences localSharedPreferences = this.mApp.getApplication().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getCurrentAccountUin());
    localStringBuilder.append("sp_key_tab_config");
    this.mTabConfig = GameMsgTabConfig.a(localSharedPreferences.getString(localStringBuilder.toString(), ""));
  }
  
  private boolean isLastMessageInGameBox()
  {
    Object localObject = this.mApp;
    if (localObject == null) {
      return false;
    }
    localObject = (IGameMsgBoxManager)((AppInterface)localObject).getRuntimeService(IGameMsgBoxManager.class, "");
    GameCenterSessionInfo localGameCenterSessionInfo = getLastSessionInfoExceptDelSession();
    if (localGameCenterSessionInfo == null) {
      return false;
    }
    return ((IGameMsgBoxManager)localObject).isGameInGameBox(localGameCenterSessionInfo.h());
  }
  
  private boolean isSpecialGameId(String paramString)
  {
    return ("-10000".equals(paramString)) || ("-10001".equals(paramString));
  }
  
  private void notifyMessageChange(GameCenterSessionInfo paramGameCenterSessionInfo, int paramInt)
  {
    int i = getUnreadCnt();
    int j = paramGameCenterSessionInfo.o();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[update] update info:");
      localStringBuilder.append(paramGameCenterSessionInfo.toString());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    int k = getUnreadCnt4MsgTab();
    if (paramGameCenterSessionInfo.f() == 0)
    {
      notifyMessageChange("action_qgame_messgae_change", getFolderSession(paramGameCenterSessionInfo.h()), 1, k);
    }
    else
    {
      notifyMessageChange("action_qgame_messgae_change", paramGameCenterSessionInfo, 1, k);
      notifyMessageChange("action_qgame_unread_change", paramGameCenterSessionInfo, 1, k);
    }
    if (QLog.isColorLevel())
    {
      paramGameCenterSessionInfo = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[update] oldUnread:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",newUnread:");
      ((StringBuilder)localObject).append(j);
      QLog.d(paramGameCenterSessionInfo, 2, ((StringBuilder)localObject).toString());
    }
    if ((GameMsgUtil.a(this.mApp)) && (paramInt != j))
    {
      ((ITempApi)QRoute.api(ITempApi.class)).refreshAppBadge(this.mApp);
      setUnshowedUnreadCntV2(i, false);
    }
  }
  
  private void notifyMessageChange(String paramString, GameCenterSessionInfo paramGameCenterSessionInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new Intent(paramString);
    ((Intent)localObject).setPackage(this.mApp.getApplication().getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_game_msg", paramGameCenterSessionInfo);
    localBundle.putInt("key_msg_change_type", paramInt1);
    localBundle.putInt("key_msg_unread_cnt", paramInt2);
    if ("action_qgame_unread_change".equals(paramString)) {
      localBundle.putString("key_msg_single_unread_cnt", getUnreadStr4EachGame());
    }
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
  
  private void notifyUserInfoChanged(Object paramObject)
  {
    try
    {
      Iterator localIterator = this.mUserInfoChangeObserverList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null) {
          return;
        }
        ((GameCenterUnissoObserver)localWeakReference.get()).b(paramObject);
      }
      return;
    }
    catch (Throwable paramObject)
    {
      QLog.w(TAG, 1, paramObject.getMessage());
    }
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
      if (paramString.equals(((GameCenterSessionInfo)localObject2).h())) {
        setReaded((GameCenterSessionInfo)localObject2);
      }
    }
  }
  
  private void startNotifyOnUserInfoChanged(int paramInt1, int paramInt2, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (paramInt2 > 30)
    {
      if (paramInt1 == paramInt2 - 1) {
        notifyMessageChange("action_qgame_messgae_change", paramGameCenterSessionInfo, 3, getUnreadCnt());
      }
    }
    else if (paramGameCenterSessionInfo.f() == 0)
    {
      GameCenterSessionInfo localGameCenterSessionInfo = getFolderSession(paramGameCenterSessionInfo.h());
      if (QLog.isColorLevel())
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onGameUserInfoChangedNotify] folder session:");
        localStringBuilder.append(localGameCenterSessionInfo);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      if ((localGameCenterSessionInfo != null) && (localGameCenterSessionInfo.g().equals(paramGameCenterSessionInfo.g()))) {
        notifyMessageChange("action_qgame_messgae_change", localGameCenterSessionInfo, 2, getUnreadCnt());
      }
    }
    else
    {
      notifyMessageChange("action_qgame_messgae_change", paramGameCenterSessionInfo, 2, getUnreadCnt());
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
      GameCenterUnissoHandler.a().a(this.mHashcode);
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
    QLog.i(TAG, 1, "[updateSessionInfo]");
    if (paramGameCenterSessionInfo != null)
    {
      if (paramGameDetailInfo == null) {
        return;
      }
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("roleId:");
      localStringBuilder.append(paramGameDetailInfo.a);
      QLog.i(str, 1, localStringBuilder.toString());
      paramGameCenterSessionInfo.k(paramGameDetailInfo.b);
      paramGameCenterSessionInfo.j(getFriendShowName(paramGameDetailInfo.b));
      paramGameCenterSessionInfo.i(paramGameDetailInfo.e);
      paramGameCenterSessionInfo.f(paramGameDetailInfo.c);
      paramGameCenterSessionInfo.e(paramGameDetailInfo.j);
      paramGameCenterSessionInfo.h(paramGameDetailInfo.d);
      paramGameCenterSessionInfo.g(paramGameDetailInfo.k);
      paramGameCenterSessionInfo.c(paramGameDetailInfo.n);
      paramGameCenterSessionInfo.a(paramGameDetailInfo.l);
    }
  }
  
  public void addUserInfoChangedObserver(GameCenterUnissoObserver paramGameCenterUnissoObserver)
  {
    if (paramGameCenterUnissoObserver == null) {
      return;
    }
    this.mUserInfoChangeObserverList.add(new WeakReference(paramGameCenterUnissoObserver));
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
    return localGameCenterMsgBean.m;
  }
  
  public String getAioHippyParameters()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if (localGameCenterMsgBean == null) {
      return null;
    }
    return localGameCenterMsgBean.n;
  }
  
  public ArrayList<String> getAioQuickReply(String paramString)
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if ((localGameCenterMsgBean != null) && (localGameCenterMsgBean.j != null) && (!TextUtils.isEmpty(paramString))) {
      return (ArrayList)this.mMsgConfig.j.get(paramString);
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
    if ((localGameCenterMsgBean != null) && (localGameCenterMsgBean.l != null) && (!TextUtils.isEmpty(paramString))) {
      return (String)this.mMsgConfig.l.get(paramString);
    }
    return null;
  }
  
  public String getGameBuddyAppName()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if ((localGameCenterMsgBean != null) && (!TextUtils.isEmpty(localGameCenterMsgBean.h))) {
      return this.mMsgConfig.h;
    }
    return "\"玩伴\"小程序";
  }
  
  public HashMap<String, GameDetailInfo> getGameDetailInfo(ArrayList<String> paramArrayList)
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
  
  public String getGameMsgListUrl()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if ((localGameCenterMsgBean != null) && (!TextUtils.isEmpty(localGameCenterMsgBean.b))) {
      return this.mMsgConfig.b;
    }
    return "https://fastest.gamecenter.qq.com/_fst_/speed_gamecenter_qq_com/_fst_/pushgame/v1/home/msg?_wv=18950115&_wwv=393&_fst_id=194";
  }
  
  public String getGameMsgSettingUrl()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if ((localGameCenterMsgBean != null) && (!TextUtils.isEmpty(localGameCenterMsgBean.c))) {
      return this.mMsgConfig.c;
    }
    return "https://speed.gamecenter.qq.com/pushgame/v1/gamemsg-setting?_wv=2&_wwv=134";
  }
  
  public String getGamePrefix()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if ((localGameCenterMsgBean != null) && (!TextUtils.isEmpty(localGameCenterMsgBean.d))) {
      return this.mMsgConfig.d;
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
      if (((GameCenterSessionInfo)localObject2).n() > ((GameCenterSessionInfo)localObject1).n()) {
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
      if (((GameCenterSessionInfo)localObject2).n() > ((GameCenterSessionInfo)localObject1).n()) {
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
      return localGameCenterMsgBean.f;
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
  
  public void getRemoteGameSessionList(IRemoteUserListCallback paramIRemoteUserListCallback)
  {
    QLog.i(TAG, 1, "[getRemoteGameSessionList]");
    this.mRemoteListCallback = paramIRemoteUserListCallback;
    GameCenterUnissoHandler.a().b();
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
  
  public JSONObject getSayHiDefaultConfig()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if (localGameCenterMsgBean == null) {
      return null;
    }
    return localGameCenterMsgBean.p;
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
    } while (!paramString.equals(((GameCenterSessionInfo)localObject).e()));
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
        ((StringBuilder)localObject2).append(",curSize:");
        ((StringBuilder)localObject2).append(this.mSessionMap.size());
        QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      if (this.mSessionMap.size() == 0)
      {
        boolean bool = initSessionMap();
        if (!bool) {
          return null;
        }
      }
      this.mNormalMap.clear();
      this.mFolderMap.clear();
      Object localObject1 = this.mSessionMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject2 = (GameCenterSessionInfo)this.mSessionMap.get(localObject2);
        ((GameCenterSessionInfo)localObject2).c(0);
        if (isGameMsgSync(((GameCenterSessionInfo)localObject2).h()))
        {
          ((GameCenterSessionInfo)localObject2).a(1);
          this.mNormalMap.put(((GameCenterSessionInfo)localObject2).g(), localObject2);
        }
        else
        {
          fillFolderMap((GameCenterSessionInfo)localObject2);
        }
      }
      localObject1 = TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getSessionInfoList] size:");
      ((StringBuilder)localObject2).append(this.mSessionMap.size());
      ((StringBuilder)localObject2).append(",fsize:");
      ((StringBuilder)localObject2).append(this.mFolderMap.size());
      ((StringBuilder)localObject2).append("，nsize:");
      ((StringBuilder)localObject2).append(this.mNormalMap.size());
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      paramString = getRequiredSessionList(paramInt, paramString);
      return paramString;
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
    Object localObject1 = (IGameMsgBoxManager)this.mApp.getRuntimeService(IGameMsgBoxManager.class, "");
    Object localObject2 = this.mNormalMap.keySet().iterator();
    int k = 0;
    int j = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (String)((Iterator)localObject2).next();
      localObject3 = (GameCenterSessionInfo)this.mNormalMap.get(localObject3);
      if ((localObject3 != null) && (!((IGameMsgBoxManager)localObject1).isGameInGameBox(((GameCenterSessionInfo)localObject3).h()))) {
        j += ((GameCenterSessionInfo)localObject3).o();
      }
    }
    int i;
    if (this.mPubMsgRedPointSwitch == 1) {
      i = 0 + j;
    } else {
      i = 0;
    }
    localObject1 = ((IGameMsgBoxManager)localObject1).getAppidsInGameBox().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (this.mFolderMap.containsKey(localObject2)) {
        k += 1;
      }
    }
    long l;
    if (this.mFolderMap.size() - k > 0) {
      l = getReqMsgCnt();
    } else {
      l = 0L;
    }
    k = i;
    if (paramBoolean) {
      k = (int)(i + l);
    }
    if (j + l > 0L) {
      this.mIsHasUnreadMsg = true;
    }
    localObject1 = TAG;
    localObject2 = new StringBuilder();
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
        i += ((GameCenterSessionInfo)localObject2).o();
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
  
  public HashMap<String, Integer> getUnreadForEachGame()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = getSessionInfoList(0, "-10001");
    if (localObject1 == null) {
      return localHashMap;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (GameCenterSessionInfo)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        String str = ((GameCenterSessionInfo)localObject2).h();
        int i = ((GameCenterSessionInfo)localObject2).o();
        localObject2 = (Integer)localHashMap.get(str);
        if (localObject2 == null) {
          localHashMap.put(str, Integer.valueOf(i));
        } else {
          localHashMap.put(str, Integer.valueOf(((Integer)localObject2).intValue() + i));
        }
      }
    }
    return localHashMap;
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
        if ((localObject2 != null) && (((GameCenterSessionInfo)localObject2).o() > 0)) {
          localArrayList.add(((GameCenterSessionInfo)localObject2).j());
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
  
  public int getUnshowedUnreadCntMsgBoxExclusive()
  {
    return getUnshowedUnreadCnt();
  }
  
  public int getViewType()
  {
    return 1;
  }
  
  public boolean isGameBuddySwitchOpen()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    return (localGameCenterMsgBean != null) && (localGameCenterMsgBean.g == 1);
  }
  
  public boolean isGameMsgBlocked(String paramString)
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
      paramString = ((GameCenterSessionInfo)localObject).h();
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
    paramString = findGameSwitchConfig(paramString);
    boolean bool = true;
    if (paramString == null) {
      return true;
    }
    if (paramString.mSyncSwitch == 0) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isGrayOpen()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    return (localGameCenterMsgBean != null) && (localGameCenterMsgBean.a == 1);
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
  
  public boolean isJumpGameProfileCard()
  {
    GameCenterMsgBean localGameCenterMsgBean = this.mMsgConfig;
    if (localGameCenterMsgBean == null) {
      return false;
    }
    return localGameCenterMsgBean.o;
  }
  
  public boolean isShowInMsgBox()
  {
    if (this.mApp == null) {
      return false;
    }
    boolean bool = ((IGameMsgBoxABTestApi)QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab();
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, new Object[] { "[isShowInMsgBox], ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public void notifyGameMsgSayHiInfo(int paramInt, long paramLong, String paramString, GameMsgGreeting.QueryAIOGreetInfoRsp paramQueryAIOGreetInfoRsp)
  {
    IGameMsgSayHiCallback localIGameMsgSayHiCallback = this.mGameMsgSayHiCallback;
    if ((localIGameMsgSayHiCallback != null) && (localIGameMsgSayHiCallback.hashCode() == paramInt)) {
      this.mGameMsgSayHiCallback.a(paramLong, paramString, paramQueryAIOGreetInfoRsp);
    }
  }
  
  public void notifyReceiveGameMsgSayHiMessage(String paramString1, String paramString2)
  {
    IGameMsgSayHiCallback localIGameMsgSayHiCallback = this.mGameMsgSayHiCallback;
    if (localIGameMsgSayHiCallback != null) {
      localIGameMsgSayHiCallback.a(paramString1, paramString2);
    }
  }
  
  public void notifyRemoteUserReady(int paramInt, ArrayList<GameMsgRemoteUserItem> paramArrayList)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[notifyRemoteUserReady], retCode:");
    localStringBuilder.append(paramInt);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = this.mRemoteListCallback;
    if (localObject != null) {
      ((IRemoteUserListCallback)localObject).a(paramInt, paramArrayList);
    }
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
      this.mHashcode = hashCode();
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
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject2 = findGameSwitchConfig(paramString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new GameSwitchConfig();
      ((GameSwitchConfig)localObject1).mAppId = paramString;
    }
    if (paramInt1 == 0) {
      handleSwitchType0((GameSwitchConfig)localObject1, paramString, paramInt2);
    } else if (paramInt1 == 1) {
      handleSwitchType1((GameSwitchConfig)localObject1, paramString, paramInt2);
    } else if (paramInt1 == 2) {
      handleSwitchType2((GameSwitchConfig)localObject1, paramString, paramInt2);
    }
    handleMsgBoxCase(paramInt1, paramString, paramInt2);
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
      ThreadManager.getSubThreadHandler().post(new GameMsgManagerServiceImpl.4(this, paramBoolean, paramArrayList));
      return;
    }
    finally {}
  }
  
  public void removeGameMsgSayHiCallback()
  {
    QLog.i(TAG, 1, "[removeGameMsgSayHiCallback]");
    this.mGameMsgSayHiCallback = null;
  }
  
  public void removeUserInfoChangedObserver(GameCenterUnissoObserver paramGameCenterUnissoObserver)
  {
    if (paramGameCenterUnissoObserver == null) {
      return;
    }
    try
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("manager->[removeUserInfoChangedObserver]++++, size:");
        ((StringBuilder)localObject2).append(this.mUserInfoChangeObserverList.size());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = this.mUserInfoChangeObserverList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeakReference)((Iterator)localObject1).next();
        if (localObject2 == null) {
          return;
        }
        if (((WeakReference)localObject2).get() == paramGameCenterUnissoObserver)
        {
          this.mUserInfoChangeObserverList.remove(localObject2);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removed-------");
          }
          return;
        }
      }
    }
    catch (Throwable paramGameCenterUnissoObserver)
    {
      QLog.w(TAG, 1, paramGameCenterUnissoObserver.getMessage());
    }
  }
  
  public void reqGameMsgSayHiInfo(String paramString1, String paramString2, IGameMsgSayHiCallback paramIGameMsgSayHiCallback)
  {
    QLog.i(TAG, 1, "[reqGameMsgSayHiInfo]");
    if (paramIGameMsgSayHiCallback == null) {
      return;
    }
    this.mGameMsgSayHiCallback = paramIGameMsgSayHiCallback;
    GameCenterUnissoHandler.a().b(paramIGameMsgSayHiCallback.hashCode(), paramString1, paramString2);
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
    String str = paramGameCenterSessionInfo.g();
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
    if (this.mApp == null) {
      return;
    }
    if ((isLastMessageInGameBox()) && (this.mUnshowedUnreadCnt == 0)) {
      return;
    }
    if ((((IRecentUserProxyService)this.mApp.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache().c("2747277822", 1008) == null) && (paramInt != 0)) {
      return;
    }
    this.mUnshowedUnreadCnt = paramInt;
    Object localObject1 = this.mApp.getApplication().getSharedPreferences("game_center_sp", 0);
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
  
  public PopupWindow showGameAIOStatusPopupWindow(GameDetailInfo paramGameDetailInfo, Activity paramActivity, Bundle paramBundle, View.OnClickListener paramOnClickListener)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(paramActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    paramBundle.getInt("from");
    paramGameDetailInfo = GameAioOnlineStatusPopUpWindow.a(this.mApp, paramActivity, paramGameDetailInfo, paramBundle, paramOnClickListener);
    paramGameDetailInfo.setAnimationStyle(2131952195);
    paramGameDetailInfo.showAtLocation(paramActivity.getWindow().getDecorView(), 80, 0, 0);
    paramGameDetailInfo.c();
    return paramGameDetailInfo;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    MessageRecord localMessageRecord = checkUpdateParam(paramObject);
    if (localMessageRecord == null) {
      return;
    }
    tryGetGameSwitchFromSvr();
    ConversationInfo localConversationInfo = TinyConvProxy.a().a(this.mApp, localMessageRecord.frienduin, localMessageRecord.istroop);
    if (QLog.isColorLevel())
    {
      paramObservable = TAG;
      paramObject = new StringBuilder();
      paramObject.append("[update] ##-- new msg:");
      paramObject.append(localMessageRecord.frienduin);
      paramObject.append(", conInfo:");
      paramObject.append(localConversationInfo);
      QLog.d(paramObservable, 1, paramObject.toString());
    }
    if (localConversationInfo == null) {
      return;
    }
    if ((this.mSessionDelDataHelper != null) && (localConversationInfo.unreadCount > 0)) {
      GameDelSessionDataHelper.a(localMessageRecord.frienduin, this.mSessionDelDataHelper);
    }
    paramObservable = getSessionInfoByUin(localMessageRecord.frienduin);
    int i = 0;
    if (paramObservable == null)
    {
      paramObject = creatSessionInfo(localMessageRecord, localConversationInfo.tinyInfo);
      paramObservable = paramObject;
      if (paramObject != null) {}
    }
    else
    {
      i = paramObservable.o();
      handleFolderSession(paramObservable);
    }
    paramObservable.d(localConversationInfo.unreadCount);
    if ((localMessageRecord instanceof MessageForPic)) {
      paramObservable.m(this.mApp.getApplicationContext().getResources().getString(2131889903));
    } else {
      paramObservable.m(localMessageRecord.msg);
    }
    paramObservable.b(localMessageRecord.time);
    paramObservable.a(localMessageRecord.isSend());
    paramObservable.a(this.mApp);
    notifyMessageChange(paramObservable, i);
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
    localStringBuilder.append(paramGameCenterMsgBean.a);
    localStringBuilder.append(",msgListUrl:");
    localStringBuilder.append(paramGameCenterMsgBean.b);
    localStringBuilder.append(",settingUrl:");
    localStringBuilder.append(paramGameCenterMsgBean.c);
    localStringBuilder.append(",prefix:");
    localStringBuilder.append(paramGameCenterMsgBean.d);
    QLog.i(str, 1, localStringBuilder.toString());
    if (this.mMsgConfig == null) {
      this.mMsgConfig = new GameCenterMsgBean();
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.b)) {
      this.mMsgConfig.b = paramGameCenterMsgBean.b;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.c)) {
      this.mMsgConfig.c = paramGameCenterMsgBean.c;
    }
    this.mMsgConfig.a = paramGameCenterMsgBean.a;
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.d)) {
      this.mMsgConfig.d = paramGameCenterMsgBean.d;
    }
    this.mMsgConfig.g = paramGameCenterMsgBean.g;
    this.mMsgConfig.h = paramGameCenterMsgBean.h;
    this.mMsgConfig.j = paramGameCenterMsgBean.j;
    this.mMsgConfig.i = paramGameCenterMsgBean.i;
    this.mMsgConfig.m = paramGameCenterMsgBean.m;
    this.mMsgConfig.n = paramGameCenterMsgBean.n;
    this.mMsgConfig.l = paramGameCenterMsgBean.l;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */