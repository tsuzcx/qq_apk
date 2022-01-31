package com.tencent.ttpic.videoshelf.model.player;

import android.media.MediaPlayer;
import android.os.Handler;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import java.util.TimerTask;
import org.libpag.PAGRenderer;

class PagShelfPlayer$PagPlayTimerTask
  extends TimerTask
{
  boolean mIsLooping = false;
  double mProgress = 0.0D;
  int mReaptCount = 1;
  boolean mTaskPause = false;
  
  private PagShelfPlayer$PagPlayTimerTask(PagShelfPlayer paramPagShelfPlayer) {}
  
  public void allEnd()
  {
    if (this.mTaskPause) {
      return;
    }
    TTPTLogger.i("PagShelfPlayer", "onAnimationEnd.");
    PagShelfPlayer.access$902(this.this$0, false);
    if (PagShelfPlayer.access$1000(this.this$0) != null) {
      PagShelfPlayer.access$1000(this.this$0).onCompletion();
    }
    if (PagShelfPlayer.access$800(this.this$0) != null) {}
    try
    {
      PagShelfPlayer.access$800(this.this$0).stop();
      PagShelfPlayer.access$202(this.this$0, true);
      this.mTaskPause = true;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        TTPTLogger.e("PagShelfPlayer", "onAnimationEnd|audioplayer stop has IllegalStateException:" + localIllegalStateException.getMessage());
      }
    }
  }
  
  public boolean isLooping()
  {
    return this.mIsLooping;
  }
  
  public void pause()
  {
    this.mTaskPause = true;
  }
  
  public void reset()
  {
    this.mProgress = 0.0D;
  }
  
  public void resume()
  {
    this.mTaskPause = false;
  }
  
  public void run()
  {
    if (this.mTaskPause) {}
    do
    {
      do
      {
        return;
        PagShelfPlayer.access$300(this.this$0).setProgress(this.mProgress);
        PagShelfPlayer.access$500(this.this$0).removeCallbacks(PagShelfPlayer.access$400(this.this$0));
        PagShelfPlayer.access$500(this.this$0).post(PagShelfPlayer.access$400(this.this$0));
        this.mProgress += PagShelfPlayer.access$600(this.this$0);
      } while (this.mProgress <= 1.0D);
      this.mReaptCount -= 1;
      if ((!this.mIsLooping) && (this.mReaptCount <= 0)) {
        PagShelfPlayer.access$500(this.this$0).post(new PagShelfPlayer.PagPlayTimerTask.1(this));
      }
      this.mProgress = 0.0D;
    } while ((!PagShelfPlayer.access$700(this.this$0)) || (PagShelfPlayer.access$800(this.this$0) == null) || (PagShelfPlayer.access$200(this.this$0)));
    PagShelfPlayer.access$800(this.this$0).seekTo(0);
  }
  
  public void setProgress(float paramFloat)
  {
    this.mProgress = paramFloat;
  }
  
  public void setReaptTime(int paramInt)
  {
    this.mReaptCount = paramInt;
    if (paramInt < 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsLooping = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer.PagPlayTimerTask
 * JD-Core Version:    0.7.0.1
 */