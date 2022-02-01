package com.tencent.xaction.api.data;

import androidx.annotation.Keep;
import com.tencent.xaction.api.base.BaseAnim;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/data/KeyWord;", "", "keys", "", "", "drawableId", "", "hierarchy", "anim", "Lcom/tencent/xaction/api/base/BaseAnim;", "status", "([Ljava/lang/String;IILcom/tencent/xaction/api/base/BaseAnim;Ljava/lang/String;)V", "getAnim", "()Lcom/tencent/xaction/api/base/BaseAnim;", "getDrawableId", "()I", "getHierarchy", "getKeys", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "([Ljava/lang/String;IILcom/tencent/xaction/api/base/BaseAnim;Ljava/lang/String;)Lcom/tencent/xaction/api/data/KeyWord;", "equals", "", "other", "hashCode", "toString", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public final class KeyWord
{
  @NotNull
  private final BaseAnim anim;
  private final int drawableId;
  private final int hierarchy;
  @NotNull
  private final String[] keys;
  @NotNull
  private final String status;
  
  public KeyWord(@NotNull String[] paramArrayOfString, int paramInt1, int paramInt2, @NotNull BaseAnim paramBaseAnim, @NotNull String paramString)
  {
    this.keys = paramArrayOfString;
    this.drawableId = paramInt1;
    this.hierarchy = paramInt2;
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
  
  @NotNull
  public final BaseAnim component4()
  {
    return this.anim;
  }
  
  @NotNull
  public final String component5()
  {
    return this.status;
  }
  
  @NotNull
  public final KeyWord copy(@NotNull String[] paramArrayOfString, int paramInt1, int paramInt2, @NotNull BaseAnim paramBaseAnim, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfString, "keys");
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "anim");
    Intrinsics.checkParameterIsNotNull(paramString, "status");
    return new KeyWord(paramArrayOfString, paramInt1, paramInt2, paramBaseAnim, paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof KeyWord))
      {
        paramObject = (KeyWord)paramObject;
        if ((!Intrinsics.areEqual(this.keys, paramObject.keys)) || (this.drawableId != paramObject.drawableId) || (this.hierarchy != paramObject.hierarchy) || (!Intrinsics.areEqual(this.anim, paramObject.anim)) || (!Intrinsics.areEqual(this.status, paramObject.status))) {}
      }
    }
    else {
      return true;
    }
    return false;
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
  
  @NotNull
  public final String getStatus()
  {
    return this.status;
  }
  
  public int hashCode()
  {
    int k = 0;
    Object localObject = this.keys;
    int i;
    int m;
    int n;
    if (localObject != null)
    {
      i = Arrays.hashCode((Object[])localObject);
      m = this.drawableId;
      n = this.hierarchy;
      localObject = this.anim;
      if (localObject == null) {
        break label94;
      }
    }
    label94:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.status;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      return (j + ((i * 31 + m) * 31 + n) * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "KeyWord(keys=" + Arrays.toString(this.keys) + ", drawableId=" + this.drawableId + ", hierarchy=" + this.hierarchy + ", anim=" + this.anim + ", status=" + this.status + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.data.KeyWord
 * JD-Core Version:    0.7.0.1
 */