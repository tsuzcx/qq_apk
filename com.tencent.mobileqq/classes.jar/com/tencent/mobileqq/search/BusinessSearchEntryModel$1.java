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
    if (((this.jdField_a_of_type_AndroidViewView.getTag() instanceof Long)) && (l - ((Long)this.jdField_a_of_type_AndroidViewView.getTag()).longValue() < 400L))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setTag(Long.valueOf(l));
    if (this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_c_of_type_JavaLangString.equals("mqqapi://contact/search_might_know")) {
      ReportController.b(null, "dc00898", "", "", "0X800A336", "0X800A336", 0, 0, "", "", "", "");
    }
    Object localObject1;
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_c_of_type_JavaLangString))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_c_of_type_JavaLangString;
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl((String)localObject1)) {
        if (this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_c_of_type_Int == 103)
        {
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("key_refer", 4001);
          PublicFragmentActivity.a(paramView.getContext(), (Intent)localObject1, ((IMiniAppService)QRoute.api(IMiniAppService.class)).getMiniAppSearchFragmentClass());
          i = 0;
          label193:
          if (this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_c_of_type_Int == 1)
          {
            if (i == 0) {
              break label759;
            }
            ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("search", "headentrance", "click", "2", null, null);
          }
        }
      }
    }
    for (;;)
    {
      if (this.b.getVisibility() == 0)
      {
        this.b.setVisibility(8);
        SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_c_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      SearchUtils.a("home_page", "clk_entry", new String[] { this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel.a), String.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_entry").ver2(UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel.a)).ver3(this.jdField_a_of_type_JavaUtilList.size() + "").ver4(this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_a_of_type_JavaLangString).ver7("{experiment_id:" + UniteSearchReportController.b + "}"));
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      new UniteSearchHandler((QQAppInterface)localObject1).b((QQAppInterface)localObject1, "clk_entry", "all_result", UniteSearchReportController.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel.a), "", this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_a_of_type_JavaLangString, "{experiment_id:" + UniteSearchReportController.b + "}");
      UniteSearchReportController.a(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), 0, SearchEntryFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel.a), "0X8009D1C", 0, 0, this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_a_of_type_JavaLangString, null);
      break;
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), (String)localObject1, 2005, null);
      i = 1;
      break label193;
      Object localObject2;
      if ((((String)localObject1).startsWith("http://")) || (((String)localObject1).startsWith("https://")))
      {
        localObject2 = new Intent(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel).startActivity((Intent)localObject2);
        i = 0;
        break label193;
      }
      if ((BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel) instanceof BaseActivity))
      {
        localObject2 = JumpParser.a(((BaseActivity)paramView.getContext()).app, BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), (String)localObject1);
        if (localObject2 != null) {
          ((JumpAction)localObject2).a();
        }
        for (;;)
        {
          i = 0;
          break;
          BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel).startActivity(new Intent(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), JumpActivity.class).setData(Uri.parse((String)localObject1)));
        }
      }
      BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel).startActivity(new Intent(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), JumpActivity.class).setData(Uri.parse((String)localObject1)));
      i = 0;
      break label193;
      label759:
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("search", "headentrance", "click", "1", null, null);
      continue;
      i = this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel.a;
      if (this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel.a == 3) {
        i = 21;
      }
      ActiveEntitySearchActivity.a(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSearchModelBusinessSearchEntryDataModel$SearchEntry.jdField_a_of_type_ArrayOfLong, i);
      if (!NetworkUtil.g(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel))) {
        QQToast.a(BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel), 0, BusinessSearchEntryModel.a(this.jdField_a_of_type_ComTencentMobileqqSearchBusinessSearchEntryModel).getResources().getString(2131718193), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.BusinessSearchEntryModel.1
 * JD-Core Version:    0.7.0.1
 */