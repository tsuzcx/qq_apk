package com.tencent.mobileqq.tts.impl;

import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

class TtsPlayerImpl$1
  implements Runnable
{
  TtsPlayerImpl$1(TtsPlayerImpl paramTtsPlayerImpl) {}
  
  public void run()
  {
    try
    {
      TtsPlayerImpl.access$000(this.this$0).close();
      return;
    }
    catch (IOException localIOException)
    {
      QLog.e("TtsPlayer", 1, "[stop] stream close error. ", localIOException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.impl.TtsPlayerImpl.1
 * JD-Core Version:    0.7.0.1
 */