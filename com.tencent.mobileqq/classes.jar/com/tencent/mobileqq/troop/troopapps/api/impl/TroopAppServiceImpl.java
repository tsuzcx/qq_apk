package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService.AppConfig;
import com.tencent.mobileqq.troop.troopapps.data.TroopAIOAppInfoListItem;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.utils.AssertUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xa1e.oidb_0xa1e.AppClick;
import tencent.im.oidb.cmd0xa1e.oidb_0xa1e.ReqBody;

public class TroopAppServiceImpl
  implements ITroopAppService
{
  protected static final int FLAG_APP_LIST_CHANGED_FROM_WEB_OPERATE = 2;
  protected static final int FLAG_CHECKED_UPDATE_AFTER_LOGINED = 1;
  private static final String TAG = ".troop.troop_app";
  protected static final String TROOP_APP_LIST_DATA = "troop_app_list_data";
  private AppRuntime app;
  protected boolean isProfileAppListChangedFromWebOperate = false;
  final Object lock = new Object();
  String mAllAppString;
  protected Map<String, JSONObject> mAppConfig = new ConcurrentHashMap();
  String mAppIdDate;
  @NonNull
  SparseArray<Integer> mAppIdNums = new SparseArray(10);
  protected SparseArray<TroopAIOAppInfoListItem> mAppListItems = new SparseArray();
  ThreadLocal<SimpleDateFormat> mDateFormat = new TroopAppServiceImpl.1(this);
  TroopAppHandler mTroopAppHandler;
  protected ConcurrentHashMap<String, ArrayList<Long>> mTroopCardAppIdListCache;
  protected String profileAppListChangedTroopUin;
  protected ConcurrentHashMap<Long, TroopAppInfo> troopAppInfoCache;
  
  private void initAppIdNums()
  {
    Object localObject = this.app.getPreferences().getString("appid_click_num", null);
    this.mAppIdNums.clear();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
        int j = localJSONObject.optInt("appId");
        int k = localJSONObject.optInt("num");
        this.mAppIdNums.put(j, Integer.valueOf(k));
        i += 1;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void initTroopAppInfoList()
  {
    if (AppSetting.b("6.0") < 0) {
      return;
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    synchronized (this.lock)
    {
      Object localObject3 = localEntityManager.query(TroopAIOAppInfo.class);
      Object localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new ArrayList();
      }
      localObject1 = ((List)localObject1).listIterator();
      while (((ListIterator)localObject1).hasNext())
      {
        localObject3 = (TroopAIOAppInfo)((ListIterator)localObject1).next();
        TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(((TroopAIOAppInfo)localObject3).groupType);
        AssertUtils.a(localTroopAIOAppInfoListItem);
        localTroopAIOAppInfoListItem.a(((TroopAIOAppInfo)localObject3).appid, (TroopAIOAppInfo)localObject3);
      }
      localEntityManager.close();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private boolean isAppInfoDayRequest(int paramInt)
  {
    TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramInt, null);
    boolean bool;
    if (localTroopAIOAppInfoListItem != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.a(bool);
    if (localTroopAIOAppInfoListItem == null) {
      return false;
    }
    Calendar localCalendar = Calendar.getInstance();
    return !((SimpleDateFormat)this.mDateFormat.get()).format(localCalendar.getTime()).equals(localTroopAIOAppInfoListItem.b);
  }
  
  private void loadAllAppConfigs()
  {
    ITroopAppService.AppConfig[] arrayOfAppConfig = ITroopAppService.AppConfig.b;
    int j = arrayOfAppConfig.length;
    int i = 0;
    while (i < j)
    {
      ITroopAppService.AppConfig localAppConfig = arrayOfAppConfig[i];
      Object localObject = this.app.getPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("KEY_APP_CONFIG_PREFIX-");
      localStringBuilder.append(localAppConfig.a);
      localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), null);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = localAppConfig.a((String)localObject);
        this.mAppConfig.put(localAppConfig.a, localObject);
      }
      i += 1;
    }
  }
  
  private void logTroopAIOAppInfoList(String paramString1, String paramString2, List<TroopAIOAppInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" end");
      QLog.d(paramString1, 2, localStringBuilder.toString());
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          QLog.d(paramString1, 2, ((TroopAIOAppInfo)paramList.next()).toString());
        }
      }
      QLog.d(paramString1, 2, "arg is null");
      paramList = new StringBuilder();
      paramList.append(paramString2);
      paramList.append(" end");
      QLog.d(paramString1, 2, paramList.toString());
    }
  }
  
  private void saveAppIdNums()
  {
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < this.mAppIdNums.size())
    {
      int j = this.mAppIdNums.keyAt(i);
      int k = ((Integer)this.mAppIdNums.get(j)).intValue();
      try
      {
        localObject = new JSONObject();
        ((JSONObject)localObject).put("appId", j);
        ((JSONObject)localObject).put("num", k);
        localJSONArray.put(localObject);
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        label84:
        break label84;
      }
      if (QLog.isColorLevel()) {
        QLog.e(".troop.troop_app", 2, "saveAppIdNums exception");
      }
      i += 1;
    }
    if (localJSONArray.length() != 0)
    {
      localObject = this.app;
      if (localObject != null) {
        ((AppRuntime)localObject).getPreferences().edit().putString("appid_click_num", localJSONArray.toString()).commit();
      }
    }
  }
  
  private void saveTroopAppInfosToDB(ArrayList<TroopAIOAppInfo> paramArrayList, int paramInt)
  {
    ThreadManager.post(new TroopAppServiceImpl.3(this, paramArrayList, this.app.getEntityManagerFactory().createEntityManager(), paramInt), 8, null, false);
  }
  
  private void setAppConfig(String paramString, JSONObject paramJSONObject)
  {
    AssertUtils.a(paramString);
    AssertUtils.a(paramJSONObject);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    if (paramJSONObject == null) {
      return;
    }
    this.mAppConfig.put(str, paramJSONObject);
    paramString = this.app.getPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KEY_APP_CONFIG_PREFIX-");
    localStringBuilder.append(str);
    paramString.putString(localStringBuilder.toString(), paramJSONObject.toString()).apply();
  }
  
  private void updateAppIdCalendarDay()
  {
    Calendar localCalendar = Calendar.getInstance();
    this.mAppIdDate = ((SimpleDateFormat)this.mDateFormat.get()).format(localCalendar.getTime());
    this.app.getPreferences().edit().putString("appid_click_date", this.mAppIdDate).commit();
  }
  
  private boolean updateEntity(EntityManager paramEntityManager, Entity paramEntity)
  {
    boolean bool2 = paramEntityManager.isOpen();
    boolean bool1 = false;
    if (bool2)
    {
      if (paramEntity.getStatus() == 1000)
      {
        paramEntityManager.persistOrReplace(paramEntity);
        if (paramEntity.getStatus() == 1001) {
          bool1 = true;
        }
        return bool1;
      }
      if ((paramEntity.getStatus() == 1001) || (paramEntity.getStatus() == 1002)) {
        return paramEntityManager.update(paramEntity);
      }
    }
    return false;
  }
  
  public void addReportClick(int paramInt, boolean paramBoolean, String arg3)
  {
    if (paramInt <= 0) {
      return;
    }
    synchronized (this.mAppIdNums)
    {
      int i = ((Integer)this.mAppIdNums.get(paramInt, Integer.valueOf(0))).intValue();
      this.mAppIdNums.put(paramInt, Integer.valueOf(i + 1));
      saveAppIdNums();
      return;
    }
  }
  
  public void addTroopApp(ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2)
  {
    if (paramArrayList1 != null)
    {
      if (paramArrayList1.isEmpty()) {
        return;
      }
      if (paramArrayList1.containsAll(paramArrayList2))
      {
        this.mTroopAppHandler.a(getAppListTimestamp(0), paramArrayList1, paramArrayList2);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_app.addTroopApp.troop.troop_app", 2, "appids to add are not contained in Appids list!");
      }
    }
  }
  
  public void addTroopAppInfo(Long paramLong, TroopAppInfo paramTroopAppInfo)
  {
    this.troopAppInfoCache.put(paramLong, paramTroopAppInfo);
  }
  
  public void addTroopAppInfos(ArrayList<TroopAIOAppInfo> paramArrayList, int paramInt)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramInt);
      boolean bool;
      if (localTroopAIOAppInfoListItem != null) {
        bool = true;
      } else {
        bool = false;
      }
      AssertUtils.a(bool);
      if (localTroopAIOAppInfoListItem == null) {
        return;
      }
      synchronized (this.lock)
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext())
        {
          TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
          localTroopAIOAppInfoListItem.a(localTroopAIOAppInfo.appid, localTroopAIOAppInfo);
        }
        ThreadManager.post(new TroopAppServiceImpl.2(this, this.app.getEntityManagerFactory().createEntityManager(), paramInt, paramArrayList), 8, null, false);
        return;
      }
    }
  }
  
  public void clearLocalTroopAppRedPoint(int paramInt)
  {
    EntityManager localEntityManager1 = this.app.getEntityManagerFactory().createEntityManager();
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[2];
    int[] tmp28_26 = arrayOfInt;
    tmp28_26[0] = 0;
    int[] tmp32_28 = tmp28_26;
    tmp32_28[1] = 32;
    tmp32_28;
    if (localEntityManager1 != null) {}
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        int j = arrayOfInt.length;
        i = 0;
        bool = false;
        if (i < j)
        {
          int k = arrayOfInt[i];
          Object localObject2 = (TroopAIOAppInfoListItem)this.mAppListItems.get(k);
          AssertUtils.a(localObject2);
          localObject2 = (TroopAIOAppInfo)((TroopAIOAppInfoListItem)localObject2).d.get(Integer.valueOf(paramInt));
          if (localObject2 == null) {
            break label235;
          }
          localArrayList.add(localObject2);
          ((TroopAIOAppInfo)localObject2).redPoint = false;
          bool = true;
          break label235;
        }
      }
      boolean bool = false;
      if (bool) {
        ThreadManager.post(new TroopAppServiceImpl.5(this, localArrayList, localEntityManager2), 8, null, false);
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("appid");
        ((StringBuilder)???).append(paramInt);
        ((StringBuilder)???).append("clearLocalTroopAppRedPoint,");
        ((StringBuilder)???).append(bool);
        QLog.d(".troop.troop_app", 2, ((StringBuilder)???).toString());
      }
      return;
      label235:
      i += 1;
    }
  }
  
  public void clearTroopAppRedPoint(int paramInt1, int paramInt2)
  {
    if (getAppInfo(paramInt1, paramInt2) == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt1));
    this.mTroopAppHandler.a(localArrayList, 0);
  }
  
  public void clearTroopAppRedPoints()
  {
    ??? = (TroopAIOAppInfoListItem)this.mAppListItems.get(0, null);
    AssertUtils.a(???);
    if (??? == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = ((TroopAIOAppInfoListItem)???).a();
    synchronized (this.lock)
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject3).next();
        if (localTroopAIOAppInfo.redPoint) {
          localArrayList.add(Integer.valueOf(localTroopAIOAppInfo.appid));
        }
      }
      this.mTroopAppHandler.a(localArrayList, 0);
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void clickReport()
  {
    if (this.mAppIdNums.size() == 0)
    {
      QLog.d(".troop.troop_app", 2, "clickReport appidNums size == 0");
      return;
    }
    Object localObject1 = Calendar.getInstance();
    if (((SimpleDateFormat)this.mDateFormat.get()).format(((Calendar)localObject1).getTime()).equals(this.mAppIdDate)) {
      return;
    }
    oidb_0xa1e.ReqBody localReqBody = new oidb_0xa1e.ReqBody();
    localReqBody.platform.set(2);
    localReqBody.position.set(1);
    ArrayList localArrayList = new ArrayList();
    localObject1 = this.mAppIdNums;
    int i = 0;
    try
    {
      while (i < this.mAppIdNums.size())
      {
        int j = this.mAppIdNums.keyAt(i);
        int k = ((Integer)this.mAppIdNums.get(j)).intValue();
        oidb_0xa1e.AppClick localAppClick = new oidb_0xa1e.AppClick();
        localAppClick.appid.set(j);
        localAppClick.click_num.set(k);
        localArrayList.add(localAppClick);
        i += 1;
      }
      localReqBody.rpt_app_click.set(localArrayList);
      ProtoUtils.a(this.app, new TroopAppServiceImpl.6(this), localReqBody.toByteArray(), "OidbSvc.0xa1e", 2590, 0);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean ensureAppInfoExist(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    int i = paramTroopAIOAppInfo.appid;
    TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramTroopAIOAppInfo.groupType);
    boolean bool;
    if (localTroopAIOAppInfoListItem != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.a(bool);
    if (localTroopAIOAppInfoListItem == null) {
      return false;
    }
    if ((TroopAIOAppInfo)localTroopAIOAppInfoListItem.d.get(Integer.valueOf(i)) != null) {
      return true;
    }
    localTroopAIOAppInfoListItem.a(paramTroopAIOAppInfo.appid, paramTroopAIOAppInfo);
    return false;
  }
  
  public JSONObject getAppConfig(String paramString)
  {
    AssertUtils.a(paramString);
    if (paramString == null) {
      return null;
    }
    return (JSONObject)this.mAppConfig.get(paramString);
  }
  
  public TroopAIOAppInfo getAppInfo(int paramInt1, int paramInt2)
  {
    ??? = this.mAppListItems;
    TroopAIOAppInfo localTroopAIOAppInfo = null;
    Object localObject3 = (TroopAIOAppInfoListItem)((SparseArray)???).get(paramInt2, null);
    boolean bool;
    if (localObject3 != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.a(bool);
    if (localObject3 == null) {
      return null;
    }
    synchronized (this.lock)
    {
      localObject3 = (TroopAIOAppInfo)((TroopAIOAppInfoListItem)localObject3).d.get(Integer.valueOf(paramInt1));
      if (localObject3 != null) {
        localTroopAIOAppInfo = new TroopAIOAppInfo((TroopAIOAppInfo)localObject3);
      }
      return localTroopAIOAppInfo;
    }
  }
  
  public boolean getAppListChangedFromWebOperate(int paramInt)
  {
    for (;;)
    {
      try
      {
        TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramInt, null);
        boolean bool2 = true;
        if (localTroopAIOAppInfoListItem != null)
        {
          bool1 = true;
          AssertUtils.a(bool1);
          if (localTroopAIOAppInfoListItem == null) {
            return false;
          }
          paramInt = localTroopAIOAppInfoListItem.a;
          if ((paramInt & 0x2) != 0) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          return bool1;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public int getAppListTimestamp(int paramInt)
  {
    TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramInt);
    boolean bool;
    if (localTroopAIOAppInfoListItem != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.a(bool);
    if (localTroopAIOAppInfoListItem == null) {
      return 0;
    }
    return localTroopAIOAppInfoListItem.c;
  }
  
  public List<TroopAIOAppInfo> getCopyAppInfos(List<TroopAIOAppInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    Object localObject = this.lock;
    int i = 0;
    try
    {
      while (i < paramList.size())
      {
        localArrayList.add(paramList.get(i));
        i += 1;
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  public boolean getProfileAppListChangedFromWebOperate(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(this.profileAppListChangedTroopUin)) && (this.profileAppListChangedTroopUin.equals(paramString)))
      {
        boolean bool = this.isProfileAppListChangedFromWebOperate;
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public List<TroopAIOAppInfo> getTroopAppList(boolean paramBoolean, int paramInt)
  {
    boolean bool;
    if ((paramInt != 0) && (paramInt != 32)) {
      bool = false;
    } else {
      bool = true;
    }
    AssertUtils.a(bool);
    if (AppSetting.b("6.0") < 0) {
      return Collections.emptyList();
    }
    if (paramBoolean)
    {
      paramBoolean = getAppListChangedFromWebOperate(paramInt);
      this.mTroopAppHandler.a(1, paramInt, null, paramBoolean);
    }
    ArrayList localArrayList = new ArrayList();
    synchronized (this.lock)
    {
      Object localObject3 = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramInt);
      AssertUtils.a(localObject3);
      localObject3 = ((TroopAIOAppInfoListItem)localObject3).a().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject3).next();
        if (localTroopAIOAppInfo.isValidTroopApp()) {
          localArrayList.add(localTroopAIOAppInfo);
        }
      }
      return localArrayList;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public List<TroopAIOAppInfo> getTroopAppList(boolean paramBoolean, TroopInfo paramTroopInfo)
  {
    int i;
    if ((paramTroopInfo != null) && (paramTroopInfo.dwGroupClassExt == 32L)) {
      i = 32;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_app", 2, new Object[] { "getTroopAppList with info: ", String.valueOf(paramTroopInfo), " type: ", Integer.valueOf(i), " requestServerIfNecessary: ", Boolean.valueOf(paramBoolean) });
    }
    boolean bool;
    if (paramBoolean)
    {
      if ((isCheckedUpdateAfterLogined(i)) && (!getAppListChangedFromWebOperate(i)) && (!isAppInfoDayRequest(i))) {
        paramBoolean = false;
      } else {
        paramBoolean = true;
      }
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d(".troop.troop_app", 2, new Object[] { "getTroopAppList shouldRequestServer: ", Boolean.valueOf(paramBoolean) });
        bool = paramBoolean;
      }
    }
    else
    {
      bool = false;
    }
    return getTroopAppList(bool, i);
  }
  
  public byte[] getTroopAppListData(String paramString)
  {
    BaseApplication localBaseApplication = this.app.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramString = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getString("troop_app_list_data", null);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = Base64Util.decode(paramString, 0);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public ArrayList<Long> getTroopCardAppIdListCache(String paramString)
  {
    return (ArrayList)this.mTroopCardAppIdListCache.get(paramString);
  }
  
  public ArrayList<TroopAppInfo> getTroopCardAppInfosCache(ArrayList<Long> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (Long)paramArrayList.next();
        localObject = (TroopAppInfo)this.troopAppInfoCache.get(localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean isCheckedUpdateAfterLogined(int paramInt)
  {
    for (;;)
    {
      try
      {
        TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramInt, null);
        boolean bool2 = true;
        if (localTroopAIOAppInfoListItem != null)
        {
          bool1 = true;
          AssertUtils.a(bool1);
          if (localTroopAIOAppInfoListItem == null) {
            return false;
          }
          paramInt = localTroopAIOAppInfoListItem.a;
          if ((paramInt & 0x1) != 0) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          return bool1;
        }
      }
      finally {}
      boolean bool1 = false;
    }
  }
  
  public boolean makeAppidsInOrder(List<Integer> paramList, int paramInt)
  {
    TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramInt, null);
    boolean bool2 = true;
    boolean bool1;
    if (paramList != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    AssertUtils.a(bool1);
    if (localTroopAIOAppInfoListItem != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    AssertUtils.a(bool1);
    Object localObject;
    if (localTroopAIOAppInfoListItem != null)
    {
      if (paramList == null) {
        return false;
      }
      new ArrayList();
      if (paramList.size() != localTroopAIOAppInfoListItem.d.size()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localObject = this.lock;
      bool2 = bool1;
      if (bool1) {}
    }
    try
    {
      bool1 = localTroopAIOAppInfoListItem.a(paramList);
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d(".troop.troop_app", 2, "makeAppidsInOrder() app order changed!");
          bool2 = bool1;
        }
      }
      if (bool2)
      {
        localTroopAIOAppInfoListItem.a(paramList, paramInt);
        saveTroopAppInfosToDB(localTroopAIOAppInfoListItem.a(), paramInt);
      }
      return bool2;
    }
    finally
    {
      label174:
      break label174;
    }
    throw paramList;
    return false;
  }
  
  public boolean needRequestDetail(TroopAIOAppInfo paramTroopAIOAppInfo)
  {
    int i = paramTroopAIOAppInfo.appid;
    Object localObject = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramTroopAIOAppInfo.groupType);
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    AssertUtils.a(bool1);
    if (localObject == null) {
      return true;
    }
    localObject = (TroopAIOAppInfo)((TroopAIOAppInfoListItem)localObject).d.get(Integer.valueOf(i));
    if (localObject == null) {
      return true;
    }
    AssertUtils.a(paramTroopAIOAppInfo.hashVal);
    AssertUtils.a(((TroopAIOAppInfo)localObject).hashVal);
    if ((TextUtils.equals(paramTroopAIOAppInfo.hashVal, ((TroopAIOAppInfo)localObject).hashVal)) && (((TroopAIOAppInfo)localObject).isValidTroopApp()) && (paramTroopAIOAppInfo.identifyMask == ((TroopAIOAppInfo)localObject).identifyMask))
    {
      bool1 = bool2;
      if (paramTroopAIOAppInfo.redPoint == ((TroopAIOAppInfo)localObject).redPoint) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.mTroopAppHandler = ((TroopAppHandler)((AppInterface)this.app).getBusinessHandler(TroopAppHandler.class.getName()));
    loadAllAppConfigs();
    paramAppRuntime = new int[2];
    AppRuntime tmp37_36 = paramAppRuntime;
    tmp37_36[0] = 0;
    AppRuntime tmp41_37 = tmp37_36;
    tmp41_37[1] = 32;
    tmp41_37;
    int j = paramAppRuntime.length;
    int i = 0;
    while (i < j)
    {
      int k = paramAppRuntime[i];
      TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = new TroopAIOAppInfoListItem();
      SharedPreferences localSharedPreferences = this.app.getPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("appinfo_date_");
      localStringBuilder.append(k);
      localTroopAIOAppInfoListItem.b = localSharedPreferences.getString(localStringBuilder.toString(), "");
      localSharedPreferences = this.app.getPreferences();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KEY_APP_LIST_TIME_STAMP_");
      localStringBuilder.append(k);
      localTroopAIOAppInfoListItem.c = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
      this.mAppListItems.put(k, localTroopAIOAppInfoListItem);
      i += 1;
    }
    initTroopAppInfoList();
    initAppIdNums();
    this.mAppIdDate = this.app.getPreferences().getString("appid_click_date", null);
    this.mAllAppString = this.app.getPreferences().getString("appinfo_all_app_string", HardCodeUtil.a(2131912465));
    if (this.troopAppInfoCache == null) {
      try
      {
        if (this.troopAppInfoCache == null) {
          this.troopAppInfoCache = new ConcurrentHashMap();
        }
      }
      finally {}
    }
    if (this.mTroopCardAppIdListCache == null) {
      try
      {
        if (this.mTroopCardAppIdListCache == null) {
          this.mTroopCardAppIdListCache = new ConcurrentHashMap();
        }
        return;
      }
      finally {}
    }
  }
  
  public void onDestroy()
  {
    int[] arrayOfInt = new int[2];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 32;
    tmp11_7;
    synchronized (this.lock)
    {
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        setCheckedUpdateAfterLogined(false, k);
        TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(k);
        AssertUtils.a(localTroopAIOAppInfoListItem);
        localTroopAIOAppInfoListItem.d.clear();
        localTroopAIOAppInfoListItem.b();
        localTroopAIOAppInfoListItem.c = 0;
        i += 1;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void removeTroopAppByAppid(int paramInt1, int paramInt2)
  {
    TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramInt2);
    boolean bool;
    if (localTroopAIOAppInfoListItem != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.a(bool);
    if (localTroopAIOAppInfoListItem == null) {
      return;
    }
    TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localTroopAIOAppInfoListItem.d.remove(Integer.valueOf(paramInt1));
    if (localTroopAIOAppInfo != null)
    {
      AssertUtils.a(localTroopAIOAppInfoListItem.a(localTroopAIOAppInfo));
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_app", 2, new Object[] { "removeTroopAppByAppid appid: ", Integer.valueOf(paramInt1), "/", Integer.valueOf(paramInt2), " removed" });
      }
      ThreadManager.post(new TroopAppServiceImpl.4(this, this.app.getEntityManagerFactory().createEntityManager(), localTroopAIOAppInfo), 8, null, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_app", 2, new Object[] { "removeTroopAppByAppid appid: ", Integer.valueOf(paramInt1), "/", Integer.valueOf(paramInt2), " remove fail, not contains app" });
    }
  }
  
  public void saveAppListTimestamp(int paramInt1, int paramInt2)
  {
    Object localObject = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramInt2);
    boolean bool;
    if (localObject != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.a(bool);
    if (localObject == null) {
      return;
    }
    ((TroopAIOAppInfoListItem)localObject).c = paramInt1;
    localObject = this.app.getPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KEY_APP_LIST_TIME_STAMP_");
    localStringBuilder.append(paramInt2);
    ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt1).commit();
  }
  
  public void setAppListChangedFromWebOperate(boolean paramBoolean)
  {
    try
    {
      Object localObject1 = this.mAppListItems;
      boolean bool = false;
      localObject1 = (TroopAIOAppInfoListItem)((SparseArray)localObject1).get(0, null);
      if (localObject1 != null) {
        bool = true;
      }
      AssertUtils.a(bool);
      if (localObject1 == null) {
        return;
      }
      if (paramBoolean) {
        ((TroopAIOAppInfoListItem)localObject1).a |= 0x2;
      } else {
        ((TroopAIOAppInfoListItem)localObject1).a &= 0xFFFFFFFD;
      }
      return;
    }
    finally {}
  }
  
  public void setCheckedUpdateAfterLogined(boolean paramBoolean, int paramInt)
  {
    for (;;)
    {
      try
      {
        TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramInt, null);
        if (localTroopAIOAppInfoListItem != null)
        {
          bool = true;
          AssertUtils.a(bool);
          if (localTroopAIOAppInfoListItem == null) {
            return;
          }
          if (paramBoolean) {
            localTroopAIOAppInfoListItem.a |= 0x1;
          } else {
            localTroopAIOAppInfoListItem.a &= 0xFFFFFFFE;
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void setProfileAppListChangedFromWebOperate(boolean paramBoolean, String paramString)
  {
    try
    {
      this.isProfileAppListChangedFromWebOperate = paramBoolean;
      this.profileAppListChangedTroopUin = paramString;
      return;
    }
    finally {}
  }
  
  public void setTroopAppListData(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    BaseApplication localBaseApplication = this.app.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putString("troop_app_list_data", Base64Util.encodeToString(paramArrayOfByte, 2)).commit();
  }
  
  public void setTroopCardAppListCache(String paramString, ArrayList<Long> paramArrayList)
  {
    this.mTroopCardAppIdListCache.put(paramString, paramArrayList);
  }
  
  public void sortTroopAppList(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      TroopAIOAppInfoListItem localTroopAIOAppInfoListItem = (TroopAIOAppInfoListItem)this.mAppListItems.get(0, null);
      boolean bool;
      if (localTroopAIOAppInfoListItem != null) {
        bool = true;
      } else {
        bool = false;
      }
      AssertUtils.a(bool);
      if (localTroopAIOAppInfoListItem == null) {
        return;
      }
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (!localTroopAIOAppInfoListItem.d.containsKey(localInteger))
        {
          QLog.w(".troop.troop_app", 1, "sortTroopAppList error, there is no appid in hashtable");
          return;
        }
      }
      this.mTroopAppHandler.a(getAppListTimestamp(0), paramArrayList);
    }
  }
  
  public void tryParseAppConfig(JSONObject paramJSONObject)
  {
    ITroopAppService.AppConfig[] arrayOfAppConfig = ITroopAppService.AppConfig.b;
    int j = arrayOfAppConfig.length;
    int i = 0;
    while (i < j)
    {
      ITroopAppService.AppConfig localAppConfig = arrayOfAppConfig[i];
      JSONObject localJSONObject = localAppConfig.a(paramJSONObject.optJSONObject(localAppConfig.a));
      if (localJSONObject != null) {
        setAppConfig(localAppConfig.a, localJSONObject);
      }
      i += 1;
    }
  }
  
  public void update0xca02Info(String paramString)
  {
    SharedPreferences.Editor localEditor = this.app.getPreferences().edit();
    this.mAllAppString = paramString;
    localEditor.putString("appinfo_all_app_string", paramString).commit();
  }
  
  public void updateAppInfoCalendarDay(int paramInt)
  {
    Object localObject1 = Calendar.getInstance();
    localObject1 = ((SimpleDateFormat)this.mDateFormat.get()).format(((Calendar)localObject1).getTime());
    Object localObject2 = (TroopAIOAppInfoListItem)this.mAppListItems.get(paramInt, null);
    boolean bool;
    if (localObject2 != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.a(bool);
    if (localObject2 != null) {
      ((TroopAIOAppInfoListItem)localObject2).b = ((String)localObject1);
    }
    localObject2 = this.app.getPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("appinfo_date_");
    localStringBuilder.append(paramInt);
    ((SharedPreferences.Editor)localObject2).putString(localStringBuilder.toString(), (String)localObject1).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopAppServiceImpl
 * JD-Core Version:    0.7.0.1
 */