package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class CallerImpl$AccessorForHiddenConstructor
  extends CallerImpl<Constructor<?>>
{
  public CallerImpl$AccessorForHiddenConstructor(@NotNull Constructor<?> paramConstructor)
  {
    super(localMember, (Type)localObject, null, (Type[])paramConstructor, null);
    return;
    label84:
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  @Nullable
  public Object call(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    checkArguments(paramArrayOfObject);
    Constructor localConstructor = (Constructor)getMember();
    SpreadBuilder localSpreadBuilder = new SpreadBuilder(2);
    localSpreadBuilder.addSpread(paramArrayOfObject);
    localSpreadBuilder.add(null);
    return localConstructor.newInstance(localSpreadBuilder.toArray(new Object[localSpreadBuilder.size()]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.CallerImpl.AccessorForHiddenConstructor
 * JD-Core Version:    0.7.0.1
 */