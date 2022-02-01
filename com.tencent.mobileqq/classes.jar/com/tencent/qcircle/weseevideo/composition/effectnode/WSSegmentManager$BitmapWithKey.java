package com.tencent.qcircle.weseevideo.composition.effectnode;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qcircle/weseevideo/composition/effectnode/WSSegmentManager$BitmapWithKey;", "", "bitmap", "Landroid/graphics/Bitmap;", "key", "", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class WSSegmentManager$BitmapWithKey
{
  @Nullable
  private final Bitmap bitmap;
  @NotNull
  private final String key;
  
  public WSSegmentManager$BitmapWithKey(@Nullable Bitmap paramBitmap, @NotNull String paramString)
  {
    this.bitmap = paramBitmap;
    this.key = paramString;
  }
  
  @Nullable
  public final Bitmap component1()
  {
    return this.bitmap;
  }
  
  @NotNull
  public final String component2()
  {
    return this.key;
  }
  
  @NotNull
  public final BitmapWithKey copy(@Nullable Bitmap paramBitmap, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    return new BitmapWithKey(paramBitmap, paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof BitmapWithKey))
      {
        paramObject = (BitmapWithKey)paramObject;
        if ((Intrinsics.areEqual(this.bitmap, paramObject.bitmap)) && (Intrinsics.areEqual(this.key, paramObject.key))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @Nullable
  public final Bitmap getBitmap()
  {
    return this.bitmap;
  }
  
  @NotNull
  public final String getKey()
  {
    return this.key;
  }
  
  public int hashCode()
  {
    Object localObject = this.bitmap;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.key;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BitmapWithKey(bitmap=");
    localStringBuilder.append(this.bitmap);
    localStringBuilder.append(", key=");
    localStringBuilder.append(this.key);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.composition.effectnode.WSSegmentManager.BitmapWithKey
 * JD-Core Version:    0.7.0.1
 */