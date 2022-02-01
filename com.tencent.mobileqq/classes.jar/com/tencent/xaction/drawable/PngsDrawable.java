package com.tencent.xaction.drawable;

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
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.api.util.BitmapUtil;
import com.tencent.xaction.api.util.BitmapUtil.Companion;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/drawable/PngsDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/xaction/api/IDrawable;", "()V", "TAG", "", "currentBitmap", "Lcom/tencent/xaction/drawable/PngBitmap;", "getCurrentBitmap", "()Lcom/tencent/xaction/drawable/PngBitmap;", "decor", "Lcom/tencent/xaction/api/base/DecorDrawable;", "getDecor", "()Lcom/tencent/xaction/api/base/DecorDrawable;", "setDecor", "(Lcom/tencent/xaction/api/base/DecorDrawable;)V", "layoutHeight", "", "getLayoutHeight", "()I", "setLayoutHeight", "(I)V", "layoutWidth", "getLayoutWidth", "setLayoutWidth", "nextIndex", "getNextIndex", "setNextIndex", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "pngs", "", "getPngs", "()[Ljava/lang/String;", "setPngs", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "remainCount", "getRemainCount", "setRemainCount", "resources", "Landroid/content/res/Resources;", "getResources", "()Landroid/content/res/Resources;", "setResources", "(Landroid/content/res/Resources;)V", "decodeNextFrame", "", "draw", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "hasNextFrame", "", "scaleFromDensity", "size", "sdensity", "tdensity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class PngsDrawable
  extends Drawable
  implements IDrawable
{
  private transient int jdField_a_of_type_Int;
  @Nullable
  private transient Resources jdField_a_of_type_AndroidContentResResources;
  @NotNull
  private final transient Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  @Nullable
  private DecorDrawable jdField_a_of_type_ComTencentXactionApiBaseDecorDrawable;
  @NotNull
  private final transient PngBitmap jdField_a_of_type_ComTencentXactionDrawablePngBitmap = new PngBitmap();
  private final String jdField_a_of_type_JavaLangString = "PngsDrawable";
  @Nullable
  private transient String[] jdField_a_of_type_ArrayOfJavaLangString;
  private transient int b;
  private transient int c;
  private transient int d;
  
  private final int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt3 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  private final boolean a()
  {
    if ((this.jdField_a_of_type_AndroidContentResResources != null) && (this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.d < 3))
    {
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (arrayOfString == null) {
        Intrinsics.throwNpe();
      }
      if (arrayOfString.length > this.c) {
        return true;
      }
    }
    return false;
  }
  
  @Nullable
  public DecorDrawable a()
  {
    return this.jdField_a_of_type_ComTencentXactionApiBaseDecorDrawable;
  }
  
  public final void a()
  {
    if (!a()) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject3 = localObject1[this.c];
      this.c += 1;
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
      localObject2 = ((IMemoryLruCache)localObject1).a((String)localObject3);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label269;
      }
      localObject2 = new BitmapFactory.Options();
      localObject1 = BitmapUtil.a;
      Resources localResources = this.jdField_a_of_type_AndroidContentResResources;
      if (localResources == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((BitmapUtil.Companion)localObject1).a(localResources, (String)localObject3, (BitmapFactory.Options)localObject2, false, null);
      if (localObject1 != null) {
        break;
      }
      localObject1 = a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((DecorDrawable)localObject1).getEngine();
    } while (localObject1 == null);
    ((XAEngine)localObject1).logi(this.jdField_a_of_type_JavaLangString, 1, "next frame " + (String)localObject3 + " file is not exsit");
    return;
    int i = ((BitmapFactory.Options)localObject2).outWidth;
    Object localObject3 = this.jdField_a_of_type_AndroidContentResResources;
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_Int = a(i, 320, ((Resources)localObject3).getDisplayMetrics().densityDpi);
    i = ((BitmapFactory.Options)localObject2).outHeight;
    Object localObject2 = this.jdField_a_of_type_AndroidContentResResources;
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    this.b = a(i, 320, ((Resources)localObject2).getDisplayMetrics().densityDpi);
    label269:
    this.jdField_a_of_type_ComTencentXactionDrawablePngBitmap.a((Bitmap)localObject1);
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
  
  public void a(@Nullable DecorDrawable paramDecorDrawable)
  {
    this.jdField_a_of_type_ComTencentXactionApiBaseDecorDrawable = paramDecorDrawable;
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
    if (a() != null)
    {
      localObject = a();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((DecorDrawable)localObject).getMirror()) {
        paramCanvas.scale(-1.0F, 1.0F, paramCanvas.getWidth() / 2, paramCanvas.getHeight() / 2);
      }
    }
    Object localObject = (Rect)null;
    if (this.jdField_a_of_type_Int > 0) {
      localObject = new Rect(0, 0, this.jdField_a_of_type_Int, this.b);
    }
    this.jdField_a_of_type_ComTencentXactionDrawablePngBitmap.a(paramCanvas, (Rect)localObject, super.getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(i);
    this.d -= 1;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.drawable.PngsDrawable
 * JD-Core Version:    0.7.0.1
 */