package com.tencent.mobileqq.friend.status;

import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.helpers.DefaultHandler;

class OnlineStatusIconHelper$ConfigParser
  extends DefaultHandler
{
  OnlineStatusIconHelper$ConfigParser(OnlineStatusIconHelper paramOnlineStatusIconHelper) {}
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2) {}
  
  public void endDocument() {}
  
  public void endElement(String paramString1, String paramString2, String paramString3) {}
  
  public void endPrefixMapping(String paramString) {}
  
  public void ignorableWhitespace(char[] paramArrayOfChar, int paramInt1, int paramInt2) {}
  
  public void processingInstruction(String paramString1, String paramString2) {}
  
  public void setDocumentLocator(Locator paramLocator) {}
  
  public void skippedEntity(String paramString) {}
  
  public void startDocument() {}
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (paramString3.equals("config"))
    {
      this.a.a.clear();
      return;
    }
    int i;
    if (paramString3.equals("value")) {
      i = Integer.parseInt(paramAttributes.getValue("termType"));
    }
    try
    {
      int j = Integer.parseInt(paramAttributes.getValue("icon"));
      this.a.a.put(Integer.valueOf(i), Integer.valueOf(j));
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void startPrefixMapping(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.status.OnlineStatusIconHelper.ConfigParser
 * JD-Core Version:    0.7.0.1
 */