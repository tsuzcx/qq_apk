import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils.5.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public final class rtm
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      ThreadManager.executeOnSubThread(new RIJUgcUtils.5.1(this));
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("RIJUGC.RIJUgcUtils", 1, "showCantUploadTips error", paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rtm
 * JD-Core Version:    0.7.0.1
 */