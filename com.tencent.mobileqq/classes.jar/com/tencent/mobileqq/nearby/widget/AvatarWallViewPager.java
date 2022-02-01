package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;

public class AvatarWallViewPager
  extends RelativeLayout
{
  protected boolean a = false;
  protected int b;
  protected Context c;
  protected AvatarWallViewPager.RollViewPager d;
  protected boolean e = true;
  protected AvatarWallPagerAdapter f;
  protected AvatarWallViewPager.RollerChangeListener g;
  protected LinearLayout h;
  protected LinearLayout.LayoutParams i;
  protected View[] j;
  protected Drawable k;
  protected Drawable l;
  protected int m = 500;
  protected int n = 4000;
  protected int o = this.m;
  protected int p = this.n;
  protected float q;
  protected float r;
  protected float s;
  protected float t;
  protected boolean u = false;
  protected boolean v = false;
  protected int w;
  protected Handler x = new AvatarWallViewPager.1(this, Looper.getMainLooper());
  
  public AvatarWallViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarWallViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    c();
  }
  
  protected View a(boolean paramBoolean)
  {
    View localView = new View(this.c);
    Object localObject;
    if (this.i == null)
    {
      int i1 = UIUtils.a(this.c, 7.0F);
      this.i = new LinearLayout.LayoutParams(i1, i1);
      localObject = this.i;
      ((LinearLayout.LayoutParams)localObject).leftMargin = i1;
      ((LinearLayout.LayoutParams)localObject).rightMargin = i1;
    }
    if (paramBoolean)
    {
      if (this.l == null) {
        this.l = BizTroopUtil.a(getResources(), Color.parseColor("#CC12B7F5"), getResources().getDrawable(2130844829));
      }
    }
    else if (this.k == null) {
      this.k = BizTroopUtil.a(getResources(), Color.parseColor("#66FFFFFF"), getResources().getDrawable(2130844829));
    }
    localView.setLayoutParams(this.i);
    if (paramBoolean) {
      localObject = this.l;
    } else {
      localObject = this.k;
    }
    localView.setBackgroundDrawable((Drawable)localObject);
    return localView;
  }
  
  protected View a(boolean paramBoolean, int paramInt)
  {
    View localView2 = this.f.a(paramBoolean, paramInt);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = a(paramBoolean);
    }
    return localView1;
  }
  
  public void a()
  {
    if (!this.a)
    {
      if (this.f.c() <= 1) {
        return;
      }
      if (this.u)
      {
        this.x.removeCallbacksAndMessages(null);
        Handler localHandler = this.x;
        localHandler.sendMessageDelayed(localHandler.obtainMessage(), this.p);
      }
    }
  }
  
  public void b()
  {
    if (this.a) {
      return;
    }
    this.x.removeCallbacksAndMessages(null);
  }
  
  protected void c()
  {
    this.b = ViewConfiguration.get(this.c).getScaledTouchSlop();
    this.d = new AvatarWallViewPager.RollViewPager(this, this.c);
    addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
    this.h = f();
    this.h.setBackgroundColor(getResources().getColor(17170445));
    this.h.setGravity(17);
    addView(this.h, d());
    AvatarWallViewPager.RollViewPager localRollViewPager = this.d;
    AvatarWallViewPager.RollerChangeListener localRollerChangeListener = new AvatarWallViewPager.RollerChangeListener(this);
    this.g = localRollerChangeListener;
    localRollViewPager.setOnPageChangeListener(localRollerChangeListener);
    new AvatarWallViewPager.RollScroller(this, this.c, new LinearInterpolator()).a();
  }
  
  protected RelativeLayout.LayoutParams d()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.bottomMargin = UIUtils.a(this.c, 50.0F);
    return localLayoutParams;
  }
  
  protected void e()
  {
    int i1 = this.f.c();
    this.h.removeAllViews();
    if (i1 > 1)
    {
      int i2 = i1 - 2;
      this.j = new View[i2];
      i1 = 0;
      while (i1 < i2)
      {
        Object localObject = this.j;
        boolean bool;
        if (i1 == 0) {
          bool = true;
        } else {
          bool = false;
        }
        localObject[i1] = a(bool, i1);
        localObject = this.h;
        if (i1 == 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((LinearLayout)localObject).addView(a(bool, i1));
        i1 += 1;
      }
    }
    this.g.a = 0;
  }
  
  protected LinearLayout f()
  {
    return new LinearLayout(this.c);
  }
  
  protected AvatarWallViewPager.RollViewPager getRollViewPager()
  {
    return this.d;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a = true;
    Object localObject = this.x;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((AvatarWallPagerAdapter)localObject).a();
      this.f = null;
    }
  }
  
  public void setAdapter(AvatarWallPagerAdapter paramAvatarWallPagerAdapter)
  {
    if (paramAvatarWallPagerAdapter != null)
    {
      this.f = paramAvatarWallPagerAdapter;
      this.d.setAdapter(paramAvatarWallPagerAdapter.b());
      e();
    }
  }
  
  public void setDotLayoutParams(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null) {
      this.h.setLayoutParams(paramLayoutParams);
    }
  }
  
  public void setScrollInterpolator(Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {
      new AvatarWallViewPager.RollScroller(this, this.c, paramInterpolator).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallViewPager
 * JD-Core Version:    0.7.0.1
 */