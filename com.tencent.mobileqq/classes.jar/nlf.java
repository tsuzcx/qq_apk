import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.qphone.base.util.QLog;

public class nlf
  implements View.OnClickListener
{
  public nlf(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "action cancel");
    }
    azmj.a(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a).a.a, "0X80090FD", "0X80090FD", 0, 0, PublicAccountAdvertisementActivity.a(this.a).a.c, "", "", PublicAccountAdvertisementActivity.a(this.a).a.b);
    if ((PublicAccountAdvertisementActivity.a(this.a) != null) && (PublicAccountAdvertisementActivity.a(this.a).isShowing())) {
      PublicAccountAdvertisementActivity.a(this.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nlf
 * JD-Core Version:    0.7.0.1
 */