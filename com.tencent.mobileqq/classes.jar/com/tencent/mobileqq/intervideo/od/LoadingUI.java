package com.tencent.mobileqq.intervideo.od;

import adlj;
import adlk;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class LoadingUI
{
  private static int jdField_a_of_type_Int = 1;
  private static int jdField_b_of_type_Int = 2;
  private static int jdField_c_of_type_Int = 3;
  private static int d = 4;
  private static int e = 5;
  private static int f = 6;
  private Activity jdField_a_of_type_AndroidAppActivity;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  protected TextView a;
  private LoadingUI.Event jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI$Event;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_b_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private int g = 1;
  
  private final int a(float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void a()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_AndroidWidgetProgressBar.getVisibility() == 8) {
      this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramActivity = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    paramActivity.setOrientation(1);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.parseColor("#22202d"));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, a(49.0F));
    paramActivity.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    a(this.jdField_c_of_type_AndroidWidgetRelativeLayout, paramString);
    paramActivity.addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    paramString = new LinearLayout.LayoutParams(-1, -1);
    paramActivity.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramString);
    b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramString = new LinearLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidAppActivity.setContentView(paramActivity, paramString);
    paramActivity.setBackgroundColor(Color.parseColor("#2e2c38"));
    a();
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    int i = this.g;
    this.g = (i + 1);
    localRelativeLayout.setId(i);
    paramRelativeLayout.addView(localRelativeLayout, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new ViewGroup.MarginLayoutParams(45, 45);
    ((ViewGroup.MarginLayoutParams)localObject1).setMargins(0, 0, 0, 0);
    localObject1 = new RelativeLayout.LayoutParams((ViewGroup.MarginLayoutParams)localObject1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(5);
    this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidAppActivity, null, 16842873);
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetProgressBar;
    i = this.g;
    this.g = (i + 1);
    ((ProgressBar)localObject2).setId(i);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminate(true);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setMax(10);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetProgressBar, (ViewGroup.LayoutParams)localObject1);
    this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, this.jdField_a_of_type_AndroidWidgetProgressBar.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    localObject2 = this.jdField_b_of_type_AndroidWidgetTextView;
    i = this.g;
    this.g = (i + 1);
    ((TextView)localObject2).setId(i);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_b_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    localRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
    i = this.g;
    this.g = (i + 1);
    ((ImageView)localObject1).setId(i);
    localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840620);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(a(100.0F), a(75.0F));
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, a(15.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(2, localRelativeLayout.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    paramRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_b_of_type_AndroidWidgetProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidAppActivity, null, 16842872);
    localObject1 = this.jdField_b_of_type_AndroidWidgetProgressBar;
    i = this.g;
    this.g = (i + 1);
    ((ProgressBar)localObject1).setId(i);
    this.jdField_b_of_type_AndroidWidgetProgressBar.setMax(100);
    this.jdField_b_of_type_AndroidWidgetProgressBar.setProgress(0);
    localObject1 = new ColorDrawable(Color.parseColor("#555460"));
    localObject2 = new ClipDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[] { -65536, -256 }), 3, 1);
    this.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable((Drawable)localObject2);
    this.jdField_b_of_type_AndroidWidgetProgressBar.setBackgroundDrawable((Drawable)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(a(200.0F), a(2.0F));
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, a(15.0F), 0, 0);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, localRelativeLayout.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    this.jdField_b_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetProgressBar, (ViewGroup.LayoutParams)localObject1);
  }
  
  public void a(RelativeLayout paramRelativeLayout, String paramString)
  {
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    int i = this.g;
    this.g = (i + 1);
    localTextView.setId(i);
    localTextView.setText(paramString);
    localTextView.setTextSize(2, 19.0F);
    localTextView.setTextColor(-1);
    localTextView.setIncludeFontPadding(false);
    localTextView.setVisibility(0);
    paramRelativeLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    paramString = new RelativeLayout.LayoutParams(a(24.0F), a(36.0F));
    paramString.addRule(5);
    paramString.addRule(15);
    paramString.leftMargin = a(15.0F);
    this.jdField_c_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    localObject = this.jdField_c_of_type_AndroidWidgetImageView;
    i = this.g;
    this.g = (i + 1);
    ((ImageView)localObject).setId(i);
    this.jdField_c_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    new StateListDrawable();
    localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840618);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new adlj(this));
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    paramRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetImageView, paramString);
  }
  
  public void a(LoadingUI.Event paramEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoOdLoadingUI$Event = paramEvent;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 8) {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
      return;
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void b(RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    int i = this.g;
    this.g = (i + 1);
    ((TextView)localObject2).setId(i);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 13.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    paramRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject1);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    localObject1 = this.jdField_b_of_type_AndroidWidgetImageView;
    i = this.g;
    this.g = (i + 1);
    ((ImageView)localObject1).setId(i);
    localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130840619);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(a(100.0F), a(75.0F));
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, a(15.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(2, this.jdField_a_of_type_AndroidWidgetTextView.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    paramRelativeLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new Button(this.jdField_a_of_type_AndroidAppActivity);
    i = this.g;
    this.g = (i + 1);
    ((Button)localObject1).setId(i);
    ((Button)localObject1).setText("重新加载");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    ((Button)localObject1).setTextColor(-1);
    localObject2 = new StateListDrawable();
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#3d3b47"));
    ((StateListDrawable)localObject2).addState(new int[] { 0 }, localColorDrawable);
    localColorDrawable = new ColorDrawable(Color.parseColor("#b33d3b47"));
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, localColorDrawable);
    ((Button)localObject1).setBackgroundDrawable((Drawable)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(a(150.0F), a(36.0F));
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, 0, a(50.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(12);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    paramRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    ((Button)localObject1).setOnClickListener(new adlk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.LoadingUI
 * JD-Core Version:    0.7.0.1
 */