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
      if ((paramList == null) || (TextUtils.isEmpty(paramList.packageName)))
      {
        ab.e("GetAppInfoEngine_", "transFrom packageName is empty");
      }
      else
      {
        AppDetailSdkReqInfo localAppDetailSdkReqInfo = new AppDetailSdkReqInfo();
        localAppDetailSdkReqInfo.packageName = paramList.packageName;
        if (paramList.channelId == null) {}
        for (paramList = "";; paramList = paramList.channelId)
        {
          localAppDetailSdkReqInfo.channelId = paramList;
          localArrayList.add(localAppDetailSdkReqInfo);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt, GetAppDetailForSdkResponse paramGetAppDetailForSdkResponse, IGetAppInfoCallback paramIGetAppInfoCallback)
  {
    try
    {
      ab.c("GetAppInfoEngine_", "doNotify , reqId=" + paramInt + ", ret=" + paramGetAppDetailForSdkResponse.ret + ",size = " + paramGetAppDetailForSdkResponse.detailList);
      paramIGetAppInfoCallback.onGetAppInfoResponse(paramInt, paramGetAppDetailForSdkResponse.ret, b(paramGetAppDetailForSdkResponse.detailList));
      return;
    }
    catch (Throwable paramIGetAppInfoCallback)
    {
      ab.c("GetAppInfoEngine_", "doNotify failed, reqId=" + paramInt + ", ret=" + paramGetAppDetailForSdkResponse.ret, paramIGetAppInfoCallback);
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
    ab.c("GetAppInfoEngine_", "request reqParam=" + paramAppDetailReqParam + ", callback=" + paramIGetAppInfoCallback);
    int i;
    if ((paramAppDetailReqParam == null) || (paramAppDetailReqParam.apps == null) || (paramAppDetailReqParam.apps.size() == 0))
    {
      ab.e("GetAppInfoEngine_", "bad req params");
      i = -1;
      return i;
    }
    GetAppDetailForSdkRequest localGetAppDetailForSdkRequest = new GetAppDetailForSdkRequest();
    if (paramAppDetailReqParam.biz == null) {}
    for (String str = "";; str = paramAppDetailReqParam.biz)
    {
      localGetAppDetailForSdkRequest.biz = str;
      localGetAppDetailForSdkRequest.reqList = a(paramAppDetailReqParam.apps);
      int j = a(localGetAppDetailForSdkRequest);
      i = j;
      if (j < 0) {
        break;
      }
      i = j;
      if (paramIGetAppInfoCallback == null) {
        break;
      }
      this.a.put(Integer.valueOf(j), paramIGetAppInfoCallback);
      return j;
    }
  }
  
  public void a(int paramInt1, int paramInt2, JceStruct paramJceStruct1, JceStruct paramJceStruct2)
  {
    ab.c("GetAppInfoEngine_", ">>onFinish reqId=" + paramInt1 + " errorCode=" + paramInt2 + " request=" + paramJceStruct1 + " response=" + paramJceStruct2);
    IGetAppInfoCallback localIGetAppInfoCallback = (IGetAppInfoCallback)this.a.remove(Integer.valueOf(paramInt1));
    if (localIGetAppInfoCallback == null)
    {
      ab.e("GetAppInfoEngine_", "cb is null, need't call back anymore.");
      return;
    }
    if ((paramInt2 == 0) && ((paramJceStruct2 instanceof GetAppDetailForSdkResponse))) {
      paramJceStruct1 = (GetAppDetailForSdkResponse)paramJceStruct2;
    }
    for (;;)
    {
      a(paramInt1, paramJceStruct1, localIGetAppInfoCallback);
      return;
      paramJceStruct1 = new GetAppDetailForSdkResponse();
      paramJceStruct1.ret = -1;
      paramJceStruct1.detailList = new ArrayList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.appinfo.a.a
 * JD-Core Version:    0.7.0.1
 */