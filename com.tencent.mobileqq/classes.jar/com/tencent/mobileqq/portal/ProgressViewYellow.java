package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.utils.ImageUtil;

public class ProgressViewYellow
  extends View
{
  private ShapeDrawable a;
  private int b;
  private int c;
  private int d;
  private long e = 10000L;
  private long f = 0L;
  private int[] g = { 2130846820, 2130846821, 2130846822, 2130846823, 2130846824, 2130846825, 2130846826, 2130846827, 2130846828, 2130846829, 2130846830, 2130846831, 2130846832, 2130846833, 2130846834, 2130846835, 2130846836, 2130846837, 2130846838, 2130846839 };
  private Bitmap[] h = null;
  private Rect i;
  private RectF j;
  private int k;
  private Paint l;
  private Path m;
  
  public ProgressViewYellow(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ProgressViewYellow(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ProgressViewYellow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.b = ((int)getResources().getDimension(2131298983));
    this.c = ((int)getResources().getDimension(2131298985));
    this.d = ((int)getResources().getDimension(2131298984));
    int i1 = this.c;
    float f1 = i1;
    int n = 0;
    this.a = new ShapeDrawable(new RoundRectShape(new float[] { f1, i1, i1, i1, i1, i1, i1, i1 }, null, null));
    this.a.getPaint().setAntiAlias(true);
    this.a.getPaint().setColor(Color.parseColor("#FC7B31"));
    this.i = new Rect();
    this.j = new RectF();
    this.k = 0;
    this.l = new Paint();
    this.l.setAntiAlias(true);
    this.l.setFilterBitmap(true);
    if ((Build.VERSION.SDK_INT < 11) || (Build.VERSION.SDK_INT >= 18)) {
      this.m = new Path();
    }
    try
    {
      this.h = new Bitmap[this.g.length];
      while (n < this.g.length)
      {
        this.h[n] = BitmapFactory.decodeResource(getResources(), this.g[n]);
        n += 1;
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.e = paramLong2;
    this.f = (paramLong2 - paramLong1);
    postInvalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.f < this.e)
    {
      int i2 = getWidth();
      int i1 = getHeight();
      int n = this.d;
      i2 -= n;
      int i4 = this.b;
      int i3 = (i1 - i4) / 2;
      i4 = (i1 + i4) / 2;
      int i5 = (int)((i2 - n) * this.f / this.e) + n;
      this.a.setBounds(i5, i3, i2, i4);
      this.a.draw(paramCanvas);
      i1 = this.k;
      Object localObject1 = this.g;
      n = i1;
      if (i1 >= localObject1.length) {
        n = i1 % localObject1.length;
      }
      i1 = this.h[n].getWidth();
      int i6 = this.h[n].getHeight();
      this.i.set(0, 0, i1, i6);
      int i7 = i2 - i5;
      if (i1 <= i7)
      {
        localObject1 = this.h[n];
        this.j.set(i5, i3, i5 + i1, i4);
        paramCanvas.drawBitmap((Bitmap)localObject1, null, this.j, null);
      }
      else
      {
        localObject1 = Bitmap.createBitmap(this.h[n], 0, 0, i7, i6, null, false);
        Object localObject2 = this.j;
        float f1 = i5;
        float f2 = i3;
        float f3 = i2;
        float f4 = i4;
        ((RectF)localObject2).set(f1, f2, f3, f4);
        if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 18))
        {
          localObject1 = ImageUtil.b((Bitmap)localObject1, this.c, i7, i6);
          this.j.set(f1, f2, f3, f4);
          paramCanvas.drawBitmap((Bitmap)localObject1, null, this.j, null);
        }
        else
        {
          localObject2 = this.m;
          RectF localRectF = this.j;
          n = this.c;
          ((Path)localObject2).addRoundRect(localRectF, n, n, Path.Direction.CW);
          paramCanvas.clipPath(this.m, Region.Op.INTERSECT);
          paramCanvas.drawBitmap((Bitmap)localObject1, null, this.j, this.l);
        }
      }
      this.k += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ProgressViewYellow
 * JD-Core Version:    0.7.0.1
 */