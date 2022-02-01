package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeAliasExpansion
{
  public static final TypeAliasExpansion.Companion Companion = new TypeAliasExpansion.Companion(null);
  @NotNull
  private final List<TypeProjection> arguments;
  @NotNull
  private final TypeAliasDescriptor descriptor;
  @NotNull
  private final Map<TypeParameterDescriptor, TypeProjection> mapping;
  @Nullable
  private final TypeAliasExpansion parent;
  
  private TypeAliasExpansion(TypeAliasExpansion paramTypeAliasExpansion, TypeAliasDescriptor paramTypeAliasDescriptor, List<? extends TypeProjection> paramList, Map<TypeParameterDescriptor, ? extends TypeProjection> paramMap)
  {
    this.parent = paramTypeAliasExpansion;
    this.descriptor = paramTypeAliasDescriptor;
    this.arguments = paramList;
    this.mapping = paramMap;
  }
  
  @NotNull
  public final List<TypeProjection> getArguments()
  {
    return this.arguments;
  }
  
  @NotNull
  public final TypeAliasDescriptor getDescriptor()
  {
    return this.descriptor;
  }
  
  @Nullable
  public final TypeProjection getReplacement(@NotNull TypeConstructor paramTypeConstructor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "constructor");
    paramTypeConstructor = paramTypeConstructor.getDeclarationDescriptor();
    if ((paramTypeConstructor instanceof TypeParameterDescriptor)) {
      return (TypeProjection)this.mapping.get(paramTypeConstructor);
    }
    return null;
  }
  
  public final boolean isRecursion(@NotNull TypeAliasDescriptor paramTypeAliasDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeAliasDescriptor, "descriptor");
    boolean bool1 = Intrinsics.areEqual(this.descriptor, paramTypeAliasDescriptor);
    boolean bool2 = false;
    if (!bool1)
    {
      TypeAliasExpansion localTypeAliasExpansion = this.parent;
      if (localTypeAliasExpansion != null) {
        bool1 = localTypeAliasExpansion.isRecursion(paramTypeAliasDescriptor);
      } else {
        bool1 = false;
      }
      if (!bool1) {}
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion
 * JD-Core Version:    0.7.0.1
 */