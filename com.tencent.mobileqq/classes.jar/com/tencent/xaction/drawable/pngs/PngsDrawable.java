package com.tencent.xaction.drawable.pngs;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.IMemoryLruCache;
import com.tencent.xaction.api.util.BitmapUtil;
import com.tencent.xaction.api.util.BitmapUtil.Companion;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import com.tencent.xaction.log.QLog;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/pngs/PngsDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/xaction/api/IDrawable;", "()V", "TAG", "", "currentBitmap", "Lcom/tencent/xaction/drawable/pngs/PngBitmap;", "getCurrentBitmap", "()Lcom/tencent/xaction/drawable/pngs/PngBitmap;", "decor", "Lcom/tencent/xaction/openapi/api/IPublicDecorDrawable;", "layoutHeight", "", "getLayoutHeight", "()I", "setLayoutHeight", "(I)V", "layoutWidth", "getLayoutWidth", "setLayoutWidth", "nextIndex", "getNextIndex", "setNextIndex", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "pngs", "", "getPngs", "()[Ljava/lang/String;", "setPngs", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "remainCount", "getRemainCount", "setRemainCount", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "setResources", "(Landroid/content/res/Resources;)V", "decodeNextFrame", "", "draw", "canvas", "Landroid/graphics/Canvas;", "getDecor", "getOpacity", "hasNextFrame", "", "scaleFromDensity", "size", "sdensity", "tdensity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setDecor", "decorDrawable", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class PngsDrawable
  extends Drawable
  implements IDrawable
{
  private final String a = "PngsDrawable";
  private IPublicDecorDrawable b;
  @Nullable
  private transient Resources c;
  @NotNull
  private final transient PngBitmap d = new PngBitmap();
  @NotNull
  private final transient Paint e = new Paint(6);
  private transient int f;
  private transient int g;
  @Nullable
  private transient String[] h;
  private transient int i;
  private transient int j;
  
  private final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = paramInt1;
    if (paramInt2 != 0)
    {
      k = paramInt1;
      if (paramInt3 != 0)
      {
        if (paramInt2 == paramInt3) {
          return paramInt1;
        }
        k = (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
      }
    }
    return k;
  }
  
  private final boolean c()
  {
    if (this.c != null)
    {
      String[] arrayOfString = this.h;
      if ((arrayOfString != null) && (this.j < 3))
      {
        if (arrayOfString == null) {
          Intrinsics.throwNpe();
        }
        if (arrayOfString.length > this.i) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public final void a(@Nullable Resources paramResources)
  {
    this.c = paramResources;
  }
  
  public final void a(@Nullable String[] paramArrayOfString)
  {
    this.h = paramArrayOfString;
  }
  
  @Nullable
  public final String[] a()
  {
    return this.h;
  }
  
  public final void b()
  {
    if (!c()) {
      return;
    }
    try
    {
      Object localObject1 = this.h;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject3 = String.valueOf(localObject1[this.i]);
      this.i += 1;
      int k = this.i;
      localObject1 = this.h;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (k >= localObject1.length) {
        this.i = 0;
      }
      localObject1 = XAEngine.Companion.e();
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((IMemoryLruCache)localObject1).a((String)localObject3);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new BitmapFactory.Options();
        if (FileUtil.a.b((String)localObject3))
        {
          localObject1 = BitmapUtil.a;
          localObject4 = this.c;
          if (localObject4 == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = ((BitmapUtil.Companion)localObject1).b((Resources)localObject4, FileUtil.a.a((String)localObject3), (BitmapFactory.Options)localObject2, true, null);
        }
        else
        {
          localObject1 = BitmapUtil.a;
          localObject4 = this.c;
          if (localObject4 == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = ((BitmapUtil.Companion)localObject1).b((Resources)localObject4, (String)localObject3, (BitmapFactory.Options)localObject2, false, null);
        }
        if (localObject1 == null) {
          return;
        }
        k = ((BitmapFactory.Options)localObject2).outWidth;
        localObject3 = this.c;
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        this.f = a(k, 320, ((Resources)localObject3).getDisplayMetrics().densityDpi);
        k = ((BitmapFactory.Options)localObject2).outHeight;
        localObject2 = this.c;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        this.g = a(k, 320, ((Resources)localObject2).getDisplayMetrics().densityDpi);
      }
      this.d.a((Bitmap)localObject1);
      this.j += 1;
      return;
    }
    catch (Exception localException)
    {
      Object localObject2 = this.a;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("pngs size:");
      Object localObject4 = this.h;
      if (localObject4 == null) {
        Intrinsics.throwNpe();
      }
      ((StringBuilder)localObject3).append(localObject4.length);
      ((StringBuilder)localObject3).append(" nextIndex:");
      ((StringBuilder)localObject3).append(this.i);
      QLog.a((String)localObject2, 1, ((StringBuilder)localObject3).toString(), (Throwable)localException);
    }
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    int k = paramCanvas.save();
    if (getDecor() != null)
    {
      localObject = getDecor();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((IPublicDecorDrawable)localObject).getMirror()) {
        paramCanvas.scale(-1.0F, 1.0F, paramCanvas.getWidth() / 2, paramCanvas.getHeight() / 2);
      }
    }
    Object localObject = (Rect)null;
    int m = this.f;
    if (m > 0) {
      localObject = new Rect(0, 0, m, this.g);
    }
    this.d.a(paramCanvas, (Rect)localObject, super.getBounds(), this.e);
    paramCanvas.restoreToCount(k);
    this.j -= 1;
  }
  
  @Nullable
  public IPublicDecorDrawable getDecor()
  {
    return this.b;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
  
  public void setDecor(@NotNull IPublicDecorDrawable paramIPublicDecorDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublicDecorDrawable, "decorDrawable");
    this.b = paramIPublicDecorDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.drawable.pngs.PngsDrawable
 * JD-Core Version:    0.7.0.1
 */