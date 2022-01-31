package com.tencent.mobileqq.intervideo.groupvideo;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GVideoLoadingUI
  implements View.OnClickListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public static String a(long paramLong)
  {
    if (paramLong > 107374182.40000001D) {
      return String.format("%.1f G", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) });
    }
    if (paramLong > 104857.60000000001D) {
      return String.format("%.1f M", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) });
    }
    return String.format("%.1f K", new Object[] { Float.valueOf((float)paramLong / 1024.0F) });
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(int paramInt, long paramLong)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    if (paramLong == 0L) {
      this.e.setVisibility(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(paramInt);
      return;
      this.e.setText(String.format("%1$s/%2$s", new Object[] { a(paramInt * paramLong / 100L), a(paramLong) }));
    }
  }
  
  public void a(Activity paramActivity, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364747));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364748));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364749));
    this.c = ((TextView)paramView.findViewById(2131364750));
    this.d = ((TextView)paramView.findViewById(2131364751));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131364752));
    this.e = ((TextView)paramView.findViewById(2131364753));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131364754));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364755));
    this.f = ((TextView)paramView.findViewById(2131364756));
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c.setText(paramString1);
    this.d.setText(paramString2);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_a_of_type_AndroidWidgetLinearLayout) || (paramView == this.jdField_a_of_type_AndroidWidgetTextView)) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.GVideoLoadingUI
 * JD-Core Version:    0.7.0.1
 */