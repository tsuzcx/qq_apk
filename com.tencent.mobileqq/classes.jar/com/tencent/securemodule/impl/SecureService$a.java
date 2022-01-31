package com.tencent.securemodule.impl;

import android.os.Binder;
import com.tencent.securemodule.ac;
import com.tencent.securemodule.ax;
import com.tencent.securemodule.service.ICallback;
import com.tencent.securemodule.service.IControlService;

public class SecureService$a
  extends Binder
  implements IControlService
{
  public SecureService$a(SecureService paramSecureService) {}
  
  public void doRemoteTask(String paramString, ICallback paramICallback)
  {
    if (!ax.a(this.a.getApplicationContext(), "sm_mq")) {
      return;
    }
    try
    {
      new Thread(new ac(this, paramString, paramICallback)).start();
      return;
    }
    finally {}
  }
  
  public void setIsShowingTips(boolean paramBoolean1, boolean paramBoolean2)
  {
    SecureService.a(this.a, paramBoolean1);
    if (paramBoolean2)
    {
      this.a.stopSelf();
      SecureService.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.securemodule.impl.SecureService.a
 * JD-Core Version:    0.7.0.1
 */