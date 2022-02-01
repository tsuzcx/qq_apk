package com.tencent.open.agent;

import Override;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import bhgr;
import bjlp;
import bjqd;
import bjtw;
import bjtx;
import bjvg;
import bkas;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BragActivity
  extends ChallengeBragBase
  implements bkas
{
  public ImageView a;
  protected ScrollView a;
  protected KeyboardDetectorRelativeLayout a;
  protected InputFilter[] a;
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131363665));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout = ((KeyboardDetectorRelativeLayout)super.findViewById(2131376765));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.a(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363664));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131366133));
    this.b = ((TextView)super.findViewById(2131365514));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365508));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379714));
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new bjtw(this.jdField_a_of_type_AndroidWidgetEditText, 100) };
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.i);
    this.b.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    try
    {
      a(this.h);
      Bitmap localBitmap = bjqd.a().a(this.j);
      if (localBitmap != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        return;
      }
    }
    catch (Exception localException)
    {
      bjtx.c("BragActivity", "getNickName error. " + localException.getMessage(), localException);
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840274);
    bjqd.a().a(this.j, new bjlp(this));
  }
  
  public void a(int paramInt)
  {
    paramInt = bhgr.b(this, paramInt) - 10 - 10;
    if ((this.jdField_a_of_type_AndroidWidgetScrollView != null) && (paramInt < 255))
    {
      paramInt = paramInt - 20 - 145;
      if ((paramInt <= 0) || (paramInt >= 90)) {
        break label79;
      }
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = bhgr.a(this, paramInt);
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
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = bhgr.a(this, 90.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVerticalFadingEdgeEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.getWindow().requestFeature(1);
    super.onCreate(paramBundle);
    super.setContentView(2131559677);
    super.a();
    a();
    bjvg.a("100", "ANDROIDQQ.BRAG.FS", this.jdField_c_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BragActivity
 * JD-Core Version:    0.7.0.1
 */