package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty2.Getter;

public class PropertyReference2Impl
  extends PropertyReference2
{
  private final String name;
  private final KDeclarationContainer owner;
  private final String signature;
  
  public PropertyReference2Impl(KDeclarationContainer paramKDeclarationContainer, String paramString1, String paramString2)
  {
    this.owner = paramKDeclarationContainer;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public Object get(Object paramObject1, Object paramObject2)
  {
    return getGetter().call(new Object[] { paramObject1, paramObject2 });
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public KDeclarationContainer getOwner()
  {
    return this.owner;
  }
  
  public String getSignature()
  {
    return this.signature;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.jvm.internal.PropertyReference2Impl
 * JD-Core Version:    0.7.0.1
 */