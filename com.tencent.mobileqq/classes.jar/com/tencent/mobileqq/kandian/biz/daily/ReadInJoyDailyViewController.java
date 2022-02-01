package com.tencent.mobileqq.kandian.biz.daily;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.util.SneakyCallback;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.diandian.DailyFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewBridge;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJFloatViewManager;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.xtab.UgcPublishUserGuideController;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule.UserLevelInfoUpdateListener;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoySrtUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.adapter.entryview.BizEntryViewController;
import com.tencent.widget.ListView;
import java.util.Map;
import org.json.JSONObject;

public class ReadInJoyDailyViewController
  extends ReadInJoyBaseViewController
  implements View.OnClickListener
{
  private static boolean i = true;
  private static String j = "readinjoy_daily_old_version_cache_deal";
  private static boolean k = ((Boolean)RIJSPUtils.b(j, Boolean.valueOf(false))).booleanValue();
  private static int t;
  protected ReadInJoyObserver a = new ReadInJoyDailyViewController.4(this);
  private ViewGroup l;
  private ReadInJoyBaseListViewGroup m;
  private ReadInJoyDailyPullToZoomHeaderXListView n;
  private ReadInJoyBaseAdapter o;
  private int p = -1;
  private int q = -1;
  private volatile boolean r = false;
  private int s = -1;
  private boolean u = false;
  private VideoPlayManager v;
  private VideoUIManager w;
  private RIJUserLevelModule.UserLevelInfoUpdateListener x = new ReadInJoyDailyViewController.1(this);
  
  public ReadInJoyDailyViewController(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private void b(ListView paramListView, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    for (Object localObject1 = DailyModeConfigHandler.d();; localObject1 = null)
    {
      try
      {
        Object localObject2 = ((JSONObject)localObject1).optString("style_ID", "null");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initPTSFooterView] ");
        localStringBuilder.append((String)localObject2);
        QLog.i("ReadInJoyDailyViewController", 1, localStringBuilder.toString());
        localObject2 = TemplateFactory.a("default_feeds", true);
        if (localObject2 == null) {
          continue;
        }
        localObject1 = ((TemplateFactory)localObject2).getTemplateBean((JSONObject)localObject1);
        if (localObject1 != null)
        {
          paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.F();
          paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.getViewFactory().inflate(paramReadInJoyBaseAdapter, (TemplateBean)localObject1);
          ProteusSupportUtil.a(paramReadInJoyBaseAdapter, null, (TemplateBean)localObject1);
          paramReadInJoyBaseAdapter.setTag(localObject1);
          paramListView.addFooterView(paramReadInJoyBaseAdapter);
          if ((paramListView instanceof ReadInJoyDailyXListView)) {
            ((ReadInJoyDailyXListView)paramListView).setPTSFooterView(paramReadInJoyBaseAdapter);
          }
        }
        else
        {
          QLog.e("ReadInJoyDailyViewController", 1, "[initPTSFooterView] template bean is null");
          return;
        }
      }
      catch (Exception paramListView)
      {
        QLog.e("ReadInJoyDailyViewController", 1, "[initPTSFooterView] ", paramListView);
      }
      return;
    }
  }
  
  public static int m()
  {
    return t;
  }
  
  private void q()
  {
    UserLevelInfo localUserLevelInfo = RIJUserLevelModule.getInstance().getUserLevelInfoOrNull(RIJQQAppInterfaceUtil.c());
    if (localUserLevelInfo != null)
    {
      if ((r()) && (localUserLevelInfo.level > 0L))
      {
        u();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkAndAddPublisherEntry, hasPublisherEntryConfig=");
      localStringBuilder.append(r());
      localStringBuilder.append(", level=");
      localStringBuilder.append(localUserLevelInfo.level);
      QLog.i("ReadInJoyDailyViewController", 1, localStringBuilder.toString());
      return;
    }
    QLog.i("ReadInJoyDailyViewController", 1, "userLevelInfo is null, request server");
    RIJUserLevelModule.getInstance().addUserLevelInfoUpdateListener(this.x);
    RIJUserLevelModule.getInstance().requestUserLevel(7, null);
  }
  
  private boolean r()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(469);
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("enable_publisher_entrance", 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  private void u()
  {
    if (this.b != null)
    {
      if (this.b.isFinishing()) {
        return;
      }
      Object localObject = (FrameLayout)this.m.findViewById(2131433609);
      UgcPublishUserGuideController localUgcPublishUserGuideController = new UgcPublishUserGuideController((FrameLayout)localObject, DisplayUtil.a(this.b, 48.0F));
      RIJEntryViewBridge localRIJEntryViewBridge = new RIJEntryViewBridge(this.b, 9);
      localRIJEntryViewBridge.a(new ReadInJoyDailyViewController.2(this, localUgcPublishUserGuideController));
      Bundle localBundle = new Bundle();
      localBundle.putInt("entryStyle", 0);
      localBundle.putInt("bottomMargin", DisplayUtil.a(this.b, 48.0F));
      localBundle.putInt("rightMargin", DisplayUtil.a(this.b, 11.0F));
      localBundle.putInt("width", DisplayUtil.a(this.b, 48.0F));
      localBundle.putInt("height", DisplayUtil.a(this.b, 48.0F));
      localObject = new BizEntryViewController(this.b, localRIJEntryViewBridge, new RIJFloatViewManager((ViewGroup)localObject));
      ((BizEntryViewController)localObject).a(localBundle, null, new ReadInJoyDailyViewController.3(this, (BizEntryViewController)localObject, localUgcPublishUserGuideController));
    }
  }
  
  private int v()
  {
    int i1 = this.p;
    if (i1 != -1) {
      return i1;
    }
    return this.b.getIntent().getIntExtra("channel_id", 0);
  }
  
  private int w()
  {
    int i1 = this.q;
    if (i1 != -1) {
      return i1;
    }
    return this.b.getIntent().getIntExtra("channel_type", 0);
  }
  
  private void x()
  {
    if (t == 2)
    {
      this.n.setCanLoadMore(true);
      return;
    }
    if (this.n.getOverScrollFooterView() == null)
    {
      View localView = LayoutInflater.from(cQ_()).inflate(2131626212, this.n, false);
      this.n.setOverScrollFooter(localView);
      this.n.a(new ReadInJoyDailyOverScrollListener());
    }
  }
  
  private void y()
  {
    ArticleInfoModule localArticleInfoModule = ReadInJoyLogicEngine.a().ab();
    if ((localArticleInfoModule != null) && (!k)) {
      localArticleInfoModule.a(new ReadInJoyDailyViewController.5(this, localArticleInfoModule));
    }
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.m.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.l = paramViewGroup;
  }
  
  public void a(ListView paramListView, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((paramListView != null) && (m() != 2)) {
      b(paramListView, paramReadInJoyBaseAdapter);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.m.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    this.m.a(paramBoolean);
  }
  
  public void b()
  {
    if (this.r) {
      return;
    }
    this.r = true;
    super.b();
    Object localObject = this.m;
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(c(Integer.valueOf(v())), d(Integer.valueOf(v())));
      this.m.b(this.d);
      if (this.l != null)
      {
        localObject = new ViewGroup.LayoutParams(-1, -1);
        this.l.addView(this.m, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void c()
  {
    if (!this.r) {
      return;
    }
    this.r = false;
    super.c();
    Object localObject = this.m;
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(d(Integer.valueOf(v())), b(Integer.valueOf(v())));
      this.m.a(this.d);
      d();
      localObject = this.l;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.m);
      }
    }
  }
  
  public void cT_()
  {
    super.cT_();
    VideoVolumeControl.getInstance().inKandianModule(cQ_());
    this.v = new VideoPlayManager(cQ_());
    t = DailyModeConfigHandler.a();
    this.d.put(Integer.valueOf(v()), Boolean.valueOf(true));
    this.m = new ReadInJoyListViewGroup(this, v(), w(), this.s, null, 2131626211);
    this.n = ((ReadInJoyDailyPullToZoomHeaderXListView)this.m.findViewById(2131446630));
    x();
    y();
    this.o = ((ReadInJoyListViewGroup)this.m).getAdapter();
    this.w = new VideoUIManager((FrameLayout)this.m.findViewById(2131449704), this.n, this.b);
    this.v.a(this.w);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a);
    if (i)
    {
      i = false;
      ReadInJoyLogicEngine.a().w();
    }
    b();
    SneakyCallback.a(8);
    ReadInJoySrtUtils.a().d();
    ReadInJoySrtUtils.a().a(String.valueOf(v()));
    VideoAudioControlUtil.a.a(VideoAudioControlUtil.a.b(), "ENTER_DAILY_FEEDS");
    q();
  }
  
  public void d()
  {
    this.c.clear();
    this.e.clear();
    this.d.clear();
  }
  
  public void e()
  {
    RIJUserLevelModule.getInstance().removeUserLevelInfoUpdateListener(this.x);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.a);
    Object localObject = ReadInJoyLogicEngine.a().ab();
    if (localObject != null) {
      ((ArticleInfoModule)localObject).a(null);
    }
    super.e();
    localObject = this.v;
    if (localObject != null) {
      ((VideoPlayManager)localObject).w();
    }
    VideoVolumeControl.getInstance().outKandianModule(cQ_());
    this.m.f();
    this.o.I();
    VideoAudioControlUtil.a.a(VideoAudioControlUtil.a.b(), "LEAVE_DAILY_FEEDS");
  }
  
  public void f()
  {
    super.f();
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.o;
    if (localReadInJoyBaseAdapter != null) {
      localReadInJoyBaseAdapter.notifyDataSetChanged();
    }
    this.m.d();
    if (!this.u)
    {
      DailyFeedsDiandianEntranceManager.a().b();
      this.u = true;
    }
  }
  
  public void g()
  {
    super.g();
    this.m.e();
  }
  
  public void h()
  {
    super.h();
    VideoPlayManager localVideoPlayManager = this.v;
    if (localVideoPlayManager != null) {
      localVideoPlayManager.z();
    }
    this.m.c();
  }
  
  public void i()
  {
    super.i();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a);
    this.m.b();
    Object localObject1 = this.m;
    if ((localObject1 instanceof ReadInJoyListViewGroup)) {
      localObject1 = ((ReadInJoyListViewGroup)localObject1).getAdapter();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.v;
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((VideoPlayManager)localObject2).a();
      if ((localObject2 != null) && (((VideoPlayParam)localObject2).M)) {
        ((ReadInJoyBaseAdapter)localObject1).P();
      }
    }
    localObject1 = this.v;
    if (localObject1 != null) {
      ((VideoPlayManager)localObject1).d(v());
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a);
    this.m.b();
    localObject1 = this.m;
    if ((localObject1 instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localObject1).k();
    }
  }
  
  public VideoPlayManager j()
  {
    return this.v;
  }
  
  public void k()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.m;
    if ((localReadInJoyBaseListViewGroup != null) && ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      localReadInJoyBaseListViewGroup.a(true, 1);
    }
  }
  
  public ViewGroup l()
  {
    return this.l;
  }
  
  public VafContext n()
  {
    return this.o.F();
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyViewController
 * JD-Core Version:    0.7.0.1
 */