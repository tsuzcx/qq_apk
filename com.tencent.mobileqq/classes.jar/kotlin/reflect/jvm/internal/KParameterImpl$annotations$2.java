package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "invoke"}, k=3, mv={1, 1, 16})
final class KParameterImpl$annotations$2
  extends Lambda
  implements Function0<List<? extends Annotation>>
{
  KParameterImpl$annotations$2(KParameterImpl paramKParameterImpl)
  {
    super(0);
  }
  
  @NotNull
  public final List<Annotation> invoke()
  {
    return UtilKt.computeAnnotations((Annotated)KParameterImpl.access$getDescriptor$p(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KParameterImpl.annotations.2
 * JD-Core Version:    0.7.0.1
 */