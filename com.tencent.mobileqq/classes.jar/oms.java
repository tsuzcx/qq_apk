import com.tencent.biz.qqstory.utils.PollWidgetUtils.OnSelectedChangedListener;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetElement;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetWrapper;

public class oms
  implements PollWidgetUtils.OnSelectedChangedListener
{
  public oms(PollWidgetUtils.WidgetWrapper paramWidgetWrapper) {}
  
  public void a(PollWidgetUtils.WidgetElement paramWidgetElement, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      PollWidgetUtils.WidgetElement[] arrayOfWidgetElement = this.a.a();
      j = arrayOfWidgetElement.length;
      i = 0;
      while (i < j)
      {
        PollWidgetUtils.WidgetElement localWidgetElement = arrayOfWidgetElement[i];
        if (localWidgetElement != paramWidgetElement) {
          localWidgetElement.b(false);
        }
        i += 1;
      }
    }
    paramWidgetElement = this.a.a();
    int j = paramWidgetElement.length;
    for (;;)
    {
      if ((i >= j) || (paramWidgetElement[i].a())) {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oms
 * JD-Core Version:    0.7.0.1
 */