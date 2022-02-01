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
    this.a = paramVideoItemHolder;
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
    Object localObject = this.a.aG;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    if (((this.a.Z == 0) && (this.a.Y == 0) && (((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).isPlayFeedsActivity(this.b.v())) && (paramBoolean)) || (paramVideoInfo.aq))
    {
      localObject = this.a.aG;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)"");
      }
      this.a.av.setText((CharSequence)"");
    }
    else
    {
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setRichTitle(paramVideoInfo, this.a.aG);
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setRichTitle(paramVideoInfo, this.a.av);
    }
    localObject = this.a.aG;
    if (localObject != null)
    {
      localObject = ((TextView)localObject).getPaint();
      if (localObject != null) {
        ((TextPaint)localObject).setFakeBoldText(true);
      }
    }
    localObject = this.a.av.getPaint();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.fullTitleTextView.paint");
    ((TextPaint)localObject).setFakeBoldText(true);
    this.c.a(this.a, paramVideoInfo);
    h(true);
    if (this.a.ba != null)
    {
      paramVideoInfo = this.a.ba;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
    }
  }
  
  public void a(@NotNull VideoItemHolder paramVideoItemHolder, @NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoItemHolder, "videoHolder");
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    if (paramVideoItemHolder.aM != null)
    {
      localObject = paramVideoItemHolder.aM;
      if (localObject != null) {
        ((View)localObject).setOnClickListener((View.OnClickListener)this.c);
      }
      localObject = paramVideoItemHolder.aM;
      if (localObject != null) {
        ((View)localObject).setTag(paramVideoItemHolder);
      }
    }
    Object localObject = paramVideoItemHolder.aO;
    if (localObject != null) {
      ((ViewGroup)localObject).setTag(paramVideoItemHolder);
    }
    localObject = paramVideoItemHolder.aO;
    if (localObject != null) {
      ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.c);
    }
    localObject = paramVideoItemHolder.aO;
    if (localObject != null) {
      ((ViewGroup)localObject).setVisibility(0);
    }
    localObject = paramVideoItemHolder.aR;
    if (localObject != null) {
      ((ImageView)localObject).setTag(paramVideoItemHolder);
    }
    localObject = paramVideoItemHolder.aR;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this.c);
    }
    localObject = paramVideoItemHolder.aR;
    if (localObject != null) {
      ((ImageView)localObject).setOnLongClickListener((View.OnLongClickListener)this.c);
    }
    if (paramVideoItemHolder.aV != null)
    {
      localObject = paramVideoItemHolder.aV;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.c);
      }
      localObject = paramVideoItemHolder.aV;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnLongClickListener((View.OnLongClickListener)this.c);
      }
      localObject = paramVideoItemHolder.aV;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(paramVideoItemHolder);
      }
    }
    if (paramVideoItemHolder.aW != null)
    {
      localObject = paramVideoItemHolder.aW;
      if (localObject != null) {
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)this.c);
      }
      localObject = paramVideoItemHolder.aW;
      if (localObject != null) {
        ((ViewGroup)localObject).setTag(paramVideoItemHolder);
      }
    }
    localObject = paramVideoItemHolder.aR;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = paramVideoItemHolder.aS;
    if (localObject != null) {
      ((ImageView)localObject).setTag(paramVideoItemHolder);
    }
    localObject = paramVideoItemHolder.aS;
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)this.c);
    }
    paramVideoItemHolder = paramVideoItemHolder.aS;
    if (paramVideoItemHolder != null) {
      paramVideoItemHolder.setVisibility(0);
    }
    c(paramVideoInfo);
  }
  
  public void a_(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    if (paramVideoInfo.p > 0)
    {
      TextView localTextView = this.a.aQ;
      if (localTextView != null) {
        localTextView.setVisibility(0);
      }
      ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextViewAsync(this.a.aQ, paramVideoInfo.p, "评论");
      paramVideoInfo = this.a.aP;
      if (paramVideoInfo != null) {
        paramVideoInfo.setImageResource(RR.drawable.a.c());
      }
    }
    else
    {
      paramVideoInfo = this.a.aQ;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
      paramVideoInfo = this.a.aP;
      if (paramVideoInfo != null) {
        paramVideoInfo.setImageResource(RR.drawable.a.d());
      }
    }
  }
  
  public void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
  }
  
  public void c(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "info");
    a_(paramVideoInfo);
    ((IVideoFeedsAccessibilityHelperFactory)QRoute.api(IVideoFeedsAccessibilityHelperFactory.class)).get().a((View)this.a.aQ, paramVideoInfo.p);
    ImageView localImageView = this.a.aS;
    if (localImageView != null) {
      localImageView.setImageDrawable(this.c.e(a(paramVideoInfo.am)));
    }
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextViewAsync(this.a.aT, paramVideoInfo.an, "赞");
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).commonSetCountToTextViewAsync(this.a.aU, paramVideoInfo.w, "Biu");
  }
  
  public void c(boolean paramBoolean)
  {
    super.a(Boolean.valueOf(paramBoolean));
  }
  
  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    if (paramBoolean)
    {
      localTextView = this.a.aG;
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      h(false);
      f(false);
      g(false);
      return;
    }
    TextView localTextView = this.a.aG;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    h(true);
    f(true);
    g(true);
  }
  
  public void f()
  {
    Object localObject = this.a.az;
    boolean bool = true;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).c;
      if ((localObject != null) && (((VideoInfo)localObject).am == true)) {}
    }
    else
    {
      bool = false;
    }
    this.b.a(this.a, a(bool));
  }
  
  public void f(boolean paramBoolean)
  {
    if (this.a.aH != null)
    {
      Object localObject = this.a.az;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).c;
        if ((localObject != null) && (((VideoInfo)localObject).a == 0)) {}
      }
      else
      {
        localObject = this.a.az;
        if (localObject != null)
        {
          localObject = ((VideoPlayParam)localObject).c;
          if ((localObject != null) && (((VideoInfo)localObject).o() == true))
          {
            if (paramBoolean)
            {
              localObject = this.a.aH;
              if (localObject == null) {
                return;
              }
              ((ViewGroup)localObject).setVisibility(0);
              return;
            }
            localObject = this.a.aH;
            if (localObject == null) {
              return;
            }
            ((ViewGroup)localObject).setVisibility(8);
            return;
          }
        }
      }
      localObject = this.a.aH;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (this.a.aN != null)
    {
      Object localObject = this.a.az;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).c;
        if ((localObject != null) && (((VideoInfo)localObject).o() == true))
        {
          if (paramBoolean)
          {
            localObject = this.a.aN;
            if (localObject == null) {
              return;
            }
            ((ViewGroup)localObject).setVisibility(0);
            return;
          }
          localObject = this.a.aN;
          if (localObject == null) {
            return;
          }
          ((ViewGroup)localObject).setVisibility(8);
          return;
        }
      }
      localObject = this.a.aN;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.a.aZ != null)
    {
      this.a.a(paramBoolean);
      ViewGroup localViewGroup;
      if ((paramBoolean) && (!this.b.e()))
      {
        localViewGroup = this.a.aZ;
        if (localViewGroup != null) {
          localViewGroup.setVisibility(0);
        }
      }
      else
      {
        localViewGroup = this.a.aZ;
        if (localViewGroup != null) {
          localViewGroup.setVisibility(8);
        }
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.a.be != null)
    {
      ViewGroup localViewGroup = this.a.be;
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
  
  public void j(boolean paramBoolean)
  {
    if (this.a.bf != null)
    {
      ViewGroup localViewGroup = this.a.bf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate.CommonVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */