package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import bcqy;
import bcra;
import bcrb;

public class FollowImageTextView
  extends LinearLayout
{
  private int jdField_a_of_type_Int = 2147483647;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bcqy jdField_a_of_type_Bcqy;
  private bcra jdField_a_of_type_Bcra;
  private bcrb jdField_a_of_type_Bcrb;
  private CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 10;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  
  public FollowImageTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public FollowImageTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public FollowImageTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  @RequiresApi(api=21)
  public FollowImageTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private bcrb a()
  {
    if (this.jdField_a_of_type_Bcrb == null) {
      this.jdField_a_of_type_Bcrb = new bcrb(this);
    }
    return this.jdField_a_of_type_Bcrb;
  }
  
  private void a()
  {
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1;
    if (this.jdField_a_of_type_Int < 2)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if (!this.jdField_a_of_type_Boolean) {
        break label95;
      }
      this.jdField_a_of_type_Bcqy.setMaxLines(1);
      this.jdField_a_of_type_Bcqy.setEllipsize(TextUtils.TruncateAt.END);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcqy.setText(this.jdField_a_of_type_JavaLangCharSequence);
      if (((this.jdField_a_of_type_Boolean ^ bool2)) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Bcra != null)) {
        this.jdField_a_of_type_Bcra.a(1);
      }
      return;
      bool1 = false;
      break;
      label95:
      this.jdField_a_of_type_Bcqy.setMaxLines(this.jdField_a_of_type_Int - 1);
      this.jdField_a_of_type_Bcqy.setEllipsize(null);
    }
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_Bcqy = new bcqy(this, paramContext);
    this.jdField_a_of_type_Bcqy.setId(2131373112);
    this.jdField_a_of_type_Bcqy.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_Bcqy);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(0);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    addView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131373113);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.jdField_a_of_type_AndroidWidgetTextView.setIncludeFontPadding(false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    localLayoutParams.leftMargin = ((int)(paramContext.getResources().getDisplayMetrics().density * this.jdField_b_of_type_Int + 0.5F));
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  private void a(boolean paramBoolean)
  {
    int i = this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility();
    if (((paramBoolean) && (i == 0)) || ((!paramBoolean) && (i == 8))) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
  }
  
  public void setAllChildOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_Bcqy.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(paramOnClickListener);
  }
  
  public void setAllChildOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_Bcqy.setOnTouchListener(paramOnTouchListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(paramOnTouchListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(paramOnTouchListener);
  }
  
  public void setAllChildTag(Object paramObject)
  {
    this.jdField_a_of_type_Bcqy.setTag(paramObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setTag(paramObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramObject);
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_Bcqy.setContentDescription(paramCharSequence);
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramCharSequence);
  }
  
  public void setFollowImageResource(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
  }
  
  public void setFollowImageVisibility(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(paramInt);
  }
  
  public void setFollowImageWH(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
  }
  
  public void setMaxLines(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.jdField_a_of_type_Bcqy.setMaxWidth(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(paramInt);
  }
  
  public void setOnTextLineChangeListener(bcra parambcra)
  {
    this.jdField_a_of_type_Bcra = parambcra;
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangCharSequence, paramCharSequence)) {
      return;
    }
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    a();
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_Bcqy.setTextColor(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
  
  public void setTextSize(float paramFloat)
  {
    this.jdField_a_of_type_Bcqy.setTextSize(paramFloat);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_Bcqy.setTextSize(paramInt, paramFloat);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(paramInt, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FollowImageTextView
 * JD-Core Version:    0.7.0.1
 */