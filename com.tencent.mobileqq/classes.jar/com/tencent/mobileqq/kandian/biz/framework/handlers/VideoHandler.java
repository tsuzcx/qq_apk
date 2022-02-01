package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADBaseAppDownloadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyAnimUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.feeds.presenter.IReadInJoyPresenter;
import com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyPresenterImpl;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.pts.data.Util;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.biz.share.VideoShareHelper;
import com.tencent.mobileqq.kandian.biz.video.NetInfoHandler;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.RIJVideoOnScrollListener;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoColumnItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoColumnItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsTwoItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsWithColumnViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder.VideoUIHandler;
import com.tencent.mobileqq.kandian.biz.video.viewholder.WeishiGridTwoItemViewHolder;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager;
import com.tencent.mobileqq.kandian.glue.video.VideoResumeManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoPreloadReportData;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ArticlePatchStatus;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoHandler
  extends BaseHandler
  implements Handler.Callback
{
  private static volatile boolean e = false;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  SimpleEventReceiver<ViolaEvent> jdField_a_of_type_ComTencentBizRichframeworkEventbusSimpleEventReceiver = new VideoHandler.11(this);
  private IADBaseAppDownloadManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADBaseAppDownloadManager;
  private VideoShareHelper jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareHelper;
  private NetInfoHandler jdField_a_of_type_ComTencentMobileqqKandianBizVideoNetInfoHandler;
  protected PlayableItem a;
  private VideoAutoPlayController jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController;
  private ViewHolder.VideoUIHandler jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler;
  protected VideoPlayManager a;
  protected VideoPreDownloadMgr a;
  protected VideoRecommendManager a;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  protected boolean a;
  private int b;
  protected boolean b;
  protected boolean c = false;
  protected boolean d = true;
  private boolean f;
  private boolean g = false;
  private boolean h = true;
  
  public VideoHandler()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem = null;
    this.jdField_b_of_type_Int = 0;
  }
  
  private void A()
  {
    boolean bool = a().a().a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((c()) && (!bool) && ((!RIJShowKanDianTabSp.c()) || ((a().a().a() instanceof ReadInJoyNewFeedsActivity))))
    {
      t();
      B();
    }
    if (((!RIJShowKanDianTabSp.c()) || ((a().a().a() instanceof ReadInJoyNewFeedsActivity))) && (a() == 56)) {
      VideoReporter.jdField_a_of_type_Int = VideoReporter.a(a().getIntent().getIntExtra("channel_from", -1));
    }
  }
  
  private void B()
  {
    a().g();
  }
  
  private void C()
  {
    if (a() == 56) {
      ReadInJoyLogicEngine.a().a(56);
    }
  }
  
  private LinearLayout a()
  {
    if (DailyModeConfigHandler.c(a())) {
      return this.jdField_a_of_type_AndroidWidgetLinearLayout;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public static PlayableItem a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof PlayableItem))) {
      return (PlayableItem)paramView.getTag();
    }
    return null;
  }
  
  private VideoPlayParam a()
  {
    VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localVideoPlayManager != null) {
      return localVideoPlayManager.a();
    }
    return null;
  }
  
  private AbsBaseArticleInfo a(int paramInt)
  {
    return a().a(paramInt);
  }
  
  public static AbsBaseArticleInfo a(VideoHandler paramVideoHandler, View paramView)
  {
    if ((paramVideoHandler != null) && (paramView != null))
    {
      if (!(paramView.getTag() instanceof PlayableItem)) {
        return null;
      }
      paramView = (PlayableItem)paramView.getTag();
      if (paramView != null) {
        return paramVideoHandler.a(paramView.a());
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, VideoPlayParam paramVideoPlayParam)
  {
    if ((paramImageView != null) && (paramVideoPlayParam != null))
    {
      if (paramVideoPlayParam.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      paramContext = paramImageView.getLayoutParams();
      paramVideoPlayParam.jdField_a_of_type_AndroidViewView.getHeight();
      paramContext.height = paramVideoPlayParam.jdField_a_of_type_AndroidViewView.getHeight();
      paramImageView.setLayoutParams(paramContext);
    }
  }
  
  private void a(Intent paramIntent)
  {
    if ((a() == 0) && (!VideoResumeManager.a.a())) {
      return;
    }
    if (paramIntent == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onActivityResult for OPEN_FULLPLAY");
    }
    a().a().a(false);
    long l1 = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", -1L);
    int i = paramIntent.getIntExtra("VIDEO_PLAY_STATUS", -1);
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.d()) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.c()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult video is pause  && isPausedByMannul, just return");
      }
      return;
    }
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a();
    if (localVideoPlayParam == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "onActivityResult getCurrentPlayVideoParam = null, just return");
      }
      return;
    }
    if (paramIntent.getExtras() != null) {
      paramIntent = paramIntent.getExtras().getString("VIDEO_ARTICLE_ID");
    } else {
      paramIntent = null;
    }
    if (!TextUtils.equals(localVideoPlayParam.j, paramIntent))
    {
      paramIntent = b(paramIntent);
      if (paramIntent == null)
      {
        l1 = localVideoPlayParam.d;
      }
      else
      {
        if (paramIntent.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam != null) {
          paramIntent.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam.d = l1;
        }
        bool = true;
        break label214;
      }
    }
    else
    {
      paramIntent = null;
    }
    boolean bool = false;
    label214:
    if (b(i))
    {
      if (bool) {
        a(paramIntent);
      } else if ((l1 >= 0L) && (localVideoPlayParam != null)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a((int)l1, localVideoPlayParam);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.f(true);
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onActivityResult continue play, playResumeVideo:");
        paramIntent.append(bool);
        paramIntent.append(",startPosition:");
        paramIntent.append(l1);
        paramIntent.append(",curPlayParam:");
        paramIntent.append(localVideoPlayParam);
        QLog.d("Q.readinjoy.video", 2, paramIntent.toString());
      }
      VideoVolumeControl.getInstance().setMute(false, "readinoy video continuePlay", 1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "onActivityResult stop play, should not continue play");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem != null)
    {
      long l2 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(4);
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem.a();
      if (l1 > 0L) {
        l2 = l1;
      }
      paramIntent.d = l2;
      if (l1 > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem.a().e = -1;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem = null;
    }
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    View localView1 = null;
    if ((paramView.getTag() instanceof ViewHolder)) {
      localView1 = ((ViewHolder)paramView.getTag()).g;
    }
    View localView2 = localView1;
    if (localView1 == null)
    {
      localView2 = localView1;
      if ((paramView.getTag(2131376138) instanceof ViewHolder)) {
        localView2 = ((ViewHolder)paramView.getTag(2131376138)).g;
      }
    }
    if (localView2 == null) {
      return;
    }
    EventCollector.getInstance().onViewClicked(localView2);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((a() instanceof ReadInJoyChannelActivity))
    {
      if ((this.c) && (paramView != null) && (paramInt > 0) && (paramInt <= 2))
      {
        if ((paramInt == 1) && (this.d))
        {
          this.d = false;
          paramView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
        }
        else if (paramInt == 2)
        {
          if (this.c) {
            this.c = false;
          }
          paramView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
        }
        if (QLog.isColorLevel())
        {
          paramView = new StringBuilder();
          paramView.append("adapter animation start at item position");
          paramView.append(paramInt);
          QLog.d("Q.readinjoy.videoanimation", 2, paramView.toString());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " judge adapter animation show or not：");
      }
    }
  }
  
  private void a(ViewHolder paramViewHolder)
  {
    if (paramViewHolder != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler == null) {
        return;
      }
      if (paramViewHolder.a()) {
        paramViewHolder.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler);
      }
    }
  }
  
  private void b(int paramInt)
  {
    a().setLayerType(2, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayerType(2, null);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetTextView, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new VideoHandler.8(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(a(), View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new VideoHandler.9(this));
    localObjectAnimator2.setDuration(400L);
    this.jdField_a_of_type_ComTencentWidgetListView.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  public static void b(Context paramContext, ImageView paramImageView, VideoPlayParam paramVideoPlayParam)
  {
    if (paramImageView == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    localLayoutParams.width = ((int)RIJComponentConfigImage.a(paramContext, paramVideoPlayParam));
    paramImageView.setLayoutParams(localLayoutParams);
  }
  
  public static void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  private void b(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (paramVideoPlayParam1 != paramVideoPlayParam2)
    {
      if (((paramVideoPlayParam1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo instanceof BaseArticleInfo)) && ((paramVideoPlayParam2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo instanceof BaseArticleInfo))) {
        ReadInJoyLogicEngine.a().a(a(), paramVideoPlayParam1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, paramVideoPlayParam2.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      }
      this.jdField_a_of_type_ComTencentWidgetListView.clearFocus();
      this.jdField_a_of_type_ComTencentWidgetListView.postDelayed(new VideoHandler.4(this, paramVideoPlayParam1, localVideoPlayManager, paramVideoPlayParam2), 100L);
      return;
    }
    if (localVideoPlayManager.a() == 7) {
      a(paramVideoPlayParam1);
    }
  }
  
  private void b(AbsListView paramAbsListView)
  {
    Object localObject1 = a(paramAbsListView);
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("playVideoInArea:");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("Q.readinjoy.video", 4, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      paramAbsListView = ((PlayableItem)localObject1).a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a();
      if (paramAbsListView == this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("error state not play");
          ((StringBuilder)localObject1).append(paramAbsListView.jdField_c_of_type_JavaLangString);
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      if ((localObject2 == null) || (((VideoPlayParam)localObject2).jdField_c_of_type_Long != paramAbsListView.jdField_c_of_type_Long) || (((VideoPlayParam)localObject2).b != a()) || (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.d()) || (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.e()))
      {
        VideoVolumeControl.getInstance().startAudioPlay();
        a((PlayableItem)localObject1);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("checkPlayableArea vid: ");
          ((StringBuilder)localObject1).append(paramAbsListView.jdField_c_of_type_JavaLangString);
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
    else
    {
      p();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a().a(paramAbsListView);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a().h();
      }
    }
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 0) || (paramInt == 4);
  }
  
  private boolean d()
  {
    if (!RIJShowKanDianTabSp.a(b())) {
      return false;
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) {
      return false;
    }
    String str = RIJAppSetting.a(this.jdField_a_of_type_Long);
    if ("2".equals(str)) {
      return false;
    }
    if ("0".equals(str)) {
      return true;
    }
    if ("1".equals(str)) {
      return NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext);
    }
    return false;
  }
  
  private boolean e()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = a();
    VideoPlayParam localVideoPlayParam = a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localVideoPlayParam == null)
    {
      bool1 = bool2;
      if (localAbsBaseArticleInfo != null)
      {
        bool1 = bool2;
        if (a(0) != null)
        {
          bool1 = bool2;
          if (localAbsBaseArticleInfo.mArticleID == a(0).mArticleID) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void u()
  {
    if (a() == 56)
    {
      VideoBehaviorsReporter.a().a(true);
      VideoBehaviorsReporter.a().a(0);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoNetInfoHandler);
    if ((a() instanceof ReadInJoyChannelActivity)) {
      this.c = a().getIntent().getBooleanExtra("is_need_show_animation_adapter", false);
    }
    if ((a() instanceof ReadInJoyChannelActivity)) {
      this.jdField_a_of_type_Boolean = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772111));
    if (!VideoFeedsHelper.c()) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(400L);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.a.add(this);
    ListView localListView = this.jdField_a_of_type_ComTencentWidgetListView;
    if ((localListView instanceof ReadInJoyBaseListView)) {
      ((ReadInJoyBaseListView)localListView).a(new RIJVideoOnScrollListener(this));
    }
  }
  
  private void v()
  {
    if (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)) {
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a();
        long l = ((VideoPlayParam)localObject).jdField_c_of_type_Long;
        localObject = a(((VideoPlayParam)localObject).jdField_a_of_type_Int);
        if ((localObject != null) && (l != ((AbsBaseArticleInfo)localObject).mArticleID))
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(12);
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("fixVideoPlayErrorState stopVideo videoVid:");
            localStringBuilder.append(((AbsBaseArticleInfo)localObject).getVideoVid());
            QLog.e("Q.readinjoy.video", 2, localStringBuilder.toString());
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("fixVideoPlayErrorState stopVideo throwable:");
          localStringBuilder.append(localThrowable.getMessage());
          QLog.e("Q.readinjoy.video", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  private void w()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a().findViewById(2131373734));
    if (DailyModeConfigHandler.c(a()))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a().findViewById(2131373733));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a().findViewById(2131373732));
  }
  
  private void x()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController = VideoAutoPlayController.getInstance();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController.setChannelFrom(this.jdField_a_of_type_Long);
    if (a() == 56)
    {
      VideoReporter.jdField_a_of_type_Int = VideoReporter.a(a().getIntent().getIntExtra("channel_from", -1));
      this.jdField_a_of_type_ComTencentWidgetListView.setContentBackground(new ColorDrawable(-1));
    }
    if (a().a().a() != null)
    {
      a().a(a().a().a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController);
      return;
    }
    m();
  }
  
  private void y()
  {
    boolean bool = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    AbsBaseArticleInfo localAbsBaseArticleInfo = a().a();
    if ((bool) && ((a() instanceof ReadInJoyChannelActivity))) {
      if (this.h)
      {
        int i = RIJBaseItemViewType.a(localAbsBaseArticleInfo);
        if ((i != 6) && (i != 71))
        {
          if (i == 28)
          {
            i = ReadInJoyHelper.e(ReadInJoyUtils.a());
            ReadInJoyAnimUtils.a(a(), localAbsBaseArticleInfo, a(), (ReadInJoyArticleAdapter)a(), a(), 0, i);
            b(i);
          }
        }
        else
        {
          this.jdField_b_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_left", 0);
          this.jdField_a_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_top", 0);
          ReadInJoyAnimUtils.a(a(), localAbsBaseArticleInfo, a(), (ReadInJoyArticleAdapter)a(), a(), this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
          b(this.jdField_a_of_type_Int);
        }
      }
      else
      {
        j();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADBaseAppDownloadManager = ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).createADBaseAppDownloadManager(a());
    a().b(this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADBaseAppDownloadManager);
    ThreadManager.executeOnSubThread(new VideoHandler.7(this));
  }
  
  private void z()
  {
    ThreadManager.executeOnSubThread(new VideoHandler.10(this));
  }
  
  public long a()
  {
    VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localVideoPlayManager != null) {
      return localVideoPlayManager.b();
    }
    return 0L;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = a(paramInt).intValue();
    Object localObject1;
    if ((paramView != null) && ((paramView.getTag() instanceof ViewHolder)))
    {
      localObject2 = (ViewHolder)paramView.getTag();
      ((ViewHolder)localObject2).jdField_a_of_type_Int = paramInt;
      localObject1 = (IReadInJoyPresenter)paramView.getTag(2131380886);
      localObject3 = (ReadInJoyView)paramView.getTag(2131380889);
      paramViewGroup = paramView;
      paramView = (View)localObject3;
    }
    else
    {
      localObject2 = a(paramInt, paramView, paramViewGroup, i);
      paramViewGroup = ((ViewHolder)localObject2).a(paramInt, paramViewGroup);
      ((ViewHolder)localObject2).g = paramViewGroup;
      ((ViewHolder)localObject2).jdField_a_of_type_Int = paramInt;
      paramViewGroup.setTag(localObject2);
      paramViewGroup.setTag(2131369613, a());
      localObject1 = new ReadInJoyPresenterImpl(a(), a().a().a(), a(), a(), a().a(), a().a());
      paramViewGroup.setTag(2131380886, localObject1);
      paramView = new ReadInJoyView(paramViewGroup);
      paramViewGroup.setTag(2131380889, paramView);
    }
    Object localObject3 = a(paramInt);
    ((ViewHolder)localObject2).a(a());
    if (localObject3 == null)
    {
      QLog.w("VideoHandler", 2, "article is null, return");
      return paramView.a();
    }
    long l;
    if (i == 46)
    {
      l = System.currentTimeMillis();
      a().a((VideoFeedsTwoItemViewHolder)localObject2, (AbsBaseArticleInfo)localObject3);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("VideoHandler", String.valueOf(i), "getProteusNormalView.configTwoItemVideo", System.currentTimeMillis() - l);
    }
    else if (i == 4)
    {
      l = System.currentTimeMillis();
      a().a((VideoFeedsViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("VideoHandler", String.valueOf(i), "getProteusNormalView.configVideoItemUI", System.currentTimeMillis() - l);
      if ((a() != null) && (a().a() != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAdvertisementInfo((AbsBaseArticleInfo)localObject3)))
      {
        localObject2 = (AdvertisementInfo)localObject3;
        a().a().a(localObject2, a().a());
      }
    }
    else if (i == 70)
    {
      l = System.currentTimeMillis();
      a().a((WeishiGridTwoItemViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
      ((IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class)).printCost("VideoHandler", String.valueOf(i), "getProteusNormalView.configWeishiGridTwoItemUI", System.currentTimeMillis() - l);
    }
    else if (i == 118)
    {
      a().a((VideoColumnItemViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
    }
    else if (i == 119)
    {
      a().a((VideoFeedsViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
      localObject2 = (VideoFeedsWithColumnViewHolder)localObject2;
      ((VideoFeedsWithColumnViewHolder)localObject2).a(((AbsBaseArticleInfo)localObject3).mVideoColumnInfo);
      ((VideoFeedsWithColumnViewHolder)localObject2).a((AbsBaseArticleInfo)localObject3);
      ((VideoFeedsWithColumnViewHolder)localObject2).f.setTag(localObject2);
      ((VideoFeedsWithColumnViewHolder)localObject2).l.setTag(localObject2);
    }
    else if (i == 6)
    {
      a().a((BigImgVideoItemViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
    }
    else if (i == 128)
    {
      a().a((BigImgVideoColumnItemViewHolder)localObject2, (AbsBaseArticleInfo)localObject3, paramInt);
    }
    Object localObject2 = null;
    if (paramInt < c() - 1) {
      localObject2 = a(paramInt + 1);
    }
    localObject2 = new ReadInJoyModelImpl(a(), (AbsBaseArticleInfo)localObject3, i, a(), b(), paramInt, a(), c(), (AbsBaseArticleInfo)localObject2, a());
    paramViewGroup.setTag(2131380884, localObject2);
    ((IReadInJoyPresenter)localObject1).a(paramView, (IReadInJoyModel)localObject2, i);
    return paramView.a();
  }
  
  public VideoShareHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareHelper;
  }
  
  public PlayableItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem;
  }
  
  public PlayableItem a(AbsListView paramAbsListView)
  {
    boolean bool = a().b();
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject1;
    if (bool)
    {
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController != null)
      {
        if (paramAbsListView.getChildCount() <= 0) {
          return null;
        }
        int i = 0;
        for (;;)
        {
          localObject1 = localObject3;
          if (i >= paramAbsListView.getChildCount()) {
            break;
          }
          localObject2 = paramAbsListView.getChildAt(i);
          if (Util.a((View)localObject2))
          {
            localObject1 = localObject3;
            break;
          }
          if ((((View)localObject2).getTag() instanceof PlayableItem))
          {
            localObject1 = (PlayableItem)((View)localObject2).getTag();
            if (((PlayableItem)localObject1).a((View)localObject2)) {
              break;
            }
          }
          i += 1;
        }
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.w("Q.readinjoy.video", 2, "checkPlayableArea(): no item can auto play...");
            localObject2 = localObject1;
          }
        }
      }
    }
    return localObject2;
  }
  
  public VideoAutoPlayController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController;
  }
  
  public VideoFeedsViewHolder a(String paramString)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
    int i = Math.max(this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount(), j);
    for (;;)
    {
      int k = a().b().size();
      int m = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      VideoFeedsViewHolder localVideoFeedsViewHolder = null;
      if (i >= k + m) {
        break;
      }
      k = i - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      AbsBaseArticleInfo localAbsBaseArticleInfo = a(k);
      if ((4 == a(k).intValue()) && (localAbsBaseArticleInfo != null) && (TextUtils.equals(localAbsBaseArticleInfo.getInnerUniqueID(), paramString)))
      {
        i -= j;
        if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())) {
          paramString = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i);
        } else if ((k >= 0) && (k < a().b().size())) {
          paramString = a(k, null, this.jdField_a_of_type_ComTencentWidgetListView);
        } else {
          paramString = null;
        }
        if (paramString != null) {
          localVideoFeedsViewHolder = (VideoFeedsViewHolder)paramString.getTag();
        }
        return localVideoFeedsViewHolder;
      }
      i += 1;
    }
    return null;
  }
  
  public ViewHolder a(int paramInt1, View paramView, ViewGroup paramViewGroup, int paramInt2)
  {
    paramView = a();
    if (paramInt2 != 4)
    {
      if (paramInt2 != 6)
      {
        if (paramInt2 != 46)
        {
          if (paramInt2 != 70)
          {
            if (paramInt2 != 128)
            {
              if (paramInt2 != 118)
              {
                if (paramInt2 != 119) {
                  paramView = new VideoFeedsViewHolder(paramView, this);
                } else {
                  paramView = new VideoFeedsWithColumnViewHolder(paramView, this);
                }
              }
              else {
                paramView = new VideoColumnItemViewHolder(paramView, this);
              }
            }
            else {
              paramView = new BigImgVideoColumnItemViewHolder(paramView, this);
            }
          }
          else {
            paramView = new WeishiGridTwoItemViewHolder(paramView, this);
          }
        }
        else {
          paramView = new VideoFeedsTwoItemViewHolder(paramView, this);
        }
      }
      else {
        paramView = new BigImgVideoItemViewHolder(paramView, this);
      }
    }
    else {
      paramView = new VideoFeedsViewHolder(paramView, this);
    }
    a(paramView);
    return paramView;
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  }
  
  public VideoPreDownloadMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
  }
  
  public VideoRecommendManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager;
  }
  
  public AbsBaseArticleInfo a()
  {
    return a().a();
  }
  
  public Boolean a()
  {
    if ((a() != null) && (a().a() != null) && (a().a().a()))
    {
      a().a().j();
      return Boolean.valueOf(true);
    }
    return super.a();
  }
  
  public void a() {}
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager == null) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "onActivityResult for REFRESH_EVENT_CHECK_PLAYAREA");
        }
        v();
        b(this.jdField_a_of_type_ComTencentWidgetListView, 50);
        QLog.d("gifvideo.VideoHandler", 2, "check shortcontent play");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "do nothing!");
      }
    }
    else
    {
      a(paramIntent);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    VideoPreDownloadMgr localVideoPreDownloadMgr;
    if (a() == 40677)
    {
      if (paramInt == 0)
      {
        localVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
        if (localVideoPreDownloadMgr != null) {
          localVideoPreDownloadMgr.a(paramInt, paramBoolean);
        }
      }
    }
    else
    {
      localVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
      if (localVideoPreDownloadMgr != null) {
        localVideoPreDownloadMgr.a(paramInt, paramBoolean);
      }
    }
  }
  
  public void a(View paramView1, View paramView2, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    super.a(paramView1, paramView2, paramAbsBaseArticleInfo, paramInt);
    a(paramView2, paramInt);
  }
  
  public void a(View paramView, ListView paramListView)
  {
    w();
    x();
    y();
    z();
    SimpleEventBus.getInstance().registerReceiver(this.jdField_a_of_type_ComTencentBizRichframeworkEventbusSimpleEventReceiver);
  }
  
  public void a(View paramView, ListView paramListView, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoNetInfoHandler = new NetInfoHandler(this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler = new ViewHolder.VideoUIHandler();
    this.f = ReadInJoyHelper.d();
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_AndroidContentContext = a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareHelper = new VideoShareHelper(a());
    u();
    this.jdField_a_of_type_Long = paramLong;
    this.h = VideoFeedsHelper.c();
  }
  
  public void a(PlayableItem paramPlayableItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(2);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem = paramPlayableItem;
    a().a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(paramPlayableItem.a());
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.postDelayed(new VideoHandler.5(this, paramVideoPlayParam), 1000L);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem != null) {
      return;
    }
    Object localObject = a(paramVideoPlayParam.j);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem = ((PlayableItem)localObject);
      paramVideoPlayParam.jdField_a_of_type_AndroidViewView = ((VideoFeedsViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fixNowPlayHolder failed videoPlayParam:");
      ((StringBuilder)localObject).append(paramVideoPlayParam);
      ((StringBuilder)localObject).append("    callSource:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("VideoHandler", 2, ((StringBuilder)localObject).toString());
    }
    paramVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (paramVideoPlayParam != null)
    {
      if (paramVideoPlayParam.a() == null) {
        return;
      }
      paramVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a();
      if (QLog.isColorLevel()) {
        QLog.i("VideoHandler", 2, "notifyVideoPositionChanged:");
      }
      paramVideoPlayParam.g();
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = a();
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).a(paramVideoPlayParam1, paramVideoPlayParam2);
    }
    if (this.jdField_a_of_type_Long == 1002L)
    {
      int i = AIOUtils.b(44.5F, a().getResources());
      int j = a().getResources().getDimensionPixelOffset(2131298861);
      a().setPadding(0, i + j, 0, 0);
    }
    b(paramVideoPlayParam1, paramVideoPlayParam2);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) {
      RIJVideoReportManager.a(paramVideoPlayParam, paramAbsBaseArticleInfo, a());
    }
  }
  
  public void a(VideoPlayManager paramVideoPlayManager, VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager = paramVideoPlayManager;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController = paramVideoAutoPlayController;
    if (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController.updateNetworkChange(true);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController.updateNetworkChange(false);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager != null) && (!a().e()))
    {
      m();
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController);
      if (RIJShowKanDianTabSp.a(b())) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.c(0);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    t();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 46) || (paramInt == 70) || (paramInt == 118) || (paramInt == 119) || (paramInt == 6) || (paramInt == 128);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return (RIJFeedsType.a(a(paramInt1))) && (a() == 56) && (this.f) && (paramInt2 == 4);
  }
  
  public VideoFeedsViewHolder b(String paramString)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
    int i = Math.max(this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount(), j);
    for (;;)
    {
      Object localObject1 = null;
      if (i > k) {
        break;
      }
      int m = i - this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
      Object localObject2 = a(m);
      if ((localObject2 != null) && (4 == a(m).intValue()) && (TextUtils.equals(((AbsBaseArticleInfo)localObject2).innerUniqueID, paramString)))
      {
        localObject2 = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - j);
        paramString = localObject1;
        if (localObject2 != null) {
          paramString = (VideoFeedsViewHolder)((View)localObject2).getTag();
        }
        return paramString;
      }
      i += 1;
    }
    return null;
  }
  
  public void b()
  {
    this.g = true;
    n();
    A();
    C();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoHandler.1(this), 1000L);
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
    if (localVideoPreDownloadMgr != null) {
      localVideoPreDownloadMgr.a(paramInt, paramBoolean);
    }
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    if (paramAbsListView == null) {
      return;
    }
    Object localObject = a(paramAbsListView);
    if (a() == 40677) {
      return;
    }
    VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if ((localVideoPlayManager != null) && (localVideoPlayManager.h())) {
      return;
    }
    if ((paramAbsListView.getFirstVisiblePosition() <= 5) && (!((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).isNormalMask()) && ((((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).getShowStatus() == 1) || (((IRIJSuperMaskService)QRoute.api(IRIJSuperMaskService.class)).getShowStatus() == 2))) {
      return;
    }
    if (localObject != null)
    {
      localObject = ((PlayableItem)localObject).a();
      if ((localObject != null) && (((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null) && (((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.patchStatus.a.get() == 1)) {
        return;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController.canAutoPlayVideo()) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController.isRefreshingList()) && (paramAbsListView.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.removeMessages(1001);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.sendEmptyMessageDelayed(1001, paramInt);
      if (QLog.isColorLevel())
      {
        paramAbsListView = new StringBuilder();
        paramAbsListView.append("checkPlayableArea delay: ");
        paramAbsListView.append(paramInt);
        QLog.d("Q.readinjoy.video", 2, paramAbsListView.toString());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(9, paramBoolean);
  }
  
  public boolean b()
  {
    return this.g;
  }
  
  public void c()
  {
    this.g = false;
    q();
    a().d();
  }
  
  public void c(AbsListView paramAbsListView, int paramInt)
  {
    if (a() != 0)
    {
      if (a() == 40677) {
        return;
      }
      if ((NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext)) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager != null) && (paramAbsListView != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.removeMessages(1001);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.sendEmptyMessageDelayed(1001, paramInt);
        if (QLog.isColorLevel())
        {
          paramAbsListView = new StringBuilder();
          paramAbsListView.append("force checkPlayableArea delay: ");
          paramAbsListView.append(paramInt);
          QLog.d("Q.readinjoy.video", 2, paramAbsListView.toString());
        }
      }
    }
  }
  
  public boolean c()
  {
    return a().a();
  }
  
  public int d()
  {
    return 0;
  }
  
  public void d() {}
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler;
    if (localObject != null)
    {
      ((ViewHolder.VideoUIHandler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.a.clear();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADBaseAppDownloadManager;
    if (localObject != null) {
      ((IADBaseAppDownloadManager)localObject).a();
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this.jdField_a_of_type_ComTencentBizRichframeworkEventbusSimpleEventReceiver);
  }
  
  public void f()
  {
    super.f();
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if ((localQQAppInterface != null) && (!e))
    {
      e = true;
      ((IDynamicNowManager)localQQAppInterface.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).a();
    }
  }
  
  public void g() {}
  
  public void h()
  {
    super.h();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "notifyDataSetChanged");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localObject != null) {
      localObject = ((VideoPlayManager)localObject).a();
    } else {
      localObject = null;
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem != null) || (localObject != null)) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr != null))
    {
      int j = -1;
      PlayableItem localPlayableItem = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem;
      int i = j;
      if (localPlayableItem != null)
      {
        i = j;
        if (localPlayableItem.a() != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem.a().jdField_a_of_type_Int;
        }
      }
      if (localObject != null) {
        i = ((VideoPlayParam)localObject).jdField_a_of_type_Int;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr.a(i, true);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1001) {
      return false;
    }
    this.jdField_a_of_type_ComTencentWidgetListView.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
    if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect)) {
      return false;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_Boolean) {
        b(this.jdField_a_of_type_ComTencentWidgetListView);
      } else if (QLog.isColorLevel()) {
        QLog.w("VideoHandler", 2, "MSG_FOR_CHECK_PLAYAREA, 平移转场动画未做完，不触发自动播放");
      }
    }
    else {
      b(this.jdField_a_of_type_ComTencentWidgetListView);
    }
    return true;
  }
  
  public void i()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = a();
    if ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localReadInJoyBaseListViewGroup).l();
    }
    if (this.jdField_a_of_type_Long == 1002L) {
      a().setPadding(0, 0, 0, 0);
    }
  }
  
  public void j()
  {
    this.jdField_b_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager != null) && ((e()) || (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController.canAutoPlayVideo())) && (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController.isRefreshingList()))
    {
      ListView localListView = this.jdField_a_of_type_ComTencentWidgetListView;
      if ((localListView != null) && (localListView.getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.removeMessages(1001);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.sendEmptyMessage(1001);
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "checkPlayableArea after transAnim: ");
        }
      }
    }
  }
  
  public void k()
  {
    VideoAutoPlayController localVideoAutoPlayController = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController;
    if (localVideoAutoPlayController != null) {
      localVideoAutoPlayController.setIsRefreshingList(false);
    }
  }
  
  public void l()
  {
    VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localVideoPlayManager != null)
    {
      localVideoPlayManager.a(new VideoHandler.2(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoHandler", 2, "mVideoPlayManager == null");
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr = new VideoPreDownloadMgr(BaseApplicationImpl.getContext());
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
    int i;
    if (a() == 56) {
      i = VideoPreloadReportData.jdField_b_of_type_Int;
    } else {
      i = VideoPreloadReportData.jdField_a_of_type_Int;
    }
    localVideoPreDownloadMgr.a = new VideoPreloadReportData(i, VideoPreloadReportData.g);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr.a(new VideoHandler.3(this));
  }
  
  public void n()
  {
    if ((a().a().f()) && (this.jdField_a_of_type_ComTencentWidgetListView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr.b();
      int j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      int i = j;
      if (j >= c()) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr.a(i);
      a().a().b(false);
    }
  }
  
  public void o()
  {
    VideoPreDownloadMgr localVideoPreDownloadMgr = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
    if (localVideoPreDownloadMgr != null)
    {
      localVideoPreDownloadMgr.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr = null;
    }
  }
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler;
    if (paramView != null) {
      paramView.removeMessages(1001);
    }
  }
  
  public void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(9);
  }
  
  public void q()
  {
    VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localVideoPlayManager != null) {
      localVideoPlayManager.b();
    }
  }
  
  public void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoViewholderViewHolder$VideoUIHandler.removeMessages(1001);
  }
  
  public void s()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearData ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoNetInfoHandler);
      QLog.d("VideoHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareHelper;
    if (localObject != null) {
      ((VideoShareHelper)localObject).a();
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoNetInfoHandler);
  }
  
  public void t()
  {
    VideoPlayManager localVideoPlayManager = a().a().a();
    if ((localVideoPlayManager != null) && (localVideoPlayManager.a() != null)) {
      localVideoPlayManager.a(11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler
 * JD-Core Version:    0.7.0.1
 */