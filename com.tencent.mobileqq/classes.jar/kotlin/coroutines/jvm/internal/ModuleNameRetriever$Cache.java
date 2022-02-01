package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "", "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ModuleNameRetriever$Cache
{
  @JvmField
  @Nullable
  public final Method getDescriptorMethod;
  @JvmField
  @Nullable
  public final Method getModuleMethod;
  @JvmField
  @Nullable
  public final Method nameMethod;
  
  public ModuleNameRetriever$Cache(@Nullable Method paramMethod1, @Nullable Method paramMethod2, @Nullable Method paramMethod3)
  {
    this.getModuleMethod = paramMethod1;
    this.getDescriptorMethod = paramMethod2;
    this.nameMethod = paramMethod3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.ModuleNameRetriever.Cache
 * JD-Core Version:    0.7.0.1
 */