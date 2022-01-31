import android.os.Handler.Callback;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class sao
  implements Handler.Callback
{
  public sao(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          this.a.g(paramMessage);
          return true;
          this.a.a(paramMessage);
          return true;
          this.a.f(paramMessage);
          return true;
          this.a.e(paramMessage);
          return true;
          this.a.b(paramMessage);
          return true;
          this.a.d(paramMessage);
          return true;
          this.a.c(paramMessage);
          return true;
          ChatHistoryForC2C.a(this.a);
          return true;
          if (QLog.isColorLevel()) {
            QLog.d("ChatHistoryForC2C", 2, "handle_get_roam_msg_auth_mode notify UI");
          }
          if (this.a.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.e())
          {
            this.a.a(false);
            return true;
          }
          this.a.g();
          return true;
        } while (paramMessage.obj == null);
        localObject = this.a;
        BaseApplication localBaseApplication = this.a.app.getApp();
        if (((Boolean)paramMessage.obj).booleanValue() == true) {}
        for (i = 2131433706;; i = 2131433707)
        {
          ((ChatHistoryForC2C)localObject).a(localBaseApplication.getString(i));
          return true;
        }
      } while ((this.a.jdField_a_of_type_AndroidWidgetTextView != null) || (!(paramMessage.obj instanceof RelativeLayout)));
      paramMessage = (RelativeLayout)paramMessage.obj;
      this.a.jdField_a_of_type_AndroidWidgetTextView = new TextView(this.a.app.getApp());
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.app.getApp().getString(2131433696));
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130842468);
      int i = AIOUtils.a(10.0F, this.a.getResources());
      int j = AIOUtils.a(13.0F, this.a.getResources());
      this.a.jdField_a_of_type_AndroidWidgetTextView.setPadding(i, j, i, i);
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131363244);
      ((RelativeLayout.LayoutParams)localObject).addRule(11);
      ((RelativeLayout.LayoutParams)localObject).addRule(15);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.a(12.0F, this.a.getResources());
      paramMessage.addView(this.a.jdField_a_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.a);
      ReportController.b(this.a.app, "CliOper", "", "", "c2c_msg_roam", "0X8007AB4", 0, 0, this.a.b, "", "", "");
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar == null);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sao
 * JD-Core Version:    0.7.0.1
 */