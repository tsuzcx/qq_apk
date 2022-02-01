package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.NotNull;

final class JavaRetentionAnnotationDescriptor$allValueArguments$2
  extends Lambda
  implements Function0<Map<Name, ? extends ConstantValue<?>>>
{
  JavaRetentionAnnotationDescriptor$allValueArguments$2(JavaRetentionAnnotationDescriptor paramJavaRetentionAnnotationDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final Map<Name, ConstantValue<?>> invoke()
  {
    Object localObject = JavaAnnotationTargetMapper.INSTANCE.mapJavaRetentionArgument$descriptors_jvm(this.this$0.getFirstArgument());
    if (localObject != null) {
      localObject = MapsKt.mapOf(TuplesKt.to(JavaAnnotationMapper.INSTANCE.getRETENTION_ANNOTATION_VALUE$descriptors_jvm(), localObject));
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return localObject;
    }
    return MapsKt.emptyMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaRetentionAnnotationDescriptor.allValueArguments.2
 * JD-Core Version:    0.7.0.1
 */