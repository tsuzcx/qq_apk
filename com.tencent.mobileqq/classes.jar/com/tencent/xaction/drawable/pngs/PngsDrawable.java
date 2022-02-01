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
  private transient int jdField_a_of_type_Int;
  @Nullable
  private transient Resources jdField_a_of_type_AndroidContentResResources;
  @NotNull
  private final transient Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  @NotNull
  private final transient PngBitmap jdField_a_of_type_ComTencentXactionDrawablePngsPngBitmap = new PngBitmap();
  private IPublicDecorDrawable jdField_a_of_type_ComTencentXactionOpenapiApiIPublicDecorDrawable;
  private final String jdField_a_of_type_JavaLangString = "PngsDrawable";
  @Nullable
  private transient String[] jdField_a_of_type_ArrayOfJavaLangString;
  private transient int b;
  private transient int c;
  private transient int d;
  
  private final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 != 0)
    {
      i = paramInt1;
      if (paramInt3 != 0)
      {
        if (paramInt2 == paramInt3) {
          return paramInt1;
        }
        i = (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
      }
    }
    return i;
  }
  
  private final boolean a()
  {
    if (this.jdField_a_of_type_AndroidContentResResources != null)
    {
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      if ((arrayOfString != null) && (this.d < 3))
      {
        if (arrayOfString == null) {
          Intrinsics.throwNpe();
        }
        if (arrayOfString.length > this.c) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final void a()
  {
    if (!a()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    int i = this.c;
    Object localObject3 = localObject1[i];
    this.c = (i + 1);
    i = this.c;
    localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    if (i >= localObject1.length) {
      this.c = 0;
    }
    localObject1 = XAEngine.Companion.a();
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    Object localObject2 = ((IMemoryLruCache)localObject1).a((String)localObject3);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new BitmapFactory.Options();
      Resources localResources;
      if (FileUtil.a.a((String)localObject3))
      {
        localObject1 = BitmapUtil.a;
        localResources = this.jdField_a_of_type_AndroidContentResResources;
        if (localResources == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((BitmapUtil.Companion)localObject1).a(localResources, FileUtil.a.a((String)localObject3), (BitmapFactory.Options)localObject2, true, null);
      }
      else
      {
        localObject1 = BitmapUtil.a;
        localResources = this.jdField_a_of_type_AndroidContentResResources;
        if (localResources == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((BitmapUtil.Companion)localObject1).a(localResources, (String)localObject3, (BitmapFactory.Options)localObject2, false, null);
      }
      if (localObject1 == null) {
        return;
      }
      i = ((BitmapFactory.Options)localObject2).outWidth;
      localObject3 = this.jdField_a_of_type_AndroidContentResResources;
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      this.jdField_a_of_type_Int = a(i, 320, ((Resources)localObject3).getDisplayMetrics().densityDpi);
      i = ((BitmapFactory.Options)localObject2).outHeight;
      localObject2 = this.jdField_a_of_type_AndroidContentResResources;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      this.b = a(i, 320, ((Resources)localObject2).getDisplayMetrics().densityDpi);
    }
    this.jdField_a_of_type_ComTencentXactionDrawablePngsPngBitmap.a((Bitmap)localObject1);
    this.d += 1;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(@Nullable Resources paramResources)
  {
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
  }
  
  public final void a(@Nullable String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  @Nullable
  public final String[] a()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    int i = paramCanvas.save();
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
    int j = this.jdField_a_of_type_Int;
    if (j > 0) {
      localObject = new Rect(0, 0, j, this.b);
    }
    this.jdField_a_of_type_ComTencentXactionDrawablePngsPngBitmap.a(paramCanvas, (Rect)localObject, super.getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    this.d -= 1;
  }
  
  @Nullable
  public IPublicDecorDrawable getDecor()
  {
    return this.jdField_a_of_type_ComTencentXactionOpenapiApiIPublicDecorDrawable;
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
    this.jdField_a_of_type_ComTencentXactionOpenapiApiIPublicDecorDrawable = paramIPublicDecorDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.drawable.pngs.PngsDrawable
 * JD-Core Version:    0.7.0.1
 */