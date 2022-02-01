package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KCallableImpl$_annotations$1
  extends Lambda
  implements Function0<List<? extends Annotation>>
{
  KCallableImpl$_annotations$1(KCallableImpl paramKCallableImpl)
  {
    super(0);
  }
  
  @NotNull
  public final List<Annotation> invoke()
  {
    return UtilKt.computeAnnotations((Annotated)this.this$0.getDescriptor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KCallableImpl._annotations.1
 * JD-Core Version:    0.7.0.1
 */