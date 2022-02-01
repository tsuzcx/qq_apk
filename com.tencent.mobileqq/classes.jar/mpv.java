import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBag.2.1;

public class mpv
  extends lfk
{
  mpv(mpt parammpt) {}
  
  protected void a(long paramLong)
  {
    int i = this.a.a.a().a().d;
    if ((i == 2) || (i == 1))
    {
      mqw.a(this.a.a.a().c());
      mqw.g();
      d(3);
      return;
    }
    mqw.a(0L);
  }
  
  protected void b(long paramLong)
  {
    mqb localmqb = this.a.a();
    if (localmqb != null) {
      localmqb.b("onResumeVideo");
    }
  }
  
  protected void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null) {
      paramString.c(paramBoolean);
    }
    mqw.h();
  }
  
  protected void c()
  {
    mqb localmqb = this.a.a();
    if (localmqb != null) {
      localmqb.b("onPauseVideo");
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
    mqb localmqb = this.a.a();
    if (localmqb != null)
    {
      localmqb.a("onConnected:" + paramInt);
      if (localmqb.a != null) {
        localmqb.a(localmqb.a.b);
      }
    }
    this.a.a.a().postDelayed(new AVRedBag.2.1(this, paramInt), 1100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mpv
 * JD-Core Version:    0.7.0.1
 */