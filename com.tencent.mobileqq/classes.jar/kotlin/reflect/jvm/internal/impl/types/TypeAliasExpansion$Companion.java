package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeAliasExpansion$Companion
{
  @NotNull
  public final TypeAliasExpansion create(@Nullable TypeAliasExpansion paramTypeAliasExpansion, @NotNull TypeAliasDescriptor paramTypeAliasDescriptor, @NotNull List<? extends TypeProjection> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeAliasDescriptor, "typeAliasDescriptor");
    Intrinsics.checkParameterIsNotNull(paramList, "arguments");
    Object localObject1 = paramTypeAliasDescriptor.getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "typeAliasDescriptor.typeConstructor");
    localObject1 = ((TypeConstructor)localObject1).getParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "typeAliasDescriptor.typeConstructor.parameters");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TypeParameterDescriptor localTypeParameterDescriptor = (TypeParameterDescriptor)((Iterator)localObject2).next();
      Intrinsics.checkExpressionValueIsNotNull(localTypeParameterDescriptor, "it");
      ((Collection)localObject1).add(localTypeParameterDescriptor.getOriginal());
    }
    return new TypeAliasExpansion(paramTypeAliasExpansion, paramTypeAliasDescriptor, paramList, MapsKt.toMap((Iterable)CollectionsKt.zip((Iterable)localObject1, (Iterable)paramList)), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansion.Companion
 * JD-Core Version:    0.7.0.1
 */