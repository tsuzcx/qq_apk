package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.model.Font;

class FontParser
{
  static Font parse(JsonReader paramJsonReader)
  {
    paramJsonReader.beginObject();
    String str3 = null;
    String str2 = null;
    String str1 = str2;
    float f = 0.0F;
    while (paramJsonReader.hasNext())
    {
      String str4 = paramJsonReader.nextName();
      int i = -1;
      switch (str4.hashCode())
      {
      default: 
        break;
      case 96619537: 
        if (str4.equals("fName")) {
          i = 1;
        }
        break;
      case -1294566165: 
        if (str4.equals("fStyle")) {
          i = 2;
        }
        break;
      case -1408684838: 
        if (str4.equals("ascent")) {
          i = 3;
        }
        break;
      case -1866931350: 
        if (str4.equals("fFamily")) {
          i = 0;
        }
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              paramJsonReader.skipValue();
            } else {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.FontParser
 * JD-Core Version:    0.7.0.1
 */