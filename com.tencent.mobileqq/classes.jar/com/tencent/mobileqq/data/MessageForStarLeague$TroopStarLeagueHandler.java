package com.tencent.mobileqq.data;

import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class MessageForStarLeague$TroopStarLeagueHandler
  extends DefaultHandler
{
  MessageForStarLeague a = (MessageForStarLeague)MessageRecordFactory.a(-2069);
  public String b = "";
  
  public MessageForStarLeague a()
  {
    return this.a;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    if (paramArrayOfChar.equals("\n")) {
      return;
    }
    MessageForStarLeague localMessageForStarLeague;
    if (this.b.equals("title"))
    {
      localMessageForStarLeague = this.a;
      if (localMessageForStarLeague.starName != null) {
        paramArrayOfChar = this.a.starName.concat(paramArrayOfChar);
      }
      localMessageForStarLeague.starName = paramArrayOfChar;
      this.a.starName.trim();
      return;
    }
    if (this.b.equals("summary"))
    {
      localMessageForStarLeague = this.a;
      if (localMessageForStarLeague.subTitle != null) {
        paramArrayOfChar = this.a.subTitle.concat(paramArrayOfChar);
      }
      localMessageForStarLeague.subTitle = paramArrayOfChar;
      this.a.subTitle.trim();
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (paramString3.equals("msg"))
    {
      this.a.actionUrl = paramAttributes.getValue("url");
      try
      {
        this.a.levelStatus = Integer.parseInt(paramAttributes.getValue("levelStatus"));
      }
      catch (Exception paramString1)
      {
        QLog.e("StructMsg", 1, "levelStatus parse failed!", paramString1);
      }
      this.a.brief = paramAttributes.getValue("brief");
      return;
    }
    if (paramString3.equals("picture"))
    {
      this.a.starAvatar = paramAttributes.getValue("cover");
      return;
    }
    if (paramString3.equals("title"))
    {
      this.b = "title";
      return;
    }
    if (paramString3.equals("summary")) {
      this.b = "summary";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForStarLeague.TroopStarLeagueHandler
 * JD-Core Version:    0.7.0.1
 */