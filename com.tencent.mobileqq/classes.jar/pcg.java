import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class pcg
  implements AbsListView.OnScrollListener
{
  pcg(pcf parampcf) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null)
    {
      paramInt1 = pcf.a(this.a, paramInt1);
      this.a.a.onScroll(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pcg
 * JD-Core Version:    0.7.0.1
 */