import com.tencent.biz.qqstory.utils.PollWidgetUtils.QuestionElement;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetWrapper;

public class omt
  implements Runnable
{
  public omt(PollWidgetUtils.WidgetWrapper paramWidgetWrapper) {}
  
  public void run()
  {
    PollWidgetUtils.WidgetWrapper localWidgetWrapper = this.a;
    if (!PollWidgetUtils.WidgetWrapper.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      PollWidgetUtils.WidgetWrapper.a(localWidgetWrapper, bool);
      this.a.a.a(PollWidgetUtils.WidgetWrapper.a(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     omt
 * JD-Core Version:    0.7.0.1
 */