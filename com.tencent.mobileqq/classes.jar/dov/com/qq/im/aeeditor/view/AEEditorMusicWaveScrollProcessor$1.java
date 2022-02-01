package dov.com.qq.im.aeeditor.view;

import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

class AEEditorMusicWaveScrollProcessor$1
  implements GestureDetector.OnGestureListener
{
  AEEditorMusicWaveScrollProcessor$1(AEEditorMusicWaveScrollProcessor paramAEEditorMusicWaveScrollProcessor) {}
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (AEEditorMusicWaveScrollProcessor.a(this.a) != null) {
      AEEditorMusicWaveScrollProcessor.a(this.a).a();
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
    do
    {
      synchronized (this.a)
      {
        AEEditorMusicWaveScrollProcessor.a(this.a, AEEditorMusicWaveScrollProcessor.a(this.a) + paramFloat1);
        if (AEEditorMusicWaveScrollProcessor.a(this.a) < AEEditorMusicWaveScrollProcessor.b(this.a)) {
          AEEditorMusicWaveScrollProcessor.a(this.a, AEEditorMusicWaveScrollProcessor.b(this.a));
        }
        if (AEEditorMusicWaveScrollProcessor.a(this.a) > AEEditorMusicWaveScrollProcessor.c(this.a)) {
          AEEditorMusicWaveScrollProcessor.a(this.a, AEEditorMusicWaveScrollProcessor.c(this.a));
        }
        paramFloat1 = AEEditorMusicWaveScrollProcessor.a(this.a);
        paramFloat2 = AEEditorMusicWaveScrollProcessor.d(this.a);
        AEEditorMusicWaveScrollProcessor.b(this.a, AEEditorMusicWaveScrollProcessor.a(this.a));
        if (a(paramFloat1 - paramFloat2, 0.0F)) {
          return true;
        }
      }
      if (AEEditorMusicWaveScrollProcessor.a(this.a) != null) {
        AEEditorMusicWaveScrollProcessor.a(this.a).a();
      }
    } while (AEEditorMusicWaveScrollProcessor.a(this.a) == null);
    AEEditorMusicWaveScrollProcessor.a(this.a).a(this.a.f(), this.a.g());
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.AEEditorMusicWaveScrollProcessor.1
 * JD-Core Version:    0.7.0.1
 */