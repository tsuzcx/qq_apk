package com.tencent.mobileqq.kandian.base.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.PuzzleAvatarUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class AggregateAvatarUrlDrawable
  extends Drawable
  implements Sizeable, URLDrawable.URLDrawableListener
{
  private static String jdField_a_of_type_JavaLangString = "AggregateAvatarUrlDrawable";
  private final float jdField_a_of_type_Float = 0.48F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private int jdField_b_of_type_Int = 1;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private RectF jdField_b_of_type_AndroidGraphicsRectF;
  private Bitmap c;
  private volatile Bitmap d;
  
  public AggregateAvatarUrlDrawable(Bitmap paramBitmap, int paramInt1, Resources paramResources, String paramString, int paramInt2)
  {
    a(paramBitmap, paramInt1, paramResources, paramInt2);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramString);
      return;
    }
    catch (NumberFormatException paramBitmap)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, paramBitmap.getMessage());
    }
  }
  
  public AggregateAvatarUrlDrawable(Bitmap paramBitmap, String paramString, int paramInt1, Resources paramResources, int paramInt2)
  {
    a(paramBitmap, paramInt1, paramResources, paramInt2);
    a(paramString);
  }
  
  private void a()
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initAggregateIcon mode : ");
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_Int);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    if ((this.d != null) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null)) {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, 2130844952);
        if (localBitmap == null)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "initAggregateIcon: mask is null");
          return;
        }
        if (this.jdField_b_of_type_Int == 1)
        {
          localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
          localObject2 = this.d;
        }
        else
        {
          localObject1 = this.d;
          localObject2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
        }
        this.jdField_b_of_type_AndroidGraphicsBitmap = PuzzleAvatarUtil.a((Bitmap)localObject1, localBitmap, 0.0F, 1.0F);
        this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, this.jdField_a_of_type_Int * 0.75F, this.jdField_a_of_type_Int * 0.75F);
        this.c = ((Bitmap)localObject2);
        this.jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, this.c.getWidth(), this.c.getHeight());
        this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Int * 0.52F, this.jdField_a_of_type_Int * 0.52F, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "initAggregateIcon: ", localOutOfMemoryError);
        return;
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "has error !");
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, Resources paramResources, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        int i = this.jdField_a_of_type_Int;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        float f2 = i;
        if (this.jdField_b_of_type_Int != 1) {
          break label142;
        }
        f1 = 0.52F;
        f1 = f2 * f1;
        localURLDrawableOptions.mRequestWidth = Math.round(f1);
        localURLDrawableOptions.mRequestHeight = Math.round(f1);
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.a);
        this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
        if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() != null))
        {
          this.d = ImageUtil.a(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
          a();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.jdField_a_of_type_ComTencentImageURLDrawable = null;
        this.d = null;
      }
      return;
      label142:
      float f1 = 0.48F;
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.d != null)
    {
      if ((this.c == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap == null)) {
        a();
      }
      if (this.c != null)
      {
        Bitmap localBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
        if (localBitmap != null)
        {
          paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.drawBitmap(this.c, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
          return;
        }
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getByteSize()
  {
    int i = this.jdField_a_of_type_Int;
    return Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888).getByteCount();
  }
  
  public int getOpacity()
  {
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localURLDrawable != null) {
      return localURLDrawable.getOpacity();
    }
    return 0;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onLoadFailed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onLoadSuccessed");
    this.d = ImageUtil.a(paramURLDrawable.getCurrDrawable());
    a();
    invalidateSelf();
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localURLDrawable != null) {
      localURLDrawable.setAlpha(paramInt);
    }
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    URLDrawable localURLDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
    if (localURLDrawable != null) {
      localURLDrawable.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.AggregateAvatarUrlDrawable
 * JD-Core Version:    0.7.0.1
 */