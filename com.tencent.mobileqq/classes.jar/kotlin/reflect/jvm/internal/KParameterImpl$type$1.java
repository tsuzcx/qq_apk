package kotlin.reflect.jvm.internal;

import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Type;", "invoke"}, k=3, mv={1, 1, 16})
final class KParameterImpl$type$1
  extends Lambda
  implements Function0<Type>
{
  KParameterImpl$type$1(KParameterImpl paramKParameterImpl)
  {
    super(0);
  }
  
  @NotNull
  public final Type invoke()
  {
    ParameterDescriptor localParameterDescriptor = KParameterImpl.access$getDescriptor$p(this.this$0);
    if (((localParameterDescriptor instanceof ReceiverParameterDescriptor)) && (Intrinsics.areEqual(UtilKt.getInstanceReceiverParameter((CallableDescriptor)this.this$0.getCallable().getDescriptor()), localParameterDescriptor)) && (this.this$0.getCallable().getDescriptor().getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE))
    {
      Object localObject = this.this$0.getCallable().getDescriptor().getContainingDeclaration();
      if (localObject != null)
      {
        localObject = UtilKt.toJavaClass((ClassDescriptor)localObject);
        if (localObject != null) {
          return (Type)localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot determine receiver Java type of inherited declaration: ");
        ((StringBuilder)localObject).append(localParameterDescriptor);
        throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject).toString()));
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }
    return (Type)this.this$0.getCallable().getCaller().getParameterTypes().get(this.this$0.getIndex());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KParameterImpl.type.1
 * JD-Core Version:    0.7.0.1
 */