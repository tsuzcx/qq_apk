import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView.OnInterceptTouchListener;
import com.tencent.biz.pubaccount.CustomWebView;

public class kvs
  implements VerticalPagerView.OnInterceptTouchListener
{
  public kvs(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public boolean a(int paramInt)
  {
    return (PublicAccountAdvertisementActivity.d(this.a)) && (PublicAccountAdvertisementActivity.c(this.a));
  }
  
  public boolean b(int paramInt)
  {
    return (PublicAccountAdvertisementActivity.d(this.a)) && (!PublicAccountAdvertisementActivity.c(this.a)) && (PublicAccountAdvertisementActivity.a(this.a) != null) && (PublicAccountAdvertisementActivity.a(this.a).a() != null) && (PublicAccountAdvertisementActivity.a(this.a).a().getWebScrollY() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvs
 * JD-Core Version:    0.7.0.1
 */