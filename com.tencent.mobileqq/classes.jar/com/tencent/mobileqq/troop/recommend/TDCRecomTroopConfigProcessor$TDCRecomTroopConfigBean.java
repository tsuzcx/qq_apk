package com.tencent.mobileqq.troop.recommend;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TDCRecomTroopConfigProcessor$TDCRecomTroopConfigBean
{
  public String a;
  public boolean a;
  
  public TDCRecomTroopConfigProcessor$TDCRecomTroopConfigBean()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static TDCRecomTroopConfigBean a(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        localTDCRecomTroopConfigBean = new TDCRecomTroopConfigBean();
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          if (localJSONObject.optInt("switch") != 1) {
            break label127;
          }
          bool = true;
          localTDCRecomTroopConfigBean.jdField_a_of_type_Boolean = bool;
          localTDCRecomTroopConfigBean.jdField_a_of_type_JavaLangString = localJSONObject.optString("tipText");
        }
        catch (Exception localException1) {}
        QLog.d("TDCRecomTroopConfigProcessor", 1, "convertFromJSONObject exception ", localException2);
      }
      catch (Exception localException2)
      {
        localTDCRecomTroopConfigBean = null;
      }
      break label75;
      TDCRecomTroopConfigBean localTDCRecomTroopConfigBean = null;
      label75:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("convertFromJSONObject ,content = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",result = ");
        localStringBuilder.append(localTDCRecomTroopConfigBean);
        QLog.d("TDCRecomTroopConfigProcessor", 2, localStringBuilder.toString());
      }
      return localTDCRecomTroopConfigBean;
      label127:
      boolean bool = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[displayOrNot:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(",title:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean
 * JD-Core Version:    0.7.0.1
 */