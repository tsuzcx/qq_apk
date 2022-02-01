package com.tencent.mobileqq.structmsg.view;

import android.widget.TextView;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.utils.QQTheme;

public class StructMsgItemTitle
  extends AbsStructMsgTextElement
{
  public int aM = 0;
  public boolean aN = false;
  public boolean aO = false;
  
  public StructMsgItemTitle()
  {
    this(null);
  }
  
  public StructMsgItemTitle(String paramString)
  {
    super(paramString, "title");
  }
  
  public void a(AbsShareMsg paramAbsShareMsg)
  {
    paramAbsShareMsg.mContentTitle = this.aA;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.aN = paramBoolean;
    this.aM = paramInt;
  }
  
  public String b()
  {
    return "Title";
  }
  
  public void b(boolean paramBoolean)
  {
    this.aO = paramBoolean;
  }
  
  protected Class<? extends TextView> c()
  {
    if (this.aO) {
      return StructMsgItemTitle.TitleTextView.class;
    }
    return super.c();
  }
  
  protected int f()
  {
    return 2131448814;
  }
  
  public int i()
  {
    if ((this.aN) && (this.aM != 0)) {
      return -1;
    }
    if ((QQTheme.isNowSimpleUI()) && (QQTheme.isNowThemeIsNight())) {
      return -1;
    }
    return -16777216;
  }
  
  public int j()
  {
    return 28;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemTitle
 * JD-Core Version:    0.7.0.1
 */