package com.tencent.mobileqq.dinifly.parser;

import android.graphics.Color;
import android.graphics.PointF;
import android.support.annotation.ColorInt;
import android.util.JsonReader;
import android.util.JsonToken;
import java.util.ArrayList;
import java.util.List;

class JsonUtils
{
  private static PointF jsonArrayToPoint(JsonReader paramJsonReader, float paramFloat)
  {
    paramJsonReader.beginArray();
    float f1 = (float)paramJsonReader.nextDouble();
    float f2 = (float)paramJsonReader.nextDouble();
    while (paramJsonReader.peek() != JsonToken.END_ARRAY) {
      paramJsonReader.skipValue();
    }
    paramJsonReader.endArray();
    return new PointF(f1 * paramFloat, f2 * paramFloat);
  }
  
  private static PointF jsonNumbersToPoint(JsonReader paramJsonReader, float paramFloat)
  {
    float f1 = (float)paramJsonReader.nextDouble();
    float f2 = (float)paramJsonReader.nextDouble();
    while (paramJsonReader.hasNext()) {
      paramJsonReader.skipValue();
    }
    return new PointF(f1 * paramFloat, f2 * paramFloat);
  }
  
  private static PointF jsonObjectToPoint(JsonReader paramJsonReader, float paramFloat)
  {
    paramJsonReader.beginObject();
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      int j = str.hashCode();
      if (j != 120)
      {
        if ((j == 121) && (str.equals("y"))) {
          i = 1;
        }
      }
      else if (str.equals("x")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1) {
          paramJsonReader.skipValue();
        } else {
          f1 = valueFromObject(paramJsonReader);
        }
      }
      else {
        f2 = valueFromObject(paramJsonReader);
      }
    }
    paramJsonReader.endObject();
    return new PointF(f2 * paramFloat, f1 * paramFloat);
  }
  
  @ColorInt
  static int jsonToColor(JsonReader paramJsonReader)
  {
    paramJsonReader.beginArray();
    int i = (int)(paramJsonReader.nextDouble() * 255.0D);
    int j = (int)(paramJsonReader.nextDouble() * 255.0D);
    int k = (int)(paramJsonReader.nextDouble() * 255.0D);
    while (paramJsonReader.hasNext()) {
      paramJsonReader.skipValue();
    }
    paramJsonReader.endArray();
    return Color.argb(255, i, j, k);
  }
  
  static PointF jsonToPoint(JsonReader paramJsonReader, float paramFloat)
  {
    int i = JsonUtils.1.$SwitchMap$android$util$JsonToken[paramJsonReader.peek().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return jsonObjectToPoint(paramJsonReader, paramFloat);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown point starts with ");
        localStringBuilder.append(paramJsonReader.peek());
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      return jsonArrayToPoint(paramJsonReader, paramFloat);
    }
    return jsonNumbersToPoint(paramJsonReader, paramFloat);
  }
  
  static List<PointF> jsonToPoints(JsonReader paramJsonReader, float paramFloat)
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY)
    {
      paramJsonReader.beginArray();
      localArrayList.add(jsonToPoint(paramJsonReader, paramFloat));
      paramJsonReader.endArray();
    }
    paramJsonReader.endArray();
    return localArrayList;
  }
  
  static float valueFromObject(JsonReader paramJsonReader)
  {
    JsonToken localJsonToken = paramJsonReader.peek();
    int i = JsonUtils.1.$SwitchMap$android$util$JsonToken[localJsonToken.ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        paramJsonReader.beginArray();
        float f = (float)paramJsonReader.nextDouble();
        while (paramJsonReader.hasNext()) {
          paramJsonReader.skipValue();
        }
        paramJsonReader.endArray();
        return f;
      }
      paramJsonReader = new StringBuilder();
      paramJsonReader.append("Unknown value for token of type ");
      paramJsonReader.append(localJsonToken);
      throw new IllegalArgumentException(paramJsonReader.toString());
    }
    return (float)paramJsonReader.nextDouble();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.JsonUtils
 * JD-Core Version:    0.7.0.1
 */