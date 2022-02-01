package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, k=3, mv={1, 1, 16})
final class KClassImpl$Data$objectInstance$2
  extends Lambda
  implements Function0<T>
{
  KClassImpl$Data$objectInstance$2(KClassImpl.Data paramData)
  {
    super(0);
  }
  
  @Nullable
  public final T invoke()
  {
    Object localObject = this.this$0.getDescriptor();
    if (((ClassDescriptor)localObject).getKind() != ClassKind.OBJECT) {
      return null;
    }
    if ((((ClassDescriptor)localObject).isCompanionObject()) && (!CompanionObjectMapping.INSTANCE.isMappedIntrinsicCompanionObject((ClassDescriptor)localObject))) {
      localObject = this.this$0.this$0.getJClass().getEnclosingClass().getDeclaredField(((ClassDescriptor)localObject).getName().asString());
    } else {
      localObject = this.this$0.this$0.getJClass().getDeclaredField("INSTANCE");
    }
    localObject = ((Field)localObject).get(null);
    if (localObject != null) {
      return localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type T");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data.objectInstance.2
 * JD-Core Version:    0.7.0.1
 */