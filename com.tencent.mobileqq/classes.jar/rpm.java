import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class rpm
  implements View.OnClickListener
{
  public rpm(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          return;
          paramView = this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131362132);
        } while (!(paramView instanceof ReplyedMessageSpan));
        paramView = (ReplyedMessageSpan)paramView;
      } while ((paramView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
      if (QLog.isColorLevel()) {
        QLog.w("Q.aio.BaseChatPie", 2, "TextItemBuilder onClickListener: isReplyMsg = true, mSourceMsgSeq = " + paramView.a);
      }
      localBaseChatPie = this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment().a();
    } while (!localBaseChatPie.f());
    QQMessageFacade.Message localMessage = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localBaseChatPie.a(20, paramView.a, (int)(localMessage.shmsgseq - paramView.a), null);
    MessageForReplyText.reportReplyMsg(null, "typebox", "clk_original", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rpm
 * JD-Core Version:    0.7.0.1
 */