package com.tencent.open.appstore.component;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bfki;
import bfkj;
import bfkk;
import bfkl;

public class CommonTitleBar
  extends RelativeLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfkl jdField_a_of_type_Bfkl;
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
    LayoutInflater.from(paramContext).inflate(2131559521, this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367917));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new bfki(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379185));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bfkj(this));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379218));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367918));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new bfkk(this));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372341));
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
  
  public void setIClickListener(bfkl parambfkl)
  {
    this.jdField_a_of_type_Bfkl = parambfkl;
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