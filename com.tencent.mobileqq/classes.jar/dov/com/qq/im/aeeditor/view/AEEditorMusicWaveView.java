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
import com.tencent.mobileqq.utils.ViewUtils;
import dov.com.qq.im.ae.util.AEQLog;

public class AEEditorMusicWaveView
  extends View
  implements AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener;
  private AEEditorMusicWaveScrollProcessor jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor;
  private AEEditorMusicWaveView.IDragIndicatorListener jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView$IDragIndicatorListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = 0.0F;
  private boolean jdField_d_of_type_Boolean = false;
  private float jdField_e_of_type_Float = 0.0F;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f = false;
  private boolean g = true;
  private boolean h = false;
  
  public AEEditorMusicWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a(paramMotionEvent);
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
    return this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.f();
  }
  
  public int a(int paramInt)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor != null)
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a();
      f1 = f2;
      if (this.jdField_b_of_type_Int <= this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.d() - this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c())
      {
        f1 = f2;
        if (this.jdField_b_of_type_Int >= this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c()) {
          f1 = paramInt * 1.0F / (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.d() - this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c() * 2) * (this.jdField_b_of_type_Int - this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c());
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
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c(paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      AEQLog.d("AEEditorMusicWaveView", "audioPath is empty, can not init");
      return;
    }
    if ((paramString2.equals(this.jdField_a_of_type_JavaLangString)) && (!paramBoolean2))
    {
      AEQLog.b("AEEditorMusicWaveView", "相同 audioPath， 不再重新初始化裁剪条");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor = new AEEditorMusicWaveScrollProcessor(this, paramString1, paramString2, paramInt1, paramInt2, ViewUtils.a(18.0F), paramBoolean1, paramInt3, paramInt4);
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a(this.h);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_Boolean = true;
    if ((!paramBoolean1) && (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor != null))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a();
      this.jdField_c_of_type_Int = this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.b();
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
    return this.jdField_e_of_type_Boolean;
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
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor == null) {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a(paramCanvas, this.jdField_e_of_type_Boolean);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor == null)
    {
      setMeasuredDimension(0, 0);
      return;
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.e());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {}
    while ((this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor == null) || (!a())) {
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
      if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor != null)
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a();
        if ((this.g) && (this.jdField_b_of_type_Int >= this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c()) && (this.jdField_a_of_type_Float >= this.jdField_b_of_type_Int - this.jdField_c_of_type_Int / 2 - 70) && (this.jdField_a_of_type_Float <= this.jdField_b_of_type_Int + this.jdField_c_of_type_Int / 2 + 70)) {
          this.f = true;
        }
        this.jdField_a_of_type_Boolean = this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
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
      if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor != null)
      {
        this.jdField_b_of_type_Int = this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a();
        if ((this.f) && (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor != null) && (this.jdField_b_of_type_Int >= this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c()) && (paramMotionEvent.getX() >= this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c()) && (paramMotionEvent.getX() <= this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.d()))
        {
          this.jdField_b_of_type_Int = ((int)paramMotionEvent.getX());
          this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a(this.jdField_b_of_type_Int);
          this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.b(this.jdField_b_of_type_Int);
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
          if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView$IDragIndicatorListener != null) {
            this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView$IDragIndicatorListener.a(this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a());
          }
        }
        else
        {
          if (b())
          {
            a(paramMotionEvent);
            c();
            setPressed(false);
            this.jdField_d_of_type_Boolean = true;
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
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a(paramInt1, paramInt2);
    }
  }
  
  public void setDragIndicatorListener(AEEditorMusicWaveView.IDragIndicatorListener paramIDragIndicatorListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveView$IDragIndicatorListener = paramIDragIndicatorListener;
  }
  
  public void setEnableTrimMusic(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setIndicatorIndex(int paramInt)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor != null) && (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.g() - this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.f() > 0.01D))
    {
      float f1 = this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c();
      float f2 = (paramInt - this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.f()) * 1.0F / (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.g() - this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.f());
      float f3 = this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.d() - this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c() * 2;
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a((int)(f1 + f2 * f3));
    }
  }
  
  public void setIndicatorIndexByVideo(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor != null) && (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.g() - this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.f() > 0.01D))
    {
      float f1 = this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c() + paramInt1 * 1.0F / paramInt2 * (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.d() - this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.c() * 2);
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a((int)f1);
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.b((int)f1);
    }
  }
  
  public void setIsPinjieWithOneMusic(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setOnMusicMoveListener(AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener paramIMusicBarMoveListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener = paramIMusicBarMoveListener;
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor.a(this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.AEEditorMusicWaveView
 * JD-Core Version:    0.7.0.1
 */