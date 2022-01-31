import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.widget.AbsListView;

public class qqm
  implements begh
{
  public qqm(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a(new qqo(this, "onListViewScroll", paramAbsListView, paramInt1, paramInt2, paramInt3));
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((ReadInJoyListViewGroup.a(this.a) != null) && (ReadInJoyListViewGroup.a(this.a).getVisibility() != 4)) {
      ReadInJoyListViewGroup.a(this.a).setVisibility(4);
    }
    this.a.a(new qqn(this, "onScrollStateChanged", paramAbsListView, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qqm
 * JD-Core Version:    0.7.0.1
 */