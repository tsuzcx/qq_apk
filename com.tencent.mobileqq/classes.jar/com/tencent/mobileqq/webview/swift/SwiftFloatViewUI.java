package com.tencent.mobileqq.webview.swift;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.widgets.Hole;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.SystemBarTintManager;

public class SwiftFloatViewUI
{
  public SwiftBrowserUIStyleHandler a;
  public SwiftBrowserUIStyle b;
  public View c;
  public View d;
  public View e;
  public View f;
  public View g;
  public View h;
  public View i;
  public View j;
  public View k;
  public Hole l;
  public int m;
  public int n;
  Rect o = new Rect();
  int p;
  int q;
  Runnable r = new SwiftFloatViewUI.3(this);
  
  public SwiftFloatViewUI(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    this.a = paramSwiftBrowserUIStyleHandler;
    this.b = paramSwiftBrowserUIStyleHandler.f;
  }
  
  private View.OnTouchListener a(DisplayMetrics paramDisplayMetrics)
  {
    return new SwiftFloatViewUI.2(this, paramDisplayMetrics);
  }
  
  public void a()
  {
    if ((this.c != null) && (8 == this.e.getVisibility()))
    {
      DisplayMetrics localDisplayMetrics;
      if (this.a.i != null) {
        localDisplayMetrics = this.a.i.getResources().getDisplayMetrics();
      } else {
        localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
      }
      this.m = localDisplayMetrics.widthPixels;
      this.n = localDisplayMetrics.heightPixels;
      Object localObject = this.b;
      if ((localObject != null) && (((SwiftBrowserUIStyle)localObject).k) && (this.b.U))
      {
        c();
        return;
      }
      localObject = (FrameLayout.LayoutParams)this.c.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = ((int)(this.m - localDisplayMetrics.density * 50.0F));
      ((FrameLayout.LayoutParams)localObject).topMargin = ((int)(this.n - localDisplayMetrics.density * 100.0F));
      this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  @TargetApi(11)
  public void a(Activity paramActivity)
  {
    if (SystemBarTintManager.hasNavBar(paramActivity))
    {
      paramActivity = paramActivity.findViewById(16908290);
      paramActivity.addOnLayoutChangeListener(new SwiftFloatViewUI.4(this, paramActivity));
    }
  }
  
  public void a(View paramView)
  {
    int i1 = paramView.getResources().getColor(2131168249);
    if (this.b.f) {
      i1 = paramView.getResources().getColor(2131168250);
    }
    paramView = this.h;
    int i2;
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      i2 = 2130843675;
      if (this.b.f) {
        i2 = 2130843676;
      }
      ((TextView)this.h).setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
      ((TextView)this.h).setTextColor(i1);
    }
    paramView = this.i;
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      i2 = 2130843672;
      if (this.b.f) {
        i2 = 2130843673;
      }
      ((TextView)this.i).setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
      ((TextView)this.i).setTextColor(i1);
    }
    paramView = this.g;
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      i2 = 2130843666;
      if (this.b.f) {
        i2 = 2130843667;
      }
      ((TextView)this.g).setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
      ((TextView)this.g).setTextColor(i1);
    }
    paramView = this.f;
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      i2 = 2130843663;
      if (this.b.f) {
        i2 = 2130843664;
      }
      ((TextView)this.f).setCompoundDrawablesWithIntrinsicBounds(0, i2, 0, 0);
      ((TextView)this.f).setTextColor(i1);
    }
    paramView = this.c;
    if ((paramView != null) && ((paramView instanceof Button)))
    {
      i1 = 2130843659;
      if (this.b.f) {
        i1 = 2130843669;
      } else if (this.b.U) {
        i1 = 2130843671;
      }
      this.c.setBackgroundResource(i1);
    }
  }
  
  @TargetApi(16)
  public void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    DisplayMetrics localDisplayMetrics;
    if (this.a.i != null) {
      localDisplayMetrics = this.a.i.getResources().getDisplayMetrics();
    } else {
      localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    }
    int i1;
    if (this.b.k)
    {
      if (localDisplayMetrics.heightPixels > localDisplayMetrics.widthPixels) {
        i1 = localDisplayMetrics.heightPixels;
      } else {
        i1 = localDisplayMetrics.widthPixels;
      }
      this.m = i1;
      if (localDisplayMetrics.heightPixels > localDisplayMetrics.widthPixels) {
        i1 = localDisplayMetrics.widthPixels;
      } else {
        i1 = localDisplayMetrics.heightPixels;
      }
      this.n = i1;
    }
    else
    {
      if (localDisplayMetrics.heightPixels < localDisplayMetrics.widthPixels) {
        i1 = localDisplayMetrics.heightPixels;
      } else {
        i1 = localDisplayMetrics.widthPixels;
      }
      this.m = i1;
      if (localDisplayMetrics.heightPixels < localDisplayMetrics.widthPixels) {
        i1 = localDisplayMetrics.widthPixels;
      } else {
        i1 = localDisplayMetrics.heightPixels;
      }
      this.n = i1;
    }
    this.c = paramView.findViewById(2131433420);
    this.e = paramView.findViewById(2131447403);
    this.d = paramView.findViewById(2131429723);
    this.f = paramView.findViewById(2131432651);
    this.h = paramView.findViewById(2131445753);
    this.i = paramView.findViewById(2131445622);
    this.j = paramView.findViewById(2131438844);
    this.g = paramView.findViewById(2131433502);
    this.k = paramView.findViewById(2131437976);
    this.l = ((Hole)paramView.findViewById(2131435066));
    b();
    if (this.b.f) {
      a(paramView);
    }
    if ((this.b.e & 1L) != 0L)
    {
      this.h.setVisibility(0);
      this.c.setVisibility(0);
    }
    if ((this.b.e & 0x4) != 0L)
    {
      this.f.setVisibility(0);
      this.c.setVisibility(0);
    }
    if ((this.b.e & 0x2) != 0L)
    {
      this.j.setVisibility(0);
      this.c.setVisibility(0);
    }
    if ((((this.b.d & 0x800) != 0L) || ((this.b.c & 0x80000000) != 0L)) && (this.a.r != null) && (AuthorizeConfig.a().f("aio_authorize_config", this.a.r.getCurrentUrl())))
    {
      this.g.setVisibility(0);
      this.c.setVisibility(0);
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("secondHandSharePre", 0);
    if (localSharedPreferences.getBoolean("first_float_tip", true))
    {
      this.e.setVisibility(0);
      localSharedPreferences.edit().putBoolean("first_float_tip", false).apply();
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(new SwiftFloatViewUI.1(this, paramView, localDisplayMetrics));
    }
    else
    {
      this.e.setVisibility(8);
    }
    paramView = a(localDisplayMetrics);
    this.f.setOnClickListener(paramOnClickListener);
    this.h.setOnClickListener(paramOnClickListener);
    this.j.setOnClickListener(paramOnClickListener);
    this.i.setOnClickListener(paramOnClickListener);
    this.g.setOnClickListener(paramOnClickListener);
    this.c.setOnTouchListener(paramView);
    this.e.setOnTouchListener(paramView);
    this.k.setOnTouchListener(paramView);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    if (this.b.f)
    {
      paramView.setBackgroundResource(2130843669);
      return;
    }
    if (this.b.U)
    {
      paramView.setBackgroundResource(2130843671);
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130843659);
      return;
    }
    paramView.setBackgroundResource(2130843660);
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = this.h;
    if (localView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 8;
      } else {
        i1 = 0;
      }
      localView.setVisibility(i1);
    }
    if (!paramBoolean)
    {
      localView = this.c;
      if ((localView != null) && ((localView.getVisibility() == 8) || (this.c.getVisibility() == 4))) {
        this.c.setVisibility(0);
      }
    }
  }
  
  public void b()
  {
    SwiftBrowserUIStyle localSwiftBrowserUIStyle = this.b;
    if ((localSwiftBrowserUIStyle != null) && (localSwiftBrowserUIStyle.k) && (this.b.U) && (this.c != null) && (8 == this.e.getVisibility())) {
      c();
    }
  }
  
  public void c()
  {
    int i2 = this.n;
    int i1 = this.m;
    int i3;
    if (i2 > i1)
    {
      i3 = i1;
    }
    else
    {
      i3 = i2;
      i2 = i1;
    }
    DisplayMetrics localDisplayMetrics;
    if (this.a.i != null) {
      localDisplayMetrics = this.a.i.getResources().getDisplayMetrics();
    } else {
      localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    localLayoutParams.leftMargin = ((int)(i2 - localDisplayMetrics.density * 70.0F));
    localLayoutParams.topMargin = (i3 / 2 - this.c.getWidth() / 2);
    this.c.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftFloatViewUI
 * JD-Core Version:    0.7.0.1
 */