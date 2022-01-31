import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBag.2.1;

public class mrn
  extends lij
{
  mrn(mrl parammrl) {}
  
  protected void a(long paramLong)
  {
    int i = this.a.a.a().a().d;
    if ((i == 2) || (i == 1))
    {
      mso.a(this.a.a.a().c());
      mso.g();
      d(3);
      return;
    }
    mso.a(0L);
  }
  
  protected void b(long paramLong)
  {
    mrt localmrt = this.a.a();
    if (localmrt != null) {
      localmrt.b("onResumeVideo");
    }
  }
  
  protected void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null) {
      paramString.c(paramBoolean);
    }
    mso.h();
  }
  
  protected void c()
  {
    mrt localmrt = this.a.a();
    if (localmrt != null) {
      localmrt.b("onPauseVideo");
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
    mrt localmrt = this.a.a();
    if (localmrt != null)
    {
      localmrt.a("onConnected:" + paramInt);
      if (localmrt.a != null) {
        localmrt.a(localmrt.a.b);
      }
    }
    this.a.a.a().postDelayed(new AVRedBag.2.1(this, paramInt), 1100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mrn
 * JD-Core Version:    0.7.0.1
 */