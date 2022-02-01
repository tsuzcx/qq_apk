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
    ArrayList localArrayList = new ArrayList();
    String str = null;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      Object localObject = paramJsonReader.nextName();
      int i = -1;
      int j = ((String)localObject).hashCode();
      if (j != 3324)
      {
        if (j != 3371)
        {
          if ((j == 3519) && (((String)localObject).equals("nm"))) {
            i = 0;
          }
        }
        else if (((String)localObject).equals("it")) {
          i = 2;
        }
      }
      else if (((String)localObject).equals("hd")) {
        i = 1;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            paramJsonReader.skipValue();
          }
          else
          {
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
        }
        else {
          bool = paramJsonReader.nextBoolean();
        }
      }
      else {
        str = paramJsonReader.nextString();
      }
    }
    return new ShapeGroup(str, localArrayList, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeGroupParser
 * JD-Core Version:    0.7.0.1
 */