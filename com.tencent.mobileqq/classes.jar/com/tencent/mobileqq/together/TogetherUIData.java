package com.tencent.mobileqq.together;

import com.tencent.mobileqq.app.QQAppInterface;
import java.io.Serializable;

public class TogetherUIData
  implements Serializable
{
  private TogetherSession mTogetherSession;
  
  public String getCurUin()
  {
    return this.mTogetherSession.n;
  }
  
  public int getSessionType()
  {
    return this.mTogetherSession.m;
  }
  
  public String getSubTitleText(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    return this.mTogetherSession.a(paramBoolean, paramQQAppInterface);
  }
  
  public TogetherSession getTogetherSession()
  {
    return this.mTogetherSession;
  }
  
  public void reset()
  {
    this.mTogetherSession = null;
  }
  
  public void setTogetherSession(TogetherSession paramTogetherSession)
  {
    this.mTogetherSession = paramTogetherSession;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherUIData
 * JD-Core Version:    0.7.0.1
 */