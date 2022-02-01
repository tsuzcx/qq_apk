package com.tencent.mobileqq.emoticonview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class VoiceGifImage
  extends NativeGifImage
{
  boolean IS_ENABLE_DEBUG_LOG = false;
  private boolean restart = false;
  private boolean restarting = false;
  private boolean running = true;
  
  public VoiceGifImage(File paramFile, int paramInt, boolean paramBoolean)
  {
    super(paramFile, paramBoolean, true, 0, 0, 0.0F);
  }
  
  public void doApplyNextFrame()
  {
    if ((QLog.isColorLevel()) && (this.IS_ENABLE_DEBUG_LOG)) {
      QLog.d("VoiceGifImage", 2, "doApplyNextFrame");
    }
    super.doApplyNextFrame();
    if (this.restarting)
    {
      this.restarting = false;
      this.restart = false;
    }
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((!this.running) && (this.mFirstFrameBitmap != null)) {
      if (this.mFirstFrameBitmap != null)
      {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
        if ((QLog.isColorLevel()) && (this.IS_ENABLE_DEBUG_LOG)) {
          QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !running ");
        }
      }
    }
    label57:
    do
    {
      do
      {
        do
        {
          break label57;
          break label57;
          do
          {
            return;
          } while ((!QLog.isColorLevel()) || (!this.IS_ENABLE_DEBUG_LOG));
          QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !running, mFirstFrameBitmap is null");
          return;
          if (!this.restart) {
            break;
          }
          if (this.mFirstFrameBitmap != null) {
            paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
          }
          for (;;)
          {
            if (sPaused) {
              break label161;
            }
            executeNewTask();
            if ((!QLog.isColorLevel()) || (!this.IS_ENABLE_DEBUG_LOG)) {
              break;
            }
            QLog.d("VoiceGifImage", 2, "VoiceGifImage draw restart  !sPaused");
            return;
            if ((QLog.isColorLevel()) && (this.IS_ENABLE_DEBUG_LOG)) {
              QLog.d("VoiceGifImage", 2, "VoiceGifImage draw restart, mFirstFrameBitmap is null");
            }
          }
        } while (this.mIsInPendingAction);
        sPendingActions.add(new WeakReference(this));
        this.mIsInPendingAction = true;
      } while ((!QLog.isColorLevel()) || (!this.IS_ENABLE_DEBUG_LOG));
      QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !mIsInPendingAction  !mIsInPendingAction");
      return;
      super.draw(paramCanvas, paramRect, paramPaint, paramBoolean);
    } while ((!QLog.isColorLevel()) || (!this.IS_ENABLE_DEBUG_LOG));
    label161:
    QLog.d("VoiceGifImage", 2, "VoiceGifImage draw else");
  }
  
  public void getNextFrame()
  {
    try
    {
      if (this.restart)
      {
        this.restarting = true;
        super.reset();
        if ((QLog.isColorLevel()) && (this.IS_ENABLE_DEBUG_LOG)) {
          QLog.d("VoiceGifImage", 2, "getNextFrame restart");
        }
      }
      super.getNextFrame();
      return;
    }
    finally {}
  }
  
  public void start()
  {
    this.running = true;
    if ((QLog.isColorLevel()) && (this.IS_ENABLE_DEBUG_LOG)) {
      QLog.d("VoiceGifImage", 2, "getNextFrame start");
    }
  }
  
  public void stop()
  {
    this.running = false;
    this.restart = true;
    if ((QLog.isColorLevel()) && (this.IS_ENABLE_DEBUG_LOG)) {
      QLog.d("VoiceGifImage", 2, "getNextFrame stop");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.VoiceGifImage
 * JD-Core Version:    0.7.0.1
 */