package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import avxu;
import com.tencent.biz.ui.TouchWebView;

public class WatchTogetherFloatingView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private avxu jdField_a_of_type_Avxu = new avxu(this);
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  
  public WatchTogetherFloatingView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131561000, this, true));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376809));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380017));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370348));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369526));
  }
  
  private void c()
  {
    View localView;
    String str;
    if ((getParent() instanceof FrameLayout))
    {
      localView = ((FrameLayout)getParent().getParent()).findViewById(2131374504);
      if (localView != null)
      {
        str = getContext().getString(2131698989);
        switch (this.jdField_a_of_type_Int)
        {
        }
      }
    }
    for (;;)
    {
      localView.setContentDescription(str);
      return;
      str = getContext().getString(2131698987);
      continue;
      str = getContext().getString(2131698989);
      continue;
      str = getContext().getString(2131698986);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Avxu.sendEmptyMessage(3);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Int = 2;
    c();
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("about:blank");
    }
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup == null) || (paramTouchWebView == null)) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent() == this.jdField_a_of_type_AndroidViewViewGroup)) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    }
    paramTouchWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(paramTouchWebView, 0);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
  }
  
  public void a(String paramString)
  {
    a(true);
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("about:blank");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Avxu.sendEmptyMessage(1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    for (this.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Int = 1)
    {
      c();
      return;
      this.jdField_a_of_type_Avxu.sendEmptyMessage(3);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView
 * JD-Core Version:    0.7.0.1
 */