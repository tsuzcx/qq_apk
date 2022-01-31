import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.ChatMessage;

public class rre
  implements DialogInterface.OnClickListener
{
  public rre(BaseChatPie paramBaseChatPie, ChatMessage paramChatMessage) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rre
 * JD-Core Version:    0.7.0.1
 */