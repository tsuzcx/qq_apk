import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class pef
  implements AbsListView.OnScrollListener
{
  pef(ped paramped) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    slt localslt = this.a.a().a();
    this.a.a().a().a(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition(), localslt);
    this.a.a().a().b(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition(), localslt);
    this.a.a().a().c(paramAbsListView.getFirstVisiblePosition(), paramAbsListView.getLastVisiblePosition(), localslt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pef
 * JD-Core Version:    0.7.0.1
 */