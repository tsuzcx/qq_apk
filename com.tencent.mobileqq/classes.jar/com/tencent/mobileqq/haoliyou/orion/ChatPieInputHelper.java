package com.tencent.mobileqq.haoliyou.orion;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.TextMenuListener;

public class ChatPieInputHelper
  implements ILifeCycleHelper
{
  public boolean a;
  private final BaseChatPie b;
  private XEditTextEx.TextMenuListener c = new ChatPieInputHelper.1(this);
  
  public ChatPieInputHelper(BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
  }
  
  private void b(XEditTextEx paramXEditTextEx)
  {
    try
    {
      paramXEditTextEx.b(this.c);
      return;
    }
    catch (Throwable paramXEditTextEx) {}
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 30) {
      this.a = true;
    }
  }
  
  public void a(XEditTextEx paramXEditTextEx)
  {
    try
    {
      paramXEditTextEx.a(this.c);
      return;
    }
    catch (Throwable paramXEditTextEx)
    {
      paramXEditTextEx.printStackTrace();
    }
  }
  
  public String getTag()
  {
    return "ChatPieInputHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15, 7 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 4)
    {
      a(this.b.Y);
      return;
    }
    if (paramInt == 15)
    {
      b(this.b.Y);
      return;
    }
    if (paramInt == 7) {
      NotifyIdManager.a(this.b.d).a(this.b.ah);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.orion.ChatPieInputHelper
 * JD-Core Version:    0.7.0.1
 */