package shark;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/GraphContext;", "", "()V", "store", "", "", "contains", "", "key", "get", "T", "(Ljava/lang/String;)Ljava/lang/Object;", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "minusAssign", "", "set", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "shark-graph"}, k=1, mv={1, 4, 1})
public final class GraphContext
{
  private final Map<String, Object> a = (Map)new LinkedHashMap();
  
  public final <T> T a(@NotNull String paramString, @NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "defaultValue");
    Map localMap = this.a;
    Object localObject2 = localMap.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = paramFunction0.invoke();
      localMap.put(paramString, localObject1);
    }
    return localObject1;
  }
  
  public final <T> void a(@NotNull String paramString, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    this.a.put(paramString, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.GraphContext
 * JD-Core Version:    0.7.0.1
 */