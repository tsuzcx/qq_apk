package com.tencent.tmassistantsdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.text.TextUtils;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.tencent.tmassistantsdk.internal.logreport.e;
import com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.QQDownloaderInstalled;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TMAssistantCallYYB_V2
  extends TMAssistantBaseCallYYB
  implements ITMAssistantCallBackListener, com.tencent.tmassistantsdk.internal.openSDK.QQDownloader.d
{
  protected static final String TAG = "TMAssistantCallYYB_V2";
  protected static TMAssistantCallYYB_V2 mInstance = null;
  protected CopyOnWriteArrayList<TMAssistantCallYYBParamStruct> mTaskList = null;
  
  private void addToTaskList(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    for (;;)
    {
      try
      {
        ab.c("TMAssistantCallYYB_V2", "param = " + paramTMAssistantCallYYBParamStruct);
        TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct;
        if ((paramTMAssistantCallYYBParamStruct != null) && (this.mTaskList != null))
        {
          Iterator localIterator = this.mTaskList.iterator();
          if (!localIterator.hasNext()) {
            break label169;
          }
          localTMAssistantCallYYBParamStruct = (TMAssistantCallYYBParamStruct)localIterator.next();
          if (localTMAssistantCallYYBParamStruct.taskAppId == null) {
            continue;
          }
          if (!localTMAssistantCallYYBParamStruct.taskAppId.equals(paramTMAssistantCallYYBParamStruct.taskAppId)) {
            continue;
          }
          if (localTMAssistantCallYYBParamStruct.taskPackageName == null) {
            break label174;
          }
          if (!localTMAssistantCallYYBParamStruct.taskPackageName.equals(paramTMAssistantCallYYBParamStruct.taskPackageName)) {
            continue;
          }
          break label174;
          if (i == 0) {
            this.mTaskList.add(paramTMAssistantCallYYBParamStruct);
          }
        }
        return;
        if (localTMAssistantCallYYBParamStruct.taskPackageName == null) {
          continue;
        }
        boolean bool = localTMAssistantCallYYBParamStruct.taskPackageName.equals(paramTMAssistantCallYYBParamStruct.taskPackageName);
        if (bool != true) {
          continue;
        }
        i = 1;
        continue;
        i = 0;
      }
      finally {}
      label169:
      continue;
      label174:
      int i = 1;
    }
  }
  
  private void addToTaskListHead(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    for (;;)
    {
      try
      {
        ab.c("TMAssistantCallYYB_V2", "param = " + paramTMAssistantCallYYBParamStruct);
        TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct;
        if ((paramTMAssistantCallYYBParamStruct != null) && (this.mTaskList != null))
        {
          Iterator localIterator = this.mTaskList.iterator();
          if (!localIterator.hasNext()) {
            break label169;
          }
          localTMAssistantCallYYBParamStruct = (TMAssistantCallYYBParamStruct)localIterator.next();
          if (localTMAssistantCallYYBParamStruct.taskAppId == null) {
            continue;
          }
          if (!localTMAssistantCallYYBParamStruct.taskAppId.equals(paramTMAssistantCallYYBParamStruct.taskAppId)) {
            continue;
          }
          if (localTMAssistantCallYYBParamStruct.taskPackageName == null) {
            break label174;
          }
          if (!localTMAssistantCallYYBParamStruct.taskPackageName.equals(paramTMAssistantCallYYBParamStruct.taskPackageName)) {
            continue;
          }
          break label174;
          if (i == 0) {
            this.mTaskList.add(0, paramTMAssistantCallYYBParamStruct);
          }
        }
        return;
        if (localTMAssistantCallYYBParamStruct.taskPackageName == null) {
          continue;
        }
        boolean bool = localTMAssistantCallYYBParamStruct.taskPackageName.equals(paramTMAssistantCallYYBParamStruct.taskPackageName);
        if (bool != true) {
          continue;
        }
        i = 1;
        continue;
        i = 0;
      }
      finally {}
      label169:
      continue;
      label174:
      int i = 1;
    }
  }
  
  private Map<String, String> buildBatchDownloadParam(Context paramContext, ArrayList<TMAssistantCallYYBParamStruct> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = (TMAssistantCallYYBParamStruct)paramArrayList.next();
      if (localTMAssistantCallYYBParamStruct != null)
      {
        JSONObject localJSONObject2 = new JSONObject();
        try
        {
          localJSONObject2.put("pkgName", localTMAssistantCallYYBParamStruct.taskPackageName);
          localJSONObject2.put("versionCode", localTMAssistantCallYYBParamStruct.taskVersion);
          localJSONObject2.put("yybChannelId", localTMAssistantCallYYBParamStruct.channelId);
          localJSONObject2.put("recommendId", localTMAssistantCallYYBParamStruct.recommendId);
          localJSONObject2.put("via", localTMAssistantCallYYBParamStruct.via);
          localJSONArray.put(localJSONObject2);
        }
        catch (JSONException localJSONException)
        {
          ab.e("TMAssistantCallYYB_V2", "" + localJSONException.getMessage() + "|" + localJSONException.getCause());
        }
      }
    }
    try
    {
      localJSONObject1.put("appList", localJSONArray);
      localJSONObject1.put("hostPackageName", GlobalUtil.getAppPackageName(paramContext));
      localJSONObject1.put("hostVersionCode", GlobalUtil.getAppVersionCode(paramContext));
      localHashMap.put("out_batch_download", localJSONObject1.toString());
      return localHashMap;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        ab.e("TMAssistantCallYYB_V2", "" + paramContext.getMessage() + "|" + paramContext.getCause());
      }
    }
  }
  
  private int getBatchOperateType(int paramInt)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      ab.c("TMAssistantCallYYB_V2", ">getBatchOperateType = " + paramInt);
      return paramInt;
      paramInt = 8;
      continue;
      paramInt = 7;
    }
  }
  
  private int getBatchRequestType(boolean paramBoolean, int paramInt)
  {
    int j = 2;
    ab.c("TMAssistantCallYYB_V2", "isUpdateAll = " + paramBoolean + ",operation = " + paramInt);
    int i;
    if (paramBoolean)
    {
      i = j;
      switch (paramInt)
      {
      default: 
        i = j;
      }
    }
    for (;;)
    {
      ab.c("TMAssistantCallYYB_V2", "batchRequestType = " + i);
      return i;
      i = 1;
      continue;
      i = 6;
      continue;
      i = 5;
      continue;
      switch (paramInt)
      {
      default: 
        i = j;
        break;
      case 0: 
      case 1: 
        i = 4;
        break;
      case 2: 
        i = 8;
        break;
      case 3: 
        i = 7;
      }
    }
  }
  
  public static TMAssistantCallYYB_V2 getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new TMAssistantCallYYB_V2();
      }
      TMAssistantCallYYB_V2 localTMAssistantCallYYB_V2 = mInstance;
      return localTMAssistantCallYYB_V2;
    }
    finally {}
  }
  
  private void onProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2)
  {
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMAssistantCallBackListener localITMAssistantCallBackListener = (ITMAssistantCallBackListener)((WeakReference)localIterator.next()).get();
      if (localITMAssistantCallBackListener == null) {
        ab.c("TMAssistantCallYYB_V2", "onDownloadStateChanged listener = null");
      } else {
        localITMAssistantCallBackListener.onDownloadTaskProgressChanged(paramTMAssistantCallYYBParamStruct, paramLong1, paramLong2);
      }
    }
  }
  
  private OuterCallReportModel setupOuterCallModel(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    OuterCallReportModel localOuterCallReportModel = OuterCallReportModel.getDefaultModel();
    localOuterCallReportModel.mOuterCallTime = System.currentTimeMillis();
    localOuterCallReportModel.mOuterCallMode = 1;
    localOuterCallReportModel.mOuterCallType = 1;
    if (paramTMAssistantCallYYBParamStruct != null) {
      localOuterCallReportModel.mVia = paramTMAssistantCallYYBParamStruct.via;
    }
    localOuterCallReportModel.mComponentName = "SplashActivity";
    return localOuterCallReportModel;
  }
  
  private OuterCallReportModel setupOuterCallModel(String paramString)
  {
    OuterCallReportModel localOuterCallReportModel = OuterCallReportModel.getDefaultModel();
    localOuterCallReportModel.mComponentName = "SplashActivity";
    localOuterCallReportModel.mVia = Uri.parse(paramString).getQueryParameter("via");
    localOuterCallReportModel.mOuterCallType = 1;
    localOuterCallReportModel.mOuterCallMode = 1;
    return localOuterCallReportModel;
  }
  
  private Map<String, String> setupParamMap(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, OuterCallReportModel paramOuterCallReportModel, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap != null)
    {
      localHashMap.putAll(paramMap);
      if (paramOuterCallReportModel != null)
      {
        localHashMap.put("outerCallType", String.valueOf(paramOuterCallReportModel.mOuterCallType));
        localHashMap.put("outerCallTime", String.valueOf(paramOuterCallReportModel.mOuterCallTime));
        localHashMap.put("outerCallMode", String.valueOf(paramOuterCallReportModel.mOuterCallMode));
        localHashMap.put("outerCallComponent", paramOuterCallReportModel.mComponentName);
        if (paramTMAssistantCallYYBParamStruct != null) {
          localHashMap.put("beaconId", paramOuterCallReportModel.mHostPname + "|" + paramTMAssistantCallYYBParamStruct.via + "|" + paramOuterCallReportModel.mOuterCallTime);
        }
      }
    }
    return localHashMap;
  }
  
  private void startToAppDetailNewAPI(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, OuterCallReportModel paramOuterCallReportModel, Map<String, String> paramMap)
  {
    paramOuterCallReportModel = super.formatIntentUriPath(2, setupParamMap(paramTMAssistantCallYYBParamStruct, paramOuterCallReportModel, paramMap));
    paramMap = new Intent();
    paramMap.setData(Uri.parse(paramOuterCallReportModel));
    paramMap.addFlags(268435456);
    paramMap.putExtra(TMAssistantCallYYBParamStruct.SOURCE_KEY, paramTMAssistantCallYYBParamStruct.source);
    paramMap.putExtra("packageName", paramTMAssistantCallYYBParamStruct.taskPackageName);
    ab.c("TMAssistantCallYYB_V2", "YYB版本符合要求，执行tmast ：" + paramOuterCallReportModel);
    paramContext.startActivity(paramMap);
  }
  
  private void startToDownloadListNewAPI(Context paramContext, Map<String, String> paramMap)
  {
    paramMap = super.formatIntentUriPath(1, paramMap);
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(paramMap));
    localIntent.addFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void startToDownloadManager(Context paramContext, ArrayList<TMAssistantCallYYBParamStruct> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    String str = super.formatIntentUriPath(6, buildBatchDownloadParam(paramContext, paramArrayList));
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse(str));
    localIntent.putExtra(TMAssistantCallYYBParamStruct.SOURCE_KEY, ((TMAssistantCallYYBParamStruct)paramArrayList.get(0)).source);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
  
  private void startToWebViewNewAPI(Map<String, String> paramMap, OuterCallReportModel paramOuterCallReportModel)
  {
    paramMap = super.formatIntentUriPath(5, setupParamMap(null, paramOuterCallReportModel, paramMap));
    paramOuterCallReportModel = new Intent("android.intent.action.VIEW");
    paramOuterCallReportModel.setData(Uri.parse(paramMap));
    paramOuterCallReportModel.addFlags(268435456);
    this.mContext.startActivity(paramOuterCallReportModel);
  }
  
  public void addBatchOperationTmast(Context paramContext, ArrayList<TMAssistantCallYYBParamStruct> paramArrayList)
  {
    paramContext = formatIntentUriPath(6, buildBatchDownloadParam(paramContext, paramArrayList), false);
    paramArrayList = new Bundle();
    paramArrayList.putString("url", paramContext);
    addDownloadTaskFromTmast(paramArrayList);
  }
  
  public long addBatchUpdateOperationToDB(ArrayList<TMAssistantCallYYBParamStruct> paramArrayList, boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool;
    Object localObject2;
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      bool = true;
      paramInt = getBatchRequestType(bool, paramInt);
      localObject2 = new StringBuilder().append("appList = ");
      if (paramArrayList != null) {
        break label162;
      }
    }
    label162:
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramArrayList.size()))
    {
      ab.c("TMAssistantCallYYB_V2", localObject1 + ",isNeedSwitchView = " + paramBoolean + ",via = " + paramString1 + ",uin = " + paramString2 + ",uinType = " + paramString3);
      if ((paramInt == 3) || (bool)) {
        break label174;
      }
      localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TMAssistantCallYYBParamStruct)((Iterator)localObject1).next();
        if (localObject2 != null) {
          addToTaskList((TMAssistantCallYYBParamStruct)localObject2);
        }
      }
      bool = false;
      break;
    }
    label174:
    paramArrayList = com.tencent.tmassistantsdk.internal.openSDK.d.b(paramInt, paramArrayList, paramString1, paramString2, paramString3);
    if (paramArrayList != null)
    {
      paramArrayList = com.tencent.tmassistantsdk.internal.openSDK.d.a(paramArrayList, "");
      if (paramArrayList == null) {}
    }
    for (long l = buildAddDBData(paramArrayList);; l = -1L)
    {
      ab.c("TMAssistantCallYYB_V2", "result = " + l);
      return l;
    }
  }
  
  public long addDownloadTaskFromAppDetail(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    ab.c("TMAssistantCallYYB_V2", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    addToTaskList(paramTMAssistantCallYYBParamStruct);
    String str = UUID.randomUUID().toString();
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramTMAssistantCallYYBParamStruct.actionFlag, null, 2, str);
    ab.c("TMAssistantCallYYB_V2", "result = " + l);
    paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), str, "V2_addDownloadTaskFromAppDetail");
    com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramTMAssistantCallYYBParamStruct);
    return l;
  }
  
  public long addDownloadTaskFromAuthorize(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    ab.c("TMAssistantCallYYB_V2", "param = " + paramTMAssistantCallYYBParamStruct + ",verifyType = " + paramString);
    String str = UUID.randomUUID().toString();
    addToTaskList(paramTMAssistantCallYYBParamStruct);
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, true, true, paramTMAssistantCallYYBParamStruct.actionFlag, paramString, 3, str);
    ab.c("TMAssistantCallYYB_V2", "result = " + l);
    paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), str, "V2_addDownloadTaskFromAuthorize");
    com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramTMAssistantCallYYBParamStruct);
    return l;
  }
  
  public long addDownloadTaskFromTaskList(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    ab.c("TMAssistantCallYYB_V2", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2);
    addToTaskList(paramTMAssistantCallYYBParamStruct);
    String str = UUID.randomUUID().toString();
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramTMAssistantCallYYBParamStruct.actionFlag, null, 1, str);
    ab.c("TMAssistantCallYYB_V2", "result = " + l);
    paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), str, "V2_addDownloadTaskFromTaskList");
    com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramTMAssistantCallYYBParamStruct);
    return l;
  }
  
  public void destroyQQDownloaderOpenSDK()
  {
    ab.c("TMAssistantCallYYB_V2", "mContext = " + this.mContext);
    e.a().b();
    if (this.mContext != null)
    {
      com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).b();
      QQDownloaderInstalled.a().b();
      QQDownloaderInstalled.a().b(this.mContext);
    }
    GlobalUtil.getInstance().destroy();
    this.mContext = null;
  }
  
  public ArrayList<TMAssistantCallYYBTaskInfo> getBatchTaskState(ArrayList<TMAssistantCallYYBParamStruct> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if (this.mContext == null)
    {
      ab.e("TMAssistantCallYYB_V2", "context is null");
      throw new Exception("mContext shouldn't be null !");
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      ab.e("TMAssistantCallYYB_V2", "appList is null");
      throw new Exception("ArrayList<TMQQDownloaderOpenSDKParam> appList cann't be null or empty!");
    }
    ab.c("TMAssistantCallYYB_V2", "appList = " + paramArrayList.size() + ",via = " + paramString1 + ",uin = " + paramString2 + ",uinType = " + paramString3);
    int i = getQQDownloadApiLevel(this.mContext);
    if (i <= 1)
    {
      ab.c("TMAssistantCallYYB_V2", "result = null");
      return null;
    }
    if (i < 4)
    {
      paramArrayList = com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a((TMAssistantCallYYBParamStruct)paramArrayList.get(0));
      if (paramArrayList != null)
      {
        paramString1 = new ArrayList();
        paramString1.add(paramArrayList);
        ab.c("TMAssistantCallYYB_V2", "result = " + paramString1.size());
        return paramString1;
      }
      ab.c("TMAssistantCallYYB_V2", "result = null");
      return null;
    }
    paramString1 = com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramArrayList, paramString1, paramString2, paramString3);
    paramString2 = new StringBuilder().append("result = ");
    if (paramString1 == null) {}
    for (paramArrayList = "null";; paramArrayList = Integer.valueOf(paramString1.size()))
    {
      ab.c("TMAssistantCallYYB_V2", paramArrayList);
      return paramString1;
    }
  }
  
  public TMAssistantCallYYBTaskInfo getDownloadTaskState(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    if (this.mContext == null)
    {
      ab.e("TMAssistantCallYYB_V2", "context is null");
      throw new Exception("Context shouldn't be null !");
    }
    if (paramTMAssistantCallYYBParamStruct == null)
    {
      ab.e("TMAssistantCallYYB_V2", "param is null");
      throw new Exception("TMQQDownloaderOpenSDKParam param cann't is null!");
    }
    ab.c("TMAssistantCallYYB_V2", "param = " + paramTMAssistantCallYYBParamStruct);
    paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramTMAssistantCallYYBParamStruct);
    ab.c("TMAssistantCallYYB_V2", "result = " + paramTMAssistantCallYYBParamStruct);
    return paramTMAssistantCallYYBParamStruct;
  }
  
  public IInterface getIPCInterface()
  {
    if (getOpenSDKClient() != null) {
      try
      {
        IInterface localIInterface = getOpenSDKClient().getServiceInterface();
        return localIInterface;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public com.tencent.tmassistantsdk.internal.b.b getOpenSDKClient()
  {
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext != null) {
      return com.tencent.tmassistantsdk.internal.openSDK.d.a(localContext).b(localContext);
    }
    return null;
  }
  
  public void initTMAssistantCallYYBApi(Context paramContext)
  {
    ab.c("TMAssistantCallYYB_V2", "context = " + paramContext);
    this.mContext = paramContext;
    this.hostPackageName = paramContext.getPackageName();
    this.hostVersionCode = GlobalUtil.getAppVersionCode(this.mContext);
    GlobalUtil.getInstance().setContext(this.mContext);
    this.sdkAPILevel = 2;
    if (this.mContext != null)
    {
      ab.c("TMAssistantCallYYB_V2", "init processor....... ");
      com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(this);
      QQDownloaderInstalled.a().a(this.mContext);
      QQDownloaderInstalled.a().a(this);
    }
    NetworkMonitorReceiver.getInstance().registerReceiver();
    e.a();
  }
  
  public void onDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2)
  {
    if (paramTMAssistantCallYYBParamStruct != null) {
      onProgressChanged(paramTMAssistantCallYYBParamStruct, paramLong1, paramLong2);
    }
  }
  
  public void onDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString)
  {
    ab.c("TMAssistantCallYYB_V2", "param = " + paramTMAssistantCallYYBParamStruct + ",state = " + paramInt1 + ",errorCode = " + paramInt2 + ",errorMsg = " + paramString);
    if (paramTMAssistantCallYYBParamStruct != null) {
      onStateChanged(paramTMAssistantCallYYBParamStruct, paramInt1, paramInt2, paramString);
    }
  }
  
  /* Error */
  public void onQQDownloaderInstalled(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 12
    //   4: ldc_w 594
    //   7: invokestatic 54	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield 27	com/tencent/tmassistantsdk/TMAssistantCallYYB_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   14: ifnull +65 -> 79
    //   17: aload_0
    //   18: getfield 27	com/tencent/tmassistantsdk/TMAssistantCallYYB_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   21: invokevirtual 58	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   24: astore_1
    //   25: aload_1
    //   26: invokeinterface 64 1 0
    //   31: ifeq +48 -> 79
    //   34: aload_1
    //   35: invokeinterface 68 1 0
    //   40: checkcast 70	com/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull -20 -> 25
    //   48: aload_0
    //   49: aload_2
    //   50: invokevirtual 596	com/tencent/tmassistantsdk/TMAssistantCallYYB_V2:getDownloadTaskState	(Lcom/tencent/tmassistantsdk/TMAssistantCallYYBParamStruct;)Lcom/tencent/tmassistantsdk/TMAssistantCallYYBTaskInfo;
    //   53: pop
    //   54: aload_0
    //   55: getfield 27	com/tencent/tmassistantsdk/TMAssistantCallYYB_V2:mTaskList	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   58: aload_2
    //   59: invokevirtual 599	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   62: pop
    //   63: goto -38 -> 25
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: astore_3
    //   72: aload_3
    //   73: invokevirtual 337	java/lang/Exception:printStackTrace	()V
    //   76: goto -22 -> 54
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	TMAssistantCallYYB_V2
    //   0	82	1	paramContext	Context
    //   43	16	2	localTMAssistantCallYYBParamStruct	TMAssistantCallYYBParamStruct
    //   71	2	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	25	66	finally
    //   25	44	66	finally
    //   48	54	66	finally
    //   54	63	66	finally
    //   72	76	66	finally
    //   48	54	71	java/lang/Exception
  }
  
  public void onQQDownloaderInvalid()
  {
    ab.c("TMAssistantCallYYB_V2", "onQQDownloaderInvalid");
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMAssistantCallBackListener localITMAssistantCallBackListener = (ITMAssistantCallBackListener)((WeakReference)localIterator.next()).get();
      if (localITMAssistantCallBackListener == null) {
        ab.c("TMAssistantCallYYB_V2", "onQQDownloaderInvalid listener = null");
      } else {
        localITMAssistantCallBackListener.onQQDownloaderInvalid();
      }
    }
  }
  
  public void onServiceFree()
  {
    ab.c("TMAssistantCallYYB_V2", "onServiceFree start");
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMAssistantCallBackListener localITMAssistantCallBackListener = (ITMAssistantCallBackListener)((WeakReference)localIterator.next()).get();
      if (localITMAssistantCallBackListener == null) {
        ab.c("TMAssistantCallYYB_V2", "onQQDownloaderInvalid listener = null");
      } else {
        localITMAssistantCallBackListener.onServiceFree();
      }
    }
  }
  
  public void releaseIPCConnected()
  {
    ab.c("TMAssistantCallYYB_V2", "mContext = " + this.mContext);
    if (this.mContext != null) {
      com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).c();
    }
  }
  
  public int startBatchOperation(Context paramContext, ArrayList<TMAssistantCallYYBParamStruct> paramArrayList, int paramInt, String paramString)
  {
    if (paramContext == null)
    {
      ab.e("TMAssistantCallYYB_V2", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    ab.c("TMAssistantCallYYB_V2", "context = " + paramContext + ",appList = " + paramArrayList + ",operation = " + paramInt + ",via = " + paramString);
    int i = getQQDownloadApiLevel(paramContext);
    if (i <= 0)
    {
      ab.c("TMAssistantCallYYB_V2", "TMAssistantDownloadTaskState.UN_INSTALLED,auto write tmast cmd");
      addBatchOperationTmast(paramContext, paramArrayList);
      return 1;
    }
    if (i < 9)
    {
      ab.c("TMAssistantCallYYB_V2", "TMAssistantDownloadTaskState.LOWWER_VERSION_INSTALLED");
      return 2;
    }
    paramInt = getBatchOperateType(paramInt);
    if (paramInt == 7) {
      startToDownloadManager(paramContext, paramArrayList);
    }
    if (!com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramInt, paramArrayList, paramString, "", "")) {
      ab.d("TMAssistantCallYYB_V2", "handleBatchRequestAction return false with batchRequestType=" + paramInt);
    }
    ab.c("TMAssistantCallYYB_V2", "TMAssistantDownloadTaskState.ALREADY_INSTALLED");
    return 0;
  }
  
  public void startToAppDetail(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (getQQDownloadApiLevel(paramContext) >= 6) {
      paramTMAssistantCallYYBParamStruct.timePointMap.put("OuterCall_TMAssistantCallYYB_V2_StartToAppDetail", Long.valueOf(System.currentTimeMillis()));
    }
    if (paramContext == null)
    {
      ab.e("TMAssistantCallYYB_V2", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    ab.c("TMAssistantCallYYB_V2", "context = " + paramContext + ",param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2 + ",operation = " + paramInt);
    String str;
    OuterCallReportModel localOuterCallReportModel;
    if (paramTMAssistantCallYYBParamStruct != null)
    {
      str = super.formatOplist(paramBoolean1, paramBoolean2);
      if (1 != paramInt) {
        break label240;
      }
      paramInt = 1;
      if ((getQQDownloadApiLevel(paramContext) < 6) || (paramInt != 1)) {
        break label252;
      }
      Map localMap = super.formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, "");
      if (!OuterCallReportModel.isYYBSupportOutcallReport()) {
        break label246;
      }
      localOuterCallReportModel = setupOuterCallModel(paramTMAssistantCallYYBParamStruct);
      SDKReportManager2.getInstance().postReport(15, localOuterCallReportModel.toString());
      label192:
      startToAppDetailNewAPI(paramContext, paramTMAssistantCallYYBParamStruct, localOuterCallReportModel, localMap);
      paramTMAssistantCallYYBParamStruct.outerCallReportData = localOuterCallReportModel.getJsonData();
    }
    for (;;)
    {
      addToTaskListHead(paramTMAssistantCallYYBParamStruct);
      com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramTMAssistantCallYYBParamStruct, paramInt, str, paramTMAssistantCallYYBParamStruct.actionFlag, null, localOuterCallReportModel);
      return;
      label240:
      paramInt = 4;
      break;
      label246:
      localOuterCallReportModel = null;
      break label192;
      label252:
      localOuterCallReportModel = null;
    }
  }
  
  public void startToAuthorized(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    if (paramContext == null)
    {
      ab.e("TMAssistantCallYYB_V2", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMAssistantCallYYBParamStruct == null)
    {
      ab.e("TMAssistantCallYYB_V2", "param is null");
      throw new Exception("QQDownloaderParam param cann't be null!");
    }
    ab.c("TMAssistantCallYYB_V2", "context = " + paramContext + ",param = " + paramTMAssistantCallYYBParamStruct + ",verifyType = " + paramString);
    if (paramTMAssistantCallYYBParamStruct != null)
    {
      addToTaskList(paramTMAssistantCallYYBParamStruct);
      paramContext = super.formatOplist(true, true);
      com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramTMAssistantCallYYBParamStruct, 3, paramContext, paramTMAssistantCallYYBParamStruct.actionFlag, paramString, null);
    }
  }
  
  public void startToAuthorized(Context paramContext, String paramString)
  {
    ab.c("TMAssistantCallYYB_V2", "context = " + paramContext + ",jumpUrl = " + paramString);
    paramContext = super.formatEncryptUrl(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null)) {
      com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramContext);
    }
  }
  
  public int startToBatchUpdateOperation(Context paramContext, ArrayList<TMAssistantCallYYBParamStruct> paramArrayList, boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if (paramContext == null)
    {
      ab.e("TMAssistantCallYYB_V2", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    ab.c("TMAssistantCallYYB_V2", "context = " + paramContext + ",appList = " + paramArrayList + ",isNeedSwitchView = " + paramBoolean + ",operation = " + paramInt + ",via = " + paramString1 + ",uin = " + paramString2 + ",uinType = " + paramString3);
    int i = getQQDownloadApiLevel(paramContext);
    if (i <= 0)
    {
      ab.c("TMAssistantCallYYB_V2", "TMAssistantDownloadTaskState.UN_INSTALLED");
      return 1;
    }
    if (i < 4)
    {
      ab.c("TMAssistantCallYYB_V2", "TMAssistantDownloadTaskState.LOWWER_VERSION_INSTALLED");
      return 2;
    }
    paramBoolean = bool;
    if (paramArrayList != null) {
      if (paramArrayList.size() != 0) {
        break label235;
      }
    }
    label235:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramInt = getBatchRequestType(paramBoolean, paramInt);
      if (!com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramInt, paramArrayList, paramString1, paramString2, paramString3)) {
        ab.d("TMAssistantCallYYB_V2", "handleBatchRequestAction return false with batchRequestType=" + paramInt);
      }
      ab.c("TMAssistantCallYYB_V2", "TMAssistantDownloadTaskState.ALREADY_INSTALLED");
      return 0;
    }
  }
  
  public void startToDownloadTaskList(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (getQQDownloadApiLevel(paramContext) >= 6) {
      paramTMAssistantCallYYBParamStruct.timePointMap.put("OuterCall_TMAssistantCallYYB_V2_StartToDownloadList", Long.valueOf(System.currentTimeMillis()));
    }
    if (paramContext == null)
    {
      ab.e("TMAssistantCallYYB_V2", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    if (paramTMAssistantCallYYBParamStruct == null) {
      ab.e("TMAssistantCallYYB_V2", "param is null");
    }
    do
    {
      return;
      ab.c("TMAssistantCallYYB_V2", "param = " + paramTMAssistantCallYYBParamStruct + ",isAutoDownload = " + paramBoolean1 + ",isAutoInstall = " + paramBoolean2 + ",operation = " + paramInt);
    } while (paramTMAssistantCallYYBParamStruct == null);
    String str = super.formatOplist(paramBoolean1, paramBoolean2);
    OuterCallReportModel localOuterCallReportModel;
    if (1 == paramInt)
    {
      paramInt = 2;
      if ((getQQDownloadApiLevel(paramContext) < 6) || (paramInt != 2)) {
        break label249;
      }
      Map localMap = super.formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, "");
      if (!OuterCallReportModel.isYYBSupportOutcallReport()) {
        break label243;
      }
      localOuterCallReportModel = setupOuterCallModel(paramTMAssistantCallYYBParamStruct);
      SDKReportManager2.getInstance().postReport(15, localOuterCallReportModel.toString());
      label194:
      startToDownloadListNewAPI(paramContext, setupParamMap(paramTMAssistantCallYYBParamStruct, localOuterCallReportModel, localMap));
    }
    for (;;)
    {
      addToTaskListHead(paramTMAssistantCallYYBParamStruct);
      com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramTMAssistantCallYYBParamStruct, paramInt, str, paramTMAssistantCallYYBParamStruct.actionFlag, null, localOuterCallReportModel);
      return;
      paramInt = 5;
      break;
      label243:
      localOuterCallReportModel = null;
      break label194;
      label249:
      localOuterCallReportModel = null;
    }
  }
  
  public void startToWebView(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      ab.e("TMAssistantCallYYB_V2", "context is null");
      throw new Exception("you must input an application or activity context!");
    }
    if (TextUtils.isEmpty(paramString))
    {
      ab.e("TMAssistantCallYYB_V2", "url is null");
      throw new Exception("param url shouldn't be null!");
    }
    ab.c("TMAssistantCallYYB_V2", "context = " + paramContext + ",url = " + paramString);
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", paramString);
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null))
    {
      if (getQQDownloadApiLevel(paramContext) >= 6)
      {
        paramContext = null;
        if (OuterCallReportModel.isYYBSupportOutcallReport())
        {
          paramContext = setupOuterCallModel(paramString);
          SDKReportManager2.getInstance().postReport(15, paramContext.toString());
        }
        startToWebViewNewAPI(localHashMap, paramContext);
      }
    }
    else {
      return;
    }
    paramContext = super.formatIntentUriPath(5, localHashMap);
    com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.TMAssistantCallYYB_V2
 * JD-Core Version:    0.7.0.1
 */