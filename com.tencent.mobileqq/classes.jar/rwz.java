import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter;
import com.tencent.mobileqq.activity.ImageViewParameter;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.open.adapter.OpenAppClient;
import mqq.manager.TicketManager;

public class rwz
  implements View.OnClickListener
{
  public rwz(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt, ImageViewParameter paramImageViewParameter, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Int == -3000) && ((this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.istroop == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.istroop == 10002)))
    {
      paramView = PkgTools.a(this.jdField_a_of_type_JavaLangString);
      paramView = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, paramView);
      if (paramView != null) {
        paramView.b();
      }
      return;
    }
    if ((this.jdField_a_of_type_Int == -3000) || (this.jdField_a_of_type_Int == -3004) || (this.jdField_a_of_type_Int == -30002) || (this.jdField_a_of_type_Int == -30003))
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.action, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.shareAppID, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.msgtype);
      return;
    }
    if (this.jdField_a_of_type_Int == -3005)
    {
      ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.action, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.shareAppID, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a.msgtype);
      return;
    }
    if (this.jdField_a_of_type_Int == -3001)
    {
      paramView = new Bundle();
      paramView.putString("schemaurl", this.jdField_a_of_type_JavaLangString);
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app.getCurrentAccountUin();
      paramView.putString("uin", str);
      paramView.putString("vkey", ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.app.getManager(2)).getSkey(str));
      OpenAppClient.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a, paramView);
      return;
    }
    PicItemBuilder.a(paramView.getContext(), paramView, this.jdField_a_of_type_ComTencentMobileqqActivityImageViewParameter.a, this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.a.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwz
 * JD-Core Version:    0.7.0.1
 */