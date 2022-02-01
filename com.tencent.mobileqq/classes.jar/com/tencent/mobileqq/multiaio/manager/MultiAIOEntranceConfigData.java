package com.tencent.mobileqq.multiaio.manager;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MultiAIOEntranceConfigData
{
  public String a;
  public List<String> a;
  public boolean a;
  
  public MultiAIOEntranceConfigData()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static MultiAIOEntranceConfigData a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      return null;
    }
    try
    {
      MultiAIOEntranceConfigData localMultiAIOEntranceConfigData = new MultiAIOEntranceConfigData();
      paramString = new JSONObject(paramString);
      if (paramString.optInt("mainswitch", 0) == 1) {}
      for (;;)
      {
        localMultiAIOEntranceConfigData.jdField_a_of_type_Boolean = bool;
        localMultiAIOEntranceConfigData.jdField_a_of_type_JavaLangString = paramString.optString("qmcf", "");
        paramString = a(paramString.optJSONArray("black"));
        localMultiAIOEntranceConfigData.jdField_a_of_type_JavaUtilList.addAll(paramString);
        return localMultiAIOEntranceConfigData;
        bool = false;
      }
      return null;
    }
    catch (Exception paramString)
    {
      QLog.e("MultiAIOEntranceConfigProcessor", 2, "MultiAIOEntranceConfigData parse error", paramString);
    }
  }
  
  private static List<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            localArrayList.add(paramJSONArray.getString(i).trim());
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("MultiAIOEntranceConfigProcessor", 2, "MultiAIOEntranceConfigData processJsonArray error", localException);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<String> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.manager.MultiAIOEntranceConfigData
 * JD-Core Version:    0.7.0.1
 */