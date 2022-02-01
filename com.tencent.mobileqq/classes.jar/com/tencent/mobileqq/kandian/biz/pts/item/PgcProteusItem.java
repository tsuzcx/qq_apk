package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnGalleryImageClickListener;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentBig;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentGridImage;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentPgcVideo;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentView;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.network.ReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.ArticleCommentView;
import com.tencent.mobileqq.kandian.biz.pts.view.PgcSmallView;
import com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyMiddleBodyView;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeMiddleBodyView;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import org.json.JSONObject;

public class PgcProteusItem
  implements ProteusItem
{
  private View a(int paramInt, Context paramContext, IReadInJoyModel paramIReadInJoyModel)
  {
    paramIReadInJoyModel = paramIReadInJoyModel.k();
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mSocialFeedInfo != null) && (paramIReadInJoyModel.mSocialFeedInfo.t != null) && (paramIReadInJoyModel.mSocialFeedInfo.t.a != null) && (paramIReadInJoyModel.mSocialFeedInfo.t.a.size() > 0) && (ComponentContentGridImage.a(paramIReadInJoyModel.mSocialFeedInfo.t.a.size(), paramIReadInJoyModel.mSocialFeedInfo.b) == 1)) {
      return new ComponentContentBig(paramContext);
    }
    return new ComponentContentGridImage(paramContext);
  }
  
  private void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    int i = a(paramAbsBaseArticleInfo, paramReadInJoyBaseAdapter);
    paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.y().d();
    if (paramReadInJoyBaseAdapter != null) {
      paramReadInJoyBaseAdapter.a(paramContext, paramAbsBaseArticleInfo, paramInt1, paramString, i, paramInt2, paramInt3);
    }
  }
  
  private void a(Context paramContext, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    OnGalleryImageClickListener localOnGalleryImageClickListener = ((ReadInJoyBaseAdapter)paramIReadInJoyModel.u()).y().d();
    paramIReadInJoyModel = paramIReadInJoyModel.k();
    if ((paramIReadInJoyModel != null) && (localOnGalleryImageClickListener != null)) {
      localOnGalleryImageClickListener.a(paramContext, paramIReadInJoyModel, 0, paramIReadInJoyModel.innerUniqueID, 5, paramInt, 0);
    }
  }
  
  private void b(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.k();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.t.a != null) && (localAbsBaseArticleInfo.mSocialFeedInfo.t.a.size() > 0) && (ComponentContentGridImage.a(localAbsBaseArticleInfo.mSocialFeedInfo.t.a.size(), localAbsBaseArticleInfo.mSocialFeedInfo.b) == 1))
    {
      c(paramInt1, paramIReadInJoyModel, paramNativeMiddleBodyView, paramInt2, paramContainer);
      return;
    }
    paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.getContent();
    paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramIReadInJoyModel, paramInt1));
    paramNativeMiddleBodyView.setMIReadInJoyModel(paramIReadInJoyModel);
    paramNativeMiddleBodyView.setGalleryClickListener(new PgcProteusItem.5(this, paramIReadInJoyModel, paramContainer, paramInt2));
  }
  
  private void c(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    paramNativeMiddleBodyView.getContent().setOnClickListener(new PgcProteusItem.6(this, paramIReadInJoyModel, paramContainer, paramInt2));
    ((ComponentView)paramNativeMiddleBodyView.getContent()).a(paramIReadInJoyModel);
  }
  
  public int a(AbsBaseArticleInfo paramAbsBaseArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    return GalleryReportedUtils.a(paramReadInJoyBaseAdapter.c(), RIJFeedsType.g(paramAbsBaseArticleInfo));
  }
  
  protected View a(int paramInt, Context paramContext, IReadInJoyModel paramIReadInJoyModel, ReadInJoyMiddleBodyView paramReadInJoyMiddleBodyView)
  {
    if (paramInt != 29)
    {
      if (paramInt != 34)
      {
        if (paramInt != 48) {
          if (paramInt != 31)
          {
            if (paramInt != 32)
            {
              if ((paramInt == 64) || (paramInt == 65)) {
                break label178;
              }
              switch (paramInt)
              {
              default: 
                switch (paramInt)
                {
                default: 
                  paramContext = new StringBuilder();
                  paramContext.append("");
                  paramContext.append(paramInt);
                  throw new IllegalArgumentException(paramContext.toString());
                }
              case 18: 
                return new ComponentContentBig(paramContext);
              case 16: 
              case 20: 
                return new PgcSmallView(paramInt, paramContext);
              }
            }
            return new ComponentContentPgcVideo(paramContext);
          }
          else
          {
            return new ComponentContentBig(paramContext);
          }
        }
        label178:
        return a(paramInt, paramContext, paramIReadInJoyModel);
      }
      paramContext = new ComponentContentGridImage(paramContext);
      if (paramReadInJoyMiddleBodyView.e())
      {
        paramContext.b = paramReadInJoyMiddleBodyView.getComPaddingLeft();
        paramContext.c = paramReadInJoyMiddleBodyView.getComPaddingRight();
      }
      return paramContext;
    }
    return new ComponentContentBig(paramContext);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    TraceUtils.traceBegin("PgcProteusItem.getDataJson");
    long l2 = System.currentTimeMillis();
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder();
    long l1;
    try
    {
      l1 = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      l1 = 0L;
    }
    TraceUtils.traceBegin("PgcProteusItem.bindArticleComment");
    if ((paramInt != 20) && (paramInt != 16) && (paramInt != 83) && (paramInt != 86) && ((!TextUtils.isEmpty(paramAbsBaseArticleInfo.mSummary)) || (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mTitle)) || ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.t.c != null)))) {
      localProteusItemDataBuilder.p(paramAbsBaseArticleInfo);
    }
    TraceUtils.traceEnd();
    TraceUtils.traceBegin("PgcProteusItem.bindReadArticle");
    if ((paramInt == 34) || (paramInt == 85)) {
      localProteusItemDataBuilder.c(paramAbsBaseArticleInfo, HardCodeUtil.a(2131905789));
    }
    TraceUtils.traceEnd();
    if (paramInt == 29) {
      localProteusItemDataBuilder.c(paramAbsBaseArticleInfo, HardCodeUtil.a(2131905788));
    }
    TraceUtils.traceBegin("PgcProteusItem.bindTopicCapsule");
    if (paramInt != 29) {
      localProteusItemDataBuilder.A(paramAbsBaseArticleInfo).D(paramAbsBaseArticleInfo).B(paramAbsBaseArticleInfo);
    }
    TraceUtils.traceEnd();
    TraceUtils.traceBegin("PgcProteusItem.bindPublicAccountFollowButton");
    TraceUtils.traceEnd();
    localProteusItemDataBuilder.a(paramAbsBaseArticleInfo).b(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo).a(paramAbsBaseArticleInfo, l1).d(paramAbsBaseArticleInfo).j(paramAbsBaseArticleInfo).i(paramAbsBaseArticleInfo).g(paramAbsBaseArticleInfo).k(paramAbsBaseArticleInfo).v(paramAbsBaseArticleInfo).w(paramAbsBaseArticleInfo).C(paramAbsBaseArticleInfo).a("ReadInjoy_original_cell").E(paramAbsBaseArticleInfo).l(paramAbsBaseArticleInfo).I(paramAbsBaseArticleInfo).t(paramAbsBaseArticleInfo).u(paramAbsBaseArticleInfo);
    TraceUtils.traceBegin("PgcProteusItem.bindMiddleBody");
    localProteusItemDataBuilder.z(paramAbsBaseArticleInfo);
    TraceUtils.traceEnd();
    TraceUtils.traceEnd();
    ReadInJoyPTSCostHelper.a("PgcProteusItem", String.valueOf(paramInt), "PgcProteusItem.getDataJson", System.currentTimeMillis() - l2);
    return localProteusItemDataBuilder.a();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    long l = System.currentTimeMillis();
    TraceUtils.traceBegin("PgcProteusItem.bindView");
    ViewBase localViewBase = paramContainer.getVirtualView();
    c(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    b(paramIReadInJoyModel, localViewBase);
    a(paramIReadInJoyModel, localViewBase);
    b(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    a(paramInt1, paramContainer, paramIReadInJoyModel, paramInt2, localViewBase);
    TraceUtils.traceBegin("PgcProteusItem.bindView.bindJumpChannel");
    BindViewHelper.b(localViewBase, paramIReadInJoyModel);
    TraceUtils.traceEnd();
    TraceUtils.traceBegin("PgcProteusItem.bindView.bindSocialCommon");
    BindViewHelper.c(localViewBase, paramIReadInJoyModel);
    TraceUtils.traceEnd();
    TraceUtils.traceBegin("PgcProteusItem.bindView.bindFlowGuideSperator");
    BindViewHelper.d(localViewBase, paramIReadInJoyModel);
    TraceUtils.traceEnd();
    TraceUtils.traceEnd();
    ReadInJoyPTSCostHelper.a("PgcProteusItem", String.valueOf(paramInt1), "PgcProteusItem.bindView", System.currentTimeMillis() - l);
  }
  
  protected void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2, ViewBase paramViewBase)
  {
    TraceUtils.traceBegin("PgcProteusItem.bindView.socialBottomBar");
    paramViewBase = paramViewBase.findViewBaseByName("id_social_bottom");
    if (((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) && (paramViewBase != null) && (paramViewBase.getNativeView() != null)) {
      paramViewBase.getNativeView().setOnClickListener(new PgcProteusItem.1(this, paramContainer, paramIReadInJoyModel, paramInt2));
    }
    TraceUtils.traceEnd();
  }
  
  protected void a(int paramInt1, IReadInJoyModel paramIReadInJoyModel, NativeMiddleBodyView paramNativeMiddleBodyView, int paramInt2, Container paramContainer)
  {
    if (paramNativeMiddleBodyView.getContent() != null)
    {
      if (paramIReadInJoyModel.u() == null) {
        return;
      }
      ReadInJoyBaseAdapter localReadInJoyBaseAdapter = (ReadInJoyBaseAdapter)paramIReadInJoyModel.u();
      if (paramInt1 != 29)
      {
        if (paramInt1 != 34)
        {
          if (paramInt1 != 48)
          {
            if ((paramInt1 != 31) && (paramInt1 != 32))
            {
              if ((paramInt1 == 64) || (paramInt1 == 65)) {
                break label201;
              }
              switch (paramInt1)
              {
              default: 
                switch (paramInt1)
                {
                default: 
                  paramIReadInJoyModel = new StringBuilder();
                  paramIReadInJoyModel.append("");
                  paramIReadInJoyModel.append(paramInt1);
                  throw new IllegalArgumentException(paramIReadInJoyModel.toString());
                }
                break;
              }
            }
            paramNativeMiddleBodyView.getContent().setOnClickListener(new PgcProteusItem.4(this, paramIReadInJoyModel, localReadInJoyBaseAdapter));
            ((ComponentView)paramNativeMiddleBodyView.getContent()).a(paramIReadInJoyModel);
            return;
          }
          label201:
          b(paramInt1, paramIReadInJoyModel, paramNativeMiddleBodyView, paramInt2, paramContainer);
          return;
        }
        paramNativeMiddleBodyView = (ComponentContentGridImage)paramNativeMiddleBodyView.getContent();
        paramNativeMiddleBodyView.a(ComponentContentGridImage.a(paramIReadInJoyModel, paramInt1));
        paramNativeMiddleBodyView.setMIReadInJoyModel(paramIReadInJoyModel);
        paramNativeMiddleBodyView.setOnNoItemClickListener(new PgcProteusItem.3(this, paramIReadInJoyModel));
        return;
      }
      ((ComponentView)paramNativeMiddleBodyView.getContent()).a(paramIReadInJoyModel);
    }
  }
  
  protected void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    TraceUtils.traceBegin("PgcProteusItem.bindView.bindBiuTime");
    BindViewHelper.a(paramViewBase, paramIReadInJoyModel.k());
    TraceUtils.traceEnd();
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
  
  protected void b(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2, ViewBase paramViewBase)
  {
    paramViewBase = (ArticleCommentView)paramViewBase.findViewBaseByName("id_article_comment");
    TraceUtils.traceBegin("PgcProteusItem.bindView.commentView");
    if (paramViewBase != null)
    {
      if ((paramInt1 == 48) || (paramInt1 == 64) || (paramInt1 == 65)) {
        paramViewBase.setOnClickListener(new PgcProteusItem.2(this, paramContainer, paramIReadInJoyModel, paramInt2));
      }
      paramViewBase.setVisibility(0);
    }
    if ((paramViewBase != null) && (paramViewBase.isVisible())) {
      paramViewBase.a(paramIReadInJoyModel);
    }
    TraceUtils.traceEnd();
  }
  
  protected void b(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    BindViewHelper.f(paramViewBase, paramIReadInJoyModel);
  }
  
  protected void c(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2, ViewBase paramViewBase)
  {
    TraceUtils.traceBegin("PgcProteusItem.bindView.findViewBaseByName");
    ReadInJoyMiddleBodyView localReadInJoyMiddleBodyView = (ReadInJoyMiddleBodyView)paramViewBase.findViewBaseByName("id_middle_body_content");
    TraceUtils.traceEnd();
    TraceUtils.traceBegin("PgcProteusItem.bindView.bodyviewContent");
    if (localReadInJoyMiddleBodyView != null)
    {
      NativeMiddleBodyView localNativeMiddleBodyView = (NativeMiddleBodyView)localReadInJoyMiddleBodyView.getNativeView();
      if (localNativeMiddleBodyView.getContent() == null)
      {
        View localView = a(paramInt1, paramContainer.getContext(), paramIReadInJoyModel, localReadInJoyMiddleBodyView);
        if ((localView != null) && ((localView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
          paramViewBase = (RelativeLayout.LayoutParams)localView.getLayoutParams();
        } else {
          paramViewBase = new RelativeLayout.LayoutParams(-2, -2);
        }
        localReadInJoyMiddleBodyView.a(paramViewBase);
        if (localView != null) {
          localNativeMiddleBodyView.a(localView, paramViewBase);
        }
      }
      TraceUtils.traceBegin("PgcProteusItem.bindView.bindBodyView");
      a(paramInt1, paramIReadInJoyModel, localNativeMiddleBodyView, paramInt2, paramContainer);
      TraceUtils.traceEnd();
    }
    TraceUtils.traceEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcProteusItem
 * JD-Core Version:    0.7.0.1
 */