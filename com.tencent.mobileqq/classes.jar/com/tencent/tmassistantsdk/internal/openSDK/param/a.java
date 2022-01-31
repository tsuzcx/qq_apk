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
  protected static int a = 0;
  
  public static int a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return -1;
    }
    paramJceStruct = paramJceStruct.getClass().getSimpleName();
    return IPCCmd.convert(paramJceStruct.substring(0, paramJceStruct.length() - "Request".length())).value();
  }
  
  public static JceStruct a(IPCResponse paramIPCResponse)
  {
    try
    {
      int i = paramIPCResponse.head.cmdId;
      ab.c("nemo", "unpackBodyStruct cmdid=" + i);
      Object localObject = IPCCmd.convert(i).toString();
      localObject = a((String)localObject);
      if ((localObject != null) && (paramIPCResponse.body.length > 0)) {}
      return null;
    }
    catch (Exception paramIPCResponse)
    {
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
        return null;
      }
      paramIPCResponse = paramIPCResponse;
      return null;
    }
  }
  
  private static JceStruct a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = a.class.getPackage().getName() + ".jce." + paramString;
    paramString = paramString + "Response";
    try
    {
      paramString = (JceStruct)Class.forName(paramString).newInstance();
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
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
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      IPCResponse localIPCResponse = new IPCResponse();
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localIPCResponse.readFrom(paramArrayOfByte);
        paramArrayOfByte = localIPCResponse;
        if (!TextUtils.isEmpty(localIPCResponse.head.hostPackageName))
        {
          localIPCResponse.body = ProtocolPackage.decrypt(localIPCResponse.body, "ji*9^&43U0X-~./(".getBytes());
          return localIPCResponse;
        }
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
    ab.c("IPCPackageTools", "TMAssistantDownloadTaskInfo ......mAppName: " + paramTMAssistantDownloadTaskInfo.mAppName);
    IPCSDKDownloadInfo localIPCSDKDownloadInfo = new IPCSDKDownloadInfo();
    if (paramTMAssistantDownloadTaskInfo != null)
    {
      localIPCSDKDownloadInfo.appId = (paramTMAssistantDownloadTaskInfo.mAppId + "");
      localIPCSDKDownloadInfo.appIconUrl = (paramTMAssistantDownloadTaskInfo.mIconUrl + "");
      localIPCSDKDownloadInfo.appName = (paramTMAssistantDownloadTaskInfo.mAppName + "");
      localIPCSDKDownloadInfo.downloadFinishTime = paramTMAssistantDownloadTaskInfo.mEndTime;
      localIPCSDKDownloadInfo.packageName = (paramTMAssistantDownloadTaskInfo.mTaskPackageName + "");
      localIPCSDKDownloadInfo.via = (paramTMAssistantDownloadTaskInfo.mVia + "");
      localIPCSDKDownloadInfo.versionCode = paramTMAssistantDownloadTaskInfo.mTaskVersionCode;
    }
    localIPCSDKDownloadInfo.appState = paramTMAssistantDownloadTaskInfo.mState;
    localIPCSDKDownloadInfo.receivedLen = paramTMAssistantDownloadTaskInfo.mReceiveDataLen;
    localIPCSDKDownloadInfo.totalLen = paramTMAssistantDownloadTaskInfo.mTotalDataLen;
    localIPCSDKDownloadInfo.url = (paramTMAssistantDownloadTaskInfo.mUrl + "");
    return localIPCSDKDownloadInfo;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.openSDK.param.a
 * JD-Core Version:    0.7.0.1
 */