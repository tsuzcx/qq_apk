package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.haoliyou.orion.XorCipher;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendForTroopConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopAddFriendHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troopAddFrd.Scene;
import com.tencent.mobileqq.troopAddFrd.Scene.OnSceneResultListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr.FlagMsgInfo;>;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBatchAddFriendMgr
  implements Scene.OnSceneResultListener
{
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy_MM_dd");
  private static final Comparator<TroopBatchAddFriendMgr.FlagMsgInfo> jdField_a_of_type_JavaUtilComparator = new TroopBatchAddFriendMgr.5();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopBatchAddFriendMgr.2(this);
  TroopRedDotObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver = new TroopBatchAddFriendMgr.3(this);
  private String jdField_a_of_type_JavaLangString = null;
  ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private String jdField_b_of_type_JavaLangString = "";
  ConcurrentHashMap<String, Scene> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopBatchAddFriendMgr(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver, true);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private Scene a(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Scene localScene = (Scene)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (localScene == null) {
        return null;
      }
      if (!localScene.a())
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return null;
      }
      return localScene;
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private ArrayList<TroopBatchAddFriendMgr.FlagMsgInfo> a(TroopBatchAddFriendMgr.FlagMsgInfo paramFlagMsgInfo, String paramString)
  {
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = b(paramString.mAtOrReplyMeUins);
    a(paramString, paramFlagMsgInfo);
    return paramString;
  }
  
  public static ArrayList<String> a(List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    HashMap localHashMap = new HashMap();
    int m = paramList.size();
    int j = 0;
    Object localObject1;
    for (int k = 0; j < m; k = i)
    {
      if (j < k)
      {
        i = k;
      }
      else
      {
        i = k;
        if (((MessageRecord)paramList.get(j)).senderuin.equals(str1))
        {
          int n;
          if (j == 0)
          {
            n = j + 1;
            i = k;
            if (n <= m - 1)
            {
              localObject1 = ((MessageRecord)paramList.get(n)).senderuin;
              i = k;
              if (!((String)localObject1).equals(str1))
              {
                if (localHashMap.containsKey(localObject1)) {
                  localHashMap.put(localObject1, Integer.valueOf(((Integer)localHashMap.get(localObject1)).intValue() + 1));
                } else {
                  localHashMap.put(localObject1, Integer.valueOf(1));
                }
                i = j + 2;
              }
            }
          }
          else if (j == m - 1)
          {
            n = j - 1;
            i = k;
            if (n >= 0)
            {
              i = k;
              if (n >= k)
              {
                localObject1 = ((MessageRecord)paramList.get(n)).senderuin;
                i = k;
                if (!((String)localObject1).equals(str1)) {
                  if (localHashMap.containsKey(localObject1))
                  {
                    localHashMap.put(localObject1, Integer.valueOf(((Integer)localHashMap.get(localObject1)).intValue() + 1));
                    i = k;
                  }
                  else
                  {
                    localHashMap.put(localObject1, Integer.valueOf(1));
                    i = k;
                  }
                }
              }
            }
          }
          else
          {
            Object localObject2 = null;
            i = j + 1;
            String str2 = ((MessageRecord)paramList.get(i)).senderuin;
            n = j - 1;
            localObject1 = localObject2;
            if (n >= 0)
            {
              localObject1 = localObject2;
              if (n >= k) {
                localObject1 = ((MessageRecord)paramList.get(n)).senderuin;
              }
            }
            if (!str2.equals(str1))
            {
              if (localHashMap.containsKey(str2)) {
                localHashMap.put(str2, Integer.valueOf(((Integer)localHashMap.get(str2)).intValue() + 1));
              } else {
                localHashMap.put(str2, Integer.valueOf(1));
              }
              i = j + 2;
            }
            if ((localObject1 != null) && (!((String)localObject1).equals(str2)) && (!((String)localObject1).equals(str1))) {
              if (localHashMap.containsKey(localObject1)) {
                localHashMap.put(localObject1, Integer.valueOf(((Integer)localHashMap.get(localObject1)).intValue() + 1));
              } else {
                localHashMap.put(localObject1, Integer.valueOf(1));
              }
            }
          }
        }
      }
      j += 1;
    }
    int i = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a().j;
    paramList = localHashMap.entrySet().iterator();
    while (paramList.hasNext())
    {
      localObject1 = (Map.Entry)paramList.next();
      if ((((Integer)((Map.Entry)localObject1).getValue()).intValue() >= i) && (!RobotUtils.a(paramQQAppInterface, (String)((Map.Entry)localObject1).getKey()))) {
        localArrayList.add(((Map.Entry)localObject1).getKey());
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString);
    if (paramString != null) {
      paramString.a(paramBoolean, paramInt);
    }
  }
  
  private void a(ArrayList<TroopBatchAddFriendMgr.FlagMsgInfo> paramArrayList, TroopBatchAddFriendMgr.FlagMsgInfo paramFlagMsgInfo)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    int i = 0;
    int k;
    for (int j = 0; i < ((ArrayList)localObject).size(); j = k)
    {
      k = j;
      if (paramFlagMsgInfo.jdField_a_of_type_JavaLangString != null)
      {
        k = j;
        if (paramFlagMsgInfo.jdField_a_of_type_JavaLangString.equals(((TroopBatchAddFriendMgr.FlagMsgInfo)((ArrayList)localObject).get(i)).jdField_a_of_type_JavaLangString))
        {
          if (((TroopBatchAddFriendMgr.FlagMsgInfo)((ArrayList)localObject).get(i)).jdField_a_of_type_Long < paramFlagMsgInfo.jdField_a_of_type_Long)
          {
            ((TroopBatchAddFriendMgr.FlagMsgInfo)((ArrayList)localObject).get(i)).jdField_a_of_type_Long = paramFlagMsgInfo.jdField_a_of_type_Long;
            ((TroopBatchAddFriendMgr.FlagMsgInfo)((ArrayList)localObject).get(i)).b = paramFlagMsgInfo.b;
            ((TroopBatchAddFriendMgr.FlagMsgInfo)((ArrayList)localObject).get(i)).jdField_a_of_type_Int = paramFlagMsgInfo.jdField_a_of_type_Int;
          }
          k = 1;
        }
      }
      i += 1;
    }
    if (j == 0) {
      ((ArrayList)localObject).add(paramFlagMsgInfo);
    }
  }
  
  private void a(ArrayList<TroopBatchAddFriendMgr.FlagMsgInfo> paramArrayList, String paramString)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      TroopInfo localTroopInfo = localTroopManager.b(paramString);
      if (localTroopInfo == null) {
        return;
      }
      Collections.sort(paramArrayList, jdField_a_of_type_JavaUtilComparator);
      int i = 10;
      Object localObject = localTroopManager.a();
      if (((BatchAddFriendForTroopConfig)localObject).p >= 1) {
        i = ((BatchAddFriendForTroopConfig)localObject).p;
      }
      if (paramArrayList.size() > i) {
        paramArrayList.subList(0, i);
      }
      localObject = a(paramArrayList);
      paramArrayList = (ArrayList<TroopBatchAddFriendMgr.FlagMsgInfo>)localObject;
      if (localObject == null) {
        paramArrayList = "";
      }
      localTroopInfo.mAtOrReplyMeUins = paramArrayList;
      localTroopManager.c(localTroopInfo);
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("markAtOrReplyMeMsgInTroop handled");
        paramArrayList.append(paramString);
        paramArrayList.append(localTroopInfo.mAtOrReplyMeUins);
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, paramArrayList.toString());
      }
    }
  }
  
  public int a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troop_gt_af_total_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences((String)localObject, 0).getInt(c(paramString), 0);
    int i = j;
    if (j >= ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a().f)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" has recommended exceed the limit ,uin = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject).toString());
      }
      i = -1;
    }
    return i;
  }
  
  public int a(String paramString, long paramLong, int paramInt)
  {
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    Object localObject1 = (TroopManager)((QQAppInterface)localObject2).getManager(QQManagerFactory.TROOP_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("startReqTroopMemberList troopUin_type_ts=%s_%d_%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
    }
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject1 = ((TroopManager)localObject1).b(paramString);
      if (localObject1 != null) {
        localObject1 = ((TroopInfo)localObject1).troopcode;
      } else {
        localObject1 = "0";
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("prepareTroopBatchAddFrdData return. net connect err %s", new Object[] { paramString }));
          }
          return -1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("startReqTroopMemberList troopUin_type_ts=%s_%d_%d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong) }));
        }
        localObject2 = (ITroopMemberListHandler)((QQAppInterface)localObject2).getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
        if (paramLong == 0L) {
          paramLong = System.currentTimeMillis();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
        ((ITroopMemberListHandler)localObject2).a(true, paramString, (String)localObject1, true, 7, paramLong, paramInt);
        return 0;
      }
    }
    return -1;
  }
  
  public int a(String paramString, long paramLong, int paramInt, boolean paramBoolean)
  {
    List localList = a(paramString);
    if (localList != null)
    {
      if (localList.size() == 0) {
        return -1;
      }
      ArrayList localArrayList = new ArrayList(localList.size());
      int i = 0;
      while (i < localList.size())
      {
        if ((!((TroopMemberInfo)localList.get(i)).memberuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (Utils.d(((TroopMemberInfo)localList.get(i)).memberuin))) {
          if ((paramBoolean) && (((TroopMemberInfo)localList.get(i)).recommendRemark == null)) {
            localArrayList.add(((TroopMemberInfo)localList.get(i)).memberuin);
          } else if (!paramBoolean) {
            localArrayList.add(((TroopMemberInfo)localList.get(i)).memberuin);
          }
        }
        i += 1;
      }
      if (localArrayList.size() > 0)
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
          return -1;
        }
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, new Object[] { "startReqRecmdRemarkList dbSize=", Integer.valueOf(localList.size()) });
        if (paramLong == 0L) {
          paramLong = System.currentTimeMillis();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
        ((ITroopAddFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ADD_FRIEND_HANDLER)).a(paramString, paramLong, paramInt, (ArrayList)localArrayList, paramBoolean);
        return 0;
      }
      return 1;
    }
    return -1;
  }
  
  public int a(String paramString, long paramLong, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    List localList = a(paramString);
    if (localList != null)
    {
      if (localList.size() == 0) {
        return -1;
      }
      ArrayList localArrayList = new ArrayList(localList.size());
      int i = 0;
      while (i < localList.size())
      {
        if ((!((TroopMemberInfo)localList.get(i)).memberuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (Utils.d(((TroopMemberInfo)localList.get(i)).memberuin))) {
          if ((paramBoolean) && (((TroopMemberInfo)localList.get(i)).commonFrdCnt == -2147483648)) {
            localArrayList.add(((TroopMemberInfo)localList.get(i)).memberuin);
          } else if (!paramBoolean) {
            localArrayList.add(((TroopMemberInfo)localList.get(i)).memberuin);
          }
        }
        i += 1;
      }
      if ((paramInt == 4) && (paramList != null))
      {
        i = 0;
        while (i < paramList.size())
        {
          String str = (String)paramList.get(i);
          if (!TextUtils.isEmpty(str))
          {
            int j = 0;
            Object localObject;
            while (j < localArrayList.size())
            {
              localObject = (String)localArrayList.get(j);
              if ((localObject != null) && (str.equals(localObject)))
              {
                j = 1;
                break label309;
              }
              j += 1;
            }
            j = 0;
            label309:
            if (j == 0)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("startReqCmnFrdCntList add uin unexpected ^_^ ");
              ((StringBuilder)localObject).append(StringUtil.e(str));
              QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, ((StringBuilder)localObject).toString());
              localArrayList.add(str);
            }
          }
          i += 1;
        }
      }
      if (localArrayList.size() > 0)
      {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, new Object[] { "startReqCmnFrdCntList dbSize=", Integer.valueOf(localList.size()), " reqSize=", Integer.valueOf(localArrayList.size()) });
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
          return -1;
        }
        if (paramLong == 0L) {
          paramLong = System.currentTimeMillis();
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
        ((ITroopAddFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ADD_FRIEND_HANDLER)).a(paramString, localArrayList, 0, paramLong, paramInt, paramBoolean);
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "startReqCmnFrdCntList no need");
      }
      return 1;
    }
    return -1;
  }
  
  String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("daily_rec_uin_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public String a(ArrayList<TroopBatchAddFriendMgr.FlagMsgInfo> paramArrayList)
  {
    if (paramArrayList != null) {
      if (paramArrayList.size() == 0) {
        return "";
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new JSONArray();
        i = 0;
        if (i < paramArrayList.size())
        {
          TroopBatchAddFriendMgr.FlagMsgInfo localFlagMsgInfo = (TroopBatchAddFriendMgr.FlagMsgInfo)paramArrayList.get(i);
          if ((localFlagMsgInfo != null) && (localFlagMsgInfo.jdField_a_of_type_JavaLangString != null))
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("mem", localFlagMsgInfo.jdField_a_of_type_JavaLangString);
            localJSONObject.put("type", localFlagMsgInfo.jdField_a_of_type_Int);
            localJSONObject.put("time", localFlagMsgInfo.jdField_a_of_type_Long);
            localJSONObject.put("seq", localFlagMsgInfo.b);
            ((JSONArray)localObject).put(localJSONObject);
            break label207;
          }
          QLog.e("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "inf memberUin is null ");
          break label207;
        }
        paramArrayList = new JSONObject();
        paramArrayList.put("list", localObject);
        paramArrayList = paramArrayList.toString();
        return paramArrayList;
      }
      catch (JSONException paramArrayList)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("FlagMsgInfoFromJson ");
        ((StringBuilder)localObject).append(paramArrayList.toString());
        QLog.e("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject).toString());
      }
      return "";
      label207:
      i += 1;
    }
  }
  
  public ArrayList<String> a(String paramString)
  {
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.b(paramString);
    String[] arrayOfString = null;
    Object localObject2 = null;
    Object localObject1 = arrayOfString;
    if (localTroopInfo != null)
    {
      localObject1 = arrayOfString;
      if (!TextUtils.isEmpty(localTroopInfo.dailyNewMemberUins))
      {
        localObject1 = arrayOfString;
        if (localTroopInfo.dailyNewMemberUins.startsWith(str))
        {
          arrayOfString = localTroopInfo.dailyNewMemberUins.split("\\|");
          localObject1 = localObject2;
          if (arrayOfString.length > 1)
          {
            localObject2 = new ArrayList();
            int i = arrayOfString.length - 1;
            for (;;)
            {
              localObject1 = localObject2;
              if (i <= 0) {
                break;
              }
              ((ArrayList)localObject2).add(arrayOfString[i]);
              i -= 1;
            }
          }
          localTroopInfo.dailyNewMemberUins = "";
          localTroopManager.b(localTroopInfo);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAndClean dailyNewMember  troopUin = ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(",resultList = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public List<TroopMemberInfo> a(String paramString)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((paramString != null) && (paramString.length() > 0) && (localObject != null))
    {
      localObject = ((QQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
      paramString = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
      ((EntityManager)localObject).close();
      return paramString;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFilesDir().getParent());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("shared_prefs");
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy curUin ");
      localStringBuilder.append(str);
      localStringBuilder.append(",sharePrefsDir = ");
      localStringBuilder.append((String)localObject);
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, localStringBuilder.toString());
    }
    ThreadManagerV2.executeOnFileThread(new TroopBatchAddFriendMgr.1(this, (String)localObject, str));
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramMessageRecord.msgseq);
    ((StringBuilder)localObject1).append("");
    localObject1 = a(paramString, ((StringBuilder)localObject1).toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_b_of_type_JavaLangString = ((String)localObject1);
      localObject1 = new ArrayList();
      int i;
      if ((paramMessageRecord.atInfoList != null) && (paramMessageRecord.atInfoList.size() > 0)) {
        i = 0;
      }
      while (i < paramMessageRecord.atInfoList.size())
      {
        Object localObject2 = (AtTroopMemberInfo)paramMessageRecord.atInfoList.get(i);
        if (((AtTroopMemberInfo)localObject2).flag == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(((AtTroopMemberInfo)localObject2).uin);
          localObject2 = localStringBuilder.toString();
          if (e((String)localObject2))
          {
            ((ArrayList)localObject1).add(localObject2);
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("update AtTroopMemberInfo = ");
              localStringBuilder.append((String)localObject2);
              QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, localStringBuilder.toString());
            }
          }
        }
        i += 1;
        continue;
        if ((paramMessageRecord instanceof MessageForReplyText))
        {
          paramMessageRecord = (MessageForReplyText)paramMessageRecord;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(paramMessageRecord.mSourceMsgInfo.mSourceMsgSenderUin);
          if (e(((StringBuilder)localObject2).toString()))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(paramMessageRecord.mSourceMsgInfo.mSourceMsgSenderUin);
            ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0) {
        a(paramString, (List)localObject1, 5);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "TriggerAndCleanAtOrReplyMsg handled");
    }
  }
  
  public void a(Scene paramScene)
  {
    if (paramScene != null)
    {
      if (TextUtils.isEmpty(paramScene.c)) {
        return;
      }
      String str = paramScene.c;
      paramScene = a(paramScene.c);
      if (QLog.isColorLevel()) {
        if (paramScene != null) {
          QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onReadyForInsertTip scene uin_type_ts_valid=%s_%d_%d_%b", new Object[] { str, Integer.valueOf(paramScene.jdField_a_of_type_Int), Long.valueOf(paramScene.jdField_a_of_type_Long), Boolean.valueOf(true) }));
        } else {
          QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onReadyForInsertTip scene uin_valid=%s_%b", new Object[] { str, Boolean.valueOf(false) }));
        }
      }
      if (paramScene != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ADD_FRIEND_HANDLER).notifyUI(TroopObserver.TYPE_NOTIFY_READY_FOR_TROOP_BATCHADD_TIP, true, new Object[] { paramScene.c, Integer.valueOf(paramScene.jdField_a_of_type_Int), paramScene.jdField_a_of_type_JavaUtilList });
      }
    }
  }
  
  public void a(String paramString)
  {
    String str = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troop_gt_af_daily_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(str);
    str = ((StringBuilder)localObject).toString();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(str, 0);
    str = b(paramString);
    ((SharedPreferences)localObject).edit().remove(str).apply();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeTroopBAGrayTipsDailyCount key = ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(",troopUin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Scene localScene = a(paramString);
    if (QLog.isColorLevel())
    {
      boolean bool = true;
      if (localScene == null) {
        bool = false;
      }
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onStartCheckInAIO [%s,%d] scene exist:%b", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(bool) }));
    }
    if (localScene != null) {
      localScene.a();
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ADD_FRIEND_HANDLER).notifyUI(TroopObserver.TYPE_NOTIFY_BATCH_ADDFRDS_DATA_PREPARE_ERR, false, new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
  }
  
  void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("troop_gt_af_daily_");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("_");
      paramString2 = new File(paramString1).list();
      if (paramString2 == null) {
        return;
      }
      String str = ((StringBuilder)localObject1).toString();
      ((StringBuilder)localObject1).append(jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
      localObject1 = ((StringBuilder)localObject1).toString();
      int j = paramString2.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramString2[i];
        if (((String)localObject2).startsWith(str))
        {
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("clearSPFile fileName ");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(",prefixToday = ");
            localStringBuilder.append((String)localObject1);
            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, localStringBuilder.toString());
          }
          if (!((String)localObject2).startsWith((String)localObject1))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString1);
            localStringBuilder.append(File.separator);
            localStringBuilder.append((String)localObject2);
            localObject2 = new File(localStringBuilder.toString());
            FileUtils.deleteFile(((File)localObject2).getAbsolutePath());
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("clearSPFile delete SP ");
              localStringBuilder.append(((File)localObject2).getAbsolutePath());
              QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, localStringBuilder.toString());
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markMultiAtOrReplyMeMsgInTroop single");
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (paramString1.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markAtOrReplyMeMsgInTroop unhandled when aio opened");
      }
      return;
    }
    if (!b("atMeOrReplyMe")) {
      return;
    }
    if (!e(paramString2)) {
      return;
    }
    paramString2 = a(new TroopBatchAddFriendMgr.FlagMsgInfo(this, paramString2, paramInt, paramLong1, paramLong2), paramString1);
    if ((paramString2 != null) && (paramString2.size() >= 0)) {
      a(paramString2, paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append("");
    localObject = a(paramString1, ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramString2);
      a(paramString1, (List)localObject, 5);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("TriggerAndCleanAtOrReplyMsg memUin  ");
        paramString1.append(paramString2);
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, paramString1.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "TriggerAndCleanAtOrReplyMsg handled");
    }
  }
  
  /* Error */
  public void a(String paramString, HashMap<String, Integer> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/tencent/mobileqq/troop/utils/TroopBatchAddFriendMgr:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 502	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   7: invokevirtual 508	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore 6
    //   12: aload 6
    //   14: invokevirtual 699	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   17: astore 7
    //   19: aload 7
    //   21: invokevirtual 704	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   24: new 94	java/lang/StringBuilder
    //   27: dup
    //   28: sipush 1024
    //   31: invokespecial 705	java/lang/StringBuilder:<init>	(I)V
    //   34: astore 8
    //   36: aload_2
    //   37: invokevirtual 708	java/util/HashMap:keySet	()Ljava/util/Set;
    //   40: invokeinterface 197 1 0
    //   45: astore 9
    //   47: aload 9
    //   49: invokeinterface 202 1 0
    //   54: ifeq +175 -> 229
    //   57: aload 9
    //   59: invokeinterface 206 1 0
    //   64: checkcast 158	java/lang/String
    //   67: astore 10
    //   69: aload_2
    //   70: aload 10
    //   72: invokevirtual 166	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   75: checkcast 168	java/lang/Integer
    //   78: invokevirtual 171	java/lang/Integer:intValue	()I
    //   81: istore_3
    //   82: aload 6
    //   84: ldc_w 384
    //   87: iconst_0
    //   88: ldc_w 710
    //   91: iconst_2
    //   92: anewarray 158	java/lang/String
    //   95: dup
    //   96: iconst_0
    //   97: aload_1
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: aload 10
    //   103: aastore
    //   104: aconst_null
    //   105: aconst_null
    //   106: aconst_null
    //   107: aconst_null
    //   108: invokevirtual 516	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   111: astore 11
    //   113: aconst_null
    //   114: astore 5
    //   116: aload 5
    //   118: astore 4
    //   120: aload 11
    //   122: ifnull +30 -> 152
    //   125: aload 5
    //   127: astore 4
    //   129: aload 11
    //   131: invokeinterface 148 1 0
    //   136: ifle +16 -> 152
    //   139: aload 11
    //   141: iconst_0
    //   142: invokeinterface 151 2 0
    //   147: checkcast 384	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   150: astore 4
    //   152: aload 4
    //   154: ifnonnull +58 -> 212
    //   157: new 384	com/tencent/mobileqq/data/troop/TroopMemberInfo
    //   160: dup
    //   161: invokespecial 711	com/tencent/mobileqq/data/troop/TroopMemberInfo:<init>	()V
    //   164: astore 4
    //   166: aload 4
    //   168: aload_1
    //   169: putfield 714	com/tencent/mobileqq/data/troop/TroopMemberInfo:troopuin	Ljava/lang/String;
    //   172: aload 4
    //   174: aload 10
    //   176: putfield 387	com/tencent/mobileqq/data/troop/TroopMemberInfo:memberuin	Ljava/lang/String;
    //   179: aload 4
    //   181: iload_3
    //   182: putfield 413	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   185: aload 6
    //   187: aload 4
    //   189: invokevirtual 718	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   192: aload 8
    //   194: ldc_w 720
    //   197: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 8
    //   203: aload 10
    //   205: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: goto +141 -> 350
    //   212: aload 4
    //   214: iload_3
    //   215: putfield 413	com/tencent/mobileqq/data/troop/TroopMemberInfo:commonFrdCnt	I
    //   218: aload 6
    //   220: aload 4
    //   222: invokevirtual 724	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   225: pop
    //   226: goto +124 -> 350
    //   229: aload 7
    //   231: invokevirtual 727	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   234: ldc_w 275
    //   237: iconst_1
    //   238: iconst_4
    //   239: anewarray 4	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: ldc_w 729
    //   247: aastore
    //   248: dup
    //   249: iconst_1
    //   250: aload_1
    //   251: aastore
    //   252: dup
    //   253: iconst_2
    //   254: ldc_w 731
    //   257: aastore
    //   258: dup
    //   259: iconst_3
    //   260: aload 8
    //   262: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: aastore
    //   266: invokestatic 401	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   269: goto +52 -> 321
    //   272: astore_1
    //   273: goto +59 -> 332
    //   276: astore_2
    //   277: invokestatic 271	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +41 -> 321
    //   283: new 94	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   290: astore 4
    //   292: aload 4
    //   294: ldc_w 733
    //   297: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 4
    //   303: aload_1
    //   304: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: ldc_w 275
    //   311: iconst_2
    //   312: aload 4
    //   314: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: aload_2
    //   318: invokestatic 736	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   321: aload 6
    //   323: invokevirtual 519	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   326: aload 7
    //   328: invokevirtual 739	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   331: return
    //   332: aload 6
    //   334: invokevirtual 519	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   337: aload 7
    //   339: invokevirtual 739	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   342: goto +5 -> 347
    //   345: aload_1
    //   346: athrow
    //   347: goto -2 -> 345
    //   350: goto -303 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	TroopBatchAddFriendMgr
    //   0	353	1	paramString	String
    //   0	353	2	paramHashMap	HashMap<String, Integer>
    //   81	134	3	i	int
    //   118	195	4	localObject1	Object
    //   114	12	5	localObject2	Object
    //   10	323	6	localEntityManager	EntityManager
    //   17	321	7	localEntityTransaction	EntityTransaction
    //   34	227	8	localStringBuilder	StringBuilder
    //   45	13	9	localIterator	Iterator
    //   67	137	10	str	String
    //   111	29	11	localList	List
    // Exception table:
    //   from	to	target	type
    //   36	47	272	finally
    //   47	113	272	finally
    //   129	152	272	finally
    //   157	209	272	finally
    //   212	226	272	finally
    //   229	269	272	finally
    //   277	321	272	finally
    //   36	47	276	java/lang/Exception
    //   47	113	276	java/lang/Exception
    //   129	152	276	java/lang/Exception
    //   157	209	276	java/lang/Exception
    //   212	226	276	java/lang/Exception
    //   229	269	276	java/lang/Exception
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap, List<String> paramList)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    localEntityTransaction.begin();
    StringBuilder localStringBuilder = new StringBuilder(1024);
    try
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject1 = (String)paramHashMap.get(str);
          paramList = (List<String>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
          List localList = localEntityManager.query(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { paramString, str }, null, null, null, null);
          Object localObject2 = null;
          localObject1 = localObject2;
          if (localList != null)
          {
            localObject1 = localObject2;
            if (localList.size() > 0) {
              localObject1 = (TroopMemberInfo)localList.get(0);
            }
          }
          if (localObject1 == null)
          {
            localObject1 = new TroopMemberInfo();
            ((TroopMemberInfo)localObject1).troopuin = paramString;
            ((TroopMemberInfo)localObject1).memberuin = str;
            ((TroopMemberInfo)localObject1).recommendRemark = paramList;
            localEntityManager.persist((Entity)localObject1);
            localStringBuilder.append("|");
            localStringBuilder.append(str);
          }
          else if (!TextUtils.equals(paramList, ((TroopMemberInfo)localObject1).recommendRemark))
          {
            ((TroopMemberInfo)localObject1).recommendRemark = paramList;
            localEntityManager.update((Entity)localObject1);
          }
        }
        localEntityTransaction.commit();
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, new Object[] { "updateDBMemberRemark troopUin=", paramString, " frdNotInDb=", localStringBuilder.toString() });
      }
      finally
      {
        localEntityManager.close();
        localEntityTransaction.end();
      }
    }
    catch (Exception paramString)
    {
      label303:
      break label303;
    }
    localEntityManager.close();
    localEntityTransaction.end();
  }
  
  public void a(String paramString, List<String> paramList, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = null;
    if (paramList == null) {
      localObject = "null";
    } else {
      try
      {
        String str = XorCipher.a(Arrays.toString(paramList.toArray()));
        localObject = str;
      }
      catch (XorCipherException localXorCipherException)
      {
        localXorCipherException.printStackTrace();
      }
    }
    int i = 0;
    QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, String.format("onTriggerBatchAddTip troopUin_type=%s_%d [%s]", new Object[] { paramString, Integer.valueOf(paramInt), localObject }));
    if (a(paramString) != null) {
      return;
    }
    if (!Scene.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt)) {
      return;
    }
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Scene localScene = a(paramString);
      localObject = localScene;
      if (localScene == null)
      {
        localObject = new Scene(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt, this, paramList);
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
        i = 1;
      }
      if (i != 0) {
        ((Scene)localObject).a();
      }
      return;
    }
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markAtOrReplyMeMsgInTroop Multi");
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      if (!b("atMeOrReplyMe")) {
        return;
      }
      HashMap localHashMap = new HashMap();
      int i = 0;
      Object localObject;
      String str;
      while (i < paramArrayList.size())
      {
        localObject = (MessageRecord)paramArrayList.get(i);
        if (((MessageRecord)localObject).mMessageInfo != null)
        {
          str = ((MessageRecord)localObject).frienduin;
          localObject = new TroopBatchAddFriendMgr.FlagMsgInfo(this, ((MessageRecord)localObject).senderuin, ((MessageRecord)localObject).mMessageInfo.a(), ((MessageRecord)localObject).time, ((MessageRecord)localObject).msgseq);
          if (localHashMap.containsKey(str)) {
            ((ArrayList)localHashMap.get(str)).add(localObject);
          } else {
            localHashMap.put(str, new ArrayList());
          }
        }
        i += 1;
      }
      if (localHashMap.keySet().size() > 0)
      {
        paramArrayList = localHashMap.keySet().iterator();
        while (paramArrayList.hasNext())
        {
          str = (String)paramArrayList.next();
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (str.equals(this.jdField_a_of_type_JavaLangString)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markAtOrReplyMeMsgInTroop unhandled when key aio opened");
            return;
          }
          localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(str);
          if (localObject == null) {
            return;
          }
          localObject = b(((TroopInfo)localObject).mAtOrReplyMeUins);
          ArrayList localArrayList = (ArrayList)localHashMap.get(str);
          i = 0;
          while (i < localArrayList.size())
          {
            TroopBatchAddFriendMgr.FlagMsgInfo localFlagMsgInfo = (TroopBatchAddFriendMgr.FlagMsgInfo)localArrayList.get(i);
            if (e(localFlagMsgInfo.jdField_a_of_type_JavaLangString)) {
              a((ArrayList)localObject, localFlagMsgInfo);
            }
            i += 1;
          }
          a((ArrayList)localObject, str);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markMultiAtOrReplyMeMsgInTroop no handled");
      }
    }
  }
  
  public boolean a(String paramString)
  {
    Object localObject1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("troop_gt_af_daily_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    boolean bool = false;
    int i = ((MobileQQ)localObject2).getSharedPreferences((String)localObject1, 0).getInt(d(paramString), 0);
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    if (i < paramString.m) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("shouldCheckNewMember config.nm_newMemberIndex = ");
      ((StringBuilder)localObject1).append(paramString.m);
      ((StringBuilder)localObject1).append(",value = ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(",result = ");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject1).toString());
    }
    return bool;
  }
  
  public int b(String paramString)
  {
    Object localObject1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("troop_gt_af_daily_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    int i = 0;
    if (((MobileQQ)localObject2).getSharedPreferences((String)localObject1, 0).contains(a(paramString)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("canBeRecommendedOrNot has recommended today ,uin = ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject1).toString());
      }
      i = -1;
    }
    int j = i;
    if (i >= 0) {
      j = a(paramString);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("canBeRecommendedOrNot uin = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",result = ");
      ((StringBuilder)localObject1).append(j);
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject1).toString());
    }
    return j;
  }
  
  String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("daily_troop_tips_count_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public ArrayList<TroopBatchAddFriendMgr.FlagMsgInfo> b(String paramString)
  {
    localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("list");
      int i = 0;
      Object localObject;
      while (i < paramString.length())
      {
        localObject = (JSONObject)paramString.get(i);
        if (localObject != null)
        {
          String str = ((JSONObject)localObject).optString("mem");
          int j = ((JSONObject)localObject).optInt("type");
          long l1 = ((JSONObject)localObject).optLong("time");
          long l2 = ((JSONObject)localObject).optLong("seq");
          if (str != null) {
            localArrayList.add(new TroopBatchAddFriendMgr.FlagMsgInfo(this, str, j, l1, l2));
          } else {
            QLog.e("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "memberUin is null ");
          }
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FlagMsgInfoFromJson ");
      ((StringBuilder)localObject).append(paramString.toString());
      QLog.e("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b(Scene paramScene)
  {
    if (paramScene != null)
    {
      if (TextUtils.isEmpty(paramScene.c)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onFailed troopUin_type_ts=%s_%d_%d", new Object[] { paramScene.c, Integer.valueOf(paramScene.jdField_a_of_type_Int), Long.valueOf(paramScene.jdField_a_of_type_Long) }));
      }
      if (paramScene.jdField_a_of_type_Int == 2) {
        ((ITroopRedDotHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(paramScene.c, 101509131);
      }
      a(paramScene.c);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, "markDailyTroopNewMemberGrayTipShownCount ");
    }
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).b(paramString);
    if (localTroopInfo == null) {
      return;
    }
    Object localObject2 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troop_gt_af_daily_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append((String)localObject2);
    localObject2 = localStringBuilder.toString();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences((String)localObject2, 0);
    paramString = d(paramString);
    int i = ((SharedPreferences)localObject2).getInt(paramString, 0) + 1;
    ((SharedPreferences)localObject2).edit().putInt(paramString, i).apply();
    ((TroopManager)localObject1).b(localTroopInfo);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("markDailyTroopNewMemberGrayTipShownCount key = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",value = ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(",dailyNewMemberUins = ");
      ((StringBuilder)localObject1).append(localTroopInfo.dailyNewMemberUins);
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    String str1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troop_gt_af_daily_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(str1);
    str1 = ((StringBuilder)localObject).toString();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(str1, 0);
    str1 = a(paramString1);
    int i = ((SharedPreferences)localObject).getInt(str1, 0) + 1;
    ((SharedPreferences)localObject).edit().putInt(str1, i).apply();
    String str2 = b(paramString2);
    int j = ((SharedPreferences)localObject).getInt(str2, 0);
    ((SharedPreferences)localObject).edit().putInt(str2, j + 1).apply();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("troop_gt_af_total_");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject = ((StringBuilder)localObject).toString();
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences((String)localObject, 0);
    str2 = c(paramString1);
    j = ((SharedPreferences)localObject).getInt(str2, 0);
    ((SharedPreferences)localObject).edit().putInt(str2, j + 1).apply();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("markHasShownTipDaily key = ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(",value = ");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",uin = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",troopCode = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean b(String paramString)
  {
    return TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
  }
  
  String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("total_rec_uin_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void c(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      Scene localScene = a(paramString);
      if (QLog.isColorLevel())
      {
        bool = false;
        if (localScene != null) {
          bool = true;
        }
        QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("insertTip aio %s scene valid:%b", new Object[] { paramString, Boolean.valueOf(bool) }));
      }
      if (localScene != null)
      {
        localScene.f();
        a(paramString);
        if (localScene.jdField_a_of_type_Int == 2) {
          ((ITroopRedDotHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(localScene.c, 101509131);
        }
      }
      return;
    }
    finally {}
  }
  
  public void c(String paramString1, String paramString2)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.b(paramString1);
    if (localTroopInfo == null) {
      return;
    }
    QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, new Object[] { "markNewMemberIndexAndUinDaily [", paramString1, ",", paramString2, "]" });
    Object localObject1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("troop_gt_af_daily_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences((String)localObject2, 0);
    StringBuilder localStringBuilder = new StringBuilder("troopNewMember_");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    int i = ((SharedPreferences)localObject2).getInt(paramString1, 0) + 1;
    ((SharedPreferences)localObject2).edit().putInt(paramString1, i).apply();
    if (TextUtils.isEmpty(localTroopInfo.dailyNewMemberUins))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(paramString2);
      localTroopInfo.dailyNewMemberUins = ((StringBuilder)localObject2).toString();
    }
    else if (localTroopInfo.dailyNewMemberUins.startsWith((String)localObject1))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(localTroopInfo.dailyNewMemberUins);
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramString2);
      localTroopInfo.dailyNewMemberUins = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(paramString2);
      localTroopInfo.dailyNewMemberUins = ((StringBuilder)localObject2).toString();
    }
    localTroopManager.b(localTroopInfo);
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("mark dailyNewMember key = ");
      paramString2.append(paramString1);
      paramString2.append(",value = ");
      paramString2.append(i);
      paramString2.append(",dailyNewMemberUins = ");
      paramString2.append(localTroopInfo.dailyNewMemberUins);
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, paramString2.toString());
    }
  }
  
  public boolean c(String paramString)
  {
    Object localObject1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("troop_gt_af_daily_");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    boolean bool = false;
    int i = ((MobileQQ)localObject2).getSharedPreferences((String)localObject1, 0).getInt(b(paramString), 0);
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a();
    if (i < paramString.e) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("canShowTipsOrNot config.tipsTotalCountForTroopEveryday = ");
      ((StringBuilder)localObject1).append(paramString.e);
      ((StringBuilder)localObject1).append(",value = ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(",result = ");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject1).toString());
    }
    return bool;
  }
  
  String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("daily_troop_new_member_tips_count_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, String.format("onActivePush troopUin=%s", new Object[] { paramString }));
    }
    ThreadManager.executeOnSubThread(new TroopBatchAddFriendMgr.4(this, paramString), true);
  }
  
  public void d(String paramString1, String paramString2)
  {
    Object localObject3 = jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject1).b(paramString1);
    if ((localTroopInfo != null) && (!TextUtils.isEmpty(localTroopInfo.dailyNewMemberUins)) && (localTroopInfo.dailyNewMemberUins.startsWith((String)localObject3)))
    {
      Object localObject4 = localTroopInfo.dailyNewMemberUins.split("\\|");
      Object localObject2 = new ArrayList();
      int i = 1;
      while (i < localObject4.length)
      {
        if (!localObject4[i].equals(paramString2)) {
          ((ArrayList)localObject2).add(localObject4[i]);
        }
        i += 1;
      }
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject3 = new StringBuilder((String)localObject3);
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          ((StringBuilder)localObject3).append("|");
          ((StringBuilder)localObject3).append((String)localObject4);
        }
        localTroopInfo.dailyNewMemberUins = ((StringBuilder)localObject3).toString();
      }
      else
      {
        localTroopInfo.dailyNewMemberUins = "";
      }
      ((TroopManager)localObject1).b(localTroopInfo);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("remove dailyNewMember  troopUin = ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(",newMemberUin = ");
        ((StringBuilder)localObject1).append(paramString2);
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public boolean d(String paramString)
  {
    synchronized (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      boolean bool;
      if ((Scene)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString) == null)
      {
        bool = false;
      }
      else
      {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        bool = true;
      }
      ??? = new StringBuilder();
      ((StringBuilder)???).append("clearTroopScence ");
      ((StringBuilder)???).append(bool);
      ((StringBuilder)???).append(" ");
      ((StringBuilder)???).append(paramString);
      QLog.i("troopBatchAddFrd.TroopBatchAddFriendMgr", 1, ((StringBuilder)???).toString());
      return bool;
    }
  }
  
  public void e(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = ((TroopManager)localObject1).b(paramString);
    if ((localObject2 != null) && (!TextUtils.isEmpty(((TroopInfo)localObject2).mAtOrReplyMeUins)))
    {
      ArrayList localArrayList2 = b(((TroopInfo)localObject2).mAtOrReplyMeUins);
      ((TroopInfo)localObject2).mAtOrReplyMeUins = "";
      ((TroopManager)localObject1).c((TroopInfo)localObject2);
      if ((localArrayList2 != null) && (localArrayList2.size() > 0))
      {
        long l = System.currentTimeMillis() / 1000L;
        int i = 0;
        while (i < localArrayList2.size())
        {
          localObject2 = (TroopBatchAddFriendMgr.FlagMsgInfo)localArrayList2.get(i);
          if ((l - ((TroopBatchAddFriendMgr.FlagMsgInfo)localObject2).jdField_a_of_type_Long < (((TroopManager)localObject1).a().a * 24.0D * 3600.0D)) && (!TextUtils.isEmpty(((TroopBatchAddFriendMgr.FlagMsgInfo)localObject2).jdField_a_of_type_JavaLangString)))
          {
            int j = 0;
            while (j < localArrayList1.size())
            {
              String str = (String)localArrayList1.get(j);
              if ((!TextUtils.isEmpty(str)) && (((TroopBatchAddFriendMgr.FlagMsgInfo)localObject2).jdField_a_of_type_JavaLangString.equals(str)))
              {
                j = 1;
                break label214;
              }
              j += 1;
            }
            j = 0;
            label214:
            if (j == 0) {
              localArrayList1.add(((TroopBatchAddFriendMgr.FlagMsgInfo)localObject2).jdField_a_of_type_JavaLangString);
            }
          }
          i += 1;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkTriggerTipsAndCleanAtOrReplyMsg visibleUins size = ");
        ((StringBuilder)localObject1).append(localArrayList1.size());
        ((StringBuilder)localObject1).append(",visibleUins = ");
        ((StringBuilder)localObject1).append(localArrayList1);
        QLog.d("troopBatchAddFrd.TroopBatchAddFriendMgr", 2, ((StringBuilder)localObject1).toString());
      }
      if (localArrayList1.size() > 0) {
        a(paramString, localArrayList1, 5);
      }
    }
  }
  
  public boolean e(String paramString)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void f(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr
 * JD-Core Version:    0.7.0.1
 */