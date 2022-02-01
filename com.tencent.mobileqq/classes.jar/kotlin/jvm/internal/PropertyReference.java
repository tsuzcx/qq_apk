package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KProperty;

public abstract class PropertyReference
  extends CallableReference
  implements KProperty
{
  public PropertyReference() {}
  
  @SinceKotlin(version="1.1")
  public PropertyReference(Object paramObject)
  {
    super(paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof PropertyReference))
    {
      paramObject = (PropertyReference)paramObject;
      return (getOwner().equals(paramObject.getOwner())) && (getName().equals(paramObject.getName())) && (getSignature().equals(paramObject.getSignature())) && (Intrinsics.areEqual(getBoundReceiver(), paramObject.getBoundReceiver()));
    }
    if ((paramObject instanceof KProperty)) {
      return paramObject.equals(compute());
    }
    return false;
  }
  
  @SinceKotlin(version="1.1")
  protected KProperty getReflected()
  {
    return (KProperty)super.getReflected();
  }
  
  public int hashCode()
  {
    return (getOwner().hashCode() * 31 + getName().hashCode()) * 31 + getSignature().hashCode();
  }
  
  @SinceKotlin(version="1.1")
  public boolean isConst()
  {
    return getReflected().isConst();
  }
  
  @SinceKotlin(version="1.1")
  public boolean isLateinit()
  {
    return getReflected().isLateinit();
  }
  
  public String toString()
  {
    Object localObject = compute();
    if (localObject != this) {
      return localObject.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("property ");
    ((StringBuilder)localObject).append(getName());
    ((StringBuilder)localObject).append(" (Kotlin reflection is not available)");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.internal.PropertyReference
 * JD-Core Version:    0.7.0.1
 */