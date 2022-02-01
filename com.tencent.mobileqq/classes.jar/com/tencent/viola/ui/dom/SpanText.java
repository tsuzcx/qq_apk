package com.tencent.viola.ui.dom;

import java.util.ArrayList;

public class SpanText
  implements Cloneable
{
  public static final String SPANTYPE_IMG = "image";
  public static final String SPANTYPE_TEXT = "text";
  public static final String SPAN_VAULE_SRC = "src";
  public static final String SPAN_VAULE_TEXT = "text";
  public ArrayList<String> events = new ArrayList();
  public int index;
  public String parentRef;
  public String resize;
  public String spanType;
  public String src;
  public Style style = new Style();
  public CharSequence text;
  
  SpanText(String paramString, int paramInt)
  {
    this.parentRef = paramString;
    this.index = paramInt;
  }
  
  public void destroy() {}
  
  public int getHeight()
  {
    return 0;
  }
  
  public int getWidth()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SpanText:[");
    localStringBuilder.append("\n |-");
    localStringBuilder.append("spanType :");
    localStringBuilder.append(this.spanType);
    if ("image".equals(this.spanType))
    {
      localStringBuilder.append("\n |-");
      localStringBuilder.append("src :");
      localStringBuilder.append(this.src);
    }
    else if ("text".equals(this.spanType))
    {
      localStringBuilder.append("\n |-");
      localStringBuilder.append("text :");
      localStringBuilder.append(this.text);
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.SpanText
 * JD-Core Version:    0.7.0.1
 */