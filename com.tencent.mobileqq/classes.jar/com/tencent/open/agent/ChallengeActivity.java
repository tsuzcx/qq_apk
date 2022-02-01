package com.tencent.open.agent;

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
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.open.agent.datamodel.ImageLoader.ImageLoadListener;
import com.tencent.open.agent.datamodel.QZonePortraitData;
import com.tencent.open.base.LengthInputFilter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.widget.IKeyboardChanged;
import com.tencent.open.widget.KeyboardDetectorRelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ChallengeActivity
  extends ChallengeBragBase
  implements View.OnClickListener, ImageLoader.ImageLoadListener, IKeyboardChanged
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
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout = ((KeyboardDetectorRelativeLayout)super.findViewById(2131376718));
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.setFitsSystemWindows(true);
      this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.jdField_b_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131378143));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131379810));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)super.findViewById(2131366316));
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131378142));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363817));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131363814));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363163));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363164));
    this.jdField_a_of_type_ComTencentOpenWidgetKeyboardDetectorRelativeLayout.a(this);
    this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
    this.jdField_a_of_type_ArrayOfAndroidTextInputFilter = new InputFilter[] { new LengthInputFilter(this.jdField_a_of_type_AndroidWidgetEditText, 100) };
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
    this.jdField_a_of_type_AndroidWidgetEditText.setText(this.i);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetScrollView;
    if (localObject1 != null) {
      ((ScrollView)localObject1).setVerticalFadingEdgeEnabled(false);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    try
    {
      a(this.h);
      this.jdField_a_of_type_JavaLangString = QZonePortraitData.a(this.jdField_c_of_type_JavaLangString, this.d);
      this.jdField_b_of_type_JavaLangString = QZonePortraitData.a(this.jdField_c_of_type_JavaLangString, this.h);
      localObject1 = ImageLoader.a().a(this.jdField_a_of_type_JavaLangString);
      localObject2 = ImageLoader.a().a(this.jdField_b_of_type_JavaLangString);
      if (localObject1 != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject1);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840321);
        ImageLoader.a().a(this.jdField_a_of_type_JavaLangString, this);
      }
      if (localObject2 != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840321);
      ImageLoader.a().a(this.jdField_b_of_type_JavaLangString, this);
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getNickName error. ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      LogUtility.c("ChallengeActivity", ((StringBuilder)localObject2).toString(), localException);
      c();
    }
  }
  
  public void a(int paramInt)
  {
    paramInt = DisplayUtil.b(this, paramInt) - 10 - 10;
    ScrollView localScrollView = this.jdField_a_of_type_AndroidWidgetScrollView;
    if ((localScrollView != null) && (paramInt < 255))
    {
      int i = paramInt - 20;
      paramInt = i - 30 - 5 - 145;
      i = i - 5 - 145;
      if ((paramInt > 0) && (paramInt < 55))
      {
        localScrollView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = DisplayUtil.a(this, paramInt);
        this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(true);
        this.jdField_b_of_type_AndroidWidgetScrollView.getLayoutParams().height = DisplayUtil.a(this, 30.0F);
        this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
        this.jdField_b_of_type_AndroidWidgetScrollView.setVisibility(0);
        return;
      }
      if ((paramInt <= 0) && (i > 0) && (i < 30))
      {
        this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
        this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams().height = DisplayUtil.a(this, i);
        this.jdField_b_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(true);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetScrollView.getLayoutParams().height = 0;
      this.jdField_b_of_type_AndroidWidgetScrollView.setVisibility(8);
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(paramString1))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
      return;
    }
    if (this.jdField_b_of_type_JavaLangString.equals(paramString1)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void b()
  {
    ScrollView localScrollView = this.jdField_a_of_type_AndroidWidgetScrollView;
    if (localScrollView != null)
    {
      localScrollView.getLayoutParams().height = DisplayUtil.a(this, 55.0F);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVerticalFadingEdgeEnabled(false);
      this.jdField_a_of_type_AndroidWidgetScrollView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetScrollView.getLayoutParams().height = DisplayUtil.a(this, 30.0F);
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.getWindow().requestFeature(1);
    super.onCreate(paramBundle);
    super.setContentView(2131559669);
    super.a();
    a();
    StaticAnalyz.a("100", "ANDROIDQQ.PK.FS", this.jdField_c_of_type_JavaLangString, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.ChallengeActivity
 * JD-Core Version:    0.7.0.1
 */