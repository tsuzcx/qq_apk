package com.tencent.open.agent;

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
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.base.LengthInputFilter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.widget.IKeyboardChanged;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BragActivity
  extends ChallengeBragBase
  implements IKeyboardChanged
{
  protected ImageView a;
  protected ScrollView a;
  protected KeyboardDetectorRelativeLayout a;
  protected InputFilter[] a;
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131363794));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout = ((KeyboardDetectorRelativeLayout)super.findViewById(2131376660));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.a(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363793));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131366316));
    this.b = ((TextView)super.findViewById(2131365639));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365633));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379553));
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new LengthInputFilter(this.jdField_a_of_type_AndroidWidgetEditText, 100) };
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.i);
    this.b.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    try
    {
      a(this.h);
      Bitmap localBitmap = ImageLoader.a().a(this.j);
      if (localBitmap != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840321);
      ImageLoader.a().a(this.j, new BragActivity.1(this));
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNickName error. ");
      localStringBuilder.append(localException.getMessage());
      LogUtility.c("BragActivity", localStringBuilder.toString(), localException);
      c();
    }
  }
  
  public void a(int paramInt)
  {
    paramInt = DisplayUtil.b(this, paramInt) - 10 - 10;
    ScrollView localScrollView = this.jdField_a_of_type_AndroidWidgetScrollView;
    if ((localScrollView != null) && (paramInt < 255))
    {
      paramInt = paramInt - 20 - 145;
      if ((paramInt > 0) && (paramInt < 90))
      {
        localScrollView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = DisplayUtil.a(this, paramInt);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(true);
        return;
      }
      if (paramInt <= 0)
      {
        this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
        this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(8);
      }
    }
  }
  
  public void b()
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null)
    {
      localImageView.getLayoutParams().height = DisplayUtil.a(this, 90.0F);
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.getWindow().requestFeature(1);
    super.onCreate(paramBundle);
    super.setContentView(2131559668);
    super.a();
    a();
    StaticAnalyz.a("100", "ANDROIDQQ.BRAG.FS", this.jdField_c_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.BragActivity
 * JD-Core Version:    0.7.0.1
 */