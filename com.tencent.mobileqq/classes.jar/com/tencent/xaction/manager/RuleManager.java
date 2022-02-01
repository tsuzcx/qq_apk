package com.tencent.xaction.manager;

import androidx.annotation.Keep;
import com.tencent.xaction.api.IRuleManager;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.BaseRule;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.util.ReflectUtil;
import com.tencent.xaction.api.util.ReflectUtil.Companion;
import com.tencent.xaction.log.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/manager/RuleManager;", "Lcom/tencent/xaction/api/IRuleManager;", "()V", "ruleNameMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getRuleNameMap", "()Ljava/util/HashMap;", "rules", "Ljava/util/ArrayList;", "Lcom/tencent/xaction/api/base/BaseRule;", "Lkotlin/collections/ArrayList;", "getRules", "()Ljava/util/ArrayList;", "setRules", "(Ljava/util/ArrayList;)V", "getRuleValue", "rule", "parseRuleMap", "", "ruleName", "ruleKey", "obj", "putEleForHashMap", "", "lastObj", "it", "ruleValue", "refreshAnimRuleValue", "key", "value", "refreshRuleValue", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "registerRule", "registerRuleLine", "setRuleValueToObj", "fieldKey", "setValueToObj", "unregisterRule", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public final class RuleManager
  implements IRuleManager
{
  public static final RuleManager.Companion Companion = new RuleManager.Companion(null);
  private static final String TAG = "RuleManager";
  @NotNull
  private static final HashMap<String, Object> globalRuleNameMap = new HashMap();
  @NotNull
  private final HashMap<String, Object> ruleNameMap = new HashMap();
  @NotNull
  private ArrayList<BaseRule> rules = new ArrayList();
  
  private final boolean parseRuleMap(HashMap<String, Object> paramHashMap, String paramString1, String paramString2, Object paramObject)
  {
    if (paramHashMap.containsKey(paramString1))
    {
      Object localObject = paramHashMap.get(paramString1);
      paramHashMap = (CharSequence)paramString2;
      if (StringsKt.contains$default(paramHashMap, '.', false, 2, null))
      {
        paramString2 = StringsKt.split$default(paramHashMap, new char[] { '.' }, false, 0, 6, null);
        Iterator localIterator = ((Iterable)paramString2).iterator();
        paramHashMap = paramObject;
        int i = 0;
        while (localIterator.hasNext())
        {
          paramString1 = localIterator.next();
          if (i < 0) {
            CollectionsKt.throwIndexOverflow();
          }
          paramString1 = (String)paramString1;
          try
          {
            putEleForHashMap(paramHashMap, paramString1, localObject);
            paramString1 = ReflectUtil.a.a(paramHashMap.getClass(), paramString1);
            if (paramString1 != null)
            {
              paramString1.setAccessible(true);
              if (i < paramString2.size() - 1)
              {
                paramString1 = paramString1.get(paramHashMap);
                Intrinsics.checkExpressionValueIsNotNull(paramString1, "field.get(lastObj)");
                paramHashMap = paramString1;
              }
              else
              {
                paramString1.set(paramHashMap, localObject);
              }
            }
            else
            {
              return false;
            }
          }
          catch (Exception paramString1)
          {
            paramObject = new StringBuilder();
            paramObject.append("exception ");
            paramObject.append(paramString1.getMessage());
            QLog.a("RuleManager", 2, paramObject.toString());
            paramString1.printStackTrace();
            i += 1;
          }
        }
      }
      try
      {
        ReflectUtil.a.a(paramObject, paramString2, localObject);
        return true;
      }
      catch (Exception paramHashMap)
      {
        paramHashMap.printStackTrace();
      }
      return true;
    }
    return false;
  }
  
  private final void putEleForHashMap(Object paramObject1, String paramString, Object paramObject2)
  {
    if (Intrinsics.areEqual(paramObject1.getClass(), HashMap.class)) {
      paramObject1.getClass().getMethod("put", new Class[] { Object.class, Object.class }).invoke(paramObject1, new Object[] { paramString, paramObject2 });
    }
  }
  
  @NotNull
  public final HashMap<String, Object> getRuleNameMap()
  {
    return this.ruleNameMap;
  }
  
  @Nullable
  public Object getRuleValue(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "rule");
    if (this.ruleNameMap.containsKey(paramString)) {
      return this.ruleNameMap.get(paramString);
    }
    return globalRuleNameMap.get(paramString);
  }
  
  @NotNull
  public final ArrayList<BaseRule> getRules()
  {
    return this.rules;
  }
  
  public void refreshAnimRuleValue(@NotNull Object paramObject, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    if ((paramObject instanceof BaseAnim))
    {
      Iterator localIterator = ((Iterable)this.rules).iterator();
      while (localIterator.hasNext()) {
        ((BaseRule)localIterator.next()).ruleAnimParse((BaseAnim)paramObject, paramString1, paramString2);
      }
    }
    if (!parseRuleMap(this.ruleNameMap, paramString2, paramString1, paramObject)) {
      parseRuleMap(globalRuleNameMap, paramString2, paramString1, paramObject);
    }
  }
  
  public void refreshRuleValue(@NotNull ViewData paramViewData, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    Iterator localIterator = ((Iterable)this.rules).iterator();
    while (localIterator.hasNext()) {
      if (((BaseRule)localIterator.next()).ruleParse(paramViewData, paramString1, paramString2)) {
        return;
      }
    }
    if (!parseRuleMap(this.ruleNameMap, paramString2, paramString1, paramViewData)) {
      parseRuleMap(globalRuleNameMap, paramString2, paramString1, paramViewData);
    }
  }
  
  public boolean registerRule(@NotNull BaseRule paramBaseRule)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseRule, "rule");
    return this.rules.add(paramBaseRule);
  }
  
  public void registerRuleLine(@NotNull String paramString, @NotNull Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "ruleName");
    Intrinsics.checkParameterIsNotNull(paramObject, "value");
    ((Map)this.ruleNameMap).put(paramString, paramObject);
  }
  
  public final void setRuleValueToObj(@NotNull Object paramObject, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramObject, "obj");
    Intrinsics.checkParameterIsNotNull(paramString1, "fieldKey");
    Intrinsics.checkParameterIsNotNull(paramString2, "ruleKey");
    paramString2 = getRuleValue(paramString2);
    if (paramString2 != null) {
      setValueToObj(paramObject, paramString1, paramString2);
    }
  }
  
  public final void setRules(@NotNull ArrayList<BaseRule> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.rules = paramArrayList;
  }
  
  public final void setValueToObj(@NotNull Object paramObject1, @NotNull String paramString, @NotNull Object paramObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramObject1, "obj");
    Intrinsics.checkParameterIsNotNull(paramString, "fieldKey");
    Intrinsics.checkParameterIsNotNull(paramObject2, "value");
    try
    {
      paramString = ReflectUtil.a.a(paramObject1.getClass(), paramString);
      if (paramString != null)
      {
        paramString.setAccessible(true);
        paramString.set(paramObject1, paramObject2);
        return;
      }
      return;
    }
    catch (Exception paramObject1)
    {
      QLog.a("RuleManager", 1, "setRuleValueToObj error", (Throwable)paramObject1);
    }
  }
  
  public boolean unregisterRule(@NotNull BaseRule paramBaseRule)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseRule, "rule");
    return this.rules.remove(paramBaseRule);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.manager.RuleManager
 * JD-Core Version:    0.7.0.1
 */