import android.content.res.Configuration;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import java.util.List;

class ntd
  extends osp
{
  ntd(ntb paramntb) {}
  
  public void a(int paramInt)
  {
    if ((ntb.a(this.a) != null) && ((ntb.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ntb.a(this.a)).a(paramInt);
    }
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((ntb.a(this.a) != null) && ((ntb.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ntb.a(this.a)).a(paramInt, paramArticleInfo, paramString1, paramString2);
    }
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    if ((ntb.a(this.a) != null) && ((ntb.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ntb.a(this.a)).a(paramInt, paramList);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (ntb.a(this.a) != null)
    {
      ntb.a(this.a).d();
      ntb.a(this.a).e();
    }
    if ((ntb.a(this.a) != null) && ((ntb.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ntb.a(this.a)).a(paramConfiguration);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if ((ntb.a(this.a) != null) && ((ntb.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ntb.a(this.a)).a(paramTopBannerInfo);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ntb.a(this.a) != null) && ((ntb.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ntb.a(this.a)).a(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void ap_()
  {
    if ((ntb.a(this.a) != null) && ((ntb.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ntb.a(this.a)).q();
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((ntb.a(this.a) != null) && ((ntb.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ntb.a(this.a)).c(paramInt, paramList);
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((ntb.a(this.a) != null) && ((ntb.a(this.a) instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)ntb.a(this.a)).b(paramBoolean1, paramInt, paramList, paramBoolean2);
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((ntb.a(this.a) != null) && ((ntb.a(this.a) instanceof ReadInJoyListViewGroup)))
    {
      ((ReadInJoyListViewGroup)ntb.a(this.a)).b(paramInt, paramList);
      ntb.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntd
 * JD-Core Version:    0.7.0.1
 */