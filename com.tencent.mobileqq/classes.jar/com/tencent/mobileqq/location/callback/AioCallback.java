package com.tencent.mobileqq.location.callback;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.LocationMessageUtil;
import mqq.app.MobileQQ;

public class AioCallback
  implements IShareLocationCallback
{
  private void a()
  {
    if ((BaseActivity.sTopActivity instanceof BaseActivity))
    {
      Object localObject = BaseActivity.sTopActivity.getChatFragment();
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).k();
        if ((localObject != null) && (((BaseChatPie)localObject).bb() >= 2)) {
          try
          {
            ((BaseChatPie)localObject).j(131072);
            return;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (paramInt == 0)
    {
      LocationMessageUtil.a(localAppInterface, String.valueOf(paramLong));
      return;
    }
    if (paramInt == 1) {
      LocationMessageUtil.b(localAppInterface, String.valueOf(paramLong));
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    LocationMessageUtil.a((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), paramInt, paramString, paramBoolean);
    a();
  }
  
  public void b(int paramInt, long paramLong)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (paramInt == 0) {
      LocationMessageUtil.a(localAppInterface, String.valueOf(paramLong));
    } else if (paramInt == 1) {
      LocationMessageUtil.b(localAppInterface, String.valueOf(paramLong));
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.callback.AioCallback
 * JD-Core Version:    0.7.0.1
 */