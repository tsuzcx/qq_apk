package dov.com.qq.im.ae.album;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class AEAlbumLinearLayout$2
  implements Animator.AnimatorListener
{
  AEAlbumLinearLayout$2(AEAlbumLinearLayout paramAEAlbumLinearLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEAlbumLinearLayout.a(this.a, 0);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (AEAlbumLinearLayout.a(this.a) != null) {
      AEAlbumLinearLayout.a(this.a).a(AEAlbumLinearLayout.b(this.a), AEAlbumLinearLayout.a(this.a, AEAlbumLinearLayout.b(this.a)));
    }
    AEAlbumLinearLayout.a(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (AEAlbumLinearLayout.a(this.a) != null) {
      AEAlbumLinearLayout.a(this.a).a(AEAlbumLinearLayout.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.AEAlbumLinearLayout.2
 * JD-Core Version:    0.7.0.1
 */