package com.tencent.mobileqq.gallery.picocr;

import android.graphics.Point;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class PicOcrResultBean
{
  public int a;
  public String a;
  public ArrayList<Point> a;
  public boolean a;
  public int b = -1;
  public int c;
  public int d;
  
  public PicOcrResultBean()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() < 2) {
        return 0;
      }
      localObject = (Point)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      Point localPoint = (Point)this.jdField_a_of_type_JavaUtilArrayList.get(1);
      int i = localPoint.x - ((Point)localObject).x;
      int j = localPoint.y - ((Point)localObject).y;
      double d1 = Math.sqrt(i * i + j * j);
      double d2 = j;
      Double.isNaN(d2);
      float f2 = (float)(Math.asin(d2 / d1) / 3.141592653589793D * 180.0D);
      float f1 = f2;
      if (localPoint.x < ((Point)localObject).x) {
        if (f2 > 0.0F) {
          f1 = 180.0F - f2;
        } else {
          f1 = -(f2 + 180.0F);
        }
      }
      return Math.round(f1);
    }
    return 0;
  }
  
  public int a(float paramFloat)
  {
    return (int)Math.ceil(b() * paramFloat);
  }
  
  public Point a()
  {
    return (Point)this.jdField_a_of_type_JavaUtilArrayList.get(0);
  }
  
  public void a(float paramFloat)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((Point)this.jdField_a_of_type_JavaUtilArrayList.get(i)).x = ((int)(((Point)this.jdField_a_of_type_JavaUtilArrayList.get(i)).x * paramFloat));
        ((Point)this.jdField_a_of_type_JavaUtilArrayList.get(i)).y = ((int)(((Point)this.jdField_a_of_type_JavaUtilArrayList.get(i)).y * paramFloat));
        i += 1;
      }
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public int b()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() < 4) {
        return 0;
      }
      localObject = (Point)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      Point localPoint = (Point)this.jdField_a_of_type_JavaUtilArrayList.get(1);
      return ((IOCR)QRoute.api(IOCR.class)).takeDistance((Point)localObject, localPoint);
    }
    return 0;
  }
  
  public int b(float paramFloat)
  {
    return (int)Math.ceil(c() * paramFloat);
  }
  
  public Point b()
  {
    return (Point)this.jdField_a_of_type_JavaUtilArrayList.get(3);
  }
  
  public int c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() < 4) {
        return 0;
      }
      localObject = (Point)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      Point localPoint = (Point)this.jdField_a_of_type_JavaUtilArrayList.get(3);
      return ((IOCR)QRoute.api(IOCR.class)).takeDistance((Point)localObject, localPoint);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrResultBean
 * JD-Core Version:    0.7.0.1
 */