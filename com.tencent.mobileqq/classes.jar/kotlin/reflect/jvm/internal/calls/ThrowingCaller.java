package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/ThrowingCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "()V", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class ThrowingCaller
  implements Caller
{
  public static final ThrowingCaller INSTANCE = new ThrowingCaller();
  
  @Nullable
  public Object call(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    throw ((Throwable)new UnsupportedOperationException("call/callBy are not supported for this declaration."));
  }
  
  @Nullable
  public Void getMember()
  {
    return null;
  }
  
  @NotNull
  public List<Type> getParameterTypes()
  {
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  public Type getReturnType()
  {
    Class localClass = Void.TYPE;
    Intrinsics.checkExpressionValueIsNotNull(localClass, "Void.TYPE");
    return (Type)localClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.ThrowingCaller
 * JD-Core Version:    0.7.0.1
 */