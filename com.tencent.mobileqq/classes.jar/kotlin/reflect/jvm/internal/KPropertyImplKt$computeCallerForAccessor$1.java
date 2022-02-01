package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isJvmStaticProperty", "", "invoke"}, k=3, mv={1, 1, 16})
final class KPropertyImplKt$computeCallerForAccessor$1
  extends Lambda
  implements Function0<Boolean>
{
  KPropertyImplKt$computeCallerForAccessor$1(KPropertyImpl.Accessor paramAccessor)
  {
    super(0);
  }
  
  public final boolean invoke()
  {
    return this.$this_computeCallerForAccessor.getProperty().getDescriptor().getAnnotations().hasAnnotation(UtilKt.getJVM_STATIC());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPropertyImplKt.computeCallerForAccessor.1
 * JD-Core Version:    0.7.0.1
 */