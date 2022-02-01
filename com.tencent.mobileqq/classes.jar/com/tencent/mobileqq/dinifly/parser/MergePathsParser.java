package com.tencent.mobileqq.dinifly.parser;

import com.tencent.mobileqq.dinifly.model.content.MergePaths;
import com.tencent.mobileqq.dinifly.model.content.MergePaths.MergePathsMode;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader.Options;

class MergePathsParser
{
  private static final JsonReader.Options NAMES = JsonReader.Options.of(new String[] { "nm", "mm", "hd" });
  
  static MergePaths parse(JsonReader paramJsonReader)
  {
    String str = null;
    MergePaths.MergePathsMode localMergePathsMode = null;
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
            paramJsonReader.skipName();
            paramJsonReader.skipValue();
          }
          else
          {
            bool = paramJsonReader.nextBoolean();
          }
        }
        else {
          localMergePathsMode = MergePaths.MergePathsMode.forId(paramJsonReader.nextInt());
        }
      }
      else {
        str = paramJsonReader.nextString();
      }
    }
    return new MergePaths(str, localMergePathsMode, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.MergePathsParser
 * JD-Core Version:    0.7.0.1
 */