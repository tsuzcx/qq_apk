package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class KTypeProjection$Companion
{
  @NotNull
  public final KTypeProjection contravariant(@NotNull KType paramKType)
  {
    Intrinsics.checkParameterIsNotNull(paramKType, "type");
    return new KTypeProjection(KVariance.IN, paramKType);
  }
  
  @NotNull
  public final KTypeProjection covariant(@NotNull KType paramKType)
  {
    Intrinsics.checkParameterIsNotNull(paramKType, "type");
    return new KTypeProjection(KVariance.OUT, paramKType);
  }
  
  @NotNull
  public final KTypeProjection getSTAR()
  {
    return KTypeProjection.access$getSTAR$cp();
  }
  
  @NotNull
  public final KTypeProjection invariant(@NotNull KType paramKType)
  {
    Intrinsics.checkParameterIsNotNull(paramKType, "type");
    return new KTypeProjection(KVariance.INVARIANT, paramKType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.reflect.KTypeProjection.Companion
 * JD-Core Version:    0.7.0.1
 */