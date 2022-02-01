package com.tencent.mobileqq.search.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig.SimpleMiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppLocalSearchEntity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.model.MiniProgramSearchResultModel;
import com.tencent.mobileqq.search.util.SearchReportUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SearchTemplatePresenter$2
  implements View.OnClickListener
{
  SearchTemplatePresenter$2(SearchTemplatePresenter paramSearchTemplatePresenter, MiniProgramSearchResultModel paramMiniProgramSearchResultModel) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
    Object localObject = new SimpleMiniAppConfig.SimpleMiniAppInfo();
    ((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject).appId = this.a.a.appId;
    SimpleMiniAppConfig localSimpleMiniAppConfig = new SimpleMiniAppConfig((SimpleMiniAppConfig.SimpleMiniAppInfo)localObject);
    if (this.a.a.showMask == 1) {
      localObject = "used";
    } else {
      localObject = "unused";
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async(localSimpleMiniAppConfig, "search", "result_click", (String)localObject, this.a.g());
    SearchReportUtil.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.presenter.SearchTemplatePresenter.2
 * JD-Core Version:    0.7.0.1
 */