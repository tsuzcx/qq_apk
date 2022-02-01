package cooperation.qzone.zipanimate;

import android.graphics.drawable.Drawable;
import android.os.Handler;

class ZipAnimationDrawable$1
  implements ZipFrameLoadedListener
{
  ZipAnimationDrawable$1(ZipAnimationDrawable paramZipAnimationDrawable) {}
  
  public void onLoaded(int paramInt, Drawable paramDrawable)
  {
    if (paramInt == 0)
    {
      ZipAnimationDrawable.access$100(this.this$0).animationResLoader.selectFrame(0);
      this.this$0.uiHandler.post(new ZipAnimationDrawable.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable.1
 * JD-Core Version:    0.7.0.1
 */