package com.tencent.securemodule;

import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.impl.SecureService.a;
import com.tencent.securemodule.service.ICallback;

public class ac
  implements Runnable
{
  public ac(SecureService.a parama, String paramString, ICallback paramICallback) {}
  
  public void run()
  {
    int i = SecureService.a(this.c.a, this.a);
    ICallback localICallback = this.b;
    if (localICallback != null) {
      localICallback.onTaskFinished(i);
    }
    this.c.a.stopSelf();
    SecureService.a(this.c.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.ac
 * JD-Core Version:    0.7.0.1
 */