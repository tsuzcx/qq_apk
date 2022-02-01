package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Jsr305State
{
  public static final Jsr305State.Companion Companion = new Jsr305State.Companion(null);
  @JvmField
  @NotNull
  public static final Jsr305State DEFAULT = new Jsr305State(ReportLevel.WARN, null, MapsKt.emptyMap(), false, 8, null);
  @JvmField
  @NotNull
  public static final Jsr305State DISABLED = new Jsr305State(ReportLevel.IGNORE, ReportLevel.IGNORE, MapsKt.emptyMap(), false, 8, null);
  @JvmField
  @NotNull
  public static final Jsr305State STRICT = new Jsr305State(ReportLevel.STRICT, ReportLevel.STRICT, MapsKt.emptyMap(), false, 8, null);
  @NotNull
  private final Lazy description$delegate;
  private final boolean enableCompatqualCheckerFrameworkAnnotations;
  @NotNull
  private final ReportLevel global;
  @Nullable
  private final ReportLevel migration;
  @NotNull
  private final Map<String, ReportLevel> user;
  
  public Jsr305State(@NotNull ReportLevel paramReportLevel1, @Nullable ReportLevel paramReportLevel2, @NotNull Map<String, ? extends ReportLevel> paramMap, boolean paramBoolean)
  {
    this.global = paramReportLevel1;
    this.migration = paramReportLevel2;
    this.user = paramMap;
    this.enableCompatqualCheckerFrameworkAnnotations = paramBoolean;
    this.description$delegate = LazyKt.lazy((Function0)new Jsr305State.description.2(this));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Jsr305State))
      {
        paramObject = (Jsr305State)paramObject;
        if ((Intrinsics.areEqual(this.global, paramObject.global)) && (Intrinsics.areEqual(this.migration, paramObject.migration)) && (Intrinsics.areEqual(this.user, paramObject.user)) && (this.enableCompatqualCheckerFrameworkAnnotations == paramObject.enableCompatqualCheckerFrameworkAnnotations)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final boolean getDisabled()
  {
    return (Jsr305State)this == DISABLED;
  }
  
  public final boolean getEnableCompatqualCheckerFrameworkAnnotations()
  {
    return this.enableCompatqualCheckerFrameworkAnnotations;
  }
  
  @NotNull
  public final ReportLevel getGlobal()
  {
    return this.global;
  }
  
  @Nullable
  public final ReportLevel getMigration()
  {
    return this.migration;
  }
  
  @NotNull
  public final Map<String, ReportLevel> getUser()
  {
    return this.user;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Jsr305State(global=");
    localStringBuilder.append(this.global);
    localStringBuilder.append(", migration=");
    localStringBuilder.append(this.migration);
    localStringBuilder.append(", user=");
    localStringBuilder.append(this.user);
    localStringBuilder.append(", enableCompatqualCheckerFrameworkAnnotations=");
    localStringBuilder.append(this.enableCompatqualCheckerFrameworkAnnotations);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.Jsr305State
 * JD-Core Version:    0.7.0.1
 */