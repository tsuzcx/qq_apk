package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemContent
  extends AbsStructMsgTextElement
{
  public boolean c;
  public int e;
  public int f = 3;
  
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
    return this.f;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  public int c()
  {
    return 2131361932;
  }
  
  public int d()
  {
    if ((this.c) && (this.e != 0)) {
      return -1;
    }
    return -8355712;
  }
  
  public int e()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemContent
 * JD-Core Version:    0.7.0.1
 */