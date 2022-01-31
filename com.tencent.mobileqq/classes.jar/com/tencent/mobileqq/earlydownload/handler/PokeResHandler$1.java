package com.tencent.mobileqq.earlydownload.handler;

import afsw;
import android.text.TextUtils;
import aphc;
import bdcs;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class PokeResHandler$1
  implements Runnable
{
  public PokeResHandler$1(aphc paramaphc, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {}
    try
    {
      bdcs.a(this.a, false);
      bdcs.a(this.b, this.a, false);
      afsw.b(this.a);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PokeResHandler_0625", 2, localIOException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.PokeResHandler.1
 * JD-Core Version:    0.7.0.1
 */