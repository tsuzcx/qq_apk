package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemContent
  extends AbsStructMsgTextElement
{
  public int aM = 0;
  public boolean aN = false;
  public int aO = 3;
  
  public StructMsgItemContent()
  {
    this(null);
  }
  
  public StructMsgItemContent(String paramString)
  {
    super(paramString, "content");
  }
  
  public String b()
  {
    return "Content";
  }
  
  public int d()
  {
    return this.aO;
  }
  
  public int f()
  {
    return 2131448353;
  }
  
  public int i()
  {
    if ((this.aN) && (this.aM != 0)) {
      return -1;
    }
    return -8355712;
  }
  
  public int j()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemContent
 * JD-Core Version:    0.7.0.1
 */