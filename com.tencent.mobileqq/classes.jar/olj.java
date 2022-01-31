import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.biz.qqstory.takevideo.EditVideoSyncStoryGuide;
import com.tencent.biz.qqstory.takevideo.EditVideoUi;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;

public class olj
  implements DialogInterface.OnDismissListener
{
  public olj(EditVideoSyncStoryGuide paramEditVideoSyncStoryGuide) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "showSyncStoryGuide ->onDismiss-------");
    }
    SharedPreUtils.b(this.a.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olj
 * JD-Core Version:    0.7.0.1
 */