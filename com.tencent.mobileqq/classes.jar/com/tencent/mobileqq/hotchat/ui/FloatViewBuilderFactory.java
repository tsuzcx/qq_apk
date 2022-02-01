package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;

public class FloatViewBuilderFactory
{
  protected Context a;
  protected BaseFloatViewBuilder a;
  protected BaseFloatViewBuilder b;
  protected BaseFloatViewBuilder c;
  
  public FloatViewBuilderFactory(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public BaseFloatViewBuilder a(int paramInt, HeartAnimator paramHeartAnimator)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqHotchatUiBaseFloatViewBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqHotchatUiBaseFloatViewBuilder = new FloatViewBuilder(this.jdField_a_of_type_AndroidContentContext, 2130846200, paramHeartAnimator);
      }
      return this.jdField_a_of_type_ComTencentMobileqqHotchatUiBaseFloatViewBuilder;
    case 2: 
      if (this.c == null) {
        this.c = new PayLikeFloatViewBuilder(this.jdField_a_of_type_AndroidContentContext, 2130842789, paramHeartAnimator);
      }
      return this.c;
    }
    if (this.b == null) {
      this.b = new FloatViewBuilder(this.jdField_a_of_type_AndroidContentContext, 2130846204, paramHeartAnimator);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.FloatViewBuilderFactory
 * JD-Core Version:    0.7.0.1
 */