package com.tencent.mobileqq.kandian.biz.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.OnPatchPlayListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleNativeView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyVideoAdHighLightBar;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.businessCard.helpers.ViewHelper;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.drawable.RoundRectColorDrawable;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.api.CountDownCallback;
import com.tencent.mobileqq.kandian.biz.feeds.api.IVideoUIManager;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsGestureLayout;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.biz.video.api.OnPlayStateListener;
import com.tencent.mobileqq.kandian.biz.video.api.OnUIChangeListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.MsgLayoutHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.PlayFeedbackHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.CustomClickListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoBrightnessController;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController.OnFullPlayListener;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager.VideoStatusListener;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.ArticlePatchStatus;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.articlesummary.articlesummary.UrlJumpInfo;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;

public class VideoUIManager
  implements View.OnClickListener, IVideoUIManager, OrientationDetector.OnOrientationChangedListener, OnPlayStateListener, CustomClickListener, VideoPlayManager.VideoStatusListener, AbsListView.OnScrollListener
{
  protected int a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new VideoUIManager.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar.OnSeekBarChangeListener jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener = new VideoUIManager.7(this);
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public OnPatchPlayListener a;
  private ReadInJoyAdBubbleNativeView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleNativeView;
  private ReadInJoyAdVideoGuide jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
  private ReadInJoyPatchAdView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView;
  private ReadInJoyVideoAdHighLightBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private VideoViewGroup jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup;
  private ReadInJoyBaseListView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView;
  private CountDownCallback jdField_a_of_type_ComTencentMobileqqKandianBizFeedsApiCountDownCallback;
  private VideoFeedsGestureLayout jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout;
  private OrientationDetector jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector;
  private OnUIChangeListener jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiOnUIChangeListener;
  private VideoPlayParam jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
  private MsgLayoutHelper jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedbackMsgLayoutHelper;
  private VideoBrightnessController jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController;
  private VideoFullPlayController jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController;
  private VideoPlayManager jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  private ArrayList<OnUIChangeListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private List<VideoUIManager.OnScreenChangeListener> jdField_a_of_type_JavaUtilList;
  private articlesummary.VideoDownloadBarInfo jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  protected int b;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private SeekBar jdField_b_of_type_AndroidWidgetSeekBar;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private KandianUrlImageView jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private int jdField_i_of_type_Int;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private int jdField_j_of_type_Int;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private int jdField_k_of_type_Int = 0;
  private TextView jdField_k_of_type_AndroidWidgetTextView;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  
  public VideoUIManager(FrameLayout paramFrameLayout, ReadInJoyBaseListView paramReadInJoyBaseListView, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView = paramReadInJoyBaseListView;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedbackMsgLayoutHelper = new MsgLayoutHelper(this.jdField_a_of_type_AndroidWidgetFrameLayout, this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController = new VideoFullPlayController(paramActivity, this.jdField_a_of_type_AndroidWidgetFrameLayout, new VideoUIManager.2(this));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector = new OrientationDetector(this.jdField_a_of_type_AndroidAppActivity, this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController = new VideoBrightnessController(paramActivity);
    paramFrameLayout = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    this.jdField_a_of_type_Int = paramFrameLayout.getAttributes().flags;
    this.jdField_b_of_type_Int = paramFrameLayout.getDecorView().getSystemUiVisibility();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.setScrollEventCallback(new VideoUIManager.3(this));
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(1000L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatCount(-1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setRepeatMode(1);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setStartTime(-1L);
    paramFrameLayout = new LinearInterpolator();
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setInterpolator(paramFrameLayout);
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131378810);
  }
  
  private void A()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedbackMsgLayoutHelper.b();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
  }
  
  private void B()
  {
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
    if (a()) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    } else {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
    if (!VideoFeedsHelper.d()) {
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
    }
  }
  
  private void C()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    int i1;
    if (localObject != null) {
      i1 = (int)(((VideoPlayManager)localObject).b() / 1000L);
    } else {
      i1 = 0;
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).reportVideoPlayC2sBasedTimeFilter(i1, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager);
    if (this.jdField_b_of_type_AndroidWidgetSeekBar.isEnabled())
    {
      if (this.jdField_b_of_type_AndroidWidgetSeekBar.getVisibility() != 0) {
        this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      }
      this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i1);
    }
    if ((this.jdField_a_of_type_AndroidWidgetSeekBar.getVisibility() == 0) && (this.jdField_a_of_type_AndroidWidgetSeekBar.isEnabled())) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i1);
    }
    if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      this.jdField_f_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(i1, false));
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiOnUIChangeListener;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam != null))
    {
      VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
      if (localVideoPlayManager != null) {
        ((OnUIChangeListener)localObject).a(localVideoPlayManager.a(), (int)this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.b(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Int * 1000);
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager != null))
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OnUIChangeListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(), (int)this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.b(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Int * 1000);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.a()), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
    }
  }
  
  private void D()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    l();
    A();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    P();
    I();
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar;
    if (localObject != null) {
      ((ReadInJoyVideoAdHighLightBar)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
    if (localObject != null) {
      ((ReadInJoyAdVideoGuide)localObject).setVisibility(8);
    }
  }
  
  private void E()
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
  }
  
  private void F()
  {
    try
    {
      if ((a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.getAdapter() != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
          return;
        }
        if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdExpandLiveVideoCard(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
          return;
        }
        a().a(0);
        ReadInJoyArticleAdapter localReadInJoyArticleAdapter = (ReadInJoyArticleAdapter)((HeaderViewListAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.getAdapter()).getWrappedAdapter();
        ((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).isSmallCard = true;
        ((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).clickPos = 40;
        localReadInJoyArticleAdapter.notifyDataSetChanged();
        ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(ReportAction.CLOSE, Integer.valueOf(0), (AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 3, 1, 1);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleAdLiveCloseClick(): error:");
      localStringBuilder.append(localException.getMessage());
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, localStringBuilder.toString());
    }
  }
  
  private void G()
  {
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
    {
      if (a()) {
        b(false);
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoUIManager.10(this));
      PlayFeedbackHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.a()), 0, 0);
      PlayFeedbackHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.a(), 0, 0);
    }
  }
  
  private void H()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (localObject != null)
      {
        localObject = new VideoR5.Builder(null, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.k, ((AbsBaseArticleInfo)localObject).mVideoVid, ((AbsBaseArticleInfo)localObject).getInnerUniqueID()).a((int)((AbsBaseArticleInfo)localObject).mChannelID).a().a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009505", "0X8009505", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a(), "", (String)localObject, false);
      }
    }
  }
  
  private void I()
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetSeekBar;
    if (localObject == null) {
      return;
    }
    ((SeekBar)localObject).setEnabled(true);
    int i1 = 0;
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localObject != null) {
      i1 = (int)(((VideoPlayManager)localObject).b() / 1000L);
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(i1);
  }
  
  private void J()
  {
    Object localObject = this.jdField_f_of_type_AndroidWidgetTextView;
    int i1 = 0;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.jdField_g_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.jdField_e_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.jdField_d_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetSeekBar;
    if (localObject != null)
    {
      ((SeekBar)localObject).setEnabled(true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
      if (localObject != null) {
        i1 = (int)(((VideoPlayManager)localObject).b() / 1000L);
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(i1);
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).sendEmptyMessageDelayed(101, 3000L);
    }
  }
  
  private void K()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if ((localObject != null) && (((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoDownloadBarInfo != null))
    {
      this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoDownloadBarInfo;
      boolean bool = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.has();
      int i2 = 0;
      int i1 = i2;
      if (bool)
      {
        i1 = i2;
        if (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.get() >= 0)
        {
          this.jdField_k_of_type_Int = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_style.get();
          if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null))
          {
            i1 = i2;
            if (this.jdField_k_of_type_Int == 1) {
              if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get() > 0))
              {
                i1 = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get();
              }
              else
              {
                this.jdField_k_of_type_Int = 0;
                if (QLog.isColorLevel()) {
                  QLog.e("Q.readinjoy.videoVideoUIManager", 2, "checkIfHasDownloadInfo(), 协议字段不合法 2");
                }
              }
            }
          }
          else
          {
            this.jdField_k_of_type_Int = 0;
            if (QLog.isColorLevel()) {
              QLog.e("Q.readinjoy.videoVideoUIManager", 2, "checkIfHasDownloadInfo(), 协议字段不合法 1");
            }
            return;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkIfHasDownloadInfo(), mDownloadBarStyle:");
        ((StringBuilder)localObject).append(this.jdField_k_of_type_Int);
        ((StringBuilder)localObject).append(", appearTime:");
        ((StringBuilder)localObject).append(i1);
        QLog.i("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkIfHasDownloadInfo(), mVideoDownloadBarInfo == null, mPlayingVideoParam:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void L()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.videoVideoUIManager", 2, "checkIfShowDownloadBarPlaying(), mDownloadBarClicked, return");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.b() / 1000L >= this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.uint32_appear_time.get())
    {
      if ((!c()) && (!b()) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a() == 3))
      {
        h(1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.videoVideoUIManager", 2, "checkIfShowDownloadBarPlaying(): failure");
      }
    }
  }
  
  private void M()
  {
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365831)).inflate();
      this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362840));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131362841));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    }
    String str1 = a();
    if (!TextUtils.isEmpty(str1)) {
      try
      {
        URL localURL = new URL(str1);
        this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImagePlaceHolder(a(this.jdField_a_of_type_AndroidAppActivity, false)).setImage(localURL);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      this.jdField_b_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setBackgroundDrawable(a(this.jdField_a_of_type_AndroidAppActivity, false));
    }
    String str2 = b();
    if (!TextUtils.isEmpty(str2)) {
      this.jdField_i_of_type_AndroidWidgetTextView.setText(str2);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showDownloadBarPlaying(), iconUrl:");
      localStringBuilder.append(str1);
      localStringBuilder.append("，iconText:");
      localStringBuilder.append(str2);
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void N()
  {
    if ((this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null))
    {
      Object localObject = (articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get();
      if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() == 1)
      {
        if (RIJPBFieldUtils.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
        }
      }
      else if (((articlesummary.UrlJumpInfo)localObject).uint32_jump_type.get() == 2) {
        if ((RIJPBFieldUtils.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle)) && (PackageUtil.a(this.jdField_a_of_type_AndroidAppActivity, RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_bundle)))) {
          VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_schema));
        } else if (RIJPBFieldUtils.a(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url)) {
          ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)localObject).bytes_jump_url));
        }
      }
      this.jdField_g_of_type_Boolean = true;
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
      if ((localObject != null) && (((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
      {
        int i1 = this.jdField_k_of_type_Int;
        if (i1 == 1) {
          localObject = "0X8009BC5";
        }
        for (;;)
        {
          break;
          if (i1 == 2) {
            localObject = "0X8009BC7";
          } else {
            localObject = "";
          }
        }
        VideoR5.Builder localBuilder = new VideoR5.Builder("", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.k, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
        localBuilder.a((int)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Long);
        articlesummary.VideoDownloadBarInfo localVideoDownloadBarInfo = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo;
        if ((localVideoDownloadBarInfo != null) && (localVideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
          localBuilder.a(RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
        }
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", (String)localObject, (String)localObject, 0, 0, "3", "", "", localBuilder.a().a(), false);
      }
    }
  }
  
  private void O()
  {
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      this.jdField_c_of_type_AndroidViewView = ((ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365832)).inflate();
      this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362840));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362841));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131376414));
      this.l = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131365851));
      this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.l.setOnClickListener(this);
      int i1 = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843293);
      ((Drawable)localObject1).setBounds(0, 0, i1, i1);
      this.jdField_k_of_type_AndroidWidgetTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843198);
      ((Drawable)localObject1).setBounds(0, 0, i1, i1);
      this.l.setCompoundDrawables((Drawable)localObject1, null, null, null);
    }
    Object localObject1 = a();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        URL localURL = new URL((String)localObject1);
        this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImagePlaceHolder(a(this.jdField_a_of_type_AndroidAppActivity, true)).setImage(localURL);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      this.jdField_c_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setBackgroundDrawable(a(this.jdField_a_of_type_AndroidAppActivity, true));
    }
    String str = b();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_j_of_type_AndroidWidgetTextView.setText(str);
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    Object localObject2 = this.jdField_b_of_type_AndroidViewView;
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(8);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showDownloadBarComplete(), iconUrl:");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("，iconText:");
      ((StringBuilder)localObject2).append(str);
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    E();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
  }
  
  private void P()
  {
    i(1);
    i(2);
  }
  
  private void Q()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      if (((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
        return;
      }
      if ((VideoFeedsHelper.e()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoLogoUrl)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoLogoUrl;
        try
        {
          if (((String)localObject).endsWith("zip"))
          {
            localObject = ReadInJoyLottieDrawable.a((String)localObject);
            ((ReadInJoyLottieDrawable)localObject).setRepeatCount(0);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
            ((ReadInJoyLottieDrawable)localObject).playAnimation();
          }
          else
          {
            localObject = new URL((String)localObject);
            URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            localURLDrawableOptions.mLoadingDrawable = new EmptyDrawable(0, 50, 150);
            localURLDrawableOptions.mPlayGifImage = true;
            localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
            this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          }
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
      }
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
    }
  }
  
  private void R()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      if (((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
        return;
      }
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdExpandLiveVideoCard(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
      {
        localObject = this.jdField_b_of_type_ComTencentImageURLImageView;
        if (localObject != null) {
          ((URLImageView)localObject).setVisibility(8);
        }
        localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
        if (localObject != null) {
          ((RelativeLayout)localObject).setVisibility(8);
        }
        return;
      }
      localObject = this.jdField_b_of_type_ComTencentImageURLImageView;
      if (localObject != null)
      {
        ((URLImageView)localObject).setVisibility(0);
        localObject = URLDrawable.getDrawable("https://img.nfa.qq.com/gmaster_prod/16104096/gmaster_b5gbv9fgqyg_adtagclose.png", URLDrawable.URLDrawableOptions.obtain());
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if ((localObject != null) && (this.n != null) && (this.m != null))
      {
        ((RelativeLayout)localObject).setVisibility(0);
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ((GradientDrawable)localObject).setColor(Color.parseColor("#4D000000"));
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(AIOUtils.b(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        localGradientDrawable.setColor(Color.parseColor("#FFFF7121"));
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable((Drawable)localObject);
        this.m.setBackgroundDrawable(localGradientDrawable);
        this.m.setText(((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).mAdvertisementExtInfo.i);
        this.n.setText(((AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo).mAdDesc);
      }
    }
  }
  
  private static Drawable a(Context paramContext, boolean paramBoolean)
  {
    int i2;
    int i1;
    if (paramBoolean)
    {
      i2 = DisplayUtil.a(paramContext, 12.0F);
      i1 = DisplayUtil.a(paramContext, 60.0F);
    }
    else
    {
      i2 = DisplayUtil.a(paramContext, 6.0F);
      i1 = DisplayUtil.a(paramContext, 28.0F);
    }
    return new RoundRectColorDrawable(-2565928, i2, i1, i1);
  }
  
  private String a()
  {
    articlesummary.VideoDownloadBarInfo localVideoDownloadBarInfo = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo;
    if ((localVideoDownloadBarInfo != null) && (RIJPBFieldUtils.a(localVideoDownloadBarInfo.bytes_icon_url))) {
      return RIJPBFieldUtils.b(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_url);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, "getDownloadIconUrl(), null:");
    }
    return null;
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoUIManager.5(this, paramInt, paramString1, paramString2));
  }
  
  private void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setVisibility(0);
    if (VideoVolumeControl.getInstance().isMute())
    {
      paramImageView.setImageResource(2130843178);
      paramImageView.setContentDescription(HardCodeUtil.a(2131716157));
      return;
    }
    paramImageView.setImageResource(2130843179);
    paramImageView.setContentDescription(HardCodeUtil.a(2131716162));
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL)
  {
    ReadInJoyDisplayUtils.a(paramKandianUrlImageView, paramURL, this.jdField_a_of_type_AndroidAppActivity, false);
  }
  
  private void a(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if (paramInt == 3)
    {
      if (a()) {
        b(false);
      }
      e();
      return;
    }
    e();
  }
  
  private void a(boolean paramBoolean, VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScreenChange   isFullScreen:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("  enterPlayParam:");
      ((StringBuilder)localObject).append(paramVideoPlayParam1);
      ((StringBuilder)localObject).append("   exitPlayParam:");
      ((StringBuilder)localObject).append(paramVideoPlayParam2);
      QLog.i("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController;
      int i1 = VideoPlayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView, paramVideoPlayParam1.jdField_a_of_type_Int);
      this.jdField_c_of_type_Int = i1;
      ((VideoFullPlayController)localObject).a(paramVideoPlayParam1, i1);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.b();
    }
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, paramBoolean ^ true);
    t();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoUIManager.OnScreenChangeListener localOnScreenChangeListener = (VideoUIManager.OnScreenChangeListener)((Iterator)localObject).next();
        if (localOnScreenChangeListener != null) {
          if (paramBoolean) {
            localOnScreenChangeListener.l();
          } else {
            localOnScreenChangeListener.a(paramVideoPlayParam1, paramVideoPlayParam2);
          }
        }
      }
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 != 0)
    {
      if (paramInt2 == 0) {
        return false;
      }
      bool1 = bool2;
      if (paramInt1 <= paramInt2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.videoVideoUIManager", 2, "isProtraitVideo return false for videoPlayParam is null.");
      }
      return false;
    }
    return a(paramVideoPlayParam.jdField_c_of_type_Int, paramVideoPlayParam.jdField_d_of_type_Int);
  }
  
  private String b()
  {
    articlesummary.VideoDownloadBarInfo localVideoDownloadBarInfo = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo;
    if ((localVideoDownloadBarInfo != null) && (RIJPBFieldUtils.a(localVideoDownloadBarInfo.bytes_icon_text))) {
      return RIJPBFieldUtils.b(this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.bytes_icon_text);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, "getDownloadIconText(), null:");
    }
    return null;
  }
  
  private void b(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(103, 1200L);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.getChildAt(1) != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.getChildAt(1).getTag() instanceof VideoFeedsViewHolder)))
    {
      paramObject = (VideoFeedsViewHolder)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.getChildAt(1).getTag();
      if ((paramObject != null) && (paramObject.jdField_g_of_type_AndroidWidgetTextView != null) && (paramObject.jdField_a_of_type_Int == 0))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
        paramObject.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.videoVideoUIManager", 2, "隐藏大王卡引导Textview");
        }
      }
    }
    ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).playPrePatchAd(paramVideoPlayParam, this, false, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsOnPatchPlayListener);
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841851));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841852));
  }
  
  private void d(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void d(View paramView)
  {
    if (a()) {
      b(false);
    } else {
      i();
    }
    ThreadManager.executeOnSubThread(new VideoUIManager.8(this));
  }
  
  private void d(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
    if (paramInt == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.a().setBackgroundColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165327));
      E();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
      if ((NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidAppActivity)) && (!this.jdField_d_of_type_Boolean))
      {
        y();
        this.jdField_d_of_type_Boolean = true;
      }
      a(this.jdField_f_of_type_AndroidWidgetImageView);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Boolean)
      {
        paramVideoPlayParam = this.jdField_f_of_type_AndroidWidgetImageView;
        if (paramVideoPlayParam != null) {
          paramVideoPlayParam.setVisibility(8);
        }
      }
      K();
      Q();
      R();
      return;
    }
    if (paramInt == 4)
    {
      E();
      return;
    }
    if (paramInt == 5)
    {
      if ((e()) && (c()))
      {
        e(2);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
        return;
      }
      if (d())
      {
        A();
        if (NetworkUtil.isMobileNetWork(this.jdField_a_of_type_AndroidAppActivity)) {
          y();
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (!g()) {
      return;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
    if (paramBoolean)
    {
      localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 91.0F);
      localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 28.0F);
      localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
      localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 16.0F);
    }
    else
    {
      localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 78.0F);
      localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 24.0F);
      localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F);
      localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 8.0F);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams);
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedbackMsgLayoutHelper.a();
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() == 0) {
      VideoFeedsHelper.a(this.jdField_d_of_type_AndroidWidgetTextView, 8, 300);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843371));
        this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(3));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843372));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(2));
      if (!e()) {
        VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843373));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      if (!e()) {
        VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetImageView, 0, 300);
      }
    }
  }
  
  private void e(View paramView)
  {
    int i2 = ((Integer)paramView.getTag()).intValue();
    int i1 = 0;
    if (i2 != 1)
    {
      if (i2 == 2) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.e(true);
      }
    }
    else
    {
      if (!VideoAutoPlayController.getInstance().canAutoPlayVideo()) {
        VideoVolumeControl.getInstance().setMute(false, "noAutoPlayClickVideoInReadInjoy", 1);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.f(true);
    }
    if (2 == i2) {
      i1 = 1;
    }
    ThreadManager.executeOnSubThread(new VideoUIManager.9(this, i1));
  }
  
  private void e(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      A();
      e(3);
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    }
    else if (paramInt == 3)
    {
      e(3);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView.getVisibility() == 0;
  }
  
  private void f(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetSeekBar.getVisibility() != 0) {
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetSeekBar.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(104);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(104, 1500L);
  }
  
  private void f(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if (e()) {
      e(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Boolean) {
      e(1);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
  }
  
  private boolean f()
  {
    int i1 = this.jdField_k_of_type_Int;
    boolean bool3 = false;
    boolean bool2 = false;
    View localView;
    boolean bool1;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return false;
      }
      localView = this.jdField_c_of_type_AndroidViewView;
      bool1 = bool3;
      if (localView != null)
      {
        bool1 = bool2;
        if (localView.getVisibility() == 0) {
          bool1 = true;
        }
        return bool1;
      }
    }
    else
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      bool1 = bool3;
      if (localView != null)
      {
        bool1 = bool3;
        if (localView.getVisibility() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void g(int paramInt)
  {
    if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() != 8) {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (this.jdField_e_of_type_AndroidWidgetImageView.getVisibility() != 0)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130843322);
    }
    if (paramInt == 0) {
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(false);
    } else {
      this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(true);
    }
    if (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 8) {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() != 8) {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(105);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(105, 1500L);
  }
  
  private void g(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(102);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(103);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.removeAllViews();
    if ((paramObject instanceof int[]))
    {
      paramVideoPlayParam = (int[])paramObject;
      a(1, VideoPlayUtils.a(paramVideoPlayParam[0], paramVideoPlayParam[1]), HardCodeUtil.a(2131716161));
    }
  }
  
  private boolean g()
  {
    URLImageView localURLImageView = this.jdField_a_of_type_ComTencentImageURLImageView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localURLImageView != null)
    {
      bool1 = bool2;
      if (localURLImageView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void h(int paramInt)
  {
    if (f()) {
      return;
    }
    if (this.jdField_g_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.readinjoy.videoVideoUIManager", 2, "showDownloadBar(): mDownloadBarClicked, just jump.");
      }
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        O();
      }
    }
    else {
      M();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if ((localObject != null) && (((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
    {
      int i1 = this.jdField_k_of_type_Int;
      if (i1 == 1) {
        localObject = "0X8009BC4";
      }
      for (;;)
      {
        break;
        if (i1 == 2) {
          localObject = "0X8009BC6";
        } else {
          localObject = "";
        }
      }
      VideoR5.Builder localBuilder = new VideoR5.Builder("", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.k, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
      localBuilder.a((int)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Long);
      articlesummary.VideoDownloadBarInfo localVideoDownloadBarInfo = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo;
      if ((localVideoDownloadBarInfo != null) && (localVideoDownloadBarInfo.msg_url_jump_info.has()) && (this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get() != null)) {
        localBuilder.a(RIJPBFieldUtils.b(((articlesummary.UrlJumpInfo)this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo.msg_url_jump_info.get()).bytes_common_data));
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", (String)localObject, (String)localObject, 0, 0, "3", "", "", localBuilder.a().a(), false);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showDownloadBar(), barStyle:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void h(VideoPlayParam paramVideoPlayParam, int paramInt, Object paramObject)
  {
    if ((!a(paramVideoPlayParam)) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a(paramVideoPlayParam);
      return;
    }
    if (this.jdField_k_of_type_Int == 2)
    {
      VideoAutoPlayController.sPauseScrollToNextVideo = true;
      h(2);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    else
    {
      b(false);
      e();
    }
    if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.patchStatus.a.get() == 1) {
      return;
    }
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.getChildAt(1) != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.getChildAt(1).getTag() instanceof VideoFeedsViewHolder))) {
      bool = true;
    } else {
      bool = false;
    }
    ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).playPostPatchAd(paramVideoPlayParam, this, bool, false, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsApiCountDownCallback, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsOnPatchPlayListener);
  }
  
  private void i(int paramInt)
  {
    View localView;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      localView = this.jdField_c_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    else
    {
      localView = this.jdField_b_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  private void o()
  {
    VideoAutoPlayController.sPauseScrollToNextVideo = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$VideoDownloadBarInfo = null;
    this.jdField_k_of_type_Int = 0;
  }
  
  private void p()
  {
    if (this.jdField_e_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup = ((VideoViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131380660));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370470));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367624));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131378837));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131378784));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131378866);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365996));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368461));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372829));
    this.o = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372223));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372165));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372166));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131369688));
    this.jdField_b_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372222));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370709));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367413));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367410));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367412));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373157));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368873));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131365998));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367411));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(this.jdField_a_of_type_AndroidWidgetSeekBar$OnSeekBarChangeListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setContext(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setOnCustomClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setSeekBar(this.jdField_a_of_type_AndroidWidgetSeekBar);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setVideoBrightnessController(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131380805));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131380804));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131380802));
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView = ((ReadInJoyPatchAdView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131372360));
    q();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar = ((ReadInJoyVideoAdHighLightBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131368180));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide = ((ReadInJoyAdVideoGuide)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131362061));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131362166));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131362147));
    this.m = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131362148));
    this.n = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131362146));
    this.jdField_b_of_type_ComTencentImageURLImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131362085));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleNativeView = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).addFeedsBubbleView(this.jdField_a_of_type_AndroidAppActivity, this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    UIUtils.a(this.jdField_f_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
    UIUtils.a(this.jdField_d_of_type_AndroidWidgetImageView, 20, 20, 20, 20);
    VideoVolumeControl.getInstance().restoreFeedsVideoView(this.jdField_f_of_type_AndroidWidgetImageView);
    VideoVolumeControl.getInstance().restoreFeedsVideoView(this.jdField_d_of_type_AndroidWidgetImageView);
    this.jdField_e_of_type_Boolean = true;
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsOnPatchPlayListener = new VideoUIManager.4(this);
    ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).initPatchAdViewListener(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController, this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsApiCountDownCallback, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsOnPatchPlayListener);
  }
  
  private void r()
  {
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if (localVideoPlayParam == null) {
      return;
    }
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if ((localFrameLayout instanceof RoundAngleFrameLayout)) {
      ((RoundAngleFrameLayout)localFrameLayout).setRadius(localVideoPlayParam.o, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.p, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.q, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.r);
    }
  }
  
  private void s()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if ((localFrameLayout instanceof RoundAngleFrameLayout)) {
      ((RoundAngleFrameLayout)localFrameLayout).setRadius(0, 0, 0, 0);
    }
  }
  
  private void t()
  {
    if (a())
    {
      s();
      return;
    }
    r();
  }
  
  private void u()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoVideoUIManager", 2, "innerConfigVideoUI() mPlayingVideoParam == null ERROR");
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTitle);
    this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTitle);
    this.jdField_h_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131167394));
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoPlayCount == 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoFeedsHelper.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoPlayCount));
      localStringBuilder.append(HardCodeUtil.a(2131716156));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    this.jdField_g_of_type_AndroidWidgetTextView.setText(ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Int, true));
    VideoHandler.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if ((localObject != null) && (((VideoPlayParam)localObject).jdField_b_of_type_Boolean))
    {
      VideoHandler.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
      localObject = MultiVideoHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false).toString());
    }
    try
    {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, new URL((String)localObject));
    }
    catch (Exception localException)
    {
      label302:
      break label302;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, "coverImage URL MalformedURLException");
      break label340;
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
    }
    label340:
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mXGFileSize <= 0L)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131716155));
    }
    else
    {
      localObject = this.jdField_d_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mXGFileSize));
      localStringBuilder.append(HardCodeUtil.a(2131716159));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Long);
    if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidAppActivity))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843373));
      this.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(1));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843291);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      this.jdField_d_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if (CUKingCardUtils.a() == 1) {
        this.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131716154));
      }
    }
    f();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Int);
    D();
    d(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.n);
    t();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.patchStatus.a.get() != 1) {
      ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).hidePathAd(this);
    }
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView;
    if ((localObject != null) && (((ReadInJoyPatchAdView)localObject).a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.a())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView.d();
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).updateLightBarText(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar);
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).fillVideoBeforeEndGuide(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).logAdConfig(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
  }
  
  private void v()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup;
  }
  
  private void w()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
    B();
    l();
    this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.a(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setIsInFullScreen(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.c(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
    d(true);
  }
  
  private void x()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a();
    if (localObject != null)
    {
      localObject = ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if (localObject != null)
      {
        String str1 = new VideoR5.Builder(null, ((AbsBaseArticleInfo)localObject).getSubscribeUin(), ((AbsBaseArticleInfo)localObject).mVideoVid, ((AbsBaseArticleInfo)localObject).getInnerUniqueID(), this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.b(), ((AbsBaseArticleInfo)localObject).getVideoDuration() * 1000L).a((int)((AbsBaseArticleInfo)localObject).mChannelID).a().a();
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        String str2 = ((AbsBaseArticleInfo)localObject).getSubscribeUin();
        if (!TextUtils.isEmpty(((AbsBaseArticleInfo)localObject).getInnerUniqueID())) {
          localObject = ((AbsBaseArticleInfo)localObject).getInnerUniqueID();
        } else {
          localObject = "0";
        }
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", (String)localObject, str1, false);
      }
    }
  }
  
  private void y()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      if (((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_AndroidViewView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.readinjoy.videoVideoUIManager", 2, "showXGToast failed for mPlayingVideoParam.feedsVideoCover is null");
        }
        return;
      }
      if (CUKingCardUtils.a() == 1)
      {
        localObject = HardCodeUtil.a(2131716158);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mXGFileSize > 0L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131716153));
        ((StringBuilder)localObject).append(VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mXGFileSize));
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = HardCodeUtil.a(2131716152);
      }
      int[] arrayOfInt = new int[2];
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
      int i1 = arrayOfInt[1] - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
      i1 = (i1 + (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_AndroidViewView.getHeight() + i1) - DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 40.0F)) / 2;
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, i1);
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams(localLayoutParams);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.getVideoCoverUrlWithSmartCut(false));
  }
  
  public ReadInJoyAdBubbleNativeView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdBubbleNativeView;
  }
  
  public ReadInJoyAdVideoGuide a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
  }
  
  public ReadInJoyPatchAdView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView;
  }
  
  public ReadInJoyVideoAdHighLightBar a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar;
  }
  
  public VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a();
    if (this.jdField_g_of_type_Boolean) {
      i(1);
    }
    if (a() != null)
    {
      Object localObject = a().jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      if ((((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).resumeFromPrePatchHomeBack((AbsBaseArticleInfo)localObject)) || (((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).resumeFromPosPatchHomeBack((AbsBaseArticleInfo)localObject)))
      {
        ReadInJoyPatchAdView localReadInJoyPatchAdView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView;
        if (localReadInJoyPatchAdView != null) {
          localReadInJoyPatchAdView.b();
        }
      }
      if (((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).resumeFromPrePatchClickBack((AbsBaseArticleInfo)localObject)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(a());
      }
      if (((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).resumeFromPosPatchClickBack((AbsBaseArticleInfo)localObject))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsApiCountDownCallback;
        if (localObject != null)
        {
          ((CountDownCallback)localObject).a(a());
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a();
        }
      }
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).updateLightBarText(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyVideoAdHighLightBar);
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).updateGuideBtnText(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOrientationChanged=> orientation=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 8)
        {
          if (paramInt != 9) {
            return;
          }
          b(false);
          return;
        }
        b(8);
        return;
      }
      b(false);
      return;
    }
    b(0);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
      return;
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a();
    Object localObject;
    if ((i1 != 0) && (i1 != 1) && (i1 != 7) && (i1 != 2) && (i1 != 4))
    {
      if (this.jdField_b_of_type_Boolean) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      a(true, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(), null);
      c(true);
      this.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.b();
      if ((paramBoolean) && (a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector.a(false)) {
          this.jdField_c_of_type_Boolean = true;
        }
      }
      else if (paramInt == 0) {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(8);
      }
      localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
      ((Window)localObject).setFlags(1024, 1024);
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() instanceof ViewGroup))
      {
        this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent());
        this.jdField_j_of_type_Int = this.jdField_a_of_type_AndroidViewViewGroup.indexOfChild(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.a();
        this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.b();
        ((Window)localObject).addContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new ViewGroup.LayoutParams(-1, -1));
      }
      this.jdField_g_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
      this.jdField_h_of_type_Int = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("FullScreen => mOriginalWidth=");
        ((StringBuilder)localObject).append(this.jdField_g_of_type_Int);
        ((StringBuilder)localObject).append(", mOriginalHeight=");
        ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
        ((StringBuilder)localObject).append(", playState=");
        ((StringBuilder)localObject).append(VideoPlayUtils.a(i1));
        ((StringBuilder)localObject).append("，userClickEnter:");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
      }
      w();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setTranslationY(0.0F);
      x();
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("innerEnterFullScreen => playState=");
      ((StringBuilder)localObject).append(VideoPlayUtils.a(i1));
      ((StringBuilder)localObject).append(", illegal state just ignore fullscreen.");
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(View paramView)
  {
    if (c())
    {
      l();
      return;
    }
    k();
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      if (c())
      {
        l();
        if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.d()) {
          this.jdField_f_of_type_Boolean = true;
        }
      }
    }
    else if (this.jdField_f_of_type_Boolean)
    {
      k();
      this.jdField_f_of_type_Boolean = false;
    }
  }
  
  public void a(View paramView, int paramInt1, int paramInt2) {}
  
  public void a(VideoPlayerWrapper paramVideoPlayerWrapper, VideoPlayParam paramVideoPlayParam) {}
  
  public void a(CountDownCallback paramCountDownCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsApiCountDownCallback = paramCountDownCallback;
  }
  
  public void a(VideoUIManager.OnScreenChangeListener paramOnScreenChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramOnScreenChangeListener)) {
      this.jdField_a_of_type_JavaUtilList.add(paramOnScreenChangeListener);
    }
  }
  
  public void a(OnUIChangeListener paramOnUIChangeListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramOnUIChangeListener);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, 8, 300);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, IVideoPlayerWrapper paramIVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject)
  {
    paramIVideoPlayerWrapper = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if ((paramIVideoPlayerWrapper != null) && (paramVideoPlayParam != null) && (paramIVideoPlayerWrapper == paramVideoPlayParam))
    {
      if (paramInt2 == 0)
      {
        a(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 1)
      {
        b(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 2)
      {
        c(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 3)
      {
        d(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 4)
      {
        e(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 5)
      {
        f(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 6)
      {
        g(paramVideoPlayParam, paramInt1, paramObject);
        return;
      }
      if (paramInt2 == 7) {
        h(paramVideoPlayParam, paramInt1, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.readinjoy.videoVideoUIManager", 2, "onStateChange(): mPlayingVideoParam and videoPlayParam not equal, just return;");
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean) {}
  
  public void a(VideoFullPlayController.OnFullPlayListener paramOnFullPlayListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a(paramOnFullPlayListener);
  }
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout == null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout = ((VideoFeedsGestureLayout)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367624));
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setChannelID(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.d());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setVideoPlayManager(paramVideoPlayManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a(paramVideoPlayManager);
  }
  
  public void a(AbsListView paramAbsListView)
  {
    if (a()) {
      return;
    }
    int i3 = ((ReadInJoyBaseListView)paramAbsListView).getHeaderViewsCount();
    int i2 = paramAbsListView.getFirstVisiblePosition() - i3;
    int i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    i2 = paramAbsListView.getLastVisiblePosition() - i3;
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if ((paramAbsListView != null) && (paramAbsListView.a() != null))
    {
      i3 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a().jdField_a_of_type_Int;
      if ((i3 >= 0) && ((i3 < i1) || (i3 > i2)))
      {
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("triggerVideoRecycleCheck => stop video，firstVisblePosi:");
          paramAbsListView.append(i1);
          paramAbsListView.append(",lastVisiblePosi:");
          paramAbsListView.append(i2);
          paramAbsListView.append(",playingPosi:");
          paramAbsListView.append(i3);
          QLog.d("Q.readinjoy.videoVideoUIManager", 2, paramAbsListView.toString());
        }
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("triggerVideoRecycleCheck => stop video，playParam:");
          paramAbsListView.append(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a());
          QLog.d("Q.readinjoy.videoVideoUIManager", 2, paramAbsListView.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(ReportConstants.VideoEndType.SLIDE_LEAVE);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(10);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector;
    if (localObject != null) {
      ((OrientationDetector)localObject).a(paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
      if ((localObject != null) && (((VideoPlayParam)localObject).jdField_b_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector.a(false);
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
      return false;
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.d();
  }
  
  public void b(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void b(View paramView) {}
  
  public void b(OnUIChangeListener paramOnUIChangeListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramOnUIChangeListener);
  }
  
  public void b(VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = paramVideoPlayParam;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("playVideo(): videoPlayParam=");
      localStringBuilder.append(paramVideoPlayParam);
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, localStringBuilder.toString());
    }
    paramVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_b_of_type_Boolean))
    {
      a(false);
      this.jdField_c_of_type_Boolean = false;
    }
    p();
    u();
    v();
    g();
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
      return;
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.c();
    c(false);
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    ((Window)localObject).clearFlags(1024);
    ((Window)localObject).addFlags(this.jdField_a_of_type_Int);
    ((Window)localObject).getDecorView().setSystemUiVisibility(this.jdField_b_of_type_Int);
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent() instanceof ViewGroup))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.a();
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoView.b();
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_j_of_type_Int, new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    l();
    localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = this.jdField_g_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).height = this.jdField_h_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.a(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.setIsInFullScreen(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGestureLayout.a();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector.a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.c(this.jdField_i_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a() != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a() instanceof VideoPlayParam))) {
      a(false, (VideoPlayParam)this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
    }
    d(false);
    if (paramBoolean) {
      H();
    }
    f();
    g();
  }
  
  public boolean b()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    boolean bool = false;
    if (localRelativeLayout == null) {
      return false;
    }
    if (localRelativeLayout.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public void c()
  {
    ReadInJoyPatchAdView localReadInJoyPatchAdView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView;
    if (localReadInJoyPatchAdView != null) {
      localReadInJoyPatchAdView.c();
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetSeekBar != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam == null) {
        return;
      }
      VideoVolumeControl.getInstance().adjustMediaVolume(paramInt);
      paramInt = (int)(VideoVolumeControl.getInstance().getMediaVolumeProgress() * this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Int);
      if (c())
      {
        g(paramInt);
        return;
      }
      f(paramInt);
    }
  }
  
  public void c(View paramView)
  {
    if (paramView.getTag() != null)
    {
      if (!(paramView.getTag() instanceof PlayableItem)) {
        return;
      }
      int i1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a();
      Object localObject1 = (PlayableItem)paramView.getTag();
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleItemClick():  playState=");
        ((StringBuilder)localObject2).append(VideoPlayUtils.a(i1));
        ((StringBuilder)localObject2).append(", view id: ");
        ((StringBuilder)localObject2).append(VideoFeedsHelper.a(paramView));
        QLog.d("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject2).toString());
      }
      if ((i1 == 7) && (f()))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.readinjoy.videoVideoUIManager", 2, "handleItemClick():  complete && isDownloadBarShowing, just return.");
        }
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a() == null)
      {
        if (!VideoAutoPlayController.getInstance().canAutoPlayVideo()) {
          VideoVolumeControl.getInstance().setMute(false, "noAutoPlayClickVideoInReadInjoy", 1);
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(((PlayableItem)localObject1).a());
        paramView = ((PlayableItem)localObject1).a().jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        if ((paramView != null) && (paramView.mChannelID == 56L) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramView)))
        {
          localObject2 = (AdvertisementInfo)paramView;
          ((AdvertisementInfo)localObject2).adbt = ((int)((PlayableItem)localObject1).a().jdField_d_of_type_Long);
          ((AdvertisementInfo)localObject2).adpa = 1;
          ((AdvertisementInfo)localObject2).adpb = 2;
          ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(4).a((AdvertisementInfo)localObject2).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(((AdvertisementInfo)localObject2).adbt, 0, ((AdvertisementInfo)localObject2).getAdbf(), 0, 1, 2, paramView.mVideoDuration * 1000, 9, 0, ((AdvertisementInfo)localObject2).videoReplayCount, ReportConstants.VideoEndType.CLICK_PAUSE, ((AdvertisementInfo)localObject2).isClickReplay, false)));
          ((AdvertisementInfo)localObject2).isClickReplay = false;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.c() == ((PlayableItem)localObject1).a().jdField_c_of_type_Long)
        {
          if (i1 == 1) {
            return;
          }
          if ((i1 == 5) && (d()))
          {
            if (QLog.isColorLevel()) {
              QLog.w("Q.readinjoy.videoVideoUIManager", 2, "handleItemClick():  paused && isErrorLayoutShowing, just return.");
            }
            return;
          }
          if (c())
          {
            l();
            return;
          }
          k();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoVideoUIManager", 2, "handleItemClick():  点击非当前播放的视频feeds，播放点击的视频");
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(2);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(((PlayableItem)localObject1).a());
        paramView = ((PlayableItem)localObject1).a().jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
        if ((paramView != null) && (paramView.mChannelID == 56L) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo(paramView)))
        {
          localObject1 = (IRIJAdService)QRoute.api(IRIJAdService.class);
          localObject2 = new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(6).b(4);
          AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)paramView;
          ((IRIJAdService)localObject1).report(((AdReportData)localObject2).a(localAdvertisementInfo).a(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getVideoInfoObject(0, 0, 1, 0, 1, 2, paramView.mVideoDuration * 1000, 9, 0, localAdvertisementInfo.videoReplayCount, ReportConstants.VideoEndType.CLICK_PAUSE, localAdvertisementInfo.isClickReplay, false)));
          localAdvertisementInfo.isClickReplay = false;
          localAdvertisementInfo.adbt = 0;
          localAdvertisementInfo.adpa = 1;
          localAdvertisementInfo.adpb = 2;
        }
        if (!VideoAutoPlayController.getInstance().canAutoPlayVideo()) {
          VideoVolumeControl.getInstance().setMute(false, "noAutoPlayClickVideoInReadInjoy", 1);
        }
      }
    }
  }
  
  public void c(OnUIChangeListener paramOnUIChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoApiOnUIChangeListener = paramOnUIChangeListener;
  }
  
  public boolean c()
  {
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    boolean bool = false;
    if (localRelativeLayout == null) {
      return false;
    }
    if (localRelativeLayout.getVisibility() == 0) {
      bool = true;
    }
    return bool;
  }
  
  public void d()
  {
    ReadInJoyPatchAdView localReadInJoyPatchAdView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView;
    if (localReadInJoyPatchAdView != null) {
      localReadInJoyPatchAdView.c();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    o();
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, "updateVideoViewSize");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam == null) {
      return;
    }
    float f1 = DeviceInfoUtil.b(this.jdField_a_of_type_AndroidAppActivity);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.l > 0) {
        f1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.l;
      }
    }
    else {
      f1 = RIJComponentConfigImage.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
    }
    float f2 = ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_d_of_type_Int) * f1;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a())
    {
      this.jdField_g_of_type_Int = ((int)f1);
      this.jdField_h_of_type_Int = ((int)f2);
      w();
      return;
    }
    Object localObject;
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams() instanceof FrameLayout.LayoutParams))
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = ((int)f1);
      ((FrameLayout.LayoutParams)localObject).height = ((int)f2);
      ((FrameLayout.LayoutParams)localObject).gravity = 1;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    else if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = ((int)f1);
      ((RelativeLayout.LayoutParams)localObject).height = ((int)f2);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.a(true);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoViewGroup.setCustomSize(1.0F, ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_d_of_type_Int));
  }
  
  @TargetApi(11)
  public void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 0) {
      return;
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if (localVideoPlayParam != null)
    {
      if (localVideoPlayParam.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      this.jdField_f_of_type_Int = this.jdField_a_of_type_ArrayOfInt[1];
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
      if ((this.jdField_a_of_type_AndroidWidgetFrameLayout.getX() != this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_AndroidViewView.getX()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_AndroidViewView.getX() != 0.0F)) {
        ViewHelper.g(this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_ArrayOfInt[0]);
      }
      float f1 = this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_f_of_type_Int;
      if (f1 == this.jdField_a_of_type_AndroidWidgetFrameLayout.getTranslationY()) {
        return;
      }
      ViewHelper.f(this.jdField_a_of_type_AndroidWidgetFrameLayout, f1);
    }
  }
  
  public void h()
  {
    FrameLayout localFrameLayout = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (localFrameLayout != null) {
      localFrameLayout.setVisibility(8);
    }
  }
  
  public void i()
  {
    a(0, true);
  }
  
  public void j()
  {
    b(true);
  }
  
  public void k()
  {
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null)
    {
      if (localRelativeLayout.getVisibility() == 0) {
        return;
      }
      if (a())
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
          VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0, 300);
        }
        this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
        a(this.jdField_d_of_type_AndroidWidgetImageView);
      }
      int i1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a();
      if (i1 == 5) {
        e(1);
      } else if (i1 == 3) {
        e(2);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedbackMsgLayoutHelper.a();
      VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 0, 300);
      if (!this.jdField_a_of_type_Boolean)
      {
        UIUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, 10, 10, 10, 10);
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      P();
      if (i1 == 5)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      }
      else if (i1 == 3)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, 3000L);
      }
      ThreadManager.executeOnSubThread(new VideoUIManager.6(this));
    }
  }
  
  public void l()
  {
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null)
    {
      if (localRelativeLayout.getVisibility() != 0) {
        return;
      }
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8, 300);
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      VideoFeedsHelper.a(this.jdField_a_of_type_AndroidWidgetImageView, 8, 300);
      VideoFeedsHelper.a(this.jdField_b_of_type_AndroidWidgetRelativeLayout, 8, 300);
      if ((!a()) && (7 != this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a())) {
        this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(0);
      } else {
        this.jdField_b_of_type_AndroidWidgetSeekBar.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(true);
    }
  }
  
  public void m()
  {
    String str = HardCodeUtil.a(2131716163);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoFeedsHelper.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mXGFileSize));
    localStringBuilder.append(HardCodeUtil.a(2131716160));
    a(0, str, localStringBuilder.toString());
  }
  
  public void n()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController;
    if (localObject != null)
    {
      ((VideoFullPlayController)localObject).e();
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = null;
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector;
    if (localObject != null)
    {
      ((OrientationDetector)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector = null;
    }
    this.jdField_c_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoBrightnessController;
    if (localObject != null) {
      ((VideoBrightnessController)localObject).b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsOnPatchPlayListener != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdUtilsOnPatchPlayListener = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick(): current playState=");
      ((StringBuilder)localObject).append(VideoPlayUtils.a(i1));
      ((StringBuilder)localObject).append(", view id: ");
      ((StringBuilder)localObject).append(VideoFeedsHelper.a(paramView));
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramView.getId() == 2131367411)
    {
      d(paramView);
      return;
    }
    if (paramView.getId() == 2131372165)
    {
      e(paramView);
      return;
    }
    if (paramView.getId() == 2131366291)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.f(true);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a() == 6)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
        if (paramView != null)
        {
          PlayFeedbackHelper.b(paramView.a(), 0);
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
        }
      }
    }
    else
    {
      if (paramView.getId() == 2131367410)
      {
        j();
        return;
      }
      if ((paramView.getId() != 2131380804) && (paramView.getId() != 2131380805))
      {
        if (paramView.getId() == 2131376414)
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedbackMsgLayoutHelper.a();
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam);
          paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
          if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
          {
            paramView = new VideoR5.Builder("", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.k, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
            paramView.a((int)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Long);
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BC8", "0X8009BC8", 0, 0, "3", "", "", paramView.a().a(), false);
            paramView = (AdvertisementInfo)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
            paramView.videoReplayCount += 1;
          }
        }
        else if ((paramView.getId() != 2131365851) && (paramView.getId() != 2131365858))
        {
          if (paramView.getId() == 2131380695)
          {
            G();
            return;
          }
          if (paramView.getId() == 2131362166) {
            F();
          }
        }
        else
        {
          N();
        }
      }
      else
      {
        boolean bool = VideoVolumeControl.getInstance().isMute() ^ true;
        VideoVolumeControl.getInstance().setMute(bool, "user click audio btn", 1);
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
        if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
        {
          localObject = new VideoR5.Builder("", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.k, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID);
          ((VideoR5.Builder)localObject).a((int)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.jdField_b_of_type_Long);
          if (bool) {
            paramView = "1";
          } else {
            paramView = "0";
          }
          ((VideoR5.Builder)localObject).a("status", paramView);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009BD6", "0X8009BD6", 0, 0, "3", "", "", ((VideoR5.Builder)localObject).a().a(), false);
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramInt2 + paramInt1 - 1;
    paramInt3 = this.jdField_d_of_type_Int;
    if ((paramInt3 == -1) || (paramInt3 == paramInt1))
    {
      paramInt3 = this.jdField_e_of_type_Int;
      if ((paramInt3 == -1) || (paramInt3 == paramInt2)) {}
    }
    else
    {
      a(paramAbsListView);
    }
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      a(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager
 * JD-Core Version:    0.7.0.1
 */