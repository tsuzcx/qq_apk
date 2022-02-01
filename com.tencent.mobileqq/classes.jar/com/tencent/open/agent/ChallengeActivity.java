package com.tencent.open.agent;

import Override;
import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import bjgt;
import bjgv;
import bjgw;
import bjkn;
import bjko;
import bjlu;
import bjre;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ChallengeActivity
  extends ChallengeBragBase
  implements View.OnClickListener, bjgv, bjre
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
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout = ((KeyboardDetectorRelativeLayout)super.findViewById(2131376852));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_b_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131378322));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380074));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131366263));
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131378321));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363790));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363787));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363174));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363175));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.a(this);
    this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new bjkn(this.jdField_a_of_type_AndroidWidgetEditText, 100) };
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
        this.jdField_a_of_type_JavaLangString = bjgw.a(this.jdField_c_of_type_JavaLangString, this.d);
        this.jdField_b_of_type_JavaLangString = bjgw.a(this.jdField_c_of_type_JavaLangString, this.h);
        Bitmap localBitmap1 = bjgt.a().a(this.jdField_a_of_type_JavaLangString);
        Bitmap localBitmap2 = bjgt.a().a(this.jdField_b_of_type_JavaLangString);
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
        bjko.c("ChallengeActivity", "getNickName error. " + localException.getMessage(), localException);
        c();
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840348);
      bjgt.a().a(this.jdField_a_of_type_JavaLangString, this);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840348);
    bjgt.a().a(this.jdField_b_of_type_JavaLangString, this);
  }
  
  public void a(int paramInt)
  {
    int i = DisplayUtil.px2dip(this, paramInt) - 10 - 10;
    if ((this.jdField_a_of_type_AndroidWidgetScrollView != null) && (i < 255))
    {
      paramInt = i - 20 - 30 - 5 - 145;
      i = i - 20 - 5 - 145;
      if ((paramInt > 0) && (paramInt < 55))
      {
        this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = DisplayUtil.dip2px(this, paramInt);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(true);
        this.jdField_b_of_type_AndroidWidgetScrollView.getLayoutParams().height = DisplayUtil.dip2px(this, 30.0F);
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
      this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().height = DisplayUtil.dip2px(this, i);
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
      this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = DisplayUtil.dip2px(this, 55.0F);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetScrollView.getLayoutParams().height = DisplayUtil.dip2px(this, 30.0F);
      this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
      this.jdField_b_of_type_AndroidWidgetScrollView.setVisibility(0);
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
    super.setContentView(2131559716);
    super.a();
    a();
    bjlu.a("100", "ANDROIDQQ.PK.FS", this.jdField_c_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeActivity
 * JD-Core Version:    0.7.0.1
 */