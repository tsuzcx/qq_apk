import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBag.2.1;

public class moy
  extends lff
{
  moy(mow parammow) {}
  
  protected void a(long paramLong)
  {
    int i = this.a.a.a().a().d;
    if ((i == 2) || (i == 1))
    {
      mpz.a(this.a.a.a().c());
      mpz.g();
      d(3);
      return;
    }
    mpz.a(0L);
  }
  
  protected void b(long paramLong)
  {
    mpe localmpe = this.a.a();
    if (localmpe != null) {
      localmpe.b("onResumeVideo");
    }
  }
  
  protected void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null) {
      paramString.c(paramBoolean);
    }
    mpz.h();
  }
  
  protected void c()
  {
    mpe localmpe = this.a.a();
    if (localmpe != null) {
      localmpe.b("onPauseVideo");
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
    mpe localmpe = this.a.a();
    if (localmpe != null)
    {
      localmpe.a("onConnected:" + paramInt);
      if (localmpe.a != null) {
        localmpe.a(localmpe.a.b);
      }
    }
    this.a.a.a().postDelayed(new AVRedBag.2.1(this, paramInt), 1100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     moy
 * JD-Core Version:    0.7.0.1
 */