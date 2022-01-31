import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class rtn
  implements ActionSheet.OnButtonClickListener
{
  public rtn(BaseChatPie paramBaseChatPie, ChatMessage paramChatMessage, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop != 3000) {
        break label41;
      }
      FileManagerReporter.a("0X8005E4F");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      label41:
      FileManagerReporter.a("0X8005E4D");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rtn
 * JD-Core Version:    0.7.0.1
 */