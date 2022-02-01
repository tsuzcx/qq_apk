package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface TypeMappingConfiguration<T>
{
  @NotNull
  public abstract KotlinType commonSupertype(@NotNull Collection<KotlinType> paramCollection);
  
  @Nullable
  public abstract String getPredefinedFullInternalNameForClass(@NotNull ClassDescriptor paramClassDescriptor);
  
  @Nullable
  public abstract String getPredefinedInternalNameForClass(@NotNull ClassDescriptor paramClassDescriptor);
  
  @Nullable
  public abstract T getPredefinedTypeForClass(@NotNull ClassDescriptor paramClassDescriptor);
  
  @Nullable
  public abstract KotlinType preprocessType(@NotNull KotlinType paramKotlinType);
  
  public abstract void processErrorType(@NotNull KotlinType paramKotlinType, @NotNull ClassDescriptor paramClassDescriptor);
  
  public abstract boolean releaseCoroutines();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
 * JD-Core Version:    0.7.0.1
 */