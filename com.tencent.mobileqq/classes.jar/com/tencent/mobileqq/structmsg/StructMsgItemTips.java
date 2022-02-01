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
    paramContext.setBackgroundResource(2130846198);
    paramContext.setPadding(20, 5, 20, 5);
    paramContext.setGravity(17);
    return paramContext;
  }
  
  public String b()
  {
    return "tips";
  }
  
  protected int f()
  {
    return 2131448810;
  }
  
  public int i()
  {
    return -1;
  }
  
  public int j()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgItemTips
 * JD-Core Version:    0.7.0.1
 */