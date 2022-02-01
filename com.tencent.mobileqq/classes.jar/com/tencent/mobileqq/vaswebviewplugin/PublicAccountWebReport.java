package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tencent.im.oidb.ac.ArticleComment.ReportNetConnectInfoRequest;
import tencent.im.oidb.ac.ArticleComment.ReportNetConnectInfoResponse;
import tencent.im.oidb.ac.ArticleComment.RetInfo;

public class PublicAccountWebReport
{
  public static final String TAG = "PublicAccountWebReport";
  public static final int THRESHOLD_2G = 4000;
  public static final int THRESHOLD_3G = 3000;
  public static final int THRESHOLD_4G = 2000;
  public static final int THRESHOLD_WIFI = 2000;
  
  public static void handlereportPublicAccountNetInfoResponse(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramIntent = new ArticleComment.ReportNetConnectInfoResponse();
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
  }
  
  public static boolean netShouldReport(int paramInt)
  {
    int i = NetUtil.a(null);
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
        {
          if (i != 4) {
            return false;
          }
          if (paramInt <= 2000) {
            break label66;
          }
        }
      }
    }
    while (paramInt > 2000) {
      for (;;)
      {
        return true;
        if (paramInt <= 3000) {
          break;
        }
        continue;
        if (paramInt <= 4000) {
          break;
        }
      }
    }
    label66:
    return false;
  }
  
  public static void reportPublicAccountNetInfoRequest(AppRuntime paramAppRuntime, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2)
  {
    int i = NetUtil.a(null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("urlStr: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",errorcode:");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append(",netType:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",DNSCost");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",connectCost:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",receiveCost:");
      ((StringBuilder)localObject).append(paramInt4);
      ((StringBuilder)localObject).append(",website_address:");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",AppSetting.subVersion:");
      ((StringBuilder)localObject).append("8.7.0,3,5295");
      QLog.i("PublicAccountWebReport", 2, ((StringBuilder)localObject).toString());
    }
    if (paramAppRuntime == null) {
      return;
    }
    if (!netShouldReport(paramInt1 + paramInt2 + paramInt4)) {
      return;
    }
    Object localObject = new NewIntent(BaseApplication.getContext(), ((IPublicAccountServlet)QRoute.api(IPublicAccountServlet.class)).getServletClass());
    ((NewIntent)localObject).putExtra("cmd", "PubAccountSvc.net_connect_info");
    ArticleComment.ReportNetConnectInfoRequest localReportNetConnectInfoRequest = new ArticleComment.ReportNetConnectInfoRequest();
    localReportNetConnectInfoRequest.netType.set(i);
    localReportNetConnectInfoRequest.versionInfo.set("8.7.0,3,5295");
    localReportNetConnectInfoRequest.connectCost.set(paramInt1);
    localReportNetConnectInfoRequest.DNSCost.set(paramInt2);
    localReportNetConnectInfoRequest.errorcode.set(paramInt3);
    localReportNetConnectInfoRequest.receiveCost.set(paramInt4);
    paramString1 = ByteStringMicro.copyFromUtf8(paramString1);
    localReportNetConnectInfoRequest.url.set(paramString1);
    localReportNetConnectInfoRequest.website_address.set(paramString2);
    ((NewIntent)localObject).putExtra("data", localReportNetConnectInfoRequest.toByteArray());
    paramAppRuntime.startServlet((NewIntent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.PublicAccountWebReport
 * JD-Core Version:    0.7.0.1
 */