package com.tencent.mobileqq.troop.jointroopsecuritytips;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JoinTroopSecurityTipsConfig
{
  private HashMap<Integer, JoinTroopSecurityTipsItem> a = new HashMap();
  
  public static JoinTroopSecurityTipsConfig a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JoinTroopSecurityTipsConfig.config", 2, "content : " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      int i;
      JoinTroopSecurityTipsItem localJoinTroopSecurityTipsItem;
      int j;
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("ui");
        if ((paramString != null) && (paramString.length() > 0))
        {
          i = 0;
          if (i < paramString.length())
          {
            Object localObject = paramString.getJSONObject(i);
            if (localObject == null) {
              break label307;
            }
            localJoinTroopSecurityTipsItem = new JoinTroopSecurityTipsItem();
            localJoinTroopSecurityTipsItem.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("id", 0);
            localJoinTroopSecurityTipsItem.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("title", "");
            localJoinTroopSecurityTipsItem.b = ((JSONObject)localObject).optString("text", "");
            localObject = ((JSONObject)localObject).getJSONArray("btns");
            if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
              break label292;
            }
            j = 0;
            if (j >= ((JSONArray)localObject).length()) {
              break label292;
            }
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(j);
            if (localJSONObject == null) {
              break label314;
            }
            localJoinTroopSecurityTipsItem.getClass();
            JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn localJoinTroopSecurityTipsBtn = new JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn(localJoinTroopSecurityTipsItem);
            localJoinTroopSecurityTipsBtn.jdField_a_of_type_JavaLangString = localJSONObject.optString("text", "");
            localJoinTroopSecurityTipsBtn.b = localJSONObject.optString("action", "");
            localJoinTroopSecurityTipsBtn.c = localJSONObject.optString("url", "");
            localJoinTroopSecurityTipsItem.jdField_a_of_type_JavaUtilList.add(localJoinTroopSecurityTipsBtn);
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = new JoinTroopSecurityTipsConfig();
        paramString.a = localHashMap;
        return paramString;
      }
      label292:
      localHashMap.put(Integer.valueOf(localJoinTroopSecurityTipsItem.jdField_a_of_type_Int), localJoinTroopSecurityTipsItem);
      label307:
      i += 1;
      continue;
      label314:
      j += 1;
    }
  }
  
  private boolean a(JoinTroopSecurityTipsItem paramJoinTroopSecurityTipsItem)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramJoinTroopSecurityTipsItem == null) || (TextUtils.isEmpty(paramJoinTroopSecurityTipsItem.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramJoinTroopSecurityTipsItem.b)))
    {
      bool1 = true;
      return bool1;
    }
    if ((paramJoinTroopSecurityTipsItem.jdField_a_of_type_JavaUtilList == null) || (paramJoinTroopSecurityTipsItem.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramJoinTroopSecurityTipsItem.jdField_a_of_type_JavaUtilList.size()) {
        break label139;
      }
      JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn localJoinTroopSecurityTipsBtn = (JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn)paramJoinTroopSecurityTipsItem.jdField_a_of_type_JavaUtilList.get(i);
      if (localJoinTroopSecurityTipsBtn != null)
      {
        if (TextUtils.isEmpty(localJoinTroopSecurityTipsBtn.jdField_a_of_type_JavaLangString)) {
          return true;
        }
        bool1 = bool2;
        if (!"web".equals(localJoinTroopSecurityTipsBtn.b)) {
          break;
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(localJoinTroopSecurityTipsBtn.c)) {
          break;
        }
        return true;
      }
      i += 1;
    }
    label139:
    return true;
  }
  
  public JoinTroopSecurityTipsItem a(int paramInt)
  {
    JoinTroopSecurityTipsItem localJoinTroopSecurityTipsItem2 = (JoinTroopSecurityTipsItem)this.a.get(Integer.valueOf(paramInt));
    JoinTroopSecurityTipsItem localJoinTroopSecurityTipsItem1 = localJoinTroopSecurityTipsItem2;
    if (a(localJoinTroopSecurityTipsItem2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("JoinTroopSecurityTipsConfig.config", 2, "getItem isInvalidItem");
      }
      localJoinTroopSecurityTipsItem1 = null;
    }
    return localJoinTroopSecurityTipsItem1;
  }
  
  public JoinTroopSecurityTipsItem a(Context paramContext)
  {
    JoinTroopSecurityTipsItem localJoinTroopSecurityTipsItem = new JoinTroopSecurityTipsItem();
    localJoinTroopSecurityTipsItem.jdField_a_of_type_Int = 0;
    localJoinTroopSecurityTipsItem.jdField_a_of_type_JavaLangString = paramContext.getString(2131693561);
    localJoinTroopSecurityTipsItem.b = paramContext.getString(2131693560);
    localJoinTroopSecurityTipsItem.getClass();
    JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn localJoinTroopSecurityTipsBtn = new JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn(localJoinTroopSecurityTipsItem);
    localJoinTroopSecurityTipsBtn.jdField_a_of_type_JavaLangString = paramContext.getString(2131693559);
    localJoinTroopSecurityTipsItem.jdField_a_of_type_JavaUtilList.add(localJoinTroopSecurityTipsBtn);
    return localJoinTroopSecurityTipsItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsConfig
 * JD-Core Version:    0.7.0.1
 */