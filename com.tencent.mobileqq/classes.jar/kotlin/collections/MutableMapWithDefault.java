package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/MutableMapWithDefault;", "K", "V", "", "Lkotlin/collections/MapWithDefault;", "map", "getMap", "()Ljava/util/Map;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
abstract interface MutableMapWithDefault<K, V>
  extends Map<K, V>, MapWithDefault<K, V>, KMutableMap
{
  @NotNull
  public abstract Map<K, V> getMap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.MutableMapWithDefault
 * JD-Core Version:    0.7.0.1
 */