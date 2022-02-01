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
  public static final CaptureOperateTouchLayout.Companion a;
  private static int e = 200;
  private float jdField_a_of_type_Float = -1;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final Scroller jdField_a_of_type_AndroidWidgetScroller = new Scroller(AppContext.a.a());
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private CaptureOperateTouchLayout.OnCaptureOperateCallback jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$OnCaptureOperateCallback;
  @Nullable
  private CaptureOperateTouchLayout.OnIndicatorPressCallback jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$OnIndicatorPressCallback;
  private VideoMeasureScaleView jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureVideoMeasureScaleView;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int c = -1;
  private int d = -1;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$Companion = new CaptureOperateTouchLayout.Companion(null);
  }
  
  public CaptureOperateTouchLayout(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final int a(float paramFloat)
  {
    return (int)(paramFloat * this.jdField_b_of_type_Int);
  }
  
  private final int a(float paramFloat, boolean paramBoolean)
  {
    return (int)Math.min(Math.max(0, b(paramFloat, paramBoolean)), this.jdField_a_of_type_Long);
  }
  
  private final void a()
  {
    CaptureOperateTouchLayout.OnCaptureOperateCallback localOnCaptureOperateCallback = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$OnCaptureOperateCallback;
    if ((localOnCaptureOperateCallback != null) && (localOnCaptureOperateCallback != null)) {
      localOnCaptureOperateCallback.a(this.jdField_a_of_type_Int);
    }
  }
  
  private final void a(int paramInt)
  {
    int i = getWidth();
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    int j = localImageView.getWidth();
    a(paramInt / (i - j), false);
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    if (f1 >= localImageView.getX())
    {
      f1 = paramMotionEvent.getRawX();
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      float f2 = localImageView.getX();
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localImageView == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      if (f1 <= f2 + localImageView.getWidth())
      {
        i = 1;
        break label96;
      }
    }
    int i = 0;
    label96:
    if (i != 0) {
      return;
    }
    f1 = paramMotionEvent.getRawX();
    paramMotionEvent = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramMotionEvent == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    a((int)(f1 - paramMotionEvent.getWidth()));
  }
  
  private final float b()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    localObject = ((ImageView)localObject).getParent();
    if (localObject != null)
    {
      int i = ((View)localObject).getRight();
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("indicator");
      }
      return i - ((ImageView)localObject).getWidth();
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
  
  private final int b(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      float f1 = this.jdField_a_of_type_Float;
      float f2 = this.d;
      return (int)(this.c + (paramFloat - f1) * f2);
    }
    return (int)(paramFloat * (float)this.jdField_a_of_type_Long) / 1000 * 1000;
  }
  
  public final float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final CaptureOperateTouchLayout.OnCaptureOperateCallback a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$OnCaptureOperateCallback;
  }
  
  @Nullable
  public final CaptureOperateTouchLayout.OnIndicatorPressCallback a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$OnIndicatorPressCallback;
  }
  
  public final void a(float paramFloat, boolean paramBoolean)
  {
    int i = getWidth();
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    float f = (i - ((ImageView)localObject).getWidth()) * paramFloat;
    this.jdField_b_of_type_Float = paramFloat;
    this.jdField_a_of_type_Int = a(paramFloat, paramBoolean);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onIndicatorChange percent: ");
    ((StringBuilder)localObject).append(paramFloat);
    ((StringBuilder)localObject).append(" progressX: ");
    ((StringBuilder)localObject).append(f);
    ((StringBuilder)localObject).append(" duration: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append("videoSeekPosition: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(" longPressStartVideoSeekPercent: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Float);
    TLog.b("CaptureOperateTouchLayout", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("indicator");
    }
    ((ImageView)localObject).setX(f);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("processTextView");
    }
    ((TextView)localObject).setX(f);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("processTextView");
    }
    ((TextView)localObject).setText((CharSequence)DisplayUtils.a.a(this.jdField_a_of_type_Int / 1000));
    a();
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      a(this.jdField_a_of_type_AndroidWidgetScroller.getCurrX() / b(), this.jdField_a_of_type_Boolean);
      invalidate();
    }
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
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final void setOnCaptureOperateCallback(@Nullable CaptureOperateTouchLayout.OnCaptureOperateCallback paramOnCaptureOperateCallback)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$OnCaptureOperateCallback = paramOnCaptureOperateCallback;
  }
  
  public final void setOnIndicatorPressCallback(@Nullable CaptureOperateTouchLayout.OnIndicatorPressCallback paramOnIndicatorPressCallback)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureCaptureOperateTouchLayout$OnIndicatorPressCallback = paramOnIndicatorPressCallback;
  }
  
  public final void setVideoSeekPosition(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final void setup(@NotNull ImageView paramImageView, @NotNull TextView paramTextView1, @NotNull TextView paramTextView2, @NotNull VideoMeasureScaleView paramVideoMeasureScaleView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "indicator");
    Intrinsics.checkParameterIsNotNull(paramTextView1, "processTextView");
    Intrinsics.checkParameterIsNotNull(paramTextView2, "captureToastTextView");
    Intrinsics.checkParameterIsNotNull(paramVideoMeasureScaleView, "videoMeasureScaleView");
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView1;
    this.jdField_b_of_type_AndroidWidgetTextView = paramTextView2;
    paramTextView2.setText(R.string.s);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocaptureVideoMeasureScaleView = paramVideoMeasureScaleView;
    this.jdField_b_of_type_Int = paramInt;
    this.d = (paramInt * e);
    paramImageView.setOnTouchListener((View.OnTouchListener)new CaptureOperateTouchLayout.IndicatorTouchListener(this, (CaptureOperateTouchLayout.IndicatorLongPressCallback)new CaptureOperateTouchLayout.setup.1(this, paramTextView2, paramVideoMeasureScaleView, paramImageView)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocapture.CaptureOperateTouchLayout
 * JD-Core Version:    0.7.0.1
 */