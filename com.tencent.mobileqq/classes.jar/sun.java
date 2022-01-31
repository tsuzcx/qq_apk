import android.view.View;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Arrays;

class sun
  implements ActionSheet.OnButtonClickListener
{
  sun(suk paramsuk, int[] paramArrayOfInt, VideoActionSheet paramVideoActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_ArrayOfInt[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "videoActionSheet onClick,showItems =  " + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + ",which = " + paramInt + ",item = " + i);
    }
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    switch (i)
    {
    case 3: 
    default: 
    case 1: 
    case 4: 
      do
      {
        return;
        FriendProfileCardActivity.a(this.jdField_a_of_type_Suk.a.app, this.jdField_a_of_type_Suk.a, this.jdField_a_of_type_Suk.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
        ReportController.b(this.jdField_a_of_type_Suk.a.app, "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
        return;
        if ((this.jdField_a_of_type_Suk.a.l == 1) || (this.jdField_a_of_type_Suk.a.l == 2))
        {
          ChatActivityUtils.a(this.jdField_a_of_type_Suk.a.app, this.jdField_a_of_type_Suk.a, this.jdField_a_of_type_Suk.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, 1);
          ReportController.b(this.jdField_a_of_type_Suk.a.app, "CliOper", "", "", "0X8006406", "0X8006406", 9, 0, "", "", "", "");
          return;
        }
      } while (this.jdField_a_of_type_Suk.a.l != 5);
      PstnUtils.a(this.jdField_a_of_type_Suk.a.app, this.jdField_a_of_type_Suk.a, 1, 7);
      return;
    }
    paramView = new SessionInfo();
    paramView.jdField_a_of_type_Int = ProfileCardUtil.a(this.jdField_a_of_type_Suk.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a);
    paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Suk.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString;
    paramView.d = FriendProfileCardActivity.a(this.jdField_a_of_type_Suk.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, this.jdField_a_of_type_Suk.a.app);
    paramView.b = this.jdField_a_of_type_Suk.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.d;
    PlusPanelUtils.a(this.jdField_a_of_type_Suk.a.app, this.jdField_a_of_type_Suk.a, paramView, false, null, null);
    ReportController.b(this.jdField_a_of_type_Suk.a.app, "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sun
 * JD-Core Version:    0.7.0.1
 */