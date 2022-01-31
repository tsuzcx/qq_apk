package com.tencent.open.agent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import azvv;
import bbvm;
import bbzz;
import bcdr;
import bcds;
import bcfb;
import bcku;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;

public class BragActivity
  extends ChallengeBragBase
  implements bcku
{
  public ImageView a;
  protected ScrollView a;
  protected KeyboardDetectorRelativeLayout a;
  protected InputFilter[] a;
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131297862));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout = ((KeyboardDetectorRelativeLayout)super.findViewById(2131309604));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.a(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297861));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131300152));
    this.b = ((TextView)super.findViewById(2131299574));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299568));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131312255));
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new bcdr(this.jdField_a_of_type_AndroidWidgetEditText, 100) };
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.i);
    this.b.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    try
    {
      a(this.h);
      Bitmap localBitmap = bbzz.a().a(this.j);
      if (localBitmap != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        return;
      }
    }
    catch (Exception localException)
    {
      bcds.c("BragActivity", "getNickName error. " + localException.getMessage(), localException);
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839687);
    bbzz.a().a(this.j, new bbvm(this));
  }
  
  public void a(int paramInt)
  {
    paramInt = azvv.b(this, paramInt) - 10 - 10;
    if ((this.jdField_a_of_type_AndroidWidgetScrollView != null) && (paramInt < 255))
    {
      paramInt = paramInt - 20 - 145;
      if ((paramInt <= 0) || (paramInt >= 90)) {
        break label79;
      }
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = azvv.a(this, paramInt);
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
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = azvv.a(this, 90.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVerticalFadingEdgeEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().requestFeature(1);
    super.onCreate(paramBundle);
    super.setContentView(2131493916);
    super.a();
    a();
    bcfb.a("100", "ANDROIDQQ.BRAG.FS", this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BragActivity
 * JD-Core Version:    0.7.0.1
 */