import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistoryFileActivity;
import com.tencent.mobileqq.activity.ChatHistoryStructMsgView;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter;
import com.tencent.mobileqq.adapter.ChatHistoryStructAdapter.HistoryStructItemHolder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;

public class sgj
  implements View.OnClickListener
{
  public sgj(ChatHistoryStructMsgView paramChatHistoryStructMsgView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String)) {
      return;
    }
    Object localObject1 = (ChatMessage)((ChatHistoryStructAdapter.HistoryStructItemHolder)paramView.getTag()).a;
    if (this.a.a()) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a((ChatMessage)localObject1)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.b((ChatMessage)localObject1);
      }
    }
    while ((!(localObject1 instanceof MessageForStructing)) || (((MessageForStructing)localObject1).structingMsg == null) || (!(((MessageForStructing)localObject1).structingMsg instanceof AbsShareMsg))) {
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAdapterChatHistoryStructAdapter.notifyDataSetChanged();
        return;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a()) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryFileActivity.a((ChatMessage)localObject1);
      }
    }
    localObject1 = (AbsShareMsg)((MessageForStructing)localObject1).structingMsg;
    Object localObject2;
    if ((localObject1 instanceof StructMsgForGeneralShare))
    {
      localObject2 = (StructMsgForGeneralShare)localObject1;
      StructMsgForGeneralShare.GeneralClickHandler localGeneralClickHandler = new StructMsgForGeneralShare.GeneralClickHandler(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView, (StructMsgForGeneralShare)localObject2);
      StructMsgForGeneralShare.onClickEvent(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, (StructMsgForGeneralShare)localObject2, paramView, localGeneralClickHandler);
    }
    for (;;)
    {
      ((AbsShareMsg)localObject1).getOnClickListener().onClick(paramView);
      break;
      if ((localObject1 instanceof StructMsgForAudioShare))
      {
        localObject2 = (StructMsgForAudioShare)localObject1;
        StructMsgForAudioShare.onClickEvent(this.a.jdField_a_of_type_AndroidContentContext, (StructMsgForAudioShare)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sgj
 * JD-Core Version:    0.7.0.1
 */