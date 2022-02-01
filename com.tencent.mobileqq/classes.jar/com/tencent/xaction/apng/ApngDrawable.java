package com.tencent.xaction.apng;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import com.tencent.image.AnimationCallback;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.ApngImage;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/apng/ApngDrawable;", "Landroid/graphics/drawable/Drawable;", "Lcom/tencent/image/AnimationCallback;", "Lcom/tencent/xaction/api/IDrawable;", "()V", "f", "Ljava/io/File;", "res", "Landroid/content/res/Resources;", "cacheStaticFrame", "", "(Ljava/io/File;Landroid/content/res/Resources;Z)V", "image", "Lcom/tencent/image/ApngImage;", "(Lcom/tencent/image/ApngImage;Landroid/content/res/Resources;)V", "chatWindowHeight", "", "decor", "Lcom/tencent/xaction/openapi/api/IPublicDecorDrawable;", "drawRect", "Landroid/graphics/Rect;", "gravity", "getGravity", "()I", "setGravity", "(I)V", "getImage", "()Lcom/tencent/image/ApngImage;", "mApngHeight", "mApngState", "Lcom/tencent/xaction/apng/ApngDrawable$ApngState;", "getMApngState", "()Lcom/tencent/xaction/apng/ApngDrawable$ApngState;", "setMApngState", "(Lcom/tencent/xaction/apng/ApngDrawable$ApngState;)V", "mApngWidth", "mDstRect", "mTargetDensity", "mUseAnimation", "getMUseAnimation", "()Z", "setMUseAnimation", "(Z)V", "reCalculateRects", "useRect", "computeImageSize", "", "draw", "canvas", "Landroid/graphics/Canvas;", "getConstantState", "Landroid/graphics/drawable/Drawable$ConstantState;", "getDecor", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "init", "apngState", "invalidateSelf", "onBoundsChange", "bounds", "pause", "removeOnPlayRepeatListener", "listener", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "repaly", "resume", "setAlpha", "alpha", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "setDecor", "decorDrawable", "setDither", "dither", "setFilterBitmap", "filter", "setOnPlayRepeatListener", "setTargetDensity", "density", "setUseRect", "param", "", "ApngState", "Companion", "OnPlayRepeatListener", "XAApng_release"}, k=1, mv={1, 1, 16})
public class ApngDrawable
  extends Drawable
  implements AnimationCallback, IDrawable
{
  public static final ApngDrawable.Companion Companion = new ApngDrawable.Companion(null);
  private static final byte[] SIGNATURE = { -119, 80, 78, 71, 13, 10, 26, 10 };
  private int chatWindowHeight;
  private IPublicDecorDrawable decor;
  private Rect drawRect;
  private int mApngHeight;
  @Nullable
  private ApngDrawable.ApngState mApngState;
  private int mApngWidth;
  private final Rect mDstRect = new Rect();
  private int mTargetDensity;
  private boolean mUseAnimation;
  private boolean reCalculateRects;
  private boolean useRect;
  
  public ApngDrawable() {}
  
  public ApngDrawable(@Nullable ApngImage paramApngImage, @Nullable Resources paramResources)
  {
    init(new ApngDrawable.ApngState(paramApngImage), paramResources);
    paramApngImage = this.mApngState;
    if (paramApngImage == null) {
      Intrinsics.throwNpe();
    }
    paramApngImage.b(this.mTargetDensity);
  }
  
  @JvmOverloads
  public ApngDrawable(@Nullable File paramFile, @Nullable Resources paramResources)
  {
    this(paramFile, paramResources, false, 4, null);
  }
  
  @JvmOverloads
  public ApngDrawable(@Nullable File paramFile, @Nullable Resources paramResources, boolean paramBoolean)
  {
    this(new ApngImage(paramFile, paramBoolean), paramResources);
  }
  
  private final void computeImageSize()
  {
    Object localObject = this.mApngState;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((ApngDrawable.ApngState)localObject).d();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    this.mApngWidth = ((ApngImage)localObject).getScaledWidth(this.mTargetDensity);
    localObject = this.mApngState;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((ApngDrawable.ApngState)localObject).d();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    this.mApngHeight = ((ApngImage)localObject).getScaledHeight(this.mTargetDensity);
  }
  
  public void draw(@NotNull Canvas paramCanvas)
  {
    Intrinsics.checkParameterIsNotNull(paramCanvas, "canvas");
    boolean bool = this.reCalculateRects;
    Rect localRect1 = null;
    if (bool)
    {
      if (this.useRect)
      {
        localObject = this.mApngState;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((ApngDrawable.ApngState)localObject).d();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        int i = ((ApngImage)localObject).width;
        localObject = this.mApngState;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((ApngDrawable.ApngState)localObject).d();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        int j = ((ApngImage)localObject).height;
        if ((j > 0) && (i > 0))
        {
          localObject = getBounds();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "this.bounds");
          if (this.chatWindowHeight < ((Rect)localObject).height()) {
            this.chatWindowHeight = ((Rect)localObject).height();
          }
          int k;
          if (this.chatWindowHeight / ((Rect)localObject).width() >= j / i)
          {
            k = ((Rect)localObject).width() * j / this.chatWindowHeight;
            int m = (int)(((Double)Integer.valueOf(i - k)).doubleValue() * 0.5D);
            i = j;
            if (this.chatWindowHeight > ((Rect)localObject).height()) {
              i = j * ((Rect)localObject).height() / this.chatWindowHeight;
            }
            this.drawRect = new Rect(m, 0, k + m, i);
          }
          else
          {
            k = ((Rect)localObject).height() * i / ((Rect)localObject).width();
            j = (int)(((Double)Integer.valueOf(j - this.chatWindowHeight * i / ((Rect)localObject).width())).doubleValue() * 0.5D);
            this.drawRect = new Rect(0, j, i, k + j);
          }
        }
        else
        {
          this.drawRect = ((Rect)null);
        }
      }
      localObject = this.mApngState;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      Gravity.apply(((ApngDrawable.ApngState)localObject).a(), this.mApngWidth, this.mApngHeight, getBounds(), this.mDstRect);
      this.reCalculateRects = false;
    }
    Object localObject = this.mApngState;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((ApngDrawable.ApngState)localObject).d();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    if (this.useRect) {
      localRect1 = this.drawRect;
    }
    Rect localRect2 = this.mDstRect;
    ApngDrawable.ApngState localApngState = this.mApngState;
    if (localApngState == null) {
      Intrinsics.throwNpe();
    }
    ((ApngImage)localObject).draw(paramCanvas, localRect1, localRect2, localApngState.c(), this.mUseAnimation);
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    return (Drawable.ConstantState)this.mApngState;
  }
  
  @Nullable
  public IPublicDecorDrawable getDecor()
  {
    return this.decor;
  }
  
  public final int getGravity()
  {
    ApngDrawable.ApngState localApngState = this.mApngState;
    if (localApngState == null) {
      Intrinsics.throwNpe();
    }
    return localApngState.a();
  }
  
  @Nullable
  public final ApngImage getImage()
  {
    ApngDrawable.ApngState localApngState = this.mApngState;
    if (localApngState == null) {
      Intrinsics.throwNpe();
    }
    return localApngState.d();
  }
  
  public int getIntrinsicHeight()
  {
    return this.mApngHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mApngWidth;
  }
  
  @Nullable
  public final ApngDrawable.ApngState getMApngState()
  {
    return this.mApngState;
  }
  
  public final boolean getMUseAnimation()
  {
    return this.mUseAnimation;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  @NotNull
  public final ApngDrawable init(@NotNull ApngDrawable.ApngState paramApngState, @Nullable Resources paramResources)
  {
    Intrinsics.checkParameterIsNotNull(paramApngState, "apngState");
    this.mUseAnimation = true;
    this.reCalculateRects = true;
    this.mTargetDensity = 160;
    this.mApngState = paramApngState;
    ApngImage localApngImage = paramApngState.d();
    if (localApngImage == null) {
      Intrinsics.throwNpe();
    }
    localApngImage.addCallBack((AnimationCallback)this);
    localApngImage = paramApngState.d();
    if (localApngImage == null) {
      Intrinsics.throwNpe();
    }
    if (localApngImage.mGetResetLoop)
    {
      localApngImage = paramApngState.d();
      if (localApngImage == null) {
        Intrinsics.throwNpe();
      }
      localApngImage.currentApngLoop = 0;
    }
    if (paramResources != null) {
      this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;
    } else {
      this.mTargetDensity = paramApngState.b();
    }
    computeImageSize();
    return this;
  }
  
  public void invalidateSelf()
  {
    super.invalidateSelf();
  }
  
  protected void onBoundsChange(@NotNull Rect paramRect)
  {
    Intrinsics.checkParameterIsNotNull(paramRect, "bounds");
    super.onBoundsChange(paramRect);
    this.reCalculateRects = true;
  }
  
  public final void pause()
  {
    ApngImage localApngImage = getImage();
    if (localApngImage != null) {
      localApngImage.pause();
    }
  }
  
  public final void removeOnPlayRepeatListener(@Nullable ApngDrawable.OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    Object localObject = this.mApngState;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((ApngDrawable.ApngState)localObject).d() != null)
      {
        localObject = this.mApngState;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((ApngDrawable.ApngState)localObject).d();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        ((ApngImage)localObject).removeOnPlayRepeatListener(paramOnPlayRepeatListener);
      }
    }
  }
  
  public final void repaly()
  {
    ApngImage localApngImage = getImage();
    if (localApngImage != null) {
      localApngImage.replay();
    }
  }
  
  public final void resume()
  {
    ApngImage localApngImage = getImage();
    if (localApngImage != null) {
      localApngImage.resume();
    }
  }
  
  public void setAlpha(int paramInt)
  {
    ApngDrawable.ApngState localApngState = this.mApngState;
    if (localApngState == null) {
      Intrinsics.throwNpe();
    }
    localApngState.c().setAlpha(paramInt);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    ApngDrawable.ApngState localApngState = this.mApngState;
    if (localApngState == null) {
      Intrinsics.throwNpe();
    }
    localApngState.c().setColorFilter(paramColorFilter);
  }
  
  public void setDecor(@NotNull IPublicDecorDrawable paramIPublicDecorDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramIPublicDecorDrawable, "decorDrawable");
    this.decor = paramIPublicDecorDrawable;
  }
  
  public void setDither(boolean paramBoolean)
  {
    ApngDrawable.ApngState localApngState = this.mApngState;
    if (localApngState == null) {
      Intrinsics.throwNpe();
    }
    localApngState.c().setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    ApngDrawable.ApngState localApngState = this.mApngState;
    if (localApngState == null) {
      Intrinsics.throwNpe();
    }
    localApngState.c().setFilterBitmap(paramBoolean);
  }
  
  public final void setGravity(int paramInt)
  {
    ApngDrawable.ApngState localApngState = this.mApngState;
    if (localApngState == null) {
      Intrinsics.throwNpe();
    }
    localApngState.a(paramInt);
    this.reCalculateRects = true;
  }
  
  public final void setMApngState(@Nullable ApngDrawable.ApngState paramApngState)
  {
    this.mApngState = paramApngState;
  }
  
  public final void setMUseAnimation(boolean paramBoolean)
  {
    this.mUseAnimation = paramBoolean;
  }
  
  public final void setOnPlayRepeatListener(@Nullable ApngDrawable.OnPlayRepeatListener paramOnPlayRepeatListener)
  {
    Object localObject = this.mApngState;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((ApngDrawable.ApngState)localObject).d() != null)
      {
        localObject = this.mApngState;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((ApngDrawable.ApngState)localObject).d();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        ((ApngImage)localObject).setOnPlayRepeatListener(paramOnPlayRepeatListener);
      }
    }
  }
  
  public final void setTargetDensity(int paramInt)
  {
    if (paramInt != this.mTargetDensity)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      computeImageSize();
      invalidateSelf();
    }
  }
  
  public final void setUseRect(@Nullable Object paramObject)
  {
    if (paramObject != null)
    {
      this.useRect = ((Bundle)paramObject).getBoolean("key_use_rect", false);
      this.reCalculateRects = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.ApngDrawable
 * JD-Core Version:    0.7.0.1
 */