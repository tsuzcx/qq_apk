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
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginObject();
    String str2 = null;
    String str1 = str2;
    double d2 = 0.0D;
    double d1 = d2;
    char c = '\000';
    while (paramJsonReader.hasNext())
    {
      String str3 = paramJsonReader.nextName();
      switch (str3.hashCode())
      {
      default: 
        break;
      case 109780401: 
        if (str3.equals("style")) {
          i = 3;
        }
        break;
      case 3530753: 
        if (str3.equals("size")) {
          i = 1;
        }
        break;
      case 3076010: 
        if (str3.equals("data")) {
          i = 5;
        }
        break;
      case 3173: 
        if (str3.equals("ch")) {
          i = 0;
        }
        break;
      case 119: 
        if (str3.equals("w")) {
          i = 2;
        }
        break;
      case -1866931350: 
        if (str3.equals("fFamily")) {
          i = 4;
        }
        break;
      }
      int i = -1;
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
                  paramJsonReader.skipValue();
                }
                else
                {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.FontCharacterParser
 * JD-Core Version:    0.7.0.1
 */