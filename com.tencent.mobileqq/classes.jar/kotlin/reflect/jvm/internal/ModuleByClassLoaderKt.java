package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"moduleByClassLoader", "Ljava/util/concurrent/ConcurrentMap;", "Lkotlin/reflect/jvm/internal/WeakClassLoaderBox;", "Ljava/lang/ref/WeakReference;", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/RuntimeModuleData;", "clearModuleByClassLoaderCache", "", "getOrCreateModule", "Ljava/lang/Class;", "kotlin-reflection"}, k=2, mv={1, 1, 16})
public final class ModuleByClassLoaderKt
{
  private static final ConcurrentMap<WeakClassLoaderBox, WeakReference<RuntimeModuleData>> moduleByClassLoader = (ConcurrentMap)new ConcurrentHashMap();
  
  public static final void clearModuleByClassLoaderCache()
  {
    moduleByClassLoader.clear();
  }
  
  @NotNull
  public static final RuntimeModuleData getOrCreateModule(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "$this$getOrCreateModule");
    Object localObject1 = ReflectClassUtilKt.getSafeClassLoader(paramClass);
    paramClass = new WeakClassLoaderBox((ClassLoader)localObject1);
    WeakReference localWeakReference = (WeakReference)moduleByClassLoader.get(paramClass);
    RuntimeModuleData localRuntimeModuleData;
    if (localWeakReference != null)
    {
      localRuntimeModuleData = (RuntimeModuleData)localWeakReference.get();
      if (localRuntimeModuleData != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localRuntimeModuleData, "it");
        return localRuntimeModuleData;
      }
      moduleByClassLoader.remove(paramClass, localWeakReference);
    }
    localObject1 = RuntimeModuleData.Companion.create((ClassLoader)localObject1);
    try
    {
      for (;;)
      {
        localWeakReference = (WeakReference)moduleByClassLoader.putIfAbsent(paramClass, new WeakReference(localObject1));
        if (localWeakReference == null) {
          break;
        }
        localRuntimeModuleData = (RuntimeModuleData)localWeakReference.get();
        if (localRuntimeModuleData != null)
        {
          paramClass.setTemporaryStrongRef((ClassLoader)null);
          return localRuntimeModuleData;
        }
        moduleByClassLoader.remove(paramClass, localWeakReference);
      }
      paramClass.setTemporaryStrongRef((ClassLoader)null);
      return localObject1;
    }
    finally
    {
      paramClass.setTemporaryStrongRef((ClassLoader)null);
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.ModuleByClassLoaderKt
 * JD-Core Version:    0.7.0.1
 */