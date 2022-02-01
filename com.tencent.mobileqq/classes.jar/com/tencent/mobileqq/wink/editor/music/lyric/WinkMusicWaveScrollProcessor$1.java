package com.tencent.mobileqq.wink.editor.music.lyric;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class WinkMusicWaveScrollProcessor$1
  implements GestureDetector.OnGestureListener
{
  WinkMusicWaveScrollProcessor$1(WinkMusicWaveScrollProcessor paramWinkMusicWaveScrollProcessor) {}
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (WinkMusicWaveScrollProcessor.f(this.a) != null) {
      WinkMusicWaveScrollProcessor.f(this.a).a();
    }
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent arg1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    synchronized (this.a)
    {
      WinkMusicWaveScrollProcessor.a(this.a, WinkMusicWaveScrollProcessor.a(this.a) + paramFloat1);
      if (WinkMusicWaveScrollProcessor.a(this.a) < WinkMusicWaveScrollProcessor.b(this.a))
      {
        ??? = this.a;
        WinkMusicWaveScrollProcessor.a(???, WinkMusicWaveScrollProcessor.b(???));
      }
      if (WinkMusicWaveScrollProcessor.a(this.a) > WinkMusicWaveScrollProcessor.c(this.a))
      {
        ??? = this.a;
        WinkMusicWaveScrollProcessor.a(???, WinkMusicWaveScrollProcessor.c(???));
      }
      paramFloat1 = WinkMusicWaveScrollProcessor.a(this.a);
      paramFloat2 = WinkMusicWaveScrollProcessor.d(this.a);
      ??? = this.a;
      WinkMusicWaveScrollProcessor.b(???, WinkMusicWaveScrollProcessor.a(???));
      if (a(paramFloat1 - paramFloat2, 0.0F)) {
        return true;
      }
      if (WinkMusicWaveScrollProcessor.e(this.a) != null) {
        WinkMusicWaveScrollProcessor.e(this.a).a();
      }
      if (WinkMusicWaveScrollProcessor.f(this.a) != null) {
        WinkMusicWaveScrollProcessor.f(this.a).a(this.a.g(), this.a.h());
      }
      return true;
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.lyric.WinkMusicWaveScrollProcessor.1
 * JD-Core Version:    0.7.0.1
 */