package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.widget.TextView;

public class StructMsgItemTips
  extends AbsStructMsgTextElement
{
  public StructMsgItemTips()
  {
    this(null);
  }
  
  public StructMsgItemTips(String paramString)
  {
    super(paramString, "tips");
  }
  
  public TextView a(Context paramContext)
  {
    paramContext = super.a(paramContext);
    paramContext.setBackgroundResource(2130842181);
    paramContext.setPadding(20, 5, 20, 5);
    paramContext.setGravity(17);
    return paramContext;
  }
  
  public String a()
  {
    return "tips";
  }
  
  protected int c()
  {
    return 2131361929;
  }
  
  public int d()
  {
    return -1;
  }
  
  public int e()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgItemTips
 * JD-Core Version:    0.7.0.1
 */