import android.graphics.Color;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class sae
  implements ActionSheet.OnButtonClickListener
{
  public sae(ChatSettingForTroop paramChatSettingForTroop, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    switch (paramInt)
    {
    default: 
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ArrayOfAndroidViewView[28];
    if (paramView != null)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131363360);
      if (localTextView != null) {
        localTextView.setTextColor(Color.parseColor("#cccccc"));
      }
      paramView = (ProgressBar)paramView.findViewById(2131364769);
      if (paramView != null) {
        paramView.setVisibility(0);
      }
    }
    ThreadManager.post(new sce(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop), 5, null, false);
    TroopReportor.a("Grp_set_new", "grpData_admin", "confirm_delRecord", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sae
 * JD-Core Version:    0.7.0.1
 */