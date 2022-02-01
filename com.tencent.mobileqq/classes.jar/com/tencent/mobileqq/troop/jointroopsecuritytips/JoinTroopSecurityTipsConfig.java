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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("content : ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("JoinTroopSecurityTipsConfig.config", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1 = new HashMap();
    label320:
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("ui");
        int j;
        if ((paramString != null) && (paramString.length() > 0))
        {
          int i = 0;
          if (i < paramString.length())
          {
            Object localObject2 = paramString.getJSONObject(i);
            if (localObject2 != null)
            {
              JoinTroopSecurityTipsItem localJoinTroopSecurityTipsItem = new JoinTroopSecurityTipsItem();
              localJoinTroopSecurityTipsItem.a = ((JSONObject)localObject2).optInt("id", 0);
              localJoinTroopSecurityTipsItem.b = ((JSONObject)localObject2).optString("title", "");
              localJoinTroopSecurityTipsItem.c = ((JSONObject)localObject2).optString("text", "");
              localObject2 = ((JSONObject)localObject2).getJSONArray("btns");
              if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
              {
                j = 0;
                if (j < ((JSONArray)localObject2).length())
                {
                  JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
                  if (localJSONObject == null) {
                    break label320;
                  }
                  localJoinTroopSecurityTipsItem.getClass();
                  JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn localJoinTroopSecurityTipsBtn = new JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn(localJoinTroopSecurityTipsItem);
                  localJoinTroopSecurityTipsBtn.a = localJSONObject.optString("text", "");
                  localJoinTroopSecurityTipsBtn.b = localJSONObject.optString("action", "");
                  localJoinTroopSecurityTipsBtn.c = localJSONObject.optString("url", "");
                  localJoinTroopSecurityTipsItem.d.add(localJoinTroopSecurityTipsBtn);
                  break label320;
                }
              }
              ((HashMap)localObject1).put(Integer.valueOf(localJoinTroopSecurityTipsItem.a), localJoinTroopSecurityTipsItem);
            }
            i += 1;
            continue;
          }
        }
        j += 1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = new JoinTroopSecurityTipsConfig();
        paramString.a = ((HashMap)localObject1);
        return paramString;
      }
    }
  }
  
  private boolean a(JoinTroopSecurityTipsItem paramJoinTroopSecurityTipsItem)
  {
    if ((paramJoinTroopSecurityTipsItem != null) && (!TextUtils.isEmpty(paramJoinTroopSecurityTipsItem.b)))
    {
      if (TextUtils.isEmpty(paramJoinTroopSecurityTipsItem.c)) {
        return true;
      }
      if (paramJoinTroopSecurityTipsItem.d != null)
      {
        if (paramJoinTroopSecurityTipsItem.d.size() == 0) {
          return true;
        }
        int i = 0;
        while (i < paramJoinTroopSecurityTipsItem.d.size())
        {
          JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn localJoinTroopSecurityTipsBtn = (JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn)paramJoinTroopSecurityTipsItem.d.get(i);
          if (localJoinTroopSecurityTipsBtn != null)
          {
            if (TextUtils.isEmpty(localJoinTroopSecurityTipsBtn.a)) {
              return true;
            }
            return ("web".equals(localJoinTroopSecurityTipsBtn.b)) && (TextUtils.isEmpty(localJoinTroopSecurityTipsBtn.c));
          }
          i += 1;
        }
      }
    }
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
    localJoinTroopSecurityTipsItem.a = 0;
    localJoinTroopSecurityTipsItem.b = paramContext.getString(2131891070);
    localJoinTroopSecurityTipsItem.c = paramContext.getString(2131891069);
    localJoinTroopSecurityTipsItem.getClass();
    JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn localJoinTroopSecurityTipsBtn = new JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn(localJoinTroopSecurityTipsItem);
    localJoinTroopSecurityTipsBtn.a = paramContext.getString(2131891068);
    localJoinTroopSecurityTipsItem.d.add(localJoinTroopSecurityTipsBtn);
    return localJoinTroopSecurityTipsItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsConfig
 * JD-Core Version:    0.7.0.1
 */