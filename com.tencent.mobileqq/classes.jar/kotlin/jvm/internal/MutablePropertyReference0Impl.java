package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KMutableProperty0.Setter;
import kotlin.reflect.KProperty0.Getter;

public class MutablePropertyReference0Impl
  extends MutablePropertyReference0
{
  private final String name;
  private final KDeclarationContainer owner;
  private final String signature;
  
  public MutablePropertyReference0Impl(KDeclarationContainer paramKDeclarationContainer, String paramString1, String paramString2)
  {
    this.owner = paramKDeclarationContainer;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public Object get()
  {
    return getGetter().call(new Object[0]);
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
  
  public void set(Object paramObject)
  {
    getSetter().call(new Object[] { paramObject });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.jvm.internal.MutablePropertyReference0Impl
 * JD-Core Version:    0.7.0.1
 */