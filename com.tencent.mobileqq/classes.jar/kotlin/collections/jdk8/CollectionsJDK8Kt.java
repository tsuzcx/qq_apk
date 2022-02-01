package kotlin.collections.jdk8;

import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getOrDefault", "V", "K", "Lkotlin/internal/OnlyInputTypes;", "", "key", "defaultValue", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "", "value", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlin-stdlib-jdk8"}, k=2, mv={1, 1, 16}, pn="kotlin.collections")
@JvmName(name="CollectionsJDK8Kt")
public final class CollectionsJDK8Kt
{
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final <K, V> V getOrDefault(@NotNull Map<? extends K, ? extends V> paramMap, K paramK, V paramV)
  {
    if (paramMap != null) {
      return paramMap.getOrDefault(paramK, paramV);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
  }
  
  @SinceKotlin(version="1.2")
  @InlineOnly
  private static final <K, V> boolean remove(@NotNull Map<? extends K, ? extends V> paramMap, K paramK, V paramV)
  {
    if (paramMap != null) {
      return TypeIntrinsics.asMutableMap(paramMap).remove(paramK, paramV);
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     kotlin.collections.jdk8.CollectionsJDK8Kt
 * JD-Core Version:    0.7.0.1
 */