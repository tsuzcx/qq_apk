package shark.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/ObjectDominators$DominatorNode;", "", "shallowSize", "", "retainedSize", "retainedCount", "dominatedObjectIds", "", "", "(IIILjava/util/List;)V", "getDominatedObjectIds", "()Ljava/util/List;", "getRetainedCount", "()I", "getRetainedSize", "getShallowSize", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "shark"}, k=1, mv={1, 4, 1})
public final class ObjectDominators$DominatorNode
{
  private final int a;
  private final int b;
  private final int c;
  @NotNull
  private final List<Long> d;
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DominatorNode))
      {
        paramObject = (DominatorNode)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    int j = this.a;
    int k = this.b;
    int m = this.c;
    List localList = this.d;
    int i;
    if (localList != null) {
      i = localList.hashCode();
    } else {
      i = 0;
    }
    return ((j * 31 + k) * 31 + m) * 31 + i;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DominatorNode(shallowSize=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", retainedSize=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", retainedCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", dominatedObjectIds=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.ObjectDominators.DominatorNode
 * JD-Core Version:    0.7.0.1
 */