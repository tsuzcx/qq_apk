import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import java.util.List;

class ojn
  extends pkt
{
  ojn(ojm paramojm) {}
  
  public void a(int paramInt)
  {
    if ((ojm.a(this.a) != null) && ((ojm.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ojm.a(this.a)).a(paramInt);
    }
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    if ((ojm.a(this.a) != null) && ((ojm.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ojm.a(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if ((ojm.a(this.a) != null) && ((ojm.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ojm.a(this.a)).a(paramTopBannerInfo);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ojm.a(this.a) != null) && ((ojm.a(this.a) instanceof ReadInJoyListViewGroup)) && (paramInt == ojm.a(this.a)))
    {
      ((ReadInJoyListViewGroup)ojm.a(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
      ojm.a(this.a);
    }
  }
  
  public void ah_()
  {
    if ((ojm.a(this.a) != null) && ((ojm.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ojm.a(this.a)).m();
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((ojm.a(this.a) != null) && ((ojm.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ojm.a(this.a)).c(paramInt, paramList);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ojm.a(this.a) != null) && ((ojm.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ojm.a(this.a)).b(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((ojm.a(this.a) != null) && ((ojm.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ojm.a(this.a)).b(paramInt, paramList);
    }
  }
  
  public void d(int paramInt, List<oqd> paramList)
  {
    if ((ojm.a(this.a) instanceof ReadInJoyListViewGroup))
    {
      prz localprz = (prz)((ReadInJoyListViewGroup)ojm.a(this.a)).a().a(2);
      if (localprz != null) {
        localprz.b(paramInt, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ojn
 * JD-Core Version:    0.7.0.1
 */