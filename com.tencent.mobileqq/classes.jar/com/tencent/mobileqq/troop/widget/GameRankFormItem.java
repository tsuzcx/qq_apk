package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
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
    if (this.jdField_a_of_type_ComTencentWidgetMultiImageTextView == null) {}
    label282:
    label319:
    label448:
    do
    {
      do
      {
        return;
        c();
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setMaxWidth(this.i);
        }
        if (this.jdField_a_of_type_Int <= 0) {
          break;
        }
        if (this.jdField_c_of_type_JavaLangCharSequence == null) {
          this.jdField_c_of_type_JavaLangCharSequence = "";
        }
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        if (this.jdField_a_of_type_Int >= 4)
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText(this.jdField_c_of_type_JavaLangCharSequence + String.valueOf(this.jdField_a_of_type_Int));
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setTextColor(a(getResources(), this.g));
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setContentDescription(this.jdField_c_of_type_JavaLangCharSequence + String.valueOf(this.jdField_a_of_type_Int));
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setMaxWidth(this.h);
          if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (!this.jdField_a_of_type_Boolean)) {
            break label448;
          }
          if ((this.e <= 0) || (this.f <= 0)) {
            break label428;
          }
          this.b.setBounds(0, 0, this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.e, this.f);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.b, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
          return;
          if (this.jdField_a_of_type_Int <= 0) {
            break;
          }
          Object localObject = getResources();
          int i;
          CharSequence localCharSequence;
          TextPaint localTextPaint;
          int k;
          if (this.jdField_a_of_type_Int == 1)
          {
            i = 2130841310;
            localObject = ((Resources)localObject).getDrawable(i);
            localCharSequence = this.jdField_c_of_type_JavaLangCharSequence;
            localTextPaint = this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.getPaint();
            k = this.h;
            if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
              break label412;
            }
            i = 0;
            if (!this.jdField_a_of_type_Boolean) {
              break label423;
            }
          }
          for (int j = this.b.getIntrinsicWidth();; j = 0)
          {
            localCharSequence = TextUtils.ellipsize(localCharSequence, localTextPaint, k - i - j - ((Drawable)localObject).getIntrinsicWidth(), TextUtils.TruncateAt.END);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText(localCharSequence);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.a((Drawable)localObject, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight()).a();
            break;
            if (this.jdField_a_of_type_Int == 2)
            {
              i = 2130841311;
              break label282;
            }
            i = 2130841312;
            break label282;
            i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
            break label319;
          }
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.b, null);
        }
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
        {
          if ((this.e > 0) && (this.f > 0))
          {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.e, this.f);
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
            return;
            this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
          }
        }
        if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.b, null);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
          return;
        }
      } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
      return;
      this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setText("");
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        if ((this.e > 0) && (this.f > 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.e, this.f);
          this.b.setBounds(0, 0, this.b.getIntrinsicWidth(), this.b.getIntrinsicHeight());
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.b, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(8);
          return;
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, this.b, null);
        }
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        if ((this.e > 0) && (this.f > 0))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.e, this.f);
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
          return;
          this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
        }
      }
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, this.b, null);
        this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setCompoundDrawablePadding(0);
        return;
      }
    } while ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Boolean));
    label412:
    label423:
    label428:
    this.jdField_a_of_type_ComTencentWidgetMultiImageTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.GameRankFormItem
 * JD-Core Version:    0.7.0.1
 */