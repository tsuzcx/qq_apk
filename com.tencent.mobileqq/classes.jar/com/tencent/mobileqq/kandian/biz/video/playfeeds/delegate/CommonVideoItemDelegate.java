package com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate;

import android.text.TextPaint;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.baseui.RR.drawable;
import com.tencent.mobileqq.kandian.biz.common.baseui.RR.drawable.Companion;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAccessibilityHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAccessibilityHelperFactory;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/delegate/CommonVideoItemDelegate;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/delegate/BaseVideoItemDelegate;", "videoHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "presenter", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAdapter;", "(Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsRecommendPresenter;Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAdapter;)V", "getDianZanDrawable", "", "isDianZan", "", "innerConfigMenuBtns", "", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "onDianZanClick", "onMenuDataChanged", "info", "onScreenOrientationChanged", "isFullScreen", "onVideoDoubleClick", "actionX", "actionY", "isZanStatusChanged", "refreshContentUI", "isNeedReloadTitle", "refreshMenuUI", "setContentUIVisibility", "visible", "setControllerVisibility", "visibility", "setFooterDiversionVisibility", "setFooterVisibility", "setHeaderDiversionVisibility", "setHeaderVisibility", "updateCommentUI", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract class CommonVideoItemDelegate
  extends BaseVideoItemDelegate
{
  private final VideoItemHolder a;
  
  public CommonVideoItemDelegate(@NotNull VideoItemHolder paramVideoItemHolder, @NotNull IVideoFeedsRecommendPresenter paramIVideoFeedsRecommendPresenter, @NotNull IVideoFeedsAdapter paramIVideoFeedsAdapter)
  {
    super((BaseVideoItemHolder)paramVideoItemHolder, paramIVideoFeedsRecommendPresenter, paramIVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder = paramVideoItemHolder;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return RR.drawable.a.a();
    }
    return RR.drawable.a.b();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    super.a(paramVideoInfo, paramBoolean);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.c == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.b == 0) && (((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).isPlayFeedsActivity(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a())) && (paramBoolean)) || (paramVideoInfo.r))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)"");
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.u.setText((CharSequence)"");
    }
    else
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setRichTitle(paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v);
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setRichTitle(paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.u);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v;
    if (localObject != null)
    {
      localObject = ((TextView)localObject).getPaint();
      if (localObject != null) {
        ((TextPaint)localObject).setFakeBoldText(true);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.u.getPaint();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.fullTitleTextView.paint");
    ((TextPaint)localObject).setFakeBoldText(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, paramVideoInfo);
    g(true);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.q != null)
    {
      paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.q;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
    }
  }
  
  public void a(@NotNull VideoItemHolder paramVideoItemHolder, @NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoItemHolder, "videoHolder");
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (paramVideoItemHolder.jdField_p_of_type_AndroidViewView != null)
    {
      localObject = paramVideoItemHolder.jdField_p_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
      }
      localObject = paramVideoItemHolder.jdField_p_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setTag(paramVideoItemHolder);
      }
    }
    Object localObject = paramVideoItemHolder.jdField_m_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setTag(paramVideoItemHolder);
    }
    localObject = paramVideoItemHolder.jdField_m_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    }
    localObject = paramVideoItemHolder.jdField_m_of_type_AndroidViewViewGroup;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(0);
    }
    localObject = paramVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setTag(paramVideoItemHolder);
    }
    localObject = paramVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    }
    localObject = paramVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    }
    if (paramVideoItemHolder.n != null)
    {
      localObject = paramVideoItemHolder.n;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
      }
      localObject = paramVideoItemHolder.n;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
      }
      localObject = paramVideoItemHolder.n;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(paramVideoItemHolder);
      }
    }
    if (paramVideoItemHolder.o != null)
    {
      localObject = paramVideoItemHolder.o;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
      }
      localObject = paramVideoItemHolder.o;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(paramVideoItemHolder);
      }
    }
    localObject = paramVideoItemHolder.jdField_l_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = paramVideoItemHolder.jdField_m_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setTag(paramVideoItemHolder);
    }
    localObject = paramVideoItemHolder.jdField_m_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    }
    paramVideoItemHolder = paramVideoItemHolder.jdField_m_of_type_AndroidWidgetImageView;
    if (paramVideoItemHolder != null) {
      paramVideoItemHolder.setVisibility(0);
    }
    c(paramVideoInfo);
  }
  
  public void a_(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.e > 0)
    {
      TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.w;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextViewAsync(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.w, paramVideoInfo.e, "评论");
      paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.k;
      if (paramVideoInfo != null) {
        paramVideoInfo.setImageResource(RR.drawable.a.c());
      }
    }
    else
    {
      paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.w;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
      paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.k;
      if (paramVideoInfo != null) {
        paramVideoInfo.setImageResource(RR.drawable.a.d());
      }
    }
  }
  
  public void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
  }
  
  public void b(boolean paramBoolean)
  {
    super.a(Boolean.valueOf(paramBoolean));
  }
  
  public void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    a_(paramVideoInfo);
    ((IVideoFeedsAccessibilityHelperFactory)QRoute.api(IVideoFeedsAccessibilityHelperFactory.class)).get().a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.w, paramVideoInfo.e);
    ImageView localImageView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_m_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(a(paramVideoInfo.q)));
    }
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextViewAsync(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.x, paramVideoInfo.s, "赞");
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextViewAsync(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.y, paramVideoInfo.f, "Biu");
  }
  
  public void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if (paramBoolean)
    {
      localTextView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      g(false);
      e(false);
      f(false);
      return;
    }
    TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.v;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    g(true);
    e(true);
    f(true);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.j != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.a;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).a;
        if ((localObject != null) && (((VideoInfo)localObject).a == 0)) {}
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.a;
        if (localObject != null)
        {
          localObject = ((VideoPlayParam)localObject).a;
          if ((localObject != null) && (((VideoInfo)localObject).h() == true))
          {
            if (paramBoolean)
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.j;
              if (localObject == null) {
                return;
              }
              ((ViewGroup)localObject).setVisibility(0);
              return;
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.j;
            if (localObject == null) {
              return;
            }
            ((ViewGroup)localObject).setVisibility(8);
            return;
          }
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.j;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
    }
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.a;
    boolean bool = true;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).a;
      if ((localObject != null) && (((VideoInfo)localObject).q == true)) {}
    }
    else
    {
      bool = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, a(bool));
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.a;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).a;
        if ((localObject != null) && (((VideoInfo)localObject).h() == true))
        {
          if (paramBoolean)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup;
            if (localObject == null) {
              return;
            }
            ((ViewGroup)localObject).setVisibility(0);
            return;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup;
          if (localObject == null) {
            return;
          }
          ((ViewGroup)localObject).setVisibility(8);
          return;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_l_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_p_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.a(paramBoolean);
      ViewGroup localViewGroup;
      if ((paramBoolean) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b()))
      {
        localViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_p_of_type_AndroidViewViewGroup;
        if (localViewGroup != null) {
          localViewGroup.setVisibility(0);
        }
      }
      else
      {
        localViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_p_of_type_AndroidViewViewGroup;
        if (localViewGroup != null) {
          localViewGroup.setVisibility(8);
        }
      }
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.r != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.r;
      if (localViewGroup != null)
      {
        int i;
        if (paramBoolean) {
          i = 0;
        } else {
          i = 8;
        }
        localViewGroup.setVisibility(i);
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.s != null)
    {
      ViewGroup localViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.s;
      if (localViewGroup != null)
      {
        int i;
        if (paramBoolean) {
          i = 0;
        } else {
          i = 8;
        }
        localViewGroup.setVisibility(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate.CommonVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */