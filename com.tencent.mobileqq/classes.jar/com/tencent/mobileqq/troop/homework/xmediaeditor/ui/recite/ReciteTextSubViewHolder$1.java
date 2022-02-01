package com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite;

import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class ReciteTextSubViewHolder$1
  implements ActionSheet.OnButtonClickListener
{
  ReciteTextSubViewHolder$1(ReciteTextSubViewHolder paramReciteTextSubViewHolder, ActionSheet paramActionSheet, boolean paramBoolean, HWReciteInfo paramHWReciteInfo) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    int i = paramInt;
    if (!this.jdField_a_of_type_Boolean) {
      i = paramInt + 1;
    }
    switch (i)
    {
    default: 
      paramView = "";
    }
    for (;;)
    {
      TroopReportor.a("Grp_edu", "Grp_recite", "Blueword_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.f, paramView });
      return;
      SelectReciteParagraphFragment.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.f, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_JavaLangString, new ArrayList(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.jdField_a_of_type_JavaUtilList), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.c);
      paramView = "2";
      continue;
      SearchReciteArticleFragment.a(paramView.getContext(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.f, "", this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.c);
      paramView = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.ReciteTextSubViewHolder.1
 * JD-Core Version:    0.7.0.1
 */