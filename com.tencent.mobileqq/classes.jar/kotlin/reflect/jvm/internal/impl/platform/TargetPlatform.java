package kotlin.reflect.jvm.internal.impl.platform;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TargetPlatform
  implements Collection<SimplePlatform>, KMappedMarker
{
  @NotNull
  private final Set<SimplePlatform> componentPlatforms;
  
  public boolean addAll(Collection<? extends SimplePlatform> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean contains(@NotNull SimplePlatform paramSimplePlatform)
  {
    Intrinsics.checkParameterIsNotNull(paramSimplePlatform, "element");
    return this.componentPlatforms.contains(paramSimplePlatform);
  }
  
  public boolean containsAll(@NotNull Collection<? extends Object> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    return this.componentPlatforms.containsAll(paramCollection);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((TargetPlatform)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof TargetPlatform)) {
      return false;
    }
    return !(Intrinsics.areEqual(this.componentPlatforms, ((TargetPlatform)paramObject).componentPlatforms) ^ true);
  }
  
  @NotNull
  public final Set<SimplePlatform> getComponentPlatforms()
  {
    return this.componentPlatforms;
  }
  
  public int getSize()
  {
    return this.componentPlatforms.size();
  }
  
  public int hashCode()
  {
    return this.componentPlatforms.hashCode();
  }
  
  public boolean isEmpty()
  {
    return this.componentPlatforms.isEmpty();
  }
  
  @NotNull
  public Iterator<SimplePlatform> iterator()
  {
    return this.componentPlatforms.iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean removeAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public boolean retainAll(Collection<? extends Object> paramCollection)
  {
    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
  }
  
  public final int size()
  {
    return getSize();
  }
  
  public Object[] toArray()
  {
    return CollectionToArray.toArray(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return CollectionToArray.toArray(this, paramArrayOfT);
  }
  
  @NotNull
  public String toString()
  {
    return PlatformUtilKt.getPresentableDescription(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.platform.TargetPlatform
 * JD-Core Version:    0.7.0.1
 */