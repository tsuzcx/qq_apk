package com.tencent.timi.game.tgpa.data;

import com.tencent.timi.game.utils.Logger;
import org.json.JSONObject;

public class CyminiTGPAData
{
  public static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      Logger.a("CyminiTGPAData", "getTGPADataKeyFromString parse error", paramString);
    }
    return 0;
  }
  
  public static JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("1111", "test notify");
      return localJSONObject;
    }
    catch (Exception localException)
    {
      Logger.a("CyminiTGPAData", "getTestNofityJson error ", localException);
    }
    return null;
  }
  
  public static int b(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      Logger.a("CyminiTGPAData", "getTGPASceneTypeFromString parse error", paramString);
    }
    return 0;
  }
  
  public static int c(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      Logger.a("CyminiTGPAData", "getTGPAResourceProgressTypeFromString parse error", paramString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tgpa.data.CyminiTGPAData
 * JD-Core Version:    0.7.0.1
 */