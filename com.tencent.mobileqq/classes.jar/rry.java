import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.text.SimpleDateFormat;
import java.util.List;

class rry
  implements ActionSheet.OnButtonClickListener
{
  rry(rrx paramrrx) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if ((ChatActivityFacade.b != null) && (ChatActivityFacade.b.isShowing())) {
        ChatActivityFacade.b.dismiss();
      }
      return;
    }
    if ((ChatActivityFacade.b != null) && (ChatActivityFacade.b.isShowing())) {
      ChatActivityFacade.b.dismiss();
    }
    paramInt = 0;
    Object localObject;
    for (;;)
    {
      if (paramInt < ChatActivityFacade.a.size())
      {
        paramView = (ChatMessage)ChatActivityFacade.a.get(paramInt);
        if ((paramView instanceof MessageForTroopTopic)) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "obj", "del_obj", 0, 0, paramView.frienduin + "", "", "", "");
        }
        if (paramView.msgtype == -2005)
        {
          localObject = FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)paramView);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((FileManagerEntity)localObject).nSessionId);
        }
        localObject = paramView.getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isDebugVersion()) {
          QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + (String)localObject + "],targetId[" + paramView.msgUid + "], hashCode:" + paramView.hashCode());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        try
        {
          long l = Long.parseLong((String)localObject);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramView.frienduin, paramView.istroop, l, true);
          paramInt += 1;
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
    if (BaseChatItemLayout.a)
    {
      paramView = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
      paramView.a(false, null, true);
      if (paramView.a.jdField_a_of_type_Int == 1008)
      {
        localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", paramView.a.jdField_a_of_type_JavaLangString, "0X80064FA", "0X80064FA", 0, 0, (String)localObject, "", "", "");
      }
    }
    if ((((this.a.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null))
    {
      if (ChatActivityFacade.a.size() == 1) {
        ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a().b((ChatMessage)ChatActivityFacade.a.get(0));
      }
      for (;;)
      {
        SpriteCommFunc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "del_multi_msg");
        return;
        ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a(ChatActivityFacade.a);
      }
    }
    paramInt = 0;
    while (paramInt < ChatActivityFacade.a.size())
    {
      ChatActivityFacade.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)ChatActivityFacade.a.get(paramInt));
      paramInt += 1;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(ChatActivityFacade.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rry
 * JD-Core Version:    0.7.0.1
 */