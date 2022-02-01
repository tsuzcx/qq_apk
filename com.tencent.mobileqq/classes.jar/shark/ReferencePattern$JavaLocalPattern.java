package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/ReferencePattern$JavaLocalPattern;", "Lshark/ReferencePattern;", "threadName", "", "(Ljava/lang/String;)V", "getThreadName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k=1, mv={1, 4, 1})
public final class ReferencePattern$JavaLocalPattern
  extends ReferencePattern
{
  @NotNull
  public static final ReferencePattern.JavaLocalPattern.Companion Companion = new ReferencePattern.JavaLocalPattern.Companion(null);
  private static final long serialVersionUID = -8985446122829543654L;
  @NotNull
  private final String threadName;
  
  public ReferencePattern$JavaLocalPattern(@NotNull String paramString)
  {
    super(null);
    this.threadName = paramString;
  }
  
  @NotNull
  public final String component1()
  {
    return this.threadName;
  }
  
  @NotNull
  public final JavaLocalPattern copy(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "threadName");
    return new JavaLocalPattern(paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof JavaLocalPattern))
      {
        paramObject = (JavaLocalPattern)paramObject;
        if (Intrinsics.areEqual(this.threadName, paramObject.threadName)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getThreadName()
  {
    return this.threadName;
  }
  
  public int hashCode()
  {
    String str = this.threadName;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("local variable on thread ");
    localStringBuilder.append(this.threadName);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.ReferencePattern.JavaLocalPattern
 * JD-Core Version:    0.7.0.1
 */