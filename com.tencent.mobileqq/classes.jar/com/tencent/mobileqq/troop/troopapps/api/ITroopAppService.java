package com.tencent.mobileqq.troop.troopapps.api;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

@Service(process={"all"})
public abstract interface ITroopAppService
  extends IRuntimeService
{
  public static final String KEY_ALL_APP_STRING = "appinfo_all_app_string";
  public static final String KEY_APPID_CLICK_DATE = "appid_click_date";
  public static final String KEY_APPID_CLICK_NUM = "appid_click_num";
  public static final String KEY_APPINFO_DATE = "appinfo_date";
  public static final String KEY_APP_CONFIG_PREFIX = "KEY_APP_CONFIG_PREFIX";
  public static final String KEY_APP_LIST_TIME_STAMP = "KEY_APP_LIST_TIME_STAMP";
  public static final int READ_TYPE_DETAIL = 2;
  public static final int READ_TYPE_HASH = 1;
  
  public abstract void addReportClick(int paramInt, boolean paramBoolean, String paramString);
  
  public abstract void addTroopApp(ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2);
  
  public abstract void addTroopAppInfo(Long paramLong, TroopAppInfo paramTroopAppInfo);
  
  public abstract void addTroopAppInfos(ArrayList<TroopAIOAppInfo> paramArrayList, int paramInt);
  
  public abstract void clearLocalTroopAppRedPoint(int paramInt);
  
  public abstract void clearTroopAppRedPoint(int paramInt1, int paramInt2);
  
  public abstract void clearTroopAppRedPoints();
  
  public abstract void clickReport();
  
  public abstract boolean ensureAppInfoExist(TroopAIOAppInfo paramTroopAIOAppInfo);
  
  public abstract JSONObject getAppConfig(String paramString);
  
  public abstract TroopAIOAppInfo getAppInfo(int paramInt1, int paramInt2);
  
  public abstract boolean getAppListChangedFromWebOperate(int paramInt);
  
  public abstract int getAppListTimestamp(int paramInt);
  
  public abstract List<TroopAIOAppInfo> getCopyAppInfos(List<TroopAIOAppInfo> paramList);
  
  public abstract boolean getProfileAppListChangedFromWebOperate(String paramString);
  
  public abstract List<TroopAIOAppInfo> getTroopAppList(boolean paramBoolean, int paramInt);
  
  public abstract List<TroopAIOAppInfo> getTroopAppList(boolean paramBoolean, TroopInfo paramTroopInfo);
  
  public abstract byte[] getTroopAppListData(String paramString);
  
  public abstract ArrayList<Long> getTroopCardAppIdListCache(String paramString);
  
  public abstract ArrayList<TroopAppInfo> getTroopCardAppInfosCache(ArrayList<Long> paramArrayList);
  
  public abstract boolean isCheckedUpdateAfterLogined(int paramInt);
  
  public abstract boolean makeAppidsInOrder(List<Integer> paramList, int paramInt);
  
  public abstract boolean needRequestDetail(TroopAIOAppInfo paramTroopAIOAppInfo);
  
  public abstract void removeTroopAppByAppid(int paramInt1, int paramInt2);
  
  public abstract void saveAppListTimestamp(int paramInt1, int paramInt2);
  
  public abstract void setAppListChangedFromWebOperate(boolean paramBoolean);
  
  public abstract void setCheckedUpdateAfterLogined(boolean paramBoolean, int paramInt);
  
  public abstract void setProfileAppListChangedFromWebOperate(boolean paramBoolean, String paramString);
  
  public abstract void setTroopAppListData(String paramString, byte[] paramArrayOfByte);
  
  public abstract void setTroopCardAppListCache(String paramString, ArrayList<Long> paramArrayList);
  
  public abstract void sortTroopAppList(ArrayList<Integer> paramArrayList);
  
  public abstract void tryParseAppConfig(JSONObject paramJSONObject);
  
  public abstract void update0xca02Info(String paramString);
  
  public abstract void updateAppInfoCalendarDay(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.ITroopAppService
 * JD-Core Version:    0.7.0.1
 */