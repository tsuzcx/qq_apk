package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KTypeProjection;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lkotlin/reflect/KTypeProjection;", "invoke"}, k=3, mv={1, 1, 16})
final class TypeReference$asString$args$1
  extends Lambda
  implements Function1<KTypeProjection, String>
{
  TypeReference$asString$args$1(TypeReference paramTypeReference)
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull KTypeProjection paramKTypeProjection)
  {
    Intrinsics.checkParameterIsNotNull(paramKTypeProjection, "it");
    return TypeReference.access$asString(this.this$0, paramKTypeProjection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.jvm.internal.TypeReference.asString.args.1
 * JD-Core Version:    0.7.0.1
 */