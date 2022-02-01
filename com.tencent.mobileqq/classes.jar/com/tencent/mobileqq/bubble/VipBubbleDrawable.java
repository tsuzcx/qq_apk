package com.tencent.mobileqq.bubble;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.StateSet;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class VipBubbleDrawable
  extends Drawable
{
  private static final ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter = new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -26.0F, 0.0F, 1.0F, 0.0F, 0.0F, -26.0F, 0.0F, 0.0F, 1.0F, 0.0F, -26.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
  private static int[] jdField_a_of_type_ArrayOfInt = { 16842919 };
  private int jdField_a_of_type_Int = 160;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private NinePatch jdField_a_of_type_AndroidGraphicsNinePatch;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public String a;
  public boolean a;
  private int jdField_b_of_type_Int;
  private NinePatch jdField_b_of_type_AndroidGraphicsNinePatch;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  private boolean f;
  
  public VipBubbleDrawable(Resources paramResources, NinePatch paramNinePatch1, NinePatch paramNinePatch2, int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    this.jdField_a_of_type_AndroidGraphicsNinePatch = paramNinePatch1;
    this.jdField_b_of_type_AndroidGraphicsNinePatch = paramNinePatch2;
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    if (paramResources != null)
    {
      this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;
      this.jdField_b_of_type_Int = AIOUtils.b(65.0F, paramResources);
      this.jdField_c_of_type_Int = AIOUtils.b(57.0F, paramResources);
    }
  }
  
  private int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    int i = paramBitmap.getRowBytes();
    return paramBitmap.getHeight() * i;
  }
  
  private void a(Canvas paramCanvas)
  {
    if (paramCanvas == null) {
      return;
    }
    int j = 0;
    Object localObject1 = AIOUtils.a();
    ((StringBuilder)localObject1).append("bubblebg://");
    ((StringBuilder)localObject1).append("0_local_default_");
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_Boolean);
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = j;
    Object localObject2;
    if (GlobalImageCache.a != null)
    {
      localObject2 = (Pair)GlobalImageCache.a.get(localObject1);
      i = j;
      if (localObject2 != null)
      {
        localObject2 = (NinePatch)((Pair)localObject2).first;
        i = j;
        if (localObject2 != null)
        {
          ((NinePatch)localObject2).draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
          i = 1;
        }
      }
    }
    if (i == 0)
    {
      if (this.jdField_b_of_type_Boolean) {
        i = 2130850159;
      } else {
        i = 2130850335;
      }
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inDensity = 320;
      ((BitmapFactory.Options)localObject2).inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
      try
      {
        a(paramCanvas, (String)localObject1, BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, i, (BitmapFactory.Options)localObject2));
        return;
      }
      catch (OutOfMemoryError paramCanvas)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("drawDefaultBubbleBg, decode default bubble bg error, bubbleId=");
        ((StringBuilder)localObject1).append(this.jdField_d_of_type_Int);
        QLog.e("VipBubbleDrawable", 1, ((StringBuilder)localObject1).toString(), paramCanvas);
      }
    }
  }
  
  private void a(Canvas paramCanvas, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Object localObject = paramBitmap.getNinePatchChunk();
      if (localObject != null)
      {
        localObject = new NinePatch(paramBitmap, (byte[])localObject, null);
        ((NinePatch)localObject).draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
        if (GlobalImageCache.a != null)
        {
          paramCanvas = new Pair(localObject, Integer.valueOf(a(paramBitmap)));
          GlobalImageCache.a.put(paramString, paramCanvas);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean, String paramString1, int[] paramArrayOfInt, String paramString2)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.e = paramBoolean;
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_ArrayOfInt = paramArrayOfInt;
      this.jdField_c_of_type_JavaLangString = paramString2;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.f = paramBoolean2;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(jdField_a_of_type_AndroidGraphicsColorFilter);
    } else {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(null);
    }
    invalidateSelf();
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.e) {
      return;
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new VipBubbleDrawable.1(this));
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = paramCanvas.save();
    if (this.f)
    {
      localObject = this.jdField_b_of_type_AndroidGraphicsNinePatch;
      if (localObject != null) {}
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsNinePatch;
    }
    if (localObject != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
      }
      ((NinePatch)localObject).draw(paramCanvas, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("draw, ninePatch null, use default, mUseAnimationBg=");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(", mNormalNinePatch=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidGraphicsNinePatch);
      ((StringBuilder)localObject).append(", mAnimationNinePath");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidGraphicsNinePatch);
      ((StringBuilder)localObject).append(", bubbleId=");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
      ((StringBuilder)localObject).append(", drawable=");
      ((StringBuilder)localObject).append(this);
      QLog.e("VipBubbleDrawable", 1, ((StringBuilder)localObject).toString());
      a(paramCanvas);
    }
    paramCanvas.restoreToCount(i);
    Object localObject = (HashMap)BubbleDiyFetcher.a().a.get(Integer.valueOf(this.jdField_d_of_type_Int));
    if ((localObject != null) && (((HashMap)localObject).size() > 0))
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DiyBubbleConfig)((Iterator)localObject).next()).a(this, paramCanvas);
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getOpacity()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsNinePatch;
    if (localObject != null)
    {
      if (((NinePatch)localObject).hasAlpha()) {
        return -3;
      }
      return -1;
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
    if ((localObject != null) && (((Paint)localObject).getAlpha() < 255)) {
      return -3;
    }
    return -1;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = StateSet.stateSetMatches(jdField_a_of_type_ArrayOfInt, paramArrayOfInt);
    if (this.jdField_c_of_type_Boolean != bool)
    {
      this.jdField_c_of_type_Boolean = bool;
      if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(jdField_a_of_type_AndroidGraphicsColorFilter);
      } else {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(null);
      }
      this.jdField_a_of_type_Boolean = false;
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.VipBubbleDrawable
 * JD-Core Version:    0.7.0.1
 */