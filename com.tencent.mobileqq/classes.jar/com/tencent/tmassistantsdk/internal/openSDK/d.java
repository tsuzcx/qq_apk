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
  protected static d a = null;
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
      localTMAssistantCallYYBParamStruct.uin = paramIPCBaseParam.uin;
      localTMAssistantCallYYBParamStruct.uinType = paramIPCBaseParam.uinType;
      localTMAssistantCallYYBParamStruct.via = paramIPCBaseParam.via;
      localTMAssistantCallYYBParamStruct.channelId = paramIPCBaseParam.channelId;
      return localTMAssistantCallYYBParamStruct;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.c("TMQQDownloaderDataProcessor", "baseParam2QQParam Integer.valueOf(baseParam.taskVersion) NumberFormatException occur");
      }
    }
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
    ab.c("TMQQDownloaderDataProcessor", "jceStruct = " + paramJceStruct);
    paramJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramJceStruct, paramString);
    if (paramJceStruct != null)
    {
      paramJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramJceStruct);
      if ((paramJceStruct != null) && (paramJceStruct.length > 0))
      {
        ab.c("TMQQDownloaderDataProcessor", "return sendData length = " + paramJceStruct.length);
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
    StringBuilder localStringBuilder = new StringBuilder().append("batchRequestType = ").append(paramInt).append(",appList size = ");
    if (paramArrayList == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(paramArrayList.size()))
    {
      ab.c("TMQQDownloaderDataProcessor", localObject + ",via = " + paramString1 + ",uin = " + paramString2 + ",uinType = " + paramString3);
      localObject = new BatchDownloadActionRequest();
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
      if (paramArrayList == null) {
        break;
      }
      paramString1 = "appList {" + "appList.size=" + paramArrayList.size() + "\n";
      paramInt = 0;
      for (;;)
      {
        paramString2 = paramString1;
        if (paramInt >= paramArrayList.size()) {
          break;
        }
        paramString2 = a((TMAssistantCallYYBParamStruct)paramArrayList.get(paramInt), null);
        paramString3 = new IPCDownloadParam();
        paramString3.baseParam = paramString2;
        ((BatchDownloadActionRequest)localObject).batchData.add(paramString3);
        paramString1 = paramString1 + "element:" + paramInt + "IPCDownloadParam {IPCBaseParam {hostAppId:" + paramString3.baseParam.hostAppId + "|taskAppId:" + paramString3.baseParam.taskAppId + "|taskPackageName:" + paramString3.baseParam.taskPackageName + "|taskVersion:" + paramString3.baseParam.taskVersion + "}|actionFlag:" + paramString3.actionFlag + "|verifyType:" + paramString3.verifyType + "}\n";
        paramInt += 1;
      }
    }
    ab.c("TMQQDownloaderDataProcessor", paramString2 + "}");
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
      localJSONObject.put("beaconId", paramOuterCallReportModel.mHostPname + "|" + paramTMAssistantCallYYBParamStruct.via + "|" + paramOuterCallReportModel.mOuterCallTime);
      return localJSONObject.toString();
    }
    catch (JSONException paramTMAssistantCallYYBParamStruct)
    {
      for (;;)
      {
        paramTMAssistantCallYYBParamStruct.printStackTrace();
      }
    }
  }
  
  public TMAssistantCallYYBTaskInfo a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct)
  {
    ab.c("TMQQDownloaderDataProcessor", "getDownloadTask param.sngAppid:" + paramTMAssistantCallYYBParamStruct.SNGAppId + "|param.appid:" + paramTMAssistantCallYYBParamStruct.taskAppId + "| param.taskPackageName:" + paramTMAssistantCallYYBParamStruct.taskPackageName + "|param.taskVersion:" + paramTMAssistantCallYYBParamStruct.taskVersion);
    paramTMAssistantCallYYBParamStruct = a(paramTMAssistantCallYYBParamStruct, null);
    QueryDownloadTaskRequest localQueryDownloadTaskRequest = new QueryDownloadTaskRequest();
    localQueryDownloadTaskRequest.baseParam = paramTMAssistantCallYYBParamStruct;
    paramTMAssistantCallYYBParamStruct = a(localQueryDownloadTaskRequest, "");
    if ((paramTMAssistantCallYYBParamStruct != null) && (paramTMAssistantCallYYBParamStruct.length > 0)) {}
    for (;;)
    {
      try
      {
        b(GlobalUtil.getInstance().getContext());
        if (this.b == null) {
          break label238;
        }
        paramTMAssistantCallYYBParamStruct = this.b.a(paramTMAssistantCallYYBParamStruct);
        paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramTMAssistantCallYYBParamStruct);
        if (paramTMAssistantCallYYBParamStruct == null) {
          break;
        }
        paramTMAssistantCallYYBParamStruct = (QueryDownloadTaskResponse)com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramTMAssistantCallYYBParamStruct);
        ab.c("TMQQDownloaderDataProcessor", "QueryDownloadTaskResponse downloadTask state:" + paramTMAssistantCallYYBParamStruct.state);
        int i = GlobalUtil.assistantState2SDKState(paramTMAssistantCallYYBParamStruct.state);
        if (paramTMAssistantCallYYBParamStruct == null) {
          break label251;
        }
        return new TMAssistantCallYYBTaskInfo(paramTMAssistantCallYYBParamStruct.url, paramTMAssistantCallYYBParamStruct.savePath, i, paramTMAssistantCallYYBParamStruct.receivedLen, paramTMAssistantCallYYBParamStruct.totalLen, "application/vnd.android.package-archive");
      }
      catch (Throwable paramTMAssistantCallYYBParamStruct)
      {
        paramTMAssistantCallYYBParamStruct.printStackTrace();
        ab.c("TMQQDownloaderDataProcessor", "getDownloadTask Exception,return null", paramTMAssistantCallYYBParamStruct);
        return null;
      }
      ab.c("TMQQDownloaderDataProcessor", "getDownloadTask sendData = null");
      label238:
      paramTMAssistantCallYYBParamStruct = null;
    }
    ab.c("TMQQDownloaderDataProcessor", "getDownloadTask IPCResponse = null");
    label251:
    ab.c("TMQQDownloaderDataProcessor", "getDownloadTask return null");
    return null;
  }
  
  public ArrayList<TMAssistantCallYYBTaskInfo> a(ArrayList<TMAssistantCallYYBParamStruct> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    if (paramArrayList == null)
    {
      ab.c("TMQQDownloaderDataProcessor", "appList = null,return null");
      return null;
    }
    ab.c("TMQQDownloaderDataProcessor", "getBatchTaskInfos appList.size:" + paramArrayList.size() + ",via = " + paramString1 + ",uin = " + paramString2 + ",uinType = " + paramString3);
    paramString1 = a(b(3, paramArrayList, paramString1, paramString2, paramString3), "");
    paramArrayList = null;
    if ((paramString1 != null) && (paramString1.length > 0)) {}
    for (;;)
    {
      try
      {
        b(GlobalUtil.getInstance().getContext());
        if (this.b != null) {
          paramArrayList = this.b.a(paramString1);
        }
        paramString1 = null;
        paramArrayList = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayList);
        if (paramArrayList == null) {
          break label366;
        }
        paramString2 = (BatchDownloadActionResponse)com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayList);
        if (paramString2 == null) {
          break label356;
        }
        paramArrayList = "getBatchTaskInfos BatchDownloadActionResponse batchRequestType:" + paramString2.batchRequestType;
        if (paramString2.batchData == null) {
          break label332;
        }
        paramArrayList = paramArrayList + "response.batchData.size:" + paramString2.batchData.size();
        paramString1 = new ArrayList();
        int i = 0;
        if (i >= paramString2.batchData.size()) {
          break;
        }
        paramString3 = (IPCQueryDownloadInfo)paramString2.batchData.get(i);
        int j = GlobalUtil.assistantState2SDKState(paramString3.state);
        if (paramString3 != null) {
          paramString1.add(new TMAssistantCallYYBTaskInfo(paramString3.url, paramString3.savePath, j, paramString3.receivedLen, paramString3.totalLen, "application/vnd.android.package-archive"));
        }
        i += 1;
        continue;
        ab.c("TMQQDownloaderDataProcessor", "getBatchTaskInfos sendData = null or length = 0");
      }
      catch (Throwable paramArrayList)
      {
        paramArrayList.printStackTrace();
        return null;
      }
    }
    for (;;)
    {
      ab.c("TMQQDownloaderDataProcessor", paramArrayList);
      return paramString1;
      label332:
      paramArrayList = paramArrayList + "response.batchData = null";
    }
    label356:
    ab.c("TMQQDownloaderDataProcessor", "getBatchTaskInfos BatchDownloadActionResponse response = null");
    return null;
    label366:
    ab.c("TMQQDownloaderDataProcessor", "getBatchTaskInfos IPCResponse resp = null");
    return null;
  }
  
  public void a()
  {
    ab.c("TMQQDownloaderDataProcessor", "onDownloadSDKServiceInvalid callback = " + this.c);
    if (this.c != null) {
      this.c.onQQDownloaderInvalid();
    }
    Context localContext = GlobalUtil.getInstance().getContext();
    if (localContext != null) {
      com.tencent.tmassistant.a.a(localContext).b(this.d);
    }
    this.b = null;
  }
  
  public void a(ITMAssistantCallBackListener paramITMAssistantCallBackListener)
  {
    ab.c("TMQQDownloaderDataProcessor", "listener = " + paramITMAssistantCallBackListener);
    this.c = paramITMAssistantCallBackListener;
  }
  
  void a(GetDownloadProgressResponse paramGetDownloadProgressResponse)
  {
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramGetDownloadProgressResponse.requestParam);
    if ((localTMAssistantCallYYBParamStruct != null) && (this.c != null))
    {
      ab.c("TMQQDownloaderDataProcessor", "进度回调：GetDownloadProgressResponse response.receivedLen:" + paramGetDownloadProgressResponse.receivedLen + ",response.totalLen" + paramGetDownloadProgressResponse.totalLen);
      this.c.onDownloadTaskProgressChanged(localTMAssistantCallYYBParamStruct, paramGetDownloadProgressResponse.receivedLen, paramGetDownloadProgressResponse.totalLen);
    }
  }
  
  void a(GetDownloadStateResponse paramGetDownloadStateResponse)
  {
    ab.c("TMQQDownloaderDataProcessor", "onServiceFreed response = " + paramGetDownloadStateResponse);
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramGetDownloadStateResponse.requestParam);
    if ((localTMAssistantCallYYBParamStruct != null) && (this.c != null))
    {
      ab.c("TMQQDownloaderDataProcessor", "状态回调：GetDownloadStateResponse param.taskAppId:" + localTMAssistantCallYYBParamStruct.taskAppId + ",param.taskPackageName:" + localTMAssistantCallYYBParamStruct.taskPackageName + ",state:" + paramGetDownloadStateResponse.state + ",response.errorCode" + paramGetDownloadStateResponse.errorCode);
      this.c.onDownloadTaskStateChanged(localTMAssistantCallYYBParamStruct, GlobalUtil.assistantState2SDKState(paramGetDownloadStateResponse.state), GlobalUtil.assistantErrorCode2SDKErrorCode(paramGetDownloadStateResponse.errorCode), paramGetDownloadStateResponse.errorMsg);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramArrayOfByte = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayOfByte);
      JceStruct localJceStruct = com.tencent.tmassistantsdk.internal.openSDK.param.a.a(paramArrayOfByte);
      ab.c("TMQQDownloaderDataProcessor", "response.head.cmdId = " + paramArrayOfByte.head.cmdId);
      switch (paramArrayOfByte.head.cmdId)
      {
      default: 
      case 2: 
      case 3: 
        do
        {
          do
          {
            return;
          } while (localJceStruct == null);
          a((GetDownloadStateResponse)localJceStruct);
          return;
        } while (localJceStruct == null);
        a((GetDownloadProgressResponse)localJceStruct);
        return;
      }
      d();
      return;
    }
    ab.c("TMQQDownloaderDataProcessor", "onActionResult reponseData = null");
  }
  
  public boolean a(int paramInt, ArrayList<TMAssistantCallYYBParamStruct> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    ab.c("TMQQDownloaderDataProcessor", "handleBatchUpdateAction batchRequestType:" + paramInt + "|appList:" + paramArrayList);
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
          ab.c("TMQQDownloaderDataProcessor", "result is true, clientKey:" + this.b.mClientKey);
          paramArrayList = com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramString1, paramArrayList, "V2_handleBatchRequestAction_" + paramInt);
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
    ab.c("TMQQDownloaderDataProcessor", "handleDownloadTask requestType:" + paramInt + "  param.sngAppid:" + paramTMAssistantCallYYBParamStruct.SNGAppId + "|param.appid:" + paramTMAssistantCallYYBParamStruct.taskAppId + "| param.taskPackageName:" + paramTMAssistantCallYYBParamStruct.taskPackageName + "|param.taskVersion:" + paramTMAssistantCallYYBParamStruct.taskVersion + "| param.actionFlag:" + paramString2 + " | verifyType:" + paramString3);
    if ((TMAssistantCallYYB_V1.getQQDownloadApiLevel(this.e) >= 6) && (paramInt == 1)) {
      paramTMAssistantCallYYBParamStruct.timePointMap.put("OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_Start", Long.valueOf(System.currentTimeMillis()));
    }
    OperateDownloadTaskRequest localOperateDownloadTaskRequest = new OperateDownloadTaskRequest();
    paramOuterCallReportModel = a(paramTMAssistantCallYYBParamStruct, paramOuterCallReportModel);
    if ((TMAssistantCallYYB_V1.getQQDownloadApiLevel(this.e) >= 6) && (paramInt == 1)) {
      paramTMAssistantCallYYBParamStruct.timePointMap.put("OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_End", Long.valueOf(System.currentTimeMillis()));
    }
    localOperateDownloadTaskRequest.requestType = paramInt;
    localOperateDownloadTaskRequest.baseParam = paramOuterCallReportModel;
    localOperateDownloadTaskRequest.actionFlag = paramString2;
    localOperateDownloadTaskRequest.verifyType = paramString3;
    localOperateDownloadTaskRequest.opList = paramString1;
    localOperateDownloadTaskRequest.timePoint = paramTMAssistantCallYYBParamStruct.timePointMap;
    paramString1 = UUID.randomUUID().toString();
    paramString2 = a(localOperateDownloadTaskRequest, paramString1);
    if ((paramString2 != null) && (paramString2.length > 0)) {
      try
      {
        b(GlobalUtil.getInstance().getContext());
        if (this.b != null)
        {
          this.b.b(paramString2);
          ab.c("TMQQDownloaderDataProcessor", "return true");
          paramTMAssistantCallYYBParamStruct = com.tencent.tmassistantsdk.internal.logreport.b.g().a(com.tencent.tmassistantsdk.internal.logreport.b.a(paramTMAssistantCallYYBParamStruct), paramString1, "V2_handleDownloadTask_" + paramInt);
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
    ab.c("TMQQDownloaderDataProcessor", "uri = " + paramString);
    Object localObject = new URIActionRequest(paramString);
    String str = UUID.randomUUID().toString();
    localObject = a((JceStruct)localObject, str);
    if ((localObject != null) && (localObject.length > 0)) {
      try
      {
        b(GlobalUtil.getInstance().getContext());
        if (this.b != null) {
          this.b.b((byte[])localObject);
        }
        paramString = com.tencent.tmassistantsdk.internal.logreport.b.g().a(paramString, str, "V2_handleUriAction");
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
    ab.c("TMQQDownloaderDataProcessor", "releaseIPCClient openSDKClient = " + this.b);
    if (this.b != null)
    {
      Context localContext = GlobalUtil.getInstance().getContext();
      if (localContext != null) {
        com.tencent.tmassistant.a.a(localContext).b(this.d);
      }
      this.b = null;
    }
  }
  
  void d()
  {
    ab.c("TMQQDownloaderDataProcessor", "onServiceFreed callback = " + this.c);
    if (this.c != null) {
      this.c.onServiceFree();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.d
 * JD-Core Version:    0.7.0.1
 */