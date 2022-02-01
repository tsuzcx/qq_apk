package com.tencent.mobileqq.multiaio.manager;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MultiAIOEntranceConfigData
{
  public boolean a;
  public String b = "";
  public List<String> c = new ArrayList();
  
  public static MultiAIOEntranceConfigData a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      MultiAIOEntranceConfigData localMultiAIOEntranceConfigData = new MultiAIOEntranceConfigData();
      paramString = new JSONObject(paramString);
      boolean bool = false;
      if (paramString.optInt("mainswitch", 0) == 1) {
        bool = true;
      }
      localMultiAIOEntranceConfigData.a = bool;
      localMultiAIOEntranceConfigData.b = paramString.optString("qmcf", "");
      paramString = a(paramString.optJSONArray("black"));
      localMultiAIOEntranceConfigData.c.addAll(paramString);
      return localMultiAIOEntranceConfigData;
    }
    catch (Exception paramString)
    {
      QLog.e("MultiAIOEntranceConfigProcessor", 2, "MultiAIOEntranceConfigData parse error", paramString);
    }
    return null;
  }
  
  private static List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        try
        {
          localArrayList.add(paramJSONArray.getString(i).trim());
        }
        catch (Exception localException)
        {
          QLog.e("MultiAIOEntranceConfigProcessor", 2, "MultiAIOEntranceConfigData processJsonArray error", localException);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public List<String> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.manager.MultiAIOEntranceConfigData
 * JD-Core Version:    0.7.0.1
 */