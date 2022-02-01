package com.tencent.mobileqq.emoticonview.anisticker;

import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.Attributes;

class SvgDrawableHandler$Properties
{
  Attributes atts;
  ArrayList<SvgDrawableHandler.StyleSet> styles;
  
  private SvgDrawableHandler$Properties(Attributes paramAttributes, HashMap<String, SvgDrawableHandler.StyleSet> paramHashMap)
  {
    this.atts = paramAttributes;
    Object localObject = SvgDrawableHandler.access$300("style", paramAttributes);
    if (localObject != null)
    {
      this.styles = new ArrayList();
      this.styles.add(new SvgDrawableHandler.StyleSet((String)localObject, null));
      return;
    }
    paramAttributes = SvgDrawableHandler.access$300("class", paramAttributes);
    if (paramAttributes != null)
    {
      this.styles = new ArrayList();
      paramAttributes = paramAttributes.split(" ");
      int i = 0;
      while (i < paramAttributes.length)
      {
        localObject = (SvgDrawableHandler.StyleSet)paramHashMap.get(paramAttributes[i].trim());
        if (localObject != null) {
          this.styles.add(localObject);
        }
        i += 1;
      }
    }
  }
  
  public String getAttr(String paramString)
  {
    ArrayList localArrayList = this.styles;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (localArrayList != null)
    {
      localObject1 = localObject3;
      if (!localArrayList.isEmpty())
      {
        int i = 0;
        int j = this.styles.size();
        localObject1 = localObject2;
        while (i < j)
        {
          localObject1 = ((SvgDrawableHandler.StyleSet)this.styles.get(i)).getStyle(paramString);
          if (localObject1 != null) {
            break;
          }
          i += 1;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = SvgDrawableHandler.access$300(paramString, this.atts);
    }
    return localObject2;
  }
  
  public Float getFloat(String paramString)
  {
    paramString = getAttr(paramString);
    if (paramString == null) {
      return null;
    }
    try
    {
      float f = Float.parseFloat(paramString);
      return Float.valueOf(f);
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  public Float getFloat(String paramString, float paramFloat)
  {
    Float localFloat = getFloat(paramString);
    paramString = localFloat;
    if (localFloat == null) {
      paramString = Float.valueOf(paramFloat);
    }
    return paramString;
  }
  
  public Integer getHex(String paramString)
  {
    paramString = getAttr(paramString);
    if (paramString == null) {
      return null;
    }
    try
    {
      int i = Integer.parseInt(paramString.substring(1), 16);
      return Integer.valueOf(i);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label28:
      break label28;
    }
    return SvgDrawableHandler.access$400(paramString);
  }
  
  public String getString(String paramString)
  {
    return getAttr(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.SvgDrawableHandler.Properties
 * JD-Core Version:    0.7.0.1
 */