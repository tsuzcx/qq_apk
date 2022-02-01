package com.tencent.mobileqq.wink.editor.music.lyric;

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

public class WinkMusicWaveView
  extends View
  implements WinkMusicWaveScrollProcessor.IMusicScrollProcessorParent
{
  private WinkMusicWaveScrollProcessor a;
  private float b;
  private float c;
  private int d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private boolean e;
  private boolean f;
  private float g = 0.0F;
  private float h = 0.0F;
  private float i = 0.0F;
  private Paint j = new Paint();
  private boolean k = false;
  private boolean l = false;
  private WinkMusicWaveScrollProcessor.IMusicBarMoveListener m;
  private WinkMusicWaveView.IDragIndicatorListener n;
  private String o;
  private boolean p = true;
  private boolean q = false;
  private int r = 0;
  private int s = 0;
  private boolean t = true;
  private boolean u = false;
  
  public WinkMusicWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.e) {
      this.a.a(paramMotionEvent);
    }
  }
  
  private void g()
  {
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public int a(int paramInt)
  {
    WinkMusicWaveScrollProcessor localWinkMusicWaveScrollProcessor = this.a;
    if (localWinkMusicWaveScrollProcessor != null)
    {
      this.r = localWinkMusicWaveScrollProcessor.a();
      if ((this.r <= this.a.d() - this.a.c()) && (this.r >= this.a.c()))
      {
        f1 = paramInt * 1.0F / (this.a.d() - this.a.c() * 2) * (this.r - this.a.c());
        break label96;
      }
    }
    float f1 = 0.0F;
    label96:
    return (int)f1;
  }
  
  public void a()
  {
    invalidate();
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    if ((paramString2.equals(this.o)) && (!paramBoolean2)) {
      return;
    }
    this.o = paramString2;
    this.a = new WinkMusicWaveScrollProcessor(this, paramString1, paramString2, paramInt1, paramInt2, ViewUtils.dip2px(18.0F), paramBoolean1, paramInt3, paramInt4);
    paramString1 = this.a;
    if (paramString1 != null) {
      paramString1.a(this.u);
    }
    this.j.setAntiAlias(true);
    this.k = true;
    if (!paramBoolean1)
    {
      paramString1 = this.a;
      if (paramString1 != null)
      {
        this.r = paramString1.a();
        this.s = this.a.b();
      }
    }
    requestLayout();
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.t = paramBoolean2;
    a(paramString1, paramString2, paramInt1, paramInt2, paramBoolean1, paramInt3, paramInt4, paramBoolean3);
  }
  
  public void b(int paramInt)
  {
    WinkMusicWaveScrollProcessor localWinkMusicWaveScrollProcessor = this.a;
    if (localWinkMusicWaveScrollProcessor != null) {
      localWinkMusicWaveScrollProcessor.c(paramInt);
    }
  }
  
  public boolean b()
  {
    return this.p;
  }
  
  void c()
  {
    this.f = true;
  }
  
  boolean d()
  {
    return this.f;
  }
  
  void e()
  {
    this.f = false;
  }
  
  public boolean f()
  {
    return this.q;
  }
  
  public Context getContextForProcessor()
  {
    return getContext();
  }
  
  public int getMusicIndicatorPosition()
  {
    WinkMusicWaveScrollProcessor localWinkMusicWaveScrollProcessor = this.a;
    if (localWinkMusicWaveScrollProcessor != null)
    {
      this.r = localWinkMusicWaveScrollProcessor.a();
      if ((this.r <= this.a.d() - this.a.c()) && (this.r >= this.a.c()))
      {
        f1 = this.a.g() + (this.a.h() - this.a.g()) * (this.r - this.a.c()) * 1.0F / (this.a.d() - this.a.c() * 2);
        break label118;
      }
    }
    float f1 = 0.0F;
    label118:
    return (int)f1;
  }
  
  public int getPerScreenDuration()
  {
    WinkMusicWaveScrollProcessor localWinkMusicWaveScrollProcessor = this.a;
    if (localWinkMusicWaveScrollProcessor != null) {
      return localWinkMusicWaveScrollProcessor.f();
    }
    return 0;
  }
  
  public float getSelectBeginTime()
  {
    return this.g + this.h;
  }
  
  public float getSelectEndTime()
  {
    return this.g + this.h + this.i;
  }
  
  public int getStartTime()
  {
    return this.a.g();
  }
  
  public Context getViewContext()
  {
    return getContext();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    WinkMusicWaveScrollProcessor localWinkMusicWaveScrollProcessor = this.a;
    if (localWinkMusicWaveScrollProcessor == null) {
      return;
    }
    localWinkMusicWaveScrollProcessor.a(paramCanvas, this.p);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.a == null)
    {
      setMeasuredDimension(0, 0);
      return;
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.a.e());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    if (this.a == null) {
      return false;
    }
    if (!b()) {
      return false;
    }
    int i1 = paramMotionEvent.getAction() & 0xFF;
    WinkMusicWaveScrollProcessor localWinkMusicWaveScrollProcessor;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3)
          {
            this.q = false;
            if (d())
            {
              e();
              a(paramMotionEvent);
              setPressed(false);
            }
            invalidate();
          }
        }
        else
        {
          localWinkMusicWaveScrollProcessor = this.a;
          if (localWinkMusicWaveScrollProcessor != null)
          {
            this.r = localWinkMusicWaveScrollProcessor.a();
            if (this.q)
            {
              localWinkMusicWaveScrollProcessor = this.a;
              if ((localWinkMusicWaveScrollProcessor != null) && (this.r >= localWinkMusicWaveScrollProcessor.c()) && (paramMotionEvent.getX() >= this.a.c()) && (paramMotionEvent.getX() <= this.a.d()))
              {
                this.r = ((int)paramMotionEvent.getX());
                this.a.a(this.r);
                this.a.b(this.r);
                invalidate();
                break label525;
              }
            }
          }
          if (d())
          {
            a(paramMotionEvent);
          }
          else if (Math.abs(paramMotionEvent.getX() - this.b) > this.d)
          {
            setPressed(true);
            invalidate();
            c();
            a(paramMotionEvent);
            g();
          }
        }
      }
      else if (this.q)
      {
        this.q = false;
        paramMotionEvent = this.n;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(this.a.a());
        }
      }
      else
      {
        if (d())
        {
          a(paramMotionEvent);
          e();
          setPressed(false);
          this.l = true;
        }
        else
        {
          c();
          a(paramMotionEvent);
          e();
        }
        this.q = false;
        invalidate();
      }
    }
    else
    {
      this.b = paramMotionEvent.getX();
      this.c = paramMotionEvent.getY();
      localWinkMusicWaveScrollProcessor = this.a;
      if (localWinkMusicWaveScrollProcessor != null)
      {
        this.r = localWinkMusicWaveScrollProcessor.a();
        if ((this.t) && (this.r >= this.a.c()))
        {
          float f1 = this.b;
          i1 = this.r;
          int i2 = this.s;
          if ((f1 >= i1 - i2 / 2 - 70) && (f1 <= i1 + i2 / 2 + 70)) {
            this.q = true;
          }
        }
        this.e = this.a.a(this.b, this.c);
      }
      if (!this.e) {
        return super.onTouchEvent(paramMotionEvent);
      }
      setPressed(true);
      invalidate();
      c();
      a(paramMotionEvent);
      g();
    }
    label525:
    return this.e;
  }
  
  public void setCurrentPosition(int paramInt1, int paramInt2)
  {
    WinkMusicWaveScrollProcessor localWinkMusicWaveScrollProcessor = this.a;
    if (localWinkMusicWaveScrollProcessor != null) {
      localWinkMusicWaveScrollProcessor.a(paramInt1, paramInt2);
    }
  }
  
  public void setDragIndicatorListener(WinkMusicWaveView.IDragIndicatorListener paramIDragIndicatorListener)
  {
    this.n = paramIDragIndicatorListener;
  }
  
  public void setEnableTrimMusic(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setIndicatorIndex(int paramInt)
  {
    WinkMusicWaveScrollProcessor localWinkMusicWaveScrollProcessor = this.a;
    if ((localWinkMusicWaveScrollProcessor != null) && (localWinkMusicWaveScrollProcessor.h() - this.a.g() > 0.01D))
    {
      float f1 = this.a.c();
      float f2 = (paramInt - this.a.g()) * 1.0F / (this.a.h() - this.a.g());
      float f3 = this.a.d() - this.a.c() * 2;
      this.a.a((int)(f1 + f2 * f3));
    }
  }
  
  public void setIndicatorIndexByVideo(int paramInt1, int paramInt2)
  {
    WinkMusicWaveScrollProcessor localWinkMusicWaveScrollProcessor = this.a;
    if ((localWinkMusicWaveScrollProcessor != null) && (localWinkMusicWaveScrollProcessor.h() - this.a.g() > 0.01D))
    {
      float f1 = this.a.c();
      float f2 = paramInt1 * 1.0F / paramInt2;
      float f3 = this.a.d() - this.a.c() * 2;
      localWinkMusicWaveScrollProcessor = this.a;
      paramInt1 = (int)(f1 + f2 * f3);
      localWinkMusicWaveScrollProcessor.a(paramInt1);
      this.a.b(paramInt1);
    }
  }
  
  public void setIsPinjieWithOneMusic(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }
  
  public void setOnMusicMoveListener(WinkMusicWaveScrollProcessor.IMusicBarMoveListener paramIMusicBarMoveListener)
  {
    this.m = paramIMusicBarMoveListener;
    paramIMusicBarMoveListener = this.a;
    if (paramIMusicBarMoveListener != null) {
      paramIMusicBarMoveListener.a(this.m);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.WinkMusicWaveView
 * JD-Core Version:    0.7.0.1
 */