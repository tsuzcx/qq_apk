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
import bdoo;
import bnid;
import bnie;
import bnig;
import bnii;
import bnij;
import bnik;

public class VideoFrameSelectBar
  extends View
  implements bnid, bnig, bnij
{
  private static final int jdField_a_of_type_Int = bdoo.a(13.0F);
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private bnie jdField_a_of_type_Bnie;
  private bnii jdField_a_of_type_Bnii;
  private bnik jdField_a_of_type_Bnik;
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
      this.jdField_a_of_type_Bnii.a(paramMotionEvent);
    }
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Bnie.a(paramMotionEvent);
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
    if (this.jdField_a_of_type_Bnik != null) {
      this.jdField_a_of_type_Bnik.a(this.f);
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
    this.e = a((int)(paramFloat1 - this.jdField_a_of_type_Bnii.b()));
    this.f = a(paramFloat2 - paramFloat1);
    d();
    this.jdField_a_of_type_Bnie.a((int)paramFloat1);
    this.jdField_a_of_type_Bnie.b((int)paramFloat2);
    invalidate();
    if (this.jdField_a_of_type_Bnik != null) {
      this.jdField_a_of_type_Bnik.a((int)a(), (int)b());
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.d = a(paramFloat1);
    d();
    if (this.jdField_a_of_type_Bnii != null) {
      this.jdField_a_of_type_Bnii.a(paramFloat2, paramFloat3);
    }
    if (this.jdField_a_of_type_Bnik != null) {
      this.jdField_a_of_type_Bnik.a((int)a(), (int)b());
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
    if ((this.jdField_a_of_type_Bnii == null) || (this.jdField_a_of_type_Bnie == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(40.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.translate(0.0F, jdField_a_of_type_Int + 50);
    if (this.jdField_a_of_type_Bnie != null) {
      this.jdField_a_of_type_Bnie.a(paramCanvas);
    }
    if (this.jdField_a_of_type_Bnii != null) {
      this.jdField_a_of_type_Bnii.a(paramCanvas);
    }
    paramCanvas.translate(0.0F, -jdField_a_of_type_Int - 50);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bnii == null) || (this.jdField_a_of_type_Bnie == null))
    {
      setMeasuredDimension(0, 0);
      return;
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), (int)(50.0F + this.jdField_a_of_type_Bnii.a() + jdField_a_of_type_Int));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    for (;;)
    {
      return false;
      if ((this.jdField_a_of_type_Bnii != null) && (this.jdField_a_of_type_Bnie != null))
      {
        switch (paramMotionEvent.getAction() & 0xFF)
        {
        }
        while ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean))
        {
          return true;
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
          this.jdField_b_of_type_Float = paramMotionEvent.getY();
          this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bnii.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float - 50.0F);
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
  
  public void setOnFramesClipChangeListener(bnik parambnik)
  {
    this.jdField_a_of_type_Bnik = parambnik;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */