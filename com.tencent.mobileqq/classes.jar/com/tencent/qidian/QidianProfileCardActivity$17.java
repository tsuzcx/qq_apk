package com.tencent.qidian;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QidianProfileCardActivity$17
  implements ActionSheet.OnButtonClickListener
{
  QidianProfileCardActivity$17(QidianProfileCardActivity paramQidianProfileCardActivity, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.c == 1)
    {
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.f(this.jdField_a_of_type_JavaLangString);
      } else if (paramInt == 1) {
        this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.e();
      }
    }
    else if (paramInt == 0) {
      this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.f(this.jdField_a_of_type_JavaLangString);
    }
    QidianProfileCardActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.17
 * JD-Core Version:    0.7.0.1
 */