import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoControlUI;

public class mjs
  extends mck
{
  public mjs(VideoControlUI paramVideoControlUI) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.a.g()) {}
    do
    {
      return;
      if (this.a.h()) {
        break;
      }
    } while (!paramBoolean);
    this.a.b.update(null, new Object[] { Integer.valueOf(110), Long.valueOf(paramLong) });
    this.a.a.a(paramLong, paramInt);
  }
  
  protected void f(long paramLong)
  {
    if (this.a.g()) {}
    while ((!this.a.h()) || (!this.a.a.b(0))) {
      return;
    }
    this.a.a.a(paramLong, 0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mjs
 * JD-Core Version:    0.7.0.1
 */