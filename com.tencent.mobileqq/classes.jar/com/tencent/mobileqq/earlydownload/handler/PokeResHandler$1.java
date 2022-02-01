package com.tencent.mobileqq.earlydownload.handler;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.photo.album.QQAlbumUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class PokeResHandler$1
  implements Runnable
{
  PokeResHandler$1(PokeResHandler paramPokeResHandler, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a)) {
      try
      {
        FileUtils.delete(this.a, false);
        FileUtils.uncompressZip(this.b, this.a, false);
        QQAlbumUtils.a(this.a);
      }
      catch (IOException localIOException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PokeResHandler_0625", 2, localIOException.toString());
        }
      }
    }
    PokeItemHelper.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.handler.PokeResHandler.1
 * JD-Core Version:    0.7.0.1
 */