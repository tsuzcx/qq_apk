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
import bbye;
import bbyf;
import bbyg;
import bbyi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TCProgressBar
  extends View
{
  float jdField_a_of_type_Float;
  public int a;
  long jdField_a_of_type_Long;
  public Bitmap a;
  public Paint a;
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  TouchDelegate jdField_a_of_type_AndroidViewTouchDelegate = new TouchDelegate(this.jdField_a_of_type_AndroidGraphicsRect, this);
  bbye jdField_a_of_type_Bbye = new bbye(this);
  public bbyf a;
  bbyg jdField_a_of_type_Bbyg = new bbyg(this);
  bbyi jdField_a_of_type_Bbyi = new bbyi(this, true);
  ArrayList<bbyi> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  boolean jdField_a_of_type_Boolean;
  public int b;
  public Bitmap b;
  public Rect b;
  ArrayList<bbyi> jdField_b_of_type_JavaUtilArrayList = new ArrayList(10);
  boolean jdField_b_of_type_Boolean = false;
  public int c;
  int d = 1000;
  public int e;
  int f;
  public int g;
  public int h = -14408659;
  public int i = -16737062;
  public int j = -65536;
  public int k = -15000805;
  public int l = ScreenUtil.dip2px(1.0F);
  public int m = -1;
  int n = ScreenUtil.dip2px(5.0F);
  int o = 0;
  
  public TCProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 1310991405;
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_Int = 3;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130845913);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130845912);
      this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new TCProgressBar.TimerRefresh(this), this.d);
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        this.jdField_e_of_type_Int = 100;
      }
    }
  }
  
  public int a()
  {
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i1 > 0) {
      return ((bbyi)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1)).jdField_b_of_type_Int;
    }
    return -1;
  }
  
  int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.jdField_b_of_type_Int) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / this.jdField_b_of_type_Int;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  public void a()
  {
    a(4);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      invalidate();
      return;
      this.jdField_a_of_type_Bbye.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Bbyg.jdField_e_of_type_Boolean = false;
      continue;
      this.jdField_a_of_type_Bbye.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_Bbyg.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Bbyg.jdField_a_of_type_Boolean = true;
      continue;
      this.jdField_a_of_type_Bbye.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Bbyg.jdField_e_of_type_Boolean = false;
      bbyi localbbyi = new bbyi(this, false);
      localbbyi.jdField_b_of_type_Boolean = false;
      localbbyi.jdField_c_of_type_Int = 0;
      localbbyi.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_JavaUtilArrayList.add(localbbyi);
      continue;
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Int = 0;
      this.o = 0;
    }
  }
  
  public int b()
  {
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = i2;
    if (i2 > 0)
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(i2 - 1);
      i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (i1 > 0)
    {
      this.o = c();
      i1 = this.o;
      this.jdField_c_of_type_Int = i1;
      return i1;
    }
    this.o = 0;
    this.jdField_c_of_type_Int = 0;
    return 0;
  }
  
  void b()
  {
    int i7 = super.getWidth();
    int i6 = this.jdField_e_of_type_Int - 3;
    int i4 = i7 - i6;
    int i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i5 - 1)
    {
      localbbyi = (bbyi)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (localbbyi.d)
      {
        localbbyi.jdField_f_of_type_Int = a(localbbyi.jdField_c_of_type_Int - localbbyi.jdField_b_of_type_Int, i4);
        localbbyi.jdField_g_of_type_Int = a(localbbyi.jdField_b_of_type_Int, i4);
        localbbyi.jdField_a_of_type_Boolean = false;
      }
      i1 += 1;
    }
    int i8 = this.jdField_b_of_type_JavaUtilArrayList.size();
    i1 = 0;
    while (i1 < i8)
    {
      localbbyi = (bbyi)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if (localbbyi.d)
      {
        localbbyi.jdField_f_of_type_Int = a(localbbyi.jdField_c_of_type_Int - localbbyi.jdField_b_of_type_Int, i4);
        localbbyi.jdField_g_of_type_Int = a(localbbyi.jdField_b_of_type_Int, i4);
        localbbyi.jdField_a_of_type_Boolean = false;
      }
      i1 += 1;
    }
    if (i5 > 0)
    {
      localbbyi = (bbyi)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1);
      localbbyi.jdField_f_of_type_Boolean = true;
      localbbyi.jdField_a_of_type_Boolean = false;
      if (!localbbyi.jdField_g_of_type_Boolean)
      {
        localbbyi.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
        localbbyi.jdField_b_of_type_Int = (this.jdField_c_of_type_Int - this.o);
      }
      if (localbbyi.d)
      {
        localbbyi.jdField_f_of_type_Int = a(localbbyi.jdField_c_of_type_Int - localbbyi.jdField_b_of_type_Int, i4);
        localbbyi.jdField_g_of_type_Int = a(localbbyi.jdField_b_of_type_Int, i4);
      }
    }
    int i2;
    int i9;
    int i3;
    if (i5 <= 0)
    {
      i2 = i4;
      i1 = 0;
      if ((this.jdField_a_of_type_Bbye.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Bbye.d))
      {
        this.jdField_a_of_type_Bbye.jdField_f_of_type_Int = i1;
        this.jdField_a_of_type_Bbye.jdField_g_of_type_Int = this.n;
      }
      i9 = this.jdField_a_of_type_Bbyg.a();
      i3 = i5;
      if (this.jdField_a_of_type_Bbyg.jdField_e_of_type_Boolean)
      {
        i3 = i5;
        if (this.jdField_a_of_type_Bbyg.d)
        {
          this.jdField_a_of_type_Bbyg.jdField_g_of_type_Int = this.jdField_e_of_type_Int;
          if (!this.jdField_a_of_type_Bbyg.jdField_c_of_type_Boolean) {
            break label879;
          }
          this.jdField_a_of_type_Bbyg.jdField_f_of_type_Int = (i1 - 3);
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bbyg.jdField_f_of_type_Int < 0) && (this.jdField_a_of_type_Bbyg.jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_Bbyg.jdField_f_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_Bbyg.jdField_f_of_type_Int + this.jdField_a_of_type_Bbyg.jdField_g_of_type_Int + 1 >= i7) {
        this.jdField_a_of_type_Bbyg.jdField_f_of_type_Int = (i7 - this.jdField_a_of_type_Bbyg.jdField_g_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "layout:delete.requestLayout" + this.jdField_a_of_type_Bbyg.jdField_c_of_type_Boolean);
      }
      i3 = i5;
      if (!this.jdField_a_of_type_Bbyg.jdField_c_of_type_Boolean)
      {
        i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (i5 > 0)
        {
          localbbyi = (bbyi)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1);
          localbbyi.jdField_f_of_type_Boolean = false;
          if (localbbyi.a(i9))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TCProgressBar", 2, "layout:progress.checkBounds=true");
            }
            localbbyi.jdField_a_of_type_Int = (this.jdField_a_of_type_Bbyg.jdField_f_of_type_Int + 3);
            localbbyi.jdField_a_of_type_Boolean = true;
          }
        }
        i3 = i5;
        if (i8 > 0)
        {
          localbbyi = (bbyi)this.jdField_b_of_type_JavaUtilArrayList.get(i8 - 1);
          i3 = i5;
          if (localbbyi.a(i9))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TCProgressBar", 2, "layout:deletedList.checkBounds=true");
            }
            localbbyi.jdField_a_of_type_Int = (this.jdField_a_of_type_Bbyg.jdField_f_of_type_Int + 3);
            localbbyi.jdField_a_of_type_Boolean = true;
            i3 = i5;
          }
        }
      }
      if (i3 > 0)
      {
        localbbyi = (bbyi)this.jdField_a_of_type_JavaUtilArrayList.get(i3 - 1);
        if (localbbyi.h) {
          localbbyi.jdField_g_of_type_Int = (i4 - localbbyi.jdField_f_of_type_Int);
        }
      }
      if (i8 > 0)
      {
        localbbyi = (bbyi)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        if (localbbyi.h) {
          localbbyi.jdField_g_of_type_Int = (i7 - localbbyi.jdField_f_of_type_Int);
        }
        i1 = localbbyi.jdField_f_of_type_Int + localbbyi.jdField_g_of_type_Int;
        i2 = i4 - i1;
      }
      if (this.jdField_a_of_type_Bbyi.d)
      {
        this.jdField_a_of_type_Bbyi.jdField_f_of_type_Int = i1;
        this.jdField_a_of_type_Bbyi.jdField_g_of_type_Int = i2;
        if (this.jdField_a_of_type_Bbyi.jdField_g_of_type_Int > 1) {
          break label919;
        }
        this.jdField_a_of_type_Bbyi.jdField_e_of_type_Boolean = false;
      }
      return;
      localbbyi = (bbyi)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1);
      i2 = localbbyi.jdField_f_of_type_Int + localbbyi.jdField_g_of_type_Int;
      i1 = i2;
      i2 = i4 - i2;
      break;
      label879:
      if ((i8 == 0) && (i9 > i1))
      {
        this.jdField_a_of_type_Bbyg.jdField_f_of_type_Int = (i1 - 3);
        this.jdField_a_of_type_Bbyg.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bbyg.jdField_c_of_type_Boolean = true;
      }
    }
    label919:
    this.jdField_a_of_type_Bbyi.jdField_e_of_type_Boolean = true;
    bbyi localbbyi = this.jdField_a_of_type_Bbyi;
    localbbyi.jdField_g_of_type_Int += i6;
  }
  
  public int c()
  {
    int i1 = 0;
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i2 > 0) {
      i1 = ((bbyi)this.jdField_a_of_type_JavaUtilArrayList.get(i2 - 1)).jdField_c_of_type_Int;
    }
    return i1;
  }
  
  public void c()
  {
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i1 > 0)
    {
      bbyi localbbyi = (bbyi)this.jdField_a_of_type_JavaUtilArrayList.get(i1 - 1);
      if (this.jdField_a_of_type_Boolean)
      {
        localbbyi.h = true;
        this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      }
      localbbyi.jdField_b_of_type_Boolean = false;
      localbbyi.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
      localbbyi.jdField_b_of_type_Int = (this.jdField_c_of_type_Int - this.o);
      localbbyi.jdField_g_of_type_Boolean = true;
      this.o = this.jdField_c_of_type_Int;
    }
  }
  
  public int d()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public void d()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0)
    {
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      this.o = c();
      this.jdField_c_of_type_Int = this.o;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i2 = 0;
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {}
    do
    {
      return;
      int i1 = super.getWidth();
      int i3 = super.getHeight();
      int i4 = i3 / 7;
      int i5 = i4 * 3;
      b();
      this.jdField_a_of_type_Bbyg.jdField_e_of_type_Int = i3;
      this.jdField_b_of_type_AndroidGraphicsRect.left = 0;
      this.jdField_b_of_type_AndroidGraphicsRect.right = i1;
      this.jdField_b_of_type_AndroidGraphicsRect.top = 0;
      this.jdField_b_of_type_AndroidGraphicsRect.bottom = i5;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
      paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_b_of_type_AndroidGraphicsRect.top = (i5 + i4);
      this.jdField_b_of_type_AndroidGraphicsRect.bottom = i3;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(0);
      paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_b_of_type_AndroidGraphicsRect.top = i5;
      this.jdField_b_of_type_AndroidGraphicsRect.bottom = (i5 + i4);
      i3 = this.jdField_a_of_type_JavaUtilArrayList.size();
      i1 = 0;
      bbyi localbbyi;
      while (i1 < i3)
      {
        localbbyi = (bbyi)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((localbbyi.d) && (localbbyi.jdField_e_of_type_Boolean)) {
          localbbyi.a(paramCanvas);
        }
        i1 += 1;
      }
      i3 = this.jdField_b_of_type_JavaUtilArrayList.size();
      i1 = i2;
      while (i1 < i3)
      {
        localbbyi = (bbyi)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
        if ((localbbyi.d) && (localbbyi.jdField_e_of_type_Boolean)) {
          localbbyi.a(paramCanvas);
        }
        i1 += 1;
      }
      if ((this.jdField_a_of_type_Bbyi.d) && (this.jdField_a_of_type_Bbyi.jdField_e_of_type_Boolean)) {
        this.jdField_a_of_type_Bbyi.a(paramCanvas);
      }
      if ((this.jdField_a_of_type_Bbye.d) && (this.jdField_a_of_type_Bbye.jdField_e_of_type_Boolean)) {
        this.jdField_a_of_type_Bbye.a(paramCanvas);
      }
    } while ((!this.jdField_a_of_type_Bbyg.d) || (!this.jdField_a_of_type_Bbyg.jdField_e_of_type_Boolean));
    this.jdField_a_of_type_Bbyg.a(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 != this.jdField_a_of_type_AndroidGraphicsRect.left) || (paramInt2 != this.jdField_a_of_type_AndroidGraphicsRect.top + 25) || (paramInt3 != this.jdField_a_of_type_AndroidGraphicsRect.right) || (paramInt4 != this.jdField_a_of_type_AndroidGraphicsRect.bottom - 25))
    {
      this.jdField_a_of_type_AndroidGraphicsRect.left = paramInt1;
      this.jdField_a_of_type_AndroidGraphicsRect.right = paramInt3;
      this.jdField_a_of_type_AndroidGraphicsRect.top = (paramInt2 - 25);
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = (paramInt4 + 25);
      ((View)getParent()).setTouchDelegate(this.jdField_a_of_type_AndroidViewTouchDelegate);
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
    switch (i2)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_DOWN count=" + i1 + " X=" + f1);
      }
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_f_of_type_Int = this.jdField_a_of_type_JavaUtilArrayList.size();
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_Bbyg.a(f1))
      {
        this.jdField_a_of_type_Bbyg.a(paramMotionEvent);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_MOVE count=" + i1 + " X=" + f1);
        }
        if (this.jdField_a_of_type_Bbyg.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Bbyg.a(paramMotionEvent);
          if (this.jdField_a_of_type_Bbyg.a())
          {
            i2 = this.jdField_a_of_type_Bbyg.a();
            if (this.jdField_a_of_type_Bbyg.jdField_c_of_type_Int < 0)
            {
              i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
              while (i1 >= 0)
              {
                paramMotionEvent = (bbyi)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
                if (!paramMotionEvent.b(i2)) {
                  break;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "onTouchEvent:checkDelBounds=true");
                }
                this.jdField_a_of_type_JavaUtilArrayList.remove(i1);
                paramMotionEvent.jdField_b_of_type_Boolean = true;
                this.jdField_b_of_type_JavaUtilArrayList.add(paramMotionEvent);
                i1 -= 1;
              }
            }
            i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
            while (i1 >= 0)
            {
              paramMotionEvent = (bbyi)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
              if (!paramMotionEvent.c(i2)) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:checkRecorverBounds=true");
              }
              this.jdField_b_of_type_JavaUtilArrayList.remove(i1);
              paramMotionEvent.jdField_b_of_type_Boolean = false;
              this.jdField_a_of_type_JavaUtilArrayList.add(paramMotionEvent);
              i1 -= 1;
            }
            invalidate();
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP count=" + i1 + " X=" + f1);
            }
            if (this.jdField_a_of_type_Bbyg.jdField_b_of_type_Boolean)
            {
              this.jdField_a_of_type_Bbyg.a(paramMotionEvent);
              if (this.jdField_a_of_type_Bbyg.a(f1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP[checkBounds:true] count=" + i1 + " X=" + f1);
                }
                if ((SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 400L) && (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) < 25.0F))
                {
                  i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
                  if (i1 > 0)
                  {
                    paramMotionEvent = (bbyi)this.jdField_a_of_type_JavaUtilArrayList.remove(i1 - 1);
                    paramMotionEvent.jdField_b_of_type_Boolean = true;
                    this.jdField_b_of_type_JavaUtilArrayList.add(paramMotionEvent);
                    if (QLog.isColorLevel()) {
                      QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP progress:[size]=" + this.jdField_a_of_type_JavaUtilArrayList.size() + " deletedList[size]=" + this.jdField_b_of_type_JavaUtilArrayList.size());
                    }
                  }
                }
              }
              if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {}
              for (this.jdField_a_of_type_Bbyg.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Bbyg.jdField_a_of_type_Boolean = true)
              {
                invalidate();
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "[@] [...]delete.enabled=" + this.jdField_a_of_type_Bbyg.jdField_e_of_type_Boolean + "delete.changed=" + this.jdField_a_of_type_Bbyg.d);
                }
                i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
                if (this.jdField_f_of_type_Int - i1 > 0) {
                  this.jdField_b_of_type_Boolean = true;
                }
                if (this.jdField_a_of_type_Bbyf == null) {
                  break;
                }
                this.jdField_a_of_type_Bbyf.f(this.jdField_b_of_type_Boolean);
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_CANCEL count=" + i1 + " X=" + f1);
              }
              if (this.jdField_a_of_type_Bbyg.jdField_b_of_type_Boolean)
              {
                this.jdField_a_of_type_Bbyg.a(paramMotionEvent);
                invalidate();
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "[@] [...]delete.enabled=" + this.jdField_a_of_type_Bbyg.jdField_e_of_type_Boolean + "delete.changed=" + this.jdField_a_of_type_Bbyg.d);
                }
                i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
                if (this.jdField_f_of_type_Int - i1 > 0) {
                  this.jdField_b_of_type_Boolean = true;
                }
                if (this.jdField_a_of_type_Bbyf != null) {
                  this.jdField_a_of_type_Bbyf.f(this.jdField_b_of_type_Boolean);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setMax(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void setProgress(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TCProgressBar", 2, "setProgress, progress = " + paramInt + ",isOver = " + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      postInvalidate();
      return;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Int = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.TCProgressBar
 * JD-Core Version:    0.7.0.1
 */