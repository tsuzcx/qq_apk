import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.redbag.AVRedBag.2.1;

public class mdx
  extends kvw
{
  mdx(mdv parammdv) {}
  
  protected void a(long paramLong)
  {
    int i = this.a.a.a().a().d;
    if ((i == 2) || (i == 1))
    {
      mey.a(this.a.a.a().c());
      mey.g();
      c(3);
      return;
    }
    mey.a(0L);
  }
  
  protected void b(long paramLong)
  {
    med localmed = this.a.a();
    if (localmed != null) {
      localmed.b("onResumeVideo");
    }
  }
  
  protected void b(long paramLong, String paramString, boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null) {
      paramString.c(paramBoolean);
    }
    mey.h();
  }
  
  protected void c()
  {
    med localmed = this.a.a();
    if (localmed != null) {
      localmed.b("onPauseVideo");
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    med localmed = this.a.a();
    if (localmed != null)
    {
      localmed.a("onConnected:" + paramInt);
      if (localmed.a != null) {
        localmed.a(localmed.a.b);
      }
    }
    this.a.a.a().postDelayed(new AVRedBag.2.1(this, paramInt), 1100L);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdx
 * JD-Core Version:    0.7.0.1
 */