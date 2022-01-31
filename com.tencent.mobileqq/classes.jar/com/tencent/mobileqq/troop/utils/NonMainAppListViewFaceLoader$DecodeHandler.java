package com.tencent.mobileqq.troop.utils;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class NonMainAppListViewFaceLoader$DecodeHandler
  extends Handler
{
  public NonMainAppListViewFaceLoader$DecodeHandler(NonMainAppListViewFaceLoader paramNonMainAppListViewFaceLoader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001) {}
    try
    {
      paramMessage = (String)paramMessage.obj;
      if (QLog.isColorLevel()) {
        QLog.d("NonMainAppListViewFaceLoader", 2, "DecodeHandler handle MSG_DECODE_FACE_BITMAP uin:" + paramMessage);
      }
      Bitmap localBitmap1 = ImageUtil.a((String)this.a.b.get(paramMessage), null);
      if (localBitmap1 != null)
      {
        Bitmap localBitmap2 = this.a.a(localBitmap1);
        if (localBitmap2 != null)
        {
          Message localMessage = Message.obtain();
          Bundle localBundle = new Bundle();
          localBundle.putParcelable("bmp", localBitmap2);
          localBundle.putString("uin", paramMessage);
          localMessage.obj = localBundle;
          localMessage.what = 1002;
          this.a.a.sendMessage(localMessage);
          if (QLog.isColorLevel()) {
            QLog.d("NonMainAppListViewFaceLoader", 2, "decodeFile, uin:" + paramMessage);
          }
        }
        if ((localBitmap1 != null) && (!localBitmap1.isRecycled())) {
          localBitmap1.recycle();
        }
      }
      return;
    }
    catch (OutOfMemoryError paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NonMainAppListViewFaceLoader", 2, "decodeFile, OutOfMemoryError");
      return;
    }
    catch (Exception paramMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NonMainAppListViewFaceLoader", 2, "decodeFile, exception:" + paramMessage.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.NonMainAppListViewFaceLoader.DecodeHandler
 * JD-Core Version:    0.7.0.1
 */