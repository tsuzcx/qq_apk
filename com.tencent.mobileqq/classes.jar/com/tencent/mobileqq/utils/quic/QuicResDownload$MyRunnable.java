package com.tencent.mobileqq.utils.quic;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.lang.ref.WeakReference;

class QuicResDownload$MyRunnable
  implements Runnable
{
  private WeakReference<QQAppInterface> a;
  
  public void run()
  {
    if (this.a != null)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
      if (localQQAppInterface != null)
      {
        VideoEnvironment.a("QuicResDownload", "start download quic res", null);
        QuicResDownload.a(new QuicResDownload(localQQAppInterface));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.quic.QuicResDownload.MyRunnable
 * JD-Core Version:    0.7.0.1
 */