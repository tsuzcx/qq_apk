package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", "", "()V", "cache", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "notOnJava9", "buildCache", "continuation", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getModuleName", "", "Cache", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ModuleNameRetriever
{
  public static final ModuleNameRetriever INSTANCE = new ModuleNameRetriever();
  @JvmField
  @Nullable
  public static ModuleNameRetriever.Cache cache;
  private static final ModuleNameRetriever.Cache notOnJava9 = new ModuleNameRetriever.Cache(null, null, null);
  
  private final ModuleNameRetriever.Cache buildCache(BaseContinuationImpl paramBaseContinuationImpl)
  {
    try
    {
      paramBaseContinuationImpl = new ModuleNameRetriever.Cache(Class.class.getDeclaredMethod("getModule", new Class[0]), paramBaseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), paramBaseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
      cache = paramBaseContinuationImpl;
      return paramBaseContinuationImpl;
    }
    catch (Exception paramBaseContinuationImpl)
    {
      label67:
      break label67;
    }
    paramBaseContinuationImpl = notOnJava9;
    cache = paramBaseContinuationImpl;
    return paramBaseContinuationImpl;
  }
  
  @Nullable
  public final String getModuleName(@NotNull BaseContinuationImpl paramBaseContinuationImpl)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseContinuationImpl, "continuation");
    Object localObject = cache;
    if (localObject == null) {
      localObject = buildCache(paramBaseContinuationImpl);
    }
    if (localObject == notOnJava9) {
      return null;
    }
    Method localMethod = ((ModuleNameRetriever.Cache)localObject).getModuleMethod;
    if (localMethod != null)
    {
      paramBaseContinuationImpl = localMethod.invoke(paramBaseContinuationImpl.getClass(), new Object[0]);
      if (paramBaseContinuationImpl != null)
      {
        localMethod = ((ModuleNameRetriever.Cache)localObject).getDescriptorMethod;
        if (localMethod != null)
        {
          paramBaseContinuationImpl = localMethod.invoke(paramBaseContinuationImpl, new Object[0]);
          if (paramBaseContinuationImpl != null)
          {
            localObject = ((ModuleNameRetriever.Cache)localObject).nameMethod;
            if (localObject != null) {
              paramBaseContinuationImpl = ((Method)localObject).invoke(paramBaseContinuationImpl, new Object[0]);
            } else {
              paramBaseContinuationImpl = null;
            }
            localObject = paramBaseContinuationImpl;
            if (!(paramBaseContinuationImpl instanceof String)) {
              localObject = null;
            }
            return (String)localObject;
          }
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.ModuleNameRetriever
 * JD-Core Version:    0.7.0.1
 */