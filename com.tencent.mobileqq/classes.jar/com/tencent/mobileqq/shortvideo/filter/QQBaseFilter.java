package com.tencent.mobileqq.shortvideo.filter;

import java.util.HashMap;
import java.util.Map;

public class QQBaseFilter
{
  protected int a;
  private QQFilterRenderManager a;
  protected Map a;
  protected int b;
  protected int c;
  protected int d = 0;
  
  public QQBaseFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.c = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = paramQQFilterRenderManager;
  }
  
  public QQFilterRenderManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    this.d = paramInt;
    this.jdField_a_of_type_JavaUtilMap.clear();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = paramArrayOfInt.length;
      paramInt = 0;
      while (paramInt < i)
      {
        int j = paramArrayOfInt[paramInt];
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), Integer.valueOf(j));
        paramInt += 1;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilMap == null) || (this.jdField_a_of_type_JavaUtilMap.size() == 0)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt));
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void d() {}
  
  public void e() {}
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public boolean i_()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQBaseFilter
 * JD-Core Version:    0.7.0.1
 */