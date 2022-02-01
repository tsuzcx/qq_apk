import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class tbb
  implements AbsListView.OnScrollListener
{
  public tbb(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.a.a.a(paramAbsListView, paramInt);
    if ((pnn.a()) && (paramInt != 0)) {
      DropFrameMonitor.getInstance().startMonitorScene("proteus_family_feeds");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbb
 * JD-Core Version:    0.7.0.1
 */