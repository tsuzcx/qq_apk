package com.tencent.tmassistant.appinfo.a;

import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.appinfo.aidl.IGetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import com.tencent.tmassistant.appinfo.data.AppDetailReqParam;
import com.tencent.tmassistant.appinfo.data.AppParam;
import com.tencent.tmassistant.common.jce.AppDetailSdkInfo;
import com.tencent.tmassistant.common.jce.AppDetailSdkReqInfo;
import com.tencent.tmassistant.common.jce.GetAppDetailForSdkRequest;
import com.tencent.tmassistant.common.jce.GetAppDetailForSdkResponse;
import com.tencent.tmassistantbase.util.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a
  extends com.tencent.tmassistantbase.network.a
{
  private Map<Integer, IGetAppInfoCallback> a = new ConcurrentHashMap();
  
  public a()
  {
    super(GetAppDetailForSdkRequest.class, GetAppDetailForSdkResponse.class);
  }
  
  private static ArrayList<AppDetailSdkReqInfo> a(List<AppParam> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (AppParam)localIterator.next();
      if ((paramList != null) && (!TextUtils.isEmpty(paramList.packageName)))
      {
        AppDetailSdkReqInfo localAppDetailSdkReqInfo = new AppDetailSdkReqInfo();
        localAppDetailSdkReqInfo.packageName = paramList.packageName;
        if (paramList.channelId == null) {
          paramList = "";
        } else {
          paramList = paramList.channelId;
        }
        localAppDetailSdkReqInfo.channelId = paramList;
        localArrayList.add(localAppDetailSdkReqInfo);
      }
      else
      {
        ab.e("GetAppInfoEngine_", "transFrom packageName is empty");
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt, GetAppDetailForSdkResponse paramGetAppDetailForSdkResponse, IGetAppInfoCallback paramIGetAppInfoCallback)
  {
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNotify , reqId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ret=");
      localStringBuilder.append(paramGetAppDetailForSdkResponse.ret);
      localStringBuilder.append(",size = ");
      localStringBuilder.append(paramGetAppDetailForSdkResponse.detailList);
      ab.c("GetAppInfoEngine_", localStringBuilder.toString());
      paramIGetAppInfoCallback.onGetAppInfoResponse(paramInt, paramGetAppDetailForSdkResponse.ret, b(paramGetAppDetailForSdkResponse.detailList));
      return;
    }
    catch (Throwable paramIGetAppInfoCallback)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doNotify failed, reqId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ret=");
      localStringBuilder.append(paramGetAppDetailForSdkResponse.ret);
      ab.c("GetAppInfoEngine_", localStringBuilder.toString(), paramIGetAppInfoCallback);
    }
  }
  
  private static ArrayList<AppDetail> b(List<AppDetailSdkInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AppDetailSdkInfo localAppDetailSdkInfo = (AppDetailSdkInfo)paramList.next();
      AppDetail localAppDetail = new AppDetail();
      localAppDetail.appId = localAppDetailSdkInfo.appId;
      localAppDetail.apkId = localAppDetailSdkInfo.apkId;
      localAppDetail.appName = localAppDetailSdkInfo.appName;
      localAppDetail.iconUrl = localAppDetailSdkInfo.iconUrl;
      localAppDetail.packageName = localAppDetailSdkInfo.packageName;
      localAppDetail.versionCode = localAppDetailSdkInfo.versionCode;
      localAppDetail.signatureMd5 = localAppDetailSdkInfo.signatureMd5;
      localAppDetail.apkMd5 = localAppDetailSdkInfo.apkMd5;
      localAppDetail.fileSize = localAppDetailSdkInfo.fileSize;
      localAppDetail.apkDownUrl = localAppDetailSdkInfo.apkDownUrl;
      localAppDetail.channelId = localAppDetailSdkInfo.channelId;
      localArrayList.add(localAppDetail);
    }
    return localArrayList;
  }
  
  public int a(AppDetailReqParam paramAppDetailReqParam, IGetAppInfoCallback paramIGetAppInfoCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("request reqParam=");
    ((StringBuilder)localObject).append(paramAppDetailReqParam);
    ((StringBuilder)localObject).append(", callback=");
    ((StringBuilder)localObject).append(paramIGetAppInfoCallback);
    ab.c("GetAppInfoEngine_", ((StringBuilder)localObject).toString());
    if ((paramAppDetailReqParam != null) && (paramAppDetailReqParam.apps != null) && (paramAppDetailReqParam.apps.size() != 0))
    {
      GetAppDetailForSdkRequest localGetAppDetailForSdkRequest = new GetAppDetailForSdkRequest();
      if (paramAppDetailReqParam.biz == null) {
        localObject = "";
      } else {
        localObject = paramAppDetailReqParam.biz;
      }
      localGetAppDetailForSdkRequest.biz = ((String)localObject);
      localGetAppDetailForSdkRequest.reqList = a(paramAppDetailReqParam.apps);
      int i = a(localGetAppDetailForSdkRequest);
      if ((i >= 0) && (paramIGetAppInfoCallback != null)) {
        this.a.put(Integer.valueOf(i), paramIGetAppInfoCallback);
      }
      return i;
    }
    ab.e("GetAppInfoEngine_", "bad req params");
    return -1;
  }
  
  public void a(int paramInt1, int paramInt2, JceStruct paramJceStruct1, JceStruct paramJceStruct2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(">>onFinish reqId=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" errorCode=");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" request=");
    ((StringBuilder)localObject).append(paramJceStruct1);
    ((StringBuilder)localObject).append(" response=");
    ((StringBuilder)localObject).append(paramJceStruct2);
    ab.c("GetAppInfoEngine_", ((StringBuilder)localObject).toString());
    localObject = (IGetAppInfoCallback)this.a.remove(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      ab.e("GetAppInfoEngine_", "cb is null, need't call back anymore.");
      return;
    }
    if ((paramInt2 == 0) && ((paramJceStruct2 instanceof GetAppDetailForSdkResponse)))
    {
      paramJceStruct1 = (GetAppDetailForSdkResponse)paramJceStruct2;
    }
    else
    {
      paramJceStruct1 = new GetAppDetailForSdkResponse();
      paramJceStruct1.ret = -1;
      paramJceStruct1.detailList = new ArrayList();
    }
    a(paramInt1, paramJceStruct1, (IGetAppInfoCallback)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.a.a
 * JD-Core Version:    0.7.0.1
 */