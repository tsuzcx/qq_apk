package shark;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.internal.StringsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakTraceReference;", "Ljava/io/Serializable;", "originObject", "Lshark/LeakTraceObject;", "referenceType", "Lshark/LeakTraceReference$ReferenceType;", "owningClassName", "", "referenceName", "(Lshark/LeakTraceObject;Lshark/LeakTraceReference$ReferenceType;Ljava/lang/String;Ljava/lang/String;)V", "getOriginObject", "()Lshark/LeakTraceObject;", "getOwningClassName", "()Ljava/lang/String;", "owningClassSimpleName", "getOwningClassSimpleName", "referenceDisplayName", "getReferenceDisplayName", "referenceGenericName", "getReferenceGenericName", "getReferenceName", "getReferenceType", "()Lshark/LeakTraceReference$ReferenceType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "ReferenceType", "shark"}, k=1, mv={1, 4, 1})
public final class LeakTraceReference
  implements Serializable
{
  @NotNull
  public static final LeakTraceReference.Companion Companion = new LeakTraceReference.Companion(null);
  private static final long serialVersionUID = 1L;
  @NotNull
  private final LeakTraceObject originObject;
  @NotNull
  private final String owningClassName;
  @NotNull
  private final String referenceName;
  @NotNull
  private final LeakTraceReference.ReferenceType referenceType;
  
  public LeakTraceReference(@NotNull LeakTraceObject paramLeakTraceObject, @NotNull LeakTraceReference.ReferenceType paramReferenceType, @NotNull String paramString1, @NotNull String paramString2)
  {
    this.originObject = paramLeakTraceObject;
    this.referenceType = paramReferenceType;
    this.owningClassName = paramString1;
    this.referenceName = paramString2;
  }
  
  @NotNull
  public final LeakTraceObject component1()
  {
    return this.originObject;
  }
  
  @NotNull
  public final LeakTraceReference.ReferenceType component2()
  {
    return this.referenceType;
  }
  
  @NotNull
  public final String component3()
  {
    return this.owningClassName;
  }
  
  @NotNull
  public final String component4()
  {
    return this.referenceName;
  }
  
  @NotNull
  public final LeakTraceReference copy(@NotNull LeakTraceObject paramLeakTraceObject, @NotNull LeakTraceReference.ReferenceType paramReferenceType, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramLeakTraceObject, "originObject");
    Intrinsics.checkParameterIsNotNull(paramReferenceType, "referenceType");
    Intrinsics.checkParameterIsNotNull(paramString1, "owningClassName");
    Intrinsics.checkParameterIsNotNull(paramString2, "referenceName");
    return new LeakTraceReference(paramLeakTraceObject, paramReferenceType, paramString1, paramString2);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LeakTraceReference))
      {
        paramObject = (LeakTraceReference)paramObject;
        if ((Intrinsics.areEqual(this.originObject, paramObject.originObject)) && (Intrinsics.areEqual(this.referenceType, paramObject.referenceType)) && (Intrinsics.areEqual(this.owningClassName, paramObject.owningClassName)) && (Intrinsics.areEqual(this.referenceName, paramObject.referenceName))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final LeakTraceObject getOriginObject()
  {
    return this.originObject;
  }
  
  @NotNull
  public final String getOwningClassName()
  {
    return this.owningClassName;
  }
  
  @NotNull
  public final String getOwningClassSimpleName()
  {
    return StringsKt.a(this.owningClassName, '.');
  }
  
  @NotNull
  public final String getReferenceDisplayName()
  {
    Object localObject = this.referenceType;
    int i = LeakTraceReference.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if (i == 4) {
          return "<Java Local>";
        }
        throw new NoWhenBranchMatchedException();
      }
      return this.referenceName;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append('[');
    ((StringBuilder)localObject).append(this.referenceName);
    ((StringBuilder)localObject).append(']');
    return ((StringBuilder)localObject).toString();
  }
  
  @NotNull
  public final String getReferenceGenericName()
  {
    LeakTraceReference.ReferenceType localReferenceType = this.referenceType;
    int i = LeakTraceReference.WhenMappings.$EnumSwitchMapping$1[localReferenceType.ordinal()];
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if (i == 4) {
          return "<Java Local>";
        }
        throw new NoWhenBranchMatchedException();
      }
      return this.referenceName;
    }
    return "[x]";
  }
  
  @NotNull
  public final String getReferenceName()
  {
    return this.referenceName;
  }
  
  @NotNull
  public final LeakTraceReference.ReferenceType getReferenceType()
  {
    return this.referenceType;
  }
  
  public int hashCode()
  {
    Object localObject = this.originObject;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.referenceType;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.owningClassName;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.referenceName;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LeakTraceReference(originObject=");
    localStringBuilder.append(this.originObject);
    localStringBuilder.append(", referenceType=");
    localStringBuilder.append(this.referenceType);
    localStringBuilder.append(", owningClassName=");
    localStringBuilder.append(this.owningClassName);
    localStringBuilder.append(", referenceName=");
    localStringBuilder.append(this.referenceName);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTraceReference
 * JD-Core Version:    0.7.0.1
 */