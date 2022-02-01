package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class AdditionalClassPartsProvider$None
  implements AdditionalClassPartsProvider
{
  public static final None INSTANCE = new None();
  
  @NotNull
  public Collection<ClassConstructorDescriptor> getConstructors(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull Name paramName, @NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  public Collection<Name> getFunctionsNames(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  public Collection<KotlinType> getSupertypes(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    return (Collection)CollectionsKt.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None
 * JD-Core Version:    0.7.0.1
 */