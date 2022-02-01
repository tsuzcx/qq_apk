package com.tencent.mobileqq.dinifly.parser;

import android.graphics.PointF;
import com.tencent.mobileqq.dinifly.model.CubicCurveData;
import com.tencent.mobileqq.dinifly.model.content.ShapeData;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Token;
import com.tencent.mobileqq.dinifly.utils.MiscUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeDataParser
  implements ValueParser<ShapeData>
{
  public static final ShapeDataParser INSTANCE = new ShapeDataParser();
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "c", "v", "i", "o" });
  
  public ShapeData parse(JsonReader paramJsonReader, float paramFloat)
  {
    if (paramJsonReader.peek() == JsonReader.Token.BEGIN_ARRAY) {
      paramJsonReader.beginArray();
    }
    paramJsonReader.beginObject();
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    boolean bool = false;
    int i;
    while (paramJsonReader.hasNext())
    {
      i = paramJsonReader.selectName(NAMES);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              paramJsonReader.skipName();
              paramJsonReader.skipValue();
            }
            else
            {
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
    if (paramJsonReader.peek() == JsonReader.Token.END_ARRAY) {
      paramJsonReader.endArray();
    }
    if ((localObject3 != null) && (localObject1 != null) && (localObject2 != null))
    {
      if (((List)localObject3).isEmpty()) {
        return new ShapeData(new PointF(), false, Collections.emptyList());
      }
      int j = ((List)localObject3).size();
      paramJsonReader = (PointF)((List)localObject3).get(0);
      ArrayList localArrayList = new ArrayList(j);
      i = 1;
      PointF localPointF1;
      while (i < j)
      {
        localPointF1 = (PointF)((List)localObject3).get(i);
        int k = i - 1;
        PointF localPointF2 = (PointF)((List)localObject3).get(k);
        PointF localPointF3 = (PointF)((List)localObject2).get(k);
        PointF localPointF4 = (PointF)((List)localObject1).get(i);
        localArrayList.add(new CubicCurveData(MiscUtils.addPoints(localPointF2, localPointF3), MiscUtils.addPoints(localPointF1, localPointF4), localPointF1));
        i += 1;
      }
      if (bool)
      {
        localPointF1 = (PointF)((List)localObject3).get(0);
        i = j - 1;
        localObject3 = (PointF)((List)localObject3).get(i);
        localObject2 = (PointF)((List)localObject2).get(i);
        localObject1 = (PointF)((List)localObject1).get(0);
        localArrayList.add(new CubicCurveData(MiscUtils.addPoints((PointF)localObject3, (PointF)localObject2), MiscUtils.addPoints(localPointF1, (PointF)localObject1), localPointF1));
      }
      return new ShapeData(paramJsonReader, bool, localArrayList);
    }
    paramJsonReader = new IllegalArgumentException("Shape data was missing information.");
    for (;;)
    {
      throw paramJsonReader;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeDataParser
 * JD-Core Version:    0.7.0.1
 */