package com.tencent.tkd.topicsdk.widget.videocrop;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor;", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameAdapter$DataSetChangeListener;", "parent", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;", "videoPath", "", "videoDuration", "", "frameWidth", "", "frameHeight", "paddingLeft", "milliSecPerFrame", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;Ljava/lang/String;IFFFI)V", "adapter", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameAdapter;", "dstRect", "Landroid/graphics/Rect;", "grayMatrix", "", "mBitmap", "Landroid/graphics/Bitmap;", "mCanvas", "Landroid/graphics/Canvas;", "mGestureDetector", "Landroid/view/GestureDetector;", "mGestureListener", "Landroid/view/GestureDetector$OnGestureListener;", "mGrayPaint", "Landroid/graphics/Paint;", "mInitialRightFrameIndex", "mLastMovedDistance", "mLeftFrameIndex", "mLeftRect", "mOnFetchFrameListener", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$OnFetchFrameListener;", "mOnMoveListener", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FramesProcessor$OnMoveListener;", "mPaint", "mRightFrameIndex", "mRightRect", "mScroller", "Landroid/widget/Scroller;", "mTotalRange", "maxMovedDistance", "minMovedDistance", "movedDistance", "getPaddingLeft", "()F", "getParent", "()Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;", "processorWidth", "srcRect", "computeFrameIndex", "", "computeScroll", "destroy", "draw", "canvas", "floatEqualsZero", "", "a", "hasChanged", "onChanged", "processTouchEvent", "event", "Landroid/view/MotionEvent;", "setLeftMaskBound", "left", "setOnMoveListener", "listener", "setRightMaskBound", "right", "setRightPosition", "Companion", "Frame", "OnFetchFrameListener", "OnMoveListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class FramesProcessor
  implements FrameAdapter.DataSetChangeListener
{
  public static final FramesProcessor.Companion a;
  private float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private final Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Rect jdField_a_of_type_AndroidGraphicsRect;
  private final GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private FrameAdapter jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter;
  @NotNull
  private final FrameParent jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent;
  private FramesProcessor.OnFetchFrameListener jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor$OnFetchFrameListener;
  private FramesProcessor.OnMoveListener jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor$OnMoveListener;
  private final float[] jdField_a_of_type_ArrayOfFloat;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private final Paint jdField_b_of_type_AndroidGraphicsPaint;
  private final Rect jdField_b_of_type_AndroidGraphicsRect;
  private final float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private final Rect jdField_c_of_type_AndroidGraphicsRect;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int;
  private final Rect jdField_d_of_type_AndroidGraphicsRect;
  private float e;
  private final float f;
  private final float g;
  private final float h;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor$Companion = new FramesProcessor.Companion(null);
  }
  
  public FramesProcessor(@NotNull FrameParent paramFrameParent, @NotNull String paramString, int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent = paramFrameParent;
    this.f = paramFloat1;
    this.g = paramFloat2;
    this.h = paramFloat3;
    this.jdField_a_of_type_Int = (DisplayUtils.a.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext()) - DisplayUtils.a.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext(), 39.0F));
    paramFloat1 = 12;
    this.jdField_c_of_type_Float = (this.f * paramFloat1);
    this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = ((GestureDetector.OnGestureListener)new FramesProcessor.mGestureListener.1(this));
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_d_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    this.jdField_d_of_type_Float = Math.max(this.jdField_c_of_type_Float - this.f * paramFloat1, 0.0F);
    this.e = 0.0F;
    paramFrameParent = new StringBuilder();
    paramFrameParent.append("mTotalRange=");
    paramFrameParent.append(this.jdField_c_of_type_Float);
    paramFrameParent.append(", mMaxMovedDistance=");
    paramFrameParent.append(this.jdField_d_of_type_Float);
    TLog.b("FramesProcessor", paramFrameParent.toString());
    this.jdField_a_of_type_Float = 0.0F;
    paramFrameParent = Bitmap.createBitmap(this.jdField_a_of_type_Int, (int)this.g, Bitmap.Config.RGB_565);
    Intrinsics.checkExpressionValueIsNotNull(paramFrameParent, "Bitmap.createBitmap(proc…), Bitmap.Config.RGB_565)");
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramFrameParent;
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColorFilter((ColorFilter)new ColorMatrixColorFilter(this.jdField_a_of_type_ArrayOfFloat));
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, (int)this.h, (int)this.g);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect((int)(this.h + this.f * paramFloat1), 0, this.jdField_a_of_type_Int, (int)this.g);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext());
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter = new FrameAdapter((FrameAdapter.DataSetChangeListener)this);
    double d1 = this.jdField_a_of_type_Int * 1.0F;
    double d2 = this.f;
    Double.isNaN(d1);
    Double.isNaN(d2);
    this.jdField_c_of_type_Int = ((int)Math.ceil(d1 / d2));
    this.jdField_c_of_type_Int = Math.min(this.jdField_c_of_type_Int, 12);
    this.jdField_d_of_type_Int = this.jdField_c_of_type_Int;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor$OnFetchFrameListener = ((FramesProcessor.OnFetchFrameListener)new VideoFramesRetriever(paramString, this.f));
    paramFrameParent = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor$OnFetchFrameListener;
    if (paramFrameParent != null) {
      paramFrameParent.a(paramInt2, paramInt1, this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter);
    }
    paramFrameParent = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor$OnFetchFrameListener;
    if (paramFrameParent != null) {
      paramFrameParent.a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    }
  }
  
  private final boolean a(float paramFloat)
  {
    return Math.abs(paramFloat - 0.0F) == 0.0F;
  }
  
  private final void c()
  {
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter.a()) {
      return;
    }
    int i = (int)(this.jdField_a_of_type_Float / this.f);
    this.jdField_b_of_type_Int = Math.max(i, 0);
    int j = this.jdField_d_of_type_Int;
    if (j >= 12) {
      this.jdField_c_of_type_Int = Math.min(j + i, 12);
    }
  }
  
  private final void d()
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(-16777216);
    Object localObject = this.jdField_a_of_type_AndroidWidgetScroller;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mScroller");
    }
    if (((Scroller)localObject).computeScrollOffset())
    {
      localObject = this.jdField_a_of_type_AndroidWidgetScroller;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mScroller");
      }
      this.jdField_a_of_type_Float = ((Scroller)localObject).getCurrX();
      f1 = this.jdField_a_of_type_Float;
      f2 = this.e;
      if (f1 < f2)
      {
        this.jdField_a_of_type_Float = f2;
        localObject = this.jdField_a_of_type_AndroidWidgetScroller;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mScroller");
        }
        ((Scroller)localObject).forceFinished(true);
      }
      f1 = this.jdField_a_of_type_Float;
      f2 = this.jdField_d_of_type_Float;
      if (f1 > f2)
      {
        this.jdField_a_of_type_Float = f2;
        localObject = this.jdField_a_of_type_AndroidWidgetScroller;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("mScroller");
        }
        ((Scroller)localObject).forceFinished(true);
      }
      c();
      this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.invalidate();
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor$OnFetchFrameListener;
      if (localObject != null) {
        ((FramesProcessor.OnFetchFrameListener)localObject).a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
    }
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_b_of_type_Float;
    this.jdField_b_of_type_Float = f1;
    if (a(f1 - f2)) {
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor$OnMoveListener;
    if (localObject != null)
    {
      f1 = this.jdField_a_of_type_Float;
      ((FramesProcessor.OnMoveListener)localObject).a(f1, -f1, this.jdField_c_of_type_Float - f1);
    }
  }
  
  @NotNull
  public final FrameParent a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.postInvalidate();
  }
  
  public final void a(int paramInt)
  {
    int i = this.jdField_a_of_type_AndroidGraphicsRect.right;
    this.e += i - paramInt;
    this.jdField_a_of_type_AndroidGraphicsRect.right = paramInt;
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.invalidate();
  }
  
  public final void a(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    d();
    int i = Math.max(this.jdField_b_of_type_Int - 1, 0);
    float f1 = i * this.f;
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(f1 - this.jdField_a_of_type_Float + this.h, 0.0F);
    int m = Math.min(this.jdField_c_of_type_Int + 3, 12);
    int j = (int)this.f;
    while (i < m)
    {
      localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter.a(i);
      if (localObject != null)
      {
        int k = (int)Math.min(this.jdField_c_of_type_Float - f1, this.f);
        localObject = ((FramesProcessor.Frame)localObject).a();
        j = k;
        if (localObject != null)
        {
          this.jdField_c_of_type_AndroidGraphicsRect.set(0, 0, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
          this.jdField_d_of_type_AndroidGraphicsRect.set(0, 0, k, (int)this.g);
          this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap((Bitmap)localObject, this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          j = k;
        }
      }
      localObject = this.jdField_a_of_type_AndroidGraphicsCanvas;
      float f2 = j;
      ((Canvas)localObject).translate(f2, 0.0F);
      f1 += f2;
      i += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(-f1 + this.jdField_a_of_type_Float - this.h, 0.0F);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    paramCanvas.drawBitmap((Bitmap)localObject, localRect, localRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    localRect = this.jdField_b_of_type_AndroidGraphicsRect;
    paramCanvas.drawBitmap((Bitmap)localObject, localRect, localRect, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public final void a(@Nullable MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public final void a(@Nullable FramesProcessor.OnMoveListener paramOnMoveListener)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor$OnMoveListener = paramOnMoveListener;
  }
  
  public final boolean a()
  {
    return a(this.jdField_a_of_type_Float) ^ true;
  }
  
  public final void b()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor$OnMoveListener = ((FramesProcessor.OnMoveListener)null);
    FramesProcessor.OnFetchFrameListener localOnFetchFrameListener = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFramesProcessor$OnFetchFrameListener;
    if (localOnFetchFrameListener != null) {
      localOnFetchFrameListener.a();
    }
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameAdapter.a();
  }
  
  public final void b(int paramInt)
  {
    int i = this.jdField_b_of_type_AndroidGraphicsRect.left;
    this.jdField_d_of_type_Float += i - paramInt;
    this.jdField_b_of_type_AndroidGraphicsRect.left = paramInt;
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.FramesProcessor
 * JD-Core Version:    0.7.0.1
 */