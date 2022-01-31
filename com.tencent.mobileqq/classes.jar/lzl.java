import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;

public class lzl
  implements DialogInterface.OnClickListener
{
  public lzl(VideoInviteActivity paramVideoInviteActivity, long paramLong, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.isFinishing()) {}
    while ((Build.VERSION.SDK_INT >= 17) && (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.isDestroyed())) {
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.c(this.jdField_a_of_type_Long);
      return;
    }
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity, this.jdField_a_of_type_Boolean, new lzm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lzl
 * JD-Core Version:    0.7.0.1
 */