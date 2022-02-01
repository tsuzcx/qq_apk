package kotlin.collections;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getValue", "V1", "V", "", "", "Lkotlin/internal/Exact;", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "", "getVarContravariant", "getVar", "setValue", "", "value", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="MapAccessorsKt")
public final class MapAccessorsKt
{
  @InlineOnly
  private static final <V, V1 extends V> V1 getValue(@NotNull Map<? super String, ? extends V> paramMap, Object paramObject, KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$getValue");
    return MapsKt.getOrImplicitDefaultNullable(paramMap, paramKProperty.getName());
  }
  
  @InlineOnly
  @JvmName(name="getVar")
  private static final <V, V1 extends V> V1 getVar(@NotNull Map<? super String, ? extends V> paramMap, Object paramObject, KProperty<?> paramKProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$getValue");
    return MapsKt.getOrImplicitDefaultNullable(paramMap, paramKProperty.getName());
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="Use getValue() with two type parameters instead")
  @InlineOnly
  @LowPriorityInOverloadResolution
  @JvmName(name="getVarContravariant")
  private static final <V> V getVarContravariant(@NotNull Map<? super String, ? super V> paramMap, Object paramObject, KProperty<?> paramKProperty)
  {
    return MapsKt.getOrImplicitDefaultNullable(paramMap, paramKProperty.getName());
  }
  
  @InlineOnly
  private static final <V> void setValue(@NotNull Map<? super String, ? super V> paramMap, Object paramObject, KProperty<?> paramKProperty, V paramV)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$setValue");
    paramMap.put(paramKProperty.getName(), paramV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.MapAccessorsKt
 * JD-Core Version:    0.7.0.1
 */