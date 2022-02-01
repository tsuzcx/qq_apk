package com.tencent.timi.game.liveroom.impl.view.operation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/operation/OperationItem;", "", "pic", "", "jumpType", "jumpUrl", "view", "scene", "priority", "", "iAdId", "isRedPacket", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V", "getIAdId", "()I", "setIAdId", "(I)V", "()Z", "setRedPacket", "(Z)V", "getJumpType", "()Ljava/lang/String;", "setJumpType", "(Ljava/lang/String;)V", "getJumpUrl", "setJumpUrl", "getPic", "setPic", "getPriority", "setPriority", "getScene", "setScene", "getView", "setView", "compareTo", "other", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "hashCode", "toString", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class OperationItem
  implements Comparable<OperationItem>
{
  @NotNull
  private String a;
  @NotNull
  private String b;
  @NotNull
  private String c;
  @NotNull
  private String d;
  @NotNull
  private String e;
  private int f;
  private int g;
  private boolean h;
  
  public OperationItem()
  {
    this(null, null, null, null, null, 0, 0, false, 255, null);
  }
  
  public OperationItem(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramBoolean;
  }
  
  public int a(@NotNull OperationItem paramOperationItem)
  {
    Intrinsics.checkParameterIsNotNull(paramOperationItem, "other");
    int i = this.f - paramOperationItem.f;
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    return 0;
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.a = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  public final void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.d = paramString;
  }
  
  public final int e()
  {
    return this.g;
  }
  
  public final void e(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.e = paramString;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof OperationItem))
      {
        paramObject = (OperationItem)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e)) && (this.f == paramObject.f) && (this.g == paramObject.g) && (this.h == paramObject.h)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean f()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OperationItem(pic=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", jumpType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", jumpUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", view=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", scene=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", priority=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", iAdId=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", isRedPacket=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.OperationItem
 * JD-Core Version:    0.7.0.1
 */