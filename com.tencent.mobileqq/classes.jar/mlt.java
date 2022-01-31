import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class mlt
  implements AbsListView.OnScrollListener
{
  public mlt(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (ReadInJoyListViewGroup.a(this.a) == null) {
      return;
    }
    if (paramInt1 > 20)
    {
      ReadInJoyListViewGroup.a(this.a).setVisibility(0);
      return;
    }
    ReadInJoyListViewGroup.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlt
 * JD-Core Version:    0.7.0.1
 */