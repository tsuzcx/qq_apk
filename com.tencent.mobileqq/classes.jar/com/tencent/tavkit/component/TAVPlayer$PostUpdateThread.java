package com.tencent.tavkit.component;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
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
  @Nullable
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
      TAVPlayer.ICompositionBuilder localICompositionBuilder = this.templateSource;
      if (localICompositionBuilder != null) {
        update(localICompositionBuilder, this.autoPlay);
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
      Logger.d(TAVPlayer.access$500(this.this$0), "doUpdateMsg() called");
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
      Object localObject1 = TAVPlayer.access$500(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unlockMsg() called thread = ");
      localStringBuilder.append(Thread.currentThread().getName());
      Logger.d((String)localObject1, localStringBuilder.toString());
      localObject1 = this.handler;
      if (localObject1 == null) {
        return;
      }
      this.handler.removeMessages(95);
      this.handler.sendEmptyMessageDelayed(95, paramInt);
      return;
    }
    finally {}
  }
  
  private void update(TAVPlayer.ICompositionBuilder paramICompositionBuilder, boolean paramBoolean)
  {
    try
    {
      Object localObject = TAVPlayer.access$500(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update() called with: thread = ");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(", templateSource = [");
      localStringBuilder.append(paramICompositionBuilder);
      localStringBuilder.append("], autoPlay = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      Logger.d((String)localObject, localStringBuilder.toString());
      localObject = this.handler;
      if (localObject == null) {
        return;
      }
      this.templateSource = paramICompositionBuilder;
      this.autoPlay = paramBoolean;
      this.handler.removeMessages(223);
      this.handler.sendEmptyMessage(223);
      return;
    }
    finally {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    String str = TAVPlayer.access$500(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleMessage() called with: msg = [");
    localStringBuilder.append(paramMessage);
    localStringBuilder.append("] msgLock = ");
    localStringBuilder.append(this.msgLock);
    localStringBuilder.append(",templateSource = ");
    localStringBuilder.append(this.templateSource);
    Logger.d(str, localStringBuilder.toString());
    int i = paramMessage.what;
    if (i != 95)
    {
      if (i == 223) {
        doUpdateMsg();
      }
    }
    else {
      doUnlockMsg();
    }
    return true;
  }
  
  protected void onLooperPrepared()
  {
    super.onLooperPrepared();
  }
  
  public void release()
  {
    try
    {
      this.templateSource = null;
      if (this.handler != null)
      {
        this.handler.removeCallbacksAndMessages(null);
        this.handler = null;
      }
      quit();
      return;
    }
    finally {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.component.TAVPlayer.PostUpdateThread
 * JD-Core Version:    0.7.0.1
 */