package com.tencent.mobileqq.data;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class MessageForTroopFee$TroopFeeParserHandler
  extends DefaultHandler
{
  MessageForTroopFee a = new MessageForTroopFee();
  public String b = "";
  
  public MessageForTroopFee a()
  {
    return this.a;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    if (this.b.equals("title"))
    {
      this.a.title = paramArrayOfChar;
      return;
    }
    if (this.b.equals("summary")) {
      this.a.summary = paramArrayOfChar;
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (paramString3.equals("msg"))
    {
      this.a.actionUrl = paramAttributes.getValue("url");
      this.a.brief = paramAttributes.getValue("brief");
      return;
    }
    if (paramString3.equals("title"))
    {
      this.b = "title";
      return;
    }
    if (paramString3.equals("summary"))
    {
      this.b = "summary";
      return;
    }
    if (paramString3.equals("source")) {
      this.a.source = paramAttributes.getValue("name");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForTroopFee.TroopFeeParserHandler
 * JD-Core Version:    0.7.0.1
 */