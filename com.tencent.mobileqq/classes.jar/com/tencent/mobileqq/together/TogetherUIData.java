package com.tencent.mobileqq.together;

import bapt;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.Serializable;

public class TogetherUIData
  implements Serializable
{
  private bapt mTogetherSession;
  
  public String getCurUin()
  {
    return this.mTogetherSession.jdField_e_of_type_JavaLangString;
  }
  
  public int getSessionType()
  {
    return this.mTogetherSession.jdField_e_of_type_Int;
  }
  
  public String getSubTitleText(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    return this.mTogetherSession.a(paramBoolean, paramQQAppInterface);
  }
  
  public bapt getTogetherSession()
  {
    return this.mTogetherSession;
  }
  
  public void reset()
  {
    this.mTogetherSession = null;
  }
  
  public void setTogetherSession(bapt parambapt)
  {
    this.mTogetherSession = parambapt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherUIData
 * JD-Core Version:    0.7.0.1
 */