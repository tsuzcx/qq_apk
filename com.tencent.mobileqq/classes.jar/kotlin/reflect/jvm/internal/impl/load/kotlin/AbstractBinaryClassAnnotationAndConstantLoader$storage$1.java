package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class AbstractBinaryClassAnnotationAndConstantLoader$storage$1
  extends Lambda
  implements Function1<KotlinJvmBinaryClass, AbstractBinaryClassAnnotationAndConstantLoader.Storage<? extends A, ? extends C>>
{
  AbstractBinaryClassAnnotationAndConstantLoader$storage$1(AbstractBinaryClassAnnotationAndConstantLoader paramAbstractBinaryClassAnnotationAndConstantLoader)
  {
    super(1);
  }
  
  @NotNull
  public final AbstractBinaryClassAnnotationAndConstantLoader.Storage<A, C> invoke(@NotNull KotlinJvmBinaryClass paramKotlinJvmBinaryClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinJvmBinaryClass, "kotlinClass");
    return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationsAndInitializers(this.this$0, paramKotlinJvmBinaryClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.storage.1
 * JD-Core Version:    0.7.0.1
 */