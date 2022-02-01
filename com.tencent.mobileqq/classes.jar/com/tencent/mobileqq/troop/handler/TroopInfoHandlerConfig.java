package com.tencent.mobileqq.troop.handler;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopInfoHandlerConfig
{
  private List<String> a = new ArrayList();
  
  public static TroopInfoHandlerConfig a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopInfoHandlerConfig", 2, "content : " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    ArrayList localArrayList;
    TroopInfoHandlerConfig localTroopInfoHandlerConfig;
    for (;;)
    {
      return paramString;
      localArrayList = new ArrayList();
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("FieldsFor88d");
        if ((paramString != null) && (paramString.length() > 0))
        {
          int i = 0;
          while (i < paramString.length())
          {
            localArrayList.add(paramString.getString(i));
            i += 1;
          }
        }
        if (!QLog.isColorLevel()) {}
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localTroopInfoHandlerConfig = new TroopInfoHandlerConfig();
        localTroopInfoHandlerConfig.a = localArrayList;
        paramString = localTroopInfoHandlerConfig;
      }
    }
    QLog.d("TroopInfoHandlerConfig", 2, "tempGrayList.size : " + localArrayList.size());
    return localTroopInfoHandlerConfig;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString)) || (this.a == null)) {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("isInFieldsList is null ? ");
        if (this.a != null) {
          break label58;
        }
        QLog.d("TroopInfoHandlerConfig", 2, bool);
      }
    }
    for (;;)
    {
      return false;
      label58:
      bool = false;
      break;
      int i = 0;
      while (i < this.a.size())
      {
        if (String.valueOf(this.a.get(i)).equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopInfoHandlerConfig
 * JD-Core Version:    0.7.0.1
 */