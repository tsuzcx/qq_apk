import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBag.2.1;

public class mow
  extends lgl
{
  mow(mou parammou) {}
  
  protected void a(long paramLong)
  {
    int i = this.a.a.a().a().d;
    if ((i == 2) || (i == 1))
    {
      mpx.a(this.a.a.a().c());
      mpx.g();
      d(3);
      return;
    }
    mpx.a(0L);
  }
  
  protected void b(long paramLong)
  {
    mpc localmpc = this.a.a();
    if (localmpc != null) {
      localmpc.b("onResumeVideo");
    }
  }
  
  protected void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null) {
      paramString.c(paramBoolean);
    }
    mpx.h();
  }
  
  protected void c()
  {
    mpc localmpc = this.a.a();
    if (localmpc != null) {
      localmpc.b("onPauseVideo");
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
    mpc localmpc = this.a.a();
    if (localmpc != null)
    {
      localmpc.a("onConnected:" + paramInt);
      if (localmpc.a != null) {
        localmpc.a(localmpc.a.b);
      }
    }
    this.a.a.a().postDelayed(new AVRedBag.2.1(this, paramInt), 1100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mow
 * JD-Core Version:    0.7.0.1
 */