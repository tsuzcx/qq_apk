package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.FirstCommentEvent;
import com.tencent.mobileqq.kandian.biz.comment.TKDCommentFragmentHelper;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.ITKDHippyEventDispatcherOwner;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.TKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class VideoFeedsCommentManager
  implements ListEventListener, ITKDHippyEventDispatcherOwner
{
  private ViewGroup a;
  private BaseActivity b;
  private VideoInfo c;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private ReadInJoyCommentListFragment g = null;
  private IAdapter h = null;
  private VideoFeedsPlayManager i = null;
  private VideoFeedsCommentManager.CommentEventListener j = null;
  private AnimationSet k;
  private TranslateAnimation l;
  private ViewGroup.LayoutParams m;
  private FragmentManager n;
  private boolean o;
  private ITKDHippyEventDispatcher p = new TKDHippyEventDispatcher();
  private int q = 0;
  
  public VideoFeedsCommentManager(BaseActivity paramBaseActivity, FragmentManager paramFragmentManager, VideoFeedsRecyclerView paramVideoFeedsRecyclerView, IAdapter paramIAdapter, VideoFeedsPlayManager paramVideoFeedsPlayManager, ViewGroup paramViewGroup)
  {
    this.b = paramBaseActivity;
    this.n = paramFragmentManager;
    this.a = paramViewGroup;
    if (paramVideoFeedsRecyclerView != null) {
      paramVideoFeedsRecyclerView.a(this);
    }
    this.h = paramIAdapter;
    this.i = paramVideoFeedsPlayManager;
    this.k = ((AnimationSet)AnimationUtils.loadAnimation(this.b, 2130772157));
    paramBaseActivity = this.k;
    if (paramBaseActivity != null)
    {
      paramBaseActivity.setDuration(200L);
      this.k.setInterpolator(new LinearInterpolator());
    }
    this.l = ((TranslateAnimation)AnimationUtils.loadAnimation(this.b, 2130772018));
    paramBaseActivity = this.l;
    if (paramBaseActivity != null)
    {
      paramBaseActivity.setAnimationListener(new VideoFeedsCommentManager.1(this));
      this.l.setDuration(300L);
      this.l.setInterpolator(new LinearInterpolator());
    }
  }
  
  private void q()
  {
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("arg_comment_list_comment_btn", false);
    ((Bundle)localObject).putBoolean("arg_comment_list_share_btn", false);
    ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
    ((Bundle)localObject).putBoolean("readinjoy_open_comment_from_video", true);
    ((Bundle)localObject).putBoolean("is_from_viola", true);
    ((Bundle)localObject).putBoolean("readinjoy_open_comment_with_edit_panel", p());
    this.g = new ReadInJoyCommentListFragment();
    this.g.a(VideoFeedsResourceLoader.a());
    this.g.a(2);
    this.g.a((Bundle)localObject, d(), this.a);
    this.g.b().merge(this.p);
    this.p.clear();
    localObject = this.n.beginTransaction();
    ((FragmentTransaction)localObject).add(2131431115, this.g);
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private boolean r()
  {
    return (this.g != null) && (TKDCommentFragmentHelper.b()) && (this.g.a());
  }
  
  private void s()
  {
    if (!r()) {
      RIJUserLevelModule.getInstance().doActionsByUserLevel(this.b, 1, new VideoFeedsCommentManager.4(this));
    }
  }
  
  private void t()
  {
    try
    {
      this.b.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new VideoFeedsCommentManager.5(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.d("adjustSystemUiVisibility", 1, localException.toString());
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    this.m = this.a.getLayoutParams();
    this.m.height = (VideoFeedsHelper.f(this.b) - this.q);
    this.a.setLayoutParams(this.m);
    this.a.setOnClickListener(null);
    c();
    t();
  }
  
  public void a(int paramInt)
  {
    if (this.g == null) {
      return;
    }
    int i2 = j();
    int i1 = 0;
    if (i2 == 2) {
      i1 = 1;
    }
    RIJTransMergeKanDianReport.a(i1, this.g.n(), paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.g;
    if (localReadInJoyCommentListFragment != null) {
      localReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setVisibility(8);
      if (this.d) {
        this.f = true;
      }
    }
    else if (this.f)
    {
      this.f = false;
      this.a.setVisibility(0);
    }
  }
  
  public void a(AnchorData paramAnchorData)
  {
    if (this.g == null) {
      a();
    }
    if (!this.d)
    {
      Object localObject = this.c;
      if ((localObject != null) && (((VideoInfo)localObject).aB != null))
      {
        if (r())
        {
          this.g.a(this.c.aB);
          this.g.a(paramAnchorData);
          if (p()) {
            this.g.b(true);
          }
        }
        b();
        localObject = this.k;
        if (localObject != null) {
          this.a.startAnimation((Animation)localObject);
        }
        localObject = this.a;
        boolean bool = false;
        VideoFeedsHelper.a((View)localObject, 0, 100);
        localObject = this.c.aB;
        if (this.g == null)
        {
          BaseFragment localBaseFragment = (BaseFragment)this.n.findFragmentById(2131431115);
          if ((localBaseFragment instanceof ReadInJoyCommentListFragment)) {
            this.g = ((ReadInJoyCommentListFragment)localBaseFragment);
          }
        }
        if ((this.g != null) && (localObject != null))
        {
          if (this.c.as == null) {
            bool = true;
          }
          this.g.a((AbsBaseArticleInfo)localObject, paramAnchorData, bool, 2);
        }
        if ((this.i != null) && (NetworkUtil.isWifiConnected(this.b))) {
          this.i.g(true);
        }
        this.d = true;
        paramAnchorData = this.j;
        if (paramAnchorData != null) {
          paramAnchorData.a(true);
        }
        paramAnchorData = this.g;
        if (paramAnchorData != null) {
          paramAnchorData.q();
        }
      }
    }
  }
  
  public void a(VideoFeedsCommentManager.CommentEventListener paramCommentEventListener)
  {
    this.j = paramCommentEventListener;
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.c = paramVideoInfo;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.d)
    {
      Object localObject = this.g;
      if (localObject != null) {
        ((ReadInJoyCommentListFragment)localObject).j();
      }
      if (this.a.getVisibility() == 0) {
        if (paramBoolean)
        {
          this.a.setVisibility(8);
        }
        else
        {
          localObject = this.l;
          if (localObject != null) {
            this.a.startAnimation((Animation)localObject);
          }
        }
      }
      localObject = this.i;
      if (localObject != null) {
        ((VideoFeedsPlayManager)localObject).g(false);
      }
      this.d = false;
      localObject = this.j;
      if (localObject != null) {
        ((VideoFeedsCommentManager.CommentEventListener)localObject).a(false);
      }
      localObject = this.g;
      if (localObject != null) {
        ((ReadInJoyCommentListFragment)localObject).r();
      }
    }
  }
  
  public void b()
  {
    ViewGroup.LayoutParams localLayoutParams = this.m;
    if (localLayoutParams != null)
    {
      localLayoutParams.height = (VideoFeedsHelper.f(this.b) - this.q);
      this.a.setLayoutParams(this.m);
    }
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void c()
  {
    q();
  }
  
  @NotNull
  public ReadInJoyCommentUtils.FirstCommentEvent d()
  {
    return new VideoFeedsCommentManager.2(this);
  }
  
  public void e()
  {
    a(null);
  }
  
  public void f()
  {
    a(false);
  }
  
  public void g()
  {
    VideoInfo localVideoInfo = this.c;
    if ((localVideoInfo != null) && (localVideoInfo.aB != null))
    {
      this.o = true;
      if (this.g == null)
      {
        e();
        this.g.a(new VideoFeedsCommentManager.3(this));
        return;
      }
      e();
      s();
    }
  }
  
  @NonNull
  public ITKDHippyEventDispatcher getTKDHippyEventDispatcher()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.g;
    if (localReadInJoyCommentListFragment != null) {
      return localReadInJoyCommentListFragment.b();
    }
    return this.p;
  }
  
  public void h()
  {
    if (i()) {
      f();
    }
  }
  
  public boolean i()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.g;
    return (localReadInJoyCommentListFragment != null) && (!localReadInJoyCommentListFragment.l());
  }
  
  public int j()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.g;
    if (localReadInJoyCommentListFragment != null) {
      return localReadInJoyCommentListFragment.m();
    }
    return -1;
  }
  
  public boolean k()
  {
    return this.d;
  }
  
  public boolean l()
  {
    return this.c.a(this.b);
  }
  
  public void m()
  {
    TranslateAnimation localTranslateAnimation = this.l;
    if (localTranslateAnimation != null)
    {
      localTranslateAnimation.setAnimationListener(null);
      this.l = null;
    }
    getTKDHippyEventDispatcher().clear();
  }
  
  public VideoInfo n()
  {
    return this.c;
  }
  
  public void o() {}
  
  public boolean p()
  {
    boolean bool = this.o;
    this.o = false;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsCommentManager
 * JD-Core Version:    0.7.0.1
 */