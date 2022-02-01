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
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      if (m > k) {}
      for (int i = Math.round(k / paramInt2);; i = Math.round(m / paramInt1))
      {
        float f1 = k * m;
        float f2 = paramInt1 * paramInt2 * 2;
        for (;;)
        {
          j = i;
          if (f1 / (i * i) <= f2) {
            break;
          }
          i += 1;
        }
      }
    }
    return j;
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
      }
      while ((paramView instanceof ImageWorker.AsyncDrawable))
      {
        return ((ImageWorker.AsyncDrawable)paramView).a();
        if ((paramView instanceof ImageView)) {
          paramView = ((ImageView)paramView).getDrawable();
        } else {
          paramView = paramView.getBackground();
        }
      }
    }
    return null;
  }
  
  private void a(boolean paramBoolean, View paramView, Drawable paramDrawable, ImageWorker.Tag paramTag)
  {
    Object localObject = paramDrawable;
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = paramDrawable;
      if (paramBoolean)
      {
        localObject = paramDrawable;
        if (!(paramDrawable instanceof AnimationDrawable))
        {
          localObject = paramDrawable;
          if (paramDrawable != null)
          {
            localObject = new TransitionDrawable(new Drawable[] { new ColorDrawable(17170445), paramDrawable });
            ((TransitionDrawable)localObject).startTransition(200);
          }
        }
      }
    }
    paramDrawable = null;
    if (paramTag != null) {
      paramDrawable = paramTag.jdField_a_of_type_ComTencentMobileqqUtilImageLoader;
    }
    if (paramDrawable != null)
    {
      paramDrawable.a(paramView, (Drawable)localObject);
      return;
    }
    if ((paramView instanceof ImageView))
    {
      ((ImageView)paramView).setImageDrawable((Drawable)localObject);
      return;
    }
    paramView.setBackgroundDrawable((Drawable)localObject);
  }
  
  public final Drawable a(String paramString)
  {
    BitmapDrawable localBitmapDrawable = null;
    if ((this.jdField_a_of_type_Int > 0) || (this.jdField_b_of_type_Int > 0)) {}
    for (paramString = a(paramString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);; paramString = BitmapManager.a(paramString))
    {
      if (paramString != null) {
        localBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), paramString);
      }
      return localBitmapDrawable;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker
 * JD-Core Version:    0.7.0.1
 */