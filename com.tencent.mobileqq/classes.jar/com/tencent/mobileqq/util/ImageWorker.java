package com.tencent.mobileqq.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.SafeBitmapFactory;
import java.util.Map;
import java.util.WeakHashMap;

public class ImageWorker
{
  protected int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageCache jdField_a_of_type_ComTencentMobileqqUtilImageCache;
  private Map<View, ImageWorker.Tag> jdField_a_of_type_JavaUtilMap = new WeakHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  protected int b;
  private boolean b;
  
  public ImageWorker(Context paramContext)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqUtilImageCache = new ImageCache(ReflectionUtil.a(paramContext) / 8);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    if ((j <= paramInt2) && (k <= paramInt1)) {
      return 1;
    }
    int i;
    if (k > j) {
      i = Math.round(j / paramInt2);
    } else {
      i = Math.round(k / paramInt1);
    }
    float f1 = k * j;
    float f2 = paramInt1 * paramInt2 * 2;
    while (f1 / (i * i) > f2) {
      i += 1;
    }
    return i;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      SafeBitmapFactory.decodeFile(paramString, localOptions);
      int i = paramInt1;
      if (paramInt1 <= 0) {
        i = localOptions.outWidth;
      }
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = localOptions.outHeight;
      }
      localOptions.inSampleSize = a(localOptions, i, paramInt1);
      localOptions.inJustDecodeBounds = false;
      paramString = BitmapManager.a(paramString, localOptions);
      return paramString;
    }
    finally {}
  }
  
  private ImageWorker.BitmapWorkerTask a(View paramView)
  {
    if (paramView != null)
    {
      ImageWorker.Tag localTag = (ImageWorker.Tag)this.jdField_a_of_type_JavaUtilMap.get(paramView);
      if (localTag != null) {
        paramView = localTag.jdField_a_of_type_ComTencentMobileqqUtilImageWorker$AsyncDrawable;
      } else if ((paramView instanceof ImageView)) {
        paramView = ((ImageView)paramView).getDrawable();
      } else {
        paramView = paramView.getBackground();
      }
      if ((paramView instanceof ImageWorker.AsyncDrawable)) {
        return ((ImageWorker.AsyncDrawable)paramView).a();
      }
    }
    return null;
  }
  
  private void a(boolean paramBoolean, View paramView, Drawable paramDrawable, ImageWorker.Tag paramTag)
  {
    if ((this.jdField_b_of_type_Boolean) && (paramBoolean) && (!(paramDrawable instanceof AnimationDrawable)) && (paramDrawable != null))
    {
      paramDrawable = new TransitionDrawable(new Drawable[] { new ColorDrawable(17170445), paramDrawable });
      paramDrawable.startTransition(200);
    }
    ImageLoader localImageLoader = null;
    if (paramTag != null) {
      localImageLoader = paramTag.jdField_a_of_type_ComTencentMobileqqUtilImageLoader;
    }
    if (localImageLoader != null)
    {
      localImageLoader.a(paramView, paramDrawable);
      return;
    }
    if ((paramView instanceof ImageView))
    {
      ((ImageView)paramView).setImageDrawable(paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public final Drawable a(String paramString)
  {
    if ((this.jdField_a_of_type_Int <= 0) && (this.jdField_b_of_type_Int <= 0)) {
      paramString = BitmapManager.a(paramString);
    } else {
      paramString = a(paramString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    if (paramString != null) {
      return new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramString);
    }
    return null;
  }
  
  public ImageCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUtilImageCache;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker
 * JD-Core Version:    0.7.0.1
 */