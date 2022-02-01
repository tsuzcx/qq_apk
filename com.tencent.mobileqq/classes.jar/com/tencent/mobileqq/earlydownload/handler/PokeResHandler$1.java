package com.tencent.mobileqq.earlydownload.handler;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import java.io.IOException;

class PokeResHandler$1
  implements Runnable
{
  PokeResHandler$1(PokeResHandler paramPokeResHandler, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {}
    try
    {
      FileUtils.a(this.a, false);
      FileUtils.a(this.b, this.a, false);
      MediaUtil.a(this.a);
      PokeItemHelper.b(this.a);
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