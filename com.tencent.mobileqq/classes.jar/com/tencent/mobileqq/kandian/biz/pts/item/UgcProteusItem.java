package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButtonImp;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUGCVoice;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcImage;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentUgcVideo;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentView;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.view.ArticleCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import org.json.JSONObject;

public class UgcProteusItem
  implements ProteusItem
{
  protected View a(int paramInt, Context paramContext)
  {
    if (paramInt != 22)
    {
      if (paramInt != 23) {
        if (paramInt != 36)
        {
          if (paramInt == 80) {
            break label65;
          }
          if (paramInt != 107)
          {
            if (paramInt != 120) {
              return null;
            }
          }
          else {
            return new ComponentContentUGCVoice(paramContext);
          }
        }
        else
        {
          return new ComponentContentGridImage(paramContext);
        }
      }
      return new ComponentContentUgcVideo(paramContext);
    }
    label65:
    return new ComponentContentUgcImage(paramContext);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    long l;
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a != null)) {
      l = paramAbsBaseArticleInfo.mSocialFeedInfo.a.a;
    } else {
      l = 0L;
    }
    return new ProteusItemDataBuilder().a(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, l).f(paramAbsBaseArticleInfo).p(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo).i(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).C(paramAbsBaseArticleInfo).q(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).v(paramAbsBaseArticleInfo).w(paramAbsBaseArticleInfo).x(paramAbsBaseArticleInfo).y(paramAbsBaseArticleInfo).A(paramAbsBaseArticleInfo).B(paramAbsBaseArticleInfo).D(paramAbsBaseArticleInfo).a("ReadInjoy_original_cell").E(paramAbsBaseArticleInfo).H(paramAbsBaseArticleInfo).L(paramAbsBaseArticleInfo).l(paramAbsBaseArticleInfo).I(paramAbsBaseArticleInfo).t(paramAbsBaseArticleInfo).u(paramAbsBaseArticleInfo).O(paramAbsBaseArticleInfo).P(paramAbsBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    ReadInJoyMiddleBodyView localReadInJoyMiddleBodyView = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localReadInJoyMiddleBodyView != null)
    {
      NativeMiddleBodyView localNativeMiddleBodyView = (NativeMiddleBodyView)localReadInJoyMiddleBodyView.getNativeView();
      if (localNativeMiddleBodyView.a() == null)
      {
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localReadInJoyMiddleBodyView.a(localLayoutParams);
        paramContainer = a(paramInt1, paramContainer.getContext());
        if (paramContainer != null) {
          localNativeMiddleBodyView.a(paramContainer, localLayoutParams);
        }
      }
      a(paramInt1, paramIReadInJoyModel, localNativeMiddleBodyView);
    }
    BindViewHelper.f(localViewBase, paramIReadInJoyModel);
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    paramContainer = (ArticleCommentView)localViewBase.findViewBaseByName("id_article_comment");
    if (paramContainer != null) {
      paramContainer.a(paramIReadInJoyModel);
    }
    BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
    Util.a(localViewBase, paramIReadInJoyModel);
    BindViewHelper.b(localViewBase, paramIReadInJoyModel);
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
  }
  
  protected void a(int paramInt, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView)
  {
    if (paramNativeMiddleBodyView.a() != null)
    {
      if (paramIReadInJoyModel.a() == null) {
        return;
      }
      ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)paramIReadInJoyModel.a();
      if (paramInt != 22)
      {
        if (paramInt != 23) {
          if (paramInt != 36)
          {
            if (paramInt == 80) {
              break label201;
            }
            if (paramInt != 107)
            {
              if (paramInt != 120)
              {
                paramIReadInJoyModel = new StringBuilder();
                paramIReadInJoyModel.append("");
                paramIReadInJoyModel.append(paramInt);
                throw new IllegalArgumentException(paramIReadInJoyModel.toString());
              }
            }
            else {
              ((ComponentContentUGCVoice)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
            }
          }
          else
          {
            paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
            ComponentContentGridImage localComponentContentGridImage = (ComponentContentGridImage)paramNativeMiddleBodyView;
            localComponentContentGridImage.setMIReadInJoyModel(paramIReadInJoyModel);
            paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramIReadInJoyModel.a()));
            localComponentContentGridImage.setOnNoItemClickListener(new UgcProteusItem.1(this, paramIReadInJoyModel, localReadInJoyBaseAdapter));
            return;
          }
        }
        paramNativeMiddleBodyView = (ComponentContentUgcVideo)paramNativeMiddleBodyView.a();
        paramNativeMiddleBodyView.a(paramIReadInJoyModel);
        ((ComponentContentUgcVideo)paramNativeMiddleBodyView).setOnClickListener(new UgcProteusItem.2(this, paramInt, localReadInJoyBaseAdapter, paramIReadInJoyModel));
        return;
      }
      label201:
      ((ComponentContentUgcImage)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.UgcProteusItem
 * JD-Core Version:    0.7.0.1
 */