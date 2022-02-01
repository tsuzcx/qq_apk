package com.tencent.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
public class LayerImageView
  extends ImageView
{
  private LayerImageView.ChildBitmap[] a;
  private Bitmap b;
  private Bitmap.Config c;
  private boolean d;
  private Paint e;
  private int f;
  private boolean g;
  
  public LayerImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LayerImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LayerImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.d = false;
    this.e = new Paint();
    this.f = getResources().getDisplayMetrics().densityDpi;
    this.g = false;
  }
  
  private void b()
  {
    this.d = true;
  }
  
  private Bitmap.Config getConfig()
  {
    if (this.g) {
      return Bitmap.Config.ARGB_8888;
    }
    Bitmap.Config localConfig = this.c;
    if (localConfig != null) {
      return localConfig;
    }
    return Bitmap.Config.ARGB_8888;
  }
  
  public Bitmap getBitmap()
  {
    return this.b;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBitmaps(Bitmap[] paramArrayOfBitmap, boolean paramBoolean)
  {
    int j = 0;
    if (paramBoolean)
    {
      LayerImageView.ChildBitmap[] arrayOfChildBitmap = this.a;
      if (arrayOfChildBitmap != null)
      {
        int k = arrayOfChildBitmap.length;
        i = 0;
        while (i < k)
        {
          LayerImageView.ChildBitmap localChildBitmap = arrayOfChildBitmap[i];
          if (LayerImageView.ChildBitmap.a(localChildBitmap) != null) {
            LayerImageView.ChildBitmap.a(localChildBitmap).recycle();
          }
          i += 1;
        }
      }
    }
    this.a = new LayerImageView.ChildBitmap[paramArrayOfBitmap.length];
    int i = j;
    while (i < paramArrayOfBitmap.length)
    {
      this.a[i] = new LayerImageView.ChildBitmap(paramArrayOfBitmap[i], this.f, null);
      if ((this.c == null) || ((LayerImageView.ChildBitmap.b(this.a[i]) != null) && (LayerImageView.ChildBitmap.b(this.a[i]).ordinal() > this.c.ordinal()))) {
        this.c = LayerImageView.ChildBitmap.b(this.a[i]);
      }
      i += 1;
    }
    b();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.d = false;
    this.b = paramBitmap;
  }
  
  public void setLayerBitmap(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    LayerImageView.ChildBitmap[] arrayOfChildBitmap = this.a;
    LayerImageView.ChildBitmap localChildBitmap = arrayOfChildBitmap[paramInt];
    arrayOfChildBitmap[paramInt] = new LayerImageView.ChildBitmap(paramBitmap, this.f, null);
    if ((paramBoolean) && (LayerImageView.ChildBitmap.a(localChildBitmap) != null)) {
      LayerImageView.ChildBitmap.a(localChildBitmap).recycle();
    }
  }
  
  public void setLayerPadding(int paramInt, Rect paramRect)
  {
    LayerImageView.ChildBitmap.a(this.a[paramInt], paramRect);
    b();
  }
  
  public void setLayerPadding(Rect[] paramArrayOfRect)
  {
    if (paramArrayOfRect.length == this.a.length)
    {
      int i = 0;
      for (;;)
      {
        LayerImageView.ChildBitmap[] arrayOfChildBitmap = this.a;
        if (i >= arrayOfChildBitmap.length) {
          break;
        }
        LayerImageView.ChildBitmap.a(arrayOfChildBitmap[i], paramArrayOfRect[i]);
        i += 1;
      }
      b();
      return;
    }
    paramArrayOfRect = new IllegalArgumentException("padding must have the same size as input bitmaps");
    for (;;)
    {
      throw paramArrayOfRect;
    }
  }
  
  public void setLayerVisibility(int paramInt1, int paramInt2)
  {
    LayerImageView.ChildBitmap.a(this.a[paramInt1], paramInt2);
    b();
  }
  
  public void setNeedTransparent(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.LayerImageView
 * JD-Core Version:    0.7.0.1
 */