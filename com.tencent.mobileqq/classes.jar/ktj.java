import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

class ktj
  implements View.OnClickListener
{
  ktj(ktg paramktg) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "action cancel");
    }
    ReportController.b(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a.a).a.a, "0X80090FD", "0X80090FD", 0, 0, PublicAccountAdvertisementActivity.a(this.a.a).a.c, "", "", "");
    if ((PublicAccountAdvertisementActivity.a(this.a.a) != null) && (PublicAccountAdvertisementActivity.a(this.a.a).isShowing())) {
      PublicAccountAdvertisementActivity.a(this.a.a).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ktj
 * JD-Core Version:    0.7.0.1
 */