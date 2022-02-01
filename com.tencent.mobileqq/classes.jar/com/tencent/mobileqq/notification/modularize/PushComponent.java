package com.tencent.mobileqq.notification.modularize;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/notification/modularize/PushComponent;", "", "()V", "mainBusinessId", "", "subBusinessId", "pushId", "notifyId", "title", "", "iconUrl", "contentText", "jumpScheme", "triggerInfo", "isUrlJump", "", "isRevokePush", "needForegroundPush", "needBackgroundPush", "bytesExtData", "", "(IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ[B)V", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "notifyIdValid", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PushComponent
{
  @JvmField
  public int a;
  @JvmField
  public int b;
  @JvmField
  public int c;
  @JvmField
  public int d;
  @JvmField
  @NotNull
  public String e;
  @JvmField
  @NotNull
  public String f;
  @JvmField
  @NotNull
  public String g;
  @JvmField
  @NotNull
  public String h;
  @JvmField
  @NotNull
  public String i;
  @JvmField
  public boolean j;
  @JvmField
  public boolean k;
  @JvmField
  public boolean l;
  @JvmField
  public boolean m;
  @JvmField
  @NotNull
  public byte[] n;
  
  public PushComponent()
  {
    this(0, 0, 0, 0, null, null, null, null, null, false, false, false, false, null, 16382, null);
  }
  
  public PushComponent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @NotNull byte[] paramArrayOfByte)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramString4;
    this.i = paramString5;
    this.j = paramBoolean1;
    this.k = paramBoolean2;
    this.l = paramBoolean3;
    this.m = paramBoolean4;
    this.n = paramArrayOfByte;
  }
  
  public final boolean a()
  {
    int i1 = this.d;
    return (528 <= i1) && (3000528 >= i1);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof PushComponent))
      {
        paramObject = (PushComponent)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (Intrinsics.areEqual(this.e, paramObject.e)) && (Intrinsics.areEqual(this.f, paramObject.f)) && (Intrinsics.areEqual(this.g, paramObject.g)) && (Intrinsics.areEqual(this.h, paramObject.h)) && (Intrinsics.areEqual(this.i, paramObject.i)) && (this.j == paramObject.j) && (this.k == paramObject.k) && (this.l == paramObject.l) && (this.m == paramObject.m) && (Intrinsics.areEqual(this.n, paramObject.n))) {}
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PushComponent(mainBusinessId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", subBusinessId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", pushId=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", notifyId=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", title=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", iconUrl=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", contentText=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", jumpScheme=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", triggerInfo=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", isUrlJump=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", isRevokePush=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", needForegroundPush=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", needBackgroundPush=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", bytesExtData=");
    localStringBuilder.append(Arrays.toString(this.n));
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.notification.modularize.PushComponent
 * JD-Core Version:    0.7.0.1
 */