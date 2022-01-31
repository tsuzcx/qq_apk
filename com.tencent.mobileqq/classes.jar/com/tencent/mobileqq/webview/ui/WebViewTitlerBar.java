package com.tencent.mobileqq.webview.ui;

import akcr;
import akcs;
import akct;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ValueAnimation;

public class WebViewTitlerBar
{
  public int a;
  Activity jdField_a_of_type_AndroidAppActivity;
  public View.OnClickListener a;
  public View a;
  FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public CustomWebView a;
  public String a;
  public boolean a;
  View jdField_b_of_type_AndroidViewView;
  FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public WebViewTitlerBar(Activity paramActivity, CustomWebView paramCustomWebView, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
    this.jdField_a_of_type_Int = 255;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = paramCustomWebView;
    a(paramViewGroup);
    a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public ImageView a()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  public CharSequence a()
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
      return this.jdField_c_of_type_AndroidWidgetTextView.getText();
    }
    return null;
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375274));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375275));
    this.jdField_b_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375277));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363363));
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxEms(9);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375276));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363227));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363410));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363456));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131363241);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (paramInt2 == 0)
    {
      this.jdField_a_of_type_AndroidViewView.getBackground().mutate().setAlpha(paramInt1);
      this.jdField_a_of_type_Int = paramInt1;
    }
    while (this.jdField_a_of_type_Int == paramInt1) {
      return;
    }
    a(this.jdField_a_of_type_Int, paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      this.jdField_a_of_type_AndroidViewView.getBackground().mutate().setAlpha(paramInt2);
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new akct(this, paramInt2));
    localValueAnimation.setDuration(paramInt3);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.startAnimation(localValueAnimation);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void a(View paramView)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, new RelativeLayout.LayoutParams(-2, -1));
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
  }
  
  void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130971677, paramViewGroup, true);
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_c_of_type_AndroidWidgetImageView = paramImageView;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString2))
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.bringToFront();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundColor(0);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    if (!TextUtils.isEmpty(paramString3)) {}
    try
    {
      int j = Color.parseColor(paramString3);
      i = j;
    }
    catch (Exception paramString2)
    {
      label75:
      break label75;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(i);
    if (paramString1 != null)
    {
      this.jdField_a_of_type_JavaLangString = paramString1.trim();
      b(new akcs(this));
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (paramInt1 == 0) {
      a(paramString1, paramString2, paramString3);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (paramInt1)
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      default: 
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        label141:
        if (paramInt2 != 0) {
          if (this.jdField_c_of_type_AndroidWidgetImageView == null)
          {
            this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
            if (this.jdField_b_of_type_AndroidWidgetFrameLayout != null)
            {
              paramString3 = new FrameLayout.LayoutParams(-2, -2);
              paramString3.setMargins(0, 0, 0, 0);
              this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramString3);
              paramString3.gravity = 53;
              paramString3.setMargins(0, 0, DisplayUtil.a(this.jdField_a_of_type_AndroidAppActivity, 5.0F), 0);
              this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView);
            }
            this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
            switch (paramInt2)
            {
            default: 
              this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
            }
          }
        }
        break;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(paramString2);
        }
        if (paramOnClickListener == null) {
          break label546;
        }
        c(paramOnClickListener);
        break;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841420);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131434725));
        break label141;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841419);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131434722));
        break label141;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839143);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131434718));
        break label141;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838558);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131434719));
        break label141;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841454);
        this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131434723));
        ((AnimationDrawable)this.jdField_b_of_type_AndroidWidgetImageView.getDrawable()).start();
        break label141;
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838271);
        break label141;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130841248);
        continue;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845924);
        continue;
        if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
      label546:
      if (paramString1 != null)
      {
        this.jdField_a_of_type_JavaLangString = paramString1.trim();
        c(new akcr(this));
      }
      else
      {
        this.jdField_a_of_type_JavaLangString = null;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public ImageView b()
  {
    return this.jdField_c_of_type_AndroidWidgetImageView;
  }
  
  public TextView b()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramCharSequence);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_b_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public TextView c()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  public void c(View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void c(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTitlerBar
 * JD-Core Version:    0.7.0.1
 */