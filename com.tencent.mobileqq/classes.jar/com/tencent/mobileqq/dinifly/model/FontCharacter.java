package com.tencent.mobileqq.dinifly.model;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FontCharacter
{
  private final char character;
  private final String fontFamily;
  private final List<ShapeGroup> shapes;
  private final int size;
  private final String style;
  private final double width;
  
  FontCharacter(List<ShapeGroup> paramList, char paramChar, int paramInt, double paramDouble, String paramString1, String paramString2)
  {
    this.shapes = paramList;
    this.character = paramChar;
    this.size = paramInt;
    this.width = paramDouble;
    this.style = paramString1;
    this.fontFamily = paramString2;
  }
  
  public static int hashFor(char paramChar, String paramString1, String paramString2)
  {
    return ((paramChar + '\000') * 31 + paramString1.hashCode()) * 31 + paramString2.hashCode();
  }
  
  public List<ShapeGroup> getShapes()
  {
    return this.shapes;
  }
  
  int getSize()
  {
    return this.size;
  }
  
  String getStyle()
  {
    return this.style;
  }
  
  public double getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    return hashFor(this.character, this.fontFamily, this.style);
  }
  
  public static class Factory
  {
    public static FontCharacter newInstance(JSONObject paramJSONObject, LottieComposition paramLottieComposition)
    {
      char c = paramJSONObject.optString("ch").charAt(0);
      int j = paramJSONObject.optInt("size");
      double d = paramJSONObject.optDouble("w");
      String str1 = paramJSONObject.optString("style");
      String str2 = paramJSONObject.optString("fFamily");
      Object localObject2 = paramJSONObject.optJSONObject("data");
      Object localObject1 = Collections.emptyList();
      paramJSONObject = (JSONObject)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((JSONObject)localObject2).optJSONArray("shapes");
        paramJSONObject = (JSONObject)localObject1;
        if (localObject2 != null)
        {
          localObject1 = new ArrayList(((JSONArray)localObject2).length());
          int i = 0;
          for (;;)
          {
            paramJSONObject = (JSONObject)localObject1;
            if (i >= ((JSONArray)localObject2).length()) {
              break;
            }
            ((List)localObject1).add((ShapeGroup)ShapeGroup.shapeItemWithJson(((JSONArray)localObject2).optJSONObject(i), paramLottieComposition));
            i += 1;
          }
        }
      }
      return new FontCharacter(paramJSONObject, c, j, d, str1, str2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.FontCharacter
 * JD-Core Version:    0.7.0.1
 */