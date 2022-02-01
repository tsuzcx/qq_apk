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
    Object localObject1 = null;
    if (paramJsonReader.peek() == JsonToken.BEGIN_ARRAY) {
      paramJsonReader.beginArray();
    }
    paramJsonReader.beginObject();
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool = false;
    if (paramJsonReader.hasNext())
    {
      localObject4 = paramJsonReader.nextName();
      i = -1;
      switch (((String)localObject4).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          label92:
          localObject4 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject4;
        }
        break;
      }
      for (;;)
      {
        localObject4 = localObject3;
        localObject3 = localObject2;
        localObject2 = localObject4;
        break;
        if (!((String)localObject4).equals("c")) {
          break label92;
        }
        i = 0;
        break label92;
        if (!((String)localObject4).equals("v")) {
          break label92;
        }
        i = 1;
        break label92;
        if (!((String)localObject4).equals("i")) {
          break label92;
        }
        i = 2;
        break label92;
        if (!((String)localObject4).equals("o")) {
          break label92;
        }
        i = 3;
        break label92;
        bool = paramJsonReader.nextBoolean();
        localObject4 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        continue;
        localObject4 = JsonUtils.jsonToPoints(paramJsonReader, paramFloat);
        localObject2 = localObject3;
        localObject3 = localObject4;
        continue;
        localObject4 = JsonUtils.jsonToPoints(paramJsonReader, paramFloat);
        localObject3 = localObject2;
        localObject2 = localObject4;
        continue;
        localObject1 = JsonUtils.jsonToPoints(paramJsonReader, paramFloat);
        localObject4 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
      }
    }
    paramJsonReader.endObject();
    if (paramJsonReader.peek() == JsonToken.END_ARRAY) {
      paramJsonReader.endArray();
    }
    if ((localObject2 == null) || (localObject3 == null) || (localObject1 == null)) {
      throw new IllegalArgumentException("Shape data was missing information.");
    }
    if (((List)localObject2).isEmpty()) {
      return new ShapeData(new PointF(), false, Collections.emptyList());
    }
    int j = ((List)localObject2).size();
    paramJsonReader = (PointF)((List)localObject2).get(0);
    Object localObject4 = new ArrayList(j);
    int i = 1;
    PointF localPointF1;
    while (i < j)
    {
      localPointF1 = (PointF)((List)localObject2).get(i);
      PointF localPointF2 = (PointF)((List)localObject2).get(i - 1);
      PointF localPointF3 = (PointF)((List)localObject1).get(i - 1);
      PointF localPointF4 = (PointF)((List)localObject3).get(i);
      ((List)localObject4).add(new CubicCurveData(MiscUtils.addPoints(localPointF2, localPointF3), MiscUtils.addPoints(localPointF1, localPointF4), localPointF1));
      i += 1;
    }
    if (bool)
    {
      localPointF1 = (PointF)((List)localObject2).get(0);
      localObject2 = (PointF)((List)localObject2).get(j - 1);
      localObject1 = (PointF)((List)localObject1).get(j - 1);
      localObject3 = (PointF)((List)localObject3).get(0);
      ((List)localObject4).add(new CubicCurveData(MiscUtils.addPoints((PointF)localObject2, (PointF)localObject1), MiscUtils.addPoints(localPointF1, (PointF)localObject3), localPointF1));
    }
    return new ShapeData(paramJsonReader, bool, (List)localObject4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeDataParser
 * JD-Core Version:    0.7.0.1
 */