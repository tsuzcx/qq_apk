package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectKotlinClass
  implements KotlinJvmBinaryClass
{
  public static final ReflectKotlinClass.Factory Factory = new ReflectKotlinClass.Factory(null);
  @NotNull
  private final KotlinClassHeader classHeader;
  @NotNull
  private final Class<?> klass;
  
  private ReflectKotlinClass(Class<?> paramClass, KotlinClassHeader paramKotlinClassHeader)
  {
    this.klass = paramClass;
    this.classHeader = paramKotlinClassHeader;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof ReflectKotlinClass)) && (Intrinsics.areEqual(this.klass, ((ReflectKotlinClass)paramObject).klass));
  }
  
  @NotNull
  public KotlinClassHeader getClassHeader()
  {
    return this.classHeader;
  }
  
  @NotNull
  public ClassId getClassId()
  {
    return ReflectClassUtilKt.getClassId(this.klass);
  }
  
  @NotNull
  public final Class<?> getKlass()
  {
    return this.klass;
  }
  
  @NotNull
  public String getLocation()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = this.klass.getName();
    Intrinsics.checkExpressionValueIsNotNull(str, "klass.name");
    localStringBuilder.append(StringsKt.replace$default(str, '.', '/', false, 4, null));
    localStringBuilder.append(".class");
    return localStringBuilder.toString();
  }
  
  public int hashCode()
  {
    return this.klass.hashCode();
  }
  
  public void loadClassAnnotations(@NotNull KotlinJvmBinaryClass.AnnotationVisitor paramAnnotationVisitor, @Nullable byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationVisitor, "visitor");
    ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, paramAnnotationVisitor);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(": ");
    localStringBuilder.append(this.klass);
    return localStringBuilder.toString();
  }
  
  public void visitMembers(@NotNull KotlinJvmBinaryClass.MemberVisitor paramMemberVisitor, @Nullable byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramMemberVisitor, "visitor");
    ReflectClassStructure.INSTANCE.visitMembers(this.klass, paramMemberVisitor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass
 * JD-Core Version:    0.7.0.1
 */