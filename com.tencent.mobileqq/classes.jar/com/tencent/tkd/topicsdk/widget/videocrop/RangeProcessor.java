package com.tencent.tkd.topicsdk.widget.videocrop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.tencent.tkd.R.color;
import com.tencent.tkd.R.drawable;
import com.tencent.tkd.topicsdk.common.DisplayUtils;
import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/videocrop/RangeProcessor;", "", "parent", "Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;", "frameWidth", "", "frameHeight", "milliSecPerFrame", "", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;FFI)V", "lastX", "leftBarrier", "lineHeight", "maxRange", "minRange", "paint", "Landroid/graphics/Paint;", "getParent", "()Lcom/tencent/tkd/topicsdk/widget/videocrop/FrameParent;", "pressedThumb", "rangeChangeListener", "Lcom/tencent/tkd/topicsdk/widget/videocrop/RangeProcessor$OnRangeChangeListener;", "getRangeChangeListener", "()Lcom/tencent/tkd/topicsdk/widget/videocrop/RangeProcessor$OnRangeChangeListener;", "setRangeChangeListener", "(Lcom/tencent/tkd/topicsdk/widget/videocrop/RangeProcessor$OnRangeChangeListener;)V", "rangeDistance", "getRangeDistance", "()F", "rightBarrier", "screenMaxCoord", "screenMinCoord", "screenWidth", "thumbColor", "thumbHalfWidth", "getThumbHalfWidth", "thumbHeight", "getThumbHeight", "thumbMaxImage", "Landroid/graphics/Bitmap;", "thumbMinImage", "thumbWidth", "getThumbWidth", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "drawMaxImage", "thumbDrawable", "Landroid/graphics/drawable/Drawable;", "drawMinImage", "floatEquals", "", "a", "b", "getBitmapFromResource", "resources", "Landroid/content/res/Resources;", "resId", "hasChanged", "isInThumbRange", "touchX", "touchY", "cursorX", "isPressedThumb", "processTouchEvent", "event", "Landroid/view/MotionEvent;", "reset", "setBarrier", "left", "right", "setLimitRange", "minVideoLength", "maxVideoLength", "updateScreenMaxCoordInMove", "dx", "updateScreenMinCoordInMove", "Companion", "OnRangeChangeListener", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class RangeProcessor
{
  public static final RangeProcessor.Companion a;
  private final float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  @NotNull
  private final FrameParent jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent;
  @Nullable
  private RangeProcessor.OnRangeChangeListener jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor$OnRangeChangeListener;
  private final float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private final float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private final float k;
  private final float l;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor$Companion = new RangeProcessor.Companion(null);
  }
  
  public RangeProcessor(@NotNull FrameParent paramFrameParent, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent = paramFrameParent;
    this.k = paramFloat1;
    this.l = paramFloat2;
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_Int = DisplayUtils.a.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext());
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_Float = DisplayUtils.a.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext(), 2.0F);
    this.jdField_b_of_type_Float = DisplayUtils.a.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext(), 18.0F);
    this.jdField_c_of_type_Float = (this.l + this.jdField_a_of_type_Float * 2);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext().getResources().getColor(R.color.jdField_c_of_type_Int);
    paramFrameParent = (Drawable)new ColorDrawable(this.jdField_c_of_type_Int);
    paramFrameParent.setBounds(0, 0, (int)this.jdField_b_of_type_Float, (int)this.jdField_c_of_type_Float);
    b(paramFrameParent);
    a(paramFrameParent);
    this.h = this.jdField_b_of_type_Float;
    this.i = (12 * this.k + this.jdField_b_of_type_Float);
  }
  
  private final int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = paramOptions.outHeight;
    int i2 = paramOptions.outWidth;
    int n = 1;
    int m = 1;
    if ((i1 > paramInt2) || (i2 > paramInt1))
    {
      i1 /= 2;
      i2 /= 2;
      for (;;)
      {
        n = m;
        if (i1 / m <= paramInt2) {
          break;
        }
        n = m;
        if (i2 / m <= paramInt1) {
          break;
        }
        m *= 2;
      }
    }
    return n;
  }
  
  private final Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = 1;
    if (paramResources == null) {}
    while (paramInt1 <= 0) {
      return null;
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      if ((paramInt2 <= 0) && (paramInt3 <= 0)) {}
      for (paramInt2 = m;; paramInt2 = a(localOptions, paramInt2, paramInt3))
      {
        localOptions.inJustDecodeBounds = false;
        localOptions.inSampleSize = paramInt2;
        return BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      }
      return (Bitmap)null;
    }
    catch (Exception paramResources)
    {
      TLog.d("RangeProcessor", "getBitmapFromResource: " + paramResources);
      return (Bitmap)null;
    }
    catch (OutOfMemoryError paramResources)
    {
      TLog.d("RangeProcessor", "getBitmapFromResource: " + paramResources);
    }
  }
  
  private final void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 < 0) && (this.jdField_d_of_type_Float + paramFloat1 <= this.jdField_b_of_type_Float)) {}
    for (;;)
    {
      this.jdField_d_of_type_Float = paramFloat2;
      return;
      if (this.e - paramFloat3 < this.f) {
        paramFloat2 = this.e - this.f;
      } else {
        paramFloat2 = paramFloat3;
      }
    }
  }
  
  private final void a(Drawable paramDrawable)
  {
    Bitmap localBitmap = a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext().getResources(), R.drawable.jdField_b_of_type_Int, (int)this.jdField_b_of_type_Float, (int)this.jdField_c_of_type_Float);
    Object localObject = Bitmap.createBitmap((int)this.jdField_b_of_type_Float, (int)this.jdField_c_of_type_Float, Bitmap.Config.RGB_565);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Bitmap.createBitmap(thum…), Bitmap.Config.RGB_565)");
    this.jdField_b_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
    localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMaxImage");
    }
    localObject = new Canvas((Bitmap)localObject);
    paramDrawable.draw((Canvas)localObject);
    if (localBitmap != null) {
      ((Canvas)localObject).drawBitmap(localBitmap, DisplayUtils.a.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext(), 2.0F), (this.jdField_c_of_type_Float - localBitmap.getHeight()) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private final boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Math.abs(paramFloat1 - paramFloat3) <= this.jdField_b_of_type_Float * 2)
    {
      bool1 = bool2;
      if (paramFloat2 > 0)
      {
        bool1 = bool2;
        if (paramFloat2 < this.jdField_c_of_type_Float) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private final void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if ((paramFloat1 > 0) && (this.e + paramFloat1 >= this.g)) {}
    for (;;)
    {
      this.e = paramFloat2;
      return;
      if (paramFloat3 - this.jdField_d_of_type_Float < this.f) {
        paramFloat2 = this.jdField_d_of_type_Float + this.f;
      } else {
        paramFloat2 = paramFloat3;
      }
    }
  }
  
  private final void b(Drawable paramDrawable)
  {
    Bitmap localBitmap = a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext().getResources(), R.drawable.jdField_a_of_type_Int, (int)this.jdField_b_of_type_Float, (int)this.jdField_c_of_type_Float);
    Object localObject = Bitmap.createBitmap((int)this.jdField_b_of_type_Float, (int)this.jdField_c_of_type_Float, Bitmap.Config.RGB_565);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Bitmap.createBitmap(thum…), Bitmap.Config.RGB_565)");
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMinImage");
    }
    localObject = new Canvas((Bitmap)localObject);
    paramDrawable.draw((Canvas)localObject);
    if (localBitmap != null) {
      ((Canvas)localObject).drawBitmap(localBitmap, DisplayUtils.a.a(this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.getContext(), 5.0F), (this.jdField_c_of_type_Float - localBitmap.getHeight()) / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private final boolean b(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  private final float d()
  {
    return this.jdField_b_of_type_Float / 2;
  }
  
  public final float a()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor$OnRangeChangeListener = ((RangeProcessor.OnRangeChangeListener)null);
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMinImage");
    }
    localBitmap.recycle();
    localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (localBitmap == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMaxImage");
    }
    localBitmap.recycle();
  }
  
  public final void a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 >= 0) {}
    for (paramFloat1 = this.jdField_b_of_type_Float + paramFloat1;; paramFloat1 = this.jdField_b_of_type_Float)
    {
      this.h = paramFloat1;
      if (paramFloat2 >= 0) {
        this.i = Math.min(this.jdField_b_of_type_Float + paramFloat2, this.jdField_a_of_type_Int - this.jdField_b_of_type_Float);
      }
      return;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.g = Math.min(paramInt2 * 1.0F / this.jdField_d_of_type_Int * this.k, 12 * this.k + this.jdField_b_of_type_Float);
    this.f = Math.max(paramInt1 * 1.0F / this.jdField_d_of_type_Int * this.k, 0.0F);
    this.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
    this.e = (this.g + this.jdField_b_of_type_Float);
  }
  
  public final void a(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    paramCanvas.drawRect(this.jdField_d_of_type_Float, -this.jdField_a_of_type_Float, this.e, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_d_of_type_Float, this.jdField_c_of_type_Float - this.jdField_a_of_type_Float * 2, this.e, this.jdField_c_of_type_Float - this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMinImage");
    }
    paramCanvas.drawBitmap(localBitmap, this.jdField_d_of_type_Float - this.jdField_b_of_type_Float, -this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (localBitmap == null) {
      Intrinsics.throwUninitializedPropertyAccessException("thumbMaxImage");
    }
    paramCanvas.drawBitmap(localBitmap, this.e, -this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  public final void a(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    float f1 = paramMotionEvent.getX();
    if (paramMotionEvent.getAction() == 1) {
      this.jdField_b_of_type_Int = -1;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.j = paramMotionEvent.getX();
      return;
    }
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 2)
    {
      f2 = f1 - this.j;
      if (this.jdField_b_of_type_Int != 0) {
        break label136;
      }
      f3 = Math.max(this.e - this.g, this.h);
      if (f1 < f3)
      {
        this.jdField_d_of_type_Float = f3;
        return;
      }
      a(f2, f3, f1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropFrameParent.invalidate();
      paramMotionEvent = this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor$OnRangeChangeListener;
      if (paramMotionEvent == null) {
        break;
      }
      paramMotionEvent.a(this.jdField_d_of_type_Float, this.e);
      return;
      label136:
      if (this.jdField_b_of_type_Int == 1)
      {
        f3 = Math.min(this.jdField_d_of_type_Float + this.g, this.i);
        if (f1 > f3)
        {
          this.e = f3;
          return;
        }
        b(f2, f3, f1);
      }
    }
  }
  
  public final void a(@Nullable RangeProcessor.OnRangeChangeListener paramOnRangeChangeListener)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkWidgetVideocropRangeProcessor$OnRangeChangeListener = paramOnRangeChangeListener;
  }
  
  public final boolean a()
  {
    return (!b(this.jdField_d_of_type_Float, this.jdField_b_of_type_Float)) || (!b(this.e, this.g));
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool1 = a(paramFloat1, paramFloat2, this.jdField_d_of_type_Float - d());
    boolean bool2 = a(paramFloat1, paramFloat2, this.e + d());
    if (bool1)
    {
      this.jdField_b_of_type_Int = 0;
      return true;
    }
    if (bool2)
    {
      this.jdField_b_of_type_Int = 1;
      return true;
    }
    return false;
  }
  
  public final float b()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public final float c()
  {
    return this.e - this.jdField_d_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.RangeProcessor
 * JD-Core Version:    0.7.0.1
 */