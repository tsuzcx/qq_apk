import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup;
import com.tencent.widget.AbsListView;

public class sjk
  implements blih
{
  public sjk(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a(new sjm(this, "onListViewScroll", paramAbsListView, paramInt1, paramInt2, paramInt3));
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.a.a(new sjl(this, "onScrollStateChanged", paramAbsListView, paramInt));
    if ((ozs.a()) && (paramInt != 0)) {
      adlb.a().a("proteus_family_feeds");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjk
 * JD-Core Version:    0.7.0.1
 */