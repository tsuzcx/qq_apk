package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1<N>
  implements DFS.Neighbors<N>
{
  public static final 1 INSTANCE = new 1();
  
  @NotNull
  public final Iterable<ClassDescriptor> getNeighbors(ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "it");
    paramClassDescriptor = paramClassDescriptor.getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "it.typeConstructor");
    paramClassDescriptor = paramClassDescriptor.getSupertypes();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "it.typeConstructor.supertypes");
    return SequencesKt.asIterable(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable)paramClassDescriptor), (Function1)LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes.1.1.INSTANCE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes.1
 * JD-Core Version:    0.7.0.1
 */