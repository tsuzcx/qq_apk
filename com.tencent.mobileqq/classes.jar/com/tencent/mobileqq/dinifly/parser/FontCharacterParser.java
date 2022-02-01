package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.FontCharacter;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import java.util.ArrayList;
import java.util.List;

class FontCharacterParser
{
  private static final JsonReader.Options DATA_NAMES = JsonReader.Options.of(new String[] { "shapes" });
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "ch", "size", "w", "style", "fFamily", "data" });
  
  static FontCharacter parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginObject();
    String str2 = null;
    String str1 = str2;
    double d2 = 0.0D;
    double d1 = d2;
    char c = '\000';
    while (paramJsonReader.hasNext())
    {
      int i = paramJsonReader.selectName(NAMES);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i != 5)
                {
                  paramJsonReader.skipName();
                  paramJsonReader.skipValue();
                }
                else
                {
                  paramJsonReader.beginObject();
                  while (paramJsonReader.hasNext()) {
                    if (paramJsonReader.selectName(DATA_NAMES) != 0)
                    {
                      paramJsonReader.skipName();
                      paramJsonReader.skipValue();
                    }
                    else
                    {
                      paramJsonReader.beginArray();
                      while (paramJsonReader.hasNext()) {
                        localArrayList.add((ShapeGroup)ContentModelParser.parse(paramJsonReader, paramLottieComposition));
                      }
                      paramJsonReader.endArray();
                    }
                  }
                  paramJsonReader.endObject();
                }
              }
              else {
                str1 = paramJsonReader.nextString();
              }
            }
            else {
              str2 = paramJsonReader.nextString();
            }
          }
          else {
            d1 = paramJsonReader.nextDouble();
          }
        }
        else {
          d2 = paramJsonReader.nextDouble();
        }
      }
      else {
        c = paramJsonReader.nextString().charAt(0);
      }
    }
    paramJsonReader.endObject();
    return new FontCharacter(localArrayList, c, d2, d1, str2, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.FontCharacterParser
 * JD-Core Version:    0.7.0.1
 */