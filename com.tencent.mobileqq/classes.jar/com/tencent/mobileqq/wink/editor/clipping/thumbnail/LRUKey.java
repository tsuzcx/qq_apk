package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import androidx.annotation.RequiresApi;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/LRUKey;", "", "assetPath", "", "time", "", "(Ljava/lang/String;J)V", "getAssetPath", "()Ljava/lang/String;", "getTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class LRUKey
{
  @NotNull
  private final String a;
  private final long b;
  
  public LRUKey(@NotNull String paramString, long paramLong)
  {
    this.a = paramString;
    this.b = paramLong;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((LRUKey)this == paramObject) {
      return true;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if ((Intrinsics.areEqual(getClass(), paramObject.getClass()) ^ true)) {
        return false;
      }
      paramObject = (LRUKey)paramObject;
      bool1 = bool2;
      if (this.b == paramObject.b)
      {
        bool1 = bool2;
        if (Intrinsics.areEqual(this.a, paramObject.a)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  @RequiresApi(19)
  public int hashCode()
  {
    return Objects.hash(new Object[] { this.a, Long.valueOf(this.b) });
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LRUKey(assetPath=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.thumbnail.LRUKey
 * JD-Core Version:    0.7.0.1
 */