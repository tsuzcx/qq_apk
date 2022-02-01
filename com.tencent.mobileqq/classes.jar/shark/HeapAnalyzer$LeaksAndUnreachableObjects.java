package shark;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HeapAnalyzer$LeaksAndUnreachableObjects;", "", "applicationLeaks", "", "Lshark/ApplicationLeak;", "libraryLeaks", "Lshark/LibraryLeak;", "unreachableObjects", "Lshark/LeakTraceObject;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getApplicationLeaks", "()Ljava/util/List;", "getLibraryLeaks", "getUnreachableObjects", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "shark"}, k=1, mv={1, 4, 1})
final class HeapAnalyzer$LeaksAndUnreachableObjects
{
  @NotNull
  private final List<ApplicationLeak> a;
  @NotNull
  private final List<LibraryLeak> b;
  @NotNull
  private final List<LeakTraceObject> c;
  
  public HeapAnalyzer$LeaksAndUnreachableObjects(@NotNull List<ApplicationLeak> paramList, @NotNull List<LibraryLeak> paramList1, @NotNull List<LeakTraceObject> paramList2)
  {
    this.a = paramList;
    this.b = paramList1;
    this.c = paramList2;
  }
  
  @NotNull
  public final List<ApplicationLeak> a()
  {
    return this.a;
  }
  
  @NotNull
  public final List<LibraryLeak> b()
  {
    return this.b;
  }
  
  @NotNull
  public final List<LeakTraceObject> c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LeaksAndUnreachableObjects))
      {
        paramObject = (LeaksAndUnreachableObjects)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
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
    List localList = this.a;
    int k = 0;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    localList = this.b;
    int j;
    if (localList != null) {
      j = localList.hashCode();
    } else {
      j = 0;
    }
    localList = this.c;
    if (localList != null) {
      k = localList.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LeaksAndUnreachableObjects(applicationLeaks=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", libraryLeaks=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", unreachableObjects=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HeapAnalyzer.LeaksAndUnreachableObjects
 * JD-Core Version:    0.7.0.1
 */