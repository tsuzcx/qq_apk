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
import com.tencent.biz.ui.TouchWebView;

public class WatchTogetherFloatingView
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 0;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private WatchTogetherFloatingView.UIHandle jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView$UIHandle = new WatchTogetherFloatingView.UIHandle(this);
  
  public WatchTogetherFloatingView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(getContext()).inflate(2131560950, this, true));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376676));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379761));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370271));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369481));
  }
  
  private void c()
  {
    if ((getParent() instanceof FrameLayout))
    {
      View localView = ((FrameLayout)getParent().getParent()).findViewById(2131374409);
      if (localView != null)
      {
        String str = getContext().getString(2131699440);
        int i = this.jdField_a_of_type_Int;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2) {
              str = getContext().getString(2131699437);
            }
          }
          else {
            str = getContext().getString(2131699440);
          }
        }
        else {
          str = getContext().getString(2131699438);
        }
        localView.setContentDescription(str);
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView$UIHandle.sendEmptyMessage(3);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_Int = 2;
    c();
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localTouchWebView != null) {
      localTouchWebView.loadUrl("about:blank");
    }
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      if (paramTouchWebView == null) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
      if (localObject != null)
      {
        localObject = ((TouchWebView)localObject).getParent();
        ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
        if (localObject == localViewGroup) {
          localViewGroup.removeView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
        }
      }
      paramTouchWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.jdField_a_of_type_AndroidViewViewGroup.addView(paramTouchWebView, 0);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
    }
  }
  
  public void a(String paramString)
  {
    a(true);
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentBizUiTouchWebView;
    if (localTouchWebView != null)
    {
      localTouchWebView.loadUrl("about:blank");
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView$UIHandle.sendEmptyMessage(1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Int = 0;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView$UIHandle.sendEmptyMessage(3);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Int = 1;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView
 * JD-Core Version:    0.7.0.1
 */