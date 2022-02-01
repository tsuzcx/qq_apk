package com.tencent.mobileqq.flashshow.presenter.feed;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._TVK_PlayerMsg;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.flashshow.bean.FSFeedSelectInfo;
import com.tencent.mobileqq.flashshow.events.FSSeekEvent;
import com.tencent.mobileqq.flashshow.ioc.IFSFeedIoc;
import com.tencent.mobileqq.flashshow.player.widget.FSBaseVideoView.InitListener;
import com.tencent.mobileqq.flashshow.player.widget.FSVideoView;
import com.tencent.mobileqq.flashshow.presenter.feed.event.FSBaseFeedPresenterEvent;
import com.tencent.mobileqq.flashshow.presenter.feed.event.FSDoubleViewClickEvent;
import com.tencent.mobileqq.flashshow.presenter.feed.event.FSVideoProgressChangeEvent;
import com.tencent.mobileqq.flashshow.presenter.feed.event.FSVideoStatusEvent;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.utils.DateUtils;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.util.EventControlUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StUser;
import feedcloud.FeedCloudMeta.StVideo;
import java.util.concurrent.ConcurrentHashMap;

public class FSFeedChildVideoPresenter
  extends FSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
{
  private FSVideoView f;
  private ImageView g;
  private SeekBar h;
  private View i;
  private FrameLayout j;
  private LinearLayout k;
  private TextView l;
  private TextView m;
  private ImageView n;
  private int o;
  private int p;
  private ConcurrentHashMap<String, Long> q = new ConcurrentHashMap();
  private boolean r = true;
  private FSVideoProgressChangeEvent s = null;
  
  private FSBaseVideoView.InitListener a(String paramString)
  {
    return new FSFeedChildVideoPresenter.2(this, paramString);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt2 == this.o) && (this.p == paramInt1)) {
      return;
    }
    Long localLong = (Long)this.q.get(paramString);
    if (localLong != null)
    {
      long l1 = paramInt1;
      if ((l1 == localLong.longValue()) || (Math.abs(l1 - localLong.longValue()) <= 100L)) {}
    }
    else
    {
      this.q.put(paramString, Long.valueOf(paramInt2));
    }
    this.o = paramInt2;
    this.p = paramInt1;
    if (this.s == null) {
      this.s = new FSVideoProgressChangeEvent();
    }
    this.s.b(paramInt1);
    this.s.a(paramInt2);
    b(this.s);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 0) && (paramInt1 != 0))
    {
      int i1 = ImmersiveUtils.getScreenWidth();
      int i2 = -1;
      if ((paramInt1 == -1) && (paramInt2 == -1)) {
        i1 = -1;
      } else {
        i2 = (int)(i1 / paramInt1 * paramInt2);
      }
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)paramView.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new FrameLayout.LayoutParams(i1, i2);
      }
      localLayoutParams1.width = i1;
      localLayoutParams1.height = i2;
      localLayoutParams1.gravity = 17;
      paramView.setLayoutParams(localLayoutParams1);
      paramView = new StringBuilder();
      paramView.append("setSize origin:");
      paramView.append(paramInt1);
      paramView.append("|");
      paramView.append(paramInt2);
      paramView.append(" target:");
      paramView.append(i1);
      paramView.append("|");
      paramView.append(i2);
      paramView.append("|");
      paramView.append(hashCode());
      QLog.d("FSFeedChildVideoPresenter", 1, paramView.toString());
      return;
    }
    QLog.d("FSFeedChildVideoPresenter", 1, "setSize origin size zero");
  }
  
  private void a(SeekBar paramSeekBar)
  {
    if (this.a != null) {
      this.a.a("event_set_viewpager_enable", new Object[] { Boolean.valueOf(true) });
    }
    this.k.setVisibility(8);
    paramSeekBar.getLayoutParams().height = ImmersiveUtils.dpToPx(1.0F);
    paramSeekBar.requestLayout();
    SimpleEventBus.getInstance().dispatchEvent(new FSSeekEvent(((FeedCloudMeta.StFeed)this.b).id.get(), false));
  }
  
  private void a(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    paramSeekBar = this.m;
    if ((paramSeekBar != null) && (paramBoolean))
    {
      RFWTypefaceUtil.a(paramSeekBar, false);
      paramSeekBar = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(DateUtils.a(paramInt));
      localStringBuilder.append(" / ");
      paramSeekBar.setText(localStringBuilder.toString());
    }
  }
  
  private void a(ISuperPlayer paramISuperPlayer)
  {
    if (!m()) {
      return;
    }
    if (this.f != null)
    {
      if (this.b == null) {
        return;
      }
      if (FSCommonUtil.b(((FeedCloudMeta.StFeed)this.b).video.width.get(), ((FeedCloudMeta.StFeed)this.b).video.height.get())) {
        paramISuperPlayer.setXYaxis(QCircleHostConstants._TVK_PlayerMsg.PLAYER_SCALE_Y_FULLSCREEN());
      } else {
        paramISuperPlayer.setXYaxis(QCircleHostConstants._TVK_PlayerMsg.PLAYER_SCALE_ORIGINAL_FULLSCREEN());
      }
      this.f.i();
      QLog.d("FSFeedChildVideoPresenter", 1, "doOnVideoPrepare start play");
      RFThreadManager.getUIHandler().post(new FSFeedChildVideoPresenter.3(this, paramISuperPlayer));
    }
  }
  
  private void b(SeekBar paramSeekBar)
  {
    if (this.a != null) {
      this.a.a("event_set_viewpager_enable", new Object[] { Boolean.valueOf(true) });
    }
    this.k.setVisibility(0);
    paramSeekBar.getLayoutParams().height = ImmersiveUtils.dpToPx(4.0F);
    paramSeekBar.requestLayout();
    SimpleEventBus.getInstance().dispatchEvent(new FSSeekEvent(((FeedCloudMeta.StFeed)this.b).id.get(), true));
  }
  
  private void b(String paramString)
  {
    if (this.b != null)
    {
      if (!((FeedCloudMeta.StFeed)this.b).id.get().equals(paramString)) {
        return;
      }
      paramString = this.f;
      if (paramString != null)
      {
        if (paramString.getSuperPlayer() == null) {
          return;
        }
        if (this.f.getSuperPlayer().isPlaying())
        {
          p();
          return;
        }
        if (this.f.getSuperPlayer().isPausing()) {
          q();
        }
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (k()) {
      return;
    }
    if (this.f.getSuperPlayer() == null)
    {
      c(paramBoolean);
      return;
    }
    if (!this.f.getSuperPlayer().isPlaying())
    {
      if (this.f.getSuperPlayer().isPausing()) {
        return;
      }
      c(paramBoolean);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.b;
    this.f.setData(localStFeed, this.c);
    Object localObject = FSCommonUtil.c(localStFeed.video.playUrl.get());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startANewPlayer playUrlKey:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" | ");
    localStringBuilder.append(this.q.containsKey(localObject));
    localStringBuilder.append(" | ");
    localStringBuilder.append(hashCode());
    QLog.d("FSFeedChildVideoPresenter", 1, localStringBuilder.toString());
    long l1;
    if ((paramBoolean) && (this.q.containsKey(localObject))) {
      l1 = ((Long)this.q.get(localObject)).longValue();
    } else {
      l1 = 0L;
    }
    localObject = a((String)localObject);
    this.f.setInitListener((FSBaseVideoView.InitListener)localObject);
    this.f.setVideoPath(localStFeed.video, (int)l1);
    this.n.setVisibility(8);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.g.setVisibility(8);
      this.h.setVisibility(0);
      return;
    }
    this.g.setVisibility(0);
    this.h.setVisibility(8);
  }
  
  private void g()
  {
    this.p = 0;
    this.o = 0;
  }
  
  private void h()
  {
    int i1 = ((FeedCloudMeta.StFeed)this.b).video.width.get();
    int i2 = ((FeedCloudMeta.StFeed)this.b).video.height.get();
    if (FSCommonUtil.a(i1, i2))
    {
      a(this.g, -1, -1);
      a(this.f, -1, -1);
      return;
    }
    if (FSCommonUtil.b(i1, i2))
    {
      a(this.g, -1, -1);
      a(this.f, -1, -1);
      return;
    }
    a(this.g, i1, i2);
    a(this.f, i1, i2);
  }
  
  private void i()
  {
    if (this.g == null) {
      return;
    }
    Object localObject = (FeedCloudMeta.StFeed)this.b;
    if (TextUtils.isEmpty(((FeedCloudMeta.StFeed)localObject).cover.layerPicUrl.get())) {
      localObject = new Option().setUrl(((FeedCloudMeta.StFeed)localObject).cover.picUrl.get()).setTargetView(this.g);
    } else {
      localObject = new Option().setUrl(((FeedCloudMeta.StFeed)localObject).cover.layerPicUrl.get()).setTargetView(this.g);
    }
    QCircleFeedPicLoader.g().loadImage((Option)localObject, null);
  }
  
  private void j()
  {
    this.f.setLoadingView(this.i);
    this.f.setProgressBar(this.h);
    this.j.setOnTouchListener(new FSFeedChildVideoPresenter.1(this));
  }
  
  private boolean k()
  {
    if ((this.a != null) && (m()) && (this.f != null)) {
      return false;
    }
    QLog.d("FSFeedChildVideoPresenter", 1, "mFeedIoc == null");
    return true;
  }
  
  private void l()
  {
    if (k()) {
      return;
    }
    QLog.d("FSFeedChildVideoPresenter", 1, "executeFromSelected");
    c(false);
  }
  
  private boolean m()
  {
    int i1 = this.a.b();
    int i2 = this.a.f();
    int i3 = this.a.cr_();
    boolean bool;
    if (ASInject.g().getAsEngineDelegate() != null) {
      bool = ASInject.g().getAsEngineDelegate().isOnThirdTab("flash-show-app");
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentFeedPos:");
    localStringBuilder.append(i1);
    localStringBuilder.append(" | mPos:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" | currentSelectedTab:");
    localStringBuilder.append(i2);
    localStringBuilder.append(" | currentTabIndex:");
    localStringBuilder.append(i3);
    localStringBuilder.append(" | isOnThirdTab:");
    localStringBuilder.append(bool);
    localStringBuilder.append("pageId:");
    localStringBuilder.append(d());
    localStringBuilder.append(" | mIsOnResume");
    localStringBuilder.append(this.r);
    localStringBuilder.append(" | ");
    localStringBuilder.append(hashCode());
    QLog.d("FSFeedChildVideoPresenter", 1, localStringBuilder.toString());
    return (i1 == this.c) && (i2 == i3) && (this.r);
  }
  
  private boolean n()
  {
    return false;
  }
  
  private void o()
  {
    FSVideoView localFSVideoView = this.f;
    if (localFSVideoView == null) {
      return;
    }
    localFSVideoView.release();
    d(false);
  }
  
  private void p()
  {
    FSVideoView localFSVideoView = this.f;
    if (localFSVideoView != null)
    {
      if (localFSVideoView.getSuperPlayer() == null) {
        return;
      }
      if (this.f.getSuperPlayer().isPlaying())
      {
        this.f.j();
        b(new FSVideoStatusEvent(true));
        this.n.setVisibility(0);
      }
    }
  }
  
  private void q()
  {
    FSVideoView localFSVideoView = this.f;
    if (localFSVideoView != null)
    {
      if (localFSVideoView.getSuperPlayer() == null) {
        return;
      }
      if (this.f.getSuperPlayer().isPausing())
      {
        this.f.i();
        b(new FSVideoStatusEvent(false));
        this.n.setVisibility(8);
      }
    }
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    a(false);
    this.f = ((FSVideoView)paramView.findViewById(2131433405));
    this.h = ((SeekBar)paramView.findViewById(2131433386));
    this.i = paramView.findViewById(2131433403);
    this.j = ((FrameLayout)paramView.findViewById(2131433326));
    this.k = ((LinearLayout)paramView.findViewById(2131433376));
    this.l = ((TextView)paramView.findViewById(2131433399));
    this.m = ((TextView)paramView.findViewById(2131433398));
    this.g = ((ImageView)paramView.findViewById(2131433367));
    this.n = ((ImageView)paramView.findViewById(2131433371));
    j();
  }
  
  public void a(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    super.a(paramFSFeedSelectInfo);
    this.r = true;
    if (this.f == null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResumed:");
      localStringBuilder.append(paramFSFeedSelectInfo);
      localStringBuilder.append(" | mPos:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" | ");
      localStringBuilder.append(hashCode());
      localStringBuilder.append("|playView is null");
      QLog.d("FSFeedChildVideoPresenter", 1, localStringBuilder.toString());
      return;
    }
    if (paramFSFeedSelectInfo == null) {
      return;
    }
    if (this.c == paramFSFeedSelectInfo.b())
    {
      f();
      b(true);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResumed:");
    localStringBuilder.append(paramFSFeedSelectInfo);
    localStringBuilder.append(" | mPos:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" | ");
    localStringBuilder.append(hashCode());
    QLog.d("FSFeedChildVideoPresenter", 1, localStringBuilder.toString());
  }
  
  protected void a(FSBaseFeedPresenterEvent paramFSBaseFeedPresenterEvent)
  {
    super.a(paramFSBaseFeedPresenterEvent);
    if ((paramFSBaseFeedPresenterEvent instanceof FSDoubleViewClickEvent)) {
      b(((FSDoubleViewClickEvent)paramFSBaseFeedPresenterEvent).a());
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.b;
    super.a(paramStFeed, paramInt);
    if (FSCommonUtil.a(paramStFeed, localStFeed)) {
      return;
    }
    if (paramStFeed == null)
    {
      paramStFeed = new StringBuilder();
      paramStFeed.append("onBindData is null: ");
      paramStFeed.append(paramInt);
      QLog.d("FSFeedChildVideoPresenter", 1, paramStFeed.toString());
      return;
    }
    g();
    this.n.setVisibility(8);
    h();
    i();
    d(false);
  }
  
  public void b()
  {
    super.b();
  }
  
  public void c()
  {
    super.c();
    o();
  }
  
  public void c(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    super.c(paramFSFeedSelectInfo);
    this.r = false;
    o();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStop:");
    localStringBuilder.append(paramFSFeedSelectInfo);
    localStringBuilder.append(" |  | mPos:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(hashCode());
    localStringBuilder.append("|playView is null");
    QLog.d("FSFeedChildVideoPresenter", 1, localStringBuilder.toString());
  }
  
  public void d(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    if (paramFSFeedSelectInfo == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSelected:");
    localStringBuilder.append(paramFSFeedSelectInfo);
    localStringBuilder.append(" | mPos:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" | ");
    localStringBuilder.append(hashCode());
    QLog.d("FSFeedChildVideoPresenter", 1, localStringBuilder.toString());
    if (paramFSFeedSelectInfo.b() != this.c) {
      return;
    }
    l();
    f();
  }
  
  public void e(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    if (paramFSFeedSelectInfo == null) {
      return;
    }
    if (paramFSFeedSelectInfo.b() != this.c) {
      return;
    }
    if (paramFSFeedSelectInfo.a() == 1) {
      this.c = -1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUnSelected:");
    localStringBuilder.append(paramFSFeedSelectInfo);
    localStringBuilder.append(" | mPos:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" | ");
    localStringBuilder.append(hashCode());
    QLog.d("FSFeedChildVideoPresenter", 1, localStringBuilder.toString());
    o();
  }
  
  public void f()
  {
    if (!m()) {
      return;
    }
    if (!EventControlUtils.a("FSFeedChildVideoPresenterreportExpose", 200L)) {
      return;
    }
    Object localObject = (FeedCloudMeta.StFeed)this.b;
    if (localObject != null)
    {
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder((FeedCloudMeta.StFeed)localObject, e()).a(1).b(1).a(((FeedCloudMeta.StFeed)localObject).poster.id.get()).g(this.c).f(2).a(true));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportExpose:");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" | ");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("FSFeedChildVideoPresenter", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildVideoPresenter
 * JD-Core Version:    0.7.0.1
 */