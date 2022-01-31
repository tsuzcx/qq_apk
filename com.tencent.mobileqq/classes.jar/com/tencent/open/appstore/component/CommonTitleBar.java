package com.tencent.open.appstore.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdhb;
import bdhc;
import bdhd;
import bdhe;

public class CommonTitleBar
  extends RelativeLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bdhe jdField_a_of_type_Bdhe;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public CommonTitleBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CommonTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CommonTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131559470, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367772));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bdhb(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378515));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bdhc(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378548));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367773));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bdhd(this));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372004));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void c()
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void setBackText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void setIClickListener(bdhe parambdhe)
  {
    this.jdField_a_of_type_Bdhe = parambdhe;
  }
  
  public void setTitleText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.component.CommonTitleBar
 * JD-Core Version:    0.7.0.1
 */