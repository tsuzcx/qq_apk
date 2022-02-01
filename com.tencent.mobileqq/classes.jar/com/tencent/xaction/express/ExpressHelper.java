package com.tencent.xaction.express;

import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.ReflectUtil;
import com.tencent.xaction.api.util.ReflectUtil.Companion;
import com.tencent.xaction.log.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/express/ExpressHelper;", "", "()V", "TAG", "", "expressMap", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lcom/tencent/xaction/express/IFunc;", "Lkotlin/collections/HashMap;", "compute", "fieldType", "express", "order", "", "isExpress", "", "parseField", "Lkotlin/Pair;", "Ljava/lang/reflect/Field;", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "fieldKey", "realParseField", "setValueToObj", "", "fieldPair", "value", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ExpressHelper
{
  public static final ExpressHelper a = new ExpressHelper();
  private static final HashMap<String, Class<? extends IFunc>> b = new HashMap();
  
  static
  {
    ((Map)b).put("random", Random.class);
    ((Map)b).put("order", Order.class);
  }
  
  private final Pair<Object, Field> b(ViewData paramViewData, String paramString)
  {
    Object localObject2 = (String)null;
    Object localObject3 = (CharSequence)paramString;
    Object localObject1 = paramString;
    int i;
    if (StringsKt.contains$default((CharSequence)localObject3, (CharSequence)".", false, 2, null))
    {
      i = StringsKt.indexOf$default((CharSequence)localObject3, ".", 0, false, 6, null);
      int j = StringsKt.indexOf$default((CharSequence)localObject3, ".", 0, false, 6, null);
      if (paramString != null)
      {
        localObject2 = paramString.substring(0, j);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (paramString != null)
        {
          localObject1 = paramString.substring(i + 1);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).substring(startIndex)");
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    paramString = (Field)null;
    if (localObject2 != null)
    {
      i = ((String)localObject2).hashCode();
      if (i != 3681)
      {
        if ((i == 2998801) && (((String)localObject2).equals("anim")))
        {
          localObject3 = paramViewData.getAnim().iterator();
          paramViewData = paramString;
          while (((Iterator)localObject3).hasNext())
          {
            localObject2 = (BaseAnim)((Iterator)localObject3).next();
            paramString = ReflectUtil.a.a(localObject2.getClass(), (String)localObject1);
            paramViewData = paramString;
            if (paramString != null)
            {
              localObject1 = localObject2;
              paramViewData = paramString;
              paramString = (String)localObject1;
              break label295;
            }
          }
          paramString = null;
          break label295;
        }
      }
      else if (((String)localObject2).equals("st"))
      {
        paramString = ReflectUtil.a.a(paramViewData.getSt().getClass(), (String)localObject1);
        localObject1 = paramViewData.getSt();
        paramViewData = paramString;
        paramString = (String)localObject1;
        break label295;
      }
    }
    localObject1 = ReflectUtil.a.a(paramViewData.getClass(), (String)localObject1);
    paramString = paramViewData;
    paramViewData = (ViewData)localObject1;
    label295:
    if ((paramString != null) && (paramViewData != null)) {
      return new Pair(paramString, paramViewData);
    }
    return null;
  }
  
  @Nullable
  public final Object a(@NotNull Class<?> paramClass, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "fieldType");
    Intrinsics.checkParameterIsNotNull(paramString, "express");
    try
    {
      int i = StringsKt.indexOf$default((CharSequence)paramString, ":", 0, false, 6, null);
      if (i == -1) {
        return null;
      }
      Object localObject = paramString.substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = paramString.substring(i + 1);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      localObject = (Class)b.get(localObject);
      if (localObject != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject, "expressMap[funName] ?: return null");
        paramClass = ((IFunc)((Class)localObject).newInstance()).a(paramClass, paramString, paramInt);
        return paramClass;
      }
      return null;
    }
    catch (Exception paramClass)
    {
      QLog.a("ExpressHelper", 1, "ExpressHelper error", (Throwable)paramClass);
    }
    return null;
  }
  
  @Nullable
  public final Pair<Object, Field> a(@NotNull ViewData paramViewData, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    Intrinsics.checkParameterIsNotNull(paramString, "fieldKey");
    try
    {
      paramViewData = b(paramViewData, paramString);
      return paramViewData;
    }
    catch (Exception paramViewData)
    {
      QLog.a("ExpressHelper", 1, "parseField error", (Throwable)paramViewData);
    }
    return null;
  }
  
  public final void a(@NotNull Pair<? extends Object, Field> paramPair, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramPair, "fieldPair");
    try
    {
      ((Field)paramPair.getSecond()).setAccessible(true);
      ((Field)paramPair.getSecond()).set(paramPair.getFirst(), paramObject);
      return;
    }
    catch (Exception paramPair)
    {
      QLog.a("ExpressHelper", 1, "setValueToObj error", (Throwable)paramPair);
    }
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "express");
    int i = StringsKt.indexOf$default((CharSequence)paramString, ":", 0, false, 6, null);
    boolean bool = false;
    if (i == -1) {
      return false;
    }
    paramString = paramString.substring(0, i);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    if (b.get(paramString) != null) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.express.ExpressHelper
 * JD-Core Version:    0.7.0.1
 */