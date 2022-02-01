package com.tencent.tmassistantsdk.internal.openSDK;

import android.content.Context;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchDownloadActionResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.GetDownloadProgressResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.GetDownloadStateResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCBaseParam;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCDownloadParam;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCQueryDownloadInfo;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.OperateDownloadTaskRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.QueryDownloadTaskResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.URIActionRequest;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  implements com.tencent.tmassistantsdk.internal.b.a
{
  protected static d a;
  protected com.tencent.tmassistantsdk.internal.b.b b = null;
  protected ITMAssistantCallBackListener c = null;
  String d = UUID.randomUUID().toString();
  private Context e = null;
  
  public d() {}
  
  private d(Context paramContext)
  {
    if (paramContext != null) {
      b(paramContext);
    }
    this.e = paramContext;
  }
  
  private TMAssistantCallYYBParamStruct a(IPCBaseParam paramIPCBaseParam)
  {
    if (paramIPCBaseParam == null) {
      return null;
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = new TMAssistantCallYYBParamStruct();
    localTMAssistantCallYYBParamStruct.SNGAppId = paramIPCBaseParam.hostAppId;
    localTMAssistantCallYYBParamStruct.taskAppId = paramIPCBaseParam.taskAppId;
    localTMAssistantCallYYBParamStruct.taskPackageName = paramIPCBaseParam.taskPackageName;
    try
    {
      localTMAssistantCallYYBParamStruct.taskVersion = Integer.valueOf(paramIPCBaseParam.taskVersion).intValue();
    }
    catch (Exception localException)
    {
      label55:
      break label55;
    }
    ab.c("TMQQDownloaderDataProcessor", "baseParam2QQParam Integer.valueOf(baseParam.taskVersion) NumberFormatException occur");
    localTMAssistantCallYYBParamStruct.uin = paramIPCBaseParam.uin;
    localTMAssistantCallYYBParamStruct.uinType = paramIPCBaseParam.uinType;
    localTMAssistantCallYYBParamStruct.via = paramIPCBaseParam.via;
    localTMAssistantCallYYBParamStruct.channelId = paramIPCBaseParam.channelId;
    return localTMAssistantCallYYBParamStruct;
  }
  
  public static d a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new d(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private static IPCBaseParam a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, OuterCallReportModel paramOuterCallReportModel)
  {
    if (paramTMAssistantCallYYBParamStruct == null) {
      return null;
    }
    IPCBaseParam localIPCBaseParam = new IPCBaseParam();
    localIPCBaseParam.hostAppId = paramTMAssistantCallYYBParamStruct.SNGAppId;
    localIPCBaseParam.taskAppId = paramTMAssistantCallYYBParamStruct.taskAppId;
    localIPCBaseParam.taskPackageName = paramTMAssistantCallYYBParamStruct.taskPackageName;
    localIPCBaseParam.taskVersion = String.valueOf(paramTMAssistantCallYYBParamStruct.taskVersion);
    localIPCBaseParam.uin = paramTMAssistantCallYYBParamStruct.uin;
    localIPCBaseParam.uinType = paramTMAssistantCallYYBParamStruct.uinType;
    localIPCBaseParam.via = paramTMAssistantCallYYBParamStruct.via;
    localIPCBaseParam.channelId = paramTMAssistantCallYYBParamStruct.channelId;
    localIPCBaseParam.extra = b(paramTMAssistantCallYYBParamStruct, paramOuterCallReportModel);
    return localIPCBaseParam;
  }
  
  public static byte[] a(JceStruct paramJceStruct, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jceStruct = ");
    localStringBuilder.append(paramJceStruct);
    ab.c("TMQQDownloaderDataProcessor", localStringBuilder.toString());
    paramJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramJceStruct, paramString);
    if (paramJceStruct != null)
    {
      paramJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramJceStruct);
      if ((paramJceStruct != null) && (paramJceStruct.length > 0))
      {
        paramString = new StringBuilder();
        paramString.append("return sendData length = ");
        paramString.append(paramJceStruct.length);
        ab.c("TMQQDownloaderDataProcessor", paramString.toString());
        return paramJceStruct;
      }
      ab.c("TMQQDownloaderDataProcessor", "handleUriAction sendData = null");
      return null;
    }
    ab.c("TMQQDownloaderDataProcessor", "handleUriAction IPCRequest = null");
    return null;
  }
  
  public static BatchDownloadActionRequest b(int paramInt, ArrayList<TMAssistantCallYYBParamStruct> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("batchRequestType = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",appList size = ");
    if (paramArrayList == null) {
      localObject = "null";
    } else {
      localObject = Integer.valueOf(paramArrayList.size());
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(",via = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",uin = ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(",uinType = ");
    localStringBuilder.append(paramString3);
    ab.c("TMQQDownloaderDataProcessor", localStringBuilder.toString());
    Object localObject = new BatchDownloadActionRequest();
    ((BatchDownloadActionRequest)localObject).batchRequestType = paramInt;
    if (paramString1 != null) {
      ((BatchDownloadActionRequest)localObject).via = paramString1;
    }
    if (paramString2 != null) {
      ((BatchDownloadActionRequest)localObject).uin = paramString2;
    }
    if (paramString3 != null) {
      ((BatchDownloadActionRequest)localObject).uinType = paramString3;
    }
    ((BatchDownloadActionRequest)localObject).batchData = new ArrayList();
    paramString2 = "appList {";
    if (paramArrayList != null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("appList {");
      paramString1.append("appList.size=");
      paramString1.append(paramArrayList.size());
      paramString1.append("\n");
      paramString1 = paramString1.toString();
      paramInt = 0;
      for (;;)
      {
        paramString2 = paramString1;
        if (paramInt >= paramArrayList.size()) {
          break;
        }
        paramString3 = a((TMAssistantCallYYBParamStruct)paramArrayList.get(paramInt), null);
        paramString2 = new IPCDownloadParam();
        paramString2.baseParam = paramString3;
        ((BatchDownloadActionRequest)localObject).batchData.add(paramString2);
        paramString3 = new StringBuilder();
        paramString3.append(paramString1);
        paramString3.append("element:");
        paramString3.append(paramInt);
        paramString3.append("IPCDownloadParam {IPCBaseParam {hostAppId:");
        paramString3.append(paramString2.baseParam.hostAppId);
        paramString3.append("|taskAppId:");
        paramString3.append(paramString2.baseParam.taskAppId);
        paramString3.append("|taskPackageName:");
        paramString3.append(paramString2.baseParam.taskPackageName);
        paramString3.append("|taskVersion:");
        paramString3.append(paramString2.baseParam.taskVersion);
        paramString3.append("}|actionFlag:");
        paramString3.append(paramString2.actionFlag);
        paramString3.append("|verifyType:");
        paramString3.append(paramString2.verifyType);
        paramString3.append("}\n");
        paramString1 = paramString3.toString();
        paramInt += 1;
      }
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append(paramString2);
    paramArrayList.append("}");
    ab.c("TMQQDownloaderDataProcessor", paramArrayList.toString());
    return localObject;
  }
  
  private static String b(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, OuterCallReportModel paramOuterCallReportModel)
  {
    if (paramOuterCallReportModel == null) {
      return "";
    }
    GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
    JSONObject localJSONObject = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramOuterCallReportModel.mHostPname);
      localStringBuilder.append("|");
      localStringBuilder.append(paramTMAssistantCallYYBParamStruct.via);
      localStringBuilder.append("|");
      localStringBuilder.append(paramOuterCallReportModel.mOuterCallTime);
      localJSONObject.put("beaconId", localStringBuilder.toString());
    }
    catch (JSONException paramTMAssistantCallYYBParamStruct)
    {
      paramTMAssistantCallYYBParamStruct.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public TMAssistantCallYYBTaskInfo a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getDownloadTask param.sngAppid:");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct.SNGAppId);
    ((StringBuilder)localObject).append("|param.appid:");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct.taskAppId);
    ((StringBuilder)localObject).append("| param.taskPackageName:");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct.taskPackageName);
    ((StringBuilder)localObject).append("|param.taskVersion:");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct.taskVersion);
    ab.c("TMQQDownloaderDataProcessor", ((StringBuilder)localObject).toString());
    paramTMAssistantCallYYBParamStruct = a(paramTMAssistantCallYYBParamStruct, null);
    localObject = new QueryDownloadTaskRequest();
    ((QueryDownloadTaskRequest)localObject).baseParam = paramTMAssistantCallYYBParamStruct;
    paramTMAssistantCallYYBParamStruct = a((JceStruct)localObject, "");
    if ((paramTMAssistantCallYYBParamStruct != null) && (paramTMAssistantCallYYBParamStruct.length > 0)) {
      try
      {
        b(GlobalUtil.getInstance().getContext());
        if (this.b == null) {
          break label174;
        }
        paramTMAssistantCallYYBParamStruct = this.b.a(paramTMAssistantCallYYBParamStruct);
      }
      catch (Throwable paramTMAssistantCallYYBParamStruct)
      {
        paramTMAssistantCallYYBParamStruct.printStackTrace();
        ab.c("TMQQDownloaderDataProcessor", "getDownloadTask Exception,return null", paramTMAssistantCallYYBParamStruct);
        return null;
      }
    } else {
      ab.c("TMQQDownloaderDataProcessor", "getDownloadTask sendData = null");
    }
    label174:
    paramTMAssistantCallYYBParamStruct = null;
    paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramTMAssistantCallYYBParamStruct);
    if (paramTMAssistantCallYYBParamStruct != null)
    {
      paramTMAssistantCallYYBParamStruct = (QueryDownloadTaskResponse)com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramTMAssistantCallYYBParamStruct);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QueryDownloadTaskResponse downloadTask state:");
      ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct.state);
      ab.c("TMQQDownloaderDataProcessor", ((StringBuilder)localObject).toString());
      int i = GlobalUtil.assistantState2SDKState(paramTMAssistantCallYYBParamStruct.state);
      if (paramTMAssistantCallYYBParamStruct != null) {
        return new TMAssistantCallYYBTaskInfo(paramTMAssistantCallYYBParamStruct.url, paramTMAssistantCallYYBParamStruct.savePath, i, paramTMAssistantCallYYBParamStruct.receivedLen, paramTMAssistantCallYYBParamStruct.totalLen, "application/vnd.android.package-archive");
      }
    }
    else
    {
      ab.c("TMQQDownloaderDataProcessor", "getDownloadTask IPCResponse = null");
    }
    ab.c("TMQQDownloaderDataProcessor", "getDownloadTask return null");
    return null;
  }
  
  public ArrayList<TMAssistantCallYYBTaskInfo> a(ArrayList<TMAssistantCallYYBParamStruct> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = null;
    if (paramArrayList == null)
    {
      ab.c("TMQQDownloaderDataProcessor", "appList = null,return null");
      return null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getBatchTaskInfos appList.size:");
    ((StringBuilder)localObject2).append(paramArrayList.size());
    ((StringBuilder)localObject2).append(",via = ");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(",uin = ");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(",uinType = ");
    ((StringBuilder)localObject2).append(paramString3);
    ab.c("TMQQDownloaderDataProcessor", ((StringBuilder)localObject2).toString());
    paramArrayList = a(b(3, paramArrayList, paramString1, paramString2, paramString3), "");
    if ((paramArrayList != null) && (paramArrayList.length > 0)) {
      try
      {
        b(GlobalUtil.getInstance().getContext());
        if (this.b == null) {
          break label170;
        }
        paramArrayList = this.b.a(paramArrayList);
      }
      catch (Throwable paramArrayList)
      {
        paramArrayList.printStackTrace();
        return null;
      }
    } else {
      ab.c("TMQQDownloaderDataProcessor", "getBatchTaskInfos sendData = null or length = 0");
    }
    label170:
    paramArrayList = null;
    paramArrayList = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayList);
    if (paramArrayList != null)
    {
      localObject2 = (BatchDownloadActionResponse)com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayList);
      if (localObject2 != null)
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("getBatchTaskInfos BatchDownloadActionResponse batchRequestType:");
        paramArrayList.append(((BatchDownloadActionResponse)localObject2).batchRequestType);
        paramArrayList = paramArrayList.toString();
        if (((BatchDownloadActionResponse)localObject2).batchData != null)
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramArrayList);
          paramString1.append("response.batchData.size:");
          paramString1.append(((BatchDownloadActionResponse)localObject2).batchData.size());
          paramString2 = paramString1.toString();
          paramString3 = new ArrayList();
          int i = 0;
          for (;;)
          {
            paramString1 = paramString2;
            paramArrayList = paramString3;
            if (i >= ((BatchDownloadActionResponse)localObject2).batchData.size()) {
              break;
            }
            paramArrayList = (IPCQueryDownloadInfo)((BatchDownloadActionResponse)localObject2).batchData.get(i);
            int j = GlobalUtil.assistantState2SDKState(paramArrayList.state);
            if (paramArrayList != null) {
              paramString3.add(new TMAssistantCallYYBTaskInfo(paramArrayList.url, paramArrayList.savePath, j, paramArrayList.receivedLen, paramArrayList.totalLen, "application/vnd.android.package-archive"));
            }
            i += 1;
          }
        }
        paramString1 = new StringBuilder();
        paramString1.append(paramArrayList);
        paramString1.append("response.batchData = null");
        paramString1 = paramString1.toString();
        paramArrayList = localObject1;
        ab.c("TMQQDownloaderDataProcessor", paramString1);
        return paramArrayList;
      }
      ab.c("TMQQDownloaderDataProcessor", "getBatchTaskInfos BatchDownloadActionResponse response = null");
      return null;
    }
    ab.c("TMQQDownloaderDataProcessor", "getBatchTaskInfos IPCResponse resp = null");
    return null;
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDownloadSDKServiceInvalid callback = ");
    ((StringBuilder)localObject).append(this.c);
    ab.c("TMQQDownloaderDataProcessor", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((ITMAssistantCallBackListener)localObject).onQQDownloaderInvalid();
    }
    localObject = GlobalUtil.getInstance().getContext();
    if (localObject != null) {
      com.tencent.tmassistant.a.a((Context)localObject).b(this.d);
    }
    this.b = null;
  }
  
  public void a(ITMAssistantCallBackListener paramITMAssistantCallBackListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("listener = ");
    localStringBuilder.append(paramITMAssistantCallBackListener);
    ab.c("TMQQDownloaderDataProcessor", localStringBuilder.toString());
    this.c = paramITMAssistantCallBackListener;
  }
  
  void a(GetDownloadProgressResponse paramGetDownloadProgressResponse)
  {
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramGetDownloadProgressResponse.requestParam);
    if ((localTMAssistantCallYYBParamStruct != null) && (this.c != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("进度回调：GetDownloadProgressResponse response.receivedLen:");
      localStringBuilder.append(paramGetDownloadProgressResponse.receivedLen);
      localStringBuilder.append(",response.totalLen");
      localStringBuilder.append(paramGetDownloadProgressResponse.totalLen);
      ab.c("TMQQDownloaderDataProcessor", localStringBuilder.toString());
      this.c.onDownloadTaskProgressChanged(localTMAssistantCallYYBParamStruct, paramGetDownloadProgressResponse.receivedLen, paramGetDownloadProgressResponse.totalLen);
    }
  }
  
  void a(GetDownloadStateResponse paramGetDownloadStateResponse)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onServiceFreed response = ");
    ((StringBuilder)localObject).append(paramGetDownloadStateResponse);
    ab.c("TMQQDownloaderDataProcessor", ((StringBuilder)localObject).toString());
    localObject = a(paramGetDownloadStateResponse.requestParam);
    if ((localObject != null) && (this.c != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("状态回调：GetDownloadStateResponse param.taskAppId:");
      localStringBuilder.append(((TMAssistantCallYYBParamStruct)localObject).taskAppId);
      localStringBuilder.append(",param.taskPackageName:");
      localStringBuilder.append(((TMAssistantCallYYBParamStruct)localObject).taskPackageName);
      localStringBuilder.append(",state:");
      localStringBuilder.append(paramGetDownloadStateResponse.state);
      localStringBuilder.append(",response.errorCode");
      localStringBuilder.append(paramGetDownloadStateResponse.errorCode);
      ab.c("TMQQDownloaderDataProcessor", localStringBuilder.toString());
      this.c.onDownloadTaskStateChanged((TMAssistantCallYYBParamStruct)localObject, GlobalUtil.assistantState2SDKState(paramGetDownloadStateResponse.state), GlobalUtil.assistantErrorCode2SDKErrorCode(paramGetDownloadStateResponse.errorCode), paramGetDownloadStateResponse.errorMsg);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayOfByte);
      JceStruct localJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayOfByte);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("response.head.cmdId = ");
      localStringBuilder.append(paramArrayOfByte.head.cmdId);
      ab.c("TMQQDownloaderDataProcessor", localStringBuilder.toString());
      int i = paramArrayOfByte.head.cmdId;
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 8) {
            return;
          }
          d();
          return;
        }
        if (localJceStruct != null) {
          a((GetDownloadProgressResponse)localJceStruct);
        }
      }
      else if (localJceStruct != null)
      {
        a((GetDownloadStateResponse)localJceStruct);
      }
    }
    else
    {
      ab.c("TMQQDownloaderDataProcessor", "onActionResult reponseData = null");
    }
  }
  
  public boolean a(int paramInt, ArrayList<TMAssistantCallYYBParamStruct> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleBatchUpdateAction batchRequestType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("|appList:");
    localStringBuilder.append(paramArrayList);
    ab.c("TMQQDownloaderDataProcessor", localStringBuilder.toString());
    paramString2 = b(paramInt, paramArrayList, paramString1, paramString2, paramString3);
    paramArrayList = UUID.randomUUID().toString();
    paramString2 = a(paramString2, paramArrayList);
    if ((paramString2 != null) && (paramString2.length > 0)) {
      try
      {
        b(GlobalUtil.getInstance().getContext());
        if (this.b != null)
        {
          this.b.b(paramString2);
          paramString2 = new StringBuilder();
          paramString2.append("result is true, clientKey:");
          paramString2.append(this.b.mClientKey);
          ab.c("TMQQDownloaderDataProcessor", paramString2.toString());
          paramString2 = com.tencent.tmassistantsdk.internal.logreport.b.g();
          paramString3 = new StringBuilder();
          paramString3.append("V2_handleBatchRequestAction_");
          paramString3.append(paramInt);
          paramArrayList = paramString2.a(paramString1, paramArrayList, paramString3.toString());
          com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramArrayList);
          return true;
        }
        ab.c("TMQQDownloaderDataProcessor", "result is false,openSDKClient is null");
        return false;
      }
      catch (Throwable paramArrayList)
      {
        paramArrayList.printStackTrace();
        ab.c("TMQQDownloaderDataProcessor", "result is false");
        return false;
      }
    }
    ab.c("TMQQDownloaderDataProcessor", "handleBatchUpdateAction sendData = null or length = 0");
    return false;
  }
  
  public boolean a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt, String paramString1, String paramString2, String paramString3, OuterCallReportModel paramOuterCallReportModel)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleDownloadTask requestType:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("  param.sngAppid:");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct.SNGAppId);
    ((StringBuilder)localObject).append("|param.appid:");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct.taskAppId);
    ((StringBuilder)localObject).append("| param.taskPackageName:");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct.taskPackageName);
    ((StringBuilder)localObject).append("|param.taskVersion:");
    ((StringBuilder)localObject).append(paramTMAssistantCallYYBParamStruct.taskVersion);
    ((StringBuilder)localObject).append("| param.actionFlag:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" | verifyType:");
    ((StringBuilder)localObject).append(paramString3);
    ab.c("TMQQDownloaderDataProcessor", ((StringBuilder)localObject).toString());
    if ((TMAssistantCallYYB_V1.getQQDownloadApiLevel(this.e) >= 6) && (paramInt == 1)) {
      paramTMAssistantCallYYBParamStruct.timePointMap.put("OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_Start", Long.valueOf(System.currentTimeMillis()));
    }
    localObject = new OperateDownloadTaskRequest();
    paramOuterCallReportModel = a(paramTMAssistantCallYYBParamStruct, paramOuterCallReportModel);
    if ((TMAssistantCallYYB_V1.getQQDownloadApiLevel(this.e) >= 6) && (paramInt == 1)) {
      paramTMAssistantCallYYBParamStruct.timePointMap.put("OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_End", Long.valueOf(System.currentTimeMillis()));
    }
    ((OperateDownloadTaskRequest)localObject).requestType = paramInt;
    ((OperateDownloadTaskRequest)localObject).baseParam = paramOuterCallReportModel;
    ((OperateDownloadTaskRequest)localObject).actionFlag = paramString2;
    ((OperateDownloadTaskRequest)localObject).verifyType = paramString3;
    ((OperateDownloadTaskRequest)localObject).opList = paramString1;
    ((OperateDownloadTaskRequest)localObject).timePoint = paramTMAssistantCallYYBParamStruct.timePointMap;
    paramString1 = UUID.randomUUID().toString();
    paramString2 = a((JceStruct)localObject, paramString1);
    if ((paramString2 != null) && (paramString2.length > 0)) {
      try
      {
        b(GlobalUtil.getInstance().getContext());
        if (this.b != null)
        {
          this.b.b(paramString2);
          ab.c("TMQQDownloaderDataProcessor", "return true");
          paramString2 = com.tencent.tmassistantsdk.internal.logreport.b.g();
          paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct);
          paramString3 = new StringBuilder();
          paramString3.append("V2_handleDownloadTask_");
          paramString3.append(paramInt);
          paramTMAssistantCallYYBParamStruct = paramString2.a(paramTMAssistantCallYYBParamStruct, paramString1, paramString3.toString());
          com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramTMAssistantCallYYBParamStruct);
          return true;
        }
        ab.c("TMQQDownloaderDataProcessor", "handleDownloadTask openSDKClient = null,return false");
        return false;
      }
      catch (Throwable paramTMAssistantCallYYBParamStruct)
      {
        ab.a("TMQQDownloaderDataProcessor", "handleDownloadTask Exception,return false", paramTMAssistantCallYYBParamStruct);
        paramTMAssistantCallYYBParamStruct.printStackTrace();
        return false;
      }
    }
    ab.c("TMQQDownloaderDataProcessor", "handleDownloadTask sendData = null,return false");
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      ab.c("TMQQDownloaderDataProcessor", "uri = null,return false");
      return false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uri = ");
    ((StringBuilder)localObject1).append(paramString);
    ab.c("TMQQDownloaderDataProcessor", ((StringBuilder)localObject1).toString());
    Object localObject2 = new URIActionRequest(paramString);
    localObject1 = UUID.randomUUID().toString();
    localObject2 = a((JceStruct)localObject2, (String)localObject1);
    if ((localObject2 != null) && (localObject2.length > 0)) {
      try
      {
        b(GlobalUtil.getInstance().getContext());
        if (this.b != null) {
          this.b.b((byte[])localObject2);
        }
        paramString = com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramString, (String)localObject1, "V2_handleUriAction");
        com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramString);
        return false;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        ab.a("TMQQDownloaderDataProcessor", "handleUriAction Exception,return false", paramString);
        return false;
      }
    }
    ab.c("TMQQDownloaderDataProcessor", "handleUriAction sendData = null");
    return false;
  }
  
  public com.tencent.tmassistantsdk.internal.b.b b(Context paramContext)
  {
    try
    {
      if ((this.b == null) && (paramContext != null))
      {
        this.b = com.tencent.tmassistant.a.a(paramContext).a(this.d);
        if (this.b != null) {
          this.b.a(this);
        }
      }
      paramContext = this.b;
      return paramContext;
    }
    finally {}
  }
  
  public void b()
  {
    ab.c("TMQQDownloaderDataProcessor", "unregisterIQQDownloaderOpenSDKListener start");
    this.c = null;
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext != null) {
      com.tencent.tmassistant.a.a(localContext).b(this.d);
    }
    this.b = null;
  }
  
  public void c()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("releaseIPCClient openSDKClient = ");
    ((StringBuilder)localObject).append(this.b);
    ab.c("TMQQDownloaderDataProcessor", ((StringBuilder)localObject).toString());
    if (this.b != null)
    {
      localObject = GlobalUtil.getInstance().getContext();
      if (localObject != null) {
        com.tencent.tmassistant.a.a((Context)localObject).b(this.d);
      }
      this.b = null;
    }
  }
  
  void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onServiceFreed callback = ");
    ((StringBuilder)localObject).append(this.c);
    ab.c("TMQQDownloaderDataProcessor", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject != null) {
      ((ITMAssistantCallBackListener)localObject).onServiceFree();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.d
 * JD-Core Version:    0.7.0.1
 */