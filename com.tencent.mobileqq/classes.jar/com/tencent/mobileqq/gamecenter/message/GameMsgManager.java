package com.tencent.mobileqq.gamecenter.message;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.config.business.GameCenterMsgBean;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.data.GameQQPlayerUtil;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoObserver;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
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
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class GameMsgManager
  implements Observer, Manager
{
  private static final String jdField_a_of_type_JavaLangString = GameCenterUnissoHandler.jdField_a_of_type_JavaLangString + "GameMsgManager";
  private static boolean jdField_e_of_type_Boolean = false;
  public int a;
  private long jdField_a_of_type_Long = 0L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GameCenterMsgBean jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean = new GameCenterMsgBean();
  public GameQQPlayerUtil a;
  private GameCenterUnissoObserver jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGameCenterUnissoObserver = new GameMsgManager.1(this);
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private Runnable jdField_a_of_type_JavaLangRunnable = new GameMsgManager.2(this);
  private Map<String, String> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private Map<String, GameUserInfo> jdField_b_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  public boolean b;
  private Map<String, GameBasicInfo> c;
  public boolean c;
  private Map<String, GameSwitchConfig> d;
  public boolean d;
  private Map<String, GameCenterSessionInfo> jdField_e_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, GameCenterSessionInfo> f = new ConcurrentHashMap();
  private Map<String, GameCenterSessionInfo> g = new ConcurrentHashMap();
  
  public GameMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameQQPlayerUtil = new GameQQPlayerUtil();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_d_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[GameMsgManager] start");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[GameMsgManager] end");
  }
  
  private ArrayList<String> a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      GameUserInfo localGameUserInfo = a(str);
      if (localGameUserInfo == null)
      {
        localArrayList.add(str);
        QLog.i(jdField_a_of_type_JavaLangString, 2, "case 1: can't find in local, roldId:" + str);
      }
      else
      {
        long l2 = l1 - localGameUserInfo.mSaveTs;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "delta:" + l2);
        }
        if (l2 >= 120000L)
        {
          localArrayList.add(str);
          QLog.i(jdField_a_of_type_JavaLangString, 2, "case 2: it's time to update, roldId:" + str);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(GameCenterSessionInfo paramGameCenterSessionInfo, GameDetailInfo paramGameDetailInfo)
  {
    paramGameCenterSessionInfo.k(paramGameDetailInfo.jdField_c_of_type_JavaLangString);
    paramGameCenterSessionInfo.j(c(paramGameDetailInfo.jdField_c_of_type_JavaLangString));
    paramGameCenterSessionInfo.i(paramGameDetailInfo.f);
    paramGameCenterSessionInfo.f(paramGameDetailInfo.jdField_d_of_type_JavaLangString);
    paramGameCenterSessionInfo.e(paramGameDetailInfo.jdField_b_of_type_Int);
    paramGameCenterSessionInfo.h(paramGameDetailInfo.e);
    paramGameCenterSessionInfo.g(paramGameDetailInfo.j);
    paramGameCenterSessionInfo.c(paramGameDetailInfo.l);
    paramGameCenterSessionInfo.a(paramGameDetailInfo.k);
  }
  
  private void a(GameBasicInfo paramGameBasicInfo)
  {
    if ((paramGameBasicInfo == null) || (TextUtils.isEmpty(paramGameBasicInfo.mAppId))) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[updateGameConfigItem], appId:" + paramGameBasicInfo.mAppId);
    this.jdField_c_of_type_JavaUtilMap.put(paramGameBasicInfo.mAppId, paramGameBasicInfo);
    a(paramGameBasicInfo);
  }
  
  private void a(GameUserInfo paramGameUserInfo)
  {
    if ((paramGameUserInfo == null) || (TextUtils.isEmpty(paramGameUserInfo.mRoleId))) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[updateGameUsrInfoItem], roleId:" + paramGameUserInfo.mRoleId);
    this.jdField_b_of_type_JavaUtilMap.put(paramGameUserInfo.mRoleId, paramGameUserInfo);
    a(paramGameUserInfo);
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[isInited]" + jdField_e_of_type_Boolean);
    }
    return jdField_e_of_type_Boolean;
  }
  
  private void e()
  {
    try
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(GameUserInfo.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameUserInfo)localObject2;
            if (!TextUtils.isEmpty(((GameUserInfo)localObject2).mRoleId)) {
              this.jdField_b_of_type_JavaUtilMap.put(((GameUserInfo)localObject2).mRoleId, localObject2);
            }
          }
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "ursInfo.size:" + this.jdField_b_of_type_JavaUtilMap.size());
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
      return;
    }
  }
  
  private void f()
  {
    try
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(GameBasicInfo.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameBasicInfo)localObject2;
            if (!TextUtils.isEmpty(((GameBasicInfo)localObject2).mAppId)) {
              this.jdField_c_of_type_JavaUtilMap.put(((GameBasicInfo)localObject2).mAppId, localObject2);
            }
          }
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "gameConfig.size:" + this.jdField_c_of_type_JavaUtilMap.size());
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
      return;
    }
  }
  
  private void g()
  {
    try
    {
      Object localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(GameSwitchConfig.class);
      if (localObject1 != null)
      {
        if (((ArrayList)localObject1).size() == 0) {
          return;
        }
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Entity)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = (GameSwitchConfig)localObject2;
            if (!TextUtils.isEmpty(((GameSwitchConfig)localObject2).mAppId)) {
              this.jdField_d_of_type_JavaUtilMap.put(((GameSwitchConfig)localObject2).mAppId, localObject2);
            }
          }
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "gameSwitchConfig.size:" + this.jdField_d_of_type_JavaUtilMap.size());
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
      return;
    }
  }
  
  public int a()
  {
    return a(true);
  }
  
  public int a(boolean paramBoolean)
  {
    int j = 0;
    if (this.g.size() == 0) {
      a();
    }
    Iterator localIterator = this.g.keySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (GameCenterSessionInfo)this.g.get(localObject);
      if (localObject == null) {
        break label170;
      }
      i = ((GameCenterSessionInfo)localObject).c() + i;
    }
    label170:
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_Int == 1) {
        j = 0 + i;
      }
      long l = a();
      int k = j;
      if (paramBoolean) {
        k = (int)(j + l);
      }
      if (i + l > 0L) {
        this.jdField_a_of_type_Boolean = true;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[getUnreadCnt] cnt:" + k);
      return k;
    }
  }
  
  public long a()
  {
    long l1 = GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sp_key_req_msg_unread_num");
    long l2 = GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sp_key_req_msg_read_time");
    if ((GameMsgUtil.a(l1)) && (!GameMsgUtil.a(l2)) && (this.f.size() > 0)) {
      return 1L;
    }
    return 0L;
  }
  
  public GameCenterSessionInfo a()
  {
    if (this.jdField_e_of_type_JavaUtilMap.size() == 0) {
      a();
    }
    Object localObject2 = new ArrayList(this.f.values());
    Object localObject1 = new ArrayList(this.g.values());
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
  
  public GameCenterSessionInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoByUin] sessionId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.jdField_e_of_type_JavaUtilMap.size() == 0) {
      a();
    }
    return (GameCenterSessionInfo)this.jdField_e_of_type_JavaUtilMap.get(paramString);
  }
  
  public GameBasicInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[findGameConfig], appId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    do
    {
      return paramString;
      localObject = (GameBasicInfo)this.jdField_c_of_type_JavaUtilMap.get(paramString);
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "got it from cache");
    return localObject;
    QLog.i(jdField_a_of_type_JavaLangString, 1, "try to read from db");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(GameBasicInfo.class, paramString);
    if (localObject != null)
    {
      localObject = (GameBasicInfo)localObject;
      this.jdField_c_of_type_JavaUtilMap.put(paramString, localObject);
      return localObject;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "fail to find gameCfg from db.");
    return null;
  }
  
  public GameDetailInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSingleGameDetail], roleId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    GameUserInfo localGameUserInfo = a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (localGameUserInfo == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "usrInfo is null");
      localArrayList.add(paramString);
      a(true, localArrayList);
      return null;
    }
    GameBasicInfo localGameBasicInfo = a(localGameUserInfo.mAppId);
    if (localGameBasicInfo == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "basicinfp is null");
      localArrayList.add(paramString);
      a(true, localArrayList);
      return null;
    }
    localArrayList.add(paramString);
    a(false, localArrayList);
    return GameDetailInfo.a(localGameBasicInfo, localGameUserInfo);
  }
  
  public GameSwitchConfig a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[findGameSwitchConfig], appId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    do
    {
      return paramString;
      localObject = (GameSwitchConfig)this.jdField_d_of_type_JavaUtilMap.get(paramString);
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "got it from cache");
    return localObject;
    QLog.i(jdField_a_of_type_JavaLangString, 1, "try to read from db");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(GameSwitchConfig.class, paramString);
    if (localObject != null)
    {
      localObject = (GameSwitchConfig)localObject;
      this.jdField_d_of_type_JavaUtilMap.put(paramString, localObject);
      return localObject;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "fail to find gameCfg from db.");
    return null;
  }
  
  public GameUserInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[findGameUserInfo], roleId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    do
    {
      return paramString;
      localObject = (GameUserInfo)this.jdField_b_of_type_JavaUtilMap.get(paramString);
      if (localObject == null) {
        break;
      }
      paramString = (String)localObject;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "got it from cache");
    return localObject;
    QLog.i(jdField_a_of_type_JavaLangString, 1, "try to read from db");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(GameUserInfo.class, paramString);
    if (localObject != null)
    {
      localObject = (GameUserInfo)localObject;
      this.jdField_b_of_type_JavaUtilMap.put(paramString, localObject);
      return localObject;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "fail to find usrinfo from db.");
    return null;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.e))) {
      return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.e;
    }
    return GameMsgUtil.jdField_d_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public ArrayList<String> a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      return (ArrayList)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public HashMap<String, GameDetailInfo> a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramArrayList.iterator();
    boolean bool = false;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      GameUserInfo localGameUserInfo = a(str);
      if (localGameUserInfo == null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "usrInfo is null, roleId:" + str);
        bool = true;
      }
      else
      {
        GameBasicInfo localGameBasicInfo = a(localGameUserInfo.mAppId);
        if (localGameBasicInfo == null)
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "basicinfp is null, appid:" + localGameUserInfo.mAppId);
          bool = true;
        }
        else
        {
          localHashMap.put(str, GameDetailInfo.a(localGameBasicInfo, localGameUserInfo));
        }
      }
    }
    a(bool, paramArrayList);
    return localHashMap;
  }
  
  public List<GameCenterSessionInfo> a()
  {
    return a(0, "");
  }
  
  public List<GameCenterSessionInfo> a(int paramInt, String paramString)
  {
    Object localObject1;
    Object localObject4;
    Object localObject5;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] type:" + paramInt + ",gameId:" + paramString + "curSize:" + this.jdField_e_of_type_JavaUtilMap.size());
      }
      if (!d()) {}
      for (localObject1 = new ArrayList();; localObject1 = null)
      {
        return localObject1;
        localObject1 = new ArrayList();
        if (this.jdField_e_of_type_JavaUtilMap.size() != 0) {
          break label926;
        }
        localObject3 = b();
        if ((localObject3 != null) && (((List)localObject3).size() != 0)) {
          break;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] tinyconversion is null.return");
      }
      localObject2 = new HashSet();
      localObject4 = ((List)localObject3).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (ConversationInfo)((Iterator)localObject4).next();
        if ((((ConversationInfo)localObject5).tinyInfo != null) && (!TextUtils.isEmpty(((ConversationInfo)localObject5).tinyInfo.fromRoleId)))
        {
          ((Set)localObject2).add(((ConversationInfo)localObject5).tinyInfo.fromRoleId);
          ((Set)localObject2).add(((ConversationInfo)localObject5).tinyInfo.toRoleId);
        }
      }
      if (!QLog.isColorLevel()) {
        break label295;
      }
    }
    finally {}
    QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoList] tinycon size:" + ((List)localObject3).size() + " id size:" + ((Set)localObject2).size());
    label295:
    Object localObject2 = a(new ArrayList((Collection)localObject2));
    Object localObject3 = ((List)localObject3).iterator();
    label319:
    Object localObject6;
    for (;;)
    {
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ConversationInfo)((Iterator)localObject3).next();
        if (localObject4 == null)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] info is null, continue.");
        }
        else if ((((ConversationInfo)localObject4).tinyInfo != null) && (b(((ConversationInfo)localObject4).tinyInfo.gameAppId + "")))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] msg blocked: " + ((ConversationInfo)localObject4).uin);
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] info:" + ((ConversationInfo)localObject4).toString());
          }
          localObject5 = new GameCenterSessionInfo();
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((ConversationInfo)localObject4).uin, ((ConversationInfo)localObject4).type);
          CharSequence localCharSequence;
          if (localObject6 != null)
          {
            localCharSequence = ((Message)localObject6).emoRecentMsg;
            if (!TextUtils.isEmpty(localCharSequence)) {
              ((GameCenterSessionInfo)localObject5).m(localCharSequence.toString());
            }
            ((GameCenterSessionInfo)localObject5).a(((Message)localObject6).isSend());
            ((GameCenterSessionInfo)localObject5).b(((Message)localObject6).time);
          }
          localObject6 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(((ConversationInfo)localObject4).uin, ((ConversationInfo)localObject4).type);
          if (localObject6 != null)
          {
            localCharSequence = ((Message)localObject6).emoRecentMsg;
            if (!TextUtils.isEmpty(localCharSequence)) {
              ((GameCenterSessionInfo)localObject5).l(localCharSequence.toString());
            }
            ((GameCenterSessionInfo)localObject5).a(((Message)localObject6).time);
          }
          ((GameCenterSessionInfo)localObject5).e(((ConversationInfo)localObject4).uin);
          ((GameCenterSessionInfo)localObject5).b(((ConversationInfo)localObject4).type);
          ((GameCenterSessionInfo)localObject5).d(((ConversationInfo)localObject4).unreadCount);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] sessionId" + ((ConversationInfo)localObject4).uin + " tinyInfo:" + ((ConversationInfo)localObject4).tinyInfo);
          }
          if ((((ConversationInfo)localObject4).tinyInfo != null) && (!TextUtils.isEmpty(((ConversationInfo)localObject4).tinyInfo.fromRoleId)))
          {
            ((GameCenterSessionInfo)localObject5).d(((ConversationInfo)localObject4).tinyInfo.fromRoleId);
            ((GameCenterSessionInfo)localObject5).b(((ConversationInfo)localObject4).tinyInfo.toRoleId);
            ((GameCenterSessionInfo)localObject5).c(((ConversationInfo)localObject4).tinyInfo.fromTinyId);
            ((GameCenterSessionInfo)localObject5).d(((ConversationInfo)localObject4).tinyInfo.toTinyId);
            if (localObject2 != null)
            {
              localObject6 = (GameDetailInfo)((HashMap)localObject2).get(((ConversationInfo)localObject4).tinyInfo.fromRoleId);
              if (!QLog.isColorLevel()) {
                break label1493;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoList] sessionId:" + ((ConversationInfo)localObject4).uin + ",gameDetailInfo:" + localObject6);
              break label1493;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject6 != null) {
        a((GameCenterSessionInfo)localObject5, (GameDetailInfo)localObject6);
      }
      this.jdField_e_of_type_JavaUtilMap.put(((GameCenterSessionInfo)localObject5).d(), localObject5);
      break label319;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoList] sessionMap:" + this.jdField_e_of_type_JavaUtilMap.toString());
      }
      label926:
      this.g.clear();
      this.f.clear();
      localObject2 = this.jdField_e_of_type_JavaUtilMap.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject3 = (GameCenterSessionInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject3);
        ((GameCenterSessionInfo)localObject3).c(0);
        if (a(((GameCenterSessionInfo)localObject3).e()))
        {
          ((GameCenterSessionInfo)localObject3).a(1);
          this.g.put(((GameCenterSessionInfo)localObject3).d(), localObject3);
        }
        else
        {
          ((GameCenterSessionInfo)localObject3).a(0);
          if (((GameCenterSessionInfo)localObject3).c() > 0)
          {
            if (!this.f.containsKey(((GameCenterSessionInfo)localObject3).e()))
            {
              ((GameCenterSessionInfo)localObject3).a();
              this.f.put(((GameCenterSessionInfo)localObject3).e(), localObject3);
            }
            else
            {
              localObject4 = (GameCenterSessionInfo)this.f.get(((GameCenterSessionInfo)localObject3).e());
              if (((GameCenterSessionInfo)localObject3).a() > ((GameCenterSessionInfo)localObject4).a())
              {
                ((GameCenterSessionInfo)localObject3).c(((GameCenterSessionInfo)localObject4).b() + 1);
                this.f.put(((GameCenterSessionInfo)localObject3).e(), localObject3);
              }
            }
          }
          else {
            QLog.i(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] folder session:" + localObject3);
          }
        }
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[getSessionInfoList] size:" + this.jdField_e_of_type_JavaUtilMap.size() + ",fsize:" + this.f.size() + "，nsize:" + this.g.size());
      if (paramInt == 0)
      {
        ((List)localObject1).addAll(this.g.values());
        ((List)localObject1).addAll(this.f.values());
        paramString = (String)localObject1;
      }
      for (;;)
      {
        Collections.sort(paramString);
        localObject1 = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoList] ret:" + paramString.toString());
        localObject1 = paramString;
        break;
        if (paramInt == 1)
        {
          paramString = new ArrayList(this.f.values());
        }
        else if (paramInt == 2)
        {
          paramString = new ArrayList(this.g.values());
        }
        else
        {
          if (paramInt == 3)
          {
            localObject2 = this.jdField_e_of_type_JavaUtilMap.keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (String)((Iterator)localObject2).next();
              if (TextUtils.equals(paramString, ((GameCenterSessionInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject3)).e())) {
                ((List)localObject1).add(this.jdField_e_of_type_JavaUtilMap.get(localObject3));
              }
            }
          }
          paramString = (String)localObject1;
        }
      }
      label1493:
      if (localObject6 != null) {}
    }
  }
  
  public void a()
  {
    GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sp_key_req_msg_unread_num", 0L);
    GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sp_key_req_msg_read_time", System.currentTimeMillis());
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "update r value:", Integer.valueOf(paramInt) });
    }
    b(paramInt);
    if (paramInt == 1)
    {
      GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sp_key_req_msg_unread_num", System.currentTimeMillis());
      GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "sp_key_req_msg_read_time", 0L);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().b("2747277822", 1008) == null) && (paramInt != 0));
      this.jdField_b_of_type_Int = paramInt;
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
      String str = "sp_enter_pub" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localSharedPreferences.edit().putInt(str, this.jdField_b_of_type_Int).apply();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[setUnshowedUnreadCnt] cnt:" + this.jdField_b_of_type_Int);
      }
    } while ((!paramBoolean) || (paramInt != 0));
    a();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(GameCenterMsgBean paramGameCenterMsgBean)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 2, "[updateGraySwich]");
    if (paramGameCenterMsgBean == null) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "graySwitch:" + paramGameCenterMsgBean.jdField_a_of_type_Int + ",msgListUrl:" + paramGameCenterMsgBean.jdField_b_of_type_JavaLangString + ",prefix:" + paramGameCenterMsgBean.jdField_c_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean == null) {
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean = new GameCenterMsgBean();
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_b_of_type_JavaLangString = paramGameCenterMsgBean.jdField_b_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_a_of_type_Int = paramGameCenterMsgBean.jdField_a_of_type_Int;
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_c_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_c_of_type_JavaLangString = paramGameCenterMsgBean.jdField_c_of_type_JavaLangString;
    }
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_c_of_type_Int = paramGameCenterMsgBean.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.e = paramGameCenterMsgBean.e;
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap = paramGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap;
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_d_of_type_Int = paramGameCenterMsgBean.jdField_d_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.f = paramGameCenterMsgBean.f;
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.g = paramGameCenterMsgBean.g;
    this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap = paramGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[setAllReaded] gameId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_e_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)this.jdField_e_of_type_JavaUtilMap.get(str);
        if (paramString.equals(localGameCenterSessionInfo.e()))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(localGameCenterSessionInfo.d(), 10007);
          localGameCenterSessionInfo.d(0);
          if (this.g.get(str) != null) {
            ((GameCenterSessionInfo)this.g.get(str)).d(0);
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[onGameSwitchChange] gameId:" + paramString + ",switchType:" + paramInt1 + ",value:" + paramInt2);
    ArrayList localArrayList = new ArrayList();
    GameSwitchConfig localGameSwitchConfig2 = a(paramString);
    GameSwitchConfig localGameSwitchConfig1 = localGameSwitchConfig2;
    if (localGameSwitchConfig2 == null)
    {
      localGameSwitchConfig1 = new GameSwitchConfig();
      localGameSwitchConfig1.mAppId = paramString;
    }
    if (paramInt1 == 0) {
      if ((paramInt2 != 0) && (paramInt2 != 1))
      {
        localGameSwitchConfig1.mBlockSwitch = 0;
        localArrayList.add(localGameSwitchConfig1);
        c(localArrayList);
        if (localGameSwitchConfig1.mBlockSwitch == 1) {
          b(paramString);
        }
      }
    }
    while (paramInt1 != 1) {
      for (;;)
      {
        return;
        localGameSwitchConfig1.mBlockSwitch = paramInt2;
      }
    }
    if ((paramInt2 != 0) && (paramInt2 != 1)) {}
    for (localGameSwitchConfig1.mSyncSwitch = 1;; localGameSwitchConfig1.mSyncSwitch = paramInt2)
    {
      localArrayList.add(localGameSwitchConfig1);
      c(localArrayList);
      if (localGameSwitchConfig1.mSyncSwitch != 0) {
        break;
      }
      a(paramString);
      return;
    }
  }
  
  public void a(String paramString, GameCenterSessionInfo paramGameCenterSessionInfo, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramString);
    localIntent.setPackage(BaseApplicationImpl.getApplication().getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_game_msg", paramGameCenterSessionInfo);
    localBundle.putInt("key_msg_change_type", paramInt1);
    localBundle.putInt("key_msg_unread_cnt", paramInt2);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[notifyMessageChange] action:" + paramString + ",type:" + paramInt1 + ",cnt:" + paramInt2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[updateRedDotConfig], roleId:" + paramString1 + ",value:" + paramString2);
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
  }
  
  public void a(ArrayList<GameUserInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[saveOrUpdateGameUsrInfoArrays], size:" + paramArrayList.size());
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameUserInfo localGameUserInfo1 = (GameUserInfo)paramArrayList.next();
        if (localGameUserInfo1 != null)
        {
          GameUserInfo localGameUserInfo2 = (GameUserInfo)this.jdField_b_of_type_JavaUtilMap.get(localGameUserInfo1.mRoleId);
          if (localGameUserInfo2 == null)
          {
            localGameUserInfo1.setStatus(1000);
            a(localGameUserInfo1);
          }
          else if (localGameUserInfo1.mUpdateTs != localGameUserInfo2.mUpdateTs)
          {
            a(localGameUserInfo1);
            QLog.i(jdField_a_of_type_JavaLangString, 1, "game user info has changed,origTS:" + localGameUserInfo2.mUpdateTs + ",newTS:" + localGameUserInfo1.mUpdateTs);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[pullGameUsrInfoFromServer], isForcePull:" + paramBoolean);
    }
    if (!d())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "not in gray whitelist, return.");
      }
      return;
    }
    ThreadManager.getSubThreadHandler().post(new GameMsgManager.4(this, paramBoolean, paramArrayList));
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen()) {
      if (paramEntity.getStatus() == 1000)
      {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool = true;
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      return bool;
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
      }
    }
    QLog.e(jdField_a_of_type_JavaLangString, 2, "updateEntity em closed e=" + paramEntity.getTableName());
    return false;
  }
  
  public boolean a(String paramString)
  {
    GameSwitchConfig localGameSwitchConfig = a(paramString);
    if (localGameSwitchConfig == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[isGameMsgSync] gameId:" + paramString + ", config is null,return true");
      return true;
    }
    if (localGameSwitchConfig.mSyncSwitch == 0) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[isGameMsgSync] gameId:" + paramString + ", ret:" + bool);
      }
      return bool;
    }
  }
  
  public int b()
  {
    if (this.g.size() == 0) {
      a();
    }
    Iterator localIterator = this.g.keySet().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (GameCenterSessionInfo)this.g.get(localObject);
      if (localObject == null) {
        break label145;
      }
      i = ((GameCenterSessionInfo)localObject).c() + i;
    }
    label145:
    for (;;)
    {
      break;
      long l = a();
      int j = (int)(0 + i + l);
      if (l + i > 0L) {
        this.jdField_a_of_type_Boolean = true;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[getUnreadCnt4MsgTab] cnt:" + j);
      return j;
    }
  }
  
  public GameCenterSessionInfo b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[getSessionInfoByRoleId] roleId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.jdField_e_of_type_JavaUtilMap.size() == 0) {
      a();
    }
    Iterator localIterator = this.jdField_e_of_type_JavaUtilMap.keySet().iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (String)localIterator.next();
      localObject = (GameCenterSessionInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject);
    } while (!paramString.equals(((GameCenterSessionInfo)localObject).c()));
    for (paramString = (String)localObject;; paramString = null) {
      return paramString;
    }
  }
  
  public String b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_b_of_type_JavaLangString))) {
      return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_b_of_type_JavaLangString;
    }
    return GameMsgUtil.jdField_b_of_type_JavaLangString;
  }
  
  public String b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap != null) && (!TextUtils.isEmpty(paramString))) {
      return (String)this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap.get(paramString);
    }
    return null;
  }
  
  public List<ConversationInfo> b()
  {
    return TinyConvProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void b()
  {
    a("action_qgame_messgae_change", null, 3, a());
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[setPubAccRedSwitch], v:" + paramInt);
    }
    if (paramInt != this.jdField_a_of_type_Int)
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0).edit().putInt("sp_pubacc_msg_redpoint", paramInt).commit();
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[deleteAllSession] gameId:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_e_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)((Map.Entry)localIterator.next()).getValue();
        if (paramString.equals(localGameCenterSessionInfo.e()))
        {
          localIterator.remove();
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localGameCenterSessionInfo.d(), 10007);
          }
        }
      }
      localIterator = this.g.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals(((GameCenterSessionInfo)((Map.Entry)localIterator.next()).getValue()).e())) {
          localIterator.remove();
        }
      }
      localIterator = this.f.entrySet().iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals((String)((Map.Entry)localIterator.next()).getKey())) {
          localIterator.remove();
        }
      }
    }
  }
  
  public void b(ArrayList<GameBasicInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[saveOrUpdateGameBasicConfigs], size:" + paramArrayList.size());
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameBasicInfo localGameBasicInfo1 = (GameBasicInfo)paramArrayList.next();
        if (localGameBasicInfo1 != null)
        {
          GameBasicInfo localGameBasicInfo2 = (GameBasicInfo)this.jdField_c_of_type_JavaUtilMap.get(localGameBasicInfo1.mAppId);
          if (localGameBasicInfo2 == null)
          {
            localGameBasicInfo1.setStatus(1000);
            a(localGameBasicInfo1);
          }
          else if (localGameBasicInfo2.mUpdateTs != localGameBasicInfo1.mUpdateTs)
          {
            a(localGameBasicInfo1);
            QLog.i(jdField_a_of_type_JavaLangString, 1, "game basic config has changed,origTS:" + localGameBasicInfo2.mUpdateTs + ",newTS:" + localGameBasicInfo1.mUpdateTs);
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_c_of_type_Int == 1);
  }
  
  public boolean b(String paramString)
  {
    GameSwitchConfig localGameSwitchConfig = a(paramString);
    if (localGameSwitchConfig == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[isGameMsgBlocked] gameId:" + paramString + ", config is null,return false");
    }
    while (localGameSwitchConfig.mBlockSwitch == 0) {
      return false;
    }
    return true;
  }
  
  public int c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[getUnshowedUnreadCnt] cnt:" + this.jdField_b_of_type_Int + ", mPubMsgRedPointSwitch:" + this.jdField_a_of_type_Int);
    }
    if (!GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {}
    while ((!d()) || (ServiceAccountFolderManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "2747277822"))) {
      return 0;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public GameCenterSessionInfo c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.f.size() == 0) {
      a();
    }
    return (GameCenterSessionInfo)this.f.get(paramString);
  }
  
  public String c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_c_of_type_JavaLangString))) {
      return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_c_of_type_JavaLangString;
    }
    return GameMsgUtil.jdField_c_of_type_JavaLangString;
  }
  
  public String c(String paramString)
  {
    paramString = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    if (paramString != null)
    {
      if ((paramString.remark != null) && (paramString.remark.length() > 0)) {
        return paramString.remark;
      }
      if ((paramString.name != null) && (paramString.name.length() > 0)) {
        return paramString.name;
      }
    }
    return "";
  }
  
  public List<String> c()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_e_of_type_JavaUtilMap.size() == 0) {
      a();
    }
    if (this.jdField_e_of_type_JavaUtilMap.size() > 0)
    {
      Iterator localIterator = this.jdField_e_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (GameCenterSessionInfo)this.jdField_e_of_type_JavaUtilMap.get(localObject);
        if ((localObject != null) && (((GameCenterSessionInfo)localObject).c() > 0)) {
          localArrayList.add(((GameCenterSessionInfo)localObject).g());
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[getUnreadFriIcon] friend icon size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void c()
  {
    if (!d()) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[tryGetGameSwitchFromSvr], not in gray whitelist, return.");
      }
    }
    while (System.currentTimeMillis() - this.jdField_a_of_type_Long <= 300000L) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[tryGetGameSwitchFromSvr]");
    ((GameCenterUnissoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER)).a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void c(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "[cleanSessionUnread] id:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      paramString = a(paramString);
    } while (paramString == null);
    paramString.d(0);
    c(a());
  }
  
  public void c(ArrayList<GameSwitchConfig> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameSwitchConfig localGameSwitchConfig = (GameSwitchConfig)paramArrayList.next();
        if (localGameSwitchConfig != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "[saveOrUpdateGameSwitchConfigs] config:" + localGameSwitchConfig.toString());
          }
          this.jdField_d_of_type_JavaUtilMap.put(localGameSwitchConfig.mAppId, localGameSwitchConfig);
          a(localGameSwitchConfig);
        }
      }
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    if ((((TempMsgBoxManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_BOX)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 10007)) && (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_d_of_type_Int == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[isShowInMsgBox], true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[isShowInMsgBox], false");
    }
    return false;
  }
  
  public int d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_d_of_type_Int == 1)) {
      return 1;
    }
    return 0;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean != null) {
      return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_d_of_type_JavaLangString;
    }
    return "";
  }
  
  public void d()
  {
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    localMqqHandler.sendMessage(localMqqHandler.obtainMessage(1009));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[updateRecentList] send update list msg.");
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean != null) && (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.jdField_a_of_type_Int == 1);
  }
  
  public int e()
  {
    return 1;
  }
  
  public String e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.f;
  }
  
  public String f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqConfigBusinessGameCenterMsgBean.g;
  }
  
  public void onDestroy()
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "[onDestroy]");
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGameCenterUnissoObserver);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!d()) {}
    label7:
    MessageRecord localMessageRecord;
    ConversationInfo localConversationInfo;
    do
    {
      do
      {
        break label7;
        break label7;
        do
        {
          return;
        } while (((paramObject instanceof MessageForUniteGrayTip)) || (!(paramObject instanceof MessageRecord)));
        localMessageRecord = (MessageRecord)paramObject;
      } while (localMessageRecord.istroop != 10007);
      c();
      localConversationInfo = TinyConvProxy.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord.frienduin, localMessageRecord.istroop);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "[update] ##-- new msg:" + localMessageRecord.frienduin + ", conInfo:" + localConversationInfo);
      }
    } while (localConversationInfo == null);
    paramObject = a(localMessageRecord.frienduin);
    label312:
    label326:
    label457:
    label472:
    int i;
    label476:
    int j;
    int k;
    int m;
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[update] create new sessionInfo.");
      }
      paramObject = new GameCenterSessionInfo();
      paramObject.e(localMessageRecord.frienduin);
      paramObject.b(10007);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(localMessageRecord.frienduin, localMessageRecord.istroop);
      if (localObject != null) {
        if (!TextUtils.isEmpty(((Message)localObject).emoRecentMsg)) {
          break label312;
        }
      }
      for (paramObservable = "";; paramObservable = ((Message)localObject).emoRecentMsg.toString())
      {
        paramObject.l(paramObservable);
        paramObject.a(((Message)localObject).time);
        paramObservable = localConversationInfo.tinyInfo;
        if (paramObservable == null) {
          break label472;
        }
        if (!b(paramObservable.gameAppId + "")) {
          break label326;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 1, "[update] ##-- new msg:" + localMessageRecord.frienduin + ", blocked.");
        return;
      }
      paramObject.d(paramObservable.fromRoleId);
      paramObject.b(paramObservable.toRoleId);
      paramObject.c(paramObservable.fromTinyId);
      paramObject.d(paramObservable.toTinyId);
      paramObject.f(paramObservable.gameAppId + "");
      localObject = a(paramObject.c());
      if (localObject != null) {
        a(paramObject, (GameDetailInfo)localObject);
      }
      if (a(paramObservable.gameAppId + ""))
      {
        paramObject.a(1);
        this.g.put(paramObject.d(), paramObject);
        this.jdField_e_of_type_JavaUtilMap.put(paramObject.d(), paramObject);
        i = 0;
        paramObservable = paramObject;
        paramObservable.d(localConversationInfo.unreadCount);
        paramObservable.m(localMessageRecord.msg);
        paramObservable.b(localMessageRecord.time);
        paramObservable.a(localMessageRecord.isSend());
        j = a();
        k = paramObservable.c();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[update] update info:" + paramObservable.toString());
        }
        m = b();
        if (paramObservable.a() != 0) {
          break label852;
        }
        paramObservable = c(paramObservable.e());
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[update] notify folder session:" + paramObservable);
        }
        a("action_qgame_messgae_change", paramObservable, 1, m);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[update] oldUnread:" + i + ",newUnread:" + k);
      }
      if ((!GameMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (i == k)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.refreshAppBadge();
      a(j, false);
      return;
      paramObject.a(0);
      paramObject.a();
      this.f.put(paramObject.e(), paramObject);
      break label457;
      j = paramObject.c();
      i = j;
      paramObservable = paramObject;
      if (paramObject.a() != 0) {
        break label476;
      }
      paramObservable = c(paramObject.e());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[update] folder session:" + paramObservable);
      }
      if (paramObservable != null)
      {
        paramObject.c(paramObservable.b() + 1);
        this.f.put(paramObject.e(), paramObject);
        i = j;
        paramObservable = paramObject;
        break label476;
      }
      paramObject.a();
      this.f.put(paramObject.e(), paramObject);
      i = j;
      paramObservable = paramObject;
      break label476;
      label852:
      a("action_qgame_messgae_change", paramObservable, 1, m);
      a("action_qgame_unread_change", paramObservable, 1, m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.GameMsgManager
 * JD-Core Version:    0.7.0.1
 */