package com.tencent.tkd.topicsdk.widget.videocapture;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "captureToastTextView", "Landroid/widget/TextView;", "currentProgress", "", "duration", "", "indicator", "Landroid/widget/ImageView;", "isDoingLongPress", "", "longPressStartVideoSeekPercent", "longPressStartVideoSeekPosition", "", "onCaptureOperateCallback", "Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$OnCaptureOperateCallback;", "getOnCaptureOperateCallback", "()Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$OnCaptureOperateCallback;", "setOnCaptureOperateCallback", "(Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$OnCaptureOperateCallback;)V", "onIndicatorPressCallback", "Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$OnIndicatorPressCallback;", "getOnIndicatorPressCallback", "()Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$OnIndicatorPressCallback;", "setOnIndicatorPressCallback", "(Lcom/tencent/tkd/topicsdk/widget/videocapture/CaptureOperateTouchLayout$OnIndicatorPressCallback;)V", "previewImageCount", "processTextView", "scroller", "Landroid/widget/Scroller;", "totalCaptureLongInterval", "uiHandler", "Landroid/os/Handler;", "videoMeasureScaleView", "Lcom/tencent/tkd/topicsdk/widget/videocapture/VideoMeasureScaleView;", "videoSeekPosition", "getVideoSeekPosition", "()I", "setVideoSeekPosition", "(I)V", "calculationVideoSeekPosition", "percent", "computeScroll", "", "getCalculationVideoSeekPosition", "getCurrentProgress", "getMaxLength", "getSeedPosition", "onIndicatorChange", "progressX", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onSeekCandidateImage", "onTouchDown", "setDuration", "setup", "Companion", "IndicatorLongPressCallback", "IndicatorTouchListener", "OnCaptureOperateCallback", "OnIndicatorPressCallback", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class CaptureOperateTouchLayout
  extends FrameLayout
{
  public static final CaptureOperateTouchLayout.Companion a = new CaptureOperateTouchLayout.Companion(null);
  private static int r = 200;
  private final Handler b = new Handler(Looper.getMainLooper());
  private ImageView c;
  private TextView d;
  private VideoMeasureScaleView e;
  private TextView f;
  private long g;
  private int h;
  private int i;
  private float j = -1;
  private int k = -1;
  private int l = -1;
  private float m;
  private boolean n;
  private final Scroller o = new Scroller(AppContext.a.a());
  @Nullable
  private CaptureOperateTouchLayout.OnCaptureOperateCallback p;
  @Nullable
  private CaptureOperateTouchLayout.OnIndicatorPressCallback q;
  
  public CaptureOperateTouchLayout(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final int a(float paramFloat)
  {
    return (int)(paramFloat * this.i);
  }
  
  private final void a(int paramInt)
  {
    int i1 = getWidth();
    ImageView localImageView = this.c;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    int i2 = localImageView.getWidth();
    a(paramInt / (i1 - i2), false);
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    ImageView localImageView = this.c;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    if (f1 >= localImageView.getX())
    {
      f1 = paramMotionEvent.getRawX();
      localImageView = this.c;
      if (localImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      float f2 = localImageView.getX();
      localImageView = this.c;
      if (localImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      if (f1 <= f2 + localImageView.getWidth())
      {
        i1 = 1;
        break label96;
      }
    }
    int i1 = 0;
    label96:
    if (i1 != 0) {
      return;
    }
    f1 = paramMotionEvent.getRawX();
    paramMotionEvent = this.c;
    if (paramMotionEvent == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    a((int)(f1 - paramMotionEvent.getWidth()));
  }
  
  private final int b(float paramFloat, boolean paramBoolean)
  {
    return (int)Math.min(Math.max(0, c(paramFloat, paramBoolean)), this.g);
  }
  
  private final void b()
  {
    CaptureOperateTouchLayout.OnCaptureOperateCallback localOnCaptureOperateCallback = this.p;
    if ((localOnCaptureOperateCallback != null) && (localOnCaptureOperateCallback != null)) {
      localOnCaptureOperateCallback.a(this.h);
    }
  }
  
  private final int c(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      float f1 = this.j;
      float f2 = this.l;
      return (int)(this.k + (paramFloat - f1) * f2);
    }
    return (int)(paramFloat * (float)this.g) / 1000 * 1000;
  }
  
  private final float getMaxLength()
  {
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localObject = ((ImageView)localObject).getParent();
    if (localObject != null)
    {
      int i1 = ((View)localObject).getRight();
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      return i1 - ((ImageView)localObject).getWidth();
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  public final void a(float paramFloat, boolean paramBoolean)
  {
    int i1 = getWidth();
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    float f1 = (i1 - ((ImageView)localObject).getWidth()) * paramFloat;
    this.m = paramFloat;
    this.h = b(paramFloat, paramBoolean);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onIndicatorChange percent: ");
    ((StringBuilder)localObject).append(paramFloat);
    ((StringBuilder)localObject).append(" progressX: ");
    ((StringBuilder)localObject).append(f1);
    ((StringBuilder)localObject).append(" duration: ");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append("videoSeekPosition: ");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append(" longPressStartVideoSeekPercent: ");
    ((StringBuilder)localObject).append(this.j);
    TLog.b("CaptureOperateTouchLayout", ((StringBuilder)localObject).toString());
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    ((ImageView)localObject).setX(f1);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("processTextView");
    }
    ((TextView)localObject).setX(f1);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("processTextView");
    }
    ((TextView)localObject).setText((CharSequence)DisplayUtils.a.a(this.h / 1000));
    b();
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.o.computeScrollOffset())
    {
      a(this.o.getCurrX() / getMaxLength(), this.n);
      invalidate();
    }
  }
  
  public final float getCurrentProgress()
  {
    return this.m;
  }
  
  @Nullable
  public final CaptureOperateTouchLayout.OnCaptureOperateCallback getOnCaptureOperateCallback()
  {
    return this.p;
  }
  
  @Nullable
  public final CaptureOperateTouchLayout.OnIndicatorPressCallback getOnIndicatorPressCallback()
  {
    return this.q;
  }
  
  public final int getVideoSeekPosition()
  {
    return this.h;
  }
  
  public boolean onInterceptTouchEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    requestDisallowInterceptTouchEvent(true);
    if (paramMotionEvent.getAction() == 0) {
      a(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public final void setDuration(long paramLong)
  {
    this.g = paramLong;
  }
  
  public final void setOnCaptureOperateCallback(@Nullable CaptureOperateTouchLayout.OnCaptureOperateCallback paramOnCaptureOperateCallback)
  {
    this.p = paramOnCaptureOperateCallback;
  }
  
  public final void setOnIndicatorPressCallback(@Nullable CaptureOperateTouchLayout.OnIndicatorPressCallback paramOnIndicatorPressCallback)
  {
    this.q = paramOnIndicatorPressCallback;
  }
  
  public final void setVideoSeekPosition(int paramInt)
  {
    this.h = paramInt;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void setup(@NotNull ImageView paramImageView, @NotNull TextView paramTextView1, @NotNull TextView paramTextView2, @NotNull VideoMeasureScaleView paramVideoMeasureScaleView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "indicator");
    Intrinsics.checkParameterIsNotNull(paramTextView1, "processTextView");
    Intrinsics.checkParameterIsNotNull(paramTextView2, "captureToastTextView");
    Intrinsics.checkParameterIsNotNull(paramVideoMeasureScaleView, "videoMeasureScaleView");
    this.c = paramImageView;
    this.d = paramTextView1;
    this.f = paramTextView2;
    paramTextView2.setText(R.string.o);
    this.e = paramVideoMeasureScaleView;
    this.i = paramInt;
    this.l = (paramInt * r);
    paramImageView.setOnTouchListener((View.OnTouchListener)new CaptureOperateTouchLayout.IndicatorTouchListener(this, (CaptureOperateTouchLayout.IndicatorLongPressCallback)new CaptureOperateTouchLayout.setup.1(this, paramTextView2, paramVideoMeasureScaleView, paramImageView)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout
 * JD-Core Version:    0.7.0.1
 */