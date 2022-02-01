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
  protected int b;
  private ImageCache c;
  private boolean d = false;
  private Context e;
  private boolean f = false;
  private Handler g;
  private BitmapDrawable h = new BitmapDrawable();
  private Map<View, ImageWorker.Tag> i = new WeakHashMap();
  
  public ImageWorker(Context paramContext)
  {
    this.e = paramContext;
    this.c = new ImageCache(ReflectionUtil.b(paramContext) / 8);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    if ((k <= paramInt2) && (m <= paramInt1)) {
      return 1;
    }
    int j;
    if (m > k) {
      j = Math.round(k / paramInt2);
    } else {
      j = Math.round(m / paramInt1);
    }
    float f1 = m * k;
    float f2 = paramInt1 * paramInt2 * 2;
    while (f1 / (j * j) > f2) {
      j += 1;
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
      int j = paramInt1;
      if (paramInt1 <= 0) {
        j = localOptions.outWidth;
      }
      paramInt1 = paramInt2;
      if (paramInt2 <= 0) {
        paramInt1 = localOptions.outHeight;
      }
      localOptions.inSampleSize = a(localOptions, j, paramInt1);
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
      ImageWorker.Tag localTag = (ImageWorker.Tag)this.i.get(paramView);
      if (localTag != null) {
        paramView = localTag.b;
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
    if ((this.f) && (paramBoolean) && (!(paramDrawable instanceof AnimationDrawable)) && (paramDrawable != null))
    {
      paramDrawable = new TransitionDrawable(new Drawable[] { new ColorDrawable(17170445), paramDrawable });
      paramDrawable.startTransition(200);
    }
    ImageLoader localImageLoader = null;
    if (paramTag != null) {
      localImageLoader = paramTag.a;
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
    if ((this.a <= 0) && (this.b <= 0)) {
      paramString = BitmapManager.a(paramString);
    } else {
      paramString = a(paramString, this.a, this.b);
    }
    if (paramString != null) {
      return new BitmapDrawable(this.e.getResources(), paramString);
    }
    return null;
  }
  
  public ImageCache a()
  {
    return this.c;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.ImageWorker
 * JD-Core Version:    0.7.0.1
 */