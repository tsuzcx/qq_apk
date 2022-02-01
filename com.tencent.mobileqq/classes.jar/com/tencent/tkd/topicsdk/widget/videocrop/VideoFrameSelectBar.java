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
  public static final VideoFrameSelectBar.Companion a;
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private FramesProcessor jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor;
  private RangeProcessor jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
  @Nullable
  private VideoFrameSelectBar.OnFramesClipChangeListener jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar$OnFramesClipChangeListener;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private float e;
  private float f;
  private float g;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar$Companion = new VideoFrameSelectBar.Companion(null);
  }
  
  public VideoFrameSelectBar(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramAttributeSet, "ViewConfiguration.get(context)");
    this.jdField_a_of_type_Int = paramAttributeSet.getScaledTouchSlop();
    this.jdField_c_of_type_Float = DisplayUtils.a.a(paramContext, 52.0F);
    this.jdField_d_of_type_Float = ((DisplayUtils.a.a(paramContext) - DisplayUtils.a.a(paramContext, 75.0F)) / 12);
    this.jdField_b_of_type_Int = DisplayUtils.a.a(paramContext, 13.0F);
    this.jdField_c_of_type_Int = DisplayUtils.a.a(paramContext, 16.0F);
    this.jdField_d_of_type_Int = 500;
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private final float a(float paramFloat)
  {
    return paramFloat / this.jdField_d_of_type_Float * this.jdField_d_of_type_Int;
  }
  
  private final void a(float paramFloat)
  {
    this.g = a(paramFloat);
    VideoFrameSelectBar.OnFramesClipChangeListener localOnFramesClipChangeListener = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar$OnFramesClipChangeListener;
    if (localOnFramesClipChangeListener != null) {
      localOnFramesClipChangeListener.a(this.g);
    }
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
      if (localObject != null) {
        ((RangeProcessor)localObject).a(paramMotionEvent);
      }
    }
    else if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor;
      if (localObject != null) {
        ((FramesProcessor)localObject).a(paramMotionEvent);
      }
    }
  }
  
  private final void b()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private final void c()
  {
    this.jdField_c_of_type_Boolean = true;
  }
  
  private final void d()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  public final float a()
  {
    return this.e + this.f;
  }
  
  public final void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
    if (localObject != null) {
      ((RangeProcessor)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor;
    if (localObject != null) {
      ((FramesProcessor)localObject).b();
    }
    this.jdField_d_of_type_Boolean = false;
    this.e = 0.0F;
    this.f = 0.0F;
    this.g = 0.0F;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
    float f1;
    if (localObject != null) {
      f1 = ((RangeProcessor)localObject).a();
    } else {
      f1 = 0.0F;
    }
    this.f = a((int)(paramFloat1 - f1));
    a(paramFloat2 - paramFloat1);
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor;
    if (localObject != null) {
      ((FramesProcessor)localObject).a((int)paramFloat1);
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor;
    if (localObject != null) {
      ((FramesProcessor)localObject).b((int)paramFloat2);
    }
    invalidate();
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar$OnFramesClipChangeListener;
    if (localObject != null) {
      ((VideoFrameSelectBar.OnFramesClipChangeListener)localObject).a((int)a(), (int)b());
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.e = a(paramFloat1);
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar$OnFramesClipChangeListener;
    if (localObject != null) {
      ((VideoFrameSelectBar.OnFramesClipChangeListener)localObject).a(this.g);
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
    if (localObject != null) {
      ((RangeProcessor)localObject).a(paramFloat2, paramFloat3);
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar$OnFramesClipChangeListener;
    if (localObject != null) {
      ((VideoFrameSelectBar.OnFramesClipChangeListener)localObject).a((int)a(), (int)b());
    }
  }
  
  public final void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "videoPath");
    this.jdField_d_of_type_Int = (paramInt / 12);
    FrameParent localFrameParent = (FrameParent)this;
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor = new RangeProcessor(localFrameParent, this.jdField_d_of_type_Float, this.jdField_c_of_type_Float, this.jdField_d_of_type_Int);
    RangeProcessor localRangeProcessor = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
    if (localRangeProcessor != null) {
      localRangeProcessor.a((RangeProcessor.OnRangeChangeListener)this);
    }
    float f2 = this.jdField_d_of_type_Float;
    float f3 = this.jdField_c_of_type_Float;
    localRangeProcessor = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
    float f1;
    if (localRangeProcessor != null) {
      f1 = localRangeProcessor.a();
    } else {
      f1 = 0.0F;
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor = new FramesProcessor(localFrameParent, paramString, paramInt, f2, f3, f1, this.jdField_d_of_type_Int);
    paramString = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor;
    if (paramString != null) {
      paramString.a((FramesProcessor.OnMoveListener)this);
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public final boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public final float b()
  {
    return this.e + this.f + this.g;
  }
  
  public final boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor;
    boolean bool3 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((FramesProcessor)localObject).a();
    } else {
      bool1 = false;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
    boolean bool2;
    if (localObject != null) {
      bool2 = ((RangeProcessor)localObject).a();
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
  
  protected void onDraw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor != null)
    {
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor == null) {
        return;
      }
      paramCanvas.translate(0.0F, this.jdField_b_of_type_Int + this.jdField_c_of_type_Int);
      Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor;
      if (localObject != null) {
        ((FramesProcessor)localObject).a(paramCanvas);
      }
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
      if (localObject != null) {
        ((RangeProcessor)localObject).a(paramCanvas);
      }
      paramCanvas.translate(0.0F, -this.jdField_b_of_type_Int - this.jdField_c_of_type_Int);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor != null) && (this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor != null))
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      RangeProcessor localRangeProcessor = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
      float f1;
      if (localRangeProcessor != null) {
        f1 = localRangeProcessor.b();
      } else {
        f1 = 0.0F;
      }
      setMeasuredDimension(paramInt1, (int)(this.jdField_c_of_type_Int + f1 + this.jdField_b_of_type_Int));
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
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor != null)
    {
      if (this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor == null) {
        return false;
      }
      int i = paramMotionEvent.getAction() & 0xFF;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              if (this.jdField_c_of_type_Boolean)
              {
                d();
                a(paramMotionEvent);
                setPressed(false);
              }
              invalidate();
            }
          }
          else if (this.jdField_c_of_type_Boolean)
          {
            a(paramMotionEvent);
          }
          else if (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > this.jdField_a_of_type_Int)
          {
            setPressed(true);
            invalidate();
            c();
            a(paramMotionEvent);
            b();
          }
        }
        else
        {
          if (this.jdField_c_of_type_Boolean)
          {
            a(paramMotionEvent);
            d();
            setPressed(false);
          }
          else
          {
            c();
            a(paramMotionEvent);
            d();
          }
          invalidate();
        }
      }
      else
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        RangeProcessor localRangeProcessor = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
        if (localRangeProcessor != null) {
          bool1 = localRangeProcessor.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float - this.jdField_c_of_type_Int);
        } else {
          bool1 = false;
        }
        this.jdField_a_of_type_Boolean = bool1;
        this.jdField_b_of_type_Boolean = false;
        if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
          return super.onTouchEvent(paramMotionEvent);
        }
        setPressed(true);
        invalidate();
        c();
        a(paramMotionEvent);
        b();
      }
      if (!this.jdField_b_of_type_Boolean)
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Boolean) {}
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
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public final void setMOnFramesClipChangeListener(@Nullable VideoFrameSelectBar.OnFramesClipChangeListener paramOnFramesClipChangeListener)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropVideoFrameSelectBar$OnFramesClipChangeListener = paramOnFramesClipChangeListener;
  }
  
  public final void setVideoLimitRange(int paramInt1, int paramInt2)
  {
    RangeProcessor localRangeProcessor = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
    if (localRangeProcessor != null) {
      localRangeProcessor.a(paramInt1, paramInt2);
    }
    localRangeProcessor = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor;
    float f1;
    if (localRangeProcessor != null) {
      f1 = localRangeProcessor.c();
    } else {
      f1 = 0.0F;
    }
    a(f1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoFrameSelectBar
 * JD-Core Version:    0.7.0.1
 */