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
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockConfig", 2, "content : " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    ArrayList localArrayList;
    TroopBlockConfig localTroopBlockConfig;
    for (;;)
    {
      return paramString;
      localArrayList = new ArrayList();
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("grayTroopUins");
        if ((paramString != null) && (paramString.length() > 0))
        {
          int i = 0;
          while (i < paramString.length())
          {
            localArrayList.add(Integer.valueOf(paramString.getInt(i)));
            i += 1;
          }
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localTroopBlockConfig = new TroopBlockConfig();
        localTroopBlockConfig.a = localArrayList;
        paramString = localTroopBlockConfig;
      }
    }
    QLog.d("TroopBlockConfig", 2, "tempGrayList.size : " + localArrayList.size());
    return localTroopBlockConfig;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockConfig", 2, "isGrayTroop troopUin = " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (this.a == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("grayTroopUinList isNull:  ");
        if (this.a != null) {
          break label96;
        }
      }
      for (;;)
      {
        QLog.d("TroopBlockConfig", 2, bool1);
        bool2 = false;
        return bool2;
        label96:
        bool1 = false;
      }
    }
    paramString = paramString.substring(paramString.length() - 1);
    int i = 0;
    label114:
    if (i < this.a.size()) {
      if (!String.valueOf(this.a.get(i)).equals(paramString)) {}
    }
    for (bool1 = bool2;; bool1 = false)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopBlockConfig", 2, "isGrayTroop grayTroopUinList size = " + this.a.size() + ", isGrayTroop = " + bool1);
      return bool1;
      i += 1;
      break label114;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.blocktroop.TroopBlockConfig
 * JD-Core Version:    0.7.0.1
 */