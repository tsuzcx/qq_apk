import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;

public class mkr
  implements DialogInterface.OnClickListener
{
  public mkr(VideoInviteActivity paramVideoInviteActivity, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.isFinishing()) {}
    while (((Build.VERSION.SDK_INT >= 17) && (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.isDestroyed())) || (paramInt == 1)) {
      return;
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, true, new mks(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mkr
 * JD-Core Version:    0.7.0.1
 */