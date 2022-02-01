package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltInsSettings$notConsideredDeprecation$2
  extends Lambda
  implements Function0<Annotations>
{
  JvmBuiltInsSettings$notConsideredDeprecation$2(JvmBuiltInsSettings paramJvmBuiltInsSettings)
  {
    super(0);
  }
  
  @NotNull
  public final Annotations invoke()
  {
    AnnotationDescriptor localAnnotationDescriptor = AnnotationUtilKt.createDeprecatedAnnotation$default(JvmBuiltInsSettings.access$getModuleDescriptor$p(this.this$0).getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null);
    return Annotations.Companion.create(CollectionsKt.listOf(localAnnotationDescriptor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsSettings.notConsideredDeprecation.2
 * JD-Core Version:    0.7.0.1
 */