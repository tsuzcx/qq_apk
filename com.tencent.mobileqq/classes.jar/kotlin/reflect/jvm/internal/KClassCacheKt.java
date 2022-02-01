package kotlin.reflect.jvm.internal;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.pcollections.HashPMap;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/pcollections/HashPMap;", "", "kotlin.jvm.PlatformType", "", "clearKClassCache", "", "getOrCreateKotlinClass", "Lkotlin/reflect/jvm/internal/KClassImpl;", "T", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k=2, mv={1, 1, 16})
public final class KClassCacheKt
{
  private static HashPMap<String, Object> K_CLASS_CACHE;
  
  static
  {
    HashPMap localHashPMap = HashPMap.empty();
    Intrinsics.checkExpressionValueIsNotNull(localHashPMap, "HashPMap.empty<String, Any>()");
    K_CLASS_CACHE = localHashPMap;
  }
  
  public static final void clearKClassCache()
  {
    HashPMap localHashPMap = HashPMap.empty();
    Intrinsics.checkExpressionValueIsNotNull(localHashPMap, "HashPMap.empty()");
    K_CLASS_CACHE = localHashPMap;
  }
  
  @NotNull
  public static final <T> KClassImpl<T> getOrCreateKotlinClass(@NotNull Class<T> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "jClass");
    String str = paramClass.getName();
    Object localObject2 = K_CLASS_CACHE.get(str);
    boolean bool = localObject2 instanceof WeakReference;
    Object localObject1 = null;
    if (bool)
    {
      localObject2 = (KClassImpl)((WeakReference)localObject2).get();
      if (localObject2 != null) {
        localObject1 = ((KClassImpl)localObject2).getJClass();
      }
      if (Intrinsics.areEqual(localObject1, paramClass)) {
        return localObject2;
      }
    }
    else if (localObject2 != null)
    {
      WeakReference[] arrayOfWeakReference = (WeakReference[])localObject2;
      int j = arrayOfWeakReference.length;
      int i = 0;
      while (i < j)
      {
        KClassImpl localKClassImpl = (KClassImpl)arrayOfWeakReference[i].get();
        if (localKClassImpl != null) {
          localObject1 = localKClassImpl.getJClass();
        } else {
          localObject1 = null;
        }
        if (Intrinsics.areEqual(localObject1, paramClass)) {
          return localKClassImpl;
        }
        i += 1;
      }
      i = ((Object[])localObject2).length;
      localObject1 = new WeakReference[i + 1];
      System.arraycopy(localObject2, 0, localObject1, 0, i);
      paramClass = new KClassImpl(paramClass);
      localObject1[i] = new WeakReference(paramClass);
      localObject1 = K_CLASS_CACHE.plus(str, localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "K_CLASS_CACHE.plus(name, newArray)");
      K_CLASS_CACHE = (HashPMap)localObject1;
      return paramClass;
    }
    paramClass = new KClassImpl(paramClass);
    localObject1 = K_CLASS_CACHE.plus(str, new WeakReference(paramClass));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
    K_CLASS_CACHE = (HashPMap)localObject1;
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassCacheKt
 * JD-Core Version:    0.7.0.1
 */