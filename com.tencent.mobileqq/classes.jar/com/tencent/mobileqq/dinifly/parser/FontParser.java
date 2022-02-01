package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.model.Font;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;

class FontParser
{
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "fFamily", "fName", "fStyle", "ascent" });
  
  static Font parse(JsonReader paramJsonReader)
  {
    paramJsonReader.beginObject();
    String str3 = null;
    String str2 = null;
    String str1 = str2;
    float f = 0.0F;
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
              paramJsonReader.skipName();
              paramJsonReader.skipValue();
            }
            else
            {
              f = (float)paramJsonReader.nextDouble();
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
        str3 = paramJsonReader.nextString();
      }
    }
    paramJsonReader.endObject();
    return new Font(str3, str2, str1, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.FontParser
 * JD-Core Version:    0.7.0.1
 */