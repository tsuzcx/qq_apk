package com.tencent.ttpic.openapi.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FaceEditParams
  implements Cloneable
{
  public HashMap<String, Double> mParamsMap = new HashMap();
  
  public FaceEditParams()
  {
    this.mParamsMap.put("BEAUTY_WHITE", Double.valueOf(0.2D));
    HashMap localHashMap = this.mParamsMap;
    Double localDouble = Double.valueOf(0.5D);
    localHashMap.put("BEAUTY_SMOOTH", localDouble);
    this.mParamsMap.put("BEAUTY_COMPLEXION", localDouble);
    this.mParamsMap.put("BEAUTY_ANTISPOT", Double.valueOf(1.0D));
    localHashMap = this.mParamsMap;
    localDouble = Double.valueOf(0.0D);
    localHashMap.put("BEAUTY_EYEPOUCH", localDouble);
    this.mParamsMap.put("BEAUTY_TOOTH", localDouble);
    this.mParamsMap.put("BEAUTY_EYELIGHT", Double.valueOf(0.7D));
    this.mParamsMap.put("BEAUTY_GLOSSY", localDouble);
  }
  
  public FaceEditParams clone()
  {
    FaceEditParams localFaceEditParams = new FaceEditParams();
    Iterator localIterator = this.mParamsMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      double d = ((Double)this.mParamsMap.get(str)).doubleValue();
      localFaceEditParams.mParamsMap.put(str, Double.valueOf(d));
    }
    return localFaceEditParams;
  }
  
  public void updateFaceParam(String paramString, double paramDouble)
  {
    if (this.mParamsMap.containsKey(paramString)) {
      this.mParamsMap.put(paramString, Double.valueOf(paramDouble));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.FaceEditParams
 * JD-Core Version:    0.7.0.1
 */