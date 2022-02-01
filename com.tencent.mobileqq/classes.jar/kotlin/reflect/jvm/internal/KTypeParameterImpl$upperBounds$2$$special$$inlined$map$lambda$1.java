package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "kotlin/reflect/jvm/internal/KTypeParameterImpl$upperBounds$2$1$1"}, k=3, mv={1, 1, 16})
final class KTypeParameterImpl$upperBounds$2$$special$$inlined$map$lambda$1
  extends Lambda
  implements Function0
{
  KTypeParameterImpl$upperBounds$2$$special$$inlined$map$lambda$1(KTypeParameterImpl.upperBounds.2 param2)
  {
    super(0);
  }
  
  @NotNull
  public final Void invoke()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Java type is not yet supported for type parameters: ");
    ((StringBuilder)localObject).append(this.this$0.this$0.getDescriptor());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append((String)localObject);
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KTypeParameterImpl.upperBounds.2..special..inlined.map.lambda.1
 * JD-Core Version:    0.7.0.1
 */