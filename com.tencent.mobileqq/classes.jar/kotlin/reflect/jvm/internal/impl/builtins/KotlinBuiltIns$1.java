package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;

class KotlinBuiltIns$1
  implements Function0<Collection<PackageViewDescriptor>>
{
  KotlinBuiltIns$1(KotlinBuiltIns paramKotlinBuiltIns) {}
  
  public Collection<PackageViewDescriptor> invoke()
  {
    return Arrays.asList(new PackageViewDescriptor[] { KotlinBuiltIns.access$000(this.this$0).getPackage(KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME), KotlinBuiltIns.access$000(this.this$0).getPackage(KotlinBuiltIns.COLLECTIONS_PACKAGE_FQ_NAME), KotlinBuiltIns.access$000(this.this$0).getPackage(KotlinBuiltIns.RANGES_PACKAGE_FQ_NAME), KotlinBuiltIns.access$000(this.this$0).getPackage(KotlinBuiltIns.access$100()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.1
 * JD-Core Version:    0.7.0.1
 */