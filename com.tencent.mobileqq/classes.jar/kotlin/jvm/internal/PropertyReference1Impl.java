package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1.Getter;

public class PropertyReference1Impl
  extends PropertyReference1
{
  private final String name;
  private final KDeclarationContainer owner;
  private final String signature;
  
  public PropertyReference1Impl(KDeclarationContainer paramKDeclarationContainer, String paramString1, String paramString2)
  {
    this.owner = paramKDeclarationContainer;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public Object get(Object paramObject)
  {
    return getGetter().call(new Object[] { paramObject });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.jvm.internal.PropertyReference1Impl
 * JD-Core Version:    0.7.0.1
 */