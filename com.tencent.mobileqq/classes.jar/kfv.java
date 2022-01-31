import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.ui.redbag.AVRedBag;
import com.tencent.av.ui.redbag.AVRedBagMgr;
import com.tencent.av.ui.redbag.RedBagReport;

public class kfv
  extends VideoObserver
{
  public kfv(AVRedBag paramAVRedBag) {}
  
  protected void c()
  {
    int i = this.a.a.a().a().d;
    if ((i == 2) || (i == 1))
    {
      RedBagReport.a(this.a.a.a().c());
      RedBagReport.g();
      e(3);
      return;
    }
    RedBagReport.a(0L);
  }
  
  protected void c(String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = this.a.a.a().a().d;
      } while ((i != 2) && (i != 1));
      if (paramBoolean)
      {
        if (paramString.a != null) {
          paramString.a.a("onPeerSwitchTerminal");
        }
        paramString.b("onPeerSwitchTerminal");
        return;
      }
      paramString.a("onPeerSwitchTerminal");
    } while (paramString.a == null);
    paramString.a(paramString.a.b);
  }
  
  protected void d()
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if (localAVRedBagMgr != null) {
      localAVRedBagMgr.b("onPauseVideo");
    }
  }
  
  protected void e()
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if (localAVRedBagMgr != null) {
      localAVRedBagMgr.b("onResumeVideo");
    }
  }
  
  void e(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if (localAVRedBagMgr != null)
    {
      localAVRedBagMgr.a("onConnected:" + paramInt);
      if (localAVRedBagMgr.a != null) {
        localAVRedBagMgr.a(localAVRedBagMgr.a.b);
      }
    }
    this.a.a.a().postDelayed(new kfw(this, paramInt), 1100L);
  }
  
  protected void e(String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null) {
      paramString.c();
    }
    RedBagReport.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kfv
 * JD-Core Version:    0.7.0.1
 */