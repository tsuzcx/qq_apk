package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class StarProjectionImpl$_type$2
  extends Lambda
  implements Function0<KotlinType>
{
  StarProjectionImpl$_type$2(StarProjectionImpl paramStarProjectionImpl)
  {
    super(0);
  }
  
  @NotNull
  public final KotlinType invoke()
  {
    return StarProjectionImplKt.starProjectionType(StarProjectionImpl.access$getTypeParameter$p(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl._type.2
 * JD-Core Version:    0.7.0.1
 */