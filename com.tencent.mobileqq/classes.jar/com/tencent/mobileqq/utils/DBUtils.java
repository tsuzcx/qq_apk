package com.tencent.mobileqq.utils;

import GeneralSettings.Setting;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RoamSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardConfig;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.stTroopRemarkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DBUtils
{
  DBUtils.LimitQueuedRunnablePool a = new DBUtils.LimitQueuedRunnablePool(10, 32);
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    int i = Build.VERSION.SDK_INT;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0) {
      return localBaseApplication.getSharedPreferences("troop_news_notify", i).getInt(paramString1 + paramString2 + paramString3, 0);
    }
  }
  
  public static DBUtils a()
  {
    return DBUtils.DBUtilsHolder.a;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DBUtils", 2, "setTroopLuckyCharacterStatus troopUin = " + paramString2 + ", wording = " + paramString3);
    }
    long l = System.currentTimeMillis();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    localEditor.putLong(paramString1 + "troop_lucky_character_status" + paramString2 + "time", l);
    localEditor.putString(paramString1 + "troop_lucky_character_status" + paramString2 + "wording", paramString3);
    localEditor.apply();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject = BaseApplication.getContext();
    if (i > 10) {}
    for (i = 4;; i = 0)
    {
      localObject = ((BaseApplication)localObject).getSharedPreferences("troop_news_notify", i).edit();
      ((SharedPreferences.Editor)localObject).putInt(paramString1 + paramString2 + paramString3, paramInt);
      ((SharedPreferences.Editor)localObject).commit();
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    if (paramBoolean)
    {
      localEditor.putBoolean(paramString1 + "group_file_inner_reddot_tim" + paramString3, true);
      localEditor.putBoolean(paramString1 + "group_file_reddot_tim" + paramString3, true);
    }
    for (;;)
    {
      localEditor.putBoolean(paramString1 + paramString2 + paramString3, paramBoolean);
      localEditor.commit();
      return;
      localEditor.putBoolean(paramString1 + "group_file_inner_reddot_tim" + paramString3, false);
      localEditor.putBoolean(paramString1 + "group_file_reddot_tim" + paramString3, false);
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DBUtils", 2, "setTroopGameCardRedPoint troopUin = " + paramString2 + ", isShowRedPoint = " + paramBoolean);
    }
    BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit().putBoolean(paramString1 + "troop_game_card_red_point" + paramString2, paramBoolean).commit();
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = BaseApplication.getContext().getSharedPreferences(paramString1, 0).getBoolean(paramString1 + "troop_game_card_red_point_has_showed" + paramString2, false);
    if (QLog.isColorLevel()) {
      QLog.d("DBUtils", 2, "hasShowTroopGameCardRedPoint troopUin = " + paramString2 + ", isShow = " + bool);
    }
    return bool;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return BaseApplication.getContext().getSharedPreferences(paramString1, 0).getBoolean(paramString1 + paramString2 + paramString3, paramBoolean);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      paramBoolean = false;
    }
    boolean bool;
    do
    {
      return paramBoolean;
      if (StudyModeManager.a()) {
        return false;
      }
      Object localObject = (TroopGameCardConfig)QConfigManager.a().a(695);
      if ((localObject == null) || (!((TroopGameCardConfig)localObject).a(paramString2))) {
        return false;
      }
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject == null) {
        return false;
      }
      localObject = ((TroopManager)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString2);
      if (localObject == null) {
        return false;
      }
      if (((TroopInfo)localObject).isHomeworkTroop()) {
        return false;
      }
      if (!((TroopInfo)localObject).isTroopGameCardEnabled()) {
        return false;
      }
      localObject = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
      if (a(paramString1, paramString2)) {
        return false;
      }
      bool = ((SharedPreferences)localObject).getBoolean(paramString1 + "troop_game_card_red_point" + paramString2, paramBoolean);
      paramBoolean = bool;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "isShowTroopGameCardRedPoint troopUin = " + paramString2 + ", isShow = " + bool);
    return bool;
  }
  
  public static Object[] a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramString1, 0);
    long l = localSharedPreferences.getLong(paramString1 + "troop_lucky_character_status" + paramString2 + "time", 0L);
    paramString1 = localSharedPreferences.getString(paramString1 + "troop_lucky_character_status" + paramString2 + "wording", paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("DBUtils", 2, "getKeyTroopLuckyCharacterStatus troopUin = " + paramString2 + ", lastFetchTime = " + l + ",wording" + paramString1);
    }
    return new Object[] { Long.valueOf(l), paramString1 };
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit();
    localEditor.putBoolean(paramString1 + paramString2 + paramString3, paramBoolean);
    localEditor.commit();
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DBUtils", 2, "setTroopGameCardRedPointHasShowed troopUin = " + paramString2 + ", isShowRedPoint = " + paramBoolean);
    }
    BaseApplication.getContext().getSharedPreferences(paramString1, 0).edit().putBoolean(paramString1 + "troop_game_card_red_point_has_showed" + paramString2, paramBoolean).commit();
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString, 0).edit();
    localEditor.putBoolean(paramString + "troop_lucky_character_red_point", paramBoolean);
    localEditor.apply();
  }
  
  public static boolean b(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      return bool1;
      bool2 = BaseApplication.getContext().getSharedPreferences(paramString, 0).getBoolean(paramString + "troop_lucky_character_red_point", true);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "isShowTroopLuckyCharacterRedPoint isShow = " + bool2);
    return bool2;
  }
  
  public static void c(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences(paramString, 0).edit();
    localEditor.putBoolean(paramString + "troop_lucky_character_red_point_aio", paramBoolean);
    localEditor.apply();
  }
  
  public static boolean c(String paramString)
  {
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool2;
    do
    {
      return bool1;
      bool2 = BaseApplication.getContext().getSharedPreferences(paramString, 0).getBoolean(paramString + "troop_lucky_character_red_point_aio", true);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "isShowLuckyCharacterRedPointInAIOSetting isShow = " + bool2);
    return bool2;
  }
  
  public int a(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("subaccount_sp", 0).getInt("subaccount_sp_version", 0);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountVersion() ver=" + i);
    }
    return i;
  }
  
  public int a(String paramString)
  {
    int j = 0;
    int i = j;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label19;
      }
      i = j;
    }
    label19:
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return i;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
        i = j;
      } while (localSharedPreferences == null);
      paramString = "stick2top_" + paramString;
      j = localSharedPreferences.getInt(paramString, 0);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, paramString + ":" + j);
    return j;
  }
  
  public Map<String, Integer> a(List<String> paramList, int paramInt, QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    if ((paramList == null) || (paramList.size() == 0)) {
      return localHashMap;
    }
    if (paramQQAppInterface == null) {
      return localHashMap;
    }
    RoamSettingManager localRoamSettingManager;
    ArrayList localArrayList;
    for (;;)
    {
      String str1;
      try
      {
        localRoamSettingManager = (RoamSettingManager)paramQQAppInterface.getManager(QQManagerFactory.ROAM_SETTING_MANAGER);
        localArrayList = new ArrayList();
        int i = 0;
        if (i >= paramList.size()) {
          break;
        }
        str1 = (String)paramList.get(i);
        if ((str1 == null) || (str1.length() == 0))
        {
          i += 1;
          continue;
        }
        paramQQAppInterface = new StringBuilder(40);
      }
      catch (ClassCastException paramList)
      {
        paramList.printStackTrace();
        return localHashMap;
      }
      paramQQAppInterface.append("message.group.policy.");
      paramQQAppInterface.append(str1);
      String str2 = paramQQAppInterface.toString();
      RoamSetting localRoamSetting = localRoamSettingManager.a(str2);
      paramQQAppInterface = localRoamSetting;
      if (localRoamSetting == null)
      {
        paramQQAppInterface = localRoamSetting;
        if (!TextUtils.isEmpty(str2))
        {
          paramQQAppInterface = new RoamSetting(str2, Integer.toString(paramInt));
          localArrayList.add(paramQQAppInterface);
        }
      }
      localHashMap.put(str1, Integer.valueOf(RoamSetting.getIntValue(paramQQAppInterface, paramInt)));
    }
    if (localArrayList.size() > 0) {
      this.a.a(new DBUtils.1(this, localArrayList, localRoamSettingManager));
    }
    return localHashMap;
  }
  
  public void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "saveGeneralSettingRevision=" + paramInt);
    }
    ((RoamSettingManager)paramQQAppInterface.getManager(QQManagerFactory.ROAM_SETTING_MANAGER)).a(paramInt);
  }
  
  public void a(Context paramContext)
  {
    int i = ApkUtils.a(paramContext);
    paramContext.getSharedPreferences("subaccount_sp", 0).edit().putInt("subaccount_sp_version", i).commit();
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setSubAccountVersion() ver=" + i);
    }
  }
  
  public void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramString = paramString + "subaccount_show_in_recentlist_first";
    paramContext.getSharedPreferences("subaccount_sp", 0).edit().putBoolean(paramString, paramBoolean).commit();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Context paramContext)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    while (paramString2 == null) {
      return;
    }
    paramString2 = paramContext.getSharedPreferences(paramString2, 0).edit();
    paramString1 = "message.group.policy." + paramString1;
    paramString2.remove(paramString1);
    paramString2.commit();
    ((RoamSettingManager)paramQQAppInterface.getManager(QQManagerFactory.ROAM_SETTING_MANAGER)).a(paramString1);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      SharedPreferences localSharedPreferences;
      do
      {
        return;
        localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
      } while (localSharedPreferences == null);
      paramString = "stick2top_" + paramString;
      paramInt += 1;
      localSharedPreferences.edit().putInt(paramString, paramInt).commit();
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "set " + paramString + "=" + paramInt);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localSharedPreferences == null) {}
    do
    {
      return;
      paramString = paramString + "bindQQAgain";
      localSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("DBUtils", 2, "setShownAgainBindDialog() " + paramString + ":" + paramBoolean);
  }
  
  public void a(ArrayList<Setting> paramArrayList, QQAppInterface paramQQAppInterface)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    long l = 0L;
    if (QLog.isColorLevel())
    {
      l = System.currentTimeMillis();
      QLog.d("RoamSetting", 2, "saveGeneralSettings setting start size = " + paramArrayList.size());
    }
    RoamSettingManager localRoamSettingManager = (RoamSettingManager)paramQQAppInterface.getManager(QQManagerFactory.ROAM_SETTING_MANAGER);
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    String str;
    label175:
    int j;
    for (;;)
    {
      if (i < paramArrayList.size())
      {
        paramQQAppInterface = (Setting)paramArrayList.get(i);
        str = paramQQAppInterface.Path;
        paramQQAppInterface = paramQQAppInterface.Value;
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "saveGeneralSettings path =" + str + "; value = " + paramQQAppInterface);
        }
        if (str == null)
        {
          paramQQAppInterface = (QQAppInterface)localObject;
          i += 1;
          localObject = paramQQAppInterface;
        }
        else
        {
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length() != 0) && (!paramQQAppInterface.equalsIgnoreCase(""))) {
            break label523;
          }
          j = RoamSettingController.a(str);
          if (j == 1) {
            paramQQAppInterface = String.valueOf(1);
          }
        }
      }
    }
    label523:
    for (;;)
    {
      label224:
      RoamSetting localRoamSetting = localRoamSettingManager.a(str, paramQQAppInterface);
      if (localRoamSetting != null) {
        localArrayList.add(localRoamSetting);
      }
      if (("message.ring.switch".equals(str)) || ("message.vibrate.switch".equals(str)) || ("message.ring.care".equals(str)))
      {
        if (localObject == null) {
          localObject = localSharedPreferences.edit();
        }
        for (;;)
        {
          for (;;)
          {
            try
            {
              ((SharedPreferences.Editor)localObject).putString(str, paramQQAppInterface);
              paramQQAppInterface = (QQAppInterface)localObject;
            }
            catch (Exception paramQQAppInterface)
            {
              paramQQAppInterface.printStackTrace();
              paramQQAppInterface = (QQAppInterface)localObject;
            }
            break label175;
            if (j == 2)
            {
              paramQQAppInterface = String.valueOf(0);
              break label224;
            }
            if (j == 3)
            {
              paramQQAppInterface = String.valueOf(0);
              break label224;
            }
            if (j == 4)
            {
              paramQQAppInterface = "";
              break label224;
            }
            if (j == 5)
            {
              paramQQAppInterface = "";
              break label224;
            }
            if (j == 6)
            {
              paramQQAppInterface = String.valueOf(1);
              break label224;
            }
            if (j == 7)
            {
              paramQQAppInterface = String.valueOf(0);
              break label224;
            }
            paramQQAppInterface = "0";
            break label224;
            if (Looper.getMainLooper().getThread() == Thread.currentThread())
            {
              ThreadManager.post(new DBUtils.2(this, localRoamSettingManager, localArrayList), 5, null, false);
              if (localObject == null) {}
            }
            try
            {
              ((SharedPreferences.Editor)localObject).commit();
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("DBUtils", 2, "GeneralSettings zsw saveGeneralSettings setting end, consume time =" + (System.currentTimeMillis() - l));
              return;
              localRoamSettingManager.a(localArrayList);
            }
            catch (Exception paramArrayList)
            {
              for (;;)
              {
                paramArrayList.printStackTrace();
              }
            }
          }
        }
      }
      paramQQAppInterface = (QQAppInterface)localObject;
      break label175;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().putBoolean("hasShowBindDialog", paramBoolean).commit();
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setHasShowBindDialog:" + paramBoolean);
  }
  
  public boolean a()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    boolean bool1;
    if (localSharedPreferences == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = localSharedPreferences.getBoolean("hasShowBindDialog", false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "hasShowBindDialog:" + bool2);
    return bool2;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramString == null) {}
    do
    {
      return bool2;
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences(paramString, 0);
      paramContext = paramContext.getSharedPreferences("subaccount_sp", 0);
      paramString = paramString + "subaccount_show_in_recentlist_first";
      if (localSharedPreferences.getBoolean(paramString, false))
      {
        localSharedPreferences.edit().remove(paramString).commit();
        paramContext.edit().putBoolean(paramString, true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() update showedBefore:=true");
        }
      }
      if (localSharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false))
      {
        bool2 = localSharedPreferences.getBoolean("subaccount_is_top_in_recentlist", false);
        localSharedPreferences.edit().remove("subaccount_is_top_in_recentlist").commit();
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() remove isTopRU=" + bool2);
          bool1 = bool2;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "subAccountOldVersionUpdate() isTop=" + bool1);
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    if (((paramString == null) || (paramString.length() < 5)) && (QLog.isColorLevel())) {
      QLog.d("SUB_ACCOUNT", 2, "shownBindQQAgain() return.FALSE: mainUin=" + paramString);
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("subaccount_sp", 0);
    boolean bool1;
    if (localSharedPreferences == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      paramString = paramString + "bindQQAgain";
      bool2 = localSharedPreferences.getBoolean(paramString, false);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "shownBindQQAgain() " + paramString + ":" + bool2);
    return bool2;
  }
  
  public Object[] a(QQAppInterface paramQQAppInterface, String paramString, ArrayList<stTroopRemarkInfo> paramArrayList)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = null;
    arrayOfObject[1] = Boolean.valueOf(false);
    if (paramArrayList == null) {
      return arrayOfObject;
    }
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
    localEntityTransaction.begin();
    ArrayList localArrayList = new ArrayList();
    arrayOfObject[0] = localArrayList;
    int i = 0;
    label721:
    for (;;)
    {
      try
      {
        if (i < paramArrayList.size())
        {
          stTroopRemarkInfo localstTroopRemarkInfo = (stTroopRemarkInfo)paramArrayList.get(i);
          Object localObject = (TroopMemberCardInfo)localEntityManager.find(TroopMemberCardInfo.class, new String[] { paramString, String.valueOf(localstTroopRemarkInfo.MemberUin) });
          int j;
          if (localObject != null)
          {
            j = 1;
            ((TroopMemberCardInfo)localObject).email = localstTroopRemarkInfo.sEmail;
            ((TroopMemberCardInfo)localObject).memberuin = String.valueOf(localstTroopRemarkInfo.MemberUin);
            ((TroopMemberCardInfo)localObject).memo = localstTroopRemarkInfo.sMemo;
            ((TroopMemberCardInfo)localObject).colorNick = ColorNickManager.b(localstTroopRemarkInfo.sName.getBytes());
            if (((TroopMemberCardInfo)localObject).colorNick == null) {
              ((TroopMemberCardInfo)localObject).colorNick = localstTroopRemarkInfo.sName;
            }
            ((TroopMemberCardInfo)localObject).name = ColorNickManager.b(((TroopMemberCardInfo)localObject).colorNick);
            ((TroopMemberCardInfo)localObject).nick = localstTroopRemarkInfo.strNick;
            ((TroopMemberCardInfo)localObject).sex = localstTroopRemarkInfo.cGender;
            ((TroopMemberCardInfo)localObject).tel = localstTroopRemarkInfo.sPhone;
            ((TroopMemberCardInfo)localObject).troopuin = paramString;
            ((TroopMemberCardInfo)localObject).level = localstTroopRemarkInfo.strRank;
            ((TroopMemberCardInfo)localObject).job = localstTroopRemarkInfo.bytes_job;
            ((TroopMemberCardInfo)localObject).charm = ((int)localstTroopRemarkInfo.GlamourLevel);
            ((TroopMemberCardInfo)localObject).torchFlag = ((int)localstTroopRemarkInfo.TorchbearerFlag);
            if (j != 0)
            {
              localEntityManager.update((Entity)localObject);
              localArrayList.add(localObject);
              j = TroopMemberLevelUtils.a(localstTroopRemarkInfo.vecGroupHonor);
              TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localEntityManager.find(TroopMemberInfo.class, new String[] { paramString, String.valueOf(localstTroopRemarkInfo.MemberUin) });
              if (localTroopMemberInfo == null) {
                break label721;
              }
              localTroopMemberInfo.troopColorNick = ((TroopMemberCardInfo)localObject).colorNick;
              localTroopMemberInfo.troopnick = ((TroopMemberCardInfo)localObject).name;
              localTroopMemberInfo.friendnick = localstTroopRemarkInfo.strNick;
              localTroopMemberInfo.memberuin = String.valueOf(localstTroopRemarkInfo.MemberUin);
              localTroopMemberInfo.sex = localstTroopRemarkInfo.cGender;
              localTroopMemberInfo.troopuin = paramString;
              localTroopMemberInfo.mGlamourLevel = ((int)localstTroopRemarkInfo.GlamourLevel);
              localTroopMemberInfo.mVipType = ((TroopMemberCardInfo)localObject).mVipType;
              localTroopMemberInfo.mVipLevel = ((TroopMemberCardInfo)localObject).mVipLevel;
              localTroopMemberInfo.newRealLevel = j;
              if ((localstTroopRemarkInfo.strRank != null) && (localstTroopRemarkInfo.strRank.length() > 0))
              {
                localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                if (localObject != null)
                {
                  localObject = ((TroopManager)localObject).b(paramString);
                  if (localObject != null)
                  {
                    localObject = ((TroopInfo)localObject).getTroopLevelMap();
                    if (localObject != null)
                    {
                      Iterator localIterator = ((ConcurrentHashMap)localObject).keySet().iterator();
                      if (localIterator.hasNext())
                      {
                        Integer localInteger = (Integer)localIterator.next();
                        if (!localstTroopRemarkInfo.strRank.equals(((ConcurrentHashMap)localObject).get(localInteger))) {
                          continue;
                        }
                        localTroopMemberInfo.realLevel = localInteger.intValue();
                      }
                    }
                  }
                }
              }
              localEntityManager.update(localTroopMemberInfo);
              break label721;
            }
          }
          else
          {
            localObject = new TroopMemberCardInfo();
            j = 0;
            continue;
          }
          localEntityManager.persist((Entity)localObject);
          continue;
        }
        i += 1;
      }
      catch (Exception paramQQAppInterface)
      {
        arrayOfObject[1] = Boolean.valueOf(false);
        if (QLog.isColorLevel()) {
          QLog.e("handlerGetTroopMemberCardInfoList()", 2, paramQQAppInterface.toString());
        }
        localEntityTransaction.end();
        localEntityManager.close();
        if (QLog.isColorLevel()) {
          QLog.d("handlerGetTroopMemberCardInfoList", 2, "insertTroopMemberCardList bRet = " + arrayOfObject[1]);
        }
        return arrayOfObject;
        arrayOfObject[1] = Boolean.valueOf(true);
        localEntityTransaction.commit();
        localEntityTransaction.end();
        localEntityManager.close();
      }
      finally
      {
        localEntityTransaction.end();
        localEntityManager.close();
      }
    }
  }
  
  public boolean b(Context paramContext, String paramString)
  {
    paramString = paramString + "subaccount_show_in_recentlist_first";
    return paramContext.getSharedPreferences("subaccount_sp", 0).getBoolean(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DBUtils
 * JD-Core Version:    0.7.0.1
 */