package com.tencent.mobileqq.webview.swift;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
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
    localView.setId(2131365597);
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localView.setBackgroundColor(1996488704);
    localView.setVisibility(8);
    return localView;
  }
  
  private FrameLayout a()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    localFrameLayout.setId(2131366765);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 49;
    localFrameLayout.setLayoutParams(localLayoutParams);
    return localFrameLayout;
  }
  
  private LinearLayout a()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setId(2131366766);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).gravity = 49;
    localLinearLayout.setBackgroundColor(super.getResources().getColor(2131493343));
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setId(2131366767);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = AIOUtils.a(20.0F, super.getResources());
    ((TextView)localObject).setGravity(17);
    ((TextView)localObject).setText("");
    ((TextView)localObject).setTextColor(-9472906);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setId(2131366768);
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = AIOUtils.a(8.0F, super.getResources());
    localLayoutParams.gravity = 1;
    ((TextView)localObject).setPadding(AIOUtils.a(2.0F, super.getResources()), 0, AIOUtils.a(2.0F, super.getResources()), 0);
    ((TextView)localObject).setVisibility(8);
    ((TextView)localObject).setText("QQ浏览器X5内核提供技术支持");
    ((TextView)localObject).setTextColor(-9472906);
    ((TextView)localObject).setCompoundDrawables(super.getResources().getDrawable(2130838287), null, null, null);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    return localLinearLayout;
  }
  
  private RelativeLayout a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext, null);
    localRelativeLayout.setId(2131366769);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localRelativeLayout.setMinimumHeight(AIOUtils.a(50.0F, super.getResources()));
    localRelativeLayout.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(a());
    localRelativeLayout.addView(a());
    return localRelativeLayout;
  }
  
  private RefreshView a()
  {
    RefreshView localRefreshView = new RefreshView(this.jdField_a_of_type_AndroidContentContext, null);
    localRefreshView.setId(2131366769);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 80;
    localRefreshView.setMinimumHeight(AIOUtils.a(50.0F, super.getResources()));
    localRefreshView.setLayoutParams(localLayoutParams);
    localRefreshView.addView(a());
    localRefreshView.addView(a());
    return localRefreshView;
  }
  
  private WebViewProgressBar a()
  {
    WebViewProgressBar localWebViewProgressBar = new WebViewProgressBar(this.jdField_a_of_type_AndroidContentContext);
    localWebViewProgressBar.setId(2131366770);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(3.0F, super.getResources()));
    localLayoutParams.addRule(10, -1);
    localWebViewProgressBar.setLayoutParams(localLayoutParams);
    return localWebViewProgressBar;
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext, null, 0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setId(2131363049);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(23.0F, super.getResources()), AIOUtils.a(23.0F, super.getResources()));
    localLayoutParams.topMargin = AIOUtils.a(-25.0F, super.getResources());
    localLayoutParams.addRule(13, -1);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(super.getResources().getDrawable(2130838600));
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setLayoutParams(localLayoutParams);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131363456);
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
      return;
    }
    localObject = a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView((View)localObject);
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (paramBoolean) {}
    for (this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((LayoutInflater)localObject).inflate(2130969512, null));; this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)((LayoutInflater)localObject).inflate(2130969511, null)))
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setId(2131363457);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Boolean = true;
      super.setId(2131363454);
      b();
      super.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      a();
      super.addView(this.jdField_a_of_type_AndroidWidgetProgressBar);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    c(paramBoolean);
    super.addView(this.jdField_b_of_type_AndroidWidgetFrameLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebBrowserViewContainer
 * JD-Core Version:    0.7.0.1
 */