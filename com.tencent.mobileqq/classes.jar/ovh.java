import com.tencent.biz.qqstory.view.widget.AbsEmptyView;

public class ovh
  implements Runnable
{
  public ovh(AbsEmptyView paramAbsEmptyView) {}
  
  public void run()
  {
    if (AbsEmptyView.a(this.a) == 0) {
      AbsEmptyView.a(this.a, 3, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ovh
 * JD-Core Version:    0.7.0.1
 */