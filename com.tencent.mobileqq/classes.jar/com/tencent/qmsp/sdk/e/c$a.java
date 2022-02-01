package com.tencent.qmsp.sdk.e;

import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.c.f;
import com.tencent.qmsp.sdk.d.c;
import com.tencent.qmsp.sdk.f.g;

final class c$a
  implements Runnable
{
  public void run()
  {
    try
    {
      if (QmspSDK.getContext() != null)
      {
        c localc = new c(QmspSDK.getContext());
        f.i().a(localc);
        localc.a();
        return;
      }
      g.d("qp.updTask", 2, "Context is null!");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.e.c.a
 * JD-Core Version:    0.7.0.1
 */