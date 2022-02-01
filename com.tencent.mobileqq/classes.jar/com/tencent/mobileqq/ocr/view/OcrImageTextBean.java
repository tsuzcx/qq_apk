package com.tencent.mobileqq.ocr.view;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mobileqq.gallery.picocr.PicOcrResultBean;
import java.util.ArrayList;
import java.util.List;

public class OcrImageTextBean
  extends OcrGestureBeanInfo
{
  public Bitmap h;
  public String i;
  public int j;
  public int k;
  public float l = -1.0F;
  public boolean m;
  public int n = -1;
  public int o = -1;
  public int p = -1;
  public Rect q;
  public int r = -1;
  public int s = -1;
  public int t = -1;
  public boolean u = false;
  public int v = -1;
  public int w = -1;
  public boolean x = false;
  public float y = -1.0F;
  
  public OcrImageTextBean(PicOcrResultBean paramPicOcrResultBean)
  {
    this.i = paramPicOcrResultBean.a;
    this.q = new Rect();
    this.c = paramPicOcrResultBean.a();
    this.n = paramPicOcrResultBean.d;
    this.p = 0;
    this.t = paramPicOcrResultBean.b;
    this.a.clear();
    if (!paramPicOcrResultBean.c.isEmpty()) {
      this.a.addAll(paramPicOcrResultBean.c);
    }
    paramPicOcrResultBean = (Point)this.a.get(0);
    Object localObject = this.a;
    boolean bool = true;
    localObject = (Point)((List)localObject).get(1);
    if (paramPicOcrResultBean.x <= ((Point)localObject).x) {
      bool = false;
    }
    this.u = bool;
  }
  
  public Point a()
  {
    return (Point)this.a.get(0);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.OcrImageTextBean
 * JD-Core Version:    0.7.0.1
 */