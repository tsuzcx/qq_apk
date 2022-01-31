import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.AVRedBagMgr;

public class ked
  implements Runnable
{
  public ked(AVRedBagMgr paramAVRedBagMgr) {}
  
  public void run()
  {
    AVActivity localAVActivity = this.a.a();
    if (localAVActivity != null) {
      localAVActivity.f(this.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ked
 * JD-Core Version:    0.7.0.1
 */