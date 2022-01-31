import com.tencent.biz.qqstory.view.widget.AbsEmptyView;

public class oqs
  implements Runnable
{
  public oqs(AbsEmptyView paramAbsEmptyView) {}
  
  public void run()
  {
    if (AbsEmptyView.a(this.a) == 0) {
      AbsEmptyView.a(this.a, 3, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqs
 * JD-Core Version:    0.7.0.1
 */