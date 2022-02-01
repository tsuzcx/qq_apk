package shark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LibraryLeakReferenceMatcher;", "Lshark/ReferenceMatcher;", "pattern", "Lshark/ReferencePattern;", "description", "", "patternApplies", "Lkotlin/Function1;", "Lshark/HeapGraph;", "", "(Lshark/ReferencePattern;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getDescription", "()Ljava/lang/String;", "getPattern", "()Lshark/ReferencePattern;", "getPatternApplies", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "shark"}, k=1, mv={1, 4, 1})
public final class LibraryLeakReferenceMatcher
  extends ReferenceMatcher
{
  @NotNull
  private final ReferencePattern a;
  @NotNull
  private final String b;
  @NotNull
  private final Function1<HeapGraph, Boolean> c;
  
  @NotNull
  public ReferencePattern a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final Function1<HeapGraph, Boolean> c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LibraryLeakReferenceMatcher))
      {
        paramObject = (LibraryLeakReferenceMatcher)paramObject;
        if ((Intrinsics.areEqual(a(), paramObject.a())) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
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
    Object localObject = a();
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("library leak: ");
    localStringBuilder.append(a());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LibraryLeakReferenceMatcher
 * JD-Core Version:    0.7.0.1
 */