import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.DataReport;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;

public final class rwc
  implements DialogInterface.OnClickListener
{
  public rwc(ChatActivityUtils.StartVideoListener paramStartVideoListener, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener.a();
    }
    paramDialogInterface.dismiss();
    DataReport.b(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwc
 * JD-Core Version:    0.7.0.1
 */