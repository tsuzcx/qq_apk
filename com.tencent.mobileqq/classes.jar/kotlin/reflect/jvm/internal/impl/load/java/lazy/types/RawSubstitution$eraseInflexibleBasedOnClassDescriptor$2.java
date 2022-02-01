package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2
  extends Lambda
  implements Function1<KotlinTypeRefiner, SimpleType>
{
  RawSubstitution$eraseInflexibleBasedOnClassDescriptor$2(ClassDescriptor paramClassDescriptor, SimpleType paramSimpleType, JavaTypeAttributes paramJavaTypeAttributes)
  {
    super(1);
  }
  
  @Nullable
  public final SimpleType invoke(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    ClassDescriptor localClassDescriptor = this.$declaration;
    Object localObject = localClassDescriptor;
    if (!(localClassDescriptor instanceof ClassDescriptor)) {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = DescriptorUtilsKt.getClassId((ClassifierDescriptor)localObject);
      if (localObject != null)
      {
        paramKotlinTypeRefiner = paramKotlinTypeRefiner.findClassAcrossModuleDependencies((ClassId)localObject);
        if (paramKotlinTypeRefiner != null)
        {
          if (Intrinsics.areEqual(paramKotlinTypeRefiner, this.$declaration)) {
            return null;
          }
          return (SimpleType)RawSubstitution.access$eraseInflexibleBasedOnClassDescriptor(RawSubstitution.INSTANCE, this.$type, paramKotlinTypeRefiner, this.$attr).getFirst();
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution.eraseInflexibleBasedOnClassDescriptor.2
 * JD-Core Version:    0.7.0.1
 */