package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.miniaio.MiniPieJumpToAioEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.kandian.base.bandwidth.VideoPreloadStrategyConoller;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyScreenShotReporter;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowRecommendPopupEvent;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyManager.Companion;
import com.tencent.mobileqq.kandian.biz.video.IVideoFeedsLoadDelegate;
import com.tencent.mobileqq.kandian.biz.video.IVideoFeedsLoadDelegate.LifeCycleCallBack;
import com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter;
import com.tencent.mobileqq.kandian.biz.video.WeishiVideoFeedsLazyLoadDelegate;
import com.tencent.mobileqq.kandian.biz.video.constants.VideoUIController;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.glue.video.VideoFeedsConstants;
import com.tencent.mobileqq.kandian.glue.video.VideoResumeManager;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.swipe.SwipeLayoutUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsPlayActivity
  extends BaseActivity
  implements View.OnClickListener, ViewPager.OnPageChangeListener, SimpleEventReceiver, VideoFeedsRecommendFragment.LifeCycleCallBack, VideoFeedsShareController.ShareSheetActionListener, IVideoFeedsLoadDelegate.LifeCycleCallBack, VideoFeedsConstants
{
  private static boolean jdField_a_of_type_Boolean = false;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private DragFrameLayout jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
  private ColorNote jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
  private VideoFeedsCustomFrameLayout jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCustomFrameLayout;
  private VideoFeedsRecommendFragment jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
  private VideoFeedsResourceLoader jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsResourceLoader;
  private VideoFeedsShareController jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController;
  private IVideoFeedsLoadDelegate jdField_a_of_type_ComTencentMobileqqKandianBizVideoIVideoFeedsLoadDelegate;
  private ViolaFragment jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment;
  private String jdField_a_of_type_JavaLangString = null;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private int jdField_b_of_type_Int = 0;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = null;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e = false;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i = false;
  
  private long a()
  {
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if ((localVideoFeedsRecommendFragment != null) && (localVideoFeedsRecommendFragment.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.a().a();
    }
    return 0L;
  }
  
  private IVideoFeedsLoadDelegate a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoIVideoFeedsLoadDelegate == null)
    {
      int j = getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0);
      if (j != 1)
      {
        if (j != 2) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoIVideoFeedsLoadDelegate = new VideoFeedsLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoIVideoFeedsLoadDelegate = new WeishiVideoFeedsLazyLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoIVideoFeedsLoadDelegate = new VideoFeedsLazyLoadDelegate(this, getIntent().getExtras(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoIVideoFeedsLoadDelegate;
  }
  
  private VideoInfo a()
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    if (((localObject instanceof VideoItemHolder)) && (((VideoItemHolder)localObject).a.a != null)) {
      return ((VideoItemHolder)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a.a;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if (localObject != null)
    {
      if (((VideoFeedsRecommendFragment)localObject).b() != null) {
        return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.b();
      }
      return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.a();
    }
    return null;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoFeedsHelper.a(a(), false, true));
    localStringBuilder.append("&v_bg_color=ffffffff&v_push_animated_disable=1&v_fromswitch=1&fromType=105&firstCreated=1");
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(Activity paramActivity)
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(384);
    int j = 1;
    if (localAladdinConfig.getIntegerFromString("samsung_enable", 1) != 1) {
      j = 0;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 29) && (j != 0))
    {
      j = paramActivity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
      j = paramActivity.getResources().getDimensionPixelSize(j);
      if ((j > 0) && (j < ViewUtils.a(20.0F)))
      {
        VideoFeedsHelper.a(paramActivity);
        return;
      }
      VideoFeedsHelper.b(paramActivity);
      return;
    }
    VideoFeedsHelper.b(paramActivity);
  }
  
  private void a(RIJFollowRecommendPopupEvent paramRIJFollowRecommendPopupEvent)
  {
    RecyclerView.ViewHolder localViewHolder = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    if ((localViewHolder instanceof ShortVideoItemHolder)) {
      ((ShortVideoItemHolder)localViewHolder).a.g(paramRIJFollowRecommendPopupEvent.showing ^ true);
    }
  }
  
  static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, paramString);
    }
  }
  
  static void a(String paramString, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, paramString, paramException);
    }
  }
  
  private boolean a()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    return (!(localViewGroup instanceof ViewPagerCompat)) || (((ViewPagerCompat)localViewGroup).getCurrentItem() == 0);
  }
  
  private void d(boolean paramBoolean)
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      FlingGestureHandler localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      if (localFlingGestureHandler.mTopLayout != null)
      {
        localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(paramBoolean);
        localFlingGestureHandler.mTopLayout.setIsInterceptChildEventWhenScroll(paramBoolean);
      }
    }
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((VideoFeedsRecommendFragment)localObject1).b();
    } else {
      localObject1 = null;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    int j;
    if (localObject3 != null) {
      j = ((VideoFeedsRecommendFragment)localObject3).a();
    } else {
      j = 0;
    }
    String str = "";
    VideoR5.Builder localBuilder = new VideoR5.Builder("", "", "", "").c(this.jdField_a_of_type_JavaLangString).a(409409).b((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
    Object localObject4;
    if (localObject1 != null)
    {
      localObject3 = localBuilder.e(((VideoInfo)localObject1).f).c(((VideoInfo)localObject1).p).l(j).s(((VideoInfo)localObject1).d()).t(this.jdField_b_of_type_Int + 1).e(((VideoInfo)localObject1).j).f(((VideoInfo)localObject1).jdField_a_of_type_JavaLangString).g(((VideoInfo)localObject1).g);
      localObject4 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
      boolean bool;
      if ((localObject4 != null) && (((VideoFeedsRecommendFragment)localObject4).d())) {
        bool = true;
      } else {
        bool = false;
      }
      ((VideoR5.Builder)localObject3).b(bool);
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if (localObject3 != null) {
      localObject4 = ((VideoFeedsRecommendFragment)localObject3).a();
    } else {
      localObject4 = null;
    }
    if (localObject4 != null) {
      localObject2 = ((VideoInfo)localObject4).g;
    }
    int k = getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
    localBuilder.i((String)localObject2).E(k).M(0);
    if (paramBoolean) {
      localObject2 = "1";
    } else {
      localObject2 = "0";
    }
    if (jdField_a_of_type_Boolean) {
      localObject3 = "0X8009501";
    } else {
      localObject3 = "0X8007DBB";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject2, "", "", localBuilder.a().a(), false);
    if (localObject1 != null)
    {
      localObject2 = String.valueOf(j + 1);
      if (((VideoInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null) {
        localObject1 = ((VideoInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.h;
      } else {
        localObject1 = "";
      }
    }
    else
    {
      localObject1 = "";
      localObject2 = localObject1;
    }
    localObject3 = str;
    if (localObject4 != null) {
      if (((VideoInfo)localObject4).jdField_b_of_type_Int >= ((VideoInfo)localObject4).jdField_c_of_type_Int) {
        localObject3 = String.valueOf(1);
      } else {
        localObject3 = String.valueOf(2);
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800957B", "0X800957B", 0, 0, (String)localObject1, (String)localObject2, (String)localObject3, "", false);
  }
  
  private void h()
  {
    ThreadManager.post(new VideoFeedsPlayActivity.1(this), 1, null, true);
  }
  
  private void i()
  {
    int j = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_a_of_type_Int = j;
    boolean bool;
    if ((j != 9) && (j != 12) && (j != 21) && (j != 20) && (j != 22) && (j != 23)) {
      bool = false;
    } else {
      bool = true;
    }
    jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_AndroidOsBundle.putBoolean("KEY_IS_WEISHI_MODE", jdField_a_of_type_Boolean);
    getIntent().putExtra("KEY_IS_WEISHI_MODE", jdField_a_of_type_Boolean);
  }
  
  private void j()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.a();
    int j = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    int k = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", 0);
    String str1;
    Object localObject2;
    Object localObject1;
    String str2;
    long l;
    if (localObject3 != null)
    {
      str1 = ((VideoInfo)localObject3).d();
      localObject2 = ((VideoInfo)localObject3).j;
      localObject1 = ((VideoInfo)localObject3).g;
      str2 = ((VideoInfo)localObject3).jdField_a_of_type_JavaLangString;
      l = ((VideoInfo)localObject3).c() * 1000L;
    }
    else
    {
      l = 0L;
      str1 = null;
      str2 = "";
      localObject1 = str2;
      localObject2 = localObject1;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("session_id", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("video_session_id", this.jdField_b_of_type_JavaLangString);
      label133:
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = localObject1;
      } else {
        localObject3 = "0";
      }
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, (String)localObject2, "0X800740A", "0X800740A", 0, 0, String.valueOf(j), String.valueOf(k), (String)localObject3, VideoReporter.a(str1, (String)localObject2, str2, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.c(), l, localJSONObject), false);
      return;
    }
    catch (Exception localException)
    {
      break label133;
    }
  }
  
  @TargetApi(11)
  private void k()
  {
    int j = getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsResourceLoader = new VideoFeedsResourceLoader(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsResourceLoader.a(j);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout = ((DragFrameLayout)findViewById(2131365880));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCustomFrameLayout = ((VideoFeedsCustomFrameLayout)findViewById(2131376818));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCustomFrameLayout.setScrollable(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCustomFrameLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setEnabled(false);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout.setDraggableView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCustomFrameLayout);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a().a(getLayoutInflater(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCustomFrameLayout));
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if ((localViewGroup instanceof ViewPagerCompat)) {
      ((ViewPagerCompat)localViewGroup).addOnPageChangeListener(this);
    }
    l();
  }
  
  private void l()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(417);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("open_auto_color_ball", 0) == 1) {
      bool = true;
    }
    this.h = bool;
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.init(this, true, false, true, true, 0);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setLeftSwipeScope(ViewUtils.a());
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.attachToActivity(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceInfo(new VideoFeedsPlayActivity.3(this));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteAnimFinishListener(new VideoFeedsPlayActivity.4(this));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteCurdListener(new VideoFeedsPlayActivity.5(this));
  }
  
  private void m()
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      FlingGestureHandler localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      localFlingGestureHandler.setTopLayout(new TopGestureLayout(this));
      localFlingGestureHandler.mTopLayout.setIsInterceptChildEventWhenScroll(false);
      localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(false);
      localFlingGestureHandler.mTopLayout.setInterceptScrollRLFlag(true);
      localFlingGestureHandler.mTopLayout.setOnFlingGesture(new VideoFeedsPlayActivity.6(this));
    }
  }
  
  private void n()
  {
    try
    {
      Object localObject1 = getSupportFragmentManager();
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = localObject1.getClass().getDeclaredField("mExecCommit");
      if (localObject2 == null) {
        return;
      }
      ((Field)localObject2).setAccessible(true);
      localObject1 = ((Field)localObject2).get(localObject1);
      if (localObject1 == null) {
        return;
      }
      localObject2 = BaseActivity.class.getDeclaredField("mHandler");
      if (localObject2 == null) {
        return;
      }
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(this);
      if (localObject2 == null) {
        return;
      }
      ((Handler)localObject2).removeCallbacks((Runnable)localObject1);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void o()
  {
    String str = a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", str);
      if (a() != null) {
        localJSONObject.put("thirdUin", a().j);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment != null) {
        localJSONObject.put("position", this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.a());
      }
      localJSONObject.put("recordId", this.jdField_c_of_type_JavaLangString);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetHomePage: HomePageUrl = ");
      localStringBuilder.append(str);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.updateViolaPage(str, localJSONObject);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.initViewAfterVisible();
  }
  
  private void p()
  {
    String str = a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshHomePage: HomePageUrl = ");
      localStringBuilder.append(str);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment.updateViolaPageWhenScroll(str);
    this.f = false;
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.canAddColorNote())
    {
      this.jdField_d_of_type_Int = 3;
      Object localObject = a();
      if (localObject != null)
      {
        ((VideoInfo)localObject).u = this.jdField_d_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mReserve = VideoFeedsHelper.a((VideoInfo)localObject);
        localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
        long l;
        if (VideoResumeManager.a.a()) {
          l = 0L;
        } else {
          l = a();
        }
        ((ColorNote)localObject).mExtLong = l;
        this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.addToRecentNote();
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onCannotAdd();
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  protected void a()
  {
    try
    {
      super.setContentView(2131560317);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 1, "setContentView IllegalStateException", localIllegalStateException);
    }
    this.jdField_a_of_type_AndroidOsBundle = getIntent().getExtras();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID"))) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID");
    } else {
      this.jdField_a_of_type_JavaLangString = VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"));
    }
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("session_id");
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_c_of_type_JavaLangString = VideoReporter.b();
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_CHANNEL_SESSION_ID");
    i();
    k();
    h();
    m();
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo)
  {
    paramVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if (paramVideoInfo != null) {
      paramVideoInfo.a(paramInt);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
    boolean bool = true;
    int j;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onPause();
      j = 1;
    }
    else
    {
      j = 0;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      localObject = (VideoItemHolder)paramViewHolder;
      VideoInfo localVideoInfo = ((VideoItemHolder)localObject).a.a;
      VideoFeedsShareController localVideoFeedsShareController = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController;
      if (localVideoFeedsShareController != null) {
        localVideoFeedsShareController.a(localVideoInfo);
      }
      int k = ((VideoItemHolder)localObject).jdField_c_of_type_Int;
      int m = this.jdField_b_of_type_Int;
      if (k <= m) {
        k = m;
      }
      this.jdField_b_of_type_Int = k;
      this.jdField_a_of_type_JavaUtilSet.add(localVideoInfo.jdField_a_of_type_JavaLangString);
    }
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    if ((localObject instanceof ViewPagerCompat))
    {
      localObject = (ViewPagerCompat)localObject;
      if ((!(paramViewHolder instanceof ShortVideoItemHolder)) || (this.i)) {
        bool = false;
      }
      ((ViewPagerCompat)localObject).setScrollable(bool);
    }
    this.f = (paramViewHolder instanceof ShortVideoItemHolder);
    RIJPushNotifyManager.Companion.a().dismiss(false, "MATCH_ALL_UIN");
    if (j != 0) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onResume();
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.b();
      paramViewHolder = this.jdField_a_of_type_AndroidViewViewGroup;
      if ((paramViewHolder instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)paramViewHolder).setScrollable(false);
      }
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
      if (paramViewHolder != null) {
        paramViewHolder.disableSwipe();
      }
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.b();
      paramViewHolder = this.jdField_a_of_type_AndroidViewViewGroup;
      if ((paramViewHolder instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)paramViewHolder).setScrollable(true);
      }
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
      if (paramViewHolder != null) {
        paramViewHolder.enableSwipe();
      }
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
    }
    RIJPushNotifyManager.Companion.a().dismiss(false, "MATCH_ALL_UIN");
  }
  
  public void a(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment = paramVideoFeedsRecommendFragment;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.a(this);
  }
  
  public void a(ViolaFragment paramViolaFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaViewViolaFragment = paramViolaFragment;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean)
    {
      d(false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
      if (localObject != null) {
        ((IColorNoteController)localObject).enableSwipe();
      }
      a(this);
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if ((localObject instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)localObject).setScrollable(true);
      }
    }
    else
    {
      d(true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
      if (localObject != null) {
        ((IColorNoteController)localObject).disableSwipe();
      }
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if ((localObject instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)localObject).setScrollable(false);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCustomFrameLayout.setScrollable(true);
    }
  }
  
  public void aC_() {}
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.enablePostTable();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.disablePostTable();
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController = new VideoFeedsShareController(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.a(), this.jdField_a_of_type_Int, jdField_a_of_type_Boolean, this, 0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.a());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    VideoReport.setElementId(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.jdField_a_of_type_AndroidWidgetImageView, "more_function_button");
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onResume();
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.refreshPostTable(this);
    ThreadManager.excute(new VideoFeedsPlayActivity.2(this), 16, null, true);
  }
  
  public void c(boolean paramBoolean)
  {
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if (localVideoFeedsRecommendFragment != null) {
      localVideoFeedsRecommendFragment.b(paramBoolean);
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController;
    if (localObject != null) {
      ((VideoFeedsShareController)localObject).a(0, 2);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if (localObject != null) {
      ((VideoFeedsRecommendFragment)localObject).a(new RIJFeedsInsertAction(ActionType.ACTION_SHARE, 0, 0, 0));
    }
    this.e = true;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 21)
    {
      if (paramInt1 != 103)
      {
        if ((paramInt1 == 10001) && (paramInt2 == -1)) {
          QQToast.a(getActivity(), 2131719081, 0).a();
        }
      }
      else if (paramInt2 == -1)
      {
        boolean bool = paramIntent.getBooleanExtra("bFailed", false);
        localObject = new QQToast(getActivity().getApplicationContext());
        ((QQToast)localObject).d(2000);
        if ((bool ^ true))
        {
          ((QQToast)localObject).a(QQToast.a(2));
          ((QQToast)localObject).c(2131692185);
          ((QQToast)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a(getActivity().getApplicationContext(), 5.0F));
        }
        else
        {
          ((QQToast)localObject).a(QQToast.a(1));
          ((QQToast)localObject).c(2131692186);
          ((QQToast)localObject).b(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299168) - (int)DisplayUtils.a(getActivity().getApplicationContext(), 5.0F));
        }
      }
    }
    else if (paramInt2 == -1)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putAll(paramIntent.getExtras());
      VideoFeedsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Bundle)localObject);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if (localObject != null) {
      ((VideoFeedsRecommendFragment)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController;
    if (localObject != null) {
      ((VideoFeedsShareController)localObject).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (!a())
    {
      ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewViewGroup).setCurrentItem(0);
      return;
    }
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if ((localVideoFeedsRecommendFragment != null) && (localVideoFeedsRecommendFragment.c())) {
      return;
    }
    e(false);
    e();
    super.doOnBackPressed();
  }
  
  @TargetApi(11)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      RIJAppSetting.a("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnCreate()");
    }
    super.doOnCreate(paramBundle);
    if (VersionUtils.d()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    LiuHaiUtils.enableNotch(this);
    a(this);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800AF10", "0X800AF10", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnCreate: ");
    localStringBuilder.append(paramBundle);
    QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 1, localStringBuilder.toString());
    if ((getIntent() != null) && (getIntent().getExtras() != null))
    {
      a();
      if (paramBundle != null) {
        overridePendingTransition(2130772266, 0);
      } else if (getIntent().getBooleanExtra("VIDEO_FEEDS_ANIM_ENABLE", true)) {
        a().a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout);
      }
      int j = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", 0);
      VideoReport.setPageId(this, "6");
      VideoReport.setPageParams(this, new RIJDtParamBuilder().a("ref_channel", Integer.valueOf(j)).a());
      VideoReport.addToDetectionWhitelist(this);
      SimpleEventBus.getInstance().registerReceiver(this);
      return true;
    }
    finish();
    QLog.e("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, "doOnCreate: getIntent().getExtras() = null");
    return true;
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      a("super.doOnDestroy failed. \n", localIllegalArgumentException);
      n();
    }
    this.jdField_c_of_type_Boolean = true;
    IVideoFeedsLoadDelegate localIVideoFeedsLoadDelegate = a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if (localObject != null) {
      localObject = ((VideoFeedsRecommendFragment)localObject).b();
    } else {
      localObject = null;
    }
    localIVideoFeedsLoadDelegate.a((VideoInfo)localObject);
    localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetDragFrameLayout;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController;
    if (localObject != null) {
      ((VideoFeedsShareController)localObject).c();
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsResourceLoader;
    if (localObject != null) {
      ((VideoFeedsResourceLoader)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    VideoBehaviorsReporter.a().a();
    ReadInJoyScreenShotReporter.a(this).b();
    VideoPreloadStrategyConoller.a().a("video_feeds", this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onDestroy();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    a("VideoFeedsPlayActivity doOnDestroy()");
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!a()) {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if ((localVideoFeedsRecommendFragment != null) && (localVideoFeedsRecommendFragment.a(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnPause()
  {
    VideoFeedsShareController localVideoFeedsShareController = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController;
    if (localVideoFeedsShareController != null) {
      localVideoFeedsShareController.b();
    }
    if (!this.e) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onPause();
    }
    this.e = false;
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(this);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsPlayActivity.7(this), 500L);
    VideoFeedsShareController localVideoFeedsShareController = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController;
    if (localVideoFeedsShareController != null) {
      localVideoFeedsShareController.a();
    }
    ReadInJoyScreenShotReporter.a(this).a(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onResume();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle) {}
  
  protected void doOnStop()
  {
    super.doOnStop();
    ReadInJoyScreenShotReporter.a(getActivity()).a();
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    a(this);
  }
  
  protected void e()
  {
    finish();
  }
  
  public void f()
  {
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if (localVideoFeedsRecommendFragment != null)
    {
      localVideoFeedsRecommendFragment.e();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.g();
    }
  }
  
  public void finish()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if ((localObject1 != null) && (((VideoFeedsRecommendFragment)localObject1).a() != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.a();
      ((VideoFeedsPlayManager)localObject1).a(ReportConstants.VideoEndType.EXIT_SCENE);
      long l1 = ((VideoFeedsPlayManager)localObject1).a();
      long l2 = ((VideoFeedsPlayManager)localObject1).c();
      long l3 = ((VideoFeedsPlayManager)localObject1).d();
      int j;
      if (l3 > 0L) {
        j = (int)((float)l2 / (float)l3 * 100.0F);
      } else {
        j = 0;
      }
      Object localObject2 = ((VideoFeedsPlayManager)localObject1).a();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.a() == localObject2)
      {
        this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", ((VideoFeedsPlayManager)localObject1).a());
        this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", l1);
      }
      else
      {
        this.jdField_a_of_type_AndroidOsBundle.putInt("VIDEO_PLAY_STATUS", 0);
        this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", 0L);
      }
      if (localObject2 != null) {
        this.jdField_a_of_type_AndroidOsBundle.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject2).g);
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras(this.jdField_a_of_type_AndroidOsBundle);
      setResult(-1, (Intent)localObject2);
      super.finish();
      overridePendingTransition(0, 2130772025);
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_IS_FROM_CONVERSATION")) {
        ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(this, 14, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.a(new RIJFeedsInsertAction(ActionType.ACTION_VIDEO_PLAY_PROGRESS, j, 0, 0));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.j();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("finishActivityWithResult() position=");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(", currentPlayStatus=");
      ((StringBuilder)localObject2).append(((VideoFeedsPlayManager)localObject1).a());
      a(((StringBuilder)localObject2).toString());
      return;
    }
    super.finish();
    overridePendingTransition(0, 2130772025);
    localObject1 = this.jdField_a_of_type_AndroidOsBundle;
    if ((localObject1 != null) && (((Bundle)localObject1).getBoolean(VideoUIController.jdField_a_of_type_JavaLangString))) {
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(this, 14, 0);
    }
  }
  
  public void g()
  {
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if (localVideoFeedsRecommendFragment != null)
    {
      localVideoFeedsRecommendFragment.f();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment.h();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(MiniPieJumpToAioEvent.class);
    localArrayList.add(RIJFollowRecommendPopupEvent.class);
    return localArrayList;
  }
  
  protected String getModuleId()
  {
    return "module_videofeeds";
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    LiuHaiUtils.a(this);
    LiuHaiUtils.enableNotch(this);
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    if (j != 2131370799)
    {
      if (j != 2131377376) {
        return;
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
      if (paramView != null) {
        VideoFeedsHelper.a(paramView.jdField_a_of_type_AndroidWidgetImageView, a(), "click_more_function");
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareController;
      if (paramView != null) {
        paramView.a(0, 1);
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
      if (paramView != null) {
        paramView.a(new RIJFeedsInsertAction(ActionType.ACTION_SHARE, 0, 0, 0));
      }
      this.e = true;
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment;
    if ((paramView != null) && (paramView.c())) {
      return;
    }
    e(false);
    e();
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      if ((this.jdField_c_of_type_Int == ((ViewPagerCompat)this.jdField_a_of_type_AndroidViewViewGroup).getCurrentItem()) && (!this.g))
      {
        paramInt = this.jdField_c_of_type_Int;
        if (paramInt == 0) {
          a(1, false);
        } else if (paramInt == 1) {
          a(0, false);
        }
      }
      this.g = false;
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((this.f) && (paramInt1 == 0) && (paramFloat > 0.0F))
    {
      o();
      p();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.g = true;
    a(paramInt, true);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof MiniPieJumpToAioEvent)) && (this.h))
    {
      q();
      return;
    }
    if ((paramSimpleBaseEvent instanceof RIJFollowRecommendPopupEvent)) {
      a((RIJFollowRecommendPopupEvent)paramSimpleBaseEvent);
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, "onRestoreInstanceState: ");
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, "onSaveInstanceState: ");
    }
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    this.mActNeedImmersive = false;
    getWindow().setFlags(1024, 1024);
    getWindow().setBackgroundDrawable(null);
    setRequestedOrientation(1);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if ((Build.VERSION.SDK_INT == 26) && (this.jdField_d_of_type_Boolean))
    {
      SwipeLayoutUtils.a(this);
      this.jdField_d_of_type_Boolean = false;
    }
    try
    {
      superSetRequestedOrientation(paramInt);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, "setRequestedOrientation: ", localException);
      }
    }
  }
  
  protected boolean themeChangeRightNow()
  {
    return false;
  }
  
  public void updateAppRuntime()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity
 * JD-Core Version:    0.7.0.1
 */