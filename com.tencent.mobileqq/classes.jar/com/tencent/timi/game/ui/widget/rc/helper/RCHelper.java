package com.tencent.timi.game.ui.widget.rc.helper;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.Op;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import com.tencent.mobileqq.timi_game.impl.R.styleable;
import java.util.ArrayList;

public class RCHelper
{
  public float[] a = new float[8];
  public Path b;
  public Paint c;
  public boolean d = false;
  public int e;
  public int f;
  public ColorStateList g;
  public int h;
  public boolean i;
  public Region j;
  public RectF k;
  public boolean l;
  public RCHelper.OnCheckedChangeListener m;
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cq);
    this.d = paramContext.getBoolean(R.styleable.cs, false);
    this.g = paramContext.getColorStateList(R.styleable.cy);
    paramAttributeSet = this.g;
    if (paramAttributeSet != null)
    {
      this.f = paramAttributeSet.getDefaultColor();
      this.e = this.g.getDefaultColor();
    }
    else
    {
      this.f = -1;
      this.e = -1;
    }
    this.h = paramContext.getDimensionPixelSize(R.styleable.cz, 0);
    this.i = paramContext.getBoolean(R.styleable.cr, false);
    int i3 = paramContext.getDimensionPixelSize(R.styleable.ct, 0);
    int n = paramContext.getDimensionPixelSize(R.styleable.cw, i3);
    int i1 = paramContext.getDimensionPixelSize(R.styleable.cx, i3);
    int i2 = paramContext.getDimensionPixelSize(R.styleable.cu, i3);
    i3 = paramContext.getDimensionPixelSize(R.styleable.cv, i3);
    paramContext.recycle();
    paramContext = this.a;
    float f1 = n;
    paramContext[0] = f1;
    paramContext[1] = f1;
    f1 = i1;
    paramContext[2] = f1;
    paramContext[3] = f1;
    f1 = i3;
    paramContext[4] = f1;
    paramContext[5] = f1;
    f1 = i2;
    paramContext[6] = f1;
    paramContext[7] = f1;
    this.k = new RectF();
    this.b = new Path();
    this.j = new Region();
    this.c = new Paint();
    this.c.setColor(-1);
    this.c.setAntiAlias(true);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.h > 0)
    {
      this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
      this.c.setColor(-1);
      this.c.setStrokeWidth(this.h * 2);
      this.c.setStyle(Paint.Style.STROKE);
      paramCanvas.drawPath(this.b, this.c);
      this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      this.c.setColor(this.f);
      this.c.setStyle(Paint.Style.STROKE);
      paramCanvas.drawPath(this.b, this.c);
    }
    this.c.setColor(-1);
    this.c.setStyle(Paint.Style.FILL);
    if (Build.VERSION.SDK_INT <= 27)
    {
      this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      paramCanvas.drawPath(this.b, this.c);
      return;
    }
    this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    Path localPath = new Path();
    localPath.addRect(-1.0F, -1.0F, (int)this.k.width(), (int)this.k.height(), Path.Direction.CW);
    localPath.op(this.b, Path.Op.DIFFERENCE);
    paramCanvas.drawPath(localPath, this.c);
  }
  
  public void a(View paramView)
  {
    int n = (int)this.k.width();
    int i1 = (int)this.k.height();
    RectF localRectF = new RectF();
    localRectF.left = paramView.getPaddingLeft();
    localRectF.top = paramView.getPaddingTop();
    localRectF.right = (n - paramView.getPaddingRight());
    localRectF.bottom = (i1 - paramView.getPaddingBottom());
    this.b.reset();
    if (this.d)
    {
      float f1;
      if (localRectF.width() >= localRectF.height()) {
        f1 = localRectF.height();
      } else {
        f1 = localRectF.width();
      }
      f1 /= 2.0F;
      float f2 = n / 2;
      float f3 = i1 / 2;
      paramView = new PointF(f2, f3);
      if (Build.VERSION.SDK_INT <= 27)
      {
        this.b.addCircle(paramView.x, paramView.y, f1, Path.Direction.CW);
        this.b.moveTo(0.0F, 0.0F);
        this.b.moveTo(n, i1);
      }
      else
      {
        f2 = f3 - f1;
        this.b.moveTo(localRectF.left, f2);
        this.b.addCircle(paramView.x, f2 + f1, f1, Path.Direction.CW);
      }
    }
    else
    {
      this.b.addRoundRect(localRectF, this.a, Path.Direction.CW);
    }
    paramView = new Region((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
    this.j.setPath(this.b, paramView);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    this.k.set(0.0F, 0.0F, paramInt1, paramInt2);
    a(paramView);
  }
  
  public void b(View paramView)
  {
    if ((paramView instanceof RCAttrs))
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramView instanceof Checkable))
      {
        localArrayList.add(Integer.valueOf(16842911));
        if (((Checkable)paramView).isChecked()) {
          localArrayList.add(Integer.valueOf(16842912));
        }
      }
      if (paramView.isEnabled()) {
        localArrayList.add(Integer.valueOf(16842910));
      }
      if (paramView.isFocused()) {
        localArrayList.add(Integer.valueOf(16842908));
      }
      if (paramView.isPressed()) {
        localArrayList.add(Integer.valueOf(16842919));
      }
      if (paramView.isHovered()) {
        localArrayList.add(Integer.valueOf(16843623));
      }
      if (paramView.isSelected()) {
        localArrayList.add(Integer.valueOf(16842913));
      }
      if (paramView.isActivated()) {
        localArrayList.add(Integer.valueOf(16843518));
      }
      if (paramView.hasWindowFocus()) {
        localArrayList.add(Integer.valueOf(16842909));
      }
      Object localObject = this.g;
      if ((localObject != null) && (((ColorStateList)localObject).isStateful()))
      {
        localObject = new int[localArrayList.size()];
        int n = 0;
        while (n < localArrayList.size())
        {
          localObject[n] = ((Integer)localArrayList.get(n)).intValue();
          n += 1;
        }
        n = this.g.getColorForState((int[])localObject, this.e);
        ((RCAttrs)paramView).setStrokeColor(n);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.rc.helper.RCHelper
 * JD-Core Version:    0.7.0.1
 */