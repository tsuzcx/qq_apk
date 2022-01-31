package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import java.util.ArrayList;
import java.util.List;

class ShapeGroupParser
{
  static ShapeGroup parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    String str = null;
    ArrayList localArrayList = new ArrayList();
    boolean bool = false;
    label14:
    while (paramJsonReader.hasNext())
    {
      Object localObject = paramJsonReader.nextName();
      int i = -1;
      switch (((String)localObject).hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label14;
          if (((String)localObject).equals("nm"))
          {
            i = 0;
            continue;
            if (((String)localObject).equals("hd"))
            {
              i = 1;
              continue;
              if (((String)localObject).equals("it")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      str = paramJsonReader.nextString();
      continue;
      bool = paramJsonReader.nextBoolean();
      continue;
      paramJsonReader.beginArray();
      while (paramJsonReader.hasNext())
      {
        localObject = ContentModelParser.parse(paramJsonReader, paramLottieComposition);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      paramJsonReader.endArray();
    }
    return new ShapeGroup(str, localArrayList, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeGroupParser
 * JD-Core Version:    0.7.0.1
 */