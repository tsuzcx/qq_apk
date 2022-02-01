package com.tencent.mobileqq.troop.blocktroop;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBlockConfig
{
  private List<Integer> a = new ArrayList();
  
  public static TroopBlockConfig a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("content : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopBlockConfig", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("grayTroopUins");
      if ((paramString != null) && (paramString.length() > 0))
      {
        int i = 0;
        while (i < paramString.length())
        {
          ((List)localObject).add(Integer.valueOf(paramString.getInt(i)));
          i += 1;
        }
      }
      StringBuilder localStringBuilder;
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = new TroopBlockConfig();
      paramString.a = ((List)localObject);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tempGrayList.size : ");
        localStringBuilder.append(((List)localObject).size());
        QLog.d("TroopBlockConfig", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isGrayTroop troopUin = ");
      localStringBuilder.append(paramString);
      QLog.d("TroopBlockConfig", 2, localStringBuilder.toString());
    }
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = true;
    if ((!bool3) && (this.a != null))
    {
      paramString = paramString.substring(paramString.length() - 1);
      int i = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i >= this.a.size()) {
          break;
        }
        if (String.valueOf(this.a.get(i)).equals(paramString))
        {
          bool1 = true;
          break;
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("isGrayTroop grayTroopUinList size = ");
        paramString.append(this.a.size());
        paramString.append(", isGrayTroop = ");
        paramString.append(bool1);
        QLog.d("TroopBlockConfig", 2, paramString.toString());
      }
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("grayTroopUinList isNull:  ");
      if (this.a != null) {
        bool1 = false;
      }
      paramString.append(bool1);
      QLog.d("TroopBlockConfig", 2, paramString.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopBlockConfig
 * JD-Core Version:    0.7.0.1
 */