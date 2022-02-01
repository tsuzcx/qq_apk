package com.tencent.viola.utils;

class ColorParseUtils$1
  implements SingleFunctionParser.FlatMapper<Integer>
{
  public Integer map(String paramString)
  {
    int i = 255;
    int j = ViolaUtils.parseUnitOrPercent(paramString, 255);
    if (j < 0) {
      i = 0;
    } else if (j <= 255) {
      i = j;
    }
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.utils.ColorParseUtils.1
 * JD-Core Version:    0.7.0.1
 */