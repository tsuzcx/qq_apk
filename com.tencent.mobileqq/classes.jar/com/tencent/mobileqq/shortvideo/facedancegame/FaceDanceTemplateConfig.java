package com.tencent.mobileqq.shortvideo.facedancegame;

import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class FaceDanceTemplateConfig
{
  public ExpressionTemplateConfig mExpressionConfig;
  public String mGestureType;
  public String mTemplateID;
  public float threshold;
  
  public static FaceDanceTemplateConfig parseConfig(String paramString, List<ExpressionTemplateConfig> paramList)
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
        if (localExpressionTemplateConfig.expressionID.equals(str)) {
          localFaceDanceTemplateConfig.mExpressionConfig = localExpressionTemplateConfig;
        }
      }
      if (localFaceDanceTemplateConfig.mExpressionConfig == null) {
        return null;
      }
      localFaceDanceTemplateConfig.mTemplateID = paramString.getString("id");
      localFaceDanceTemplateConfig.mGestureType = paramString.getString("gesture");
      localFaceDanceTemplateConfig.threshold = ((float)paramString.getDouble("expression_threshold"));
      return localFaceDanceTemplateConfig;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.FaceDanceTemplateConfig
 * JD-Core Version:    0.7.0.1
 */