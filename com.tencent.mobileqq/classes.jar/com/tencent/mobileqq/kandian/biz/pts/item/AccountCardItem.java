package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.view.ArticleCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import org.json.JSONObject;

public class AccountCardItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return null;
    }
    long l;
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)) {
      l = paramAbsBaseArticleInfo.mSocialFeedInfo.s.e;
    } else {
      l = 0L;
    }
    return new ProteusItemDataBuilder().a(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, l).f(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo).i(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).C(paramAbsBaseArticleInfo).q(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).v(paramAbsBaseArticleInfo).w(paramAbsBaseArticleInfo).A(paramAbsBaseArticleInfo).B(paramAbsBaseArticleInfo).a("ReadInjoy_original_cell").F(paramAbsBaseArticleInfo).E(paramAbsBaseArticleInfo).H(paramAbsBaseArticleInfo).I(paramAbsBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    BindViewHelper.f(paramContainer, paramIReadInJoyModel);
    ArticleCommentView localArticleCommentView = (ArticleCommentView)paramContainer.findViewBaseByName("id_article_comment");
    if (localArticleCommentView != null) {
      localArticleCommentView.a(paramIReadInJoyModel);
    }
    BindViewHelper.a(paramContainer, paramIReadInJoyModel.k());
    Util.a(paramContainer, paramIReadInJoyModel);
    BindViewHelper.c(paramContainer, paramIReadInJoyModel);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.AccountCardItem
 * JD-Core Version:    0.7.0.1
 */