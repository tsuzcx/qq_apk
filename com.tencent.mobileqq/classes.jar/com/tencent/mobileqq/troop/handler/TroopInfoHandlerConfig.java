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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("content : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("TroopInfoHandlerConfig", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new ArrayList();
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("FieldsFor88d");
      if ((paramString != null) && (paramString.length() > 0))
      {
        int i = 0;
        while (i < paramString.length())
        {
          ((List)localObject).add(paramString.getString(i));
          i += 1;
        }
      }
      StringBuilder localStringBuilder;
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      paramString = new TroopInfoHandlerConfig();
      paramString.a = ((List)localObject);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("tempGrayList.size : ");
        localStringBuilder.append(((List)localObject).size());
        QLog.d("TroopInfoHandlerConfig", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = true;
    if ((!bool2) && (this.a != null))
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (String.valueOf(this.a.get(i)).equals(paramString)) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isInFieldsList is null ? ");
      if (this.a != null) {
        bool1 = false;
      }
      paramString.append(bool1);
      QLog.d("TroopInfoHandlerConfig", 2, paramString.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopInfoHandlerConfig
 * JD-Core Version:    0.7.0.1
 */