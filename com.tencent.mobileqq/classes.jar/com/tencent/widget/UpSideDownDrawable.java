package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class UpSideDownDrawable
  extends Drawable
  implements Handler.Callback
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private UpSideDownDrawable.State jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int c = 0;
  private int d = 0;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public UpSideDownDrawable(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramBitmap.getWidth();
    this.jdField_b_of_type_Int = paramBitmap.getHeight();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.e = paramInt1;
    if (this.e <= 0) {
      if ((paramContext == null) || (paramContext.getResources() == null)) {
        break label307;
      }
    }
    label307:
    for (this.e = ScreenUtil.getInstantScreenWidth(paramContext);; this.e = ScreenUtil.SCREEN_WIDTH)
    {
      int i = paramInt2;
      if (paramInt2 <= 0) {
        i = ScreenUtil.dip2px(170.0F);
      }
      this.f = (this.jdField_a_of_type_Int * i / this.e);
      this.g = (this.jdField_b_of_type_Int * 15 / 100);
      this.h = (this.jdField_b_of_type_Int * 85 / 100);
      if (QLog.isColorLevel()) {
        QLog.i("UpSideDownDrawable", 2, String.format("UpSideDownDrawable bw=%d bh=%d dw=%d dh=%d mDisplayHeight=%d mTop=%d mBot=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h) }));
      }
      this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new AccelerateDecelerateInterpolator());
      this.d = this.g;
      this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State = new UpSideDownDrawable.State(this);
      return;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_a_of_type_Int = (this.h - this.f);
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_b_of_type_Int = (-(this.h - this.g - this.f));
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.c = 12000;
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.d = 3;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_a_of_type_Int = this.g;
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_b_of_type_Int = (this.h - this.g - this.f);
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.c = 12000;
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.d = 2;
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_a_of_type_Int = this.g;
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_b_of_type_Int = (this.h - this.g - this.f);
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.c = 12000;
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.d = 2;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_a_of_type_Int = this.g;
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_b_of_type_Int = (this.h - this.g - this.f);
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.c = 12000;
    this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.d = 2;
    this.d = this.g;
    this.jdField_a_of_type_Boolean = false;
    invalidateSelf();
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(2))
    {
      this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.d = 2;
      this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_b_of_type_Int = (this.h - this.g - this.f);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_a_of_type_Int = this.d;
      this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.c = (this.jdField_a_of_type_AndroidWidgetScroller.getDuration() - this.jdField_a_of_type_AndroidWidgetScroller.timePassed());
      this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_Boolean = false;
      return;
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(3))
      {
        this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.d = 3;
        this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_b_of_type_Int = (-(this.h - this.g - this.f));
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, this.d, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.d + this.f);
    this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.f);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getIntrinsicHeight()
  {
    return this.f;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(0, this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_a_of_type_Int, 0, this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.c);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(this.jdField_a_of_type_ComTencentWidgetUpSideDownDrawable$State.d);
      this.jdField_a_of_type_Boolean = true;
      return false;
    case 2: 
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
      {
        this.d = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
        if (this.d <= this.h - this.f)
        {
          invalidateSelf();
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 20L);
          return false;
        }
        e();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        return false;
      }
      e();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return false;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.d = this.jdField_a_of_type_AndroidWidgetScroller.getCurrY();
      if (this.d >= this.g)
      {
        invalidateSelf();
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 20L);
        return false;
      }
      f();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return false;
    }
    f();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    return false;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.UpSideDownDrawable
 * JD-Core Version:    0.7.0.1
 */