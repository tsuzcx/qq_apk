package com.tencent.mobileqq.emoticonview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.NativeGifIndex8;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class VoiceGifImageV2
  extends NativeGifIndex8
{
  private boolean mRestart;
  private boolean mRestarting;
  private boolean mRunning = true;
  
  public VoiceGifImageV2(File paramFile, int paramInt, boolean paramBoolean)
  {
    super(paramFile, paramBoolean, true, 0, 0, 0.0F);
  }
  
  public void doApplyNextFrame()
  {
    super.doApplyNextFrame();
    if (this.mRestarting)
    {
      this.mRestarting = false;
      this.mRestart = false;
    }
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((!this.mRunning) && (this.mFirstFrameBitmap != null)) {
      if (this.mFirstFrameBitmap != null) {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
      }
    }
    do
    {
      return;
      if (!this.mRestart) {
        break;
      }
      if (this.mFirstFrameBitmap != null) {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
      }
      if (!sPaused)
      {
        executeNewTask();
        return;
      }
    } while (this.mIsInPendingAction);
    sPendingActions.add(new WeakReference(this));
    this.mIsInPendingAction = true;
    return;
    super.draw(paramCanvas, paramRect, paramPaint, paramBoolean);
  }
  
  public void getNextFrame()
  {
    try
    {
      if (this.mRestart)
      {
        this.mRestarting = true;
        super.reset();
      }
      super.getNextFrame();
      return;
    }
    finally {}
  }
  
  public void start()
  {
    this.mRunning = true;
  }
  
  public void stop()
  {
    this.mRunning = false;
    this.mRestart = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.VoiceGifImageV2
 * JD-Core Version:    0.7.0.1
 */