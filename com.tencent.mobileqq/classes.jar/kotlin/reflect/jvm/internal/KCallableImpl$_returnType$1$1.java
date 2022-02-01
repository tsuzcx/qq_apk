package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Type;", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KCallableImpl$_returnType$1$1
  extends Lambda
  implements Function0<Type>
{
  KCallableImpl$_returnType$1$1(KCallableImpl._returnType.1 param1)
  {
    super(0);
  }
  
  @NotNull
  public final Type invoke()
  {
    Type localType = KCallableImpl.access$extractContinuationArgument(this.this$0.this$0);
    if (localType != null) {
      return localType;
    }
    return this.this$0.this$0.getCaller().getReturnType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KCallableImpl._returnType.1.1
 * JD-Core Version:    0.7.0.1
 */