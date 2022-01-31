package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import aqyh;
import aqyn;
import aqyq;
import bbdr;
import bbwg;
import bbwi;
import bbwl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;

public class PayLikeFloatViewBuilder
  extends aqyn
{
  private static boolean jdField_a_of_type_Boolean;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  
  public PayLikeFloatViewBuilder(Context paramContext, int paramInt, aqyh paramaqyh)
  {
    super(paramContext, paramInt, paramaqyh);
  }
  
  private static Bitmap a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    bbwg localbbwg = null;
    String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/.nearby/nearby_pay_zan_anim.png";
    if (new File(str).exists())
    {
      paramQQAppInterface = new BitmapFactory.Options();
      paramQQAppInterface.inDensity = 320;
      paramQQAppInterface.inTargetDensity = paramContext.getResources().getDisplayMetrics().densityDpi;
    }
    do
    {
      try
      {
        paramContext = bbdr.a(str, paramQQAppInterface);
        return paramContext;
      }
      catch (OutOfMemoryError paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
      paramContext = localbbwg;
    } while (jdField_a_of_type_Boolean);
    jdField_a_of_type_Boolean = true;
    paramContext = new Bundle();
    localbbwg = new bbwg("http://pub.idqqimg.com/pc/misc/nearby_pay_zan_anim.png", new File(str + ".tmp"));
    localbbwg.b = 2;
    ((bbwi)paramQQAppInterface.getManager(47)).a(1).a(localbbwg, new aqyq(str), paramContext);
    return null;
  }
  
  public Bitmap a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_Int);
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public Drawable[] a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable == null)
    {
      paramQQAppInterface = a(this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface);
      if (paramQQAppInterface == null) {
        return null;
      }
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = new Drawable[20];
      int j = paramQQAppInterface.getWidth();
      int k = paramQQAppInterface.getHeight() / 20;
      int i = 0;
      while (i < 20)
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramQQAppInterface, 0, i * k, j, k);
        this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i] = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
        i += 1;
      }
    }
    return this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder
 * JD-Core Version:    0.7.0.1
 */