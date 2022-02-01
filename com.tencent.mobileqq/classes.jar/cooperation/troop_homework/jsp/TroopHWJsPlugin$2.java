package cooperation.troop_homework.jsp;

import android.view.View;
import com.tencent.mobileqq.webview.swift.WebViewUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopHWJsPlugin$2
  implements ActionSheet.OnButtonClickListener
{
  TroopHWJsPlugin$2(TroopHWJsPlugin paramTroopHWJsPlugin, int paramInt, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin.a(this.jdField_a_of_type_Int);
      }
    }
    else {
      TroopHWJsPlugin.a(this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin, (WebViewUtil.a("homework") << 8) + 2);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */