package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "getInstanceClass", "()Ljava/lang/Class;", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/reflect/Type;", "checkObjectInstance", "", "obj", "", "AccessorForHiddenBoundConstructor", "AccessorForHiddenConstructor", "BoundConstructor", "Companion", "Constructor", "FieldGetter", "FieldSetter", "Method", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public abstract class CallerImpl<M extends Member>
  implements Caller<M>
{
  public static final CallerImpl.Companion Companion = new CallerImpl.Companion(null);
  @Nullable
  private final Class<?> instanceClass;
  @NotNull
  private final M member;
  @NotNull
  private final List<Type> parameterTypes;
  @NotNull
  private final Type returnType;
  
  private CallerImpl(M paramM, Type paramType, Class<?> paramClass, Type[] paramArrayOfType)
  {
    this.member = paramM;
    this.returnType = paramType;
    this.instanceClass = paramClass;
    paramM = this.instanceClass;
    if (paramM != null)
    {
      paramType = new SpreadBuilder(2);
      paramType.add((Type)paramM);
      paramType.addSpread(paramArrayOfType);
      paramM = CollectionsKt.listOf((Type[])paramType.toArray(new Type[paramType.size()]));
      if (paramM != null) {}
    }
    else
    {
      paramM = ArraysKt.toList(paramArrayOfType);
    }
    this.parameterTypes = paramM;
  }
  
  public void checkArguments(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    Caller.DefaultImpls.checkArguments(this, paramArrayOfObject);
  }
  
  protected final void checkObjectInstance(@Nullable Object paramObject)
  {
    if ((paramObject != null) && (this.member.getDeclaringClass().isInstance(paramObject))) {
      return;
    }
    throw ((Throwable)new IllegalArgumentException("An object member requires the object instance passed as the first argument."));
  }
  
  @Nullable
  public final Class<?> getInstanceClass()
  {
    return this.instanceClass;
  }
  
  @NotNull
  public final M getMember()
  {
    return this.member;
  }
  
  @NotNull
  public List<Type> getParameterTypes()
  {
    return this.parameterTypes;
  }
  
  @NotNull
  public final Type getReturnType()
  {
    return this.returnType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.CallerImpl
 * JD-Core Version:    0.7.0.1
 */