package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.model.content.ContentModel;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;
import java.util.ArrayList;
import java.util.List;

class ShapeGroupParser
{
  private static JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "hd", "it" });
  
  static ShapeGroup parse(JsonReader paramJsonReader, LottieComposition paramLottieComposition)
  {
    ArrayList localArrayList = new ArrayList();
    String str = null;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      int i = paramJsonReader.selectName(NAMES);
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
              ContentModel localContentModel = ContentModelParser.parse(paramJsonReader, paramLottieComposition);
              if (localContentModel != null) {
                localArrayList.add(localContentModel);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.ShapeGroupParser
 * JD-Core Version:    0.7.0.1
 */