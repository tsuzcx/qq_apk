import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.messagesearch.MessageSearchDialog;
import com.tencent.qphone.base.util.QLog;

public class rwl
  implements DialogInterface.OnDismissListener
{
  public rwl(ChatHistory paramChatHistory, View paramView1, int paramInt, View paramView2, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.b.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    paramDialogInterface = (MessageSearchDialog)paramDialogInterface;
    int i = paramDialogInterface.a() + this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.l;
    boolean bool = paramDialogInterface.a();
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistory", 2, "onDismiss, recordCount : " + i);
    }
    if (i <= 0) {}
    int j;
    do
    {
      return;
      j = (i - 1) / 8 + 1;
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistory", 2, "onDismiss, pageIndex = " + j);
      }
    } while (j < 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_ComTencentMobileqqActivityChatHistory$ChatHistoryAdapter.c = ((i - 1) % 8);
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.setText(String.valueOf(j));
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.leftView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getString(2131433681));
      return;
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.getIntent().getExtras().getString("leftViewText");
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistory.leftView.setText(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwl
 * JD-Core Version:    0.7.0.1
 */