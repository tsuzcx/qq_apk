import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;

class sbx
  implements DialogInterface.OnShowListener
{
  sbx(sbt paramsbt) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "mDisLikeActionSheet onShow() on VideoChannel");
    }
    sbi.a(this.a.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbx
 * JD-Core Version:    0.7.0.1
 */