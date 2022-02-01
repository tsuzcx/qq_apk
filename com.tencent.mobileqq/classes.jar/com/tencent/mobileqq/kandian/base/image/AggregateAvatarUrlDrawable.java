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
  private static String a = "AggregateAvatarUrlDrawable";
  private Bitmap b;
  private Rect c;
  private RectF d;
  private Rect e;
  private RectF f;
  private Paint g;
  private Bitmap h;
  private Bitmap i;
  private URLDrawable j;
  private volatile Bitmap k;
  private long l;
  private Resources m;
  private int n;
  private final float o = 0.48F;
  private int p = 1;
  
  public AggregateAvatarUrlDrawable(Bitmap paramBitmap, int paramInt1, Resources paramResources, String paramString, int paramInt2)
  {
    a(paramBitmap, paramInt1, paramResources, paramInt2);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.n = paramInt1;
    this.m = paramResources;
    try
    {
      this.l = Long.parseLong(paramString);
      return;
    }
    catch (NumberFormatException paramBitmap)
    {
      QLog.d(a, 2, paramBitmap.getMessage());
    }
  }
  
  public AggregateAvatarUrlDrawable(Bitmap paramBitmap, String paramString, int paramInt1, Resources paramResources, int paramInt2)
  {
    a(paramBitmap, paramInt1, paramResources, paramInt2);
    a(paramString);
  }
  
  private void a()
  {
    Object localObject1 = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initAggregateIcon mode : ");
    ((StringBuilder)localObject2).append(this.p);
    QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    if ((this.k != null) && (this.b != null)) {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource(this.m, 2130846388);
        if (localBitmap == null)
        {
          QLog.e(a, 2, "initAggregateIcon: mask is null");
          return;
        }
        if (this.p == 1)
        {
          localObject1 = this.b;
          localObject2 = this.k;
        }
        else
        {
          localObject1 = this.k;
          localObject2 = this.b;
        }
        this.h = PuzzleAvatarUtil.a((Bitmap)localObject1, localBitmap, 0.0F, 1.0F);
        this.c = new Rect(0, 0, this.h.getWidth(), this.h.getHeight());
        this.d = new RectF(0.0F, 0.0F, this.n * 0.75F, this.n * 0.75F);
        this.i = ((Bitmap)localObject2);
        this.e = new Rect(0, 0, this.i.getWidth(), this.i.getHeight());
        this.f = new RectF(this.n * 0.52F, this.n * 0.52F, this.n, this.n);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e(a, 2, "initAggregateIcon: ", localOutOfMemoryError);
        return;
      }
    }
    QLog.d(a, 2, "has error !");
  }
  
  public void a(Bitmap paramBitmap, int paramInt1, Resources paramResources, int paramInt2)
  {
    this.b = paramBitmap;
    this.n = paramInt1;
    this.m = paramResources;
    this.p = paramInt2;
    this.g = new Paint();
    this.g.setAntiAlias(true);
    this.g.setDither(true);
    this.g.setFilterBitmap(true);
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        int i1 = this.n;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        float f2 = i1;
        if (this.p != 1) {
          break label142;
        }
        f1 = 0.52F;
        f1 = f2 * f1;
        localURLDrawableOptions.mRequestWidth = Math.round(f1);
        localURLDrawableOptions.mRequestHeight = Math.round(f1);
        this.j = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        this.j.setURLDrawableListener(this);
        this.j.setDecodeHandler(URLDrawableDecodeHandler.b);
        this.j.startDownload();
        if ((this.j.getStatus() == 1) && (this.j.getCurrDrawable() != null))
        {
          this.k = ImageUtil.a(this.j.getCurrDrawable());
          a();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        this.j = null;
        this.k = null;
      }
      return;
      label142:
      float f1 = 0.48F;
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.k != null)
    {
      if ((this.i == null) || (this.h == null)) {
        a();
      }
      if (this.i != null)
      {
        Bitmap localBitmap = this.h;
        if (localBitmap != null)
        {
          paramCanvas.drawBitmap(localBitmap, this.c, this.d, this.g);
          paramCanvas.drawBitmap(this.i, this.e, this.f, this.g);
          return;
        }
      }
      paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, this.g);
      return;
    }
    paramCanvas.drawBitmap(this.b, 0.0F, 0.0F, this.g);
  }
  
  public int getByteSize()
  {
    int i1 = this.n;
    return Bitmap.createBitmap(i1, i1, Bitmap.Config.ARGB_8888).getByteCount();
  }
  
  public int getOpacity()
  {
    URLDrawable localURLDrawable = this.j;
    if (localURLDrawable != null) {
      return localURLDrawable.getOpacity();
    }
    return 0;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d(a, 2, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d(a, 2, "onLoadFailed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d(a, 2, "onLoadSuccessed");
    this.k = ImageUtil.a(paramURLDrawable.getCurrDrawable());
    a();
    invalidateSelf();
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt)
  {
    URLDrawable localURLDrawable = this.j;
    if (localURLDrawable != null) {
      localURLDrawable.setAlpha(paramInt);
    }
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    URLDrawable localURLDrawable = this.j;
    if (localURLDrawable != null) {
      localURLDrawable.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.AggregateAvatarUrlDrawable
 * JD-Core Version:    0.7.0.1
 */