import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class oeh
  implements View.OnClickListener
{
  public oeh(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "action cancel");
    }
    bdla.a(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a).a.a, "0X80090FD", "0X80090FD", 0, 0, PublicAccountAdvertisementActivity.a(this.a).a.c, "", "", PublicAccountAdvertisementActivity.a(this.a).a.b);
    if ((PublicAccountAdvertisementActivity.a(this.a) != null) && (PublicAccountAdvertisementActivity.a(this.a).isShowing())) {
      PublicAccountAdvertisementActivity.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oeh
 * JD-Core Version:    0.7.0.1
 */