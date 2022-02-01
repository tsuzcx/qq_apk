package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;

class KotlinBuiltIns$4
  implements Function0<Void>
{
  KotlinBuiltIns$4(KotlinBuiltIns paramKotlinBuiltIns, ModuleDescriptorImpl paramModuleDescriptorImpl) {}
  
  public Void invoke()
  {
    if (KotlinBuiltIns.access$000(this.this$0) == null)
    {
      KotlinBuiltIns.access$002(this.this$0, this.val$module);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Built-ins module is already set: ");
    localStringBuilder.append(KotlinBuiltIns.access$000(this.this$0));
    localStringBuilder.append(" (attempting to reset to ");
    localStringBuilder.append(this.val$module);
    localStringBuilder.append(")");
    throw new AssertionError(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.4
 * JD-Core Version:    0.7.0.1
 */