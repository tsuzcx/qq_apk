package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KCallableImpl$_returnType$1
  extends Lambda
  implements Function0<KTypeImpl>
{
  KCallableImpl$_returnType$1(KCallableImpl paramKCallableImpl)
  {
    super(0);
  }
  
  @NotNull
  public final KTypeImpl invoke()
  {
    KotlinType localKotlinType = this.this$0.getDescriptor().getReturnType();
    if (localKotlinType == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "descriptor.returnType!!");
    return new KTypeImpl(localKotlinType, (Function0)new KCallableImpl._returnType.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KCallableImpl._returnType.1
 * JD-Core Version:    0.7.0.1
 */