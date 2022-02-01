import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.av.ui.chatroom.VideoChatRoomContainer;

class mnh
  implements Animation.AnimationListener
{
  mnh(mng parammng) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (mng.a(this.a) != null) {
      mng.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mnh
 * JD-Core Version:    0.7.0.1
 */