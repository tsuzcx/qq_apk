package com.tencent.mobileqq.guild.webview.methods;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/guild/webview/methods/CheckGuildTabOpenMethod$InvokeResult;", "", "result", "", "message", "", "interval", "(ILjava/lang/String;I)V", "getInterval", "()I", "setInterval", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getResult", "setResult", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toJson", "toString", "Companion", "qqguild-impl_release"}, k=1, mv={1, 1, 16})
final class CheckGuildTabOpenMethod$InvokeResult
{
  public static final CheckGuildTabOpenMethod.InvokeResult.Companion a = new CheckGuildTabOpenMethod.InvokeResult.Companion(null);
  @SerializedName("result")
  private int b;
  @SerializedName("msg")
  @Nullable
  private String c;
  @SerializedName("interval")
  private int d;
  
  public CheckGuildTabOpenMethod$InvokeResult()
  {
    this(0, null, 0, 7, null);
  }
  
  public CheckGuildTabOpenMethod$InvokeResult(int paramInt1, @Nullable String paramString, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramString;
    this.d = paramInt2;
  }
  
  @NotNull
  public final String a()
  {
    String str = new Gson().toJson(this);
    Intrinsics.checkExpressionValueIsNotNull(str, "Gson().toJson(this)");
    return str;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof InvokeResult))
      {
        paramObject = (InvokeResult)paramObject;
        if ((this.b == paramObject.b) && (Intrinsics.areEqual(this.c, paramObject.c)) && (this.d == paramObject.d)) {}
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
    int j = this.b;
    String str = this.c;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + i) * 31 + this.d;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InvokeResult(result=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", interval=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.webview.methods.CheckGuildTabOpenMethod.InvokeResult
 * JD-Core Version:    0.7.0.1
 */