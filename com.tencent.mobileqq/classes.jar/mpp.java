import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBag.2.1;

public class mpp
  extends lfl
{
  mpp(mpn parammpn) {}
  
  protected void a(long paramLong)
  {
    int i = this.a.a.a().a().d;
    if ((i == 2) || (i == 1))
    {
      mqq.a(this.a.a.a().c());
      mqq.g();
      d(3);
      return;
    }
    mqq.a(0L);
  }
  
  protected void b(long paramLong)
  {
    mpv localmpv = this.a.a();
    if (localmpv != null) {
      localmpv.b("onResumeVideo");
    }
  }
  
  protected void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null) {
      paramString.c(paramBoolean);
    }
    mqq.h();
  }
  
  protected void c()
  {
    mpv localmpv = this.a.a();
    if (localmpv != null) {
      localmpv.b("onPauseVideo");
    }
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
  
  public void d(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    mpv localmpv = this.a.a();
    if (localmpv != null)
    {
      localmpv.a("onConnected:" + paramInt);
      if (localmpv.a != null) {
        localmpv.a(localmpv.a.b);
      }
    }
    this.a.a.a().postDelayed(new AVRedBag.2.1(this, paramInt), 1100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mpp
 * JD-Core Version:    0.7.0.1
 */