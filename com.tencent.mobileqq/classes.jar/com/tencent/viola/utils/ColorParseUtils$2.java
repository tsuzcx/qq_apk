package com.tencent.viola.utils;

import java.util.ArrayList;
import java.util.List;

class ColorParseUtils$2
  implements SingleFunctionParser.NonUniformMapper<Number>
{
  public List<Number> map(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(4);
    int j = 0;
    while (j < 3)
    {
      int k = ViolaUtils.parseUnitOrPercent((String)paramList.get(j), 255);
      int i;
      if (k < 0)
      {
        i = 0;
      }
      else
      {
        i = k;
        if (k > 255) {
          i = 255;
        }
      }
      localArrayList.add(Integer.valueOf(i));
      j += 1;
    }
    localArrayList.add(Float.valueOf((String)paramList.get(j)));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.utils.ColorParseUtils.2
 * JD-Core Version:    0.7.0.1
 */