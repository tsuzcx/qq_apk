package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import anyb;
import aocs;
import aocu;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemEmoticonPanel
  extends RelativeLayout
{
  protected Context a;
  protected ViewPager a;
  private aocs a;
  protected EmoticonPagerAdapter a;
  protected EmoticonPagerRadioGroup a;
  protected boolean a;
  protected View b;
  
  public SystemEmoticonPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public SystemEmoticonPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public SystemEmoticonPanel(Context paramContext, anyb paramanyb)
  {
    this(paramContext, paramanyb, false);
  }
  
  public SystemEmoticonPanel(Context paramContext, anyb paramanyb, boolean paramBoolean)
  {
    super(paramContext);
    if (Build.VERSION.SDK_INT < 24) {}
    try
    {
      Field localField = Class.forName("android.view.LayoutInflater").getDeclaredField("sConstructorMap");
      localField.setAccessible(true);
      ((HashMap)localField.get(LayoutInflater.from(paramContext))).remove("android.support.v4.view.ViewPager");
      this.b = LayoutInflater.from(paramContext).inflate(a(), this);
      this.jdField_a_of_type_Boolean = paramBoolean;
      a(paramContext, paramanyb);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localClassNotFoundException);
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localNoSuchFieldException);
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        QLog.e("SystemEmoticonPanel", 2, "init SystemEmoticonPanel error.", localIllegalAccessException);
      }
    }
  }
  
  protected int a()
  {
    return 2131559031;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a();
    }
  }
  
  protected void a(Context paramContext, anyb paramanyb)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup = ((EmoticonPagerRadioGroup)this.b.findViewById(2131374681));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.b.findViewById(2131379147));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter = new EmoticonPagerAdapter();
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(new aocu(paramContext, paramanyb, 0));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.a(localArrayList);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(0);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerRadioGroup.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPagerAdapter.getCount());
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_Aocs != null) && (this.jdField_a_of_type_Aocs.a(paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        i = paramMotionEvent.getAction() & 0xFF;
        if (i != 0) {
          continue;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      catch (Exception localException)
      {
        int i;
        QLog.e("SystemEmoticonPanel", 1, "onInterceptTouchEvent failed", localException);
        continue;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setCallBack(anyb paramanyb)
  {
    a(this.jdField_a_of_type_AndroidContentContext, paramanyb);
  }
  
  public void setDispatchKeyEventListener(aocs paramaocs)
  {
    this.jdField_a_of_type_Aocs = paramaocs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemEmoticonPanel
 * JD-Core Version:    0.7.0.1
 */