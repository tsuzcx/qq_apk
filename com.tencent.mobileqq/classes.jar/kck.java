import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteLock;

class kck
  implements QavInOutAnimation.QavOutAnimationListener
{
  kck(kcj paramkcj) {}
  
  public void a()
  {
    if (this.a.a.a != null)
    {
      this.a.a.a.setViewEnable(2131364223, false);
      this.a.a.a.setViewEnable(2131365392, false);
      this.a.a.a.setViewEnable(2131365391, false);
      this.a.a.a.setViewEnable(2131365389, false);
      this.a.a.a.setViewEnable(2131365387, false);
      this.a.a.a.setViewEnable(2131364225, false);
    }
  }
  
  public void b()
  {
    VideoInviteLock.b(this.a.a);
    VideoInviteLock.a(this.a.a, 0, 2131034269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kck
 * JD-Core Version:    0.7.0.1
 */