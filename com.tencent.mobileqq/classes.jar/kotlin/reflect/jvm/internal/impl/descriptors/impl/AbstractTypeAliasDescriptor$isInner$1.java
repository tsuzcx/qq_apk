package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

final class AbstractTypeAliasDescriptor$isInner$1
  extends Lambda
  implements Function1<UnwrappedType, Boolean>
{
  AbstractTypeAliasDescriptor$isInner$1(AbstractTypeAliasDescriptor paramAbstractTypeAliasDescriptor)
  {
    super(1);
  }
  
  public final boolean invoke(UnwrappedType paramUnwrappedType)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramUnwrappedType, "type");
    boolean bool3 = KotlinTypeKt.isError((KotlinType)paramUnwrappedType);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      AbstractTypeAliasDescriptor localAbstractTypeAliasDescriptor = this.this$0;
      paramUnwrappedType = paramUnwrappedType.getConstructor().getDeclarationDescriptor();
      int i;
      if (((paramUnwrappedType instanceof TypeParameterDescriptor)) && ((Intrinsics.areEqual(((TypeParameterDescriptor)paramUnwrappedType).getContainingDeclaration(), this.this$0) ^ true))) {
        i = 1;
      } else {
        i = 0;
      }
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor.isInner.1
 * JD-Core Version:    0.7.0.1
 */