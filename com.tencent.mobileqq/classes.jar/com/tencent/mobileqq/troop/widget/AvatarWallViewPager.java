package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener;
import com.tencent.mobileqq.troop.utils.BizTroopUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AvatarWallViewPager
  extends RelativeLayout
{
  protected int a;
  protected Context b;
  protected AvatarWallViewPager.RollViewPager c;
  protected boolean d = true;
  protected AvatarWallViewPagerAdapter e;
  protected LinearLayout f;
  protected LinearLayout.LayoutParams g;
  protected View[] h;
  protected Drawable i;
  protected Drawable j;
  protected boolean k = false;
  protected float l;
  protected float m;
  protected float n;
  protected float o;
  protected int p;
  protected ViewPager.SimpleOnPageChangeListener q;
  protected Handler r = new AvatarWallViewPager.1(this, Looper.getMainLooper());
  private boolean s = true;
  private boolean t = false;
  
  public AvatarWallViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarWallViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    a();
  }
  
  protected void a()
  {
    this.a = ViewConfiguration.get(this.b).getScaledTouchSlop();
    this.c = new AvatarWallViewPager.RollViewPager(this, this.b);
    addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    localLayoutParams.addRule(11);
    localLayoutParams.rightMargin = ViewUtils.dip2px(13.0F);
    localLayoutParams.bottomMargin = ViewUtils.dip2px(10.0F);
    this.f = e();
    this.f.setBackgroundColor(getResources().getColor(17170445));
    this.f.setGravity(5);
    addView(this.f, localLayoutParams);
    this.c.setOnPageChangeListener(new AvatarWallViewPager.RollerChangeListener(this));
    new AvatarWallViewPager.RollScroller(this, this.b, new LinearInterpolator()).a();
  }
  
  protected View b()
  {
    View localView = new View(this.b);
    if (this.g == null)
    {
      int i1 = ViewUtils.dip2px(6.0F);
      this.g = new LinearLayout.LayoutParams(i1, i1);
      this.g.leftMargin = ViewUtils.dip2px(7.0F);
      this.i = BizTroopUtil.a(getResources(), Color.parseColor("#80ffffff"), getResources().getDrawable(2130844829));
      this.j = BizTroopUtil.a(getResources(), Color.parseColor("#ffffffff"), getResources().getDrawable(2130844829));
      if (ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.waitAppRuntime(null)))
      {
        this.i.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        this.j.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
    }
    localView.setLayoutParams(this.g);
    localView.setBackgroundDrawable(this.i);
    return localView;
  }
  
  public void c()
  {
    int i2 = this.e.a();
    if (i2 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarWallViewPager", 2, "startRoll error, the count of avatars is 0...");
      }
      return;
    }
    this.f.removeAllViews();
    if (i2 > 1)
    {
      this.h = new View[i2];
      int i1 = 0;
      while (i1 < i2)
      {
        this.h[i1] = b();
        this.f.addView(this.h[i1]);
        i1 += 1;
      }
      this.h[0].setBackgroundDrawable(this.j);
      this.p = 1;
      this.c.setCurrentItem(this.p, false);
      f();
    }
    else
    {
      g();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarWallViewPager", 2, "startRoll is called successfully");
    }
  }
  
  public void d()
  {
    g();
  }
  
  protected LinearLayout e()
  {
    return new LinearLayout(this.b);
  }
  
  protected void f()
  {
    this.s = false;
    if (this.t)
    {
      this.r.removeCallbacksAndMessages(null);
      Handler localHandler = this.r;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(), 4000L);
    }
  }
  
  protected void g()
  {
    this.s = true;
    this.r.removeCallbacksAndMessages(null);
  }
  
  public int getCurrentItem()
  {
    int i1 = this.p;
    if (i1 > 0) {
      return i1 - 1;
    }
    return 0;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.t = true;
    if (!this.s)
    {
      this.r.removeCallbacksAndMessages(null);
      Handler localHandler = this.r;
      localHandler.sendMessageDelayed(localHandler.obtainMessage(), 4000L);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.t = false;
    this.r.removeCallbacksAndMessages(null);
  }
  
  public void setAdapter(AvatarWallViewPagerAdapter paramAvatarWallViewPagerAdapter)
  {
    if (paramAvatarWallViewPagerAdapter != null)
    {
      this.e = paramAvatarWallViewPagerAdapter;
      this.c.setAdapter(paramAvatarWallViewPagerAdapter);
    }
  }
  
  public void setOnPageChangeListener(ViewPager.SimpleOnPageChangeListener paramSimpleOnPageChangeListener)
  {
    this.q = paramSimpleOnPageChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallViewPager
 * JD-Core Version:    0.7.0.1
 */