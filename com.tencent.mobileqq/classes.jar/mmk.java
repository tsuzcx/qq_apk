import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.chatroom.VideoChatRoomContainer;

class mmk
  implements Animation.AnimationListener
{
  mmk(mmj parammmj) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (mmj.a(this.a) != null) {
      mmj.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mmk
 * JD-Core Version:    0.7.0.1
 */