package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.mobileqq.extendfriend.utils.GradientDrawableUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ExtendFriendFeedView
  extends FrameLayout
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final int[] jdField_a_of_type_ArrayOfInt = { -13900833, -37464, -12331403, -5544982 };
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private GradientDrawable jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  
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
    LayoutInflater.from(paramContext).inflate(2130970337, this, true);
    this.jdField_a_of_type_Float = AIOUtils.a(4.0F, getResources());
  }
  
  private Bitmap a(String paramString)
  {
    Object localObject1 = ExtendFriendResourceUtil.c;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      for (;;)
      {
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            break label212;
          }
          i = paramString.lastIndexOf('=');
          if (i < 0) {
            break label212;
          }
          paramString = paramString.substring(i + 1);
          if (TextUtils.isEmpty(paramString)) {
            break label212;
          }
          i = paramString.toUpperCase().charAt(0) % localObject1.length;
          if (i == -1)
          {
            str = ExtendFriendResourceUtil.a("expand_feed_bg_default.png");
            paramString = (WeakReference)jdField_a_of_type_JavaUtilMap.get(str);
            if (paramString == null) {
              break label207;
            }
            paramString = (Bitmap)paramString.get();
            if (paramString != null)
            {
              localObject2 = paramString;
              localObject1 = paramString;
            }
          }
        }
        catch (Exception paramString)
        {
          String str;
          Object localObject2;
          localObject1 = null;
          QLog.e("ExtendFriendFeedView", 1, "getRandomFeedBackground fail.", paramString);
          return localObject1;
        }
        try
        {
          if (paramString.isRecycled())
          {
            localObject1 = paramString;
            localObject2 = new BitmapFactory.Options();
            localObject1 = paramString;
            ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
            localObject1 = paramString;
            ((BitmapFactory.Options)localObject2).inSampleSize = 2;
            localObject1 = paramString;
            localObject2 = ExtendFriendResourceUtil.a(str, (BitmapFactory.Options)localObject2);
            localObject1 = localObject2;
            jdField_a_of_type_JavaUtilMap.put(str, new WeakReference(localObject2));
          }
          return localObject2;
        }
        catch (Exception paramString)
        {
          continue;
        }
        str = ExtendFriendResourceUtil.a(localObject1[i]);
        continue;
        label207:
        paramString = null;
        continue;
        label212:
        int i = -1;
      }
    }
    return null;
  }
  
  private GradientDrawable a(int paramInt)
  {
    int i = jdField_a_of_type_ArrayOfInt.length;
    paramInt = jdField_a_of_type_ArrayOfInt[(paramInt % i)];
    if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable == null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = GradientDrawableUtils.a(paramInt, 0.0F, 0.0F, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable;
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setColor(paramInt);
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    int i;
    float f2;
    float f3;
    float f1;
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_b_of_type_Int > 0))
    {
      if ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        if (jdField_a_of_type_AndroidGraphicsBitmap == null)
        {
          jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(10, 10, Bitmap.Config.RGB_565);
          new Canvas(jdField_a_of_type_AndroidGraphicsBitmap).drawColor(-1);
        }
        this.jdField_b_of_type_AndroidGraphicsBitmap = jdField_a_of_type_AndroidGraphicsBitmap;
      }
      i = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
      int j = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
      f2 = this.jdField_a_of_type_Int / i;
      f3 = this.jdField_b_of_type_Int / j;
      if (f2 <= f3) {
        break label311;
      }
      f1 = (j * f2 - this.jdField_b_of_type_Int) / 2.0F;
      f3 = f2;
      f2 = 0.0F;
    }
    for (;;)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.setScale(f3, f3);
      localMatrix.postTranslate(-f2, -f1);
      BitmapShader localBitmapShader = new BitmapShader(this.jdField_b_of_type_AndroidGraphicsBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      localBitmapShader.setLocalMatrix(localMatrix);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localBitmapShader);
      if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable != null)
      {
        i = AIOUtils.a(5.0F, getResources());
        this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.setBounds(0, this.jdField_b_of_type_Int - i, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      return;
      label311:
      f2 = (i * f3 - this.jdField_a_of_type_Int) / 2.0F;
      f1 = 0.0F;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsRectF != null) && (this.jdField_a_of_type_AndroidGraphicsPaint != null)) {
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable.draw(paramCanvas);
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
  
  public void setFeedBgParams(int paramInt, String paramString)
  {
    this.jdField_b_of_type_AndroidGraphicsBitmap = a(paramString);
    this.jdField_a_of_type_AndroidGraphicsDrawableGradientDrawable = a(paramInt);
    a();
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView
 * JD-Core Version:    0.7.0.1
 */