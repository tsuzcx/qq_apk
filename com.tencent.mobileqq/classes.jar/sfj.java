import android.view.View;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class sfj
  implements ActionSheet.OnButtonClickListener
{
  public sfj(ChatHistoryForC2C paramChatHistoryForC2C, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C, 230);
    localQQCustomDialog.setTitle("温馨提示");
    if (paramInt == 0) {}
    for (paramView = "删除本地的聊天记录和对应的云端聊天记录，无法恢复";; paramView = "删除本地聊天记录，再次进入聊天记录可从云端重新获取聊天记录")
    {
      localQQCustomDialog.setMessage(paramView);
      localQQCustomDialog.setNegativeButton(2131433029, new sfk(this));
      localQQCustomDialog.setPositiveButton(2131433030, new sfl(this, paramInt));
      localQQCustomDialog.show();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfj
 * JD-Core Version:    0.7.0.1
 */