package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

public class FunctionReference
  extends CallableReference
  implements FunctionBase, KFunction
{
  private final int arity;
  
  public FunctionReference(int paramInt)
  {
    this.arity = paramInt;
  }
  
  @SinceKotlin(version="1.1")
  public FunctionReference(int paramInt, Object paramObject)
  {
    super(paramObject);
    this.arity = paramInt;
  }
  
  @SinceKotlin(version="1.1")
  protected KCallable computeReflected()
  {
    return Reflection.function(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof FunctionReference)) {
        break;
      }
      paramObject = (FunctionReference)paramObject;
      if (getOwner() == null) {
        if (paramObject.getOwner() != null) {}
      }
      while ((!getName().equals(paramObject.getName())) || (!getSignature().equals(paramObject.getSignature())) || (!Intrinsics.areEqual(getBoundReceiver(), paramObject.getBoundReceiver()))) {
        do
        {
          return false;
        } while (!getOwner().equals(paramObject.getOwner()));
      }
    }
    if ((paramObject instanceof KFunction)) {
      return paramObject.equals(compute());
    }
    return false;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  @SinceKotlin(version="1.1")
  protected KFunction getReflected()
  {
    return (KFunction)super.getReflected();
  }
  
  public int hashCode()
  {
    if (getOwner() == null) {}
    for (int i = 0;; i = getOwner().hashCode() * 31) {
      return (i + getName().hashCode()) * 31 + getSignature().hashCode();
    }
  }
  
  @SinceKotlin(version="1.1")
  public boolean isExternal()
  {
    return getReflected().isExternal();
  }
  
  @SinceKotlin(version="1.1")
  public boolean isInfix()
  {
    return getReflected().isInfix();
  }
  
  @SinceKotlin(version="1.1")
  public boolean isInline()
  {
    return getReflected().isInline();
  }
  
  @SinceKotlin(version="1.1")
  public boolean isOperator()
  {
    return getReflected().isOperator();
  }
  
  @SinceKotlin(version="1.1")
  public boolean isSuspend()
  {
    return getReflected().isSuspend();
  }
  
  public String toString()
  {
    KCallable localKCallable = compute();
    if (localKCallable != this) {
      return localKCallable.toString();
    }
    if ("<init>".equals(getName())) {
      return "constructor (Kotlin reflection is not available)";
    }
    return "function " + getName() + " (Kotlin reflection is not available)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.jvm.internal.FunctionReference
 * JD-Core Version:    0.7.0.1
 */