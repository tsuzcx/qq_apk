package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl.Companion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getExtensionDelegate", "", "Lkotlin/reflect/KProperty1;", "D", "Lkotlin/reflect/KProperty2;", "receiver", "(Lkotlin/reflect/KProperty2;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=2, mv={1, 1, 16})
@JvmName(name="KProperties")
public final class KProperties
{
  @SinceKotlin(version="1.1")
  @Nullable
  public static final Object getExtensionDelegate(@NotNull KProperty1<?, ?> paramKProperty1)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty1, "$this$getExtensionDelegate");
    return paramKProperty1.getDelegate(KPropertyImpl.Companion.getEXTENSION_PROPERTY_DELEGATE());
  }
  
  @SinceKotlin(version="1.1")
  @Nullable
  public static final <D> Object getExtensionDelegate(@NotNull KProperty2<D, ?, ?> paramKProperty2, D paramD)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty2, "$this$getExtensionDelegate");
    return paramKProperty2.getDelegate(paramD, KPropertyImpl.Companion.getEXTENSION_PROPERTY_DELEGATE());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KProperties
 * JD-Core Version:    0.7.0.1
 */