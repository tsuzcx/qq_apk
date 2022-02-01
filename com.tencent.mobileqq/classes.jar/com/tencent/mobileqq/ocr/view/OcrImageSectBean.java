package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.gallery.picocr.PicOcrResultBean;
import com.tencent.mobileqq.ocr.OCRPerformUtil;
import com.tencent.mobileqq.ocr.OcrImageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OcrImageSectBean
  extends OcrGestureBeanInfo
{
  public float a;
  public Bitmap a;
  public Point a;
  public Rect a;
  public String a;
  public float b;
  public String b;
  public boolean b;
  public float c;
  public boolean c;
  public boolean d;
  public int f;
  public int g = -1;
  public int h = -1;
  public int i = 10;
  public int j = 0;
  
  public OcrImageSectBean(PicOcrResultBean paramPicOcrResultBean)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramPicOcrResultBean.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Int = paramPicOcrResultBean.a();
    this.f = paramPicOcrResultBean.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_JavaUtilList.clear();
    paramPicOcrResultBean = paramPicOcrResultBean.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramPicOcrResultBean.hasNext())
    {
      Point localPoint = (Point)paramPicOcrResultBean.next();
      this.jdField_a_of_type_JavaUtilList.add(new Point(localPoint));
    }
    if (((Point)this.jdField_a_of_type_JavaUtilList.get(0)).x > ((Point)this.jdField_a_of_type_JavaUtilList.get(1)).x) {
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_a_of_type_Float = 0.0F;
    this.h = -16777216;
  }
  
  private void a(int paramInt, Point paramPoint)
  {
    if (paramPoint != null) {
      ((Point)this.jdField_a_of_type_JavaUtilList.get(paramInt)).set(paramPoint.x, paramPoint.y);
    }
  }
  
  private void b(PicOcrResultBean paramPicOcrResultBean)
  {
    a(3, (Point)paramPicOcrResultBean.jdField_a_of_type_JavaUtilArrayList.get(3));
    a(2, OcrImageUtil.a((Point)this.jdField_a_of_type_JavaUtilList.get(1), (Point)this.jdField_a_of_type_JavaUtilList.get(2), (Point)paramPicOcrResultBean.jdField_a_of_type_JavaUtilArrayList.get(2), (Point)paramPicOcrResultBean.jdField_a_of_type_JavaUtilArrayList.get(3)));
    a(0, OcrImageUtil.a((Point)paramPicOcrResultBean.jdField_a_of_type_JavaUtilArrayList.get(3), (Point)paramPicOcrResultBean.jdField_a_of_type_JavaUtilArrayList.get(0), (Point)this.jdField_a_of_type_JavaUtilList.get(1), (Point)this.jdField_a_of_type_JavaUtilList.get(0)));
  }
  
  public Point a()
  {
    this.jdField_a_of_type_AndroidGraphicsPoint = ((Point)this.jdField_a_of_type_JavaUtilList.get(0));
    return this.jdField_a_of_type_AndroidGraphicsPoint;
  }
  
  public Rect a()
  {
    Point localPoint1 = (Point)this.jdField_a_of_type_JavaUtilList.get(0);
    Point localPoint2 = (Point)this.jdField_a_of_type_JavaUtilList.get(1);
    Point localPoint3 = (Point)this.jdField_a_of_type_JavaUtilList.get(2);
    Point localPoint4 = (Point)this.jdField_a_of_type_JavaUtilList.get(3);
    int k = Math.max(OCRPerformUtil.a(localPoint1, localPoint2), OCRPerformUtil.a(localPoint4, localPoint3));
    int m = Math.max(OCRPerformUtil.a(localPoint1, localPoint4), OCRPerformUtil.a(localPoint2, localPoint3));
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, k, m);
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    int k = 0;
    while (k < this.jdField_a_of_type_JavaUtilList.size())
    {
      Point localPoint = (Point)this.jdField_a_of_type_JavaUtilList.get(k);
      localPoint = new Point((int)(localPoint.x * paramFloat1), (int)(localPoint.y * paramFloat2));
      this.jdField_b_of_type_Int = Math.max(this.jdField_b_of_type_Int, localPoint.x);
      this.jdField_c_of_type_Int = Math.max(this.jdField_c_of_type_Int, localPoint.y);
      this.jdField_d_of_type_Int = Math.min(this.jdField_d_of_type_Int, localPoint.x);
      this.e = Math.min(this.e, localPoint.y);
      if (localPoint.x < 0) {
        localPoint.x = 0;
      }
      if (localPoint.y < 0) {
        localPoint.y = 0;
      }
      this.jdField_a_of_type_JavaUtilList.set(k, localPoint);
      k += 1;
    }
  }
  
  public void a(TextPaint paramTextPaint)
  {
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!a()))
    {
      if (this.jdField_b_of_type_Float <= 0.0F) {
        return;
      }
      float f1 = paramTextPaint.measureText(this.jdField_b_of_type_JavaLangString);
      float f2 = paramTextPaint.measureText(this.jdField_a_of_type_JavaLangString);
      double d1 = this.jdField_b_of_type_Float;
      double d2 = Math.sqrt(f1 / f2);
      Double.isNaN(d1);
      this.jdField_a_of_type_Float = ((float)(d1 * d2));
      if (this.jdField_a_of_type_Float > 30.0F) {
        this.jdField_a_of_type_Float = 30.0F;
      }
      if (this.jdField_a_of_type_Float < 5.0F) {
        this.jdField_a_of_type_Float = 5.0F;
      }
    }
  }
  
  public void a(PicOcrResultBean paramPicOcrResultBean)
  {
    if (paramPicOcrResultBean != null)
    {
      if (this.f != paramPicOcrResultBean.jdField_b_of_type_Int) {
        return;
      }
      if ((paramPicOcrResultBean.jdField_a_of_type_JavaUtilArrayList != null) && (paramPicOcrResultBean.jdField_a_of_type_JavaUtilArrayList.size() == 4)) {
        b(paramPicOcrResultBean);
      }
      if (!TextUtils.isEmpty(paramPicOcrResultBean.jdField_a_of_type_JavaLangString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        localStringBuilder.append(paramPicOcrResultBean.jdField_a_of_type_JavaLangString);
        this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
      }
    }
  }
  
  public boolean a()
  {
    Rect localRect = a();
    int k = localRect.width();
    int m = this.j;
    int n = localRect.height();
    int i1 = this.i;
    return (k - m * 2 < 10) || (n - i1 * 2 < 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageSectBean
 * JD-Core Version:    0.7.0.1
 */