package com.tencent.mobileqq.shortvideo.facedancegame;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ExpressionTemplateConfig
{
  public String a;
  public List a;
  public double[] a;
  public float[] a;
  
  public static ExpressionTemplateConfig a(String paramString)
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
        localExpressionTemplateConfig.jdField_a_of_type_JavaLangString = paramString.getString("expressionID");
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
              if (localExpressionTemplateConfig.jdField_a_of_type_JavaUtilList == null) {
                localExpressionTemplateConfig.jdField_a_of_type_JavaUtilList = new ArrayList();
              }
              localExpressionTemplateConfig.jdField_a_of_type_JavaUtilList.add(localPointF);
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
          if (localExpressionTemplateConfig.jdField_a_of_type_ArrayOfFloat == null) {
            localExpressionTemplateConfig.jdField_a_of_type_ArrayOfFloat = new float[j];
          }
          d = localJSONArray.getDouble(i);
          localExpressionTemplateConfig.jdField_a_of_type_ArrayOfFloat[i] = ((float)d);
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
          if (localExpressionTemplateConfig.jdField_a_of_type_ArrayOfDouble == null) {
            localExpressionTemplateConfig.jdField_a_of_type_ArrayOfDouble = new double[j];
          }
          d = paramString.getDouble(i);
          localExpressionTemplateConfig.jdField_a_of_type_ArrayOfDouble[i] = d;
          i += 1;
        }
      }
      return localExpressionTemplateConfig;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.facedancegame.ExpressionTemplateConfig
 * JD-Core Version:    0.7.0.1
 */