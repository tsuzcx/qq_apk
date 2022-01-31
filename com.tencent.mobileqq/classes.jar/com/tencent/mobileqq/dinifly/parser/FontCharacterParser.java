package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.FontCharacter;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import java.util.ArrayList;
import java.util.List;

class FontCharacterParser
{
  static FontCharacter parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    String str1 = null;
    double d1 = 0.0D;
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginObject();
    String str2 = null;
    double d2 = 0.0D;
    char c = '\000';
    label26:
    while (paramJsonReader.hasNext())
    {
      String str3 = paramJsonReader.nextName();
      int i = -1;
      switch (str3.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label26;
          if (str3.equals("ch"))
          {
            i = 0;
            continue;
            if (str3.equals("size"))
            {
              i = 1;
              continue;
              if (str3.equals("w"))
              {
                i = 2;
                continue;
                if (str3.equals("style"))
                {
                  i = 3;
                  continue;
                  if (str3.equals("fFamily"))
                  {
                    i = 4;
                    continue;
                    if (str3.equals("data")) {
                      i = 5;
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      c = paramJsonReader.nextString().charAt(0);
      continue;
      d2 = paramJsonReader.nextDouble();
      continue;
      d1 = paramJsonReader.nextDouble();
      continue;
      str2 = paramJsonReader.nextString();
      continue;
      str1 = paramJsonReader.nextString();
      continue;
      paramJsonReader.beginObject();
      while (paramJsonReader.hasNext()) {
        if ("shapes".equals(paramJsonReader.nextName()))
        {
          paramJsonReader.beginArray();
          while (paramJsonReader.hasNext()) {
            localArrayList.add((ShapeGroup)ContentModelParser.parse(paramJsonReader, paramLottieComposition));
          }
          paramJsonReader.endArray();
        }
        else
        {
          paramJsonReader.skipValue();
        }
      }
      paramJsonReader.endObject();
    }
    paramJsonReader.endObject();
    return new FontCharacter(localArrayList, c, d2, d1, str2, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.FontCharacterParser
 * JD-Core Version:    0.7.0.1
 */