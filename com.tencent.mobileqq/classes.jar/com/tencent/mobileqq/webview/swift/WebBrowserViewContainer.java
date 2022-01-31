package com.tencent.mobileqq.webview.swift;

import actj;
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
import com.tencent.mobileqq.widget.WebViewProgressBar;

public class WebBrowserViewContainer
  extends RelativeLayout
{
  private final Context jdField_a_of_type_AndroidContentContext;
  public FrameLayout a;
  public ProgressBar a;
  private boolean jdField_a_of_type_Boolean;
  public FrameLayout b;
  private boolean b;
  
  public WebBrowserViewContainer(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setBackgroundColor(-1);
  }
  
  public WebBrowserViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setBackgroundColor(-1);
  }
  
  public WebBrowserViewContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setBackgroundColor(-1);
  }
  
  private View a()
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    localView.setId(2131369803);
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localView.setBackgroundColor(1996488704);
    localView.setVisibility(8);
    return localView;
  }
  
  private FrameLayout a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    localFrameLayout.setId(2131362565);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 49;
    localFrameLayout.setLayoutParams(localLayoutParams);
    return localFrameLayout;
  }
  
  private LinearLayout a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setId(2131363421);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 49;
    localLinearLayout.setBackgroundColor(super.getResources().getColor(2131167129));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setId(2131363422);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = actj.a(20.0F, super.getResources());
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setTextColor(-9472906);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setId(2131376901);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = actj.a(8.0F, super.getResources());
    localLayoutParams.gravity = 1;
    ((TextView)localObject).setPadding(actj.a(2.0F, super.getResources()), 0, actj.a(2.0F, super.getResources()), 0);
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setText("QQ浏览器X5内核提供技术支持");
    ((TextView)localObject).setTextColor(-9472906);
    ((TextView)localObject).setCompoundDrawables(super.getResources().getDrawable(2130838577), null, null, null);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    return localLinearLayout;
  }
  
  private RelativeLayout a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext, null);
    localRelativeLayout.setId(2131379412);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localRelativeLayout.setMinimumHeight(actj.a(50.0F, super.getResources()));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(a());
    localRelativeLayout.addView(a());
    return localRelativeLayout;
  }
  
  private RefreshView a()
  {
    RefreshView localRefreshView = new RefreshView(this.jdField_a_of_type_AndroidContentContext, null);
    localRefreshView.setId(2131379412);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localRefreshView.setMinimumHeight(actj.a(50.0F, super.getResources()));
    localRefreshView.setLayoutParams(localLayoutParams);
    localRefreshView.addView(a());
    localRefreshView.addView(a());
    return localRefreshView;
  }
  
  private WebViewProgressBar a()
  {
    WebViewProgressBar localWebViewProgressBar = new WebViewProgressBar(this.jdField_a_of_type_AndroidContentContext);
    localWebViewProgressBar.setId(2131372005);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, actj.a(3.0F, super.getResources()));
    localLayoutParams.addRule(10, -1);
    localWebViewProgressBar.setLayoutParams(localLayoutParams);
    return localWebViewProgressBar;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setId(2131375056);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(actj.a(23.0F, super.getResources()), actj.a(23.0F, super.getResources()));
    localLayoutParams.topMargin = actj.a(-25.0F, super.getResources());
    localLayoutParams.addRule(13, -1);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(super.getResources().getDrawable(2130839144));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setLayoutParams(localLayoutParams);
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131366880);
    localObject = a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    if (!this.jdField_b_of_type_Boolean)
    {
      localObject = a();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      localObject = a();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    }
    for (;;)
    {
      d();
      a();
      return;
      localObject = a();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (paramBoolean) {}
    for (this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((LayoutInflater)localObject).inflate(2131559759, null));; this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((LayoutInflater)localObject).inflate(2131559758, null)))
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setId(2131366382);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  private void d()
  {
    ViewStub localViewStub = new ViewStub(this.jdField_a_of_type_AndroidContentContext);
    localViewStub.setId(2131363377);
    localViewStub.setLayoutResource(2131559658);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localViewStub, localLayoutParams);
  }
  
  public void a()
  {
    ViewStub localViewStub = new ViewStub(this.jdField_a_of_type_AndroidContentContext);
    localViewStub.setId(2131363337);
    localViewStub.setLayoutResource(2131559657);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localViewStub, localLayoutParams);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Boolean = true;
      super.setId(2131363418);
      c();
      super.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      b();
      super.addView(this.jdField_a_of_type_AndroidWidgetProgressBar);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    c(paramBoolean);
    super.addView(this.jdField_b_of_type_AndroidWidgetFrameLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebBrowserViewContainer
 * JD-Core Version:    0.7.0.1
 */