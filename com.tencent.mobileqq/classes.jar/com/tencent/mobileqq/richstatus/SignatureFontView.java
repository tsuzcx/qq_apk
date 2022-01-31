package com.tencent.mobileqq.richstatus;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import avdp;
import avgb;
import axkd;
import baoj;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.item.SignatureView;
import fs;

public class SignatureFontView
  extends RelativeLayout
{
  public float a;
  private int jdField_a_of_type_Int;
  public TextPaint a;
  public ETTextView a;
  public SignatureView a;
  private fs jdField_a_of_type_Fs = new avdp(this);
  public boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1;
  private int c = 1;
  
  public SignatureFontView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    a();
  }
  
  public SignatureFontView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    a();
  }
  
  public SignatureFontView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    a();
  }
  
  private void a()
  {
    this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = getResources().getDisplayMetrics().widthPixels;
    this.jdField_a_of_type_Float = (13.0F * this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView = new SignatureView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.setId(2131310415);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView, localLayoutParams);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = new ETTextView(getContext());
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setId(2131310429);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextAnimationListener(this.jdField_a_of_type_Fs);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextSize(15.0F);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.d = true;
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setMovementMethod(avgb.a());
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    addView(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, localLayoutParams);
  }
  
  public void setAnimation(int paramInt, String paramString, baoj parambaoj)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.setAnimation(paramInt, paramString, parambaoj);
  }
  
  public void setBGDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView);
    }
  }
  
  public void setContentColor(int paramInt)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextColor(paramInt);
  }
  
  public void setFont(ETFont paramETFont, long paramLong)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setFont(paramETFont, paramLong);
  }
  
  public void setInAIO(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.f = paramBoolean;
  }
  
  public void setSigViewSize(int paramInt1, int paramInt2)
  {
    setSigViewSize(paramInt1, paramInt2, 20);
  }
  
  public void setSigViewSize(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.a(paramInt1, paramInt2);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLayoutParams();
    localLayoutParams.topMargin = ((int)(paramInt2 + paramInt3 * this.jdField_b_of_type_Float));
    if (this.jdField_a_of_type_Boolean) {}
    for (localLayoutParams.leftMargin = ((int)(this.jdField_b_of_type_Float * 20.0F) + (this.jdField_a_of_type_Int - paramInt1) / 2);; localLayoutParams.leftMargin = ((int)(this.jdField_b_of_type_Float * 20.0F)))
    {
      localLayoutParams.width = (paramInt1 - (int)(40.0F * this.jdField_b_of_type_Float));
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setMaxWidth(localLayoutParams.width);
      return;
    }
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    paramCharSequence = new axkd(paramCharSequence, 1, 20);
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setText(paramCharSequence);
  }
  
  public void setTextAnimationRepeatTime(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setTextClickListener(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setOnClickListener(paramOnClickListener);
  }
  
  public void setTitleColor(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_Int = paramInt;
  }
  
  public void setTitleContent(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemSignatureView.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureFontView
 * JD-Core Version:    0.7.0.1
 */