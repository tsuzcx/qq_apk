import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;

public class mki
  extends mct
{
  public mki(VideoControlUI paramVideoControlUI) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.a.h()) {}
    do
    {
      return;
      if (this.a.i()) {
        break;
      }
    } while (!paramBoolean);
    this.a.b.update(null, new Object[] { Integer.valueOf(110), Long.valueOf(paramLong) });
    this.a.a.a(paramLong, paramInt);
  }
  
  protected void g(long paramLong)
  {
    if (this.a.h()) {}
    while ((!this.a.i()) || (!this.a.a.b(0))) {
      return;
    }
    this.a.a.a(paramLong, 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mki
 * JD-Core Version:    0.7.0.1
 */