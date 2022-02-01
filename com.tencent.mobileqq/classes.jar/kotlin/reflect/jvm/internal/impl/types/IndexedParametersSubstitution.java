package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IndexedParametersSubstitution
  extends TypeSubstitution
{
  private final boolean approximateCapturedTypes;
  @NotNull
  private final TypeProjection[] arguments;
  @NotNull
  private final TypeParameterDescriptor[] parameters;
  
  public IndexedParametersSubstitution(@NotNull List<? extends TypeParameterDescriptor> paramList, @NotNull List<? extends TypeProjection> paramList1) {}
  
  public IndexedParametersSubstitution(@NotNull TypeParameterDescriptor[] paramArrayOfTypeParameterDescriptor, @NotNull TypeProjection[] paramArrayOfTypeProjection, boolean paramBoolean)
  {
    this.parameters = paramArrayOfTypeParameterDescriptor;
    this.arguments = paramArrayOfTypeProjection;
    this.approximateCapturedTypes = paramBoolean;
    int i;
    if (this.parameters.length <= this.arguments.length) {
      i = 1;
    } else {
      i = 0;
    }
    if (_Assertions.ENABLED)
    {
      if (i != 0) {
        return;
      }
      paramArrayOfTypeParameterDescriptor = new StringBuilder();
      paramArrayOfTypeParameterDescriptor.append("Number of arguments should not be less then number of parameters, but: parameters=");
      paramArrayOfTypeParameterDescriptor.append(this.parameters.length);
      paramArrayOfTypeParameterDescriptor.append(", args=");
      paramArrayOfTypeParameterDescriptor.append(this.arguments.length);
      throw ((Throwable)new AssertionError(paramArrayOfTypeParameterDescriptor.toString()));
    }
  }
  
  public boolean approximateContravariantCapturedTypes()
  {
    return this.approximateCapturedTypes;
  }
  
  @Nullable
  public TypeProjection get(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "key");
    Object localObject = paramKotlinType.getConstructor().getDeclarationDescriptor();
    paramKotlinType = (KotlinType)localObject;
    if (!(localObject instanceof TypeParameterDescriptor)) {
      paramKotlinType = null;
    }
    paramKotlinType = (TypeParameterDescriptor)paramKotlinType;
    if (paramKotlinType != null)
    {
      int i = paramKotlinType.getIndex();
      localObject = this.parameters;
      if ((i < localObject.length) && (Intrinsics.areEqual(localObject[i].getTypeConstructor(), paramKotlinType.getTypeConstructor()))) {
        return this.arguments[i];
      }
    }
    return null;
  }
  
  @NotNull
  public final TypeProjection[] getArguments()
  {
    return this.arguments;
  }
  
  @NotNull
  public final TypeParameterDescriptor[] getParameters()
  {
    return this.parameters;
  }
  
  public boolean isEmpty()
  {
    return this.arguments.length == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution
 * JD-Core Version:    0.7.0.1
 */