package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.TypeCastException;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public abstract class WrappedType
  extends KotlinType
{
  public WrappedType()
  {
    super(null);
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return getDelegate().getAnnotations();
  }
  
  @NotNull
  public List<TypeProjection> getArguments()
  {
    return getDelegate().getArguments();
  }
  
  @NotNull
  public TypeConstructor getConstructor()
  {
    return getDelegate().getConstructor();
  }
  
  @NotNull
  protected abstract KotlinType getDelegate();
  
  @NotNull
  public MemberScope getMemberScope()
  {
    return getDelegate().getMemberScope();
  }
  
  public boolean isComputed()
  {
    return true;
  }
  
  public boolean isMarkedNullable()
  {
    return getDelegate().isMarkedNullable();
  }
  
  @NotNull
  public String toString()
  {
    if (isComputed()) {
      return getDelegate().toString();
    }
    return "<Not computed yet>";
  }
  
  @NotNull
  public final UnwrappedType unwrap()
  {
    for (Object localObject = getDelegate(); (localObject instanceof WrappedType); localObject = ((WrappedType)localObject).getDelegate()) {}
    if (localObject != null) {
      return (UnwrappedType)localObject;
    }
    localObject = new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.WrappedType
 * JD-Core Version:    0.7.0.1
 */