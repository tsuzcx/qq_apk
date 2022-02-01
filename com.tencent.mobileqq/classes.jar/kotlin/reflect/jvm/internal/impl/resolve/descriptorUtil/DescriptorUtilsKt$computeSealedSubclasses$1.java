package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls;
import org.jetbrains.annotations.NotNull;

final class DescriptorUtilsKt$computeSealedSubclasses$1
  extends Lambda
  implements Function2<MemberScope, Boolean, Unit>
{
  DescriptorUtilsKt$computeSealedSubclasses$1(ClassDescriptor paramClassDescriptor, LinkedHashSet paramLinkedHashSet)
  {
    super(2);
  }
  
  public final void invoke(@NotNull MemberScope paramMemberScope, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramMemberScope, "scope");
    paramMemberScope = ResolutionScope.DefaultImpls.getContributedDescriptors$default(paramMemberScope, DescriptorKindFilter.CLASSIFIERS, null, 2, null).iterator();
    while (paramMemberScope.hasNext())
    {
      Object localObject2 = (DeclarationDescriptor)paramMemberScope.next();
      if ((localObject2 instanceof ClassDescriptor))
      {
        Object localObject1 = (ClassDescriptor)localObject2;
        if (DescriptorUtils.isDirectSubclass((ClassDescriptor)localObject1, this.$sealedClass)) {
          this.$result.add(localObject2);
        }
        if (paramBoolean)
        {
          localObject2 = (1)this;
          localObject1 = ((ClassDescriptor)localObject1).getUnsubstitutedInnerClassesScope();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "descriptor.unsubstitutedInnerClassesScope");
          ((1)localObject2).invoke((MemberScope)localObject1, paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.computeSealedSubclasses.1
 * JD-Core Version:    0.7.0.1
 */