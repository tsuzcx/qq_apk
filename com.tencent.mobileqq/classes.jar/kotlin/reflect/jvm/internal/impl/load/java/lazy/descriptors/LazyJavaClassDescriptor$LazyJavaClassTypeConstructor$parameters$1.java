package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import org.jetbrains.annotations.NotNull;

final class LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1
  extends Lambda
  implements Function0<List<? extends TypeParameterDescriptor>>
{
  LazyJavaClassDescriptor$LazyJavaClassTypeConstructor$parameters$1(LazyJavaClassDescriptor.LazyJavaClassTypeConstructor paramLazyJavaClassTypeConstructor)
  {
    super(0);
  }
  
  @NotNull
  public final List<TypeParameterDescriptor> invoke()
  {
    return TypeParameterUtilsKt.computeConstructorTypeParameters((ClassifierDescriptorWithTypeParameters)this.this$0.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.LazyJavaClassTypeConstructor.parameters.1
 * JD-Core Version:    0.7.0.1
 */