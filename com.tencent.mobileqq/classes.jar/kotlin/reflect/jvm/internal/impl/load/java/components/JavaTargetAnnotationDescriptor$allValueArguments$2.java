package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.NotNull;

final class JavaTargetAnnotationDescriptor$allValueArguments$2
  extends Lambda
  implements Function0<Map<Name, ? extends ConstantValue<?>>>
{
  JavaTargetAnnotationDescriptor$allValueArguments$2(JavaTargetAnnotationDescriptor paramJavaTargetAnnotationDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final Map<Name, ConstantValue<?>> invoke()
  {
    Object localObject = this.this$0.getFirstArgument();
    boolean bool = localObject instanceof JavaArrayAnnotationArgument;
    Map localMap = null;
    if (bool) {
      localObject = JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArguments$descriptors_jvm(((JavaArrayAnnotationArgument)this.this$0.getFirstArgument()).getElements());
    } else if ((localObject instanceof JavaEnumValueAnnotationArgument)) {
      localObject = JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArguments$descriptors_jvm(CollectionsKt.listOf(this.this$0.getFirstArgument()));
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localMap = MapsKt.mapOf(TuplesKt.to(JavaAnnotationMapper.INSTANCE.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), localObject));
    }
    if (localMap != null) {
      return localMap;
    }
    return MapsKt.emptyMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaTargetAnnotationDescriptor.allValueArguments.2
 * JD-Core Version:    0.7.0.1
 */