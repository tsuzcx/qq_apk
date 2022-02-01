package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeMappingConfigurationImpl
  implements TypeMappingConfiguration<JvmType>
{
  public static final TypeMappingConfigurationImpl INSTANCE = new TypeMappingConfigurationImpl();
  
  @NotNull
  public KotlinType commonSupertype(@NotNull Collection<? extends KotlinType> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "types");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("There should be no intersection type in existing descriptors, but found: ");
    localStringBuilder.append(CollectionsKt.joinToString$default((Iterable)paramCollection, null, null, null, 0, null, null, 63, null));
    throw ((Throwable)new AssertionError(localStringBuilder.toString()));
  }
  
  @Nullable
  public String getPredefinedFullInternalNameForClass(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    return TypeMappingConfiguration.DefaultImpls.getPredefinedFullInternalNameForClass(this, paramClassDescriptor);
  }
  
  @Nullable
  public String getPredefinedInternalNameForClass(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    return null;
  }
  
  @Nullable
  public JvmType getPredefinedTypeForClass(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    return null;
  }
  
  @Nullable
  public KotlinType preprocessType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "kotlinType");
    return TypeMappingConfiguration.DefaultImpls.preprocessType(this, paramKotlinType);
  }
  
  public void processErrorType(@NotNull KotlinType paramKotlinType, @NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "kotlinType");
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "descriptor");
  }
  
  public boolean releaseCoroutines()
  {
    return TypeMappingConfiguration.DefaultImpls.releaseCoroutines(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfigurationImpl
 * JD-Core Version:    0.7.0.1
 */