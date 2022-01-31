package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.SinceKotlin;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;

public abstract class CallableReference
  implements Serializable, KCallable
{
  @SinceKotlin(version="1.1")
  public static final Object NO_RECEIVER = ;
  @SinceKotlin(version="1.1")
  protected final Object receiver;
  private transient KCallable reflected;
  
  public CallableReference()
  {
    this(NO_RECEIVER);
  }
  
  @SinceKotlin(version="1.1")
  protected CallableReference(Object paramObject)
  {
    this.receiver = paramObject;
  }
  
  public Object call(Object... paramVarArgs)
  {
    return getReflected().call(paramVarArgs);
  }
  
  public Object callBy(Map paramMap)
  {
    return getReflected().callBy(paramMap);
  }
  
  @SinceKotlin(version="1.1")
  public KCallable compute()
  {
    KCallable localKCallable2 = this.reflected;
    KCallable localKCallable1 = localKCallable2;
    if (localKCallable2 == null)
    {
      localKCallable1 = computeReflected();
      this.reflected = localKCallable1;
    }
    return localKCallable1;
  }
  
  protected abstract KCallable computeReflected();
  
  public List<Annotation> getAnnotations()
  {
    return getReflected().getAnnotations();
  }
  
  @SinceKotlin(version="1.1")
  public Object getBoundReceiver()
  {
    return this.receiver;
  }
  
  public String getName()
  {
    throw new AbstractMethodError();
  }
  
  public KDeclarationContainer getOwner()
  {
    throw new AbstractMethodError();
  }
  
  public List<KParameter> getParameters()
  {
    return getReflected().getParameters();
  }
  
  @SinceKotlin(version="1.1")
  protected KCallable getReflected()
  {
    KCallable localKCallable = compute();
    if (localKCallable == this) {
      throw new KotlinReflectionNotSupportedError();
    }
    return localKCallable;
  }
  
  public KType getReturnType()
  {
    return getReflected().getReturnType();
  }
  
  public String getSignature()
  {
    throw new AbstractMethodError();
  }
  
  @SinceKotlin(version="1.1")
  public List<KTypeParameter> getTypeParameters()
  {
    return getReflected().getTypeParameters();
  }
  
  @SinceKotlin(version="1.1")
  public KVisibility getVisibility()
  {
    return getReflected().getVisibility();
  }
  
  @SinceKotlin(version="1.1")
  public boolean isAbstract()
  {
    return getReflected().isAbstract();
  }
  
  @SinceKotlin(version="1.1")
  public boolean isFinal()
  {
    return getReflected().isFinal();
  }
  
  @SinceKotlin(version="1.1")
  public boolean isOpen()
  {
    return getReflected().isOpen();
  }
  
  @SinceKotlin(version="1.3")
  public boolean isSuspend()
  {
    return getReflected().isSuspend();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.jvm.internal.CallableReference
 * JD-Core Version:    0.7.0.1
 */