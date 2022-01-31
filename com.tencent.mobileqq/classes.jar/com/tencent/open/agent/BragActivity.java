package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import bcwh;
import bezd;
import bfdm;
import bfhf;
import bfhg;
import bfip;
import bfoh;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;

public class BragActivity
  extends ChallengeBragBase
  implements bfoh
{
  public ImageView a;
  protected ScrollView a;
  protected KeyboardDetectorRelativeLayout a;
  protected InputFilter[] a;
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131363446));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout = ((KeyboardDetectorRelativeLayout)super.findViewById(2131375840));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.a(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363445));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131365834));
    this.b = ((TextView)super.findViewById(2131365226));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365220));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378629));
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new bfhf(this.jdField_a_of_type_AndroidWidgetEditText, 100) };
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.i);
    this.b.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    try
    {
      a(this.h);
      Bitmap localBitmap = bfdm.a().a(this.j);
      if (localBitmap != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        return;
      }
    }
    catch (Exception localException)
    {
      bfhg.c("BragActivity", "getNickName error. " + localException.getMessage(), localException);
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840084);
    bfdm.a().a(this.j, new bezd(this));
  }
  
  public void a(int paramInt)
  {
    paramInt = bcwh.b(this, paramInt) - 10 - 10;
    if ((this.jdField_a_of_type_AndroidWidgetScrollView != null) && (paramInt < 255))
    {
      paramInt = paramInt - 20 - 145;
      if ((paramInt <= 0) || (paramInt >= 90)) {
        break label79;
      }
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = bcwh.a(this, paramInt);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(true);
    }
    label79:
    while (paramInt > 0) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
    this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(8);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = bcwh.a(this, 90.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVerticalFadingEdgeEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().requestFeature(1);
    super.onCreate(paramBundle);
    super.setContentView(2131559536);
    super.a();
    a();
    bfip.a("100", "ANDROIDQQ.BRAG.FS", this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BragActivity
 * JD-Core Version:    0.7.0.1
 */