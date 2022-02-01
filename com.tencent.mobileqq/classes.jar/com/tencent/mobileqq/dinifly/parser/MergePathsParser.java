package com.tencent.mobileqq.dinifly.parser;

import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.model.content.MergePaths;
import com.tencent.mobileqq.dinifly.model.content.MergePaths.MergePathsMode;

class MergePathsParser
{
  static MergePaths parse(JsonReader paramJsonReader)
  {
    String str1 = null;
    MergePaths.MergePathsMode localMergePathsMode = null;
    boolean bool = false;
    while (paramJsonReader.hasNext())
    {
      String str2 = paramJsonReader.nextName();
      int i = -1;
      int j = str2.hashCode();
      if (j != 3324)
      {
        if (j != 3488)
        {
          if ((j == 3519) && (str2.equals("nm"))) {
            i = 0;
          }
        }
        else if (str2.equals("mm")) {
          i = 1;
        }
      }
      else if (str2.equals("hd")) {
        i = 2;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            paramJsonReader.skipValue();
          } else {
            bool = paramJsonReader.nextBoolean();
          }
        }
        else {
          localMergePathsMode = MergePaths.MergePathsMode.forId(paramJsonReader.nextInt());
        }
      }
      else {
        str1 = paramJsonReader.nextString();
      }
    }
    return new MergePaths(str1, localMergePathsMode, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.parser.MergePathsParser
 * JD-Core Version:    0.7.0.1
 */