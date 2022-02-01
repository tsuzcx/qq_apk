package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class PasswdRedBagServiceImpl$10
  implements Runnable
{
  PasswdRedBagServiceImpl$10(PasswdRedBagServiceImpl paramPasswdRedBagServiceImpl) {}
  
  public void run()
  {
    try
    {
      Object localObject = PasswdRedBagServiceImpl.access$400(this.this$0).c();
      if (localObject != null)
      {
        PasswdRedBagServiceImpl.access$602(this.this$0, false);
        localObject = ((HashMap)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          this.this$0.mPasswdRedBagAuthKeyCache.put(localEntry.getKey(), localEntry.getValue());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isDevelopLevel()) {
        localThrowable.printStackTrace();
      }
      PasswdRedBagServiceImpl.access$702(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl.10
 * JD-Core Version:    0.7.0.1
 */