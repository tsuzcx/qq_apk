package com.tencent.replacemonitor.replace;

import com.qq.taf.jce.JceStruct;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.jce.GetMobilePhoneQqApkInfoRequest;
import com.tencent.replacemonitor.jce.GetMobilePhoneQqApkInfoResponse;
import com.tencent.tmassistantbase.util.ab;

public class a
  extends com.tencent.tmassistantbase.network.a
{
  private b a;
  
  public a(b paramb)
  {
    super(GetMobilePhoneQqApkInfoRequest.class, GetMobilePhoneQqApkInfoResponse.class);
    this.a = paramb;
  }
  
  public int a(MonitorTask paramMonitorTask)
  {
    GetMobilePhoneQqApkInfoRequest localGetMobilePhoneQqApkInfoRequest = new GetMobilePhoneQqApkInfoRequest();
    localGetMobilePhoneQqApkInfoRequest.apkId = paramMonitorTask.yybApkId;
    localGetMobilePhoneQqApkInfoRequest.appId = paramMonitorTask.yybAppId;
    localGetMobilePhoneQqApkInfoRequest.pkgName = paramMonitorTask.packageName;
    localGetMobilePhoneQqApkInfoRequest.downloadUrl = paramMonitorTask.downloadUrl;
    return a(localGetMobilePhoneQqApkInfoRequest);
  }
  
  public void a(int paramInt1, int paramInt2, JceStruct paramJceStruct1, JceStruct paramJceStruct2)
  {
    ab.c("WashMonitor", "GetMonitorInfoEngine>>onFinish reqId=" + paramInt1 + " errorCode=" + paramInt2 + " request=" + paramJceStruct1 + " response=" + paramJceStruct2);
    if ((paramInt2 == 0) && ((paramJceStruct2 instanceof GetMobilePhoneQqApkInfoResponse)))
    {
      paramJceStruct1 = (GetMobilePhoneQqApkInfoResponse)paramJceStruct2;
      if (paramJceStruct1.ret == 0)
      {
        ab.c("WashMonitor", "GetMonitorInfoEngine>>onFinish success");
        this.a.a(paramInt1, paramJceStruct1.strategy, paramJceStruct1.fileSize, paramJceStruct1.apkMd5, paramJceStruct1.maxFileSize, paramJceStruct1.channelId);
        return;
      }
      ab.c("WashMonitor", "GetMonitorInfoEngine>>onFinish failed ret = " + paramJceStruct1.ret + " retMsg=" + paramJceStruct1.msg);
      this.a.a(paramInt1, paramJceStruct1.ret, paramJceStruct1.msg);
      return;
    }
    this.a.a(paramInt1, paramInt2, "response is " + paramJceStruct2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.a
 * JD-Core Version:    0.7.0.1
 */