package com.tencent.mobileqq.shortvideo.dancemachine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MatchTemplateConfig$KeyVector
{
  public int threshold;
  public int[] vectors;
  public float weight;
  
  public JSONObject toJsonObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("threshold", this.threshold);
      localJSONObject.put("weight", this.weight);
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < this.vectors.length)
      {
        localJSONArray.put(this.vectors[i]);
        i += 1;
      }
      localJSONObject.put("vector", localJSONArray);
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
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.MatchTemplateConfig.KeyVector
 * JD-Core Version:    0.7.0.1
 */