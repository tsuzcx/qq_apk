package com.tencent.open.agent;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import bawz;
import bddz;
import bdeb;
import bdec;
import bdhs;
import bdht;
import bdjc;
import bdov;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ChallengeActivity
  extends ChallengeBragBase
  implements View.OnClickListener, bdeb, bdov
{
  protected ImageView a;
  protected ScrollView a;
  protected KeyboardDetectorRelativeLayout a;
  protected String a;
  protected InputFilter[] a;
  protected ImageView b;
  protected ScrollView b;
  protected String b;
  
  @TargetApi(14)
  protected void a()
  {
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout = ((KeyboardDetectorRelativeLayout)super.findViewById(2131375407));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_b_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131376730));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131378281));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131365749));
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131376729));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363428));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363425));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362969));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131362970));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.a(this);
    this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new bdhs(this.jdField_a_of_type_AndroidWidgetEditText, 100) };
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.i);
    if (this.jdField_a_of_type_AndroidWidgetScrollView != null) {
      this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    for (;;)
    {
      try
      {
        a(this.h);
        this.jdField_a_of_type_JavaLangString = bdec.a(this.jdField_c_of_type_JavaLangString, this.d);
        this.jdField_b_of_type_JavaLangString = bdec.a(this.jdField_c_of_type_JavaLangString, this.h);
        Bitmap localBitmap1 = bddz.a().a(this.jdField_a_of_type_JavaLangString);
        Bitmap localBitmap2 = bddz.a().a(this.jdField_b_of_type_JavaLangString);
        if (localBitmap1 != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
          if (localBitmap2 == null) {
            break;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap2);
          return;
        }
      }
      catch (Exception localException)
      {
        bdht.c("ChallengeActivity", "getNickName error. " + localException.getMessage(), localException);
        c();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839736);
      bddz.a().a(this.jdField_a_of_type_JavaLangString, this);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839736);
    bddz.a().a(this.jdField_b_of_type_JavaLangString, this);
  }
  
  public void a(int paramInt)
  {
    int i = bawz.b(this, paramInt) - 10 - 10;
    if ((this.jdField_a_of_type_AndroidWidgetScrollView != null) && (i < 255))
    {
      paramInt = i - 20 - 30 - 5 - 145;
      i = i - 20 - 5 - 145;
      if ((paramInt > 0) && (paramInt < 55))
      {
        this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = bawz.a(this, paramInt);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(true);
        this.jdField_b_of_type_AndroidWidgetScrollView.getLayoutParams().height = bawz.a(this, 30.0F);
        this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
        this.jdField_b_of_type_AndroidWidgetScrollView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    if ((paramInt <= 0) && (i > 0) && (i < 30))
    {
      this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().height = bawz.a(this, i);
      this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
    this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
    this.jdField_b_of_type_AndroidWidgetScrollView.setVisibility(8);
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(paramString1)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    while (!this.jdField_b_of_type_JavaLangString.equals(paramString1)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetScrollView != null)
    {
      this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = bawz.a(this, 55.0F);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetScrollView.getLayoutParams().height = bawz.a(this, 30.0F);
      this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
      this.jdField_b_of_type_AndroidWidgetScrollView.setVisibility(0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().requestFeature(1);
    super.onCreate(paramBundle);
    super.setContentView(2131559485);
    super.a();
    a();
    bdjc.a("100", "ANDROIDQQ.PK.FS", this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeActivity
 * JD-Core Version:    0.7.0.1
 */