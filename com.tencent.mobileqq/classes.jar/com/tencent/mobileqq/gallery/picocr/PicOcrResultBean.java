package com.tencent.mobileqq.gallery.picocr;

import android.graphics.Point;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class PicOcrResultBean
{
  public String a;
  public int b;
  public ArrayList<Point> c;
  public int d = -1;
  public int e;
  public int f;
  public boolean g = false;
  
  public int a()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() < 2) {
        return 0;
      }
      localObject = (Point)this.c.get(0);
      Point localPoint = (Point)this.c.get(1);
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
  
  public int b()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() < 4) {
        return 0;
      }
      localObject = (Point)this.c.get(0);
      Point localPoint = (Point)this.c.get(1);
      return ((IOCR)QRoute.api(IOCR.class)).takeDistance((Point)localObject, localPoint);
    }
    return 0;
  }
  
  public int b(float paramFloat)
  {
    return (int)Math.ceil(c() * paramFloat);
  }
  
  public int c()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() < 4) {
        return 0;
      }
      localObject = (Point)this.c.get(0);
      Point localPoint = (Point)this.c.get(3);
      return ((IOCR)QRoute.api(IOCR.class)).takeDistance((Point)localObject, localPoint);
    }
    return 0;
  }
  
  public void c(float paramFloat)
  {
    if (!this.g)
    {
      int i = 0;
      while (i < this.c.size())
      {
        ((Point)this.c.get(i)).x = ((int)(((Point)this.c.get(i)).x * paramFloat));
        ((Point)this.c.get(i)).y = ((int)(((Point)this.c.get(i)).y * paramFloat));
        i += 1;
      }
      this.g = true;
    }
  }
  
  public Point d()
  {
    return (Point)this.c.get(0);
  }
  
  public Point e()
  {
    return (Point)this.c.get(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrResultBean
 * JD-Core Version:    0.7.0.1
 */