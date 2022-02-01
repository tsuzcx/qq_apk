import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class sqp
  implements AbsListView.OnScrollListener
{
  public sqp(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      this.a.e = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sqp
 * JD-Core Version:    0.7.0.1
 */