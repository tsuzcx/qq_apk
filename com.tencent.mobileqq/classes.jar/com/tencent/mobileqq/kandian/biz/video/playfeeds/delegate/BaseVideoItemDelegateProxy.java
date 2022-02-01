package com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.imageloader.ZBitmapDrawable;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.CustomClickListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter.DefaultImpls;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.AbsVideoFeedsGestureLayout;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoBrightnessController;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.net.URL;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/delegate/BaseVideoItemDelegateProxy;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsItemUIDelegate;", "videoHolder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;", "presenter", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsRecommendPresenter;", "adapter", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAdapter;", "(Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/BaseVideoItemHolder;Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsRecommendPresenter;Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IVideoFeedsAdapter;)V", "subClassItemUIDelegate", "getDianZanDrawable", "", "isDianZan", "", "(Ljava/lang/Boolean;)I", "innerConfigMenuBtns", "", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "videoInfo", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/VideoInfo;", "isXgfileshow", "holder", "onCheckControllerVisibility", "visibility", "onCheckVolumeProgressVisibility", "onCommentComponentVisiblityChanged", "onDianZanClick", "onGestureTouchEvent", "event", "onItemSizeChanged", "onMenuDataChanged", "info", "onNetworkStatusChanged", "isWifi", "onScreenOrientationChanged", "isFullScreen", "onShowAsFirstTime", "isScrollToTop", "isNeedShowTitle", "onSpeedRatioChanged", "drawableId", "onVideoClick", "onVideoDoubleClick", "actionX", "actionY", "isZanStatusChanged", "onVisibilityChanged", "onVolumeChanged", "progress", "", "refreshContentUI", "isNeedReloadTitle", "refreshMenuUI", "resetCoverViewLayoutParams", "resetItemLayoutParams", "resetVolumeProgressState", "isControllerVisibility", "setContentUIVisibility", "visible", "setControllerVisibility", "setControllerVisibilitySubClass", "setFooterDiversionVisibility", "setFooterVisibility", "setHeaderDiversionVisibility", "setHeaderVisibility", "setSubClassItemUIDelegate", "showCurXGfileSizeTextView", "isKingCardUser", "tryLoadExtraCoverCache", "target", "Landroid/widget/ImageView;", "coverUrl", "Ljava/net/URL;", "updateCommentUI", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BaseVideoItemDelegateProxy
  implements IVideoFeedsItemUIDelegate
{
  @JvmField
  @NotNull
  public final IVideoFeedsAdapter a;
  private IVideoFeedsItemUIDelegate jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate;
  @JvmField
  @NotNull
  public final IVideoFeedsRecommendPresenter a;
  private final BaseVideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder;
  
  public BaseVideoItemDelegateProxy(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, @NotNull IVideoFeedsRecommendPresenter paramIVideoFeedsRecommendPresenter, @NotNull IVideoFeedsAdapter paramIVideoFeedsAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder = paramBaseVideoItemHolder;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter = paramIVideoFeedsRecommendPresenter;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter = paramIVideoFeedsAdapter;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate = ((IVideoFeedsItemUIDelegate)this);
  }
  
  private final boolean a(ImageView paramImageView, URL paramURL)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((Activity)localObject1).getIntent();
    } else {
      localObject1 = null;
    }
    int j;
    if (localObject1 != null) {
      j = ((Intent)localObject1).getIntExtra("item_width", 0);
    } else {
      j = 0;
    }
    int i;
    if (localObject1 != null) {
      i = ((Intent)localObject1).getIntExtra("item_height", 0);
    } else {
      i = 0;
    }
    if (localObject1 != null) {
      j = ((Intent)localObject1).getIntExtra("item_image_width", j);
    } else {
      j = 0;
    }
    if (localObject1 != null) {
      i = ((Intent)localObject1).getIntExtra("item_image_height", i);
    } else {
      i = 0;
    }
    if ((j != 0) && (i != 0))
    {
      localObject1 = new ImageRequest();
      ((ImageRequest)localObject1).jdField_a_of_type_JavaNetURL = RIJConvertString2URL.a(paramURL.toString());
      ((ImageRequest)localObject1).jdField_a_of_type_Int = j;
      ((ImageRequest)localObject1).jdField_b_of_type_Int = i;
      ICloseableBitmap localICloseableBitmap = ((IImageManager)QRoute.api(IImageManager.class)).getBitmap((ImageRequest)localObject1);
      localObject1 = localObject2;
      if (localICloseableBitmap != null) {
        localObject1 = localICloseableBitmap.a();
      }
      if (localObject1 != null)
      {
        paramURL = (Drawable)new ZBitmapDrawable(localICloseableBitmap.a());
        if (paramImageView != null) {
          paramImageView.setImageDrawable(paramURL);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: ImageManager hitCache");
        }
        return true;
      }
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = j;
      ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
      paramURL = URLDrawable.getDrawable(paramURL, (URLDrawable.URLDrawableOptions)localObject1);
      if ((paramURL != null) && (paramURL.getStatus() == 1))
      {
        if (paramImageView != null) {
          paramImageView.setImageDrawable((Drawable)paramURL);
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: urlDrawable hitCache");
        }
        return true;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: missCache");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseVideoItemDelegate", 2, "tryLoadExtraCoverCache: width or height = 0");
    }
    return false;
  }
  
  private final boolean a(BaseVideoItemHolder paramBaseVideoItemHolder)
  {
    boolean bool3 = NetworkUtil.isMobileNetWork((Context)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      if (paramBaseVideoItemHolder != null)
      {
        Object localObject = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
        if (localObject != null)
        {
          localObject = ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
          if (localObject != null)
          {
            l = ((VideoInfo)localObject).jdField_b_of_type_Long;
            break label66;
          }
        }
      }
      long l = 0L;
      label66:
      bool1 = bool2;
      if (l >= 0L)
      {
        bool1 = bool2;
        if ((paramBaseVideoItemHolder instanceof VideoItemHolder))
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(paramBaseVideoItemHolder)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private final void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    int i = paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a());
    int j = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a())[0];
    if (paramBoolean)
    {
      ((ViewGroup.LayoutParams)localObject).height = -1;
      ((ViewGroup.LayoutParams)localObject).width = -1;
    }
    else
    {
      if (paramVideoInfo.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a())) {
        ((ViewGroup.LayoutParams)localObject).height = i;
      } else {
        ((ViewGroup.LayoutParams)localObject).height = i;
      }
      ((ViewGroup.LayoutParams)localObject).width = -1;
    }
    paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.itemView;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoHolder.itemView");
    paramVideoInfo.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    int i = paramVideoInfo.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a());
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
    }
    else
    {
      localLayoutParams.width = -1;
      if (paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_Int) == 2)
      {
        localLayoutParams.height = -1;
      }
      else
      {
        if (i <= 0) {
          i = -1;
        }
        localLayoutParams.height = i;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
  }
  
  private final void m(boolean paramBoolean)
  {
    IVideoFeedsItemUIDelegate localIVideoFeedsItemUIDelegate = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate;
    if (localIVideoFeedsItemUIDelegate != null) {
      localIVideoFeedsItemUIDelegate.a(Boolean.valueOf(paramBoolean));
    }
  }
  
  public void a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility();
    boolean bool = false;
    if (i == 8) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    } else if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b()) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
      bool = true;
    }
    m(bool);
  }
  
  public void a(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate;
    boolean bool = false;
    if (localObject != null) {
      ((IVideoFeedsVideoUIDelegate)localObject).a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setProgress((int)(100 * paramFloat));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.q.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_h_of_type_AndroidWidgetImageView;
      if (paramFloat != 0.0F) {
        bool = true;
      }
      ((ImageView)localObject).setEnabled(bool);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setProgress((int)(paramFloat * 100));
    }
    IVideoFeedsAdapter.DefaultImpls.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter, 0, 1500, false, 4, null);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      m(true);
      return;
    }
    if (paramInt == 2) {
      m(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
  
  public void a(@Nullable IVideoFeedsItemUIDelegate paramIVideoFeedsItemUIDelegate)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate = paramIVideoFeedsItemUIDelegate;
  }
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_h_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_h_of_type_AndroidViewViewGroup.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    int i = VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a())[0];
    int j = paramVideoInfo.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a());
    b(paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup.setTag(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder);
    if ((paramVideoInfo.jdField_b_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int > 0) && (paramVideoInfo.jdField_c_of_type_Int < 10000) && (paramVideoInfo.jdField_b_of_type_Int < 10000) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if (localObject1 != null) {
        localObject1 = ((VideoPlayParam)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("refreshContentUI: setFixedSize width=");
          ((StringBuilder)localObject1).append(paramVideoInfo.jdField_b_of_type_Int);
          ((StringBuilder)localObject1).append(", height=");
          ((StringBuilder)localObject1).append(paramVideoInfo.jdField_c_of_type_Int);
          QLog.d("BaseVideoItemDelegate", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
        if (localObject1 != null)
        {
          localObject1 = ((VideoPlayParam)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
          if (localObject1 != null) {
            ((IVideoPlayerWrapper)localObject1).b(paramVideoInfo.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_Int));
          }
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
        if (localObject1 != null)
        {
          localObject1 = ((VideoPlayParam)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
          if (localObject1 != null)
          {
            localObject1 = ((IVideoPlayerWrapper)localObject1).a();
            if (localObject1 != null) {
              ((IVideoView)localObject1).a(paramVideoInfo.jdField_b_of_type_Int, paramVideoInfo.jdField_c_of_type_Int);
            }
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout.setTag(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout.setOnCustomClickListener((CustomClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout.setVideoPlayManager(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout.setChannelID(409409L);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout.setVideoBrightnessController((VideoBrightnessController)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a());
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g;
    if (localObject1 != null) {
      ((ImageView)localObject1).setBackgroundDrawable(null);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g;
    if (localObject1 != null) {
      ((ImageView)localObject1).setTag(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g;
    if (localObject1 != null) {
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    }
    Object localObject2 = paramVideoInfo.a();
    localObject1 = (ImageView)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_ComTencentImageURLImageView;
    c(paramVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b());
    if (localObject2 != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_Int != 0) || (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_b_of_type_Int != 0) || (!a((ImageView)localObject1, (URL)localObject2)))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a());
        localURLDrawableOptions.mFailedDrawable = ((Drawable)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a());
        localObject2 = URLDrawable.getDrawable((URL)localObject2, localURLDrawableOptions);
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        }
      }
    }
    else if (localObject1 != null) {
      ((ImageView)localObject1).setImageDrawable(null);
    }
    if (localObject1 != null) {
      ((ImageView)localObject1).setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView, 0L);
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.q, paramVideoInfo.c() * 1000);
    if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_Int == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.f.setTag(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.f.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView;
    if (paramVideoInfo != null) {
      paramVideoInfo.setAlpha(1.0F);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.s.setVisibility(8);
    paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g;
    if (paramVideoInfo != null) {
      paramVideoInfo.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.r.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.t.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_o_of_type_AndroidViewView.setVisibility(8);
    paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_i_of_type_AndroidViewViewGroup;
    if (paramVideoInfo != null) {
      paramVideoInfo.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
    }
    paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_i_of_type_AndroidViewViewGroup;
    if (paramVideoInfo != null) {
      paramVideoInfo.setTag(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder);
    }
    if (PlayerHelper.a.a())
    {
      paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_i_of_type_AndroidViewViewGroup;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(0);
      }
    }
    else
    {
      paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_i_of_type_AndroidViewViewGroup;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
    }
    m(false);
  }
  
  protected final void a(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseVideoItemHolder, "holder");
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a();
    if (localActivity != null)
    {
      Object localObject1 = paramBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if (localObject1 != null) {
        localObject1 = ((VideoPlayParam)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      } else {
        localObject1 = null;
      }
      if (paramBoolean)
      {
        localObject1 = HardCodeUtil.a(2131715972);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "HardCodeUtil.qqStr(R.str….qqstr_videofee_b91647ab)");
      }
      else
      {
        long l;
        if (localObject1 != null) {
          l = ((VideoInfo)localObject1).jdField_b_of_type_Long;
        } else {
          l = 0L;
        }
        localObject1 = VideoFeedsHelper.c(l);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "VideoFeedsHelper.getXgFi…deoInfo?.xgFileSize ?: 0)");
      }
      Object localObject2 = paramBaseVideoItemHolder.g;
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(8);
      }
      localObject2 = localActivity.getResources().getDrawable(2130843291);
      paramBaseVideoItemHolder.r.setText((CharSequence)localObject1);
      paramBaseVideoItemHolder.r.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
      paramBaseVideoItemHolder.r.setCompoundDrawablePadding(AIOUtils.b(6.0F, localActivity.getResources()));
      paramBaseVideoItemHolder.r.setVisibility(0);
      paramBaseVideoItemHolder.r.setOnClickListener((View.OnClickListener)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter);
      paramBaseVideoItemHolder.r.setTag(paramBaseVideoItemHolder);
      if ((!paramBoolean) && (!TextUtils.isEmpty((CharSequence)CUKingCardHelper.a("kandian"))))
      {
        paramBaseVideoItemHolder.t.setVisibility(0);
        VideoFeedsHelper.a((Context)localActivity, paramBaseVideoItemHolder.t);
      }
    }
  }
  
  public void a(@Nullable VideoItemHolder paramVideoItemHolder, @Nullable VideoInfo paramVideoInfo) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if ((localObject != null) && (((VideoInfo)localObject).jdField_a_of_type_Int == 0))
        {
          m(true);
          break label79;
        }
      }
    }
    m(false);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0) {
      VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup, 8);
    }
    label79:
    if (paramBoolean)
    {
      if (a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder)) {
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.d());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setAlpha(0.0F);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b();
    if (localObject != null)
    {
      localObject = ((BaseVideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIMsgLayoutHelper;
      if (localObject != null) {
        ((IMsgLayoutHelper)localObject).a();
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder)) {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.d());
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView;
    if (localObject != null) {
      ((VideoFeedsAlphaMaskView)localObject).setAlpha(0.0F);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_Int == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if ((localObject != null) && (((VideoInfo)localObject).jdField_a_of_type_Int == 0))
        {
          m(true);
          return;
        }
      }
    }
    m(false);
  }
  
  public void a_(@Nullable VideoInfo paramVideoInfo) {}
  
  public void b(int paramInt)
  {
    ImageView localImageView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.j;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void b(@Nullable VideoInfo paramVideoInfo) {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup, 0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 8) {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup, 0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.getVisibility() == 0) {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup, 8);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a().f() == true) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup.getVisibility() == 0)) {
        VideoFeedsHelper.a((View)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_c_of_type_AndroidViewViewGroup, 8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
    }
    l(paramBoolean);
  }
  
  public void c(@Nullable VideoInfo paramVideoInfo)
  {
    paramVideoInfo = new StringBuilder();
    paramVideoInfo.append("An operation is not implemented: ");
    paramVideoInfo.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(paramVideoInfo.toString()));
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject != null) {
        b((VideoInfo)localObject, paramBoolean);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject != null) {
        c((VideoInfo)localObject, paramBoolean);
      }
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.e.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_i_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(2130841851));
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setVisibility(8);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.e.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_i_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.a(2130841852));
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setVisibility(0);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsAdapter.f();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout.setIsInFullScreen(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityAbsVideoFeedsGestureLayout.a();
    m(false);
    if (LiuHaiUtils.b())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setPadding(LiuHaiUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a()), 0, LiuHaiUtils.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.a()), 0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_d_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject != null) {
        b((VideoInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b());
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject != null) {
        c((VideoInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b());
      }
    }
  }
  
  public void d(boolean paramBoolean) {}
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.b();
    if (localObject != null)
    {
      localObject = ((BaseVideoItemHolder)localObject).jdField_d_of_type_AndroidViewViewGroup;
      if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
      {
        bool = true;
        break label37;
      }
    }
    boolean bool = false;
    label37:
    l(bool);
  }
  
  public void e(boolean paramBoolean) {}
  
  public void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
  
  public void f(boolean paramBoolean) {}
  
  public void g(boolean paramBoolean) {}
  
  public void h(boolean paramBoolean) {}
  
  public void i(boolean paramBoolean) {}
  
  public void j(boolean paramBoolean)
  {
    m(paramBoolean);
  }
  
  public void k(boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.g;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.r.setVisibility(8);
        if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.d()) && (!TextUtils.isEmpty((CharSequence)CUKingCardHelper.a("kandian")))) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.t.setVisibility(8);
        }
      }
    }
    else
    {
      if (VideoFeedsHelper.b())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsRecommendPresenter.d())
        {
          localObject1 = HardCodeUtil.a(2131715972);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "HardCodeUtil.qqStr(R.str….qqstr_videofee_b91647ab)");
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
          if (localObject1 != null)
          {
            localObject1 = ((VideoPlayParam)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
            if (localObject1 != null)
            {
              l = ((VideoInfo)localObject1).jdField_b_of_type_Long;
              break label160;
            }
          }
          long l = 0L;
          label160:
          localObject1 = VideoFeedsHelper.c(l);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "VideoFeedsHelper.getXgFi…                    ?: 0)");
        }
        localObject2 = HardCodeUtil.a(2131715928);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIMsgLayoutHelper.a(0, (String)localObject2, (String)localObject1, 2130843373);
        return;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate;
      if (localObject2 != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
        if (localObject1 != null) {
          localObject1 = ((VideoPlayParam)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        } else {
          localObject1 = null;
        }
        ((IVideoFeedsVideoUIDelegate)localObject2).a((VideoInfo)localObject1);
      }
    }
  }
  
  protected final void l(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_o_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.q.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(true);
    }
    IVideoFeedsVideoUIDelegate localIVideoFeedsVideoUIDelegate = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate;
    if (localIVideoFeedsVideoUIDelegate != null) {
      localIVideoFeedsVideoUIDelegate.a(true);
    }
    localIVideoFeedsVideoUIDelegate = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderBaseVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsVideoUIDelegate;
    if (localIVideoFeedsVideoUIDelegate != null) {
      localIVideoFeedsVideoUIDelegate.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate.BaseVideoItemDelegateProxy
 * JD-Core Version:    0.7.0.1
 */