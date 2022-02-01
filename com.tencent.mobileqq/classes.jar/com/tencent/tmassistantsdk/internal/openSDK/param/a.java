package com.tencent.tmassistantsdk.internal.openSDK.param;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCCmd;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCHead;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCRequest;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCSDKDownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  protected static int a;
  
  public static int a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return -1;
    }
    paramJceStruct = paramJceStruct.getClass().getSimpleName();
    return IPCCmd.convert(paramJceStruct.substring(0, paramJceStruct.length() - 7)).value();
  }
  
  public static JceStruct a(IPCResponse paramIPCResponse)
  {
    try
    {
      int i = paramIPCResponse.head.cmdId;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unpackBodyStruct cmdid=");
      ((StringBuilder)localObject).append(i);
      ab.c("nemo", ((StringBuilder)localObject).toString());
      localObject = IPCCmd.convert(i).toString();
      localObject = a((String)localObject);
      if ((localObject != null) && (paramIPCResponse.body.length > 0)) {
        try
        {
          paramIPCResponse = new JceInputStream(paramIPCResponse.body);
          paramIPCResponse.setServerEncoding("utf-8");
          ((JceStruct)localObject).readFrom(paramIPCResponse);
          return localObject;
        }
        catch (Exception paramIPCResponse)
        {
          paramIPCResponse.printStackTrace();
        }
      }
      return null;
    }
    catch (Exception paramIPCResponse) {}
    return null;
  }
  
  private static JceStruct a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a.class.getPackage().getName());
    localStringBuilder.append(".jce.");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("Response");
    paramString = localStringBuilder.toString();
    try
    {
      paramString = (JceStruct)Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (InstantiationException paramString)
    {
      paramString.printStackTrace();
    }
    catch (IllegalAccessException paramString)
    {
      paramString.printStackTrace();
    }
    catch (ClassNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static IPCRequest a(JceStruct paramJceStruct, String paramString)
  {
    if (paramJceStruct == null) {
      return null;
    }
    IPCRequest localIPCRequest = new IPCRequest();
    IPCHead localIPCHead = new IPCHead();
    int i = a;
    a = i + 1;
    localIPCHead.requestId = i;
    localIPCHead.cmdId = a(paramJceStruct);
    localIPCHead.hostPackageName = GlobalUtil.getAppPackageName(GlobalUtil.getInstance().getContext());
    localIPCHead.hostVersionCode = String.valueOf(GlobalUtil.getAppVersionCode(GlobalUtil.getInstance().getContext()));
    localIPCHead.traceId = paramString;
    localIPCHead.sdkIpcJceVersion = 1;
    localIPCRequest.head = localIPCHead;
    localIPCRequest.body = b(paramJceStruct);
    return localIPCRequest;
  }
  
  public static IPCResponse a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 4) {
        return null;
      }
      IPCResponse localIPCResponse = new IPCResponse();
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localIPCResponse.readFrom(paramArrayOfByte);
        if (!TextUtils.isEmpty(localIPCResponse.head.hostPackageName)) {
          localIPCResponse.body = ProtocolPackage.decrypt(localIPCResponse.body, "ji*9^&43U0X-~./(".getBytes());
        }
        return localIPCResponse;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static IPCSDKDownloadInfo a(TMAssistantDownloadTaskInfo paramTMAssistantDownloadTaskInfo)
  {
    if (paramTMAssistantDownloadTaskInfo == null) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TMAssistantDownloadTaskInfo ......mAppName: ");
    ((StringBuilder)localObject).append(paramTMAssistantDownloadTaskInfo.mAppName);
    ab.c("IPCPackageTools", ((StringBuilder)localObject).toString());
    localObject = new IPCSDKDownloadInfo();
    if (paramTMAssistantDownloadTaskInfo != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTMAssistantDownloadTaskInfo.mAppId);
      localStringBuilder.append("");
      ((IPCSDKDownloadInfo)localObject).appId = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTMAssistantDownloadTaskInfo.mIconUrl);
      localStringBuilder.append("");
      ((IPCSDKDownloadInfo)localObject).appIconUrl = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTMAssistantDownloadTaskInfo.mAppName);
      localStringBuilder.append("");
      ((IPCSDKDownloadInfo)localObject).appName = localStringBuilder.toString();
      ((IPCSDKDownloadInfo)localObject).downloadFinishTime = paramTMAssistantDownloadTaskInfo.mEndTime;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTMAssistantDownloadTaskInfo.mTaskPackageName);
      localStringBuilder.append("");
      ((IPCSDKDownloadInfo)localObject).packageName = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTMAssistantDownloadTaskInfo.mVia);
      localStringBuilder.append("");
      ((IPCSDKDownloadInfo)localObject).via = localStringBuilder.toString();
      ((IPCSDKDownloadInfo)localObject).versionCode = paramTMAssistantDownloadTaskInfo.mTaskVersionCode;
    }
    ((IPCSDKDownloadInfo)localObject).appState = paramTMAssistantDownloadTaskInfo.mState;
    ((IPCSDKDownloadInfo)localObject).receivedLen = paramTMAssistantDownloadTaskInfo.mReceiveDataLen;
    ((IPCSDKDownloadInfo)localObject).totalLen = paramTMAssistantDownloadTaskInfo.mTotalDataLen;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramTMAssistantDownloadTaskInfo.mUrl);
    localStringBuilder.append("");
    ((IPCSDKDownloadInfo)localObject).url = localStringBuilder.toString();
    return localObject;
  }
  
  public static List<IPCSDKDownloadInfo> a(List<TMAssistantDownloadTaskInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IPCSDKDownloadInfo localIPCSDKDownloadInfo = a((TMAssistantDownloadTaskInfo)paramList.next());
      if (localIPCSDKDownloadInfo != null) {
        localArrayList.add(localIPCSDKDownloadInfo);
      }
    }
    return localArrayList;
  }
  
  public static byte[] a(IPCRequest paramIPCRequest)
  {
    if (paramIPCRequest == null) {
      return null;
    }
    paramIPCRequest.body = ProtocolPackage.encrypt(paramIPCRequest.body, "ji*9^&43U0X-~./(".getBytes());
    return b(paramIPCRequest);
  }
  
  public static byte[] b(JceStruct paramJceStruct)
  {
    return ProtocolPackage.jceStructToUTF8Byte(paramJceStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.a
 * JD-Core Version:    0.7.0.1
 */