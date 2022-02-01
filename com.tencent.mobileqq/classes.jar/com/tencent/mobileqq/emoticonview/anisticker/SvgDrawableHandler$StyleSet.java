package com.tencent.mobileqq.emoticonview.anisticker;

import java.util.HashMap;

class SvgDrawableHandler$StyleSet
{
  HashMap<String, String> styleMap = new HashMap();
  
  private SvgDrawableHandler$StyleSet(StyleSet paramStyleSet)
  {
    this.styleMap.putAll(paramStyleSet.styleMap);
  }
  
  private SvgDrawableHandler$StyleSet(String paramString)
  {
    paramString = paramString.split(";");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split(":");
      if (arrayOfString.length == 2) {
        this.styleMap.put(arrayOfString[0].trim(), arrayOfString[1].trim());
      }
      i += 1;
    }
  }
  
  public String getStyle(String paramString)
  {
    return (String)this.styleMap.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.SvgDrawableHandler.StyleSet
 * JD-Core Version:    0.7.0.1
 */