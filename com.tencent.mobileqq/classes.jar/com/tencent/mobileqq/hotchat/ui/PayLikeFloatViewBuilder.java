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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.io.File;

public class PayLikeFloatViewBuilder
  extends BaseFloatViewBuilder
{
  private static boolean jdField_a_of_type_Boolean = false;
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  
  public PayLikeFloatViewBuilder(Context paramContext, int paramInt, HeartAnimator paramHeartAnimator)
  {
    super(paramContext, paramInt, paramHeartAnimator);
  }
  
  private static Bitmap a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory().getAbsolutePath());
    ((StringBuilder)localObject1).append("/tencent/MobileQQ/.nearby/nearby_pay_zan_anim.png");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (new File((String)localObject1).exists())
    {
      paramQQAppInterface = new BitmapFactory.Options();
      paramQQAppInterface.inDensity = 320;
      paramQQAppInterface.inTargetDensity = paramContext.getResources().getDisplayMetrics().densityDpi;
    }
    try
    {
      paramContext = ImageUtil.a((String)localObject1, paramQQAppInterface);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext) {}
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      paramContext = new Bundle();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(".tmp");
      localObject2 = new DownloadTask("https://pub.idqqimg.com/pc/misc/nearby_pay_zan_anim.png", new File(((StringBuilder)localObject2).toString()));
      ((DownloadTask)localObject2).b = 2;
      ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1).startDownload((DownloadTask)localObject2, new PayLikeFloatViewBuilder.1((String)localObject1), paramContext);
    }
    return null;
    return null;
  }
  
  public Bitmap a()
  {
    super.a();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_Int);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label33:
      break label33;
    }
    return null;
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder
 * JD-Core Version:    0.7.0.1
 */