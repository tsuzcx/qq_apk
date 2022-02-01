package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import org.jetbrains.annotations.NotNull;

final class ClassDeclaredMemberIndex$methodFilter$1
  extends Lambda
  implements Function1<JavaMethod, Boolean>
{
  ClassDeclaredMemberIndex$methodFilter$1(ClassDeclaredMemberIndex paramClassDeclaredMemberIndex)
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull JavaMethod paramJavaMethod)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaMethod, "m");
    return (((Boolean)ClassDeclaredMemberIndex.access$getMemberFilter$p(this.this$0).invoke(paramJavaMethod)).booleanValue()) && (!DescriptorResolverUtils.isObjectMethodInInterface((JavaMember)paramJavaMethod));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex.methodFilter.1
 * JD-Core Version:    0.7.0.1
 */