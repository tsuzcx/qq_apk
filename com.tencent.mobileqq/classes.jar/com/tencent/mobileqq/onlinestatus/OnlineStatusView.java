package com.tencent.mobileqq.onlinestatus;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class OnlineStatusView
  extends LinearLayout
{
  int jdField_a_of_type_Int = 1;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  TextView b;
  
  public OnlineStatusView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public OnlineStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public OnlineStatusView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public int a()
  {
    CharSequence localCharSequence1 = this.jdField_a_of_type_AndroidWidgetTextView.getText();
    CharSequence localCharSequence2 = this.b.getText();
    int i = (int)this.jdField_a_of_type_AndroidWidgetTextView.getPaint().measureText(localCharSequence1, 0, localCharSequence1.length());
    int j = (int)this.b.getPaint().measureText(localCharSequence2, 0, localCharSequence2.length());
    int k = ViewUtils.a(2.0F);
    int m = ViewUtils.a(12.0F);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusView", 2, new Object[] { "prefixLen:", Integer.valueOf(i), " suffixLen:", Integer.valueOf(j), " iconLen:", Integer.valueOf(m) });
    }
    return i + m + j + k;
  }
  
  public TextView a()
  {
    return this.b;
  }
  
  public CharSequence a()
  {
    CharSequence localCharSequence1 = this.jdField_a_of_type_AndroidWidgetTextView.getText();
    CharSequence localCharSequence2 = this.b.getText();
    StringBuilder localStringBuilder = new StringBuilder(10);
    localStringBuilder.append(localCharSequence1);
    localStringBuilder.append(localCharSequence2);
    return localStringBuilder.toString();
  }
  
  void a()
  {
    setOrientation(0);
    setGravity(16);
    float f = getResources().getDimensionPixelSize(2131296774);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setDuplicateParentStateEnabled(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167142));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(0, f);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("[");
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(16);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.a(19.0F));
    localLayoutParams.gravity = 16;
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
    this.jdField_a_of_type_ComTencentImageURLImageView.setDuplicateParentStateEnabled(false);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.a(12.0F), ViewUtils.a(12.0F));
    localLayoutParams.gravity = 16;
    localLayoutParams.leftMargin = ViewUtils.a(2.0F);
    localLayoutParams.rightMargin = ViewUtils.a(2.0F);
    addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
    this.b = new TextView(getContext());
    this.b.setDuplicateParentStateEnabled(false);
    this.b.setIncludeFontPadding(false);
    this.b.setSingleLine(true);
    this.b.setTextColor(getResources().getColor(2131167142));
    this.b.setTextSize(0, f);
    this.b.setGravity(16);
    localLayoutParams = new LinearLayout.LayoutParams(-2, ViewUtils.a(19.0F));
    localLayoutParams.gravity = 16;
    addView(this.b, localLayoutParams);
  }
  
  public void setDescText(String paramString)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      TextView localTextView = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      localTextView.setText(localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.b.setText(paramString);
  }
  
  public void setIconDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
  }
  
  public void setTextSize(int paramInt)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    float f = paramInt;
    localTextView.setTextSize(0, f);
    this.b.setTextSize(0, f);
  }
  
  public void setViewStyle(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusView
 * JD-Core Version:    0.7.0.1
 */