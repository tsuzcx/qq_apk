package com.tencent.mobileqq.shortvideo.dancemachine;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MatchTemplateConfig
{
  public int checkMethod;
  public int datumIndex0;
  public int datumIndex1;
  public float degreeThreshold;
  public float distanceThreshold;
  public List<MatchTemplateConfig.KeyPoint> keyPoints;
  public List<MatchTemplateConfig.KeyVector> keyVectors;
  
  public static MatchTemplateConfig parseConfig(String paramString)
  {
    int j = 0;
    try
    {
      MatchTemplateConfig localMatchTemplateConfig = new MatchTemplateConfig();
      paramString = new JSONObject(paramString);
      localMatchTemplateConfig.distanceThreshold = ((float)paramString.optDouble("distanceThreshold", -1.0D));
      localMatchTemplateConfig.degreeThreshold = ((float)paramString.optDouble("degreeThreshold", -1.0D));
      localMatchTemplateConfig.checkMethod = paramString.optInt("checkMethod", -1);
      Object localObject1 = paramString.getJSONArray("datumIndices");
      localMatchTemplateConfig.datumIndex0 = ((JSONArray)localObject1).getInt(0);
      localMatchTemplateConfig.datumIndex1 = ((JSONArray)localObject1).getInt(1);
      localObject1 = paramString.optJSONArray("keyPoints");
      int i;
      Object localObject2;
      if (localObject1 != null)
      {
        localMatchTemplateConfig.keyPoints = new ArrayList();
        i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject3 = (JSONObject)((JSONArray)localObject1).get(i);
          localObject2 = new MatchTemplateConfig.KeyPoint();
          ((MatchTemplateConfig.KeyPoint)localObject2).index = ((JSONObject)localObject3).optInt("index");
          ((MatchTemplateConfig.KeyPoint)localObject2).weight = ((float)((JSONObject)localObject3).optDouble("weight"));
          ((MatchTemplateConfig.KeyPoint)localObject2).threshold = ((float)((JSONObject)localObject3).optDouble("threshold"));
          localObject3 = ((JSONObject)localObject3).optJSONArray("point");
          ((MatchTemplateConfig.KeyPoint)localObject2).coords = new float[] { (float)((JSONArray)localObject3).getDouble(0), (float)((JSONArray)localObject3).getDouble(1) };
          localMatchTemplateConfig.keyPoints.add(localObject2);
          i += 1;
        }
      }
      paramString = paramString.optJSONArray("keyVectors");
      if (paramString != null)
      {
        localMatchTemplateConfig.keyVectors = new ArrayList();
        i = j;
        while (i < paramString.length())
        {
          localObject2 = (JSONObject)paramString.get(i);
          localObject1 = new MatchTemplateConfig.KeyVector();
          ((MatchTemplateConfig.KeyVector)localObject1).weight = ((float)((JSONObject)localObject2).optDouble("weight"));
          ((MatchTemplateConfig.KeyVector)localObject1).threshold = ((JSONObject)localObject2).optInt("threshold");
          localObject2 = ((JSONObject)localObject2).optJSONArray("vector");
          ((MatchTemplateConfig.KeyVector)localObject1).vectors = new int[] { ((JSONArray)localObject2).getInt(0), ((JSONArray)localObject2).getInt(1) };
          localMatchTemplateConfig.keyVectors.add(localObject1);
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
  
  public int[] getPointIndices()
  {
    if ((this.keyPoints != null) && (this.keyPoints.size() > 0))
    {
      int[] arrayOfInt = new int[this.keyPoints.size()];
      int i = 0;
      while (i < this.keyPoints.size())
      {
        arrayOfInt[i] = ((MatchTemplateConfig.KeyPoint)this.keyPoints.get(i)).index;
        i += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
  
  public JSONObject toJsonObject()
  {
    int j = 0;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put(this.datumIndex0);
      localJSONArray.put(this.datumIndex1);
      localJSONObject.put("datumIndices", localJSONArray);
      localJSONObject.put("distanceThreshold", this.distanceThreshold);
      localJSONObject.put("degreeThreshold", this.degreeThreshold);
      localJSONObject.put("checkMethod", this.checkMethod);
      int i;
      if (this.keyPoints != null)
      {
        localJSONArray = new JSONArray();
        i = 0;
        while (i < this.keyPoints.size())
        {
          localJSONArray.put(((MatchTemplateConfig.KeyPoint)this.keyPoints.get(i)).toJsonObject());
          i += 1;
        }
        localJSONObject.put("keyPoints", localJSONArray);
      }
      if (this.keyVectors != null)
      {
        localJSONArray = new JSONArray();
        i = j;
        while (i < this.keyVectors.size())
        {
          localJSONArray.put(((MatchTemplateConfig.KeyVector)this.keyVectors.get(i)).toJsonObject());
          i += 1;
        }
        localJSONObject.put("keyVectors", this.keyPoints);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.MatchTemplateConfig
 * JD-Core Version:    0.7.0.1
 */