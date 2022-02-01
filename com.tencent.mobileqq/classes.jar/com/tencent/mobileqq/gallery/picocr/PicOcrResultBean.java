package com.tencent.mobileqq.gallery.picocr;

import android.graphics.Point;
import com.tencent.mobileqq.ocr.OCRPerformUtil;
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
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 2)) {
      return 0;
    }
    Point localPoint1 = (Point)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    Point localPoint2 = (Point)this.jdField_a_of_type_JavaUtilArrayList.get(1);
    int i = localPoint2.x - localPoint1.x;
    int j = localPoint2.y - localPoint1.y;
    double d1 = Math.sqrt(i * i + j * j);
    float f = (float)(Math.asin(j / d1) / 3.141592653589793D * 180.0D);
    if (localPoint2.x < localPoint1.x) {
      if (f > 0.0F) {
        f = 180.0F - f;
      }
    }
    for (;;)
    {
      return Math.round(f);
      f = -(180.0F + f);
    }
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
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 4)) {
      return 0;
    }
    return OCRPerformUtil.a((Point)this.jdField_a_of_type_JavaUtilArrayList.get(0), (Point)this.jdField_a_of_type_JavaUtilArrayList.get(1));
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
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 4)) {
      return 0;
    }
    return OCRPerformUtil.a((Point)this.jdField_a_of_type_JavaUtilArrayList.get(0), (Point)this.jdField_a_of_type_JavaUtilArrayList.get(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrResultBean
 * JD-Core Version:    0.7.0.1
 */