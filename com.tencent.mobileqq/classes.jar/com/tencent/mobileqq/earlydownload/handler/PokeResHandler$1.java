package com.tencent.mobileqq.earlydownload.handler;

import adll;
import amzi;
import android.text.TextUtils;
import bace;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class PokeResHandler$1
  implements Runnable
{
  public PokeResHandler$1(amzi paramamzi, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {}
    try
    {
      String str = this.a + "/poke";
      bace.a(str, false);
      bace.a(this.b, str, false);
      adll.b(this.a + "/poke/");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.PokeResHandler.1
 * JD-Core Version:    0.7.0.1
 */