package shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.internal.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LibraryLeak;", "Lshark/Leak;", "leakTraces", "", "Lshark/LeakTrace;", "pattern", "Lshark/ReferencePattern;", "description", "", "(Ljava/util/List;Lshark/ReferencePattern;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getLeakTraces", "()Ljava/util/List;", "getPattern", "()Lshark/ReferencePattern;", "shortDescription", "getShortDescription", "signature", "getSignature", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "shark"}, k=1, mv={1, 4, 1})
public final class LibraryLeak
  extends Leak
{
  @NotNull
  public static final LibraryLeak.Companion Companion = new LibraryLeak.Companion(null);
  private static final long serialVersionUID = 3943636164568681903L;
  @NotNull
  private final String description;
  @NotNull
  private final List<LeakTrace> leakTraces;
  @NotNull
  private final ReferencePattern pattern;
  
  public LibraryLeak(@NotNull List<LeakTrace> paramList, @NotNull ReferencePattern paramReferencePattern, @NotNull String paramString)
  {
    super(null);
    this.leakTraces = paramList;
    this.pattern = paramReferencePattern;
    this.description = paramString;
  }
  
  @NotNull
  public final List<LeakTrace> component1()
  {
    return getLeakTraces();
  }
  
  @NotNull
  public final ReferencePattern component2()
  {
    return this.pattern;
  }
  
  @NotNull
  public final String component3()
  {
    return this.description;
  }
  
  @NotNull
  public final LibraryLeak copy(@NotNull List<LeakTrace> paramList, @NotNull ReferencePattern paramReferencePattern, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "leakTraces");
    Intrinsics.checkParameterIsNotNull(paramReferencePattern, "pattern");
    Intrinsics.checkParameterIsNotNull(paramString, "description");
    return new LibraryLeak(paramList, paramReferencePattern, paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LibraryLeak))
      {
        paramObject = (LibraryLeak)paramObject;
        if ((Intrinsics.areEqual(getLeakTraces(), paramObject.getLeakTraces())) && (Intrinsics.areEqual(this.pattern, paramObject.pattern)) && (Intrinsics.areEqual(this.description, paramObject.description))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getDescription()
  {
    return this.description;
  }
  
  @NotNull
  public List<LeakTrace> getLeakTraces()
  {
    return this.leakTraces;
  }
  
  @NotNull
  public final ReferencePattern getPattern()
  {
    return this.pattern;
  }
  
  @NotNull
  public String getShortDescription()
  {
    return this.pattern.toString();
  }
  
  @NotNull
  public String getSignature()
  {
    return StringsKt.a(this.pattern.toString());
  }
  
  public int hashCode()
  {
    Object localObject = getLeakTraces();
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.pattern;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.description;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Leak pattern: ");
    localStringBuilder.append(this.pattern);
    localStringBuilder.append("\nDescription: ");
    localStringBuilder.append(this.description);
    localStringBuilder.append('\n');
    localStringBuilder.append(super.toString());
    localStringBuilder.append('\n');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LibraryLeak
 * JD-Core Version:    0.7.0.1
 */