package kotlin.reflect.full;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, k=3, mv={1, 1, 16})
final class KTypes$withNullability$1
  extends Lambda
  implements Function0<Type>
{
  KTypes$withNullability$1(KType paramKType)
  {
    super(0);
  }
  
  @NotNull
  public final Type invoke()
  {
    return ((KTypeImpl)this.$this_withNullability).getJavaType$kotlin_reflection();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KTypes.withNullability.1
 * JD-Core Version:    0.7.0.1
 */