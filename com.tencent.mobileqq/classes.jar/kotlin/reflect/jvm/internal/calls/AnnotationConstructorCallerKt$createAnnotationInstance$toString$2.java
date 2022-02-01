package kotlin.reflect.jvm.internal.calls;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "invoke"}, k=3, mv={1, 1, 16})
final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$2
  extends Lambda
  implements Function0<String>
{
  AnnotationConstructorCallerKt$createAnnotationInstance$toString$2(Class paramClass, Map paramMap)
  {
    super(0);
  }
  
  @NotNull
  public final String invoke()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('@');
    ((StringBuilder)localObject).append(this.$annotationClass.getCanonicalName());
    CollectionsKt.joinTo$default((Iterable)this.$values.entrySet(), (Appendable)localObject, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, (Function1)AnnotationConstructorCallerKt.createAnnotationInstance.toString.2.1.1.INSTANCE, 48, null);
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance.toString.2
 * JD-Core Version:    0.7.0.1
 */