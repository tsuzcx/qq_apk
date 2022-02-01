package com.tencent.tkd.topicsdk.widget.videocrop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFrameSelectBar;", "Landroid/view/View;", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;", "Lcom/tencent/tkd/topicsdk/widget/videocrop/RangeProcessor$OnRangeChangeListener;", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$OnMoveListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "frameHeight", "", "frameWidth", "isInited", "", "()Z", "setInited", "(Z)V", "isTrackingTouch", "mDownMotionX", "mDownMotionY", "mFrameBar", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor;", "mIntervalTimeMillis", "mIsFramePressed", "mIsRangePressed", "mOnFramesClipChangeListener", "Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFrameSelectBar$OnFramesClipChangeListener;", "getMOnFramesClipChangeListener", "()Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFrameSelectBar$OnFramesClipChangeListener;", "setMOnFramesClipChangeListener", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/VideoFrameSelectBar$OnFramesClipChangeListener;)V", "mRangeBar", "Lcom/tencent/tkd/topicsdk/widget/videocrop/RangeProcessor;", "mRangeIntervalTimeMillis", "mScaledTouchSlop", "", "mStartTimeMillis", "milliSecondsPerFrame", "processorGap", "selectBeginTime", "getSelectBeginTime", "()F", "selectEndTime", "getSelectEndTime", "textHeight", "attemptClaimDrag", "", "destroy", "distanceToTime", "distance", "hasChanged", "init", "videoDuration", "videoPath", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onFrameMove", "left", "right", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRangeValuesChanged", "onStartTrackingTouch", "onStopTrackingTouch", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "postInvalidate", "reset", "setVideoLimitRange", "minVideoLength", "maxVideoLength", "trackTouchEvent", "updateRangeInterval", "timeInterval", "Companion", "OnFramesClipChangeListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class VideoFrameSelectBar
  extends View
  implements FrameParent, FramesProcessor.OnMoveListener, RangeProcessor.OnRangeChangeListener
{
  public static final VideoFrameSelectBar.Companion a = new VideoFrameSelectBar.Companion(null);
  private RangeProcessor b;
  private FramesProcessor c;
  private float d;
  private float e;
  private final int f;
  private boolean g;
  private boolean h;
  private boolean i;
  private float j;
  private float k;
  private final int l;
  private final int m;
  private int n;
  private float o;
  private float p;
  private float q;
  private boolean r;
  @Nullable
  private VideoFrameSelectBar.OnFramesClipChangeListener s;
  
  public VideoFrameSelectBar(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "ViewConfiguration.get(context)");
    this.f = paramAttributeSet.getScaledTouchSlop();
    this.j = DisplayUtils.a.a(paramContext, 52.0F);
    this.k = ((DisplayUtils.a.a(paramContext) - DisplayUtils.a.a(paramContext, 75.0F)) / 12);
    this.l = DisplayUtils.a.a(paramContext, 13.0F);
    this.m = DisplayUtils.a.a(paramContext, 16.0F);
    this.n = 500;
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private final float a(float paramFloat)
  {
    return paramFloat / this.k * this.n;
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (this.g)
    {
      localObject = this.b;
      if (localObject != null) {
        ((RangeProcessor)localObject).a(paramMotionEvent);
      }
    }
    else if (this.h)
    {
      localObject = this.c;
      if (localObject != null) {
        ((FramesProcessor)localObject).a(paramMotionEvent);
      }
    }
  }
  
  private final void b(float paramFloat)
  {
    this.q = a(paramFloat);
    VideoFrameSelectBar.OnFramesClipChangeListener localOnFramesClipChangeListener = this.s;
    if (localOnFramesClipChangeListener != null) {
      localOnFramesClipChangeListener.a(this.q);
    }
  }
  
  private final void d()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private final void e()
  {
    this.i = true;
  }
  
  private final void f()
  {
    this.i = false;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.b;
    float f1;
    if (localObject != null) {
      f1 = ((RangeProcessor)localObject).a();
    } else {
      f1 = 0.0F;
    }
    this.p = a((int)(paramFloat1 - f1));
    b(paramFloat2 - paramFloat1);
    localObject = this.c;
    if (localObject != null) {
      ((FramesProcessor)localObject).a((int)paramFloat1);
    }
    localObject = this.c;
    if (localObject != null) {
      ((FramesProcessor)localObject).b((int)paramFloat2);
    }
    invalidate();
    localObject = this.s;
    if (localObject != null) {
      ((VideoFrameSelectBar.OnFramesClipChangeListener)localObject).a((int)getSelectBeginTime(), (int)getSelectEndTime());
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.o = a(paramFloat1);
    Object localObject = this.s;
    if (localObject != null) {
      ((VideoFrameSelectBar.OnFramesClipChangeListener)localObject).a(this.q);
    }
    localObject = this.b;
    if (localObject != null) {
      ((RangeProcessor)localObject).b(paramFloat2, paramFloat3);
    }
    localObject = this.s;
    if (localObject != null) {
      ((VideoFrameSelectBar.OnFramesClipChangeListener)localObject).a((int)getSelectBeginTime(), (int)getSelectEndTime());
    }
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "videoPath");
    this.n = (paramInt / 12);
    FrameParent localFrameParent = (FrameParent)this;
    this.b = new RangeProcessor(localFrameParent, this.k, this.j, this.n);
    RangeProcessor localRangeProcessor = this.b;
    if (localRangeProcessor != null) {
      localRangeProcessor.a((RangeProcessor.OnRangeChangeListener)this);
    }
    float f2 = this.k;
    float f3 = this.j;
    localRangeProcessor = this.b;
    float f1;
    if (localRangeProcessor != null) {
      f1 = localRangeProcessor.a();
    } else {
      f1 = 0.0F;
    }
    this.c = new FramesProcessor(localFrameParent, paramString, paramInt, f2, f3, f1, this.n);
    paramString = this.c;
    if (paramString != null) {
      paramString.a((FramesProcessor.OnMoveListener)this);
    }
    this.r = true;
  }
  
  public final boolean a()
  {
    return this.r;
  }
  
  public final boolean b()
  {
    Object localObject = this.c;
    boolean bool3 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((FramesProcessor)localObject).b();
    } else {
      bool1 = false;
    }
    localObject = this.b;
    boolean bool2;
    if (localObject != null) {
      bool2 = ((RangeProcessor)localObject).d();
    } else {
      bool2 = false;
    }
    if (!bool1)
    {
      bool1 = bool3;
      if (!bool2) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public final void c()
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((RangeProcessor)localObject).e();
    }
    localObject = this.c;
    if (localObject != null) {
      ((FramesProcessor)localObject).c();
    }
    this.r = false;
    this.o = 0.0F;
    this.p = 0.0F;
    this.q = 0.0F;
  }
  
  @Nullable
  public final VideoFrameSelectBar.OnFramesClipChangeListener getMOnFramesClipChangeListener()
  {
    return this.s;
  }
  
  public final float getSelectBeginTime()
  {
    return this.o + this.p;
  }
  
  public final float getSelectEndTime()
  {
    return this.o + this.p + this.q;
  }
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    if (this.b != null)
    {
      if (this.c == null) {
        return;
      }
      paramCanvas.translate(0.0F, this.l + this.m);
      Object localObject = this.c;
      if (localObject != null) {
        ((FramesProcessor)localObject).a(paramCanvas);
      }
      localObject = this.b;
      if (localObject != null) {
        ((RangeProcessor)localObject).a(paramCanvas);
      }
      paramCanvas.translate(0.0F, -this.l - this.m);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.b != null) && (this.c != null))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      RangeProcessor localRangeProcessor = this.b;
      float f1;
      if (localRangeProcessor != null) {
        f1 = localRangeProcessor.b();
      } else {
        f1 = 0.0F;
      }
      setMeasuredDimension(paramInt1, (int)(this.m + f1 + this.l));
      return;
    }
    setMeasuredDimension(0, 0);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    boolean bool1 = isEnabled();
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (this.b != null)
    {
      if (this.c == null) {
        return false;
      }
      int i1 = paramMotionEvent.getAction() & 0xFF;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 == 3)
            {
              if (this.i)
              {
                f();
                a(paramMotionEvent);
                setPressed(false);
              }
              invalidate();
            }
          }
          else if (this.i)
          {
            a(paramMotionEvent);
          }
          else if (Math.abs(paramMotionEvent.getX() - this.d) > this.f)
          {
            setPressed(true);
            invalidate();
            e();
            a(paramMotionEvent);
            d();
          }
        }
        else
        {
          if (this.i)
          {
            a(paramMotionEvent);
            f();
            setPressed(false);
          }
          else
          {
            e();
            a(paramMotionEvent);
            f();
          }
          invalidate();
        }
      }
      else
      {
        this.d = paramMotionEvent.getX();
        this.e = paramMotionEvent.getY();
        RangeProcessor localRangeProcessor = this.b;
        if (localRangeProcessor != null) {
          bool1 = localRangeProcessor.a(this.d, this.e - this.m);
        } else {
          bool1 = false;
        }
        this.g = bool1;
        this.h = false;
        if ((!this.h) && (!this.g)) {
          return super.onTouchEvent(paramMotionEvent);
        }
        setPressed(true);
        invalidate();
        e();
        a(paramMotionEvent);
        d();
      }
      if (!this.h)
      {
        bool1 = bool2;
        if (!this.g) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void postInvalidate()
  {
    super.postInvalidate();
  }
  
  public final void setInited(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }
  
  public final void setMOnFramesClipChangeListener(@Nullable VideoFrameSelectBar.OnFramesClipChangeListener paramOnFramesClipChangeListener)
  {
    this.s = paramOnFramesClipChangeListener;
  }
  
  public final void setVideoLimitRange(int paramInt1, int paramInt2)
  {
    RangeProcessor localRangeProcessor = this.b;
    if (localRangeProcessor != null) {
      localRangeProcessor.a(paramInt1, paramInt2);
    }
    localRangeProcessor = this.b;
    float f1;
    if (localRangeProcessor != null) {
      f1 = localRangeProcessor.c();
    } else {
      f1 = 0.0F;
    }
    b(f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */