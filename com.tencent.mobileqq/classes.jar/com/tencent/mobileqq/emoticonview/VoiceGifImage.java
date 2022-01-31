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
  private boolean a = true;
  private boolean b;
  private boolean c;
  
  public VoiceGifImage(File paramFile, int paramInt, boolean paramBoolean)
  {
    super(paramFile, paramBoolean, true, 0, 0, 0.0F);
  }
  
  public void a()
  {
    this.a = true;
    if (QLog.isColorLevel()) {
      QLog.d("VoiceGifImage", 2, "getNextFrame start");
    }
  }
  
  public void b()
  {
    this.a = false;
    this.b = true;
    if (QLog.isColorLevel()) {
      QLog.d("VoiceGifImage", 2, "getNextFrame stop");
    }
  }
  
  protected void doApplyNextFrame()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceGifImage", 2, "doApplyNextFrame");
    }
    super.doApplyNextFrame();
    if (this.c)
    {
      this.c = false;
      this.b = false;
    }
  }
  
  public void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    initHandlerAndRunnable();
    if ((!this.a) && (this.mFirstFrameBitmap != null)) {
      if (this.mFirstFrameBitmap != null)
      {
        paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
        if (QLog.isColorLevel()) {
          QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !running ");
        }
      }
    }
    label50:
    do
    {
      do
      {
        do
        {
          break label50;
          break label50;
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !running, mFirstFrameBitmap is null");
          return;
          if (!this.b) {
            break;
          }
          if (this.mFirstFrameBitmap != null) {
            paramCanvas.drawBitmap(this.mFirstFrameBitmap, null, paramRect, paramPaint);
          }
          for (;;)
          {
            if (sPaused) {
              break label133;
            }
            executeNewTask();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("VoiceGifImage", 2, "VoiceGifImage draw restart  !sPaused");
            return;
            if (QLog.isColorLevel()) {
              QLog.d("VoiceGifImage", 2, "VoiceGifImage draw restart, mFirstFrameBitmap is null");
            }
          }
        } while (this.mIsInPendingAction);
        sPendingActions.add(new WeakReference(this));
        this.mIsInPendingAction = true;
      } while (!QLog.isColorLevel());
      QLog.d("VoiceGifImage", 2, "VoiceGifImage draw !mIsInPendingAction  !mIsInPendingAction");
      return;
      super.draw(paramCanvas, paramRect, paramPaint, paramBoolean);
    } while (!QLog.isColorLevel());
    label133:
    QLog.d("VoiceGifImage", 2, "VoiceGifImage draw else");
  }
  
  public void getNextFrame()
  {
    try
    {
      if (this.b)
      {
        this.c = true;
        super.reset();
        if (QLog.isColorLevel()) {
          QLog.d("VoiceGifImage", 2, "getNextFrame restart");
        }
      }
      super.getNextFrame();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.VoiceGifImage
 * JD-Core Version:    0.7.0.1
 */