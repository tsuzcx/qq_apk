package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class CallerImpl$BoundConstructor
  extends CallerImpl<Constructor<?>>
  implements BoundCaller
{
  private final Object boundReceiver;
  
  public CallerImpl$BoundConstructor(@NotNull Constructor<?> paramConstructor, @Nullable Object paramObject)
  {
    super(localMember, (Type)localObject, null, paramConstructor, null);
    this.boundReceiver = paramObject;
  }
  
  @Nullable
  public Object call(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    checkArguments(paramArrayOfObject);
    Constructor localConstructor = (Constructor)getMember();
    SpreadBuilder localSpreadBuilder = new SpreadBuilder(2);
    localSpreadBuilder.add(this.boundReceiver);
    localSpreadBuilder.addSpread(paramArrayOfObject);
    return localConstructor.newInstance(localSpreadBuilder.toArray(new Object[localSpreadBuilder.size()]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.CallerImpl.BoundConstructor
 * JD-Core Version:    0.7.0.1
 */