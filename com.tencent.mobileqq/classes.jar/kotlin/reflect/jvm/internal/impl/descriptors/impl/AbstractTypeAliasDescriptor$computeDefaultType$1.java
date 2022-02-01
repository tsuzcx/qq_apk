package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.Nullable;

final class AbstractTypeAliasDescriptor$computeDefaultType$1
  extends Lambda
  implements Function1<KotlinTypeRefiner, SimpleType>
{
  AbstractTypeAliasDescriptor$computeDefaultType$1(AbstractTypeAliasDescriptor paramAbstractTypeAliasDescriptor)
  {
    super(1);
  }
  
  @Nullable
  public final SimpleType invoke(KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    paramKotlinTypeRefiner = paramKotlinTypeRefiner.refineDescriptor((DeclarationDescriptor)this.this$0);
    if (paramKotlinTypeRefiner != null) {
      return paramKotlinTypeRefiner.getDefaultType();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor.computeDefaultType.1
 * JD-Core Version:    0.7.0.1
 */