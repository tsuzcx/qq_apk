import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;

public class mmm
  implements DialogInterface.OnClickListener
{
  public mmm(VideoInviteActivity paramVideoInviteActivity, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.isFinishing()) {}
    while (((Build.VERSION.SDK_INT >= 17) && (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.isDestroyed())) || (paramInt == 1)) {
      return;
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, true, new mmn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mmm
 * JD-Core Version:    0.7.0.1
 */