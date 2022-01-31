import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.qphone.base.util.QLog;

public class mxk
  implements begw
{
  public mxk(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    PublicAccountAdvertisementActivity.a(this.a).dismiss();
    if (paramView != null)
    {
      paramView = PublicAccountAdvertisementActivity.a(this.a).a(paramInt);
      if (QLog.isColorLevel()) {
        QLog.i("PublicAccountAdvertisementActivity", 2, "action" + paramView);
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(this.a.getResources().getString(2131627103))) {
          break label91;
        }
        PublicAccountAdvertisementActivity.d(this.a);
      }
    }
    label91:
    while (!paramView.equals(this.a.getResources().getString(2131627727))) {
      return;
    }
    aqiw.a().a(PublicAccountAdvertisementActivity.a(this.a), null, 3, 2);
    awqx.a(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a).a.a, "0X80090FC", "0X80090FC", 0, 0, PublicAccountAdvertisementActivity.a(this.a).a.c, "", "", PublicAccountAdvertisementActivity.a(this.a).a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     mxk
 * JD-Core Version:    0.7.0.1
 */