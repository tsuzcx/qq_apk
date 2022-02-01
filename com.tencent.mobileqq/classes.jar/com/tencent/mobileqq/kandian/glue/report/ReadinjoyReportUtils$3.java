package com.tencent.mobileqq.kandian.glue.report;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.gdtad.statistics.GdtC2SReporter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinManager;
import com.tencent.mobileqq.kandian.biz.skin.RefreshData;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
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
    int i = this.a;
    Object localObject2 = "0";
    Object localObject1;
    int j;
    int k;
    if (i == 0)
    {
      localObject1 = this.b;
      if ((localObject1 instanceof BaseActivity)) {
        bool1 = SharedPreUtils.bz((Context)localObject1, ((BaseActivity)localObject1).getCurrentAccountUin());
      } else {
        bool1 = false;
      }
      localObject1 = this.b;
      if ((localObject1 instanceof BaseActivity)) {
        localObject1 = ((ReadInJoySkinManager)((BaseActivity)localObject1).app.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).b();
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
      localObject2 = this.b;
      if ((localObject2 instanceof BaseActivity))
      {
        localObject2 = (ReadInJoyRefreshManager)((BaseActivity)localObject2).app.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        if ((((ReadInJoyRefreshManager)localObject2).d() == 1) && (((ReadInJoyRefreshManager)localObject2).e()))
        {
          localObject1 = ((ReadInJoyRefreshManager)localObject2).c();
          bool1 = ((ReadInJoyRefreshManager)localObject2).b();
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
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder;
    if (this.a != 40677)
    {
      localObject2 = ReadInJoyRefreshManager.b(this.b, 0);
      if (((this.b instanceof BaseActivity)) && (this.a == 0) && (localObject2 != null) && (((RefreshData)localObject2).isAD) && (((RefreshData)localObject2).adExposureReports != null) && (((RefreshData)localObject2).adExposureReports.size() > 0)) {
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
      m = this.a;
      bool2 = this.c;
      if (bool1) {
        k = 1;
      } else {
        k = 0;
      }
      localReportR5Builder = RIJTransMergeKanDianReport.a(m, (String)localObject1, i, j, bool2, k);
      if (this.a == 0) {
        if (localObject2 == null) {
          break label618;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!((RefreshData)localObject2).isAD) {
          break label618;
        }
        k = 1;
        localReportR5Builder.addInt("ad_page", k);
        localReportR5Builder.addInt("banner_refresh_length", this.d);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F8", "0X80066F8", 0, 0, RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"), "", "", localReportR5Builder.build(), false);
      PublicAccountReportUtils.a("0X80066F8", "", "", "", "", RIJTransMergeKanDianReport.b(this.a));
      if (this.a == 70)
      {
        String str = RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid");
        m = this.a;
        bool2 = this.c;
        if (bool1) {
          k = 1;
        } else {
          k = 0;
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009861", "0X8009861", 0, 0, str, "", "", RIJTransMergeKanDianReport.a(m, (String)localObject1, i, j, bool2, k).build(), false);
        PublicAccountReportUtils.a("0X8009861", "", "", "", "", RIJTransMergeKanDianReport.b(this.a));
      }
      return;
      label618:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils.3
 * JD-Core Version:    0.7.0.1
 */