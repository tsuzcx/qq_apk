package com.tencent.mobileqq.shortvideo.dancemachine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MatchTemplateConfig$KeyPoint
{
  public float[] coords;
  public int index;
  public float threshold;
  public float weight;
  
  public MatchTemplateConfig$KeyPoint() {}
  
  public MatchTemplateConfig$KeyPoint(int paramInt, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat)
  {
    this.index = paramInt;
    this.weight = paramFloat1;
    this.coords = paramArrayOfFloat;
    this.threshold = paramFloat2;
  }
  
  public JSONObject toJsonObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("index", this.index);
      localJSONObject.put("weight", this.weight);
      localJSONObject.put("threshold", this.threshold);
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < this.coords.length)
      {
        localJSONArray.put(this.coords[i]);
        i += 1;
      }
      localJSONObject.put("point", localJSONArray);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.MatchTemplateConfig.KeyPoint
 * JD-Core Version:    0.7.0.1
 */