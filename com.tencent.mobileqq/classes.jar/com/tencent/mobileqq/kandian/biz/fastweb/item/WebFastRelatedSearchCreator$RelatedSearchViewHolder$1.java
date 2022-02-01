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
    QLog.d("WebFastRelatedSearchCreator", 1, new Object[] { "click search word, position = ", Integer.valueOf(this.a), ", word = ", this.b.a, ", jumpUrl = ", this.b.b });
    try
    {
      paramView = new RIJTransMergeKanDianReport.ReportR5Builder().addRowkey(this.c.aR.q).addRelatedSearch(this.b, this.a).addTitle(this.c.aR.j);
      if (RIJArticleInteractBarAladdinConfig.b()) {
        i = 1;
      }
      WebFastRelatedSearchCreator.a("0X800983F", paramView.addAdRelativePos(i).addSid(((RelatedSearchData)this.c).b).build());
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
    }
    if (!TextUtils.isEmpty(this.b.b))
    {
      paramView = new Intent(WebFastRelatedSearchCreator.RelatedSearchViewHolder.a(this.d), ((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
      paramView.putExtra("url", this.b.b);
      WebFastRelatedSearchCreator.RelatedSearchViewHolder.a(this.d).startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.item.WebFastRelatedSearchCreator.RelatedSearchViewHolder.1
 * JD-Core Version:    0.7.0.1
 */