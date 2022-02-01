package com.tencent.xaction.anim;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/PhysicalWorld$Params;", "", "density", "", "friction", "restitution", "mirror", "", "bodyType", "", "(FFFZI)V", "getBodyType", "()I", "setBodyType", "(I)V", "getDensity", "()F", "setDensity", "(F)V", "getFriction", "setFriction", "getMirror", "()Z", "setMirror", "(Z)V", "getRestitution", "setRestitution", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "XAPhysical_release"}, k=1, mv={1, 1, 16})
public final class PhysicalWorld$Params
{
  private float a;
  private float b;
  private float c;
  private boolean d;
  private int e;
  
  public PhysicalWorld$Params()
  {
    this(0.0F, 0.0F, 0.0F, false, 0, 31, null);
  }
  
  public PhysicalWorld$Params(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, int paramInt)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.d = paramBoolean;
    this.e = paramInt;
  }
  
  public final float a()
  {
    return this.a;
  }
  
  public final void a(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final float b()
  {
    return this.b;
  }
  
  public final void b(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public final float c()
  {
    return this.c;
  }
  
  public final void c(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public final int d()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Params))
      {
        paramObject = (Params)paramObject;
        if ((Float.compare(this.a, paramObject.a) == 0) && (Float.compare(this.b, paramObject.b) == 0) && (Float.compare(this.c, paramObject.c) == 0) && (this.d == paramObject.d) && (this.e == paramObject.e)) {}
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
    localStringBuilder.append("Params(density=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", friction=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", restitution=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mirror=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", bodyType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.PhysicalWorld.Params
 * JD-Core Version:    0.7.0.1
 */