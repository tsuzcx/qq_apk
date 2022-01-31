import com.tencent.av.ui.QavInOutAnimation.QavOutAnimationListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoInviteActivity;

class kbs
  implements QavInOutAnimation.QavOutAnimationListener
{
  kbs(kbq paramkbq) {}
  
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
    this.a.a.e = true;
    this.a.a.finish();
    this.a.a.overridePendingTransition(0, 2131034269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kbs
 * JD-Core Version:    0.7.0.1
 */