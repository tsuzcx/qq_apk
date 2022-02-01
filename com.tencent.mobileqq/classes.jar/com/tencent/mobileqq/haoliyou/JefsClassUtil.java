package com.tencent.mobileqq.haoliyou;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class JefsClassUtil
{
  private static boolean a = false;
  private static JefsClassUtil.PolicyConfig b;
  
  public static JefsClassUtil.PolicyConfig a(JSONObject paramJSONObject)
  {
    JefsClassUtil.PolicyConfig localPolicyConfig = new JefsClassUtil.PolicyConfig();
    if (paramJSONObject == null) {
      return localPolicyConfig;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = paramJSONObject.optJSONArray("packages");
        int j;
        String str;
        if (localObject1 != null)
        {
          j = ((JSONArray)localObject1).length();
          i = 0;
          if (i < j)
          {
            str = ((JSONArray)localObject1).getString(i);
            if (str == null) {
              break label199;
            }
            localPolicyConfig.a.add(str);
            break label199;
          }
        }
        paramJSONObject = paramJSONObject.optJSONArray("policy");
        if (paramJSONObject != null)
        {
          j = paramJSONObject.length();
          i = 0;
          if (i < j)
          {
            Object localObject2 = paramJSONObject.getJSONObject(i);
            if (localObject2 != null)
            {
              localObject1 = ((JSONObject)localObject2).optString("package");
              str = ((JSONObject)localObject2).optString("schema");
              localObject2 = ((JSONObject)localObject2).optString("action");
              JefsClassUtil.Policy localPolicy = new JefsClassUtil.Policy();
              localPolicy.a = ((String)localObject1);
              localPolicy.b = str.toLowerCase();
              localPolicy.c = ((String)localObject2).toLowerCase();
              localPolicyConfig.b.add(localPolicy);
            }
            i += 1;
            continue;
          }
        }
        return localPolicyConfig;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.d("TeleScreen|JefsClass", 1, paramJSONObject, new Object[0]);
      }
      label199:
      i += 1;
    }
  }
  
  public static void a(boolean paramBoolean, JSONObject paramJSONObject)
  {
    try
    {
      a = paramBoolean;
      b = a(paramJSONObject);
      return;
    }
    finally
    {
      paramJSONObject = finally;
      throw paramJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClassUtil
 * JD-Core Version:    0.7.0.1
 */