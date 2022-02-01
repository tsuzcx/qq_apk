package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/MapWithDefault;", "K", "V", "", "map", "getMap", "()Ljava/util/Map;", "getOrImplicitDefault", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
abstract interface MapWithDefault<K, V>
  extends Map<K, V>, KMappedMarker
{
  @NotNull
  public abstract Map<K, V> getMap();
  
  public abstract V getOrImplicitDefault(K paramK);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.MapWithDefault
 * JD-Core Version:    0.7.0.1
 */