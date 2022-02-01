package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

final class LazyJavaClassDescriptor$scopeHolder$1
  extends Lambda
  implements Function1<KotlinTypeRefiner, LazyJavaClassMemberScope>
{
  LazyJavaClassDescriptor$scopeHolder$1(LazyJavaClassDescriptor paramLazyJavaClassDescriptor)
  {
    super(1);
  }
  
  @NotNull
  public final LazyJavaClassMemberScope invoke(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    paramKotlinTypeRefiner = LazyJavaClassDescriptor.access$getC$p(this.this$0);
    Object localObject = this.this$0;
    ClassDescriptor localClassDescriptor = (ClassDescriptor)localObject;
    localObject = ((LazyJavaClassDescriptor)localObject).getJClass();
    boolean bool;
    if (LazyJavaClassDescriptor.access$getAdditionalSupertypeClassDescriptor$p(this.this$0) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return new LazyJavaClassMemberScope(paramKotlinTypeRefiner, localClassDescriptor, (JavaClass)localObject, bool, LazyJavaClassDescriptor.access$getUnsubstitutedMemberScope$p(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor.scopeHolder.1
 * JD-Core Version:    0.7.0.1
 */