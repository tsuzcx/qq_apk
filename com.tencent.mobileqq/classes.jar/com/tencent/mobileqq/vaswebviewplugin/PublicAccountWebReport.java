package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import bcxh;
import com.tencent.mobileqq.ac.ArticleComment.ReportNetConnectInfoRequest;
import com.tencent.mobileqq.ac.ArticleComment.ReportNetConnectInfoResponse;
import com.tencent.mobileqq.ac.ArticleComment.RetInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import nou;

public class PublicAccountWebReport
{
  public static final String TAG = "PublicAccountWebReport";
  public static final int THRESHOLD_2G = 4000;
  public static final int THRESHOLD_3G = 3000;
  public static final int THRESHOLD_4G = 2000;
  public static final int THRESHOLD_WIFI = 2000;
  
  public static void handlereportPublicAccountNetInfoResponse(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      paramIntent = new ArticleComment.ReportNetConnectInfoResponse();
    }
    try
    {
      paramIntent.mergeFrom((byte[])paramObject);
      paramIntent.ret.ret_code.get();
      return;
    }
    catch (Exception paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public static boolean netShouldReport(int paramInt)
  {
    boolean bool = true;
    switch (bcxh.a(null))
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool;
          } while (paramInt > 2000);
          return false;
        } while (paramInt > 2000);
        return false;
      } while (paramInt > 3000);
      return false;
    } while (paramInt > 4000);
    return false;
  }
  
  public static void reportPublicAccountNetInfoRequest(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    int i = bcxh.a(null);
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountWebReport", 2, "urlStr: " + paramString1 + ",errorcode:" + paramInt3 + ",netType:" + i + ",DNSCost" + paramInt2 + ",connectCost:" + paramInt1 + ",receiveCost:" + paramInt4 + ",website_address:" + paramString2 + ",AppSetting.subVersion:" + "8.2.8,3,4440");
    }
    if (paramAppRuntime == null) {}
    while (!netShouldReport(paramInt1 + paramInt2 + paramInt4)) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(BaseApplication.getContext(), nou.class);
    localNewIntent.putExtra("cmd", "PubAccountSvc.net_connect_info");
    ArticleComment.ReportNetConnectInfoRequest localReportNetConnectInfoRequest = new ArticleComment.ReportNetConnectInfoRequest();
    localReportNetConnectInfoRequest.netType.set(i);
    localReportNetConnectInfoRequest.versionInfo.set("8.2.8,3,4440");
    localReportNetConnectInfoRequest.connectCost.set(paramInt1);
    localReportNetConnectInfoRequest.DNSCost.set(paramInt2);
    localReportNetConnectInfoRequest.errorcode.set(paramInt3);
    localReportNetConnectInfoRequest.receiveCost.set(paramInt4);
    paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
    localReportNetConnectInfoRequest.url.set(paramString1);
    localReportNetConnectInfoRequest.website_address.set(paramString2);
    localNewIntent.putExtra("data", localReportNetConnectInfoRequest.toByteArray());
    paramAppRuntime.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.PublicAccountWebReport
 * JD-Core Version:    0.7.0.1
 */