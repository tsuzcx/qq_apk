import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.av.ui.chatroom.VideoChatRoomContainer;

class mni
  implements Animator.AnimatorListener
{
  mni(mng parammng) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    mng.a(this.a).setVisibility(8);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mni
 * JD-Core Version:    0.7.0.1
 */