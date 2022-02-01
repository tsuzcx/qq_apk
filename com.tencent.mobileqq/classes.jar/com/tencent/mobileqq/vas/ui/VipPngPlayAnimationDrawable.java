package com.tencent.mobileqq.vas.ui;

import android.annotation.TargetApi;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.util.Utils;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class VipPngPlayAnimationDrawable
  extends Drawable
  implements Runnable
{
  private int jdField_a_of_type_Int = -1;
  public Resources a;
  public Bitmap a;
  protected Paint a;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public INinePathBitmap a;
  public VipPngPlayAnimationDrawable.DecodeNextFrameTask a;
  public Object a;
  public boolean a;
  private int b;
  public Handler b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e = 50;
  public int f;
  public int g;
  public int h = 0;
  public int i;
  public int j;
  
  public VipPngPlayAnimationDrawable(Resources paramResources)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_ComTencentMobileqqVasUiINinePathBitmap = new VipPngBitmap();
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int - 1)
    {
      this.h -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  @TargetApi(11)
  protected Bitmap a(int paramInt1, Object paramObject, int paramInt2)
  {
    Object localObject = new BitmapFactory.Options();
    if (paramInt1 != 0)
    {
      if ((paramInt1 != 1) && (paramInt1 != 2)) {
        return null;
      }
      paramObject = (int[])paramObject;
      paramInt1 = paramObject[((paramInt2 + 1) % paramObject.length)];
      return BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, paramInt1, (BitmapFactory.Options)localObject);
    }
    paramObject = (String[])paramObject;
    paramObject = paramObject[((paramInt2 + 1) % paramObject.length)];
    ((BitmapFactory.Options)localObject).inDensity = 320;
    ((BitmapFactory.Options)localObject).inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
    if (paramObject.startsWith("file:///android_assets/bubbles/"))
    {
      paramObject = paramObject.substring(23);
      paramObject = new BufferedInputStream(this.jdField_a_of_type_AndroidContentResResources.getAssets().open(paramObject));
    }
    else
    {
      paramObject = new BufferedInputStream(new FileInputStream(paramObject));
    }
    localObject = BitmapFactory.decodeStream(paramObject, null, (BitmapFactory.Options)localObject);
    try
    {
      paramObject.close();
      return localObject;
    }
    catch (IOException paramObject)
    {
      paramObject.printStackTrace();
    }
    return localObject;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasUiINinePathBitmap;
    if (localObject != null) {
      ((INinePathBitmap)localObject).a();
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      ((Bitmap)localObject).recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable$DecodeNextFrameTask;
    if (localObject != null)
    {
      ((VipPngPlayAnimationDrawable.DecodeNextFrameTask)localObject).cancel(false);
      this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable$DecodeNextFrameTask = null;
    }
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
    this.e = 50;
    this.h = -1;
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {
      super.invalidateSelf();
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((this.jdField_c_of_type_Int == 0) && (Arrays.equals((String[])this.jdField_a_of_type_JavaLangObject, paramArrayOfString))) {
      return;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    String str = paramArrayOfString[0];
    if (str.startsWith("file:///android_assets/bubbles/"))
    {
      paramArrayOfString = str.substring(23);
      paramArrayOfString = this.jdField_a_of_type_AndroidContentResResources.getAssets().open(paramArrayOfString);
      BitmapFactory.decodeStream(paramArrayOfString, null, localOptions);
      if (paramArrayOfString != null) {
        try
        {
          paramArrayOfString.close();
        }
        catch (IOException paramArrayOfString)
        {
          paramArrayOfString.printStackTrace();
        }
      }
    }
    else
    {
      paramArrayOfString = new BufferedInputStream(new FileInputStream(paramArrayOfString[0]));
      BitmapFactory.decodeStream(paramArrayOfString, null, localOptions);
      paramArrayOfString.close();
    }
    this.f = Utils.a(localOptions.outWidth, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
    this.g = Utils.a(localOptions.outHeight, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
    this.i = this.f;
    this.j = this.g;
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString != null)
    {
      if ((this.jdField_c_of_type_Int == 0) && (Arrays.equals((String[])this.jdField_a_of_type_JavaLangObject, paramArrayOfString))) {
        return;
      }
      a();
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangObject = paramArrayOfString;
      this.jdField_b_of_type_Int = paramArrayOfString.length;
      this.e = paramInt;
      this.jdField_d_of_type_Boolean = false;
    }
  }
  
  public boolean a()
  {
    return (!this.jdField_d_of_type_Boolean) && (this.jdField_d_of_type_Int >= 0);
  }
  
  protected void b()
  {
    if ((this.jdField_c_of_type_Int == 1) && (this.jdField_d_of_type_Int >= 0))
    {
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(this, this.e);
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.e;
      this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable$DecodeNextFrameTask = new VipPngPlayAnimationDrawable.DecodeNextFrameTask(this, this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_ComTencentMobileqqVasUiVipPngPlayAnimationDrawable$DecodeNextFrameTask.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.jdField_d_of_type_Int), Long.valueOf(this.jdField_c_of_type_Int) });
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_c_of_type_Int == -1) {
      return;
    }
    int k;
    if (this.jdField_d_of_type_Int != -1)
    {
      Rect localRect2 = super.getBounds();
      if (this.jdField_c_of_type_Boolean)
      {
        k = paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, localRect2.centerX(), localRect2.centerY());
      }
      else
      {
        k = 0;
      }
      int m = this.jdField_c_of_type_Int;
      if ((m != 1) && ((m == 0) || (m == 2)) && (this.jdField_a_of_type_ComTencentMobileqqVasUiINinePathBitmap != null))
      {
        Rect localRect1 = null;
        m = this.i;
        if (m > 0) {
          localRect1 = new Rect(0, 0, m, getIntrinsicHeight());
        }
        this.jdField_a_of_type_ComTencentMobileqqVasUiINinePathBitmap.a(paramCanvas, localRect1, localRect2, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (this.jdField_c_of_type_Boolean) {
        paramCanvas.restoreToCount(k);
      }
    }
    if (this.h == 0)
    {
      k = this.jdField_a_of_type_Int;
      if ((102 != k) && (103 != k)) {
        a();
      }
      super.invalidateSelf();
      this.jdField_d_of_type_Boolean = true;
      return;
    }
    b();
  }
  
  public int getIntrinsicHeight()
  {
    return this.g;
  }
  
  public int getIntrinsicWidth()
  {
    return this.f;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Int = a(this.jdField_d_of_type_Int);
    if ((this.jdField_c_of_type_Int != -1) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_ComTencentMobileqqVasUiINinePathBitmap.a() != this.jdField_a_of_type_AndroidGraphicsBitmap))
    {
      this.jdField_a_of_type_ComTencentMobileqqVasUiINinePathBitmap.a();
      this.jdField_a_of_type_ComTencentMobileqqVasUiINinePathBitmap.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      super.invalidateSelf();
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */