package com.tencent.mobileqq.structmsg.view;

import android.widget.TextView;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;

public class StructMsgItemTitle
  extends AbsStructMsgTextElement
{
  public boolean c = false;
  public boolean d = false;
  public int o = 0;
  
  public StructMsgItemTitle()
  {
    this(null);
  }
  
  public StructMsgItemTitle(String paramString)
  {
    super(paramString, "title");
  }
  
  protected Class<? extends TextView> a()
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
    paramAbsShareMsg.mContentTitle = this.ai;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.c = paramBoolean;
    this.o = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  protected int c()
  {
    return 2131379930;
  }
  
  public int e()
  {
    if ((this.c) && (this.o != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int f()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTitle
 * JD-Core Version:    0.7.0.1
 */