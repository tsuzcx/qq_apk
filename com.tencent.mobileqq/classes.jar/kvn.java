import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class kvn
  implements View.OnClickListener
{
  public kvn(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131364833: 
    case 2131365592: 
    case 2131365595: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              PublicAccountAdvertisementActivity.a(this.a);
              PublicAccountAdvertisementActivity.c(this.a);
              PublicAccountAdvertisementActivity.b(this.a);
              AdvertisementRecentUserManager.a().a(this.a.getAppInterface(), 4, PublicAccountAdvertisementActivity.a(this.a));
              PublicAccountAdvertisementActivity.a(this.a).setVisibility(8);
              this.a.finish();
              return;
            } while ((!PublicAccountAdvertisementActivity.c(this.a)) || (PublicAccountAdvertisementActivity.a(this.a) == null));
            PublicAccountAdvertisementActivity.a(this.a).setCurrentPage(1);
            PublicAccountAdvertisementActivity.b(this.a, 1);
            return;
            paramView = PublicAccountAdvertisementActivity.a(this.a).a;
            if (paramView == null) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PublicAccountAdvertisementActivity", 2, "videoDownloadItem jumpType = " + paramView.jdField_b_of_type_Int);
            }
            if (paramView.jdField_b_of_type_Int == 1)
            {
              PublicAccountAdvertisementActivity.d(this.a);
              return;
            }
          } while (paramView.jdField_b_of_type_Int != 2);
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountAdvertisementActivity", 2, "videoDownloadItem jumpUrl = " + paramView.jdField_b_of_type_Int);
          }
        } while ((paramView.e == null) || (TextUtils.isEmpty(paramView.e)));
        this.a.a(paramView.e);
        ReportController.b(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a).a.a, "0X8008F74", "0X8008F74", 0, 0, PublicAccountAdvertisementActivity.a(this.a), "", "", PublicAccountAdvertisementActivity.a(this.a).a.jdField_b_of_type_JavaLangString);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PublicAccountAdvertisementActivity", 2, "videoDownloadItem is null");
      return;
    }
    ReportController.b(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a).a.a, "0X80090FB", "0X80090FB", 0, 0, PublicAccountAdvertisementActivity.a(this.a).a.c, "", "", PublicAccountAdvertisementActivity.a(this.a).a.jdField_b_of_type_JavaLangString);
    paramView = new kvo(this);
    if ((PublicAccountAdvertisementActivity.a(this.a) != null) && (PublicAccountAdvertisementActivity.a(this.a).isShowing())) {
      PublicAccountAdvertisementActivity.a(this.a).dismiss();
    }
    PublicAccountAdvertisementActivity.a(this.a, ActionSheet.d(this.a));
    PublicAccountAdvertisementActivity.a(this.a).b(2131439226);
    PublicAccountAdvertisementActivity.a(this.a).c(2131433029);
    PublicAccountAdvertisementActivity.a(this.a).setOnDismissListener(paramView);
    PublicAccountAdvertisementActivity.a(this.a).a(new kvp(this));
    PublicAccountAdvertisementActivity.a(this.a).a(new kvq(this));
    PublicAccountAdvertisementActivity.a(this.a).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kvn
 * JD-Core Version:    0.7.0.1
 */