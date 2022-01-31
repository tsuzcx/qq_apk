import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class rut
  implements ActionSheet.OnButtonClickListener
{
  rut(rus paramrus) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (ChatActivityFacade.a != null) {
        ChatActivityFacade.a.dismiss();
      }
      return;
      ChatActivityFacade.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((((this.a.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null))
      {
        ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForArkApp)) {
          ArkTipsManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopTopic)) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "obj", "del_obj", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + "", "", "", "");
        }
        if (((StructLongMessageDownloadProcessor.b(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (StructLongMessageDownloadProcessor.d(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
        {
          paramView = (MessageForStructing)this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          StructLongMessageDownloadProcessor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uniseq);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForApollo))
        {
          paramView = (MessageForApollo)this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if (paramView != null)
          {
            SpriteCommFunc.a(paramView.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "del_msg");
            if ((paramView.mApolloMessage != null) && ((this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
            {
              BaseChatPie localBaseChatPie = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
              if ((localBaseChatPie != null) && (localBaseChatPie.a != null)) {
                VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "del_success", ApolloUtil.b(localBaseChatPie.a.a), 0, new String[] { Integer.toString(paramView.mApolloMessage.id) });
              }
            }
          }
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForFile))
        {
          paramView = FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.nSessionId);
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
        }
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isDebugVersion()) {
          QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + paramView + "],targetId[" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgUid + "], hashCode:" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.hashCode());
        }
        if (TextUtils.isEmpty(paramView)) {}
      }
      try
      {
        long l = Long.parseLong(paramView);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, l, true);
        ((VasExtensionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        continue;
        ThreadManager.post(new ruu(this), 8, null, true);
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
          QLog.e("ChatActivityFacade", 1, paramView.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rut
 * JD-Core Version:    0.7.0.1
 */