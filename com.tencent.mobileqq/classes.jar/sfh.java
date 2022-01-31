import android.os.Handler;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

public class sfh
  implements ActionSheet.OnButtonClickListener
{
  public sfh(ChatHistoryForC2C paramChatHistoryForC2C, MessageRecord paramMessageRecord, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.b = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramView, 800L);
      Utils.executeAsyncTaskOnThreadPool(new sfi(this), new MessageRecord[] { this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord });
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app, "chat_history", "ChatHistory", "Clk_deleteOne", 1, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfh
 * JD-Core Version:    0.7.0.1
 */