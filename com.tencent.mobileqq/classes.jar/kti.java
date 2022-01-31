import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.mobileqq.imaxad.ImaxAdNetPresenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class kti
  implements ActionSheet.OnButtonClickListener
{
  kti(ktg paramktg) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    PublicAccountAdvertisementActivity.a(this.a.a).dismiss();
    if (paramView != null)
    {
      paramView = PublicAccountAdvertisementActivity.a(this.a.a).a(paramInt);
      if (!TextUtils.isEmpty(paramView))
      {
        if (QLog.isColorLevel()) {
          QLog.i("PublicAccountAdvertisementActivity", 2, "action" + paramView);
        }
        ImaxAdNetPresenter.a().a(PublicAccountAdvertisementActivity.a(this.a.a), 3);
        ReportController.b(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a.a).a.a, "0X80090FC", "0X80090FC", 0, 0, PublicAccountAdvertisementActivity.a(this.a.a).a.c, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kti
 * JD-Core Version:    0.7.0.1
 */