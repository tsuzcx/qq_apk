package com.tencent.mobileqq.leba.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.leba.pb.UserSetDynamicPlugin.PluginData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LebaPluginSetting
{
  public List<LebaPluginSettingItem> a;
  public long b;
  
  public static LebaPluginSetting a(String paramString)
  {
    localLebaPluginSetting = new LebaPluginSetting();
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("LebaPluginSetting", 1, "changeFormJson fail TextUtils.isEmpty(json)");
      return localLebaPluginSetting;
    }
    try
    {
      localLebaPluginSetting.a = new ArrayList();
      Object localObject = new JSONObject(paramString);
      JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("json_key_items");
      localLebaPluginSetting.b = ((JSONObject)localObject).optLong("json_key_sequence");
      int i = 0;
      while (i < localJSONArray.length())
      {
        localObject = localJSONArray.getJSONObject(i);
        localObject = new LebaPluginSettingItem(((JSONObject)localObject).optLong("json_key_plugin_id"), ((JSONObject)localObject).optInt("json_key_plugin_type"));
        if (!localLebaPluginSetting.a.contains(localObject)) {
          localLebaPluginSetting.a.add(localObject);
        }
        i += 1;
      }
      StringBuilder localStringBuilder;
      return localLebaPluginSetting;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("changeFormJson fail json=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("LebaPluginSetting", 1, ((StringBuilder)localObject).toString(), localException);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeFormJson sec json=");
      localStringBuilder.append(paramString);
      QLog.i("LebaPluginSetting", 1, localStringBuilder.toString());
    }
  }
  
  public static LebaPluginSetting a(List<UserSetDynamicPlugin.PluginData> paramList, long paramLong)
  {
    LebaPluginSetting localLebaPluginSetting = new LebaPluginSetting();
    localLebaPluginSetting.b = paramLong;
    if (paramList == null) {
      return localLebaPluginSetting;
    }
    localLebaPluginSetting.a = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (UserSetDynamicPlugin.PluginData)paramList.next();
      if (localObject != null)
      {
        localObject = new LebaPluginSettingItem(((UserSetDynamicPlugin.PluginData)localObject).id.get(), ((UserSetDynamicPlugin.PluginData)localObject).type.get());
        if (!localLebaPluginSetting.a.contains(localObject)) {
          localLebaPluginSetting.a.add(localObject);
        }
      }
    }
    return localLebaPluginSetting;
  }
  
  public static String a(LebaPluginSetting paramLebaPluginSetting)
  {
    if (paramLebaPluginSetting != null)
    {
      Object localObject1 = paramLebaPluginSetting.a;
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        try
        {
          localObject1 = new JSONArray();
          Object localObject2 = paramLebaPluginSetting.a.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            LebaPluginSettingItem localLebaPluginSettingItem = (LebaPluginSettingItem)((Iterator)localObject2).next();
            if (localLebaPluginSettingItem != null)
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("json_key_plugin_id", localLebaPluginSettingItem.a);
              localJSONObject.put("json_key_plugin_type", localLebaPluginSettingItem.b);
              ((JSONArray)localObject1).put(localJSONObject);
            }
          }
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("json_key_items", localObject1);
          ((JSONObject)localObject2).put("json_key_sequence", paramLebaPluginSetting.b);
          paramLebaPluginSetting = ((JSONObject)localObject2).toString();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("changeToJson sec json=");
          ((StringBuilder)localObject1).append(paramLebaPluginSetting);
          QLog.i("LebaPluginSetting", 1, ((StringBuilder)localObject1).toString());
          return paramLebaPluginSetting;
        }
        catch (Exception paramLebaPluginSetting)
        {
          QLog.i("LebaPluginSetting", 1, "changeToJson fail ", paramLebaPluginSetting);
          return "";
        }
      }
    }
    QLog.i("LebaPluginSetting", 1, "changeToJson fail setting == null || setting.items == null || setting.items.isEmpty()");
    return "";
  }
  
  public static List<UserSetDynamicPlugin.PluginData> a(List<LebaPluginSettingItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LebaPluginSettingItem localLebaPluginSettingItem = (LebaPluginSettingItem)paramList.next();
      UserSetDynamicPlugin.PluginData localPluginData = new UserSetDynamicPlugin.PluginData();
      localPluginData.id.set((int)localLebaPluginSettingItem.a);
      localPluginData.type.set(localLebaPluginSettingItem.b);
      localArrayList.add(localPluginData);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.entity.LebaPluginSetting
 * JD-Core Version:    0.7.0.1
 */