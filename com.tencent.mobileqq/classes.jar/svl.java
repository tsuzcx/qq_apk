import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;

class svl
  implements DialogInterface.OnShowListener
{
  svl(svh paramsvh) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "mDisLikeActionSheet onShow() on VideoChannel");
    }
    suw.a(this.a.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svl
 * JD-Core Version:    0.7.0.1
 */