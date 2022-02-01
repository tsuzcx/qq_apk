package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.view.BiuCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.PgcSmallView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCPicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.util.Pair;
import java.util.ArrayList;
import org.json.JSONObject;

public class QuestionCardProteusItem
  implements ProteusItem
{
  public static Pair<Boolean, String> a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null))
    {
      int i = paramAbsBaseArticleInfo.mSocialFeedInfo.s.b.size();
      boolean bool = false;
      if (i == 0)
      {
        bool = true;
        paramAbsBaseArticleInfo = "https://sqimg.qq.com/qq_product_operations/kan/images/super_wenda_default.png";
      }
      else
      {
        paramAbsBaseArticleInfo = ((UGCPicInfo)paramAbsBaseArticleInfo.mSocialFeedInfo.s.b.get(0)).e;
      }
      Object localObject = paramAbsBaseArticleInfo;
      if (!TextUtils.isEmpty(paramAbsBaseArticleInfo))
      {
        localObject = paramAbsBaseArticleInfo;
        if (paramAbsBaseArticleInfo.contains("https")) {
          localObject = paramAbsBaseArticleInfo.replaceFirst("https", "http");
        }
      }
      return new Pair(Boolean.valueOf(bool), localObject);
    }
    return null;
  }
  
  private void a(ViewBase paramViewBase, IReadInJoyModel paramIReadInJoyModel)
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
        paramViewBase = paramViewBase.getNativeView();
        paramViewBase.setOnClickListener(new QuestionCardProteusItem.2(this, paramViewBase.getContext(), paramIReadInJoyModel.k()));
      }
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramInt == 75)
    {
      if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null)
      {
        l = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
        break label56;
      }
    }
    else if (paramAbsBaseArticleInfo.mSocialFeedInfo.s != null)
    {
      l = paramAbsBaseArticleInfo.mSocialFeedInfo.s.e;
      break label56;
    }
    long l = 0L;
    label56:
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder();
    localProteusItemDataBuilder.a(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, l).f(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo).i(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).p(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).v(paramAbsBaseArticleInfo).w(paramAbsBaseArticleInfo).m(paramAbsBaseArticleInfo).x(paramAbsBaseArticleInfo).C(paramAbsBaseArticleInfo).A(paramAbsBaseArticleInfo).E(paramAbsBaseArticleInfo).B(paramAbsBaseArticleInfo);
    if (paramInt == 75) {
      localProteusItemDataBuilder.a("ReadInjoy_biu_small_pgc_cell").n(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, "Biu了").G(paramAbsBaseArticleInfo);
    } else {
      localProteusItemDataBuilder.a("ReadInjoy_biu_small_pgc_cell").a(paramAbsBaseArticleInfo, HardCodeUtil.a(2131908832));
    }
    return localProteusItemDataBuilder.a();
  }
  
  protected void a(int paramInt1, Context paramContext, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2)
  {
    paramNativeMiddleBodyView = (PgcSmallView)paramNativeMiddleBodyView.getContent();
    paramNativeMiddleBodyView.setOnClickListener(new QuestionCardProteusItem.1(this, paramIReadInJoyModel, paramContext, paramInt1));
    paramNativeMiddleBodyView.a(paramIReadInJoyModel);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    ReadInJoyMiddleBodyView localReadInJoyMiddleBodyView = (ReadInJoyMiddleBodyView)localViewBase.findViewBaseByName("id_middle_body_content");
    if (localReadInJoyMiddleBodyView != null)
    {
      NativeMiddleBodyView localNativeMiddleBodyView = (NativeMiddleBodyView)localReadInJoyMiddleBodyView.getNativeView();
      if (localNativeMiddleBodyView.getContent() == null)
      {
        PgcSmallView localPgcSmallView = new PgcSmallView(paramInt1, paramContainer.getContext());
        RelativeLayout.LayoutParams localLayoutParams;
        if ((localPgcSmallView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
          localLayoutParams = (RelativeLayout.LayoutParams)localPgcSmallView.getLayoutParams();
        } else {
          localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        localReadInJoyMiddleBodyView.a(localLayoutParams);
        localNativeMiddleBodyView.a(localPgcSmallView, localLayoutParams);
      }
      a(paramInt1, paramContainer.getContext(), paramIReadInJoyModel, localNativeMiddleBodyView, paramInt2);
      localReadInJoyMiddleBodyView.setVisibility(0);
    }
    BindViewHelper.f(localViewBase, paramIReadInJoyModel);
    if (paramInt1 == 75)
    {
      paramContainer = (BiuCommentView)localViewBase.findViewBaseByName("id_biu_comment");
      if (paramContainer != null) {
        paramContainer.a(paramIReadInJoyModel);
      }
      Util.b(localViewBase, paramIReadInJoyModel);
    }
    BindViewHelper.a(localViewBase, paramIReadInJoyModel.k());
    Util.a(localViewBase, paramIReadInJoyModel);
    a(localViewBase, paramIReadInJoyModel);
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.QuestionCardProteusItem
 * JD-Core Version:    0.7.0.1
 */