package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ReferencePattern$StaticFieldPattern;", "Lshark/ReferencePattern;", "className", "", "fieldName", "(Ljava/lang/String;Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "getFieldName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k=1, mv={1, 4, 1})
public final class ReferencePattern$StaticFieldPattern
  extends ReferencePattern
{
  @NotNull
  public static final ReferencePattern.StaticFieldPattern.Companion Companion = new ReferencePattern.StaticFieldPattern.Companion(null);
  private static final long serialVersionUID = 7656908128775899611L;
  @NotNull
  private final String className;
  @NotNull
  private final String fieldName;
  
  public ReferencePattern$StaticFieldPattern(@NotNull String paramString1, @NotNull String paramString2)
  {
    super(null);
    this.className = paramString1;
    this.fieldName = paramString2;
  }
  
  @NotNull
  public final String component1()
  {
    return this.className;
  }
  
  @NotNull
  public final String component2()
  {
    return this.fieldName;
  }
  
  @NotNull
  public final StaticFieldPattern copy(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "className");
    Intrinsics.checkParameterIsNotNull(paramString2, "fieldName");
    return new StaticFieldPattern(paramString1, paramString2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof StaticFieldPattern))
      {
        paramObject = (StaticFieldPattern)paramObject;
        if ((Intrinsics.areEqual(this.className, paramObject.className)) && (Intrinsics.areEqual(this.fieldName, paramObject.fieldName))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getClassName()
  {
    return this.className;
  }
  
  @NotNull
  public final String getFieldName()
  {
    return this.fieldName;
  }
  
  public int hashCode()
  {
    String str = this.className;
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.fieldName;
    if (str != null) {
      j = str.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("static field ");
    localStringBuilder.append(this.className);
    localStringBuilder.append('#');
    localStringBuilder.append(this.fieldName);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ReferencePattern.StaticFieldPattern
 * JD-Core Version:    0.7.0.1
 */