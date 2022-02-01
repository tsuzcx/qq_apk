package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectKotlinClass$Factory
{
  @Nullable
  public final ReflectKotlinClass create(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    Object localObject = new ReadKotlinClassHeaderAnnotationVisitor();
    ReflectClassStructure.INSTANCE.loadClassAnnotations(paramClass, (KotlinJvmBinaryClass.AnnotationVisitor)localObject);
    localObject = ((ReadKotlinClassHeaderAnnotationVisitor)localObject).createHeader();
    if (localObject != null) {
      return new ReflectKotlinClass(paramClass, (KotlinClassHeader)localObject, null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass.Factory
 * JD-Core Version:    0.7.0.1
 */