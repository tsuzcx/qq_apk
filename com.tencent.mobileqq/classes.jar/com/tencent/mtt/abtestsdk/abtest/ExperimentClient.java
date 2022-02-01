package com.tencent.mtt.abtestsdk.abtest;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mtt.abtestsdk.entity.ABTestConfig;
import com.tencent.mtt.abtestsdk.entity.AttaEntity;
import com.tencent.mtt.abtestsdk.entity.BeaconExpEntity;
import com.tencent.mtt.abtestsdk.entity.DeviceEntity;
import com.tencent.mtt.abtestsdk.entity.ExpEntity;
import com.tencent.mtt.abtestsdk.entity.ExpStrategyEntity;
import com.tencent.mtt.abtestsdk.listener.ExpInitListener;
import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.manager.CacheManager;
import com.tencent.mtt.abtestsdk.report.AttaReport;
import com.tencent.mtt.abtestsdk.report.BeaconReport;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import com.tencent.mtt.abtestsdk.utils.ABTestUtil;
import com.tencent.mtt.abtestsdk.utils.HandlerThreadUtil;
import com.tencent.mtt.abtestsdk.utils.ThreadPoolUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExperimentClient
{
  private static boolean sIsInitExpClient = false;
  private final List<ExpInitListener> initListeners = new CopyOnWriteArrayList();
  private CacheManager mCacheMgr;
  private ABTestConfig mConfig;
  private Context mContext;
  private Handler mMainHandler;
  
  private boolean checkIsFetchExpInIntervalTime(ExpStrategyEntity paramExpStrategyEntity)
  {
    boolean bool = true;
    if (paramExpStrategyEntity == null) {
      return true;
    }
    long l2 = System.currentTimeMillis() / 1000L;
    long l3 = paramExpStrategyEntity.getLastFetchDataTime();
    long l1 = paramExpStrategyEntity.getRefreshDuration();
    l2 -= l3;
    ABTestLog.expUpload(String.format("exp fetch data by net cur interval time: %d, fetchIntervalTime: %d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) }), new Object[0]);
    if (l2 < l1) {
      bool = false;
    }
    return bool;
  }
  
  private boolean checkIsResponseDataValid(String paramString, OnUpdateExperimentsListener paramOnUpdateExperimentsListener)
  {
    if (paramString.contains("<html>"))
    {
      handleOnFailedEvent(1002, "unknown error", paramOnUpdateExperimentsListener);
      return false;
    }
    try
    {
      if (new JSONObject(paramString).optInt("code") != 0)
      {
        handleOnFailedEvent(1006, "server error", paramOnUpdateExperimentsListener);
        return false;
      }
      return true;
    }
    catch (JSONException paramString)
    {
      label51:
      break label51;
    }
    ABTestLog.expUpload(String.format("response json format invalid", new Object[0]), new Object[0]);
    handleOnFailedEvent(1005, "json parser error", paramOnUpdateExperimentsListener);
    return false;
  }
  
  private void handleOnFailedEvent(int paramInt, String paramString, OnUpdateExperimentsListener paramOnUpdateExperimentsListener)
  {
    Message localMessage = this.mMainHandler.obtainMessage(1);
    Bundle localBundle = localMessage.getData();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("errMsg", paramString);
    localMessage.setData(localBundle);
    localMessage.obj = paramOnUpdateExperimentsListener;
    localMessage.sendToTarget();
  }
  
  private void handleOnSuccessEvent(String paramString1, String paramString2, OnUpdateExperimentsListener paramOnUpdateExperimentsListener)
  {
    if (!checkIsResponseDataValid(paramString1, paramOnUpdateExperimentsListener)) {
      return;
    }
    paramString1 = updateRemoteData(paramString1, paramString2);
    paramString2 = this.mMainHandler.obtainMessage(0);
    paramString2.obj = new Object[] { paramString1, paramOnUpdateExperimentsListener };
    paramString2.sendToTarget();
  }
  
  private JSONObject handlePostBodyData(String paramString)
  {
    String str1 = ABTestUtil.getABTestSDKAppId(this.mContext, this.mConfig);
    String str2 = this.mConfig.getGuid();
    Map localMap = this.mConfig.getCustomProfiles();
    List localList1 = this.mConfig.getLayerCodes();
    List localList2 = this.mConfig.getSceneIds();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("appid", str1);
      localJSONObject.put("guid", str2);
      if ((localMap != null) && (!localMap.isEmpty())) {
        localJSONObject.put("profiles", new JSONObject(new JSONObject(localMap).toString()));
      }
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("expName", paramString);
      }
      if ((localList1 != null) && (!localList1.isEmpty())) {
        localJSONObject.put("layerCodes", new JSONArray(localList1));
      }
      if ((localList2 != null) && (!localList2.isEmpty())) {
        localJSONObject.put("sceneId", new JSONArray(localList2));
      }
      ABTestLog.expUpload(String.format("exp expName: %s, appId: %s, guid: %s\npostBody: %s ", new Object[] { paramString, str1, str2, localJSONObject.toString() }), new Object[0]);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      ABTestLog.error(paramString.getMessage(), new Object[0]);
    }
    return null;
  }
  
  private void initClientData()
  {
    this.mCacheMgr = CacheManager.getInstance(this.mContext, this.mConfig.isDiskCache());
  }
  
  private void startFetchExpData()
  {
    Message localMessage = HandlerThreadUtil.getHandler().obtainMessage(0, new Object[] { this, this.mCacheMgr });
    HandlerThreadUtil.getHandler().sendMessage(localMessage);
  }
  
  private JSONObject updateRemoteData(String paramString1, String paramString2)
  {
    Object localObject1 = new ConcurrentHashMap();
    try
    {
      paramString1 = new JSONObject(paramString1);
      JSONObject localJSONObject1 = paramString1.optJSONObject("strategy");
      if (localJSONObject1 == null) {
        return null;
      }
      Object localObject2 = new ExpStrategyEntity();
      ((ExpStrategyEntity)localObject2).readFromJson(localJSONObject1);
      this.mCacheMgr.saveExpReportStrategy((ExpStrategyEntity)localObject2);
      localJSONObject1 = paramString1.optJSONObject("data");
      if (localJSONObject1 != null)
      {
        if (localJSONObject1.keys() == null) {
          return null;
        }
        paramString1 = localJSONObject1.keys();
        while (paramString1.hasNext())
        {
          localObject2 = (String)paramString1.next();
          JSONObject localJSONObject2 = localJSONObject1.optJSONObject((String)localObject2);
          ExpEntity localExpEntity = new ExpEntity("");
          localExpEntity.readJson(localJSONObject2);
          localExpEntity.setLayerCode((String)localObject2);
          ((Map)localObject1).put(localObject2, localExpEntity);
        }
        if (TextUtils.isEmpty(paramString2))
        {
          this.mCacheMgr.saveExpEntityMap((Map)localObject1);
          if (!sIsInitExpClient)
          {
            paramString1 = this.initListeners.iterator();
            while (paramString1.hasNext()) {
              ((ExpInitListener)paramString1.next()).expInitSuccess();
            }
            sIsInitExpClient = true;
            return localJSONObject1;
          }
        }
        else
        {
          paramString2 = this.mCacheMgr.getExpEntityMap();
          paramString1 = paramString2;
          if (paramString2 == null) {
            paramString1 = new ConcurrentHashMap();
          }
          paramString2 = ((Map)localObject1).entrySet().iterator();
          while (paramString2.hasNext())
          {
            localObject1 = (Map.Entry)paramString2.next();
            paramString1.put((String)((Map.Entry)localObject1).getKey(), (ExpEntity)((Map.Entry)localObject1).getValue());
          }
          this.mCacheMgr.saveExpEntityMap(paramString1);
        }
        return localJSONObject1;
      }
      return null;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("updateData error and please check data format: ");
      paramString2.append(paramString1.getMessage());
      ABTestLog.error(paramString2.toString(), new Object[0]);
    }
    return null;
  }
  
  public void fetchExpDataByNet(String paramString, OnUpdateExperimentsListener paramOnUpdateExperimentsListener, int paramInt)
  {
    JSONObject localJSONObject = handlePostBodyData(paramString);
    if (localJSONObject == null) {
      return;
    }
    String str = this.mConfig.getExperimentUrl();
    ABTestLog.expUpload(String.format("expUrl:  %s", new Object[] { str }), new Object[0]);
    ThreadPoolUtil.execute(new ExperimentClient.1(this, str, localJSONObject, paramInt, paramString, paramOnUpdateExperimentsListener));
  }
  
  public void handleIntervalFetchExpByNet(OnUpdateExperimentsListener paramOnUpdateExperimentsListener, int paramInt)
  {
    if ((checkIsFetchExpInIntervalTime(this.mCacheMgr.getExpReportStrategy())) || (paramOnUpdateExperimentsListener == null)) {
      fetchExpDataByNet("", paramOnUpdateExperimentsListener, paramInt);
    }
  }
  
  public void init(@Nullable Context paramContext, @Nullable ABTestConfig paramABTestConfig, Handler paramHandler)
  {
    this.mContext = paramContext;
    this.mConfig = paramABTestConfig;
    this.mMainHandler = paramHandler;
    initClientData();
    startFetchExpData();
  }
  
  public void registerExpInitListener(ExpInitListener paramExpInitListener)
  {
    List localList = this.initListeners;
    if ((localList != null) && (!localList.contains(paramExpInitListener))) {
      this.initListeners.add(paramExpInitListener);
    }
  }
  
  public boolean reportBeaconExpExpose(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      String str1 = ABTestUtil.getABTestSDKAppId(this.mContext, this.mConfig);
      String str2 = this.mConfig.getGuid();
      BeaconExpEntity localBeaconExpEntity = new BeaconExpEntity();
      localBeaconExpEntity.setAppId(str1);
      localBeaconExpEntity.setUserId(str2);
      localBeaconExpEntity.setGrayId(paramString1);
      localBeaconExpEntity.setExpName(paramString2);
      localBeaconExpEntity.setReportFlag(paramString3);
      boolean bool = BeaconReport.reportExpEvent("rqd_expimpression", localBeaconExpEntity);
      return bool;
    }
    catch (Exception paramString1)
    {
      label76:
      break label76;
    }
    ABTestLog.warn("beacon report failed ", new Object[0]);
    return false;
  }
  
  public void reportExpAttaExpose(String paramString1, String paramString2)
  {
    Object localObject1 = this.mCacheMgr;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((CacheManager)localObject1).getExpReportStrategy();
    if (!((ExpStrategyEntity)localObject2).isEnableReport())
    {
      ABTestLog.debug("atta report not enabled!", new Object[0]);
      return;
    }
    localObject1 = new AttaEntity();
    String str1 = ((ExpStrategyEntity)localObject2).getReportId();
    String str2 = ((ExpStrategyEntity)localObject2).getReportToken();
    if ((TextUtils.equals("atta", ((ExpStrategyEntity)localObject2).getReportType())) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      ((AttaEntity)localObject1).setAttaId(str1);
      ((AttaEntity)localObject1).setAttaToken(str2);
      ABTestLog.expUpload(String.format("get exp strategy atta report, attaId: %s, attaToken: %s", new Object[] { str1, str2 }), new Object[0]);
    }
    localObject2 = this.mCacheMgr.getCommonDeviceEntity();
    ((AttaEntity)localObject1).setPlatform("android");
    ((AttaEntity)localObject1).setGrayid(paramString1);
    ((AttaEntity)localObject1).setGuid(((DeviceEntity)localObject2).getGuid());
    ((AttaEntity)localObject1).setEventcode("rqd_expimpression");
    ((AttaEntity)localObject1).setAppid(ABTestUtil.getABTestSDKAppId(this.mContext, this.mConfig));
    ((AttaEntity)localObject1).setBundleid(((DeviceEntity)localObject2).getBundleId());
    ((AttaEntity)localObject1).setBundlerversion(((DeviceEntity)localObject2).getBundleVersion());
    ((AttaEntity)localObject1).setChannel("");
    ((AttaEntity)localObject1).setDevicebrand(((DeviceEntity)localObject2).getDeviceBrand());
    ((AttaEntity)localObject1).setDevicemodel(((DeviceEntity)localObject2).getDeviceVersion());
    ((AttaEntity)localObject1).setEventpage("");
    ((AttaEntity)localObject1).setEventtime(String.valueOf(System.currentTimeMillis()));
    ((AttaEntity)localObject1).setSdkversion("3.0.14");
    paramString1 = new StringBuilder();
    paramString1.append(((DeviceEntity)localObject2).getDeviceWidth());
    paramString1.append("_");
    paramString1.append(((DeviceEntity)localObject2).getDeviceHeight());
    ((AttaEntity)localObject1).setResolution(paramString1.toString());
    ((AttaEntity)localObject1).setLanguage(((DeviceEntity)localObject2).getLanguage());
    ((AttaEntity)localObject1).setOsmodel("android");
    ((AttaEntity)localObject1).setOsversion(((DeviceEntity)localObject2).getOsVersion());
    ((AttaEntity)localObject1).setIsfirsthint("0");
    ((AttaEntity)localObject1).setReportFlag(paramString2);
    AttaReport.getInstance().report((AttaEntity)localObject1);
  }
  
  public void unregisterExpInitListener(ExpInitListener paramExpInitListener)
  {
    List localList = this.initListeners;
    if ((localList != null) && (localList.contains(paramExpInitListener))) {
      this.initListeners.remove(paramExpInitListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.abtest.ExperimentClient
 * JD-Core Version:    0.7.0.1
 */