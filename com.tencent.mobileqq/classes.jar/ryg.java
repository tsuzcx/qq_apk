import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class ryg
  implements DialogInterface.OnDismissListener
{
  public ryg(ChatHistoryForC2C paramChatHistoryForC2C, View paramView1, int paramInt, View paramView2, TranslateAnimation paramTranslateAnimation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.jdField_a_of_type_Int);
    this.b.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.a.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    Object localObject = (C2CMessageSearchDialog)paramDialogInterface;
    boolean bool = ((C2CMessageSearchDialog)localObject).a();
    int i = ((C2CMessageSearchDialog)localObject).a();
    paramDialogInterface = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.app.getManager(91);
    if (QLog.isColorLevel()) {
      QLog.i("ChatHistoryForC2C", 2, "onDismiss, recordCount : " + i + ",showRoamFlag" + paramDialogInterface.d());
    }
    localObject = ((C2CMessageSearchDialog)localObject).a();
    if (localObject != null)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(((MessageRecord)localObject).time * 1000L);
      localCalendar1.set(11, 0);
      localCalendar1.set(12, 0);
      localCalendar1.set(13, 0);
      localCalendar1.set(14, 0);
      Calendar localCalendar2 = paramDialogInterface.c();
      if ((localCalendar2 != null) && (!localCalendar1.after(localCalendar2))) {
        break label251;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryForC2C", 2, "search message's date beyond the dateline, should rebuild the dateline");
      }
    }
    while (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.leftView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.getString(2131433681));
      return;
      label251:
      paramDialogInterface.a((MessageRecord)localObject);
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.getIntent().getExtras().getString("leftViewText");
    this.jdField_a_of_type_ComTencentMobileqqActivityChatHistoryForC2C.leftView.setText(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ryg
 * JD-Core Version:    0.7.0.1
 */