package com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListFragment;
import com.tencent.mobileqq.kandian.biz.comment.TKDCommentFragmentHelper;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.videonew.VVideoView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Random;
import org.json.JSONObject;

public class ViolaCommentManager
{
  private ViewGroup a;
  private View b;
  private QBaseActivity c;
  private boolean d = false;
  private ReadInJoyCommentListFragment e = null;
  private ViolaCommentManager.CommentEventListener f = null;
  private ViewGroup.LayoutParams g;
  private FragmentManager h;
  private FrameLayout i;
  @Nullable
  private VVideoView j;
  @Nullable
  private View k;
  private ViewGroup l;
  private ViewGroup.LayoutParams m;
  private boolean n = false;
  private int[] o;
  private int[] p;
  private int q;
  private int[] r;
  private int s;
  private int t;
  private int u = 0;
  private boolean v;
  private int w;
  private JSONObject x;
  private final ITKDHippyEventReceiver y;
  
  public ViolaCommentManager(QBaseActivity paramQBaseActivity, FragmentManager paramFragmentManager, int paramInt, ViewGroup paramViewGroup, TopGestureLayout paramTopGestureLayout, JSONObject paramJSONObject)
  {
    int i1;
    if (LiuHaiUtils.b()) {
      i1 = ImmersiveUtils.getStatusBarHeight(this.c);
    } else {
      i1 = 0;
    }
    this.w = i1;
    this.y = new ViolaCommentManager.11(this);
    this.s = paramInt;
    this.c = paramQBaseActivity;
    this.h = paramFragmentManager;
    paramFragmentManager = VideoFeedsHelper.c(this.c);
    boolean bool = true;
    this.t = (paramFragmentManager[1] / 3);
    this.i = new FrameLayout(paramQBaseActivity);
    this.b = new View(paramQBaseActivity);
    this.b.setId(2131429234);
    this.i.addView(this.b, -1, -1);
    this.a = new FrameLayout(paramQBaseActivity);
    if (Build.VERSION.SDK_INT >= 17) {
      this.a.setId(View.generateViewId());
    } else {
      this.a.setId(new Random().nextInt());
    }
    this.i.addView(this.a, -1, -2);
    ((FrameLayout.LayoutParams)this.a.getLayoutParams()).gravity = 80;
    this.a.setVisibility(0);
    if (paramTopGestureLayout != null) {
      paramTopGestureLayout.addView(this.i, -1, -1);
    } else {
      paramTopGestureLayout = this.i;
    }
    if (paramViewGroup != null) {
      paramViewGroup.addView(paramTopGestureLayout, -1, -1);
    } else {
      this.c.getWindow().addContentView(paramTopGestureLayout, new WindowManager.LayoutParams(-1, -1));
    }
    if (paramJSONObject.optInt("directComment") != 1) {
      bool = false;
    }
    this.v = bool;
    this.x = paramJSONObject;
    a();
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      if (this.o == null) {
        this.o = new int[2];
      }
      paramView.getLocationInWindow(this.o);
    }
  }
  
  private void a(VVideoView paramVVideoView, View paramView)
  {
    this.a.clearAnimation();
    this.a.setVisibility(8);
    this.b.clearAnimation();
    this.b.setVisibility(8);
    b(paramVVideoView, paramView);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    paramVVideoView = this.l;
    if (paramVVideoView != null) {
      paramVVideoView.addView(paramView, this.q, this.m);
    }
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = null;
    this.o = null;
    this.p = null;
  }
  
  private void a(VVideoView paramVVideoView, View paramView, int paramInt)
  {
    this.j = paramVVideoView;
    this.b.setBackgroundDrawable(new ColorDrawable(paramInt));
    this.a.setVisibility(8);
    this.b.setVisibility(8);
    VideoFeedsHelper.b(this.b, 0, 300);
    VideoFeedsHelper.a(this.a, 0, 300);
    int[] arrayOfInt1 = VideoFeedsHelper.c(this.c);
    int i1;
    int i2;
    if (paramView != null)
    {
      this.k = paramView;
      this.l = ((ViewGroup)paramView.getParent());
      this.q = this.l.indexOfChild(paramView);
      this.m = paramView.getLayoutParams();
      a(paramView);
      int[] arrayOfInt2;
      if (this.u == 0)
      {
        arrayOfInt2 = this.o;
        arrayOfInt2[1] -= this.s;
      }
      this.p = new int[] { paramView.getWidth(), paramView.getHeight() };
      b(paramVVideoView, paramView);
      int i3;
      if (this.u == 1)
      {
        k();
        paramInt = this.t;
        i1 = (int)(paramView.getWidth() / paramView.getHeight() * paramInt);
        i2 = (arrayOfInt1[0] - i1) / 2;
        i3 = this.w;
        this.i.addView(paramView, 1, new FrameLayout.LayoutParams(paramView.getWidth(), paramView.getHeight()));
        paramView.addOnLayoutChangeListener(new ViolaCommentManager.2(this, paramVVideoView, paramView, new int[] { i2, i3 }, i1, paramInt));
      }
      else
      {
        paramInt = VideoFeedsHelper.c(this.c)[0];
        i1 = (int)(paramView.getHeight() / paramView.getWidth() * paramInt);
        this.i.addView(paramView, 1, new FrameLayout.LayoutParams(-1, i1));
        VideoFeedsHelper.a(paramView, this.o, this.p, new int[] { 0, this.w }, new int[] { paramInt, i1 }, 300L, true);
        paramVVideoView = this.a;
        paramInt = this.o[1];
        i1 = this.p[1];
        arrayOfInt1 = this.r;
        i2 = VideoFeedsHelper.c(this.c)[1];
        arrayOfInt2 = this.r;
        i3 = arrayOfInt2[1];
        VideoFeedsHelper.a(paramVVideoView, new int[] { 0, paramInt + i1 }, arrayOfInt1, new int[] { 0, i2 - i3 }, arrayOfInt2, 300L, true);
        paramView.addOnLayoutChangeListener(new ViolaCommentManager.3(this));
      }
    }
    else
    {
      paramVVideoView = this.a;
      paramInt = VideoFeedsHelper.c(this.c)[1];
      paramView = this.r;
      i1 = VideoFeedsHelper.c(this.c)[1];
      arrayOfInt1 = this.r;
      i2 = arrayOfInt1[1];
      VideoFeedsHelper.a(paramVVideoView, new int[] { 0, paramInt }, paramView, new int[] { 0, i1 - i2 }, arrayOfInt1, 300L, true);
    }
    paramVVideoView = this.e;
    if (paramVVideoView != null) {
      paramVVideoView.q();
    }
  }
  
  private void a(VVideoView paramVVideoView, View paramView, boolean paramBoolean)
  {
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    if (this.n) {
      VideoFeedsHelper.b(this.b, 8, 0);
    } else {
      VideoFeedsHelper.b(this.b, 8, 300);
    }
    VideoFeedsHelper.a(this.a, 8, 300);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.a.getWidth();
    arrayOfInt[1] = this.a.getHeight();
    Object localObject;
    if ((!paramBoolean) && (paramView != null))
    {
      localObject = new int[2];
      localObject[0] = 0;
      localObject[1] = (this.o[1] + this.p[1]);
    }
    else
    {
      localObject = new int[2];
      localObject[0] = 0;
      localObject[1] = VideoFeedsHelper.c(this.c)[1];
    }
    if (!paramBoolean) {
      VideoFeedsHelper.a(this.a, new int[] { 0, VideoFeedsHelper.c(this.c)[1] - this.a.getHeight() }, arrayOfInt, (int[])localObject, arrayOfInt, 300L, true);
    }
    if (paramView != null)
    {
      if (this.n)
      {
        b(paramVVideoView, paramView);
        localObject = this.l;
        if (localObject != null) {
          ((ViewGroup)localObject).addView(paramView, this.q, paramView.getLayoutParams());
        }
      }
      int i1;
      int i2;
      int i3;
      if (this.u == 1)
      {
        localObject = new int[2];
        paramView.getLocationInWindow((int[])localObject);
        i1 = localObject[0];
        i2 = localObject[1];
        i3 = (int)(paramView.getWidth() * paramView.getScaleX());
        int i4 = (int)(paramView.getHeight() * paramView.getScaleY());
        localObject = this.o;
        arrayOfInt = this.p;
        localObject = VideoFeedsHelper.a(paramView, new int[] { i1, i2 }, new int[] { i3, i4 }, (int[])localObject, arrayOfInt, 300L, false);
        ((Animator)localObject).addListener(new ViolaCommentManager.4(this, paramVVideoView, paramView));
        ((Animator)localObject).start();
      }
      else
      {
        i1 = this.w;
        i2 = paramView.getWidth();
        i3 = paramView.getHeight();
        localObject = this.o;
        arrayOfInt = this.p;
        localObject = VideoFeedsHelper.a(paramView, new int[] { 0, i1 }, new int[] { i2, i3 }, (int[])localObject, arrayOfInt, 300L, false);
        ((Animator)localObject).addListener(new ViolaCommentManager.5(this, paramVVideoView, paramView));
        ((Animator)localObject).start();
      }
    }
    else
    {
      this.j = null;
    }
    paramVVideoView = this.e;
    if (paramVVideoView != null) {
      paramVVideoView.r();
    }
  }
  
  private void b(VVideoView paramVVideoView, View paramView)
  {
    if (paramVVideoView != null) {
      paramVVideoView.b();
    }
    if ((paramView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    if (paramVVideoView != null) {
      paramVVideoView.c();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    this.v = false;
    this.e.j();
    if (this.d)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hideFirstCommentList: isSlideDown=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("ViolaCommentManager", 2, ((StringBuilder)localObject).toString());
      }
      this.d = false;
      if (this.j == null)
      {
        localObject = this.k;
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewWithTag("VVideoView");
          if ((localObject instanceof VVideoView)) {
            this.j = ((VVideoView)localObject);
          }
        }
      }
      a(this.j, this.k, paramBoolean);
      Object localObject = this.f;
      if (localObject != null) {
        ((ViolaCommentManager.CommentEventListener)localObject).a(false);
      }
    }
  }
  
  private void i()
  {
    try
    {
      this.a.setPadding(0, 0, 0, 0);
      int i1;
      if ((ScreenUtil.checkDeviceHasNavigationBar(this.c.getApplicationContext())) && (j()))
      {
        i1 = ScreenUtil.getNavigationBarHeight(this.c.getApplicationContext());
        this.a.setPadding(0, 0, 0, i1);
      }
      if (CommonSuspensionGestureLayout.c(this.c))
      {
        if (this.s != 0)
        {
          i1 = ScreenUtil.getNavigationBarHeight(this.c.getApplicationContext());
          this.a.setPadding(0, 0, 0, i1 + this.s);
        }
      }
      else
      {
        if (this.s == 0)
        {
          this.a.post(new ViolaCommentManager.1(this));
          return;
        }
        if ((!CommonSuspensionGestureLayout.c(this.c)) && (this.s != 0))
        {
          this.a.setPadding(0, 0, 0, this.s);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d("ViolaCommentManager", 1, "setCommentPadding");
      localException.printStackTrace();
    }
  }
  
  private boolean j()
  {
    boolean bool = ScreenUtil.checkNavigationBarShow(this.c.getApplicationContext());
    if (bool) {
      for (ViewParent localViewParent = this.a.getParent(); (localViewParent instanceof View); localViewParent = localViewParent.getParent()) {
        if ((((View)localViewParent).getSystemUiVisibility() & 0x2) > 0) {
          return false;
        }
      }
    }
    return bool;
  }
  
  private void k()
  {
    this.b.setOnClickListener(new ViolaCommentManager.6(this));
  }
  
  private boolean l()
  {
    return (this.e != null) && (TKDCommentFragmentHelper.b()) && (this.e.a());
  }
  
  private void m()
  {
    VideoFeedsHelper.a(new ViolaCommentManager.8(this));
  }
  
  private void n()
  {
    if (this.e == null)
    {
      Fragment localFragment = this.h.findFragmentById(this.a.getId());
      if ((localFragment instanceof ReadInJoyCommentListFragment)) {
        this.e = ((ReadInJoyCommentListFragment)localFragment);
      }
    }
  }
  
  private void o()
  {
    if ((this.e != null) && (!l())) {
      this.e.i();
    }
  }
  
  public void a()
  {
    this.g = this.a.getLayoutParams();
    this.g.height = VideoFeedsHelper.f(this.c);
    this.a.setLayoutParams(this.g);
    b();
    this.r = new int[] { VideoFeedsHelper.c(this.c)[0], this.g.height };
  }
  
  public void a(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.e;
    if (localReadInJoyCommentListFragment != null) {
      localReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    if (this.g != null)
    {
      int i1 = 0;
      if (paramView != null) {
        i1 = (int)(paramView.getHeight() / paramView.getWidth() * VideoFeedsHelper.c(this.c)[0]);
      }
      if (this.u == 1) {
        this.g.height = (VideoFeedsHelper.c(this.c)[1] - this.t - this.w);
      } else {
        this.g.height = ((int)(VideoFeedsHelper.c(this.c)[1] - i1 - paramFloat - this.w));
      }
      this.r[1] = this.g.height;
      this.a.setLayoutParams(this.g);
    }
  }
  
  public void a(VVideoView paramVVideoView, View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    n();
    if (l())
    {
      this.e.a(paramAbsBaseArticleInfo);
      this.e.a(paramAnchorData);
      if (g()) {
        this.e.b(true);
      }
    }
    i();
    if ((this.a.getWidth() > 0) && (this.a.getHeight() == this.r[1]))
    {
      if ((!this.d) && (paramAbsBaseArticleInfo != null))
      {
        QLog.d("ViolaCommentManager", 1, "showCommentList: ");
        n();
        ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.e;
        if (localReadInJoyCommentListFragment != null) {
          localReadInJoyCommentListFragment.a(paramAbsBaseArticleInfo, paramAnchorData, true, 2);
        }
        this.d = true;
        a(paramVVideoView, paramView, paramInt);
        paramVVideoView = this.f;
        if (paramVVideoView != null) {
          paramVVideoView.a(true);
        }
      }
    }
    else
    {
      this.a.setVisibility(4);
      this.a.addOnLayoutChangeListener(new ViolaCommentManager.9(this, paramVVideoView, paramView, paramAbsBaseArticleInfo, paramAnchorData, paramInt));
    }
  }
  
  public void a(ViolaCommentManager.CommentEventListener paramCommentEventListener)
  {
    this.f = paramCommentEventListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void b()
  {
    if (this.e == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_is_fragment_container", true);
      ((Bundle)localObject).putBoolean("arg_comment_list_comment_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_share_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_from_video", true);
      ((Bundle)localObject).putBoolean("is_from_viola", true);
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_with_edit_panel", g());
      this.e = new ReadInJoyCommentListFragment();
      JSONObject localJSONObject = this.x;
      if ((localJSONObject != null) && (localJSONObject.has("rowkey"))) {
        this.e.a(ViolaBizUtils.d(this.x));
      }
      this.e.a(2);
      this.e.b().register(this.y);
      this.e.a((Bundle)localObject, new ViolaCommentManager.7(this), this.a);
      localObject = this.h.beginTransaction();
      ((FragmentTransaction)localObject).add(this.a.getId(), this.e);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  public void b(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void b(VVideoView paramVVideoView, View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaCommentManager", 2, "openWriteCommentComponent: ");
      }
      this.v = true;
      if (this.e == null)
      {
        a(paramVVideoView, paramView, paramAbsBaseArticleInfo, paramAnchorData, paramInt);
        this.e.a(new ViolaCommentManager.10(this));
        return;
      }
      a(paramVVideoView, paramView, paramAbsBaseArticleInfo, paramAnchorData, paramInt);
      o();
    }
  }
  
  public void c()
  {
    if (this.e != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaCommentManager", 2, "hideCommentList: ");
      }
      c(4);
      this.e.l();
      b(false);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.e == null) {
      return;
    }
    int i2 = e();
    int i1 = 0;
    if (i2 == 2) {
      i1 = 1;
    }
    RIJTransMergeKanDianReport.a(i1, this.e.n(), paramInt);
  }
  
  public boolean d()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.e;
    if ((localReadInJoyCommentListFragment != null) && (!localReadInJoyCommentListFragment.l()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaCommentManager", 2, "onBackPress: ");
      }
      b(false);
      return true;
    }
    return false;
  }
  
  public int e()
  {
    ReadInJoyCommentListFragment localReadInJoyCommentListFragment = this.e;
    if (localReadInJoyCommentListFragment != null) {
      return localReadInJoyCommentListFragment.m();
    }
    return -1;
  }
  
  public boolean f()
  {
    return this.d;
  }
  
  public boolean g()
  {
    boolean bool = this.v;
    this.v = false;
    return bool;
  }
  
  public void h()
  {
    QLog.d("ViolaCommentManager", 1, "destory");
    try
    {
      FragmentTransaction localFragmentTransaction = this.h.beginTransaction();
      localFragmentTransaction.remove(this.e);
      localFragmentTransaction.commitAllowingStateLoss();
      if ((this.i.getParent() instanceof ViewGroup))
      {
        ((ViewGroup)this.i.getParent()).removeView(this.i);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaCommentManager", 2, "destroy: ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.topicvideo.ViolaCommentManager
 * JD-Core Version:    0.7.0.1
 */