package com.tencent.mobileqq.qqlive.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

public class RegionView
  extends View
{
  final Rect a = new Rect();
  final Paint b = new Paint();
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  private PortraitImageView j;
  private Rect[] k;
  private Rect l = new Rect();
  private RectF m = new RectF();
  private Path n = new Path();
  private Bitmap o;
  
  public RegionView(Context paramContext, PortraitImageView paramPortraitImageView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramContext);
    paramPortraitImageView.setRegionView(this);
    this.j = paramPortraitImageView;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    this.i = paramInt5;
    this.k = new Rect[] { new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), new Rect() };
  }
  
  public Bitmap getBitmap()
  {
    Matrix localMatrix = this.j.getImageViewMatrix();
    Object localObject = this.j.getRestrictRect();
    localMatrix.postTranslate(-((RectF)localObject).left, -((RectF)localObject).top);
    localMatrix.postScale(this.e / ((RectF)localObject).width(), this.f / ((RectF)localObject).height(), 0.0F, 0.0F);
    localObject = Bitmap.createBitmap(this.e, this.f, Bitmap.Config.RGB_565);
    Bitmap localBitmap = this.j.getImageBitmap();
    if ((localObject != null) && (localBitmap != null)) {
      new Canvas((Bitmap)localObject).drawBitmap(localBitmap, localMatrix, new Paint(6));
    }
    return localObject;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.e != 0)
    {
      if (this.f == 0) {
        return;
      }
      Object localObject = this.j;
      if (localObject != null)
      {
        this.c = ((PortraitImageView)localObject).getClipWidth();
        this.d = this.j.getClipHeight();
      }
      int i1 = this.h;
      if (i1 == 0)
      {
        this.a.left = ((getWidth() - this.c) / 2);
        this.a.right = ((getWidth() + this.c) / 2);
      }
      else
      {
        localObject = this.a;
        ((Rect)localObject).left = i1;
        ((Rect)localObject).right = (this.c + i1);
      }
      i1 = this.i;
      if (i1 == 0)
      {
        this.a.top = ((getHeight() - this.d) / 2);
        this.a.bottom = ((getHeight() + this.d) / 2);
      }
      else
      {
        localObject = this.a;
        ((Rect)localObject).top = i1;
        ((Rect)localObject).bottom = (this.d + i1);
      }
      if (this.g == 0)
      {
        this.b.setColor(1711276032);
        this.b.setStyle(Paint.Style.FILL);
        float f1 = this.a.top + this.a.height() * 0.5F;
        this.n.reset();
        this.n.moveTo(getWidth(), f1);
        this.m.set(this.a.left, this.a.top, this.a.right, this.a.bottom);
        this.n.addArc(this.m, 0.0F, -360.0F);
        this.n.moveTo(getWidth(), f1);
        this.n.lineTo(getWidth(), getHeight());
        this.n.lineTo(0.0F, getHeight());
        this.n.lineTo(0.0F, 0.0F);
        this.n.lineTo(getWidth(), 0.0F);
        this.n.moveTo(getWidth(), f1);
        this.n.close();
        paramCanvas.drawPath(this.n, this.b);
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(1291845632);
        this.b.setStrokeWidth(5.0F);
        paramCanvas.drawCircle(this.a.left + this.a.width() * 0.5F, f1, this.a.width() * 0.5F, this.b);
        this.b.setColor(-1);
        this.b.setStrokeWidth(3.0F);
        paramCanvas.drawCircle(this.a.left + this.a.width() * 0.5F, f1, this.a.width() * 0.5F, this.b);
        return;
      }
      this.k[0].set(0, 0, this.a.left, this.a.top);
      this.k[1].set(this.a.left, 0, this.a.right, this.a.top);
      this.k[2].set(this.a.right, 0, getWidth(), this.a.top);
      this.k[3].set(0, this.a.top, this.a.left, this.a.bottom);
      this.k[4].set(this.a.right, this.a.top, getWidth(), this.a.bottom);
      this.k[5].set(0, this.a.bottom, this.a.left, getHeight());
      this.k[6].set(this.a.left, this.a.bottom, this.a.right, getHeight());
      this.k[7].set(this.a.right, this.a.bottom, getWidth(), getHeight());
      this.l.set(this.a);
      localObject = this.l;
      ((Rect)localObject).left -= 2;
      localObject = this.l;
      ((Rect)localObject).right += 2;
      localObject = this.l;
      ((Rect)localObject).top -= 2;
      localObject = this.l;
      ((Rect)localObject).bottom += 2;
      this.b.setColor(1711276032);
      this.b.setStyle(Paint.Style.FILL);
      i1 = 0;
      for (;;)
      {
        localObject = this.k;
        if (i1 >= localObject.length) {
          break;
        }
        paramCanvas.drawRect(localObject[i1], this.b);
        i1 += 1;
      }
      this.b.setColor(0);
      paramCanvas.drawRect(this.l, this.b);
      this.b.setStyle(Paint.Style.STROKE);
      this.b.setStrokeWidth(5.0F);
      this.b.setColor(1291845632);
      paramCanvas.drawRect(this.l, this.b);
      this.b.setStyle(Paint.Style.STROKE);
      this.b.setStrokeWidth(3.0F);
      this.b.setColor(-1);
      localObject = this.o;
      if (localObject != null)
      {
        paramCanvas.drawBitmap((Bitmap)localObject, this.l.left, this.l.top, this.b);
        return;
      }
      paramCanvas.drawRect(this.l, this.b);
    }
  }
  
  public void setCropBitmap(Bitmap paramBitmap)
  {
    this.o = paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.widget.RegionView
 * JD-Core Version:    0.7.0.1
 */