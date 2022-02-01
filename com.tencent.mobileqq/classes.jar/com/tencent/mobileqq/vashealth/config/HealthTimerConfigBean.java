package com.tencent.mobileqq.vashealth.config;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/HealthTimerConfigBean;", "", "maxInterval", "", "maxIncrement", "timer1StartHour", "timer1StartMin", "timer1EndHour", "timer1EndMin", "timer1Interval", "timer1Increment", "timer1SpanMinute", "timer2StartHour", "timer2EndHour", "timer2Interval", "timer2RetryTimes", "configReady", "", "(IIIIIIIIIIIIIZ)V", "getConfigReady", "()Z", "getMaxIncrement", "()I", "getMaxInterval", "getTimer1EndHour", "getTimer1EndMin", "getTimer1Increment", "getTimer1Interval", "getTimer1SpanMinute", "getTimer1StartHour", "getTimer1StartMin", "getTimer2EndHour", "getTimer2Interval", "getTimer2RetryTimes", "getTimer2StartHour", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class HealthTimerConfigBean
{
  public static final HealthTimerConfigBean.Companion a;
  private final int jdField_a_of_type_Int;
  private final boolean jdField_a_of_type_Boolean;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;
  private final int m;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVashealthConfigHealthTimerConfigBean$Companion = new HealthTimerConfigBean.Companion(null);
  }
  
  public HealthTimerConfigBean()
  {
    this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 16383, null);
  }
  
  public HealthTimerConfigBean(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.g = paramInt7;
    this.h = paramInt8;
    this.i = paramInt9;
    this.j = paramInt10;
    this.k = paramInt11;
    this.l = paramInt12;
    this.m = paramInt13;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HealthTimerConfigBean))
      {
        paramObject = (HealthTimerConfigBean)paramObject;
        if ((this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f) && (this.g == paramObject.g) && (this.h == paramObject.h) && (this.i == paramObject.i) && (this.j == paramObject.j) && (this.k == paramObject.k) && (this.l == paramObject.l) && (this.m == paramObject.m) && (this.jdField_a_of_type_Boolean == paramObject.jdField_a_of_type_Boolean)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int f()
  {
    return this.f;
  }
  
  public final int g()
  {
    return this.g;
  }
  
  public final int h()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final int i()
  {
    return this.i;
  }
  
  public final int j()
  {
    return this.j;
  }
  
  public final int k()
  {
    return this.k;
  }
  
  public final int l()
  {
    return this.l;
  }
  
  public final int m()
  {
    return this.m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HealthTimerConfigBean(maxInterval=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", maxIncrement=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", timer1StartHour=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", timer1StartMin=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", timer1EndHour=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", timer1EndMin=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", timer1Interval=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", timer1Increment=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", timer1SpanMinute=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", timer2StartHour=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", timer2EndHour=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", timer2Interval=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", timer2RetryTimes=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", configReady=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.HealthTimerConfigBean
 * JD-Core Version:    0.7.0.1
 */