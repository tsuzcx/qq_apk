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
import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.kandian.base.image.api.ICloseableBitmap;
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
  public final IVideoFeedsRecommendPresenter a;
  @JvmField
  @NotNull
  public final IVideoFeedsAdapter b;
  private IVideoFeedsItemUIDelegate c;
  private final BaseVideoItemHolder d;
  
  public BaseVideoItemDelegateProxy(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, @NotNull IVideoFeedsRecommendPresenter paramIVideoFeedsRecommendPresenter, @NotNull IVideoFeedsAdapter paramIVideoFeedsAdapter)
  {
    this.d = paramBaseVideoItemHolder;
    this.a = paramIVideoFeedsRecommendPresenter;
    this.b = paramIVideoFeedsAdapter;
    this.c = ((IVideoFeedsItemUIDelegate)this);
  }
  
  private final boolean a(ImageView paramImageView, URL paramURL)
  {
    Object localObject1 = this.a.v();
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
      ((ImageRequest)localObject1).a = RIJConvertString2URL.b(paramURL.toString());
      ((ImageRequest)localObject1).b = j;
      ((ImageRequest)localObject1).c = i;
      ICloseableBitmap localICloseableBitmap = ImageManager.get().getBitmap((ImageRequest)localObject1);
      localObject1 = localObject2;
      if (localICloseableBitmap != null) {
        localObject1 = localICloseableBitmap.b();
      }
      if (localObject1 != null)
      {
        paramURL = (Drawable)new ZBitmapDrawable(localICloseableBitmap.b());
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
    boolean bool3 = NetworkUtil.isMobileNetWork((Context)this.a.v());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      if (paramBaseVideoItemHolder != null)
      {
        Object localObject = paramBaseVideoItemHolder.az;
        if (localObject != null)
        {
          localObject = ((VideoPlayParam)localObject).c;
          if (localObject != null)
          {
            l = ((VideoInfo)localObject).n;
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
          if (!this.b.b(paramBaseVideoItemHolder)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private final void b(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Object localObject = this.d.itemView;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "videoHolder.itemView");
    localObject = ((View)localObject).getLayoutParams();
    int i = paramVideoInfo.c(this.a.v());
    int j = VideoFeedsHelper.c(this.a.v())[0];
    if (paramBoolean)
    {
      ((ViewGroup.LayoutParams)localObject).height = -1;
      ((ViewGroup.LayoutParams)localObject).width = -1;
    }
    else
    {
      if (paramVideoInfo.e(this.a.v())) {
        ((ViewGroup.LayoutParams)localObject).height = i;
      } else {
        ((ViewGroup.LayoutParams)localObject).height = i;
      }
      ((ViewGroup.LayoutParams)localObject).width = -1;
    }
    paramVideoInfo = this.d.itemView;
    Intrinsics.checkExpressionValueIsNotNull(paramVideoInfo, "videoHolder.itemView");
    paramVideoInfo.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private final void c(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    int i = paramVideoInfo.d(this.a.v());
    ViewGroup.LayoutParams localLayoutParams = this.d.ao.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.height = -1;
      localLayoutParams.width = -1;
    }
    else
    {
      localLayoutParams.width = -1;
      if (paramVideoInfo.a(this.a.v(), this.d.aD) == 2)
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
    this.d.ao.setLayoutParams(localLayoutParams);
  }
  
  private final void m(boolean paramBoolean)
  {
    IVideoFeedsItemUIDelegate localIVideoFeedsItemUIDelegate = this.c;
    if (localIVideoFeedsItemUIDelegate != null) {
      localIVideoFeedsItemUIDelegate.a(Boolean.valueOf(paramBoolean));
    }
  }
  
  public void a()
  {
    int i = this.d.af.getVisibility();
    boolean bool = false;
    if (i == 8) {
      this.d.aj.setVisibility(8);
    } else if (!this.a.e()) {
      this.d.aj.setVisibility(0);
    }
    if (this.d.af.getVisibility() == 8) {
      bool = true;
    }
    m(bool);
  }
  
  public void a(float paramFloat)
  {
    Object localObject = this.d.aB;
    boolean bool = false;
    if (localObject != null) {
      ((IVideoFeedsVideoUIDelegate)localObject).a(false);
    }
    if (this.d.af.getVisibility() == 0)
    {
      this.d.ai.setEnabled(false);
      this.d.ai.setProgress((int)(100 * paramFloat));
      this.d.ak.setVisibility(8);
      this.d.am.setVisibility(8);
      this.d.ah.setVisibility(0);
      localObject = this.d.ah;
      if (paramFloat != 0.0F) {
        bool = true;
      }
      ((ImageView)localObject).setEnabled(bool);
    }
    else
    {
      this.d.aj.setEnabled(false);
      this.d.aj.setProgress((int)(paramFloat * 100));
    }
    IVideoFeedsAdapter.DefaultImpls.a(this.b, 0, 1500, false, 4, null);
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
    this.c = paramIVideoFeedsItemUIDelegate;
  }
  
  public void a(@NotNull VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    this.d.at.setTag(this.d);
    this.d.at.setOnClickListener((View.OnClickListener)this.b);
    int i = VideoFeedsHelper.c(this.a.v())[0];
    int j = paramVideoInfo.d(this.a.v());
    b(paramVideoInfo, this.a.e());
    this.d.aa.setOnClickListener((View.OnClickListener)this.b);
    this.d.aa.setTag(this.d);
    if ((paramVideoInfo.c > 0) && (paramVideoInfo.d > 0) && (paramVideoInfo.d < 10000) && (paramVideoInfo.c < 10000) && (this.d.az != null))
    {
      localObject1 = this.d.az;
      if (localObject1 != null) {
        localObject1 = ((VideoPlayParam)localObject1).h;
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("refreshContentUI: setFixedSize width=");
          ((StringBuilder)localObject1).append(paramVideoInfo.c);
          ((StringBuilder)localObject1).append(", height=");
          ((StringBuilder)localObject1).append(paramVideoInfo.d);
          QLog.d("BaseVideoItemDelegate", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = this.d.az;
        if (localObject1 != null)
        {
          localObject1 = ((VideoPlayParam)localObject1).h;
          if (localObject1 != null) {
            ((IVideoPlayerWrapper)localObject1).b(paramVideoInfo.a(this.a.v(), this.d.aD));
          }
        }
        localObject1 = this.d.az;
        if (localObject1 != null)
        {
          localObject1 = ((VideoPlayParam)localObject1).h;
          if (localObject1 != null)
          {
            localObject1 = ((IVideoPlayerWrapper)localObject1).c();
            if (localObject1 != null) {
              ((IVideoView)localObject1).a(paramVideoInfo.c, paramVideoInfo.d);
            }
          }
        }
      }
    }
    this.d.ac.setTag(this.d);
    this.d.ac.setOnCustomClickListener((CustomClickListener)this.b);
    this.d.ac.setContext(this.a.v());
    this.d.ac.setVideoPlayManager(this.a.x());
    this.d.ac.setChannelID(409409L);
    this.d.ac.setVideoBrightnessController((VideoBrightnessController)this.b.g());
    Object localObject1 = this.d.ad;
    if (localObject1 != null) {
      ((ImageView)localObject1).setBackgroundDrawable(null);
    }
    localObject1 = this.d.ad;
    if (localObject1 != null) {
      ((ImageView)localObject1).setTag(this.d);
    }
    localObject1 = this.d.ad;
    if (localObject1 != null) {
      ((ImageView)localObject1).setOnClickListener((View.OnClickListener)this.b);
    }
    Object localObject2 = paramVideoInfo.t();
    localObject1 = (ImageView)this.d.ao;
    c(paramVideoInfo, this.a.e());
    if (localObject2 != null)
    {
      if ((this.d.Z != 0) || (this.d.Y != 0) || (!a((ImageView)localObject1, (URL)localObject2)))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = i;
        localURLDrawableOptions.mRequestHeight = j;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)this.b.h());
        localURLDrawableOptions.mFailedDrawable = ((Drawable)this.b.h());
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
    this.d.ai.setProgress(0);
    VideoFeedsHelper.a(this.d.ak, 0L);
    VideoFeedsHelper.a(this.d.am, paramVideoInfo.k() * 1000);
    if ((!this.b.i()) && (this.d.Z == 0)) {
      this.d.ae.setVisibility(0);
    } else {
      this.d.ae.setVisibility(8);
    }
    this.d.af.setVisibility(8);
    this.d.aj.setProgress(0);
    this.d.an.setTag(this.d);
    this.d.an.setOnClickListener((View.OnClickListener)this.b);
    paramVideoInfo = this.d.W;
    if (paramVideoInfo != null) {
      paramVideoInfo.setAlpha(1.0F);
    }
    this.d.ar.setVisibility(8);
    paramVideoInfo = this.d.ad;
    if (paramVideoInfo != null) {
      paramVideoInfo.setVisibility(0);
    }
    this.d.aq.setVisibility(8);
    this.d.as.setVisibility(8);
    this.d.aw.setVisibility(8);
    paramVideoInfo = this.d.ax;
    if (paramVideoInfo != null) {
      paramVideoInfo.setOnClickListener((View.OnClickListener)this.b);
    }
    paramVideoInfo = this.d.ax;
    if (paramVideoInfo != null) {
      paramVideoInfo.setTag(this.d);
    }
    if (PlayerHelper.a.a())
    {
      paramVideoInfo = this.d.ax;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(0);
      }
    }
    else
    {
      paramVideoInfo = this.d.ax;
      if (paramVideoInfo != null) {
        paramVideoInfo.setVisibility(8);
      }
    }
    m(false);
  }
  
  protected final void a(@NotNull BaseVideoItemHolder paramBaseVideoItemHolder, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseVideoItemHolder, "holder");
    Activity localActivity = this.a.v();
    if (localActivity != null)
    {
      Object localObject1 = paramBaseVideoItemHolder.az;
      if (localObject1 != null) {
        localObject1 = ((VideoPlayParam)localObject1).c;
      } else {
        localObject1 = null;
      }
      if (paramBoolean)
      {
        localObject1 = HardCodeUtil.a(2131913426);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "HardCodeUtil.qqStr(R.str….qqstr_videofee_b91647ab)");
      }
      else
      {
        long l;
        if (localObject1 != null) {
          l = ((VideoInfo)localObject1).n;
        } else {
          l = 0L;
        }
        localObject1 = VideoFeedsHelper.d(l);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "VideoFeedsHelper.getXgFi…deoInfo?.xgFileSize ?: 0)");
      }
      Object localObject2 = paramBaseVideoItemHolder.ad;
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(8);
      }
      localObject2 = localActivity.getResources().getDrawable(2130844245);
      paramBaseVideoItemHolder.aq.setText((CharSequence)localObject1);
      paramBaseVideoItemHolder.aq.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
      paramBaseVideoItemHolder.aq.setCompoundDrawablePadding(AIOUtils.b(6.0F, localActivity.getResources()));
      paramBaseVideoItemHolder.aq.setVisibility(0);
      paramBaseVideoItemHolder.aq.setOnClickListener((View.OnClickListener)this.b);
      paramBaseVideoItemHolder.aq.setTag(paramBaseVideoItemHolder);
      if ((!paramBoolean) && (!TextUtils.isEmpty((CharSequence)CUKingCardHelper.a("kandian"))))
      {
        paramBaseVideoItemHolder.as.setVisibility(0);
        VideoFeedsHelper.a((Context)localActivity, paramBaseVideoItemHolder.as);
      }
    }
  }
  
  public void a(@Nullable VideoItemHolder paramVideoItemHolder, @Nullable VideoInfo paramVideoInfo) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.d.af.getVisibility() == 8) {
        VideoFeedsHelper.a((View)this.d.af, 0);
      }
      if (this.d.ae.getVisibility() == 8) {
        VideoFeedsHelper.a((View)this.d.ae, 0);
      }
    }
    else
    {
      if (this.d.af.getVisibility() == 0) {
        VideoFeedsHelper.a((View)this.d.af, 8);
      }
      if ((this.a.x().p() == true) && (this.d.ae.getVisibility() == 0)) {
        VideoFeedsHelper.a((View)this.d.ae, 8);
      }
      if (this.a.e()) {
        this.d.aj.setVisibility(8);
      } else {
        this.d.aj.setVisibility(0);
      }
    }
    c(paramBoolean);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a(this.d)) {
      a(this.d, this.a.t());
    } else {
      this.d.ae.setVisibility(8);
    }
    Object localObject = this.d.W;
    if (localObject != null) {
      ((VideoFeedsAlphaMaskView)localObject).setAlpha(0.0F);
    }
    if (this.d.Z == 0)
    {
      localObject = this.d.az;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).c;
        if ((localObject != null) && (((VideoInfo)localObject).a == 0))
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
    ImageView localImageView = this.d.ay;
    if (localImageView != null) {
      localImageView.setImageResource(paramInt);
    }
  }
  
  public void b(@Nullable VideoInfo paramVideoInfo) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.d.Z == 0)
    {
      localObject = this.d.az;
      if (localObject != null)
      {
        localObject = ((VideoPlayParam)localObject).c;
        if ((localObject != null) && (((VideoInfo)localObject).a == 0))
        {
          m(true);
          break label79;
        }
      }
    }
    m(false);
    if (this.d.ae.getVisibility() == 0) {
      VideoFeedsHelper.a((View)this.d.ae, 8);
    }
    label79:
    if (paramBoolean)
    {
      if (a(this.d)) {
        a(this.d, this.a.t());
      }
      localObject = this.d.W;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setAlpha(0.0F);
      }
    }
    Object localObject = this.a.u();
    if (localObject != null)
    {
      localObject = ((BaseVideoItemHolder)localObject).aC;
      if (localObject != null) {
        ((IMsgLayoutHelper)localObject).a();
      }
    }
  }
  
  public void c(@Nullable VideoInfo paramVideoInfo)
  {
    paramVideoInfo = new StringBuilder();
    paramVideoInfo.append("An operation is not implemented: ");
    paramVideoInfo.append("Not yet implemented");
    throw ((Throwable)new NotImplementedError(paramVideoInfo.toString()));
  }
  
  protected final void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.ai.setEnabled(true);
      this.d.ak.setVisibility(0);
      this.d.am.setVisibility(0);
      this.d.ah.setVisibility(8);
    }
    else
    {
      this.d.aj.setEnabled(true);
    }
    IVideoFeedsVideoUIDelegate localIVideoFeedsVideoUIDelegate = this.d.aB;
    if (localIVideoFeedsVideoUIDelegate != null) {
      localIVideoFeedsVideoUIDelegate.a(true);
    }
    localIVideoFeedsVideoUIDelegate = this.d.aB;
    if (localIVideoFeedsVideoUIDelegate != null) {
      localIVideoFeedsVideoUIDelegate.a();
    }
  }
  
  public void d()
  {
    Object localObject = this.d.az;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).c;
      if (localObject != null) {
        b((VideoInfo)localObject, this.a.e());
      }
    }
    localObject = this.d.az;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).c;
      if (localObject != null) {
        c((VideoInfo)localObject, this.a.e());
      }
    }
  }
  
  public void d(boolean paramBoolean)
  {
    Object localObject = this.d.az;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).c;
      if (localObject != null) {
        b((VideoInfo)localObject, paramBoolean);
      }
    }
    localObject = this.d.az;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).c;
      if (localObject != null) {
        c((VideoInfo)localObject, paramBoolean);
      }
    }
    if (paramBoolean)
    {
      this.d.ag.setVisibility(0);
      this.d.au.setBackgroundDrawable(this.b.e(2130842768));
      localObject = this.d.W;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setVisibility(8);
      }
    }
    else
    {
      this.d.ag.setVisibility(8);
      this.d.au.setBackgroundDrawable(this.b.e(2130842769));
      localObject = this.d.W;
      if (localObject != null) {
        ((VideoFeedsAlphaMaskView)localObject).setVisibility(0);
      }
    }
    this.b.f();
    this.d.ac.setIsInFullScreen(paramBoolean);
    this.d.ac.a();
    m(false);
    if (LiuHaiUtils.b())
    {
      if (paramBoolean)
      {
        this.d.af.setPadding(LiuHaiUtils.e(this.a.v()), 0, LiuHaiUtils.e(this.a.v()), 0);
        return;
      }
      this.d.af.setPadding(0, 0, 0, 0);
    }
  }
  
  public void e()
  {
    Object localObject = this.a.u();
    if (localObject != null)
    {
      localObject = ((BaseVideoItemHolder)localObject).af;
      if ((localObject != null) && (((ViewGroup)localObject).getVisibility() == 0))
      {
        bool = true;
        break label37;
      }
    }
    boolean bool = false;
    label37:
    c(bool);
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
  
  public void j(boolean paramBoolean) {}
  
  public void k(boolean paramBoolean)
  {
    m(paramBoolean);
  }
  
  public void l(boolean paramBoolean)
  {
    Object localObject1;
    if (paramBoolean)
    {
      if (this.d.ad != null)
      {
        localObject1 = this.d.ad;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
        this.d.aq.setVisibility(8);
        if ((!this.a.t()) && (!TextUtils.isEmpty((CharSequence)CUKingCardHelper.a("kandian")))) {
          this.d.as.setVisibility(8);
        }
      }
    }
    else
    {
      if (VideoFeedsHelper.e())
      {
        if (this.a.t())
        {
          localObject1 = HardCodeUtil.a(2131913426);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "HardCodeUtil.qqStr(R.str….qqstr_videofee_b91647ab)");
        }
        else
        {
          localObject1 = this.d.az;
          if (localObject1 != null)
          {
            localObject1 = ((VideoPlayParam)localObject1).c;
            if (localObject1 != null)
            {
              l = ((VideoInfo)localObject1).n;
              break label160;
            }
          }
          long l = 0L;
          label160:
          localObject1 = VideoFeedsHelper.d(l);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "VideoFeedsHelper.getXgFi…                    ?: 0)");
        }
        localObject2 = HardCodeUtil.a(2131913383);
        this.d.aC.a(0, (String)localObject2, (String)localObject1, 2130844327);
        return;
      }
      Object localObject2 = this.d.aB;
      if (localObject2 != null)
      {
        localObject1 = this.d.az;
        if (localObject1 != null) {
          localObject1 = ((VideoPlayParam)localObject1).c;
        } else {
          localObject1 = null;
        }
        ((IVideoFeedsVideoUIDelegate)localObject2).a((VideoInfo)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.delegate.BaseVideoItemDelegateProxy
 * JD-Core Version:    0.7.0.1
 */