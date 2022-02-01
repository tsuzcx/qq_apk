package com.tencent.xaction;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.DecorDrawableState;
import com.tencent.xaction.api.util.BitmapUtil;
import com.tencent.xaction.api.util.BitmapUtil.Companion;
import com.tencent.xaction.api.util.FileUtil;
import com.tencent.xaction.api.util.FileUtil.Companion;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/XAPhysicalDecorDrawable$XAPhysicalDecorDrawableState;", "Lcom/tencent/xaction/api/base/DecorDrawableState;", "()V", "count", "", "getCount", "()I", "setCount", "(I)V", "dirX", "", "getDirX", "()F", "setDirX", "(F)V", "dirY", "getDirY", "setDirY", "h", "getH", "setH", "hPx", "getHPx", "setHPx", "isDirectLeft", "", "()Z", "setDirectLeft", "(Z)V", "range", "getRange", "setRange", "startX", "getStartX", "setStartX", "startXPx", "getStartXPx", "setStartXPx", "startY", "getStartY", "setStartY", "startYPx", "getStartYPx", "setStartYPx", "textureList", "", "", "getTextureList", "()Ljava/util/List;", "setTextureList", "(Ljava/util/List;)V", "textures", "getTextures", "()Ljava/lang/String;", "setTextures", "(Ljava/lang/String;)V", "w", "getW", "setW", "wPx", "getWPx", "setWPx", "buildDrawable", "Lcom/tencent/xaction/api/IDrawable;", "getRandomTexture", "Landroid/graphics/Bitmap;", "res", "Landroid/content/res/Resources;", "init", "", "XAPhysical_release"}, k=1, mv={1, 1, 16})
@Keep
public final class XAPhysicalDecorDrawable$XAPhysicalDecorDrawableState
  extends DecorDrawableState
{
  private int count = 1;
  private float dirX;
  private float dirY;
  private int h;
  private transient int hPx;
  private boolean isDirectLeft;
  private int range = 70;
  private float startX;
  private transient float startXPx;
  private float startY;
  private transient float startYPx;
  @Nullable
  private transient List<String> textureList;
  @NotNull
  private String textures = "";
  private int w;
  private transient int wPx;
  
  @NotNull
  public IDrawable buildDrawable()
  {
    return buildDrawable(XAPhysicalDecorDrawable.class);
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final float getDirX()
  {
    return this.dirX;
  }
  
  public final float getDirY()
  {
    return this.dirY;
  }
  
  public final int getH()
  {
    return this.h;
  }
  
  public final int getHPx()
  {
    return this.hPx;
  }
  
  @Nullable
  public final Bitmap getRandomTexture(@NotNull Resources paramResources)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "res");
    Object localObject1 = this.textureList;
    if (localObject1 != null)
    {
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if ((((Collection)localObject1).isEmpty() ^ true))
      {
        localObject1 = this.textureList;
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        Object localObject2 = new Random();
        Object localObject3 = this.textureList;
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = (String)((List)localObject1).get(((Random)localObject2).nextInt(((List)localObject3).size()));
        localObject3 = new BitmapFactory.Options();
        boolean bool = FileUtil.a.b((String)localObject2);
        localObject1 = localObject2;
        if (bool) {
          localObject1 = FileUtil.a.a((String)localObject2);
        }
        return BitmapUtil.a.a(paramResources, (String)localObject1, (BitmapFactory.Options)localObject3, bool, new int[] { this.wPx, this.hPx });
      }
    }
    return null;
  }
  
  public final int getRange()
  {
    return this.range;
  }
  
  public final float getStartX()
  {
    return this.startX;
  }
  
  public final float getStartXPx()
  {
    return this.startXPx;
  }
  
  public final float getStartY()
  {
    return this.startY;
  }
  
  public final float getStartYPx()
  {
    return this.startYPx;
  }
  
  @Nullable
  public final List<String> getTextureList()
  {
    return this.textureList;
  }
  
  @NotNull
  public final String getTextures()
  {
    return this.textures;
  }
  
  public final int getW()
  {
    return this.w;
  }
  
  public final int getWPx()
  {
    return this.wPx;
  }
  
  public final void init()
  {
    this.startXPx = ScreenUnit.a.d(this.startX);
    this.startYPx = ScreenUnit.a.d(this.startY);
    this.wPx = ScreenUnit.a.a(this.w);
    this.hPx = ScreenUnit.a.a(this.h);
    if ((!TextUtils.isEmpty((CharSequence)this.textures)) && (StringsKt.indexOf$default((CharSequence)this.textures, "random:", 0, false, 6, null) == 0))
    {
      String str = this.textures;
      if (str != null)
      {
        str = str.substring(7);
        Intrinsics.checkExpressionValueIsNotNull(str, "(this as java.lang.String).substring(startIndex)");
        this.textureList = StringsKt.split$default((CharSequence)str, new String[] { "," }, false, 0, 6, null);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
  }
  
  public final boolean isDirectLeft()
  {
    return this.isDirectLeft;
  }
  
  public final void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public final void setDirX(float paramFloat)
  {
    this.dirX = paramFloat;
  }
  
  public final void setDirY(float paramFloat)
  {
    this.dirY = paramFloat;
  }
  
  public final void setDirectLeft(boolean paramBoolean)
  {
    this.isDirectLeft = paramBoolean;
  }
  
  public final void setH(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void setHPx(int paramInt)
  {
    this.hPx = paramInt;
  }
  
  public final void setRange(int paramInt)
  {
    this.range = paramInt;
  }
  
  public final void setStartX(float paramFloat)
  {
    this.startX = paramFloat;
  }
  
  public final void setStartXPx(float paramFloat)
  {
    this.startXPx = paramFloat;
  }
  
  public final void setStartY(float paramFloat)
  {
    this.startY = paramFloat;
  }
  
  public final void setStartYPx(float paramFloat)
  {
    this.startYPx = paramFloat;
  }
  
  public final void setTextureList(@Nullable List<String> paramList)
  {
    this.textureList = paramList;
  }
  
  public final void setTextures(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.textures = paramString;
  }
  
  public final void setW(int paramInt)
  {
    this.w = paramInt;
  }
  
  public final void setWPx(int paramInt)
  {
    this.wPx = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.XAPhysicalDecorDrawable.XAPhysicalDecorDrawableState
 * JD-Core Version:    0.7.0.1
 */