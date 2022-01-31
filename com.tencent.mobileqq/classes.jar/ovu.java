import com.tencent.biz.qqstory.view.widget.RateWidget;

public class ovu
  implements Runnable
{
  public ovu(RateWidget paramRateWidget) {}
  
  public void run()
  {
    if (RateWidget.a(this.a))
    {
      RateWidget.a(this.a, false);
      this.a.c(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovu
 * JD-Core Version:    0.7.0.1
 */