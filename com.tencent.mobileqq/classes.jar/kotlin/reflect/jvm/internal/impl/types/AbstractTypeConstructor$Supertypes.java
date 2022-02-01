package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class AbstractTypeConstructor$Supertypes
{
  @NotNull
  private final Collection<KotlinType> allSupertypes;
  @NotNull
  private List<? extends KotlinType> supertypesWithoutCycles;
  
  public AbstractTypeConstructor$Supertypes(@NotNull Collection<? extends KotlinType> paramCollection)
  {
    this.allSupertypes = paramCollection;
    this.supertypesWithoutCycles = CollectionsKt.listOf(ErrorUtils.ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES);
  }
  
  @NotNull
  public final Collection<KotlinType> getAllSupertypes()
  {
    return this.allSupertypes;
  }
  
  @NotNull
  public final List<KotlinType> getSupertypesWithoutCycles()
  {
    return this.supertypesWithoutCycles;
  }
  
  public final void setSupertypesWithoutCycles(@NotNull List<? extends KotlinType> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "<set-?>");
    this.supertypesWithoutCycles = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.Supertypes
 * JD-Core Version:    0.7.0.1
 */