package com.tencent.mobileqq.together;

import bddf;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.Serializable;

public class TogetherUIData
  implements Serializable
{
  private bddf mTogetherSession;
  
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
  
  public bddf getTogetherSession()
  {
    return this.mTogetherSession;
  }
  
  public void reset()
  {
    this.mTogetherSession = null;
  }
  
  public void setTogetherSession(bddf parambddf)
  {
    this.mTogetherSession = parambddf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherUIData
 * JD-Core Version:    0.7.0.1
 */