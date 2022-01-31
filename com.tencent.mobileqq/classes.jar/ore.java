import com.tencent.biz.qqstory.view.widget.RateWidget;

public class ore
  implements Runnable
{
  public ore(RateWidget paramRateWidget) {}
  
  public void run()
  {
    RateWidget localRateWidget = this.a;
    if (!RateWidget.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      RateWidget.a(localRateWidget, bool);
      this.a.c(RateWidget.a(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ore
 * JD-Core Version:    0.7.0.1
 */