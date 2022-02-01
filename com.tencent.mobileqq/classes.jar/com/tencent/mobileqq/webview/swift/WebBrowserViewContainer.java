package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.widget.immersive.ImmersiveUtils;

public class WebBrowserViewContainer
  extends RelativeLayout
{
  public FrameLayout a;
  public ProgressBar b;
  public FrameLayout c;
  private final Context d;
  private boolean e = false;
  private boolean f = false;
  
  public WebBrowserViewContainer(Context paramContext)
  {
    super(paramContext);
    this.d = paramContext;
    setBackgroundColor(-1);
  }
  
  public WebBrowserViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    setBackgroundColor(-1);
  }
  
  public WebBrowserViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    setBackgroundColor(-1);
  }
  
  private void c()
  {
    this.b = new ProgressBar(this.d, null, 0);
    this.b.setId(2131444560);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(23.0F), ViewUtils.dpToPx(23.0F));
    localLayoutParams.topMargin = ViewUtils.dpToPx(-25.0F);
    localLayoutParams.addRule(13, -1);
    this.b.setIndeterminate(true);
    this.b.setIndeterminateDrawable(super.getResources().getDrawable(2130839590));
    this.b.setVisibility(8);
    this.b.setLayoutParams(localLayoutParams);
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = LayoutInflater.from(this.d);
    if (paramBoolean) {
      this.c = ((FrameLayout)((LayoutInflater)localObject).inflate(2131626000, null));
    } else {
      this.c = ((FrameLayout)((LayoutInflater)localObject).inflate(2131625999, null));
    }
    this.c.setId(2131433424);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void d()
  {
    this.a = new FrameLayout(this.d);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a.setId(2131433916);
    localObject = f();
    this.a.addView((View)localObject);
    if (!this.f)
    {
      localObject = g();
      this.a.addView((View)localObject);
    }
    if (!this.f)
    {
      localObject = h();
      this.a.addView((View)localObject);
    }
    else
    {
      localObject = i();
      this.a.addView((View)localObject);
    }
    e();
    a();
    b();
  }
  
  private void e()
  {
    ViewStub localViewStub = new ViewStub(this.d);
    localViewStub.setId(2131429682);
    localViewStub.setLayoutResource(2131625888);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    this.a.addView(localViewStub, localLayoutParams);
  }
  
  private FrameLayout f()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.d);
    localFrameLayout.setId(2131428408);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 49;
    localFrameLayout.setLayoutParams(localLayoutParams);
    return localFrameLayout;
  }
  
  private LinearLayout g()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.d);
    localLinearLayout.setId(2131429743);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 49;
    localLinearLayout.setBackgroundColor(super.getResources().getColor(2131168451));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.d);
    ((TextView)localObject).setId(2131429744);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = ViewUtils.dpToPx(20.0F);
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setTextColor(-9472906);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    localObject = new TextView(this.d);
    ((TextView)localObject).setId(2131446856);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = ViewUtils.dpToPx(8.0F);
    localLayoutParams.gravity = 1;
    ((TextView)localObject).setPadding(ViewUtils.dpToPx(2.0F), 0, ViewUtils.dpToPx(2.0F), 0);
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setText("QQ浏览器X5内核提供技术支持");
    ((TextView)localObject).setTextColor(-9472906);
    ((TextView)localObject).setCompoundDrawables(super.getResources().getDrawable(2130839013), null, null, null);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    return localLinearLayout;
  }
  
  private RefreshView h()
  {
    RefreshView localRefreshView = new RefreshView(this.d, null);
    localRefreshView.setId(2131450099);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localRefreshView.setMinimumHeight(ViewUtils.dpToPx(50.0F));
    localRefreshView.setLayoutParams(localLayoutParams);
    localRefreshView.addView(j());
    localRefreshView.addView(k());
    return localRefreshView;
  }
  
  private RelativeLayout i()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.d, null);
    localRelativeLayout.setId(2131450099);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localRelativeLayout.setMinimumHeight(ViewUtils.dpToPx(50.0F));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(j());
    localRelativeLayout.addView(k());
    return localRelativeLayout;
  }
  
  private View j()
  {
    View localView = new View(this.d);
    localView.setId(2131437976);
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localView.setBackgroundColor(1996488704);
    localView.setVisibility(8);
    return localView;
  }
  
  private WebViewProgressBar k()
  {
    WebViewProgressBar localWebViewProgressBar = new WebViewProgressBar(this.d);
    localWebViewProgressBar.setId(2131440738);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(3.0F));
    localLayoutParams.addRule(10, -1);
    localWebViewProgressBar.setLayoutParams(localLayoutParams);
    return localWebViewProgressBar;
  }
  
  public void a()
  {
    ViewStub localViewStub = new ViewStub(this.d);
    localViewStub.setId(2131429636);
    localViewStub.setLayoutResource(2131625887);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    this.a.addView(localViewStub, localLayoutParams);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.f = paramBoolean;
      this.e = true;
      super.setId(2131429740);
      d();
      super.addView(this.a);
      c();
      super.addView(this.b);
    }
  }
  
  public void b()
  {
    ViewStub localViewStub = new ViewStub(this.d);
    localViewStub.setId(2131433427);
    localViewStub.setLayoutResource(2131625890);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 53;
    localLayoutParams.height = ViewUtils.dpToPx(44.0F);
    localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(this.d);
    this.a.addView(localViewStub, localLayoutParams);
  }
  
  public void b(boolean paramBoolean)
  {
    c(paramBoolean);
    super.addView(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebBrowserViewContainer
 * JD-Core Version:    0.7.0.1
 */