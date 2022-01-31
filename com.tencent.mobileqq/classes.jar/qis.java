import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;

class qis
  implements DialogInterface.OnShowListener
{
  qis(qim paramqim) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "mDisLikeActionSheet onShow() on VideoChannel");
    }
    qim.a(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qis
 * JD-Core Version:    0.7.0.1
 */