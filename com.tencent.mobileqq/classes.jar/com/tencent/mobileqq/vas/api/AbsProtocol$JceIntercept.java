package com.tencent.mobileqq.vas.api;

import com.qq.taf.jce.JceStruct;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/api/AbsProtocol$JceIntercept;", "", "servantName", "", "cmd", "funcName", "block", "Lkotlin/Function1;", "Lcom/qq/taf/jce/JceStruct;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "getCmd", "()Ljava/lang/String;", "getFuncName", "getServantName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class AbsProtocol$JceIntercept
{
  @NotNull
  private final String a;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final Function1<JceStruct, JceStruct> d;
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  @NotNull
  public final Function1<JceStruct, JceStruct> d()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof JceIntercept))
      {
        paramObject = (JceIntercept)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.d;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JceIntercept(servantName=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", cmd=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", funcName=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", block=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.AbsProtocol.JceIntercept
 * JD-Core Version:    0.7.0.1
 */