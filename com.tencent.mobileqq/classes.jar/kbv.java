import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteLock;

class kbv
  implements QavInOutAnimation.QavOutAnimationListener
{
  kbv(kbu paramkbu) {}
  
  public void a()
  {
    if (this.a.a.a != null)
    {
      this.a.a.a.setViewEnable(2131364247, false);
      this.a.a.a.setViewEnable(2131365414, false);
      this.a.a.a.setViewEnable(2131365413, false);
      this.a.a.a.setViewEnable(2131365411, false);
      this.a.a.a.setViewEnable(2131365409, false);
      this.a.a.a.setViewEnable(2131364249, false);
    }
  }
  
  public void b()
  {
    VideoInviteLock.b(this.a.a);
    VideoInviteLock.a(this.a.a, 0, 2131034269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbv
 * JD-Core Version:    0.7.0.1
 */