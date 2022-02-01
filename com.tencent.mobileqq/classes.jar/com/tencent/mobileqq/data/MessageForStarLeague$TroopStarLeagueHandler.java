package com.tencent.mobileqq.data;

import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class MessageForStarLeague$TroopStarLeagueHandler
  extends DefaultHandler
{
  MessageForStarLeague a;
  public String a;
  
  MessageForStarLeague$TroopStarLeagueHandler()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague = ((MessageForStarLeague)MessageRecordFactory.a(-2069));
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public MessageForStarLeague a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    if (paramArrayOfChar.equals("\n")) {
      return;
    }
    MessageForStarLeague localMessageForStarLeague;
    if (this.jdField_a_of_type_JavaLangString.equals("title"))
    {
      localMessageForStarLeague = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague;
      if (localMessageForStarLeague.starName != null) {
        paramArrayOfChar = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.starName.concat(paramArrayOfChar);
      }
      localMessageForStarLeague.starName = paramArrayOfChar;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.starName.trim();
      return;
    }
    if (this.jdField_a_of_type_JavaLangString.equals("summary"))
    {
      localMessageForStarLeague = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague;
      if (localMessageForStarLeague.subTitle != null) {
        paramArrayOfChar = this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.subTitle.concat(paramArrayOfChar);
      }
      localMessageForStarLeague.subTitle = paramArrayOfChar;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.subTitle.trim();
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (paramString3.equals("msg"))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.actionUrl = paramAttributes.getValue("url");
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.levelStatus = Integer.parseInt(paramAttributes.getValue("levelStatus"));
      }
      catch (Exception paramString1)
      {
        QLog.e("StructMsg", 1, "levelStatus parse failed!", paramString1);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.brief = paramAttributes.getValue("brief");
      return;
    }
    if (paramString3.equals("picture"))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStarLeague.starAvatar = paramAttributes.getValue("cover");
      return;
    }
    if (paramString3.equals("title"))
    {
      this.jdField_a_of_type_JavaLangString = "title";
      return;
    }
    if (paramString3.equals("summary")) {
      this.jdField_a_of_type_JavaLangString = "summary";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForStarLeague.TroopStarLeagueHandler
 * JD-Core Version:    0.7.0.1
 */