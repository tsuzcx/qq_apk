package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.tencent.mobileqq.dinifly.model.CubicCurveData;
import com.tencent.mobileqq.dinifly.model.content.ShapeData;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeDataParser
  implements ValueParser<ShapeData>
{
  public static final ShapeDataParser INSTANCE = new ShapeDataParser();
  
  public ShapeData parse(JsonReader paramJsonReader, float paramFloat)
  {
    if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY) {
      paramJsonReader.beginArray();
    }
    paramJsonReader.beginObject();
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    boolean bool = false;
    Object localObject4;
    int i;
    int j;
    while (paramJsonReader.hasNext())
    {
      localObject4 = paramJsonReader.nextName();
      i = -1;
      j = ((String)localObject4).hashCode();
      if (j != 99)
      {
        if (j != 105)
        {
          if (j != 111)
          {
            if ((j == 118) && (((String)localObject4).equals("v"))) {
              i = 1;
            }
          }
          else if (((String)localObject4).equals("o")) {
            i = 3;
          }
        }
        else if (((String)localObject4).equals("i")) {
          i = 2;
        }
      }
      else if (((String)localObject4).equals("c")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              localObject2 = JsonUtils.jsonToPoints(paramJsonReader, paramFloat);
            }
          }
          else {
            localObject1 = JsonUtils.jsonToPoints(paramJsonReader, paramFloat);
          }
        }
        else {
          localObject3 = JsonUtils.jsonToPoints(paramJsonReader, paramFloat);
        }
      }
      else {
        bool = paramJsonReader.nextBoolean();
      }
    }
    paramJsonReader.endObject();
    if (paramJsonReader.peek() == JsonToken.END_ARRAY) {
      paramJsonReader.endArray();
    }
    if ((localObject3 != null) && (localObject1 != null) && (localObject2 != null))
    {
      if (((List)localObject3).isEmpty()) {
        return new ShapeData(new PointF(), false, Collections.emptyList());
      }
      j = ((List)localObject3).size();
      paramJsonReader = (PointF)((List)localObject3).get(0);
      localObject4 = new ArrayList(j);
      i = 1;
      PointF localPointF1;
      while (i < j)
      {
        localPointF1 = (PointF)((List)localObject3).get(i);
        int k = i - 1;
        PointF localPointF2 = (PointF)((List)localObject3).get(k);
        PointF localPointF3 = (PointF)((List)localObject2).get(k);
        PointF localPointF4 = (PointF)((List)localObject1).get(i);
        ((List)localObject4).add(new CubicCurveData(MiscUtils.addPoints(localPointF2, localPointF3), MiscUtils.addPoints(localPointF1, localPointF4), localPointF1));
        i += 1;
      }
      if (bool)
      {
        localPointF1 = (PointF)((List)localObject3).get(0);
        i = j - 1;
        localObject3 = (PointF)((List)localObject3).get(i);
        localObject2 = (PointF)((List)localObject2).get(i);
        localObject1 = (PointF)((List)localObject1).get(0);
        ((List)localObject4).add(new CubicCurveData(MiscUtils.addPoints((PointF)localObject3, (PointF)localObject2), MiscUtils.addPoints(localPointF1, (PointF)localObject1), localPointF1));
      }
      return new ShapeData(paramJsonReader, bool, (List)localObject4);
    }
    paramJsonReader = new IllegalArgumentException("Shape data was missing information.");
    for (;;)
    {
      throw paramJsonReader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeDataParser
 * JD-Core Version:    0.7.0.1
 */