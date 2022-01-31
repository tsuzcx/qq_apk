import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.ui.redbag.AVRedBagMgr;

public class kdx
  extends VideoObserver
{
  public kdx(AVRedBagMgr paramAVRedBagMgr) {}
  
  protected void c()
  {
    super.c();
    this.a.a("onConnected_init_when_not_support");
    AVRedBagMgr.a(this.a).b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kdx
 * JD-Core Version:    0.7.0.1
 */