import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StrangerHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class rwb
  implements ActionSheet.OnButtonClickListener
{
  rwb(rwa paramrwa, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    do
    {
      for (;;)
      {
        return;
        ReportController.b(this.jdField_a_of_type_Rwa.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_Rwa.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "Manage_stranger", "Manage_str_delete", 0, 0, "", "", "", "");
        paramView = (StrangerHandler)this.jdField_a_of_type_Rwa.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(26);
        ArrayList localArrayList = new ArrayList();
        try
        {
          localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_Rwa.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
          paramView.a(localArrayList);
          if (this.jdField_a_of_type_Rwa.a.c == null) {
            this.jdField_a_of_type_Rwa.a.c = new QQProgressDialog(this.jdField_a_of_type_Rwa.a.jdField_a_of_type_AndroidContentContext, 0);
          }
          this.jdField_a_of_type_Rwa.a.c.show();
        }
        catch (NumberFormatException paramView) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.aio.BaseChatPie", 2, "delete Stranger parseLong() error", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwb
 * JD-Core Version:    0.7.0.1
 */