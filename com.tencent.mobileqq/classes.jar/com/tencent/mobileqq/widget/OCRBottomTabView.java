package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qqocr.impl.R.styleable;

public class OCRBottomTabView
  extends LinearLayout
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public OCRBottomTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public OCRBottomTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2131561255, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379469));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369181));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aH);
    paramAttributeSet = paramContext.getString(R.styleable.x);
    Drawable localDrawable = paramContext.getDrawable(R.styleable.w);
    paramContext.recycle();
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAttributeSet);
    }
    if (localDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    }
  }
  
  public CharSequence a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView.getText();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(paramBoolean);
  }
  
  public void setTabImage(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setTabText(String paramString)
  {
    if (paramString != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public void setTabTextColor(int paramInt)
  {
    ColorStateList localColorStateList = ColorStateList.valueOf(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(localColorStateList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OCRBottomTabView
 * JD-Core Version:    0.7.0.1
 */