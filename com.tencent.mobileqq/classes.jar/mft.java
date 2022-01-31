import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

public class mft
  implements DialogInterface.OnShowListener
{
  public mft(VideoShareHelper paramVideoShareHelper) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "mDisLikeActionSheet onShow() on VideoChannel");
    }
    VideoShareHelper.b(this.a).getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mft
 * JD-Core Version:    0.7.0.1
 */