package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Method;", "unboxMethod", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "member", "getMember", "()Ljava/lang/reflect/Method;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "callMethod", "", "instance", "args", "", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "Bound", "Unbound", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public abstract class InternalUnderlyingValOfInlineClass
  implements Caller<Method>
{
  @NotNull
  private final List<Type> parameterTypes;
  @NotNull
  private final Type returnType;
  private final Method unboxMethod;
  
  private InternalUnderlyingValOfInlineClass(Method paramMethod, List<? extends Type> paramList)
  {
    this.unboxMethod = paramMethod;
    this.parameterTypes = paramList;
    paramMethod = this.unboxMethod.getReturnType();
    Intrinsics.checkExpressionValueIsNotNull(paramMethod, "unboxMethod.returnType");
    this.returnType = ((Type)paramMethod);
  }
  
  @Nullable
  protected final Object callMethod(@Nullable Object paramObject, @NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    return this.unboxMethod.invoke(paramObject, Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length));
  }
  
  public void checkArguments(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    Caller.DefaultImpls.checkArguments(this, paramArrayOfObject);
  }
  
  @Nullable
  public final Method getMember()
  {
    return null;
  }
  
  @NotNull
  public final List<Type> getParameterTypes()
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
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass
 * JD-Core Version:    0.7.0.1
 */