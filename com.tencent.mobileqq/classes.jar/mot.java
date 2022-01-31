import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBag.2.1;

public class mot
  extends lgg
{
  mot(mor parammor) {}
  
  protected void a(long paramLong)
  {
    int i = this.a.a.a().a().d;
    if ((i == 2) || (i == 1))
    {
      mpu.a(this.a.a.a().c());
      mpu.g();
      d(3);
      return;
    }
    mpu.a(0L);
  }
  
  protected void b(long paramLong)
  {
    moz localmoz = this.a.a();
    if (localmoz != null) {
      localmoz.b("onResumeVideo");
    }
  }
  
  protected void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null) {
      paramString.c(paramBoolean);
    }
    mpu.h();
  }
  
  protected void c()
  {
    moz localmoz = this.a.a();
    if (localmoz != null) {
      localmoz.b("onPauseVideo");
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
    moz localmoz = this.a.a();
    if (localmoz != null)
    {
      localmoz.a("onConnected:" + paramInt);
      if (localmoz.a != null) {
        localmoz.a(localmoz.a.b);
      }
    }
    this.a.a.a().postDelayed(new AVRedBag.2.1(this, paramInt), 1100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mot
 * JD-Core Version:    0.7.0.1
 */