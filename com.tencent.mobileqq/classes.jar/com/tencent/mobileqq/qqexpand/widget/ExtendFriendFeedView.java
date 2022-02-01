package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.GradientDrawableUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ExtendFriendFeedView
  extends FrameLayout
  implements View.OnTouchListener
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public static ColorFilter a;
  private static final Map<String, WeakReference<Bitmap>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final int[] jdField_a_of_type_ArrayOfInt = { -13900833, -37464, -12331403, -5544982 };
  private final float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private int c = 0;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsColorFilter = new PorterDuffColorFilter(536870912, PorterDuff.Mode.SRC_ATOP);
  }
  
  public ExtendFriendFeedView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendFeedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendFeedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(1912995846, this, true);
    this.jdField_a_of_type_Float = AIOUtils.b(4.0F, getResources());
  }
  
  private Bitmap a(String paramString)
  {
    String[] arrayOfString = ExpandResourceUtil.c;
    String str2 = null;
    Object localObject2 = null;
    Object localObject1 = str2;
    if (arrayOfString != null)
    {
      localObject1 = str2;
      if (arrayOfString.length <= 0) {}
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          break label244;
        }
        i = paramString.lastIndexOf('=');
        if (i < 0) {
          break label244;
        }
        paramString = paramString.substring(i + 1);
        if (TextUtils.isEmpty(paramString)) {
          break label244;
        }
        i = paramString.toUpperCase().charAt(0) % arrayOfString.length;
        if (i == -1) {
          str2 = ExpandResourceUtil.a("expand_feed_bg_default.png");
        } else {
          str2 = ExpandResourceUtil.a(arrayOfString[i]);
        }
        paramString = (WeakReference)jdField_a_of_type_JavaUtilMap.get(str2);
        if (paramString != null) {
          paramString = (Bitmap)paramString.get();
        } else {
          paramString = null;
        }
        if (paramString != null)
        {
          localObject1 = paramString;
          localObject2 = paramString;
        }
        try
        {
          if (!paramString.isRecycled()) {
            break;
          }
          localObject1 = paramString;
          localObject2 = new BitmapFactory.Options();
          localObject1 = paramString;
          ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
          localObject1 = paramString;
          ((BitmapFactory.Options)localObject2).inSampleSize = 2;
          localObject1 = paramString;
          localObject2 = ExpandResourceUtil.a(str2, (BitmapFactory.Options)localObject2);
          localObject1 = localObject2;
          jdField_a_of_type_JavaUtilMap.put(str2, new WeakReference(localObject2));
        }
        catch (Exception localException2)
        {
          paramString = (String)localObject1;
          localObject1 = localException2;
        }
        QLog.e("ExtendFriendFeedView", 1, "getRandomFeedBackground fail.", localException1);
      }
      catch (Exception localException1)
      {
        paramString = (String)localObject2;
      }
      String str1 = paramString;
      return str1;
      label244:
      int i = -1;
    }
    return localObject2;
  }
  
  private GradientDrawable a(int paramInt)
  {
    Object localObject = jdField_a_of_type_ArrayOfInt;
    paramInt = localObject[(paramInt % localObject.length)];
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
    if (localObject == null)
    {
      float f = this.jdField_a_of_type_Float;
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = GradientDrawableUtils.a(paramInt, 0.0F, 0.0F, f, f);
    }
    else
    {
      ((GradientDrawable)localObject).setColor(paramInt);
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0))
    {
      Object localObject = this.jdField_b_of_type_AndroidGraphicsBitmap;
      if ((localObject == null) || (((Bitmap)localObject).isRecycled()))
      {
        if (jdField_a_of_type_AndroidGraphicsBitmap == null)
        {
          jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
          new Canvas(jdField_a_of_type_AndroidGraphicsBitmap).drawColor(-1);
        }
        this.jdField_b_of_type_AndroidGraphicsBitmap = jdField_a_of_type_AndroidGraphicsBitmap;
      }
      int k = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
      int i = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
      int j = this.jdField_a_of_type_Int;
      float f2 = j;
      float f1 = k;
      float f3 = f2 / f1;
      k = this.jdField_b_of_type_Int;
      f2 = k;
      float f4 = i;
      f2 /= f4;
      if (f3 > f2)
      {
        f2 = (f4 * f3 - k) / 2.0F;
        f1 = 0.0F;
      }
      else
      {
        f1 = (f1 * f2 - j) / 2.0F;
        f3 = f2;
        f2 = 0.0F;
      }
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f3, f3);
      ((Matrix)localObject).postTranslate(-f1, -f2);
      BitmapShader localBitmapShader = new BitmapShader(this.jdField_b_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      localBitmapShader.setLocalMatrix((Matrix)localObject);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localBitmapShader);
      if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, this.c, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable != null)
      {
        i = AIOUtils.b(5.0F, getResources());
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
        j = this.jdField_b_of_type_Int;
        ((GradientDrawable)localObject).setBounds(0, j - i, this.jdField_a_of_type_Int, j);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    if (localObject != null)
    {
      Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      if (localPaint != null)
      {
        float f = this.jdField_a_of_type_Float;
        paramCanvas.drawRoundRect((RectF)localObject, f, f, localPaint);
      }
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
    if (localObject != null) {
      ((GradientDrawable)localObject).draw(paramCanvas);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    a();
    invalidate();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 0) {
      if (i != 1)
      {
        bool1 = bool2;
        if (i == 2) {}
      }
      else
      {
        bool1 = false;
      }
    }
    if (this.jdField_a_of_type_Boolean != bool1)
    {
      this.jdField_a_of_type_Boolean = bool1;
      if (bool1) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(jdField_a_of_type_AndroidGraphicsColorFilter);
      } else {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(null);
      }
      invalidate();
    }
    return false;
  }
  
  public void setFeedBgParams(int paramInt1, String paramString, int paramInt2)
  {
    setFeedBgParams(paramInt1, paramString, paramInt2, true);
  }
  
  public void setFeedBgParams(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    this.c = paramInt2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFeedBgParams feedPosition:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" itemPaddingTop:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("  getPaddingTop:");
      localStringBuilder.append(getPaddingTop());
      QLog.d("ExtendFriendFeedView", 0, localStringBuilder.toString());
    }
    setPadding(getPaddingLeft(), paramInt2, getPaddingRight(), getPaddingBottom());
    this.jdField_b_of_type_AndroidGraphicsBitmap = a(paramString);
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = a(paramInt1);
    } else {
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = null;
    }
    a();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendFeedView
 * JD-Core Version:    0.7.0.1
 */