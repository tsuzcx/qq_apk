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
import com.tencent.mobileqq.kandian.base.view.widget.LifeCycleCallBack;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyScreenShotReporter;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowRecommendPopupEvent;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.impl.ReadInJoyActivityHelper;
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
  implements View.OnClickListener, ViewPager.OnPageChangeListener, SimpleEventReceiver, LifeCycleCallBack, VideoFeedsShareController.ShareSheetActionListener, IVideoFeedsLoadDelegate.LifeCycleCallBack, VideoFeedsConstants
{
  private static boolean a = false;
  private boolean A = false;
  private IVideoFeedsLoadDelegate B;
  private VideoFeedsShareController C;
  private VideoFeedsResourceLoader D;
  private IColorNoteController E;
  private Handler F = new Handler(Looper.getMainLooper());
  private VideoFeedsCustomFrameLayout b;
  private DragFrameLayout c;
  private ViewGroup d;
  private VideoFeedsRecommendFragment e;
  private ViolaFragment f;
  private RecyclerView.ViewHolder g;
  private String h = null;
  private String i = null;
  private String j = null;
  private Bundle k;
  private QQAppInterface l;
  private int m = 0;
  private int n = 0;
  private long o = 0L;
  private boolean p = true;
  private boolean q = false;
  private Set<String> r = new HashSet();
  private boolean s = true;
  private boolean t = false;
  private boolean u;
  private boolean v;
  private int w;
  private int x;
  private boolean y;
  private ColorNote z;
  
  private void a(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(Activity paramActivity)
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(384);
    int i1 = 1;
    if (localAladdinConfig.getIntegerFromString("samsung_enable", 1) != 1) {
      i1 = 0;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 29) && (i1 != 0))
    {
      i1 = paramActivity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
      i1 = paramActivity.getResources().getDimensionPixelSize(i1);
      if ((i1 > 0) && (i1 < ViewUtils.dip2px(20.0F)))
      {
        VideoFeedsHelper.g(paramActivity);
        return;
      }
      VideoFeedsHelper.h(paramActivity);
      return;
    }
    VideoFeedsHelper.h(paramActivity);
  }
  
  private void a(RIJFollowRecommendPopupEvent paramRIJFollowRecommendPopupEvent)
  {
    RecyclerView.ViewHolder localViewHolder = this.g;
    if ((localViewHolder instanceof ShortVideoItemHolder)) {
      ((ShortVideoItemHolder)localViewHolder).aA.h(paramRIJFollowRecommendPopupEvent.showing ^ true);
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
    Object localObject1 = this.e;
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = ((VideoFeedsRecommendFragment)localObject1).n();
    } else {
      localObject1 = null;
    }
    Object localObject3 = this.e;
    int i1;
    if (localObject3 != null) {
      i1 = ((VideoFeedsRecommendFragment)localObject3).q();
    } else {
      i1 = 0;
    }
    String str = "";
    VideoR5.Builder localBuilder = new VideoR5.Builder("", "", "", "").d(this.h).a(409409).b((System.currentTimeMillis() - this.o) / 1000L);
    Object localObject4;
    if (localObject1 != null)
    {
      localObject3 = localBuilder.e(((VideoInfo)localObject1).ah).c(((VideoInfo)localObject1).ai).l(i1).s(((VideoInfo)localObject1).p()).t(this.n + 1).f(((VideoInfo)localObject1).q).g(((VideoInfo)localObject1).b).h(((VideoInfo)localObject1).l);
      localObject4 = this.e;
      boolean bool;
      if ((localObject4 != null) && (((VideoFeedsRecommendFragment)localObject4).p())) {
        bool = true;
      } else {
        bool = false;
      }
      ((VideoR5.Builder)localObject3).d(bool);
    }
    localObject3 = this.e;
    if (localObject3 != null) {
      localObject4 = ((VideoFeedsRecommendFragment)localObject3).m();
    } else {
      localObject4 = null;
    }
    if (localObject4 != null) {
      localObject2 = ((VideoInfo)localObject4).l;
    }
    int i2 = getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
    localBuilder.j((String)localObject2).E(i2).M(0);
    if (paramBoolean) {
      localObject2 = "1";
    } else {
      localObject2 = "0";
    }
    if (a) {
      localObject3 = "0X8009501";
    } else {
      localObject3 = "0X8007DBB";
    }
    PublicAccountReportUtils.a(null, "", (String)localObject3, (String)localObject3, 0, 0, (String)localObject2, "", "", localBuilder.b().a(), false);
    if (localObject1 != null)
    {
      localObject2 = String.valueOf(i1 + 1);
      if (((VideoInfo)localObject1).as != null) {
        localObject1 = ((VideoInfo)localObject1).as.m;
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
      if (((VideoInfo)localObject4).c >= ((VideoInfo)localObject4).d) {
        localObject3 = String.valueOf(1);
      } else {
        localObject3 = String.valueOf(2);
      }
    }
    PublicAccountReportUtils.a(null, "", "0X800957B", "0X800957B", 0, 0, (String)localObject1, (String)localObject2, (String)localObject3, "", false);
  }
  
  private IVideoFeedsLoadDelegate h()
  {
    if (this.B == null)
    {
      int i1 = getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0);
      if (i1 != 1)
      {
        if (i1 != 2) {
          this.B = new VideoFeedsLoadDelegate(this, getIntent().getExtras(), this.l, this, this.h, this.j, this.i, a, this.m);
        } else {
          this.B = new WeishiVideoFeedsLazyLoadDelegate(this, getIntent().getExtras(), this.l, this, this.h, this.j, this.i, a, this.m);
        }
      }
      else {
        this.B = new VideoFeedsLazyLoadDelegate(this, getIntent().getExtras(), this.l, this, this.h, this.j, this.i, a, this.m);
      }
    }
    return this.B;
  }
  
  private void i()
  {
    ThreadManager.post(new VideoFeedsPlayActivity.1(this), 1, null, true);
  }
  
  private void j()
  {
    int i1 = this.k.getInt("VIDEO_FROM_TYPE", -1);
    this.m = i1;
    boolean bool;
    if ((i1 != 9) && (i1 != 12) && (i1 != 21) && (i1 != 20) && (i1 != 22) && (i1 != 23)) {
      bool = false;
    } else {
      bool = true;
    }
    a = bool;
    this.k.putBoolean("KEY_IS_WEISHI_MODE", a);
    getIntent().putExtra("KEY_IS_WEISHI_MODE", a);
  }
  
  private void k()
  {
    Object localObject3 = this.e.m();
    int i1 = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    int i2 = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", 0);
    String str1;
    Object localObject2;
    Object localObject1;
    String str2;
    long l1;
    if (localObject3 != null)
    {
      str1 = ((VideoInfo)localObject3).l();
      localObject2 = ((VideoInfo)localObject3).q;
      localObject1 = ((VideoInfo)localObject3).l;
      str2 = ((VideoInfo)localObject3).b;
      l1 = ((VideoInfo)localObject3).k() * 1000L;
    }
    else
    {
      l1 = 0L;
      str1 = null;
      str2 = "";
      localObject1 = str2;
      localObject2 = localObject1;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("session_id", this.h);
      localJSONObject.put("video_session_id", this.i);
      label133:
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = localObject1;
      } else {
        localObject3 = "0";
      }
      PublicAccountReportUtils.a(null, (String)localObject2, "0X800740A", "0X800740A", 0, 0, String.valueOf(i1), String.valueOf(i2), (String)localObject3, VideoReporter.a(str1, (String)localObject2, str2, (String)localObject1, this.e.r(), l1, localJSONObject), false);
      return;
    }
    catch (Exception localException)
    {
      break label133;
    }
  }
  
  @TargetApi(11)
  private void l()
  {
    int i1 = getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0);
    this.D = new VideoFeedsResourceLoader(this);
    this.D.a(i1);
    this.c = ((DragFrameLayout)findViewById(2131432141));
    this.b = ((VideoFeedsCustomFrameLayout)findViewById(2131445148));
    this.b.setScrollable(false);
    this.b.setVisibility(0);
    this.c.setEnabled(false);
    this.c.setDraggableView(this.b);
    this.d = ((ViewGroup)h().a(getLayoutInflater(), this.b));
    ViewGroup localViewGroup = this.d;
    if ((localViewGroup instanceof ViewPagerCompat)) {
      ((ViewPagerCompat)localViewGroup).addOnPageChangeListener(this);
    }
    m();
  }
  
  private void m()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(417);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("open_auto_color_ball", 0) == 1) {
      bool = true;
    }
    this.y = bool;
    this.E = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.E.init(this, true, false, true, true, 0);
    this.E.setLeftSwipeScope(ViewUtils.getScreenWidth());
    this.E.attachToActivity(this);
    this.E.setServiceInfo(new VideoFeedsPlayActivity.3(this));
    this.E.setOnColorNoteAnimFinishListener(new VideoFeedsPlayActivity.4(this));
    this.E.setOnColorNoteCurdListener(new VideoFeedsPlayActivity.5(this));
  }
  
  private long n()
  {
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.e;
    if ((localVideoFeedsRecommendFragment != null) && (localVideoFeedsRecommendFragment.j() != null)) {
      return this.e.j().b();
    }
    return 0L;
  }
  
  private VideoInfo p()
  {
    Object localObject = this.g;
    if (((localObject instanceof VideoItemHolder)) && (((VideoItemHolder)localObject).az.c != null)) {
      return ((VideoItemHolder)this.g).az.c;
    }
    localObject = this.e;
    if (localObject != null)
    {
      if (((VideoFeedsRecommendFragment)localObject).n() != null) {
        return this.e.n();
      }
      return this.e.m();
    }
    return null;
  }
  
  private void q()
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
  
  private void r()
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
  
  private boolean s()
  {
    ViewGroup localViewGroup = this.d;
    return (!(localViewGroup instanceof ViewPagerCompat)) || (((ViewPagerCompat)localViewGroup).getCurrentItem() == 0);
  }
  
  private void t()
  {
    String str = v();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", str);
      if (p() != null) {
        localJSONObject.put("thirdUin", p().q);
      }
      if (this.e != null) {
        localJSONObject.put("position", this.e.q());
      }
      localJSONObject.put("recordId", this.j);
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
    this.f.updateViolaPage(str, localJSONObject);
    this.f.initViewAfterVisible();
  }
  
  private void u()
  {
    String str = v();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshHomePage: HomePageUrl = ");
      localStringBuilder.append(str);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 2, localStringBuilder.toString());
    }
    this.f.updateViolaPageWhenScroll(str);
    this.u = false;
  }
  
  private String v()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(VideoFeedsHelper.a(p(), false, true));
    localStringBuilder.append("&v_bg_color=ffffffff&v_push_animated_disable=1&v_fromswitch=1&fromType=105&firstCreated=1");
    return localStringBuilder.toString();
  }
  
  private void w()
  {
    if (this.E.canAddColorNote())
    {
      this.x = 3;
      Object localObject = p();
      if (localObject != null)
      {
        ((VideoInfo)localObject).av = this.x;
        this.z.mReserve = VideoFeedsHelper.b((VideoInfo)localObject);
        localObject = this.z;
        long l1;
        if (VideoResumeManager.a.a()) {
          l1 = 0L;
        } else {
          l1 = n();
        }
        ((ColorNote)localObject).mExtLong = l1;
        this.E.addToRecentNote();
      }
    }
    else
    {
      this.E.onCannotAdd();
    }
  }
  
  public void a()
  {
    if (!this.q)
    {
      this.C = new VideoFeedsShareController(this, this.l, this.e.j(), this.m, a, this, 0);
      this.C.b(this.e.m());
      this.C.a(this.E);
    }
    this.e.c.setOnClickListener(this);
    this.e.b.setOnClickListener(this);
    VideoReport.setElementId(this.e.b, "more_function_button");
    this.E.onResume();
    this.E.refreshPostTable(this);
    ThreadManager.excute(new VideoFeedsPlayActivity.2(this), 16, null, true);
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo)
  {
    paramVideoInfo = this.e;
    if (paramVideoInfo != null) {
      paramVideoInfo.a(paramInt);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = this.g;
    boolean bool = true;
    int i1;
    if (localObject != null)
    {
      this.E.onPause();
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    this.g = paramViewHolder;
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      localObject = (VideoItemHolder)paramViewHolder;
      VideoInfo localVideoInfo = ((VideoItemHolder)localObject).az.c;
      VideoFeedsShareController localVideoFeedsShareController = this.C;
      if (localVideoFeedsShareController != null) {
        localVideoFeedsShareController.a(localVideoInfo);
      }
      int i2 = ((VideoItemHolder)localObject).Z;
      int i3 = this.n;
      if (i2 <= i3) {
        i2 = i3;
      }
      this.n = i2;
      this.r.add(localVideoInfo.b);
    }
    localObject = this.d;
    if ((localObject instanceof ViewPagerCompat))
    {
      localObject = (ViewPagerCompat)localObject;
      if ((!(paramViewHolder instanceof ShortVideoItemHolder)) || (this.A)) {
        bool = false;
      }
      ((ViewPagerCompat)localObject).setScrollable(bool);
    }
    this.u = (paramViewHolder instanceof ShortVideoItemHolder);
    RIJPushNotifyManager.Companion.a().dismiss(false, "MATCH_ALL_UIN");
    if (i1 != 0) {
      this.E.onResume();
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.A = paramBoolean;
    if (paramBoolean)
    {
      this.e.n();
      paramViewHolder = this.d;
      if ((paramViewHolder instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)paramViewHolder).setScrollable(false);
      }
      paramViewHolder = this.E;
      if (paramViewHolder != null) {
        paramViewHolder.disableSwipe();
      }
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
    }
    else
    {
      this.e.n();
      paramViewHolder = this.d;
      if ((paramViewHolder instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)paramViewHolder).setScrollable(true);
      }
      paramViewHolder = this.E;
      if (paramViewHolder != null) {
        paramViewHolder.enableSwipe();
      }
      ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
    }
    RIJPushNotifyManager.Companion.a().dismiss(false, "MATCH_ALL_UIN");
  }
  
  public void a(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment)
  {
    this.e = paramVideoFeedsRecommendFragment;
    this.e.a(this);
  }
  
  public void a(ViolaFragment paramViolaFragment)
  {
    this.f = paramViolaFragment;
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean)
    {
      d(false);
      localObject = this.E;
      if (localObject != null) {
        ((IColorNoteController)localObject).enableSwipe();
      }
      a(this);
      localObject = this.d;
      if ((localObject instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)localObject).setScrollable(true);
      }
    }
    else
    {
      d(true);
      localObject = this.E;
      if (localObject != null) {
        ((IColorNoteController)localObject).disableSwipe();
      }
      localObject = this.d;
      if ((localObject instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)localObject).setScrollable(false);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      this.b.setScrollable(true);
    }
  }
  
  public void b()
  {
    Object localObject = this.C;
    if (localObject != null) {
      ((VideoFeedsShareController)localObject).a(0, 2);
    }
    localObject = this.e;
    if (localObject != null) {
      ((VideoFeedsRecommendFragment)localObject).a(new RIJFeedsInsertAction(ActionType.ACTION_SHARE, 0, 0, 0));
    }
    this.t = true;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.E.enablePostTable();
      return;
    }
    this.E.disablePostTable();
  }
  
  protected void c()
  {
    try
    {
      super.setContentView(2131626363);
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 1, "setContentView IllegalStateException", localIllegalStateException);
    }
    this.k = getIntent().getExtras();
    if (!TextUtils.isEmpty(this.k.getString("VIDEO_FEEDS_INNER_SESSION_ID"))) {
      this.h = this.k.getString("VIDEO_FEEDS_INNER_SESSION_ID");
    } else {
      this.h = VideoFeedsHelper.a(this.l, this.k.getString("VIDEO_ARTICLE_ID"));
    }
    this.j = this.k.getString("session_id");
    if (TextUtils.isEmpty(this.j)) {
      this.j = VideoReporter.b();
    }
    this.i = this.k.getString("VIDEO_CHANNEL_SESSION_ID");
    j();
    l();
    i();
    q();
  }
  
  public void c(boolean paramBoolean)
  {
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.e;
    if (localVideoFeedsRecommendFragment != null) {
      localVideoFeedsRecommendFragment.b(paramBoolean);
    }
  }
  
  protected void d()
  {
    finish();
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 21)
    {
      if (paramInt1 != 103)
      {
        if ((paramInt1 == 10001) && (paramInt2 == -1)) {
          QQToast.makeText(getActivity(), 2131916617, 0).show();
        }
      }
      else if (paramInt2 == -1)
      {
        boolean bool = paramIntent.getBooleanExtra("bFailed", false);
        localObject = new QQToast(getActivity().getApplicationContext());
        ((QQToast)localObject).setDuration(2000);
        if ((bool ^ true))
        {
          ((QQToast)localObject).setToastIcon(QQToast.getIconRes(2));
          ((QQToast)localObject).setToastMsg(2131889172);
          ((QQToast)localObject).show(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(getActivity().getApplicationContext(), 5.0F));
        }
        else
        {
          ((QQToast)localObject).setToastIcon(QQToast.getIconRes(1));
          ((QQToast)localObject).setToastMsg(2131889173);
          ((QQToast)localObject).show(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(getActivity().getApplicationContext(), 5.0F));
        }
      }
    }
    else if (paramInt2 == -1)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putAll(paramIntent.getExtras());
      VideoFeedsHelper.a(this.l, (Bundle)localObject);
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((VideoFeedsRecommendFragment)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    localObject = this.C;
    if (localObject != null) {
      ((VideoFeedsShareController)localObject).a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (!s())
    {
      ((ViewPagerCompat)this.d).setCurrentItem(0);
      return;
    }
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.e;
    if ((localVideoFeedsRecommendFragment != null) && (localVideoFeedsRecommendFragment.i())) {
      return;
    }
    e(false);
    d();
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
    this.o = System.currentTimeMillis();
    PublicAccountReportUtils.a(null, "", "0X800AF10", "0X800AF10", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doOnCreate: ");
    localStringBuilder.append(paramBundle);
    QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayActivity", 1, localStringBuilder.toString());
    if ((getIntent() != null) && (getIntent().getExtras() != null))
    {
      c();
      if (paramBundle != null) {
        overridePendingTransition(2130772345, 0);
      } else if (getIntent().getBooleanExtra("VIDEO_FEEDS_ANIM_ENABLE", true)) {
        h().a(this.c);
      }
      int i1 = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", 0);
      VideoReport.setPageId(this, "6");
      VideoReport.setPageParams(this, new RIJDtParamBuilder().a("ref_channel", Integer.valueOf(i1)).b());
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
      r();
    }
    this.q = true;
    IVideoFeedsLoadDelegate localIVideoFeedsLoadDelegate = h();
    Object localObject = this.e;
    if (localObject != null) {
      localObject = ((VideoFeedsRecommendFragment)localObject).n();
    } else {
      localObject = null;
    }
    localIVideoFeedsLoadDelegate.a((VideoInfo)localObject);
    localObject = this.c;
    if (localObject != null) {
      ((DragFrameLayout)localObject).a();
    }
    localObject = this.C;
    if (localObject != null) {
      ((VideoFeedsShareController)localObject).e();
    }
    localObject = this.F;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.F = null;
    }
    localObject = this.D;
    if (localObject != null) {
      ((VideoFeedsResourceLoader)localObject).b();
    }
    this.l = null;
    VideoBehaviorsReporter.a().b();
    ReadInJoyScreenShotReporter.a(this).b();
    VideoPreloadStrategyConoller.a().b("video_feeds", this.n);
    this.E.onDestroy();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    a("VideoFeedsPlayActivity doOnDestroy()");
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!s()) {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.e;
    if ((localVideoFeedsRecommendFragment != null) && (localVideoFeedsRecommendFragment.a(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnPause()
  {
    VideoFeedsShareController localVideoFeedsShareController = this.C;
    if (localVideoFeedsShareController != null) {
      localVideoFeedsShareController.d();
    }
    if (!this.t) {
      this.E.onPause();
    }
    this.t = false;
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a(this);
    this.F.postDelayed(new VideoFeedsPlayActivity.7(this), 500L);
    VideoFeedsShareController localVideoFeedsShareController = this.C;
    if (localVideoFeedsShareController != null) {
      localVideoFeedsShareController.c();
    }
    ReadInJoyScreenShotReporter.a(this).a(-1, -1);
    this.E.onResume();
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
  
  public void e()
  {
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.e;
    if (localVideoFeedsRecommendFragment != null)
    {
      localVideoFeedsRecommendFragment.e();
      this.e.t();
    }
  }
  
  public void f()
  {
    VideoFeedsRecommendFragment localVideoFeedsRecommendFragment = this.e;
    if (localVideoFeedsRecommendFragment != null)
    {
      localVideoFeedsRecommendFragment.f();
      this.e.u();
    }
  }
  
  public void finish()
  {
    Object localObject1 = this.e;
    if ((localObject1 != null) && (((VideoFeedsRecommendFragment)localObject1).j() != null))
    {
      localObject1 = this.e.j();
      ((VideoFeedsPlayManager)localObject1).a(ReportConstants.VideoEndType.EXIT_SCENE);
      long l1 = ((VideoFeedsPlayManager)localObject1).b();
      long l2 = ((VideoFeedsPlayManager)localObject1).d();
      long l3 = ((VideoFeedsPlayManager)localObject1).t();
      int i1;
      if (l3 > 0L) {
        i1 = (int)((float)l2 / (float)l3 * 100.0F);
      } else {
        i1 = 0;
      }
      Object localObject2 = ((VideoFeedsPlayManager)localObject1).e();
      if (this.e.m() == localObject2)
      {
        this.k.putInt("VIDEO_PLAY_STATUS", ((VideoFeedsPlayManager)localObject1).r());
        this.k.putLong("VIDEO_PLAY_POSITION", l1);
      }
      else
      {
        this.k.putInt("VIDEO_PLAY_STATUS", 0);
        this.k.putLong("VIDEO_PLAY_POSITION", 0L);
      }
      if (localObject2 != null) {
        this.k.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject2).l);
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtras(this.k);
      setResult(-1, (Intent)localObject2);
      super.finish();
      overridePendingTransition(0, 2130772030);
      if (this.k.getBoolean("VIDEO_IS_FROM_CONVERSATION")) {
        ReadInJoyActivityHelper.INSTANCE.launchFeedsActivity(this, 14, 0);
      }
      this.e.a(new RIJFeedsInsertAction(ActionType.ACTION_VIDEO_PLAY_PROGRESS, i1, 0, 0));
      this.e.w();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("finishActivityWithResult() position=");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(", currentPlayStatus=");
      ((StringBuilder)localObject2).append(((VideoFeedsPlayManager)localObject1).r());
      a(((StringBuilder)localObject2).toString());
      return;
    }
    super.finish();
    overridePendingTransition(0, 2130772030);
    localObject1 = this.k;
    if ((localObject1 != null) && (((Bundle)localObject1).getBoolean(VideoUIController.a))) {
      ReadInJoyActivityHelper.INSTANCE.launchFeedsActivity(this, 14, 0);
    }
  }
  
  public ViewGroup g()
  {
    return this.e.a;
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
  
  public void o() {}
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    LiuHaiUtils.f(this);
    LiuHaiUtils.enableNotch(this);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131438109)
    {
      if (i1 != 2131445775) {
        return;
      }
      paramView = this.e;
      if (paramView != null) {
        VideoFeedsHelper.a(paramView.b, p(), "click_more_function");
      }
      paramView = this.C;
      if (paramView != null) {
        paramView.a(0, 1);
      }
      paramView = this.e;
      if (paramView != null) {
        paramView.a(new RIJFeedsInsertAction(ActionType.ACTION_SHARE, 0, 0, 0));
      }
      this.t = true;
      return;
    }
    paramView = this.e;
    if ((paramView != null) && (paramView.i())) {
      return;
    }
    e(false);
    d();
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      if ((this.w == ((ViewPagerCompat)this.d).getCurrentItem()) && (!this.v))
      {
        paramInt = this.w;
        if (paramInt == 0) {
          a(1, false);
        } else if (paramInt == 1) {
          a(0, false);
        }
      }
      this.v = false;
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if ((this.u) && (paramInt1 == 0) && (paramFloat > 0.0F))
    {
      t();
      u();
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    this.w = paramInt;
    this.v = true;
    a(paramInt, true);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof MiniPieJumpToAioEvent)) && (this.y))
    {
      w();
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
    if ((Build.VERSION.SDK_INT == 26) && (this.s))
    {
      SwipeLayoutUtils.a(this);
      this.s = false;
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
    this.l = ((QQAppInterface)ReadInJoyUtils.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayActivity
 * JD-Core Version:    0.7.0.1
 */