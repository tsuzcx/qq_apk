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
import com.tencent.mobileqq.kandian.biz.pts.util.RIJBiuCardUtil;
import com.tencent.mobileqq.kandian.biz.pts.view.BiuCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.SummaryView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import org.json.JSONObject;

public class BiuUgcProteusItem
  implements ProteusItem
{
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramViewBase != null) && (paramIReadInJoyModel != null))
    {
      if (paramIReadInJoyModel.a() == null) {
        return;
      }
      paramViewBase = paramViewBase.findViewBaseByName("id_middle_body_wrapper");
      if (paramViewBase != null)
      {
        if (paramViewBase.getNativeView() == null) {
          return;
        }
        paramViewBase = paramViewBase.getNativeView();
        Context localContext = paramViewBase.getContext();
        paramViewBase.setOnClickListener(new BiuUgcProteusItem.1(this, paramIReadInJoyModel.a(), localContext));
      }
    }
  }
  
  protected View a(int paramInt, Context paramContext)
  {
    if (paramInt != 25) {
      if (paramInt != 26)
      {
        if (paramInt != 37)
        {
          if (paramInt != 81)
          {
            if (paramInt != 108) {
              return null;
            }
            return new ComponentContentUGCVoice(paramContext);
          }
        }
        else {
          return new ComponentContentGridImage(paramContext);
        }
      }
      else {
        return new ComponentContentUgcVideo(paramContext);
      }
    }
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
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder().a(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, l).f(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, "Biu了").i(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).n(paramAbsBaseArticleInfo).m(paramAbsBaseArticleInfo).C(paramAbsBaseArticleInfo).o(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).v(paramAbsBaseArticleInfo).w(paramAbsBaseArticleInfo).x(paramAbsBaseArticleInfo).y(paramAbsBaseArticleInfo).A(paramAbsBaseArticleInfo).D(paramAbsBaseArticleInfo).G(paramAbsBaseArticleInfo).E(paramAbsBaseArticleInfo).B(paramAbsBaseArticleInfo).H(paramAbsBaseArticleInfo).s(paramAbsBaseArticleInfo).F(paramAbsBaseArticleInfo).l(paramAbsBaseArticleInfo).I(paramAbsBaseArticleInfo).t(paramAbsBaseArticleInfo).u(paramAbsBaseArticleInfo).O(paramAbsBaseArticleInfo).P(paramAbsBaseArticleInfo);
    if (RIJBiuCardUtil.a(paramAbsBaseArticleInfo)) {
      localProteusItemDataBuilder.a("RIJ_biu_small_single_img_cell");
    } else {
      localProteusItemDataBuilder.a("RIJ_biu_cell");
    }
    return localProteusItemDataBuilder.a();
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
    paramContainer = (BiuCommentView)localViewBase.findViewBaseByName("id_biu_comment");
    if (paramContainer != null) {
      paramContainer.a(paramIReadInJoyModel);
    }
    paramContainer = (SummaryView)localViewBase.findViewBaseByName("id_summary");
    if (paramContainer != null) {
      paramContainer.a(paramIReadInJoyModel);
    }
    paramContainer = (NativeButton)localViewBase.findViewBaseByName("id_super_topic_button");
    if ((paramContainer != null) && (paramContainer.getNativeView() != null) && ((paramContainer.getNativeView() instanceof NativeButtonImp))) {
      ((NativeButtonImp)paramContainer.getNativeView()).setTextColor(-1);
    }
    BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
    Util.a(localViewBase, paramIReadInJoyModel);
    a(localViewBase, paramIReadInJoyModel);
    Util.b(localViewBase, paramIReadInJoyModel);
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
      if (paramInt != 25) {
        if (paramInt != 26)
        {
          if (paramInt != 37)
          {
            if (paramInt != 81)
            {
              if (paramInt == 108)
              {
                ((ComponentContentUGCVoice)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
                return;
              }
              paramIReadInJoyModel = new StringBuilder();
              paramIReadInJoyModel.append("");
              paramIReadInJoyModel.append(paramInt);
              throw new IllegalArgumentException(paramIReadInJoyModel.toString());
            }
          }
          else
          {
            paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.a();
            ComponentContentGridImage localComponentContentGridImage = (ComponentContentGridImage)paramNativeMiddleBodyView;
            localComponentContentGridImage.setMIReadInJoyModel(paramIReadInJoyModel);
            paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramIReadInJoyModel.a()));
            localComponentContentGridImage.setOnNoItemClickListener(new BiuUgcProteusItem.2(this, paramIReadInJoyModel, localReadInJoyBaseAdapter));
          }
        }
        else
        {
          paramNativeMiddleBodyView = (ComponentContentUgcVideo)paramNativeMiddleBodyView.a();
          paramNativeMiddleBodyView.a(paramIReadInJoyModel);
          ((ComponentContentUgcVideo)paramNativeMiddleBodyView).setOnClickListener(new BiuUgcProteusItem.3(this, paramIReadInJoyModel, localReadInJoyBaseAdapter));
          return;
        }
      }
      ((ComponentContentUgcImage)paramNativeMiddleBodyView.a()).a(paramIReadInJoyModel);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BiuUgcProteusItem
 * JD-Core Version:    0.7.0.1
 */