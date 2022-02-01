package dov.com.qq.im.aeeditor.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import bgtn;
import bnzb;
import bojf;
import bojh;
import boji;
import bojj;

public class AEEditorMusicWaveView
  extends View
  implements boji
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private bojf jdField_a_of_type_Bojf;
  private bojh jdField_a_of_type_Bojh;
  private bojj jdField_a_of_type_Bojj;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e = true;
  private boolean f;
  private boolean g = true;
  private boolean h;
  
  public AEEditorMusicWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bojf.a(paramMotionEvent);
    }
  }
  
  private void d()
  {
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Bojf.f();
  }
  
  public int a(int paramInt)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (this.jdField_a_of_type_Bojf != null)
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Bojf.a();
      f1 = f2;
      if (this.jdField_b_of_type_Int <= this.jdField_a_of_type_Bojf.d() - this.jdField_a_of_type_Bojf.c())
      {
        f1 = f2;
        if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Bojf.c()) {
          f1 = paramInt * 1.0F / (this.jdField_a_of_type_Bojf.d() - this.jdField_a_of_type_Bojf.c() * 2) * (this.jdField_b_of_type_Int - this.jdField_a_of_type_Bojf.c());
        }
      }
    }
    return (int)f1;
  }
  
  public Context a()
  {
    return getContext();
  }
  
  public void a()
  {
    invalidate();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bojf != null) {
      this.jdField_a_of_type_Bojf.c(paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      bnzb.d("AEEditorMusicWaveView", "audioPath is empty, can not init");
      return;
    }
    if ((paramString2.equals(this.jdField_a_of_type_JavaLangString)) && (!paramBoolean2))
    {
      bnzb.b("AEEditorMusicWaveView", "相同 audioPath， 不再重新初始化裁剪条");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bojf = new bojf(this, paramString1, paramString2, paramInt1, paramInt2, bgtn.a(18.0F), paramBoolean1, paramInt3, paramInt4);
    if (this.jdField_a_of_type_Bojf != null) {
      this.jdField_a_of_type_Bojf.a(this.h);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_Boolean = true;
    if ((!paramBoolean1) && (this.jdField_a_of_type_Bojf != null))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Bojf.a();
      this.jdField_c_of_type_Int = this.jdField_a_of_type_Bojf.b();
    }
    requestLayout();
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.g = paramBoolean2;
    a(paramString1, paramString2, paramInt1, paramInt2, paramBoolean1, paramInt3, paramInt4, paramBoolean3);
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  void c()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bojf == null) {
      return;
    }
    this.jdField_a_of_type_Bojf.a(paramCanvas, this.e);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bojf == null)
    {
      setMeasuredDimension(0, 0);
      return;
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.jdField_a_of_type_Bojf.e());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    while ((this.jdField_a_of_type_Bojf == null) || (!a())) {
      return false;
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      if (this.jdField_a_of_type_Bojf != null)
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Bojf.a();
        if ((this.g) && (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Bojf.c()) && (this.jdField_a_of_type_Float >= this.jdField_b_of_type_Int - this.jdField_c_of_type_Int / 2 - 70) && (this.jdField_a_of_type_Float <= this.jdField_b_of_type_Int + this.jdField_c_of_type_Int / 2 + 70)) {
          this.f = true;
        }
        this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bojf.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      }
      if (!this.jdField_a_of_type_Boolean) {
        return super.onTouchEvent(paramMotionEvent);
      }
      setPressed(true);
      invalidate();
      b();
      a(paramMotionEvent);
      d();
      continue;
      if (this.jdField_a_of_type_Bojf != null)
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_Bojf.a();
        if ((this.f) && (this.jdField_a_of_type_Bojf != null) && (this.jdField_b_of_type_Int >= this.jdField_a_of_type_Bojf.c()) && (paramMotionEvent.getX() >= this.jdField_a_of_type_Bojf.c()) && (paramMotionEvent.getX() <= this.jdField_a_of_type_Bojf.d()))
        {
          this.jdField_b_of_type_Int = ((int)paramMotionEvent.getX());
          this.jdField_a_of_type_Bojf.a(this.jdField_b_of_type_Int);
          this.jdField_a_of_type_Bojf.b(this.jdField_b_of_type_Int);
          invalidate();
          continue;
        }
      }
      if (b())
      {
        a(paramMotionEvent);
      }
      else if (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > this.jdField_a_of_type_Int)
      {
        setPressed(true);
        invalidate();
        b();
        a(paramMotionEvent);
        d();
        continue;
        if (this.f)
        {
          this.f = false;
          if (this.jdField_a_of_type_Bojj != null) {
            this.jdField_a_of_type_Bojj.a(this.jdField_a_of_type_Bojf.a());
          }
        }
        else
        {
          if (b())
          {
            a(paramMotionEvent);
            c();
            setPressed(false);
            this.d = true;
          }
          for (;;)
          {
            this.f = false;
            invalidate();
            break;
            b();
            a(paramMotionEvent);
            c();
          }
          this.f = false;
          if (b())
          {
            c();
            a(paramMotionEvent);
            setPressed(false);
          }
          invalidate();
        }
      }
    }
  }
  
  public void setCurrentPosition(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Bojf != null) {
      this.jdField_a_of_type_Bojf.a(paramInt1, paramInt2);
    }
  }
  
  public void setDragIndicatorListener(bojj parambojj)
  {
    this.jdField_a_of_type_Bojj = parambojj;
  }
  
  public void setEnableTrimMusic(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setIndicatorIndex(int paramInt)
  {
    if ((this.jdField_a_of_type_Bojf != null) && (this.jdField_a_of_type_Bojf.g() - this.jdField_a_of_type_Bojf.f() > 0.01D))
    {
      float f1 = this.jdField_a_of_type_Bojf.c();
      float f2 = (paramInt - this.jdField_a_of_type_Bojf.f()) * 1.0F / (this.jdField_a_of_type_Bojf.g() - this.jdField_a_of_type_Bojf.f());
      float f3 = this.jdField_a_of_type_Bojf.d() - this.jdField_a_of_type_Bojf.c() * 2;
      this.jdField_a_of_type_Bojf.a((int)(f1 + f2 * f3));
    }
  }
  
  public void setIndicatorIndexByVideo(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Bojf != null) && (this.jdField_a_of_type_Bojf.g() - this.jdField_a_of_type_Bojf.f() > 0.01D))
    {
      float f1 = this.jdField_a_of_type_Bojf.c() + paramInt1 * 1.0F / paramInt2 * (this.jdField_a_of_type_Bojf.d() - this.jdField_a_of_type_Bojf.c() * 2);
      this.jdField_a_of_type_Bojf.a((int)f1);
      this.jdField_a_of_type_Bojf.b((int)f1);
    }
  }
  
  public void setIsPinjieWithOneMusic(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setOnMusicMoveListener(bojh parambojh)
  {
    this.jdField_a_of_type_Bojh = parambojh;
    if (this.jdField_a_of_type_Bojf != null) {
      this.jdField_a_of_type_Bojf.a(this.jdField_a_of_type_Bojh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.AEEditorMusicWaveView
 * JD-Core Version:    0.7.0.1
 */