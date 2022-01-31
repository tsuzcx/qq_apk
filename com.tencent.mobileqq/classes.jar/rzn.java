import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.activity.ChatHistory.Holder;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;

public class rzn
  implements Runnable
{
  public rzn(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, String paramString, ChatHistory.Holder paramHolder, TextView paramTextView) {}
  
  public void run()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a, MsgUtils.a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$Holder.b.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$Holder.jdField_a_of_type_JavaLangString = str;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.runOnUiThread(new rzo(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rzn
 * JD-Core Version:    0.7.0.1
 */