package com.tencent.qqmusic.mediaplayer.upstream;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;

class DefaultLoader$1
  implements Handler.Callback
{
  DefaultLoader$1(DefaultLoader paramDefaultLoader, Loader.Listener paramListener) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.val$listener == null) {
      return false;
    }
    int i = paramMessage.what;
    if ((i != 1) && (i == 2))
    {
      this.val$listener.onLoadProgress(paramMessage.arg1, paramMessage.arg2);
      return true;
    }
    DefaultLoader.access$002(this.this$0, false);
    Logger.i("DefaultLoader", "[handleMessage] loading = false");
    i = paramMessage.what;
    if (i != 3)
    {
      if (i != 4)
      {
        if (i != 5) {
          return false;
        }
        this.val$listener.onLoadCancelled(DefaultLoader.access$100(this.this$0));
        return true;
      }
      this.val$listener.onLoadError((IOException)paramMessage.obj);
      return true;
    }
    this.val$listener.onLoadCompleted();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DefaultLoader.1
 * JD-Core Version:    0.7.0.1
 */