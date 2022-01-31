import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.chatroom.VideoChatRoomContainer;

class mbp
  implements Animation.AnimationListener
{
  mbp(mbo parammbo) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (mbo.a(this.a) != null) {
      mbo.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mbp
 * JD-Core Version:    0.7.0.1
 */