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
  protected static TMAssistantCallYYB_V2 mInstance;
  protected CopyOnWriteArrayList<TMAssistantCallYYBParamStruct> mTaskList = null;
  
  private void addToTaskList(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("param = ");
      ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct);
      ab.c("TMAssistantCallYYB_V2", ((StringBuilder)localObject).toString());
      if ((paramTMAssistantCallYYBParamStruct == null) || (this.mTaskList == null)) {
        break label182;
      }
      localObject = this.mTaskList.iterator();
      int j;
      TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct;
      do
      {
        for (;;)
        {
          boolean bool = ((Iterator)localObject).hasNext();
          j = 1;
          if (!bool) {
            break label196;
          }
          localTMAssistantCallYYBParamStruct = (TMAssistantCallYYBParamStruct)((Iterator)localObject).next();
          if (localTMAssistantCallYYBParamStruct.taskAppId == null) {
            break;
          }
          if (localTMAssistantCallYYBParamStruct.taskAppId.equals(paramTMAssistantCallYYBParamStruct.taskAppId))
          {
            i = j;
            if (localTMAssistantCallYYBParamStruct.taskPackageName == null) {
              break label169;
            }
            i = j;
            if (localTMAssistantCallYYBParamStruct.taskPackageName.equals(paramTMAssistantCallYYBParamStruct.taskPackageName)) {
              break label169;
            }
          }
        }
      } while ((localTMAssistantCallYYBParamStruct.taskPackageName == null) || (localTMAssistantCallYYBParamStruct.taskPackageName.equals(paramTMAssistantCallYYBParamStruct.taskPackageName) != true));
      i = j;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          label169:
          label182:
          throw paramTMAssistantCallYYBParamStruct;
        }
        label196:
        int i = 0;
      }
    }
    if (i == 0) {
      this.mTaskList.add(paramTMAssistantCallYYBParamStruct);
    }
  }
  
  private void addToTaskListHead(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("param = ");
      ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct);
      ab.c("TMAssistantCallYYB_V2", ((StringBuilder)localObject).toString());
      if ((paramTMAssistantCallYYBParamStruct == null) || (this.mTaskList == null)) {
        break label182;
      }
      localObject = this.mTaskList.iterator();
      int j;
      TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct;
      do
      {
        for (;;)
        {
          boolean bool = ((Iterator)localObject).hasNext();
          j = 1;
          if (!bool) {
            break label196;
          }
          localTMAssistantCallYYBParamStruct = (TMAssistantCallYYBParamStruct)((Iterator)localObject).next();
          if (localTMAssistantCallYYBParamStruct.taskAppId == null) {
            break;
          }
          if (localTMAssistantCallYYBParamStruct.taskAppId.equals(paramTMAssistantCallYYBParamStruct.taskAppId))
          {
            i = j;
            if (localTMAssistantCallYYBParamStruct.taskPackageName == null) {
              break label169;
            }
            i = j;
            if (localTMAssistantCallYYBParamStruct.taskPackageName.equals(paramTMAssistantCallYYBParamStruct.taskPackageName)) {
              break label169;
            }
          }
        }
      } while ((localTMAssistantCallYYBParamStruct.taskPackageName == null) || (localTMAssistantCallYYBParamStruct.taskPackageName.equals(paramTMAssistantCallYYBParamStruct.taskPackageName) != true));
      i = j;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          label169:
          label182:
          throw paramTMAssistantCallYYBParamStruct;
        }
        label196:
        int i = 0;
      }
    }
    if (i == 0) {
      this.mTaskList.add(0, paramTMAssistantCallYYBParamStruct);
    }
  }
  
  private Map<String, String> buildBatchDownloadParam(Context paramContext, ArrayList<TMAssistantCallYYBParamStruct> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = (TMAssistantCallYYBParamStruct)paramArrayList.next();
      if (localTMAssistantCallYYBParamStruct != null)
      {
        Object localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("pkgName", localTMAssistantCallYYBParamStruct.taskPackageName);
          ((JSONObject)localObject).put("versionCode", localTMAssistantCallYYBParamStruct.taskVersion);
          ((JSONObject)localObject).put("yybChannelId", localTMAssistantCallYYBParamStruct.channelId);
          ((JSONObject)localObject).put("recommendId", localTMAssistantCallYYBParamStruct.recommendId);
          ((JSONObject)localObject).put("via", localTMAssistantCallYYBParamStruct.via);
          localJSONArray.put(localObject);
        }
        catch (JSONException localJSONException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(localJSONException.getMessage());
          ((StringBuilder)localObject).append("|");
          ((StringBuilder)localObject).append(localJSONException.getCause());
          ab.e("TMAssistantCallYYB_V2", ((StringBuilder)localObject).toString());
        }
      }
    }
    try
    {
      localJSONObject.put("appList", localJSONArray);
      localJSONObject.put("hostPackageName", GlobalUtil.getAppPackageName(paramContext));
      localJSONObject.put("hostVersionCode", GlobalUtil.getAppVersionCode(paramContext));
    }
    catch (JSONException paramContext)
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("");
      paramArrayList.append(paramContext.getMessage());
      paramArrayList.append("|");
      paramArrayList.append(paramContext.getCause());
      ab.e("TMAssistantCallYYB_V2", paramArrayList.toString());
    }
    localHashMap.put("out_batch_download", localJSONObject.toString());
    return localHashMap;
  }
  
  private int getBatchOperateType(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3) {
        paramInt = 0;
      } else {
        paramInt = 7;
      }
    }
    else {
      paramInt = 8;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">getBatchOperateType = ");
    localStringBuilder.append(paramInt);
    ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
    return paramInt;
  }
  
  private int getBatchRequestType(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isUpdateAll = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",operation = ");
    localStringBuilder.append(paramInt);
    ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
    int i = 1;
    if (paramBoolean)
    {
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          break label126;
        }
        if (paramInt != 2)
        {
          if (paramInt == 3)
          {
            i = 5;
            break label126;
          }
        }
        else
        {
          i = 6;
          break label126;
        }
      }
    }
    else
    {
      if ((paramInt == 0) || (paramInt == 1)) {
        break label124;
      }
      if (paramInt == 2) {
        break label118;
      }
      if (paramInt == 3) {
        break label112;
      }
    }
    i = 2;
    break label126;
    label112:
    i = 7;
    break label126;
    label118:
    i = 8;
    break label126;
    label124:
    i = 4;
    label126:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchRequestType = ");
    localStringBuilder.append(i);
    ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
    return i;
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
        if (paramTMAssistantCallYYBParamStruct != null)
        {
          paramMap = new StringBuilder();
          paramMap.append(paramOuterCallReportModel.mHostPname);
          paramMap.append("|");
          paramMap.append(paramTMAssistantCallYYBParamStruct.via);
          paramMap.append("|");
          paramMap.append(paramOuterCallReportModel.mOuterCallTime);
          localHashMap.put("beaconId", paramMap.toString());
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
    paramTMAssistantCallYYBParamStruct = new StringBuilder();
    paramTMAssistantCallYYBParamStruct.append("YYB版本符合要求，执行tmast ：");
    paramTMAssistantCallYYBParamStruct.append(paramOuterCallReportModel);
    ab.c("TMAssistantCallYYB_V2", paramTMAssistantCallYYBParamStruct.toString());
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
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return;
      }
      String str = super.formatIntentUriPath(6, buildBatchDownloadParam(paramContext, paramArrayList));
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse(str));
      localIntent.putExtra(TMAssistantCallYYBParamStruct.SOURCE_KEY, ((TMAssistantCallYYBParamStruct)paramArrayList.get(0)).source);
      localIntent.addFlags(268435456);
      paramContext.startActivity(localIntent);
    }
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
    if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    paramInt = getBatchRequestType(bool, paramInt);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("appList = ");
    Object localObject1;
    if (paramArrayList == null) {
      localObject1 = "null";
    } else {
      localObject1 = Integer.valueOf(paramArrayList.size());
    }
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(",isNeedSwitchView = ");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(",via = ");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(",uin = ");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(",uinType = ");
    ((StringBuilder)localObject2).append(paramString3);
    ab.c("TMAssistantCallYYB_V2", ((StringBuilder)localObject2).toString());
    if ((paramInt != 3) && (!bool))
    {
      localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TMAssistantCallYYBParamStruct)((Iterator)localObject1).next();
        if (localObject2 != null) {
          addToTaskList((TMAssistantCallYYBParamStruct)localObject2);
        }
      }
    }
    paramArrayList = com.tencent.tmassistantsdk.internal.openSDK.d.b(paramInt, paramArrayList, paramString1, paramString2, paramString3);
    if (paramArrayList != null)
    {
      paramArrayList = com.tencent.tmassistantsdk.internal.openSDK.d.a(paramArrayList, "");
      if (paramArrayList != null)
      {
        l = buildAddDBData(paramArrayList);
        break label249;
      }
    }
    long l = -1L;
    label249:
    paramArrayList = new StringBuilder();
    paramArrayList.append("result = ");
    paramArrayList.append(l);
    ab.c("TMAssistantCallYYB_V2", paramArrayList.toString());
    return l;
  }
  
  public long addDownloadTaskFromAppDetail(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("param = ");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct);
    ((StringBuilder)localObject).append(",isAutoDownload = ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(",isAutoInstall = ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ab.c("TMAssistantCallYYB_V2", ((StringBuilder)localObject).toString());
    addToTaskList(paramTMAssistantCallYYBParamStruct);
    localObject = UUID.randomUUID().toString();
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramTMAssistantCallYYBParamStruct.actionFlag, null, 2, (String)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result = ");
    localStringBuilder.append(l);
    ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
    paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), (String)localObject, "V2_addDownloadTaskFromAppDetail");
    com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramTMAssistantCallYYBParamStruct);
    return l;
  }
  
  public long addDownloadTaskFromAuthorize(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("param = ");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct);
    ((StringBuilder)localObject).append(",verifyType = ");
    ((StringBuilder)localObject).append(paramString);
    ab.c("TMAssistantCallYYB_V2", ((StringBuilder)localObject).toString());
    localObject = UUID.randomUUID().toString();
    addToTaskList(paramTMAssistantCallYYBParamStruct);
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, true, true, paramTMAssistantCallYYBParamStruct.actionFlag, paramString, 3, (String)localObject);
    paramString = new StringBuilder();
    paramString.append("result = ");
    paramString.append(l);
    ab.c("TMAssistantCallYYB_V2", paramString.toString());
    paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), (String)localObject, "V2_addDownloadTaskFromAuthorize");
    com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramTMAssistantCallYYBParamStruct);
    return l;
  }
  
  public long addDownloadTaskFromTaskList(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("param = ");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct);
    ((StringBuilder)localObject).append(",isAutoDownload = ");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(",isAutoInstall = ");
    ((StringBuilder)localObject).append(paramBoolean2);
    ab.c("TMAssistantCallYYB_V2", ((StringBuilder)localObject).toString());
    addToTaskList(paramTMAssistantCallYYBParamStruct);
    localObject = UUID.randomUUID().toString();
    long l = super.buildAddDBData(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, paramTMAssistantCallYYBParamStruct.actionFlag, null, 1, (String)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result = ");
    localStringBuilder.append(l);
    ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
    paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), (String)localObject, "V2_addDownloadTaskFromTaskList");
    com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramTMAssistantCallYYBParamStruct);
    return l;
  }
  
  public void destroyQQDownloaderOpenSDK()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mContext = ");
    localStringBuilder.append(this.mContext);
    ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
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
    if (this.mContext != null)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("appList = ");
        localStringBuilder.append(paramArrayList.size());
        localStringBuilder.append(",via = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(",uin = ");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(",uinType = ");
        localStringBuilder.append(paramString3);
        ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
        int i = getQQDownloadApiLevel(this.mContext);
        if (i <= 1)
        {
          ab.c("TMAssistantCallYYB_V2", "result = null");
          return null;
        }
        if (i < 4)
        {
          paramString1 = com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a((TMAssistantCallYYBParamStruct)paramArrayList.get(0));
          if (paramString1 != null)
          {
            paramArrayList = new ArrayList();
            paramArrayList.add(paramString1);
            paramString1 = new StringBuilder();
            paramString1.append("result = ");
            paramString1.append(paramArrayList.size());
            ab.c("TMAssistantCallYYB_V2", paramString1.toString());
            return paramArrayList;
          }
          ab.c("TMAssistantCallYYB_V2", "result = null");
          return null;
        }
        paramString1 = com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramArrayList, paramString1, paramString2, paramString3);
        paramString2 = new StringBuilder();
        paramString2.append("result = ");
        if (paramString1 == null) {
          paramArrayList = "null";
        } else {
          paramArrayList = Integer.valueOf(paramString1.size());
        }
        paramString2.append(paramArrayList);
        ab.c("TMAssistantCallYYB_V2", paramString2.toString());
        return paramString1;
      }
      ab.e("TMAssistantCallYYB_V2", "appList is null");
      throw new Exception("ArrayList<TMQQDownloaderOpenSDKParam> appList cann't be null or empty!");
    }
    ab.e("TMAssistantCallYYB_V2", "context is null");
    throw new Exception("mContext shouldn't be null !");
  }
  
  public TMAssistantCallYYBTaskInfo getDownloadTaskState(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    if (this.mContext != null)
    {
      if (paramTMAssistantCallYYBParamStruct != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("param = ");
        localStringBuilder.append(paramTMAssistantCallYYBParamStruct);
        ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
        paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramTMAssistantCallYYBParamStruct);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("result = ");
        localStringBuilder.append(paramTMAssistantCallYYBParamStruct);
        ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
        return paramTMAssistantCallYYBParamStruct;
      }
      ab.e("TMAssistantCallYYB_V2", "param is null");
      throw new Exception("TMQQDownloaderOpenSDKParam param cann't is null!");
    }
    ab.e("TMAssistantCallYYB_V2", "context is null");
    throw new Exception("Context shouldn't be null !");
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("context = ");
    localStringBuilder.append(paramContext);
    ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("param = ");
    localStringBuilder.append(paramTMAssistantCallYYBParamStruct);
    localStringBuilder.append(",state = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",errorCode = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",errorMsg = ");
    localStringBuilder.append(paramString);
    ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
    if (paramTMAssistantCallYYBParamStruct != null) {
      onStateChanged(paramTMAssistantCallYYBParamStruct, paramInt1, paramInt2, paramString);
    }
  }
  
  public void onQQDownloaderInstalled(Context paramContext)
  {
    try
    {
      ab.c("TMAssistantCallYYB_V2", "received qqdownload install broadcase!");
      if (this.mTaskList != null)
      {
        paramContext = this.mTaskList.iterator();
        while (paramContext.hasNext())
        {
          TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = (TMAssistantCallYYBParamStruct)paramContext.next();
          if (localTMAssistantCallYYBParamStruct != null)
          {
            try
            {
              getDownloadTaskState(localTMAssistantCallYYBParamStruct);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
            this.mTaskList.remove(localTMAssistantCallYYBParamStruct);
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mContext = ");
    localStringBuilder.append(this.mContext);
    ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
    if (this.mContext != null) {
      com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).c();
    }
  }
  
  public int startBatchOperation(Context paramContext, ArrayList<TMAssistantCallYYBParamStruct> paramArrayList, int paramInt, String paramString)
  {
    if (paramContext != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("context = ");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(",appList = ");
      localStringBuilder.append(paramArrayList);
      localStringBuilder.append(",operation = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",via = ");
      localStringBuilder.append(paramString);
      ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
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
      if (!com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramInt, paramArrayList, paramString, "", ""))
      {
        paramContext = new StringBuilder();
        paramContext.append("handleBatchRequestAction return false with batchRequestType=");
        paramContext.append(paramInt);
        ab.d("TMAssistantCallYYB_V2", paramContext.toString());
      }
      ab.c("TMAssistantCallYYB_V2", "TMAssistantDownloadTaskState.ALREADY_INSTALLED");
      return 0;
    }
    ab.e("TMAssistantCallYYB_V2", "context is null");
    throw new Exception("you must input an application or activity context!");
  }
  
  public void startToAppDetail(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (getQQDownloadApiLevel(paramContext) >= 6) {
      paramTMAssistantCallYYBParamStruct.timePointMap.put("OuterCall_TMAssistantCallYYB_V2_StartToAppDetail", Long.valueOf(System.currentTimeMillis()));
    }
    if (paramContext != null)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("context = ");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(",param = ");
      ((StringBuilder)localObject1).append(paramTMAssistantCallYYBParamStruct);
      ((StringBuilder)localObject1).append(",isAutoDownload = ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(",isAutoInstall = ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append(",operation = ");
      ((StringBuilder)localObject1).append(paramInt);
      ab.c("TMAssistantCallYYB_V2", ((StringBuilder)localObject1).toString());
      if (paramTMAssistantCallYYBParamStruct != null)
      {
        String str = super.formatOplist(paramBoolean1, paramBoolean2);
        if (1 == paramInt) {
          paramInt = 1;
        } else {
          paramInt = 4;
        }
        Map localMap = null;
        Object localObject2 = null;
        localObject1 = localMap;
        if (getQQDownloadApiLevel(paramContext) >= 6)
        {
          localObject1 = localMap;
          if (paramInt == 1)
          {
            localMap = super.formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, "");
            localObject1 = localObject2;
            if (OuterCallReportModel.isYYBSupportOutcallReport())
            {
              localObject1 = setupOuterCallModel(paramTMAssistantCallYYBParamStruct);
              SDKReportManager2.getInstance().postReport(15, ((OuterCallReportModel)localObject1).toString());
            }
            startToAppDetailNewAPI(paramContext, paramTMAssistantCallYYBParamStruct, (OuterCallReportModel)localObject1, localMap);
            paramTMAssistantCallYYBParamStruct.outerCallReportData = ((OuterCallReportModel)localObject1).getJsonData();
          }
        }
        addToTaskListHead(paramTMAssistantCallYYBParamStruct);
        com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramTMAssistantCallYYBParamStruct, paramInt, str, paramTMAssistantCallYYBParamStruct.actionFlag, null, (OuterCallReportModel)localObject1);
      }
      return;
    }
    ab.e("TMAssistantCallYYB_V2", "context is null");
    throw new Exception("you must input an application or activity context!");
  }
  
  public void startToAuthorized(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, String paramString)
  {
    if (paramContext != null)
    {
      if (paramTMAssistantCallYYBParamStruct != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("context = ");
        localStringBuilder.append(paramContext);
        localStringBuilder.append(",param = ");
        localStringBuilder.append(paramTMAssistantCallYYBParamStruct);
        localStringBuilder.append(",verifyType = ");
        localStringBuilder.append(paramString);
        ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
        if (paramTMAssistantCallYYBParamStruct != null)
        {
          addToTaskList(paramTMAssistantCallYYBParamStruct);
          paramContext = super.formatOplist(true, true);
          com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramTMAssistantCallYYBParamStruct, 3, paramContext, paramTMAssistantCallYYBParamStruct.actionFlag, paramString, null);
        }
        return;
      }
      ab.e("TMAssistantCallYYB_V2", "param is null");
      throw new Exception("QQDownloaderParam param cann't be null!");
    }
    ab.e("TMAssistantCallYYB_V2", "context is null");
    throw new Exception("you must input an application or activity context!");
  }
  
  public void startToAuthorized(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("context = ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append(",jumpUrl = ");
    localStringBuilder.append(paramString);
    ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
    paramContext = super.formatEncryptUrl(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (this.mContext != null)) {
      com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramContext);
    }
  }
  
  public int startToBatchUpdateOperation(Context paramContext, ArrayList<TMAssistantCallYYBParamStruct> paramArrayList, boolean paramBoolean, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramContext != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("context = ");
      localStringBuilder.append(paramContext);
      localStringBuilder.append(",appList = ");
      localStringBuilder.append(paramArrayList);
      localStringBuilder.append(",isNeedSwitchView = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",operation = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",via = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",uin = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",uinType = ");
      localStringBuilder.append(paramString3);
      ab.c("TMAssistantCallYYB_V2", localStringBuilder.toString());
      int i = getQQDownloadApiLevel(paramContext);
      boolean bool = true;
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
        if (paramArrayList.size() == 0) {
          paramBoolean = bool;
        } else {
          paramBoolean = false;
        }
      }
      paramInt = getBatchRequestType(paramBoolean, paramInt);
      if (!com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramInt, paramArrayList, paramString1, paramString2, paramString3))
      {
        paramContext = new StringBuilder();
        paramContext.append("handleBatchRequestAction return false with batchRequestType=");
        paramContext.append(paramInt);
        ab.d("TMAssistantCallYYB_V2", paramContext.toString());
      }
      ab.c("TMAssistantCallYYB_V2", "TMAssistantDownloadTaskState.ALREADY_INSTALLED");
      return 0;
    }
    ab.e("TMAssistantCallYYB_V2", "context is null");
    throw new Exception("you must input an application or activity context!");
  }
  
  public void startToDownloadTaskList(Context paramContext, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (getQQDownloadApiLevel(paramContext) >= 6) {
      paramTMAssistantCallYYBParamStruct.timePointMap.put("OuterCall_TMAssistantCallYYB_V2_StartToDownloadList", Long.valueOf(System.currentTimeMillis()));
    }
    if (paramContext != null)
    {
      if (paramTMAssistantCallYYBParamStruct == null)
      {
        ab.e("TMAssistantCallYYB_V2", "param is null");
        return;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("param = ");
      ((StringBuilder)localObject1).append(paramTMAssistantCallYYBParamStruct);
      ((StringBuilder)localObject1).append(",isAutoDownload = ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(",isAutoInstall = ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append(",operation = ");
      ((StringBuilder)localObject1).append(paramInt);
      ab.c("TMAssistantCallYYB_V2", ((StringBuilder)localObject1).toString());
      if (paramTMAssistantCallYYBParamStruct != null)
      {
        String str = super.formatOplist(paramBoolean1, paramBoolean2);
        if (1 == paramInt) {
          paramInt = 2;
        } else {
          paramInt = 5;
        }
        Map localMap = null;
        Object localObject2 = null;
        localObject1 = localMap;
        if (getQQDownloadApiLevel(paramContext) >= 6)
        {
          localObject1 = localMap;
          if (paramInt == 2)
          {
            localMap = super.formatMapParams(paramTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, "");
            localObject1 = localObject2;
            if (OuterCallReportModel.isYYBSupportOutcallReport())
            {
              localObject1 = setupOuterCallModel(paramTMAssistantCallYYBParamStruct);
              SDKReportManager2.getInstance().postReport(15, ((OuterCallReportModel)localObject1).toString());
            }
            startToDownloadListNewAPI(paramContext, setupParamMap(paramTMAssistantCallYYBParamStruct, (OuterCallReportModel)localObject1, localMap));
          }
        }
        addToTaskListHead(paramTMAssistantCallYYBParamStruct);
        com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramTMAssistantCallYYBParamStruct, paramInt, str, paramTMAssistantCallYYBParamStruct.actionFlag, null, (OuterCallReportModel)localObject1);
      }
      return;
    }
    ab.e("TMAssistantCallYYB_V2", "context is null");
    throw new Exception("you must input an application or activity context!");
  }
  
  public void startToWebView(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("context = ");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append(",url = ");
        ((StringBuilder)localObject).append(paramString);
        ab.c("TMAssistantCallYYB_V2", ((StringBuilder)localObject).toString());
        localObject = new HashMap();
        ((Map)localObject).put("url", paramString);
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
            startToWebViewNewAPI((Map)localObject, paramContext);
            return;
          }
          paramContext = super.formatIntentUriPath(5, (Map)localObject);
          com.tencent.tmassistantsdk.internal.openSDK.d.a(this.mContext).a(paramContext);
        }
        return;
      }
      ab.e("TMAssistantCallYYB_V2", "url is null");
      throw new Exception("param url shouldn't be null!");
    }
    ab.e("TMAssistantCallYYB_V2", "context is null");
    throw new Exception("you must input an application or activity context!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.TMAssistantCallYYB_V2
 * JD-Core Version:    0.7.0.1
 */