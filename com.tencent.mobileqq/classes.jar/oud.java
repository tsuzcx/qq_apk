import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class oud
  implements AbsListView.OnScrollListener
{
  oud(ouc paramouc) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null)
    {
      paramInt1 = ouc.a(this.a, paramInt1);
      this.a.a.onScroll(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oud
 * JD-Core Version:    0.7.0.1
 */