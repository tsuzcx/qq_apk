package com.tencent.mobileqq.vas.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasNinePathBitmap;", "Lcom/tencent/mobileqq/vas/ui/INinePathBitmap;", "()V", "mBitmap", "Landroid/graphics/Bitmap;", "mNinePatch", "Landroid/graphics/NinePatch;", "tempBounds", "Landroid/graphics/Rect;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "src", "bounds", "paint", "Landroid/graphics/Paint;", "drawBitmap", "bitmap", "drawNinePath", "ninePath", "getBitmap", "getHeight", "", "getNinePatchChunk", "", "getWidth", "isEmpty", "", "next", "cache", "recycle", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasNinePathBitmap
  implements INinePathBitmap
{
  public static final VasNinePathBitmap.Companion a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private NinePatch jdField_a_of_type_AndroidGraphicsNinePatch;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasUiVasNinePathBitmap$Companion = new VasNinePathBitmap.Companion(null);
  }
  
  @JvmStatic
  @NotNull
  public static final Triple<Boolean, Boolean, Float> a(int paramInt1, int paramInt2, @NotNull Rect paramRect)
  {
    return jdField_a_of_type_ComTencentMobileqqVasUiVasNinePathBitmap$Companion.a(paramInt1, paramInt2, paramRect);
  }
  
  private final void a(Bitmap paramBitmap, Canvas paramCanvas, Rect paramRect1, Rect paramRect2, Paint paramPaint)
  {
    if (paramRect1 == null) {
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    }
    for (;;)
    {
      paramCanvas.drawBitmap(paramBitmap, this.jdField_a_of_type_AndroidGraphicsRect, paramRect2, paramPaint);
      return;
      this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect1);
    }
  }
  
  private final void a(NinePatch paramNinePatch, Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
    int i = paramNinePatch.getWidth();
    int j = paramNinePatch.getHeight();
    Object localObject = jdField_a_of_type_ComTencentMobileqqVasUiVasNinePathBitmap$Companion.a(i, j, paramRect);
    boolean bool1 = ((Boolean)((Triple)localObject).component1()).booleanValue();
    boolean bool2 = ((Boolean)((Triple)localObject).component2()).booleanValue();
    float f1 = ((Number)((Triple)localObject).component3()).floatValue();
    int k;
    int m;
    float f2;
    if ((bool1) || (bool2))
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        if (!bool1) {
          break label196;
        }
        paramCanvas.scale(1 / f1, 1 / f1);
        localObject = this.jdField_a_of_type_AndroidGraphicsRect;
        k = paramRect.left;
        m = paramRect.top;
        f2 = paramRect.right;
        ((Rect)localObject).set(k, m, (int)((f1 - 1.0F) * paramRect.width() + f2), j + paramRect.top);
      }
    }
    for (;;)
    {
      paramNinePatch.draw(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect, paramPaint);
      if (i != 0) {
        paramCanvas.restore();
      }
      return;
      i = 0;
      break;
      label196:
      paramCanvas.scale(1 / f1, 1 / f1);
      localObject = this.jdField_a_of_type_AndroidGraphicsRect;
      k = paramRect.left;
      m = paramRect.top;
      f2 = paramRect.right;
      ((Rect)localObject).set(k, m, (int)((f1 - 1.0F) * paramRect.width() + f2), j + paramRect.top);
    }
  }
  
  public final int a()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return localBitmap.getWidth();
    }
    return 0;
  }
  
  @Nullable
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)null);
  }
  
  public void a(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    paramBitmap = paramBitmap.getNinePatchChunk();
    if (paramBitmap != null) {
      if (NinePatch.isNinePatchChunk(paramBitmap)) {
        paramBitmap = new NinePatch(this.jdField_a_of_type_AndroidGraphicsBitmap, paramBitmap, null);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsNinePatch = paramBitmap;
      return;
      paramBitmap = null;
      continue;
      paramBitmap = null;
    }
  }
  
  public void a(@NotNull Canvas paramCanvas, @Nullable Rect paramRect1, @NotNull Rect paramRect2, @NotNull Paint paramPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramRect2, "bounds");
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    if (paramRect2.height() == 0) {
      a();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidGraphicsNinePatch != null)
      {
        paramRect1 = this.jdField_a_of_type_AndroidGraphicsNinePatch;
        if (paramRect1 == null) {
          Intrinsics.throwNpe();
        }
        a(paramRect1, paramCanvas, paramRect2, paramPaint);
        return;
      }
    } while (this.jdField_a_of_type_AndroidGraphicsBitmap == null);
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap == null) {
      Intrinsics.throwNpe();
    }
    a(localBitmap, paramCanvas, paramRect1, paramRect2, paramPaint);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap == null;
  }
  
  @Nullable
  public final byte[] a()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return localBitmap.getNinePatchChunk();
    }
    return null;
  }
  
  public final int b()
  {
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      return localBitmap.getHeight();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasNinePathBitmap
 * JD-Core Version:    0.7.0.1
 */