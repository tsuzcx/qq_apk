import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtViewStatus.Listener;
import com.tencent.gdtad.views.freeflip.GdtFreeFlipView;

public class qkc
  implements GdtViewStatus.Listener
{
  public qkc(GdtFreeFlipView paramGdtFreeFlipView) {}
  
  public void a()
  {
    GdtLog.b("GdtFreeFlipView", "onViewResume");
    GdtFreeFlipView.a(this.a);
  }
  
  public void b()
  {
    GdtLog.b("GdtFreeFlipView", "onViewPause");
    GdtFreeFlipView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     qkc
 * JD-Core Version:    0.7.0.1
 */