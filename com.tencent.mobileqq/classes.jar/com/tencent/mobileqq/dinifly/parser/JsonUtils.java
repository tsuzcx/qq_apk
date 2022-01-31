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
    float f2 = 0.0F;
    paramJsonReader.beginObject();
    float f1 = 0.0F;
    label8:
    while (paramJsonReader.hasNext())
    {
      String str = paramJsonReader.nextName();
      int i = -1;
      switch (str.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label8;
          if (str.equals("x"))
          {
            i = 0;
            continue;
            if (str.equals("y")) {
              i = 1;
            }
          }
          break;
        }
      }
      f1 = valueFromObject(paramJsonReader);
      continue;
      f2 = valueFromObject(paramJsonReader);
    }
    paramJsonReader.endObject();
    return new PointF(f1 * paramFloat, f2 * paramFloat);
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
    switch (JsonUtils.1.$SwitchMap$android$util$JsonToken[paramJsonReader.peek().ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unknown point starts with " + paramJsonReader.peek());
    case 1: 
      return jsonNumbersToPoint(paramJsonReader, paramFloat);
    case 2: 
      return jsonArrayToPoint(paramJsonReader, paramFloat);
    }
    return jsonObjectToPoint(paramJsonReader, paramFloat);
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
    switch (JsonUtils.1.$SwitchMap$android$util$JsonToken[localJsonToken.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Unknown value for token of type " + localJsonToken);
    case 1: 
      return (float)paramJsonReader.nextDouble();
    }
    paramJsonReader.beginArray();
    float f = (float)paramJsonReader.nextDouble();
    while (paramJsonReader.hasNext()) {
      paramJsonReader.skipValue();
    }
    paramJsonReader.endArray();
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.JsonUtils
 * JD-Core Version:    0.7.0.1
 */