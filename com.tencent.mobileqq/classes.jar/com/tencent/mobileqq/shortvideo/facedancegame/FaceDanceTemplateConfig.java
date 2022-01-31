package com.tencent.mobileqq.shortvideo.facedancegame;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class FaceDanceTemplateConfig
{
  public float a;
  public ExpressionTemplateConfig a;
  public String a;
  public String b;
  
  public static FaceDanceTemplateConfig a(String paramString, List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    try
    {
      FaceDanceTemplateConfig localFaceDanceTemplateConfig = new FaceDanceTemplateConfig();
      paramString = new JSONObject(paramString);
      String str = paramString.getString("expression");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ExpressionTemplateConfig localExpressionTemplateConfig = (ExpressionTemplateConfig)paramList.next();
        if (localExpressionTemplateConfig.jdField_a_of_type_JavaLangString.equals(str)) {
          localFaceDanceTemplateConfig.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameExpressionTemplateConfig = localExpressionTemplateConfig;
        }
      }
      if (localFaceDanceTemplateConfig.jdField_a_of_type_ComTencentMobileqqShortvideoFacedancegameExpressionTemplateConfig == null) {
        return null;
      }
      localFaceDanceTemplateConfig.jdField_a_of_type_JavaLangString = paramString.getString("id");
      localFaceDanceTemplateConfig.b = paramString.getString("gesture");
      localFaceDanceTemplateConfig.jdField_a_of_type_Float = ((float)paramString.getDouble("expression_threshold"));
      return localFaceDanceTemplateConfig;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceTemplateConfig
 * JD-Core Version:    0.7.0.1
 */