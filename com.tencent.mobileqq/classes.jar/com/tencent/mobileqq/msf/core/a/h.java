package com.tencent.mobileqq.msf.core.a;

import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class h
  extends DefaultHandler
{
  Map a;
  String b;
  private String c = null;
  
  public h(String paramString, Map paramMap)
  {
    this.b = paramString;
    this.a = paramMap;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (this.c != null)
    {
      paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
      Map localMap = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(this.c);
      localMap.put(localStringBuilder.toString(), paramArrayOfChar);
    }
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.c = null;
  }
  
  public void startDocument() {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    this.c = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.a.h
 * JD-Core Version:    0.7.0.1
 */