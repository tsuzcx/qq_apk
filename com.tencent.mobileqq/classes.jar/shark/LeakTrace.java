package shark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakTrace;", "Ljava/io/Serializable;", "gcRootType", "Lshark/LeakTrace$GcRootType;", "referencePath", "", "Lshark/LeakTraceReference;", "leakingObject", "Lshark/LeakTraceObject;", "(Lshark/LeakTrace$GcRootType;Ljava/util/List;Lshark/LeakTraceObject;)V", "getGcRootType", "()Lshark/LeakTrace$GcRootType;", "getLeakingObject", "()Lshark/LeakTraceObject;", "getReferencePath", "()Ljava/util/List;", "retainedHeapByteSize", "", "getRetainedHeapByteSize", "()Ljava/lang/Integer;", "retainedObjectCount", "getRetainedObjectCount", "signature", "", "getSignature", "()Ljava/lang/String;", "suspectReferenceSubpath", "Lkotlin/sequences/Sequence;", "getSuspectReferenceSubpath", "()Lkotlin/sequences/Sequence;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "leakTraceAsString", "showLeakingStatus", "referencePathElementIsSuspect", "index", "toSimplePathString", "toString", "Companion", "GcRootType", "shark"}, k=1, mv={1, 4, 1})
public final class LeakTrace
  implements Serializable
{
  @NotNull
  public static final LeakTrace.Companion Companion = new LeakTrace.Companion(null);
  public static final char ZERO_WIDTH_SPACE = '​';
  private static final long serialVersionUID = -6315725584154386429L;
  @NotNull
  private final LeakTrace.GcRootType gcRootType;
  @NotNull
  private final LeakTraceObject leakingObject;
  @NotNull
  private final List<LeakTraceReference> referencePath;
  
  public LeakTrace(@NotNull LeakTrace.GcRootType paramGcRootType, @NotNull List<LeakTraceReference> paramList, @NotNull LeakTraceObject paramLeakTraceObject)
  {
    this.gcRootType = paramGcRootType;
    this.referencePath = paramList;
    this.leakingObject = paramLeakTraceObject;
  }
  
  private final String a(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("\n        ┬───\n        │ GC Root: ");
    ((StringBuilder)localObject1).append(this.gcRootType.getDescription());
    ((StringBuilder)localObject1).append("\n        │\n      ");
    localObject1 = kotlin.text.StringsKt.trimIndent(((StringBuilder)localObject1).toString());
    Object localObject2 = ((Iterable)this.referencePath).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject3 = (LeakTraceReference)localObject3;
      Object localObject4 = ((LeakTraceReference)localObject3).getOriginObject();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("\n");
      localObject1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      if ((i == 0) && (this.gcRootType == LeakTrace.GcRootType.JAVA_FRAME)) {
        localObject1 = "thread";
      } else {
        localObject1 = ((LeakTraceObject)localObject4).getTypeName();
      }
      localStringBuilder.append(((LeakTraceObject)localObject4).toString$shark("├─ ", "│    ", paramBoolean, (String)localObject1));
      localObject1 = localStringBuilder.toString();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append((String)localObject1);
      ((StringBuilder)localObject4).append(LeakTrace.Companion.a(Companion, this, (LeakTraceReference)localObject3, i, paramBoolean));
      localObject1 = ((StringBuilder)localObject4).toString();
      i += 1;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(LeakTraceObject.toString$shark$default(this.leakingObject, "╰→ ", "​     ", paramBoolean, null, 8, null));
    return ((StringBuilder)localObject2).toString();
  }
  
  @NotNull
  public final LeakTrace.GcRootType component1()
  {
    return this.gcRootType;
  }
  
  @NotNull
  public final List<LeakTraceReference> component2()
  {
    return this.referencePath;
  }
  
  @NotNull
  public final LeakTraceObject component3()
  {
    return this.leakingObject;
  }
  
  @NotNull
  public final LeakTrace copy(@NotNull LeakTrace.GcRootType paramGcRootType, @NotNull List<LeakTraceReference> paramList, @NotNull LeakTraceObject paramLeakTraceObject)
  {
    Intrinsics.checkParameterIsNotNull(paramGcRootType, "gcRootType");
    Intrinsics.checkParameterIsNotNull(paramList, "referencePath");
    Intrinsics.checkParameterIsNotNull(paramLeakTraceObject, "leakingObject");
    return new LeakTrace(paramGcRootType, paramList, paramLeakTraceObject);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof LeakTrace))
      {
        paramObject = (LeakTrace)paramObject;
        if ((Intrinsics.areEqual(this.gcRootType, paramObject.gcRootType)) && (Intrinsics.areEqual(this.referencePath, paramObject.referencePath)) && (Intrinsics.areEqual(this.leakingObject, paramObject.leakingObject))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final LeakTrace.GcRootType getGcRootType()
  {
    return this.gcRootType;
  }
  
  @NotNull
  public final LeakTraceObject getLeakingObject()
  {
    return this.leakingObject;
  }
  
  @NotNull
  public final List<LeakTraceReference> getReferencePath()
  {
    return this.referencePath;
  }
  
  @Nullable
  public final Integer getRetainedHeapByteSize()
  {
    Collection localCollection = (Collection)CollectionsKt.listOf(this.leakingObject);
    Object localObject2 = (Iterable)this.referencePath;
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((LeakTraceReference)((Iterator)localObject2).next()).getOriginObject());
    }
    localObject1 = (Iterable)CollectionsKt.plus(localCollection, (Iterable)localObject1);
    localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      int i;
      if (((LeakTraceObject)localObject2).getLeakingStatus() == LeakTraceObject.LeakingStatus.LEAKING) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localCollection.add(localObject2);
      }
    }
    localObject1 = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((LeakTraceObject)((Iterator)localObject1).next()).getRetainedHeapByteSize();
      if (localObject2 != null) {
        localCollection.add(localObject2);
      }
    }
    return (Integer)CollectionsKt.max((Iterable)localCollection);
  }
  
  @Nullable
  public final Integer getRetainedObjectCount()
  {
    Collection localCollection = (Collection)CollectionsKt.listOf(this.leakingObject);
    Object localObject2 = (Iterable)this.referencePath;
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((LeakTraceReference)((Iterator)localObject2).next()).getOriginObject());
    }
    localObject1 = (Iterable)CollectionsKt.plus(localCollection, (Iterable)localObject1);
    localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      int i;
      if (((LeakTraceObject)localObject2).getLeakingStatus() == LeakTraceObject.LeakingStatus.LEAKING) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        localCollection.add(localObject2);
      }
    }
    localObject1 = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((LeakTraceObject)((Iterator)localObject1).next()).getRetainedObjectCount();
      if (localObject2 != null) {
        localCollection.add(localObject2);
      }
    }
    return (Integer)CollectionsKt.max((Iterable)localCollection);
  }
  
  @NotNull
  public final String getSignature()
  {
    return shark.internal.StringsKt.a(SequencesKt.joinToString$default(getSuspectReferenceSubpath(), (CharSequence)"", null, null, 0, null, (Function1)LeakTrace.signature.1.INSTANCE, 30, null));
  }
  
  @NotNull
  public final Sequence<LeakTraceReference> getSuspectReferenceSubpath()
  {
    return SequencesKt.filterIndexed(CollectionsKt.asSequence((Iterable)this.referencePath), (Function2)new LeakTrace.suspectReferenceSubpath.1(this));
  }
  
  public int hashCode()
  {
    Object localObject = this.gcRootType;
    int k = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.referencePath;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.leakingObject;
    if (localObject != null) {
      k = localObject.hashCode();
    }
    return (i * 31 + j) * 31 + k;
  }
  
  public final boolean referencePathElementIsSuspect(int paramInt)
  {
    LeakTraceObject.LeakingStatus localLeakingStatus = ((LeakTraceReference)this.referencePath.get(paramInt)).getOriginObject().getLeakingStatus();
    int i = LeakTrace.WhenMappings.$EnumSwitchMapping$0[localLeakingStatus.ordinal()];
    boolean bool = false;
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      if ((paramInt != CollectionsKt.getLastIndex(this.referencePath)) && (((LeakTraceReference)this.referencePath.get(paramInt + 1)).getOriginObject().getLeakingStatus() == LeakTraceObject.LeakingStatus.NOT_LEAKING)) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  @NotNull
  public final String toSimplePathString()
  {
    return a(false);
  }
  
  @NotNull
  public String toString()
  {
    return a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTrace
 * JD-Core Version:    0.7.0.1
 */