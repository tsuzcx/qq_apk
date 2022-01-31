package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MatchTemplateConfig
{
  public float a;
  public int a;
  public List a;
  public float b;
  public int b;
  public List b;
  public int c;
  
  public static MatchTemplateConfig a(String paramString)
  {
    int j = 0;
    try
    {
      MatchTemplateConfig localMatchTemplateConfig = new MatchTemplateConfig();
      paramString = new JSONObject(paramString);
      localMatchTemplateConfig.jdField_a_of_type_Float = ((float)paramString.optDouble("distanceThreshold", -1.0D));
      localMatchTemplateConfig.jdField_b_of_type_Float = ((float)paramString.optDouble("degreeThreshold", -1.0D));
      localMatchTemplateConfig.jdField_a_of_type_Int = paramString.optInt("checkMethod", -1);
      Object localObject1 = paramString.getJSONArray("datumIndices");
      localMatchTemplateConfig.jdField_b_of_type_Int = ((JSONArray)localObject1).getInt(0);
      localMatchTemplateConfig.c = ((JSONArray)localObject1).getInt(1);
      localObject1 = paramString.optJSONArray("keyPoints");
      int i;
      Object localObject2;
      if (localObject1 != null)
      {
        localMatchTemplateConfig.jdField_a_of_type_JavaUtilList = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject3 = (JSONObject)((JSONArray)localObject1).get(i);
          localObject2 = new MatchTemplateConfig.KeyPoint();
          ((MatchTemplateConfig.KeyPoint)localObject2).jdField_a_of_type_Int = ((JSONObject)localObject3).optInt("index");
          ((MatchTemplateConfig.KeyPoint)localObject2).jdField_a_of_type_Float = ((float)((JSONObject)localObject3).optDouble("weight"));
          ((MatchTemplateConfig.KeyPoint)localObject2).jdField_b_of_type_Float = ((float)((JSONObject)localObject3).optDouble("threshold"));
          localObject3 = ((JSONObject)localObject3).optJSONArray("point");
          ((MatchTemplateConfig.KeyPoint)localObject2).jdField_a_of_type_ArrayOfFloat = new float[] { (float)((JSONArray)localObject3).getDouble(0), (float)((JSONArray)localObject3).getDouble(1) };
          localMatchTemplateConfig.jdField_a_of_type_JavaUtilList.add(localObject2);
          i += 1;
        }
      }
      paramString = paramString.optJSONArray("keyVectors");
      if (paramString != null)
      {
        localMatchTemplateConfig.jdField_b_of_type_JavaUtilList = new ArrayList();
        i = j;
        while (i < paramString.length())
        {
          localObject2 = (JSONObject)paramString.get(i);
          localObject1 = new MatchTemplateConfig.KeyVector();
          ((MatchTemplateConfig.KeyVector)localObject1).jdField_a_of_type_Float = ((float)((JSONObject)localObject2).optDouble("weight"));
          ((MatchTemplateConfig.KeyVector)localObject1).jdField_a_of_type_Int = ((JSONObject)localObject2).optInt("threshold");
          localObject2 = ((JSONObject)localObject2).optJSONArray("vector");
          ((MatchTemplateConfig.KeyVector)localObject1).jdField_a_of_type_ArrayOfInt = new int[] { ((JSONArray)localObject2).getInt(0), ((JSONArray)localObject2).getInt(1) };
          localMatchTemplateConfig.jdField_b_of_type_JavaUtilList.add(localObject1);
          i += 1;
        }
      }
      paramString = localMatchTemplateConfig;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    finally {}
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.MatchTemplateConfig
 * JD-Core Version:    0.7.0.1
 */