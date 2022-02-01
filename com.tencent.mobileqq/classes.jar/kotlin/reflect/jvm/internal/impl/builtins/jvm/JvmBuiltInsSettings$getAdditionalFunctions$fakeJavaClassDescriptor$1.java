package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltInsSettings$getAdditionalFunctions$fakeJavaClassDescriptor$1
  extends Lambda
  implements Function0<LazyJavaClassDescriptor>
{
  JvmBuiltInsSettings$getAdditionalFunctions$fakeJavaClassDescriptor$1(LazyJavaClassDescriptor paramLazyJavaClassDescriptor, ClassDescriptor paramClassDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final LazyJavaClassDescriptor invoke()
  {
    LazyJavaClassDescriptor localLazyJavaClassDescriptor = this.$javaAnalogueDescriptor;
    JavaResolverCache localJavaResolverCache = JavaResolverCache.EMPTY;
    Intrinsics.checkExpressionValueIsNotNull(localJavaResolverCache, "JavaResolverCache.EMPTY");
    return localLazyJavaClassDescriptor.copy$descriptors_jvm(localJavaResolverCache, this.$kotlinMutableClassIfContainer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.getAdditionalFunctions.fakeJavaClassDescriptor.1
 * JD-Core Version:    0.7.0.1
 */