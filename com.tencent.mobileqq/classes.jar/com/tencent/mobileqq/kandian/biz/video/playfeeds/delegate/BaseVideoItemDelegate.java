package com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IBaseVideoItemDelegateProxyFactory;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/delegate/BaseVideoItemDelegate;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsItemUIDelegate;", "videoHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "presenter", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAdapter;", "(Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsRecommendPresenter;Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAdapter;)V", "getDianZanDrawable", "", "isDianZan", "", "kotlin.jvm.PlatformType", "(Ljava/lang/Boolean;)I", "innerConfigMenuBtns", "", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "onCheckControllerVisibility", "visibility", "onCheckVolumeProgressVisibility", "onCommentComponentVisiblityChanged", "onDianZanClick", "onGestureTouchEvent", "event", "onItemSizeChanged", "onMenuDataChanged", "info", "onNetworkStatusChanged", "isWifi", "onScreenOrientationChanged", "isFullScreen", "onShowAsFirstTime", "isScrollToTop", "isNeedShowTitle", "onSpeedRatioChanged", "drawableId", "onVideoClick", "onVideoDoubleClick", "actionX", "actionY", "isZanStatusChanged", "onVisibilityChanged", "onVolumeChanged", "progress", "", "refreshContentUI", "isNeedReloadTitle", "refreshMenuUI", "setContentUIVisibility", "visible", "setControllerVisibility", "(Ljava/lang/Boolean;)V", "setFooterDiversionVisibility", "setFooterVisibility", "setHeaderDiversionVisibility", "setHeaderVisibility", "setSubClassItemUIDelegate", "subClassItemUIDelegate", "updateCommentUI", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract class BaseVideoItemDelegate
  implements IVideoFeedsItemUIDelegate
{
  public static final BaseVideoItemDelegate.Companion d = new BaseVideoItemDelegate.Companion(null);
  private final BaseVideoItemHolder a;
  @JvmField
  @NotNull
  public final IVideoFeedsRecommendPresenter b;
  @JvmField
  @NotNull
  public final IVideoFeedsAdapter c;
  
  public BaseVideoItemDelegate(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, @NotNull IVideoFeedsRecommendPresenter paramIVideoFeedsRecommendPresenter, @NotNull IVideoFeedsAdapter paramIVideoFeedsAdapter)
  {
    this.e = ((IBaseVideoItemDelegateProxyFactory)QRoute.api(IBaseVideoItemDelegateProxyFactory.class)).create(paramBaseVideoItemHolder, paramIVideoFeedsRecommendPresenter, paramIVideoFeedsAdapter);
    this.a = paramBaseVideoItemHolder;
    this.b = paramIVideoFeedsRecommendPresenter;
    this.c = paramIVideoFeedsAdapter;
    a((IVideoFeedsItemUIDelegate)this);
  }
  
  public void a()
  {
    this.e.a();
  }
  
  public void a(float paramFloat)
  {
    this.e.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.e.a(paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(IVideoFeedsItemUIDelegate paramIVideoFeedsItemUIDelegate)
  {
    this.e.a(paramIVideoFeedsItemUIDelegate);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    this.e.a(paramVideoInfo, paramBoolean);
  }
  
  public void a(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    this.e.a(paramVideoItemHolder, paramVideoInfo);
  }
  
  public void a(Boolean paramBoolean)
  {
    this.e.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e.a(paramBoolean1, paramBoolean2);
  }
  
  public void a_(VideoInfo paramVideoInfo)
  {
    this.e.a_(paramVideoInfo);
  }
  
  public void b(int paramInt)
  {
    this.e.b(paramInt);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.e.b(paramVideoInfo);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e.b(paramBoolean);
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.e.c(paramVideoInfo);
  }
  
  public void d()
  {
    this.e.d();
  }
  
  public void d(boolean paramBoolean)
  {
    this.e.d(paramBoolean);
  }
  
  public void e()
  {
    this.e.e();
  }
  
  public void e(boolean paramBoolean)
  {
    this.e.e(paramBoolean);
  }
  
  public void f()
  {
    this.e.f();
  }
  
  public void f(boolean paramBoolean)
  {
    this.e.f(paramBoolean);
  }
  
  public void g(boolean paramBoolean)
  {
    this.e.g(paramBoolean);
  }
  
  public void h(boolean paramBoolean)
  {
    this.e.h(paramBoolean);
  }
  
  public void i(boolean paramBoolean)
  {
    this.e.i(paramBoolean);
  }
  
  public void j(boolean paramBoolean)
  {
    this.e.j(paramBoolean);
  }
  
  public void k(boolean paramBoolean)
  {
    this.e.k(paramBoolean);
  }
  
  public void l(boolean paramBoolean)
  {
    this.e.l(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate.BaseVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */