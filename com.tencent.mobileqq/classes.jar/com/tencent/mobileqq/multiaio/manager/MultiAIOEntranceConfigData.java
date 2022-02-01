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
      localMultiAIOEntranceConfigData.jdField_a_of_type_Boolean = bool;
      localMultiAIOEntranceConfigData.jdField_a_of_type_JavaLangString = paramString.optString("qmcf", "");
      paramString = a(paramString.optJSONArray("black"));
      localMultiAIOEntranceConfigData.jdField_a_of_type_JavaUtilList.addAll(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.manager.MultiAIOEntranceConfigData
 * JD-Core Version:    0.7.0.1
 */