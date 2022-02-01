package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltInsSettings$getJdkMethodStatus$1<N>
  implements DFS.Neighbors<N>
{
  JvmBuiltInsSettings$getJdkMethodStatus$1(JvmBuiltInsSettings paramJvmBuiltInsSettings) {}
  
  @NotNull
  public final List<LazyJavaClassDescriptor> getNeighbors(ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "it");
    paramClassDescriptor = paramClassDescriptor.getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "it.typeConstructor");
    paramClassDescriptor = paramClassDescriptor.getSupertypes();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "it.typeConstructor.supertypes");
    paramClassDescriptor = (Iterable)paramClassDescriptor;
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramClassDescriptor.iterator();
    while (localIterator.hasNext())
    {
      paramClassDescriptor = ((KotlinType)localIterator.next()).getConstructor().getDeclarationDescriptor();
      Object localObject = null;
      if (paramClassDescriptor != null) {
        paramClassDescriptor = paramClassDescriptor.getOriginal();
      } else {
        paramClassDescriptor = null;
      }
      ClassDescriptor localClassDescriptor = paramClassDescriptor;
      if (!(paramClassDescriptor instanceof ClassDescriptor)) {
        localClassDescriptor = null;
      }
      localClassDescriptor = (ClassDescriptor)localClassDescriptor;
      paramClassDescriptor = localObject;
      if (localClassDescriptor != null) {
        paramClassDescriptor = JvmBuiltInsSettings.access$getJavaAnalogue(this.this$0, localClassDescriptor);
      }
      if (paramClassDescriptor != null) {
        localCollection.add(paramClassDescriptor);
      }
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.getJdkMethodStatus.1
 * JD-Core Version:    0.7.0.1
 */