package com.tencent.tavkit.component;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.TAVComposition;

class TAVPlayer$PostUpdateThread
  extends HandlerThread
  implements Handler.Callback
{
  private static final int MSG_UNLOCK = 95;
  private static final int MSG_UPDATE = 223;
  private boolean autoPlay;
  private Handler handler;
  private volatile boolean msgLock = false;
  private TAVPlayer.ICompositionBuilder templateSource;
  
  private TAVPlayer$PostUpdateThread(TAVPlayer paramTAVPlayer, String paramString)
  {
    super(paramString);
  }
  
  private void doUnlockMsg()
  {
    if (this.msgLock)
    {
      this.msgLock = false;
      if (this.templateSource != null) {
        update(this.templateSource, this.autoPlay);
      }
    }
  }
  
  private void doUpdateComposition(TAVPlayer.ICompositionBuilder paramICompositionBuilder, boolean paramBoolean)
  {
    unlockMsg(1000);
    TAVComposition localTAVComposition = paramICompositionBuilder.buildComposition();
    this.this$0.updateComposition(localTAVComposition, CMTime.CMTimeZero, paramBoolean, new TAVPlayer.PostUpdateThread.1(this, paramICompositionBuilder));
  }
  
  private void doUpdateMsg()
  {
    if ((!this.msgLock) && (this.templateSource != null))
    {
      Log.d(TAVPlayer.access$500(this.this$0), "doUpdateMsg() called");
      this.msgLock = true;
      doUpdateComposition(this.templateSource, this.autoPlay);
      this.templateSource = null;
      this.autoPlay = false;
    }
  }
  
  private void unlockMsg(int paramInt)
  {
    try
    {
      Logger.d(TAVPlayer.access$500(this.this$0), "unlockMsg() called thread = " + Thread.currentThread().getName());
      this.handler.removeMessages(95);
      this.handler.sendEmptyMessageDelayed(95, paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void update(TAVPlayer.ICompositionBuilder paramICompositionBuilder, boolean paramBoolean)
  {
    try
    {
      Logger.d(TAVPlayer.access$500(this.this$0), "update() called with: thread = " + Thread.currentThread().getName() + ", templateSource = [" + paramICompositionBuilder + "], autoPlay = [" + paramBoolean + "]");
      this.templateSource = paramICompositionBuilder;
      this.autoPlay = paramBoolean;
      this.handler.removeMessages(223);
      this.handler.sendEmptyMessage(223);
      return;
    }
    finally
    {
      paramICompositionBuilder = finally;
      throw paramICompositionBuilder;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Logger.d(TAVPlayer.access$500(this.this$0), "handleMessage() called with: msg = [" + paramMessage + "] msgLock = " + this.msgLock + ",templateSource = " + this.templateSource);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      doUpdateMsg();
      continue;
      doUnlockMsg();
    }
  }
  
  protected void onLooperPrepared()
  {
    super.onLooperPrepared();
  }
  
  public void release()
  {
    this.templateSource = null;
    if (this.handler != null)
    {
      this.handler.removeCallbacksAndMessages(null);
      this.handler = null;
    }
    quit();
  }
  
  public void start()
  {
    try
    {
      super.start();
      this.handler = new Handler(getLooper(), this);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer.PostUpdateThread
 * JD-Core Version:    0.7.0.1
 */