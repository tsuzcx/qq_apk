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
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = (QQAppInterface)((WeakReference)localObject).get();
      if (localObject != null)
      {
        VideoEnvironment.LogDownLoad("QuicResDownload", "start download quic res", null);
        QuicResDownload.a(new QuicResDownload((QQAppInterface)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.quic.QuicResDownload.MyRunnable
 * JD-Core Version:    0.7.0.1
 */