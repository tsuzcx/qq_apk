package com.tencent.mobileqq.kandian.glue.report;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.skin.RefreshData;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.List;
import org.json.JSONException;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.ThirdPartyMonitorUrls;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

final class ReadinjoyReportUtils$3
  implements Runnable
{
  ReadinjoyReportUtils$3(int paramInt1, Activity paramActivity, boolean paramBoolean, int paramInt2) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject2 = "0";
    Object localObject1;
    int j;
    int k;
    if (i == 0)
    {
      localObject1 = this.jdField_a_of_type_AndroidAppActivity;
      if ((localObject1 instanceof BaseActivity)) {
        bool1 = SharedPreUtils.p((Context)localObject1, ((BaseActivity)localObject1).getCurrentAccountUin());
      } else {
        bool1 = false;
      }
      localObject1 = this.jdField_a_of_type_AndroidAppActivity;
      if ((localObject1 instanceof BaseActivity)) {
        localObject1 = ((ReadInJoySkinManager)((BaseActivity)localObject1).app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a();
      } else {
        localObject1 = "0";
      }
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals("0")))
      {
        if (bool1) {
          j = 1;
        } else {
          j = 2;
        }
        i = 1;
      }
      else
      {
        j = 0;
        i = 0;
        localObject1 = localObject2;
      }
      localObject2 = this.jdField_a_of_type_AndroidAppActivity;
      if ((localObject2 instanceof BaseActivity))
      {
        localObject2 = (ReadInJoyRefreshManager)((BaseActivity)localObject2).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        if ((((ReadInJoyRefreshManager)localObject2).a() == 1) && (((ReadInJoyRefreshManager)localObject2).b()))
        {
          localObject1 = ((ReadInJoyRefreshManager)localObject2).a();
          bool1 = ((ReadInJoyRefreshManager)localObject2).a();
          i = 0;
          j = 2;
          break label228;
        }
      }
      k = i;
      i = j;
      j = k;
    }
    else
    {
      i = 0;
      j = 0;
      localObject1 = localObject2;
    }
    boolean bool1 = false;
    label228:
    int m;
    boolean bool2;
    Object localObject3;
    if (this.jdField_a_of_type_Int != 40677)
    {
      localObject2 = ReadInJoyRefreshManager.b(this.jdField_a_of_type_AndroidAppActivity, 0);
      if (((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) && (this.jdField_a_of_type_Int == 0) && (localObject2 != null) && (((RefreshData)localObject2).isAD) && (((RefreshData)localObject2).adExposureReports != null) && (((RefreshData)localObject2).adExposureReports.size() > 0)) {
        try
        {
          qq_ad_get.QQAdGetRsp.AdInfo localAdInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
          long l = ((RefreshData)localObject2).adId.longValue();
          localAdInfo.report_info.trace_info.aid.set(l);
          localAdInfo.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(((RefreshData)localObject2).getUrls(((RefreshData)localObject2).adExposureReports));
          GdtC2SReporter.a(0, 1, localAdInfo);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localNumberFormatException.printStackTrace();
        }
      }
      m = this.jdField_a_of_type_Int;
      bool2 = this.jdField_a_of_type_Boolean;
      if (bool1) {
        k = 1;
      } else {
        k = 0;
      }
      localObject3 = RIJTransMergeKanDianReport.a(m, (String)localObject1, i, j, bool2, k);
      if (this.jdField_a_of_type_Int == 0) {
        if (localObject2 == null) {
          break label682;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!((RefreshData)localObject2).isAD) {
          break label682;
        }
        k = 1;
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).addInt("ad_page", k);
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).addInt("banner_refresh_length", this.b);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066F8", "0X80066F8", 0, 0, ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("default_feeds_proteus_offline_bid"), "", "", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject3).build(), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066F8", "", "", "", "", RIJTransMergeKanDianReport.b(this.jdField_a_of_type_Int));
      if (this.jdField_a_of_type_Int == 70)
      {
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        localObject3 = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).getProteusOfflineBid("default_feeds_proteus_offline_bid");
        m = this.jdField_a_of_type_Int;
        bool2 = this.jdField_a_of_type_Boolean;
        if (bool1) {
          k = 1;
        } else {
          k = 0;
        }
        localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8009861", "0X8009861", 0, 0, (String)localObject3, "", "", RIJTransMergeKanDianReport.a(m, (String)localObject1, i, j, bool2, k).build(), false);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8009861", "", "", "", "", RIJTransMergeKanDianReport.b(this.jdField_a_of_type_Int));
      }
      return;
      label682:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.3
 * JD-Core Version:    0.7.0.1
 */