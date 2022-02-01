package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ReferencePattern$NativeGlobalVariablePattern;", "Lshark/ReferencePattern;", "className", "", "(Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k=1, mv={1, 4, 1})
public final class ReferencePattern$NativeGlobalVariablePattern
  extends ReferencePattern
{
  @NotNull
  public static final ReferencePattern.NativeGlobalVariablePattern.Companion Companion = new ReferencePattern.NativeGlobalVariablePattern.Companion(null);
  private static final long serialVersionUID = -2651328076202244933L;
  @NotNull
  private final String className;
  
  public ReferencePattern$NativeGlobalVariablePattern(@NotNull String paramString)
  {
    super(null);
    this.className = paramString;
  }
  
  @NotNull
  public final String component1()
  {
    return this.className;
  }
  
  @NotNull
  public final NativeGlobalVariablePattern copy(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    return new NativeGlobalVariablePattern(paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NativeGlobalVariablePattern))
      {
        paramObject = (NativeGlobalVariablePattern)paramObject;
        if (Intrinsics.areEqual(this.className, paramObject.className)) {}
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
  
  public int hashCode()
  {
    String str = this.className;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("native global variable referencing ");
    localStringBuilder.append(this.className);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ReferencePattern.NativeGlobalVariablePattern
 * JD-Core Version:    0.7.0.1
 */