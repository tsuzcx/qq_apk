package com.tencent.mobileqq.hotpic;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class HotPicPageView$MyVideoViewHolder
  extends HotPicPageView.MyViewHolder
  implements URLDrawable.DownloadListener, HotVideoMongoliaRelativeLayout.OnVideoControlStateListener
{
  WeakReference<HotVideoData> a;
  RelativeLayout b;
  RelativeLayout c;
  RelativeLayout d;
  TextView e;
  TextView f;
  ImageView g;
  ImageView h;
  TextView i;
  View j;
  TextView k;
  ImageView l;
  public boolean m = false;
  public int n = -10;
  
  public HotPicPageView$MyVideoViewHolder(HotPicPageView paramHotPicPageView, View paramView, OnHolderItemClickListener paramOnHolderItemClickListener)
  {
    super(paramHotPicPageView, paramView, paramOnHolderItemClickListener);
    if (this.itemView != null) {
      this.itemView.setOnTouchListener(null);
    }
    this.c = ((RelativeLayout)paramView.findViewById(2131435177));
    this.d = ((RelativeLayout)paramView.findViewById(2131435183));
    this.b = ((RelativeLayout)paramView.findViewById(2131435182));
    this.e = ((TextView)paramView.findViewById(2131449731));
    this.f = ((TextView)paramView.findViewById(2131449737));
    this.g = ((ImageView)paramView.findViewById(2131449652));
    this.i = ((TextView)paramView.findViewById(2131440602));
    this.k = ((TextView)paramView.findViewById(2131449663));
    this.l = ((ImageView)paramView.findViewById(2131449732));
    this.j = paramView.findViewById(2131430725);
    this.h = ((ImageView)paramView.findViewById(2131449511));
  }
  
  public HotVideoData a()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference == null) {
      return null;
    }
    return (HotVideoData)localWeakReference.get();
  }
  
  public void a(int paramInt)
  {
    if (HotPicPageView.p())
    {
      b(paramInt);
      return;
    }
    ThreadManager.getUIHandler().post(new HotPicPageView.MyVideoViewHolder.2(this, paramInt));
  }
  
  public void a(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (HotPicPageView.p())
      {
        this.q.setImageDrawable(paramDrawable);
        return;
      }
      ThreadManager.getUIHandler().post(new HotPicPageView.MyVideoViewHolder.1(this, paramDrawable));
    }
  }
  
  public void a(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null)
    {
      this.a = null;
      return;
    }
    this.a = new WeakReference(paramHotVideoData);
  }
  
  public void a(String paramString)
  {
    if (HotPicPageView.p())
    {
      this.i.setText(paramString);
      return;
    }
    ThreadManager.getUIHandler().post(new HotPicPageView.MyVideoViewHolder.6(this, paramString));
  }
  
  public HotVideoMongoliaRelativeLayout b()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((RelativeLayout)localObject).getChildCount() == 0) {
        return null;
      }
      localObject = this.b.findViewWithTag("HotVideoControlTag");
      if (localObject == null) {
        return null;
      }
      if ((localObject instanceof HotVideoMongoliaRelativeLayout)) {
        return (HotVideoMongoliaRelativeLayout)localObject;
      }
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.n) {
      return;
    }
    e();
    Object localObject;
    if (paramInt != -11)
    {
      if (paramInt != -10)
      {
        switch (paramInt)
        {
        default: 
          break;
        case 6: 
          this.q.setVisibility(8);
          this.e.setVisibility(8);
          this.f.setVisibility(8);
          this.l.setVisibility(8);
          this.g.setVisibility(8);
          this.i.setVisibility(8);
          this.j.setVisibility(8);
          this.itemView.setContentDescription(HardCodeUtil.a(2131903583));
          break;
        case 5: 
          this.q.setVisibility(8);
          this.e.setVisibility(8);
          this.f.setVisibility(8);
          this.l.setVisibility(8);
          this.g.setVisibility(8);
          this.i.setVisibility(8);
          this.j.setVisibility(8);
          this.itemView.setContentDescription(HardCodeUtil.a(2131903582));
          break;
        case 4: 
          this.q.setVisibility(8);
          this.e.setVisibility(0);
          this.f.setVisibility(8);
          this.l.setVisibility(8);
          this.g.setVisibility(0);
          this.i.setVisibility(0);
          this.j.setVisibility(8);
          this.itemView.setContentDescription(HardCodeUtil.a(2131903581));
          d();
          break;
        case 3: 
          if (this.q.getVisibility() == 0)
          {
            int i1 = this.n;
            if ((i1 == 1) || (i1 == 2))
            {
              localObject = new AlphaAnimation(1.0F, 0.8F);
              ((AlphaAnimation)localObject).setDuration(600L);
              ((AlphaAnimation)localObject).setAnimationListener(new HotPicPageView.MyVideoViewHolder.3(this));
              this.q.startAnimation((Animation)localObject);
              break label381;
            }
          }
          this.q.setVisibility(8);
          this.e.setVisibility(8);
          this.f.setVisibility(8);
          this.l.setVisibility(8);
          this.g.setVisibility(8);
          this.i.setVisibility(8);
          this.j.setVisibility(8);
          this.itemView.setContentDescription(HardCodeUtil.a(2131903579));
          break;
        case 1: 
        case 2: 
          this.m = false;
          if (paramInt == 1) {
            this.o.a(this);
          }
          this.q.setVisibility(0);
          this.e.setVisibility(0);
          this.f.setVisibility(0);
          this.l.setVisibility(0);
          this.g.setVisibility(8);
          this.i.setVisibility(8);
          this.j.setVisibility(0);
          break;
        case 0: 
          label381:
          this.q.setVisibility(0);
          c();
          this.e.setVisibility(0);
          this.f.setVisibility(0);
          this.l.setVisibility(0);
          this.g.setVisibility(0);
          this.i.setVisibility(8);
          this.j.setVisibility(8);
          this.itemView.setContentDescription(HardCodeUtil.a(2131903580));
          break;
        }
      }
      else
      {
        f();
        this.o.setContentDescription("");
        this.m = false;
      }
    }
    else
    {
      this.q.setVisibility(0);
      c();
      this.e.setVisibility(0);
      this.f.setVisibility(0);
      this.l.setVisibility(0);
      this.g.setVisibility(0);
      this.i.setVisibility(8);
      this.j.setVisibility(8);
      this.itemView.setContentDescription(HardCodeUtil.a(2131903577));
      this.m = false;
    }
    this.n = paramInt;
    if ((paramInt == 0) && (this.m))
    {
      localObject = a();
      if (localObject != null)
      {
        this.o.c(this, ((HotVideoData)localObject).picIndex);
        this.m = false;
      }
    }
  }
  
  public void b(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      if (HotPicPageView.p())
      {
        this.h.setImageDrawable(paramDrawable);
        return;
      }
      ThreadManager.getUIHandler().post(new HotPicPageView.MyVideoViewHolder.5(this, paramDrawable));
    }
  }
  
  public boolean b(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null) {
      return false;
    }
    HotVideoData localHotVideoData = a();
    if (localHotVideoData == null) {
      return false;
    }
    return localHotVideoData.equals(paramHotVideoData);
  }
  
  public void c()
  {
    e();
    HotVideoMongoliaRelativeLayout localHotVideoMongoliaRelativeLayout = b();
    if (localHotVideoMongoliaRelativeLayout != null)
    {
      localHotVideoMongoliaRelativeLayout.setVidoeControlListener(null);
      localHotVideoMongoliaRelativeLayout.setControlStateListener(null);
      if (this.o.B == this) {
        this.o.B = null;
      }
      this.b.removeView(localHotVideoMongoliaRelativeLayout);
    }
  }
  
  public void c(int paramInt)
  {
    a(paramInt);
  }
  
  public void d()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
    localValueAnimator.setTarget(this.itemView);
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new HotPicPageView.MyVideoViewHolder.4(this));
    localValueAnimator.start();
  }
  
  public void e()
  {
    this.itemView.clearAnimation();
  }
  
  public void f()
  {
    this.q.setImageDrawable(new ColorDrawable(0));
    this.q.setVisibility(0);
    this.n = -10;
    c();
    g();
    this.i.setVisibility(8);
    this.g.setVisibility(8);
    this.l.setVisibility(8);
    this.j.setVisibility(8);
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    this.l.setVisibility(0);
  }
  
  public void g()
  {
    this.h.setImageDrawable(new ColorDrawable(0));
  }
  
  public void onClick(View paramView)
  {
    if (this.p != null)
    {
      int i1 = this.n;
      if ((i1 == 0) || (i1 == -11))
      {
        this.p.c(this, getPosition());
        break label52;
      }
    }
    if (this.n == 1) {
      a(0);
    }
    label52:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "HotPreview Download onFileDownloadFailed");
    }
    HotVideoData localHotVideoData = a();
    if ((localHotVideoData != null) && (localHotVideoData.picIndex == paramInt)) {
      a(-10);
    }
    this.o.q.a();
  }
  
  public void onFileDownloadStarted()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "HotPreview Download onFileDownloadStarted");
    }
    a();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "HotPreview Download onFileDownloadSucceed");
    }
    HotVideoData localHotVideoData = a();
    if ((localHotVideoData != null) && (localHotVideoData.picIndex == paramLong))
    {
      if (this.n == -10) {
        a(0);
      }
      if (localHotVideoData.CheckIsNeedBlurBackground())
      {
        b(new ColorDrawable(Color.parseColor("#7f000000")));
        if ((Build.VERSION.SDK_INT >= 17) && (this.o.j()) && (this.o.C != null)) {
          this.o.C.a(this, localHotVideoData);
        }
      }
    }
    this.o.q.a();
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.MyVideoViewHolder
 * JD-Core Version:    0.7.0.1
 */