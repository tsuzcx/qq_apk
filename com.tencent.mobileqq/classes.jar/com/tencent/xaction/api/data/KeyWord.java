package com.tencent.xaction.api.data;

import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/KeyWord;", "", "keys", "", "", "drawableId", "", "hierarchy", "staticHierarchy", "anim", "Lcom/tencent/xaction/api/base/BaseAnim;", "status", "([Ljava/lang/String;IIILcom/tencent/xaction/api/base/BaseAnim;Ljava/lang/String;)V", "getAnim", "()Lcom/tencent/xaction/api/base/BaseAnim;", "getDrawableId", "()I", "getHierarchy", "getKeys", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getStaticHierarchy", "getStatus", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "([Ljava/lang/String;IIILcom/tencent/xaction/api/base/BaseAnim;Ljava/lang/String;)Lcom/tencent/xaction/api/data/KeyWord;", "equals", "", "other", "hashCode", "toString", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class KeyWord
{
  @NotNull
  private final BaseAnim anim;
  private final int drawableId;
  private final int hierarchy;
  @NotNull
  private final String[] keys;
  private final int staticHierarchy;
  @NotNull
  private final String status;
  
  public KeyWord(@NotNull String[] paramArrayOfString, int paramInt1, int paramInt2, int paramInt3, @NotNull BaseAnim paramBaseAnim, @NotNull String paramString)
  {
    this.keys = paramArrayOfString;
    this.drawableId = paramInt1;
    this.hierarchy = paramInt2;
    this.staticHierarchy = paramInt3;
    this.anim = paramBaseAnim;
    this.status = paramString;
  }
  
  @NotNull
  public final String[] component1()
  {
    return this.keys;
  }
  
  public final int component2()
  {
    return this.drawableId;
  }
  
  public final int component3()
  {
    return this.hierarchy;
  }
  
  public final int component4()
  {
    return this.staticHierarchy;
  }
  
  @NotNull
  public final BaseAnim component5()
  {
    return this.anim;
  }
  
  @NotNull
  public final String component6()
  {
    return this.status;
  }
  
  @NotNull
  public final KeyWord copy(@NotNull String[] paramArrayOfString, int paramInt1, int paramInt2, int paramInt3, @NotNull BaseAnim paramBaseAnim, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "keys");
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "anim");
    Intrinsics.checkParameterIsNotNull(paramString, "status");
    return new KeyWord(paramArrayOfString, paramInt1, paramInt2, paramInt3, paramBaseAnim, paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof KeyWord))
      {
        paramObject = (KeyWord)paramObject;
        if ((Intrinsics.areEqual(this.keys, paramObject.keys)) && (this.drawableId == paramObject.drawableId) && (this.hierarchy == paramObject.hierarchy) && (this.staticHierarchy == paramObject.staticHierarchy) && (Intrinsics.areEqual(this.anim, paramObject.anim)) && (Intrinsics.areEqual(this.status, paramObject.status))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final BaseAnim getAnim()
  {
    return this.anim;
  }
  
  public final int getDrawableId()
  {
    return this.drawableId;
  }
  
  public final int getHierarchy()
  {
    return this.hierarchy;
  }
  
  @NotNull
  public final String[] getKeys()
  {
    return this.keys;
  }
  
  public final int getStaticHierarchy()
  {
    return this.staticHierarchy;
  }
  
  @NotNull
  public final String getStatus()
  {
    return this.status;
  }
  
  public int hashCode()
  {
    Object localObject = this.keys;
    int k = 0;
    int i;
    if (localObject != null) {
      i = Arrays.hashCode((Object[])localObject);
    } else {
      i = 0;
    }
    int m = this.drawableId;
    int n = this.hierarchy;
    int i1 = this.staticHierarchy;
    localObject = this.anim;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.status;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return ((((i * 31 + m) * 31 + n) * 31 + i1) * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("KeyWord(keys=");
    localStringBuilder.append(Arrays.toString(this.keys));
    localStringBuilder.append(", drawableId=");
    localStringBuilder.append(this.drawableId);
    localStringBuilder.append(", hierarchy=");
    localStringBuilder.append(this.hierarchy);
    localStringBuilder.append(", staticHierarchy=");
    localStringBuilder.append(this.staticHierarchy);
    localStringBuilder.append(", anim=");
    localStringBuilder.append(this.anim);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.data.KeyWord
 * JD-Core Version:    0.7.0.1
 */