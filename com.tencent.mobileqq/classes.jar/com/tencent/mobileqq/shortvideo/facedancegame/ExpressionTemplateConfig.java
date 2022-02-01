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
      int i;
      try
      {
        ExpressionTemplateConfig localExpressionTemplateConfig = new ExpressionTemplateConfig();
        paramString = new JSONObject(paramString);
        localExpressionTemplateConfig.expressionID = paramString.getString("expressionID");
        JSONArray localJSONArray = paramString.optJSONArray("expressionFeat");
        int j = 0;
        double d;
        if (localJSONArray != null)
        {
          i = 0;
          float f = 0.0F;
          if (i < localJSONArray.length())
          {
            d = localJSONArray.getDouble(i);
            if (i % 2 == 0)
            {
              f = (float)d;
              break label283;
            }
            PointF localPointF = new PointF(f, (float)d);
            if (localExpressionTemplateConfig.expressionFeat == null) {
              localExpressionTemplateConfig.expressionFeat = new ArrayList();
            }
            localExpressionTemplateConfig.expressionFeat.add(localPointF);
            break label283;
          }
        }
        localJSONArray = paramString.optJSONArray("expressionAngle");
        int k;
        if (localJSONArray != null)
        {
          k = localJSONArray.length();
          i = 0;
          if (i < k)
          {
            if (localExpressionTemplateConfig.expressionAngle == null) {
              localExpressionTemplateConfig.expressionAngle = new float[k];
            }
            d = localJSONArray.getDouble(i);
            localExpressionTemplateConfig.expressionAngle[i] = ((float)d);
            i += 1;
            continue;
          }
        }
        paramString = paramString.optJSONArray("expressionWeight");
        if (paramString != null)
        {
          k = paramString.length();
          i = j;
          if (i < k)
          {
            if (localExpressionTemplateConfig.expressionWeight == null) {
              localExpressionTemplateConfig.expressionWeight = new double[k];
            }
            d = paramString.getDouble(i);
            localExpressionTemplateConfig.expressionWeight[i] = d;
            i += 1;
            continue;
          }
        }
        return localExpressionTemplateConfig;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      label283:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.ExpressionTemplateConfig
 * JD-Core Version:    0.7.0.1
 */