package com.tencent.mobileqq.widget;

import com.tencent.biz.common.util.HttpUtil;

class WebViewProgressBarController$DurationGenerator
{
  private static DurationGenerator jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController$DurationGenerator;
  private static DurationGenerator jdField_b_of_type_ComTencentMobileqqWidgetWebViewProgressBarController$DurationGenerator;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private int[] jdField_a_of_type_ArrayOfInt = null;
  private int jdField_b_of_type_Int = 0;
  private int c = 9000;
  private int d = 1800;
  private int e;
  
  public WebViewProgressBarController$DurationGenerator(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_Int == 0)
    {
      this.c = 9000;
      this.d = 1800;
    }
    else
    {
      this.c = 6000;
      this.d = 1200;
    }
    this.jdField_a_of_type_Long = 0L;
    this.e = 0;
    this.jdField_a_of_type_ArrayOfInt = new int[3];
    paramInt = 0;
    while (paramInt < 3)
    {
      this.jdField_a_of_type_ArrayOfInt[paramInt] = 0;
      paramInt += 1;
    }
  }
  
  public static DurationGenerator a(int paramInt)
  {
    if (paramInt == 0)
    {
      if (jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController$DurationGenerator == null) {
        jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController$DurationGenerator = new DurationGenerator(0);
      }
      return jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController$DurationGenerator;
    }
    if (jdField_b_of_type_ComTencentMobileqqWidgetWebViewProgressBarController$DurationGenerator == null) {
      jdField_b_of_type_ComTencentMobileqqWidgetWebViewProgressBarController$DurationGenerator = new DurationGenerator(1);
    }
    return jdField_b_of_type_ComTencentMobileqqWidgetWebViewProgressBarController$DurationGenerator;
  }
  
  private void b()
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = 0;
      i += 1;
    }
    this.e = 0;
  }
  
  private int c()
  {
    int i1 = 0;
    int j = 0;
    int k = 0;
    int m;
    for (int i = 0; j < 3; i = m)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int n = k;
      m = i;
      if (arrayOfInt[j] > 0)
      {
        n = k + 1;
        m = i + arrayOfInt[j];
      }
      j += 1;
      k = n;
    }
    j = i1;
    if (k > 0) {
      j = i / k;
    }
    return j;
  }
  
  public int a()
  {
    if (2 == this.jdField_b_of_type_Int) {
      return this.c;
    }
    return this.d;
  }
  
  public void a()
  {
    int j = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    int k = c();
    int i;
    if (this.jdField_b_of_type_Int == 2) {
      i = this.c;
    } else {
      i = this.d;
    }
    if (k == 0) {
      i *= 3;
    } else {
      i = k * 3;
    }
    if (j > 100)
    {
      if (j <= i) {
        i = j;
      }
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      j = this.e;
      arrayOfInt[j] = ((int)(i * 1.2F));
      i = j + 1;
      this.e = i;
      this.e = (i % 3);
    }
  }
  
  public int b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int k = HttpUtil.getNetWorkType();
    int i = this.jdField_b_of_type_Int;
    int j = 0;
    if (i != k) {
      i = 1;
    } else {
      i = 0;
    }
    this.jdField_b_of_type_Int = k;
    if (i != 0)
    {
      if (this.jdField_b_of_type_Int == 2) {
        i = this.c;
      } else {
        i = this.d;
      }
      b();
      return i;
    }
    k = c();
    i = j;
    if (k > 0) {
      i = k;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.WebViewProgressBarController.DurationGenerator
 * JD-Core Version:    0.7.0.1
 */