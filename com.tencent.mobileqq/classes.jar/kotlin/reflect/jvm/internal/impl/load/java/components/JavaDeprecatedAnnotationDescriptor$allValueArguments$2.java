package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import org.jetbrains.annotations.NotNull;

final class JavaDeprecatedAnnotationDescriptor$allValueArguments$2
  extends Lambda
  implements Function0<Map<Name, ? extends StringValue>>
{
  public static final 2 INSTANCE = new 2();
  
  JavaDeprecatedAnnotationDescriptor$allValueArguments$2()
  {
    super(0);
  }
  
  @NotNull
  public final Map<Name, StringValue> invoke()
  {
    return MapsKt.mapOf(TuplesKt.to(JavaAnnotationMapper.INSTANCE.getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm(), new StringValue("Deprecated in Java")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.JavaDeprecatedAnnotationDescriptor.allValueArguments.2
 * JD-Core Version:    0.7.0.1
 */