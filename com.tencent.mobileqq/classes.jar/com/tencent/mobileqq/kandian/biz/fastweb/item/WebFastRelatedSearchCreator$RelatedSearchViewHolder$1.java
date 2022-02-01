package com.tencent.mobileqq.kandian.biz.fastweb.item;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJArticleInteractBarAladdinConfig;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.RelatedSearchData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.RelatedSearchData.SearchWord;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

class WebFastRelatedSearchCreator$RelatedSearchViewHolder$1
  implements View.OnClickListener
{
  WebFastRelatedSearchCreator$RelatedSearchViewHolder$1(WebFastRelatedSearchCreator.RelatedSearchViewHolder paramRelatedSearchViewHolder, int paramInt, RelatedSearchData.SearchWord paramSearchWord, BaseData paramBaseData) {}
  
  public void onClick(View paramView)
  {
    int i = 0;
    QLog.d("WebFastRelatedSearchCreator", 1, new Object[] { "click search word, position = ", Integer.valueOf(this.jdField_a_of_type_Int), ", word = ", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityRelatedSearchData$SearchWord.a, ", jumpUrl = ", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityRelatedSearchData$SearchWord.b });
    try
    {
      paramView = new RIJTransMergeKanDianReport.ReportR5Builder().addRowkey(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.a.j).addRelatedSearch(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityRelatedSearchData$SearchWord, this.jdField_a_of_type_Int).addTitle(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData.a.c);
      if (RIJArticleInteractBarAladdinConfig.b()) {
        i = 1;
      }
      WebFastRelatedSearchCreator.a("0X800983F", paramView.addAdRelativePos(i).addSid(((RelatedSearchData)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData).a).build());
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityRelatedSearchData$SearchWord.b))
    {
      paramView = new Intent(WebFastRelatedSearchCreator.RelatedSearchViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebFastRelatedSearchCreator$RelatedSearchViewHolder), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebEntityRelatedSearchData$SearchWord.b);
      WebFastRelatedSearchCreator.RelatedSearchViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebItemWebFastRelatedSearchCreator$RelatedSearchViewHolder).startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastRelatedSearchCreator.RelatedSearchViewHolder.1
 * JD-Core Version:    0.7.0.1
 */