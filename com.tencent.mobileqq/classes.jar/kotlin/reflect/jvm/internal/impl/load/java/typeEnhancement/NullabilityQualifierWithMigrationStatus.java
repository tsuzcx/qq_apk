package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NullabilityQualifierWithMigrationStatus
{
  private final boolean isForWarningOnly;
  @NotNull
  private final NullabilityQualifier qualifier;
  
  public NullabilityQualifierWithMigrationStatus(@NotNull NullabilityQualifier paramNullabilityQualifier, boolean paramBoolean)
  {
    this.qualifier = paramNullabilityQualifier;
    this.isForWarningOnly = paramBoolean;
  }
  
  @NotNull
  public final NullabilityQualifierWithMigrationStatus copy(@NotNull NullabilityQualifier paramNullabilityQualifier, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramNullabilityQualifier, "qualifier");
    return new NullabilityQualifierWithMigrationStatus(paramNullabilityQualifier, paramBoolean);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NullabilityQualifierWithMigrationStatus))
      {
        paramObject = (NullabilityQualifierWithMigrationStatus)paramObject;
        if ((Intrinsics.areEqual(this.qualifier, paramObject.qualifier)) && (this.isForWarningOnly == paramObject.isForWarningOnly)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final NullabilityQualifier getQualifier()
  {
    return this.qualifier;
  }
  
  public int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final boolean isForWarningOnly()
  {
    return this.isForWarningOnly;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NullabilityQualifierWithMigrationStatus(qualifier=");
    localStringBuilder.append(this.qualifier);
    localStringBuilder.append(", isForWarningOnly=");
    localStringBuilder.append(this.isForWarningOnly);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus
 * JD-Core Version:    0.7.0.1
 */