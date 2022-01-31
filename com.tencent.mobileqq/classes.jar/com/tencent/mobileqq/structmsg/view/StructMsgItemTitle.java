package com.tencent.mobileqq.structmsg.view;

import android.widget.TextView;
import awun;
import com.tencent.mobileqq.structmsg.AbsShareMsg;

public class StructMsgItemTitle
  extends awun
{
  public boolean c;
  public boolean d;
  public int i;
  
  public StructMsgItemTitle()
  {
    this(null);
  }
  
  public StructMsgItemTitle(String paramString)
  {
    super(paramString, "title");
  }
  
  public Class<? extends TextView> a()
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
    paramAbsShareMsg.mContentTitle = this.Y;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.c = paramBoolean;
    this.i = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public int c()
  {
    return 2131312553;
  }
  
  public int e()
  {
    if ((this.c) && (this.i != 0)) {
      return -1;
    }
    return -16777216;
  }
  
  public int f()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTitle
 * JD-Core Version:    0.7.0.1
 */