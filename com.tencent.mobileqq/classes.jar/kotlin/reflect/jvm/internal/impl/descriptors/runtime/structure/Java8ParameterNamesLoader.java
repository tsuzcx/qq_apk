package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class Java8ParameterNamesLoader
{
  public static final Java8ParameterNamesLoader INSTANCE = new Java8ParameterNamesLoader();
  @Nullable
  private static Java8ParameterNamesLoader.Cache cache;
  
  @NotNull
  public final Java8ParameterNamesLoader.Cache buildCache(@NotNull Member paramMember)
  {
    Intrinsics.checkParameterIsNotNull(paramMember, "member");
    paramMember = paramMember.getClass();
    try
    {
      Method localMethod = paramMember.getMethod("getParameters", new Class[0]);
      return new Java8ParameterNamesLoader.Cache(localMethod, ReflectClassUtilKt.getSafeClassLoader(paramMember).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
    }
    catch (NoSuchMethodException paramMember)
    {
      label49:
      break label49;
    }
    return new Java8ParameterNamesLoader.Cache(null, null);
  }
  
  @Nullable
  public final List<String> loadParameterNames(@NotNull Member paramMember)
  {
    Intrinsics.checkParameterIsNotNull(paramMember, "member");
    Object localObject2 = cache;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = buildCache(paramMember);
      cache = (Java8ParameterNamesLoader.Cache)localObject1;
    }
    localObject2 = ((Java8ParameterNamesLoader.Cache)localObject1).getGetParameters();
    if (localObject2 != null)
    {
      localObject1 = ((Java8ParameterNamesLoader.Cache)localObject1).getGetName();
      if (localObject1 != null)
      {
        paramMember = ((Method)localObject2).invoke(paramMember, new Object[0]);
        if (paramMember != null)
        {
          paramMember = (Object[])paramMember;
          localObject2 = (Collection)new ArrayList(paramMember.length);
          int j = paramMember.length;
          int i = 0;
          while (i < j)
          {
            Object localObject3 = ((Method)localObject1).invoke(paramMember[i], new Object[0]);
            if (localObject3 != null)
            {
              ((Collection)localObject2).add((String)localObject3);
              i += 1;
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
          }
          return (List)localObject2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader
 * JD-Core Version:    0.7.0.1
 */