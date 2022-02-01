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
import bjca;
import bjgt;
import bjkn;
import bjko;
import bjlu;
import bjre;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BragActivity
  extends ChallengeBragBase
  implements bjre
{
  public ImageView a;
  protected ScrollView a;
  protected KeyboardDetectorRelativeLayout a;
  protected InputFilter[] a;
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131363767));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout = ((KeyboardDetectorRelativeLayout)super.findViewById(2131376794));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.a(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363766));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131366263));
    this.b = ((TextView)super.findViewById(2131365639));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365633));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379807));
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new bjkn(this.jdField_a_of_type_AndroidWidgetEditText, 100) };
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.i);
    this.b.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    try
    {
      a(this.h);
      Bitmap localBitmap = bjgt.a().a(this.j);
      if (localBitmap != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        return;
      }
    }
    catch (Exception localException)
    {
      bjko.c("BragActivity", "getNickName error. " + localException.getMessage(), localException);
      c();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840348);
    bjgt.a().a(this.j, new bjca(this));
  }
  
  public void a(int paramInt)
  {
    paramInt = DisplayUtil.px2dip(this, paramInt) - 10 - 10;
    if ((this.jdField_a_of_type_AndroidWidgetScrollView != null) && (paramInt < 255))
    {
      paramInt = paramInt - 20 - 145;
      if ((paramInt <= 0) || (paramInt >= 90)) {
        break label79;
      }
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = DisplayUtil.dip2px(this, paramInt);
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
      this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams().height = DisplayUtil.dip2px(this, 90.0F);
      this.jdField_a_of_type_AndroidWidgetImageView.setVerticalFadingEdgeEnabled(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
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
    super.setContentView(2131559715);
    super.a();
    a();
    bjlu.a("100", "ANDROIDQQ.BRAG.FS", this.jdField_c_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.BragActivity
 * JD-Core Version:    0.7.0.1
 */