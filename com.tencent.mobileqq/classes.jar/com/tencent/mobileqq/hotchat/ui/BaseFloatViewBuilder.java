package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator.Config;

public abstract class BaseFloatViewBuilder
{
  protected int a;
  protected Context a;
  protected Bitmap a;
  protected HeartAnimator a;
  
  public BaseFloatViewBuilder(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public BaseFloatViewBuilder(Context paramContext, int paramInt, HeartAnimator paramHeartAnimator)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator = paramHeartAnimator;
  }
  
  public Bitmap a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartAnimator.a());
    }
    return null;
  }
  
  public void a(HeartAnimator.Config paramConfig)
  {
    paramConfig.c = 1.0F;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.BaseFloatViewBuilder
 * JD-Core Version:    0.7.0.1
 */