package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import bbkx;
import bkrq;
import bkrr;
import bkrt;
import bkrv;
import bkrw;
import bkrx;

public class VideoFrameSelectBar
  extends View
  implements bkrq, bkrt, bkrw
{
  private static final int jdField_a_of_type_Int = bbkx.a(13.0F);
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private bkrr jdField_a_of_type_Bkrr;
  private bkrv jdField_a_of_type_Bkrv;
  private bkrx jdField_a_of_type_Bkrx;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 3000;
  private boolean jdField_c_of_type_Boolean;
  private float d;
  private float e;
  private float f;
  private float g;
  
  public VideoFrameSelectBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private float a(float paramFloat)
  {
    return paramFloat / this.jdField_c_of_type_Float * this.jdField_c_of_type_Int;
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bkrv.a(paramMotionEvent);
    }
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bkrr.a(paramMotionEvent);
  }
  
  private void c()
  {
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangString = String.format("%.1f''", new Object[] { Float.valueOf(this.f / 1000.0F) });
    this.g = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bkrx != null) {
      this.jdField_a_of_type_Bkrx.a(this.f);
    }
  }
  
  public float a()
  {
    return this.d + this.e;
  }
  
  void a()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.e = a((int)(paramFloat1 - this.jdField_a_of_type_Bkrv.b()));
    this.f = a(paramFloat2 - paramFloat1);
    d();
    this.jdField_a_of_type_Bkrr.a((int)paramFloat1);
    this.jdField_a_of_type_Bkrr.b((int)paramFloat2);
    invalidate();
    if (this.jdField_a_of_type_Bkrx != null) {
      this.jdField_a_of_type_Bkrx.a((int)a(), (int)b());
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.d = a(paramFloat1);
    d();
    if (this.jdField_a_of_type_Bkrv != null) {
      this.jdField_a_of_type_Bkrv.a(paramFloat2, paramFloat3);
    }
    if (this.jdField_a_of_type_Bkrx != null) {
      this.jdField_a_of_type_Bkrx.a((int)a(), (int)b());
    }
  }
  
  boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public float b()
  {
    return this.d + this.e + this.f;
  }
  
  void b()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Bkrv == null) || (this.jdField_a_of_type_Bkrr == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(40.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.translate(0.0F, jdField_a_of_type_Int + 50);
    if (this.jdField_a_of_type_Bkrr != null) {
      this.jdField_a_of_type_Bkrr.a(paramCanvas);
    }
    if (this.jdField_a_of_type_Bkrv != null) {
      this.jdField_a_of_type_Bkrv.a(paramCanvas);
    }
    paramCanvas.translate(0.0F, -jdField_a_of_type_Int - 50);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bkrv == null) || (this.jdField_a_of_type_Bkrr == null))
    {
      setMeasuredDimension(0, 0);
      return;
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), (int)(50.0F + this.jdField_a_of_type_Bkrv.a() + jdField_a_of_type_Int));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_Bkrv != null) && (this.jdField_a_of_type_Bkrr != null))
      {
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        }
        while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
        {
          return true;
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
          this.jdField_b_of_type_Float = paramMotionEvent.getY();
          this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bkrv.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float - 50.0F);
          this.jdField_b_of_type_Boolean = false;
          if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
            return super.onTouchEvent(paramMotionEvent);
          }
          setPressed(true);
          invalidate();
          a();
          a(paramMotionEvent);
          c();
          continue;
          if (a())
          {
            a(paramMotionEvent);
          }
          else if (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > this.jdField_b_of_type_Int)
          {
            setPressed(true);
            invalidate();
            a();
            a(paramMotionEvent);
            c();
            continue;
            if (a())
            {
              a(paramMotionEvent);
              b();
              setPressed(false);
            }
            for (;;)
            {
              invalidate();
              break;
              a();
              a(paramMotionEvent);
              b();
            }
            if (a())
            {
              b();
              a(paramMotionEvent);
              setPressed(false);
            }
            invalidate();
          }
        }
      }
    }
  }
  
  public void postInvalidate()
  {
    super.postInvalidate();
  }
  
  public void setOnFramesClipChangeListener(bkrx parambkrx)
  {
    this.jdField_a_of_type_Bkrx = parambkrx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */