import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraObserver;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.redbag.AVRedBag;
import com.tencent.av.ui.redbag.AVRedBagMgr;

public class kfu
  extends CameraObserver
{
  public kfu(AVRedBag paramAVRedBag) {}
  
  protected void a(boolean paramBoolean)
  {
    d();
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    d();
  }
  
  void d()
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if ((localAVRedBagMgr != null) && (localAVRedBagMgr.a())) {
      ((AVRedPacketManager)this.a.a.a(6)).c(this.a.a.a().a().f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kfu
 * JD-Core Version:    0.7.0.1
 */