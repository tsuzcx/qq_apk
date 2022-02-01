package com.tencent.mobileqq.bubble;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.StateSet;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class VipBubbleDrawable
  extends Drawable
{
  private static final ColorFilter f = new ColorMatrixColorFilter(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -26.0F, 0.0F, 1.0F, 0.0F, 0.0F, -26.0F, 0.0F, 0.0F, 1.0F, 0.0F, -26.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
  private static int[] j = { 16842919 };
  public boolean a = false;
  public boolean b;
  public String c;
  private int d = 160;
  private Paint e;
  private int g;
  private int h;
  private boolean i;
  private Resources k;
  private Handler l;
  private boolean m = false;
  private boolean n = false;
  private String o;
  private int[] p;
  private String q;
  private boolean r;
  private NinePatch s;
  private NinePatch t;
  private int u;
  
  public VipBubbleDrawable(Resources paramResources, NinePatch paramNinePatch1, NinePatch paramNinePatch2, int paramInt)
  {
    this.k = paramResources;
    this.s = paramNinePatch1;
    this.t = paramNinePatch2;
    this.u = paramInt;
    this.e = new Paint();
    this.e.setDither(true);
    if (paramResources != null)
    {
      this.d = paramResources.getDisplayMetrics().densityDpi;
      this.g = AIOUtils.b(BubbleInfo.c(), paramResources);
      this.h = AIOUtils.b(57.0F, paramResources);
    }
  }
  
  private int a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    int i1 = paramBitmap.getRowBytes();
    return paramBitmap.getHeight() * i1;
  }
  
  private void a(Canvas paramCanvas)
  {
    if (paramCanvas == null) {
      return;
    }
    int i2 = 0;
    Object localObject1 = AIOUtils.a();
    ((StringBuilder)localObject1).append("bubblebg://");
    ((StringBuilder)localObject1).append("0_local_default_");
    ((StringBuilder)localObject1).append(this.b);
    localObject1 = ((StringBuilder)localObject1).toString();
    int i1 = i2;
    Object localObject2;
    if (GlobalImageCache.a != null)
    {
      localObject2 = (Pair)GlobalImageCache.a.get(localObject1);
      i1 = i2;
      if (localObject2 != null)
      {
        localObject2 = (NinePatch)((Pair)localObject2).first;
        i1 = i2;
        if (localObject2 != null)
        {
          ((NinePatch)localObject2).draw(paramCanvas, getBounds(), this.e);
          i1 = 1;
        }
      }
    }
    if (i1 == 0)
    {
      if (this.b) {
        i1 = 2130851944;
      } else {
        i1 = 2130852126;
      }
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inDensity = 320;
      ((BitmapFactory.Options)localObject2).inTargetDensity = this.k.getDisplayMetrics().densityDpi;
      try
      {
        a(paramCanvas, (String)localObject1, BitmapFactory.decodeResource(this.k, i1, (BitmapFactory.Options)localObject2));
        return;
      }
      catch (OutOfMemoryError paramCanvas)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("drawDefaultBubbleBg, decode default bubble bg error, bubbleId=");
        ((StringBuilder)localObject1).append(this.u);
        QLog.e("VipBubbleDrawable", 1, ((StringBuilder)localObject1).toString(), paramCanvas);
      }
    }
  }
  
  private void a(Canvas paramCanvas, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      Object localObject = paramBitmap.getNinePatchChunk();
      if (localObject != null)
      {
        localObject = new NinePatch(paramBitmap, (byte[])localObject, null);
        ((NinePatch)localObject).draw(paramCanvas, getBounds(), this.e);
        if (GlobalImageCache.a != null)
        {
          paramCanvas = new Pair(localObject, Integer.valueOf(a(paramBitmap)));
          GlobalImageCache.a.put(paramString, paramCanvas);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.r = paramBoolean;
    invalidateSelf();
  }
  
  public void a(boolean paramBoolean, String paramString1, int[] paramArrayOfInt, String paramString2)
  {
    this.m = paramBoolean;
    this.n = paramBoolean;
    if (this.m)
    {
      this.o = paramString1;
      this.p = paramArrayOfInt;
      this.q = paramString2;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.b = paramBoolean1;
    this.r = paramBoolean2;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.e.setColorFilter(f);
    } else {
      this.e.setColorFilter(null);
    }
    invalidateSelf();
  }
  
  public void c(boolean paramBoolean)
  {
    if (!this.n) {
      return;
    }
    this.m = paramBoolean;
    if (this.l == null) {
      this.l = new Handler(Looper.getMainLooper());
    }
    this.l.post(new VipBubbleDrawable.1(this));
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i1 = paramCanvas.save();
    if (this.r)
    {
      localObject = this.t;
      if (localObject != null) {}
    }
    else
    {
      localObject = this.s;
    }
    if (localObject != null)
    {
      if (this.b) {
        paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
      }
      ((NinePatch)localObject).draw(paramCanvas, getBounds(), this.e);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("draw, ninePatch null, use default, mUseAnimationBg=");
      ((StringBuilder)localObject).append(this.r);
      ((StringBuilder)localObject).append(", mNormalNinePatch=");
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append(", mAnimationNinePath");
      ((StringBuilder)localObject).append(this.t);
      ((StringBuilder)localObject).append(", bubbleId=");
      ((StringBuilder)localObject).append(this.u);
      ((StringBuilder)localObject).append(", drawable=");
      ((StringBuilder)localObject).append(this);
      QLog.e("VipBubbleDrawable", 1, ((StringBuilder)localObject).toString());
      a(paramCanvas);
    }
    paramCanvas.restoreToCount(i1);
    Object localObject = (HashMap)BubbleDiyFetcher.a().k.get(Integer.valueOf(this.u));
    if ((localObject != null) && (((HashMap)localObject).size() > 0))
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DiyBubbleConfig)((Iterator)localObject).next()).a(this, paramCanvas);
      }
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.h;
  }
  
  public int getIntrinsicWidth()
  {
    return this.g;
  }
  
  public int getOpacity()
  {
    Object localObject = this.s;
    if (localObject != null)
    {
      if (((NinePatch)localObject).hasAlpha()) {
        return -3;
      }
      return -1;
    }
    localObject = this.e;
    if ((localObject != null) && (((Paint)localObject).getAlpha() < 255)) {
      return -3;
    }
    return -1;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    boolean bool = StateSet.stateSetMatches(j, paramArrayOfInt);
    if (this.i != bool)
    {
      this.i = bool;
      if ((this.i) && (!this.a)) {
        this.e.setColorFilter(f);
      } else {
        this.e.setColorFilter(null);
      }
      this.a = false;
      invalidateSelf();
      return true;
    }
    return false;
  }
  
  public void setAlpha(int paramInt)
  {
    this.e.setAlpha(paramInt);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.VipBubbleDrawable
 * JD-Core Version:    0.7.0.1
 */