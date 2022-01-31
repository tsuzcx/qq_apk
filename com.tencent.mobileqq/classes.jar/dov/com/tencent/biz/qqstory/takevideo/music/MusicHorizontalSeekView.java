package dov.com.tencent.biz.qqstory.takevideo.music;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class MusicHorizontalSeekView
  extends View
  implements View.OnTouchListener
{
  protected static final int a;
  protected static final int[] a;
  protected static int b;
  protected static int[] b;
  protected static int c;
  float a;
  protected Paint a;
  protected Rect a;
  protected MusicHorizontalSeekView.SeekListener a;
  protected boolean a;
  protected Paint b;
  protected Paint c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 6, 8, 10, 12, 12, 10, 8, 6 };
    jdField_a_of_type_Int = jdField_a_of_type_ArrayOfInt.length;
    jdField_b_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
  }
  
  public MusicHorizontalSeekView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 0.0F;
    this.m = ((int)DisplayUtils.a(paramContext, 2.0F));
    this.n = ((int)DisplayUtils.a(paramContext, 1.0F));
    jdField_b_of_type_Int = (int)DisplayUtils.a(paramContext, 10.0F);
    jdField_c_of_type_Int = (int)DisplayUtils.a(paramContext, 21.0F);
    int i1 = 0;
    while (i1 < jdField_a_of_type_Int)
    {
      jdField_b_of_type_ArrayOfInt[i1] = ((int)DisplayUtils.a(paramContext, jdField_a_of_type_ArrayOfInt[i1]));
      i1 += 1;
    }
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131493234));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131493762));
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramContext.getColor(2131493763));
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.n);
    super.setOnTouchListener(this);
  }
  
  public void a(int paramInt)
  {
    this.h = (jdField_b_of_type_Int * paramInt / 1000);
    setPlayedPosition(-1);
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, Paint paramPaint)
  {
    paramCanvas.drawLine(paramInt1, paramInt2, paramInt1, paramInt3, paramPaint);
  }
  
  public void draw(Canvas paramCanvas)
  {
    System.currentTimeMillis();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.n);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.n);
    int i2 = 0;
    int i1 = -1;
    int i3;
    int i4;
    if (i2 < this.e)
    {
      i3 = this.j;
      i4 = this.h;
      i3 = (i2 + 1) * jdField_b_of_type_Int + (i3 - i4);
      if ((i3 <= this.j + this.f) || (this.h != this.g)) {
        break label189;
      }
    }
    label189:
    label194:
    Paint localPaint;
    for (;;)
    {
      if ((this.jdField_a_of_type_Boolean) || (this.i >= this.d))
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.m);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
        if (QLog.isColorLevel()) {}
        return;
        if (i3 < 0)
        {
          i2 += 1;
          break;
        }
        if (i3 <= this.k)
        {
          localPaint = this.jdField_c_of_type_AndroidGraphicsPaint;
          if ((this.jdField_a_of_type_Boolean) || (i3 <= this.jdField_a_of_type_AndroidGraphicsRect.left) || (i3 >= this.jdField_a_of_type_AndroidGraphicsRect.right)) {
            break label498;
          }
          if (i1 != -1) {
            break label495;
          }
          i1 = i2;
          label254:
          if ((i2 >= i1) && (i2 < this.i + i1)) {
            localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;
          }
        }
      }
    }
    label495:
    label498:
    for (;;)
    {
      i4 = jdField_b_of_type_ArrayOfInt[(i2 % jdField_a_of_type_Int)];
      int i5 = (this.l - i4) / 2;
      a(paramCanvas, i3, i5, i5 + i4, localPaint);
      break label194;
      localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      continue;
      if (this.i == -1)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.m);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
        a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
        break;
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.m);
      a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.m);
      a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      break;
      break label254;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.k = super.getMeasuredWidth();
    this.l = (jdField_c_of_type_Int + super.getPaddingTop() + super.getPaddingBottom());
    setMeasuredDimension(this.k, this.l);
    this.j = ((this.k - this.f) / 2);
    paramInt1 = (this.l - jdField_c_of_type_Int) / 2;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(this.j, paramInt1, this.j + this.d * jdField_b_of_type_Int, jdField_c_of_type_Int + paramInt1);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.a(this.j, this.f);
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onMeasure() mViewWidth: " + this.k + ", mViewHeight = " + this.l + ", mVideoViewOffsetX = " + this.j + ", mMusicMaxWidth = " + this.g);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      bool = false;
      float f1;
      do
      {
        return bool;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener == null) {
          break;
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.a(this.g, this.f, this.h);
        break;
        f1 = paramMotionEvent.getX();
      } while (Math.abs(f1 - this.jdField_a_of_type_Float) < 2.0F);
      this.jdField_a_of_type_Boolean = true;
      this.h = ((int)(this.h + (this.jdField_a_of_type_Float - f1) / 2.0F));
      if (f1 > this.jdField_a_of_type_Float)
      {
        if (this.h <= jdField_b_of_type_Int)
        {
          this.h = 0;
          super.invalidate();
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener != null) {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.b(this.g, this.f, this.h);
          }
          this.jdField_a_of_type_Float = f1;
          return false;
        }
      }
      else if (this.h >= this.g - this.f)
      {
        this.h = (this.g - this.f);
        super.invalidate();
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener != null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.b(this.g, this.f, this.h);
        }
        this.jdField_a_of_type_Float = f1;
        return false;
      }
      super.invalidate();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.b(this.g, this.f, this.h);
      }
      this.jdField_a_of_type_Float = f1;
      continue;
      this.jdField_a_of_type_Boolean = false;
      super.invalidate();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener.c(this.g, this.f, this.h);
      }
    }
  }
  
  public void setDurations(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = (jdField_b_of_type_Int * this.d);
    this.g = (jdField_b_of_type_Int * this.e);
  }
  
  public void setOnSeekListener(MusicHorizontalSeekView.SeekListener paramSeekListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView$SeekListener = paramSeekListener;
  }
  
  public void setPlayedPosition(int paramInt)
  {
    this.i = paramInt;
    super.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView
 * JD-Core Version:    0.7.0.1
 */