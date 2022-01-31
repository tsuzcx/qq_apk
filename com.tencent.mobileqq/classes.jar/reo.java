import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyProteusFamilyListViewGroup;
import com.tencent.widget.AbsListView;

public class reo
  implements bfos
{
  public reo(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a(new req(this, "onListViewScroll", paramAbsListView, paramInt1, paramInt2, paramInt3));
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.a.a(new rep(this, "onScrollStateChanged", paramAbsListView, paramInt));
    if ((onh.a()) && (paramInt != 0)) {
      zzz.a().a("proteus_family_feeds");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     reo
 * JD-Core Version:    0.7.0.1
 */