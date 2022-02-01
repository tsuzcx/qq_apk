package com.tencent.xaction.manager;

import com.tencent.xaction.api.IRuleManager;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.BaseRule;
import com.tencent.xaction.api.data.ViewData;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/manager/RuleManager;", "Lcom/tencent/xaction/api/IRuleManager;", "()V", "ruleNameMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getRuleNameMap", "()Ljava/util/HashMap;", "rules", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/base/BaseRule;", "Lkotlin/collections/ArrayList;", "getRules", "()Ljava/util/ArrayList;", "setRules", "(Ljava/util/ArrayList;)V", "getField", "Ljava/lang/reflect/Field;", "clazz", "Ljava/lang/Class;", "propName", "getRuleValue", "rule", "parseRuleMap", "", "ruleName", "ruleKey", "viewData", "refreshAnimRuleValue", "", "anim", "Lcom/tencent/xaction/api/base/BaseAnim;", "key", "value", "refreshRuleValue", "Lcom/tencent/xaction/api/data/ViewData;", "registerGlobalRuleLine", "registerRule", "registerRuleLine", "unregisterRule", "Companion", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class RuleManager
  implements IRuleManager
{
  public static final RuleManager.Companion a;
  @NotNull
  private static final HashMap<String, Object> b = new HashMap();
  @NotNull
  private ArrayList<BaseRule> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  @NotNull
  private final HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  static
  {
    jdField_a_of_type_ComTencentXactionManagerRuleManager$Companion = new RuleManager.Companion(null);
  }
  
  private final Field a(Class<?> paramClass, String paramString)
  {
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      if (paramClass.getClass().getSuperclass() != null)
      {
        paramClass = paramClass.getSuperclass();
        Intrinsics.checkExpressionValueIsNotNull(paramClass, "clazz.superclass");
        return a(paramClass, paramString);
      }
    }
    return null;
  }
  
  private final boolean a(HashMap<String, Object> paramHashMap, String paramString1, String paramString2, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Iterator localIterator;
    int i;
    if (paramHashMap.containsKey(paramString1))
    {
      paramString1 = paramHashMap.get(paramString1);
      if (StringsKt.contains$default((CharSequence)paramString2, '.', false, 2, null))
      {
        paramString2 = StringsKt.split$default((CharSequence)paramString2, new char[] { '.' }, false, 0, 6, null);
        localIterator = ((Iterable)paramString2).iterator();
        i = 0;
      }
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramHashMap = localIterator.next();
        if (i < 0) {
          CollectionsKt.throwIndexOverflow();
        }
        paramHashMap = (String)paramHashMap;
        try
        {
          paramHashMap = a(paramObject.getClass(), paramHashMap);
          bool1 = bool2;
          if (paramHashMap != null)
          {
            paramHashMap.setAccessible(true);
            if (i < paramString2.size() - 1)
            {
              paramHashMap = paramHashMap.get(paramObject);
              Intrinsics.checkExpressionValueIsNotNull(paramHashMap, "field.get(lastObj)");
            }
            else
            {
              paramHashMap.set(paramObject, paramString1);
              paramHashMap = paramObject;
            }
          }
        }
        catch (Exception paramHashMap)
        {
          paramHashMap.printStackTrace();
          paramHashMap = paramObject;
        }
      }
      try
      {
        paramHashMap = a(paramObject.getClass(), paramString2);
        bool1 = bool2;
        if (paramHashMap == null) {
          break label213;
        }
        paramHashMap.setAccessible(true);
        paramHashMap.set(paramObject, paramString1);
      }
      catch (Exception paramHashMap)
      {
        for (;;)
        {
          paramHashMap.printStackTrace();
        }
      }
      bool1 = true;
      label213:
      return bool1;
      i += 1;
      paramObject = paramHashMap;
    }
  }
  
  @Nullable
  public Object a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rule");
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      return this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    return b.get(paramString);
  }
  
  public void a(@NotNull BaseAnim paramBaseAnim, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "anim");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    Iterator localIterator = ((Iterable)this.jdField_a_of_type_JavaUtilArrayList).iterator();
    while (localIterator.hasNext()) {
      ((BaseRule)localIterator.next()).ruleAnimParse(paramBaseAnim, paramString1, paramString2);
    }
    if (!a(this.jdField_a_of_type_JavaUtilHashMap, paramString2, paramString1, paramBaseAnim)) {
      a(b, paramString2, paramString1, paramBaseAnim);
    }
  }
  
  public void a(@NotNull ViewData paramViewData, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    Iterator localIterator = ((Iterable)this.jdField_a_of_type_JavaUtilArrayList).iterator();
    if (localIterator.hasNext()) {
      if (!((BaseRule)localIterator.next()).ruleParse(paramViewData, paramString1, paramString2)) {}
    }
    while (a(this.jdField_a_of_type_JavaUtilHashMap, paramString2, paramString1, paramViewData))
    {
      return;
      break;
    }
    a(b, paramString2, paramString1, paramViewData);
  }
  
  public void a(@NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ruleName");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    ((Map)this.jdField_a_of_type_JavaUtilHashMap).put(paramString, paramObject);
  }
  
  public boolean a(@NotNull BaseRule paramBaseRule)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseRule, "rule");
    return this.jdField_a_of_type_JavaUtilArrayList.add(paramBaseRule);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.manager.RuleManager
 * JD-Core Version:    0.7.0.1
 */