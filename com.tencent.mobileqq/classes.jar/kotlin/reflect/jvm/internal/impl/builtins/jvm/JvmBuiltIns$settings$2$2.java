package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class JvmBuiltIns$settings$2$2
  extends Lambda
  implements Function0<Boolean>
{
  JvmBuiltIns$settings$2$2(JvmBuiltIns.settings.2 param2)
  {
    super(0);
  }
  
  public final boolean invoke()
  {
    if (JvmBuiltIns.access$getOwnerModuleDescriptor$p(this.this$0.this$0) != null) {
      return JvmBuiltIns.access$isAdditionalBuiltInsFeatureSupported$p(this.this$0.this$0);
    }
    throw ((Throwable)new AssertionError("JvmBuiltins has not been initialized properly"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns.settings.2.2
 * JD-Core Version:    0.7.0.1
 */