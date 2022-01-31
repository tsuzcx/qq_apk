import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import java.util.List;
import mqq.os.MqqHandler;

public class ryo
  implements DialogInterface.OnClickListener
{
  public ryo(ChatHistory paramChatHistory, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a);
    if ((paramDialogInterface != null) && (!paramDialogInterface.isEmpty())) {
      if ((1 != this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a) && (3000 != this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a)) {}
    }
    for (long l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).shmsgseq;; l1 = 0L) {
      for (;;)
      {
        ThreadManager.getSubThreadHandler().post(new ryp(this));
        this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().e(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a);
        SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app, "chat_history_confirm_del_msg");
        if (this.jdField_a_of_type_JavaLangString != null) {}
        try
        {
          l2 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a, l1);
          }
          paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.app.getHandler(Conversation.class);
          Message localMessage = paramDialogInterface.obtainMessage(1017);
          localMessage.obj = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_JavaLangString;
          localMessage.arg1 = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.a;
          paramDialogInterface.sendMessage(localMessage);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_b_of_type_AndroidAppDialog.dismiss();
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.setResult(-1);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.finish();
          return;
          if (((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).isSendFromLocal()) {
            l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).time + 2L;
          } else {
            l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).time;
          }
        }
        catch (Exception paramDialogInterface)
        {
          for (;;)
          {
            paramDialogInterface.printStackTrace();
            long l2 = 0L;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ryo
 * JD-Core Version:    0.7.0.1
 */