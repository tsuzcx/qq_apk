package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemSummary
  extends AbsStructMsgTextElement
{
  public boolean c;
  public int e;
  public int f = 3;
  
  public StructMsgItemSummary()
  {
    this(null);
  }
  
  public StructMsgItemSummary(String paramString)
  {
    super(paramString, "summary");
  }
  
  public String a()
  {
    return "Summary";
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    paramAbsShareMsg.mContentSummary = this.A;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.c = paramBoolean;
    this.e = paramInt;
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
    return 2131361927;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemSummary
 * JD-Core Version:    0.7.0.1
 */