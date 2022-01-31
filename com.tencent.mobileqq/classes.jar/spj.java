import android.graphics.Color;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

public class spj
  implements ActionSheet.OnButtonClickListener
{
  public spj(DiscussionInfoCardActivity paramDiscussionInfoCardActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.a().a(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), 3000);
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.a().e(DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity), 3000);
      SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app, "chat_history_confirm_del_msg");
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.app.getHandler(Conversation.class);
      Message localMessage = paramView.obtainMessage(1017);
      localMessage.obj = DiscussionInfoCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity);
      localMessage.arg1 = 3000;
      paramView.sendMessage(localMessage);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity, 2, this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.getString(2131434501), 0).a();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a != null) {
        ((TextView)this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionInfoCardActivity.a.findViewById(2131363397)).setTextColor(Color.parseColor("#cccccc"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spj
 * JD-Core Version:    0.7.0.1
 */