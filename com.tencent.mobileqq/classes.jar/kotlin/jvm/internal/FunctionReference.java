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
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof FunctionReference))
    {
      paramObject = (FunctionReference)paramObject;
      return (getOwner() == null ? paramObject.getOwner() == null : getOwner().equals(paramObject.getOwner())) && (getName().equals(paramObject.getName())) && (getSignature().equals(paramObject.getSignature())) && (Intrinsics.areEqual(getBoundReceiver(), paramObject.getBoundReceiver()));
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
    int i;
    if (getOwner() == null) {
      i = 0;
    } else {
      i = getOwner().hashCode() * 31;
    }
    return (i + getName().hashCode()) * 31 + getSignature().hashCode();
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
    Object localObject = compute();
    if (localObject != this) {
      return localObject.toString();
    }
    if ("<init>".equals(getName())) {
      return "constructor (Kotlin reflection is not available)";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("function ");
    ((StringBuilder)localObject).append(getName());
    ((StringBuilder)localObject).append(" (Kotlin reflection is not available)");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.jvm.internal.FunctionReference
 * JD-Core Version:    0.7.0.1
 */