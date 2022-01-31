package com.tencent.mobileqq.structmsg.view;

import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemTitle
  extends AbsStructMsgTextElement
{
  public boolean c;
  public boolean d;
  public int e;
  
  public StructMsgItemTitle()
  {
    this(null);
  }
  
  public StructMsgItemTitle(String paramString)
  {
    super(paramString, "title");
  }
  
  protected Class a()
  {
    if (this.d) {
      return StructMsgItemTitle.TitleTextView.class;
    }
    return super.a();
  }
  
  public String a()
  {
    return "Title";
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    paramAbsShareMsg.mContentTitle = this.A;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.c = paramBoolean;
    this.e = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  protected int c()
  {
    return 2131361926;
  }
  
  public int d()
  {
    if ((this.c) && (this.e != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int e()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTitle
 * JD-Core Version:    0.7.0.1
 */