package com.tencent.qidian;

import android.text.TextUtils;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class QidianProfileCardActivity$25
  implements ActionSheet.OnButtonClickListener
{
  QidianProfileCardActivity$25(QidianProfileCardActivity paramQidianProfileCardActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    do
    {
      return;
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
      if (TextUtils.isEmpty(paramView))
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      if (paramView.equals(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.getString(2131693302)))
      {
        QidianProfileCardActivity.a(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, this.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
      if (paramView.equals(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.getString(2131693308)))
      {
        QidianProfileCardActivity.b(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, this.jdField_a_of_type_ComTencentImageURLDrawable);
        return;
      }
    } while (!paramView.equals(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.getString(2131698260)));
    QidianProfileCardActivity.c(this.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.25
 * JD-Core Version:    0.7.0.1
 */