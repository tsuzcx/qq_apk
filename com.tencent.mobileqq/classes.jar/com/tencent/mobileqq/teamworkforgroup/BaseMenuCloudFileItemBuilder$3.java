package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class BaseMenuCloudFileItemBuilder$3
  implements ActionSheet.OnButtonClickListener
{
  BaseMenuCloudFileItemBuilder$3(BaseMenuCloudFileItemBuilder paramBaseMenuCloudFileItemBuilder, List paramList, ICloudFile paramICloudFile, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      paramView = (MenuItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (BaseMenuCloudFileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupBaseMenuCloudFileItemBuilder) != null) {
        BaseMenuCloudFileItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupBaseMenuCloudFileItemBuilder).a(paramView.b(), this.jdField_a_of_type_ComTencentMobileqqTeamworkforgroupICloudFile);
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.BaseMenuCloudFileItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */