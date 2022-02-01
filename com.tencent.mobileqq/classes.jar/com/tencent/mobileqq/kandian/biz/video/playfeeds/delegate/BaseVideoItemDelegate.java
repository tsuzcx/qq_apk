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
  public static final BaseVideoItemDelegate.Companion a;
  @JvmField
  @NotNull
  public final IVideoFeedsAdapter a;
  @JvmField
  @NotNull
  public final IVideoFeedsRecommendPresenter a;
  private final BaseVideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsDelegateBaseVideoItemDelegate$Companion = new BaseVideoItemDelegate.Companion(null);
  }
  
  public BaseVideoItemDelegate(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, @NotNull IVideoFeedsRecommendPresenter paramIVideoFeedsRecommendPresenter, @NotNull IVideoFeedsAdapter paramIVideoFeedsAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate = ((IBaseVideoItemDelegateProxyFactory)QRoute.api(IBaseVideoItemDelegateProxyFactory.class)).create(paramBaseVideoItemHolder, paramIVideoFeedsRecommendPresenter, paramIVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder = paramBaseVideoItemHolder;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter = paramIVideoFeedsRecommendPresenter;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter = paramIVideoFeedsAdapter;
    a((IVideoFeedsItemUIDelegate)this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(IVideoFeedsItemUIDelegate paramIVideoFeedsItemUIDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(paramIVideoFeedsItemUIDelegate);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(paramVideoInfo, paramBoolean);
  }
  
  public void a(VideoItemHolder paramVideoItemHolder, VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(paramVideoItemHolder, paramVideoInfo);
  }
  
  public void a(Boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(paramBoolean1, paramBoolean2);
  }
  
  public void a_(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a_(paramVideoInfo);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.b(paramInt);
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.b(paramVideoInfo);
  }
  
  public void c(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.c(paramVideoInfo);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.c(paramBoolean);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.d();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.d(paramBoolean);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.e();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.e(paramBoolean);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.f();
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.f(paramBoolean);
  }
  
  public void g(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.g(paramBoolean);
  }
  
  public void h(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.h(paramBoolean);
  }
  
  public void i(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.i(paramBoolean);
  }
  
  public void j(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.j(paramBoolean);
  }
  
  public void k(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.k(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate.BaseVideoItemDelegate
 * JD-Core Version:    0.7.0.1
 */