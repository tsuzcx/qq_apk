package com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.bean.TagInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class Tag
{
  private int jdField_a_of_type_Int = 0;
  TagInfo jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo;
  private Tag jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampTag;
  private int jdField_b_of_type_Int = 0;
  private Tag jdField_b_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampTag;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  
  public Tag(TagInfo paramTagInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo = paramTagInfo;
    this.f = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297313);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Tag a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampTag;
  }
  
  public void a(int paramInt)
  {
    this.f = ((int)DisplayUtils.a(BaseApplicationImpl.getContext(), paramInt));
  }
  
  public void a(Tag paramTag)
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampTag = paramTag;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public Tag b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampTag;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(Tag paramTag)
  {
    this.jdField_b_of_type_ComTencentMobileqqExtendfriendWigetHorseRaceLampTag = paramTag;
  }
  
  public int c()
  {
    if (this.d != 0)
    {
      if (this.f != 0) {
        return this.d + this.f;
      }
      this.f = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297313);
      return this.d + this.f;
    }
    return 0;
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public int d()
  {
    if (this.c != 0) {
      return this.c;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo.a)))
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject2 = TagInfosAdapter.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo.a, ((QQAppInterface)localObject1).getApp().getBaseContext());
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanTagInfo.a;
      }
      int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297318);
      localObject2 = new TextPaint();
      ((TextPaint)localObject2).setAntiAlias(true);
      ((TextPaint)localObject2).setDither(true);
      ((TextPaint)localObject2).setTextSize(i);
      this.c = ((int)((TextPaint)localObject2).measureText((String)localObject1) + (BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297317) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297316) * 2 + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297313) + BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297314)));
    }
    for (;;)
    {
      return this.c;
      QLog.e("TAG horserace", 2, " GET WIDTH WITH NULL INFO");
    }
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.horseRaceLamp.Tag
 * JD-Core Version:    0.7.0.1
 */