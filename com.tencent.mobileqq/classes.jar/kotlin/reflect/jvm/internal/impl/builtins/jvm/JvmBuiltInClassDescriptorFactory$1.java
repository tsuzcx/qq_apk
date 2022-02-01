package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

final class JvmBuiltInClassDescriptorFactory$1
  extends Lambda
  implements Function1<ModuleDescriptor, BuiltInsPackageFragment>
{
  public static final 1 INSTANCE = new 1();
  
  JvmBuiltInClassDescriptorFactory$1()
  {
    super(1);
  }
  
  @NotNull
  public final BuiltInsPackageFragment invoke(@NotNull ModuleDescriptor paramModuleDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "module");
    Object localObject1 = JvmBuiltInClassDescriptorFactory.access$getKOTLIN_FQ_NAME$cp();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "KOTLIN_FQ_NAME");
    localObject1 = (Iterable)paramModuleDescriptor.getPackage((FqName)localObject1).getFragments();
    paramModuleDescriptor = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof BuiltInsPackageFragment)) {
        paramModuleDescriptor.add(localObject2);
      }
    }
    return (BuiltInsPackageFragment)CollectionsKt.first((List)paramModuleDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory.1
 * JD-Core Version:    0.7.0.1
 */