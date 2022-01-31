package com.tencent.mobileqq.richmedia.capture.util;

import android.content.Context;
import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.mobileqq.richmedia.capture.view.BeautyProviderView;
import com.tencent.mobileqq.richmedia.capture.view.FilterProviderView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateProviderView;
import com.tencent.mobileqq.richmedia.capture.view.SubtitleProviderView;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ProviderViewBuilder
{
  public static final int[] a;
  public static final int[] b;
  public static final int[] c;
  public static final int[] d;
  private int jdField_a_of_type_Int = 0;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 101, 2130843199 };
    jdField_b_of_type_ArrayOfInt = new int[] { 102, 2130843202 };
    jdField_c_of_type_ArrayOfInt = new int[] { 103, 2130843198 };
    jdField_d_of_type_ArrayOfInt = new int[] { 104, 2130843205 };
  }
  
  public ProviderViewBuilder(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return 0;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[1];
  }
  
  public ProviderView a(Context paramContext, int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramContext = localObject;
      if (QLog.isColorLevel())
      {
        QLog.d("ProviderViewBuilder", 2, "bad id=" + paramInt);
        paramContext = localObject;
      }
      break;
    }
    for (;;)
    {
      if (paramContext != null)
      {
        if (this.jdField_a_of_type_Int != 0) {
          break;
        }
        paramContext.setTabBarPosition(2);
      }
      return paramContext;
      paramContext = new FilterProviderView(paramContext, this.jdField_a_of_type_Int);
      paramContext.setId(2131362421);
      continue;
      paramContext = new PtvTemplateProviderView(paramContext);
      continue;
      paramContext = new BeautyProviderView(paramContext);
      continue;
      paramContext = new SubtitleProviderView(paramContext);
    }
    paramContext.setTabBarPosition(1);
    if (paramContext.a())
    {
      paramContext.b(213);
      return paramContext;
    }
    paramContext.b(249);
    return paramContext;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      return;
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ArrayOfInt);
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ArrayOfInt);
      }
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilArrayList.add(jdField_d_of_type_ArrayOfInt);
      }
    } while (!this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ArrayOfInt);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    do
    {
      return;
      paramInt = ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
      if (paramInt == 101)
      {
        CaptureVideoFilterManager.a().a(1, 0, "");
        return;
      }
    } while (paramInt != 102);
    CapturePtvTemplateManager.a().a(1, 0, "");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {}
    do
    {
      return false;
      paramInt = ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
      if (paramInt == 101) {
        return CaptureVideoFilterManager.a().a(1, 0, "");
      }
    } while (paramInt != 102);
    if ((!RedBagVideoManager.a(RedBagVideoManager.e)) || (CapturePtvTemplateManager.a().a(1, 0, ""))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return -1;
    }
    return ((int[])this.jdField_a_of_type_JavaUtilArrayList.get(paramInt))[0];
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public int c(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((int[])this.jdField_a_of_type_JavaUtilArrayList.get(i))[0] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.ProviderViewBuilder
 * JD-Core Version:    0.7.0.1
 */