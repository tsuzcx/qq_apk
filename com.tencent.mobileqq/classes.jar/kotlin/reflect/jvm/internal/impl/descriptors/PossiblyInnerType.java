package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PossiblyInnerType
{
  @NotNull
  private final List<TypeProjection> arguments;
  @NotNull
  private final ClassifierDescriptorWithTypeParameters classifierDescriptor;
  @Nullable
  private final PossiblyInnerType outerType;
  
  public PossiblyInnerType(@NotNull ClassifierDescriptorWithTypeParameters paramClassifierDescriptorWithTypeParameters, @NotNull List<? extends TypeProjection> paramList, @Nullable PossiblyInnerType paramPossiblyInnerType)
  {
    this.classifierDescriptor = paramClassifierDescriptorWithTypeParameters;
    this.arguments = paramList;
    this.outerType = paramPossiblyInnerType;
  }
  
  @NotNull
  public final List<TypeProjection> getArguments()
  {
    return this.arguments;
  }
  
  @NotNull
  public final ClassifierDescriptorWithTypeParameters getClassifierDescriptor()
  {
    return this.classifierDescriptor;
  }
  
  @Nullable
  public final PossiblyInnerType getOuterType()
  {
    return this.outerType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType
 * JD-Core Version:    0.7.0.1
 */