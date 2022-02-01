package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.tencent.mobileqq.widget.FormResHelper;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.widget.MultiImageTextView;

public class GameRankFormItem
  extends FormSimpleItem
{
  public int a;
  
  public GameRankFormItem(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetMultiImageTextView == null) {
      return;
    }
    b();
    if (this.jdField_d_of_type_AndroidWidgetTextView != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setMaxWidth(this.o);
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      if (this.jdField_d_of_type_JavaLangCharSequence == null) {
        this.jdField_d_of_type_JavaLangCharSequence = "";
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
      int i = this.jdField_a_of_type_Int;
      if (i >= 4)
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetMultiImageTextView;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangCharSequence);
        ((StringBuilder)localObject2).append(String.valueOf(this.jdField_a_of_type_Int));
        ((MultiImageTextView)localObject1).setText(((StringBuilder)localObject2).toString());
      }
      else if (i > 0)
      {
        localObject1 = getResources();
        i = this.jdField_a_of_type_Int;
        if (i == 1) {
          i = 2130843907;
        } else if (i == 2) {
          i = 2130843908;
        } else {
          i = 2130843909;
        }
        localObject1 = ((Resources)localObject1).getDrawable(i);
        localObject2 = this.jdField_d_of_type_JavaLangCharSequence;
        TextPaint localTextPaint = this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.getPaint();
        int k = this.n;
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          i = 0;
        } else {
          i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
        }
        int j;
        if (this.jdField_a_of_type_Boolean) {
          j = this.b.getIntrinsicWidth();
        } else {
          j = 0;
        }
        localObject2 = TextUtils.ellipsize((CharSequence)localObject2, localTextPaint, k - i - j - ((Drawable)localObject1).getIntrinsicWidth(), TextUtils.TruncateAt.END);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText((CharSequence)localObject2);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a((Drawable)localObject1, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight()).c();
      }
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(FormResHelper.a(getResources(), this.m));
      Object localObject1 = this.jdField_a_of_type_ComTencentWidgetMultiImageTextView;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_d_of_type_JavaLangCharSequence);
      ((StringBuilder)localObject2).append(String.valueOf(this.jdField_a_of_type_Int));
      ((MultiImageTextView)localObject1).setContentDescription(((StringBuilder)localObject2).toString());
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setMaxWidth(this.n);
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        if ((this.k > 0) && (this.l > 0))
        {
          this.b.setBounds(0, 0, this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.b, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.b, null);
        }
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        if ((this.k > 0) && (this.l > 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.b, null);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText("");
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        if ((this.k > 0) && (this.l > 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
          this.b.setBounds(0, 0, this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.b, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.b, null);
        }
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        if ((this.k > 0) && (this.l > 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.k, this.l);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        else
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.b, null);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
        return;
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.GameRankFormItem
 * JD-Core Version:    0.7.0.1
 */