package com.tencent.weishi.module.publisher.utils;

import android.os.Build.VERSION;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.weishi.module.publisher.data.AbilityPresetData;
import com.tencent.weishi.module.publisher.data.AiModelInfo;
import com.tencent.weishi.module.publisher.model.AIModelConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class AIUtils
{
  public static List<AiModelInfo> getAiModelPath(AbilityPresetData paramAbilityPresetData, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramBoolean) {}
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    for (paramAbilityPresetData = paramAbilityPresetData.getAiParams();; paramAbilityPresetData = getSupportAbility(paramAbilityPresetData))
    {
      localArrayList = new ArrayList();
      localObject1 = AIModelConfig.getAiModelAgentMap();
      if ((CollectionUtil.isEmptyMap(paramAbilityPresetData)) || (CollectionUtil.isEmptyMap((Map)localObject1))) {
        return localArrayList;
      }
      paramAbilityPresetData = paramAbilityPresetData.entrySet().iterator();
      localObject2 = new HashMap();
      while (paramAbilityPresetData.hasNext())
      {
        String str = (String)((Map.Entry)paramAbilityPresetData.next()).getKey();
        if ((((Map)localObject1).containsKey(str)) && (((Map)localObject1).get(str) != null) && (Build.VERSION.SDK_INT >= 19)) {
          ((Map)localObject2).put(str, Objects.requireNonNull(((Map)localObject1).get(str)));
        }
      }
    }
    paramAbilityPresetData = ((Map)localObject2).entrySet().iterator();
    while (paramAbilityPresetData.hasNext())
    {
      localObject2 = (Map.Entry)paramAbilityPresetData.next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      if ((paramMap != null) && (paramMap.containsKey(localObject1))) {
        localArrayList.add(new AiModelInfo((String)paramMap.get(localObject1), (String)localObject2));
      }
    }
    return localArrayList;
  }
  
  public static Map<String, Boolean> getSupportAbility(AbilityPresetData paramAbilityPresetData)
  {
    HashMap localHashMap = new HashMap();
    if (paramAbilityPresetData == null) {
      return localHashMap;
    }
    paramAbilityPresetData = paramAbilityPresetData.getAiParams().entrySet().iterator();
    while (paramAbilityPresetData.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramAbilityPresetData.next();
      String str = (String)localEntry.getKey();
      boolean bool = ((Boolean)localEntry.getValue()).booleanValue();
      if (bool) {
        localHashMap.put(str, Boolean.valueOf(bool));
      }
    }
    return localHashMap;
  }
  
  public static void updateLightAIModelPath() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weishi.module.publisher.utils.AIUtils
 * JD-Core Version:    0.7.0.1
 */