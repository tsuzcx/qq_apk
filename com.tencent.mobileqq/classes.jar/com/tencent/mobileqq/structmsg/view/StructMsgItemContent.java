package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemContent
  extends AbsStructMsgTextElement
{
  public boolean c = false;
  public int o = 0;
  public int p = 3;
  
  public StructMsgItemContent()
  {
    this(null);
  }
  
  public StructMsgItemContent(String paramString)
  {
    super(paramString, "content");
  }
  
  public String a()
  {
    return "Content";
  }
  
  public int b()
  {
    return this.p;
  }
  
  public int c()
  {
    return 2131380283;
  }
  
  public int e()
  {
    if ((this.c) && (this.o != 0)) {
      return -1;
    }
    return -8355712;
  }
  
  public int f()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemContent
 * JD-Core Version:    0.7.0.1
 */