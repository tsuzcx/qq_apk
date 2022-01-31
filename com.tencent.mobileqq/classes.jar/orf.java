import com.tencent.biz.qqstory.view.widget.RateWidget;

public class orf
  implements Runnable
{
  public orf(RateWidget paramRateWidget) {}
  
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
 * Qualified Name:     orf
 * JD-Core Version:    0.7.0.1
 */