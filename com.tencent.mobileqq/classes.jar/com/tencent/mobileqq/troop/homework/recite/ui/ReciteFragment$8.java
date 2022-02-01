package com.tencent.mobileqq.troop.homework.recite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.recite.data.ArticleInfo;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.HWReciteInfo;
import com.tencent.mobileqq.util.TroopReportor;

class ReciteFragment$8
  implements DialogInterface.OnClickListener
{
  ReciteFragment$8(ReciteFragment paramReciteFragment, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.a(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.c();
    QQAppInterface localQQAppInterface;
    String str1;
    String str2;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.f;
      str2 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelHWReciteInfo.f;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo == null) {
        break label108;
      }
    }
    label108:
    for (paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteDataArticleInfo.title;; paramDialogInterface = "")
    {
      TroopReportor.a(localQQAppInterface, str1, "Grp_recite", "Out_Recite_Clk", 0, 0, new String[] { str2, "", paramDialogInterface, "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment.8
 * JD-Core Version:    0.7.0.1
 */