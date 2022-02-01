package com.tencent.qmsp.sdk.e;

import com.tencent.qmsp.sdk.app.QmspSDK;
import com.tencent.qmsp.sdk.c.h;
import com.tencent.qmsp.sdk.f.g;

final class b$a
  implements Runnable
{
  public void run()
  {
    try
    {
      if (QmspSDK.getContext() != null)
      {
        h.a(QmspSDK.getContext());
        return;
      }
      g.d("qmsp.cbid", 2, "Context is null!");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.e.b.a
 * JD-Core Version:    0.7.0.1
 */