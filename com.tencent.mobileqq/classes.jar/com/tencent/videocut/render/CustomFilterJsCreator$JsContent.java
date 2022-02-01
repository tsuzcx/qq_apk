package com.tencent.videocut.render;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/render/CustomFilterJsCreator$JsContent;", "", "uniformCode", "", "initCode", "updateCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInitCode", "()Ljava/lang/String;", "getUniformCode", "getUpdateCode", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class CustomFilterJsCreator$JsContent
{
  public static final CustomFilterJsCreator.JsContent.Companion a = new CustomFilterJsCreator.JsContent.Companion(null);
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof JsContent))
      {
        paramObject = (JsContent)paramObject;
        if ((Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    String str = this.b;
    int k = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.c;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.d;
    if (str != null) {
      k = str.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JsContent(uniformCode=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", initCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", updateCode=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.render.CustomFilterJsCreator.JsContent
 * JD-Core Version:    0.7.0.1
 */