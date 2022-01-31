package dov.com.tencent.mobileqq.shortvideo.widget;

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
import bnsm;
import bntk;
import bntl;
import bntm;
import bnto;
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
  bntk jdField_a_of_type_Bntk = new bntk(this);
  public bntl a;
  bntm jdField_a_of_type_Bntm = new bntm(this);
  bnto jdField_a_of_type_Bnto = new bnto(this, true);
  ArrayList<bnto> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  boolean jdField_a_of_type_Boolean;
  public int b;
  public Bitmap b;
  public Rect b;
  ArrayList<bnto> jdField_b_of_type_JavaUtilArrayList = new ArrayList(10);
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
  public int l = bnsm.a(1.0F);
  public int m = -1;
  int n = bnsm.a(5.0F);
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
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130845600);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramContext.getResources(), 2130845599);
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
  
  void a()
  {
    int i7 = super.getWidth();
    int i6 = this.jdField_e_of_type_Int - 3;
    int i4 = i7 - i6;
    int i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    while (i1 < i5 - 1)
    {
      localbnto = (bnto)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (localbnto.d)
      {
        localbnto.jdField_f_of_type_Int = a(localbnto.jdField_c_of_type_Int - localbnto.jdField_b_of_type_Int, i4);
        localbnto.jdField_g_of_type_Int = a(localbnto.jdField_b_of_type_Int, i4);
        localbnto.jdField_a_of_type_Boolean = false;
      }
      i1 += 1;
    }
    int i8 = this.jdField_b_of_type_JavaUtilArrayList.size();
    i1 = 0;
    while (i1 < i8)
    {
      localbnto = (bnto)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
      if (localbnto.d)
      {
        localbnto.jdField_f_of_type_Int = a(localbnto.jdField_c_of_type_Int - localbnto.jdField_b_of_type_Int, i4);
        localbnto.jdField_g_of_type_Int = a(localbnto.jdField_b_of_type_Int, i4);
        localbnto.jdField_a_of_type_Boolean = false;
      }
      i1 += 1;
    }
    if (i5 > 0)
    {
      localbnto = (bnto)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1);
      localbnto.jdField_f_of_type_Boolean = true;
      localbnto.jdField_a_of_type_Boolean = false;
      if (!localbnto.jdField_g_of_type_Boolean)
      {
        localbnto.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
        localbnto.jdField_b_of_type_Int = (this.jdField_c_of_type_Int - this.o);
      }
      if (localbnto.d)
      {
        localbnto.jdField_f_of_type_Int = a(localbnto.jdField_c_of_type_Int - localbnto.jdField_b_of_type_Int, i4);
        localbnto.jdField_g_of_type_Int = a(localbnto.jdField_b_of_type_Int, i4);
      }
    }
    int i2;
    int i9;
    int i3;
    if (i5 <= 0)
    {
      i2 = i4;
      i1 = 0;
      if ((this.jdField_a_of_type_Bntk.jdField_e_of_type_Boolean) && (this.jdField_a_of_type_Bntk.d))
      {
        this.jdField_a_of_type_Bntk.jdField_f_of_type_Int = i1;
        this.jdField_a_of_type_Bntk.jdField_g_of_type_Int = this.n;
      }
      i9 = this.jdField_a_of_type_Bntm.a();
      i3 = i5;
      if (this.jdField_a_of_type_Bntm.jdField_e_of_type_Boolean)
      {
        i3 = i5;
        if (this.jdField_a_of_type_Bntm.d)
        {
          this.jdField_a_of_type_Bntm.jdField_g_of_type_Int = this.jdField_e_of_type_Int;
          if (!this.jdField_a_of_type_Bntm.jdField_c_of_type_Boolean) {
            break label877;
          }
          this.jdField_a_of_type_Bntm.jdField_f_of_type_Int = (i1 - 3);
        }
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bntm.jdField_f_of_type_Int < 0) && (this.jdField_a_of_type_Bntm.jdField_c_of_type_Boolean)) {
        this.jdField_a_of_type_Bntm.jdField_f_of_type_Int = 0;
      }
      if (this.jdField_a_of_type_Bntm.jdField_f_of_type_Int + this.jdField_a_of_type_Bntm.jdField_g_of_type_Int + 1 >= i7) {
        this.jdField_a_of_type_Bntm.jdField_f_of_type_Int = (i7 - this.jdField_a_of_type_Bntm.jdField_g_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TCProgressBar", 2, "layout:delete.requestLayout" + this.jdField_a_of_type_Bntm.jdField_c_of_type_Boolean);
      }
      i3 = i5;
      if (!this.jdField_a_of_type_Bntm.jdField_c_of_type_Boolean)
      {
        i5 = this.jdField_a_of_type_JavaUtilArrayList.size();
        if (i5 > 0)
        {
          localbnto = (bnto)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1);
          localbnto.jdField_f_of_type_Boolean = false;
          if (localbnto.a(i9))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TCProgressBar", 2, "layout:progress.checkBounds=true");
            }
            localbnto.jdField_a_of_type_Int = (this.jdField_a_of_type_Bntm.jdField_f_of_type_Int + 3);
            localbnto.jdField_a_of_type_Boolean = true;
          }
        }
        i3 = i5;
        if (i8 > 0)
        {
          localbnto = (bnto)this.jdField_b_of_type_JavaUtilArrayList.get(i8 - 1);
          i3 = i5;
          if (localbnto.a(i9))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TCProgressBar", 2, "layout:deletedList.checkBounds=true");
            }
            localbnto.jdField_a_of_type_Int = (this.jdField_a_of_type_Bntm.jdField_f_of_type_Int + 3);
            localbnto.jdField_a_of_type_Boolean = true;
            i3 = i5;
          }
        }
      }
      if (i3 > 0)
      {
        localbnto = (bnto)this.jdField_a_of_type_JavaUtilArrayList.get(i3 - 1);
        if (localbnto.h) {
          localbnto.jdField_g_of_type_Int = (i4 - localbnto.jdField_f_of_type_Int);
        }
      }
      if (i8 > 0)
      {
        localbnto = (bnto)this.jdField_b_of_type_JavaUtilArrayList.get(0);
        if (localbnto.h) {
          localbnto.jdField_g_of_type_Int = (i7 - localbnto.jdField_f_of_type_Int);
        }
        i1 = localbnto.jdField_f_of_type_Int + localbnto.jdField_g_of_type_Int;
        i2 = i4 - i1;
      }
      if (this.jdField_a_of_type_Bnto.d)
      {
        this.jdField_a_of_type_Bnto.jdField_f_of_type_Int = i1;
        this.jdField_a_of_type_Bnto.jdField_g_of_type_Int = i2;
        if (this.jdField_a_of_type_Bnto.jdField_g_of_type_Int > 1) {
          break label917;
        }
        this.jdField_a_of_type_Bnto.jdField_e_of_type_Boolean = false;
      }
      return;
      localbnto = (bnto)this.jdField_a_of_type_JavaUtilArrayList.get(i5 - 1);
      i2 = localbnto.jdField_f_of_type_Int + localbnto.jdField_g_of_type_Int;
      i1 = i2;
      i2 = i4 - i2;
      break;
      label877:
      if ((i8 == 0) && (i9 > i1))
      {
        this.jdField_a_of_type_Bntm.jdField_f_of_type_Int = (i1 - 3);
        this.jdField_a_of_type_Bntm.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bntm.jdField_c_of_type_Boolean = true;
      }
    }
    label917:
    this.jdField_a_of_type_Bnto.jdField_e_of_type_Boolean = true;
    bnto localbnto = this.jdField_a_of_type_Bnto;
    localbnto.jdField_g_of_type_Int += i6;
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
      a();
      this.jdField_a_of_type_Bntm.jdField_e_of_type_Int = i3;
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
      bnto localbnto;
      while (i1 < i3)
      {
        localbnto = (bnto)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if ((localbnto.d) && (localbnto.jdField_e_of_type_Boolean)) {
          localbnto.a(paramCanvas);
        }
        i1 += 1;
      }
      i3 = this.jdField_b_of_type_JavaUtilArrayList.size();
      i1 = i2;
      while (i1 < i3)
      {
        localbnto = (bnto)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
        if ((localbnto.d) && (localbnto.jdField_e_of_type_Boolean)) {
          localbnto.a(paramCanvas);
        }
        i1 += 1;
      }
      if ((this.jdField_a_of_type_Bnto.d) && (this.jdField_a_of_type_Bnto.jdField_e_of_type_Boolean)) {
        this.jdField_a_of_type_Bnto.a(paramCanvas);
      }
      if ((this.jdField_a_of_type_Bntk.d) && (this.jdField_a_of_type_Bntk.jdField_e_of_type_Boolean)) {
        this.jdField_a_of_type_Bntk.a(paramCanvas);
      }
    } while ((!this.jdField_a_of_type_Bntm.d) || (!this.jdField_a_of_type_Bntm.jdField_e_of_type_Boolean));
    this.jdField_a_of_type_Bntm.a(paramCanvas);
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
      if (this.jdField_a_of_type_Bntm.a(f1))
      {
        this.jdField_a_of_type_Bntm.a(paramMotionEvent);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_MOVE count=" + i1 + " X=" + f1);
        }
        if (this.jdField_a_of_type_Bntm.jdField_b_of_type_Boolean)
        {
          this.jdField_a_of_type_Bntm.a(paramMotionEvent);
          if (this.jdField_a_of_type_Bntm.a())
          {
            i2 = this.jdField_a_of_type_Bntm.a();
            if (this.jdField_a_of_type_Bntm.jdField_c_of_type_Int < 0)
            {
              i1 = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
              while (i1 >= 0)
              {
                paramMotionEvent = (bnto)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
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
              paramMotionEvent = (bnto)this.jdField_b_of_type_JavaUtilArrayList.get(i1);
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
            if (this.jdField_a_of_type_Bntm.jdField_b_of_type_Boolean)
            {
              this.jdField_a_of_type_Bntm.a(paramMotionEvent);
              if (this.jdField_a_of_type_Bntm.a(f1))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP[checkBounds:true] count=" + i1 + " X=" + f1);
                }
                if ((SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < 400L) && (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) < 25.0F))
                {
                  i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
                  if (i1 > 0)
                  {
                    paramMotionEvent = (bnto)this.jdField_a_of_type_JavaUtilArrayList.remove(i1 - 1);
                    paramMotionEvent.jdField_b_of_type_Boolean = true;
                    this.jdField_b_of_type_JavaUtilArrayList.add(paramMotionEvent);
                    if (QLog.isColorLevel()) {
                      QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_UP progress:[size]=" + this.jdField_a_of_type_JavaUtilArrayList.size() + " deletedList[size]=" + this.jdField_b_of_type_JavaUtilArrayList.size());
                    }
                  }
                }
              }
              if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {}
              for (this.jdField_a_of_type_Bntm.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_Bntm.jdField_a_of_type_Boolean = true)
              {
                invalidate();
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "[@] [...]delete.enabled=" + this.jdField_a_of_type_Bntm.jdField_e_of_type_Boolean + "delete.changed=" + this.jdField_a_of_type_Bntm.d);
                }
                i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
                if (this.jdField_f_of_type_Int - i1 > 0) {
                  this.jdField_b_of_type_Boolean = true;
                }
                if (this.jdField_a_of_type_Bntl == null) {
                  break;
                }
                this.jdField_a_of_type_Bntl.a(this.jdField_b_of_type_Boolean);
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("TCProgressBar", 2, "onTouchEvent:action=ACTION_CANCEL count=" + i1 + " X=" + f1);
              }
              if (this.jdField_a_of_type_Bntm.jdField_b_of_type_Boolean)
              {
                this.jdField_a_of_type_Bntm.a(paramMotionEvent);
                invalidate();
                if (QLog.isColorLevel()) {
                  QLog.d("TCProgressBar", 2, "[@] [...]delete.enabled=" + this.jdField_a_of_type_Bntm.jdField_e_of_type_Boolean + "delete.changed=" + this.jdField_a_of_type_Bntm.d);
                }
                i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
                if (this.jdField_f_of_type_Int - i1 > 0) {
                  this.jdField_b_of_type_Boolean = true;
                }
                if (this.jdField_a_of_type_Bntl != null) {
                  this.jdField_a_of_type_Bntl.a(this.jdField_b_of_type_Boolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar
 * JD-Core Version:    0.7.0.1
 */