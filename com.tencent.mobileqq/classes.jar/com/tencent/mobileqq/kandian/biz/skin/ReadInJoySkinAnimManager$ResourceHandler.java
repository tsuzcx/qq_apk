package com.tencent.mobileqq.kandian.biz.skin;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ReadInJoySkinAnimManager$ResourceHandler
  extends Handler
{
  private WeakReference<ReadInJoySkinAnimManager> a;
  
  public ReadInJoySkinAnimManager$ResourceHandler(ReadInJoySkinAnimManager paramReadInJoySkinAnimManager)
  {
    this.a = new WeakReference(paramReadInJoySkinAnimManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ReadInJoySkinAnimManager localReadInJoySkinAnimManager = (ReadInJoySkinAnimManager)this.a.get();
    if (localReadInJoySkinAnimManager == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      ReadInJoySkinAnimManager.a(localReadInJoySkinAnimManager);
      return;
    }
    ReadInJoySkinAnimManager.b(localReadInJoySkinAnimManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinAnimManager.ResourceHandler
 * JD-Core Version:    0.7.0.1
 */