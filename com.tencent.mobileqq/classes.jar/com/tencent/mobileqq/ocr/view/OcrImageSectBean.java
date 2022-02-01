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
  public String h;
  public String i;
  public Rect j;
  public float k;
  public float l;
  public float m;
  public int n;
  public int o = -1;
  public int p = -1;
  public int q = 10;
  public int r = 0;
  public boolean s = false;
  public boolean t = false;
  public boolean u = false;
  public Point v;
  public Bitmap w;
  
  public OcrImageSectBean(PicOcrResultBean paramPicOcrResultBean)
  {
    this.i = paramPicOcrResultBean.a;
    this.c = paramPicOcrResultBean.a();
    this.n = paramPicOcrResultBean.d;
    this.j = new Rect();
    this.a.clear();
    paramPicOcrResultBean = paramPicOcrResultBean.c.iterator();
    while (paramPicOcrResultBean.hasNext())
    {
      Point localPoint = (Point)paramPicOcrResultBean.next();
      this.a.add(new Point(localPoint));
    }
    if (((Point)this.a.get(0)).x > ((Point)this.a.get(1)).x) {
      this.s = true;
    }
    this.k = 0.0F;
    this.p = -16777216;
  }
  
  private void a(int paramInt, Point paramPoint)
  {
    if (paramPoint != null) {
      ((Point)this.a.get(paramInt)).set(paramPoint.x, paramPoint.y);
    }
  }
  
  private void b(PicOcrResultBean paramPicOcrResultBean)
  {
    a(3, (Point)paramPicOcrResultBean.c.get(3));
    a(2, OcrImageUtil.a((Point)this.a.get(1), (Point)this.a.get(2), (Point)paramPicOcrResultBean.c.get(2), (Point)paramPicOcrResultBean.c.get(3)));
    a(0, OcrImageUtil.a((Point)paramPicOcrResultBean.c.get(3), (Point)paramPicOcrResultBean.c.get(0), (Point)this.a.get(1), (Point)this.a.get(0)));
  }
  
  public Rect a()
  {
    Point localPoint1 = (Point)this.a.get(0);
    Point localPoint2 = (Point)this.a.get(1);
    Point localPoint3 = (Point)this.a.get(2);
    Point localPoint4 = (Point)this.a.get(3);
    int i1 = Math.max(OCRPerformUtil.a(localPoint1, localPoint2), OCRPerformUtil.a(localPoint4, localPoint3));
    int i2 = Math.max(OCRPerformUtil.a(localPoint1, localPoint4), OCRPerformUtil.a(localPoint2, localPoint3));
    this.j.set(0, 0, i1, i2);
    return this.j;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    int i1 = 0;
    while (i1 < this.a.size())
    {
      Point localPoint = (Point)this.a.get(i1);
      localPoint = new Point((int)(localPoint.x * paramFloat1), (int)(localPoint.y * paramFloat2));
      this.d = Math.max(this.d, localPoint.x);
      this.e = Math.max(this.e, localPoint.y);
      this.f = Math.min(this.f, localPoint.x);
      this.g = Math.min(this.g, localPoint.y);
      if (localPoint.x < 0) {
        localPoint.x = 0;
      }
      if (localPoint.y < 0) {
        localPoint.y = 0;
      }
      this.a.set(i1, localPoint);
      i1 += 1;
    }
  }
  
  public void a(TextPaint paramTextPaint)
  {
    if ((!TextUtils.isEmpty(this.i)) && (!TextUtils.isEmpty(this.h)) && (!c()))
    {
      if (this.l <= 0.0F) {
        return;
      }
      float f1 = paramTextPaint.measureText(this.i);
      float f2 = paramTextPaint.measureText(this.h);
      double d1 = this.l;
      double d2 = Math.sqrt(f1 / f2);
      Double.isNaN(d1);
      this.k = ((float)(d1 * d2));
      if (this.k > 30.0F) {
        this.k = 30.0F;
      }
      if (this.k < 5.0F) {
        this.k = 5.0F;
      }
    }
  }
  
  public void a(PicOcrResultBean paramPicOcrResultBean)
  {
    if (paramPicOcrResultBean != null)
    {
      if (this.n != paramPicOcrResultBean.d) {
        return;
      }
      if ((paramPicOcrResultBean.c != null) && (paramPicOcrResultBean.c.size() == 4)) {
        b(paramPicOcrResultBean);
      }
      if (!TextUtils.isEmpty(paramPicOcrResultBean.a))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.i);
        localStringBuilder.append(paramPicOcrResultBean.a);
        this.i = localStringBuilder.toString();
      }
    }
  }
  
  public Point b()
  {
    this.v = ((Point)this.a.get(0));
    return this.v;
  }
  
  public boolean c()
  {
    Rect localRect = a();
    int i1 = localRect.width();
    int i2 = this.r;
    int i3 = localRect.height();
    int i4 = this.q;
    return (i1 - i2 * 2 < 10) || (i3 - i4 * 2 < 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageSectBean
 * JD-Core Version:    0.7.0.1
 */