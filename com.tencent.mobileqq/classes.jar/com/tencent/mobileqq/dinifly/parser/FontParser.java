package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.model.Font;

class FontParser
{
  static Font parse(JsonReader paramJsonReader)
  {
    String str3 = null;
    float f = 0.0F;
    paramJsonReader.beginObject();
    String str2 = null;
    String str1 = null;
    label14:
    while (paramJsonReader.hasNext())
    {
      String str4 = paramJsonReader.nextName();
      int i = -1;
      switch (str4.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramJsonReader.skipValue();
          break label14;
          if (str4.equals("fFamily"))
          {
            i = 0;
            continue;
            if (str4.equals("fName"))
            {
              i = 1;
              continue;
              if (str4.equals("fStyle"))
              {
                i = 2;
                continue;
                if (str4.equals("ascent")) {
                  i = 3;
                }
              }
            }
          }
          break;
        }
      }
      str1 = paramJsonReader.nextString();
      continue;
      str2 = paramJsonReader.nextString();
      continue;
      str3 = paramJsonReader.nextString();
      continue;
      f = (float)paramJsonReader.nextDouble();
    }
    paramJsonReader.endObject();
    return new Font(str1, str2, str3, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.FontParser
 * JD-Core Version:    0.7.0.1
 */