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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/ui/VasNinePathBitmap;", "Lcom/tencent/mobileqq/vas/ui/INinePathBitmap;", "()V", "mBitmap", "Landroid/graphics/Bitmap;", "mNinePatch", "Landroid/graphics/NinePatch;", "tempBounds", "Landroid/graphics/Rect;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "src", "bounds", "paint", "Landroid/graphics/Paint;", "drawBitmap", "bitmap", "drawNinePath", "ninePath", "getBitmap", "getHeight", "", "getNinePatchChunk", "", "getWidth", "isEmpty", "", "next", "cache", "recycle", "Companion", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
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
    } else {
      this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect1);
    }
    paramCanvas.drawBitmap(paramBitmap, this.jdField_a_of_type_AndroidGraphicsRect, paramRect2, paramPaint);
  }
  
  private final void a(NinePatch paramNinePatch, Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
    int i = paramNinePatch.getWidth();
    int j = paramNinePatch.getHeight();
    Triple localTriple = jdField_a_of_type_ComTencentMobileqqVasUiVasNinePathBitmap$Companion.a(i, j, paramRect);
    boolean bool1 = ((Boolean)localTriple.component1()).booleanValue();
    boolean bool2 = ((Boolean)localTriple.component2()).booleanValue();
    float f1 = ((Number)localTriple.component3()).floatValue();
    if ((!bool1) && (!bool2)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      paramCanvas.save();
      float f2;
      if (bool1)
      {
        f2 = 1 / f1;
        paramCanvas.scale(f2, f2);
        this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect.left, paramRect.top, (int)(paramRect.right + paramRect.width() * (f1 - 1.0F)), paramRect.top + j);
      }
      else
      {
        f2 = 1 / f1;
        paramCanvas.scale(f2, f2);
        this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect.left, paramRect.top, (int)(paramRect.right + paramRect.width() * (f1 - 1.0F)), paramRect.top + j);
      }
    }
    paramNinePatch.draw(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect, paramPaint);
    if (i != 0) {
      paramCanvas.restore();
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
    byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
    Object localObject = null;
    paramBitmap = localObject;
    if (arrayOfByte != null)
    {
      paramBitmap = localObject;
      if (NinePatch.isNinePatchChunk(arrayOfByte)) {
        paramBitmap = new NinePatch(this.jdField_a_of_type_AndroidGraphicsBitmap, arrayOfByte, null);
      }
    }
    this.jdField_a_of_type_AndroidGraphicsNinePatch = paramBitmap;
  }
  
  public void a(@NotNull Canvas paramCanvas, @Nullable Rect paramRect1, @NotNull Rect paramRect2, @NotNull Paint paramPaint)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    Intrinsics.checkParameterIsNotNull(paramRect2, "bounds");
    Intrinsics.checkParameterIsNotNull(paramPaint, "paint");
    if (paramRect2.height() == 0)
    {
      a();
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsNinePatch;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      a((NinePatch)localObject, paramCanvas, paramRect2, paramPaint);
      return;
    }
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      a((Bitmap)localObject, paramCanvas, paramRect1, paramRect2, paramPaint);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VasNinePathBitmap
 * JD-Core Version:    0.7.0.1
 */