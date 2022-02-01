package cooperation.qzone.zipanimate;

import android.os.Handler;

class ZipAnimationDrawable$ZipAnimationState$1
  implements ZipLoadedListener
{
  ZipAnimationDrawable$ZipAnimationState$1(ZipAnimationDrawable.ZipAnimationState paramZipAnimationState) {}
  
  public void onZipLoaded(boolean paramBoolean)
  {
    if (!this.this$1.aniResLoaded)
    {
      ZipAnimationDrawable.ZipAnimationState localZipAnimationState = this.this$1;
      localZipAnimationState.aniResLoaded = paramBoolean;
      localZipAnimationState.this$0.uiHandler.post(new ZipAnimationDrawable.ZipAnimationState.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable.ZipAnimationState.1
 * JD-Core Version:    0.7.0.1
 */