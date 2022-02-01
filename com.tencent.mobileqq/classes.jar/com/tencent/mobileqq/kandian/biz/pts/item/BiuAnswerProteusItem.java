package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcImage;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.view.BiuCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.SummaryView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeSummaryView;
import com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import org.json.JSONObject;

public class BiuAnswerProteusItem
  implements ProteusItem
{
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel, ViewBase.OnClickListener paramOnClickListener)
  {
    if ((paramViewBase != null) && (paramIReadInJoyModel != null))
    {
      if (paramIReadInJoyModel.k() == null) {
        return;
      }
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
      if (paramViewBase != null)
      {
        if (paramViewBase.getNativeView() == null) {
          return;
        }
        paramViewBase.setOnClickListener(paramOnClickListener);
      }
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    long l;
    if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) {
      l = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
    } else {
      l = 0L;
    }
    JSONObject localJSONObject = new ProteusItemDataBuilder().a(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, l).f(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, "Biu了").i(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).n(paramAbsBaseArticleInfo).m(paramAbsBaseArticleInfo).o(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).v(paramAbsBaseArticleInfo).w(paramAbsBaseArticleInfo).x(paramAbsBaseArticleInfo).D(paramAbsBaseArticleInfo).C(paramAbsBaseArticleInfo).G(paramAbsBaseArticleInfo).a("ReadInjoy_biu_cell").E(paramAbsBaseArticleInfo).s(paramAbsBaseArticleInfo).I(paramAbsBaseArticleInfo).a();
    if (!ArticleInfoHelper.a(paramAbsBaseArticleInfo)) {
      AnswerProteusItem.a(paramAbsBaseArticleInfo, HardCodeUtil.a(2131899399), localJSONObject);
    }
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    Object localObject1 = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localObject1 != null)
    {
      Object localObject2 = (NativeMiddleBodyView)((ReadInJoyMiddleBodyView)localObject1).getNativeView();
      Object localObject3;
      if ((localObject2 != null) && (((NativeMiddleBodyView)localObject2).getContent() == null))
      {
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        LinearLayout localLinearLayout = new LinearLayout(paramContainer.getContext());
        localLinearLayout.setOrientation(1);
        localLinearLayout.addView(new ComponentContentGridImage(paramContainer.getContext()));
        localLinearLayout.addView(new ComponentContentUgcImage(paramContainer.getContext()));
        ((ReadInJoyMiddleBodyView)localObject1).a((RelativeLayout.LayoutParams)localObject3);
        ((NativeMiddleBodyView)localObject2).a(localLinearLayout, (RelativeLayout.LayoutParams)localObject3);
      }
      if (localObject2 != null)
      {
        localObject1 = (ViewGroup)((NativeMiddleBodyView)localObject2).getContent();
        localObject2 = paramIReadInJoyModel.k();
        paramInt1 = AnswerProteusItem.a((AbsBaseArticleInfo)localObject2);
        localObject2 = AnswerProteusItem.a((AbsBaseArticleInfo)localObject2, paramInt1);
        if (paramInt1 == 0)
        {
          ((ViewGroup)localObject1).setVisibility(8);
        }
        else
        {
          ((ViewGroup)localObject1).setVisibility(0);
          localObject3 = (ComponentContentGridImage)((ViewGroup)localObject1).getChildAt(0);
          localObject1 = (ComponentContentUgcImage)((ViewGroup)localObject1).getChildAt(1);
          if (paramInt1 == 1)
          {
            ((ComponentContentGridImage)localObject3).setVisibility(8);
            ((ComponentContentUgcImage)localObject1).setVisibility(0);
            ((ComponentContentUgcImage)localObject1).a(paramIReadInJoyModel);
          }
          else
          {
            ((ComponentContentGridImage)localObject3).setVisibility(0);
            ((ComponentContentGridImage)localObject3).setMIReadInJoyModel(paramIReadInJoyModel);
            ((ComponentContentUgcImage)localObject1).setVisibility(8);
            ((ComponentContentGridImage)localObject3).a(localObject2);
          }
          ((ComponentContentUgcImage)localObject1).setPicClickListener(new BiuAnswerProteusItem.1(this, paramIReadInJoyModel));
        }
      }
    }
    BindViewHelper.f(localViewBase, paramIReadInJoyModel);
    localObject1 = (BiuCommentView)localViewBase.findViewBaseByName("id_biu_comment");
    if (localObject1 != null) {
      ((BiuCommentView)localObject1).a(paramIReadInJoyModel);
    }
    localObject1 = (SummaryView)localViewBase.findViewBaseByName("id_summary");
    paramContainer = new BiuAnswerProteusItem.2(this, paramIReadInJoyModel, paramContainer);
    if (localObject1 != null)
    {
      ((SummaryView)localObject1).a(paramIReadInJoyModel);
      ((NativeSummaryView)((SummaryView)localObject1).getNativeView()).setShouldCallClick(true);
      ((SummaryView)localObject1).setOnClickListener(paramContainer);
    }
    localObject1 = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((localObject1 != null) && (((NativeButton)localObject1).getNativeView() != null) && ((((NativeButton)localObject1).getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)((NativeButton)localObject1).getNativeView()).setTextColor(-1);
    }
    BindViewHelper.a(localViewBase, paramIReadInJoyModel.k());
    Util.a(localViewBase, paramIReadInJoyModel);
    a(localViewBase, paramIReadInJoyModel, paramContainer);
    Util.b(localViewBase, paramIReadInJoyModel);
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BiuAnswerProteusItem
 * JD-Core Version:    0.7.0.1
 */