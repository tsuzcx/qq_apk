import com.tencent.gdtad.views.canvas.framework.GdtCanvasScrollView;

public class qqw
  implements Runnable
{
  public qqw(GdtCanvasScrollView paramGdtCanvasScrollView) {}
  
  public void run()
  {
    if (GdtCanvasScrollView.a(this.a) != this.a.getScrollY())
    {
      GdtCanvasScrollView.a(this.a, this.a.getScrollY());
      this.a.postDelayed(GdtCanvasScrollView.a(this.a), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     qqw
 * JD-Core Version:    0.7.0.1
 */