package shark.internal;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/LruCache;", "K", "V", "", "maxSize", "", "(I)V", "cache", "Ljava/util/LinkedHashMap;", "<set-?>", "evictionCount", "getEvictionCount", "()I", "hitCount", "getHitCount", "getMaxSize", "missCount", "getMissCount", "putCount", "getPutCount", "size", "getSize", "evictAll", "", "get", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "toString", "", "shark-graph"}, k=1, mv={1, 4, 1})
public final class LruCache<K, V>
{
  private final LinkedHashMap<K, V> a;
  private int b;
  private int c;
  private int d;
  private int e;
  private final int f;
  
  public LruCache(int paramInt)
  {
    this.f = paramInt;
    if (this.f > 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0)
    {
      this.a = ((LinkedHashMap)new LruCache.2(this, this.f, 0.75F, true));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxSize=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" <= 0");
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  public final int a()
  {
    return this.c;
  }
  
  @Nullable
  public final V a(@Nullable K paramK)
  {
    paramK = ((Map)this.a).get(paramK);
    if (paramK != null)
    {
      this.d += 1;
      return paramK;
    }
    this.e += 1;
    return null;
  }
  
  @Nullable
  public final V a(K paramK, V paramV)
  {
    this.b += 1;
    return this.a.put(paramK, paramV);
  }
  
  public final int b()
  {
    return this.f;
  }
  
  @NotNull
  public String toString()
  {
    int i = this.d;
    int j = this.e + i;
    if (j != 0) {
      i = i * 100 / j;
    } else {
      i = 0;
    }
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = new Object[4];
    localObject[0] = Integer.valueOf(this.f);
    localObject[1] = Integer.valueOf(this.d);
    localObject[2] = Integer.valueOf(this.e);
    localObject[3] = Integer.valueOf(i);
    localObject = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.LruCache
 * JD-Core Version:    0.7.0.1
 */