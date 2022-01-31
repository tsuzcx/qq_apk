import com.tencent.biz.qqstory.utils.PollWidgetUtils.QuestionElement;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetWrapper;

public class omu
  implements Runnable
{
  public omu(PollWidgetUtils.WidgetWrapper paramWidgetWrapper) {}
  
  public void run()
  {
    if (PollWidgetUtils.WidgetWrapper.a(this.a))
    {
      PollWidgetUtils.WidgetWrapper.a(this.a, false);
      this.a.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omu
 * JD-Core Version:    0.7.0.1
 */