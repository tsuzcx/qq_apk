package com.tencent.mobileqq.shortvideo.facedancegame;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExpressionTemplateConfig
{
  public float[] expressionAngle;
  public List<PointF> expressionFeat;
  public String expressionID;
  public double[] expressionWeight;
  
  public static ExpressionTemplateConfig parseConfig(String paramString)
  {
    for (;;)
    {
      ExpressionTemplateConfig localExpressionTemplateConfig;
      int i;
      double d;
      try
      {
        localExpressionTemplateConfig = new ExpressionTemplateConfig();
        paramString = new JSONObject(paramString);
        localExpressionTemplateConfig.expressionID = paramString.getString("expressionID");
        localJSONArray = paramString.optJSONArray("expressionFeat");
        if (localJSONArray != null)
        {
          float f = 0.0F;
          i = 0;
          if (i < localJSONArray.length())
          {
            d = localJSONArray.getDouble(i);
            if (i % 2 == 0)
            {
              f = (float)d;
            }
            else
            {
              PointF localPointF = new PointF(f, (float)d);
              if (localExpressionTemplateConfig.expressionFeat == null) {
                localExpressionTemplateConfig.expressionFeat = new ArrayList();
              }
              localExpressionTemplateConfig.expressionFeat.add(localPointF);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      JSONArray localJSONArray = paramString.optJSONArray("expressionAngle");
      int j;
      if (localJSONArray != null)
      {
        j = localJSONArray.length();
        i = 0;
        while (i < j)
        {
          if (localExpressionTemplateConfig.expressionAngle == null) {
            localExpressionTemplateConfig.expressionAngle = new float[j];
          }
          d = localJSONArray.getDouble(i);
          localExpressionTemplateConfig.expressionAngle[i] = ((float)d);
          i += 1;
        }
      }
      paramString = paramString.optJSONArray("expressionWeight");
      if (paramString != null)
      {
        j = paramString.length();
        i = 0;
        while (i < j)
        {
          if (localExpressionTemplateConfig.expressionWeight == null) {
            localExpressionTemplateConfig.expressionWeight = new double[j];
          }
          d = paramString.getDouble(i);
          localExpressionTemplateConfig.expressionWeight[i] = d;
          i += 1;
        }
      }
      return localExpressionTemplateConfig;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.ExpressionTemplateConfig
 * JD-Core Version:    0.7.0.1
 */