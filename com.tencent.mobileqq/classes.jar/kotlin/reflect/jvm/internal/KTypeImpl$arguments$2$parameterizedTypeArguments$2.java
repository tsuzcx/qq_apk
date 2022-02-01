package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"}, k=3, mv={1, 1, 16})
final class KTypeImpl$arguments$2$parameterizedTypeArguments$2
  extends Lambda
  implements Function0<List<? extends Type>>
{
  KTypeImpl$arguments$2$parameterizedTypeArguments$2(KTypeImpl.arguments.2 param2)
  {
    super(0);
  }
  
  @NotNull
  public final List<Type> invoke()
  {
    return ReflectClassUtilKt.getParameterizedTypeArguments(this.this$0.this$0.getJavaType$kotlin_reflection());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KTypeImpl.arguments.2.parameterizedTypeArguments.2
 * JD-Core Version:    0.7.0.1
 */