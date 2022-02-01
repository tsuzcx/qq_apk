package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TCProgressBar
  extends View
{
  TCProgressBar.BlinkBlock A = new TCProgressBar.BlinkBlock(this);
  TCProgressBar.DeleteImage B = new TCProgressBar.DeleteImage(this);
  TCProgressBar.ProgressBlock C = new TCProgressBar.ProgressBlock(this, true);
  ArrayList<TCProgressBar.ProgressBlock> D = new ArrayList(10);
  ArrayList<TCProgressBar.ProgressBlock> E = new ArrayList(10);
  Handler F = new Handler();
  public int a = 3;
  public int b = 0;
  public int c = 0;
  boolean d;
  int e = 1000;
  public Bitmap f;
  public Bitmap g;
  public int h;
  Paint i = new Paint();
  public TCProgressBar.DelEvent j = null;
  Rect k = new Rect(0, 0, 0, 0);
  TouchDelegate l = new TouchDelegate(this.k, this);
  long m;
  float n;
  boolean o = false;
  int p = 0;
  int q = 1310991405;
  int r = -14408659;
  int s = -16737062;
  int t = -65536;
  int u = -15000805;
  int v = ScreenUtil.dip2px(1.0F);
  int w = -1;
  int x = ScreenUtil.dip2px(5.0F);
  Rect y = new Rect();
  int z = 0;
  
  public TCProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    try
    {
      this.f = BitmapFactory.decodeResource(paramContext.getResources(), 2130847665);
      this.g = BitmapFactory.decodeResource(paramContext.getResources(), 2130847664);
      this.h = this.f.getWidth();
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
      this.h = 100;
    }
    this.F.postDelayed(new TCProgressBar.TimerRefresh(this), this.e);
  }
  
  int a(int paramInt1, int paramInt2)
  {
    int i1 = this.b;
    if (paramInt1 == i1) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / i1;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  void a()
  {
    int i7 = super.getWidth();
    int i6 = this.h - 3;
    int i4 = i7 - i6;
    int i5 = this.D.size();
    int i1 = 0;
    int i2;
    Object localObject;
    for (;;)
    {
      i2 = i5 - 1;
      if (i1 >= i2) {
        break;
      }
      localObject = (TCProgressBar.ProgressBlock)this.D.get(i1);
      if (((TCProgressBar.ProgressBlock)localObject).m)
      {
        ((TCProgressBar.ProgressBlock)localObject).k = a(((TCProgressBar.ProgressBlock)localObject).d - ((TCProgressBar.ProgressBlock)localObject).c, i4);
        ((TCProgressBar.ProgressBlock)localObject).l = a(((TCProgressBar.ProgressBlock)localObject).c, i4);
        ((TCProgressBar.ProgressBlock)localObject).a = false;
      }
      i1 += 1;
    }
    int i8 = this.E.size();
    i1 = 0;
    while (i1 < i8)
    {
      localObject = (TCProgressBar.ProgressBlock)this.E.get(i1);
      if (((TCProgressBar.ProgressBlock)localObject).m)
      {
        ((TCProgressBar.ProgressBlock)localObject).k = a(((TCProgressBar.ProgressBlock)localObject).d - ((TCProgressBar.ProgressBlock)localObject).c, i4);
        ((TCProgressBar.ProgressBlock)localObject).l = a(((TCProgressBar.ProgressBlock)localObject).c, i4);
        ((TCProgressBar.ProgressBlock)localObject).a = false;
      }
      i1 += 1;
    }
    if (i5 > 0)
    {
      localObject = (TCProgressBar.ProgressBlock)this.D.get(i2);
      ((TCProgressBar.ProgressBlock)localObject).o = true;
      ((TCProgressBar.ProgressBlock)localObject).a = false;
      if (!((TCProgressBar.ProgressBlock)localObject).g)
      {
        i1 = this.c;
        ((TCProgressBar.ProgressBlock)localObject).d = i1;
        ((TCProgressBar.ProgressBlock)localObject).c = (i1 - this.z);
      }
      if (((TCProgressBar.ProgressBlock)localObject).m)
      {
        ((TCProgressBar.ProgressBlock)localObject).k = a(((TCProgressBar.ProgressBlock)localObject).d - ((TCProgressBar.ProgressBlock)localObject).c, i4);
        ((TCProgressBar.ProgressBlock)localObject).l = a(((TCProgressBar.ProgressBlock)localObject).c, i4);
      }
    }
    if (i5 <= 0)
    {
      i1 = i4;
      i2 = 0;
    }
    else
    {
      localObject = (TCProgressBar.ProgressBlock)this.D.get(i2);
      i1 = ((TCProgressBar.ProgressBlock)localObject).k;
      i2 = ((TCProgressBar.ProgressBlock)localObject).l + i1;
      i1 = i4 - i2;
    }
    if ((this.A.n) && (this.A.m))
    {
      localObject = this.A;
      ((TCProgressBar.BlinkBlock)localObject).k = i2;
      ((TCProgressBar.BlinkBlock)localObject).l = this.x;
    }
    int i9 = this.B.b();
    int i3 = i5;
    if (this.B.n)
    {
      i3 = i5;
      if (this.B.m)
      {
        localObject = this.B;
        ((TCProgressBar.DeleteImage)localObject).l = this.h;
        if (((TCProgressBar.DeleteImage)localObject).g)
        {
          this.B.k = (i2 - 3);
        }
        else if ((i8 == 0) && (i9 > i2))
        {
          localObject = this.B;
          ((TCProgressBar.DeleteImage)localObject).k = (i2 - 3);
          ((TCProgressBar.DeleteImage)localObject).a = true;
          ((TCProgressBar.DeleteImage)localObject).g = true;
        }
        if ((this.B.k < 0) && (this.B.g)) {
          this.B.k = 0;
        }
        if (this.B.k + this.B.l + 1 >= i7)
        {
          localObject = this.B;
          ((TCProgressBar.DeleteImage)localObject).k = (i7 - ((TCProgressBar.DeleteImage)localObject).l);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("layout:delete.requestLayout");
          ((StringBuilder)localObject).append(this.B.g);
          QLog.d("TCProgressBar", 2, ((StringBuilder)localObject).toString());
        }
        i3 = i5;
        if (!this.B.g)
        {
          i5 = this.D.size();
          if (i5 > 0)
          {
            localObject = (TCProgressBar.ProgressBlock)this.D.get(i5 - 1);
            ((TCProgressBar.ProgressBlock)localObject).o = false;
            if (((TCProgressBar.ProgressBlock)localObject).a(i9))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "layout:progress.checkBounds=true");
              }
              ((TCProgressBar.ProgressBlock)localObject).b = (this.B.k + 3);
              ((TCProgressBar.ProgressBlock)localObject).a = true;
            }
          }
          i3 = i5;
          if (i8 > 0)
          {
            localObject = (TCProgressBar.ProgressBlock)this.E.get(i8 - 1);
            i3 = i5;
            if (((TCProgressBar.ProgressBlock)localObject).a(i9))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "layout:deletedList.checkBounds=true");
              }
              ((TCProgressBar.ProgressBlock)localObject).b = (this.B.k + 3);
              ((TCProgressBar.ProgressBlock)localObject).a = true;
              i3 = i5;
            }
          }
        }
      }
    }
    if (i3 > 0)
    {
      localObject = (TCProgressBar.ProgressBlock)this.D.get(i3 - 1);
      if (((TCProgressBar.ProgressBlock)localObject).h) {
        ((TCProgressBar.ProgressBlock)localObject).l = (i4 - ((TCProgressBar.ProgressBlock)localObject).k);
      }
    }
    if (i8 > 0)
    {
      localObject = (TCProgressBar.ProgressBlock)this.E.get(0);
      if (((TCProgressBar.ProgressBlock)localObject).h) {
        ((TCProgressBar.ProgressBlock)localObject).l = (i7 - ((TCProgressBar.ProgressBlock)localObject).k);
      }
      i2 = ((TCProgressBar.ProgressBlock)localObject).k + ((TCProgressBar.ProgressBlock)localObject).l;
      i1 = i4 - i2;
    }
    if (this.C.m)
    {
      localObject = this.C;
      ((TCProgressBar.ProgressBlock)localObject).k = i2;
      ((TCProgressBar.ProgressBlock)localObject).l = i1;
      if (((TCProgressBar.ProgressBlock)localObject).l <= 1)
      {
        this.C.n = false;
        return;
      }
      localObject = this.C;
      ((TCProgressBar.ProgressBlock)localObject).n = true;
      ((TCProgressBar.ProgressBlock)localObject).l += i6;
    }
  }
  
  public int getCurrentBlockLength()
  {
    int i1 = this.D.size();
    if (i1 > 0) {
      return ((TCProgressBar.ProgressBlock)this.D.get(i1 - 1)).c;
    }
    return -1;
  }
  
  public int getCurrentBreakPoint()
  {
    int i1 = this.D.size();
    if (i1 > 0) {
      return ((TCProgressBar.ProgressBlock)this.D.get(i1 - 1)).d;
    }
    return 0;
  }
  
  public int getDeletedCount()
  {
    return this.E.size();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {
      return;
    }
    int i4 = super.getWidth();
    int i1 = super.getHeight();
    int i5 = i1 / 7;
    int i3 = i5 * 3;
    a();
    this.B.i = i1;
    Object localObject = this.y;
    int i2 = 0;
    ((Rect)localObject).left = 0;
    ((Rect)localObject).right = i4;
    ((Rect)localObject).top = 0;
    ((Rect)localObject).bottom = i3;
    this.i.setColor(0);
    paramCanvas.drawRect(this.y, this.i);
    localObject = this.y;
    i4 = i5 + i3;
    ((Rect)localObject).top = i4;
    ((Rect)localObject).bottom = i1;
    this.i.setColor(0);
    paramCanvas.drawRect(this.y, this.i);
    localObject = this.y;
    ((Rect)localObject).top = i3;
    ((Rect)localObject).bottom = i4;
    i3 = this.D.size();
    i1 = 0;
    while (i1 < i3)
    {
      localObject = (TCProgressBar.ProgressBlock)this.D.get(i1);
      if ((((TCProgressBar.ProgressBlock)localObject).m) && (((TCProgressBar.ProgressBlock)localObject).n)) {
        ((TCProgressBar.ProgressBlock)localObject).a(paramCanvas);
      }
      i1 += 1;
    }
    i3 = this.E.size();
    i1 = i2;
    while (i1 < i3)
    {
      localObject = (TCProgressBar.ProgressBlock)this.E.get(i1);
      if ((((TCProgressBar.ProgressBlock)localObject).m) && (((TCProgressBar.ProgressBlock)localObject).n)) {
        ((TCProgressBar.ProgressBlock)localObject).a(paramCanvas);
      }
      i1 += 1;
    }
    if ((this.C.m) && (this.C.n)) {
      this.C.a(paramCanvas);
    }
    if ((this.A.m) && (this.A.n)) {
      this.A.a(paramCanvas);
    }
    if ((this.B.m) && (this.B.n)) {
      this.B.a(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != this.k.left) || (paramInt2 != this.k.top + 25) || (paramInt3 != this.k.right) || (paramInt4 != this.k.bottom - 25))
    {
      Rect localRect = this.k;
      localRect.left = paramInt1;
      localRect.right = paramInt3;
      localRect.top = (paramInt2 - 25);
      localRect.bottom = (paramInt4 + 25);
      ((View)getParent()).setTouchDelegate(this.l);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.isEnabled()) {
      return false;
    }
    int i1 = paramMotionEvent.getPointerCount();
    int i2 = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    StringBuilder localStringBuilder;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 != 3) {
            return true;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onTouchEvent:action=ACTION_CANCEL count=");
            localStringBuilder.append(i1);
            localStringBuilder.append(" X=");
            localStringBuilder.append(f1);
            QLog.d("TCProgressBar", 2, localStringBuilder.toString());
          }
          if (this.B.d)
          {
            this.B.a(paramMotionEvent);
            invalidate();
            if (QLog.isColorLevel())
            {
              paramMotionEvent = new StringBuilder();
              paramMotionEvent.append("[@] [...]delete.enabled=");
              paramMotionEvent.append(this.B.n);
              paramMotionEvent.append("delete.changed=");
              paramMotionEvent.append(this.B.m);
              QLog.d("TCProgressBar", 2, paramMotionEvent.toString());
            }
            i1 = this.D.size();
            if (this.p - i1 > 0) {
              this.o = true;
            }
            paramMotionEvent = this.j;
            if (paramMotionEvent != null)
            {
              paramMotionEvent.a(this.o);
              return true;
            }
          }
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onTouchEvent:action=ACTION_MOVE count=");
            localStringBuilder.append(i1);
            localStringBuilder.append(" X=");
            localStringBuilder.append(f1);
            QLog.d("TCProgressBar", 2, localStringBuilder.toString());
          }
          if (!this.B.d) {
            return true;
          }
          this.B.a(paramMotionEvent);
          if (this.B.a())
          {
            i2 = this.B.b();
            if (this.B.f < 0)
            {
              i1 = this.D.size() - 1;
              while (i1 >= 0)
              {
                paramMotionEvent = (TCProgressBar.ProgressBlock)this.D.get(i1);
                if (!paramMotionEvent.b(i2)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "onTouchEvent:checkDelBounds=true");
                }
                this.D.remove(i1);
                paramMotionEvent.e = true;
                this.E.add(paramMotionEvent);
                i1 -= 1;
              }
            }
            i1 = this.E.size() - 1;
            while (i1 >= 0)
            {
              paramMotionEvent = (TCProgressBar.ProgressBlock)this.E.get(i1);
              if (!paramMotionEvent.c(i2)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:checkRecorverBounds=true");
              }
              this.E.remove(i1);
              paramMotionEvent.e = false;
              this.D.add(paramMotionEvent);
              i1 -= 1;
            }
            invalidate();
            return true;
          }
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onTouchEvent:action=ACTION_UP count=");
          localStringBuilder.append(i1);
          localStringBuilder.append(" X=");
          localStringBuilder.append(f1);
          QLog.d("TCProgressBar", 2, localStringBuilder.toString());
        }
        if (!this.B.d) {
          return true;
        }
        this.B.a(paramMotionEvent);
        if (this.B.a(f1))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onTouchEvent:action=ACTION_UP[checkBounds:true] count=");
            localStringBuilder.append(i1);
            localStringBuilder.append(" X=");
            localStringBuilder.append(f1);
            QLog.d("TCProgressBar", 2, localStringBuilder.toString());
          }
          if ((SystemClock.elapsedRealtime() - this.m < 400L) && (Math.abs(paramMotionEvent.getX() - this.n) < 25.0F))
          {
            i1 = this.D.size();
            if (i1 > 0)
            {
              paramMotionEvent = (TCProgressBar.ProgressBlock)this.D.remove(i1 - 1);
              paramMotionEvent.e = true;
              this.E.add(paramMotionEvent);
              if (QLog.isColorLevel())
              {
                paramMotionEvent = new StringBuilder();
                paramMotionEvent.append("onTouchEvent:action=ACTION_UP progress:[size]=");
                paramMotionEvent.append(this.D.size());
                paramMotionEvent.append(" deletedList[size]=");
                paramMotionEvent.append(this.E.size());
                QLog.d("TCProgressBar", 2, paramMotionEvent.toString());
              }
            }
          }
        }
        if (this.E.size() > 0) {
          this.B.a = false;
        } else {
          this.B.a = true;
        }
        invalidate();
        if (QLog.isColorLevel())
        {
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("[@] [...]delete.enabled=");
          paramMotionEvent.append(this.B.n);
          paramMotionEvent.append("delete.changed=");
          paramMotionEvent.append(this.B.m);
          QLog.d("TCProgressBar", 2, paramMotionEvent.toString());
        }
        i1 = this.D.size();
        if (this.p - i1 > 0) {
          this.o = true;
        }
        paramMotionEvent = this.j;
        if (paramMotionEvent != null)
        {
          paramMotionEvent.a(this.o);
          return true;
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTouchEvent:action=ACTION_DOWN count=");
        localStringBuilder.append(i1);
        localStringBuilder.append(" X=");
        localStringBuilder.append(f1);
        QLog.d("TCProgressBar", 2, localStringBuilder.toString());
      }
      this.m = SystemClock.elapsedRealtime();
      this.n = paramMotionEvent.getX();
      this.p = this.D.size();
      this.o = false;
      if (this.B.a(f1)) {
        this.B.a(paramMotionEvent);
      }
    }
    return true;
  }
  
  public void setMax(int paramInt1, int paramInt2)
  {
    this.b = paramInt2;
  }
  
  public void setProgress(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setProgress, progress = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",isOver = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("TCProgressBar", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      this.c = this.b;
      this.d = true;
    }
    else
    {
      this.d = false;
      this.c = paramInt;
    }
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.TCProgressBar
 * JD-Core Version:    0.7.0.1
 */