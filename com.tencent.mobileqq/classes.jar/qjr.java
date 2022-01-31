import com.tencent.gdtad.views.canvas.framework.GdtCanvasScrollView;

public class qjr
  implements Runnable
{
  public qjr(GdtCanvasScrollView paramGdtCanvasScrollView) {}
  
  public void run()
  {
    if (GdtCanvasScrollView.a(this.a) != this.a.getScrollY())
    {
      GdtCanvasScrollView.a(this.a, this.a.getScrollY());
      this.a.postDelayed(GdtCanvasScrollView.a(this.a), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     qjr
 * JD-Core Version:    0.7.0.1
 */