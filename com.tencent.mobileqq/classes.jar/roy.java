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
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class roy
  extends Drawable
  implements Sizeable, URLDrawable.URLDrawableListener, pbg
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
  
  public roy(Bitmap paramBitmap, int paramInt1, Resources paramResources, String paramString, int paramInt2)
  {
    a(paramBitmap, paramInt1, paramResources, paramInt2);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_AndroidContentResResources = paramResources;
      try
      {
        this.jdField_a_of_type_Long = Long.parseLong(paramString);
        if (this.jdField_a_of_type_Long <= 0L) {
          continue;
        }
        paramBitmap = ReadInJoyUserInfoModule.a(this.jdField_a_of_type_Long, this);
        QLog.d(jdField_a_of_type_JavaLangString, 1, "[AggregateAvatarUrlDrawable] load aggregate avatar from 0xb81 userinfo success, uin:" + this.jdField_a_of_type_Long);
        if (paramBitmap == null) {
          continue;
        }
        a(ReadInJoyUserInfoModule.a(paramBitmap));
        return;
      }
      catch (NumberFormatException paramBitmap)
      {
        for (;;)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, paramBitmap.getMessage());
        }
      }
    }
  }
  
  public roy(Bitmap paramBitmap, String paramString, int paramInt1, Resources paramResources, int paramInt2)
  {
    a(paramBitmap, paramInt1, paramResources, paramInt2);
    a(paramString);
  }
  
  private void a()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "initAggregateIcon mode : " + this.jdField_b_of_type_Int);
    if ((this.d == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "has error !");
      return;
    }
    Bitmap localBitmap3;
    try
    {
      localBitmap3 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, 2130844136);
      if (localBitmap3 == null)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "initAggregateIcon: mask is null");
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "initAggregateIcon: ", localOutOfMemoryError);
      return;
    }
    Bitmap localBitmap2;
    if (this.jdField_b_of_type_Int == 1) {
      localBitmap2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    for (Bitmap localBitmap1 = this.d;; localBitmap1 = this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap = bbae.a(localBitmap2, localBitmap3, 0.0F, 1.0F);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, this.jdField_a_of_type_Int * 0.75F, this.jdField_a_of_type_Int * 0.75F);
      this.c = localBitmap1;
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, this.c.getWidth(), this.c.getHeight());
      this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Int * 0.52F, this.jdField_a_of_type_Int * 0.52F, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      return;
      localBitmap2 = this.d;
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      int i = this.jdField_a_of_type_Int;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      float f2 = i;
      if (this.jdField_b_of_type_Int == 1) {}
      for (float f1 = 0.52F;; f1 = 0.48F)
      {
        f1 *= f2;
        localURLDrawableOptions.mRequestWidth = Math.round(f1);
        localURLDrawableOptions.mRequestHeight = Math.round(f1);
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(this);
        this.jdField_a_of_type_ComTencentImageURLDrawable.setDecodeHandler(bavw.a);
        this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload();
        if ((this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() != null))
        {
          this.d = bbef.a(this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable());
          a();
        }
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.d = null;
    }
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
  
  public void a(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((!TextUtils.equals(paramString, String.valueOf(this.jdField_a_of_type_Long))) || (paramReadInJoyUserInfo == null)) {
      return;
    }
    a(ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo));
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onLoadUserInfoFailed");
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.d != null)
    {
      if ((this.c == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap == null)) {
        a();
      }
      if ((this.c != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null))
      {
        paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawBitmap(this.c, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getByteSize()
  {
    return Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, Bitmap.Config.ARGB_8888).getByteCount();
  }
  
  public int getOpacity()
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      return this.jdField_a_of_type_ComTencentImageURLDrawable.getOpacity();
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
    this.d = bbef.a(paramURLDrawable.getCurrDrawable());
    a();
    invalidateSelf();
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setAlpha(paramInt);
    }
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     roy
 * JD-Core Version:    0.7.0.1
 */