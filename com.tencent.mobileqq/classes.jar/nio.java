import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;

public class nio
  implements View.OnClickListener
{
  public nio(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131378934: 
    case 2131378954: 
      do
      {
        return;
        PublicAccountAdvertisementActivity.a(this.a);
        PublicAccountAdvertisementActivity.c(this.a);
        PublicAccountAdvertisementActivity.b(this.a);
        nje.a().a(this.a.getAppInterface(), 4, PublicAccountAdvertisementActivity.a(this.a));
        PublicAccountAdvertisementActivity.a(this.a).setVisibility(8);
        this.a.finish();
        return;
      } while ((!PublicAccountAdvertisementActivity.c(this.a)) || (PublicAccountAdvertisementActivity.a(this.a) == null));
      PublicAccountAdvertisementActivity.a(this.a).setCurrentPage(1);
      PublicAccountAdvertisementActivity.b(this.a, 1);
      return;
    case 2131378947: 
      this.a.b();
      return;
    case 2131362044: 
      axqw.b(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a).a.a, "0X8009032", "0X8009032", 0, 0, PublicAccountAdvertisementActivity.a(this.a).a.c, "", "", PublicAccountAdvertisementActivity.a(this.a).a.b);
      PublicAccountAdvertisementActivity.d(this.a);
      return;
    case 2131370413: 
      PublicAccountAdvertisementActivity.a(this.a, 2);
      return;
    }
    PublicAccountAdvertisementActivity.a(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nio
 * JD-Core Version:    0.7.0.1
 */