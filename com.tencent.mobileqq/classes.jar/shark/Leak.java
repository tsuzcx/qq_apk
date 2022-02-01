package shark;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/Leak;", "Ljava/io/Serializable;", "()V", "leakTraces", "", "Lshark/LeakTrace;", "getLeakTraces", "()Ljava/util/List;", "shortDescription", "", "getShortDescription", "()Ljava/lang/String;", "signature", "getSignature", "totalRetainedHeapByteSize", "", "getTotalRetainedHeapByteSize", "()Ljava/lang/Integer;", "totalRetainedObjectCount", "getTotalRetainedObjectCount", "toString", "Companion", "Lshark/LibraryLeak;", "Lshark/ApplicationLeak;", "shark"}, k=1, mv={1, 4, 1})
public abstract class Leak
  implements Serializable
{
  @NotNull
  public static final Leak.Companion Companion = new Leak.Companion(null);
  private static final long serialVersionUID = -2287572510360910916L;
  
  @NotNull
  public abstract List<LeakTrace> getLeakTraces();
  
  @NotNull
  public abstract String getShortDescription();
  
  @NotNull
  public abstract String getSignature();
  
  @Nullable
  public final Integer getTotalRetainedHeapByteSize()
  {
    if (((LeakTrace)CollectionsKt.first(getLeakTraces())).getRetainedHeapByteSize() == null) {
      return null;
    }
    Object localObject = (Iterable)getLeakTraces();
    int i = 0;
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = ((LeakTrace)((Iterator)localObject).next()).getRetainedHeapByteSize();
      if (localInteger == null) {
        Intrinsics.throwNpe();
      }
      i += localInteger.intValue();
    }
    return Integer.valueOf(i);
  }
  
  @Nullable
  public final Integer getTotalRetainedObjectCount()
  {
    if (((LeakTrace)CollectionsKt.first(getLeakTraces())).getRetainedObjectCount() == null) {
      return null;
    }
    Object localObject = (Iterable)getLeakTraces();
    int i = 0;
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = ((LeakTrace)((Iterator)localObject).next()).getRetainedObjectCount();
      if (localInteger == null) {
        Intrinsics.throwNpe();
      }
      i += localInteger.intValue();
    }
    return Integer.valueOf(i);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = getTotalRetainedHeapByteSize();
    String str = "";
    if (localObject != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getTotalRetainedHeapByteSize());
      ((StringBuilder)localObject).append(" bytes retained by leaking objects\n");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localObject = str;
    if (getLeakTraces().size() > 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Displaying only 1 leak trace out of ");
      ((StringBuilder)localObject).append(getLeakTraces().size());
      ((StringBuilder)localObject).append(" with the same signature\n");
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("Signature: ");
    localStringBuilder.append(getSignature());
    localStringBuilder.append('\n');
    localStringBuilder.append((LeakTrace)CollectionsKt.first(getLeakTraces()));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.Leak
 * JD-Core Version:    0.7.0.1
 */