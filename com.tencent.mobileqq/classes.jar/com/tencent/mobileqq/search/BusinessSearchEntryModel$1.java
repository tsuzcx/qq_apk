package com.tencent.mobileqq.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.BusinessSearchEntryDataModel.SearchEntry;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class BusinessSearchEntryModel$1
  implements View.OnClickListener
{
  BusinessSearchEntryModel$1(BusinessSearchEntryModel paramBusinessSearchEntryModel, View paramView1, BusinessSearchEntryDataModel.SearchEntry paramSearchEntry, View paramView2, String paramString, List paramList) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if ((!(this.a.getTag() instanceof Long)) || (l - ((Long)this.a.getTag()).longValue() >= 400L))
    {
      this.a.setTag(Long.valueOf(l));
      if (this.b.d.equals("mqqapi://contact/search_might_know")) {
        ReportController.b(null, "dc00898", "", "", "0X800A336", "0X800A336", 0, 0, "", "", "", "");
      }
      int i;
      if (!TextUtils.isEmpty(this.b.d))
      {
        localObject1 = this.b.d;
        if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl((String)localObject1))
        {
          if (this.b.g == 103)
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("key_refer", 4001);
            PublicFragmentActivity.a(paramView.getContext(), (Intent)localObject1, ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppSearchFragmentClass());
          }
          else
          {
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(BusinessSearchEntryModel.a(this.f), (String)localObject1, 2005, null);
            i = 1;
            break label411;
          }
        }
        else if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://")))
        {
          if ((BusinessSearchEntryModel.a(this.f) instanceof BaseActivity))
          {
            localObject2 = JumpParser.a(((BaseActivity)paramView.getContext()).app, BusinessSearchEntryModel.a(this.f), (String)localObject1);
            if (localObject2 != null) {
              ((JumpAction)localObject2).a();
            } else {
              BusinessSearchEntryModel.a(this.f).startActivity(new Intent(BusinessSearchEntryModel.a(this.f), JumpActivity.class).setData(Uri.parse((String)localObject1)));
            }
          }
          else
          {
            BusinessSearchEntryModel.a(this.f).startActivity(new Intent(BusinessSearchEntryModel.a(this.f), JumpActivity.class).setData(Uri.parse((String)localObject1)));
          }
        }
        else
        {
          localObject2 = new Intent(BusinessSearchEntryModel.a(this.f), QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          BusinessSearchEntryModel.a(this.f).startActivity((Intent)localObject2);
        }
        i = 0;
        label411:
        if (this.b.g == 1) {
          if (i != 0) {
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("search", "headentrance", "click", "2", null, null);
          } else {
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("search", "headentrance", "click", "1", null, null);
          }
        }
      }
      else
      {
        i = this.f.a;
        if (this.f.a == 3) {
          i = 21;
        }
        ActiveEntitySearchActivity.a(BusinessSearchEntryModel.a(this.f), this.b.a, this.b.c, i);
        if (!NetworkUtil.isNetworkAvailable(BusinessSearchEntryModel.a(this.f))) {
          QQToast.makeText(BusinessSearchEntryModel.a(this.f), 0, BusinessSearchEntryModel.a(this.f).getResources().getString(2131915328), 0).show();
        }
      }
      if (this.c.getVisibility() == 0)
      {
        this.c.setVisibility(8);
        SharedPreUtils.c(this.b.g, this.d);
      }
      SearchUtils.a("home_page", "clk_entry", new String[] { this.b.a, String.valueOf(this.f.a), String.valueOf(this.e.size()) });
      Object localObject1 = new ReportModelDC02528().module("all_result").action("clk_entry").ver2(UniteSearchReportController.a(this.f.a));
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.e.size());
      ((StringBuilder)localObject2).append("");
      localObject1 = ((ReportModelDC02528)localObject1).ver3(((StringBuilder)localObject2).toString()).ver4(this.b.a);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("{experiment_id:");
      ((StringBuilder)localObject2).append(UniteSearchReportController.b);
      ((StringBuilder)localObject2).append("}");
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject1).ver7(((StringBuilder)localObject2).toString()));
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject2 = new UniteSearchHandler((QQAppInterface)localObject1);
      String str1 = UniteSearchReportController.a(this.f.a);
      String str2 = this.b.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{experiment_id:");
      localStringBuilder.append(UniteSearchReportController.b);
      localStringBuilder.append("}");
      ((UniteSearchHandler)localObject2).b((QQAppInterface)localObject1, "clk_entry", "all_result", str1, "", str2, localStringBuilder.toString());
      UniteSearchReportController.a(BusinessSearchEntryModel.b(this.f), 0, SearchEntryFragment.b(this.f.a), "0X8009D1C", 0, 0, this.b.a, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.BusinessSearchEntryModel.1
 * JD-Core Version:    0.7.0.1
 */