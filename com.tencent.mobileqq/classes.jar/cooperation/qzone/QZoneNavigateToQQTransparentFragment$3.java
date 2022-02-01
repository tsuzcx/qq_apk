package cooperation.qzone;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qqexpand.utils.ICampusHelper;
import com.tencent.mobileqq.qroute.QRoute;

final class QZoneNavigateToQQTransparentFragment$3
  implements DialogInterface.OnClickListener
{
  QZoneNavigateToQQTransparentFragment$3(boolean paramBoolean, BaseActivity paramBaseActivity, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.val$hasWriteSchoolName) {
      ((ICampusHelper)QRoute.api(ICampusHelper.class)).jumpToSchoolCertificateWebPage(this.val$activity, this.val$idx, this.val$schoolName, this.val$schoolID);
    } else {
      ((ICampusHelper)QRoute.api(ICampusHelper.class)).jumpToSchoolFillInWebPage(this.val$activity, this.val$schoolName);
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneNavigateToQQTransparentFragment.3
 * JD-Core Version:    0.7.0.1
 */