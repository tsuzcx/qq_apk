package com.tencent.mobileqq.together;

import axnf;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.Serializable;

public class TogetherUIData
  implements Serializable
{
  private axnf mTogetherSession;
  
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
  
  public axnf getTogetherSession()
  {
    return this.mTogetherSession;
  }
  
  public void reset()
  {
    this.mTogetherSession = null;
  }
  
  public void setTogetherSession(axnf paramaxnf)
  {
    this.mTogetherSession = paramaxnf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherUIData
 * JD-Core Version:    0.7.0.1
 */