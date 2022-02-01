package dov.com.qq.im.aeeditor.view.timeline;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import dov.com.qq.im.aeeditor.view.dragdrop.IDragDropScrollListener;
import dov.com.qq.im.aeeditor.view.dragdrop.IDragView;
import dov.com.qq.im.aeeditor.view.dragdrop.IStateChangeListener;
import dov.com.qq.im.aeeditor.view.dragdrop.IValueChangeListener;
import dov.com.qq.im.aeeditor.view.timebar.scale.ScaleAdapter;

public class EffectTimelineView
  extends TimelineView
  implements IDragDropScrollListener, IDragView, TimelineListener
{
  public static long a;
  private float jdField_a_of_type_Float = 0.0F;
  protected int a;
  private PointF jdField_a_of_type_AndroidGraphicsPointF;
  protected IStateChangeListener a;
  protected IValueChangeListener a;
  protected ScaleAdapter a;
  protected TimeLineViewListener a;
  private boolean jdField_a_of_type_Boolean = false;
  protected long b;
  private boolean b;
  protected long c = 0L;
  protected long d = 0L;
  protected long e = 0L;
  protected long f = 0L;
  protected long g = 0L;
  private long h = -1L;
  private long i = -1L;
  private long j = 0L;
  
  static
  {
    jdField_a_of_type_Long = 1000L;
  }
  
  public EffectTimelineView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EffectTimelineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EffectTimelineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    setTimelineListener(this);
  }
  
  public int a()
  {
    return d();
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void a()
  {
    this.e = (this.c - this.j);
    this.d = (this.jdField_b_of_type_Long - this.j);
  }
  
  protected void a(float paramFloat)
  {
    super.a(paramFloat);
    this.jdField_b_of_type_Boolean = true;
    long l1;
    if ((this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener != null) && (this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter != null))
    {
      this.j = this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(paramFloat);
      l1 = this.d + this.j;
      if ((paramFloat >= this.jdField_a_of_type_Float) || (!this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a())) {
        break label189;
      }
      this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a();
      this.e = (this.c - this.j);
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = paramFloat;
      Log.i("miles", "handleLeftSliderMove. moveX:" + paramFloat + ". scrollValue:" + this.j + ". raw startValue:" + l1 + ". adjusted value:" + this.jdField_b_of_type_Long);
      if ((this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener != null) && (this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter != null)) {
        this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener.a(this, this.jdField_b_of_type_Long, this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(paramFloat));
      }
      return;
      label189:
      if ((paramFloat > this.jdField_a_of_type_Float) && (this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.b()))
      {
        this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a();
        this.e = (this.c - this.j);
      }
      else
      {
        long l2 = this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a(this, l1);
        if (l2 >= 0L)
        {
          this.jdField_b_of_type_Long = l2;
          this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a(this);
        }
      }
    }
  }
  
  public void a(float paramFloat, boolean paramBoolean) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener != null)
    {
      this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a();
      this.d = (this.jdField_b_of_type_Long - this.j);
      this.e = (this.c - this.j);
    }
    if (this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener.a(this, this.jdField_b_of_type_Long, this.c, this.jdField_a_of_type_Int, paramBoolean);
    }
    if (a()) {
      bringToFront();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return d();
  }
  
  public long b()
  {
    return this.c;
  }
  
  public void b()
  {
    this.d = this.jdField_b_of_type_Long;
    this.e = this.c;
  }
  
  protected void b(float paramFloat)
  {
    super.b(paramFloat);
    this.jdField_b_of_type_Boolean = true;
    long l1;
    if (this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener != null)
    {
      this.j = this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(paramFloat);
      l1 = this.e + this.j;
      if ((paramFloat >= this.jdField_a_of_type_Float) || (!this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a())) {
        break label175;
      }
      this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a();
      this.e = (this.c - this.j);
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = paramFloat;
      Log.i("miles", "handleRightSliderMove. moveX:" + paramFloat + ". scrollValue:" + this.j + ". raw endValue:" + l1 + ". adjusted value:" + this.c);
      if (this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener.b(this, this.c, this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter.a(paramFloat));
      }
      return;
      label175:
      if ((paramFloat > this.jdField_a_of_type_Float) && (this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.b()))
      {
        this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a();
        this.e = (this.c - this.j);
      }
      else
      {
        long l2 = this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.b(this, l1);
        if (l2 >= 0L)
        {
          this.c = l2;
          this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener.a(this);
        }
      }
    }
  }
  
  public long c()
  {
    return jdField_a_of_type_Long;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Log.i("EffectTimelineView", "onTouchEvent >> " + paramMotionEvent);
    if (paramMotionEvent.getAction() == 0) {
      this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEndValue(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void setMaxEndValue(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void setMinBlockDuration(long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
  }
  
  public void setMinStartValue(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void setScaleModel(ScaleAdapter paramScaleAdapter)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewTimebarScaleScaleAdapter = paramScaleAdapter;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    if ((paramBoolean) && (a())) {
      bringToFront();
    }
    if (this.jdField_a_of_type_Boolean == paramBoolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIStateChangeListener != null) {
        this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIStateChangeListener.a(this, paramBoolean);
      }
    } while (this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener == null);
    this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener.a(paramBoolean, this);
  }
  
  public void setStartValue(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void setStateChangeListener(IStateChangeListener paramIStateChangeListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIStateChangeListener = paramIStateChangeListener;
  }
  
  public void setTimeLineViewListener(TimeLineViewListener paramTimeLineViewListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewTimelineTimeLineViewListener = paramTimeLineViewListener;
  }
  
  public void setTrackIndex(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setValueChangeListener(IValueChangeListener paramIValueChangeListener)
  {
    this.jdField_a_of_type_DovComQqImAeeditorViewDragdropIValueChangeListener = paramIValueChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.timeline.EffectTimelineView
 * JD-Core Version:    0.7.0.1
 */