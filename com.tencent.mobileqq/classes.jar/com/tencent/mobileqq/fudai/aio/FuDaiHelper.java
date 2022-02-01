package com.tencent.mobileqq.fudai.aio;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.data.MessageForFuDai;

public class FuDaiHelper
  implements Handler.Callback, ILifeCycleHelper
{
  private BaseChatPie a;
  
  public FuDaiHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  void a(MessageForFuDai paramMessageForFuDai) {}
  
  public String getTag()
  {
    return "FuDaiHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15, 16, 17, 18 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 18: 
      FudaiItemBuilder.f();
      return;
    }
    FudaiItemBuilder.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fudai.aio.FuDaiHelper
 * JD-Core Version:    0.7.0.1
 */