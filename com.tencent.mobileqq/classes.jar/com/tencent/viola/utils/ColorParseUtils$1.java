package com.tencent.viola.utils;

final class ColorParseUtils$1
  implements SingleFunctionParser.FlatMapper<Integer>
{
  public Integer map(String paramString)
  {
    int i = 255;
    int j = ViolaUtils.parseUnitOrPercent(paramString, 255);
    if (j < 0) {
      i = 0;
    }
    for (;;)
    {
      return Integer.valueOf(i);
      if (j <= 255) {
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.utils.ColorParseUtils.1
 * JD-Core Version:    0.7.0.1
 */