package cooperation.qzone;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;

final class QZoneNavigateToQQTransparentFragment$3
  implements DialogInterface.OnClickListener
{
  QZoneNavigateToQQTransparentFragment$3(boolean paramBoolean, FragmentActivity paramFragmentActivity, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.val$hasWriteSchoolName) {
      CampusHelper.a(this.val$activity, this.val$idx, this.val$schoolName, this.val$schoolID);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      CampusHelper.a(this.val$activity, this.val$schoolName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QZoneNavigateToQQTransparentFragment.3
 * JD-Core Version:    0.7.0.1
 */