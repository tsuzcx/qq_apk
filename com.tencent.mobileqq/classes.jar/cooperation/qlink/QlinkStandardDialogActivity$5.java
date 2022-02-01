package cooperation.qlink;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

class QlinkStandardDialogActivity$5
  implements DialogInterface.OnClickListener
{
  QlinkStandardDialogActivity$5(QlinkStandardDialogActivity paramQlinkStandardDialogActivity, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a)
    {
      if (this.b) {
        FileManagerUtil.a(this.c, null, 777, false, 0);
      } else {
        FileManagerUtil.a(this.c, null, 888, false, 0);
      }
    }
    else
    {
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("from", "qlink");
      RouteUtils.a(this.c, paramDialogInterface, "/qrscan/scanner");
    }
    this.c.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qlink.QlinkStandardDialogActivity.5
 * JD-Core Version:    0.7.0.1
 */