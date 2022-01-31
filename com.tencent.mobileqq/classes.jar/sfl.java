import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.ChatHistoryAdapterForC2C;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import java.util.List;
import mqq.os.MqqHandler;

class sfl
  implements DialogInterface.OnClickListener
{
  sfl(sfj paramsfj, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new StringBuilder();
    Object localObject = (MessageRoamManager)this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.getManager(91);
    paramInt = ((MessageRoamManager)localObject).a(this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramDialogInterface);
    if ((paramDialogInterface != null) && (paramDialogInterface.length() > 0)) {}
    for (paramDialogInterface = paramDialogInterface.toString();; paramDialogInterface = null)
    {
      if (paramInt <= 0)
      {
        this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a(this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.getApp().getString(2131434500));
        return;
      }
      List localList = this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a().b(this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      long l1;
      if ((localList != null) && (!localList.isEmpty())) {
        if (((MessageRecord)localList.get(localList.size() - 1)).isSendFromLocal()) {
          l1 = ((MessageRecord)localList.get(localList.size() - 1)).time + 2L;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a().a(this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioChatHistoryAdapterForC2C.b(null);
        SpriteCommFunc.a(this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app, "chat_history_c2c_start_del_msg");
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.i();
          this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a().a(this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          ((MessageRoamManager)localObject).m();
          VipUtils.a(this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app, "chat_history", "ChatHistory", "Clk_deleteCloud", 1, 0, new String[] { this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_JavaLangString });
        }
        for (;;)
        {
          this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a().e(this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          long l2;
          if (paramDialogInterface != null) {
            l2 = 0L;
          }
          try
          {
            long l3 = Long.parseLong(paramDialogInterface);
            l2 = l3;
          }
          catch (Exception paramDialogInterface)
          {
            for (;;)
            {
              paramDialogInterface.printStackTrace();
            }
          }
          l1 = Math.max(l2, l1);
          if (l1 > 0L) {
            this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.a().a(this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l1);
          }
          ((MessageRoamManager)localObject).a().e();
          ((MessageRoamManager)localObject).b();
          if (this.jdField_a_of_type_Int == 0) {
            ((MessageRoamManager)localObject).m();
          }
          paramDialogInterface = this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.getHandler(Conversation.class);
          if (paramDialogInterface != null)
          {
            localObject = paramDialogInterface.obtainMessage(1017);
            ((Message)localObject).obj = this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
            ((Message)localObject).arg1 = this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
            paramDialogInterface.sendMessage((Message)localObject);
          }
          this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.setResult(-1);
          this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.finish();
          return;
          l1 = ((MessageRecord)localList.get(localList.size() - 1)).time;
          break;
          VipUtils.a(this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app, "chat_history", "ChatHistory", "Clk_deleteLocal", 1, 0, new String[] { this.jdField_a_of_type_Sfj.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.jdField_a_of_type_JavaLangString });
        }
        l1 = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfl
 * JD-Core Version:    0.7.0.1
 */