package com.tencent.mobileqq.gamecenter.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class GameMsgTabConfig
{
  public static final String a;
  private Map<String, Map<String, String>> b = new HashMap();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameCenterMsg.");
    localStringBuilder.append(GameMsgTabConfig.class.getSimpleName());
    a = localStringBuilder.toString();
  }
  
  public static GameMsgTabConfig a(String paramString)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[parse] config: ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = new GameMsgTabConfig();
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("testResult");
      if (paramString != null)
      {
        localObject2 = paramString.keys();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (String)((Iterator)localObject2).next();
          if ("qgame_msgassistant_aio_redpoint".equals(localObject3))
          {
            localObject3 = b(paramString.getJSONObject((String)localObject3));
            if (localObject3 != null) {
              ((GameMsgTabConfig)localObject1).a("qgame_msgassistant_aio_redpoint", (Map)localObject3);
            }
          }
          else if ("qgame_msgassistant_box".equals(localObject3))
          {
            localObject3 = a(paramString.getJSONObject((String)localObject3));
            if (localObject3 != null) {
              ((GameMsgTabConfig)localObject1).a("qgame_msgassistant_box", (Map)localObject3);
            }
          }
        }
      }
      return localObject1;
    }
    catch (Exception paramString)
    {
      QLog.e(a, 1, paramString, new Object[0]);
      if (QLog.isColorLevel())
      {
        paramString = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[parse] result tabConfig: ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public static Map<String, String> a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e(a, 1, "[parseBoxSwitchConfig] jsonObject is null.");
      return null;
    }
    try
    {
      Object localObject1 = paramJSONObject.getJSONObject("resultList");
      if (localObject1 != null)
      {
        paramJSONObject = ((JSONObject)localObject1).optString("style", "0");
        localObject1 = ((JSONObject)localObject1).optString("grayPolicyId", "0");
        Object localObject2 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseBoxSwitchConfig save red style:");
        localStringBuilder.append(paramJSONObject);
        localStringBuilder.append(",id:");
        localStringBuilder.append((String)localObject1);
        QLog.i((String)localObject2, 1, localStringBuilder.toString());
        localObject2 = new HashMap();
        ((Map)localObject2).put("style", paramJSONObject);
        ((Map)localObject2).put("grayPolicyId", localObject1);
        return localObject2;
      }
      return null;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e(a, 1, "[parseBoxSwitchConfig] err:", paramJSONObject);
    }
    return null;
  }
  
  public static Map<String, String> b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QLog.e(a, 1, "[parseRedDotConfig] jsonObject is null.");
      return null;
    }
    try
    {
      Object localObject1 = paramJSONObject.getJSONObject("resultList");
      if (localObject1 != null)
      {
        paramJSONObject = ((JSONObject)localObject1).optString("style", "0");
        localObject1 = ((JSONObject)localObject1).optString("grayPolicyId", "0");
        Object localObject2 = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseRedDotConfig save red style:");
        localStringBuilder.append(paramJSONObject);
        QLog.i((String)localObject2, 1, localStringBuilder.toString());
        localObject2 = new HashMap();
        ((Map)localObject2).put("style", paramJSONObject);
        ((Map)localObject2).put("grayPolicyId", localObject1);
        return localObject2;
      }
      return null;
    }
    catch (Exception paramJSONObject)
    {
      QLog.e(a, 1, "[parseRedDotConfig] err:", paramJSONObject);
    }
    return null;
  }
  
  public Map<String, String> a()
  {
    Map localMap = this.b;
    if ((localMap != null) && (localMap.size() > 0)) {
      return (Map)this.b.get("qgame_msgassistant_aio_redpoint");
    }
    return null;
  }
  
  public void a(String paramString, Map<String, String> paramMap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramMap != null))
    {
      if (this.b == null) {
        this.b = new HashMap();
      }
      this.b.put(paramString, paramMap);
    }
  }
  
  public Map<String, String> b()
  {
    Map localMap = this.b;
    if ((localMap != null) && (localMap.size() > 0)) {
      return (Map)this.b.get("qgame_msgassistant_box");
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameMsgTabConfig{tabConfigs=");
    localStringBuilder.append(this.b.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.config.GameMsgTabConfig
 * JD-Core Version:    0.7.0.1
 */